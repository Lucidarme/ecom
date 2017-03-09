var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        myFunction(this);
    }
};
xhttp.open("GET", "rest/evenements", true);
xhttp.send();

function myFunction(xml) {
    var xmlDoc = xml.responseXML;
    

    for(i = 0; i < xmlDoc.getElementsByTagName("name").length; i++){
        duplicate(i,
                xmlDoc.getElementsByTagName("id")[i].childNodes[0].nodeValue,
                xmlDoc.getElementsByTagName("name")[i].childNodes[0].nodeValue,
                xmlDoc.getElementsByTagName("imageLink")[i].childNodes[0].nodeValue,
                xmlDoc.getElementsByTagName("price")[i].childNodes[0].nodeValue,
                xmlDoc.getElementsByTagName("description")[i].childNodes[0].nodeValue
                );
        /*var s = "product" + i;
        document.getElementById(s).innerHTML =
        xmlDoc.getElementsByTagName("name")[i].childNodes[0].nodeValue;*/

    }

}


function duplicate(i, id, name, imageLink, price, description) {
    /*var original = document.getElementById('event' + i);
    var clone = original.cloneNode(true); // "deep" clone
    clone.id = "event" + ++i; // there can only be one element with an ID
    clone.onclick = duplicate; // event handlers are not cloned
    original.parentNode.appendChild(clone);*/
    var div = document.createElement('div');
    div.id = 'event' + i;
    div.className = "col-sm-4 col-lg-4 col-md-4";
    var div2 = document.createElement('div');
    div2.className = "thumbnail";
    var img = document.createElement('img');
    img.src=imageLink;
    img.alt="";
    var div3 = document.createElement('div');
    div3.className = "caption";
    var h4_1 = document.createElement('h4');
    h4_1.className = "pull-right";
    if(price === "0.0")
        h4_1.textContent = "Gratuit";
    else
        h4_1.textContent = price + "€";
    div3.appendChild(h4_1);
    var h4_2 = document.createElement('h4');
    var a_1 = document.createElement('a');
    a_1.href = "item.html?eventid=" + id;
    a_1.id="product" + i;
    a_1.textContent=name;
    h4_2.appendChild(a_1);
    div3.appendChild(h4_2);
    var p_1 = document.createElement('p');
    p_1.textContent = description;
    div3.appendChild(p_1);
    
    var div4 = document.createElement('div');
    div4.className = "ratings";
    var p_2 = document.createElement('p');
    p_2.className ="pull-right";
    p_2.textContent = "15 reviews";
    div4.appendChild(p_2);
    var p_3 = document.createElement('p');
    var span1 = document.createElement('span');
    span1.className ="glyphicon glyphicon-star";
    p_3.appendChild(span1);
    var span2 = document.createElement('span');
    span2.className ="glyphicon glyphicon-star";
    p_3.appendChild(span2);
    var span3 = document.createElement('span');
    span3.className ="glyphicon glyphicon-star";
    p_3.appendChild(span3);
    var span4 = document.createElement('span');
    span4.className ="glyphicon glyphicon-star";
    p_3.appendChild(span4);
    var span5 = document.createElement('span');
    span5.className ="glyphicon glyphicon-star";
    p_3.appendChild(span5);
    
    div4.appendChild(p_3);

    div2.appendChild(img);
    div2.appendChild(div3);
    div2.appendChild(div4);
    div.appendChild(div2);
    var eventRoot = document.getElementById('eventsContainer');
    eventRoot.appendChild(div);
}
