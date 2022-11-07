// On click to the shop name at the sidebar the active color applied, filters showing and product updated accroding to the shop activated.

$('body').on('click', '.shop-nav li', (e) => {
    if (activeShop === $(e.currentTarget).text() && Object.keys(finalObjCopy).length === 0 && $(".header .search > input").val() === "") {
        return false;
    }
    $('#nav-list > li').removeClass('active-shop');
    $(e.currentTarget).addClass('active-shop');
    activeShop = $(e.currentTarget).text();
    activeCategory = "All";
    if (Object.keys(finalObjCopy).length !== 0 && $(".header .search >  input").val() === "") {
        finalObjCopy = new Object();
        searchTriggered = false;
        activeShopLi = tellMeActiveShop();
        $(activeShopLi).addClass("active-shop");   // doubt
        $("#product-card-cover").removeAttr("style");
        $("#shop-filters").removeClass("display-none");
        $("#product-card").removeAttr('style');
    } else if (Object.keys(finalObjCopy).length === 0) {
        console.log("dynamic else if run")
        $(".header .search input").val("");
        $('.header .search .search-list').empty();
        activeShopLi = tellMeActiveShop();
        $(".header .search input").blur();
    } else {
        console.log("dynamic else run")
        console.log(activeShop + " : " + activeShop2)
        if (activeShop !== activeShop2) {
            $("#product-card-cover").removeClass("display-none");
            activeShop2 = activeShop;
            console.log("search call")
            searchInShop();
        }
        return false;
        console.log("after return")
    }
    $("#product-card-cover").removeClass("display-none");
    let html = "<li class='active-shop'>All</li>";
    let categories = categoryobj[activeShop];
    for (let c of categories) {
        html = html.concat("<li>" + c + "</li>");
    }
    $('#filters').html(html);
    document.querySelector('#product-card').scrollTo(0, 0);
    scrollTopAlert = 0;
    scrollTop = 50;
    start = defaultStart;
    end = defaultEnd;
    console.log("Active shop " + activeShop)
    console.log("Active category " + activeCategory)
    let data = {select: activeShop, selectedCategory: 'All', start: start, end: end};
    $("#progress-bar").addClass("anim1");
    let xhr2 = $.post('GetProductServlet', data, processResponse);
    xhr2.fail((jqxhr, textstatus) => {
        swal("Error!", 'Some error occured:' + jqxhr.status, "error");
    });
});

// On click to the filters names at the topbar the active color applied, product updated accroding to the shop activated.

$('body').on('click', '#filters li', (e) => {
    $("#product-card-cover").removeClass("display-none");
    $('#filters > li').removeClass('active-shop');
    $(e.currentTarget).addClass('active-shop');
    activeCategory = $(e.target).text();
    document.querySelector('#product-card').scrollTo(0, 0);
    scrollTopAlert = 0;
    scrollTop = 50;
    start = defaultStart;
    end = defaultEnd;
    let data = {
        select: activeShop,
        selectedCategory: activeCategory,
        start: start,
        end: end
    };
    $("#progress-bar").addClass("anim1");
    let xhr2 = $.post('GetProductServlet', data, processResponse);
    xhr2.fail((jqxhr, textstatus) => {
        swal("Error!", 'Some error occured:' + jqxhr.status, "error");
    });
});

function processResponse(responseText) {
    if (responseText !== "error") {
        let promise = new Promise(function (resolve, reject)
        {
            getCardSize();
            $("#product-card").html(responseText);
            $("#product-card").prepend(`<i class='bx bxs-chevrons-up return-to-top display-none'></i>`);
            removeAcartClick();
            addToCart();
            $("#product-card-cover").addClass("display-none");
            console.log(activeShop)
            console.log(activeCategory)
            let count = 0;
            if (activeCategory === "All") {
                productCounter(activeShop + " shop showing " + eval(activeShop.toLowerCase() + "Products").length + " products");
            } else {
                for (let p of Object.values(products)) {
                    if (p.shop === activeShop && p.category === activeCategory) {
                        count++;
                    }
                }
                productCounter(activeShop + " shop showing " + count + " products");
            }
            resolve();
        });
        promise.then(function () {
            $("#progress-bar").addClass("anim2");
            let lastAnim;
            clearTimeout(lastAnim);
            lastAnim = setTimeout(function () {
                $("#progress-bar").removeAttr("class");
            }, 1000);
            $('#product-card > div').attr('class', resizeCard);
        });
    } else if (responseText === "null") {
    } else {
        swal("Error!", "Server not responding. Please try later", "error");
    }
}

