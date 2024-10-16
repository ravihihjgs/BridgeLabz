import java.util.*;
public class isEmployee {
    public static void main(String[] args) {
        
    
    Scanner sc= new Scanner(System.in);
    int att=0;
    int salary=0;
    String  Name=sc.nextLine();
    String  compamy=sc.nextLine();
  
    System.out.println(totalsalary(att, salary,Name,compamy));
     
    }
    static int totalsalary(int att,int salary,String Name,String company){
      while(att<=30){
        Random random=new Random();
        int ran=random.nextInt(3);
        
        if(ran==0){
            salary+=0;
        }
        else if(ran==1){
            salary+=500;
        }
        else if(ran==2){
            salary+=1000;
        }
        att++;
     }
     return salary;
    
    
    } 
}
