package androidx.core.p036h;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.p */
/* loaded from: classes.dex */
public class NestedScrollingParentHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f3068a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f3069b;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2817a(View view, View view2, int OplusGLSurfaceView_13) {
        m2818a(view, view2, OplusGLSurfaceView_13, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2818a(View view, View view2, int OplusGLSurfaceView_13, int i2) {
        if (i2 == 1) {
            this.f3069b = OplusGLSurfaceView_13;
        } else {
            this.f3068a = OplusGLSurfaceView_13;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m2815a() {
        return this.f3069b | this.f3068a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2816a(View view, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1) {
            this.f3069b = 0;
        } else {
            this.f3068a = 0;
        }
    }
}
