package androidx.appcompat.widget;

/* compiled from: TooltipCompatHandler.java */
/* loaded from: classes.dex */
class au_renamed implements android.view.View.OnAttachStateChangeListener, android.view.View.OnHoverListener, android.view.View.OnLongClickListener {
    private static androidx.appcompat.widget.au_renamed j_renamed;
    private static androidx.appcompat.widget.au_renamed k_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.View f588a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.CharSequence f589b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f590c;
    private final java.lang.Runnable d_renamed = new java.lang.Runnable() { // from class: androidx.appcompat.widget.au_renamed.1
        @Override // java.lang.Runnable
        public void run() throws android.content.res.Resources.NotFoundException {
            androidx.appcompat.widget.au_renamed.this.a_renamed(false);
        }
    };
    private final java.lang.Runnable e_renamed = new java.lang.Runnable() { // from class: androidx.appcompat.widget.au_renamed.2
        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.widget.au_renamed.this.a_renamed();
        }
    };
    private int f_renamed;
    private int g_renamed;
    private androidx.appcompat.widget.av_renamed h_renamed;
    private boolean i_renamed;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(android.view.View view) {
    }

    public static void a_renamed(android.view.View view, java.lang.CharSequence charSequence) {
        androidx.appcompat.widget.au_renamed auVar = j_renamed;
        if (auVar != null && auVar.f588a == view) {
            a_renamed((androidx.appcompat.widget.au_renamed) null);
        }
        if (android.text.TextUtils.isEmpty(charSequence)) {
            androidx.appcompat.widget.au_renamed auVar2 = k_renamed;
            if (auVar2 != null && auVar2.f588a == view) {
                auVar2.a_renamed();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new androidx.appcompat.widget.au_renamed(view, charSequence);
    }

    private au_renamed(android.view.View view, java.lang.CharSequence charSequence) {
        this.f588a = view;
        this.f589b = charSequence;
        this.f590c = androidx.core.h_renamed.w_renamed.a_renamed(android.view.ViewConfiguration.get(this.f588a.getContext()));
        d_renamed();
        this.f588a.setOnLongClickListener(this);
        this.f588a.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(android.view.View view) throws android.content.res.Resources.NotFoundException {
        this.f_renamed = view.getWidth() / 2;
        this.g_renamed = view.getHeight() / 2;
        a_renamed(true);
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(android.view.View view, android.view.MotionEvent motionEvent) {
        if (this.h_renamed != null && this.i_renamed) {
            return false;
        }
        android.view.accessibility.AccessibilityManager accessibilityManager = (android.view.accessibility.AccessibilityManager) this.f588a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                d_renamed();
                a_renamed();
            }
        } else if (this.f588a.isEnabled() && this.h_renamed == null && a_renamed(motionEvent)) {
            a_renamed(this);
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(android.view.View view) {
        a_renamed();
    }

    void a_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        long j2;
        int longPressTimeout;
        long j3;
        if (androidx.core.h_renamed.v_renamed.D_renamed(this.f588a)) {
            a_renamed((androidx.appcompat.widget.au_renamed) null);
            androidx.appcompat.widget.au_renamed auVar = k_renamed;
            if (auVar != null) {
                auVar.a_renamed();
            }
            k_renamed = this;
            this.i_renamed = z_renamed;
            this.h_renamed = new androidx.appcompat.widget.av_renamed(this.f588a.getContext());
            this.h_renamed.a_renamed(this.f588a, this.f_renamed, this.g_renamed, this.i_renamed, this.f589b);
            this.f588a.addOnAttachStateChangeListener(this);
            if (this.i_renamed) {
                j3 = 2500;
            } else {
                if ((androidx.core.h_renamed.v_renamed.r_renamed(this.f588a) & 1) == 1) {
                    j2 = 3000;
                    longPressTimeout = android.view.ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = 15000;
                    longPressTimeout = android.view.ViewConfiguration.getLongPressTimeout();
                }
                j3 = j2 - longPressTimeout;
            }
            this.f588a.removeCallbacks(this.e_renamed);
            this.f588a.postDelayed(this.e_renamed, j3);
        }
    }

    void a_renamed() {
        if (k_renamed == this) {
            k_renamed = null;
            androidx.appcompat.widget.av_renamed avVar = this.h_renamed;
            if (avVar != null) {
                avVar.a_renamed();
                this.h_renamed = null;
                d_renamed();
                this.f588a.removeOnAttachStateChangeListener(this);
            } else {
                android.util.Log.e_renamed("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (j_renamed == this) {
            a_renamed((androidx.appcompat.widget.au_renamed) null);
        }
        this.f588a.removeCallbacks(this.e_renamed);
    }

    private static void a_renamed(androidx.appcompat.widget.au_renamed auVar) {
        androidx.appcompat.widget.au_renamed auVar2 = j_renamed;
        if (auVar2 != null) {
            auVar2.c_renamed();
        }
        j_renamed = auVar;
        androidx.appcompat.widget.au_renamed auVar3 = j_renamed;
        if (auVar3 != null) {
            auVar3.b_renamed();
        }
    }

    private void b_renamed() {
        this.f588a.postDelayed(this.d_renamed, android.view.ViewConfiguration.getLongPressTimeout());
    }

    private void c_renamed() {
        this.f588a.removeCallbacks(this.d_renamed);
    }

    private boolean a_renamed(android.view.MotionEvent motionEvent) {
        int x_renamed = (int) motionEvent.getX();
        int y_renamed = (int) motionEvent.getY();
        if (java.lang.Math.abs(x_renamed - this.f_renamed) <= this.f590c && java.lang.Math.abs(y_renamed - this.g_renamed) <= this.f590c) {
            return false;
        }
        this.f_renamed = x_renamed;
        this.g_renamed = y_renamed;
        return true;
    }

    private void d_renamed() {
        this.f_renamed = Integer.MAX_VALUE;
        this.g_renamed = Integer.MAX_VALUE;
    }
}
