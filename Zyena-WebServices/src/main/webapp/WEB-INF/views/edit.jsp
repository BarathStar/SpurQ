<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Being Java Guys | Spring DI Hello World</title>
<style>
body {
 font-size: 20px;
 color: teal;
 font-family: Calibri;
}

td {
 font-size: 15px;
 color: black;
 width: 100px;
 height: 22px;
 text-align: center;
}

.heading {
 font-size: 18px;
 color: white;
 font: bold;
 background-color: orange;
 border: thick;
}
</style>
</head>
<body>
 <center>
  
 
 
 <b>Edit User Details </b>
 

  <div>
   <form:form method="post" action="update" modelAttribute="user">
    <table>
     <tr>
      <td>First Name :</td>
      <td><form:input path="firstName"
        value="${map.user.firstName}" />
      </td>
     </tr>
     <tr>
      <td>Last Name :</td>
      <td><form:input path="lastName" value="${map.user.lastName}" />
      </td>
     </tr>
     <tr>
      <tr>
      <td>Email :</td>
      <td><form:input path="email" value="${map.user.email}" />
      </td>
     </tr>
     <tr>
      <td>Password :</td>
      <td><form:input path="password" value="${map.user.password}" />
      </td>
     </tr>
     <tr>
      <td> </td>
      <td><input type="submit" value="Save" />
      </td>
     </tr>
    </table>
    <form:hidden path="userId" value="${map.user.userId}" />

   </form:form>
  </div>
 </center>
</body>
</html>
