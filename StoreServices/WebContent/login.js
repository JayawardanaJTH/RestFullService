/**
 * login  functon
 */

$(document).on("click", "#login", function(event) {

	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	var username = $("#uName").vai().trim();
	var password = $("#password").vai().trim();
	
	$.ajax({
		xhrFields: {
		        withCredentials: true
		    },
	    beforeSend: function (xhr) {
	        	xhr.setRequestHeader('Authorization', 'Basic ' + btoa(username+":"+password));
	    	},
		url: "http://localhost:8080/StoreServices/rest/UserService"
	}).then(function(data, status, jqxhr) {
      
       console.log(data.id);
    });

});

function validateItemForm() {

	if ($("#uName").val().trim() == "") {
		return "Enter User Name.";
	}

	if ($("#password").val().trim() == "") {
		return "Enter Password.";
	}

	return true;
}