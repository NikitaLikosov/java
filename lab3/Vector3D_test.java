import static org.junit.Assert.*;

import org.junit.Test;

public class Vector3D_test {
  @org.junit.Test
  public void testScalar() {
    double res= new Vector3D(1, 1, 1).scalar(new Vector3D(1, 1, 1));
    assertEquals(3.0, res, 0.001);   
  } // скалярное произведение векторов
  @org.junit.Test
  public void testLen() {
    double res= new Vector3D(0, 0, 2).len();
    assertEquals(2.0, res, 0.001);   
  } // длина вектора
  @org.junit.Test
  public void testMultiply() {
    Vector3D res= new Vector3D(1, 1, 1).multiply(5);
    assertEquals(new Vector3D(5, 5, 5), res);   
  } // умножение на число
  @org.junit.Test
  public void testAdd() {
    Vector3D res= new Vector3D(1, 1, 1).add(new Vector3D(1, 1, 1));
    assertEquals(new Vector3D(2, 2, 2), res);   
  } // сложение векторов
  @org.junit.Test
  public void testSub() {
    Vector3D res= new Vector3D(1, 1, 1).sub(new Vector3D(1, 1, 1));
    assertEquals(new Vector3D(0, 0, 0), res);   
  } // вычитание векторов
  @org.junit.Test
  public void testVecX() {
    Vector3D res= new Vector3D(1, 1, 1).vecX(new Vector3D(1, 1, 1));
    assertEquals(new Vector3D(0,0,0), res);   
  } // векторное произведение векторов
  @org.junit.Test
  public void testPcollin() {
    boolean res= new Vector3D(1, 1, 1).pcollin(new Vector3D(1, 1, 1));
    assertEquals(true, res);   
  } // проверка на коллинеарность
}
