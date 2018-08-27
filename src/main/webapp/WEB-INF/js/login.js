$(document).ready(function () {
    $('#login').click(function () {
        var user = $('#userid').val();
        var pwd = $('#pswrd').val();

        if (user != '' && pwd != '') {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/admin/login",
                data: "adminEmail=" + user + "&adminPassword=" + pwd,
                success: function (response) {

                    if (response == 'index') {
                        window.location = 'index.html';
                    }
                    else {
                        $("#errorMessage2").show();
                        $('#pswrd').val('');
                        $("#errorMessage").hide();
                        $("#errorMessage1").hide();
                    }
                    console.log(data);
                }
            });
        }
        else if (user == '' && pwd != '') {
            $("#errorMessage").show();
            $("#errorMessage1").hide();
        }
        else if (pwd == '' && user != '') {
            $("#errorMessage1").show();
            $("#errorMessage").show();
            $('#pswrd').val('');
        }
        else {
            $("#errorMessage").show();
            $("#errorMessage1").show();
        }
    });
});
