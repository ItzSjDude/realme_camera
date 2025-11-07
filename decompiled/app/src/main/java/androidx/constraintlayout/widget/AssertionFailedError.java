package androidx.constraintlayout.widget;

/* compiled from: ConstraintHelper.java */
/* loaded from: classes.dex */
public abstract class b_renamed extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected int[] f756a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected int f757b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected android.content.Context f758c;
    protected androidx.constraintlayout.a_renamed.a_renamed.j_renamed d_renamed;
    protected boolean e_renamed;
    private java.lang.String f_renamed;

    public void b_renamed(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
    }

    public void c_renamed(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
    }

    public b_renamed(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        super(context);
        this.f756a = new int[32];
        this.e_renamed = false;
        this.f758c = context;
        a_renamed((android.util.AttributeSet) null);
    }

    protected void a_renamed(android.util.AttributeSet attributeSet) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i_renamed = 0; i_renamed < indexCount; i_renamed++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i_renamed);
                if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f_renamed = typedArrayObtainStyledAttributes.getString(index);
                    setIds(this.f_renamed);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return java.util.Arrays.copyOf(this.f756a, this.f757b);
    }

    public void setReferencedIds(int[] iArr) {
        this.f757b = 0;
        for (int i_renamed : iArr) {
            setTag(i_renamed, null);
        }
    }

    @Override // android.view.View
    public void setTag(int i_renamed, java.lang.Object obj) {
        int i2 = this.f757b + 1;
        int[] iArr = this.f756a;
        if (i2 > iArr.length) {
            this.f756a = java.util.Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f756a;
        int i3 = this.f757b;
        iArr2[i3] = i_renamed;
        this.f757b = i3 + 1;
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        if (this.e_renamed) {
            super.onMeasure(i_renamed, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void b_renamed() {
        if (this.d_renamed == null) {
            return;
        }
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof androidx.constraintlayout.widget.ConstraintLayout.a_renamed) {
            ((androidx.constraintlayout.widget.ConstraintLayout.a_renamed) layoutParams).al_renamed = this.d_renamed;
        }
    }

    private void a_renamed(java.lang.String str) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        int iIntValue;
        java.lang.Object objA;
        if (str == null || this.f758c == null) {
            return;
        }
        java.lang.String strTrim = str.trim();
        try {
            iIntValue = androidx.constraintlayout.widget.R_renamed.id_renamed.class.getField(strTrim).getInt(null);
        } catch (java.lang.Exception unused) {
            iIntValue = 0;
        }
        if (iIntValue == 0) {
            iIntValue = this.f758c.getResources().getIdentifier(strTrim, com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID, this.f758c.getPackageName());
        }
        if (iIntValue == 0 && isInEditMode() && (getParent() instanceof androidx.constraintlayout.widget.ConstraintLayout) && (objA = ((androidx.constraintlayout.widget.ConstraintLayout) getParent()).a_renamed(0, strTrim)) != null && (objA instanceof java.lang.Integer)) {
            iIntValue = ((java.lang.Integer) objA).intValue();
        }
        if (iIntValue != 0) {
            setTag(iIntValue, null);
            return;
        }
        android.util.Log.w_renamed("ConstraintHelper", "Could not find id_renamed of_renamed \"" + strTrim + "\"");
    }

    private void setIds(java.lang.String str) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        if (str == null) {
            return;
        }
        int i_renamed = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i_renamed);
            if (iIndexOf == -1) {
                a_renamed(str.substring(i_renamed));
                return;
            } else {
                a_renamed(str.substring(i_renamed, iIndexOf));
                i_renamed = iIndexOf + 1;
            }
        }
    }

    public void a_renamed(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        if (isInEditMode()) {
            setIds(this.f_renamed);
        }
        androidx.constraintlayout.a_renamed.a_renamed.j_renamed jVar = this.d_renamed;
        if (jVar == null) {
            return;
        }
        jVar.K_renamed();
        for (int i_renamed = 0; i_renamed < this.f757b; i_renamed++) {
            android.view.View viewA = constraintLayout.a_renamed(this.f756a[i_renamed]);
            if (viewA != null) {
                this.d_renamed.b_renamed(constraintLayout.a_renamed(viewA));
            }
        }
    }
}
