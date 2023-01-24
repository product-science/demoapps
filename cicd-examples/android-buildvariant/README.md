# CICD Integration based on build variant

Repository contains a demo for Product Science tool CICD integration with [Gradle 
build vairant](https://developer.android.com/studio/build/build-variants).

Build Pipeline can be found [here](../../.github/workflows/cicd-buildvariant.yml).

Full Product Science Plugin integration instruction can be found on documentation [website](https://product-science.github.io/android/gradle/).

## Integration 

The separate gradle build variant `psiRelease` for the instrumented build was created. PS Plugin will be applied only for this build variant.

```title="app/build.gradle"
productScience {
    psiRelease {
        enabled true
    }
}

android {
    defaultConfig { ... }

    buildTypes {
        release {
            ...
        }

        psiRelease {
            ...
        }
    }
```


