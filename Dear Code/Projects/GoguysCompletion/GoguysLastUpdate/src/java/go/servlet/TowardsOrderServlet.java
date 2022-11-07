/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go.servlet;

import go.dao.CartDao;
import go.dao.ManageProductDao;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Sourabh Gautam
 */
public class TowardsOrderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher rd = request.getRequestDispatcher("orderdetails.jsp");
        String id = request.getParameter("id");
        String qty = request.getParameter("qty");
        String unit = request.getParameter("unit");
        try {
            JSONArray jsonArrayId = new JSONArray(id);
            JSONArray jsonArrayQty = new JSONArray(qty);
            JSONArray jsonArrayUnit = new JSONArray(unit);
            JSONObject productDetails = ManageProductDao.getProducts(jsonArrayId);
            double[] calcPrices = priceCalculator(jsonArrayId, jsonArrayQty, jsonArrayUnit, productDetails);
            System.out.println(Arrays.toString(calcPrices));
            addTotalAmount(calcPrices, session);
            addCartIntoDb(request, jsonArrayId, jsonArrayQty, jsonArrayUnit, calcPrices);
            request.setAttribute("calcPricesArr", calcPrices);
            rd.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean addCartIntoDb(HttpServletRequest request, JSONArray id, JSONArray qty, JSONArray unit, double[] price) throws JSONException {
        System.out.println("addCartIntoDb");
        HttpSession loginSession = request.getSession();
        JSONObject user = (JSONObject) loginSession.getAttribute("token");
        String phone = (String) user.getString("phone");
        boolean result=false;
        try {
            CartDao.removeCart(phone);
            System.out.println("Removed previous items");
            for (int i = 0; i < id.length(); i++) {
                long id1 = Long.parseLong((String) id.get(i));
                int qty1 = Integer.parseInt((String) qty.get(i));
                double p = price[i];
                String unit1 = (String) unit.get(i);
                result = (Boolean)CartDao.addCartProduct(phone, id1, qty1, unit1, p);
            }
            System.out.println("All items added succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    return result;
}
    
    public void addTotalAmount(double[] prices, HttpSession session){
         double total=0;
        for(double a:prices){
            total = total+a;
        }
        session.setAttribute("totalprice", total);
    }

public double[] priceCalculator(JSONArray idArr, JSONArray qtyArr, JSONArray unitArr, JSONObject product) throws JSONException {
        double actualPrice[] = new double[idArr.length()];
        for (int i = 0; i < idArr.length(); i++) {
            long id1 = Long.parseLong((String) idArr.get(i));
            int qty = Integer.parseInt((String) qtyArr.get(i));
            String unit = (String) unitArr.get(i);
            for (int j = 1; j <= product.length(); j++) {
                long id2 = ((JSONObject) product.get("" + j)).getLong("id");
                if (id2 == id1) {
                    double price2 = ((JSONObject) product.get("" + j)).getDouble("price");
                    switch (unit) {
                        case "kg":
                            actualPrice[i] = qty * price2;
                            break;
                        case "lt":
                            actualPrice[i] = qty * price2;
                            break;
                        case "piece":
                            actualPrice[i] = qty * price2;
                            break;
                        case "gm":
                            actualPrice[i] = qty * (price2 / 1000);
                            break;
                        case "ml":
                            actualPrice[i] = qty * (price2 / 1000);
                    }
                }
            }
        }
        return actualPrice;
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
