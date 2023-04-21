// category
function createNewFeatureTag() {
    var text = document.getElementById("feature-name").value.toLowerCase();

    if (text.length !== 0) {
        generateNewFeatureTag(text);
    } else {
        alert("please enter feature name to add");
    }
}

function generateNewFeatureTag(value) {
    var table = document.getElementById("specified-features");

    var row_count = $("#specified-features tbody tr").length;

    var row = table.insertRow(row_count);

    row.setAttribute("id", "tr" + row_count);

    var coloumn1 = row.insertCell(0);
    coloumn1.innerHTML = value;
    coloumn1.setAttribute("class", "col-md-11");
    coloumn1.setAttribute("id", "fname" + row_count);

    var coloumn2 = row.insertCell(1);
    coloumn2.setAttribute("class", "col-md-1 fa fa-times btn");
    coloumn2.setAttribute("id", "close" + row_count);

    coloumn2.onclick = function() {
        table.deleteRow(row.rowIndex);
    };

    document.getElementById("feature-name").value = "";
}

function saveCategory() {
    var category_name = document.getElementById("cname").value;
    var category_desc = document.getElementById("cdesc").value;

    var row_count = $("#specified-features tbody tr").length;
    var feature_list = [];
    //alert(feature_list);
    if (row_count > 0) {
        for (var i = 0; i < row_count; i++) {
            var text = $("#specified-features tbody tr").find("#fname" + i).text();
            feature_list.push(text);
        }
    }

    var featureJSON = JSON.stringify(feature_list);
    alert(featureJSON);

    if (category_name.length === 0) {
        alert("Please enter category name to save");
    } else {
        var parameters = "cname=" + category_name + "&cdesc=" + category_desc + "&feature_list=" + featureJSON;
        var request = new XMLHttpRequest();
        request.onreadystatechange = function() {
            if (request.readyState === 4 & request.status === 200) {
                if (request.responseText === "1") {
                    document.getElementById("cname").value = "";
                    document.getElementById("cdesc").value = "";
                    $("#specified-features").empty();
                    alert("category added successfully!");
                    loadCategoryDatatoTable();
                } else {
                    alert(request.responseText);
                }
            }
        };
        request.open("POST", "ASaveCategory", true);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        request.send(parameters);
    }
}

function updateCategory() {
    var cid = document.getElementById("hcid").value;
    var category_name = document.getElementById("cname").value;
    var category_desc = document.getElementById("cdesc").value;

    var row_count = $("#specified-features tbody tr").length;
    var feature_list = [];
    if (row_count > 0) {
        for (var i = 0; i < row_count; i++) {
            var text = $("#specified-features tbody tr").find("#fname" + i).text();
            feature_list.push(text);
        }
    }

    var featureJSON = JSON.stringify(feature_list);

    if (category_name.length === 0) {
        alert("Please enter category name to save");
    } else {
        var parameters = "cid=" + cid + "&cname=" + category_name + "&cdesc=" + category_desc + "&feature_list=" + featureJSON;
        var request = new XMLHttpRequest();
        request.onreadystatechange = function() {
            if (request.readyState === 4 & request.status === 200) {
                if (request.responseText === "1") {
//                    document.getElementById("cname").value = "";
//                    document.getElementById("cdesc").value = "";
//                    $("#specified-features").empty();
//                    alert("category added successfully!");
//                    loadCategoryDatatoTable();
                } else {
                    alert(request.responseText);
                }
            }
        };
        request.open("POST", "AUpdateCategory", true);
        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        request.send(parameters);
    }
}

function deleteCategory() {
    var cid = document.getElementById("hcid").value;
    var parameters = "cid=" + cid;

    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            if (request.responseText === "1") {
                document.getElementById("cname").value = "";
                document.getElementById("cdesc").value = "";
                $("#specified-features").empty();
                alert("category deactivated !");
                loadCategoryDatatoTable();
            }
        }
    };
    request.open("GET", "ADeleteCategory?" + parameters, true);
    request.send();
}

function activeCategory(id) {
    var cid = document.getElementById("hcid").value;
    var parameters = "cid=" + id;

    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            if (request.responseText === "1") {
                alert("category activated !");
                loadCategoryDatatoTable();
            }
        }
    };
    request.open("GET", "AActiveCategory?" + parameters, true);
    request.send();
}

