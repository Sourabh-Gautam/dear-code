/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go.servlet;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author Sourabh Gautam
 */
public class PayServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             PrintWriter pw = response.getWriter();
             HttpSession session = request.getSession();
        try{
            
            int amt = (int)Math.ceil((double)session.getAttribute("totalprice"));
            JSONObject user = (JSONObject) session.getAttribute("token");
            String phone = user.getString("phone");
            RazorpayClient razorpay = new RazorpayClient("rzp_test_oIGyebxDnN8haM", "WvxYOXBuGyGuBEn7xyWR2aLx");
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amt*100);
            // amount in the smallest currency unit
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", "order_rcptid_11");
            Order order = razorpay.Orders.create(orderRequest);
            System.out.println(order);
            pw.print(order.toJson().append("phone", phone));
        }catch(RazorpayException rp){
                rp.printStackTrace();
                pw.print("error");
        }catch(Exception ex){
            ex.printStackTrace();
            pw.print("error");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
