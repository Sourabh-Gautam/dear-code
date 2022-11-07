<%@page import="java.util.ArrayList"%>
<%@page import="go.dao.ProfileDao"%>
<%@page import="org.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    JSONObject status = (JSONObject) session.getAttribute("token");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Manage Profile</title>
        <link rel="stylesheet" href="css/main/profile.css" />
        <link
            href="https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css"
            rel="stylesheet"
            />
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="popup-holder" style="display: none">
            <div class="popup"></div>
        </div>
        <main class="m-profile">
            <div class="container">
                <section class="p-header">
                    <div>
                        <div class="photo">
                            <img src="sourabh.jpg" alt="your photo" />
                            <div class="upload"><i class="bx bxs-camera"></i></div>
                        </div>
                    </div>
                    <div>
                        <div class="name">Sourabh</div>
                    </div>
                </section>
                <section class="p-body">
                    <section class="basic-info">
                        <div class="title">Basic Info</div>
                        <ul>
                            <li>
                                <div><strong>Name</strong><span>Sourabh</span></div>
                                <span class="edit edit-name">edit</span>
                            </li>
                            <li>
                                <div><strong>Password</strong><span>********</span></div>
                                <span class="edit edit-pwd">change</span>
                            </li>
                            <li>
                                <div><strong>Mobile</strong><span>+91 9953774522</span></div>
                                <span class="edit edit-mob">change</span>
                            </li>
                            <li>
                                <div><strong>Email</strong><span>No email linked</span></div>
                                <span class="edit edit-email">change</span>
                            </li>
                        </ul>
                    </section>
                    <section class="addresses">
                        <div class="title">Address Info</div>
                        <div class="note"><strong>Note:</strong> You can add at most 3 different addresses</div>
                        <ul>
                            <%
                                ArrayList<String> list = ProfileDao.getAddress(status.getString("username"));
                                for (int i = 0; i < list.size(); i++) {
                                    JSONObject json = new JSONObject(list.get(i));
                            %>
                            <li>
                                <strong>Address <%= i+1 %></strong>
                                <div class="address">
                                    <span>
                                        <input
                                            type="text"
                                            id="name<%= i+1 %>"
                                            value="<%= json.getString("adname") %>"
                                            disabled
                                            style="font-weight: bolder"
                                            /></span>
                                    <span
                                        ><input
                                            type="text"
                                            id="mobile<%= i+1 %>"
                                            value="<%= json.getString("mobile") %>"
                                            disabled
                                            /></span>
                                    <span
                                        ><input
                                            type="text"
                                            id="address<%= i+1 %>"
                                            value="<%= json.getString("address") %>"
                                            disabled
                                            /></span>
                                </div>
                                <span class="edit">edit</span>
                                <span class="remove">remove</span>
                                <input type="hidden" value="address<%= i+1 %>">
                            </li>
                            <%
                                }
                            %>
                        </ul>
                        <button class="add">
                            <i class="bx bxs-plus-circle"></i> New address
                        </button>
                    </section>
                </section>
            </div>
        </main>
        <script src="js/main/profile.js"></script>
    </body>
</html>
