let div = document.getElementById("mytext");
div.onkeypress = (e) => {
  if (e.charCode < 48 || e.charCode > 57) {
    return false;
  }
};
