package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;

/* compiled from: ActionBar.java */
/* renamed from: androidx.appcompat.app.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class ActionBar {

    /* compiled from: ActionBar.java */
    /* renamed from: androidx.appcompat.app.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void m894a(boolean z);
    }

    /* compiled from: ActionBar.java */
    @Deprecated
    /* renamed from: androidx.appcompat.app.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public static abstract class IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        public abstract Drawable m895a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        public abstract CharSequence m896b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        public abstract View m897c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        public abstract void m898d();

        /* renamed from: COUIBaseListPopupWindow_8 */
        public abstract CharSequence m899e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract int mo875a();

    /* renamed from: PlatformImplementations.kt_3 */
    public ActionMode mo876a(ActionMode.PlatformImplementations.kt_3 aVar) {
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo878a(Configuration configuration) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo879a(CharSequence charSequence) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo880a(boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo881a(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo882a(KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Context mo883b() {
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo884b(boolean z) {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo886c() {
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo887d(boolean z) {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo888d() {
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo889e(boolean z) {
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo890e() {
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo891f(boolean z) {
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean mo892f() {
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    void mo893g() {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo885c(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo877a(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 != 0.0f) {
            throw new UnsupportedOperationException("Setting PlatformImplementations.kt_3 non-zero elevation is not supported in this action bar configuration.");
        }
    }

    /* compiled from: ActionBar.java */
    /* renamed from: androidx.appcompat.app.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 extends ViewGroup.MarginLayoutParams {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f1005a;

        public PlatformImplementations.kt_3(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1005a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f1005a = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
            this.f1005a = 0;
            this.f1005a = 8388627;
        }

        public PlatformImplementations.kt_3(PlatformImplementations.kt_3 aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.f1005a = 0;
            this.f1005a = aVar.f1005a;
        }

        public PlatformImplementations.kt_3(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1005a = 0;
        }
    }
}
