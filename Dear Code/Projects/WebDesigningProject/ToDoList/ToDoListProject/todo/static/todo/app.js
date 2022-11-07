let ul = document.querySelector(".todos");

const myformadd = document.addfrm;
const addtodo = myformadd.add;

myformadd.addEventListener("submit", (e) => {
  if (addtodo.value != "") {
    let str = `<li class="listitems">
<span>${addtodo.value}</span>
<i class="far fa-trash-alt delete"></i>
</li>`;
    ul.innerHTML = str + ul.innerHTML;
    addtodo.value = "";
  }
});

ul.addEventListener("click", (e) => {
  if (e.target.nodeName == "I") {
    confirm("Are you sure ? ");
    e.target.parentElement.remove();
    addtodo.focus();
  }
});

let refreshTodo = (element) => {
  let liarr = ul.children;
  for (let li of liarr) {
    if (li.innerText.toLowerCase().indexOf(element.toLowerCase()) != -1) {
      li.classList.remove("displayContent");
      continue;
    } else {
      li.classList.add("displayContent");
    }
  }
};

let myformsearch = document.querySelector(".search input");
myformsearch.addEventListener("keyup", (e) => {
  refreshTodo(myformsearch.value);
});
