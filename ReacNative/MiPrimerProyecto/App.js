import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Button, Alert } from 'react-native';

export default function App() {
  const despedirse=()=>{
    Alert.alert("Mensaje","Despedida")
  }
  return (
    <View style={styles.container}>
      <Text>Bienvenido al curso de RN</Text>
      <StatusBar style="auto" />
      <Button
        title="Hola"
        // funcion que no recibe parametros
        onPress={()=>{
          Alert.alert(/*titulo*/ "Mensaje",/*mensaje*/"Hola desde el boton");
        }}
      />
      <Button
        title="Adios"
        onPress={
          despedirse  
        }
      />
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
