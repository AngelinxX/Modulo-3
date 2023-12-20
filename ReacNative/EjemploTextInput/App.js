import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, TextInput, Button } from 'react-native';
import {useState} from 'react';

export default function App() {
  const[nombre,setNombre]=useState("Ingrese su nombre");
  const[apellid,setApellido]=useState("Ingrse su apellido");
  const[nombreCompleto,setNombreCompleto]=useState("")
  return (
    <View style={styles.container}>
      <Text>Ejemplo TextInput</Text>
      <Text>Hola {nombreCompleto}</Text>
      <TextInput 
        style={styles.cajaTexto}
        value={nombre}
        onChangeText={(txt)=>{
          setNombre(txt);
        }}
      />
      <TextInput
        style={styles.cajaTexto}
        value={apellid}
        onChangeText={(txt)=>{
          setApellido(txt);
        }}
      />
      <Button
        title="Saludar"
        onPress={()=>{
          let completo = nombre+" "+apellid;
          setNombreCompleto(completo);
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
  cajaTexto: {
    borderColor:"black",
    borderWidth:1,
    paddingTop:5,
    paddingHorizontal:10,
  }
});
