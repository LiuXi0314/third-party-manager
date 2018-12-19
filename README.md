## third-party-manager
第三方平台功能集合
[![](https://jitpack.io/v/LiuXi0314/third-party-manager.svg)](https://jitpack.io/#LiuXi0314/third-party-manager)

# How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Gradle:

Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency:
```
	dependencies {
	        implementation 'com.github.LiuXi0314:third-party-manager:0.0.2'
	}
```
