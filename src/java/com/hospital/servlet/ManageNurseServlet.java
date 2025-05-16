/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.DoctorDAO;
import com.hospital.dao.impl.DoctorDAOImpl;
import com.hospital.model.Doctor;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author AFRIJ MBM
 */
@WebServlet(name = "ManageNurseServlet", urlPatterns = {"/ManageNurseServlet"})
public class ManageNurseServlet extends HttpServlet {
  private DoctorDAO dao = new DoctorDAOImpl();
  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<Doctor> list = dao.findAll();
    req.setAttribute("doctorsList", list);
    req.getRequestDispatcher("/admin/manage-nurses.jsp").forward(req,resp);
  }
  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String action = req.getParameter("action");
    if("save".equals(action)) {
      Doctor d=new Doctor();
      d.setName(req.getParameter("name"));
      d.setSpecialization(req.getParameter("specialization"));
      d.setFee(Double.parseDouble(req.getParameter("fee")));
      d.setPassword(req.getParameter("password"));
      dao.save(d);
    } else if("delete".equals(action)) {
      dao.deleteById(Integer.parseInt(req.getParameter("Id")));
    }
    resp.sendRedirect(req.getContextPath()+"/admin/manage-nurses");
  }
}