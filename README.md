# RealtimeCharts
A simple implementation of MPCharts
How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.SHUbham23-rgb:RealtimeCharts:v1.0.0'
	}
