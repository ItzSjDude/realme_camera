package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.p036h.GravityCompat;
import androidx.core.p036h.ViewCompat;

/* compiled from: MenuPopupHelper.java */
/* renamed from: androidx.appcompat.view.menu.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public class MenuPopupHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f1410a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final MenuBuilder f1411b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final boolean f1412c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f1413d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f1414e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private View f1415f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f1416g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f1417h;

    /* renamed from: OplusGLSurfaceView_13 */
    private MenuPresenter.PlatformImplementations.kt_3 f1418i;

    /* renamed from: OplusGLSurfaceView_15 */
    private MenuPopup f1419j;

    /* renamed from: OplusGLSurfaceView_5 */
    private PopupWindow.OnDismissListener f1420k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final PopupWindow.OnDismissListener f1421l;

    public MenuPopupHelper(Context context, MenuBuilder c0236h, View view, boolean z, int OplusGLSurfaceView_13) {
        this(context, c0236h, view, z, OplusGLSurfaceView_13, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder c0236h, View view, boolean z, int OplusGLSurfaceView_13, int i2) {
        this.f1416g = 8388611;
        this.f1421l = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.OplusGLSurfaceView_6.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MenuPopupHelper.this.mo1212e();
            }
        };
        this.f1410a = context;
        this.f1411b = c0236h;
        this.f1415f = view;
        this.f1412c = z;
        this.f1413d = OplusGLSurfaceView_13;
        this.f1414e = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1205a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1420k = onDismissListener;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1204a(View view) {
        this.f1415f = view;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1207a(boolean z) {
        this.f1417h = z;
        MenuPopup abstractC0240l = this.f1419j;
        if (abstractC0240l != null) {
            abstractC0240l.mo1135a(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1203a(int OplusGLSurfaceView_13) {
        this.f1416g = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1202a() {
        if (!m1210c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public MenuPopup m1209b() {
        if (this.f1419j == null) {
            this.f1419j = m1201g();
        }
        return this.f1419j;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m1210c() {
        if (m1213f()) {
            return true;
        }
        if (this.f1415f == null) {
            return false;
        }
        m1200a(0, 0, false, false);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m1208a(int OplusGLSurfaceView_13, int i2) {
        if (m1213f()) {
            return true;
        }
        if (this.f1415f == null) {
            return false;
        }
        m1200a(OplusGLSurfaceView_13, i2, true, true);
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private MenuPopup m1201g() {
        MenuPopup viewOnKeyListenerC0246r;
        Display defaultDisplay = ((WindowManager) this.f1410a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.f1410a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
            viewOnKeyListenerC0246r = new CascadingMenuPopup(this.f1410a, this.f1415f, this.f1413d, this.f1414e, this.f1412c);
        } else {
            viewOnKeyListenerC0246r = new StandardMenuPopup(this.f1410a, this.f1411b, this.f1415f, this.f1413d, this.f1414e, this.f1412c);
        }
        viewOnKeyListenerC0246r.mo1134a(this.f1411b);
        viewOnKeyListenerC0246r.mo1133a(this.f1421l);
        viewOnKeyListenerC0246r.mo1132a(this.f1415f);
        viewOnKeyListenerC0246r.setCallback(this.f1418i);
        viewOnKeyListenerC0246r.mo1135a(this.f1417h);
        viewOnKeyListenerC0246r.mo1131a(this.f1416g);
        return viewOnKeyListenerC0246r;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1200a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2) {
        MenuPopup abstractC0240lM1209b = m1209b();
        abstractC0240lM1209b.mo1139b(z2);
        if (z) {
            if ((GravityCompat.m2773a(this.f1416g, ViewCompat.m2885g(this.f1415f)) & 7) == 5) {
                OplusGLSurfaceView_13 -= this.f1415f.getWidth();
            }
            abstractC0240lM1209b.mo1138b(OplusGLSurfaceView_13);
            abstractC0240lM1209b.mo1141c(i2);
            int i3 = (int) ((this.f1410a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            abstractC0240lM1209b.m1198a(new Rect(OplusGLSurfaceView_13 - i3, i2 - i3, OplusGLSurfaceView_13 + i3, i2 + i3));
        }
        abstractC0240lM1209b.mo1136a_();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m1211d() {
        if (m1213f()) {
            this.f1419j.mo1137b();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void mo1212e() {
        this.f1419j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1420k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m1213f() {
        MenuPopup abstractC0240l = this.f1419j;
        return abstractC0240l != null && abstractC0240l.mo1142c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1206a(MenuPresenter.PlatformImplementations.kt_3 aVar) {
        this.f1418i = aVar;
        MenuPopup abstractC0240l = this.f1419j;
        if (abstractC0240l != null) {
            abstractC0240l.setCallback(aVar);
        }
    }
}
