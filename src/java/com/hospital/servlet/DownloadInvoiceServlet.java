/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.hospital.dao.InvoiceDAO;
import com.hospital.dao.impl.InvoiceDAOImpl;
import com.hospital.model.Invoice;
import com.hospital.util.InvoicePDFGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
/**
 *
 * @author 
 */
@WebServlet("/download-invoice")
public class DownloadInvoiceServlet extends HttpServlet {
  private InvoiceDAO invoiceDAO = new InvoiceDAOImpl();
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String idParam = req.getParameter("invoiceId");
    if (idParam == null) {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing invoiceId");
      return;
    }
    int invoiceId;
    try {
      invoiceId = Integer.parseInt(idParam);
    } catch (NumberFormatException e) {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid invoiceId");
      return;
    }
    Invoice inv = invoiceDAO.findById(invoiceId);
    if (inv == null) {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Invoice not found");
      return;
    }
    byte[] pdf = InvoicePDFGenerator.generateInvoicePDF(inv);
    resp.setContentType("application/pdf");
    resp.setHeader(
      "Content-Disposition",
      "attachment; filename=\"invoice_" + invoiceId + ".pdf\""
    );
    resp.setContentLength(pdf.length);
    resp.getOutputStream().write(pdf);
  }
}