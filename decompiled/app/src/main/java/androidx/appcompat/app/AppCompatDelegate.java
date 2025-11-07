package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.ArraySet;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: AppCompatDelegate.java */
/* renamed from: androidx.appcompat.app.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public abstract class AppCompatDelegate {

    /* renamed from: PlatformImplementations.kt_3 */
    private static int f1010a = -100;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final ArraySet<WeakReference<AppCompatDelegate>> f1011b = new ArraySet<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final Object f1012c = new Object();

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract ActionBar mo798a();

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo800a(int OplusGLSurfaceView_13) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo802a(Context context) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo803a(Configuration configuration);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo804a(Bundle bundle);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo805a(View view);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo806a(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo810a(Toolbar toolbar);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo811a(CharSequence charSequence);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract MenuInflater mo814b();

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract <T extends View> T mo815b(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract void mo817b(Bundle bundle);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract void mo818b(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract void mo820c();

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract void mo821c(int OplusGLSurfaceView_13);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract void mo822c(Bundle bundle);

    /* renamed from: IntrinsicsJvm.kt_5 */
    public abstract void mo824d();

    /* renamed from: IntrinsicsJvm.kt_5 */
    public abstract boolean mo825d(int OplusGLSurfaceView_13);

    /* renamed from: COUIBaseListPopupWindow_8 */
    public abstract void mo826e();

    /* renamed from: COUIBaseListPopupWindow_12 */
    public abstract void mo828f();

    /* renamed from: COUIBaseListPopupWindow_11 */
    public abstract void mo830g();

    /* renamed from: COUIBaseListPopupWindow_10 */
    public abstract void mo832h();

    /* renamed from: OplusGLSurfaceView_13 */
    public int mo834i() {
        return -100;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static AppCompatDelegate m919a(Activity activity, AppCompatCallback interfaceC0206d) {
        return new AppCompatDelegateImpl(activity, interfaceC0206d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static AppCompatDelegate m920a(Dialog dialog, AppCompatCallback interfaceC0206d) {
        return new AppCompatDelegateImpl(dialog, interfaceC0206d);
    }

    AppCompatDelegate() {
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public static int m924j() {
        return f1010a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m921a(AppCompatDelegate abstractC0207e) {
        synchronized (f1012c) {
            m923c(abstractC0207e);
            f1011b.add(new WeakReference<>(abstractC0207e));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static void m922b(AppCompatDelegate abstractC0207e) {
        synchronized (f1012c) {
            m923c(abstractC0207e);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static void m923c(AppCompatDelegate abstractC0207e) {
        synchronized (f1012c) {
            Iterator<WeakReference<AppCompatDelegate>> it = f1011b.iterator();
            while (it.hasNext()) {
                AppCompatDelegate abstractC0207e2 = it.next().get();
                if (abstractC0207e2 == abstractC0207e || abstractC0207e2 == null) {
                    it.remove();
                }
            }
        }
    }
}
