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
divPending.innerHTML = "<h1> testing </h1>";
};


  //view resolved requests
const divResolved = document.getElementById('viewResolved');
if (divResolved != null ){
divResolved.innerHTML = "<h1> testing </h1>";
};

 //view account info
const divAccount = document.getElementById('accountInfo');
if (divAccount != null){
    divAccount.innerHTML = "<h1> testing </h1>";
};

let u_username = AuthToken.split(':')[0];
getRequestData("http://localhost/reimbursement/pending/u_username");

// async function submitReimb(){
//     let requestBody = `{"email" : "${email}" , "password" : "${password}"}`; 
//     let response = await fetch('http://localhost/reimbursement', {method: 'post',
//     headers : {'Content-Type': 'application/json'},         
//     body : requestBody         
//     });
// };

async function getRequestData(r_url) {
    
    let response = await fetch(r_url, {method: 'get',
    headers : {'authToken': AuthToken},        
    });
    let responsetext = await response.text();
    JSON.parse(responsetext);
    alert(responsetext)
};

function viewPending(){

};

function viewResolved() {

};

function accountInfo(){

};




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
    }
    };


    //log in
function setSession(authToken) {
    document.cookie = `authToken = ${authToken} ; expires=Thu, 18 Dec 2022 12:00:00 UTC; path=/`;
    };
    
    //log out
    
    function deleteSession(){
        document.cookie = "authToken=; expires=Thu, 01 Jan 1970 00:00:00 UTC;  path=/";
        window.location.replace("../index.html");
    }
    

// -------------- END OF SESSION MANAGER -----------------------