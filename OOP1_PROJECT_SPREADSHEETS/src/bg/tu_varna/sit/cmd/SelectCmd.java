package bg.tu_varna.sit.cmd;

import bg.tu_varna.sit.cmd.txt.Close;
import bg.tu_varna.sit.cmd.txt.Open;
import bg.tu_varna.sit.cmd.txt.Write;

public class SelectCmd {
    private static boolean openFile = false;//проверка дали файлът е отворен
    private static String pathFile;

    public void runCommand(String[] commands) throws Exception {
        try {
            if (commands.length < 1) throw new IllegalArgumentException("Not entered operation!");
            CommandsEnum command = CommandsEnum.valueOf(commands[0].toUpperCase());
            //проверка дали въведената команда присъства в енъма ако не хвърля грешка която да не спира програмата???

            if (command == CommandsEnum.HELP) {
                System.out.println("The following commands are supported:");
                for (CommandsEnum cmd : CommandsEnum.values())//принтира всички опции от енъма
                    System.out.printf("%-35s %n", cmd.name().toLowerCase() + ":\t" + cmd.getCommandEnum());//името на променливата в енъм + описанието му
            } else if (command == CommandsEnum.EXIT) {
                System.out.println("Exiting the program... ");
                System.exit(0);
            }

            if (command == CommandsEnum.OPEN) {
                pathFile = commands[1];
                System.out.println("> open " + pathFile);
                new Open().open(pathFile);
                openFile = true;//файлът вече е отворен и в съситемата е заредена база данни

            } else if (openFile) {//изпълнява се само ако е отворен файлът
                System.out.println("> " + command.name().toLowerCase());

                switch (command) {
                    case SAVE -> new Write().write(pathFile);
                    case SAVEAS -> {
                        if (commands.length == 2)
                            new Write().write(commands[1]);
                        else throw new IllegalArgumentException("Not enough or too many entered arguments!");
                    }
                    case CLOSE -> {
                        new Close().close();
                        openFile = false;
                    }
                    case PRINT -> new Print().printTable();
                    case EDIT -> {
                        if (commands.length == 3)
                            new Edit(commands[1], commands[2]).editDataInTable();
                        else throw new IllegalArgumentException("Not enough or too many entered arguments!");
                    }
                }
            }
            System.out.println("Successfully " + command.name().toLowerCase());
        }catch (IllegalArgumentException msg){
            System.out.println(msg.getMessage());
        }
    }
}