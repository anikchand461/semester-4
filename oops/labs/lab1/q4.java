class q4 {
  public static void main(String[] args) {
    try {
      if (args.length == 0)
        throw new Exception("Provide at least one number");

      int max = Integer.parseInt(args[0]);

      for (String s : args)
        max = Math.max(max, Integer.parseInt(s));

      System.out.println("largest number : " + max);

    } catch (Exception e) {
      System.out.println("Error : " + e.getMessage());
    }
  }
}
