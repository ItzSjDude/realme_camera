package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.p036h.ViewPropertyAnimatorListenerAdapter;
import androidx.core.p036h.ViewPropertyAnimatorCompat;
import androidx.core.p036h.ViewPropertyAnimatorListener;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* renamed from: androidx.appcompat.view.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class ViewPropertyAnimatorCompatSet {

    /* renamed from: IntrinsicsJvm.kt_4 */
    ViewPropertyAnimatorListener f1230b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Interpolator f1232d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f1233e;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private long f1231c = -1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final ViewPropertyAnimatorListenerAdapter f1234f = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.view.COUIBaseListPopupWindow_10.1

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f1236b = false;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f1237c = 0;

        @Override // androidx.core.p036h.ViewPropertyAnimatorListenerAdapter, androidx.core.p036h.ViewPropertyAnimatorListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo852a(View view) {
            if (this.f1236b) {
                return;
            }
            this.f1236b = true;
            if (ViewPropertyAnimatorCompatSet.this.f1230b != null) {
                ViewPropertyAnimatorCompatSet.this.f1230b.mo852a(null);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m1085a() {
            this.f1237c = 0;
            this.f1236b = false;
            ViewPropertyAnimatorCompatSet.this.m1083b();
        }

        @Override // androidx.core.p036h.ViewPropertyAnimatorListenerAdapter, androidx.core.p036h.ViewPropertyAnimatorListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo853b(View view) {
            int OplusGLSurfaceView_13 = this.f1237c + 1;
            this.f1237c = OplusGLSurfaceView_13;
            if (OplusGLSurfaceView_13 == ViewPropertyAnimatorCompatSet.this.f1229a.size()) {
                if (ViewPropertyAnimatorCompatSet.this.f1230b != null) {
                    ViewPropertyAnimatorCompatSet.this.f1230b.mo853b(null);
                }
                m1085a();
            }
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    final ArrayList<ViewPropertyAnimatorCompat> f1229a = new ArrayList<>();

    /* renamed from: PlatformImplementations.kt_3 */
    public ViewPropertyAnimatorCompatSet m1080a(ViewPropertyAnimatorCompat c0517z) {
        if (!this.f1233e) {
            this.f1229a.add(c0517z);
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ViewPropertyAnimatorCompatSet m1081a(ViewPropertyAnimatorCompat c0517z, ViewPropertyAnimatorCompat c0517z2) {
        this.f1229a.add(c0517z);
        c0517z2.m2952b(c0517z.m2945a());
        this.f1229a.add(c0517z2);
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1082a() {
        if (this.f1233e) {
            return;
        }
        Iterator<ViewPropertyAnimatorCompat> it = this.f1229a.iterator();
        while (it.hasNext()) {
            ViewPropertyAnimatorCompat next = it.next();
            long OplusGLSurfaceView_15 = this.f1231c;
            if (OplusGLSurfaceView_15 >= 0) {
                next.m2947a(OplusGLSurfaceView_15);
            }
            Interpolator interpolator = this.f1232d;
            if (interpolator != null) {
                next.m2948a(interpolator);
            }
            if (this.f1230b != null) {
                next.m2949a(this.f1234f);
            }
            next.m2955c();
        }
        this.f1233e = true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m1083b() {
        this.f1233e = false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m1084c() {
        if (this.f1233e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f1229a.iterator();
            while (it.hasNext()) {
                it.next().m2953b();
            }
            this.f1233e = false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ViewPropertyAnimatorCompatSet m1077a(long OplusGLSurfaceView_15) {
        if (!this.f1233e) {
            this.f1231c = OplusGLSurfaceView_15;
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ViewPropertyAnimatorCompatSet m1078a(Interpolator interpolator) {
        if (!this.f1233e) {
            this.f1232d = interpolator;
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ViewPropertyAnimatorCompatSet m1079a(ViewPropertyAnimatorListener interfaceC0487aa) {
        if (!this.f1233e) {
            this.f1230b = interfaceC0487aa;
        }
        return this;
    }
}
