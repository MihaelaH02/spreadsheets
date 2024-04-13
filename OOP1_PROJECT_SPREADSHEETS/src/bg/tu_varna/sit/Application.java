package bg.tu_varna.sit;

import bg.tu_varna.sit.cmd.SelectCmd;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        SelectCmd commands = new SelectCmd();
        while (true) {
            String input = scanner.nextLine();
            String[] temporary = input.split("\\s+");
            commands.runCommand(temporary);
        }
    }
}
