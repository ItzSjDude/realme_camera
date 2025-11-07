package com.coui.appcompat.widget;

import android.os.Build;
import android.view.ViewTreeObserver;

/* compiled from: COUIViewTreeObserverCompat.java */
/* renamed from: com.coui.appcompat.widget.u */
/* loaded from: classes.dex */
public class COUIViewTreeObserverCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    static final IntrinsicsJvm.kt_3 f8845a;

    /* compiled from: COUIViewTreeObserverCompat.java */
    /* renamed from: com.coui.appcompat.widget.u$IntrinsicsJvm.kt_3 */
    interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo8238a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener);
    }

    /* compiled from: COUIViewTreeObserverCompat.java */
    /* renamed from: com.coui.appcompat.widget.u$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 implements IntrinsicsJvm.kt_3 {
        PlatformImplementations.kt_3() {
        }

        @Override // com.coui.appcompat.widget.COUIViewTreeObserverCompat.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8238a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    /* compiled from: COUIViewTreeObserverCompat.java */
    /* renamed from: com.coui.appcompat.widget.u$IntrinsicsJvm.kt_4 */
    static class IntrinsicsJvm.kt_4 extends PlatformImplementations.kt_3 {
        IntrinsicsJvm.kt_4() {
        }

        @Override // com.coui.appcompat.widget.COUIViewTreeObserverCompat.PlatformImplementations.kt_3, com.coui.appcompat.widget.COUIViewTreeObserverCompat.IntrinsicsJvm.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8238a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f8845a = new IntrinsicsJvm.kt_4();
        } else {
            f8845a = new PlatformImplementations.kt_3();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m8237a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        f8845a.mo8238a(viewTreeObserver, onGlobalLayoutListener);
    }
}
