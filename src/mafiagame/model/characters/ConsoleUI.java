package mafiagame;

import java.util.Scanner;

/**
 * Simple console-based UI helper.
 *
 * Handles all System.in / System.out interaction so the rest of the game
 * can focus on logic and story structure.
 */
public class ConsoleUI {

    private final Scanner scanner;

    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void println(String text) {
        System.out.println(text);
    }

    public void print(String text) {
        System.out.print(text);
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public String ask(String prompt) {
        print(prompt);
        return readLine();
    }

    /**
     * Equivalent of the old waitForEnter logic.
     */
    public void waitForEnter() {
        System.out.println();
        System.out.println("Press Enter to continue...");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
        }
        System.out.println();
    }
}
