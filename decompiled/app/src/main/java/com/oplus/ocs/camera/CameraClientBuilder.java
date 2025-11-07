package com.oplus.ocs.camera;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.oplus.ocs.base.common.api.C3652a;
import com.oplus.ocs.base.internal.C3676a;

/* loaded from: classes2.dex */
class CameraClientBuilder extends C3652a.PlatformImplementations.kt_3 {
    private static final String TAG = "CameraClientBuilder";

    CameraClientBuilder() {
    }

    @Override // com.oplus.ocs.base.common.api.C3652a.PlatformImplementations.kt_3
    public C3652a.COUIBaseListPopupWindow_8 buildClient(Context context, Looper looper, C3676a c3676a, Object obj) {
        Log.IntrinsicsJvm.kt_5(TAG, "buildClient");
        return new CameraClient(context, looper);
    }
}
