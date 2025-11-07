package com.oplus.ocs.camera;

import android.content.Context;
import android.os.Looper;
import com.oplus.ocs.base.common.api.AbstractC3653b;

/* loaded from: classes2.dex */
class CameraClient extends AbstractC3653b {
    @Override // com.oplus.ocs.base.common.api.AbstractC3653b
    public String getClientName() {
        return "CAMERA_CLIENT";
    }

    protected CameraClient(Context context, Looper looper) {
        super(context, looper);
    }
}
