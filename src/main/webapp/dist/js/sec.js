$.ajaxSetup({
    url: ("rest/login"),
    type:"POST",
    dataType:"json",
    success: function(user) {
        if (user) {
            var root=window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
            window.location = root + "/";
        } else {
            $("#message").empty().append("Invalid credentials. Please try again.");
            $("#loginForms").show();
        }
    },
	error : function(xhr, textStatus, errorThrown) {
	    alert("Could not authenticate.")
    }
});

function performUsernamePasswordLogin() {
	var username = $("#userName");
	var password = $("#password");
	
	if (username.is(":valid") && password.is(":valid")) {
		$.ajax({
            contentType:"application/x-authc-username-password+json",
            data:JSON.stringify({ userId: username.val(), password: password.val()})
            }
		);
	}
}

$(document).ready(
    function() {

        $("#usernamePasswordBtn").click(function() {
            performUsernamePasswordLogin();
        });
    }
);