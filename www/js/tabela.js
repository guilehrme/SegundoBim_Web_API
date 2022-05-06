function getCalendario() {
    $.get("http://ergast.com/api/f1/2022/drivers.json", function (data, status) {
        debugger;

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

        var textC1 = document.createTextNode('Nome');
        var textC2 = document.createTextNode('Sigla');
        var textC3 = document.createTextNode('Número');
        var textC4 = document.createTextNode('Nacionalidade');

        th1.appendChild(textC1);
        th2.appendChild(textC2);
        th3.appendChild(textC3);
        th4.appendChild(textC4);

        trC1.appendChild(th1);
        trC1.appendChild(th2);
        trC1.appendChild(th3);
        trC1.appendChild(th4);

        thead.appendChild(trC1);


        table.appendChild(thead)

        numeroPilotos = data.MRData.DriverTable.Drivers.length;
        elementos = data.MRData.DriverTable.Drivers;

        var tbody = document.createElement('tbody');
        
        for (var i = 0; i < numeroPilotos; i++) {

            var tr = document.createElement('tr');

            var td1 = document.createElement('td');
            td1.classList.add('column1');
            var td2 = document.createElement('td');
            td2.classList.add('column2');
            var td3 = document.createElement('td');
            td3.classList.add('column3');
            var td4 = document.createElement('td');
            td4.classList.add('column4');

            var text1 = document.createTextNode(elementos[i].givenName);
            var text2 = document.createTextNode(elementos[i].code);
            var text3 = document.createTextNode(elementos[i].permanentNumber);
            var text4 = document.createTextNode(elementos[i].nationality);

            td1.appendChild(text1);
            td2.appendChild(text2);
            td3.appendChild(text3);
            td4.appendChild(text4);
            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);

            tbody.appendChild(tr);
        }

        table.appendChild(tbody);
    });

}