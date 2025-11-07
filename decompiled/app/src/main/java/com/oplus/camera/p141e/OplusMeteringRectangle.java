package com.oplus.camera.p141e;

import android.graphics.Rect;
import android.hardware.camera2.params.MeteringRectangle;
import com.oplus.camera.util.Util;

/* compiled from: OplusMeteringRectangle.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public final class OplusMeteringRectangle {

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f13538a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f13539b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f13540c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f13541d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f13542e;

    public OplusMeteringRectangle(MeteringRectangle meteringRectangle) {
        this.f13538a = meteringRectangle.getX();
        this.f13539b = meteringRectangle.getY();
        this.f13540c = meteringRectangle.getWidth();
        this.f13541d = meteringRectangle.getHeight();
        this.f13542e = meteringRectangle.getMeteringWeight();
    }

    public OplusMeteringRectangle(Rect rect, int OplusGLSurfaceView_13) {
        this.f13538a = rect.left;
        this.f13539b = rect.top;
        this.f13540c = rect.width();
        this.f13541d = rect.height();
        this.f13542e = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int[] m13292a() {
        int OplusGLSurfaceView_13 = this.f13538a;
        int i2 = this.f13539b;
        return new int[]{OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13 + this.f13540c, i2 + this.f13541d, this.f13542e};
    }

    public int hashCode() {
        return Util.m24408c(this.f13538a, this.f13539b, this.f13540c, this.f13541d, this.f13542e);
    }

    public String toString() {
        return String.format("(x:%IntrinsicsJvm.kt_5, y:%IntrinsicsJvm.kt_5, w:%IntrinsicsJvm.kt_5, COUIBaseListPopupWindow_10:%IntrinsicsJvm.kt_5, wt:%IntrinsicsJvm.kt_5)", Integer.valueOf(this.f13538a), Integer.valueOf(this.f13539b), Integer.valueOf(this.f13540c), Integer.valueOf(this.f13541d), Integer.valueOf(this.f13542e));
    }
}
