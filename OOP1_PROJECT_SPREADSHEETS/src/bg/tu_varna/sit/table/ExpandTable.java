package bg.tu_varna.sit.table;

public class ExpandTable {
    private final Table table;

    public ExpandTable() {
        this.table = Table.getInstance();
    }

    public void addNewRowsAndCells(int row, int col) {

        while (table.getTable().size() < row) {
            table.addRowInTable(null); // добавяме нови редове
        }

        if (table.getTable().get(row - 1) == null) {//ако целия ред е празен
            Row tempRow = new Row();//нов временен масив
            for (int i = 0; i < col; i++) {
                tempRow.addCell(null);//който пълним с брой нулеви келки които ни трябват
            }
            table.getTable().set(row - 1, tempRow);//добави в празния ред новите клетки
        } else
            while (table.getTable().get(row - 1).getLengthOfRow() < col) //ако клетките на даден ред са по малко от търсените
                table.getTable().get(row - 1).addCell(null); // добавяме нови клетки след последната
    }
}
