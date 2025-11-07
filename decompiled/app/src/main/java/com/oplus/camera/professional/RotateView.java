package com.oplus.camera.professional;

import android.content.Context;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;

/* compiled from: RotateView.java */
/* renamed from: com.oplus.camera.professional.y */
/* loaded from: classes2.dex */
public class RotateView extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean f15814a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected int f15815b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Context f15816c;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16139a(int OplusGLSurfaceView_13, boolean z) {
    }

    public RotateView(Context context, int OplusGLSurfaceView_13) {
        super(context);
        this.f15814a = true;
        this.f15815b = -1;
        this.f15816c = context;
        this.f15815b = OplusGLSurfaceView_13;
        CameraLog.m12967f("RotateView", "RotateView mOrientation is " + this.f15815b);
        m16139a(this.f15815b, false);
    }

    @Override // android.view.View
    public Object getTag(int OplusGLSurfaceView_13) {
        Object tag;
        return (getChildCount() <= 0 || (tag = getChildAt(0).getTag(OplusGLSurfaceView_13)) == null) ? super.getTag(OplusGLSurfaceView_13) : tag;
    }

    public void setRotateViewClickable(boolean z) {
        this.f15814a = z;
    }
}
