import java.util.*;

class q3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    try {
      int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

      switch (c) {
        case 1:
          System.out.println("addition : " + (a + b));
          break;
        case 2:
          System.out.println("subtraction : " + (a - b));
          break;
        case 3:
          System.out.println("multiplication : " + (a * b));
          break;
        case 4:
          System.out.println("division : " + (a / b));
          break;
        default:
          System.out.println("invalid choice");
      }

    } catch (Exception e) {
      System.out.println("exception : " + e.getMessage());
    } finally {
      sc.close();
    }
  }
}
