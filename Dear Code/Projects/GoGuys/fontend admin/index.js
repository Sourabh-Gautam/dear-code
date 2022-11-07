$('.product').click((e)=>{
    console.log("product");
    $('.home-content').html(`
    <div class="add-product">
    <h1>Add Product</h1>
</div>
<div class="remove-product">
    <h1>Remove Product</h1>
</div>
<div class="update-product">
    <h1>Update Product</h1>
</div>
    `);
    $(".home-content").toggleClass("product-content");
    // $(".product-content").removeClass("home-content");
});

$('.shop-category').click((e)=>{
    console.log("shop category");
    $('.home-content').html(`
    <div class="add-product">
    <h1>Add Shop Category</h1>
</div>
<div class="remove-product">
    <h1>Remove Shop Category</h1>
</div>
<div class="update-product">
    <h1>Update Shop Category</h1>
</div>
    `);
    $(".home-content").toggleClass("product-content");
    // $(".product-content").removeClass("home-content");
});

$('.shop').click((e)=>{
    console.log("shop");
    $('.home-content').html(`
    <div class="add-product">
    <h1>Add Shop</h1>
</div>
<div class="remove-product">
    <h1>Remove Shop</h1>
</div>
<div class="update-product">
    <h1>Update Shop</h1>
</div>
    `);
    $(".home-content").toggleClass("product-content");
    // $(".product-content").removeClass("home-content");
});