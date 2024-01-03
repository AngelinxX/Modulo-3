import { View, Text, StyleSheet, Button } from "react-native"

export const Productos = ({ navigation }) => {
    return <View style={styles.container}>
        <Text>Estoy en productos</Text>
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
        //backgroundColor: 'green',
    },
});