/**
 * 
 */
 
 function validar(){
    var obs=    document.getElementById("txtNome").value;
    if(obs==''){
        alert("Campo nome Obrigatorio");
        return false;
    }else{
        return true;
    }
}