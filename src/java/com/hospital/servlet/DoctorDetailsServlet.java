/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.DoctorDAO;
import com.hospital.dao.ScheduleDAO;
import com.hospital.dao.impl.DoctorDAOImpl;
import com.hospital.dao.impl.ScheduleDAOImpl;
import com.hospital.model.Doctor;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 *
 * @author 
 */
@WebServlet("/doctor-details")
public class DoctorDetailsServlet extends HttpServlet {
  private DoctorDAO docDao = new DoctorDAOImpl();
  private ScheduleDAO schDao = new ScheduleDAOImpl();
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    int docId = Integer.parseInt(req.getParameter("doctorId"));
    Doctor d = docDao.findById(docId);
    req.setAttribute("doctor", d);
    req.setAttribute("availList", schDao.findByDoctorId(docId));
    req.getRequestDispatcher("/patient/doctor-details.jsp").forward(req, resp);
  }
}