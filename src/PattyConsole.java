/*
 * Description: Class that contains useful stuff in relation to output in the console etc.
 * Creator: @KUHLwasStolen
 * Editor(s): @KUHLwasStolen
 * Version: V1.0.0
 * License: GPLv3
*/

public class PattyConsole {

    // ANSI colors (selection)
    public static final String RESET = "\u001B[0m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String GRAY = "\u001B[90m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_MAGENTA = "\u001B[95m";
    public static final String BRIGHT_CYAN = "\u001B[96m";

    // Version of progressBar() that calculates the percentage for you
    public static void progressBar(double start, double progress, double goal) {
        goal = Math.abs(goal - start);
        progress = Math.abs(progress - start);
        int percentage = (int)Math.round((progress/goal) * 100);
        progressBar(percentage);
    }

    // Prints out a visual representation of some progress
    public static void progressBar(int percentage) {
        final int maxSections = 30; // "resolution" of the progress bar

        percentage = Math.max(Math.min(percentage, 100), 0);
        int sections = (int)(Math.round(percentage / (100 / (float)maxSections)));

        System.out.println("Progress:");
        System.out.printf("%s[", sections == maxSections ? PattyConsole.BRIGHT_GREEN : "");
        int i;
        for(i = 1; i <= sections; i++) {
            System.out.print("#");
        }
        for(; i <= maxSections; i++) {
            System.out.print(" ");
        }
        System.out.printf("]%s\n", PattyConsole.RESET);
    }

    // Clears the terminal's output
    public static void clear() {
        System.out.flush();

        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.println("\033\143");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
