package bg.tu_varna.sit.cmd;

public enum CommandsEnum {
        OPEN("opens <file> "),
        CLOSE("closes currently opened file"),
        SAVE("saves the currently open file"),
        SAVEAS("saves the currently open file in <file>"),
        HELP("prints the information"),
        EXIT("exists the program"),
        PRINT("prints the table"),
        EDIT("edits the table");

        private final String commandEnum;

        CommandsEnum(String commandEnum) {
            this.commandEnum = commandEnum;
        }

        public String getCommandEnum() {
            return commandEnum;
        }
    }
