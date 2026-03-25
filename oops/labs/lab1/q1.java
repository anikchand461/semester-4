import java.util.*;

class q1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    try {
      String name = sc.nextLine();
      String address = sc.nextLine();
      String info = sc.nextLine();

      System.out.println("name : " + name);
      System.out.println("address : " + address);
      System.out.println("other info : " + info);
    
    } catch (Exception e) {
      System.out.println("Error occurred : " + e.getMessage());
    } finally {
      sc.close();
    }
  }
}



