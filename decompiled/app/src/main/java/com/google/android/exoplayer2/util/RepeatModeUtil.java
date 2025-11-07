package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class RepeatModeUtil {
    public static final int REPEAT_TOGGLE_MODE_ALL = 2;
    public static final int REPEAT_TOGGLE_MODE_NONE = 0;
    public static final int REPEAT_TOGGLE_MODE_ONE = 1;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface RepeatToggleModes {
    }

    public static boolean isRepeatModeEnabled(int i_renamed, int i2) {
        if (i_renamed != 0) {
            return i_renamed != 1 ? i_renamed == 2 && (i2 & 2) != 0 : (i2 & 1) != 0;
        }
        return true;
    }

    private RepeatModeUtil() {
    }

    public static int getNextRepeatMode(int i_renamed, int i2) {
        for (int i3 = 1; i3 <= 2; i3++) {
            int i4 = (i_renamed + i3) % 3;
            if (isRepeatModeEnabled(i4, i2)) {
                return i4;
            }
        }
        return i_renamed;
    }
}
