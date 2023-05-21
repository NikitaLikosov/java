import java.awt.Color;

abstract class Figure {

  protected String name; // название фигуры
  protected Color color = Color.black; // цвет линии
  protected double x = 0;
  protected double y = 0;

  public Figure(String nm) {
    name = nm;
  }

  public Figure(String nm, Color color) {
    name = nm;
    this.color = color;
  }

  public Figure(String nm, Color color, double x, double y) {
    name = nm;
    this.color = color;
    this.x = x;
    this.y = y;
  }
}
