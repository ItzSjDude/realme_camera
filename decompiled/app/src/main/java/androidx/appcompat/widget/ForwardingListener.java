package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;

/* compiled from: ForwardingListener.java */
/* renamed from: androidx.appcompat.widget.ad */
/* loaded from: classes.dex */
public abstract class ForwardingListener implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private final float f1736a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f1737b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final View f1738c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f1739d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Runnable f1740e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Runnable f1741f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f1742g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f1743h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final int[] f1744i = new int[2];

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract ShowableListMenu mo1107a();

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    public ForwardingListener(View view) {
        this.f1738c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1736a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1737b = ViewConfiguration.getTapTimeout();
        this.f1739d = (this.f1737b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1742g;
        if (z2) {
            z = m1416b(motionEvent) || !mo1268c();
        } else {
            z = m1413a(motionEvent) && mo1108b();
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1738c.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f1742g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1742g = false;
        this.f1743h = -1;
        Runnable runnable = this.f1740e;
        if (runnable != null) {
            this.f1738c.removeCallbacks(runnable);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected boolean mo1108b() {
        ShowableListMenu interfaceC0245qMo1107a = mo1107a();
        if (interfaceC0245qMo1107a == null || interfaceC0245qMo1107a.mo1142c()) {
            return true;
        }
        interfaceC0245qMo1107a.mo1136a_();
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected boolean mo1268c() {
        ShowableListMenu interfaceC0245qMo1107a = mo1107a();
        if (interfaceC0245qMo1107a == null || !interfaceC0245qMo1107a.mo1142c()) {
            return true;
        }
        interfaceC0245qMo1107a.mo1137b();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m1413a(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1738c
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f1743h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1736a
            boolean r6 = m1414a(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.m1418e()
            android.view.ViewParent r5 = r0.getParent()
            r5.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.m1418e()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f1743h = r6
            java.lang.Runnable r6 = r5.f1740e
            if (r6 != 0) goto L52
            androidx.appcompat.widget.ad$PlatformImplementations.kt_3 r6 = new androidx.appcompat.widget.ad$PlatformImplementations.kt_3
            r6.<init>()
            r5.f1740e = r6
        L52:
            java.lang.Runnable r6 = r5.f1740e
            int r1 = r5.f1737b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1741f
            if (r6 != 0) goto L65
            androidx.appcompat.widget.ad$IntrinsicsJvm.kt_4 r6 = new androidx.appcompat.widget.ad$IntrinsicsJvm.kt_4
            r6.<init>()
            r5.f1741f = r6
        L65:
            java.lang.Runnable r6 = r5.f1741f
            int r5 = r5.f1739d
            long r3 = (long) r5
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ForwardingListener.m1413a(android.view.MotionEvent):boolean");
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m1418e() {
        Runnable runnable = this.f1741f;
        if (runnable != null) {
            this.f1738c.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1740e;
        if (runnable2 != null) {
            this.f1738c.removeCallbacks(runnable2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void m1419d() {
        m1418e();
        View view = this.f1738c;
        if (view.isEnabled() && !view.isLongClickable() && mo1108b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f1742g = true;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m1416b(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException {
        DropDownListView c0306ab;
        View view = this.f1738c;
        ShowableListMenu interfaceC0245qMo1107a = mo1107a();
        if (interfaceC0245qMo1107a == null || !interfaceC0245qMo1107a.mo1142c() || (c0306ab = (DropDownListView) interfaceC0245qMo1107a.mo1140b_()) == null || !c0306ab.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m1417b(view, motionEventObtainNoHistory);
        m1415a(c0306ab, motionEventObtainNoHistory);
        boolean zMo1409a = c0306ab.mo1409a(motionEventObtainNoHistory, this.f1743h);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zMo1409a && (actionMasked != 1 && actionMasked != 3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m1414a(View view, float COUIBaseListPopupWindow_12, float f2, float f3) {
        float f4 = -f3;
        return COUIBaseListPopupWindow_12 >= f4 && f2 >= f4 && COUIBaseListPopupWindow_12 < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m1415a(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1744i);
        motionEvent.offsetLocation(-r1[0], -r1[1]);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m1417b(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1744i);
        motionEvent.offsetLocation(r1[0], r1[1]);
        return true;
    }

    /* compiled from: ForwardingListener.java */
    /* renamed from: androidx.appcompat.widget.ad$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements Runnable {
        PlatformImplementations.kt_3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = ForwardingListener.this.f1738c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener.java */
    /* renamed from: androidx.appcompat.widget.ad$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements Runnable {
        IntrinsicsJvm.kt_4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ForwardingListener.this.m1419d();
        }
    }
}
