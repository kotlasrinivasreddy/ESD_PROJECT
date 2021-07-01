let get_students = document.getElementById('display_user_courses');

get_students.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    //alert("i'm invoked");
    //alert(document.getElementById('Select Specialization').value);
    console.log("inside the submit button of get students");
    //using same buttonrequest java class 2 variables
    // domain as coursename, faculty as ordering

    let response = await fetch('api/buttonsdynamically/get/getStudentsByOrdering', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            domain: document.getElementById('Select Course').value,
            year: "dummy",
            faculty: document.getElementById('Select Ordering').value,
            capacity: "dummy",
            specialization: "dummy",
        })
    });
    let result = await response.json();
    //console.log(result.length);
    if(result.length==0)
        console.log("No courses available for selected options");
    else
        console.log(result);


// table printing onto html page -- front end
    const tableHeadings= ['Roll_no','Student_name', 'Course_grade', 'Total cgpa'];
    let tablehtml = "<table><caption>CLICK ON COLUMN HEADING TO SORT STDUENTS ON SPECIFIC COLUMN</caption>";
    //let tablehtml= "<table>";
    // insert row of headings
    tablehtml  += "<tr>";
    // unable to add "sortTable(i)" dynamically.... we have only 4 tables
    // so statically adding them
    for(let i=0;i<tableHeadings.length;i++)
    {
        let fun_param= "sortTable(" + i + ")";
        console.log(fun_param);
        tablehtml += `<th onclick= ${fun_param} >${tableHeadings[i]}</th>`;
    }
    // tablehtml += `<th onclick= "sortTable(0)">${tableHeadings[0]}</th>`;
    // tablehtml += `<th onclick= "sortTable(1)">${tableHeadings[1]}</th>`;
    // tablehtml += `<th onclick= "sortTable(2)">${tableHeadings[2]}</th>`;
    // tablehtml += `<th onclick= "sortTable(3)">${tableHeadings[3]}</th>`;
    // tablehtml += "</tr>";

    tablehtml += "</tr>";
    // iterate json array and insert for every row
    for(let i = 0; i < result.length; i++)
    {
        let obj = result[i];
        tablehtml += "<tr>";
        tablehtml += `<td>${obj.roll_no}</td>`;
        tablehtml += `<td>${obj.name}</td>`;
        tablehtml += `<td>${obj.course_grade}</td>`;
        tablehtml += `<td>${obj.cgpa}</td>`;
        tablehtml += "</tr>";
    }

    // end of table
    tablehtml += "</table>";
    // add table to the empty div
    document.getElementById("student-table-id").innerHTML = "";
    document.getElementById("student-table-id").innerHTML=tablehtml;


});



// sorting function based on column click
function sortTable(n) {
    let table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("student-table-id");
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
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch= true;
                    break;
                }
            } else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
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