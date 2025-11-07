package com.oplus.tblplayer.utils;

/* loaded from: classes2.dex */
public class ArgsUtil {
    public static <T_renamed> T_renamed safeGet(java.lang.Object[] objArr, int i_renamed) {
        if (objArr == null || objArr.length <= i_renamed) {
            return null;
        }
        return (T_renamed) objArr[i_renamed];
    }
}
