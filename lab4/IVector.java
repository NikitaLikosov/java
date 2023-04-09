
public interface IVector {
  public abstract Vector categorizer(double[] a);
  public int dimension();
  public double getComponent(int i);
  public void printVector();
  public double scalar(Vector v);
  public double len();
  public Vector multiply(double factor);
  public Vector add(Vector v);
  public Vector sub(Vector v);
  public double pr(Vector v);

}