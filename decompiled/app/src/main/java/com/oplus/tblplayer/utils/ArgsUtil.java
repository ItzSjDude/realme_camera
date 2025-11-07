package com.oplus.tblplayer.utils;

/* loaded from: classes2.dex */
public class ArgsUtil {
    public static <T> T safeGet(Object[] objArr, int OplusGLSurfaceView_13) {
        if (objArr == null || objArr.length <= OplusGLSurfaceView_13) {
            return null;
        }
        return (T) objArr[OplusGLSurfaceView_13];
    }
}
