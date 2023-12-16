/*ejecutarSuma=function(){
    let valor1=recuperarTexto("txtValor1")
    let valor2=recuperarTexto("txtValor2")
    console.log("Valor 1>>>>>"+valor1+"Valor 2>>>>>"+valor2);
}*/


ejecutarSuma=()=>{
    let valor1=recuperarEntero("txtValor1");
    let valor2=recuperarEntero("txtValor2");
    let resultadoSuma;
    console.log("Valor 1>>>>>"+valor1+"Valor 2>>>>>"+valor2);
    resultadoSuma=sumar(valor1,valor2);
    console.log(resultadoSuma);
}

ejecutarResta=()=>{
    let valor1=recuperarFloat("txtValor1");
    let valor2=recuperarFloat("txtValor2");
    let resultadoResta;
    console.log("Valor 1>>>>>"+valor1+"Valor 2>>>>>"+valor2);
    resultadoResta=restar(valor1,valor2);
    console.log(resultadoResta);
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