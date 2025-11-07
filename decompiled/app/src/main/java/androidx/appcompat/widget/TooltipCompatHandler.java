package androidx.appcompat.widget;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.ViewConfigurationCompat;

/* compiled from: TooltipCompatHandler.java */
/* renamed from: androidx.appcompat.widget.au */
/* loaded from: classes.dex */
class TooltipCompatHandler implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {

    /* renamed from: OplusGLSurfaceView_15 */
    private static TooltipCompatHandler f1899j;

    /* renamed from: OplusGLSurfaceView_5 */
    private static TooltipCompatHandler f1900k;

    /* renamed from: PlatformImplementations.kt_3 */
    private final View f1901a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final CharSequence f1902b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f1903c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Runnable f1904d = new Runnable() { // from class: androidx.appcompat.widget.au.1
        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            TooltipCompatHandler.this.m1613a(false);
        }
    };

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Runnable f1905e = new Runnable() { // from class: androidx.appcompat.widget.au.2
        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.m1612a();
        }
    };

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f1906f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f1907g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private TooltipPopup f1908h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f1909i;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m1606a(View view, CharSequence charSequence) {
        TooltipCompatHandler viewOnAttachStateChangeListenerC0325au = f1899j;
        if (viewOnAttachStateChangeListenerC0325au != null && viewOnAttachStateChangeListenerC0325au.f1901a == view) {
            m1607a((TooltipCompatHandler) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            TooltipCompatHandler viewOnAttachStateChangeListenerC0325au2 = f1900k;
            if (viewOnAttachStateChangeListenerC0325au2 != null && viewOnAttachStateChangeListenerC0325au2.f1901a == view) {
                viewOnAttachStateChangeListenerC0325au2.m1612a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new TooltipCompatHandler(view, charSequence);
    }

    private TooltipCompatHandler(View view, CharSequence charSequence) {
        this.f1901a = view;
        this.f1902b = charSequence;
        this.f1903c = ViewConfigurationCompat.m2931a(ViewConfiguration.get(this.f1901a.getContext()));
        m1611d();
        this.f1901a.setOnLongClickListener(this);
        this.f1901a.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) throws Resources.NotFoundException {
        this.f1906f = view.getWidth() / 2;
        this.f1907g = view.getHeight() / 2;
        m1613a(true);
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1908h != null && this.f1909i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1901a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                m1611d();
                m1612a();
            }
        } else if (this.f1901a.isEnabled() && this.f1908h == null && m1608a(motionEvent)) {
            m1607a(this);
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m1612a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1613a(boolean z) throws Resources.NotFoundException {
        long OplusGLSurfaceView_15;
        int longPressTimeout;
        long j2;
        if (ViewCompat.m2826D(this.f1901a)) {
            m1607a((TooltipCompatHandler) null);
            TooltipCompatHandler viewOnAttachStateChangeListenerC0325au = f1900k;
            if (viewOnAttachStateChangeListenerC0325au != null) {
                viewOnAttachStateChangeListenerC0325au.m1612a();
            }
            f1900k = this;
            this.f1909i = z;
            this.f1908h = new TooltipPopup(this.f1901a.getContext());
            this.f1908h.m1617a(this.f1901a, this.f1906f, this.f1907g, this.f1909i, this.f1902b);
            this.f1901a.addOnAttachStateChangeListener(this);
            if (this.f1909i) {
                j2 = 2500;
            } else {
                if ((ViewCompat.m2899r(this.f1901a) & 1) == 1) {
                    OplusGLSurfaceView_15 = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    OplusGLSurfaceView_15 = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j2 = OplusGLSurfaceView_15 - longPressTimeout;
            }
            this.f1901a.removeCallbacks(this.f1905e);
            this.f1901a.postDelayed(this.f1905e, j2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1612a() {
        if (f1900k == this) {
            f1900k = null;
            TooltipPopup c0326av = this.f1908h;
            if (c0326av != null) {
                c0326av.m1616a();
                this.f1908h = null;
                m1611d();
                this.f1901a.removeOnAttachStateChangeListener(this);
            } else {
                Log.COUIBaseListPopupWindow_8("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1899j == this) {
            m1607a((TooltipCompatHandler) null);
        }
        this.f1901a.removeCallbacks(this.f1905e);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m1607a(TooltipCompatHandler viewOnAttachStateChangeListenerC0325au) {
        TooltipCompatHandler viewOnAttachStateChangeListenerC0325au2 = f1899j;
        if (viewOnAttachStateChangeListenerC0325au2 != null) {
            viewOnAttachStateChangeListenerC0325au2.m1610c();
        }
        f1899j = viewOnAttachStateChangeListenerC0325au;
        TooltipCompatHandler viewOnAttachStateChangeListenerC0325au3 = f1899j;
        if (viewOnAttachStateChangeListenerC0325au3 != null) {
            viewOnAttachStateChangeListenerC0325au3.m1609b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1609b() {
        this.f1901a.postDelayed(this.f1904d, ViewConfiguration.getLongPressTimeout());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m1610c() {
        this.f1901a.removeCallbacks(this.f1904d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m1608a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f1906f) <= this.f1903c && Math.abs(y - this.f1907g) <= this.f1903c) {
            return false;
        }
        this.f1906f = x;
        this.f1907g = y;
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m1611d() {
        this.f1906f = Integer.MAX_VALUE;
        this.f1907g = Integer.MAX_VALUE;
    }
}
