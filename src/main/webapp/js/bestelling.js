
const bestellingenTableBody = document.querySelector('#bestellingen-table-body');

// Get All
fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/klant/get_klanten')
    .then(response => response.json())
    .then(klanten => {
        // Loop through the list of Klant objects and add a row to the table for each one
        klanten.forEach(klant => {
            const row = document.createElement('tr');
            row.innerHTML = `
        <td>${klant.id}</td>
        <td>${klant.voornaam}</td>
        <td>${klant.achternaam}</td>
        <td>${klant.adres}</td>
        <td>${klant.telefoon}</td>
        <td>
            <button class="btn btn-warning btn-sm">Update</button>
            <button class="delete-btn btn btn-danger btn-sm" data-id="${klant.id}">Delete</button>
        </td>
      `;
            bestellingenTableBody.appendChild(row);
        });
    })
    .catch(error => {
        console.error('Error fetching Klanten:', error);
        alert('An error occurred while fetching the Klanten. Please try again later.');
    });


// Delete
klantenTableBody.addEventListener('click', event => {
    if (event.target.classList.contains('delete-btn')) {
        const id = event.target.dataset.id;
        fetch(`http://localhost:8080/logistiekWebApp_war_exploded/api/klant/remove/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert(`Klant ${id} removed successfully!`);
                event.target.closest('tr').remove(); // Remove the row from the table
            })
            .catch(error => {
                console.error(`Error removing Klant ${id}:`, error);
                alert(`An error occurred while removing Klant ${id}. Please try again later.`);
            });
    }
});


// Add
const form = document.querySelector('#add-klant-form'); //werkt niet
form.addEventListener('submit', event => {
    event.preventDefault(); // Prevent the form from submitting normally
    // const id = form.elements.id.value;
    const firstName = form.elements.firstName.value;
    const lastName = form.elements.lastName.value;
    const address = form.elements.address.value;
    const phoneNumber = form.elements.phoneNumber.value;
    const klant = {firstName, lastName, address, phoneNumber}; // Create a Klant object from the form data
    fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/klant/add', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(klant) // Send the Klant object as JSON in the request body
    })
        .then(response => response.json())
        .then(newKlant => {
            alert(`Klant ${newKlant.firstName} added successfully!`);
            form.reset(); // Reset the form
        })
        .catch(error => {
            console.error('Error adding Klant:', error);
            alert('An error occurred while adding the Klant. Please try again later.');
        });
});