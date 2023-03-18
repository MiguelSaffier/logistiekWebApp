
// Get All
const klantenTableBody = document.querySelector('#klanten-table-body');
fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/klant/get_klanten')
    .then(response => response.json())
    .then(klanten => {
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
            klantenTableBody.appendChild(row);
        });
    })
    .catch(error => {
        console.error('Error fetching Klanten:', error);
        // alert('An error occurred while fetching the Klanten. Please try again later.');
    });


// Delete
klantenTableBody.addEventListener('click', event => {
    if (event.target.classList.contains('delete-btn')) {
        const id = event.target.dataset.id;
        fetch(`http://localhost:8080/logistiekWebApp_war_exploded/api/klant/remove/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                // alert(`Klant ${id} removed successfully!`);
                event.target.closest('tr').remove();
            })
            .catch(error => {
                console.error(`Error removing Klant ${id}:`, error);
                // alert(`An error occurred while removing Klant ${id}. Please try again later.`);
            });
    }
});

// add met form data werkt niet, ingevulde data is null


// Add
// const form = document.querySelector('#add-klant-form'); //werkt niet
// form.addEventListener('submit', event => {
//     event.preventDefault();
//     // const id = form.elements.id.value;
//     const firstName = form.elements.firstName.value;
//     const lastName = form.elements.lastName.value;
//     const address = form.elements.address.value;
//     const phoneNumber = form.elements.phoneNumber.value;
//     const klant = {firstName, lastName, address, phoneNumber};
//     fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/klant/add', {
//         method: 'POST',
//         headers: {'Content-Type': 'application/json'},
//         body: JSON.stringify(klant)
//     })
//         .then(response => response.json())
//         .then(newKlant => {
//             alert(`Klant ${newKlant.firstName} added successfully!`);
//             form.reset();
//         })
//         .catch(error => {
//             console.error('Error adding Klant:', error);
//             alert('An error occurred while adding the Klant. Please try again later.');
//             form.reset();
//         });
// });

// form.addEventListener('submit', event => {
//         let id = document.getElementById("firstName").value;
//         console.log(id);
//
//
//         const firstName = form.elements.firstName.value;
//         console.log(firstName);
//     })

//
// const form = document.querySelector('form');
//
// form.addEventListener('submit', (event) => {
//     event.preventDefault(); // prevent default form submission behavior
//
//     const formData = new FormData(form);
//
//     fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/klant/add', {
//         method: 'POST',
//         body: formData
//     })
//         .then(response => response.json())
//         .then(data => {
//             console.log('New Klant:', data);
//             // do something with the new Klant object (e.g. display it on the page)
//         })
//         .catch(error => {
//             console.error('Error:', error);
//             // handle error
//         });
// });

// function addKlant() {
//     // Get the form data
//     const firstName = document.getElementById("firstName").value;
//     const lastName = document.getElementById("lastName").value;
//     const address = document.getElementById("address").value;
//     const phoneNumber = document.getElementById("phoneNumber").value;
//
//     // Create a new HTTP request
//     const xhr = new XMLHttpRequest();
//     xhr.open("POST", "http://localhost:8080/logistiekWebApp_war_exploded/api/klant/add");
//     xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//
//     // Set up a callback function to handle the response
//     xhr.onload = function() {
//         if (xhr.status === 200) {
//             // Success - do something with the response data
//             const response = JSON.parse(xhr.responseText);
//             console.log(response);
//         } else {
//             // Error - handle it appropriately
//             console.error(xhr.statusText);
//         }
//     };
//
//     // Send the request with the form data
//     xhr.send(`firstName=${firstName}&lastName=${lastName}&address=${address}&phoneNumber=${phoneNumber}`);
// }

