class q2 {
  public static void main(String[] args) {
    System.out.println(area(3, 3));
    System.out.println(area(3.1f, 2.4f));
    System.out.println(area(4.3, 2.1));
  }

  static int area(int a, int b) {
    return a * b;
  }

  static float area(float a, float b) {
    return a * b;
  }

  static double area(double b, double h) {
    return 0.5 * b * h;
  }
}

