
// document.cookie = `authToken = 'test' ; expires=Thu, 18 Dec 2022 12:00:00 UTC"`;
checkSession();

const btn = document.getElementById('logoutbtn');
btn.addEventListener("click", deleteSession);

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


    