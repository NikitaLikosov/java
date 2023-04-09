abstract class  Vector implements IVector  {
  double[] components;
  public abstract Vector categorizer(double[] a);
  public Vector(double[] componentsArr) { 
    this.components = componentsArr;
  };
  public Vector(Vector v, int dim) {
    double[] res = new double[dim];
    for (int i = 0; i < v.dimension(); i++){
      res[i] = v.components[i];
    }
    components = res;
  };
  public int dimension() {
      return components.length;
    }; // размерность
  public double getComponent(int i) {
    return components[i];
  };  // возвращает компоненту вектора
  public void printVector() {
    for (int i = 0; i < components.length; i++){
      System.out.println("Компонент " + i + ": " + components[i]);       
    }
  }; //выводит на консоль информацию о векторе
  public double scalar(Vector v) {
    int res = 0;
    int minLength = Math.min(v.dimension(), this.dimension()); 
    for (int i = 0; i < minLength; i++){
      res += v.getComponent(i) * this.getComponent(i);
    }
    return res;
  };
  public double len() {
    double sum = 0;
    for (int i = 0; i < components.length; i++){
      sum += components[i] * components[i];
    }
    return Math.sqrt(sum);
  };
  public Vector multiply(double factor) {
    double[] res = new double[this.dimension()];
    for (int i = 0; i < this.dimension(); i++){
      res[i] = components[i] * factor;
    }
    return categorizer(res);
  };
  public Vector add(Vector v){
    double[] res = new double[this.dimension()];
    for (int i = 0; i < components.length; i++){
      res[i] = this.components[i] + v.components[i];
    }
    return categorizer(res);
  };
  public Vector sub(Vector v) {
    double[] res = new double[this.dimension()];
    for (int i = 0; i < components.length; i++){
      res[i] = this.components[i] - v.components[i];
    }
    return categorizer(res);
  };
  public double pr(Vector v) {
    return (this.scalar(v))/(v.len());
  }; // возвращает проекция вектора на вектор v
  
}