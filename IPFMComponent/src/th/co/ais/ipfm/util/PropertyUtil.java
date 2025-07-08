package th.co.ais.ipfm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertyUtil {
	private static Hashtable cache = null;
	private static String propertyPath = null;

	private static void getPropertyPath() {
		ResourceBundle rb = ResourceBundle.getBundle("th.co.ais.ipfm.resource.ipfm_resource");
		propertyPath = rb.getString("IPFMPropertyFile");
	}

	private static void getPropertyFile() {
		if (propertyPath == null)
			getPropertyPath();

		cache = new Hashtable();

		try {
			ResourceBundle rb = new PropertyResourceBundle(new FileInputStream(propertyPath));

			for (Enumeration enumeration = rb.getKeys(); enumeration.hasMoreElements();) {
				String key = (String) enumeration.nextElement();
				cache.put(key, rb.getString(key));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static Hashtable getAllProperty() {
		if (cache == null) {
			getPropertyFile();
		}

		return cache;
	}

	public static Hashtable reloadProperty() {
		getPropertyFile();

		return cache;
	}

	public static String getProperty(String key) {
		if (cache == null) {
			getPropertyFile();
		}

		return (String) cache.get(key);
	}
}
