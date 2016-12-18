#Java ASCII Render

ASCII renderer in pure java with no external dependencies. Java ASCII Render supports graphical primitives/elements, layers, context, canvas.

```
                               EXPERIMENTAL RESULT                              
                                                                                
    Theme: Teleportation of matter through extremely dense elements             
                                                                                
    Date: 1998-11-19                                                            
    Time: 08:47                                                                 
    Subject: Gordon Freeman                                                     
                                                                                
    ┌──────────────────────────────────────┐    Observation of Einstein-Podo    
    │ 1.00┼****                       *****│    lsky-Rosen Entanglement on S    
    │ 0.75┼   ***                   ***    │    upraquantum Structures by In    
    │ 0.50┼     **                 **      │    duction Through Nonlinear Tr    
    │ 0.25┼       **             **        │    ansuranic Crystal of Extreme    
    │ 0.00┼        **           **         │    ly Long Wavelength (ELW) Pul    
    │-0.25┼         ***       ***          │    se from Mode-Locked Source A    
    │-0.50┼           *********            │    rray shows a very promising     
    │-0.75┼               *                │    result.                         
    │-1.00┼───────┼───────┼───────┼───────┼│                                    
    │     0      90      180     270    360│                 *******************
    └──────────────────────────────────────┘                 CONCLUSION: APPROVE
```

## Using
Add repository to your POM:

```xml
	<repository>
		<id>indvd00m-github-repo</id>
		<url>https://github.com/indvd00m/maven-repo/raw/master/repository</url>
	</repository>
```

Add dependency to your maven project:

```xml
	<dependency>
		<groupId>com.indvd00m.ascii.render</groupId>
		<artifactId>ascii-render</artifactId>
		<version>1.0.0</version>
	</dependency>
```

