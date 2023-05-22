package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class complexValueParser implements AbstractValueParser {

  public AbstractValue parse(String value) throws ParseValueException {
    try {
      double real = Double.parseDouble(value.split("\\+")[0]);
      String regex = "[^i]*$";
      Matcher m = Pattern.compile(regex).matcher(value.split("\\+")[1]);
      if (m.find()) {
        String num = m.group(0).replace("(", "").replace(")", "");
        double image = Double.parseDouble(num);
        return new complexValue(real, image);
      } else throw new NumberFormatException();
    } catch (NumberFormatException exception) {
      throw new ParseValueException();
    }
  }

  public String format(double real, double image) {
    return "����� �����";
  }

  public String getDatatypeName() {
    return "����� �����";
  }
}
