package androidx.appcompat.widget;

/* compiled from: ForwardingListener.java */
/* loaded from: classes.dex */
public abstract class ad_renamed implements android.view.View.OnAttachStateChangeListener, android.view.View.OnTouchListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final float f528a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f529b;

    /* renamed from: c_renamed, reason: collision with root package name */
    final android.view.View f530c;
    private final int d_renamed;
    private java.lang.Runnable e_renamed;
    private java.lang.Runnable f_renamed;
    private boolean g_renamed;
    private int h_renamed;
    private final int[] i_renamed = new int[2];

    public abstract androidx.appcompat.view.menu.q_renamed a_renamed();

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(android.view.View view) {
    }

    public ad_renamed(android.view.View view) {
        this.f530c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f528a = android.view.ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f529b = android.view.ViewConfiguration.getTapTimeout();
        this.d_renamed = (this.f529b + android.view.ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        boolean z_renamed;
        boolean z2 = this.g_renamed;
        if (z2) {
            z_renamed = b_renamed(motionEvent) || !c_renamed();
        } else {
            z_renamed = a_renamed(motionEvent) && b_renamed();
            if (z_renamed) {
                long jUptimeMillis = android.os.SystemClock.uptimeMillis();
                android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f530c.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.g_renamed = z_renamed;
        return z_renamed || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(android.view.View view) {
        this.g_renamed = false;
        this.h_renamed = -1;
        java.lang.Runnable runnable = this.e_renamed;
        if (runnable != null) {
            this.f530c.removeCallbacks(runnable);
        }
    }

    protected boolean b_renamed() {
        androidx.appcompat.view.menu.q_renamed qVarA = a_renamed();
        if (qVarA == null || qVarA.c_renamed()) {
            return true;
        }
        qVarA.a__renamed();
        return true;
    }

    protected boolean c_renamed() {
        androidx.appcompat.view.menu.q_renamed qVarA = a_renamed();
        if (qVarA == null || !qVarA.c_renamed()) {
            return true;
        }
        qVarA.b_renamed();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a_renamed(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f530c
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
            int r1 = r5.h_renamed
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f528a
            boolean r6 = a_renamed(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.e_renamed()
            android.view.ViewParent r5 = r0.getParent()
            r5.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.e_renamed()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.h_renamed = r6
            java.lang.Runnable r6 = r5.e_renamed
            if (r6 != 0) goto L52
            androidx.appcompat.widget.ad_renamed$a_renamed r6 = new androidx.appcompat.widget.ad_renamed$a_renamed
            r6.<init>()
            r5.e_renamed = r6
        L52:
            java.lang.Runnable r6 = r5.e_renamed
            int r1 = r5.f529b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f_renamed
            if (r6 != 0) goto L65
            androidx.appcompat.widget.ad_renamed$b_renamed r6 = new androidx.appcompat.widget.ad_renamed$b_renamed
            r6.<init>()
            r5.f_renamed = r6
        L65:
            java.lang.Runnable r6 = r5.f_renamed
            int r5 = r5.d_renamed
            long r3 = (long) r5
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ad_renamed.a_renamed(android.view.MotionEvent):boolean");
    }

    private void e_renamed() {
        java.lang.Runnable runnable = this.f_renamed;
        if (runnable != null) {
            this.f530c.removeCallbacks(runnable);
        }
        java.lang.Runnable runnable2 = this.e_renamed;
        if (runnable2 != null) {
            this.f530c.removeCallbacks(runnable2);
        }
    }

    void d_renamed() {
        e_renamed();
        android.view.View view = this.f530c;
        if (view.isEnabled() && !view.isLongClickable() && b_renamed()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = android.os.SystemClock.uptimeMillis();
            android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.g_renamed = true;
        }
    }

    private boolean b_renamed(android.view.MotionEvent motionEvent) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        androidx.appcompat.widget.ab_renamed abVar;
        android.view.View view = this.f530c;
        androidx.appcompat.view.menu.q_renamed qVarA = a_renamed();
        if (qVarA == null || !qVarA.c_renamed() || (abVar = (androidx.appcompat.widget.ab_renamed) qVarA.b__renamed()) == null || !abVar.isShown()) {
            return false;
        }
        android.view.MotionEvent motionEventObtainNoHistory = android.view.MotionEvent.obtainNoHistory(motionEvent);
        b_renamed(view, motionEventObtainNoHistory);
        a_renamed(abVar, motionEventObtainNoHistory);
        boolean zA = abVar.a_renamed(motionEventObtainNoHistory, this.h_renamed);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zA && (actionMasked != 1 && actionMasked != 3);
    }

    private static boolean a_renamed(android.view.View view, float f_renamed, float f2, float f3) {
        float f4 = -f3;
        return f_renamed >= f4 && f2 >= f4 && f_renamed < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean a_renamed(android.view.View view, android.view.MotionEvent motionEvent) {
        view.getLocationOnScreen(this.i_renamed);
        motionEvent.offsetLocation(-r1[0], -r1[1]);
        return true;
    }

    private boolean b_renamed(android.view.View view, android.view.MotionEvent motionEvent) {
        view.getLocationOnScreen(this.i_renamed);
        motionEvent.offsetLocation(r1[0], r1[1]);
        return true;
    }

    /* compiled from: ForwardingListener.java */
    private class a_renamed implements java.lang.Runnable {
        a_renamed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            android.view.ViewParent parent = androidx.appcompat.widget.ad_renamed.this.f530c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener.java */
    private class b_renamed implements java.lang.Runnable {
        b_renamed() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.widget.ad_renamed.this.d_renamed();
        }
    }
}
