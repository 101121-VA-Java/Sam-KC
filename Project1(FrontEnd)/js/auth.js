const btn = document.getElementById('loginbtn');

btn.addEventListener("click", authUser);

function authUser() {

     if ($("#frm")[0].checkValidity()){
        alert('sucess');

    }
    else {
        //Validate Form
        $("#frm")[0].reportValidity()
    }

}