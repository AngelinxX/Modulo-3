import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { StyleSheet, Text, View, Button, TextInput } from 'react-native';

export default function App() {
  const[peso,setPeso]=useState();
  const[estatura,setEstatura]=useState();
  const[resultado,setResultado]=useState("");
  const[texto,setTexto]=useState("");
  console.log(resultado);
  return (
    <View style={styles.container}>
      <Text style={styles.titulo}>Calculadora IMC</Text>
      <View>
      <TextInput
        style={styles.caja}
        value={peso}
        onChangeText={setPeso}
        placeholder='Ingrese su peso en Kilogramos'
      />
      <TextInput
        style={styles.caja}
        value={estatura}
        onChangeText={setEstatura}
        placeholder='Ingrese su estatura en Metros'
      />
      </View>
      <Button
        title='Calcular IMC'
        onPress={()=>{
          const pesoInt = parseInt(peso);
          const estaturaFloat = parseFloat(estatura);
          const suma = peso/(estatura*estatura);
          let total = suma.toFixed(2);
          setResultado(total);
          if(total<=18.5){
            setTexto("Su peso es inferior al normal")
          }else if(total>=18.5&&total<=25.0){
            setTexto("Su peso es normal")
          }else if(total>=25.0&&total<=30.0){
            setTexto("Su peso es superior al normal")
          }else if(total>=30.0){
            setTexto("Tiene obesidad")
          }
        }}
      />
      <Text style={styles.titulo}>Resultado:  {resultado}</Text>
      <Text style={styles.titulo}>{texto}</Text>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    flexDirection: "column",//eje principal es el vertical
    justifyContent:"center", //vertical
    alignItems: "stretch", // eje horizontal
    paddingHorizontal:10
  },
  caja:{
    borderColor: "gray",
    borderWidth: 1,
    paddingTop: 5,
    paddingHorizontal: 10, 
    marginBottom: 10
  },
  titulo:{
    fontSize: 16,
    marginVertical: 10,
    fontWeight: "bold"
  }
});
