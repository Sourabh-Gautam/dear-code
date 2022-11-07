function showLoginAlert(selector, msg, cls) {
    let regCardRect = document
            .querySelector(".login-card")
            .getBoundingClientRect();
    let eRect = selector.getBoundingClientRect();
    let c = eRect.bottom - regCardRect.top;
    $(".login-card " + cls + " .tt").text(msg);
    $(cls).css("top", c - 6);
    $(cls).removeClass("display-none");
}

$($("#loginpage-container input")[0]).keyup(function (e) {
    let el = $(e.target);
    if (el.val().length !== 0) {
        el.addClass("flag");
    } else {
        el.removeClass("flag");
    }
    loginActive();
});

$($("#loginpage-container input")[1]).keyup(function (e) {
    let el = $(e.target);
    if (el.val().length >= 6) {
        el.addClass("flag");
    } else {
        el.removeClass("flag");
    }
    loginActive();
});

function loginActive() {
    let e1 = $($("#loginpage-container input")[0]).hasClass('flag');
    let e2 = $($("#loginpage-container input")[1]).hasClass('flag');
    if (e1 && e2) {
        $("#loginpage-container .l-btn").removeClass("inactive-btn");
        $("#loginpage-container .l-btn").css("cursor", "pointer");
        $("#loginpage-container .l-btn").addClass("flag");
    } else {
        $("#loginpage-container .l-btn").addClass("inactive-btn");
        $("#loginpage-container .l-btn").removeClass("flag");
        $("#loginpage-container .l-btn").css("cursor", "default");
    }
}

//While click on login button

$("body").on('click', '.login-card #login-btn', function () {
    let pe = $('.login-card #username')[0];
    let password = $('.login-card #login-password')[0];
    if (!$(".login-card .l-btn").hasClass('flag')) {
        return false;
    }
    data = {pe: pe.value, password: password.value};
    let xhr = $.post('LoginServlet', data, responseText => {
        if (responseText === "error") {
            swal("Error!", "Server facing some issues. Try again later!", "error");
        } else if (responseText === "uerror") {
            showLoginAlert(pe, "Email or phone is incorrect or probably you're not registered yet", ".id");
        } else if (responseText === "perror") {
            showLoginAlert(password, "Password is incorrect", ".pwd");
        } else {
            $(".login-registration-page-container").removeClass("showme");
            $(".login-registration-page-container .remove-card").trigger("click");
            $(".login-register-text").text(responseText);
            let xhr = $.post('IsOldUser', responseText => {
                if (responseText === "error") {
                    swal("Error!", "Server facing some issues. Try again later!", "error");
                } else if (responseText === "new") {
                    console.log("else if");
                } else {
                    $(".login-registration-page-container").removeClass("showme");
                    $(".login-register-text").text(responseText.substring(0, responseText.indexOf(",")));
                    let cartitems = responseText.substring(responseText.indexOf(",") + 1);
                    if (cartitems.trim()!=="") { 
                        console.log("sourabh");
                        $("#cart-section").css("background", "white");
                        $("#cart-section .heading.my-cart").removeClass("display-none");
                        $("#cart-section section.cart-items-section").prepend(cartitems);
                        $('.cart-items-counter').text($('.cart-items-container').length);
                        $("#cart-section").css("background", "white");
                        quantityValidate();
                    } else {
                        $("#cart-section").removeAttr("style");
                        $('.cart-items-counter').text("0");
                        $("#cart-section").removeAttr("style");
                    }
                }
            });
            xhr.fail((jqxhr, textstatus) => {
                swal("Error!", 'Some error occured:' + jqxhr.status, "error");
            });
        }
    });
    xhr.fail((jqxhr, textstatus) => {
        swal("Error!", 'Some error occured:' + jqxhr.status, "error");
    });
});

$(".login-card #username").focus(function (e) {
    $(".rtt.id").removeAttr("style");
    $(".rtt.id").addClass("display-none");
});


$(".login-card #login-password").focus(function (e) {
    $(".rtt.pwd").removeAttr("style");
    $(".rtt.pwd").addClass("display-none");
});