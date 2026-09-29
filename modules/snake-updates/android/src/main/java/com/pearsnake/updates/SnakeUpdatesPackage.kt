package com.pearsnake.updates

import android.content.Context
import expo.modules.core.interfaces.Package
import expo.modules.core.interfaces.ReactNativeHostHandler

class SnakeUpdatesPackage : Package {
  companion object {
    var bundleFileProvider: (() -> String?)? = null
  }

  override fun createReactNativeHostHandlers(context: Context): List<ReactNativeHostHandler> {
    return listOf(SnakeUpdatesHostHandler())
  }
}

internal class SnakeUpdatesHostHandler : ReactNativeHostHandler {
  override fun getJSBundleFile(useDeveloperSupport: Boolean): String? {
    if (useDeveloperSupport) return null
    val provider = SnakeUpdatesPackage.bundleFileProvider ?: return null
    return provider() ?: "assets://index.android.bundle"
  }
}
