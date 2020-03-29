# XOF API client v1.0-SNAPSHOT

[![Coverage](https://codecov.io/gh/dan-zx/xof-api-client/branch/develop/graph/badge.svg)](https://codecov.io/gh/dan-zx/xof-api-client)
[![Build Status](https://api.travis-ci.com/dan-zx/xof-api-client.svg?branch=develop)](https://travis-ci.com/dan-zx/xof-api-client)
[![License](https://img.shields.io/badge/licence-Apache_Licence_2.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

Client to use the XOF API in Kotlin/Java applications

Modules
-------

* `xof-client`: contains the client abstract API
* `xof-client-core`: implements the client API (currently with Retrofit)
* `xof-client-spring-boot-starter`: Spring auto-configuration to integrate the client into Spring applications

Prerequisites
-------------

  * JDK11+

Build the project
-----------------

```sh
$ ./gradlew clean build
```

Usage
-----

## Without Spring Boot

1. Download the latest `xof-client-core` JAR via Maven:

  ```xml
  <dependency>
    <groupId>com.github.danzx.xof</groupId>
    <artifactId>xof-client-core</artifactId>
    <version>${version}</version>
  </dependency>
  ```

  or Gradle:

  ```groovy
  implementation "com.github.danzx.xof:xof-client-core:${version}"
  ```

2. Configure a client factory to create a new instance of the client

  > The only required configuration parameter is the baseUrl

  ```kotlin
  val client = XofClientRetrofitFactory(
    config {
      baseUrl = "http://localhost:8080/"
      // Default values
      logger { level = NONE }
      cache { size = 10.megabytes }
      connection {
        readTimeout = 10.seconds
        writeTimeout = 10.seconds
        connectTimeout = 10.seconds
        callTimeout = 0.nanoseconds
      }
    })
    .create()
  ```

3. Use the client

  ```kotlin
  if (client.isServiceAvailable) {
    val user = client.usersApi.getByUsername("username")
  }
  ```

## In Spring Boot applications

1. Download the latest `xof-client-spring-boot-starter` JAR via Maven:

  ```xml
  <dependency>
    <groupId>com.github.danzx.xof</groupId>
    <artifactId>xof-client-spring-boot-starter</artifactId>
    <version>${version}</version>
  </dependency>
  ```

  or Gradle:

  ```groovy
  implementation "com.github.danzx.xof:xof-client-spring-boot-starter:${version}"
  ```

2. Configure the client using `application.properties`

  > The only required configuration parameter is the base-url

  ```properties
  xof-client.base-url=http://localhost:8081/api/v1/

  # Default values
  xof-client.connection.read-timeout=10s
  xof-client.connection.write-timeout=10s
  xof-client.connection.connect-timeout=10s
  xof-client.connection.call-timeout=0ns
  xof-client.logger.enabled=false
  xof-client.logger.level=none
  xof-client.cache.enabled=false
  xof-client.cache.size=10MB
  ```

3. Inject the client in your bean

  ```kotlin
  @Autowired lateinit var client: XofClient
  ```

License
-------

    Copyright 2020 Daniel Pedraza-Arcega

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
