# Demo Apps Overview

Product Science Demo Apps highlighting code optimization exercises

These versions are instrumented- follow docs to update instrumentation:  
https://product-science.github.io/  

- `simple-android-app-mt` - app name `PSI MT`: demo with delay on separate thread but blocking fast app execution
- `simple-android-app-mt-fixed` - app name `PSi MT Fixed`: demo with delay synchronous separate enabling improved performance

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