import calculator.Calculator;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;
import calculator.datatypes.integer.IntegerValueParser;

public class main {
  
  public static void  main(String[] args) throws DivisionByZeroException, ParseValueException, OperationNotSupportedException  {
    Calculator TestCalc = new Calculator(new IntegerValueParser());
    String val =  TestCalc.calculate("1", "+", "2");
    System.out.println(val);
  }
}
