package bg.tu_varna.sit.cmd;

import bg.tu_varna.sit.exceptions.UnknownDataType;
import bg.tu_varna.sit.table.ExpandTable;
import bg.tu_varna.sit.table.Table;
import bg.tu_varna.sit.types.DataTypes;
import bg.tu_varna.sit.types.Reference;

public class Edit {
    private final Reference reference;
    private final String newData;

    public Edit(String reference, String newData){
        this.reference = new Reference(reference);
        this.newData = newData;
    }

    public void editDataInTable() throws Exception {
        Table table = Table.getInstance();

        new ExpandTable().addNewRowsAndCells(reference.getRow(), reference.getCell());//проверка дали референцията не надхвърля таблицата
        try {
            table.getTable().get(reference.getRow() - 1).setCell(reference.getCell() - 1, new DataTypes().checkDataTypes(this.newData));//намери клетката според подадените ред и клетка и промени нейната стойност на новата подадена
        } catch (UnknownDataType msg) {
            throw new Exception(msg.getMessage() + " in row " + reference.getRow() + " col " + reference.getCell() + "!");
        }
    }
}
