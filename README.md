# SatisPatty
Create satisfying patterns just how you like it.  
Welcome to the project! Thank you for showing interest and considering using it!

Table of contents:
1. [What is it? What does it do?](#1-what-is-it-what-does-it-do)
2. [How to get started?](#2-how-to-get-started)
3. [Documentation](#3-documentation)  
3.1 [Variables](#31-variables)  
3.2 [Functions and methods](#32-functions-and-methods)
4. [How to contribute?](#4-how-to-contribute)
5. [Thank you](#5-thank-you)

## 1 What is it? What does it do?
Here is a short summary: Basically it is just a fun project to create mesmerizing patterns and animations.  
Does it really serve a purpose? Not really. But sometimes fun is purpose enough! Additionally working on fun projects is the best way to learn. And maybe along the way we will find ways to visualize abstract concepts and other actually useful things.

Now a more detailed explanation: The concept is that an empty window is created which will be filled with awesome patterns. This process takes some time and this is the fun part. It is really mesmerizing to watch what you have previously planned out, slowly take shape. The project offers lots of different ways to express your ideas and we hope that your imagination will be the limiting factor to what you can create :)

We hope the concept is pretty self-explanatory. But enough talk for now! Let's get you started!  
(If you are still confused consider checking out the images in the [Examples folder](/Examples/))

## 2 How to get started?
(This section is curretly a work in progress as some features still have to be added to make this section more relevant)  

Now that you got an idea of what the project is supposed to do, let's explore how to do it.  
A good starting point will always be the [Examples folder](/Examples/). It contains code, configuration files and images of certain basic patterns. These examples should be a good reference to get you pointed in the right direction.

Though if you want to completely understand and use this project to realize your own ideas, we recommend reading this tutorial until the end.  
(If you are already experienced you might be interested in [this chapter](#3-documentation) as a reference)

## 3 Documentation  
**Note:** This documentation is not meant for people who are completely new to the project.  
If you want detailed and simple explanations that include examples you should check out the [Examples folder](/Examples/).  
(Btw this is not meant to shame/exclude anyone! New people are **always appreciated** and therefore we want to point them to the appropriate places where they are able to find beginner-friendly references)

This documentation is for you if you already know all of the basics and are searching for something like a cheat sheet for all of the things this project has to offer.  
For this reason it is rather sparing in detail and explanation.  

### 3.1 Variables
| Variable(s) | Origin | Purpose | Used (in) |
|---|---|---|---|
| public static int WIDTH, HEIGHT | PattyPress.java | Width/height of the window | Constructor, public void paint(), collision detection methods |
| public int x, y | PattyPress.java | Current postion of the line | User specific |
| public int xOrigin, yOrigin | PattyPress.java | Initial position of the line, "starting point" | User specific |
| public int xVel, yVel | PattyPress.java | "Speed" of the line, determines next x, y | User specific |
| public int dX, dY | PattyPress.java | E.g. slowly changing line speed etc. | User specific |
| public int red, green, blue | PattyPress.java | Variables to store the current color of the line | User specific |
| public int dR, dG, dB | PattyPress.java | E.g. change the color of the line bit by bit every loop etc. | User specific |
| public int delay | PattyPress.java | Determines how long the pattern is paused each loop in ms | public void paint() |
| public int bounces | PattyPress.java | Determines how often the line is allowed to bounce off of the screen border | public void paint() |
| int checkValue | PattyPress --> paint() | Stores the output of checkBounds() | public void paint() |
| Point xyN | PattyPress --> paint() | Stores the output of getNearestI() | public void paint() |
Point oldXY | PattyPress --> paint() | Stores the most recent bounce position | public void paint() |

### 3.2 Functions and methods
| Name | Origin | Purpose | Used (in) |
|---|---|---|---|
| public PattyPress() | PattyPress.java | Constructor; handles the creating of the window | PattyPress --> main() |
| [public void setup()](/Examples/basicMethods/setup().md) | PattyPress.java | setting the initial parameters of the pattern | public void paint() |
| [public void loop()](/Examples/basicMethods/loop().md) | PattyPress.java | User specific; is called in every loop cycle | public void paint() |
| [public void onBounce()](/Examples/basicMethods/onBounce().md) | PattyPress.java | User specific; is called when line bounces off borders | public void paint() |
| public void paint() | PattyPress.java (override) | is called after window is created; contains the main "engine" | PattyPress (indirectly) |
| public int checkBounds() | PattyPress.java | Detects a collision with the walls and reports the kind | public void paint() |
| public boolean checkOutOfBounds() | PattyPress.java | Detects if the pattern should be halted | public void paint() |
| public Point getNearestI() | PattyPress.java | Calculates where line exactly hits border | public void paint() |


## 4 How to contribute?
You like the project and want to support us? Or you did NOT like something?  
Please let us know!  
Whether you discovered a bug, a missing feature, an inconvenient or wrong formulation, let us know!  
We are always glad for feedback!  
To learn more about this check out the [CONTRIBUTING file](/CONTRIBUTING.md).  
It contains details about what you can report and how to.  
But in short: Open a new issue and tell us what bugs you! (yes, pun intended)

<br></br>
## 5 Thank you  
Thank you to everyone who is using this project!  
Thank you to everyone who is contributing!  

Thank you for reading all of this and remember:  
You are awesome!  

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;created by [@KUHLwasStolen](https://github.com/KUHLwasStolen)