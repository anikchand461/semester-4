import java.util.*;

class q7 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    try {
      int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
      System.out.println(Math.max(a, Math.max(b, c)));
    } catch (Exception e) {
      System.out.println("Error : " + e.getMessage());
    } finally {
      sc.close();
    }
  }
}
