import java.io.UnsupportedEncodingException;

import org.jcodings.specific.ASCIIEncoding;
import org.joni.Config;
import org.joni.Option;
import org.joni.Regex;
import org.joni.Syntax;
import org.joni.exception.JOniException;

class TestJoni {

	public static void main(String[] args) {
		String str_pattern = "foo";
		String str_target = " fooo ";
		byte[] byte_pattern;
		byte[] byte_target;
		Regex reg;
		try {
			byte_pattern = str_pattern.getBytes("iso-8859-2");
			byte_target = str_target.getBytes("iso-8859-2");
			reg = new Regex(byte_pattern, 0, byte_pattern.length, Option.DEFAULT, ASCIIEncoding.INSTANCE,
					Syntax.DEFAULT);
			
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		} catch (JOniException je) {
			Config.err.println("Pattern: " + str_pattern + " Str: " + str_target);
			je.printStackTrace(Config.err);
			Config.err.println("ERROR: " + je.getMessage());
			return;
		} catch (Exception e) {
			Config.err.println("Pattern: " + str_pattern + " Str: " + str_target);
			e.printStackTrace(Config.err);
			Config.err.println("SEVERE ERROR: " + e.getMessage());
			return;
		}

		System.out.println("hi");
	}
}