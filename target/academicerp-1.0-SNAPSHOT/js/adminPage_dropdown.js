function Get(yourUrl){
    let Httpreq = new XMLHttpRequest(); // a new request
    Httpreq.open("GET",yourUrl,false);
    Httpreq.send(null);
    return JSON.parse(Httpreq.responseText);
}

function populate_domain()
{
    console.log("Entered popluate");
    let ul = document.getElementById("dropdown_Domain");
    let arr= Get("api/buttonsdynamically/get/domains");
    if(ul===null)
        alert("empty object retrieved from DOM parse");
    if( ul.length>1) {
        //alert("Domains already exist in under the domain button, no need to again add them");
        return "";
    }
    // for (let i = 0; i < arr.length; i++) {
    //     let option = document.createElement("li"), txt = document.createTextNode(arr[i]);
    //     option.appendChild(txt);
    //     option.setAttribute("value", arr[i]);
    //     select.insertBefore(option, select.lastChild);
    // }
    ul.innerHTML = "";
    for (let i = 0; i < arr.length; i++) {
        let li = document.createElement('li');
        li.appendChild(document.createTextNode(arr[i]));
        ul.appendChild(li);
        console.log(li)
    }
}