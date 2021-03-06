# Let me serenade you 🎶

#### [View Releases and Changelogs](https://github.com/ThanosFisherman/serenador/releases)

[![Gradle Plugins Portal](https://img.shields.io/maven-metadata/v?color=Green&label=Gradle%20Plugins%20Portal&metadataUrl=https%3A%2F%2Fplugins.gradle.org%2Fm2%2Fio%2Fgithub%2Fthanosfisherman%2Fserenador%2Fio.github.thanosfisherman.serenador.gradle.plugin%2Fmaven-metadata.xml&style=for-the-badge)](https://plugins.gradle.org/plugin/io.github.thanosfisherman.serenador)
[![Hex.pm](https://img.shields.io/hexpm/l/plug?style=for-the-badge&color=Green)](https://opensource.org/licenses/Apache-2.0)

--------------

### :rotating_light:Currently functional on Mac OSX and Linux:rotating_light:

**Serenador** is a Gradle plugin that utilizes text-to-speech to give you feedback about your project's build status. Once installed you will be notified accordingly either when your build succeeds or fails. Inspired by [saydle](https://github.com/handstandsam/saydle).

### Demo

https://user-images.githubusercontent.com/4888330/147281809-4e47ce25-1068-4b2d-9317-1c27106a880a.mov

Prerequisites
---------------

### MacOS

Serenador leverages `say` command on Mac PCs under the hood. Moreover it's highly recommended that you install the **English (United States) -- Novelty** voices via **Accesibility** settings for extra fun. 🥳

![image](https://user-images.githubusercontent.com/4888330/145729718-3f2b4652-b8ce-4352-ba3c-f010e0401a3c.png)

### Linux (Preferably Ubuntu derivatives)
Serenador leverages `spd-say` command from [speechd](https://github.com/brailcom/speechd) which usually comes pre-installed on most ubuntu-based distros. If it's not you can install it via the following command

`sudo apt-get install speech-dispatcher`

### Windows

Under Construction...

Installation
---------------

**Using the [plugins DSL:](https://docs.gradle.org/current/userguide/plugins.html#sec:plugins_block)**

```kotlin
plugins {
  id("io.github.thanosfisherman.serenador") version "1.2"
}
```

**Using the [legacy plugin application:](https://docs.gradle.org/current/userguide/plugins.html#sec:old_plugin_application)**

```kotlin
buildscript {
  repositories {
    maven {
      url = uri("https://plugins.gradle.org/m2/")
    }
  }
  dependencies {
    classpath("io.github.thanosfisherman.serenador:serenador-plugin:1.2")
  }
}

apply(plugin = "io.github.thanosfisherman.serenador")
```

Usage
---------

You don't really need to do anything else after installing (including) the plugin into your gradle scripts. However some basic configuration is also supported if you want to be adventurous enough!

```kotlin
serenadorExtension {
    shutTheFuckUp(true) // makes the plugin shut up

    // you can add your own phrases thus overriding the default ones.
    // once you do that serenador will use the default voice currently selected in your machine.
    phraseBook {
           addSuccessPhrase("Success1")
           addSuccessPhrase("Success2")
           addFailPhrase("EPIC FAIL 1")
           addFailPhrase("EPIC FAIL 2")
    }
}
```

License
-------
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)

    Copyright 2021 Thanos Psaridis

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
