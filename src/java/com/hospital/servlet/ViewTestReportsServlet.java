/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.TestReportDAO;
import com.hospital.dao.impl.TestReportDAOImpl;
import com.hospital.model.TestReport;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author 
 */
@WebServlet("/view-test-reports")
public class ViewTestReportsServlet extends HttpServlet {
private TestReportDAO dao = new TestReportDAOImpl();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession(false);
    if (session == null || session.getAttribute("patientId") == null) {
      resp.sendRedirect(req.getContextPath() + "/login.jsp");
      return;
    }
    int patientId = (Integer) session.getAttribute("patientId");
    List<TestReport> reports = dao.findByPatientId(patientId);
    req.setAttribute("reports", reports);
    req.getRequestDispatcher("patient/view-test-reports.jsp").forward(req, resp);
  }
}