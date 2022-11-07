// Global Variables
var nameVal = "";
var passwordVal = "";
var numberVal = "";
var cpasswordVal = "";
var otpVal = "";

function showAlert(selector, msg, cls) {
  let regCardRect = document
    .getElementById("registration-card")
    .getBoundingClientRect();
  let eRect = selector.getBoundingClientRect();
  let c = eRect.bottom - regCardRect.top;
  $("#registration-card " + cls + " .tt").text(msg);
  $(cls).css("top", c - 6);
  $(cls).removeClass("display-none");
}

//  Validation on registration NAME

$("#registration-card #name").blur(function (e) {
  e.preventDefault();
  if (nameVal.length < 3 && nameVal.length > 0) {
    showAlert(e.target, "Name should atleast of 3 letters", ".n");
  }
});

$("#registration-card #name").focus(function (e) {
  $(".rtt.n").removeAttr("style");
  $(".rtt.n").addClass("display-none");
});

$("#registration-card #name").keypress(function (e) {
  let value = $(e.target).val();
  if (
    (e.charCode >= 65 && e.charCode <= 90) ||
    (e.charCode >= 97 && e.charCode <= 122)
  ) {
  } else {
    return false;
  }
});

$("#registration-card #name").keyup(function (e) {
  nameVal = $(e.target).val();
  if (nameVal.length < 3 && nameVal.length > 0) {
    $("#registration-card #name").removeClass("flag");
    $("#registration-card #name").css("border", "thin solid #cc3300");
  } else if (nameVal.length !== 0 && nameVal.length >= 3) {
    $("#registration-card #name").addClass("flag");
    $("#registration-card #name").css("border", "thin solid #4BB543");
  } else {
    $("#registration-card #name").removeClass("flag");
    $("#registration-card #name").removeAttr("style");
  }
  activeButton();
});

//  Validation on registration password

$("#registration-card #registration-password").keyup(function (e) {
  passwordVal = $(e.target).val();
  if (passwordVal.length < 6 && passwordVal.length !== 0) {
    $("#registration-card #registration-password").removeClass("flag");
    $("#registration-card #registration-password").css(
      "border",
      "thin solid #cc3300"
    );
  } else if (passwordVal.length === 0) {
    $("#registration-card #registration-password").removeClass("flag");
    $("#registration-card #registration-password").removeAttr("style");
  } else {
    $("#registration-card #registration-password").addClass("flag");
    $("#registration-card #registration-password").css(
      "border",
      "thin solid #4BB543"
    );
  }
  activeButton();
});

$("#registration-card #registration-password").blur(function (e) {
  e.preventDefault();
  if (passwordVal.length < 6 && passwordVal.length > 0) {
    showAlert(
      e.target,
      "Password length should be between 6-14 characters long",
      ".p"
    );
  }
});

$("#registration-card #registration-password").focus(function (e) {
  $(".rtt.p").removeAttr("style");
  $(".rtt.p").addClass("display-none");
});

//  Validation on registration NUMBER

$("#registration-card #phone").keypress(function (e) {
  let value = $(e.target).val();
  if (e.charCode >= 48 && e.charCode <= 57) {
  } else {
    return false;
  }
});

$("#registration-card #phone").keyup(function (e) {
  numberVal = $(e.target).val();
  if (numberVal.length < 10 && numberVal.length !== 0) {
    $("#registration-card #phone").removeClass("flag");
    $("#registration-card .pno").css("border", "thin solid #cc3300");
  } else if (numberVal.length === 0) {
    $("#registration-card #phone").removeClass("flag");
    $("#registration-card .pno").removeAttr("style");
  } else {
    $("#registration-card #phone").addClass("flag");
    $("#registration-card .pno").css("border", "thin solid #4BB543");
  }
  activeButton();
});

