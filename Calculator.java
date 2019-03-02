
//compiled with Main.java

public class Calculator {     //class calculator support add, subtract, mulitiple, divide, squareroot, and factorial operations.

    int x, y;
    double result;
   //behaviors
    public void addNumbers(int x, int y){
    	result = x + y;
         
    }
    public void subtractNumbers(int x, int y){
    	result = x - y;
        
    }
    public void multiplyNumbers(int x, int y){
    	result = x*y;
        
    }
    public void divideNumbers(int x, int y){
    	result= x/y;
    }
   public void squarerootNumber(double x){
         result= (int) Math.sqrt(x);
    }
    public void factorialNumber(int x){
    	int total=1;
    	for(int i=1; i<x; i++ )
    		total=total*i;
    	result = (total);
    }



     public static void main(String[] args) { 
       //instantiation 
       // show all operations here on myCalculator Object 

      	Calculator john = new Calculator();
		john.factorialNumber(5);
      	System.out.println(john.result);
      }
  


 }