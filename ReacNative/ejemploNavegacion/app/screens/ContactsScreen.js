import { View, Text, StyleSheet, Button } from "react-native"

export const Contacts = ({ navigation }) => {
    return <View style={styles.container}>
        <Text>Estoy en contacts</Text>
        <Button
            title="IR A HOME"
            onPress={() => {
                navigation.navigate('HomeNav');
            }}
        />
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
});
