

//fetching json array of objects for all URIs
function Get(yourUrl){
    let Httpreq = new XMLHttpRequest(); // a new request
    Httpreq.open("GET",yourUrl,false);
    Httpreq.send(null);
    return JSON.parse(Httpreq.responseText);
}

// populating domain drop down button dynamically using the values fetched from database
function populate_domain_dropdown_by_query()
{
    let select = document.getElementById("Select Domain");
    let arr= Get("api/buttonsdynamically/get/domains");
    if(select===null)
        alert("empty object retrieved from DOM parse");
    if( select.length>1) {
        //alert("Domains already exist in under the domain button, no need to again add them");
        return "";
    }
    for (let i = 0; i < arr.length; i++) {
        let option = document.createElement("OPTION"), txt = document.createTextNode(arr[i]);
        option.appendChild(txt);
        option.setAttribute("value", arr[i]);
        select.insertBefore(option, select.lastChild);
    }
}

// populating domain year down button dynamically using the values fetched from database
function populate_year_dropdown_by_query()
{
    let select = document.getElementById("Select Academic Year");
    let arr= Get("api/buttonsdynamically/get/years");
    if(select===null)
        alert("empty object retrieved from DOM parse");
    if( select.length>1) {
        //alert("year already exist in under the domain button, no need to again add them");
        return "";
    }

    for (let i = 0; i < arr.length; i++) {
        let option = document.createElement("OPTION"), txt = document.createTextNode(arr[i]);
        option.appendChild(txt);
        option.setAttribute("value", arr[i]);
        select.insertBefore(option, select.lastChild);
    }
}
// populating domain faculty down button dynamically using the values fetched from database
function populate_faculty_dropdown_by_query()
{
    let select = document.getElementById("Select Faculty");
    let arr= Get("api/buttonsdynamically/get/faculty");
    if(select===null)
        alert("empty object retrieved from DOM parse");
    if( select.length>1) {
        //alert("faculty already exist in under the domain button, no need to again add them");
        return "";
    }
    for (let i = 0; i < arr.length; i++) {
        let option = document.createElement("OPTION"), txt = document.createTextNode(arr[i]);
        option.appendChild(txt);
        option.setAttribute("value", arr[i]);
        select.insertBefore(option, select.lastChild);
    }
}

// populating domain capacity down button dynamically using the values fetched from database
function populate_capacity_dropdown_by_query()
{
    let select = document.getElementById("Select Capacity");
    let arr= Get("api/buttonsdynamically/get/capacity");
    if(select===null)
        alert("empty object retrieved from DOM parse");
    if( select.length>1) {
        //alert("capacities already exist in under the domain button, no need to again add them");
        return "";
    }
    for (let i = 0; i < arr.length; i++) {
        let option = document.createElement("OPTION"), txt = document.createTextNode(arr[i]);
        option.appendChild(txt);
        option.setAttribute("value", arr[i]);
        select.insertBefore(option, select.lastChild);
    }
}

// populating domain specialization down button dynamically using the values fetched from database
function populate_specialization_dropdown_by_query()
{
    let select = document.getElementById("Select Specialization");
    let arr= Get("api/buttonsdynamically/get/specialization");
    if(select===null)
        alert("empty object retrieved from DOM parse");
    if( select.length>1) {
        //alert("Specialization already exist in under the domain button, no need to again add them");
        return "";
    }
    for (let i = 0; i < arr.length; i++) {
        let option = document.createElement("OPTION"), txt = document.createTextNode(arr[i]);
        option.appendChild(txt);
        option.setAttribute("value", arr[i]);
        select.insertBefore(option, select.lastChild);
    }
}



//-------------------fro user dropdown dynamically filling the drop downs

function populate_user_specialization_dropdown_by_query()
{
    let select = document.getElementById("Select User Course Specialization");
    let arr= Get("api/buttonsdynamically/get/specialization");
    if(select===null)
        alert("empty object retrieved from DOM parse");
    if( select.length>1) {
        //alert("Specialization already exist in under the domain button, no need to again add them");
        return "";
    }
    for (let i = 0; i < arr.length; i++) {
        let option = document.createElement("OPTION"), txt = document.createTextNode(arr[i]);
        option.appendChild(txt);
        option.setAttribute("value", arr[i]);
        select.insertBefore(option, select.lastChild);
    }
    
}
