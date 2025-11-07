package com.oplus.ocs.camera;

import android.content.Context;

/* loaded from: classes2.dex */
public final class CameraUnit {
    public static CameraUnitClient getCameraClient(Context context) {
        return CameraUnitClient.initialize(context);
    }
}
