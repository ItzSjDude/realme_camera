package androidx.constraintlayout.widget;

/* loaded from: classes.dex */
public class ConstraintLayout extends android.view.ViewGroup {

    /* renamed from: a_renamed, reason: collision with root package name */
    android.util.SparseArray<android.view.View> f749a;

    /* renamed from: b_renamed, reason: collision with root package name */
    androidx.constraintlayout.a_renamed.a_renamed.g_renamed f750b;

    /* renamed from: c_renamed, reason: collision with root package name */
    int f751c;
    int d_renamed;
    int e_renamed;
    int f_renamed;
    private java.util.ArrayList<androidx.constraintlayout.widget.b_renamed> g_renamed;
    private final java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private boolean m_renamed;
    private int n_renamed;
    private androidx.constraintlayout.widget.c_renamed o_renamed;
    private int p_renamed;
    private java.util.HashMap<java.lang.String, java.lang.Integer> q_renamed;
    private int r_renamed;
    private int s_renamed;
    private androidx.constraintlayout.a_renamed.f_renamed t_renamed;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void a_renamed(int i_renamed, java.lang.Object obj, java.lang.Object obj2) {
        if (i_renamed == 0 && (obj instanceof java.lang.String) && (obj2 instanceof java.lang.Integer)) {
            if (this.q_renamed == null) {
                this.q_renamed = new java.util.HashMap<>();
            }
            java.lang.String strSubstring = (java.lang.String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.q_renamed.put(strSubstring, java.lang.Integer.valueOf(((java.lang.Integer) obj2).intValue()));
        }
    }

    public java.lang.Object a_renamed(int i_renamed, java.lang.Object obj) {
        if (i_renamed != 0 || !(obj instanceof java.lang.String)) {
            return null;
        }
        java.lang.String str = (java.lang.String) obj;
        java.util.HashMap<java.lang.String, java.lang.Integer> map = this.q_renamed;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.q_renamed.get(str);
    }

    public ConstraintLayout(android.content.Context context) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        super(context);
        this.f749a = new android.util.SparseArray<>();
        this.g_renamed = new java.util.ArrayList<>(4);
        this.h_renamed = new java.util.ArrayList<>(100);
        this.f750b = new androidx.constraintlayout.a_renamed.a_renamed.g_renamed();
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = Integer.MAX_VALUE;
        this.l_renamed = Integer.MAX_VALUE;
        this.m_renamed = true;
        this.n_renamed = 7;
        this.o_renamed = null;
        this.p_renamed = -1;
        this.q_renamed = new java.util.HashMap<>();
        this.r_renamed = -1;
        this.s_renamed = -1;
        this.f751c = -1;
        this.d_renamed = -1;
        this.e_renamed = 0;
        this.f_renamed = 0;
        b_renamed((android.util.AttributeSet) null);
    }