function loadCategoryDatatoTable() {
    var cat_name = document.getElementById("search_cat_name").value;

    var parameters = "cat_name=" + cat_name;

    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            document.getElementById("category-tbody").innerHTML = request.responseText;
        }
    };
    request.open("GET", "ALoadCategoryToTable?" + parameters, true);
    request.send();
}

function resetCategoryTable() {
    document.getElementById("search_cat_name").value = "";
    loadCategoryDatatoTable();
}

function setCategoryDetailsToFields(id) {
    var parameters = "id=" + id;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            var cat = JSON.parse(request.responseText);
            document.getElementById("cname").value = cat.cname;
            document.getElementById("cdesc").value = cat.cdesc;
            document.getElementById("hcid").value = cat.cid;
            var array = cat.feature_array;
            $("#specified-features").empty();
            array.forEach(function(value) {
                if (value.length !== 0) {
                    generateNewFeatureTag(value);
                }
            });
        }
    };
    request.open("GET", "AFindCategory?" + parameters, true);
    request.send();
}

function loadCategory() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            document.getElementById("product-category").innerHTML = request.responseText;
        }
    };
    request.open("GET", "LoadCategory?rc=100", true);
    request.send();
}

function findSpecifiedFeatures() {
    var value = document.getElementById("product-category").value;
    var parameter = "cat_name=" + value;

    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            document.getElementById("feature-container").innerHTML = request.responseText;
        }
    };
    request.open("GET", "AFindSpecifiedFeature?" + parameter, true);
    request.send();
}
// category


//add new product

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#img1')
                    .attr('src', e.target.result);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

function generateProductId() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            document.getElementById("pid").value = request.responseText;
        }
    };
    request.open("GET", "CountProduct", true);
    request.send();
}

function saveProduct() {
    var pid = document.getElementById("pid").value;
    var pname = document.getElementById("pname").value;
    var pdesc = document.getElementById("pdesc").value;
    var pdepartment = document.getElementById("pdepartment").value;
    var pprice = document.getElementById("pprice").value;
    var pqty = document.getElementById("pqty").value;
    var pcat = document.getElementById("product-category").value;
    var pwarranty = document.getElementById("pwarranty").value;
    var pcdays = document.getElementById("pdatec").value;
    var pfiles = document.getElementById("image-upload").files;

    var row_count = $("#feature-container > .row").length;

    var feature_list = [];
    if (row_count > 0) {
        for (var i = 1; row_count >= i; i++) {
            var obj = {};
            var name = $("#feature-container > .row > .col-md-5").find("#sf" + i).val();
            var value = $("#feature-container > .row > .col-md-7").find("#value" + i).val();
            obj["featureName"] = name;
            obj["fValue"] = value;
            feature_list.push(obj);
        }
    }

    var featureJSON = JSON.stringify(feature_list);

    var form = new FormData();
    form.append("pid", pid);
    form.append("pname", pname);
    form.append("pdesc", pdesc);
    form.append("pdepartment", pdepartment);
    form.append("pprice", pprice);
    form.append("pqty", pqty);
    form.append("pcat", pcat);
    form.append("pwarranty", pwarranty);
    form.append("pcdays", pcdays);
    form.append("features", featureJSON);

    for (var i = 0; i < pfiles.length; i++) {
        form.append("file" + i, pfiles[i]);
    }

    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 & request.status === 200) {
            if (request.responseText === "1") {
                document.getElementById("pname").value = "";
                document.getElementById("pdesc").value = "";
                document.getElementById("pwarranty").value = "";
                document.getElementById("pdepartment").selectedIndex = 0;
                document.getElementById("pprice").value = "";
                document.getElementById("pqty").value = "";
                document.getElementById("pdatec").value = "";
                document.getElementById("product-category").selectedIndex = 0;
                document.getElementById("feature-container").innerHTML = "";
                document.getElementById("img1").src = "";
                generateProductId();
                alert("success");
            } else {
                alert(request.responseText);
            }
        }
    };
    request.open("POST", "ASaveProduct", true);
    request.send(form);
}
//add new product

// search product
function loadDepartments() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
            document.getElementById("department").innerHTML = request.responseText;
        }
    };
    request.open("GET", "LoadDepartment?rc=100", true);
    request.send();
}

function loadProducts() {
    var dept = document.getElementById("sdept").value;
    
    var parameters = "sdept="+dept;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
//            alert("ok load");
            document.getElementById("product-tbody").innerHTML = request.responseText;
        }
    };
    request.open("GET", "AFilterProducts?"+parameters, true);
    request.send();
}
// search product
