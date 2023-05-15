import java.util.Scanner;

public class Vector2DTest {
    public static void main(String[] args) {
      // task1();
      try {
        task2();
      } catch (VcollinearException e) {
        e.printStackTrace();
      } catch (NonSemException e) {
        e.printStackTrace();
      }
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
      double s1, s2 ,s3, s4, s5, s6, s7, s8, lenA1X;
      Vector2D n, A, B, A1, O, pr, newN;
      Scanner sc = new Scanner(System.in);
      System.out.println("Введите кординаты точки A");
      s1 = Double.parseDouble(sc.nextLine());
      s2 = Double.parseDouble(sc.nextLine());
      System.out.println("Введите кординаты точки B");
      s3 = Double.parseDouble(sc.nextLine());
      s4 = Double.parseDouble(sc.nextLine());
      System.out.println("Введите кординаты нормали для прямой");
      s5 = Double.parseDouble(sc.nextLine());
      s6 = Double.parseDouble(sc.nextLine());
      System.out.println("Введите кординаты точки для прямой");
      s7 = Double.parseDouble(sc.nextLine());
      s8 = Double.parseDouble(sc.nextLine());
      A = new Vector2D(s1 , s2);
      B = new Vector2D(s3 , s4);
      n = new Vector2D(s5, s6);
      O = new Vector2D(s7, s8);
      A1 = (Vector2D) (Vector2DTest.calcSim(n,(Vector2D) O.sub(A)));
      if (n.pcollin((Vector2D) A1.sub(B))) {
        sc.close();
        throw new VcollinearException(); 
      }
      if (n.pr(A) * n.pr(B) > 0) {
        sc.close();
        throw new NonSemException(); 
      }
      A.sub(O).printVector();
      pr = (Vector2D) n.prVect(((Vector2D) O.sub(A)));
      A1 = (Vector2D) pr.multiply(-1).add(O);
      lenA1X = (pr.len() * pr.len())/(pr.multiply(-1).scalar(B.sub(A1)));
      newN = (Vector2D) A1.sub(B).multiply(1/A1.sub(B).len());
      A1.add(newN.multiply(lenA1X)).printVector();
      sc.close();
      // A 2 0 ; B -1 2; n 1 -1; O 1 1
      // A 2 0 ; B -1 0; n 1 -1; O 1 1

    }
}
