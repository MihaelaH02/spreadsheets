package bg.tu_varna.sit.formula;

public class Operation {
    private final char[] VALID_OPERATIONS={'+','-','*','/','^'};

    public char checkForOperationInFormula(String data){
        for (char operationFormArray:VALID_OPERATIONS) {//преход през масива с позволени операции
            int index = data.indexOf(operationFormArray);//проверява коя операция ще използваме
            if(index != -1) return data.charAt(index);//ако има намерена валидна се извлича кой е тя
        }
        throw new ArithmeticException("Invalid arithmetic operation!");
    }
}
