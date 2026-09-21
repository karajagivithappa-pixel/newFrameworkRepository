package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int randomNumber() {
		Random r=new Random();
		int num=r.nextInt();
		if(num>0) {
			return num; 
		}
		else
			return -num;
	}
	
	public String currectDate()
    {
        Date d= new Date();// returns current date and time
        SimpleDateFormat simdate= new SimpleDateFormat("yyyy-MM-dd");// to get date only
        return simdate.format(d);
    }

    public String endDate()
    {
    	Calendar cal = Calendar.getInstance(); // Gets today's date/time
        cal.add(Calendar.DAY_OF_MONTH, 30);    // Adds 30 days to today
        SimpleDateFormat simdate = new SimpleDateFormat("yyyy-MM-dd");
        return simdate.format(cal.getTime());

    }
}