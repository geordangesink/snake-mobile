import { NativeModules, Platform } from 'react-native'
import { reloadAppAsync } from 'expo-modules-core'
import RNRestart from 'react-native-restart'

export async function restartAfterUpdate() {
  if (Platform.OS === 'android') {
    if (!NativeModules.RNRestart) {
      throw new Error('Update applied. Close and reopen the app to finish updating.')
    }
    RNRestart.restart()
    return
  }

  await reloadAppAsync('Pear update applied')
}
