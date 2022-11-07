// on click to the add to cart button at product cards will be responsible to add that particular product into the cart
var cart_counter = 0;
function addToCart() {
    $("#product-card .card").on("click", ".acart", function (e) {
        e.stopPropagation();
        if ($(".login-registration-page-container").hasClass("showme")) {
            //tooltip
            showTooltip($(".login-register-dp")[0], "Please login first", 0, -60, 5);
            let timer;
            $(".login-register-dp").css("border", "solid 1px red");
            clearTimeout(timer);
            timer = setTimeout(function () {
                $(".login-register-dp").removeAttr("style");
                hideTooltip();
            }, 2000);
            return false;
        }
        cart_counter = $('.cart-items-container').length;
        let price = $(e.target).parents('.card').find('.item-details strong').text();
        let productId = $(e.target).parent().siblings('input[type=hidden]').val();
        onChangeRemoveOrder();
        let p;
        for (let product in products) {
            if (products[product].id === Number($(e.target).parent().siblings("input[type='hidden']").val())) {
                p = products[product];
            }
        }
        let units;
        if (p.unit === "kg") {
            units = '<option value="kg">kg</option><option value="gm">gm</option>';
        } else if (p.unit === "ltr") {
            units = '<option value="ltr">ltr</option><option value="ml">ml</option>';
        } else {
            units = '<option value="piece">piece</option>';
        }
        $("#cart-section").css("background", "white");
        $("#cart-section .heading.my-cart").removeClass("display-none");
        $("#cart-section section.cart-items-section").prepend(`<div class="cart-items-container">
        <input type="hidden" value="${p.id}">
                    <div class="cart-items">
                        <div class="image-container">
                            <img src="${$(e.target).parent().next().children("img").attr("src")}">
                        </div>
                        <div class="item-desc">
                            <ul class="desc">
                                <li>${p.pname} ( <span class = 'quantity'>${ p.quantity}</span> <span class = 'unit'>${p.unit}</span> )</li>
                                <li>${p.shortdescription}</li>
                                <li>${p.type === "Pack" ? "Standard packing" : "Pack in hard paper bag"}</li>
                                <li> <span class="pad">&#8377; <strong>${p.price.toFixed(1)}</strong></span></li>
                            </ul>
                        </div>
                        <div class="modify-item">
                            <div class="weight">
                                <span class="less"><i class="fas fa-minus"></i></span>
                                <input type="text" class="qty" value="1" name="qty" maxlength="2">
                                <span class="more"><i class="fas fa-plus"></i></span>
                            </div>
                            <select name="unit" id="unit" class="unit">
                                ${units}
                            </select>
                            <button class="remove">Remove</button>
                        </div>
                    </div>
                </div>`);
        $('.cart-items-counter').text(++cart_counter);
        $('.cart-items-section .qty').unbind("keypress");
        $('.cart-items-section .qty').unbind("keyup");
        $('.cart-items #unit').unbind("change");
        $('.cart-items .fa-minus').unbind("click");
        $('.cart-items .fa-plus').unbind("click");
        $('.cart-items-section .qty').unbind("blur");
        quantityValidate();
    });
}

function removeAcartClick() {
//    document.querySelector("#product-card .card").removeEventListener("click");
    $("#product-card .card").unbind("click");
}

$('body').on('click', '.cart-items .remove', function (e) {
    onChangeRemoveOrder();
    $(e.target).parent().parent().parent().remove();
    $('.cart-items-counter').text(--cart_counter);
    if ($("#cart-section .cart-items-section").children().length === 0) {
        $("#cart-section").removeAttr("style");
        $("#cart-section .heading.my-cart").addClass("display-none");
        $.post("EmptyCartServlet");
    }
});

// on clicking of towards order button three array will be initialized where id contains id's of all products and qty -> quantity and unit -> unit of the products

$('body').on('click', '#cart-section .towards-order', function () {
    var id = [];
    var qty = [];
    var unit = [];
    $('#cart-section .cart-items-section > *').each(function (i, e) {
        id.push($(e).find("input[type='hidden']").val());
        qty.push($(e).find("input[type='text']").val());
        unit.push($(e).find("#unit").val());
    });
    let xhr = $.post('TowardsOrderServlet', {id: JSON.stringify(id), qty: JSON.stringify(qty), unit: JSON.stringify(unit)}, responseText => {
        $("#cart-section").prepend(responseText);
        $('#cart-section .towards-order').addClass('display-none');
        $(".cart-section").scrollTop(0);
    });
    xhr.fail((jqxhr, textstatus) => {
        swal("Error!", 'Some error occured:' + jqxhr.status, "error");
    });

});

