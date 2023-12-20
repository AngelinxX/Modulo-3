import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Button, Alert } from 'react-native';

export default function App() {
  const iniciar=()=>{
    Alert.alert("Mensaje","Su sesion ha iniciado")
  }
  return (
    <View style={styles.container}>
      <Text>Open up App.js to start working on your app!</Text>
      <StatusBar style="auto" />

      <Button
        title="Finalizar"
        onPress={()=>{
          Alert.alert("Mensaje","Su sesion ha finalizado");
        }}
      />

      <Button
        title="Iniciar"
        onPress={
          iniciar  
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
