package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ActionMode.java */
/* renamed from: androidx.appcompat.view.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public abstract class ActionMode {

    /* renamed from: PlatformImplementations.kt_3 */
    private Object f1168a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f1169b;

    /* compiled from: ActionMode.java */
    /* renamed from: androidx.appcompat.view.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo863a(ActionMode abstractC0221b);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo864a(ActionMode abstractC0221b, Menu menu);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo865a(ActionMode abstractC0221b, MenuItem menuItem);

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo866b(ActionMode abstractC0221b, Menu menu);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract MenuInflater mo965a();

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo966a(int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo967a(View view);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo968a(CharSequence charSequence);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract Menu mo970b();

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract void mo971b(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract void mo972b(CharSequence charSequence);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract void mo973c();

    /* renamed from: IntrinsicsJvm.kt_5 */
    public abstract void mo974d();

    /* renamed from: COUIBaseListPopupWindow_12 */
    public abstract CharSequence mo976f();

    /* renamed from: COUIBaseListPopupWindow_11 */
    public abstract CharSequence mo977g();

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo978h() {
        return false;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public abstract View mo979i();

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1055a(Object obj) {
        this.f1168a = obj;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public Object m1056j() {
        return this.f1168a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo969a(boolean z) {
        this.f1169b = z;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m1057k() {
        return this.f1169b;
    }
}
