package com.oplus.tblplayer.utils;

import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.oplus.tblplayer.config.Globals;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes2.dex */
public class LogUtil {
    private static final NumberFormat NUMBER_TIME_FORMAT;
    private static final String PREFIX_TAG = "TBLPlayer-";
    private static final SimpleDateFormat SIMPLE_DTAT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");

    public static String getDiscontinuityReasonString(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 0 ? OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? OplusGLSurfaceView_13 != 3 ? OplusGLSurfaceView_13 != 4 ? "?" : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION";
    }

    public static String getExtractorTypeString(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 0 ? OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? "?" : "Ffmpeg Extractor" : "Exo Extractor" : "All Extractor";
    }

    public static String getNetworkTypeString(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 2 ? OplusGLSurfaceView_13 != 5 ? "?" : "4G" : "Wifi";
    }

    public static String getRendererTypeString(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 0 ? OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? "?" : "Ffmpeg Codec" : "Media Codec" : "Auto Codec";
    }

    public static String getStateString(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? OplusGLSurfaceView_13 != 3 ? OplusGLSurfaceView_13 != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE";
    }

    public static String getTrackTypeString(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? OplusGLSurfaceView_13 != 3 ? "?" : "Text" : "Video" : "Audio";
    }

    static {
        SIMPLE_DTAT_FORMAT.setTimeZone(Calendar.getInstance().getTimeZone());
        NUMBER_TIME_FORMAT = NumberFormat.getInstance(Locale.US);
        NUMBER_TIME_FORMAT.setMinimumFractionDigits(2);
        NUMBER_TIME_FORMAT.setMaximumFractionDigits(2);
        NUMBER_TIME_FORMAT.setGroupingUsed(false);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m25450d(String str, String str2) {
        if (Globals.DEBUG) {
            Log.IntrinsicsJvm.kt_5("TBLPlayer-" + str, String.format("[%IntrinsicsJvm.kt_5][%IntrinsicsJvm.kt_5] %s", Integer.valueOf(getProcessPid()), Integer.valueOf(getProcessTid()), str2));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m25451d(String str, String str2, Throwable th) {
        if (Globals.DEBUG) {
            Log.IntrinsicsJvm.kt_5("TBLPlayer-" + str, str2, th);
        }
    }

    public static void dfmt(String str, String str2, Object... objArr) {
        if (Globals.DEBUG) {
            Log.IntrinsicsJvm.kt_5("TBLPlayer-" + str, String.format(str2, objArr));
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static void m25454i(String str, String str2) {
        Log.OplusGLSurfaceView_13("TBLPlayer-" + str, str2);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static void m25455i(String str, String str2, Throwable th) {
        Log.OplusGLSurfaceView_13("TBLPlayer-" + str, str2, th);
    }

    /* renamed from: w */
    public static void m25456w(String str, String str2) {
        Log.w("TBLPlayer-" + str, str2);
    }

    /* renamed from: w */
    public static void m25457w(String str, String str2, Throwable th) {
        Log.w("TBLPlayer-" + str, str2, th);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m25452e(String str, String str2) {
        Log.COUIBaseListPopupWindow_8("TBLPlayer-" + str, str2);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m25453e(String str, String str2, Throwable th) {
        Log.COUIBaseListPopupWindow_8("TBLPlayer-" + str, str2, th);
    }

    public static int getProcessPid() {
        return Process.myPid();
    }

    public static int getProcessTid() {
        return Process.myTid();
    }

    public static int getProcessUid() {
        return Process.myUid();
    }

    public static String getEventTimeString(AnalyticsListener.EventTime eventTime, long OplusGLSurfaceView_15) {
        String str = "window=" + eventTime.windowIndex;
        if (eventTime.mediaPeriodId != null) {
            str = str + ", period=" + eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid);
            if (eventTime.mediaPeriodId.isAd()) {
                str = (str + ", adGroup=" + eventTime.mediaPeriodId.adGroupIndex) + ", ad=" + eventTime.mediaPeriodId.adIndexInAdGroup;
            }
        }
        return "eventTime=" + getNumberTimeString(eventTime.realtimeMs - OplusGLSurfaceView_15) + ", mediaPos=" + getNumberTimeString(eventTime.currentPlaybackPositionMs) + ", " + str;
    }

    public static String getNumberTimeString(long OplusGLSurfaceView_15) {
        return OplusGLSurfaceView_15 == -9223372036854775807L ? "?" : NUMBER_TIME_FORMAT.format(OplusGLSurfaceView_15 / 1000.0f);
    }

    public static String getDateTimeString(long OplusGLSurfaceView_15) {
        return OplusGLSurfaceView_15 == -9223372036854775807L ? "?" : SIMPLE_DTAT_FORMAT.format(Long.valueOf(OplusGLSurfaceView_15));
    }

    public static String getDecoderCountersString(DecoderCounters decoderCounters) {
        return "decoderCountersToString: DecoderCounters[decoderInitCount = " + decoderCounters.decoderInitCount + ", decoderReleaseCount = " + decoderCounters.decoderReleaseCount + ", inputBufferCount = " + decoderCounters.inputBufferCount + ", skippedInputBufferCount = " + decoderCounters.skippedInputBufferCount + ", renderedOutputBufferCount = " + decoderCounters.renderedOutputBufferCount + ", skippedOutputBufferCount = " + decoderCounters.skippedOutputBufferCount + ", droppedBufferCount = " + decoderCounters.droppedBufferCount + ", maxConsecutiveDroppedBufferCount = " + decoderCounters.maxConsecutiveDroppedBufferCount + ", droppedToKeyframeCount = " + decoderCounters.droppedToKeyframeCount + "]";
    }

    public static void printPlatformBuildInfo() throws IllegalAccessException, IllegalArgumentException {
        Field[] declaredFields = Build.class.getDeclaredFields();
        int length = declaredFields.length;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            String name = declaredFields[OplusGLSurfaceView_13].getName();
            try {
                boolean zIsAccessible = declaredFields[OplusGLSurfaceView_13].isAccessible();
                declaredFields[OplusGLSurfaceView_13].setAccessible(true);
                Log.IntrinsicsJvm.kt_5("BuildInfo", name + ": " + declaredFields[OplusGLSurfaceView_13].get(Build.class));
                declaredFields[OplusGLSurfaceView_13].setAccessible(zIsAccessible);
            } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }
}
