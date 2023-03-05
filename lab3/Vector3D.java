public class Vector3D {
  double x;
  double y;
  double z;

  public Vector3D(double xEl,double yEl,double zEl)//конструктор 
  { 
    x = xEl;
    y = yEl;
    z = zEl;
  }
  double getX() {
    return x;
  }
  double getY() {
    return y;
  }
  double getZ() {
    return z;
  }

  double scalar(Vector3D v) {
    return x*v.x + y*v.y + z*v.z; 
  } // скалярное произведение векторов
  double len(){
    return Math.sqrt(x*x + y*y + z*z); 
  } // длина вектора
  Vector3D multiply(double factor){
    return new Vector3D(x*factor,y*factor,z*factor);  
  } // умножение на число
  Vector3D add(Vector3D v) {
    return new Vector3D(x+v.x,y+v.y,z+v.z);  
  } // сложение векторов
  Vector3D sub(Vector3D v) {
    return new Vector3D(x-v.x,y-v.y,z-v.z);  
  } // вычитание векторов
  Vector3D vecX(Vector3D v) {
    return new Vector3D(y*v.z-z*v.y, z*v.x-x*v.z, x*v.y-y*v.x);     
  } // векторное произведение векторов
  boolean pcollin(Vector3D v) {
    return this.vecX(v).equals(new Vector3D(0, 0, 0));
  } // проверка на коллинеарность
  boolean equals(Vector3D v) {
    return x == v.x && y == v.y && z == v.z;
  } 
}
