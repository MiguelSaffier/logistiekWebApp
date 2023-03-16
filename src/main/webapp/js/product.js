const img1 = document.getElementById("product1");
img1.src = "http://localhost:8080/logistiekWebApp_war_exploded/api/product/get_product_image/102";
img1.alt = "double washing sand";

function displayImageFromAPI(id) {
   return  fetch('http://localhost:8080/logistiekWebApp_war_exploded/api/product/get_product_image/'+id);
}


