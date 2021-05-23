/**
 * 
 */
function getLogin(){
	jQuery.ajax({
        url: "http://localhost:8080/book_service/rest/books/" + $("#id").val(),
        type: "GET",
        contentType: "application/json",  
        dataType:'json',
        success: function(data, textStatus, errorThrown) {
            //here is your json.
              // process it
        	  $("#title").text(data.title);
        	  $("#price").text(data.price);

        },
        error : function(jqXHR, textStatus, errorThrown) {
        		$("#title").text("Sorry! Book not found!");
        		$("#price").text("");
        },
        timeout: 120000,
    });
};

function deleteBook(id){
	jQuery.ajax({
		url: "http://localhost:8080/book_service/rest/books/" + id,
		type: "DELETE",
		contentType: "application/json",  
        dataType:'json',
		success: function(data, textStatus, errorThrown){
			 $("#title").text("Deleted");
			 $("#price").text("");
		alert("Book deleted")
				loadTable();
		},
		error : function(jqXHR, textStatus, errorThrown) {
        		$("#title").text("Sorry! Book not found!");
        		$("#price").text("");
        },
	});
};

function addBook(){
	var id = $("#uID").val();
	
	if(id == ""){
		var book = new Object();
		book.title = $("#uTitle").val();
		book.price = $("#uPrice").val();
		
		var obj = JSON.stringify(book);
		jQuery.ajax({
			url: "http://localhost:8080/book_service/rest/books/",
			type: "POST",
			contentType: "application/json",  
	        dataType:'json',
			data: obj,
			success: function(data, textStatus, errorThrown){
				 $("#title").text("Book added");
				 $("#price").text("");
			alert("New book added")
				    $("#uTitle").val("");
	        	    $("#uPrice").val("");
					loadTable();
			},
			error : function(jqXHR, textStatus, errorThrown) {
	        		$("#title").text("Sorry! Book not Added!");
	        		$("#price").text("");
	        },
		});
	}else{

			var book = new Object();
			book.title = $("#uTitle").val();
			book.price = $("#uPrice").val();
			book.id = $("#uID").val();
			
			var obj = JSON.stringify(book);
			jQuery.ajax({
				url: "http://localhost:8080/book_service/rest/books/",
				type: "PUT",
				contentType: "application/json",  
		        dataType:'json',
				data: obj,
				success: function(data, textStatus, errorThrown){
					 $("#title").text("Book updated");
					 $("#price").text("");
				alert("Updated")
					$("#uTitle").val("");
	        	    $("#uPrice").val("");
				    $("#uID").val(null);
						loadTable();
				},
				error : function(jqXHR, textStatus, errorThrown) {
		        		$("#title").text("Sorry! Book not Updated!");
		        		$("#price").text("");
		        },
			});
	}
	
};

function updateBook(id){
	
	jQuery.ajax({
        url: "http://localhost:8080/book_service/rest/books/" + id,
        type: "GET",
        contentType: "application/json",  
        dataType:'json',
        success: function(data, textStatus, errorThrown) {
        	  $("#uTitle").val(data.title);
        	  $("#uPrice").val(data.price);
			  $("#uID").val(data.id);
        },
        error : function(jqXHR, textStatus, errorThrown) {
        		$("#title").text("Sorry! Update failed");
        		$("#price").text("");
        },
        timeout: 120000,
	});
	
};

function loadTable(){
	
	
	jQuery.ajax({
		url: "http://localhost:8080/book_service/rest/books",
		type: "GET",
        dataType:'json',
		success: function(data){
			var table = $("#table tbody");
			table.empty();
			
			 $(data).each(function(index, element){
				table.append('<tr><td>'+element.id+'</td><td>'+element.title+'</td><td>'+element.price+'</td><td><Button onclick="updateBook('+element.id+')">Update</Button>|<Button onclick="deleteBook('+element.id+')" id='+element.id+'>Delete</Button></td></tr>');
			})
		},
		error : function(jqXHR, textStatus, errorThrown) {
        		$("#title").text("Cannot load table");
        		$("#price").text("");
        },
	});
}