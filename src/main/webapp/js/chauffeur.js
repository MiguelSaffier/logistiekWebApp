
const chauffeurTableBody = document.querySelector('#chauffeur-table-body');

// Get All
fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/chauffeur/get_chauffeurs')
    .then(response => response.json())
    .then(chauffeurs => {
        chauffeurs.forEach(chauffeur => {
            const row = document.createElement('tr');
            row.innerHTML = `
        <td>${chauffeur.id}</td>
        <td>${chauffeur.voornaam}</td>
        <td>${chauffeur.achternaam}</td>
        <td>${chauffeur.telefoon}</td>
        <td>
            <button class="btn btn-warning btn-sm">Update</button>
            <button class="delete-btn btn btn-danger btn-sm" data-id="${chauffeur.id}">Delete</button>
        </td>
      `;
            chauffeurTableBody.appendChild(row);
        });
    })
    .catch(error => {
        console.error('Error fetching Chauffeurs:', error);
        // alert('An error occurred while fetching the Chauffeurs. Please try again later.');
    });

// Delete
chauffeurTableBody.addEventListener('click', event => {
    if (event.target.classList.contains('delete-btn')) {
        const id = event.target.dataset.id;
        fetch(`http://localhost:8080/logistiekWebApp_war_exploded/api/chauffeur/remove/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                // alert(`Chauffeur ${id} removed successfully!`);
                event.target.closest('tr').remove();
            })
            .catch(error => {
                console.error(`Error removing Chauffeur ${id}:`, error);
                // alert(`An error occurred while removing Chauffeur ${id}. Please try again later.`);
            });
    }
});