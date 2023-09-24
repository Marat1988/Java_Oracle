"use strict";


function getInformation(){
    fetch("/getInfo", {
        method: "POST"
    })
        .then(response => response.json())
        .then(response => {
            let information = document.getElementById("information");
            information.innerText = JSON.stringify(response);
        })
        .catch(reason => alert('Ошибка при получении данных ' + reason));
}