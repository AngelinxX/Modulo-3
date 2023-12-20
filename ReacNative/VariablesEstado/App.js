import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Button } from 'react-native';
import {useState} from 'react';
import { Alert } from 'react-native';

export default function App() {
  /*const arreglo = useState(0);
  const contadorEstado=arreglo[0];
  const setContadorEstado=arreglo[1];*/

  /*const [contadorEstado,setContadorEstado] = useState(0);

  /*let contador = 0;
  const incrementar=()=>{
    /*contador=contador+1;
    console.log("Contador>>"+contador);
    setContadorEstado(contadorEstado+1);
    console.log("ContadorEstado>>"+contadorEstado);
  }
  const decrementar=()=>{
    setContadorEstado(contadorEstado-1);
  }*/

  const [contadorVidas,setContadorVidas] = useState(5);

  const perderVidas=()=>{
    setContadorVidas(contadorVidas-1);
    if (contadorVidas <= 0){
      Alert.alert("ADVENTENCIA","GAME OVER")
      setContadorVidas(contadorVidas);
    }
  }

  const premiarVidas=()=>{
    setContadorVidas(contadorVidas+3);
  }

  return (
    <View style={styles.container}>
      <Text>Variable de estado</Text>
      <Text>Contador Vidas: {contadorVidas}</Text>
      <Button
        title="Perder vidas"
        onPress={perderVidas}
      />
      <Button
        title="Premiar"
        onPress={premiarVidas}
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
});
