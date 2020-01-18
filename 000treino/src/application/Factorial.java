package application;

class Factorial{
  public int factorial (int n){
    if(n>1){
      n *= factorial(n-1);
    }
    return n;
  }

  public static void main (String [] args){
    System.out.println(new Factorial().factorial(8));
  }
}
