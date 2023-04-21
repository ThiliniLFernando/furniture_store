function cSignIn() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("pw").value;
    if (email.length === 0) {
        alert("Please Enter your Email");
    } else if (password.length === 0) {
        alert("Please Enter your Password");
    } else {

        var parameter_list = "email=" + email + "&" + "pw=" + password;
        var request = new XMLHttpRequest();
        request.onreadystatechange = function() {
            if (request.readyState === 4 & request.status === 200) {
                var response = request.responseText;
                if (response === "1") {
                    window.location = "AdvancedSearch.jsp";
                } else {
                    alert(response);
                }
            }
        };
        request.open("POST", "CSignInProcess", true);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        request.send(parameter_list);
    }
}

function cSignUp() {
    var name = document.getElementById("signUp-name").value.trim();
    var email = document.getElementById("signUp-email").value.trim();
    var password = document.getElementById("signUp-pw").value.trim();
    var retype_password = document.getElementById("signUp-retype_pw").value.trim();
    if (name.length === 0) {
        alert("Please Enter your Name");
    } else if (email.length === 0) {
        alert("Please Enter your Email");
    } else if (password.length === 0) {
        alert("Please Enter your Password");
    } else if (retype_password.length === 0) {
        alert("Please Enter Retype Password Field");
    } else if (password !== retype_password) {
        alert("Password and Retype Password doesn't match");
    } else {
        var parameters = "name=" + name + "&email=" + email + "&pw=" + password + "&repw=" + retype_password;
        var request = new XMLHttpRequest();
        request.onreadystatechange = function() {
            if (request.readyState === 4 & request.status === 200) {
                var response = request.responseText;
                if (response === "1") {
                    document.getElementById("signUp-name").value = "";
                    document.getElementById("signUp-email").value = "";
                    document.getElementById("signUp-pw").value = "";
                    document.getElementById("signUp-retype_pw").value = "";
                    alert("Successfully rejestered.Please Sign in to continue");
                } else {
                    alert(response);
                }
            }
        };
        request.open("POST", "CSignUpProcess", true);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        request.send(parameters);
    }
}



