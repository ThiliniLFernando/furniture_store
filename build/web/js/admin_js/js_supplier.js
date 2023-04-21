function showNewSupplierModel() {
    $('#addNewSupplier').modal('show');
    $('#addNewSupplier').appendTo('body');
}

function addSupplier() {
    var name = document.getElementById("sname").value.trim();
    var address = document.getElementById("saddress").value.trim();
    var city = document.getElementById("scity").value.trim();
    var contact_no = document.getElementById("scontactNo").value.trim();
    var email = document.getElementById("semail").value.trim();

    if (name.length === 0) {
        alert("Please enter supplier name");
    } else if (address.length === 0) {
        alert("Please enter supplier address");
    } else if (city.length === 0) {
        alert("Please enter supplier city");
    } else if (contact_no.length === 0) {
        alert("Please enter supplier contact no");
    } else {
        var parameters = "name=" + name + "&address=" + address + "&city=" + city + "&contact_no=" + contact_no + "&email=" + email;
        var request = new XMLHttpRequest();
        request.onreadystatechange = function() {
            if (request.readyState === 4 & request.status === 200) {
                if (request.responseText === "1") {
                    document.getElementById("sname").value = "";
                    document.getElementById("saddress").value = "";
                    document.getElementById("scity").value = "";
                    document.getElementById("scontactNo").value = "";
                    document.getElementById("semail").value = "";
                    loadSupplier(0);
                } else {
                    alert(request.responseText);
                }
            }
        };
        request.open("POST", "RegSupplier", true);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        request.send(parameters);
    }
}

function loadSupplier(start) {

    var name = document.getElementById("search_name").value;
    var city = document.getElementById("search_city").value;
    var contact_no = document.getElementById("search_mobile").value;
    var email = document.getElementById("search_email").value;

    var parameters = "start=" + start + "&name=" + name + "&city=" + city + "&contact_no=" + contact_no + "&email=" + email;
    
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            document.getElementById("supplier-details").innerHTML = request.responseText;
        }
    };
    request.open("GET", "LoadSupplier?" + parameters, true);
    request.send();
}