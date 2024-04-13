package bg.tu_varna.sit.formula;


public class FormulaCalculation extends FormulaData{
    private Double result;

    private Object intOrDouble(){
        if(Math.floor(this.result) == this.result)//проверка дали при отделянето на цялата част на числото то остава същото, пример 10,0 го закръгляме на 10 и сравняваме дали 10,0==10
            return (int)Math.floor(this.result);//връщаме само цялата част
        else return this.result;//върни дабъл
    }

    public Object doCalculation(String enteredFormula) throws Exception {
        super.extractTheElementsInFormula(enteredFormula);

        switch (super.getOperation()){
            case '+': this.result = super.getFirstData() + super.getSecondData();
            break;
            case '-': this.result = super.getFirstData() - super.getSecondData();
            break;
            case '*': this.result =  super.getFirstData() * super.getSecondData();
            case '/':{
                if(super.getSecondData() != 0) this.result = super.getFirstData()/super.getSecondData();//ако второто чесло е различно от 0 изъпълни операцията
                else return "ERROR";// върни грешка в клетката защото не може да се дели на 0
            }
            break;
            case '^': this.result = Math.pow(super.getFirstData(),super.getSecondData());
            break;
            default: throw new Exception("Error in calculation!");
        }

        return intOrDouble();
    }
}
