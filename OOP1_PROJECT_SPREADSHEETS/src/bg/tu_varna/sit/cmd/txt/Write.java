package bg.tu_varna.sit.cmd.txt;

import bg.tu_varna.sit.table.Row;
import bg.tu_varna.sit.table.Table;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public void write(String pathFile) throws IOException {
        Table table = Table.getInstance();
        File file = new File(pathFile);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fileWriter);

        for (int i = 0; i < table.getTable().size(); i++) {
            Row row = table.getTable().get(i);//масив от клетките на един ред

            if(row==null){
                bw.write("");//писане на празен ред
                bw.newLine(); // Запис на нов ред след всяка редица
                continue;
            }
            for (int j = 0; j < row.getLengthOfRow(); j++) {
                if(row.getCell(j)==null) bw.write(",");//писане на празна клетка
                else {
                    bw.write(row.getCell(j).toString());//запис на текуща клетка
                    if (j + 1 != row.getLengthOfRow()) bw.write(",");//разделител ако не сме стигнали последния елемент
                }
            }
            if(i != table.getTable().size()-1) bw.newLine(); // Запис на нов ред след всяка редица
        }
        bw.close();
    }
}