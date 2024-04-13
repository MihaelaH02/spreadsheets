package bg.tu_varna.sit.formula;

import bg.tu_varna.sit.types.Reference;

public class ExtractData{
    private Object data;

    public ExtractData(Object data) {
        this.data = data;
    }

    public Double extractDataInFormula() throws Exception {
        if(data==null) return 0.0;//ако е празно
        //проверяваме дали данни са препратки, ако да вземаме стойността, която се намира на даденото място в таблицата
        try {
            data = new Reference((String) data).returnValueOfCell();//ако е препрадка и не хвърли грешка извлечи записаното в него
        }catch (Exception ignored){}//хваната е грешка не е препрадка

        //превръщане на обект в дабъл
        return new StringToNumber(data).dataTypesInFormula();
    }
}
