package com.coui.appcompat.widget;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* compiled from: COUIViewCompat.java */
/* renamed from: com.coui.appcompat.widget.t */
/* loaded from: classes.dex */
public class COUIViewCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    static final IntrinsicsJvm.kt_5 f8749a;

    /* compiled from: COUIViewCompat.java */
    /* renamed from: com.coui.appcompat.widget.t$IntrinsicsJvm.kt_5 */
    interface IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        int mo8187a(View view);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo8188a(View view, int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        int mo8189b(View view);

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean mo8190c(View view);
    }

    /* compiled from: COUIViewCompat.java */
    /* renamed from: com.coui.appcompat.widget.t$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 implements IntrinsicsJvm.kt_5 {
        @Override // com.coui.appcompat.widget.COUIViewCompat.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8187a(View view) {
            return 0;
        }

        @Override // com.coui.appcompat.widget.COUIViewCompat.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8188a(View view, int OplusGLSurfaceView_13) {
        }

        @Override // com.coui.appcompat.widget.COUIViewCompat.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo8190c(View view) {
            return true;
        }

        PlatformImplementations.kt_3() {
        }

        @Override // com.coui.appcompat.widget.COUIViewCompat.IntrinsicsJvm.kt_5
        @SuppressLint({"NewApi"})
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo8189b(View view) {
            return view.getLayoutDirection();
        }
    }

    /* compiled from: COUIViewCompat.java */
    /* renamed from: com.coui.appcompat.widget.t$IntrinsicsJvm.kt_4 */
    static class IntrinsicsJvm.kt_4 extends PlatformImplementations.kt_3 {
        @Override // com.coui.appcompat.widget.COUIViewCompat.PlatformImplementations.kt_3, com.coui.appcompat.widget.COUIViewCompat.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo8190c(View view) {
            return true;
        }

        IntrinsicsJvm.kt_4() {
        }

        @Override // com.coui.appcompat.widget.COUIViewCompat.PlatformImplementations.kt_3, com.coui.appcompat.widget.COUIViewCompat.IntrinsicsJvm.kt_5
        @SuppressLint({"NewApi"})
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo8187a(View view) {
            return view.getTextAlignment();
        }

        @Override // com.coui.appcompat.widget.COUIViewCompat.PlatformImplementations.kt_3, com.coui.appcompat.widget.COUIViewCompat.IntrinsicsJvm.kt_5
        @SuppressLint({"NewApi"})
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8188a(View view, int OplusGLSurfaceView_13) {
            view.setTextAlignment(OplusGLSurfaceView_13);
        }
    }

    /* compiled from: COUIViewCompat.java */
    /* renamed from: com.coui.appcompat.widget.t$IntrinsicsJvm.kt_3 */
    static class IntrinsicsJvm.kt_3 extends IntrinsicsJvm.kt_4 {
        @Override // com.coui.appcompat.widget.COUIViewCompat.PlatformImplementations.kt_3, com.coui.appcompat.widget.COUIViewCompat.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_4 */
        public int mo8189b(View view) {
            return 2;
        }

        IntrinsicsJvm.kt_3() {
        }
    }

    static {
        int OplusGLSurfaceView_13 = Build.VERSION.SDK_INT;
        if (OplusGLSurfaceView_13 >= 17) {
            f8749a = new IntrinsicsJvm.kt_3();
        } else if (OplusGLSurfaceView_13 >= 16) {
            f8749a = new IntrinsicsJvm.kt_4();
        } else {
            f8749a = new PlatformImplementations.kt_3();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m8183a(View view) {
        return f8749a.mo8187a(view);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m8184a(View view, int OplusGLSurfaceView_13) {
        f8749a.mo8188a(view, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m8185b(View view) {
        return f8749a.mo8189b(view);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m8186c(View view) {
        return f8749a.mo8190c(view);
    }
}
