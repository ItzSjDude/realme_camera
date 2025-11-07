package com.google.android.exoplayer2.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class RepeatModeUtil {
    public static final int REPEAT_TOGGLE_MODE_ALL = 2;
    public static final int REPEAT_TOGGLE_MODE_NONE = 0;
    public static final int REPEAT_TOGGLE_MODE_ONE = 1;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatToggleModes {
    }

    public static boolean isRepeatModeEnabled(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 != 0) {
            return OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 == 2 && (i2 & 2) != 0 : (i2 & 1) != 0;
        }
        return true;
    }

    private RepeatModeUtil() {
    }

    public static int getNextRepeatMode(int OplusGLSurfaceView_13, int i2) {
        for (int i3 = 1; i3 <= 2; i3++) {
            int i4 = (OplusGLSurfaceView_13 + i3) % 3;
            if (isRepeatModeEnabled(i4, i2)) {
                return i4;
            }
        }
        return OplusGLSurfaceView_13;
    }
}
