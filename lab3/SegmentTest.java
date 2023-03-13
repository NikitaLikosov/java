import java.util.Scanner;

public class SegmentTest {
  public static void main() {
    double x1, y1, z1, x2, y2, z2, x3, y3, z3;
    Scanner sc = new Scanner(System.in);
    System.out.println("введите кординаты отрезка");    
    x1 = Double.parseDouble(sc.nextLine());
    y1 = Double.parseDouble(sc.nextLine());
    z1 = Double.parseDouble(sc.nextLine());

    x2 = Double.parseDouble(sc.nextLine());
    y2 = Double.parseDouble(sc.nextLine());
    z2 = Double.parseDouble(sc.nextLine());
    Segment segment = new Segment(new Vector3D(x1, y1, z1), new Vector3D(x2, y2, z2));
    System.out.println("введите кординаты точки");    
    x3 = Double.parseDouble(sc.nextLine());
    y3 = Double.parseDouble(sc.nextLine());
    z3 = Double.parseDouble(sc.nextLine());
    Vector3D point = new Vector3D(x3, y3, z3);
    
    System.out.println(segment.len());
    System.out.println(segment.distanceTo(point));

  }
}
