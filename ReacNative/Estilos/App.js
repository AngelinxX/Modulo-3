import { StatusBar } from 'expo-status-bar';
import { Button } from 'react-native';
import { StyleSheet, Text, View } from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <Button
        title="COMP 1"
      />
      <Button
        title="COMP 2" color="green"
      />
      <Button
        title="COMP 3"
      />
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    flexDirection: "column",
    justifyContent: "space-around",
    alignItems: "stretch"
  },
});
