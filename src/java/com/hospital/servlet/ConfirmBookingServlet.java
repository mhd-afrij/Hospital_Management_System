/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;



import com.hospital.dao.InvoiceDAO;
import com.hospital.dao.impl.AppointmentDAOImpl;
import com.hospital.dao.impl.InvoiceDAOImpl;
import com.hospital.dao.AppointmentDAO;
import com.hospital.dao.impl.DoctorDAOImpl;
import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Invoice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import jakarta.servlet.http.HttpSession;

@WebServlet("/confirm-booking")
public class ConfirmBookingServlet extends HttpServlet {   
  private AppointmentDAO apptDao    = new AppointmentDAOImpl();
  private InvoiceDAO     invoiceDao = new InvoiceDAOImpl();
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    int doctorId      = Integer.parseInt(req.getParameter("doctorId"));
    int scheduleId    = Integer.parseInt(req.getParameter("scheduleId"));
    String patientName  = req.getParameter("patientName");
    String patientEmail = req.getParameter("patientEmail");
    String patientPhone = req.getParameter("patientPhone"); // Get patient phone from request
 // Set the patient phone in the appointment object

    String amtStr = req.getParameter("amount");
    BigDecimal amount;
    if (amtStr == null || amtStr.isBlank()) {
        Doctor d = new DoctorDAOImpl().findById(doctorId);
        amount = BigDecimal.valueOf(d.getFee());
    } else {
        try {
            amount = new BigDecimal(amtStr);
        } catch (NumberFormatException e) {
            throw new ServletException("Invalid amount value: " + amtStr, e);
        }
    }
    Appointment appt = new Appointment();
    appt.setDoctorId(doctorId);
    appt.setScheduleId(scheduleId);
    appt.setPatientName(patientName);
    appt.setPatientEmail(patientEmail);
    appt.setPatientPhone(patientPhone);
    appt.setPaymentStatus("Paid");
    new AppointmentDAOImpl().saveAppointment(appt);
    int appointmentId = appt.getId();

    Invoice inv = new Invoice();
    inv.setAppointmentId(appointmentId);
    inv.setPatientId((Integer)req.getSession().getAttribute("patientId"));
    inv.setAmount(amount);
    inv.setPaymentDate(new Timestamp(System.currentTimeMillis()));
    inv = new InvoiceDAOImpl().create(inv);

    HttpSession session = req.getSession();
    session.setAttribute("appointmentId", appointmentId);
    session.setAttribute("invoiceId", inv.getId());
    resp.sendRedirect(req.getContextPath() + "/appointment-details");
}
}