function popupUserPane() {
    $('#popup-user-pane').modal('show');
    $('#popup-user-pane').appendTo('body');
}

function loadDepartmentCat() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            document.getElementById("dept-dropdown").innerHTML = request.responseText;
        }
    };
    request.open("GET", "LoadDepartment?rc=101", true);
    request.send();
}

function loadCategory() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            document.getElementById("category-dropdown").innerHTML = request.responseText;
        }
    };
    request.open("GET", "LoadCategory?rc=101", true);
    request.send();
}

function setCategoryName(cat) {
    document.getElementById("category-dropdown-label").innerHTML = cat;
    loadFeatureSearch(cat);
}

function setDepartmentName(dept) {
    document.getElementById("dept-dropdown-label").innerHTML = dept;
    filterProducts(0);
}

function loadFeatureSearch(cat) {
    var parameters = "?cat_name=" + cat;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            document.getElementById("specified-search-div").innerHTML = request.responseText;
            filterProducts(0);
        }
    };
    request.open("GET", "LoadFeatureForSearch" + parameters, true);
    request.send();
}

function filterProducts(start) {
    var dept = document.getElementById("dept-dropdown-label").innerHTML;
    var category = document.getElementById("category-dropdown-label").innerHTML;
    var order_by = document.getElementById("order_by").value;
    var search_pname = document.getElementById("search-pname").value;
    var max_price = document.getElementById("search-max-price").value;
    var min_price = document.getElementById("search-min-price").value;
    var hidden = $('#specified-holder').attr("value");
    var feature_list = [];
    if ($('#specified-holder').length > 0) {
        var sf = hidden.trim();
        var array = sf.split('#');
        for (var x in array) {
            var obj = {};
            var val = document.getElementById("search-" + array[x]).value.toLowerCase();
            obj["name"] = array[x];
            obj["value"] = val;
            feature_list.push(obj);
        }
    }

    var featureJSON = JSON.stringify(feature_list);
//    alert(featureJSON);

    var parameter = "start=" + start + "&dept=" + dept + "&category=" + category + "&features=" + featureJSON + "&order_by=" + order_by + "&search_pname=" + search_pname + "&min_price=" + min_price + "&max_price=" + max_price;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            document.getElementById("loading-div").style.display = "none";
            document.getElementById("product-container").innerHTML = request.responseText;
        } else {
            document.getElementById("loading-div").style.display = "block";
        }
    };
    request.open("POST", "CFilterProducts", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(parameter);
}

function loadCartData() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            document.getElementById("cart-tbody").innerHTML = request.responseText;
        }
    };
    request.open("GET", "CLoadCartData", true);
    request.send();
}

function addToCart(pid) {
    var qty = document.getElementById("q" + pid).value;
    var parameters = "pid=" + pid + "&cqty=" + qty;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            if (request.responseText === "1") {
                document.getElementById("q" + pid).value = "";
            } else {
                alert(request.responseText);
            }
        }
    };
    request.open("GET", "CAddCartData?" + parameters, true);
    request.send();
}

function removeCartItem(pid) {
    var parameters = "id=" + pid;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            window.location = "CartView.jsp";
        }
    };
    request.open("GET", "RemoveCartItem?" + parameters, true);
    request.send();
}

function updateCartItem(pid) {
    var qty = document.getElementById("cqty" + pid.trim().toUpperCase()).textContent;
    var parameters = "id=" + pid + "&qty=" + qty;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            if (request.responseText === "0") {
                alert("Quantity out of stock");
            } else if (request.responseText === "2") {
                alert("Please enter valid quantity");
                window.location = "CartView.jsp";
            } else if (request.responseText === "1") {
                window.location = "CartView.jsp";
            }
        }
    };
    request.open("GET", "UpdateCartItem?" + parameters, true);
    request.send();
}

function clearFilters() {
    document.getElementById("dept-dropdown-label").innerHTML = "SELECT DEPARTMENT&nbsp&nbsp";
    document.getElementById("category-dropdown-label").innerHTML = "SELECT CATEGORY&nbsp&nbsp";
    document.getElementById("order_by").selectedIndex = 0;
    document.getElementById("search-pname").value = "";
    document.getElementById("search-max-price").value = "";
    document.getElementById("search-min-price").value = "";
    document.getElementById("specified-holder").value = "";
    document.getElementById("specified-search-div").innerHTML = "";
    filterProducts(0);
}

function logOut() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            if (request.responseText === "1") {
                window.location = "index.jsp";
            }
        }
    };
    request.open("GET", "CLogOut", true);
    request.send();
}

function changePassword() {
    var currentPw = document.getElementById("currentPw").value.trim();
    var newPw = document.getElementById("newPw").value.trim();
    var retypePw = document.getElementById("retypePw").value.trim();

    if (currentPw === "" | retypePw === "" | newPw === "") {
        document.getElementById("cpw-well-container").textContent = "required fields cann't empty !";
        document.getElementById("cpw-well-container").className = "alert alert-danger";
    } else if (newPw !== retypePw) {
        document.getElementById("cpw-well-container").textContent = "confirm your password !";
        document.getElementById("cpw-well-container").className = "alert alert-danger";
    } else {
        var parameters = "currentPw=" + currentPw + "&newPw=" + newPw + "&retypePw=" + retypePw;

        var request = new XMLHttpRequest();
        request.onreadystatechange = function() {
            if (request.readyState === 4 & request.status === 200) {
                if (request.responseText === "1") {
                    document.getElementById("cpw-well-container").textContent = "Password updated";
                    document.getElementById("cpw-well-container").className = "alert alert-success";
                } else {
                    document.getElementById("cpw-well-container").textContent = request.responseText;
                    document.getElementById("cpw-well-container").className = "alert alert-danger";
                }
            }
        };
        request.open("GET", "CChangePassword?" + parameters, true);
        request.send();
    }
}

function checkOutRedirect(tot){
    var parameter = "tot="+tot;
    alert(tot);
    var request = new XMLHttpRequest();
    request.onreadystatechange = function (){
        if(request.readyState === 4 && request.status === 200){
            window.location = request.responseText;
        }
    };
    request.open("GET","CCheckOutRedirect?"+parameter,false);
    request.send();
}
