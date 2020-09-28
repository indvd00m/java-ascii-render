# Java ASCII Render

[![Maven Central](https://img.shields.io/maven-central/v/com.indvd00m.ascii.render/ascii-render.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.indvd00m.ascii.render%22%20AND%20a:%22ascii-render%22)
[![Build Status](https://travis-ci.org/indvd00m/java-ascii-render.svg?branch=master)](https://travis-ci.org/indvd00m/java-ascii-render)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.indvd00m.ascii.render%3Ajava-ascii-render&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.indvd00m.ascii.render%3Ajava-ascii-render)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=com.indvd00m.ascii.render%3Ajava-ascii-render&metric=ncloc)](https://sonarcloud.io/dashboard?id=com.indvd00m.ascii.render%3Ajava-ascii-render)
![GitHub](https://img.shields.io/github/license/indvd00m/java-ascii-render)

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

## Download and Install

To download and install Java ASCII Render you currently have the following options.

**Maven**

Add dependency to `com.indvd00m.ascii.render:ascii-render`:

```xml
	<dependency>
		<groupId>com.indvd00m.ascii.render</groupId>
		<artifactId>ascii-render</artifactId>
		<version>2.1.3</version>
	</dependency>
```

**Plain-old JAR**

Download the following JARs and add them to your classpath:

 * [ascii-render.jar](https://search.maven.org/search?q=g:%22com.indvd00m.ascii.render%22%20AND%20a:%22ascii-render%22)
 * [ascii-render-api.jar](https://search.maven.org/search?q=g:%22com.indvd00m.ascii.render%22%20AND%20a:%22ascii-render-api%22)

## Compatibility

Java ASCII Render requires Java 6 (or higher). 

## Available graphical elements and usage examples

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
			if (degree > 75 && degree < 105) {
				continue;
			}
			if (degree > 255 && degree < 285) {
				continue;
			}
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

### Table

Table with rows and columns.

```
┌────────┬────────┬────────┬────────┐
│12345678│        │        │        │
├────────┼────────┼────────┼────────┤
│        │        │        │        │
├────────╆━━━━━━━━╅────────╆━━━━━━━━┪
│        ┃        ┃        ┃1234567…┃
└────────┺━━━━━━━━┹────────┺━━━━━━━━┛
```
```java
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(37).height(7);
		Table table = new Table(4, 3);
		table.setElement(1, 1, new Label("1234567890"));
		table.setElement(4, 3, new Text("1234567890"), true);
		table.setHighlighted(2, 3, true);
		builder.element(table);
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
```

### Overlay

Possibility to combine results of several renders.

```
┌──────────────────┐
│                  │
│                  │
│Lore┌───────┐s sim│
│ply │Overlay│t of │
│the └───────┘and …│
│                  │
│                  │
│                  │
└──────────────────┘
```
```java
		IRender render1 = new Render();
		IContextBuilder builder1 = render1.newBuilder();
		builder1.width(9).height(3);
		builder1.element(new Rectangle());
		builder1.element(new Text("Overlay", 1, 1, 7, 1));
		ICanvas canvas1 = render1.render(builder1.build());

		IRender render2 = new Render();
		IContextBuilder builder2 = render2.newBuilder();
		builder2.width(20).height(10);
		builder2.element(new Rectangle());
		builder2.element(
				new Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry.", 1, 3, 18, 3));
		builder2.element(new Overlay(5, 3, canvas1, true));
		ICanvas canvas2 = render2.render(builder2.build());
		String s = canvas2.getText();
		System.out.println(s);
```

### PseudoCanvas

In some cases you can get better results by synthetic increasing of "pixel resolution". This is possible by calling 
`render.setPseudoCanvas(true)` method. After that render would use `▖▗▘▙▚▛▜▝▞▟▄▐▌▀█ ` chars for drawing 4 points in 1 char. 
This is would work only if you do not use any special symbols for drawing (but you still can use Overlay to combine 
two different renders).

Example 1: line in 30x10 resolution:
```
██                            
  ███                         
     ████                     
         ███                  
            ███               
               ███            
                  ███         
                     ████     
                         ███  
                            ██
```
```java
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(30).height(10);
		builder.element(new Line(new Point(0, 0), new Point(29, 9), '█'));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
```
And same line in 60x20 resolution:
```
▀▄▖                           
  ▝▀▄▖                        
     ▝▀▄▄                     
         ▀▚▄                  
            ▀▚▄               
               ▀▚▄            
                  ▀▚▄         
                     ▀▀▄▖     
                        ▝▀▄▖  
                           ▝▀▄
```
```java
		IRender render = new Render();
		render.setPseudoCanvas(true);
		IContextBuilder builder = render.newBuilder();
		builder.width(60).height(20);
		builder.element(new Line(new Point(0, 0), new Point(59, 19)));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
```

Example 2: pseudo text in 60x10 resolution:
```
                                                            
                          █                                 
 ███                      █      █████                      
 █  █                     █        █               █        
 █  █ ████   ██  █  █   ███  ██    █    ██  █  █  ████      
 ███  █     █  █ █  █  █  █ █  █   █   █  █  ██    █        
 █     ███  ████ █  █  █  █ █  █   █   ████  ██    █        
 █       █  █    █  █  █  █ █  █   █   █     ██    █        
 █    ████   ███ ████   ███  ██    █    ███ █  █   ███      
                                                            
```
```java
		IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(60).height(10);
		builder.element(new PseudoText("PseudoText", false));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);
```
And same pseudo text in 120x20 resolution:
```
                                                            
                                                            
                        ▄                                   
▐▛▀▙                    █      ▀▀█▀▀            ▐▌          
▐▌ ▐▌ ▗▄▄   ▄▄  ▄  ▄  ▄▖█  ▗▄▖   █   ▗▄▖  ▄▖▗▄ ▗▟▙▄         
▐▌ ▟▘▐▌  ▘ ▟▘▝▙ █  █ ▟▘▝█ ▗▛ ▜▖  █  ▗▛ ▜▖ ▝██▘  ▐▌          
▐▛▀▘ ▝██▙▖ █▄▄█ █  █ █  █ ▐▌ ▐▌  █  ▐▙▄▟▌  ▐▌   ▐▌          
▐▌      ▜▌ █    █  █ █  █ ▐▌ ▐▌  █  ▐▌     ██   ▐▌          
▐▌   ▝▄▄▞▘ ▝▙▄▞ ▜▙▞█ ▝▙▞█  ▜▄▛   █   ▜▄▄▘ ▟▌▐▙  ▝▙▄         
                                                            
```
```java
		IRender render = new Render();
		render.setPseudoCanvas(true);
		IContextBuilder builder = render.newBuilder();
		builder.width(120).height(20);
		builder.element(new PseudoText("PseudoText", false));
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

### Version 1.1.0
- Add PseudoText element.
- Use Bresenham's algorithm for line drawing.

### Version 1.2.0
- Simplify extending existing elements.

### Version 1.2.1
- Pass axis type to format method in AxisLabels element.

### Version 1.2.2
- Add deploy to maven central.

### Version 1.2.3
- Add url to pom's.

### Version 1.2.4
- Add some useful methods to builder.

### Version 1.3.0
- Add table element.

### Version 1.4.0
- Add overlay element.
- Added possibility to trim canvas.
- Simplified extending of existing implementation.

### Version 1.5.0
- Improved canvas draw performance.

### Version 2.0.0
- Canvas now is empty by default - contains only \0 and \n symbols. Previous Canvas implementation contained \s and 
\n symbols. This new changes break backward compatibility for drawing behavior in some cases (but do not break compile 
time API compatibility). Now overlapping of layers would work correctly when you directly draw spaces \s to layer.
- Added opacity for layers.

### Version 2.1.0
- Added table cells highlighting.

### Version 2.1.1
- Added some useful constructors.

### Version 2.1.2
- Fixed javadoc.

### Version 2.1.3
- Simplified extending of Table element.

## Roadmap

This component is developed as a hobby with no public roadmap or any guarantees of upcoming releases. That said, the following features are planned for upcoming releases:
- PseudoCanvas and PseudoElement (increasing "pixel" resolution by using `▖▗▘▙▚▛▜▝▞▟` chars).
- Fluent API for elements.

## Issue tracking

The issues for this project are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Building and running tests
```bash
git clone https://github.com/indvd00m/java-ascii-render.git
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
