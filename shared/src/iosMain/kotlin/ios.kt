package com.example

import platform.UIKit.UIDevice

actual fun platformName(): String{
    return "${UIDevice.currentDevice.systemName()}"
}