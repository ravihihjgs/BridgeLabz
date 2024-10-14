import java.util.*;
class Calculator{
public static void main(String[] arge){
Scanner sc= new Scanner(System.in);
char operator;
double n,m,result;
 operator=sc.next().charAt(0);
 n=sc.nextDouble();
 m=sc.nextDouble();

switch (operator) {
    case '+':
    result=n+m;
    System.out.println("Sum of " +" "+ n +" and " + m + " is " + result);
    break;
    case '-':
    result=n-m;
    System.out.println("Sub of " +" "+ n+ " and "+ m + " is " + result);
    break;
    case '*':
    result=n*m;
    System.out.println("Mul of " +" "+ n+" and "+ m  + " is " + result);
    break;
    case '/':
    result=n/m;
    System.out.println("Dev of "+ n + " and " + m + " is " + result);
    break;
    

    default:
        break;
}



}
}