//checking if there is a valid token
checkSession();


//setting the token to use for api calls.
let AuthToken = getCookie('authToken');


//logout btn 
const btn0 = document.getElementById('logoutbtn');
btn0.addEventListener("click", deleteSession);




//submit reimb
const btn = document.getElementById('submitreimb');
if (btn != null){
btn.addEventListener("click", submitReimb);
};

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

 //view account info
const divAccount = document.getElementById('accountInfo');
if (divAccount != null){
    accountInfo();
    const btn = document.getElementById('updateUserInfoBtn');    
    btn.addEventListener("click", updateUserInfo);
};

//let u_username = AuthToken.split(':')[0];


// async function submitReimb(){
//     let requestBody = `{"email" : "${email}" , "password" : "${password}"}`; 
//     let response = await fetch('http://localhost/reimbursement', {method: 'post',
//     headers : {'Content-Type': 'application/json'},         
//     body : requestBody         
//     });
// };

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

// --------------- END REUSEABLE FUNCS---------------


// -------- PAGE SPECIFIC SCRIPTS--------------

async function viewPending(){
    var jsontext = await getRequestData("http://localhost/reimbursement/pending/u_username");
    const table = document.getElementById('pendingList');
    viewTable(table, jsontext);
};

async function viewResolved() {
    var jsontext = await getRequestData("http://localhost/reimbursement/resolved/u_username");
    const table = document.getElementById('resolvedList');
    viewTable(table, jsontext);
};

async function accountInfo(){
    var jsontext = await getRequestData("http://localhost/account");
    
    
    var titleName = document.getElementById('u_usernameTitle'); 
    titleName.innerText  = jsontext.username;

    var u_firstName = document.getElementById('u_firstname'); 
    var u_lastname = document.getElementById('u_lastname');      
    var u_username = document.getElementById('u_username');
    var u_email = document.getElementById('u_email');
    var u_password = document.getElementById('u_password');


   
    u_firstName.value =  jsontext.firstName;
    u_lastname.value =  jsontext.lastName;
    u_username.value =  jsontext.username;
    u_email.value = jsontext.email;
    u_password.value = jsontext.password;
    

};

async function updateUserInfo() {
    var u_firstName = document.getElementById('u_firstname').value; 
    var u_lastname = document.getElementById('u_lastname').value;      
    var u_username = document.getElementById('u_username').value;
    var u_email = document.getElementById('u_email').value;
    var u_password = document.getElementById('u_password').value;
    
    
    try {
        let requestBody = `{"username" : "${u_username}" , "password" : "${u_password}"
        , "firstName" : "${u_firstName}", "lastName" : "${u_lastname}"
        , "email" : "${u_email}"}  `;
        let response = await fetch("http://localhost/account", {method: 'put',
        headers : {'authToken': AuthToken},   
        body : requestBody       
        });
        if (response.status === 200) {
            alert("Information Updated");
            }
            else {      
            alert(response.status);
            }
        }
        catch (err) {
            alert("500");
        };
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

        if (u_role != 'employee'){
            window.location.replace("manager.html");
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