[![Build Status](https://travis-ci.org/kkorolyov/full-doc.svg?branch=master)](https://travis-ci.org/kkorolyov/full-doc)
[![Download](https://api.bintray.com/packages/kkorolyov/groovy/full-doc/images/download.svg) ](https://bintray.com/kkorolyov/groovy/full-doc/_latestVersion)

# FullDoc
Adds a task to bundle documentation of all projects into a single output directory.

## Usage
```groovy
buildscript {
	repositories {
		maven {
			url 'https://dl.bintray.com/kkorolyov/groovy'
		}
	}
	dependencies {
		classpath 'dev.kkorolyov:full-doc:1.0'
	}
}
apply plugin: 'dev.kkorolyov.full-doc'

fulldoc {
	src "someDir"	// Source directory of root project documentation
	out "someDir"	// Output directory of bundled documentation
}

```
1. Download the plugin from the Bintray repository
2. Apply it to your `build.gradle`
3. Configure using the `fulldoc` extension
4. `gradle fulldoc`

## License
[BSD-new license](LICENSE).  
