import java.io.UnsupportedEncodingException;

import org.jcodings.specific.ASCIIEncoding;
import org.joni.Matcher;
import org.joni.Config;
import org.joni.Option;
import org.joni.Regex;
import org.joni.Syntax;
import org.joni.exception.JOniException;
import org.joni.Region;

class TestJoni {

	public static void test_re(String str_pattern, String str_target) {
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
			return;
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

	    Matcher m = reg.matcher(byte_target, 0, byte_target.length);
	    Region region;

	    int r = 0;
	    try {
	        r = m.search(0, byte_target.length, Option.NONE);
	        region = m.getEagerRegion();
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
//	    if (r == -1) {
//	      System.out.println("no match");
//		} 
//		else {
//	      System.out.printf("match: %s\n", region.toString());
//		}
	}
}