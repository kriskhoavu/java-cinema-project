$.ajax ({
    url: "http://localhost:8080/api/movie/playing/false",
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
                        <img src="${elm.trailer}" alt="">
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
})
.fail(errs => {
    console.log(errs);
});