/*
 * Description: Core of the project. Contains the basic loop and the main method to run the project. The engine so to say.
 * Creator: @KUHLwasStolen
 * Editor(s): @KUHLwasStolen
 * Version: V1.0.2
 * License: GPLv3
*/

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PattyPress extends JFrame {

    public static int WIDTH, HEIGHT;
    public int x, y, xVel, yVel, xOrigin, yOrigin;
    public int red, green, blue;
    public int dX, dY, dR, dG, dB; // d... meaning delta... this is here to "change direction" and intended to be 1, -1 or 0
    public int delay; // the time in ms that the Thread sleeps for each loop
    // Determines how often the line is allowed to bounce off the borders
    // bounces = 0 means pattern is halted when the line first leaves the screen
    public int bounces;

    public PattyPress(String title) {
        super(title); // super constructor for JFrame

        dR = dG = dB = 0;
        dX = dY = 1;

        // Gets the full screen size
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        WIDTH = (int)(screen.getWidth());
        HEIGHT = (int)(screen.getHeight());

        // Using all of these is probably not necessary in this case but better safe than sorry
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // to avoid weird interactions
        setLocationRelativeTo(null);

        // Disables annoying bars, rounded edges etc; makes the patterns more enjoyable
        setUndecorated(true);

        setVisible(true);
    }

    public void setup(Graphics g) {
        bounces = 26;

        xVel = 2;
        yVel = 2;

        // Initial color of the line
        red = 255;
        green = blue = 0;
        g.setColor(new Color(red,green,blue));
    }

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

    public void onBounce(double i, Graphics g) {
        // Draws a little green circle around the "impact"
        g.setColor(new Color(0, 255, 0));
        g.drawOval(x-5, y-5, 10, 10);
    }

    public void paint(Graphics g) {
        super.paint(g);

        // Fills the background with a color of choice
        g.setColor(new Color(30, 30, 30));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // This is where your pattern will start
        xOrigin = (int)(WIDTH / 2);
        yOrigin = (int)(HEIGHT / 2);

        x = xOrigin;
        y = yOrigin;

        delay = 5;

        // Collision detection related variables
        int checkValue;
        Point oldXY = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE); // somewhere way off the screen to avoid accidental errors

        setup(g);

        // i is a double because it allows for easier calculations when using functions like Math.sin() dependent on i
        for(double i = 0; !checkOutOfBounds(x, y); i++) {
            loop(i, g);

            g.drawLine(x, y, x+xVel, y+yVel);

            checkValue = checkBounds(x+xVel, y+yVel, 1, 1);
            if (checkValue != 0 && (bounces > 0 || bounces == -1)) {
                Point xyN = getNearestI(x, y, xVel, yVel);

                x += xyN.x;
                y += xyN.y;

                if(checkValue%2 == 0) {
                    xVel = -xVel;
                } else {
                    yVel = -yVel;
                }

                if(!(oldXY.x == x && oldXY.y == y)) { // this corrects for "double bounces" which occur when perfectly hitting a corner
                    bounces--;
                    onBounce(i, g);

                    // Correction for the case that the last bounce is a "double bounce" --> otherwise not executed
                    if(((x == 0 && y == 0) || (x == WIDTH && y == 0) || (x == 0 && y == HEIGHT) || (x == WIDTH && y == HEIGHT))
                    && bounces == 0) {
                        bounces = -1;
                    }
                } else if(bounces == -1) {
                    bounces--;
                }

                oldXY.x = x;
                oldXY.y = y;
                
            } else {
                x += xVel;
                y += yVel;
            }

            try {
                Thread.sleep(delay);
            } catch(Exception e) {
                e.printStackTrace();
            }

        }

        // minimize window and wait for user to close it by terminal (can take a look at final pattern now)
        this.setState(JFrame.ICONIFIED);
        System.out.print("Pattern finished. Press <ENTER> to continue.");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
        
    }

    public static void main(String[] args) {

        PattyPress pPress = new PattyPress("cool pattern in process...");
        
    }

    // Detects a collision with the walls and reports the kind
    public int checkBounds(double x, double y, int oWidth, int oHeight) {
        if(x < 0) {                         // "left"
            return 2;
        } else if(x + oWidth > WIDTH) {     // "right"
            return 4;
        } else if(y < 0) {                  // "top"
            return 1;
        } else if(y + oHeight > HEIGHT) {   // "bottom"
            return 3;
        } else {                            // none of the above
            return 0;
        }
    }

    // Used for detecting if the pattern should be halted
    // Has a small margin around the window
    public boolean checkOutOfBounds(int x, int y) {
        if(x < -50) {
            return true;
        } else if(x > WIDTH + 50) {
            return true;
        } else if(y < -50) {
            return true;
        } else if(y > HEIGHT + 50) {
            return true;
        } else {
            return false;
        }
    }

    // Allows us to get a prediction of the exact position where the line would hit the border
    public Point getNearestI(int x, int y, int xVel, int yVel) {
        int bound = checkBounds(x+xVel, y+yVel, 1, 1);
        double xN, yN;
        if(bound == 4) {
            xN = WIDTH - x;
            yN = Math.round(yVel * (xN / xVel));
        } else if(bound == 2) {
            xN = -x;
            yN = Math.round(yVel * (xN / xVel));
        } else if(bound == 1) {
            yN = -y;
            xN = Math.round(xVel * (yN / yVel));
        } else {
            yN = HEIGHT - y;
            xN = Math.round(xVel * (yN / yVel));
        }

        return new Point((int)(xN), (int)(yN));
    }

}