## CI
Maven artifacts are built via Travis: 
[![Build Status](https://travis-ci.org/indvd00m/java-ascii-render.svg?branch=master)](https://travis-ci.org/indvd00m/java-ascii-render)

## Available graphical elements

### Rectangle
```
┌──────────────────┐
│                  │
│                  │
│                  │
│                  │
│                  │
│                  │
│                  │
│                  │
└──────────────────┘
```
```java
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
```

### Dot
```
┌──────────────────┐
│                  │
│                  │
│                  │
│                  │
│         *        │
│                  │
│                  │
│                  │
└──────────────────┘
```
```java
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(new Dot());
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
```

### Line
```
┌──────────────────┐
│                  │
│ ●●               │
│   ●●●            │
│      ●●●         │
│         ●●●      │
│            ●●●   │
│               ●● │
│                  │
└──────────────────┘

```
```java
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(new Line(new Point(2, 2), new Point(17, 7)));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
```

### Circle
```
┌──────────────────┐
│       ***        │
│      *   *       │
│     *     *      │
│     *     *      │
│     *     *      │
│      *   *       │
│       ***        │
│                  │
└──────────────────┘
```
```java
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(new Circle(9, 4, 3));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
```

### Ellipse
```
┌──────────────────┐
│     *******      │
│   **       **    │
│                  │
│ *             *  │
│                  │
│   **       **    │
│     *******      │
│                  │
└──────────────────┘
```
```java
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(new Ellipse(9, 4, 14, 6));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
```

### Label

Single-line string.

```
┌──────────────────┐
│                  │
│                  │
│                  │
│Label with long t…│
│                  │
│                  │
│                  │
│                  │
└──────────────────┘
```
```java
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(new Label("Label with long text", 1, 4, 18));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
```

### Text

Multiline string.

```
┌──────────────────┐
│                  │
│                  │
│Lorem Ipsum is sim│
│ply dummy text of │
│the printing and …│
│                  │
│                  │
│                  │
└──────────────────┘
```
```java
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(20).height(10);
		builder.element(new Rectangle());
		builder.element(new Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry.", 1, 3, 18, 3));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
```

### PseudoText

Antialising option is customizable, enabled by default.

```
                                                ██                                                    
 ██████▒                                        ██           ██████████                         ██    
 ██ ░░██▒                                       ██               ██                             ██    
 ██   ░██                                       ██               ██                             ██    
 ██   ░██  ░▒████▓▒   ░▓███▒    ██    ██   ▒███▒██   ▒████░      ██       ░▓███▒   ▓██░░██▓   ███████ 
 ██   ░██  ▓█▓░░░▒▓  ░██░░██░   ██    ██  ░██░░███  ░██░░██░     ██      ░██░░██░  ░██▓▓██░     ██    
 ██ ░░██▒  ██▒░      ▓█▒  ░█▓   ██    ██  ▓█▒  ▒██  ▓█▒  ▒█▓     ██      ▓█▒  ░█▓   ░████░      ██    
 ██████▒   ▓████▓▒   ██░  ░██   ██    ██  ██░  ░██  ██░  ░██     ██      ██░  ░██    ▒██▒       ██    
 ██        ░▓█████▒  ████████   ██    ██  ██░  ░██  ██░  ░██     ██      ████████    ░██░       ██    
 ██           ░░▓██  ██░        ██░  ░██  ██░  ░██  ██░  ░██     ██      ██░         ▓██▓       ██    
 ██             ░██  ▓█▒        ██░  ░██  ▓█▒  ▒██  ▓█▒  ▒█▓     ██      ▓█▒        ▒████▒      ██░   
 ██        █▒░░░▓█▓  ░██▒░░▒▓   ▓█▓░░███  ░██░░███  ░██░░██░     ██      ░██▒░░▒▓  ░██▒▒██░     ▓█▒░  
 ██        ░▓████▒░   ░▓███▓░   ░▓███░██   ▒███▒██   ▒████▒      ██       ░▓███▓░  ▓██░░██▓     ░▓███ 
```
```java
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(120).height(20);
		builder.element(new PseudoText("PseudoText"));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
```

### Plot

Plot with axis and labels based on array of points.

```
┌──────────────────────────────────────────────────────────────────────────────┐
│ 3.73┼              *                                  **                     │
│     │             **                                  *                      │
│     │             *                                  **                      │
│     │            *                                  **                       │
│ 1.87┼          **                                 ***                        │
│     │       ****                               ****                          │
│     │  ******                              *****                             │
│     │***                             *******                             ****│
│-0.00┼                            *****                              ******   │
│     │                         ****                               ****        │
│     │                       ***                                 **           │
│     │                      **                                  *             │
│-1.87┼                     **                                  *              │
│     │                     *                                  **              │
│     │                    **                                  *               │
│     │                                                        *               │
│-3.73┼─────────────────┼─────────────────┼─────────────────┼─────────────────┼│
│     0                90                180               270              360│
└──────────────────────────────────────────────────────────────────────────────┘
```
```java
		List<IPlotPoint> points = new ArrayList<IPlotPoint>();
		for (int degree = 0; degree <= 360; degree++) {
			if (degree > 75 && degree < 105)
				continue;
			if (degree > 255 && degree < 285)
				continue;
			double val = Math.tan(Math.toRadians(degree));
			IPlotPoint plotPoint = new PlotPoint(degree, val);
			points.add(plotPoint);
		}
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(80).height(20);
		builder.element(new Rectangle(0, 0, 80, 20));
		builder.layer(new Region(1, 1, 78, 18));
		builder.element(new Axis(points, new Region(0, 0, 78, 18)));
		builder.element(new AxisLabels(points, new Region(0, 0, 78, 18)));
		builder.element(new Plot(points, new Region(0, 0, 78, 18)));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
```


## Download release

https://github.com/indvd00m/java-ascii-render/releases

## Release notes

### Version 0.9.0
- First release. Project reworked from https://github.com/indvd00m/java-ascii-plotter

### Version 1.0.0
- Reworking API. Add new elements.

## Roadmap

This component is developed as a hobby with no public roadmap or any guarantees of upcoming releases. That said, the following features are planned for upcoming releases:
- ...

## Issue tracking

The issues for this project are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Building and running tests
```bash
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
