package com.pearsnake.updates

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class SnakeUpdatesModule : Module() {
  override fun definition() = ModuleDefinition {
    Name("SnakeUpdates")
    Constant("canReload") { SnakeUpdatesPackage.bundleFileProvider != null }
  }
}
