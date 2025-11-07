package com.oplus.camera.statistics;

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
    private static final java.lang.String TAG = "Quality";
    private static java.lang.reflect.Method mMethodLogP;
    private com.oplus.camera.statistics.QualityReport.Status mStatus;
    private long mTs;
    private java.lang.String mModeName = null;
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
        this.mStatus = com.oplus.camera.statistics.QualityReport.Status.idle;
        this.mTs = 0L;
        this.mStatus = com.oplus.camera.statistics.QualityReport.Status.start;
        this.mTs = java.lang.System.currentTimeMillis();
    }

    public static void report(int i_renamed, java.lang.Object... objArr) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(i_renamed);
        sb.append(":");
        for (java.lang.Object obj : objArr) {
            sb.append(" ");
            sb.append(obj);
        }
        logP(sb.toString());
    }

    private static void logP(java.lang.String str) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (mMethodLogP == null) {
            try {
                mMethodLogP = android.util.Log.class.getDeclaredMethod(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P, java.lang.String.class, java.lang.String.class);
                mMethodLogP.setAccessible(true);
            } catch (java.lang.NoSuchMethodException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        java.lang.reflect.Method method = mMethodLogP;
        if (method != null) {
            try {
                method.invoke(null, TAG, str);
            } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onSwitchMode(java.lang.String str) {
        this.mTs = java.lang.System.currentTimeMillis();
        this.mModeName = str;
        this.mStatus = com.oplus.camera.statistics.QualityReport.Status.switchMode;
    }

    public void onSwitchCamera(boolean z_renamed) {
        this.mTs = java.lang.System.currentTimeMillis();
        this.mbFront = z_renamed;
        this.mStatus = com.oplus.camera.statistics.QualityReport.Status.switchCamera;
    }

    public void onFirstFrame(android.hardware.camera2.CaptureResult captureResult) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        android.util.Range<java.lang.Integer> range = captureResult != null ? (android.util.Range) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_TARGET_FPS_RANGE) : null;
        int i_renamed = com.oplus.camera.statistics.QualityReport.SceneLoader_2.$SwitchMap$com$oplus$camera$statistics$QualityReport$Status[this.mStatus.ordinal()];
        if (i_renamed == 1) {
            report(EVENT_ID_START, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - this.mTs));
            preview(range);
        } else if (i_renamed == 2) {
            report(EVENT_ID_SWITCH_MODE, this.mModeName, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - this.mTs));
            preview(range);
        } else {
            if (i_renamed != 3) {
                return;
            }
            report(EVENT_ID_SWITCH_CAMERA, java.lang.Boolean.valueOf(this.mbFront), java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - this.mTs));
            preview(range);
        }
    }

    /* renamed from: com.oplus.camera.statistics.QualityReport$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {
        static final /* synthetic */ int[] $SwitchMap$com$oplus$camera$statistics$QualityReport$Status = new int[com.oplus.camera.statistics.QualityReport.Status.values().length];

        static {
            try {
                $SwitchMap$com$oplus$camera$statistics$QualityReport$Status[com.oplus.camera.statistics.QualityReport.Status.start.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$oplus$camera$statistics$QualityReport$Status[com.oplus.camera.statistics.QualityReport.Status.switchMode.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$oplus$camera$statistics$QualityReport$Status[com.oplus.camera.statistics.QualityReport.Status.switchCamera.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    private void preview(android.util.Range<java.lang.Integer> range) {
        this.mTs = java.lang.System.currentTimeMillis();
        if (range != null) {
            this.mFpsLower = ((java.lang.Integer) range.getLower()).intValue();
        } else {
            this.mFpsLower = 15;
        }
        this.mStatus = com.oplus.camera.statistics.QualityReport.Status.preview;
    }

    public void onPreview() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (com.oplus.camera.statistics.QualityReport.Status.preview == this.mStatus) {
            if (1000.0f / this.mFpsLower < java.lang.System.currentTimeMillis() - this.mTs) {
                this.mPreviewStuckCount++;
            } else {
                this.mPreviewStuckCount = 0;
            }
            if (this.mPreviewStuckCount > PREVIEW_STUCK_FRAME) {
                report(EVENT_ID_PREVIEW_STUCK, new java.lang.Object[0]);
            }
            this.mTs = java.lang.System.currentTimeMillis();
        }
    }
}
