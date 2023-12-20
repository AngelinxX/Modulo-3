/*recuperarTexto=function(idComponente){
    let componente = document.getElementById(idComponente);
    let valorComponente = componente.value;
    return valorComponente;
}*/


//Arrow functions otra forma de apuntar la funcion
recuperarTexto=(idComponente)=>{
    let componente = document.getElementById(idComponente);
    let valorComponente = componente.value;
    return valorComponente;
}

recuperarEntero=(idComponente)=>{
    let valorTexto = recuperarTexto(idComponente);
    let valorEntero = parseInt(valorTexto);
    return valorEntero;
}

recuperarFloat=(idComponente)=>{
    let valorTexto = recuperarTexto(idComponente);
    let valorFloat = parseFloat(valorTexto);
    return valorFloat;
}

