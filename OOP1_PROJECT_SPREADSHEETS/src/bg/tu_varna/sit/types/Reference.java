package bg.tu_varna.sit.types;

import bg.tu_varna.sit.table.Row;
import bg.tu_varna.sit.table.Table;

public class Reference {
    private final String reference;
    private int row;
    private int cell;

    public Reference(String reference){
        this.reference = reference;
        //формат R число C число като \d+ е проверка за digit(регулярен израз!)
        String VALID_FORMAT = "R\\d+C\\d+";
        if(this.reference.matches(VALID_FORMAT)) {
            this.setR();
            this.setC();
        }
        else throw new IllegalArgumentException("Invalid reference format!");
    }

    private void setR() {
        this.row = Integer.parseInt(reference.substring(1, 2));
    }

    private void setC() {
        this.cell = Integer.parseInt(reference.substring(3));
    }

    public int getRow() {
        return row;
    }

    public int getCell() {
        return cell;
    }

    public Object returnValueOfCell(){

        Table table = Table.getInstance();
        if(table.getTable().size() < this.row) return null;//ако надхвърля

        Row currentCow = table.getTable().get(this.row - 1);
        if (currentCow.getLengthOfRow() < cell) return null;//0;  //ако реда е пръзен или надхвърля

        return currentCow.getCell( this.cell- 1);//ако е пълно с данни върни ги
    }

}
