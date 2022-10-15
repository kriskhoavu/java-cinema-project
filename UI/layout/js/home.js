$.ajax({
        url: "http://localhost:8080/api/movie/playing/true",
        type: "GET",
        dataType: "JSON",
        headers: {
            'Authorization': 'Bearer ' + localStorage.getItem("TOKEN"),
            'Content-Type': 'application/json'
        }
    })
    .done(data => {
        let content = "";
        $.each(data, function (idx, elm) {
            content += `
        <div class="col-md-3 mb-2">
            <div class="movie">
                <div class="img-box">
                    <img class="w-100"
                        src="${elm.image}"
                        alt="">
                    <div class="overlay"></div>
                    <a href="#" data-video-id="pFSQh_5QE40" class="btn-play">
                        <img src="" alt="">
                        <p>TRAILER</p>
                    </a>
                </div>
                <a href="#" class="movie-title">
                    <h5>${elm.name}</h5>
                </a>
            </div>
        </div>
        `;
        });
        $('#upcoming_movie').html(content);

        let loginInfo = `
            <div class="dropdown">
                <button type="button" class="btn btn-outline-primary dropdown-toggle" data-toggle="dropdown">
                    Welcome o.O!
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Đặt vé</a> 
                    <a class="dropdown-item" href="#" onclick="logout();">Đăng xuất</a>
                </div>
            </div>`;

        $('#loginModalId').html(loginInfo);
    })
    .fail(errs => {
        console.log(errs);
    });

function logout() {
    $.ajax({
        url: "http://localhost:8080/auth/logout",
        type: 'POST',
        contentType: "application/json"
    }).done(res => {
        localStorage.setItem('TOKEN', "");
        location.reload();
    }).fail(errs => {
        alert(errs);
    });
}