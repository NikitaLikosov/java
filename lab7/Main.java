import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;

public class Main extends JFrame {

  public Main() {
    super("simpleApp");
    setSize(700, 600);
    setVisible(true);
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D gr2d = (Graphics2D) g; // Рисуем простые линии
    gr2d.setPaint(Color.BLUE);
    gr2d.drawLine(0, 300, 700, 300);
    gr2d.drawLine(350, 0, 350, 600);
    gr2d.setFont(new Font("TimesRoman", Font.PLAIN, 7));
    for (int i = 1; i < 17; i++) {
      gr2d.drawLine(350 + i * 20, 295, 350 + i * 20, 305);
      gr2d.drawString(i + "", 351 + i * 20, 310);
      gr2d.drawLine(350 - i * 20, 295, 350 - i * 20, 305);
      gr2d.drawLine(345, 300 + i * 20, 355, 300 + i * 20);
      gr2d.drawLine(345, 300 - i * 20, 355, 300 - i * 20);
      gr2d.drawString(i + "", 352, 300 - i * 20);
    }

    Rectangle rt = new Rectangle(300, 250, 100, 100);
    gr2d.setPaint(Color.black);
    gr2d.draw(new Rectangle2D.Double(rt.x, rt.y, rt.height, rt.weight));
    double rad = rt.roundRect();
    System.out.println(rad);
    double crx = rt.x + rt.height / 2;
    double cry = rt.y + rt.weight / 2;
    gr2d.setPaint(Color.red);
    gr2d.draw(new Ellipse2D.Double(crx - rad, cry - rad, 2 * rad, 2 * rad));
    System.out.println(
      "острый угол параллелограмма равен: " + rt.sharpParal(0.5)
    );
  }

  public static void main(String args[]) {
    new Main();
  }
}
