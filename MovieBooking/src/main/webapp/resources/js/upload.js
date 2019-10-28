Dropzone.autoDiscover = false;

$(document).ready(
    function() {

        var uploadUrl = $('#DropZoneUpload').data("upload");
        var loadUrl = $('#DropZoneUpload').data("load");

        $('#DropZoneUpload').dropzone({
            url: uploadUrl,
            addRemoveLinks: true,
            paramName: 'file',
            success: function(file, res) {
                var imgName = res.url;
                file.previewElement.classList.add("dz-success");
                $('#avatar').val(imgName);
                console.log(imgName);
            },
            error: function(file, err) {
                file.previewElement.classList.add("dz-error");
                console.log(err);
            },
            init: function() {
                var dropZone = this;

                $.ajax({
                    url: loadUrl,
                    dataType: 'JSON',
                    type: 'GET',
                    data: {
                        fileName: $('#avatar').val()
                    },
                    success: function(res) {
                        if (res) {
                            console.log(res);
                            var mockFile = {
                                name: res.name,
                                size: 1234567
                            };
                            dropZone.options.addedfile.call(
                                dropZone, mockFile);
                            dropZone.options.thumbnail.call(
                                dropZone, mockFile, res.url);
                            mockFile.previewElement.classList
                                .add("dz-success");
                            mockFile.previewElement.classList
                                .add("dz-complete");
                        }
                    },
                    error: function(err) {
                        console.log(err);
                    }
                });
            }
        });
    });