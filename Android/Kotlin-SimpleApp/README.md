# Demo Apps Overview

Product Science Demo Apps highlighting code optimization exercises

These versions are instrumented- follow docs to update instrumentation:  
https://product-science.github.io/  

- `psi-simpleapp-lag` - app name `PSi-Lag.apk`: Kotlin demo with work dispatched to a separate thread blocking main thread
- `psi-simpleapp-fixed` - app name `PSi-Fixed.apk`: Kotlin demo with work dispatched to a separate thread working in parallel and not blocking main thread
# Instructions

## Step 1: Configure Build Environment With PSi Instrumentation And Tokens

A set of tokens from PSi is required to build- speak to your Sales Engineer or Rep for access..

Once you have the tokens, follow the instructions for configuring your build env:  
https://product-science.github.io/  

This will entail editing `build.gradle` files, `androidmanifest.xml`, and other typical changes.  

## Step 2: Build App Using Gradle on Mac

```bash
gradle clean
gradle wrapper --gradle-version=7.5.1
gradle assembleRelease
```

## Step 3: Sign Apps

```bash
keytool -genkey -v -keystore my-release-key.keystore -alias mykey -keyalg RSA -keysize 2048 -validity 100
```

```bash
~/Library/Android/sdk/build-tools/32.0.0/apksigner sign -ks my-release-key.keystore ./app/build/outputs/apk/release/*.apk
```

## Step 4: Install .APK On Phone

### App build location

`app -> build -> outputs -> apk/release -> [filename].apk`

### Enable Framecounter / Timecode

PSi instrumented apps have a framecounter or time code written on the app for correlating visual frames to code traces.  
To enable:  

`Preferences -> App -> [PSI app] -> Appear On Top -> Enable`