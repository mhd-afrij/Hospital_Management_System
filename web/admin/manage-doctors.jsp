<%-- 
    Document   : manage-doctors
    Created on : Apr 27, 2025, 12:39:06?AM
    Author     : 
--%>

<%-- 
    Document   : manage-doctors
    Created on : Apr 27, 2025, 12:39:06?AM
    Author     : 
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.hospital.model.Doctor" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Manage Doctors</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-site.css">
</head>
<body>

  <header>
    <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right">
    <h1>Healspire Medical Center</h1>
    <p>Inspiring Better Health, Every Day</p>
  </header>

  <nav>
    <a href="${pageContext.request.contextPath}/admin/dashboard.jsp" class="btn">Dashboard</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn">Logout</a>
  </nav>

  <main class="container">
    <h2 style="text-align: center;">Manage Doctors</h2>
    <table>
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Specialization</th>
          <th>Fee</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <%
          List<Doctor> doctors = (List<Doctor>) request.getAttribute("doctorsList");
          if (doctors != null) {
            for (Doctor d : doctors) {
        %>
        <tr>
          <td><%= d.getId() %></td>
          <td><%= d.getName() %></td>
          <td><%= d.getSpecialization() %></td>
          <td><%= d.getFee() %></td>
          <td>
            <form method="post" action="${pageContext.request.contextPath}/admin/manage-doctors" style="display:inline">
              <input type="hidden" name="action" value="delete"/>
              <input type="hidden" name="doctorId" value="<%= d.getId() %>"/>
              <button type="submit" class="btn">Delete</button>
            </form>
          </td>
        </tr>
        <%
            }
          }
        %>
      </tbody>
    </table>

    <h3>Add Doctor</h3>
    <form method="post" action="${pageContext.request.contextPath}/admin/manage-doctors">
      <input type="hidden" name="action" value="save"/>

      <label for="doc-name">Name</label>
      <input type="text" id="doc-name" name="name" required/>

      <label for="doc-spec">Specialization</label>
      <input type="text" id="doc-spec" name="specialization" required/>

      <label for="doc-fee">Fee</label>
      <input type="number" id="doc-fee" name="fee" required/>

      <label for="doc-password">Password</label>
      <input type="password" id="doc-password" name="password" required/>

      <button type="submit" class="btn">Add</button>
    </form>
  </main>

  <footer>
    <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@ourhospital.com</p>
    </section>
    &copy; 2025 Hospital Management System — All Rights Reserved
  </footer>

</body>
</html>

