"use strict";

function output() {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/worldwide_war_exploded/lab?",
        contentType: "application/json",
        success: function(response) {
            let str = response;
            go(str);
        },
        error: function(xhr, status, error) {
            console.log(error);
        }
    });
}

function go(str) {
    let tableData = JSON.parse(str);

    let tableHeader = "<tr><th>name</th><th>lastname</th><th>middlename</th><th>age</th><th>language</th></tr>";

    let tableRows = "";
    for (let i = 0; i < tableData.length; i++) {
        let row = tableData[i];
        tableRows += "<tr>";
        tableRows += "<td>" + row[0] + "</td>";
        tableRows += "<td>" + row[1] + "</td>";
        tableRows += "<td>" + row[2] + "</td>";
        tableRows += "<td>" + row[3] + "</td>";
        tableRows += "<td>" + row[4] + "</td>";
        tableRows += "</tr>";
    }

    document.getElementById("output").innerHTML = "<table>" + tableHeader + tableRows + "</table>";
}