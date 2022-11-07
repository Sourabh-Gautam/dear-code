let div = document.querySelector("div");
let section = document.querySelector("section");
let button = document.querySelector("button");

div.addEventListener(
  "click",
  (e) => {
    console.log("Div bolte");
  },
  true
);
section.addEventListener(
  "click",
  (e) => {
    console.log("Section bolte");
  },
  true
);
button.addEventListener(
  "click",
  (e) => {
    console.log("Button bolte");
  },
  true
);
