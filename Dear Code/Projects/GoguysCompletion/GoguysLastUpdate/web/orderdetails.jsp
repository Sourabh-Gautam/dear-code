<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    double[] calcPrices = (double[])request.getAttribute("calcPricesArr");
    double price = 0;
    for(double p : calcPrices){
        price = price + p;
    }
%>
<div class="cart-items-details">
    <div class="heading">
        Order Details
    </div>
    <div class="details">
        <div class="items-in-cart">
            <span class="key">Items</span>
            <span class="value"><%= calcPrices.length %></span>
        </div>
        <div class="price">
            <span class="key">Price</span>
            <span class="value">&#8377;<%= (int)Math.ceil(price) %></span>
        </div>
        <div class="discount">
            <span class="key">Discounts</span>
            <span class="value">- &#8377;0</span>
        </div>
        <div class="d-charge">
            <span class="key">Delivery Charges</span>
            <span class="value">Free</span>
        </div>
    </div>
    <div class="order-now">
        <div class="t-amt">
            <strong class="key">Total Amount :</strong>
            <strong class="value">&#8377;<%= (int)Math.ceil(price) %></strong>
        </div>
        <button>Order Now</button>
    </div>
</div>