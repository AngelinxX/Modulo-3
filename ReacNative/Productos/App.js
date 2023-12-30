import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { Button, FlatList, TextInput, ScrollView } from 'react-native';
import { StyleSheet, Text, View, Alert } from 'react-native';

let productos = [
  { nombre: 'Arroz', categoria: 'Granos', precioCompra: '0.35', precioVenta: '0.45', id: '100' },
  { nombre: 'Azucar', categoria: 'Endulzante', precioCompra: '0.12', precioVenta: '0.21', id: '101' },
  { nombre: 'Lenteja', categoria: 'Granos', precioCompra: '0.25', precioVenta: '0.35', id: '102' },
  { nombre: 'Stevia', categoria: 'Endulzante', precioCompra: '0.45', precioVenta: '0.62', id: '103' },
  { nombre: 'Atun', categoria: 'Conservas', precioCompra: '0.60', precioVenta: '0.85', id: '104' },
]

let esNuevo = true;
let indiceSeleccionado = -1;

export default function App() {
  const [txtNombre, setTxtNombre] = useState();
  const [txtCategoria, setTxtCategoria] = useState();
  const [txtPrecioCompra, setTxtPrecioCompra] = useState();
  const [txtPrecioVenta, setTxtPrecioVenta] = useState();
  const [txtId, setTxtId] = useState();
  const [numProducto, setNumProducto] = useState(productos.length);

  let ItemProducto = (props) => {
    return (
      <View style={styles.contenidoProd}>
        <View style={styles.indiceProd}>
          <Text>{props.producto.id}</Text>
        </View>
        <View style={styles.infoProd}>
          <Text>{props.producto.nombre}</Text>
          <Text>{props.producto.categoria}</Text>
        </View>
        <View style={styles.precioProd}>
          <Text>$ {props.producto.precioVenta}</Text>
        </View>
        <View style={styles.botonesProd}>
          <Button
            title='E'
            color="lightseagreen"
            onPress={() => {
              setTxtNombre(props.producto.nombre);
              setTxtCategoria(props.producto.categoria);
              setTxtPrecioCompra(props.producto.precioCompra);
              setTxtId(props.producto.id);
              setTxtPrecioVenta(props.producto.precioVenta);
              esNuevo = false;
              indiceSeleccionado = props.indice;
              console.log("arreglo", indiceSeleccionado);
            }}
          />
          <Button
            title='X'
            color="lightcoral"
            onPress={() => {
              indiceSeleccionado = props.indice;
              productos.splice(indiceSeleccionado, 1);
              setNumProducto(productos.length);
              console.log("arreglo", indiceSeleccionado);
            }}
          />
        </View>
      </View>);
  }


  let limpiar = () => {
    setTxtNombre(null);
    setTxtCategoria(null);
    setTxtId(null);
    setTxtPrecioCompra(0);
    setTxtPrecioVenta(null);
    esNuevo = true;
  }

  let existeProducto = () => {
    for (let i = 0; i < productos.length; i++) {
      if (productos[i].id == txtId) {
        return true;
      }
    }
    return false;
  }
  let guardarProducto = () => {
    if (txtCategoria !== null && txtId !== null && txtNombre !== null && txtPrecioCompra !== null && txtPrecioVenta !== null) {
      if (esNuevo) {
        if (existeProducto()) {
          Alert.alert("INFO", "Ya existe un producto con el id " + txtId);
        } else {
          let producto = { nombre: txtNombre, categoria: txtCategoria, precioCompra: txtPrecioCompra, precioVenta: txtPrecioVenta, id: txtId }
          productos.push(producto);
        }
      } else {
        productos[indiceSeleccionado].nombre = txtNombre;
        productos[indiceSeleccionado].categoria = txtCategoria;
        productos[indiceSeleccionado].precioCompra = txtPrecioCompra;
        productos[indiceSeleccionado].precioVenta = txtPrecioVenta;
      }
      limpiar();
      setNumProducto(productos.length);
    } else {
      Alert.alert("INFO", "Completar todos los campos");
    }
  }
  return (
    <ScrollView>
      <View style={styles.container}>
        <View style={styles.cabeceraDatos}>
          <Text style={styles.textTitulo}>PRODUCTOS</Text>
          <View>
            <TextInput
              style={styles.cajaIngreso}
              value={txtId}
              placeholder='CODIGO'
              onChangeText={setTxtId}
              keyboardType='numeric'
              editable={esNuevo}
            />
            <TextInput
              style={styles.cajaIngreso}
              value={txtNombre}
              placeholder='NOMBRE'
              onChangeText={setTxtNombre}
            />
            <TextInput
              style={styles.cajaIngreso}
              value={txtCategoria}
              placeholder='CATEGORIA'
              onChangeText={setTxtCategoria}
            />
            <TextInput
              style={styles.cajaIngreso}
              value={txtPrecioCompra}
              placeholder='PRECIO DE COMPRA'
              onChangeText={(txtPrecioCompra) => {
                let precioDeVenta = () => {
                  compra = parseFloat(txtPrecioCompra);
                  venta = compra * 1.20;
                  decimal = venta.toFixed(2);
                  precioV = decimal.toString();
                  console.log(precioV);
                  return precioV;
                }
                setTxtPrecioVenta(precioDeVenta);
                setTxtPrecioCompra(txtPrecioCompra)
              }}
              keyboardType='numeric'
            />
            <TextInput
              style={styles.cajaIngreso}
              value={txtPrecioVenta}
              placeholder='PRECIO DE VENTA'
              editable={false}
            />
          </View>
          <View style={styles.botones}>
            <Button
              title='NUEVO'
              onPress={() => {
                limpiar();
              }}
            />
            <Button
              title='GUARDAR'
              onPress={() => {
                guardarProducto();
              }}
            />
            <Text>
              productos: {numProducto}
            </Text>
          </View>
        </View>
        <View style={styles.contenidoCajas}>
          <FlatList
            data={productos}
            renderItem={(elemento) => {
              return <ItemProducto indice={elemento.index} producto={elemento.item} />
            }}
            keyExtractor={(item) => {
              return item.id;
            }}
          />
        </View>
        <View style={styles.pieDePagina}>
          <Text>Autor Angel Fajardo</Text>
        </View>
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    flexDirection: 'column',
    justifyContent: 'center',
    paddingTop: 20,
    margin: 20
  },
  cabeceraDatos: {
    flex: 5,
    flexDirection: 'column',
    paddingBottom: 10
  },
  cajaIngreso: {
    borderWidth: 1,
    borderColor: 'grey',
    //backgroundColor: 'wheat',
    borderRadius: 5,
    paddingLeft: 7,
    margin: 5
  },
  contenidoCajas: {
    flex: 6,
  },
  contenidoProd: {
    flexDirection: 'row',
    borderWidth: 1,
    borderColor: 'blue',
    backgroundColor: 'powderblue',
    borderRadius: 5,
    padding: 5,
    margin: 5,
  },
  indiceProd: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    fontSize: 16,
    padding: 5
  },
  infoProd: {
    flex: 2,
    flexDirection: 'column',
    //backgroundColor:'blue',
    justifyContent: 'center',
    fontSize: 16,
  },
  precioProd: {
    flex: 2,
    //backgroundColor: 'blue',
    justifyContent: 'center',
    alignItems: 'flex-end',
    marginRight: 10,
    fontSize: 16,
  },
  botonesProd: {
    flex: 2,
    flexDirection: 'row',
    justifyContent: 'space-evenly'
  },
  pieDePagina: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'flex-end'
  },

  botones: {
    flexDirection: 'row',
    justifyContent: 'space-evenly',
    alignItems: 'center',
    paddingTop: 20
  },



  textTitulo: {
    fontSize: 24
  },
  textPrincipal: {
    fontSize: 18,
  },
  textSecundario: {
    fontSize: 16,
    fontWeight: 'bold',
    fontStyle: 'italic'
  }
});
