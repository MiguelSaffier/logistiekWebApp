
fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/product/get_producten')
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error(error);
    });