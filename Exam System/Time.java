import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;
class TestDt
{
public static String TodayDate = getTodayDate();

	private static String getTodayDate() {
		Date currDate 	= new Date();
		SimpleDateFormat dateFormat 	= new SimpleDateFormat ( "dd/MM/yyyy HH:mm:ss", Locale.getDefault() );
		return dateFormat.format ( currDate );
	}
public static String TodayTime = getTodayTime();	
	private static String getTodayTime() {
		Date currTime 	= new Date();
		SimpleDateFormat TimeFormat 	= new SimpleDateFormat ( "HH:mm:ss", Locale.getDefault() );
		Calendar cal=Calendar.getInstance();
		System.out.println(TimeFormat.format(cal.getTime()));
		return TimeFormat.format ( currTime );
	}
	public static void main(String z[])
	{
		System.out.println(TodayDate);
		System.out.println(TodayTime);
	
	}
}