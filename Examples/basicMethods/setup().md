## public void setup(Graphics g)  
This method is called before the loop and therefore before the pattern is started.  
Here you can put the code that you only want to run once.  

You have access to all the Graphics methods and all of the basic variables, functions and methods of the program.  
A detailed documentation can be found in the respective [README section](/README.md#3-documentation).

For example if the speed of your line is static then you can set xVel and yVel here.  
It is also a good idea to set the initial color of the line here.  
The following example shows you how.  

**Example:** (this is the default code in [PattyPress.java](/src/PattyPress.java))  
~~~
public void setup(Graphics g) {  
    bounces = 26;

    xVel = 2;  
    yVel = 2;  

    // Initial color of the line
    red = 255;  
    green = blue = 0;  
    g.setColor(new Color(red, green, blue));  
}
~~~
The code above is pretty self-explanatory:  
The line will start with a motion towards the bottom right corner of the screen.  
The initial color will be red.  
The line is allowed to bounce 26 times off of the screen borders.  

**Note:** You can also just set the color like this:  
~~~
g.setColor(new Color(255, 0, 0));
~~~
But if you want to change the color later in the loop it is best to use the variables as shown above, so you have an easy way to check your current color.