// On scroll new product fetching

function fetchProductOnScroll() {
    return new Promise(function (resolve, reject) {
        let xhr;
        if (searchTriggered) {
            console.log("Search scrolling");
            start = end;
            end = end + increment;
            let slicedIds;
            if (tellMeActiveShop() === undefined) {
                console.log("undefined")
                slicedIds = Object.keys(finalObjCopy).slice(start - 1, end - 1);
            } else {
                slicedIds = Object.keys(shopInputSearch).slice(start - 1, end - 1);
            }
            console.log(slicedIds.length)
            if (slicedIds.length !== 0) {
                let data = {filteredIds: JSON.stringify(slicedIds)};
                let xhr = $.post("GetSearchProducts", data, responseText => {
                    console.log("response got by search")
                    if (responseText !== "error") {
                        resolve();
                        $("#product-card").append(responseText);
                    } else {
                        swal("Error!", "Server not responding. Try later", "error");
                    }
                });
                xhr.fail((jqxhr, textstatus) => {
                    swal("Error!", 'Some error occured:' + jqxhr.status, "error");
                });
            }
        } else {
            console.log("Shop click scrolling");
            start = end;
            end = end + increment;
            data = {select: activeShop, selectedCategory: activeCategory, start: start, end: end};
            xhr = $.post('GetProductServlet', data, function (responseText) {
                if (responseText !== "error") {
                    $("#product-card").append(responseText);
                    resolve();
                } else if (responseText == "null") {
                } else {
                    swal("Error!", "Server not responding. Please try later", "error");
                }
            });
            xhr.fail((jqxhr, textstatus) => {
                swal("Error!", 'Some error occured:' + jqxhr.status, "error");
            });
        }
    });
}

var isScrolling;
var scrollTopAlert = 0;  // It will be change every movement of scrolling.
var scrollTop = 20;       // It will be change only when untill the scrollTopAlert becomes equal to the initialized valued of scrollTop
document.querySelector('#product-card').addEventListener('scroll', function (e) {
    clearTimeout(isScrolling);
    isScrolling = setTimeout(function () {
        console.log("scrolling happen");
        scrollTopAlert = document.querySelector('#product-card').scrollTop;
        console.log(scrollTopAlert);
        console.log(scrollTop);
        if (scrollTopAlert > scrollTop) {
            console.log("Scroll fired")
            scrollTop = scrollTop + 50;
            let promise = fetchProductOnScroll();
            promise.then(function () {
                getCardSize();
                removeAcartClick();
                addToCart();
                $('#product-card > div').attr('class', resizeCard);
            });
        }
    }, 100);
}, false);


//Show Description when click on the product

$(".product-card").on('click', '.card', function (e) {
    console.log("called");
    $(".f-desc-parent").removeAttr("style");
    let id = $($(e.currentTarget).children()[0]).val();
    let xhr = $.post('GetOneProductServlet', {id: id}, function (responseText) {
        if (responseText !== "error") {
            $(".f-desc-parent").html(responseText);
        } else if (responseText == "null") {
        } else {
            swal("Error!", "Server not responding. Please try later", "error");
        }
    });
    xhr.fail((jqxhr, textstatus) => {
        swal("Error!", 'Some error occured:' + jqxhr.status, "error");
    });
});

$('.f-desc-parent').on('mouseenter', '.tiny-img ul li img', function (e) {
    let img = $(e.currentTarget).attr("src");
    $('.img-showcase .big-img img').attr("src", img);
});

$('body').on('click', '.bx-arrow-back', function (e) {
    $(".f-desc-parent").css("display", "none");
    $(".f-desc-parent").html("");
});

$('body').on('click', '.f-desc-parent', function () {
    $(".f-desc-parent").css("display", "none");
    $(".f-desc-parent").html("");
});

$('body').on('click', '.f-desc-container', function (e) {
    e.stopPropagation();
});