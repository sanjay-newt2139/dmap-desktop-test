package th.co.ais.ipfm.web.util;

import java.util.HashMap;
import java.util.Iterator;

public class FaceNavigatorMapping {
	private static FaceNavigatorMapping faceNavInstance;
	private HashMap<String, String> navigationCaseMap;

	private FaceNavigatorMapping() {
		navigationCaseMap = new HashMap<String, String>();
	}

	public static FaceNavigatorMapping getInstance() {
		if (faceNavInstance == null) {
			faceNavInstance = new FaceNavigatorMapping();
		}
		return faceNavInstance;
	}

	protected void putNavigationCaseMap(String formOutCome, String viewPath)
			throws Exception {
		if (navigationCaseMap == null) {
			throw new Exception(
					" Data never been initialed by FaceConfiureParserListener............");
		}
		navigationCaseMap.put(formOutCome, viewPath);
	}

	protected void removeNavigationCaseMap() throws Exception {
		if (navigationCaseMap == null) {
			throw new Exception(
					" Data never been initialed by FaceConfiureParserListener............");
		}
		if (navigationCaseMap.size() > 0) {
			Iterator<String> it = navigationCaseMap.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				navigationCaseMap.remove(key);
			}
		}
		navigationCaseMap = null;
	}

	public String urlPathViewFinder(String formOutComeMappCase)
			throws Exception {
		if (navigationCaseMap == null) {
			throw new Exception(
					" Data never been initialed by FaceConfiureParserListener............");
		}
		if (formOutComeMappCase != null) {
			return navigationCaseMap.get(formOutComeMappCase);
		} else {
			return null;
		}
	}
}
