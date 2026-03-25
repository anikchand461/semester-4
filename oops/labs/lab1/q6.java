import java.util.*;

class q6 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    try {
      String s = sc.nextLine();
      char c = sc.next().charAt(0);
      float f = sc.nextFloat();

      System.out.println(s + c + f);
    } catch (Exception e) {
      System.out.println("Error : " + e.getMessage());
    } finally {
      sc.close();
    }
  }
}
