//checking if there is a valid token
checkSession();


//setting the token to use for api calls.
let AuthToken = getCookie('authToken');


//logout btn 
const btn0 = document.getElementById('logoutbtn');
btn0.addEventListener("click", deleteSession);



//-- VIEWS---

// view pending reimb
const divPending = document.getElementById('pendingList');
if (divPending != null){
    viewPending();
};

//view resolved requests
const divResolved = document.getElementById('resolvedList');
if (divResolved != null ){
    viewResolved();
};
//view employee list
const divEmployees = document.getElementById('employeeList');
if (divEmployees != null ){
    viewEmployees();
};

// approve/ deny requests
const divPanel = document.getElementById('pendingPanelList');
if (divPanel != null ){ 
    viewPendingPanel();
};

//-- END VIEWS---

// ---------------REUSEABLE FUNCS---------------

async function getRequestData(r_url) {
    try {
    let response = await fetch(r_url, {method: 'get',
    headers : {'authToken': AuthToken},        
    });
    if (response.status === 200) {
        let jsontext = await response.json();    
        return jsontext;
        }
        else {      
        var titleName = document.getElementById('errorMsg'); 
        titleName.innerText  = response.status;
        }
    }
    catch (err) {
        var titleName = document.getElementById('errorMsg'); 
        titleName.innerText  = "500";
    };



    //alert(JSON.stringify(jsontext[0].id)); how to get values

};

async function updateReimbAPI(reimbId, statusId) {
    try {
    
    let response = await fetch("http://localhost/reimbursement", {method: 'put',
    headers : {'authToken': AuthToken, 'Content-Type': 'application/json'},        
    body: `{"reimbId" : "${reimbId}" , "statusId" : "${statusId}"}`
    });
    if (response.status == 200) {         
        alert("Updated");
        }
        else {      
        var titleName = document.getElementById('errorMsg'); 
        titleName.innerText  = response.status;    
        }
    }
    catch (err) {
        var titleName = document.getElementById('errorMsg'); 
        titleName.innerText  = err;
        
    };



    //alert(JSON.stringify(jsontext[0].id)); how to get values

};



function viewTable(table, jsontext){
   
    for (let i = 0; i < jsontext.length +1 ; i++) {
        var cells = [];

        var row = table.insertRow(0);  
        for (let ic = 0; ic < 6 ; ic++) {
            cells[ic] = row.insertCell(ic);
        }              

        if (i === jsontext.length) {                    
            cells[0].innerHTML = "ID";  
            cells[1].innerHTML = "submittedDate";  
            cells[2].innerHTML = "amount"; 
            cells[3].innerHTML = "description"; 
            cells[4].innerHTML = "type"; 
            cells[5].innerHTML = "status"; 
            }
        else {
            cells[0].innerHTML = jsontext[i].id;
            cells[1].innerHTML = jsontext[i].submittedDate;  
            cells[2].innerHTML = jsontext[i].amount; 
            cells[3].innerHTML = jsontext[i].description;
            cells[4].innerHTML = jsontext[i].type.type;
            cells[5].innerHTML = jsontext[i].status.status;
        }

    }
}
function viewTableEmployees(table, jsontext){
   
    for (let i = 0; i < jsontext.length +1 ; i++) {
        var cells = [];

        var row = table.insertRow(0);  
        for (let ic = 0; ic < 6 ; ic++) {
            cells[ic] = row.insertCell(ic);
        }              

        if (i === jsontext.length) {                    
            cells[0].innerHTML = "User ID";  
            cells[1].innerHTML = "Username";  
            cells[2].innerHTML = "Password"; 
            cells[3].innerHTML = "First Name"; 
            cells[4].innerHTML = "Last Name"; 
            cells[5].innerHTML = "Email"; 
            }
        else {
            cells[0].innerHTML = jsontext[i].userId;
            cells[1].innerHTML = jsontext[i].username;  
            cells[2].innerHTML = jsontext[i].password; 
            cells[3].innerHTML = jsontext[i].firstName;
            cells[4].innerHTML = jsontext[i].lastName;
            cells[5].innerHTML = jsontext[i].email;
        }

    }
}
function viewTablePanel(table, jsontext){
    for (let i = 0; i < jsontext.length +1 ; i++) {
        var cells = [];

        var row = table.insertRow(0);  
        for (let ic = 0; ic < 7 ; ic++) {
            cells[ic] = row.insertCell(ic);
        }              

        if (i === jsontext.length) {                    
            //cells[0].innerHTML = "ID";  
            cells[0].innerHTML = "Username";
            cells[1].innerHTML = "submittedDate";  
            cells[2].innerHTML = "amount"; 
            cells[3].innerHTML = "description"; 
            cells[4].innerHTML = "type"; 
            cells[5].innerHTML = "status"; 
            cells[6].innerHTML = "Update";
            }
        else {
            
            //cells[0].innerHTML = jsontext[i].id;
            cells[0].innerHTML = jsontext[i].author.username;
            cells[1].innerHTML = jsontext[i].submittedDate;  
            cells[2].innerHTML = jsontext[i].amount; 
            cells[3].innerHTML = jsontext[i].description;
            cells[4].innerHTML = jsontext[i].type.type;
            cells[5].innerHTML = jsontext[i].status.status;
            cells[6].innerHTML = `<button onclick="updateReimb('${jsontext[i].id}' , '2')">Approve</button>
            <button onclick="updateReimb('${jsontext[i].id}' , '3')">Deny</button>            
            `;
        }

    }
}


