
var count = 0;
var max = document.querySelector("ul").scrollWidth-document.querySelector("ul").offsetWidth;
console.log(document.querySelector("ul").offsetWidth);
console.log(document.querySelector("ul").scrollWidth);

function previous(){
   var left= document.querySelector('#scroll');
   if(count>=80){
       count-=80;
   }else{
       count=0;
   }
   left.scrollTo(count,0);
   console.log(count);
   
}
function next(){
    var right = document.querySelector('#scroll');
    
    if(count>=max){
        count= max;
        console.log("count overflow")
    }
    else{
        count+=80;
    }  
    right.scrollTo(count,0);
    console.log(count);
 }