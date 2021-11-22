//import { checkSession } from '/sessionJS.js';



const btn = document.getElementById('loginbtn');



btn.addEventListener("click", authUser);

async function authUser() {
let email = document.getElementById("inputEmail").value;
let password = document.getElementById("inputPassword").value;
     if ($("#frm")[0].checkValidity()){        
       let requestBody = `{"email" : "${email}" , "password" : "${password}"}`; 

       let response = await fetch('http://localhost/auth', {method: 'post',
       headers : {'Content-Type': 'application/json'},         
       body : requestBody         
       });

       let responsetext = await response.text();
       if(response.status != 200){       
       alert(responsetext);
       }
       else {
        if (responsetext == 1){            
            window.location.replace("views/employee.html");
        }
        else {
            alert(responsetext);
            //window.location.replace("views/manager.html");
        }
       }


               
    }
    
    else {
        //Validate Form
        $("#frm")[0].reportValidity()
    }

}

async function authUser1() {

}