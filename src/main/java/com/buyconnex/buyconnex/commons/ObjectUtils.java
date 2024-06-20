package com.buyconnex.buyconnex.commons;
import java.util.Collection;
import java.util.Map;

public class ObjectUtils {

	public static boolean isNotNullOrNotEmptyString(String str) {
		return str != null && !str.isEmpty();
	}
	

	public static boolean isNotNullOrEmpty(Object obj) {
	    if (obj == null) {
	        return false;
	    } else if (obj instanceof String) {
	        return !((String) obj).trim().isEmpty();
	    } else if (obj instanceof Collection) {
	        return !((Collection<?>) obj).isEmpty();
	    } else if (obj instanceof Map) {
	        return !((Map<?, ?>) obj).isEmpty();
	    }
	    return true; // Pour d'autres types d'objets non nulls
	}

}
