package com.oplus.camera.professional;

/* compiled from: HSListProfessionalModeBar.java */
/* loaded from: classes2.dex */
public class e_renamed extends android.widget.LinearLayout implements com.oplus.camera.professional.g_renamed.c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final /* synthetic */ boolean f5125a = !com.oplus.camera.professional.e_renamed.class.desiredAssertionStatus();

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.professional.d_renamed f5126b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f5127c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private android.view.View h_renamed;
    private android.graphics.Rect i_renamed;
    private android.app.Activity j_renamed;
    private com.oplus.camera.professional.e_renamed.b_renamed k_renamed;
    private boolean l_renamed;
    private com.oplus.camera.professional.e_renamed.a_renamed m_renamed;
    private com.oplus.camera.professional.q_renamed n_renamed;

    /* compiled from: HSListProfessionalModeBar.java */
    public enum a_renamed {
        NO_PRESSED,
        ISO_PRESSED,
        SHUTTER_PRESSED,
        WB_PRESSED,
        AF_PRESSED,
        EV_PRESSED
    }

    /* compiled from: HSListProfessionalModeBar.java */
    public interface b_renamed {
        void a_renamed(android.view.View view, android.view.View view2, long j_renamed);
    }

    public e_renamed(android.app.Activity activity, int i_renamed) {
        super(activity);
        this.f5126b = null;
        this.f5127c = 0;
        this.d_renamed = -1;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.l_renamed = false;
        this.m_renamed = com.oplus.camera.professional.e_renamed.a_renamed.NO_PRESSED;
        this.n_renamed = null;
        this.j_renamed = activity;
        this.f5127c = i_renamed;
        setGravity(17);
        setOrientation(0);
        setClipChildren(false);
    }

    private void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        android.view.View childAt;
        int iA = a_renamed(i_renamed, i2);
        if (iA == this.d_renamed || iA == -1 || this.e_renamed <= 0 || iA >= this.f5126b.getCount() || (childAt = getChildAt(iA)) == null) {
            return;
        }
        childAt.setPressed(z_renamed);
    }

    public void a_renamed() {
        setItemPressed(false);
        this.d_renamed = -1;
    }

    public int getSelectedPosition() {
        return this.d_renamed;
    }

    public int getSelectedIndex() {
        int i_renamed = this.d_renamed;
        if (i_renamed < 0 || i_renamed >= getChildCount()) {
            return -1;
        }
        return a_renamed(getChildAt(this.d_renamed));
    }

    public int a_renamed(android.view.View view) {
        if (view == null) {
            return -1;
        }
        return ((java.lang.Integer) view.getTag(com.oplus.camera.R_renamed.id_renamed.professional_parameter_index)).intValue();
    }

    public android.view.View a_renamed(int i_renamed) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            android.view.View childAt = getChildAt(i2);
            if (i_renamed == a_renamed(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public com.oplus.camera.professional.e_renamed.a_renamed getModePressState() {
        return this.m_renamed;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        android.view.View childAt;
        android.view.View childAt2;
        android.view.View childAt3;
        android.view.View childAt4;
        com.oplus.camera.e_renamed.f_renamed("HSListProfessionalModeBar", "onTouchEvent, isEnabled: " + isEnabled());
        int actionMasked = motionEvent.getActionMasked();
        if (this.h_renamed != null && (1 == actionMasked || 3 == actionMasked)) {
            this.f5126b.a_renamed(this.h_renamed, false);
            this.h_renamed = null;
        }
        if (!isEnabled()) {
            a_renamed(this.f_renamed, this.g_renamed, false);
            return isClickable() || isLongClickable();
        }
        if (motionEvent.getPointerCount() > 1) {
            a_renamed(this.f_renamed, this.g_renamed, false);
            return true;
        }
        if (actionMasked == 0) {
            this.f_renamed = (int) motionEvent.getX();
            this.g_renamed = (int) motionEvent.getY();
            int iA = a_renamed(this.f_renamed, this.g_renamed);
            if (iA == -1 || this.e_renamed <= 0 || iA >= this.f5126b.getCount() || (childAt = getChildAt(iA)) == null || !((com.oplus.camera.professional.y_renamed) childAt).f5282a) {
                return false;
            }
            this.f5126b.a_renamed(childAt, true);
            this.h_renamed = childAt;
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int x_renamed = (int) motionEvent.getX();
                int y_renamed = (int) motionEvent.getY();
                if (java.lang.Math.abs(x_renamed - this.f_renamed) > 10 || java.lang.Math.abs(y_renamed - this.g_renamed) > 10) {
                    this.l_renamed = true;
                    int iA2 = a_renamed(this.f_renamed, this.g_renamed);
                    if (iA2 == this.d_renamed || iA2 == -1 || this.e_renamed <= 0 || iA2 >= this.f5126b.getCount() || (childAt3 = getChildAt(iA2)) == null || !((com.oplus.camera.professional.y_renamed) childAt3).f5282a) {
                        return true;
                    }
                    childAt3.setPressed(false);
                }
            } else if (actionMasked == 3) {
                if (this.l_renamed) {
                    this.l_renamed = false;
                }
                int iA3 = a_renamed(this.f_renamed, this.g_renamed);
                if (iA3 != this.d_renamed && iA3 != -1 && this.e_renamed > 0 && iA3 < this.f5126b.getCount() && (childAt4 = getChildAt(iA3)) != null) {
                    com.oplus.camera.professional.y_renamed yVar = (com.oplus.camera.professional.y_renamed) childAt4;
                    if (!yVar.f5282a) {
                        return true;
                    }
                    if ((yVar.getChildAt(0) instanceof com.oplus.camera.professional.k_renamed) || (yVar.getChildAt(0) instanceof com.oplus.camera.professional.f_renamed)) {
                        childAt4.setPressed(false);
                    }
                }
            } else if (actionMasked != 5) {
            }
        } else if (this.l_renamed) {
            this.l_renamed = false;
            int iA4 = a_renamed(this.f_renamed, this.g_renamed);
            if (iA4 == this.d_renamed || iA4 == -1 || this.e_renamed <= 0 || iA4 >= this.f5126b.getCount() || (childAt2 = getChildAt(iA4)) == null || !((com.oplus.camera.professional.y_renamed) childAt2).f5282a) {
                return true;
            }
            childAt2.setPressed(false);
        } else if (!b_renamed((int) motionEvent.getX(), (int) motionEvent.getY())) {
            b_renamed(this.f_renamed, this.g_renamed);
        }
        return true;
    }

    private void setModePressedState(int i_renamed) {
        if (-1 == i_renamed) {
            com.oplus.camera.e_renamed.f_renamed("HSListProfessionalModeBar", "setModePressedState, invalid position");
            return;
        }
        if (this.e_renamed > 0 && i_renamed < this.f5126b.getCount()) {
            int iIntValue = ((java.lang.Integer) getChildAt(i_renamed).getTag(com.oplus.camera.R_renamed.id_renamed.professional_parameter_index)).intValue();
            if (i_renamed == this.d_renamed) {
                this.m_renamed = com.oplus.camera.professional.e_renamed.a_renamed.NO_PRESSED;
                return;
            }
            if (iIntValue == 1) {
                this.m_renamed = com.oplus.camera.professional.e_renamed.a_renamed.ISO_PRESSED;
                return;
            }
            if (iIntValue == 2) {
                this.m_renamed = com.oplus.camera.professional.e_renamed.a_renamed.SHUTTER_PRESSED;
                return;
            }
            if (iIntValue == 3) {
                this.m_renamed = com.oplus.camera.professional.e_renamed.a_renamed.EV_PRESSED;
                return;
            }
            if (iIntValue == 4) {
                this.m_renamed = com.oplus.camera.professional.e_renamed.a_renamed.AF_PRESSED;
            } else if (iIntValue == 5) {
                this.m_renamed = com.oplus.camera.professional.e_renamed.a_renamed.WB_PRESSED;
            } else {
                com.oplus.camera.e_renamed.f_renamed("HSListProfessionalModeBar", "setModePressedState, default invalid position");
            }
        }
    }

    private boolean b_renamed(int i_renamed, int i2) {
        int iA = a_renamed(i_renamed, i2);
        if (iA == -1 || this.e_renamed <= 0 || iA >= this.f5126b.getCount()) {
            return false;
        }
        android.view.View childAt = getChildAt(iA);
        if (childAt != null) {
            com.oplus.camera.professional.y_renamed yVar = (com.oplus.camera.professional.y_renamed) childAt;
            if (!yVar.f5282a) {
                return true;
            }
            if (a_renamed(childAt) != 0) {
                setPressed(false);
            }
            childAt.setPressed(true);
            android.view.View childAt2 = yVar.getChildAt(0);
            if (childAt2 != null && (childAt2 instanceof com.oplus.camera.professional.f_renamed)) {
                ((com.oplus.camera.professional.f_renamed) childAt2).a_renamed();
            }
        }
        setModePressedState(iA);
        if (a_renamed(childAt) != 0) {
            this.d_renamed = iA;
        }
        a_renamed(childAt, this.f5126b.getItemId(iA));
        return true;
    }

    public int a_renamed(int i_renamed, int i2) {
        android.graphics.Rect rect = this.i_renamed;
        if (rect == null) {
            this.i_renamed = new android.graphics.Rect();
            rect = this.i_renamed;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            android.view.View childAt = getChildAt(childCount);
            if (!f5125a && childAt == null) {
                throw new java.lang.AssertionError();
            }
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i_renamed, i2)) {
                    return childCount;
                }
            }
        }
        com.oplus.camera.e_renamed.f_renamed("HSListProfessionalModeBar", "error frame is_renamed " + rect);
        return -1;
    }

    @Override // android.view.View
    public boolean isSelected() {
        return -1 != this.d_renamed;
    }

    public boolean a_renamed(android.view.View view, long j_renamed) {
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
            this.k_renamed.a_renamed(this, view, j_renamed);
        }
        return true;
    }

    private android.view.View a_renamed(int i_renamed, java.lang.Boolean bool) {
        com.oplus.camera.professional.f_renamed fVar;
        com.oplus.camera.professional.y_renamed yVar = new com.oplus.camera.professional.y_renamed(this.j_renamed, this.f5127c);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        yVar.setGravity(17);
        yVar.setLayoutParams(layoutParams);
        yVar.setClipChildren(false);
        if (bool.booleanValue()) {
            fVar = new com.oplus.camera.professional.f_renamed(this.j_renamed, true);
        } else {
            fVar = new com.oplus.camera.professional.f_renamed(this.j_renamed, false);
        }
        fVar.setId(102);
        fVar.setLayoutParams(layoutParams);
        yVar.addView(fVar);
        return yVar;
    }

    public void setAdapter(com.oplus.camera.professional.d_renamed dVar) throws android.content.res.Resources.NotFoundException {
        this.f5126b = dVar;
        this.f5126b.a_renamed(new int[]{100, 101, 102});
        this.e_renamed = this.f5126b.getCount();
        b_renamed();
        requestLayout();
    }

    public com.oplus.camera.professional.d_renamed getAdapter() {
        return this.f5126b;
    }

    public int getItemCount() {
        return this.e_renamed;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        this.d_renamed = i_renamed;
        if (getChildAt(i_renamed) != null) {
            getChildAt(i_renamed).setPressed(z_renamed);
        }
    }

    public void setItemPressed(boolean z_renamed) {
        android.view.View childAt;
        int i_renamed = this.d_renamed;
        if (-1 == i_renamed || (childAt = getChildAt(i_renamed)) == null) {
            return;
        }
        childAt.setPressed(z_renamed);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if (!f5125a && childAt == null) {
                throw new java.lang.AssertionError();
            }
            childAt.clearAnimation();
        }
        super.removeAllViews();
    }

    private void b_renamed() throws android.content.res.Resources.NotFoundException {
        android.view.View view;
        int dimensionPixelSize = this.j_renamed.getApplicationContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_margin_side);
        int dimensionPixelSize2 = this.j_renamed.getApplicationContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.hs_main_mode_bar_item_margin_another);
        boolean z_renamed = 1 == androidx.core.f_renamed.f_renamed.a_renamed(java.util.Locale.getDefault());
        for (int i_renamed = 0; i_renamed < this.e_renamed; i_renamed++) {
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            if ((i_renamed == 0 && !z_renamed) || (z_renamed && i_renamed == this.e_renamed - 1)) {
                layoutParams.leftMargin = dimensionPixelSize;
            } else if ((i_renamed == 0 && z_renamed) || (!z_renamed && i_renamed == this.e_renamed - 1)) {
                layoutParams.leftMargin = dimensionPixelSize2;
                layoutParams.rightMargin = dimensionPixelSize;
            } else {
                layoutParams.leftMargin = dimensionPixelSize2;
            }
            if (i_renamed == 0) {
                view = this.f5126b.getView(i_renamed, a_renamed(i_renamed, (java.lang.Boolean) true), this);
            } else {
                view = this.f5126b.getView(i_renamed, a_renamed(i_renamed, (java.lang.Boolean) false), this);
            }
            addView(view, layoutParams);
        }
    }

    public void setOnItemClickListener(com.oplus.camera.professional.e_renamed.b_renamed bVar) {
        this.k_renamed = bVar;
    }

    @Override // com.oplus.camera.professional.g_renamed.c_renamed
    public void a_renamed(int i_renamed, java.lang.String str, boolean z_renamed) {
        android.view.View viewA = a_renamed(i_renamed);
        if (viewA != null) {
            this.f5126b.a_renamed(viewA, str);
            if (z_renamed) {
                if (viewA.isPressed()) {
                    this.f5126b.a_renamed(viewA, 0, false);
                    return;
                } else {
                    this.f5126b.a_renamed(viewA, 0, true);
                    return;
                }
            }
            this.f5126b.a_renamed(viewA, 8, true);
        }
    }

    @Override // com.oplus.camera.professional.g_renamed.c_renamed
    public void b_renamed(int i_renamed, boolean z_renamed) {
        android.view.View viewA = a_renamed(i_renamed);
        if (viewA != null) {
            if (z_renamed) {
                this.f5126b.a_renamed(viewA, 0, true);
            } else {
                this.f5126b.a_renamed(viewA, 8, true);
            }
        }
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        for (int i_renamed = 0; i_renamed < getChildCount(); i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if (childAt != null) {
                this.f5126b.a_renamed(childAt, z_renamed, z2);
            }
        }
    }

    public void a_renamed(int i_renamed, java.lang.String str) {
        android.view.View viewA = a_renamed(i_renamed);
        if (viewA != null) {
            this.f5126b.a_renamed(viewA, str);
        }
    }

    public java.lang.String b_renamed(int i_renamed) {
        android.view.View viewA = a_renamed(i_renamed);
        com.oplus.camera.professional.d_renamed dVar = this.f5126b;
        if (dVar == null || viewA == null) {
            return null;
        }
        return dVar.a_renamed(viewA);
    }

    public void setPanelInterface(com.oplus.camera.professional.q_renamed qVar) {
        this.n_renamed = qVar;
    }
}
