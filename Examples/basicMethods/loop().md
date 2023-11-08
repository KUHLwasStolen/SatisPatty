## public void loop(double i, Graphics g)  
This method is called right at the beginning of every cycle in the loop.  
Here you should put the code that you want to run in every single loop cycle regardless of the current state of the pattern.  

An example for this would be continuously changing the color of the line (2 Examples below).  
Another example would be using functions in your code to determine yVel or yVel (e.g. Math.sin()).  
To do this you have access to the Graphics class, all of the basic variables, functions and methods of the program and the variable i, which counts the repetitions of the loop.  
A detailed documentation can be found in the respective [README section](/README.md#3-documentation).  

**Example 1**
~~~
public void loop(double i, Graphics g) {
    g.setColor(new Color(red+=dR, green+=dG, blue+=dB));

    if(green == 0) {
        dG = 1;
        dB = dR = 0;
    }
    if(green == 255) {
        dG = -1;
        dB = dR = 0;
    }
}
~~~
This code causes the color of the line to fade from blue to turquoise and back to blue.  
This works by slowly increasing the green value to 255 and then back to 0.  

**Note:** To recreate this exact behaviour your [setup method](/Examples/basicMethods/setup().md) should of course include something like this:
~~~
blue = 255;
red = green = 0;
g.setColor(new Color(red,green,blue));
~~~

&nbsp;  
**Example 2** (this is the default code in [PattyPress.java](/src/PattyPress.java))  
~~~
public void loop(double i, Graphics g) {
    g.setColor(new Color(red+=dR, green+=dG, blue+=dB));

    // "rainbow" color change
    if(red == 255 && blue == 0 && green == 0) {
        dG = 1;
        dR = dB = 0;
    }
    if (green == 255 && red == 255 && blue == 0) {
        dR = -1;
        dB = dG = 0;
    }
    if (red == 0 && green == 255 && blue == 0) {
        dB = 1;
        dR = dG = 0;
    }
    if (blue == 255 && green == 255 && red == 0) {
        dG = -1;
        dR = dB = 0;
    }
    if(green == 0 && red == 0 && blue == 255) {
        dR = 1;
        dB = dG = 0;
    }
    if(red == 255 && blue == 255 && green == 0) {
        dB = -1;
        dR = dG = 0;
    }
}
~~~
This code causes the color of the line to cycle through a "rainbow effect", starting with red.  
The implementation is pretty rudimentary as the code just detects the end of each "section" and then starts the next one.  
The first line in the function sets the line to the according color, while increasing/decreasing the respective variable by its respective delta (i.e. dR, dG or dB).  

**Note:** To recreate this exact behaviour your [setup method](/Examples/basicMethods/setup().md) should of course include something like this:
~~~
red = 255;
green = blue = 0;
g.setColor(new Color(red,green,blue));
~~~