package bg.tu_varna.sit.cmd;

import bg.tu_varna.sit.table.Row;
import bg.tu_varna.sit.table.Table;

public class Print {
    private int maxRows =0;

    private String printString(String str){
        str = str.substring(1, str.length() - 1);//премахваме кавичките в началото и края
        return str.replace("\\", ""); //премахва наклонените черти
    }

    public void printTable() {
        Table table = Table.getInstance();
        if(table.getTable().get(0) == null) {
            System.out.println("The table is empty!");
            return;//изход от метода не се изпълнява по надолу
        }

        for (int i = 0; i < table.getTable().size(); i++) {
            if(table.getTable().get(i) == null) continue;
            if(table.getTable().get(i).getLengthOfRow() > maxRows)
                maxRows = table.getTable().get(i).getLengthOfRow();// определяме маскималния брой клетки за ред
        }

        for (int i = 0; i < table.getTable().size(); i++) {
            Row row = table.getTable().get(i);//масив от клетките на един ред

            for (int j = 0; j < maxRows; j++) {
                if (row == null || row.getLengthOfRow() <= j || row.getCell(j) == null) System.out.print("|\t");
                else if (row.getCell(j) instanceof String) //ако е стринг премахни кавичките
                    System.out.print(this.printString((String) row.getCell(j)) + "|\t");
                else System.out.print(row.getCell(j) + "|\t");
            }
            System.out.println();
        }
    }
}
