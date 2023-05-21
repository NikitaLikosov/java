package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;

public class complexValue extends AbstractValue {

  private final double real;
  private final double image;

  public complexValue(double real, double image) {
    super();
    this.real = real;
    this.image = image;
  }

  public String toString() {
    return (
      String.format("%f", this.real) + "+i" + String.format("%f", this.image)
    );
  }

  public AbstractValue add(AbstractValue operand) {
    return new complexValue(
      this.real + ((complexValue) operand).real,
      this.image + ((complexValue) operand).image
    );
  }

  public AbstractValue sub(AbstractValue operand) {
    return new complexValue(
      this.real - ((complexValue) operand).real,
      this.image - ((complexValue) operand).image
    );
  }

  public AbstractValue mul(AbstractValue operand) {
    return new complexValue(
      this.real *
      ((complexValue) operand).real -
      this.image *
      ((complexValue) operand).image,
      this.real *
      ((complexValue) operand).real +
      this.image *
      ((complexValue) operand).image
    );
  }

  public AbstractValue div(AbstractValue operand)
    throws DivisionByZeroException {
    double intReal = ((complexValue) operand).real;
    double intImage = ((complexValue) operand).image;
    if (intReal == 0 && intImage == 0) throw new DivisionByZeroException();
    return new complexValue(
      (
        this.real *
        ((complexValue) operand).real +
        this.image *
        ((complexValue) operand).image
      ) /
      (
        ((complexValue) operand).real *
        ((complexValue) operand).real +
        ((complexValue) operand).image *
        ((complexValue) operand).image
      ),
      (
        this.real *
        ((complexValue) operand).real -
        this.image *
        ((complexValue) operand).image
      ) /
      (
        ((complexValue) operand).real *
        ((complexValue) operand).real +
        ((complexValue) operand).image *
        ((complexValue) operand).image
      )
    );
  }
}
