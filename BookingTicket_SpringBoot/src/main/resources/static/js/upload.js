$(document).ready(
    function () {
        $('#fileUpload').change((event) => {
            var files = event.target.files;

            var formData = new FormData();
            formData.append(file, files[0]);

            var path = $("#path").val();
        });
    }
);