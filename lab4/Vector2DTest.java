import java.util.Scanner;

public class Vector2DTest {
    public static void main(String[] args) {
      task1();
      // try {
      //   task2();
      // } catch (VcollinearException e) {
      //   e.printStackTrace();
      // } catch (NonSemException e) {
      //   e.printStackTrace();
      // }
    }
    public static void task1() {
      double s1,  s2 ,s3, s4, s5, s6;
      Vector2D n, vector, P;
      Scanner sc = new Scanner(System.in);
      System.out.println("Введите кординаты точки p");
      s1 = Double.parseDouble(sc.nextLine());
      s2 = Double.parseDouble(sc.nextLine());
      System.out.println("Введите кординаты вектора нормали n");
      s3 = Double.parseDouble(sc.nextLine());
      s4 = Double.parseDouble(sc.nextLine());
      System.out.println("Введите кординаты точки S");
      s5 = Double.parseDouble(sc.nextLine());
      s6 = Double.parseDouble(sc.nextLine());
      n = new Vector2D(s3, s4 );
      vector = new Vector2D(s5, s6);
      P = new Vector2D(s1, s2);
      P.add(calcSim(n ,(Vector2D) vector.sub(P))).printVector();
      sc.close();
    }
    
    public static Vector2D calcSim(Vector2D n,Vector2D vector) {
      return (Vector2D) vector.add(vector.prVect(n).multiply(-2));
    }
    
    public static void task2() throws VcollinearException, NonSemException {
      double s1, s2 ,s3, s4, s5, s6;
      Vector2D n, A, B, A1;
      Scanner sc = new Scanner(System.in);
      System.out.println("Введите кординаты точки A");
      s1 = Double.parseDouble(sc.nextLine());
      s2 = Double.parseDouble(sc.nextLine());
      System.out.println("Введите кординаты симметричного вектора a");
      s3 = Double.parseDouble(sc.nextLine());
      s4 = Double.parseDouble(sc.nextLine());
      System.out.println("Введите кординаты точки B");
      s5 = Double.parseDouble(sc.nextLine());
      s6 = Double.parseDouble(sc.nextLine());
      A = new Vector2D(s1 , s2);
      n = new Vector2D(s3, s4);
      B = new Vector2D(s5 , s6);
      A1 = (Vector2D) B.sub(Vector2DTest.calcSim(n, A));
      if (n.pcollin(A1)) {
        sc.close();
        throw new VcollinearException(); 
      }
      if (n.pr(A) * n.pr(B) < 0) {
        sc.close();
        throw new NonSemException(); 
      }
      Vector2DTest.calcSim(n, A).add(A1.multiply(Vector2D.Vect2(A1, n)[0])).printVector();
      sc.close();
    }
}
