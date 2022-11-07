var shopInputSearch = new Object();

function productCounter(msg) {
    $(".shop-nav .overview-search-result").html(msg);
}

function singleProductCounter(id) {
    let pArr = Object.values(products);
    for (let p of pArr) {
        if (p.id + "" === id) {
            $(".shop-nav .overview-search-result").text('This product belongs to "' + p.shop + '" shop ');
        }
    }
}

function tellMeActiveShop() {
    let el;
    $("#shop-nav li").each(function (i, e) {
        if ($(e).hasClass("active-shop")) {
            el = e;
        }
    });
    console.log("function run")
    return el;
}

function tellMeActiveCategory() {
    let el;
    $("#filters li").each(function (i, e) {
        if ($(e).hasClass("active-shop")) {
            el = e;
        }
    });
    return el;
}

function searchInShop() {
    let arr = new Object();
    for (let p1 of Object.values(finalObjCopy)) {
        for (let p2 of eval(activeShop.toLowerCase() + "Products")) {
            if (p2.pname === p1) {
                arr[p2.id] = p2.pname;
            }
        }
    }
    shopInputSearch = Object.assign(arr);
    start = defaultStart;
    end = defaultEnd;
    let slicedIds = Object.keys(arr).slice(defaultStart - 1, defaultEnd - 1);
    console.log(slicedIds)
    let xhr = $.post("GetSearchProducts", {filteredIds: JSON.stringify(slicedIds)}, responseText => {
        if (responseText !== "error") {
//            if (Object.keys(finalObjCopy).length === 0) {
//                console.log("response if run")
//                $(activeShopLi).addClass("active-shop");
//                $("#shop-filters").removeClass("display-none");
//                $("#product-card").removeAttr('style');
//            }
            $("#product-card-cover").addClass("display-none");
            $("#product-card").html(responseText);
            $('#product-card > div').attr('class', resizeCard);
            productCounter("Search ' "+$(".header .search > input").val()+" ' matched with<br>"+Object.keys(arr).length+" products ( "+activeShop+" )");
            document.querySelector("#product-card").scrollTop = 0;
        } else {
            swal("Error!", "Server not responding. Try later", "error");
        }
    });
    xhr.fail((jqxhr, textstatus) => {
        swal("Error!", 'Some error occured:' + jqxhr.status, "error");
    });
}

// To get size of the first product when the screen size would change

function getCardSize(){
    resizeCard = $($('#product-card > div')[0]).attr('class');
}
