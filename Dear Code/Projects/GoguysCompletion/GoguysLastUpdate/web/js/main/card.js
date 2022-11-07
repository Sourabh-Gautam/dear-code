
$("body").on("mouseenter", ".qbuy", function (e) {
    tooltipSetting(e, 6, "Quick Buy");
    showTip();
});
$("body").on("mouseleave", ".qbuy", function (e) { 
    hideTip();
});


$("body").on("mouseenter", ".acart", function (e) { 
    tooltipSetting(e, 6, "Add to Cart");
    showTip();
});
$("body").on("mouseleave", ".acart", function (e) { 
     hideTip();
});

// Return To Top Icon Handler 

$("#product-card").on('click', '.return-to-top', function () {
    console.log("clicked")
    $("#product-card").scrollTop(0);
});
$("#product-card").scroll(function () {
    console.log("Scrolled")
    if (Math.floor($("#product-card").scrollTop()) == 0) {
            console.log("if")
        $("#product-card .return-to-top").addClass("display-none");
    } else {
            console.log("else")
        $("#product-card .return-to-top").removeClass("display-none");
    }
});