[This](/Examples/YourFirstPattern/FirstPattern-Screenshot.png) is the pattern that is created when you run the code that comes with the unmodified project.  
Though if you run this code on your own computer it might look **different**!  
**Why?** The outcome of this pattern depends on your screen size. More exactly it depends on your screen's aspect ratio. The computer that this was created on comes with a 16:10 display, while most displays feature a 16:9 aspect ratio.  
So let's run this pattern on your machine and see what's the outcome!  
Here is a short description on how to do that:  
1. **Make sure you have a more or less recent version of the [java-jdk](https://www.oracle.com/java/technologies/downloads/#jdk21-windows) installed**
2. **Get yourself a copy of the [source code](/src/)**
3. **Compile the project**  
If you are unsure how this is done follow these steps:  
3.1) Open a terminal  
3.2 Navigate your way to the directory where the source code is stored  
3.3 Enter '.\javac PattyPress.java' in the terminal (on windows; it might look bit different on your OS but the concept is the same)  
3.4 Now you should see that the compiler has created additional files in your directory with the file extension '.class'  
4. **Run the project**  
If you are unsure how this is done follow these steps:  
4.1 Make sure you are still in the directory where your '.class' files are stored  
4.2 Enter 'java PattyPress' in the console (no file extension required this time)  
4.3 Now you should see a window pop up and the pattern should start  
5. **The pattern looks 'unfinished'?**  
If this is the case, your display setup might require you to add additional bounces to the pattern. To do this you just have to increase the value of the 'bounces' variable in the code. Do this in the [setup()](/Examples/basicMethods/setup().md) method.  
From now on it's just trial and error  

If you want to learn more on how to modify the pattern to your taste check out the [basicMethods](/Examples/basicMethods/) folder, which will guide you through the three most important methods for creating your own pattern.  
It also contains explanations for the exact code that you just ran.