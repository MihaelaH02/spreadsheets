package bg.tu_varna.sit.formula;

public class StringToNumber {
    private Object data;

    public StringToNumber(Object data) {
        this.data = data;
    }

    public Double dataTypesInFormula(){
        if (data == null) return 0.0;

        else if (data instanceof String) {
            if (((String) data).startsWith("\"") && ((String) data).endsWith("\""))
                data = ((String) data).substring(1, ((String) data).length()-1);

            if(((String) data).matches("[-+]?\\d*\\.?\\d+"))
                return Double.parseDouble((String) data);//ако е дабъл върни го
            else return 0.0;//ако не е число върни
        }
        if(data instanceof Integer)//проверка дали е инт азащото не може директно да се кастват
            return ((Integer) data).doubleValue();//върни преобразуваната стойност от инт в дабъл
        return (Double) data;//пръвоначално е било дабъл
    }
}
