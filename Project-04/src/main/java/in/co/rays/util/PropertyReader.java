package in.co.rays.util;

import java.util.ResourceBundle;

public class PropertyReader {

	private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.system");

	public static String getValue(String key) {

		String val = null;

		try {
			val = rb.getString(key); // {0} is required
		} catch (Exception e) {
			val = key;
		}
		return val;
	}

	public static String getValue(String key, String param) {
		String msg = getValue(key); // {0} is required
		msg = msg.replace("{0}", param);
		return msg;
	}

	public static String getValue(String key, String[] params) {
		String msg = getValue(key);
		for (int i = 0; i < params.length; i++) {
			msg = msg.replace("{" + i + "}", params[i]);
		}
		return msg;
	}

	public static void main(String[] args) {
		// String[] params = { "Roll No" };
		// System.out.println(PropertyReader.getValue("error.require", params));
		System.out.println(PropertyReader.getValue("error.require", "loginId"));
	}
}
