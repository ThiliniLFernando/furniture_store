# Online Furniture Store Web Project
This is a sample web project developed for online furniture store using **Java (JSP and Servlet)** tech stack. In here, I used **AJAX** to send request from client to server. For this project I used **Hibernate Framework** as relational mapping tool and also I used **bootstrap 3** to make my jsps looks responsive and attractive. 
> **Note:** This project developed using Netbeans IDE 7.4

var request = new XMLHttpRequest();
request.onreadystatechange = function() {
  if (request.readyState === 4 && request.status === 200) {
     document.getElementById("dept-dropdown").innerHTML = request.responseText;
  }
 };
request.open("GET", "LoadDepartment?rc=101", true);
request.send();
