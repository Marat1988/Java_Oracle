"use strict";

function buy() {
    event.preventDefault();
    const data = new FormData(event.target);
    fetch("/product/buy", {
        method: "POST",
        body: data
    })
        .then(response => response.json())
        .then(response => {
            let countProduct = response.quantity;
            let recyclerLink = document.getElementById("userRecycler");
            recyclerLink.innerText = "Корзина (" + countProduct + ")";
            console.log(recyclerLink);
        })
}