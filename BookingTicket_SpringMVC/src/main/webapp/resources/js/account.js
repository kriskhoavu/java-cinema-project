$(function() {
//    $.ajax({
//        url: $('#roleApi').val(),
//        type: 'GET',
//        dataType: 'JSON',
//        success: function(data) {
//            // Khai báo chuỗi chứa các option
//            var html = '';
//            data.forEach(function(role, index) {
//                html += `<option value="${role.id}">${role.description}</option>`;
//            });
//            $('#reg_roleId').html(html);
//        },
//        error: function(err) {
//            console.log(err);
//        }
//    });

    $('#fileUpload').change(function(e){
    	var files = e.target.files;
    	var formData = new FormData();
    	formData.append("file", files[0]);
    	
    	var path = $('#path').val();
        $.ajax({
            url: path,
            type: 'POST',
            data: formData,
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            success: function(res) {
            	var imgName = $('#url').val() + res.url;
            	$('#avatar').attr('src', imgName);
            },
            error: function(err) {
                console.log(err);
            }
        });
    });
    
    $('#frmLogin').submit(function() {
        console.log($(this).attr('action'));
        $.ajax({
            url: $(this).attr('action'),
            type: $(this).attr('method'),
            data: $(this).serialize(),
            success: function(res) {
                console.log(res);
                if (res) {
                     location.reload();
                } else {
                    swal({
                        title: "Thông báo!",
                        text: "Sai tên đăng nhập hoặc mật khẩu!",
                        icon: "error",
                        button: "Đóng",
                    });
                }
            },
            error: function(err) {
                alert(err);
            }
        });

        return false;
    });
});

// Khi bàn phím được nhấn và thả ra
// thì sẽ chạy phương thức này
$("#frmRegister").validate({
    rules: {
        fullname: {
            required: true,
            minlength: 4
        },
        email: {
            required: true,
            email: true
        },
        password: {
            required: true,
            minlength: 6
        },
        confirm: {
            equalTo: "#reg_password"
        }
    },
    messages: {
        fullname: {
            required: "Vui lòng nhập họ tên!",
            minlength: "Họ tên ít nhất 4 ký tự!"
        },
        email: {
            required: "Vui lòng nhập email!",
            email: "Email không đúng định dạng!"
        },
        password: {
            required: 'Vui lòng nhập mật khẩu',
            minlength: 'Vui lòng nhập ít nhất 6 kí tự'
        },
        confirm: {
            equalTo: 'Mật khẩu nhập không khớp!'
        }
    },
    // Nếu ko có lỗi nhập liệu thì chạy code của hàm này
    submitHandler: function(form, event) {
        event.preventDefault();
        var obj = {
            fullname: $('#reg_fullname').val(),
            email: $('#reg_email').val(),
            password: $('#reg_password').val(),
            confirm: $('#reg_confirm').val(),
            roleId: $('#reg_roleId').val()
        }

        $.ajax({
            url: $(form).attr('action'),
            type: $(form).attr('method'),
            data: JSON.stringify(obj),
            contentType: 'application/json',
            dataType: 'json',
            success: function(data) {
                console.log(data);
                if (data.success === 'true') {
                    swal({
                        title: "Thông báo!",
                        text: data.message,
                        icon: "success",
                        button: "Đóng",
                    });
                    $("#registerModal").modal('hide');
                } else {
                    swal({
                        title: "Thông báo!",
                        text: data.message,
                        icon: "error",
                        button: "Đóng",
                    });
                }
            },
            error: function(err) {
                console.log(err);
            }
        });
    }
});