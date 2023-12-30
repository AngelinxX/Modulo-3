import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { FlatList } from 'react-native';
import { StyleSheet, Text, View, TextInput, Button, Alert } from 'react-native';

let personas = [
  { nombre: 'Thor', apellido: 'Thillas', cedula: '0242342342' },
  { nombre: 'Amber', apellido: 'Flores', cedula: '1723432442' },
  { nombre: 'Peter', apellido: 'Parker', cedula: '0732131243' }
]

let esNuevo = true;
// variable almacena el indice del arreglo del elemento seleccionado para edicion
let indiceSeleccionado = -1;

export default function App() {
  const [txtCedula, setTextCedula] = useState();
  const [txtNombre, setTextNombre] = useState();
  const [txtApellida, setTextApellido] = useState();
  const [numElemento, setNumElemento] = useState(personas.length);

  let ItemPersona = (props) => {
    return (
      <View style={styles.itemPersona}>
        <View style={styles.itemIndice}>
          <Text style={styles.textoSecundario}> {props.indice}</Text>
        </View>
        <View style={styles.itemContenido}>
          <Text style={styles.textoPrincipal}>{props.persona.nombre} {props.persona.apellido}</Text>
          <Text style={styles.textoSecundario}>{props.persona.cedula}</Text>
        </View>
        <View style={styles.itemBotones}>
          <Button
            title='E'
            color="lightseagreen"
            onPress={() => {
              setTextCedula(props.persona.cedula);
              setTextNombre(props.persona.nombre);
              setTextApellido(props.persona.apellido);
              esNuevo = false;
              indiceSeleccionado = props.indice;
              console.log("arreglo persona", indiceSeleccionado);
            }}
          />
          <Button
            title='X'
            color="lightcoral"
            onPress={() => {
              indiceSeleccionado = props.indice;
              personas.splice(indiceSeleccionado, 1);
              console.log("arreglo persona", personas);
              setNumElemento(personas.length);
            }}
          />
        </View>
      </View>);
  }

  let limpiar = () => {
    setTextCedula(null);
    setTextNombre(null);
    setTextApellido(null);
    esNuevo = true;
  }

  let existePersona = () => {
    for (let i = 0; i < personas.length; i++) {
      if (personas[i].cedula == txtCedula) {
        return true;
      }
    }
    return false;
  }

  let guardarPersona = () => {
    if (esNuevo) {
      if (existePersona()) {
        Alert.alert("INFO", "Ya existe una persona con la cedula " + txtCedula);
      } else {
        let persona = { nombre: txtNombre, apellido: txtApellida, cedula: txtCedula }
        personas.push(persona);
      }
    } else {
      personas[indiceSeleccionado].nombre = txtNombre;
      personas[indiceSeleccionado].apellido = txtApellida;
    }
    limpiar();
    setNumElemento(personas.length);
  }
  return (
    <View style={styles.container}>
      <View style={styles.areaCabecera}>
        <Text>PERSONAS</Text>
        <TextInput
          style={styles.txt}
          value={txtCedula}
          placeholder='Ingrese su cedula'
          onChangeText={setTextCedula}
          keyboardType='numeric'
          editable={esNuevo}
        />
        <TextInput
          style={styles.txt}
          value={txtNombre}
          placeholder='Ingrese su nombre'
          onChangeText={setTextNombre}
        />
        <TextInput
          style={styles.txt}
          value={txtApellida}
          placeholder='Ingrese su apellido'
          onChangeText={setTextApellido}
        />
        <View style={styles.areaBotones}>
          <Button
            title="Guardar"
            onPress={() => {
              guardarPersona();
            }}
          />
          <Button
            title="Nuevo"
            onPress={() => {
              limpiar();
            }}
          />
        </View>
        <Text>Elementos Disponibles:{numElemento}</Text>
      </View>
      <View style={styles.areaContenido}>
        <FlatList // crea una lista segun la informacion recibida
          style={styles.lista}
          data={personas} //contiene el array de toda la informacion
          renderItem={(obj) => { //es una funcion que devuelve una vista o componente que renderiza la celda  
            return <ItemPersona indice={obj.index} persona={obj.item} />
          }}
          keyExtractor={(item) => {// retornar un item que no se repita
            return item.cedula;
          }}
        />
      </View>
      <View style={styles.areaPie}>
        <Text>ESTE ES EL PIE</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    //backgroundColor: 'lightblue',
    flexDirection: 'column',//eje principal vertical
    justifyContent: 'flex-start',
    alignContent: 'stretch',
    paddingTop: 50,
    paddingHorizontal: 30,
  },
  lista: {
    //backgroundColor: 'lightpink'
  },
  itemPersona: {
    backgroundColor: 'lemonchiffon',
    marginBottom: 10,
    padding: 5,
    flexDirection: 'row'
  },
  textoPrincipal: {
    fontSize: 20
  },
  textoSecundario: {
    fontStyle: 'italic',
    fontSize: 16
  },
  areaCabecera: {
    flex: 4,
    //backgroundColor: 'chartreuse',
    justifyContent: 'center'
  },
  areaContenido: {
    flex: 6,
    //backgroundColor: 'coral'
  },
  areaPie: {
    flex: 1,
    //backgroundColor: 'cornflowerblue',
    justifyContent: 'center',
    alignItems: 'flex-end'
  },
  itemIndice: {
    flex: 1,
    //backgroundColor: 'crimson',
    justifyContent: 'center',
    alignItems: 'center',
    paddingRight: 12
  },
  itemContenido: {
    flex: 8,
    //backgroundColor: 'gold',
    paddingLeft: 5
  },
  txt: {
    borderWidth: 1,
    borderColor: 'grey',
    paddingTop: 5,
    paddingHorizontal: 5,
    marginBottom: 5

  },
  areaBotones: {
    flexDirection: 'row',
    justifyContent: 'space-evenly'
  },
  itemBotones: {
    flexDirection: 'row',
    //backgroundColor: 'darkorange',
    flex: 2,
    alignItems: 'center',
    justifyContent: 'space-between',
    paddingLeft: 5
  }

});