$("#registration-card #phone").blur(function (e) {
  e.preventDefault();
  if (numberVal.length < 10 && numberVal.length > 0) {
    showAlert(e.target, "Please enter a valid phone number", ".num");
  }
});

$("#registration-card #phone").focus(function (e) {
  $(".rtt.num").removeAttr("style");
  $(".rtt.num").addClass("display-none");
});

// Disable and Enable Register button

function activeButton() {
  let count = 0;
  $("#registration-card input").each(function (i, e) {
    if ($(e).hasClass("flag")) {
      count++;
    }
  });
  if (count === 3) {
    $("#registration-card .request-otp").removeClass("display-none");
  } else {
    $("#registration-card .request-otp").addClass("display-none");
  }
}

// OTP and confirm password Verification

$(".request-otp a").click(function (e) {
  e.preventDefault();
  $(".otp-section").removeClass("display-none");
  $("#registration-card .request-otp").addClass("display-none");
});

$(".otp-section .bx-arrow-back").click(function (e) {
  $(".otp-section").addClass("display-none");
  $("#registration-card .request-otp").removeClass("display-none");
});

// 1.) Confirm password verification
$("#c-pwd").keyup(function (e) {
  cpasswordVal = $(e.target).val();
  if (cpasswordVal === "") {
    $(e.target).removeAttr("style");
    $(e.target).removeClass("flag");
  } else if (cpasswordVal === passwordVal) {
    $(e.target).addClass("flag");
    $(e.target).css("border-bottom", "thin solid #4BB543");
  } else {
    $(e.target).css("border-bottom", "thin solid #cc3300");
    $(e.target).removeClass("flag");
  }
});

$("#registration-card #c-pwd").blur(function (e) {
  if (cpasswordVal !== passwordVal && cpasswordVal !== "") {
    showAlert(e.target, "Not matched with password!", ".n");
  }
});

$("#registration-card #c-pwd").focus(function (e) {
  $(".rtt.n").removeAttr("style");
  $(".rtt.n").addClass("display-none");
});

// 2.) Otp Verification

$("#otp").keyup(function (e) {
  otpVal = $(e.target).val();
  if (otpVal === "") {
    $(e.target).removeAttr("style");
    $(e.target).removeClass("flag");
  } else if (otpVal.length === 4) {
    $(e.target).css("border-bottom", "thin solid #4BB543");
    $(e.target).addClass("flag");
  } else {
    $(e.target).css("border-bottom", "thin solid #cc3300");
    $(e.target).removeClass("flag");
  }
});

$("#registration-card #otp").blur(function (e) {
  if (otpVal.length < 4 && otpVal.length > 0) {
    showAlert(e.target, "Wrong otp!", ".p");
  }
});

$("#registration-card #otp").focus(function (e) {
  $(".rtt.p").removeAttr("style");
  $(".rtt.p").addClass("display-none");
});

// Submit otp handling

$(".otp-section .submit-otp-btn").click(function (e) {
  if (!$("#registration-card #c-pwd").hasClass("flag")) {
    if (cpasswordVal.length === 0) {
      showAlert($("#c-pwd")[0], "Confirm password can't be empty", ".n");
      return false;
    }
    return false;
  }
  if (!$("#otp").hasClass("flag")) {
    if (otpVal.length === 0) {
      showAlert($("#otp")[0], "OTP missing!", ".p");
      return false;
    }
    return false;
  }
  $(e.target).addClass("loading");
  setTimeout(() => {
    if ($(".otp-section .otp").val() === "1234") {
      $(".submit-otp-btn").addClass("success");
    }
  }, 1000);
  setTimeout(() => {
    $(".otp-section").addClass("display-none");
    $(".submit-otp-btn").removeClass("success");
    $(".submit-otp-btn").removeClass("loading");
    $("#registration-card .request-otp").removeClass("display-none");
    $(".num-verified").removeClass("display-none");
    $("#registration-card #register-btn").removeClass("inactive-btn");
  }, 2000);
});
