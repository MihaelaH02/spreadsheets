package bg.tu_varna.sit.cmd.txt;

import bg.tu_varna.sit.exceptions.UnknownDataType;
import bg.tu_varna.sit.types.DataTypes;
import bg.tu_varna.sit.table.Row;
import bg.tu_varna.sit.table.Table;
import java.io.*;

public class Open{

    public void open(String pathFile) throws Exception {
        File file = new File(pathFile);

        if (file.exists()) {
            Table table = Table.getInstance();

            FileReader fileReader = new FileReader(pathFile);
            BufferedReader br = new BufferedReader(fileReader);

            String rows;
            while((rows=br.readLine()) != null) {//проверка дали сме стигнали края на документа
                if (rows.equals("")) {
                    table.addRowInTable(null);//запис на празен ред
                    continue;
                }
                String[] row = rows.split(",");//записваме всички клетки разделени със ,
                Row cells = new Row();//нов временен масив

                for (int i = 0; i < row.length; i++)
                    try {
                        cells.addCell(new DataTypes().checkDataTypes(row[i]));//превръщане на стринг прочетената клетка в сътветния тип
                    } catch (Exception message) {
                        throw new UnknownDataType(message.getMessage() + " in row " + (table.getTable().size() + 1) + " col " + (i+1) + "!");
                    }
                table.addRowInTable(cells);//запазване на временния масив като нов ред в таблицата
            }
            br.close();
        }
        else throw new FileNotFoundException("File not Find");
    }
}