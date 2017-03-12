
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {//Call a function when the state changes.
    if(xhttp.readyState === 4 && xhttp.status === 200) {
        alert(xhttp.responseText);
        MyFunction(this);
    }
    else{
        console.log(xhttp.readState + " " + xhttp.status);
    }
}
var url = "http://localhost:8080/ecom/rest/user";
var name = document.getElementById("name").value;
var password = document.getElementById("password").value;
var params = "name="+name+"&password="+password;
xhttp.open("POST", url);

//Send the proper header information along with the request
xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhttp.send(params);
console.log("params = " + params);

function myFunction(xml) {
    console.log(xml);
}
