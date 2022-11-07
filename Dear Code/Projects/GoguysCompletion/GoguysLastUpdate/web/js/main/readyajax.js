$(document).ready(() => {
    let p1 = readyAJAX();
    p1.then(function () {
        let xhr3 = $.post('GetProductServlet', function (responseText) {
            let parsedJSON = JSON.parse(responseText);
            products = Object.values(parsedJSON);
            productsName = [];
            for (let product of products) {
                itemsPrice[product.id]=product.price;
                let sn = product.shop;
                switch (sn) {
                    case "Grocery":
                        groceryProducts.push(product);
                        break;
                    case "Stationery":
                        stationeryProducts.push(product);
                        break;
                    case "Cosmetics":
                        cosmeticsProducts.push(product);
                        break;
                    case "Fruits":
                        fruitsProducts.push(product);
                        break;
                    case "Vegetables":
                        vegetablesProducts.push(product);
                        break;
                }
                productsName.push(product.pname);
            }
            productCounter("Grocery shop showing " + groceryProducts.length + " products");
            productsName.sort();
        });
        xhr3.fail((jqxhr, textstatus) => {
            swal("Error!", 'Some error occured:' + jqxhr.status, "error");
        });
    });
});

function readyAJAX() {
    return new Promise(function (res, rej) {
        let promise1 = new Promise(function (resolve, reject) {
            let xhr = $.post('GetShopServlet', (responseText) => {
                shopobj = JSON.parse(responseText);
                let html = '';
                let shop = Object.keys(shopobj);
                let icon = Object.values(shopobj);
                for (let i = 0; i < shop.length; i++) {
                    if (shop[i] === 'Grocery') {
                        html = html.concat("<li class='active-shop' id='" + shop[i].toLowerCase() + "'>" + icon[i] + "<span>" + shop[i] + "</span></li>");
                        continue;
                    }
                    html = html.concat("<li id='" + shop[i].toLowerCase() + "'>" + icon[i] + "<span>" + shop[i] + "</span></li>");
                }
                $('#shop-nav #nav-list').html(html);
                console.log("shop resolve");
                resolve();
            });
            xhr.fail((jqxhr, textstatus) => {
                swal("Error!", 'Some error occured:' + jqxhr.status, "error");
            });
        });

        promise1.then(function () {
            var data1 = {select: 'Grocery'};
            let xhr1 = $.post('GetShopCategoryServlet', data1, (responseText) => {
                categoryobj = JSON.parse(responseText);
                let html = "<li class='active-shop'>All</li>";
                let categories = categoryobj['Grocery'];
                for (let i = 0; i < categories.length; i++) {
                    html = html.concat("<li>" + categories[i] + "</li>");
                }
                console.log("category resolve");
                $('#filters').html(html);
            });
            xhr1.fail((jqxhr, textstatus) => {
                swal("Error!", 'Some error occured:' + jqxhr.status, "error");
            });
        });

        promise1.then(function () {
            let data2 = {select: 'Grocery', selectedCategory: 'All', start: start, end: end};
            let xhr2 = $.post('GetProductServlet', data2, function (responseText) {
                if (responseText !== "error") {
                    $("#product-card").html(responseText);
                    $("#product-card").prepend(`<i class='bx bxs-chevrons-up return-to-top display-none'></i>`);
                    console.log("product resolve");
                    addToCart();
                    res();
                } else {
                    swal("Error!", "Server not responding. Try later", "error");
                }
            });
            xhr2.fail((jqxhr, textstatus) => {
                swal("Error!", 'Some error occured:' + jqxhr.status, "error");
            });
        });
    });
}
