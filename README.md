#Java ASCII Render

ASCII render in pure java with no external dependencies.


## Using
Add repository to your POM:

	<repository>
		<id>indvd00m-github-repo</id>
		<url>https://github.com/indvd00m/maven-repo/raw/master/repository</url>
	</repository>

Add dependency to your maven project:

	<dependency>
		<groupId>com.indvd00m.ascii.render</groupId>
		<artifactId>ascii-render</artifactId>
		<version>0.9.0</version>
	</dependency>

## CI
Maven artifacts are built via Travis: 
[![Build Status](https://travis-ci.org/indvd00m/java-ascii-render.svg?branch=master)](https://travis-ci.org/indvd00m/java-ascii-render)

## Download release

https://github.com/indvd00m/java-ascii-render/releases

## Release notes

### Version 0.9.0
- First release. Project reworked from https://github.com/indvd00m/java-ascii-plotter

## Roadmap

This component is developed as a hobby with no public roadmap or any guarantees of upcoming releases. That said, the following features are planned for upcoming releases:
- ...

## Issue tracking

The issues for this project are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Building and running tests
```
git clone https://github.com/indvd00m/java-ascii-render/
cd java-ascii-render
mvn clean install
```

## Contributions

Contributions are welcome, but there are no guarantees that they are accepted as such. Process for contributing is the following:
- Fork this project
- Create an issue to this project about the contribution (bug or feature) if there is no such issue about it already. Try to keep the scope minimal.
- Develop and test the fix or functionality carefully. Only include minimum amount of code needed to fix the issue.
- Refer to the fixed issue in commit
- Send a pull request for the original project
- Comment on the original issue that you have implemented a fix for it

## License & Author

Java ASCII Render is distributed under Apache License 2.0. For license terms, see LICENSE.

Java ASCII Render is written by David E. Veliev.
