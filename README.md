# Online Furniture Store Web Project
This is a sample web project developed for online furniture store using **Java (JSP and Servlet)** tech stack. In here, I used **AJAX** to send request from client to server. For this project I used **Hibernate Framework** as relational mapping tool and also I used **bootstrap 3** to make my jsps looks responsive and attractive. 
> **Note:** This project developed using Netbeans IDE 7.4

## Sample AJAX Request
```
var request = new XMLHttpRequest();
request.onreadystatechange = function() { 
  if (request.readyState === 4 && request.status === 200) {
     document.getElementById("dept-dropdown").innerHTML = request.responseText;
  }
 };
request.open("GET", "LoadDepartment?rc=101", true);
request.send();
```
In here, LoadDepartment is the Servlet that we send the HTTPRequest and rc=101 is the data that we are send with HTTPRequest as a parameter. In AJAX Request, there are five ready states. 
<table>
  <thead>
    <tr>
      <th>Ready State Code</th>
      <th>Ready State</th>
      <th>Significance</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>0</td>
      <td>Uninitialized</td>
      <td>Request not yet opened</td>
    </tr>
    <tr>
      <td>1</td>
      <td>Loading</td>
      <td>Not yet sent</td>
    </tr>
    <tr>
      <td>2</td>
      <td>Loaded</td>
      <td>Sent but information are not yet available</td>
    </tr>
    <tr>
      <td>3</td>
      <td>Interactive</td>
      <td>Partial Responce Received</td>
    </tr>
    <tr>
      <td>4</td>
      <td>Completed</td>
      <td>Responce complete</td>
    </tr>
  </tbody>
</table>
