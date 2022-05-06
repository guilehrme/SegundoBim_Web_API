function getNews2() {
    var result;
        $.ajax({
            async: true,
            crossDomain: true,
            url: "https://google-search3.p.rapidapi.com/api/v1/news/q=formula1",
            method: "GET",
            headers: {
                "X-User-Agent": "desktop",
                "X-Proxy-Location": "BR",
                "X-RapidAPI-Host": "google-search3.p.rapidapi.com",
                "X-RapidAPI-Key": "a39569234bmsh8376c82a56146dfp129f0ejsnb8e937f990e5"
            },
            success: function (data) {
                $("#card1text").html(data.entries[0].title);
                $("#btnCard1").attr("href", data.entries[0].link)
                $("#card2text").html(data.entries[1].title);
                $("#btnCard2").attr("href", data.entries[1].link)
                $("#card3text").html(data.entries[2].title);
                $("#btnCard4").attr("href", data.entries[2].link)
            }
        });
    };