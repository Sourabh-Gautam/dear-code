// Cart Opening While Clicking On Cart Button
$(".cart").click(function (e) {
    e.preventDefault();
    let xhr = $.post('IsLoggedIn', responseText => {
        if (responseText === "loggedin") {
            $(".cart-section").toggleClass("ct-dcss-gt1000");
            $(".shop-filters").toggleClass("ct-dcss-gt1000");
            $(".product-card").toggleClass("ct-dcss-gt1000");
            $(".product-card .return-to-top").css("right", "650px");
            $(".product-card-cover").toggleClass("ct-dcss-gt1000");
            if (!$(".shop-nav").hasClass("br-dcss-gt1000")) {
                $(".shop-filters").addClass("br-dcss-gt1000");
                $(".shop-nav").addClass("br-dcss-gt1000");
                $(".product-card").addClass("br-dcss-gt1000");
                $(".product-card-cover").addClass("br-dcss-gt1000");
                flag = true;
            } else {
                if (flag) {
                    $(".product-card .return-to-top").removeAttr("style");
                    $(".shop-filters").removeClass("br-dcss-gt1000");
                    $(".shop-nav").removeClass("br-dcss-gt1000");
                    $(".product-card").removeClass("br-dcss-gt1000");
                    $(".product-card-cover").removeClass("br-dcss-gt1000");
                }
            }
            $(".product-card .card").toggleClass("ct-dcss-gt1000");
        } else if (responseText === "notloggedin") {
            $(".login-registration-page-container").prepend("<div class='opencartwithoutloginmsg' style='text-align: center;border: 1px solid #cc3300; border-radius: 5px; width: 350px; color:#cc3300; padding: 10px; margin-bottom: 5px;'><i class='fas fa-exclamation-circle' style='color:#cc3300; font-size: 30px;'></i><div>It seems you are trying to access cart without login. Please login first!</div></div>");
            removeLoginAlert = setTimeout(function () {
                $(".opencartwithoutloginmsg").remove();
            }, 5000);
            $(".login-registration-page-container").removeClass("display-none");
        } else {
            swal("Error!", "Server is facing some issues.Try after sometime", "error");
        }
    });
});

// Return To Top Icon Handler 

$(".cart-section").on('click', '.return-to-top', function () {
    console.log("clicked")
    $(".cart-section").scrollTop(0);
});
$(".cart-section").scroll(function () {
    console.log("Scrolled")
    if (Math.floor($(".cart-section").scrollTop()) == 0) {
        console.log("if")
        $(".cart-section .return-to-top").addClass("display-none");
    } else {
        console.log("else")
        $(".cart-section .return-to-top").removeClass("display-none");
    }
});


//Order button functionality

$("#cart-section").on('click', '.order-now button', function (e) {
    $('.order-now button').css('display', 'none');
    $('.cart-items-details').append('<div class="final-step"><i class="fas fa-chevron-left order-back-arrow"></i><h3><strong>Choose Deliver Address</strong></h3><section><select></select></section><section class="cod"><input type="checkbox" id="cod"/><label for="cod">Cash on delivery</label></section><button class="checkout" style="margin:10px;width:200px;">Checkout</button></div>');
    let xhr = $.post("GetAddress", response => {
        console.log(response);
        if(response==='noaddress'){
            $('.final-step').html('<i class="fas fa-chevron-left order-back-arrow"></i><a href="profile.jsp" style="text-decoration:none; color:blue;" target="_blank"> Please add an address before checkout</a>');
        }else{
            $('.final-step select').html(response);
        }
    });
});

$("#cart-section").on('click', '.order-back-arrow', function (e) {
    $('.order-now button').removeAttr("style");
    $(".final-step").remove();
});