// Increment and decrement quantity of the product in cart


function quantityValidate() {
    $('.cart-items-section .qty').keypress(function (e) {
        console.log("quantity ");
        if (e.charCode >= 48 && e.charCode <= 57) {
            onChangeRemoveOrder();
        } else {
            return false;
        }
    }
    );

    $('.cart-items-section .qty').keyup(function (e) {
        $(e.target).parents('.cart-items-container').find('.desc .quantity').text($(e.target).val());
        displayCalPrice(e);
    });

    $('.cart-items-section .qty').blur(function (e) {
        if ($(e.target).val() === "") {
            $(e.target).val("1");
            $(e.target).parents('.cart-items-container').find('.desc .quantity').text(1);
            displayCalPrice(e);
        }

    });

    $('.cart-items #unit').change(function (e) {
        onChangeRemoveOrder();
        console.log("change");
        $(e.target).parents('.cart-items-container').find('.desc .unit').text($(e.target).val());
        if ($(e.target).val() === "gm" || $(e.target).val() === "ltr") {
            $(e.target).prev().children('input[type=text]').val("1");
            $(e.target).parents('.cart-items-container').find('.desc .quantity').text("1");
            $(e.target).prev().children('input[type=text]').attr("maxlength", "4");
        } else {
            $(e.target).prev().children('input[type=text]').val("1");
            $(e.target).parents('.cart-items-container').find('.desc .quantity').text("1");
            $(e.target).prev().children('input[type=text]').attr("maxlength", "2");
        }
        displayCalPrice(e);
    });

    $('.cart-items .fa-plus').click(function (e) {
        let value = $(e.target).parent().prev().val();
        if ($(e.target).parent().prev().attr("maxlength") === "4") {
            if (Number(value) === 9999) {
            } else {
                onChangeRemoveOrder();
                $(e.target).parent().prev().val(++value);
                $(e.target).parents('.cart-items-container').find('.desc .quantity').text($(e.target).parent().prev().val());
            }
        } else if ($(e.target).parent().prev().attr("maxlength") === "2") {
            if (Number(value) === 99) {
            } else {
                onChangeRemoveOrder();
                $(e.target).parent().prev().val(++value);
                $(e.target).parents('.cart-items-container').find('.desc .quantity').text($(e.target).parent().prev().val());
            }
        } else {
            onChangeRemoveOrder();
            $(e.target).parent().prev().val(++value);
            $(e.target).parents('.cart-items-container').find('.desc .quantity').text($(e.target).parent().prev().val());
        }
        displayCalPrice(e);
    });

    $('.cart-items .fa-minus').click(function (e) {
        let value = $(e.target).parent().next().val();
        if (value > 1) {
            onChangeRemoveOrder();
            $(e.target).parent().next().val(--value);
            $(e.target).parents('.cart-items-container').find('.desc .quantity').text($(e.target).parent().next().val());
        }
        displayCalPrice(e);
    });
}

// Whenever the user make changes in the added items then the visible order details will get disappear and the towards order button again will be showing
function onChangeRemoveOrder() {
    $('.cart-items-details').remove();
    $('#cart-section .towards-order').removeClass('display-none');
}

function changeCartUi() {
    $(".cart-items-container .item-desc .quantity").text();
    $(".cart-items-container .item-desc .unit").text();
    $(".cart-items-container .item-desc .pad").text();
}

function displayCalPrice(e) {
    let id = $(e.target).parents('.cart-items-container').find('input[type=hidden]').val();
    let unit = $(e.target).parents('.cart-items-container').find('#unit').val();
    let price = itemsPrice[id];
    let quantity = Number($(e.target).parents('.cart-items-container').find('.desc .quantity').text());
    let calcPrice = (unit == ("kg" || "lt")) ? (price * quantity) : (price * quantity / 1000);
    $(e.target).parents('.cart-items-container').find('.desc strong').text(calcPrice);
}

