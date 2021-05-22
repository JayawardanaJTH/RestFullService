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

	var username = $("#uName").val().trim();
	var password = $("#password").val().trim();
	$.ajax({
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