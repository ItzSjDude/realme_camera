package androidx.core.p036h;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* compiled from: PointerIconCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.s */
/* loaded from: classes.dex */
public final class PointerIconCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private Object f3073a;

    private PointerIconCompat(Object obj) {
        this.f3073a = obj;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Object m2822a() {
        return this.f3073a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static PointerIconCompat m2821a(Context context, int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new PointerIconCompat(PointerIcon.getSystemIcon(context, OplusGLSurfaceView_13));
        }
        return new PointerIconCompat(null);
    }
}
