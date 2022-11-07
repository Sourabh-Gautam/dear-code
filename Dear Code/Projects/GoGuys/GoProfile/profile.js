$(".edit-name").click(function (e) {
  $(".popup-holder").removeAttr("style");
  $(".popup").html(`
  <header>Edit Name</header>
  <table>
  <tr><td><label for="name">Name</label></td>
  <td>
  <input
  type="text"
  name="name"
  placeholder="new name"
  id="name"
  value="Sourabh"
/>
  </td></tr>
  </table>
  <section class="options">
    <button class="cancel">Cancel</button>
    <button class="save">Save Changes</button>
  </section>`);
});

$(".edit-pwd").click(function (e) {
  $(".popup-holder").removeAttr("style");
  $(".popup").html(`
  <header>Edit Password</header>
  <table>
  <tr>
  <td><label for="old-pwd">Old Password</label></td>
  <td>
  <input
  type="password"
  placeholder="Enter old password"
  id="old-pwd"
/>
  </td>
  </tr>
  <tr>
  <td><label for="new-pwd">New Password</label></td>
  <td>
  <input
  type="password"
  placeholder="Enter new password"
  id="new-pwd"
/>
  </td>
  </tr>
  <tr>
  <td><label for="confirm-pwd">Old Password</label></td>
  <td>
  <input
    type="password"
    placeholder="Confirm new password"
    id="confirm-pwd"
  />
  </td>
  </tr>
  </table>
  <section class="options">
    <button class="cancel">Cancel</button>
    <button class="save">Save Changes</button>
  </section>`);
});

$(".edit-mob").click(function (e) {
  $(".popup-holder").removeAttr("style");
  $(".popup").html(`
  <header>Edit Mobile</header>
  <table>
  <tr><td><label for="mobile">New Mobile</label></td>
  <td><input
    type="tel"
    name="mobile"
    placeholder=""
    maxlength="10"
    id="mobile"
  /></td></tr>
  <tr><td><label for="otp">OTP</label></td>
  <td><input
    type="text"
    name="otp"
    placeholder=""
    id="otp"
    value=""
  /></td></tr>
  </table>
  <button class="g-otp">Genrate Otp</button>
  <div class="options">
    <button class="cancel">Cancel</button>
    <button class="save">Save Changes</button>
  </div>`);
});

$(".edit-email").click(function (e) {
  $(".popup-holder").removeAttr("style");
  $(".popup").html(`
  <header>Link Email</header>
  <table>
  <tr><td><label for="email">Email</label></td>
  <td><input
    type="email"
    name="email"
    placeholder=""
    id="email"
  /></td></tr>
  <tr><td><label for="otp">OTP</label></td>
  <td><input
    type="text"
    name="otp"
    placeholder=""
    id="otp"
    value=""
  /></td></tr>
  </table>
  <button class="g-otp">Genrate Otp</button>
  <div class="options">
    <button class="cancel">Cancel</button>
    <button class="save">Link</button>
  </div>`);
});

$(".popup").on("click", ".options .cancel", function (e) {
  $(".popup-holder").css("display", "none");
});

$("body").on("click", ".popup-holder", function (e) {
  $(".popup-holder").css("display", "none");
});

$("body").on("click", ".popup", function (e) {
  e.stopPropogation();
});
