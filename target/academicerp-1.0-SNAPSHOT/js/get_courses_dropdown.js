
let get_courses_names = document.getElementById('Select User Course Specialization');

get_courses_names.addEventListener("input", async(e) =>{
    e.preventDefault();
    e.stopPropagation();

    console.log("inside listener");
    console.log(get_courses_names.value);
    let select= document.getElementById('Select Course');
    if(select==null)
        alert("empty object retrieved from DOM parse");
    //using buttonRequest java class instead of creating new class ( using only last variable)
    let response = await fetch('api/buttonsdynamically/get/getCourseNamesDropdown', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            domain: "dummy",
            year: "dummy",
            faculty: "dummy",
            capacity: "dummy",
            specialization: get_courses_names.value,
        })
    });

    let arr = await response.json();
    select.innerHTML= "";
    for (let i = 0; i < arr.length; i++) {
        let option = document.createElement("OPTION"), txt = document.createTextNode(arr[i]);
        option.appendChild(txt);
        option.setAttribute("value", arr[i]);
        select.insertBefore(option, select.lastChild);
    }

});