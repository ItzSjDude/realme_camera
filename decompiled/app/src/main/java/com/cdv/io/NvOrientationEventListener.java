package com.cdv.io;

/* loaded from: classes.dex */
public class NvOrientationEventListener {
    private static final java.lang.String TAG = "OrientationEventListener";
    private int m_cameraId;
    private android.view.OrientationEventListener m_orientationEventListener;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void notifyOrientation(int i_renamed, int i2);

    private NvOrientationEventListener(int i_renamed, android.content.Context context) {
        this.m_cameraId = -1;
        this.m_cameraId = i_renamed;
        this.m_orientationEventListener = new android.view.OrientationEventListener(context, 3) { // from class: com.cdv.io.NvOrientationEventListener.1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i2) {
                com.cdv.io.NvOrientationEventListener.notifyOrientation(com.cdv.io.NvOrientationEventListener.this.m_cameraId, i2);
            }
        };
    }

    public void enableListener() {
        if (this.m_orientationEventListener.canDetectOrientation()) {
            this.m_orientationEventListener.enable();
        }
    }

    public void disableListener() {
        if (this.m_orientationEventListener.canDetectOrientation()) {
            this.m_orientationEventListener.disable();
        }
    }
}
