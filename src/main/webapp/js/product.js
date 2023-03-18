// const img1 = document.getElementById("product1");
// img1.src = "http://localhost:8080/logistiekWebApp_war_exploded/api/product/get_product_image/102";
// img1.alt = "double washing sand";
//
// function displayImageFromAPI(id) {
//    return  fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/product/get_product_image/'+id);
// }


const productenTableBody = document.querySelector('#producten-table-body');

// Get All
fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/product/get_producten')
    .then(response => response.json())
    .then(producten => {
       producten.forEach(product => {
          const row = document.createElement('tr');
          row.innerHTML = `
        <td>${product.id}</td>
        <td>${product.naam}</td>
        <td>${product.prijs}</td>
        <td>${product.adres}</td>
        <td>
            <button class="btn btn-warning btn-sm">Update</button>
            <button class="delete-btn btn btn-danger btn-sm" data-id="${product.id}">Delete</button>
        </td>
      `;
          productenTableBody.appendChild(row);
       });
    })
    .catch(error => {
       console.error('Error fetching Producten:', error);
       // alert('An error occurred while fetching the Producten. Please try again later.');
    });


// Delete
productenTableBody.addEventListener('click', event => {
   if (event.target.classList.contains('delete-btn')) {
      const id = event.target.dataset.id;
      fetch(`http://localhost:8080/logistiekWebApp_war_exploded/api/product/remove/${id}`, {
         method: 'DELETE'
      })
          .then(() => {
             // alert(`Product ${id} removed successfully!`);
             event.target.closest('tr').remove();
          })
          .catch(error => {
             console.error(`Error removing Product ${id}:`, error);
             // alert(`An error occurred while removing Product ${id}. Please try again later.`);
          });
   }
});
