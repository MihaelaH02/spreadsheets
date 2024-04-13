package bg.tu_varna.sit.table;

import java.util.ArrayList;

public class Row {
    private final ArrayList<Object> row;

    public Row() {
        this.row=new ArrayList<>();
    }

    public void addCell(Object cell) {
        this.row.add(cell);
    }

    public int getLengthOfRow(){
        return row.size();
    }

    public Object getCell(int index){
        return row.get(index);
    }
    public void setCell(int index,Object element){row.set(index,element);}
}
