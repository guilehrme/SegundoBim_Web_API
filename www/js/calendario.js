function getCalendario() {
    $.get("http://ergast.com/api/f1/current.json", function (data, status) {
        var d = new Date();
        d.toString()

        var table = document.getElementById("tabelaResultado");
        var thead = document.createElement('thead');
        var trC1 = document.createElement('tr');
        trC1.classList.add('table100-head');

        var th1 = document.createElement('th');
        th1.classList.add('column1');
        var th2 = document.createElement('th');
        th2.classList.add('column2');
        var th3 = document.createElement('th');
        th3.classList.add('column3');
        var th4 = document.createElement('th');
        th4.classList.add('column4');
        var th5 = document.createElement('th');
        th5.classList.add('column4');

        var textC1 = document.createTextNode('#');
        var textC2 = document.createTextNode('Nome');
        var textC3 = document.createTextNode('Local');
        var textC4 = document.createTextNode('Data');
        var textC5 = document.createTextNode('Clima');

        th1.appendChild(textC1);
        th2.appendChild(textC2);
        th3.appendChild(textC3);
        th4.appendChild(textC4);
        th5.appendChild(textC5);

        trC1.appendChild(th1);
        trC1.appendChild(th2);
        trC1.appendChild(th3);
        trC1.appendChild(th4);
        trC1.appendChild(th5);

        thead.appendChild(trC1);


        table.appendChild(thead)

        numeroCorridas = data.MRData.RaceTable.Races.length;
        elementos = data.MRData.RaceTable.Races;

        var tbody = document.createElement('tbody');
        var getClimabool = false;
        var clima = true;;

        for (var i = 0; i < numeroCorridas; i++) {

            var d1 = new Date();
            var d2 = new Date(elementos[i].date);

            if (clima) {
                if (d1 < d2) {
                    getClimabool = true;
                    clima = false;
                }
            }

            var text1 = document.createTextNode(i + 1);
            var text2 = document.createTextNode(elementos[i].raceName);
            var text3 = document.createTextNode(elementos[i].Circuit.Location.locality + ' - ' + elementos[i].Circuit.Location.country);
            var text4 = document.createTextNode(elementos[i].date + ' - ' + elementos[i].time);
            var text5 = document.createTextNode(" - ");
            if (getClimabool) {
                var lat = parseInt(elementos[i].Circuit.Location.lat)
                var lon = parseInt(elementos[i].Circuit.Location.long);
                var cli = getClima(lat, lon)
                text5 = document.createTextNode(cli);
                getClimabool = false;
            }
            debugger;
            td1.appendChild(text1);
            td2.appendChild(text2);
            td3.appendChild(text3);
            td4.appendChild(text4);
            td5.appendChild(text5);
            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
            tr.appendChild(td5);

            $(tr).data('lat', elementos[i].Circuit.Location.lat);
            $(tr).data('long', elementos[i].Circuit.Location.long);

            tr.onclick = function (event) {
                getMap($(this).data('lat'),$(this).data('long'));
            };

            tbody.appendChild(tr);
        }

        table.appendChild(tbody);
    });

};

function getClima(lat, lon) {
    var retorno;
    $.ajax({
        url: "https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon + "&exclude=hourly,minutely&appid=dd8d3a7c77fdcdad9eaf718daec79567&units=metric",
        type: 'get',
        dataType: 'html',
        async: false,
        success: function (data) {
            result = data;
        }
    });
    retorno = JSON.parse(result);
    var tempMin = retorno.daily[0].temp.min;
    var tempMax = retorno.daily[0].temp.max;

    return String(retorno.daily[0].weather[0].description + " - Min Temp: " + parseInt(tempMin) + " / Max Temp: " + parseInt(tempMax));
};

function getMap(lat, lon) {
    	
    $( "#map" ).html('');
    var map = new ol.Map({
        target: 'map',
        layers: [
          new ol.layer.Tile({
            source: new ol.source.OSM()
          })
        ],
        view: new ol.View({
          center: ol.proj.fromLonLat([lon, lat]),
          zoom: 4
        })
      });
};