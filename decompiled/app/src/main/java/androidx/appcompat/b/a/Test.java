package androidx.appcompat.b_renamed.a_renamed;

/* compiled from: StateListDrawable.java */
@android.annotation.SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
class d_renamed extends androidx.appcompat.b_renamed.a_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.appcompat.b_renamed.a_renamed.d_renamed.a_renamed f318a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f319b;

    @Override // androidx.appcompat.b_renamed.a_renamed.b_renamed, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    d_renamed() {
        this(null, null);
    }

    @Override // androidx.appcompat.b_renamed.a_renamed.b_renamed, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iB = this.f318a.b_renamed(iArr);
        if (iB < 0) {
            iB = this.f318a.b_renamed(android.util.StateSet.WILD_CARD);
        }
        return a_renamed(iB) || zOnStateChange;
    }

    public void b_renamed(android.content.Context context, android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        android.content.res.TypedArray typedArrayA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.appcompat.resources.R_renamed.styleable.StateListDrawable);
        setVisible(typedArrayA.getBoolean(androidx.appcompat.resources.R_renamed.styleable.StateListDrawable_android_visible, true), true);
        a_renamed(typedArrayA);
        a_renamed(resources);
        typedArrayA.recycle();
        a_renamed(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    private void a_renamed(android.content.res.TypedArray typedArray) {
        androidx.appcompat.b_renamed.a_renamed.d_renamed.a_renamed aVar = this.f318a;
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            aVar.f_renamed |= typedArray.getChangingConfigurations();
        }
        aVar.k_renamed = typedArray.getBoolean(androidx.appcompat.resources.R_renamed.styleable.StateListDrawable_android_variablePadding, aVar.k_renamed);
        aVar.n_renamed = typedArray.getBoolean(androidx.appcompat.resources.R_renamed.styleable.StateListDrawable_android_constantSize, aVar.n_renamed);
        aVar.C_renamed = typedArray.getInt(androidx.appcompat.resources.R_renamed.styleable.StateListDrawable_android_enterFadeDuration, aVar.C_renamed);
        aVar.D_renamed = typedArray.getInt(androidx.appcompat.resources.R_renamed.styleable.StateListDrawable_android_exitFadeDuration, aVar.D_renamed);
        aVar.z_renamed = typedArray.getBoolean(androidx.appcompat.resources.R_renamed.styleable.StateListDrawable_android_dither, aVar.z_renamed);
    }

    private void a_renamed(android.content.Context context, android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int next;
        androidx.appcompat.b_renamed.a_renamed.d_renamed.a_renamed aVar = this.f318a;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                android.content.res.TypedArray typedArrayA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.appcompat.resources.R_renamed.styleable.StateListDrawableItem);
                int resourceId = typedArrayA.getResourceId(androidx.appcompat.resources.R_renamed.styleable.StateListDrawableItem_android_drawable, -1);
                android.graphics.drawable.Drawable drawableA = resourceId > 0 ? androidx.appcompat.widget.ah_renamed.a_renamed().a_renamed(context, resourceId) : null;
                typedArrayA.recycle();
                int[] iArrA = a_renamed(attributeSet);
                if (drawableA == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new org.xmlpull.v1.XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a_renamed 'drawable' attribute or child tag defining a_renamed drawable");
                    }
                    if (android.os.Build.VERSION.SDK_INT >= 21) {
                        drawableA = android.graphics.drawable.Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                    } else {
                        drawableA = android.graphics.drawable.Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                    }
                }
                aVar.a_renamed(iArrA, drawableA);
            }
        }
    }

    int[] a_renamed(android.util.AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i_renamed = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i_renamed + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i_renamed] = attributeNameResource;
                i_renamed = i3;
            }
        }
        return android.util.StateSet.trimStateSet(iArr, i_renamed);
    }

    @Override // androidx.appcompat.b_renamed.a_renamed.b_renamed, android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable mutate() {
        if (!this.f319b && super.mutate() == this) {
            this.f318a.a_renamed();
            this.f319b = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b_renamed.a_renamed.b_renamed
    /* renamed from: b_renamed */
    public androidx.appcompat.b_renamed.a_renamed.d_renamed.a_renamed c_renamed() {
        return new androidx.appcompat.b_renamed.a_renamed.d_renamed.a_renamed(this.f318a, this, null);
    }

    @Override // androidx.appcompat.b_renamed.a_renamed.b_renamed
    void clearMutated() {
        super.clearMutated();
        this.f319b = false;
    }

    /* compiled from: StateListDrawable.java */
    static class a_renamed extends androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2 {
        int[][] L_renamed;

        a_renamed(androidx.appcompat.b_renamed.a_renamed.d_renamed.a_renamed aVar, androidx.appcompat.b_renamed.a_renamed.d_renamed dVar, android.content.res.Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.L_renamed = aVar.L_renamed;
            } else {
                this.L_renamed = new int[c_renamed()][];
            }
        }

        @Override // androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2
        void a_renamed() {
            int[][] iArr = this.L_renamed;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.L_renamed;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.L_renamed = iArr2;
        }

        int a_renamed(int[] iArr, android.graphics.drawable.Drawable drawable) {
            int iA = a_renamed(drawable);
            this.L_renamed[iA] = iArr;
            return iA;
        }

        int b_renamed(int[] iArr) {
            int[][] iArr2 = this.L_renamed;
            int iD = d_renamed();
            for (int i_renamed = 0; i_renamed < iD; i_renamed++) {
                if (android.util.StateSet.stateSetMatches(iArr2[i_renamed], iArr)) {
                    return i_renamed;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable() {
            return new androidx.appcompat.b_renamed.a_renamed.d_renamed(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            return new androidx.appcompat.b_renamed.a_renamed.d_renamed(this, resources);
        }

        @Override // androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2
        public void e_renamed(int i_renamed, int i2) {
            super.e_renamed(i_renamed, i2);
            int[][] iArr = new int[i2][];
            java.lang.System.arraycopy(this.L_renamed, 0, iArr, 0, i_renamed);
            this.L_renamed = iArr;
        }
    }

    @Override // androidx.appcompat.b_renamed.a_renamed.b_renamed, android.graphics.drawable.Drawable
    public void applyTheme(android.content.res.Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.b_renamed.a_renamed.b_renamed
    void a_renamed(androidx.appcompat.b_renamed.a_renamed.b_renamed.DrawableContainer_2 abstractC0005b) {
        super.a_renamed(abstractC0005b);
        if (abstractC0005b instanceof androidx.appcompat.b_renamed.a_renamed.d_renamed.a_renamed) {
            this.f318a = (androidx.appcompat.b_renamed.a_renamed.d_renamed.a_renamed) abstractC0005b;
        }
    }

    d_renamed(androidx.appcompat.b_renamed.a_renamed.d_renamed.a_renamed aVar, android.content.res.Resources resources) {
        a_renamed(new androidx.appcompat.b_renamed.a_renamed.d_renamed.a_renamed(aVar, this, resources));
        onStateChange(getState());
    }

    d_renamed(androidx.appcompat.b_renamed.a_renamed.d_renamed.a_renamed aVar) {
        if (aVar != null) {
            a_renamed(aVar);
        }
    }
}
