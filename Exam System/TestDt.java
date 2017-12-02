import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
class TestDt
{
public static String TodayDate = getTodayDate();

	private static String getTodayDate() {
		Date currDate 	= new Date();
		SimpleDateFormat dateFormat 	= new SimpleDateFormat ( "dd/MM/yyyy", Locale.getDefault() );
		return dateFormat.format ( currDate );
	}
	public static void main(String z[])
	{
		System.out.println(TodayDate);
	}
}