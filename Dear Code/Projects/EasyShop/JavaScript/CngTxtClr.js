let list = document.querySelectorAll("li");
list.forEach((x) => {
  x.addEventListener("click", () => {
    x.style.color = "crimson";
  });
});
