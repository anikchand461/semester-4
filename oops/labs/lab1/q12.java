import java.util.*;

class q12 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(n%5==0 ? "divisible by 5" : "not divisible by 5");
    } catch (Exception e) {
      System.out.println("Error : " + e.getMessage());
    }
  }
}
