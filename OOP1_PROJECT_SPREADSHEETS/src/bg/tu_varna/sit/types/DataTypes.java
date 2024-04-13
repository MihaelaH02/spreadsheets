package bg.tu_varna.sit.types;

import bg.tu_varna.sit.exceptions.UnknownDataType;
import bg.tu_varna.sit.formula.FormulaCalculation;

public class DataTypes {
    public Object checkDataTypes(String data) throws Exception {

        if (data.startsWith("\"") && data.endsWith("\"") ) //стринг е!
           return data;

        if(data.contains(" ") || data.equals("")) return null;//празна клетка

        if (data.charAt(0) == '=' && data.length() > 1) return new FormulaCalculation().doCalculation(data); //ако е формула върни решевието от клас формула

        if(data.matches("[-+]?\\d*\\.?\\d+")) {//число е
            if (data.contains("."))
                return Double.parseDouble(data);
            return Integer.parseInt(data);
        }
       // [-+]? означава, че символите + или - са опционални.
       // \\d* съответства на нула или повече цифри.
       // \\.? означава, че десетичната точка (запетаята) е опционална.
       // \\d+ съответства на една или повече цифри след десетичната точка.

        throw new UnknownDataType("Unknown data type");// при всички други случеи да се хвърли грешка
    }
}
