
// var count = 0;
// var max = document.querySelector("ul").scrollWidth-document.querySelector("ul").offsetWidth;
// console.log(document.querySelector("ul").offsetWidth);
// console.log(document.querySelector("ul").scrollWidth);

// function previous(){
//    var left= document.querySelector('#scroll');
//    if(count>=80){
//        count-=80;
//    }else{
//        count=0;
//    }

//    left.scrollTo(count,0);
//    console.log(count);
   
// }
// function next(){
//     var right = document.querySelector('#scroll');
    
//     if(count>=max){
//         count= max;
//         console.log("count overflow")
//     }
//     else{
//         count+=80;
//     }  
//     right.scrollTo(count,0);
//     console.log(count);
//  }

 var button = document.getElementById('scroll-right');
button.onclick = function () {
    var scroll = document.getElementById('scroll');
    sideScroll(scroll,'right',15,160,10);
};

var back = document.getElementById('scroll-left');
back.onclick = function () {
    var scroll = document.getElementById('scroll');
    sideScroll(scroll,'left',15,160,10);
};

function sideScroll(element,direction,speed,distance,step){
    scrollAmount = 0;
    var slideTimer = setInterval(function(){
        if(direction == 'left'){
            element.scrollLeft -= step;
        } else {
            element.scrollLeft += step;
        }
        scrollAmount += step;
        if(scrollAmount >= distance){
            window.clearInterval(slideTimer);
        }
    }, speed);
}


// const ele = document.getElementById('scroll');

// let pos = { top: 0, left: 0, x: 0, y: 0 };


// const mouseDownHandler = function(e) {
//     // pos = {
//     //     // The current scroll 
//     //     left: ele.scrollLeft,
//     //     // top: ele.scrollTop,
//     //     // Get the current mouse position
//     //     x: e.clientX,
//     //     // y: e.clientY,
//     // };
//     pos.left = ele.scrollLeft;
//     pos.x = e.clientX
//     console.log(pos.left);
//     console.log(pos.x);
//     document.getElementById('scroll').addEventListener('mousemove', mouseMoveHandler);
//     ele.style.cursor = 'grab';
//     ele.style.removeProperty('user-select');
//     // ele.style.cursor = 'grabbing';
//     // ele.style.userSelect = 'none';
//     // document.getElementById('scroll').addEventListener('mouseup', mouseUpHandler);
// }

// document.getElementById('scroll').addEventListener('mousedown', mouseDownHandler);

// const mouseMoveHandler = function(e) {
//     console.log("mouseMoveHAndler");
//     // How far the mouse has been moved
//     const dx = e.clientX - pos.x;
//     // const dy = e.clientY - pos.y;

//     // Scroll the element
//     // ele.scrollTop = pos.top - dy;
//     ele.scrollLeft = pos.left - dx;
// };



// // const mouseUpHandler = function() {
// //     console.log("mouseMoveHAndler");
// //     ele.style.cursor = 'grab';
// //     ele.style.removeProperty('user-select');
// // };


const slider = document.querySelector('#scroll');
let isDown = false;
let startX;
let scrollLeft;

slider.addEventListener('mousedown', (e) => {
  isDown = true;
  slider.classList.add('active');
  startX = e.pageX - slider.offsetLeft;
  scrollLeft = slider.scrollLeft;
});
slider.addEventListener('mouseleave', () => {
  isDown = false;
  slider.classList.remove('active');
});
slider.addEventListener('mouseup', () => {
  isDown = false;
  slider.classList.remove('active');
});
slider.addEventListener('mousemove', (e) => {
  if(!isDown) return;
  e.preventDefault();
  const x = e.pageX - slider.offsetLeft;
  const walk = (x - startX) * 1; //scroll-fast
  slider.scrollLeft = scrollLeft - walk;
  console.log(walk);
});