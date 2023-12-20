import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { Button } from 'react-native';
import { TextInput } from 'react-native';
import { StyleSheet, Text, View } from 'react-native';

export default function App() {
  const[dolares,setDolares]=useState("Ingrese el valor en dolares");
  const[equivalente,setEquivalente]=useState("");
  return (
    <View style={styles.container}>
      <Text>Proyecto Convertidor</Text>
      <Text>Valor equivalente {equivalente}</Text>
      <TextInput
      style={styles.cajaTexto}
      value={dolares}
      onChangeText={(valor)=>{
        setDolares(valor);
      }}
      />
      <Button
      title="PESOS MEXICANOS"
      onPress={()=>{
        const pmx = parseFloat(dolares,10);
        const vpmx = 17.07;
        const conversion = pmx*vpmx;
        let total = conversion;
        setEquivalente(total);
      }}
      />
      <Button
      title="PESOS COLOMBIANOS"
      onPress={()=>{
        const pcl = parseFloat(dolares,10);
        const vpcl = 3943.00;
        const conversion = pcl*vpcl;
        let total = conversion;
        setEquivalente(total); 
      }}
      />
      <Button
      title="EUROS"
      onPress={()=>{
        const peu = parseFloat(dolares,10);
        const vpeu = 0.91;
        const conversion = peu*vpeu;
        let total = conversion;
        setEquivalente(total);
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
    borderColor:"green",
    borderWidth:1,
    paddingTop:5,
    paddingHorizontal:10,
  }
});
