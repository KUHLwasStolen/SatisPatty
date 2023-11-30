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
    backgroundColor = new Color(30, 30, 30);

    delay = 5;
    bounces = 26;

    dR = dG = dB = 0;
    dX = dY = 1;

    xOrigin = (int)(WIDTH / 2);
    yOrigin = (int)(HEIGHT / 2);

    xVel = 2;
    yVel = 2;

    red = 255;
    green = blue = 0;
    g.setColor(new Color(red,green,blue));
}
~~~
The code above is pretty self-explanatory:  
The line will start with a motion towards the bottom right corner of the screen. (xVel, yVel)  
This motion starts in the center of the screen. (xOrigin, yOrigin)  
The initial color will be red. (red, green, blue, setColor)  
The background color will be a dark gray. You only need to set this. The program automatically fills the background with your color after setup() is called.  
The line is allowed to bounce 26 times off of the screen borders. (bounces)  
'delay' is the time (in ms) that the loop pauses after each repetition. Using this variable you can create a slower/faster line without changing xVel/yVel. It is recommended to keep this variable somewhere between 1 and 20, to ensure a fluid experience, but feel free to experiment.  
The variables that start with 'd' (which stands for delta) are meant to help you gradually change a value, but can be used for anything that you want them to do (keep in mind that they are of type int). In [loop().md](/Examples/basicMethods/loop().md) you can find an example that makes use of them.  

**Note:** You can also just set the color like this:  
~~~
g.setColor(new Color(255, 0, 0));
~~~
But if you want to change the color later in the loop it is best to use the variables as shown above, so you have an easy way to check your current color.