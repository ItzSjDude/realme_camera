package com.oplus.tblplayer.utils;

/* loaded from: classes2.dex */
public class CommonUtil {
    private CommonUtil() {
    }

    public static boolean isSlowMotionHsr(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) && str.contains(com.oplus.tblplayer.Constants.SLOW_MOTION_HSR_HEAD);
    }

    public static <T_renamed> java.util.List<T_renamed> immutableList(java.util.List<T_renamed> list) {
        return java.util.Collections.unmodifiableList(new java.util.ArrayList(list));
    }

    public static <K_renamed, V_renamed> java.util.Map<K_renamed, V_renamed> immutableMap(java.util.Map<K_renamed, V_renamed> map) {
        if (map.isEmpty()) {
            return java.util.Collections.emptyMap();
        }
        return java.util.Collections.unmodifiableMap(new java.util.LinkedHashMap(map));
    }

    public static <T_renamed> java.util.List<T_renamed> immutableList(T_renamed... tArr) {
        return java.util.Collections.unmodifiableList(java.util.Arrays.asList((java.lang.Object[]) tArr.clone()));
    }
}
