/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go.servlet;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Sourabh Gautam
 */
public class GetSearchProducts extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("filteredIds");
        System.out.println(data);
        String id = request.getParameter("id");
        PrintWriter pw = response.getWriter();
        RequestDispatcher rd = request.getRequestDispatcher("productcard.jsp");
        try {
            if (data != null) {
                JSONArray jsonArr = new JSONArray(data);
                JSONObject json = ManageProductDao.getProducts(jsonArr);
                toProductCard(request, json);
                rd.forward(request, response);
            } else if (id != null) {
                JSONObject json = ManageProductDao.getSearchProduct(Long.parseLong(id));
                toProductCard(request, json);
                rd.forward(request, response);
            }
        } catch (Exception ex) {
            pw.print("error");
            ex.printStackTrace();
        }
    }

    void toProductCard(HttpServletRequest request, JSONObject json) throws IOException, JSONException {
        HashMap<String, String> map = new HashMap<>();
        ImageHandler ih = new ImageHandler();
        String PATH = request.getServletContext().getRealPath("/");
        for (int i = 1; i <= json.length(); i++) {
            String pname = ((JSONObject) json.get("" + i)).getString("pname");
            String directoryName = PATH.concat("images/product/" + pname + "/1.jpg");
            File f = new File(directoryName);
            String image = ih.base64Encode(f);
            map.put(pname, image);
        }
        request.setAttribute("productDetails", json);
        request.setAttribute("images", map);
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
