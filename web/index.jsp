<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Healspire Medical Center | Home</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<header class="site-header">
  <div class="header-container">
    <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo">
    <div class="header-text">
      <h1>Healspire Medical Center</h1>
      <p>Inspiring Better Health, Every Day</p>
    </div>
  </div>
  <nav class="main-nav">
    <a href="${pageContext.request.contextPath}/patient/login.jsp" class="btn">Patient</a>
    <a href="${pageContext.request.contextPath}/doctor-logs.jsp" class="btn">Doctor</a>
    <a href="${pageContext.request.contextPath}/admin/user-logs.jsp" class="btn">Admin</a>
    <a href="${pageContext.request.contextPath}/about.jsp" class="btn">About Us</a>
  </nav>
</header>

<section class="hero-section">
  <div class="hero-content">
    <h2>Compassionate Care, Advanced Medicine, Close to Home</h2>
    <p>Providing top-tier healthcare services with a personal touch. Your well-being is our mission.</p>
    <a href="${pageContext.request.contextPath}/patient/register.jsp" class="btn-primary">Get Started</a>
  </div>
</section>

<main class="main-content container">
  <section id="about-us">
    <h2>About Us</h2>
    <p>Healspire Medical Center is a premier healthcare provider committed to delivering exceptional medical services and compassionate patient care.</p>
  </section>

  <section id="services">
    <h2>Our Services</h2>
    <ul class="service-list">
      <li>24/7 Emergency Care</li>
      <li>Outpatient & Inpatient Services</li>
      <li>Advanced Diagnostic Imaging (MRI, CT, X-Ray)</li>
      <li>Laboratory & Pathology</li>
      <li>On-site Pharmacy</li>
      <li>Telemedicine Consultations</li>
    </ul>
  </section>

  <section id="departments">
    <h2>Departments</h2>
    <ul class="department-list">
      <li>Cardiology</li>
      <li>Neurology</li>
      <li>Orthopedics</li>
      <li>Pediatrics</li>
      <li>Oncology</li>
      <li>Gynecology & Obstetrics</li>
      <li>General Surgery</li>
    </ul>
  </section>
</main>

<footer class="site-footer">
  <section id="contact">
    <h2>Contact Us</h2>
    <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
    <p><strong>Phone:</strong> +1 (555) 123-4567</p>
    <p><strong>Email:</strong> info@HealspireMedicalCenter.com</p>
    <div class="map-container">
      <iframe src="https://www.google.com/maps/embed/v1/place?q=114+Norris+Canal+Rd,+Colombo+01000&key=AIzaSyBFw0Qbyq9zTFTd-tUY6dZWTgaQzuU17R8" allowfullscreen loading="lazy"></iframe>
    </div>
    <p>&copy; 2025 Healspire Medical Center. All rights reserved.</p>
  </section>
</footer>

</body>
</html>
