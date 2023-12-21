import { StatusBar } from 'expo-status-bar';
import { Button } from 'react-native';
import { StyleSheet, Text, View } from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <View style={styles.container1}>
        <Button title="X"/>
        <Button title="Y"/>
        <Button title="Z"/>
      </View>
      <View style={styles.container2}>
        <View style={styles.container4}>
          <View style={styles.container6}>
            <Button title="BOTON 1"/>
            <Button title="BOTON 2"/>
          </View>
          <View style={styles.container7}>
            <Button title="OPERACION 1"/>
            <Button title="OPERACION 2"/>
            <Button title="OPERACION 3"/>
          </View>
        </View>
        <View style={styles.container5}>
          <Button title="ACCION 1"/>
          <Button title="ACCION 2"/>
        </View>
      </View>
      <View style={styles.container3}>
        <Button title="BOTON FINAL"/>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'gray',
  },
  container1: {
    flex: 1,
    backgroundColor: 'blue',
    flexDirection: "row",
    justifyContent: "flex-end",
    alignItems: "center"
  },
  container2: {
    flex: 6,
    backgroundColor: 'green',
  },
  container3: {
    flex: 1,
    backgroundColor: 'orange',
    justifyContent: "center",
    alignItems: "flex-start",
  },
  container4: {
    flex: 4,
    backgroundColor: 'pink',
    flexDirection: "row"
  },
  container5: {
    flex: 2,
    backgroundColor: 'purple',
    flexDirection: "row",
    justifyContent: "center",
    alignItems: "flex-end",
  },
  container6: {
    flex: 1,
    backgroundColor: 'yellow',
    justifyContent: "space-around",
    alignItems: "stretch",
  },
  container7: {
    flex: 1,
    backgroundColor: 'white',
    justifyContent: "center",
    alignItems: "flex-start",
  },
});
