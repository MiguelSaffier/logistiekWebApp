
// Get All  werkt wel maar data is undefined
const leveringenTableBody = document.querySelector('#leveringen-table-body');
fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/levering/get_leveringen')
    .then(response => response.json())
    .then(leveringen => {
        leveringen.forEach(levering => {
            const row = document.createElement('tr');
            row.innerHTML = `
        <td>${levering.id}</td>
        <td>${levering.status}</td>
        <td>${levering.totaleKosten}</td>
        <td>${levering.bestellingid}</td>
        <td>
            <button class="btn btn-warning btn-sm">Update</button>
            <button class="delete-btn btn btn-danger btn-sm" data-id="${levering.id}">Delete</button>
        </td>
      `;
            leveringenTableBody.appendChild(row);
        });
    })
    .catch(error => {
        console.error('Error fetching Levering:', error);
        // alert('An error occurred while fetching the Levering. Please try again later.');
    });

// Delete
leveringenTableBody.addEventListener('click', event => {
    if (event.target.classList.contains('delete-btn')) {
        const id = event.target.dataset.id;
        fetch(`http://localhost:8080/logistiekWebApp_war_exploded/api/levering/remove/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                // alert(`Levering ${id} removed successfully!`);
                event.target.closest('tr').remove();
            })
            .catch(error => {
                console.error(`Error removing Levering ${id}:`, error);
                // alert(`An error occurred while removing Levering ${id}. Please try again later.`);
            });
    }
});



//Add   //werkt wel maar create button freezed
const form = document.querySelector('#levering-form');
const idField = document.querySelector('#bestellingId');

form.addEventListener('submit', (event) => {
    event.preventDefault();
    const id = idField.value;

    fetch(`http://localhost:8080/logistiekWebApp_war_exploded/api/levering/add/${id}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id: id })
    })
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.error(error));
});
