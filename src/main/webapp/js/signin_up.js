
// var firstNamew = "John";
// var lastNamew = "Doe";
// var addressw = "123 Main St";
// var phoneNumberw = "555-1234";

// var firstNameInputw = document.getElementById("firstNamep");
// var lastNameInputw = document.getElementById("lastNamep");
// var addressInputw = document.getElementById("adresp");
// var phoneNumberInputw = document.getElementById("phoneNumberp");

// firstNameInputw.value = firstNamew;
// lastNameInputw.value = lastNamew;
// addressInputw.value = addressw;
// phoneNumberInputw.value = phoneNumberw;

// let firstNameInput = document.getElementById("firstNamep");
// let lastNameInput = document.getElementById("lastNamep");                    //Dit is afhankelijk van inlog gegevens
// let addressInput = document.getElementById("adresp");                        //maar in log gegevens zijn onderaan
// let phoneNumberInput = document.getElementById("phoneNumberp");              //maar als ik dit gedeelte onderaan zet
//                                                                              //WERKT HET NIETTTT
// firstNameInput.value = firstName;
// lastNameInput.value = lastName;
// addressInput.value = address;
// phoneNumberInput.value = phoneNumber;


const klantSearchForm = document.querySelector('#klant-search-form');

klantSearchForm.addEventListener('submit', event => {
    event.preventDefault(); // Prevent the default form submission behavior

    const firstNameInput = document.querySelector('#first-name-input');
    const lastNameInput = document.querySelector('#last-name-input');

    const firstName = firstNameInput.value.trim();
    const lastName = lastNameInput.value.trim();

    if (!firstName || !lastName) {
        alert('Please enter both first and last name to search for a Klant.');
        return;
    }

    if (firstName === "admin" && lastName === "admin") {
        window.location.href = "admin.html";
    } else {
    fetch(`http://localhost:8080/logistiekWebApp_war_exploded/api/klant/findByName?firstName=${encodeURIComponent(firstName)}&lastName=${encodeURIComponent(lastName)}`)
        .then(response => {
            if (response.status === 404) {
                alert(`No Klant found with first name '${firstName}' and last name '${lastName}'.`);
            } else if (response.ok) {
                return response.json();
            } else {
                throw new Error('An error occurred while searching for the Klant.');
            }
        })
        .then(klant => {
            if (klant) {
                window.location.href = "profile.html";
            }
        })
        .catch(error => {
            console.error('Error searching for Klant:', error);
            alert('An error occurred while searching for the Klant. Please try again later.');
        });

    }
});



