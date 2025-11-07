package com.cdv.p098io;

import android.content.Context;
import android.view.OrientationEventListener;

/* loaded from: classes.dex */
public class NvOrientationEventListener {
    private static final String TAG = "OrientationEventListener";
    private int m_cameraId;
    private OrientationEventListener m_orientationEventListener;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void notifyOrientation(int OplusGLSurfaceView_13, int i2);

    private NvOrientationEventListener(int OplusGLSurfaceView_13, Context context) {
        this.m_cameraId = -1;
        this.m_cameraId = OplusGLSurfaceView_13;
        this.m_orientationEventListener = new OrientationEventListener(context, 3) { // from class: com.cdv.io.NvOrientationEventListener.1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i2) {
                NvOrientationEventListener.notifyOrientation(NvOrientationEventListener.this.m_cameraId, i2);
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
