$('#btnLogin').click(function () {
    var email = $('#lgEmail').val();
    var pass = $('#lgPassword').val();
    var data = JSON.stringify({
        email: email,
        password: pass
    });
    console.log(JSON.stringify(data));
    $.ajax({
        url: "http://localhost:8082/login",
        type: 'POST',
        contentType: "application/json",
        data: data
    }).done(res => {
            localStorage.setItem('TOKEN', res);
            location.reload();
    }).fail(errs => {
        alert(errs);
    });
});