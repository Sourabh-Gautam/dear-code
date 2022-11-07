b = document.querySelector("body");
b.addEventListener("click", (e) => {
  text = e.target.innerText;
  myFunction(text);
});

function myFunction(copyText) {
  let s = JSON.parse(copyText);
  let finalstr =
    s.name + "\n" + s.number + "\n" + s.pincode + "\n" + s.category;
  console.log(finalstr);

  navigator.clipboard.writeText(finalstr);
}
