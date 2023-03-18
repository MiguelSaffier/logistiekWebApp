// Get All
const recordTableBody = document.querySelector('#voertuigchauffeur-table-body');
fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/voertuigchauffeur/get_voertuig_chauffeur_detail')
    .then(response => response.json())
    .then(records => {
        records.forEach(record => {
            const row = document.createElement('tr');
            row.innerHTML = `
        <td>${record.id}</td>
        <td>${record.leveringId}</td>
        <td>${record.status}</td>
        <td>${record.totaleKosten}</td>
        <td>${record.bestellingId}</td>
        <td>${record.chauffeurId}</td>
        <td>${record.voornaam}</td>
        <td>${record.achternaam}</td>
        <td>${record.voertuigId}</td>
        <td>${record.merk}</td>
        <td>${record.kentekenNummer}</td>
        <td>${record.capaciteit}</td>
        <td>${record.leveringsKosten}</td>
        <td>
            <button class="btn btn-warning btn-sm">Update</button>
        </td>
      `;
            recordTableBody.appendChild(row);
        });
    })
    .catch(error => {
        console.error('Error fetching Records:', error);
    });

