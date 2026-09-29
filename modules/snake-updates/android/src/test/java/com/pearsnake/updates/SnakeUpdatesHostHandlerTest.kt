package com.pearsnake.updates

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class SnakeUpdatesHostHandlerTest {
  @After
  fun resetProvider() {
    SnakeUpdatesPackage.bundleFileProvider = null
  }

  @Test
  fun resolvesBundleAgainOnEveryReload() {
    val handler = SnakeUpdatesHostHandler()
    var bundle: String? = null
    SnakeUpdatesPackage.bundleFileProvider = { bundle }

    assertEquals("assets://index.android.bundle", handler.getJSBundleFile(false))
    bundle = "/data/first/app.bundle"
    assertEquals(bundle, handler.getJSBundleFile(false))
    bundle = "/data/second/app.bundle"
    assertEquals(bundle, handler.getJSBundleFile(false))
    bundle = null
    assertEquals("assets://index.android.bundle", handler.getJSBundleFile(false))
  }

  @Test
  fun preservesDefaultLoaderWithoutProvider() {
    assertNull(SnakeUpdatesHostHandler().getJSBundleFile(false))
  }

  @Test
  fun preservesDevelopmentLoader() {
    SnakeUpdatesPackage.bundleFileProvider = { error("Development must not load OTA") }
    assertNull(SnakeUpdatesHostHandler().getJSBundleFile(true))
  }
}
