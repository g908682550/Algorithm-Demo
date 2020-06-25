package test;

import java.util.HashMap;
import java.util.Map;

public class MapConstant {

    private static final Map<String,String> GROUP_ATTRIBUTES_MAP = new HashMap<>();

    private static final Map<String,String> GRADE_ATTRIBUTES_MAP = new HashMap<>();

    public static Map<String, String> getGroupAttributesMap() {

        return GROUP_ATTRIBUTES_MAP;
    }

    public static Map<String, String> getGradeAttributesMap() {
        GRADE_ATTRIBUTES_MAP.put("sub_title","subTitle");
        GRADE_ATTRIBUTES_MAP.put("logo","logo");
        GRADE_ATTRIBUTES_MAP.put("big_Picture","bigPicture");
        return GRADE_ATTRIBUTES_MAP;
    }

}
