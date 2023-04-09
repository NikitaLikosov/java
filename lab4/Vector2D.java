public class Vector2D extends Vector {
  public Vector2D(double x,double y) {
    super(new double[]{x,y});
  };
  
  @Override
  public Vector2D categorizer(double[] a) {
   return new Vector2D(a[0], a[1]);
  }
  
  public double getX() {
    return this.getComponent(0);
  };
  public double getY(){
    return this.getComponent(0);
  }
  public boolean pcollin(Vector2D v) {
    return v.scalar(this) == 0;
  };
  public Vector perependperependicularicular() {  
    return new Vector2D(- getY(), getX());
  }
  public Vector prVect(Vector2D v) {  
    Vector od = v.multiply(1/v.len());
    return  od.multiply(this.pr(v));
  }
  static public double[] Vect2(Vector2D a, Vector2D b) throws VcollinearException {  
    if (a.pcollin(b)) {
      throw new VcollinearException();
    }
    return new double[]{a.pr(b), b.pr(a)} ;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
     }
    if (o == null || getClass() != o.getClass()) { 
            return false; 
        } 
        Vector2D vector = (Vector2D) o; 
        return vector.getX() == this.getX() && vector.getY() == this.getY();
         
    } 
}
