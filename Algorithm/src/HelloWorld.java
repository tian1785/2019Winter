import java.util.*;

public class HelloWorld{

	public static void main(String []args){
         
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
        
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
        
		int days = 0;
		String[] name = {"January", "February", "March", "April","May", "June", "July", "August", "September", "October", "November", "December"};
        int[] d = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		
        days = d[month];
        
        if(month==1 && ((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0))
            days = 29;
        
        
        System.out.println(year +" " + (name[month]) + " has "+days + " days");        
        
     }
}