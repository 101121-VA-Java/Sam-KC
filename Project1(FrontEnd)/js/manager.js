//checking if there is a valid token
checkSession();


//setting the token to use for api calls.
let AuthToken = getCookie('authToken');


//logout btn 
const btn0 = document.getElementById('logoutbtn');
btn0.addEventListener("click", deleteSession);






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
        var row = table.insertRow(0);        
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        if (i === jsontext.length) {                    
            cell1.innerHTML = "ID";  
            cell2.innerHTML = "submittedDate";  
            cell3.innerHTML = "amount"; 
            cell4.innerHTML = "description"; 
            cell5.innerHTML = "type"; 
            cell6.innerHTML = "status"; 
            }
        else {
            cell1.innerHTML = jsontext[i].id;
            cell2.innerHTML = jsontext[i].submittedDate;  
            cell3.innerHTML = jsontext[i].amount; 
            cell4.innerHTML = jsontext[i].description;
            cell5.innerHTML = jsontext[i].type.type;
            cell6.innerHTML = jsontext[i].status.status;
        }

    }
}

// --------------- END REUSEABLE FUNCS---------------


// -------- PAGE SPECIFIC SCRIPTS--------------



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