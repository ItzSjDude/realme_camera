package com.oplus.camera.statistics;

import android.hardware.camera2.CaptureResult;
import android.util.Log;
import android.util.Range;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class QualityReport {
    public static final int EVENT_ID_CAPTURE_THUMBNAIL_STUCK = 14006201;
    public static final int EVENT_ID_CAPTURE_TOTAL_STUCK = 14005201;
    public static final int EVENT_ID_PREVIEW_STUCK = 14004201;
    public static final int EVENT_ID_START = 14001201;
    public static final int EVENT_ID_SWITCH_CAMERA = 14002201;
    public static final int EVENT_ID_SWITCH_MODE = 14003201;
    private static final int FPS_LOWER = 15;
    private static final int MS_IN_SECOND = 1000;
    private static final float PREVIEW_STUCK_FRAME = 15.0f;
    private static final String TAG = "Quality";
    private static Method mMethodLogP;
    private Status mStatus;
    private long mTs;
    private String mModeName = null;
    private boolean mbFront = false;
    private int mPreviewStuckCount = 0;
    private int mFpsLower = 0;

    public enum Status {
        idle,
        start,
        switchMode,
        switchCamera,
        preview
    }

    public QualityReport() {
        this.mStatus = Status.idle;
        this.mTs = 0L;
        this.mStatus = Status.start;
        this.mTs = System.currentTimeMillis();
    }

    public static void report(int OplusGLSurfaceView_13, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        StringBuilder sb = new StringBuilder();
        sb.append(OplusGLSurfaceView_13);
        sb.append(":");
        for (Object obj : objArr) {
            sb.append(" ");
            sb.append(obj);
        }
        logP(sb.toString());
    }

    private static void logP(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (mMethodLogP == null) {
            try {
                mMethodLogP = Log.class.getDeclaredMethod(TtmlNode.TAG_P, String.class, String.class);
                mMethodLogP.setAccessible(true);
            } catch (NoSuchMethodException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        Method method = mMethodLogP;
        if (method != null) {
            try {
                method.invoke(null, TAG, str);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onSwitchMode(String str) {
        this.mTs = System.currentTimeMillis();
        this.mModeName = str;
        this.mStatus = Status.switchMode;
    }

    public void onSwitchCamera(boolean z) {
        this.mTs = System.currentTimeMillis();
        this.mbFront = z;
        this.mStatus = Status.switchCamera;
    }

    public void onFirstFrame(CaptureResult captureResult) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Range<Integer> range = captureResult != null ? (Range) captureResult.get(CaptureResult.CONTROL_AE_TARGET_FPS_RANGE) : null;
        int OplusGLSurfaceView_13 = C29681.f16170x6dd8d1e3[this.mStatus.ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            report(EVENT_ID_START, Long.valueOf(System.currentTimeMillis() - this.mTs));
            preview(range);
        } else if (OplusGLSurfaceView_13 == 2) {
            report(EVENT_ID_SWITCH_MODE, this.mModeName, Long.valueOf(System.currentTimeMillis() - this.mTs));
            preview(range);
        } else {
            if (OplusGLSurfaceView_13 != 3) {
                return;
            }
            report(EVENT_ID_SWITCH_CAMERA, Boolean.valueOf(this.mbFront), Long.valueOf(System.currentTimeMillis() - this.mTs));
            preview(range);
        }
    }

    /* renamed from: com.oplus.camera.statistics.QualityReport$1 */
    static /* synthetic */ class C29681 {

        /* renamed from: $SwitchMap$com$oplus$camera$statistics$QualityReport$Status */
        static final /* synthetic */ int[] f16170x6dd8d1e3 = new int[Status.values().length];

        static {
            try {
                f16170x6dd8d1e3[Status.start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16170x6dd8d1e3[Status.switchMode.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16170x6dd8d1e3[Status.switchCamera.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void preview(Range<Integer> range) {
        this.mTs = System.currentTimeMillis();
        if (range != null) {
            this.mFpsLower = ((Integer) range.getLower()).intValue();
        } else {
            this.mFpsLower = 15;
        }
        this.mStatus = Status.preview;
    }

    public void onPreview() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Status.preview == this.mStatus) {
            if (1000.0f / this.mFpsLower < System.currentTimeMillis() - this.mTs) {
                this.mPreviewStuckCount++;
            } else {
                this.mPreviewStuckCount = 0;
            }
            if (this.mPreviewStuckCount > PREVIEW_STUCK_FRAME) {
                report(EVENT_ID_PREVIEW_STUCK, new Object[0]);
            }
            this.mTs = System.currentTimeMillis();
        }
    }
}
