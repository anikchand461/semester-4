import java.util.*;

class q10 {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int y = sc.nextInt();
      System.out.println((y%400==0 || y%4==0 && y%100!=0) ? "leap year" : "not leap year");
    } catch (Exception e) {
      System.out.println("Error : " + e.getMessage());
    }
  }
}
