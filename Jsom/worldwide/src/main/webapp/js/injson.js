"use strict";

function req(){

    let Users = new Object();
    Users.name = document.getElementById("Bandname").value;
    Users.lastname = document.getElementById("hometown").value;
    Users.middlename = document.getElementById("genre").value;
    Users.age = document.getElementById("last_ablbum").value;
    Users.language = document.getElementById("Singer").value;

    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/worldwide_war_exploded/lab2?data=" + encodeURIComponent(JSON.stringify(Users)),
        success: function() {
            console.log('Данные успешно отправлены!');
        },
        error: function() {
            console.log('Произошла ошибка при отправке данных.');
        }
    });

    let inputs = document.getElementsByTagName("input");
    for (let i = 0; i < inputs.length; i++) {
        inputs[i].value = "";
    }
}