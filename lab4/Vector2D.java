public class Vector2D extends Vector {
  public Vector2D(double x,double y) {
    super(new double[]{x,y});
  };
  public double getX() {
    return this.getComponent(0);
  };
  public double getY(){
    return this.getComponent(0);
  }
  public Vector perependicular() {  
    return new Vector2D(- getY(), getX());
  }
  public Vector prVect(Vector2D v) {  
    Vector od = v.multiply(1/v.len());
    return  od.multiply(this.pr(v));
  }
  

}
