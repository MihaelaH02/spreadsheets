package bg.tu_varna.sit.table;

import java.util.ArrayList;

public class Table {
    private static Table instance;
    private final ArrayList<Row> table;

    private Table() {
        this.table = new ArrayList<>();
    }

    public static Table getInstance() {
        if (instance == null) instance = new Table();
        return instance;
    }

    public static void setInstance(Table instance) {
        Table.instance = instance;
    }

    public void addRowInTable(Row newRow) {
        table.add(newRow);
    }

    public ArrayList<Row> getTable() {
        return table;
    }

}
