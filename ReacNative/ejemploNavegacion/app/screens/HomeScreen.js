import { View, Text, StyleSheet, Button } from "react-native"

export const Home = ({ navigation }) => {
    return <View style={styles.container}>
        <Text>HOME</Text>
        <View style={styles.areaBotones}>
            <Button
            style={styles.boton}
                title='CONTACTOS'
                onPress={() => {
                    navigation.navigate('ContactsNav');
                }}
            />
            <Button
                title='PRODUCTOS'
                onPress={() => {
                    navigation.navigate('ProductosNav');
                }}
            />
        </View>
    </View>
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        //backgroundColor: 'grey',
        flexDirection: "column",//eje principal es el vertical
        justifyContent:"center", //vertical
        alignItems: "center", // eje horizontal
        paddingHorizontal:10
    },
    areaBotones: {
        //backgroundColor: 'blue',
        flexDirection: 'row',
        alignItems: 'space-evenly',
        padding: 30,
        gap:50
    },
    boton:{
        backgroundColor: 'yellow'
    }

});
