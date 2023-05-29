import java.awt.*;

public class Rectangle extends Figure implements IShape {

  public double height;
  public double weight;

  public Rectangle(double x, double y, double height, double weight) {
    super("Прямоугольник", Color.BLUE, x, y);
    this.height = height;
    this.weight = weight;
  }

  @Override
  public double getPerimeter() {
    return 2 * (height + weight);
  }

  @Override
  public double getArea() {
    return height * weight;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public double diagonalRect() {
    return Math.sqrt(height * height + weight * weight);
  }

  public double roundRect() {
    double rad, a = height, b = weight;
    rad = (Math.sqrt(a * a + b * b)) / 2;
    return rad;
  }

  public double sharpParal(double k) {
    if (k >= 1 || k <= 0) {
      throw new Error("k not valid");
    }
    return Math.sin(k);
  }
}
