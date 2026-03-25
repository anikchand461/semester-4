import java.util.*;

class q9 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      double m = sc.nextDouble();
      System.out.printf("%f miles = %f kms", m, m * 1.60934);
    } catch (Exception e) {
      System.out.println("Error : " + e.getMessage());
    }
  }
}
