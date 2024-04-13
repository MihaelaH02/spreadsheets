package bg.tu_varna.sit.formula;

public abstract class FormulaData {

    private Double firstData;
    private char operation;
    private Double secondData;

    public Double getFirstData() {
        return firstData;
    }

    public char getOperation() {
        return operation;
    }

    public Double getSecondData() {
        return secondData;
    }

    private void setFirstData(Object firstData) throws Exception {
        this.firstData = new ExtractData(firstData).extractDataInFormula();
    }

    private void setOperation(String enteredFormula) throws Exception {
        this.operation =new Operation().checkForOperationInFormula(enteredFormula);
    }

    private void setSecondData(Object secondData) throws Exception {
        this.secondData = new ExtractData(secondData).extractDataInFormula();
    }

    //не съм сигурна тези сетове в наследника ли се викат или тук, май тука :`)
    public void extractTheElementsInFormula(String enteredFormula) throws Exception { //примерен вход: “=123,0 + "147""
            setOperation(enteredFormula);//определяме знака
            setFirstData(enteredFormula.substring(1, enteredFormula.indexOf(this.operation)));//вземаме символите след равното и преди символа за операция
            setSecondData(enteredFormula.substring(enteredFormula.indexOf(this.operation) + 1)); //вземаме стойността след символа за опирация до края
    }
}
