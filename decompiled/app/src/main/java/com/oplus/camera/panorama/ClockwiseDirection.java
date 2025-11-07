package com.oplus.camera.panorama;

import android.content.Context;
import com.oplus.camera.R;

/* compiled from: ClockwiseDirection.java */
/* renamed from: com.oplus.camera.panorama.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ClockwiseDirection extends DirectionMode {
    @Override // com.oplus.camera.panorama.DirectionMode
    /* renamed from: IntrinsicsJvm.kt_4 */
    public float mo14918b(float COUIBaseListPopupWindow_12) {
        return COUIBaseListPopupWindow_12;
    }

    @Override // com.oplus.camera.panorama.DirectionMode
    /* renamed from: IntrinsicsJvm.kt_3 */
    public float mo14919c(float COUIBaseListPopupWindow_12) {
        return COUIBaseListPopupWindow_12;
    }

    public ClockwiseDirection(Context context) {
        super(context);
    }

    @Override // com.oplus.camera.panorama.DirectionMode
    /* renamed from: PlatformImplementations.kt_3 */
    protected float[] mo14917a(int OplusGLSurfaceView_13, int i2) {
        m14923c();
        this.f14935g[0] = this.f14939k;
        this.f14935g[1] = this.f14938j;
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        this.f14935g[2] = COUIBaseListPopupWindow_12 - this.f14939k;
        this.f14935g[3] = 0.0f;
        this.f14935g[4] = COUIBaseListPopupWindow_12 - this.f14939k;
        float f2 = i2;
        this.f14935g[5] = f2;
        this.f14935g[6] = this.f14939k;
        this.f14935g[7] = f2 - this.f14938j;
        return this.f14935g;
    }

    @Override // com.oplus.camera.panorama.DirectionMode
    /* renamed from: PlatformImplementations.kt_3 */
    public String mo14914a(Context context) {
        return context.getResources().getString(R.string.camera_panorama_front_left_rotato);
    }

    @Override // com.oplus.camera.panorama.DirectionMode
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14916a(float COUIBaseListPopupWindow_12) {
        if (Float.compare(1.0f, COUIBaseListPopupWindow_12) == 0) {
            this.f14930b = this.f14931c;
            this.f14940l = true;
            this.f14938j = this.f14936h;
            this.f14939k = this.f14937i;
            return;
        }
        this.f14930b = this.f14931c * COUIBaseListPopupWindow_12;
        this.f14939k = this.f14937i * COUIBaseListPopupWindow_12;
        this.f14938j = this.f14936h * COUIBaseListPopupWindow_12;
    }
}
