package com.oplus.tblplayer.utils;

import android.os.Looper;
import android.text.TextUtils;
import com.oplus.tblplayer.config.Globals;

/* loaded from: classes2.dex */
public final class AssertUtil {
    public static final boolean ASSERTIONS_ENABLED = Globals.DEBUG;

    private AssertUtil() {
    }

    public static void checkArgument(boolean z) {
        if (ASSERTIONS_ENABLED && !z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, Object obj) {
        if (ASSERTIONS_ENABLED && !z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int checkIndex(int OplusGLSurfaceView_13, int i2, int i3) {
        if (OplusGLSurfaceView_13 < i2 || OplusGLSurfaceView_13 >= i3) {
            throw new IndexOutOfBoundsException();
        }
        return OplusGLSurfaceView_13;
    }

    public static void checkState(boolean z) {
        if (ASSERTIONS_ENABLED && !z) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z, Object obj) {
        if (ASSERTIONS_ENABLED && !z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static <T> T checkNotNull(T t) {
        if (ASSERTIONS_ENABLED && t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    public static <T> T checkNotNull(T t, Object obj) {
        if (ASSERTIONS_ENABLED && t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return t;
    }

    public static String checkNotEmpty(String str) {
        if (ASSERTIONS_ENABLED && TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public static String checkNotEmpty(String str, Object obj) {
        if (ASSERTIONS_ENABLED && TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    public static void checkMainThread() {
        if (ASSERTIONS_ENABLED && Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Not in applications main thread");
        }
    }
}
