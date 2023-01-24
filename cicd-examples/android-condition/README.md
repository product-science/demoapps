# CICD Integration based on conditional plugin apply

Repository contains a demo for Product Science tool CICD integration with conditional plugin applying.

Build Pipeline can be found [here](../../.github/workflows/cicd-condition.yml).

Full Product Science Plugin integration instruction can be found on documentation [website](https://product-science.github.io/android/gradle/).

## Integration 

PS Plugin is applied only when the value of environment variable `USE_PSTOOL` set to `true`.

```title="app/build.gradle"
plugins {
    id 'com.android.application'
    id 'kotlin-android'
}

if (System.getenv("USE_PSTOOL")) {
    apply plugin: "com.productscience.transformer.plugin" 
}
```


