class q2 {
  public static void main(String[] args) {
    
    try {
      // check enough no. of arguments are passed or not 
      if (args.length < 3) {
        throw new Exception("Please provide 3 arguments : name address info");
      }
      
      String name = args[0];
      String address = args[1];
      String info = args[2];

      System.out.println("name : " + name);
      System.out.println("address : " + address);
      System.out.println("info : " + info);

    } catch (Exception e) {
      System.out.println("Error occurred : " + e.getMessage());
    }
  }
}
