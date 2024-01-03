import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { Contacts } from './app/screens/ContactsScreen';
import { Home } from './app/screens/HomeScreen';
import { Productos } from './app/screens/ProductoScreen';

const stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <stack.Navigator>
        
        <stack.Screen name='HomeNav' component={Home} />
        <stack.Screen name='ContactsNav' component={Contacts} />
        <stack.Screen name='ProductosNav' component={Productos} />
      </stack.Navigator>
    </NavigationContainer>
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
