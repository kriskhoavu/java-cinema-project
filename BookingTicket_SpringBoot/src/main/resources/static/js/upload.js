$(document).ready(
    function () {
        $('#fileUpload').change((event) => {
            var files = event.target.files;
            var formData = new FormData();
            formData.append("file", files[0]);

            var path = "http://localhost:8080/" + $("#path").val();

            console.log(path);
            $.ajax({
                type: "POST",
                url: path,
                data: formData,
                contentType: false,
                processData: false,
                enctype: "multipart/form-data",
                success: function (data, status) {
                    console.log(data);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(errorThrown);
                }
            });
        });
    }
);