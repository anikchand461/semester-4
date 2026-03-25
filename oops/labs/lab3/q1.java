class q1 {
  public static void main(String[] args) {
    System.out.println(add(2, 3));
    System.out.println(add(3, 2, 7));
    System.out.println(add(4.3f, 2.1f));
  }

  static int add(int a, int b) {
    return a + b;
  }

  static int add(int a, int b, int c) {
    return a + b + c;
  }

  static float add(float a, float b) {
    return a + b;
  }
}
