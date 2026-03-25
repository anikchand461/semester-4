import java.util.*;

class q8 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    try {
      int a = sc.nextInt();
      int b = sc.nextInt();

      // swap
      int t = a;
      a = b;
      b = t;

      System.out.println("a : " + a + ", b : " + b);
    } catch (Exception e) {
      System.out.println("Error : " + e.getMessage());
    } finally {
      sc.close();
    }
  }
}
