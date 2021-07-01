


let get_courses = document.getElementById('get_Courses');

get_courses.addEventListener('submit', async (e) => {
    console.log("Entered event listener");
    e.preventDefault();
    e.stopPropagation();
    //alert("i'm invoked");
    //alert(document.getElementById('Select Specialization').value);


    let response = await fetch('api/buttonsdynamically/get/getCourses', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            domain: document.getElementById('Select Domain').value,
            year: document.getElementById('Select Academic Year').value,
            faculty: document.getElementById('Select Faculty').value,
            capacity: document.getElementById('Select Capacity').value,
            specialization: document.getElementById('Select Specialization').value,
        })
    });
    let result = await response.json();
    //console.log(result.length);
    if(result.length==0)
        console.log("No courses available for selected options");
    else
        console.log(result);


    // table printing onto html page -- front end
    const tableHeadings= ['Course_Id','Course_Code', 'Course_Name', 'Credits', 'Course_Capacity','Faculty_Name','Faculty_Email','Year', 'Term'];
    //let tablehtml = "<table><caption>Courses</caption>";
    let tablehtml= "<table>";
    // insert row of headings
    tablehtml  += "<tr>";
    for(let i=0;i<tableHeadings.length;i++)
    {
        let fun_param= "sortTable(" + i + ")";
        tablehtml  += `<th onclick=${fun_param}>${tableHeadings[i]}</th>`;
    }
    tablehtml += "</tr>";
    // iterate json array and insert for every row
    for(let i = 0; i < result.length; i++)
    {
        let obj = result[i];
        tablehtml += "<tr>";
        tablehtml += `<td>${obj.course_id}</td>`;
        tablehtml += `<td>${obj.course_code}</td>`;
        tablehtml += `<td>${obj.name}</td>`;
        tablehtml += `<td>${obj.credits}</td>`;
        tablehtml += `<td>${obj.capacity}</td>`;
        tablehtml += `<td>${obj.faculty.first_name} ${obj.faculty.last_name}</td>`;
        tablehtml += `<td>${obj.faculty.email}</td>`;
        tablehtml += `<td>${obj.year}</td>`;
        tablehtml += `<td>${obj.term}</td>`;
        tablehtml += "</tr>";
    }

    // end of table
    tablehtml += "</table>";
    // add table to the empty div
    document.getElementById("org-table-id").innerHTML = tablehtml;
});


//additional sorting functionality on column headers


// sorting function based on column click
function sortTable(n) {
    let table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("org-table-id");
    switching = true;
    //Set the sorting direction to ascending:
    dir = "asc";
    /*Make a loop that will continue until
    no switching has been done:*/
    while (switching) {
        //start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /*Loop through all table rows (except the
        first, which contains table headers):*/
        for (i = 1; i < (rows.length - 1); i++) {
            //start by saying there should be no switching:
            shouldSwitch = false;
            /*Get the two elements you want to compare,
            one from current row and one from the next:*/
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            /*check if the two rows should switch place,
            based on the direction, asc or desc:*/
            if (dir == "asc") {
                //adding for course_id parsing integer
                if(n==0) // for handling course_id sort
                {
                    if( parseInt(x.innerHTML.toLowerCase()) > parseInt(y.innerHTML.toLocaleLowerCase()) )
                    {
                        shouldSwitch= true;
                        break;
                    }
                }
                else if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch= true;
                    break;
                }
            } else if (dir == "desc") {
                if(n==0) // for handling course_id sort
                {
                    if( parseInt(x.innerHTML.toLowerCase()) > parseInt(y.innerHTML.toLocaleLowerCase()) )
                    {
                        shouldSwitch= true;
                        break;
                    }
                }
                else if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /*If a switch has been marked, make the switch
            and mark that a switch has been done:*/
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            //Each time a switch is done, increase this count by 1:
            switchcount ++;
        } else {
            /*If no switching has been done AND the direction is "asc",
            set the direction to "desc" and run the while loop again.*/
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
} // end of sort table function


