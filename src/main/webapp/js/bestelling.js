
const bestellingenTableBody = document.querySelector('#bestellingen-table-body');

// Get All, data is undefined
fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/bestelling/get_bestellingen')
    .then(response => response.json())
    .then(bestellingen => {
        // console.log(JSON.stringify(bestellingen));
        bestellingen.forEach(bestelling => {
            // console.log(bestelling);                            //krijg wel data, maar hoe toon ik het?
            const row = document.createElement('tr');   //bestelling.id, etc werkt niet
            row.innerHTML = `
        <td>${bestelling.id}</td>
        <td>${bestelling.bestellingDatum}</td>
        <td>${bestelling.id}</td>
        <td>${bestelling.voornaam}</td>
        <td>${bestelling.achternaam}</td>
        <td>${bestelling.leveringDatum}</td>
        <td>${bestelling.telefoon}</td>
        <td>
            <button class="btn btn-warning btn-sm">Update</button>
            <button class="delete-btn btn btn-danger btn-sm" data-id="${bestelling.id}">Delete</button>
        </td>
      `;
            bestellingenTableBody.appendChild(row);
        });
    })
    .catch(error => {
        console.error('Error fetching Bestellingen:', error);
        // alert('An error occurred while fetching the Bestellingen. Please try again later.');
    });


// Delete
bestellingenTableBody.addEventListener('click', event => {
    if (event.target.classList.contains('delete-btn')) {
        const id = event.target.dataset.id;
        fetch(`http://localhost:8080/logistiekWebApp_war_exploded/api/bestelling/remove/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                // alert(`Bestelling ${id} removed successfully!`);
                event.target.closest('tr').remove();
            })
            .catch(error => {
                console.error(`Error removing Bestelling ${id}:`, error);
                // alert(`An error occurred while removing Bestelling ${id}. Please try again later.`);
            });
    }
});


// Add
// const form = document.querySelector('#add-bestelling-form'); //werkt niet
// form.addEventListener('submit', event => {
//     event.preventDefault();
//     const id = form.elements.id.value;
//     const year = form.elements.year.value;
//     const month = form.elements.month.value;
//     const day = form.elements.day.value;
//     const bestelling = {id, year, month, day};
//     fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/bestelling/add', {
//         method: 'POST',
//         headers: {'Content-Type': 'application/json'},
//         body: JSON.stringify(bestelling)
//     })
//         .then(response => response.json())
//         .then(newBestelling => {
//             alert(`Klant ${newBestelling.id} added successfully!`);
//             form.reset(); // Reset the form
//         })
//         .catch(error => {
//             console.error('Error adding Bestelling:', error);
//             alert('An error occurred while adding the Bestelling. Please try again later.');
//         });
// });