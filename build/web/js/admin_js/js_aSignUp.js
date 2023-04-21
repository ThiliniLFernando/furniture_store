function adminSignUp() {
    var name = document.getElementById("name").value.trim();
    var username = document.getElementById("username").value.trim();
    var pwd = document.getElementById("pwd").value.trim();
    var retype_pwd = document.getElementById("retype_pwd").value.trim();
    var role = document.getElementById("role").value;

    if (name.length === 0) {
        alert("Please enter your name");
    } else if (username.length === 0) {
        alert("Please enter your email");
    } else if (pwd.length < 8) {
        alert("Please enter valid password");
    } else if (retype_pwd.length === 0) {
        alert("Please confirm your password");
    } else {
        var parameters = "name=" + name + "&username=" + username + "&pwd=" + pwd + "&retype_pwd=" + retype_pwd + "&role=" + role;

        var request = new XMLHttpRequest();
        request.onreadystatechange = function() {
            if (request.readyState === 4 && request.status === 200) {
                if (request.responseText === "success") {
                    document.getElementById("name").value = "";
                    document.getElementById("username").value = "";
                    document.getElementById("pwd").value = "";
                    document.getElementById("retype_pwd").value = "";
                    alert(request.responseText);
                } else {
                    alert(request.responseText);
                }
            }
        };
        request.open("POST", "ASignUp", true);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        request.send(parameters);
    }
}

function replaceSignInPage() {
    window.location.replace("ASignIn.jsp");
}


