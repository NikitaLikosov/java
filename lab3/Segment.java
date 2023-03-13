import java.lang.reflect.Constructor;

public class Segment {
  Vector3D vectorA; 
  Vector3D vectorB; 
  public Segment (Vector3D vectorA, Vector3D vectorB) {
    this.vectorA = vectorA; 
    this.vectorB = vectorB;
  }
  public double len() {
    return vectorB.sub(vectorA).len();
  }// длина отрезка
  public double distanceTo(Vector3D point) {
    if (this.len() <= vectorA.sub(point).len() || this.len() <= vectorA.sub(point).len()) {
      return vectorA.sub(point).len() < vectorB.sub(point).len() ? vectorA.sub(point).len() : vectorB.sub(point).len();
    } 
    if (this.len() == vectorA.sub(point).len() + vectorA.sub(point).len()) {
      return 0;
    }
    double a = vectorA.sub(point).len();
    double b = vectorA.sub(point).len();
    double c = this.len();
    double p = (a + b + c) / 2;
    return (this.len()* 0.5) / Math.sqrt(p*(p-a)*(p-b)*(p-c)); 
  };// расстояние от точки до отрезка
}
