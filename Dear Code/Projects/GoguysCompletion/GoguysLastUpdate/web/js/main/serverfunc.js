function productCardAjax(listener, data) {
    console.log(data)
    let ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function () {
        console.log("js call ajax")
        if (ajax.readyState === 1) {
            $("#progress-bar").addClass("anim1");
        } else if (ajax.readyState === 2) {
//            $("#progress-bar").addClass("anim2");
        } else if (ajax.readyState === 3) {
//            $("#progress-bar").addClass("anim3");
        } else if (ajax.readyState === 4) {
            if (ajax.responseText !== "error") {
                let promise = new Promise(function (resolve, reject)
                {
                    $("#product-card").html(ajax.responseText);
                    $("#product-card-cover").addClass("display-none");
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
                    $("#progress-bar").addClass("anim4");
                    let lastAnim;
                    clearTimeout(lastAnim);
                    lastAnim = setTimeout(function(){
                        $("#progress-bar").removeAttr("class");
                    }, 1000);
                    $('#product-card > div').attr('class', resizeCard);
                });
            } else if (ajax.responseText === "null") {
            } else {
                swal("Error!", "Server not responding. Please try later", "error");
            }
        } else if (ajax.status === 400) {
            swal("Error!", 'Some error occured:' + ajax.statusText, "error");
        }
    };
    ajax.open("POST", listener, true);
    ajax.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    let query = "";
    for (let a in data) {
        query = query + a + "=" + data[a] + "&";
    }
    query = query.substring(0, query.length - 1);
    console.log(query)
    ajax.send(query);
}