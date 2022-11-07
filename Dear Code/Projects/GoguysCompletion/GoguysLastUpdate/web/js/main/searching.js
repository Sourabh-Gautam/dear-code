var finalObject = new Object();
var finalObjCopy = new Object();
var activeShopLi;
var input = document.querySelector('.header .search input');
input.addEventListener("keyup", searching);
input.addEventListener("keypress", function (e) {
    if (e.keyCode === 13) {
        $('.header .search .fa-search').click();
        $('.header .search input').blur();
        $('.header .search .search-list').addClass("display-none");
        finalObjCopy = finalObject;
    }
})
function searching(e) {
    let value = input.value.toLowerCase();
    if (value === "") {
        document.querySelector(".header .search .search-list").innerHTML = "";
        return;
    }
    let single = new Object();
    let filter1 = new Object();
    let filter2 = new Object();
    const filter3 = new Object();
    for (let product of products) {
        let pname = product.pname.toLowerCase();
        if (pname === value) {
            single[product.id] = product.pname;
            break;
        }
        if (pname.indexOf(value) === 0) {
            filter1[product.id] = product.pname;
        }
        if (pname.indexOf(value) >= 1) {
            filter2[product.id] = product.pname;
        }
        if (pname.indexOf(value) === -1) {
            if (value.length > 3) {
                for (i = 0, j = 3; j <= value.length; i++, j++) {
                    if (pname.includes(value.substring(i, j))) {
                        filter2[product.id] = product.pname;
                    }
                }
            }
        }
    }
    if (Object.keys(single).length === 1) {
        finalObject = Object.assign(single);
    } else {
        finalObject = Object.assign(filter1, filter2, filter3);
    }
    let html = "";
    let count = 1;
    for (let id in finalObject) {
        html =
                html +
                "<li><input type='hidden' value='" + id + "'>" + finalObject[id] + "</li>";
        if (count === 15) {
            break;
        }
        count++;
    }
    document.querySelector(".header .search .search-list").innerHTML = html;
}

// search input cross button handling

document.querySelector(".header .search input").addEventListener("search", function (e) {
    $('.header .search .search-list').empty();
});

// Stop propaations

$(".header .search input").mousedown(function (e) {
    e.stopPropagation();
});

$("body").on("mousedown", ".header .search-list", function (e) {
    e.stopPropagation();
});

// On focus border color of search will be change and products name will be fetch

$('.header .search input').focus(function () {
    $("#shop-nav li").each(function (i, e) {
        if ($(e).hasClass("active-shop")) {
            activeShopLi = e;
            $(e).removeClass("active-shop");
        }
    });
    $("#shop-filters").addClass("display-none");
    $("#product-card").css("top", "76px");
    $("#product-card").css("height", "calc(100% - 76px)");
    $('.header .search .search-list').removeClass("display-none");
    $('.header .search input').css({
        "border": "solid 2px rgb(38,151,255)",
        "border-right": "none"
    });
});

$('.header .search input').blur(function () {
    $('.header .search input').removeAttr("style");
    if (Object.keys(finalObjCopy).length === 0 && $(".header .search input").val() === "") {
        $(activeShopLi).addClass("active-shop");
        $("#shop-filters").removeClass("display-none");
        $("#product-card").removeAttr('style');
    }
});

//when click on search list li that particular will be display

$("body").on("click", ".header .search-list li", function (e) {
    e.stopPropagation();
    let p = $(e.target).text();
    let id = $(e.currentTarget).children('input').val();
    singleProductCounter(id);
    $(".header .search input").val(p);
    $('.header .search input').removeAttr("style");
    $('.header .search .search-list').addClass("display-none");
    input.dispatchEvent(new KeyboardEvent("keyup"));
    finalObjCopy = finalObject;
    let xhr = $.post("GetSearchProducts", {id: id}, responseText => {
        if (responseText !== "error") {
            $("#product-card").html(responseText);
            removeAcartClick();
            addToCart();
        } else {
            swal("Error!", "Server not responding. Try later", "error");
        }
    });
    xhr.fail((jqxhr, textstatus) => {
        swal("Error!", 'Some error occured:' + jqxhr.status, "error");
    });
});

// when click on search button then all the matched product that filled inside the search list will be display

$("body").on("click", ".header .search .fa-search", function (e) {
    if (Object.keys(finalObjCopy).length !== 0 && $(".header .search > input").val() === "") {
        console.log("inside if")
        finalObjCopy = new Object();
        $(activeShopLi).click();
        $(activeShopLi).addClass("active-shop");
        $("#shop-filters").removeClass("display-none");
        $("#product-card").removeAttr('style');
        searchTriggered = false;
        return false;
    } else if ($(".header .search > input").val() === "") {
        console.log("inside else")
        searchTriggered = false;
        return false;
    }
    scrollTopAlert = 0;
    scrollTop = 20;
    $(tellMeActiveShop()).removeClass("active-shop");
    $("#product-card-cover").css({"height": "calc(100% - 76px)", "top": "76px"});
    $("#product-card-cover").removeClass("display-none");
    console.log("function running")
    finalObjCopy = finalObject;
    let arr = Object.keys(finalObjCopy);
    start = defaultStart;
    end = defaultEnd;
    let slicedIds = arr.slice(defaultStart - 1, defaultEnd - 1);
    searchTriggered = true;
    let xhr = $.post("GetSearchProducts", {filteredIds: JSON.stringify(slicedIds)}, responseText => {
        if (responseText !== "error") {
            if (Object.keys(finalObjCopy).length === 0) {
                console.log("response if run")
                $(activeShopLi).addClass("active-shop");
                $("#shop-filters").removeClass("display-none");
                $("#product-card").removeAttr('style');
            }
            getCardSize();
            $("#product-card").html(responseText);
            $("#product-card").prepend(`<i class='bx bxs-chevrons-up return-to-top display-none'></i>`);
            $('#product-card > div').attr('class', resizeCard);
            console.log("response arrived")
            $("#product-card-cover").addClass("display-none");
            productCounter("Search ' " + $(".header .search > input").val() + " ' matched with<br>" + arr.length + " products ( All )");
            document.querySelector("#product-card").scrollTop = 0;
            removeAcartClick();
            addToCart();
            activeShop2 = "";
        } else {
            swal("Error!", "Server not responding. Try later", "error");
        }
    });
    xhr.fail((jqxhr, textstatus) => {
        swal("Error!", 'Some error occured:' + jqxhr.status, "error");
    });
});