    public ConstraintLayout(android.content.Context context, android.util.AttributeSet attributeSet) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        super(context, attributeSet);
        this.f749a = new android.util.SparseArray<>();
        this.g_renamed = new java.util.ArrayList<>(4);
        this.h_renamed = new java.util.ArrayList<>(100);
        this.f750b = new androidx.constraintlayout.a_renamed.a_renamed.g_renamed();
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = Integer.MAX_VALUE;
        this.l_renamed = Integer.MAX_VALUE;
        this.m_renamed = true;
        this.n_renamed = 7;
        this.o_renamed = null;
        this.p_renamed = -1;
        this.q_renamed = new java.util.HashMap<>();
        this.r_renamed = -1;
        this.s_renamed = -1;
        this.f751c = -1;
        this.d_renamed = -1;
        this.e_renamed = 0;
        this.f_renamed = 0;
        b_renamed(attributeSet);
    }

    public ConstraintLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        super(context, attributeSet, i_renamed);
        this.f749a = new android.util.SparseArray<>();
        this.g_renamed = new java.util.ArrayList<>(4);
        this.h_renamed = new java.util.ArrayList<>(100);
        this.f750b = new androidx.constraintlayout.a_renamed.a_renamed.g_renamed();
        this.i_renamed = 0;
        this.j_renamed = 0;
        this.k_renamed = Integer.MAX_VALUE;
        this.l_renamed = Integer.MAX_VALUE;
        this.m_renamed = true;
        this.n_renamed = 7;
        this.o_renamed = null;
        this.p_renamed = -1;
        this.q_renamed = new java.util.HashMap<>();
        this.r_renamed = -1;
        this.s_renamed = -1;
        this.f751c = -1;
        this.d_renamed = -1;
        this.e_renamed = 0;
        this.f_renamed = 0;
        b_renamed(attributeSet);
    }

    @Override // android.view.View
    public void setId(int i_renamed) {
        this.f749a.remove(getId());
        super.setId(i_renamed);
        this.f749a.put(getId(), this);
    }

    private void b_renamed(android.util.AttributeSet attributeSet) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        this.f750b.a_renamed(this);
        this.f749a.put(getId(), this);
        this.o_renamed = null;
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i_renamed = 0; i_renamed < indexCount; i_renamed++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i_renamed);
                if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.i_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.i_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.j_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.j_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.k_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.k_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.l_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.l_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.n_renamed = typedArrayObtainStyledAttributes.getInt(index, this.n_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.o_renamed = new androidx.constraintlayout.widget.c_renamed();
                        this.o_renamed.a_renamed(getContext(), resourceId);
                    } catch (android.content.res.Resources.NotFoundException unused) {
                        this.o_renamed = null;
                    }
                    this.p_renamed = resourceId;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f750b.a_renamed(this.n_renamed);
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i_renamed, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i_renamed, layoutParams);
        if (android.os.Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(android.view.View view) {
        super.removeView(view);
        if (android.os.Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarA = a_renamed(view);
        if ((view instanceof androidx.constraintlayout.widget.e_renamed) && !(fVarA instanceof androidx.constraintlayout.a_renamed.a_renamed.i_renamed)) {
            androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) view.getLayoutParams();
            aVar.al_renamed = new androidx.constraintlayout.a_renamed.a_renamed.i_renamed();
            aVar.Y_renamed = true;
            ((androidx.constraintlayout.a_renamed.a_renamed.i_renamed) aVar.al_renamed).a_renamed(aVar.S_renamed);
        }
        if (view instanceof androidx.constraintlayout.widget.b_renamed) {
            androidx.constraintlayout.widget.b_renamed bVar = (androidx.constraintlayout.widget.b_renamed) view;
            bVar.b_renamed();
            ((androidx.constraintlayout.widget.ConstraintLayout.a_renamed) view.getLayoutParams()).Z_renamed = true;
            if (!this.g_renamed.contains(bVar)) {
                this.g_renamed.add(bVar);
            }
        }
        this.f749a.put(view.getId(), view);
        this.m_renamed = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f749a.remove(view.getId());
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarA = a_renamed(view);
        this.f750b.c_renamed(fVarA);
        this.g_renamed.remove(view);
        this.h_renamed.remove(fVarA);
        this.m_renamed = true;
    }

    public void setMinWidth(int i_renamed) {
        if (i_renamed == this.i_renamed) {
            return;
        }
        this.i_renamed = i_renamed;
        requestLayout();
    }

    public void setMinHeight(int i_renamed) {
        if (i_renamed == this.j_renamed) {
            return;
        }
        this.j_renamed = i_renamed;
        requestLayout();
    }

    public int getMinWidth() {
        return this.i_renamed;
    }

    public int getMinHeight() {
        return this.j_renamed;
    }

    public void setMaxWidth(int i_renamed) {
        if (i_renamed == this.k_renamed) {
            return;
        }
        this.k_renamed = i_renamed;
        requestLayout();
    }

    public void setMaxHeight(int i_renamed) {
        if (i_renamed == this.l_renamed) {
            return;
        }
        this.l_renamed = i_renamed;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.k_renamed;
    }

    public int getMaxHeight() {
        return this.l_renamed;
    }

    private void b_renamed() throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException {
        int childCount = getChildCount();
        boolean z_renamed = false;
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= childCount) {
                break;
            }
            if (getChildAt(i_renamed).isLayoutRequested()) {
                z_renamed = true;
                break;
            }
            i_renamed++;
        }
        if (z_renamed) {
            this.h_renamed.clear();
            c_renamed();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r26v0, types: [androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v67 */
    private void c_renamed() throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException {
        int i_renamed;
        int i2;
        int i3;
        float f_renamed;
        int i4;
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarB;
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarB2;
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarB3;
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarB4;
        int i5;
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        ?? r3 = 0;
        if (zIsInEditMode) {
            for (int i6 = 0; i6 < childCount; i6++) {
                android.view.View childAt = getChildAt(i6);
                try {
                    java.lang.String resourceName = getResources().getResourceName(childAt.getId());
                    a_renamed(0, resourceName, java.lang.Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    b_renamed(childAt.getId()).a_renamed(resourceName);
                } catch (android.content.res.Resources.NotFoundException unused) {
                }
            }
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarA = a_renamed(getChildAt(i7));
            if (fVarA != null) {
                fVarA.g_renamed();
            }
        }
        if (this.p_renamed != -1) {
            for (int i8 = 0; i8 < childCount; i8++) {
                android.view.View childAt2 = getChildAt(i8);
                if (childAt2.getId() == this.p_renamed && (childAt2 instanceof androidx.constraintlayout.widget.d_renamed)) {
                    this.o_renamed = ((androidx.constraintlayout.widget.d_renamed) childAt2).getConstraintSet();
                }
            }
        }
        androidx.constraintlayout.widget.c_renamed cVar = this.o_renamed;
        if (cVar != null) {
            cVar.c_renamed(this);
        }
        this.f750b.U_renamed();
        int size = this.g_renamed.size();
        if (size > 0) {
            for (int i9 = 0; i9 < size; i9++) {
                this.g_renamed.get(i9).a_renamed((androidx.constraintlayout.widget.ConstraintLayout) this);
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            android.view.View childAt3 = getChildAt(i10);
            if (childAt3 instanceof androidx.constraintlayout.widget.f_renamed) {
                ((androidx.constraintlayout.widget.f_renamed) childAt3).a_renamed(this);
            }
        }
        int i11 = 0;
        while (i11 < childCount) {
            android.view.View childAt4 = getChildAt(i11);
            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarA2 = a_renamed(childAt4);
            if (fVarA2 != null) {
                androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) childAt4.getLayoutParams();
                aVar.a_renamed();
                if (aVar.am_renamed) {
                    aVar.am_renamed = r3;
                } else if (zIsInEditMode) {
                    try {
                        java.lang.String resourceName2 = getResources().getResourceName(childAt4.getId());
                        a_renamed(r3, resourceName2, java.lang.Integer.valueOf(childAt4.getId()));
                        b_renamed(childAt4.getId()).a_renamed(resourceName2.substring(resourceName2.indexOf("id_renamed/") + 3));
                    } catch (android.content.res.Resources.NotFoundException unused2) {
                    }
                }
                fVarA2.e_renamed(childAt4.getVisibility());
                if (aVar.aa_renamed) {
                    fVarA2.e_renamed(8);
                }
                fVarA2.a_renamed(childAt4);
                this.f750b.b_renamed(fVarA2);
                if (!aVar.W_renamed || !aVar.V_renamed) {
                    this.h_renamed.add(fVarA2);
                }
                if (aVar.Y_renamed) {
                    androidx.constraintlayout.a_renamed.a_renamed.i_renamed iVar = (androidx.constraintlayout.a_renamed.a_renamed.i_renamed) fVarA2;
                    int i12 = aVar.ai_renamed;
                    int i13 = aVar.aj_renamed;
                    float f2 = aVar.ak_renamed;
                    if (android.os.Build.VERSION.SDK_INT < 17) {
                        i12 = aVar.f752a;
                        i13 = aVar.f753b;
                        f2 = aVar.f754c;
                    }
                    if (f2 != -1.0f) {
                        iVar.e_renamed(f2);
                    } else if (i12 != -1) {
                        iVar.u_renamed(i12);
                    } else if (i13 != -1) {
                        iVar.v_renamed(i13);
                    }
                } else if (aVar.d_renamed != -1 || aVar.e_renamed != -1 || aVar.f_renamed != -1 || aVar.g_renamed != -1 || aVar.q_renamed != -1 || aVar.p_renamed != -1 || aVar.r_renamed != -1 || aVar.s_renamed != -1 || aVar.h_renamed != -1 || aVar.i_renamed != -1 || aVar.j_renamed != -1 || aVar.k_renamed != -1 || aVar.l_renamed != -1 || aVar.Q_renamed != -1 || aVar.R_renamed != -1 || aVar.m_renamed != -1 || aVar.width == -1 || aVar.height == -1) {
                    int i14 = aVar.ab_renamed;
                    int i15 = aVar.ac_renamed;
                    int i16 = aVar.ad_renamed;
                    int i17 = aVar.ae_renamed;
                    int i18 = aVar.af_renamed;
                    int i19 = aVar.ag_renamed;
                    float f3 = aVar.ah_renamed;
                    if (android.os.Build.VERSION.SDK_INT < 17) {
                        int i20 = aVar.d_renamed;
                        int i21 = aVar.e_renamed;
                        i16 = aVar.f_renamed;
                        i17 = aVar.g_renamed;
                        int i22 = aVar.t_renamed;
                        int i23 = aVar.v_renamed;
                        f3 = aVar.z_renamed;
                        if (i20 == -1 && i21 == -1) {
                            if (aVar.q_renamed != -1) {
                                i20 = aVar.q_renamed;
                            } else if (aVar.p_renamed != -1) {
                                i21 = aVar.p_renamed;
                            }
                        }
                        int i24 = i21;
                        i14 = i20;
                        i_renamed = i24;
                        if (i16 == -1 && i17 == -1) {
                            if (aVar.r_renamed != -1) {
                                i16 = aVar.r_renamed;
                            } else if (aVar.s_renamed != -1) {
                                i17 = aVar.s_renamed;
                            }
                        }
                        i3 = i22;
                        i2 = i23;
                    } else {
                        i_renamed = i15;
                        i2 = i19;
                        i3 = i18;
                    }
                    int i25 = i17;
                    float f4 = f3;
                    int i26 = i16;
                    if (aVar.m_renamed != -1) {
                        androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarB5 = b_renamed(aVar.m_renamed);
                        if (fVarB5 != null) {
                            fVarA2.a_renamed(fVarB5, aVar.o_renamed, aVar.n_renamed);
                        }
                    } else {
                        if (i14 != -1) {
                            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarB6 = b_renamed(i14);
                            if (fVarB6 != null) {
                                f_renamed = f4;
                                i5 = i25;
                                fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.LEFT, fVarB6, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.LEFT, aVar.leftMargin, i3);
                            } else {
                                f_renamed = f4;
                                i5 = i25;
                            }
                            i4 = i5;
                        } else {
                            f_renamed = f4;
                            i4 = i25;
                            if (i_renamed != -1 && (fVarB = b_renamed(i_renamed)) != null) {
                                fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.LEFT, fVarB, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT, aVar.leftMargin, i3);
                            }
                        }
                        if (i26 != -1) {
                            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarB7 = b_renamed(i26);
                            if (fVarB7 != null) {
                                fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT, fVarB7, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.LEFT, aVar.rightMargin, i2);
                            }
                        } else if (i4 != -1 && (fVarB2 = b_renamed(i4)) != null) {
                            fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT, fVarB2, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT, aVar.rightMargin, i2);
                        }
                        if (aVar.h_renamed != -1) {
                            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarB8 = b_renamed(aVar.h_renamed);
                            if (fVarB8 != null) {
                                fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.TOP, fVarB8, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.TOP, aVar.topMargin, aVar.u_renamed);
                            }
                        } else if (aVar.i_renamed != -1 && (fVarB3 = b_renamed(aVar.i_renamed)) != null) {
                            fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.TOP, fVarB3, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM, aVar.topMargin, aVar.u_renamed);
                        }
                        if (aVar.j_renamed != -1) {
                            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarB9 = b_renamed(aVar.j_renamed);
                            if (fVarB9 != null) {
                                fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM, fVarB9, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.TOP, aVar.bottomMargin, aVar.w_renamed);
                            }
                        } else if (aVar.k_renamed != -1 && (fVarB4 = b_renamed(aVar.k_renamed)) != null) {
                            fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM, fVarB4, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM, aVar.bottomMargin, aVar.w_renamed);
                        }
                        if (aVar.l_renamed != -1) {
                            android.view.View view = this.f749a.get(aVar.l_renamed);
                            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarB10 = b_renamed(aVar.l_renamed);
                            if (fVarB10 != null && view != null && (view.getLayoutParams() instanceof androidx.constraintlayout.widget.ConstraintLayout.a_renamed)) {
                                androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar2 = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) view.getLayoutParams();
                                aVar.X_renamed = true;
                                aVar2.X_renamed = true;
                                fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BASELINE).a_renamed(fVarB10.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BASELINE), 0, -1, androidx.constraintlayout.a_renamed.a_renamed.e_renamed.b_renamed.STRONG, 0, true);
                                fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.TOP).i_renamed();
                                fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM).i_renamed();
                            }
                        }
                        float f5 = f_renamed;
                        if (f5 >= 0.0f && f5 != 0.5f) {
                            fVarA2.a_renamed(f5);
                        }
                        if (aVar.A_renamed >= 0.0f && aVar.A_renamed != 0.5f) {
                            fVarA2.b_renamed(aVar.A_renamed);
                        }
                    }
                    if (zIsInEditMode && (aVar.Q_renamed != -1 || aVar.R_renamed != -1)) {
                        fVarA2.a_renamed(aVar.Q_renamed, aVar.R_renamed);
                    }
                    if (!aVar.V_renamed) {
                        if (aVar.width == -1) {
                            fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_PARENT);
                            fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.LEFT).d_renamed = aVar.leftMargin;
                            fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.RIGHT).d_renamed = aVar.rightMargin;
                        } else {
                            fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT);
                            fVarA2.j_renamed(0);
                        }
                    } else {
                        fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED);
                        fVarA2.j_renamed(aVar.width);
                    }
                    if (!aVar.W_renamed) {
                        if (aVar.height == -1) {
                            fVarA2.b_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_PARENT);
                            fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.TOP).d_renamed = aVar.topMargin;
                            fVarA2.a_renamed(androidx.constraintlayout.a_renamed.a_renamed.e_renamed.c_renamed.BOTTOM).d_renamed = aVar.bottomMargin;
                            r3 = 0;
                        } else {
                            fVarA2.b_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.MATCH_CONSTRAINT);
                            r3 = 0;
                            fVarA2.k_renamed(0);
                        }
                    } else {
                        r3 = 0;
                        fVarA2.b_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED);
                        fVarA2.k_renamed(aVar.height);
                    }
                    if (aVar.B_renamed != null) {
                        fVarA2.b_renamed(aVar.B_renamed);
                    }
                    fVarA2.c_renamed(aVar.E_renamed);
                    fVarA2.d_renamed(aVar.F_renamed);
                    fVarA2.r_renamed(aVar.G_renamed);
                    fVarA2.s_renamed(aVar.H_renamed);
                    fVarA2.a_renamed(aVar.I_renamed, aVar.K_renamed, aVar.M_renamed, aVar.O_renamed);
                    fVarA2.b_renamed(aVar.J_renamed, aVar.L_renamed, aVar.N_renamed, aVar.P_renamed);
                }
            }
            i11++;
            r3 = r3;
        }
    }

    private final androidx.constraintlayout.a_renamed.a_renamed.f_renamed b_renamed(int i_renamed) {
        if (i_renamed == 0) {
            return this.f750b;
        }
        android.view.View viewFindViewById = this.f749a.get(i_renamed);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i_renamed)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f750b;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((androidx.constraintlayout.widget.ConstraintLayout.a_renamed) viewFindViewById.getLayoutParams()).al_renamed;
    }

    public final androidx.constraintlayout.a_renamed.a_renamed.f_renamed a_renamed(android.view.View view) {
        if (view == this) {
            return this.f750b;
        }
        if (view == null) {
            return null;
        }
        return ((androidx.constraintlayout.widget.ConstraintLayout.a_renamed) view.getLayoutParams()).al_renamed;
    }

    private void a_renamed(int i_renamed, int i2) {
        boolean z_renamed;
        boolean z2;
        int baseline;
        int childMeasureSpec;
        int childMeasureSpec2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            android.view.View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) childAt.getLayoutParams();
                androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar = aVar.al_renamed;
                if (!aVar.Y_renamed && !aVar.Z_renamed) {
                    fVar.e_renamed(childAt.getVisibility());
                    int measuredWidth = aVar.width;
                    int measuredHeight = aVar.height;
                    if (aVar.V_renamed || aVar.W_renamed || (!aVar.V_renamed && aVar.I_renamed == 1) || aVar.width == -1 || (!aVar.W_renamed && (aVar.J_renamed == 1 || aVar.height == -1))) {
                        if (measuredWidth == 0) {
                            childMeasureSpec = getChildMeasureSpec(i_renamed, paddingLeft, -2);
                            z_renamed = true;
                        } else if (measuredWidth == -1) {
                            childMeasureSpec = getChildMeasureSpec(i_renamed, paddingLeft, -1);
                            z_renamed = false;
                        } else {
                            z_renamed = measuredWidth == -2;
                            childMeasureSpec = getChildMeasureSpec(i_renamed, paddingLeft, measuredWidth);
                        }
                        if (measuredHeight == 0) {
                            z2 = true;
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, -2);
                        } else if (measuredHeight == -1) {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, -1);
                            z2 = false;
                        } else {
                            z2 = measuredHeight == -2;
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, measuredHeight);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        androidx.constraintlayout.a_renamed.f_renamed fVar2 = this.t_renamed;
                        if (fVar2 != null) {
                            fVar2.f741a++;
                        }
                        fVar.b_renamed(measuredWidth == -2);
                        fVar.c_renamed(measuredHeight == -2);
                        measuredWidth = childAt.getMeasuredWidth();
                        measuredHeight = childAt.getMeasuredHeight();
                    } else {
                        z_renamed = false;
                        z2 = false;
                    }
                    fVar.j_renamed(measuredWidth);
                    fVar.k_renamed(measuredHeight);
                    if (z_renamed) {
                        fVar.n_renamed(measuredWidth);
                    }
                    if (z2) {
                        fVar.o_renamed(measuredHeight);
                    }
                    if (aVar.X_renamed && (baseline = childAt.getBaseline()) != -1) {
                        fVar.q_renamed(baseline);
                    }
                }
            }
        }
    }

    private void d_renamed() {
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if (childAt instanceof androidx.constraintlayout.widget.f_renamed) {
                ((androidx.constraintlayout.widget.f_renamed) childAt).b_renamed(this);
            }
        }
        int size = this.g_renamed.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.g_renamed.get(i2).c_renamed(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:117:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:127:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:137:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:138:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:141:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:142:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:145:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:146:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:149:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:151:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:153:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:154:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:156:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:157:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:160:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:163:0x02cc A_renamed[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:164:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:52:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b_renamed(int r24, int r25) {
        /*
            Method dump skipped, instructions count: 739
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b_renamed(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:61:0x0133 A_renamed[PHI: r10
      0x0133: PHI (r10v3 boolean) = (r10v2 boolean), (r10v26 boolean), (r10v26 boolean) binds: [B_renamed:41:0x00de, B_renamed:57:0x0122, B_renamed:59:0x0128] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r25, int r26) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 967
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    private void c_renamed(int i_renamed, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i_renamed);
        int size = android.view.View.MeasureSpec.getSize(i_renamed);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed aVar = androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED;
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed aVar2 = androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                aVar = androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT;
            } else if (mode == 1073741824) {
                size = java.lang.Math.min(this.k_renamed, size) - paddingLeft;
            }
            size = 0;
        } else {
            aVar = androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                aVar2 = androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = java.lang.Math.min(this.l_renamed, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            aVar2 = androidx.constraintlayout.a_renamed.a_renamed.f_renamed.a_renamed.WRAP_CONTENT;
        }
        this.f750b.l_renamed(0);
        this.f750b.m_renamed(0);
        this.f750b.a_renamed(aVar);
        this.f750b.j_renamed(size);
        this.f750b.b_renamed(aVar2);
        this.f750b.k_renamed(size2);
        this.f750b.l_renamed((this.i_renamed - getPaddingLeft()) - getPaddingRight());
        this.f750b.m_renamed((this.j_renamed - getPaddingTop()) - getPaddingBottom());
    }

    protected void a_renamed(java.lang.String str) {
        this.f750b.N_renamed();
        androidx.constraintlayout.a_renamed.f_renamed fVar = this.t_renamed;
        if (fVar != null) {
            fVar.f743c++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        android.view.View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            android.view.View childAt = getChildAt(i5);
            androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) childAt.getLayoutParams();
            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar = aVar.al_renamed;
            if ((childAt.getVisibility() != 8 || aVar.Y_renamed || aVar.Z_renamed || zIsInEditMode) && !aVar.aa_renamed) {
                int iU = fVar.u_renamed();
                int iV = fVar.v_renamed();
                int iQ = fVar.q_renamed() + iU;
                int iS = fVar.s_renamed() + iV;
                childAt.layout(iU, iV, iQ, iS);
                if ((childAt instanceof androidx.constraintlayout.widget.f_renamed) && (content = ((androidx.constraintlayout.widget.f_renamed) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iU, iV, iQ, iS);
                }
            }
        }
        int size = this.g_renamed.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.g_renamed.get(i6).b_renamed(this);
            }
        }
    }

    public void setOptimizationLevel(int i_renamed) {
        this.f750b.a_renamed(i_renamed);
    }

    public int getOptimizationLevel() {
        return this.f750b.b_renamed();
    }

    @Override // android.view.ViewGroup
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.constraintlayout.widget.ConstraintLayout.a_renamed generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new androidx.constraintlayout.widget.ConstraintLayout.a_renamed(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.constraintlayout.widget.ConstraintLayout.a_renamed generateDefaultLayoutParams() {
        return new androidx.constraintlayout.widget.ConstraintLayout.a_renamed(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new androidx.constraintlayout.widget.ConstraintLayout.a_renamed(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof androidx.constraintlayout.widget.ConstraintLayout.a_renamed;
    }

    public void setConstraintSet(androidx.constraintlayout.widget.c_renamed cVar) {
        this.o_renamed = cVar;
    }

    public android.view.View a_renamed(int i_renamed) {
        return this.f749a.get(i_renamed);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(android.graphics.Canvas canvas) throws java.lang.NumberFormatException {
        java.lang.Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                android.view.View childAt = getChildAt(i_renamed);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof java.lang.String)) {
                    java.lang.String[] strArrSplit = ((java.lang.String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i2 = java.lang.Integer.parseInt(strArrSplit[0]);
                        int i3 = java.lang.Integer.parseInt(strArrSplit[1]);
                        int i4 = java.lang.Integer.parseInt(strArrSplit[2]);
                        int i5 = (int) ((i2 / 1080.0f) * width);
                        int i6 = (int) ((i3 / 1920.0f) * height);
                        android.graphics.Paint paint = new android.graphics.Paint();
                        paint.setColor(-65536);
                        float f_renamed = i5;
                        float f2 = i6;
                        float f3 = i5 + ((int) ((i4 / 1080.0f) * width));
                        canvas.drawLine(f_renamed, f2, f3, f2, paint);
                        float f4 = i6 + ((int) ((java.lang.Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, f4, paint);
                        canvas.drawLine(f3, f4, f_renamed, f4, paint);
                        canvas.drawLine(f_renamed, f4, f_renamed, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f_renamed, f2, f3, f4, paint);
                        canvas.drawLine(f_renamed, f4, f3, f2, paint);
                    }
                }
            }
        }
    }

    public static class a_renamed extends android.view.ViewGroup.MarginLayoutParams {
        public float A_renamed;
        public java.lang.String B_renamed;
        float C_renamed;
        int D_renamed;
        public float E_renamed;
        public float F_renamed;
        public int G_renamed;
        public int H_renamed;
        public int I_renamed;
        public int J_renamed;
        public int K_renamed;
        public int L_renamed;
        public int M_renamed;
        public int N_renamed;
        public float O_renamed;
        public float P_renamed;
        public int Q_renamed;
        public int R_renamed;
        public int S_renamed;
        public boolean T_renamed;
        public boolean U_renamed;
        boolean V_renamed;
        boolean W_renamed;
        boolean X_renamed;
        boolean Y_renamed;
        boolean Z_renamed;

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f752a;
        boolean aa_renamed;
        int ab_renamed;
        int ac_renamed;
        int ad_renamed;
        int ae_renamed;
        int af_renamed;
        int ag_renamed;
        float ah_renamed;
        int ai_renamed;
        int aj_renamed;
        float ak_renamed;
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed al_renamed;
        public boolean am_renamed;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f753b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public float f754c;
        public int d_renamed;
        public int e_renamed;
        public int f_renamed;
        public int g_renamed;
        public int h_renamed;
        public int i_renamed;
        public int j_renamed;
        public int k_renamed;
        public int l_renamed;
        public int m_renamed;
        public int n_renamed;
        public float o_renamed;
        public int p_renamed;
        public int q_renamed;
        public int r_renamed;
        public int s_renamed;
        public int t_renamed;
        public int u_renamed;
        public int v_renamed;
        public int w_renamed;
        public int x_renamed;
        public int y_renamed;
        public float z_renamed;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a_renamed$a_renamed, reason: collision with other inner class name */
        private static class C0012a {

            /* renamed from: a_renamed, reason: collision with root package name */
            public static final android.util.SparseIntArray f755a = new android.util.SparseIntArray();

            static {
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_android_orientation, 1);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f755a.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public a_renamed(android.content.Context context, android.util.AttributeSet attributeSet) throws java.lang.NumberFormatException {
            int i_renamed;
            super(context, attributeSet);
            this.f752a = -1;
            this.f753b = -1;
            this.f754c = -1.0f;
            this.d_renamed = -1;
            this.e_renamed = -1;
            this.f_renamed = -1;
            this.g_renamed = -1;
            this.h_renamed = -1;
            this.i_renamed = -1;
            this.j_renamed = -1;
            this.k_renamed = -1;
            this.l_renamed = -1;
            this.m_renamed = -1;
            this.n_renamed = 0;
            this.o_renamed = 0.0f;
            this.p_renamed = -1;
            this.q_renamed = -1;
            this.r_renamed = -1;
            this.s_renamed = -1;
            this.t_renamed = -1;
            this.u_renamed = -1;
            this.v_renamed = -1;
            this.w_renamed = -1;
            this.x_renamed = -1;
            this.y_renamed = -1;
            this.z_renamed = 0.5f;
            this.A_renamed = 0.5f;
            this.B_renamed = null;
            this.C_renamed = 0.0f;
            this.D_renamed = 1;
            this.E_renamed = -1.0f;
            this.F_renamed = -1.0f;
            this.G_renamed = 0;
            this.H_renamed = 0;
            this.I_renamed = 0;
            this.J_renamed = 0;
            this.K_renamed = 0;
            this.L_renamed = 0;
            this.M_renamed = 0;
            this.N_renamed = 0;
            this.O_renamed = 1.0f;
            this.P_renamed = 1.0f;
            this.Q_renamed = -1;
            this.R_renamed = -1;
            this.S_renamed = -1;
            this.T_renamed = false;
            this.U_renamed = false;
            this.V_renamed = true;
            this.W_renamed = true;
            this.X_renamed = false;
            this.Y_renamed = false;
            this.Z_renamed = false;
            this.aa_renamed = false;
            this.ab_renamed = -1;
            this.ac_renamed = -1;
            this.ad_renamed = -1;
            this.ae_renamed = -1;
            this.af_renamed = -1;
            this.ag_renamed = -1;
            this.ah_renamed = 0.5f;
            this.al_renamed = new androidx.constraintlayout.a_renamed.a_renamed.f_renamed();
            this.am_renamed = false;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                switch (androidx.constraintlayout.widget.ConstraintLayout.a_renamed.C0012a.f755a.get(index)) {
                    case 1:
                        this.S_renamed = typedArrayObtainStyledAttributes.getInt(index, this.S_renamed);
                        break;
                    case 2:
                        this.m_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.m_renamed);
                        if (this.m_renamed == -1) {
                            this.m_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.n_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.n_renamed);
                        break;
                    case 4:
                        this.o_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.o_renamed) % 360.0f;
                        float f_renamed = this.o_renamed;
                        if (f_renamed < 0.0f) {
                            this.o_renamed = (360.0f - f_renamed) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f752a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f752a);
                        break;
                    case 6:
                        this.f753b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f753b);
                        break;
                    case 7:
                        this.f754c = typedArrayObtainStyledAttributes.getFloat(index, this.f754c);
                        break;
                    case 8:
                        this.d_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.d_renamed);
                        if (this.d_renamed == -1) {
                            this.d_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        this.e_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.e_renamed);
                        if (this.e_renamed == -1) {
                            this.e_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        this.f_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.f_renamed);
                        if (this.f_renamed == -1) {
                            this.f_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        this.g_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.g_renamed);
                        if (this.g_renamed == -1) {
                            this.g_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        this.h_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.h_renamed);
                        if (this.h_renamed == -1) {
                            this.h_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        this.i_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.i_renamed);
                        if (this.i_renamed == -1) {
                            this.i_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        this.j_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.j_renamed);
                        if (this.j_renamed == -1) {
                            this.j_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        this.k_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.k_renamed);
                        if (this.k_renamed == -1) {
                            this.k_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        this.l_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.l_renamed);
                        if (this.l_renamed == -1) {
                            this.l_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        this.p_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.p_renamed);
                        if (this.p_renamed == -1) {
                            this.p_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        this.q_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.q_renamed);
                        if (this.q_renamed == -1) {
                            this.q_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        this.r_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.r_renamed);
                        if (this.r_renamed == -1) {
                            this.r_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        this.s_renamed = typedArrayObtainStyledAttributes.getResourceId(index, this.s_renamed);
                        if (this.s_renamed == -1) {
                            this.s_renamed = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.t_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.t_renamed);
                        break;
                    case 22:
                        this.u_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.u_renamed);
                        break;
                    case 23:
                        this.v_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.v_renamed);
                        break;
                    case 24:
                        this.w_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.w_renamed);
                        break;
                    case 25:
                        this.x_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.x_renamed);
                        break;
                    case 26:
                        this.y_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.y_renamed);
                        break;
                    case 27:
                        this.T_renamed = typedArrayObtainStyledAttributes.getBoolean(index, this.T_renamed);
                        break;
                    case 28:
                        this.U_renamed = typedArrayObtainStyledAttributes.getBoolean(index, this.U_renamed);
                        break;
                    case 29:
                        this.z_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.z_renamed);
                        break;
                    case 30:
                        this.A_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.A_renamed);
                        break;
                    case 31:
                        this.I_renamed = typedArrayObtainStyledAttributes.getInt(index, 0);
                        if (this.I_renamed == 1) {
                            android.util.Log.e_renamed("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is_renamed deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        this.J_renamed = typedArrayObtainStyledAttributes.getInt(index, 0);
                        if (this.J_renamed == 1) {
                            android.util.Log.e_renamed("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is_renamed deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.K_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K_renamed);
                            break;
                        } catch (java.lang.Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.K_renamed) == -2) {
                                this.K_renamed = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.M_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M_renamed);
                            break;
                        } catch (java.lang.Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.M_renamed) == -2) {
                                this.M_renamed = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.O_renamed = java.lang.Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.O_renamed));
                        break;
                    case 36:
                        try {
                            this.L_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L_renamed);
                            break;
                        } catch (java.lang.Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.L_renamed) == -2) {
                                this.L_renamed = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.N_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N_renamed);
                            break;
                        } catch (java.lang.Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.N_renamed) == -2) {
                                this.N_renamed = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.P_renamed = java.lang.Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.P_renamed));
                        break;
                    case 44:
                        this.B_renamed = typedArrayObtainStyledAttributes.getString(index);
                        this.C_renamed = Float.NaN;
                        this.D_renamed = -1;
                        java.lang.String str = this.B_renamed;
                        if (str != null) {
                            int length = str.length();
                            int iIndexOf = this.B_renamed.indexOf(44);
                            if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                i_renamed = 0;
                            } else {
                                java.lang.String strSubstring = this.B_renamed.substring(0, iIndexOf);
                                if (strSubstring.equalsIgnoreCase(com.oplus.exif.OplusExifInterface.GpsLongitudeRef.WEST)) {
                                    this.D_renamed = 0;
                                } else if (strSubstring.equalsIgnoreCase("H_renamed")) {
                                    this.D_renamed = 1;
                                }
                                i_renamed = iIndexOf + 1;
                            }
                            int iIndexOf2 = this.B_renamed.indexOf(58);
                            if (iIndexOf2 >= 0 && iIndexOf2 < length - 1) {
                                java.lang.String strSubstring2 = this.B_renamed.substring(i_renamed, iIndexOf2);
                                java.lang.String strSubstring3 = this.B_renamed.substring(iIndexOf2 + 1);
                                if (strSubstring2.length() <= 0 || strSubstring3.length() <= 0) {
                                    break;
                                } else {
                                    try {
                                        float f2 = java.lang.Float.parseFloat(strSubstring2);
                                        float f3 = java.lang.Float.parseFloat(strSubstring3);
                                        if (f2 <= 0.0f || f3 <= 0.0f) {
                                            break;
                                        } else if (this.D_renamed == 1) {
                                            this.C_renamed = java.lang.Math.abs(f3 / f2);
                                            break;
                                        } else {
                                            this.C_renamed = java.lang.Math.abs(f2 / f3);
                                            break;
                                        }
                                    } catch (java.lang.NumberFormatException unused5) {
                                        break;
                                    }
                                }
                            } else {
                                java.lang.String strSubstring4 = this.B_renamed.substring(i_renamed);
                                if (strSubstring4.length() > 0) {
                                    this.C_renamed = java.lang.Float.parseFloat(strSubstring4);
                                    break;
                                } else {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                        break;
                    case 45:
                        this.E_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.E_renamed);
                        break;
                    case 46:
                        this.F_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.F_renamed);
                        break;
                    case 47:
                        this.G_renamed = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.H_renamed = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 49:
                        this.Q_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.Q_renamed);
                        break;
                    case 50:
                        this.R_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.R_renamed);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a_renamed();
        }

        public void a_renamed() {
            this.Y_renamed = false;
            this.V_renamed = true;
            this.W_renamed = true;
            if (this.width == -2 && this.T_renamed) {
                this.V_renamed = false;
                this.I_renamed = 1;
            }
            if (this.height == -2 && this.U_renamed) {
                this.W_renamed = false;
                this.J_renamed = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.V_renamed = false;
                if (this.width == 0 && this.I_renamed == 1) {
                    this.width = -2;
                    this.T_renamed = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.W_renamed = false;
                if (this.height == 0 && this.J_renamed == 1) {
                    this.height = -2;
                    this.U_renamed = true;
                }
            }
            if (this.f754c == -1.0f && this.f752a == -1 && this.f753b == -1) {
                return;
            }
            this.Y_renamed = true;
            this.V_renamed = true;
            this.W_renamed = true;
            if (!(this.al_renamed instanceof androidx.constraintlayout.a_renamed.a_renamed.i_renamed)) {
                this.al_renamed = new androidx.constraintlayout.a_renamed.a_renamed.i_renamed();
            }
            ((androidx.constraintlayout.a_renamed.a_renamed.i_renamed) this.al_renamed).a_renamed(this.S_renamed);
        }

        public a_renamed(int i_renamed, int i2) {
            super(i_renamed, i2);
            this.f752a = -1;
            this.f753b = -1;
            this.f754c = -1.0f;
            this.d_renamed = -1;
            this.e_renamed = -1;
            this.f_renamed = -1;
            this.g_renamed = -1;
            this.h_renamed = -1;
            this.i_renamed = -1;
            this.j_renamed = -1;
            this.k_renamed = -1;
            this.l_renamed = -1;
            this.m_renamed = -1;
            this.n_renamed = 0;
            this.o_renamed = 0.0f;
            this.p_renamed = -1;
            this.q_renamed = -1;
            this.r_renamed = -1;
            this.s_renamed = -1;
            this.t_renamed = -1;
            this.u_renamed = -1;
            this.v_renamed = -1;
            this.w_renamed = -1;
            this.x_renamed = -1;
            this.y_renamed = -1;
            this.z_renamed = 0.5f;
            this.A_renamed = 0.5f;
            this.B_renamed = null;
            this.C_renamed = 0.0f;
            this.D_renamed = 1;
            this.E_renamed = -1.0f;
            this.F_renamed = -1.0f;
            this.G_renamed = 0;
            this.H_renamed = 0;
            this.I_renamed = 0;
            this.J_renamed = 0;
            this.K_renamed = 0;
            this.L_renamed = 0;
            this.M_renamed = 0;
            this.N_renamed = 0;
            this.O_renamed = 1.0f;
            this.P_renamed = 1.0f;
            this.Q_renamed = -1;
            this.R_renamed = -1;
            this.S_renamed = -1;
            this.T_renamed = false;
            this.U_renamed = false;
            this.V_renamed = true;
            this.W_renamed = true;
            this.X_renamed = false;
            this.Y_renamed = false;
            this.Z_renamed = false;
            this.aa_renamed = false;
            this.ab_renamed = -1;
            this.ac_renamed = -1;
            this.ad_renamed = -1;
            this.ae_renamed = -1;
            this.af_renamed = -1;
            this.ag_renamed = -1;
            this.ah_renamed = 0.5f;
            this.al_renamed = new androidx.constraintlayout.a_renamed.a_renamed.f_renamed();
            this.am_renamed = false;
        }

        public a_renamed(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f752a = -1;
            this.f753b = -1;
            this.f754c = -1.0f;
            this.d_renamed = -1;
            this.e_renamed = -1;
            this.f_renamed = -1;
            this.g_renamed = -1;
            this.h_renamed = -1;
            this.i_renamed = -1;
            this.j_renamed = -1;
            this.k_renamed = -1;
            this.l_renamed = -1;
            this.m_renamed = -1;
            this.n_renamed = 0;
            this.o_renamed = 0.0f;
            this.p_renamed = -1;
            this.q_renamed = -1;
            this.r_renamed = -1;
            this.s_renamed = -1;
            this.t_renamed = -1;
            this.u_renamed = -1;
            this.v_renamed = -1;
            this.w_renamed = -1;
            this.x_renamed = -1;
            this.y_renamed = -1;
            this.z_renamed = 0.5f;
            this.A_renamed = 0.5f;
            this.B_renamed = null;
            this.C_renamed = 0.0f;
            this.D_renamed = 1;
            this.E_renamed = -1.0f;
            this.F_renamed = -1.0f;
            this.G_renamed = 0;
            this.H_renamed = 0;
            this.I_renamed = 0;
            this.J_renamed = 0;
            this.K_renamed = 0;
            this.L_renamed = 0;
            this.M_renamed = 0;
            this.N_renamed = 0;
            this.O_renamed = 1.0f;
            this.P_renamed = 1.0f;
            this.Q_renamed = -1;
            this.R_renamed = -1;
            this.S_renamed = -1;
            this.T_renamed = false;
            this.U_renamed = false;
            this.V_renamed = true;
            this.W_renamed = true;
            this.X_renamed = false;
            this.Y_renamed = false;
            this.Z_renamed = false;
            this.aa_renamed = false;
            this.ab_renamed = -1;
            this.ac_renamed = -1;
            this.ad_renamed = -1;
            this.ae_renamed = -1;
            this.af_renamed = -1;
            this.ag_renamed = -1;
            this.ah_renamed = 0.5f;
            this.al_renamed = new androidx.constraintlayout.a_renamed.a_renamed.f_renamed();
            this.am_renamed = false;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:22:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:28:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:36:0x0084  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r7) {
            /*
                Method dump skipped, instructions count: 265
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a_renamed.resolveLayoutDirection(int):void");
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.m_renamed = true;
        this.r_renamed = -1;
        this.s_renamed = -1;
        this.f751c = -1;
        this.d_renamed = -1;
        this.e_renamed = 0;
        this.f_renamed = 0;
    }
}
