# Let me Serenade you ♪

#### [View Releases and Changelogs](https://github.com/ThanosFisherman/serenador/releases)

[![Maven Central](https://img.shields.io/maven-central/v/io.github.thanosfisherman.serenador?label=Gradle&style=for-the-badge)](https://repo1.maven.org/maven2/io/github/thanosfisherman/serenador/serenador-plugin/)
[![Hex.pm](https://img.shields.io/hexpm/l/plug?style=for-the-badge)]((https://opensource.org/licenses/Apache-2.0))

--------------

### :rotating_light:Currently only functional on Mac OS:rotating_light:

**Serenador** is a Gradle plugin that utilizes text-to-speech to give you feedback about your project's build status. Once installed you will be notified accordingly either when your build succeeds or fails. Highly inspired by [saydle](https://github.com/handstandsam/saydle).

### Prerequisites
As Serenador is currently available only for Mac PC's it's highly recommended that you install the **English (United States) -- Novelty** voices via **Accesibility** settings for extra fun. 🥳

![image](https://user-images.githubusercontent.com/4888330/145729718-3f2b4652-b8ce-4352-ba3c-f010e0401a3c.png)

Installation
---------------

**Using the [plugins DSL:](https://docs.gradle.org/current/userguide/plugins.html#sec:plugins_block)**

```kotlin
plugins {
  id("io.github.thanosfisherman.serenador") version "1.0
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
    classpath("io.github.thanosfisherman.serenador:serenador-plugin:1.0")
  }
}

apply(plugin = "io.github.thanosfisherman.serenador")
```

Usage
---------

Under Construction...

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
