/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go.servlet;

import go.dao.CartDao;
import go.dao.ManageProductDao;
import go.handler.ImageHandler;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Sourabh Gautam
 */
public class IsOldUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside IsOldUse");
        RequestDispatcher rd = request.getRequestDispatcher("usercart.jsp");
        HttpSession loginSession = request.getSession();
        JSONObject status = (JSONObject) loginSession.getAttribute("token");
        System.out.println("status" + status);
        PrintWriter pw = response.getWriter();
        try {
            if (status != null) {
                request.setAttribute("username", status.getString("username"));
                String phone = status.getString("phone");
                System.out.println(phone);
                JSONObject json = CartDao.getUserCartItems(phone);
                System.out.println(json);
                JSONArray jsonArrayId = (JSONArray) json.get("idArr");
                System.out.println(jsonArrayId);
                JSONObject productDetails = ManageProductDao.getProducts(jsonArrayId);
                System.out.println("d" + productDetails);
                if (productDetails != null) {
                    HashMap<String, String> map = new HashMap<>();
                    ImageHandler ih = new ImageHandler();
                    for (int i = 1; i <= productDetails.length(); i++) {
                        JSONObject myjson = (JSONObject) productDetails.get("" + i);
                        String pname = myjson.getString("pname");
                        String PATH = request.getServletContext().getRealPath("/");
                        String directoryName = PATH.concat("images/product/" + pname + "/1.jpg");
                        File f = new File(directoryName);
                        String image = ih.base64Encode(f);
                        map.put(pname, image);
                    }
                    request.setAttribute("cartitems", json);
                    request.setAttribute("productDetails", productDetails);
                    request.setAttribute("images", map);
                    System.out.println("response sent");
                    rd.forward(request, response);
                }
            } else {
                pw.print("new");
            }
        } catch (Exception ex) {
            pw.print("error");
            ex.printStackTrace();
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
