function showNewUserModel() {
    $('#addNewUser').modal('show');
    $('#addNewUser').appendTo('body');
}

function checkRadio(id) {
    if (document.getElementById(id) !== null) {
        document.getElementById(id).checked = 'true';
    }
}

function readImageUrl(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#uimg')
                    .attr('src', e.target.result);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

function loadUserType() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            document.getElementById("sbutype").innerHTML = request.responseText;
            document.getElementById("utype").innerHTML = request.responseText;
            document.getElementById("vutype").innerHTML = request.responseText;
        }
    };
    request.open("GET", "ALoadUserType", true);
    request.send();
}

function addUser() {
    var uname = document.getElementById("uname").value;
    var un = document.getElementById("un").value;
    var mobile = document.getElementById("mobile").value;
    var email = document.getElementById("email").value;
    var utype = document.getElementById("utype").value;
    var uimg = document.getElementById("img-file").files[0];

    var form = new FormData();
    form.append("uname", uname);
    form.append("un", un);
    form.append("mobile", mobile);
    form.append("email", email);
    form.append("utype", utype);
    form.append("uimg", uimg);

    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            if (request.responseText === "1") {
                document.getElementById("uname").value = "";
                document.getElementById("un").value = "";
                document.getElementById("mobile").value = "";
                document.getElementById("email").value = "";
                document.getElementById("utype").selectedIndex = 0;
                document.getElementById("uimg").src = "";
                alert("successfully saved user");
                loadUser();
            } else {
                alert(request.responseText);
            }
        }
    };
    request.open("POST", "ASaveUser", true);
    request.send(form);
}

function loadUser() {
    var sbname = document.getElementById("sbname").value;
    var sbuname = document.getElementById("sbuname").value;
    var sbutype = document.getElementById("sbutype").value;
    var sbmobile = document.getElementById("sbmobile").value;
    var sbemail = document.getElementById("sbemail").value;
    var sbdcreate = document.getElementById("sbdcreate").value;
    var sbstatus = "";

    if (document.getElementById("sbnone").checked) {
        sbstatus = "none";
    } else if (document.getElementById("sbactive").checked) {
        sbstatus = "active";
    } else {
        sbstatus = "deactive";
    }

    var parameters = "sbname=" + sbname + "&sbuname=" + sbuname + "&sbutype=" + sbutype + "&sbmobile=" + sbmobile + "&sbemail=" + sbemail + "&sbstatus=" + sbstatus + "&sbdcreate=" + sbdcreate;

    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            document.getElementById("user-tbody").innerHTML = request.responseText;
        }
    };
    request.open("GET", "ALoadUser?" + parameters, true);
    request.send();
}

function slideUserView(id) {
    var boxWidth = $("#userView-carousel").width();
    document.getElementById("userView-carousel").style.display = "block";
    $("#userView-carousel").animate({
        right: '0px',
        width: '400px'
    },"slow");
    
}

function closeUserViewSlider(){
    $("#userView-carousel").animate({
        right: '0px',
        width: '0px'
    },"slow");
}