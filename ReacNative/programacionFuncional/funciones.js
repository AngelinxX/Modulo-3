/*ejecutarSuma=function(){
    let valor1=recuperarTexto("txtValor1")
    let valor2=recuperarTexto("txtValor2")
    console.log("Valor 1>>>>>"+valor1+"Valor 2>>>>>"+valor2);
}*/

/*ejecutarSuma=()=>{
    let valor1=recuperarEntero("txtValor1");
    let valor2=recuperarEntero("txtValor2");
    let resultadoSuma;
    console.log("Valor 1>>>>>"+valor1+"Valor 2>>>>>"+valor2);
    resultadoSuma=sumar(valor1,valor2);
    console.log(resultadoSuma);
    ejecutarOperacion(sumar);
}*/

ejecutarOperacion=(operar)=>{
    let valor1=recuperarEntero("txtValor1");
    let valor2=recuperarEntero("txtValor2");
    let resultado;
    resultado=operar(valor1,valor2);
    console.log(resultado);
}

sumar=(sum1,sum2)=>{
    let resultado;
    resultado=sum1+sum2;
    return resultado;
}

restar=(rest1,rest2)=>{
    let resultado;
    resultado = rest1-rest2;
    return resultado;
}

ejecutar=(fn)=>{
    console.log("Estoy ejecutando funciones..")
    fn();
}

imprimir=()=>{
    console.log("Estoy impimiendo");
}

saludar=()=>{
    alert("Aprendiendo programacion funcional");
}

testEjecutar=()=>{
    ejecutar(imprimir);
    ejecutar(saludar);
    ejecutar(()=>{ // funcion anonima
        alert("Soy una funcion sin nombre");
    });
}

