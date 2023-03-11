
fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/chauffeur/get_chauffeurs')
    .then(response => response.json())
    .then(data => {
        const items = data.items;
        const list = document.createElement('ul');
        items.forEach(item => {
            const listItem = document.createElement('li');
            listItem.textContent = item.name;
            list.appendChild(listItem);
        });
        document.getElementById('container').appendChild(list);
    })
    .catch(error => console.error(error));

async function getChauffeur(){
    const repsonse = await fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/chauffeur/get_chauffeurs');
    const list = repsonse.json();
}

let chauffeurList;

function loadChauffeurList() {
    const CHAUFFEUR_URL_LIST = 'http://localhost:8080/logistiekWebApp_war_exploded/api/chauffeur/get_chauffeurs';

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let chauffeurDataList = JSON.parse(this.responseText);
            chauffeurList = '';
            for (let index = 0; index < chauffeurDataList.length; index++) {
                chauffeurList +=

                    '<table>' +
                    '<tr>' +
                    '<td>' + chauffeurDataList[index].voornaam + '</td>' +
                    '<td>' + chauffeurDataList[index].achternaam + '</td>' +
                    '</tr>' +
                    '</table>';
            }
            document.getElementById('chauffeurData').innerHTML = chauffeurList;
        }
    };
    xhttp.open('GET', CHAUFFEUR_URL_LIST, true);
    xhttp.send();
}