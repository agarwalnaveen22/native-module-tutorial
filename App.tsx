/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, {useCallback} from 'react';
import {StyleSheet, Text, View, NativeModules, Button} from 'react-native';

const DeviceModule = NativeModules.Device;

function App(): JSX.Element {
  const getDisplayInfo = useCallback(async () => {
    try {
      const response = await DeviceModule.getDisplayInfo();
      console.log(response);
    } catch (error) {
      console.error(error);
    }
  }, []);

  return (
    <View style={styles.mainContainer}>
      <Text>Native Tutorial</Text>
      <Button title="Get Display Info" onPress={getDisplayInfo} />
    </View>
  );
}

const styles = StyleSheet.create({
  mainContainer: {
    justifyContent: 'center',
    alignItems: 'center',
  },
});

export default App;
