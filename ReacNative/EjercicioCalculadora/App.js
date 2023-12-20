import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { Button, StyleSheet, Text, TextInput, View } from 'react-native';

export default function App() {
  const[valor1,setValor1]=useState("Ingrese un valor");
  const[valor2,setValor2]=useState("Ingrese un valor");
  const[total,setTotal]=useState("");
  return (
    <View style={styles.container}>
      <Text>CALCULADORA</Text>
      <Text>Valor{total}</Text>
      <TextInput
        style={styles.cajaTexto}
        value={valor1}
        onChangeText={(val1)=>{
          setValor1(val1);
        }}
      />
      <TextInput
        style={styles.cajaTexto}
        value={valor2}
        onChangeText={(val2)=>{
          setValor2(val2);
        }}
      />
      <Button
        title="Suma"
        onPress={()=>{
          const val1 = parseInt(valor1,10);
          const val2 = parseInt(valor2,10);
          const suma = val1+val2;
          let total = suma;
          setTotal(total);
        }}
      />
      <Button
        title="Restar"
        onPress={()=>{
          const val1 = parseInt(valor1,10);
          const val2 = parseInt(valor2,10);
          const resta = val1-val2;
          let total = resta;
          setTotal(total);
        }}
      />
      <Button
        title="Multiplicacion"
        onPress={()=>{
          const val1 = parseInt(valor1,10);
          const val2 = parseInt(valor2,10);
          const multiplicacion = val1*val2;
          let total = multiplicacion;
          setTotal(total);
        }}
      />
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  cajaTexto:{
    borderColor:"blue",
    borderWidth:1,
    paddingTop:5,
    paddingHorizontal:10,
  }
});
