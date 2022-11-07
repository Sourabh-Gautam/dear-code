// Global Variable Declaration 


// Function definitions

function showContent(element){
    $(".home-section > div").addClass("display-none");
    $(".sidebar .nav-links li").attr("id", function(index, text){
        if($(element).attr("id")===text || $(element).parent().attr("id")===text || $(element).parent().parent().attr("id")===text){
            $(".home-section ."+text).removeClass("display-none");
        }
    });
}

// Burger Functionality

$(".three-bar").click(function(){
    $(".sidebar").toggleClass("active");
});

// Sidebar Selection Functionality
for(let elem of document.querySelectorAll('.sidebar li')) {
    elem.addEventListener("click", e => {console.log(e.target)}, true); 
  }
$('.sidebar li').click(function(e){
    showContent(e.target);
});