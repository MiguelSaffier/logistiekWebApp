
// Get All
const recordTableBody = document.querySelector('#bestellingproduct-table-body');
fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/bestellingproduct/get_bestelling_detail')
    .then(response => response.json())
    .then(records => {
        records.forEach(record => {
            const row = document.createElement('tr');
            row.innerHTML = `
        <td>${record.id}</td>
        <td>${record.bestellingDatum}</td>
        <td>${record.voornaam}</td>
        <td>${record.achternaam}</td>
        <td>${record.bestelligId}</td>
        <td>${record.leveringDatum}</td>
        <td>${record.product}</td>
        <td>${record.amount}</td>
        <td>
            <button class="btn btn-warning btn-sm">Update</button>
        </td>
      `;
            recordTableBody.appendChild(row);
        });
    })
    .catch(error => {
        console.error('Error fetching Records:', error);
        // alert('An error occurred while fetching the Records. Please try again later.');
    });
