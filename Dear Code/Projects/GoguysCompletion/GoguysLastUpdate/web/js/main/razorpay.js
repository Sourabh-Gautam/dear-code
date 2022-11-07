$("body").on('click', 'button.checkout', function (e) {
    if ($("#cod").prop("checked") !== true) {
        let xhr = $.post('PayServlet', function (response) {
            if (JSON.parse(response).status == "created") {
                var options = {
                    "key": "rzp_test_oIGyebxDnN8haM", // Enter the Key ID generated from the Dashboard
                    "amount": JSON.parse(response).amount, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
                    "currency": "INR",
                    "name": "Goguys",
                    "description": "Test Transaction",
                    "image": "images/cosmetics.png.png",
                    "order_id": JSON.parse(response).id, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
                    "handler": function (response) {
                        console.log(response.razorpay_payment_id);
                        console.log(response.razorpay_order_id);
                        console.log(response.razorpay_signature);
                        swal("Congrats! Payment successfully done", "", "success");
                    },
                    "prefill": {
                        "name": "Gaurav Kumar",
//                                "email": "gaurav.kumar@example.com",
                        "contact": JSON.parse(response).phone.toString().substring(3)
                    },
                    "notes": {
                        "address": "Goguys Shopping Payment"
                    },
                    "theme": {
                        "color": "rgb(221, 84, 114)"
                    }
                };

                var rzp1 = new Razorpay(options);
                rzp1.on('payment.failed', function (response) {
                    console.log(response.error.code);
                    console.log(response.error.description);
                    console.log(response.error.source);
                    console.log(response.error.step);
                    console.log(response.error.reason);
                    console.log(response.error.metadata.order_id);
                    console.log(response.error.metadata.payment_id);
                    alert("parment failed");
                });
                rzp1.open();
                e.preventDefault();
            } else {

            }
        });
        xhr.fail(function () {
            alert("failed");
        });
    }else{
        swal("Sorry! COD not available now", "", "warning");
    }
});