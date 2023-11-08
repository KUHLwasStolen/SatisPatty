## public void onBounce(double i, Graphics g)  
This method is called when the line "bounces".  
I.e. when the line hits the border of the window and is "reflected" by it.

Here you can put code that should be ran if and only if this happens.  
For example you could change the color (Example 2) of the line or make it speed up and so on.  
To do this you have access to the Graphics class, all of the basic variables, functions and methods of the program and the variable i, which counts the repetitions of the loop.  
A detailed documentation can be found in the respective [README section](/README.md#3-documentation).  

**Example 1** (this is the default code in [PattyPress.java](/src/PattyPress.java))  
~~~
public void onBounce(double i, Graphics g) {
    // Draws a little green circle around the "impact"
    g.setColor(new Color(0, 255, 0));
    g.drawOval(x-5, y-5, 10, 10);
}
~~~
Like the comment already mentions this code draws a little green circle around the location of the "bounce".  
Depending on your other code you might want to reset the color of the line to its original value at the end of the method.  
For example like this:
~~~
g.setColor(new Color(red, green, blue));
~~~

&nbsp;  
**Example 2**
~~~
public void onBounce(double i, Graphics g) {
    if(red == 255) {
        blue = 255;
        red = 0;
    } else if(blue == 255) {
        green = 255;
        blue = 0;
    } else if(green == 255) {
        red = 255;
        green = 0;
    }
}
~~~
This cicles through the three base colors of the 8-bit RGB-system.  
**Note:** This code requires you to have the initial color of the line set to one of the three.  
If you do not want to do this you can change the last "else if" to something like this:
~~~
... } else {
        red = 255;
        green = blue = 0;
    }
~~~