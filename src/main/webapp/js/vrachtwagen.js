
const vrachtwagenTableBody = document.querySelector('#vrachtwagen-table-body');

// Get All
fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/vrachtwagen/get_vrachtwagen')
    .then(response => response.json())
    .then(vrachtwagen => {
        vrachtwagen.forEach(voertuig => {
            const row = document.createElement('tr');
            row.innerHTML = `
        <td>${voertuig.id}</td>
        <td>${voertuig.merk}</td>
        <td>${voertuig.kentekenNummer}</td>
        <td>${voertuig.capaciteit}</td>
        <td>
            <button class="btn btn-warning btn-sm">Update</button>
            <button class="delete-btn btn btn-danger btn-sm" data-id="${voertuig.id}">Delete</button>
        </td>
      `;
            vrachtwagenTableBody.appendChild(row);
        });
    })
    .catch(error => {
        console.error('Error fetching Vrachtwagen:', error);
        // alert('An error occurred while fetching the Vrachtwagen. Please try again later.');
    });


// Delete
vrachtwagenTableBody.addEventListener('click', event => {
    if (event.target.classList.contains('delete-btn')) {
        const id = event.target.dataset.id;
        fetch(`http://localhost:8080/logistiekWebApp_war_exploded/api/vrachtwagen/remove/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                // alert(`Vrachtwagen ${id} removed successfully!`);
                event.target.closest('tr').remove();
            })
            .catch(error => {
                console.error(`Error removing Vrachtwagen ${id}:`, error);
                // alert(`An error occurred while removing Vrachtwagen ${id}. Please try again later.`);
            });
    }
});