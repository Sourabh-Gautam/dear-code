<%@page import="java.util.HashMap"%>
<%@page import="org.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%= request.getAttribute("username").toString() + ","%>
<%
    JSONObject json = (JSONObject) request.getAttribute("cartitems");
    JSONObject productDetails = (JSONObject) request.getAttribute("productDetails");
    HashMap<String, String> map = (HashMap<String, String>) request.getAttribute("images");
    System.out.println(json.length());
    for (int i = 1; i < json.length(); i++) {
        System.out.println("run");
        long id = ((JSONObject) json.get("" + i)).getLong("pid");
        double price = ((JSONObject) json.get("" + i)).getDouble("price");
        String unit = ((JSONObject) json.get("" + i)).getString("unit");
        int qty = ((JSONObject) json.get("" + i)).getInt("qty");
        JSONObject product = null;
        for (int a = 1; a <= productDetails.length(); a++) {
            JSONObject p = (JSONObject) productDetails.get(a + "");
            if (p.getLong("id") == id) {
                product = p;
            }
        }
        String pname = product.getString("pname");
        String shortdesc = product.getString("shortdescription");
        String type = product.getString("type");
        String image = map.get(pname);
%>
<div class="cart-items-container">
    <input type="hidden" value="<%= id%>">
    <div class="cart-items">
        <div class="image-container">
            <img src="data:image/jpg;charset=utf-8;base64,<%= image%>">
        </div>
        <div class="item-desc">
            <ul class="desc">
                <li><%= pname%> ( <span class = 'quantity'><%= qty%></span> <span class = 'unit'><%= unit%></span> )</li>
                <li><%= shortdesc%></li>
                <li><% if (type.equals("Pack")) { %>Standard packing<% } else { %>Pack in hard paper bag<% }%></li>
                <li> <span class="pad">&#8377; <strong><%= price%></strong></span></li>
            </ul>
        </div>
        <div class="modify-item">
            <div class="weight">
                <span class="less"><i class="fas fa-minus"></i></span>
                <input type="text" class="qty" value="<%= qty %>" name="qty" maxlength="2">
                <span class="more"><i class="fas fa-plus"></i></span>
            </div>
            <select name="unit" id="unit" class="unit">
                <%
                    if (unit.equals("kg")) {
                %>
                <option value="kg">kg</option><option value="gm">gm</option>
                <%
                } else if (unit.equals("gm")) {
                %>
                <option value="gm">gm</option><option value="kg">kg</option>
                <%
                } else if (unit.equals("ltr")) {
                %>
                <option value="ltr">ltr</option><option value="ml">ml</option>
                <%
                } else if (unit.equals("ml")) {
                %>
                <option value="ml">ml</option><option value="ltr">ltr</option>
                <%
                } else {
                %>
                <option value="piece">piece</option>
                <%
                    }
                %>
            </select>
            <button class="remove">Remove</button>
        </div>
    </div>
</div>
<%
    }
%>           