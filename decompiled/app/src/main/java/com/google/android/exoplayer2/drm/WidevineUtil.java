package com.google.android.exoplayer2.drm;

/* loaded from: classes.dex */
public final class WidevineUtil {
    public static final java.lang.String PROPERTY_LICENSE_DURATION_REMAINING = "LicenseDurationRemaining";
    public static final java.lang.String PROPERTY_PLAYBACK_DURATION_REMAINING = "PlaybackDurationRemaining";

    private WidevineUtil() {
    }

    public static android.util.Pair<java.lang.Long, java.lang.Long> getLicenseDurationRemainingSec(com.google.android.exoplayer2.drm.DrmSession<?> drmSession) {
        java.util.Map<java.lang.String, java.lang.String> mapQueryKeyStatus = drmSession.queryKeyStatus();
        if (mapQueryKeyStatus == null) {
            return null;
        }
        return new android.util.Pair<>(java.lang.Long.valueOf(getDurationRemainingSec(mapQueryKeyStatus, PROPERTY_LICENSE_DURATION_REMAINING)), java.lang.Long.valueOf(getDurationRemainingSec(mapQueryKeyStatus, PROPERTY_PLAYBACK_DURATION_REMAINING)));
    }

    private static long getDurationRemainingSec(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        if (map == null) {
            return -9223372036854775807L;
        }
        try {
            java.lang.String str2 = map.get(str);
            if (str2 != null) {
                return java.lang.Long.parseLong(str2);
            }
            return -9223372036854775807L;
        } catch (java.lang.NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }
}
