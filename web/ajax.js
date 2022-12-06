async function logar(event){
    event.preventDefault();
    
    let data = new FormData(event.target);
    
    let resultado = await fetch('UsuarioLogin', {
        method: 'post',
        body: data
    });
    
    let resultadoData = await resultado.json();
    
    if(resultadoData.status){
        alert(resultadoData.Message);
    }
    else{
        window.location.href("Hub");
    }
}