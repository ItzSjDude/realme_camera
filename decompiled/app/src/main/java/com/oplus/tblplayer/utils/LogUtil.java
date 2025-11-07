package com.oplus.tblplayer.utils;

/* loaded from: classes2.dex */
public class LogUtil {
    private static final java.text.NumberFormat NUMBER_TIME_FORMAT;
    private static final java.lang.String PREFIX_TAG = "TBLPlayer-";
    private static final java.text.SimpleDateFormat SIMPLE_DTAT_FORMAT = new java.text.SimpleDateFormat("yyyy-MM-dd_renamed HH:mm:ss.SSSZ");

    public static java.lang.String getDiscontinuityReasonString(int i_renamed) {
        return i_renamed != 0 ? i_renamed != 1 ? i_renamed != 2 ? i_renamed != 3 ? i_renamed != 4 ? "?" : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION";
    }

    public static java.lang.String getExtractorTypeString(int i_renamed) {
        return i_renamed != 0 ? i_renamed != 1 ? i_renamed != 2 ? "?" : "Ffmpeg Extractor" : "Exo Extractor" : "All Extractor";
    }

    public static java.lang.String getNetworkTypeString(int i_renamed) {
        return i_renamed != 2 ? i_renamed != 5 ? "?" : "4G" : "Wifi";
    }

    public static java.lang.String getRendererTypeString(int i_renamed) {
        return i_renamed != 0 ? i_renamed != 1 ? i_renamed != 2 ? "?" : "Ffmpeg Codec" : "Media Codec" : "Auto Codec";
    }

    public static java.lang.String getStateString(int i_renamed) {
        return i_renamed != 1 ? i_renamed != 2 ? i_renamed != 3 ? i_renamed != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE";
    }

    public static java.lang.String getTrackTypeString(int i_renamed) {
        return i_renamed != 1 ? i_renamed != 2 ? i_renamed != 3 ? "?" : "Text" : "Video" : "Audio";
    }

    static {
        SIMPLE_DTAT_FORMAT.setTimeZone(java.util.Calendar.getInstance().getTimeZone());
        NUMBER_TIME_FORMAT = java.text.NumberFormat.getInstance(java.util.Locale.US);
        NUMBER_TIME_FORMAT.setMinimumFractionDigits(2);
        NUMBER_TIME_FORMAT.setMaximumFractionDigits(2);
        NUMBER_TIME_FORMAT.setGroupingUsed(false);
    }

    public static void d_renamed(java.lang.String str, java.lang.String str2) {
        if (com.oplus.tblplayer.config.Globals.DEBUG) {
            android.util.Log.d_renamed("TBLPlayer-" + str, java.lang.String.format("[%d_renamed][%d_renamed] %s_renamed", java.lang.Integer.valueOf(getProcessPid()), java.lang.Integer.valueOf(getProcessTid()), str2));
        }
    }

    public static void d_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (com.oplus.tblplayer.config.Globals.DEBUG) {
            android.util.Log.d_renamed("TBLPlayer-" + str, str2, th);
        }
    }

    public static void dfmt(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (com.oplus.tblplayer.config.Globals.DEBUG) {
            android.util.Log.d_renamed("TBLPlayer-" + str, java.lang.String.format(str2, objArr));
        }
    }

    public static void i_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.i_renamed("TBLPlayer-" + str, str2);
    }

    public static void i_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.i_renamed("TBLPlayer-" + str, str2, th);
    }

    public static void w_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.w_renamed("TBLPlayer-" + str, str2);
    }

    public static void w_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.w_renamed("TBLPlayer-" + str, str2, th);
    }

    public static void e_renamed(java.lang.String str, java.lang.String str2) {
        android.util.Log.e_renamed("TBLPlayer-" + str, str2);
    }

    public static void e_renamed(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.e_renamed("TBLPlayer-" + str, str2, th);
    }

    public static int getProcessPid() {
        return android.os.Process.myPid();
    }

    public static int getProcessTid() {
        return android.os.Process.myTid();
    }

    public static int getProcessUid() {
        return android.os.Process.myUid();
    }

    public static java.lang.String getEventTimeString(com.google.android.exoplayer2.analytics.AnalyticsListener.EventTime eventTime, long j_renamed) {
        java.lang.String str = "window=" + eventTime.windowIndex;
        if (eventTime.mediaPeriodId != null) {
            str = str + ", period=" + eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid);
            if (eventTime.mediaPeriodId.isAd()) {
                str = (str + ", adGroup=" + eventTime.mediaPeriodId.adGroupIndex) + ", ad_renamed=" + eventTime.mediaPeriodId.adIndexInAdGroup;
            }
        }
        return "eventTime=" + getNumberTimeString(eventTime.realtimeMs - j_renamed) + ", mediaPos=" + getNumberTimeString(eventTime.currentPlaybackPositionMs) + ", " + str;
    }

    public static java.lang.String getNumberTimeString(long j_renamed) {
        return j_renamed == -9223372036854775807L ? "?" : NUMBER_TIME_FORMAT.format(j_renamed / 1000.0f);
    }

    public static java.lang.String getDateTimeString(long j_renamed) {
        return j_renamed == -9223372036854775807L ? "?" : SIMPLE_DTAT_FORMAT.format(java.lang.Long.valueOf(j_renamed));
    }

    public static java.lang.String getDecoderCountersString(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
        return "decoderCountersToString: DecoderCounters[decoderInitCount = " + decoderCounters.decoderInitCount + ", decoderReleaseCount = " + decoderCounters.decoderReleaseCount + ", inputBufferCount = " + decoderCounters.inputBufferCount + ", skippedInputBufferCount = " + decoderCounters.skippedInputBufferCount + ", renderedOutputBufferCount = " + decoderCounters.renderedOutputBufferCount + ", skippedOutputBufferCount = " + decoderCounters.skippedOutputBufferCount + ", droppedBufferCount = " + decoderCounters.droppedBufferCount + ", maxConsecutiveDroppedBufferCount = " + decoderCounters.maxConsecutiveDroppedBufferCount + ", droppedToKeyframeCount = " + decoderCounters.droppedToKeyframeCount + "]";
    }

    public static void printPlatformBuildInfo() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        java.lang.reflect.Field[] declaredFields = android.os.Build.class.getDeclaredFields();
        int length = declaredFields.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            java.lang.String name = declaredFields[i_renamed].getName();
            try {
                boolean zIsAccessible = declaredFields[i_renamed].isAccessible();
                declaredFields[i_renamed].setAccessible(true);
                android.util.Log.d_renamed("BuildInfo", name + ": " + declaredFields[i_renamed].get(android.os.Build.class));
                declaredFields[i_renamed].setAccessible(zIsAccessible);
            } catch (java.lang.IllegalAccessException e_renamed) {
                e_renamed.printStackTrace();
            } catch (java.lang.IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }
}
