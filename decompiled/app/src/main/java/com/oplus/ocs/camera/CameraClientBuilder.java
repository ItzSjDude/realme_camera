package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
class CameraClientBuilder extends com.oplus.ocs.base.common.api.a_renamed.AbstractC0143a {
    private static final java.lang.String TAG = "CameraClientBuilder";

    CameraClientBuilder() {
    }

    @Override // com.oplus.ocs.base.common.api.a_renamed.AbstractC0143a
    public com.oplus.ocs.base.common.api.a_renamed.e_renamed buildClient(android.content.Context context, android.os.Looper looper, com.oplus.ocs.base.internal.a_renamed aVar, java.lang.Object obj) {
        android.util.Log.d_renamed(TAG, "buildClient");
        return new com.oplus.ocs.camera.CameraClient(context, looper);
    }
}
