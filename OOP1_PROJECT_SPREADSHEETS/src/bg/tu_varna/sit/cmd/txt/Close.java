package bg.tu_varna.sit.cmd.txt;

import bg.tu_varna.sit.table.Table;

public class Close {
    public void close() {
        Table.setInstance(null);
    }
}
