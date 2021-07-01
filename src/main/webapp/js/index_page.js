document.getElementById("student_button").addEventListener("click",async (e) =>{
    console.log("Hit Submit Button");
    e.preventDefault();
    e.stopPropagation();
    let email = document.getElementById("student_email").value;
    console.log(email);
    let response = await fetch('api/buttonsdynamically/get/checkStudentEmail', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            domain: document.getElementById('student_email').value,
            year: "dummy",
            faculty: "dummy",
            capacity: "dummy",
            specialization: "dummy",
        })
    });
    //console.log(response.body);
    //console.log(response.text());
    let result = await response.json();
    console.log(result);
    if(result[0] === "success"){
        window.location = "student_page.html";
    }
    else{
        document.getElementById("result").innerHTML = "Please Enter correct EmailID";
    }
});

//FOR ADMIN EMAIL CHECK:

document.getElementById("admin_button").addEventListener("click",async (e) =>{
    console.log("Hit Submit Button");
    e.preventDefault();
    e.stopPropagation();
    let email = document.getElementById("admin_email").value;
    console.log(email);
    let response = await fetch('api/buttonsdynamically/get/checkAdminEmail', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            domain: document.getElementById('admin_email').value,
            year: "dummy",
            faculty: "dummy",
            capacity: "dummy",
            specialization: "dummy",
        })
    });
    //console.log(response.body);
    //console.log(response.text());
    let result = await response.json();
    console.log(result);
    if(result[0] === "success"){
        window.location = "adminPage_Test.html";
    }
    else{
        document.getElementById("result_admin").innerHTML = "Please Enter correct EmailID";
    }
});


