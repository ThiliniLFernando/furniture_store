function adminSignIn() {
    var username = document.getElementById("username").value.trim();
    var password = document.getElementById("pwd").value.trim();

    if (username.length === 0) {
        alert("Please enter your email");
    } else if (password.length === 0) {
        alert("Please enter your password");
    } else {
        var parameters = "username=" + username + "&password=" + password;

        var request = new XMLHttpRequest();
        request.onreadystatechange = function() {
            if (request.readyState === 4 && request.status === 200) {
                if (request.responseText === "success") {
                    window.location = "AdminPanel.jsp";
                } else {
                    alert(request.responseText);
                }
            }
        };
        request.open("POST", "ASignIn", true);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        request.send(parameters);
    }
}

function replaceSignUpPage() {
    window.location.replace("ASignUp.jsp");
}


