package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

/* compiled from: AppCompatPopupWindow.java */
/* renamed from: androidx.appcompat.widget.o */
/* loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final boolean f1975a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f1976b;

    static {
        f1975a = Build.VERSION.SDK_INT < 21;
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) throws IllegalAccessException, IllegalArgumentException {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        m1690a(context, attributeSet, OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1690a(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) throws IllegalAccessException, IllegalArgumentException {
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(context, attributeSet, R.styleable.PopupWindow, OplusGLSurfaceView_13, i2);
        if (c0322arM1541a.m1561g(R.styleable.PopupWindow_overlapAnchor)) {
            m1691a(c0322arM1541a.m1547a(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(c0322arM1541a.m1546a(R.styleable.PopupWindow_android_popupBackground));
        c0322arM1541a.m1551b();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int OplusGLSurfaceView_13, int i2) {
        if (f1975a && this.f1976b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, OplusGLSurfaceView_13, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int OplusGLSurfaceView_13, int i2, int i3) {
        if (f1975a && this.f1976b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, OplusGLSurfaceView_13, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (f1975a && this.f1976b) {
            i2 -= view.getHeight();
        }
        super.update(view, OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1691a(boolean z) throws IllegalAccessException, IllegalArgumentException {
        if (f1975a) {
            this.f1976b = z;
        } else {
            PopupWindowCompat.m3042a(this, z);
        }
    }
}
