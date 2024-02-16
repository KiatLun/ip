package Duke;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    /**
     * Main function of the Duke program. Displays opening logo. Scans for user input.
     *
     * @param args
     * @throws DukeException
     * @throws IOException
     */
    public static void main(String[] args) throws DukeException, IOException {

        UI.showLogo();
        UI.showAvailCommands();
        TaskList storage = new TaskList();
        Path filePath = Paths.get("./data/duke.txt");
        Path writeToFile = FileHandler.handleFile(storage, filePath);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.isEmpty()) {
            if (input.equals("bye")) {
                UI.showExitMsg();
                break;
            }
            TaskHandler.doTasks(input, storage, writeToFile);

            input = scan.nextLine();

        }

    }
}
