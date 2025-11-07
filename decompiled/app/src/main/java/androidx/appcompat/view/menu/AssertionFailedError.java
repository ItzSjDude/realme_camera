package androidx.appcompat.view.menu;

/* compiled from: ActionMenuItemView.java */
/* loaded from: classes.dex */
public class b_renamed extends androidx.appcompat.widget.AppCompatTextView implements android.view.View.OnClickListener, androidx.appcompat.view.menu.o_renamed.a_renamed, androidx.appcompat.widget.ActionMenuView.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.appcompat.view.menu.j_renamed f360a;

    /* renamed from: b_renamed, reason: collision with root package name */
    androidx.appcompat.view.menu.h_renamed.b_renamed f361b;

    /* renamed from: c_renamed, reason: collision with root package name */
    androidx.appcompat.view.menu.b_renamed.ActionMenuItemView_2 f362c;
    private java.lang.CharSequence e_renamed;
    private android.graphics.drawable.Drawable f_renamed;
    private androidx.appcompat.widget.ad_renamed g_renamed;
    private boolean h_renamed;
    private boolean i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;

    /* compiled from: ActionMenuItemView.java */
    /* renamed from: androidx.appcompat.view.menu.b_renamed$b_renamed, reason: collision with other inner class name */
    public static abstract class ActionMenuItemView_2 {
        public abstract androidx.appcompat.view.menu.q_renamed a_renamed();
    }

    @Override // androidx.appcompat.view.menu.o_renamed.a_renamed
    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z_renamed) {
    }

    public void setChecked(boolean z_renamed) {
    }

    public b_renamed(android.content.Context context) {
        this(context, null);
    }

    public b_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        android.content.res.Resources resources = context.getResources();
        this.h_renamed = d_renamed();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R_renamed.styleable.ActionMenuItemView, i_renamed, 0);
        this.j_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R_renamed.styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.l_renamed = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.k_renamed = -1;
        setSaveEnabled(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.h_renamed = d_renamed();
        e_renamed();
    }

    private boolean d_renamed() {
        android.content.res.Configuration configuration = getContext().getResources().getConfiguration();
        int i_renamed = configuration.screenWidthDp;
        return i_renamed >= 480 || (i_renamed >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i_renamed, int i2, int i3, int i4) {
        this.k_renamed = i_renamed;
        super.setPadding(i_renamed, i2, i3, i4);
    }

    @Override // androidx.appcompat.view.menu.o_renamed.a_renamed
    public androidx.appcompat.view.menu.j_renamed getItemData() {
        return this.f360a;
    }

    @Override // androidx.appcompat.view.menu.o_renamed.a_renamed
    public void initialize(androidx.appcompat.view.menu.j_renamed jVar, int i_renamed) {
        this.f360a = jVar;
        setIcon(jVar.getIcon());
        setTitle(jVar.a_renamed((androidx.appcompat.view.menu.o_renamed.a_renamed) this));
        setId(jVar.getItemId());
        setVisibility(jVar.isVisible() ? 0 : 8);
        setEnabled(jVar.isEnabled());
        if (jVar.hasSubMenu() && this.g_renamed == null) {
            this.g_renamed = new androidx.appcompat.view.menu.b_renamed.a_renamed();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        androidx.appcompat.widget.ad_renamed adVar;
        if (this.f360a.hasSubMenu() && (adVar = this.g_renamed) != null && adVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        androidx.appcompat.view.menu.h_renamed.b_renamed bVar = this.f361b;
        if (bVar != null) {
            bVar.a_renamed(this.f360a);
        }
    }

    public void setItemInvoker(androidx.appcompat.view.menu.h_renamed.b_renamed bVar) {
        this.f361b = bVar;
    }

    public void setPopupCallback(androidx.appcompat.view.menu.b_renamed.ActionMenuItemView_2 abstractC0006b) {
        this.f362c = abstractC0006b;
    }

    public void setExpandedFormat(boolean z_renamed) {
        if (this.i_renamed != z_renamed) {
            this.i_renamed = z_renamed;
            androidx.appcompat.view.menu.j_renamed jVar = this.f360a;
            if (jVar != null) {
                jVar.h_renamed();
            }
        }
    }

    private void e_renamed() {
        boolean z_renamed = true;
        boolean z2 = !android.text.TextUtils.isEmpty(this.e_renamed);
        if (this.f_renamed != null && (!this.f360a.l_renamed() || (!this.h_renamed && !this.i_renamed))) {
            z_renamed = false;
        }
        boolean z3 = z2 & z_renamed;
        setText(z3 ? this.e_renamed : null);
        java.lang.CharSequence contentDescription = this.f360a.getContentDescription();
        if (android.text.TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f360a.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        java.lang.CharSequence tooltipText = this.f360a.getTooltipText();
        if (android.text.TextUtils.isEmpty(tooltipText)) {
            androidx.appcompat.widget.at_renamed.a_renamed(this, z3 ? null : this.f360a.getTitle());
        } else {
            androidx.appcompat.widget.at_renamed.a_renamed(this, tooltipText);
        }
    }

    public void setIcon(android.graphics.drawable.Drawable drawable) {
        this.f_renamed = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i_renamed = this.l_renamed;
            if (intrinsicWidth > i_renamed) {
                intrinsicHeight = (int) (intrinsicHeight * (i_renamed / intrinsicWidth));
                intrinsicWidth = i_renamed;
            }
            int i2 = this.l_renamed;
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
                intrinsicHeight = i2;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        e_renamed();
    }

    public boolean a_renamed() {
        return !android.text.TextUtils.isEmpty(getText());
    }

    public void setTitle(java.lang.CharSequence charSequence) {
        this.e_renamed = charSequence;
        e_renamed();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a_renamed
    public boolean b_renamed() {
        return a_renamed() && this.f360a.getIcon() == null;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a_renamed
    public boolean c_renamed() {
        return a_renamed();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int i3;
        boolean zA = a_renamed();
        if (zA && (i3 = this.k_renamed) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i_renamed, i2);
        int mode = android.view.View.MeasureSpec.getMode(i_renamed);
        int size = android.view.View.MeasureSpec.getSize(i_renamed);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? java.lang.Math.min(size, this.j_renamed) : this.j_renamed;
        if (mode != 1073741824 && this.j_renamed > 0 && measuredWidth < iMin) {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (zA || this.f_renamed == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f_renamed.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    /* compiled from: ActionMenuItemView.java */
    private class a_renamed extends androidx.appcompat.widget.ad_renamed {
        public a_renamed() {
            super(androidx.appcompat.view.menu.b_renamed.this);
        }

        @Override // androidx.appcompat.widget.ad_renamed
        public androidx.appcompat.view.menu.q_renamed a_renamed() {
            if (androidx.appcompat.view.menu.b_renamed.this.f362c != null) {
                return androidx.appcompat.view.menu.b_renamed.this.f362c.a_renamed();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ad_renamed
        protected boolean b_renamed() {
            androidx.appcompat.view.menu.q_renamed qVarA;
            return androidx.appcompat.view.menu.b_renamed.this.f361b != null && androidx.appcompat.view.menu.b_renamed.this.f361b.a_renamed(androidx.appcompat.view.menu.b_renamed.this.f360a) && (qVarA = a_renamed()) != null && qVarA.c_renamed();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
