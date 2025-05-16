<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Doctor Login | Hospital Management System</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>

  <header>
      <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right">
      <h1>Healspire Medical Center</h1>
      <p>Inspiring Better Health, Every Day</p>
      <h2 style="color: #00eaff;">Doctor Portal</h2>
  </header>

  <nav>
    <a href="${pageContext.request.contextPath}/patient/register.jsp" class="btn">Patient</a>
    <a href="${pageContext.request.contextPath}/doctor-logs.jsp" class="btn">Doctor</a>
    <a href="${pageContext.request.contextPath}/admin/user-logs.jsp" class="btn">Admin</a>
    <a href="${pageContext.request.contextPath}/about.jsp" class="btn">About Us</a>
  </nav>

  <div class="container">
    <h2 style="text-align: center;">Doctor Login</h2>
    <form action="doctorservlet" method="post">
      <label for="name">Doctor Name</label>
      <input id="name" type="text" name="name" placeholder="Enter your name" required>

      <label for="id">Doctor ID</label>
      <input id="id" type="text" name="id" placeholder="Enter your ID" required>

      <label for="password">Password</label>
      <input id="password" type="password" name="password" placeholder="Enter password" required>

      <button type="submit" class="btn">Login</button>
    </form>

    <p style="text-align: center;">
      <a href="error.jsp">Forgot Password?</a> |
      <a href="${pageContext.request.contextPath}/index.jsp">Back to Dashboard</a>
    </p>
  </div>

  <footer>
    <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@HealspireMedicalCenter.com</p>
      <div class="map-container">
  <iframe
    src="https://www.google.com/maps/embed/v1/place?q=114+Norris+Canal+Rd,+Colombo+01000&key=AIzaSyBFw0Qbyq9zTFTd-tUY6dZWTgaQzuU17R8"
    allowfullscreen
    loading="lazy"
    referrerpolicy="no-referrer-when-downgrade">
  </iframe>
</div>

    </section>
    &copy; 2025 Our Hospital. All rights reserved.
  </footer>

</body>
</html>
