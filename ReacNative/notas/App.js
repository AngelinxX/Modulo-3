import "react-native-gesture-handler";
import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import { GradeForm } from './app/screens/GradeForm'
import { ListGrades } from './app/screens/ListGrades';
import { createDrawerNavigator } from '@react-navigation/drawer'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import { ContenidoA } from './app/screens/ContenidoA'
import { ContenidoB } from './app/screens/ContenidoB'
import { Icon } from "@rneui/base";

const Drawer = createDrawerNavigator();
const DrawerNav = () => {
  return (
    <Drawer.Navigator>
      <Drawer.Screen
        name='DrawerGradesNav'
        component={ListGrades}
        options={{
          title: 'Materias'
        }} />
      <Drawer.Screen
        name='DrawerGradesFormNav'
        component={GradeForm}
        options={{
          title: 'Notas'
        }} />
        <Drawer.Screen
        name='Tab'
        component={TabNav}
        options={{
          title: 'Ejemplos Tab'
        }} />
    </Drawer.Navigator>
  )
}
const StackGrades = createNativeStackNavigator();
const StackNav = () => {
  return (
    <StackGrades.Navigator>
      <StackGrades.Screen name='Home' component={DrawerNav} />
      <StackGrades.Screen name='ListGradesNav' component={ListGrades} />
      <StackGrades.Screen name='GradeFormNav' component={GradeForm} />
    </StackGrades.Navigator>
  )
}

const TabBottom = createBottomTabNavigator();
const TabNav = () => {
  return (
    <TabBottom.Navigator>
      <TabBottom.Screen
        name='TabContenidoA'
        component={ContenidoA}
        options={{
          headerShown: false,
          tabBarLabel: 'Configuracion',
          tabBarIcon:()=>{
            return<Icon name='tool' size={24} color='black' type="ant-design"/>
          }
        }} />
      <TabBottom.Screen
        name='TabContenidoB'
        component={ContenidoB}
        options={{
          headerShown: false,
          tabBarLabel: 'Acerca de',
          tabBarIcon:()=>{
            return<Icon name='mail' size={24} color='black' type="ant-design"/>
          }
        }} />
    </TabBottom.Navigator>
  )
}

export default function App() {

  return (
    <NavigationContainer>
      <StackNav />
    </NavigationContainer>
  );

}


