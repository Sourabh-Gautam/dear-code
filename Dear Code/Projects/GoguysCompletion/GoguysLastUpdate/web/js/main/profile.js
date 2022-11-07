$(".edit-name").click(function (e) {
    $(".popup-holder").removeAttr("style");
    $(".popup").html(`
  <header>Edit Name</header>
    <input type="hidden" value="name">
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
    <input type="hidden" value="password">
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
    <input type="hidden" value="mobile">
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
    <input type="hidden" value="email">
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

$(".addresses .add").click(function (e) {
    $(".popup-holder").removeAttr("style");
    $(".popup").html(`
  <header>Add an address</header>
    <input type="hidden" value="address">
  <table>
      <tr><td><label for="name">Name</label></td>
  <td>
  <input
  type="text"
  placeholder="type name"
  id="name"
/>
  </td></tr>
  <tr><td><label for="mobile">Mobile</label></td>
  <td>
  <input
  type="text"
  placeholder="type mobile"
  id="mobile"
/>
  </td></tr>
  <tr><td><label for="address">Address</label></td>
  <td>
  <input
  type="text"
  placeholder="type address here"
  id="address"
/>
  </td></tr>
  </table>
  <section class="options">
    <button class="cancel">Cancel</button>
    <button class="save">Add</button>
  </section>`);
});

$(".popup").on("click", ".options .cancel", function (e) {
    $(".popup-holder").css("display", "none");
});

$("body").on("click", ".popup-holder", function (e) {
    $(".popup-holder").css("display", "none");
});

$("body").on("click", ".popup", function (e) {
    e.stopPropagation();
});

$("body").on("click", "section.addresses > ul:nth-child(3) > li > span.edit", function (e) {
    $("#address1").prop("disabled", false);
    $("#address1").focus();
});

$(".popup").on("click", "button.save", function (e) {
    if ($('.popup input[type=hidden]').val() === 'address') {
        let name = $(".popup input#name").val();
        let mobile = $(".popup input#mobile").val();
        let address = $(".popup input#address").val();
        let xhr = $.post("AddressServlet", {address: JSON.stringify({adname: name, mobile: mobile, address: address})}, (responseText) => {
            console.log(responseText)
            if (responseText == "success") {
                swal({title: "Added", text: "Address added successfully", type:
                            "success"}).then(function () {
                    location.reload();
                }
                );
            } else {
                swal("Error!", 'Server facing some issues. Try later', "error");
            }
        });
        xhr.fail((jqxhr, textstatus) => {
            swal("Error!", 'Some error occured:' + jqxhr.status, "error");
        });
    }
});


//Remove Address

$('body').on("click", ".remove", function (e) {
    swal({
        title: "Are you sure?",
        text: "Do you really want to delete?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
            .then((willDelete) => {
                if (willDelete) {
                    let xhr = $.post("RemoveAddressServlet", {target: $(e.target).next().val()}, (r) => {
                        if (r == "success") {
                            swal({title: "Deleted", text: "Address deleted successfully", type:
                                        "success"}).then(function () {
                                location.reload();
                            }
                            );
                        }
                    });
                    xhr.fail((jqxhr, textstatus) => {
                        swal("Error!", 'Some error occured:' + jqxhr.status, "error");
                    });
                } else {
                    swal("Thanks! Shop is safe.");
                }
            });
});