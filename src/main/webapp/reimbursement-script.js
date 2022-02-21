let userUrl = "hthttp://localhost:8080/ReimbursementApp/Register.htmltp"

function addEmployee (){
    let fname =document.getElementById('employeeFname').Value;
let lname = document.getElementById('employeeLname').Value;


let newEmployee = {
firstname: fname,
lastName: lName


}
console.log(newEmployee)
let employeeJson = JSON.stringify(newEmployee);
console.log(employeeJson);

let xhr = new XMLHttpRequest();
xhr.onreadystatechange = function(){
    if(this.readyState == 4 && this.status == 200){
        let r = this.responseText;
        console.log(r);
    }
}
xhr. open('POST', requestUrl, true);
xhr.setRequestHeader('Content-type', 'application/json');

xhr.send(employeeJson);
}
async function addEmployeeFetch(){
    let employee = {
        firstname: document.getElementById('employeeFname').value,
        lastName: document.getElementById('employeeLName').value
    }
    let res = await fetch(requestUrl, {
        method:"POST",
        body:JSON.stringify(employee),
        header: {'Content-Type': 'application/json'}
    });
    let resJson = await res.json()
    .then((resp) =>{
        console.log(error);
    });
}



function getAllrequest(){
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200){
            let r = JSON.parse(this.responseText);
            console.log(r)
        }
    }
    xhr.open('GET', requestUrl, true);
    xhr.send();
}

let requestUrl ="http://localhost:8080/ReimbursementApp/Manager.html"

async function fetchAllRequests(){
    let res = await fetch(requestUrl);
    let data = await res.json();

    if(res.status == 200){
        console.log(data);
        populateRequests(data);
    }else {
        console.log("Sorry we're expriencing trouble")
    }
}
function populateRequests(data){

    let requestDiv = document.getElementById('requests');
    requestDiv.innerHTML = "";

    let requestTable = document.getElementById('table');
    bookTable.setAttribute('class', 'table')

    let tHead = document.createElement('thead');

    let tableHeadRow= document.createElement('tr');

    let theaders = ['ID', 'firstName','lastName', 'amount','status'];
    for (let h of theaders){
        let th = document.createElement('th');
        th.setAttribute('scope', 'col');
        th.innerHTML= h;
        tableHeadRow.append(th);
    }
    tHead.append(tableHeadRow)
    bookTable.append(thead);
    
    for(let request of data){
    let tr = document.createElement('tr');
    tr.id= request.id;

    let tdID = document.createElement('td');
    tdID.innerHTML = request.id;
    tr.append(tdID);
    
    let tdTitle = document.createElement('td');
    tdTitle.innerHTML = request.title;
    tr.append(tdTitle);

    let tdEmployee = document.createElement('td');
    tdEmployee.id = request.employee.id;
    tdEmployee.innerHTML = `${request.employee.firstName} ${request.employee.lastName}`;
    tr.append(tdEmployee);

    let tdButton = document.createElement('td');
    tdButton.innerHTML = `<button type=:"button" onclick="update(event)">update</button>`;
    tr.append(tdButton);

    requestTable.append(tr);
}
requestDiv.append(requestTable);
}

function update(event) {
    console.log(event);
    let requestRow = event.path[2];

    let request = {
        id:Number(requestRow.cells[0].innerHTML),
        title:"Updated Title",
        employee: {
            id: requestRow.cells[2].attributes.id.value
        }
    }
    console.log(book);
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText); 
}
    }

xhr.open('PUT', `${requestUrl}/${request.id}`, true);
xhr.send(JSON.stringify(request));

}

