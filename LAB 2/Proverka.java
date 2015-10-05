import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Proverka {
	public static boolean regular(String s)
	{
		Pattern p = Pattern.compile("\\d\\d.\\d\\d(USD|RUR|EU)");
		Matcher m =p.matcher(s);
		return m.matches();
	}

}