// --------------- END REUSEABLE FUNCS---------------

async function updateReimb(reimbId, statusId){
    updateReimbAPI(reimbId, statusId);
    location.reload();
}


// -------- PAGE SPECIFIC SCRIPTS--------------
async function viewPending(){
    var jsontext = await getRequestData("http://localhost/reimbursement/pending/all");
    const table = document.getElementById('pendingList');
    viewTable(table, jsontext);
};

async function viewResolved() {
    var jsontext = await getRequestData("http://localhost/reimbursement/resolved/all");
    const table = document.getElementById('resolvedList');
    viewTable(table, jsontext);
};
async function viewEmployees() {
    var jsontext = await getRequestData("http://localhost/employees");
    const table = document.getElementById('employeeList');
    const searchBtn = document.getElementById('searchBtn');
    searchBtn.addEventListener("click", searchUser);
    viewTableEmployees(table, jsontext);
};
async function viewPendingPanel(){
    var jsontext = await getRequestData("http://localhost/reimbursement/pending/all");
    const table = document.getElementById('pendingPanelList');
    viewTablePanel(table, jsontext);
};

async function searchUser(){
    //resetting the table before viewing it again
    const table = document.getElementById('singleEmployee');
    while(table.rows.length > 0) {
        table.deleteRow(0);
      }
    let usr = document.getElementById("e_username").value;    
    var jsontext = await getRequestData(`http://localhost/reimbursement/${usr}`);

    if (jsontext == null || jsontext.length == 0 ) {       
        let searchMsg = document.getElementById("searchMsg"); 
        searchMsg.innerText = "No records from this user";
    }
     else {        
        
        const table = document.getElementById('singleEmployee');
        searchMsg.innerText = "";
        viewTable(table, jsontext);
     }
 
    
}

// -------- END PAGE SPECIFIC SCRIPTS--------------



// -------------- SESSION MANAGER -----------------------
function getCookie(cname) {
    let name = cname + "=";
    let ca = document.cookie.split(';');
    for(let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
        c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
        }
    }
    return "";
    }

    //default check
function checkSession(){
    let currentSession = getCookie('authToken');
    if (currentSession == null || currentSession.length == 0) {
         window.location.replace("../index.html");
    }
    else {    
        u_role = currentSession.split(':')[2];

        if (u_role != 'manager'){
            window.location.replace("employee.html");
        }
        
    }
    };


    //log in
function setSession(authToken) {
    document.cookie = `authToken = ${authToken} ; expires=Thu, 18 Dec 2022 12:00:00 UTC; path=/`;
    };
    
    //log out
    
    function deleteSession(){
        document.cookie = "authToken=; expires=Thu, 01 Jan 1970 00:00:00 UTC;  path=/";
        window.location.replace("http://127.0.0.1:5500");
    }
    

// -------------- END OF SESSION MANAGER -----------------------