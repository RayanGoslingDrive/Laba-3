"use strict";

function getData(){

    let Bands = new Object();
    Bands.Bandname = document.getElementById("Bandname").value;
    Bands.hometown= document.getElementById("hometown").value;
    Bands.genre = document.getElementById("genre").value;
    Bands.last_ablbum = document.getElementById("last_ablbum").value;
    Bands.Singer = document.getElementById("Singer").value;

    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/worldwide_war_exploded/lab2?data=" + encodeURIComponent(JSON.stringify(Bands)),
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