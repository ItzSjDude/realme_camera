package androidx.vectordrawable.a_renamed.a_renamed;

/* compiled from: VectorDrawableCompat.java */
/* loaded from: classes.dex */
public class i_renamed extends androidx.vectordrawable.a_renamed.a_renamed.h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final android.graphics.PorterDuff.Mode f1780a = android.graphics.PorterDuff.Mode.SRC_IN;

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.vectordrawable.a_renamed.a_renamed.i_renamed.g_renamed f1781b;
    private android.graphics.PorterDuffColorFilter d_renamed;
    private android.graphics.ColorFilter e_renamed;
    private boolean f_renamed;
    private boolean g_renamed;
    private android.graphics.drawable.Drawable.ConstantState h_renamed;
    private final float[] i_renamed;
    private final android.graphics.Matrix j_renamed;
    private final android.graphics.Rect k_renamed;

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(android.content.res.Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ android.graphics.drawable.Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(android.graphics.Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ android.graphics.Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i_renamed) {
        super.setChangingConfigurations(i_renamed);
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i_renamed, android.graphics.PorterDuff.Mode mode) {
        super.setColorFilter(i_renamed, mode);
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z_renamed) {
        super.setFilterBitmap(z_renamed);
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i_renamed, int i2, int i3, int i4) {
        super.setHotspotBounds(i_renamed, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    i_renamed() {
        this.g_renamed = true;
        this.i_renamed = new float[9];
        this.j_renamed = new android.graphics.Matrix();
        this.k_renamed = new android.graphics.Rect();
        this.f1781b = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.g_renamed();
    }

    i_renamed(androidx.vectordrawable.a_renamed.a_renamed.i_renamed.g_renamed gVar) {
        this.g_renamed = true;
        this.i_renamed = new float[9];
        this.j_renamed = new android.graphics.Matrix();
        this.k_renamed = new android.graphics.Rect();
        this.f1781b = gVar;
        this.d_renamed = a_renamed(this.d_renamed, gVar.f1793c, gVar.d_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable mutate() {
        if (this.f1779c != null) {
            this.f1779c.mutate();
            return this;
        }
        if (!this.f_renamed && super.mutate() == this) {
            this.f1781b = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.g_renamed(this.f1781b);
            this.f_renamed = true;
        }
        return this;
    }

    java.lang.Object a_renamed(java.lang.String str) {
        return this.f1781b.f1792b.k_renamed.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        if (this.f1779c != null && android.os.Build.VERSION.SDK_INT >= 24) {
            return new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.h_renamed(this.f1779c.getConstantState());
        }
        this.f1781b.f1791a = getChangingConfigurations();
        return this.f1781b;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (this.f1779c != null) {
            this.f1779c.draw(canvas);
            return;
        }
        copyBounds(this.k_renamed);
        if (this.k_renamed.width() <= 0 || this.k_renamed.height() <= 0) {
            return;
        }
        android.graphics.ColorFilter colorFilter = this.e_renamed;
        if (colorFilter == null) {
            colorFilter = this.d_renamed;
        }
        canvas.getMatrix(this.j_renamed);
        this.j_renamed.getValues(this.i_renamed);
        float fAbs = java.lang.Math.abs(this.i_renamed[0]);
        float fAbs2 = java.lang.Math.abs(this.i_renamed[4]);
        float fAbs3 = java.lang.Math.abs(this.i_renamed[1]);
        float fAbs4 = java.lang.Math.abs(this.i_renamed[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = java.lang.Math.min(2048, (int) (this.k_renamed.width() * fAbs));
        int iMin2 = java.lang.Math.min(2048, (int) (this.k_renamed.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.k_renamed.left, this.k_renamed.top);
        if (a_renamed()) {
            canvas.translate(this.k_renamed.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.k_renamed.offsetTo(0, 0);
        this.f1781b.b_renamed(iMin, iMin2);
        if (!this.g_renamed) {
            this.f1781b.a_renamed(iMin, iMin2);
        } else if (!this.f1781b.b_renamed()) {
            this.f1781b.a_renamed(iMin, iMin2);
            this.f1781b.c_renamed();
        }
        this.f1781b.a_renamed(canvas, colorFilter, this.k_renamed);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.f1779c != null) {
            return androidx.core.graphics.drawable.a_renamed.c_renamed(this.f1779c);
        }
        return this.f1781b.f1792b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
        if (this.f1779c != null) {
            this.f1779c.setAlpha(i_renamed);
        } else if (this.f1781b.f1792b.getRootAlpha() != i_renamed) {
            this.f1781b.f1792b.setRootAlpha(i_renamed);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        if (this.f1779c != null) {
            this.f1779c.setColorFilter(colorFilter);
        } else {
            this.e_renamed = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.ColorFilter getColorFilter() {
        if (this.f1779c != null) {
            return androidx.core.graphics.drawable.a_renamed.e_renamed(this.f1779c);
        }
        return this.e_renamed;
    }

    android.graphics.PorterDuffColorFilter a_renamed(android.graphics.PorterDuffColorFilter porterDuffColorFilter, android.content.res.ColorStateList colorStateList, android.graphics.PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new android.graphics.PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTint(int i_renamed) {
        if (this.f1779c != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.f1779c, i_renamed);
        } else {
            setTintList(android.content.res.ColorStateList.valueOf(i_renamed));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintList(android.content.res.ColorStateList colorStateList) {
        if (this.f1779c != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.f1779c, colorStateList);
            return;
        }
        androidx.vectordrawable.a_renamed.a_renamed.i_renamed.g_renamed gVar = this.f1781b;
        if (gVar.f1793c != colorStateList) {
            gVar.f1793c = colorStateList;
            this.d_renamed = a_renamed(this.d_renamed, colorStateList, gVar.d_renamed);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.f1779c != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.f1779c, mode);
            return;
        }
        androidx.vectordrawable.a_renamed.a_renamed.i_renamed.g_renamed gVar = this.f1781b;
        if (gVar.d_renamed != mode) {
            gVar.d_renamed = mode;
            this.d_renamed = a_renamed(this.d_renamed, gVar.f1793c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        androidx.vectordrawable.a_renamed.a_renamed.i_renamed.g_renamed gVar;
        if (this.f1779c != null) {
            return this.f1779c.isStateful();
        }
        return super.isStateful() || ((gVar = this.f1781b) != null && (gVar.d_renamed() || (this.f1781b.f1793c != null && this.f1781b.f1793c.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f1779c != null) {
            return this.f1779c.setState(iArr);
        }
        boolean z_renamed = false;
        androidx.vectordrawable.a_renamed.a_renamed.i_renamed.g_renamed gVar = this.f1781b;
        if (gVar.f1793c != null && gVar.d_renamed != null) {
            this.d_renamed = a_renamed(this.d_renamed, gVar.f1793c, gVar.d_renamed);
            invalidateSelf();
            z_renamed = true;
        }
        if (!gVar.d_renamed() || !gVar.a_renamed(iArr)) {
            return z_renamed;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f1779c != null) {
            return this.f1779c.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f1779c != null) {
            return this.f1779c.getIntrinsicWidth();
        }
        return (int) this.f1781b.f1792b.d_renamed;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f1779c != null) {
            return this.f1779c.getIntrinsicHeight();
        }
        return (int) this.f1781b.f1792b.e_renamed;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f1779c == null) {
            return false;
        }
        androidx.core.graphics.drawable.a_renamed.d_renamed(this.f1779c);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        if (this.f1779c != null) {
            return androidx.core.graphics.drawable.a_renamed.b_renamed(this.f1779c);
        }
        return this.f1781b.e_renamed;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z_renamed) {
        if (this.f1779c != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.f1779c, z_renamed);
        } else {
            this.f1781b.e_renamed = z_renamed;
        }
    }

    public static androidx.vectordrawable.a_renamed.a_renamed.i_renamed a_renamed(android.content.res.Resources resources, int i_renamed, android.content.res.Resources.Theme theme) {
        int next;
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            androidx.vectordrawable.a_renamed.a_renamed.i_renamed iVar = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed();
            iVar.f1779c = androidx.core.a_renamed.a_renamed.f_renamed.a_renamed(resources, i_renamed, theme);
            iVar.h_renamed = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.h_renamed(iVar.f1779c.getConstantState());
            return iVar;
        }
        try {
            android.content.res.XmlResourceParser xml = resources.getXml(i_renamed);
            android.util.AttributeSet attributeSetAsAttributeSet = android.util.Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
            }
            return a_renamed(resources, xml, attributeSetAsAttributeSet, theme);
        } catch (java.io.IOException e2) {
            android.util.Log.e_renamed("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (org.xmlpull.v1.XmlPullParserException e3) {
            android.util.Log.e_renamed("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static androidx.vectordrawable.a_renamed.a_renamed.i_renamed a_renamed(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        androidx.vectordrawable.a_renamed.a_renamed.i_renamed iVar = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    static int a_renamed(int i_renamed, float f2) {
        return (i_renamed & 16777215) | (((int) (android.graphics.Color.alpha(i_renamed) * f2)) << 24);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (this.f1779c != null) {
            this.f1779c.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (this.f1779c != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.f1779c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        androidx.vectordrawable.a_renamed.a_renamed.i_renamed.g_renamed gVar = this.f1781b;
        gVar.f1792b = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.f_renamed();
        android.content.res.TypedArray typedArrayA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.vectordrawable.a_renamed.a_renamed.a_renamed.f1765a);
        a_renamed(typedArrayA, xmlPullParser, theme);
        typedArrayA.recycle();
        gVar.f1791a = getChangingConfigurations();
        gVar.k_renamed = true;
        b_renamed(resources, xmlPullParser, attributeSet, theme);
        this.d_renamed = a_renamed(this.d_renamed, gVar.f1793c, gVar.d_renamed);
    }

    private static android.graphics.PorterDuff.Mode a_renamed(int i_renamed, android.graphics.PorterDuff.Mode mode) {
        if (i_renamed == 3) {
            return android.graphics.PorterDuff.Mode.SRC_OVER;
        }
        if (i_renamed == 5) {
            return android.graphics.PorterDuff.Mode.SRC_IN;
        }
        if (i_renamed == 9) {
            return android.graphics.PorterDuff.Mode.SRC_ATOP;
        }
        switch (i_renamed) {
            case 14:
                return android.graphics.PorterDuff.Mode.MULTIPLY;
            case 15:
                return android.graphics.PorterDuff.Mode.SCREEN;
            case 16:
                return android.graphics.PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void a_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException {
        androidx.vectordrawable.a_renamed.a_renamed.i_renamed.g_renamed gVar = this.f1781b;
        androidx.vectordrawable.a_renamed.a_renamed.i_renamed.f_renamed fVar = gVar.f1792b;
        gVar.d_renamed = a_renamed(androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "tintMode", 6, -1), android.graphics.PorterDuff.Mode.SRC_IN);
        android.content.res.ColorStateList colorStateListA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListA != null) {
            gVar.f1793c = colorStateListA;
        }
        gVar.e_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "autoMirrored", 5, gVar.e_renamed);
        fVar.f_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "viewportWidth", 7, fVar.f_renamed);
        fVar.g_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "viewportHeight", 8, fVar.g_renamed);
        if (fVar.f_renamed <= 0.0f) {
            throw new org.xmlpull.v1.XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fVar.g_renamed <= 0.0f) {
            throw new org.xmlpull.v1.XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        fVar.d_renamed = typedArray.getDimension(3, fVar.d_renamed);
        fVar.e_renamed = typedArray.getDimension(2, fVar.e_renamed);
        if (fVar.d_renamed <= 0.0f) {
            throw new org.xmlpull.v1.XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (fVar.e_renamed <= 0.0f) {
            throw new org.xmlpull.v1.XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        fVar.setAlpha(androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
        java.lang.String string = typedArray.getString(0);
        if (string != null) {
            fVar.i_renamed = string;
            fVar.k_renamed.put(string, fVar);
        }
    }

    private void b_renamed(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        androidx.vectordrawable.a_renamed.a_renamed.i_renamed.g_renamed gVar = this.f1781b;
        androidx.vectordrawable.a_renamed.a_renamed.i_renamed.f_renamed fVar = gVar.f1792b;
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        arrayDeque.push(fVar.f1790c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z_renamed = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                java.lang.String name = xmlPullParser.getName();
                androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed cVar = (androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed) arrayDeque.peek();
                if ("path".equals(name)) {
                    androidx.vectordrawable.a_renamed.a_renamed.i_renamed.b_renamed bVar = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.b_renamed();
                    bVar.a_renamed(resources, attributeSet, theme, xmlPullParser);
                    cVar.f1786b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.k_renamed.put(bVar.getPathName(), bVar);
                    }
                    z_renamed = false;
                    gVar.f1791a = bVar.o_renamed | gVar.f1791a;
                } else if ("clip-path".equals(name)) {
                    androidx.vectordrawable.a_renamed.a_renamed.i_renamed.a_renamed aVar = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.a_renamed();
                    aVar.a_renamed(resources, attributeSet, theme, xmlPullParser);
                    cVar.f1786b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.k_renamed.put(aVar.getPathName(), aVar);
                    }
                    gVar.f1791a = aVar.o_renamed | gVar.f1791a;
                } else if ("group".equals(name)) {
                    androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed cVar2 = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed();
                    cVar2.a_renamed(resources, attributeSet, theme, xmlPullParser);
                    cVar.f1786b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.k_renamed.put(cVar2.getGroupName(), cVar2);
                    }
                    gVar.f1791a = cVar2.e_renamed | gVar.f1791a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z_renamed) {
            throw new org.xmlpull.v1.XmlPullParserException("no path defined");
        }
    }

    void a_renamed(boolean z_renamed) {
        this.g_renamed = z_renamed;
    }

    private boolean a_renamed() {
        return android.os.Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a_renamed.i_renamed(this) == 1;
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        if (this.f1779c != null) {
            this.f1779c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.f1779c != null) {
            return this.f1779c.getChangingConfigurations();
        }
        return this.f1781b.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f1779c != null) {
            this.f1779c.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(java.lang.Runnable runnable, long j_renamed) {
        if (this.f1779c != null) {
            this.f1779c.scheduleSelf(runnable, j_renamed);
        } else {
            super.scheduleSelf(runnable, j_renamed);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z_renamed, boolean z2) {
        if (this.f1779c != null) {
            return this.f1779c.setVisible(z_renamed, z2);
        }
        return super.setVisible(z_renamed, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(java.lang.Runnable runnable) {
        if (this.f1779c != null) {
            this.f1779c.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    private static class h_renamed extends android.graphics.drawable.Drawable.ConstantState {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final android.graphics.drawable.Drawable.ConstantState f1794a;

        public h_renamed(android.graphics.drawable.Drawable.ConstantState constantState) {
            this.f1794a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable() {
            androidx.vectordrawable.a_renamed.a_renamed.i_renamed iVar = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed();
            iVar.f1779c = (android.graphics.drawable.VectorDrawable) this.f1794a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            androidx.vectordrawable.a_renamed.a_renamed.i_renamed iVar = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed();
            iVar.f1779c = (android.graphics.drawable.VectorDrawable) this.f1794a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources, android.content.res.Resources.Theme theme) {
            androidx.vectordrawable.a_renamed.a_renamed.i_renamed iVar = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed();
            iVar.f1779c = (android.graphics.drawable.VectorDrawable) this.f1794a.newDrawable(resources, theme);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f1794a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1794a.getChangingConfigurations();
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    private static class g_renamed extends android.graphics.drawable.Drawable.ConstantState {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1791a;

        /* renamed from: b_renamed, reason: collision with root package name */
        androidx.vectordrawable.a_renamed.a_renamed.i_renamed.f_renamed f1792b;

        /* renamed from: c_renamed, reason: collision with root package name */
        android.content.res.ColorStateList f1793c;
        android.graphics.PorterDuff.Mode d_renamed;
        boolean e_renamed;
        android.graphics.Bitmap f_renamed;
        android.content.res.ColorStateList g_renamed;
        android.graphics.PorterDuff.Mode h_renamed;
        int i_renamed;
        boolean j_renamed;
        boolean k_renamed;
        android.graphics.Paint l_renamed;

        public g_renamed(androidx.vectordrawable.a_renamed.a_renamed.i_renamed.g_renamed gVar) {
            this.f1793c = null;
            this.d_renamed = androidx.vectordrawable.a_renamed.a_renamed.i_renamed.f1780a;
            if (gVar != null) {
                this.f1791a = gVar.f1791a;
                this.f1792b = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.f_renamed(gVar.f1792b);
                if (gVar.f1792b.f1789b != null) {
                    this.f1792b.f1789b = new android.graphics.Paint(gVar.f1792b.f1789b);
                }
                if (gVar.f1792b.f1788a != null) {
                    this.f1792b.f1788a = new android.graphics.Paint(gVar.f1792b.f1788a);
                }
                this.f1793c = gVar.f1793c;
                this.d_renamed = gVar.d_renamed;
                this.e_renamed = gVar.e_renamed;
            }
        }

        public void a_renamed(android.graphics.Canvas canvas, android.graphics.ColorFilter colorFilter, android.graphics.Rect rect) {
            canvas.drawBitmap(this.f_renamed, (android.graphics.Rect) null, rect, a_renamed(colorFilter));
        }

        public boolean a_renamed() {
            return this.f1792b.getRootAlpha() < 255;
        }

        public android.graphics.Paint a_renamed(android.graphics.ColorFilter colorFilter) {
            if (!a_renamed() && colorFilter == null) {
                return null;
            }
            if (this.l_renamed == null) {
                this.l_renamed = new android.graphics.Paint();
                this.l_renamed.setFilterBitmap(true);
            }
            this.l_renamed.setAlpha(this.f1792b.getRootAlpha());
            this.l_renamed.setColorFilter(colorFilter);
            return this.l_renamed;
        }

        public void a_renamed(int i_renamed, int i2) {
            this.f_renamed.eraseColor(0);
            this.f1792b.a_renamed(new android.graphics.Canvas(this.f_renamed), i_renamed, i2, (android.graphics.ColorFilter) null);
        }

        public void b_renamed(int i_renamed, int i2) {
            if (this.f_renamed == null || !c_renamed(i_renamed, i2)) {
                this.f_renamed = android.graphics.Bitmap.createBitmap(i_renamed, i2, android.graphics.Bitmap.Config.ARGB_8888);
                this.k_renamed = true;
            }
        }

        public boolean c_renamed(int i_renamed, int i2) {
            return i_renamed == this.f_renamed.getWidth() && i2 == this.f_renamed.getHeight();
        }

        public boolean b_renamed() {
            return !this.k_renamed && this.g_renamed == this.f1793c && this.h_renamed == this.d_renamed && this.j_renamed == this.e_renamed && this.i_renamed == this.f1792b.getRootAlpha();
        }

        public void c_renamed() {
            this.g_renamed = this.f1793c;
            this.h_renamed = this.d_renamed;
            this.i_renamed = this.f1792b.getRootAlpha();
            this.j_renamed = this.e_renamed;
            this.k_renamed = false;
        }

        public g_renamed() {
            this.f1793c = null;
            this.d_renamed = androidx.vectordrawable.a_renamed.a_renamed.i_renamed.f1780a;
            this.f1792b = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.f_renamed();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable() {
            return new androidx.vectordrawable.a_renamed.a_renamed.i_renamed(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            return new androidx.vectordrawable.a_renamed.a_renamed.i_renamed(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1791a;
        }

        public boolean d_renamed() {
            return this.f1792b.a_renamed();
        }

        public boolean a_renamed(int[] iArr) {
            boolean zA = this.f1792b.a_renamed(iArr);
            this.k_renamed |= zA;
            return zA;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    private static class f_renamed {
        private static final android.graphics.Matrix n_renamed = new android.graphics.Matrix();

        /* renamed from: a_renamed, reason: collision with root package name */
        android.graphics.Paint f1788a;

        /* renamed from: b_renamed, reason: collision with root package name */
        android.graphics.Paint f1789b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed f1790c;
        float d_renamed;
        float e_renamed;
        float f_renamed;
        float g_renamed;
        int h_renamed;
        java.lang.String i_renamed;
        java.lang.Boolean j_renamed;
        final androidx.collection.ArrayMap<java.lang.String, java.lang.Object> k_renamed;
        private final android.graphics.Path l_renamed;
        private final android.graphics.Path m_renamed;
        private final android.graphics.Matrix o_renamed;
        private android.graphics.PathMeasure p_renamed;
        private int q_renamed;

        private static float a_renamed(float f_renamed, float f2, float f3, float f4) {
            return (f_renamed * f4) - (f2 * f3);
        }

        public f_renamed() {
            this.o_renamed = new android.graphics.Matrix();
            this.d_renamed = 0.0f;
            this.e_renamed = 0.0f;
            this.f_renamed = 0.0f;
            this.g_renamed = 0.0f;
            this.h_renamed = 255;
            this.i_renamed = null;
            this.j_renamed = null;
            this.k_renamed = new androidx.collection.ArrayMap<>();
            this.f1790c = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed();
            this.l_renamed = new android.graphics.Path();
            this.m_renamed = new android.graphics.Path();
        }

        public void setRootAlpha(int i_renamed) {
            this.h_renamed = i_renamed;
        }

        public int getRootAlpha() {
            return this.h_renamed;
        }

        public void setAlpha(float f_renamed) {
            setRootAlpha((int) (f_renamed * 255.0f));
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public f_renamed(androidx.vectordrawable.a_renamed.a_renamed.i_renamed.f_renamed fVar) {
            this.o_renamed = new android.graphics.Matrix();
            this.d_renamed = 0.0f;
            this.e_renamed = 0.0f;
            this.f_renamed = 0.0f;
            this.g_renamed = 0.0f;
            this.h_renamed = 255;
            this.i_renamed = null;
            this.j_renamed = null;
            this.k_renamed = new androidx.collection.ArrayMap<>();
            this.f1790c = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed(fVar.f1790c, this.k_renamed);
            this.l_renamed = new android.graphics.Path(fVar.l_renamed);
            this.m_renamed = new android.graphics.Path(fVar.m_renamed);
            this.d_renamed = fVar.d_renamed;
            this.e_renamed = fVar.e_renamed;
            this.f_renamed = fVar.f_renamed;
            this.g_renamed = fVar.g_renamed;
            this.q_renamed = fVar.q_renamed;
            this.h_renamed = fVar.h_renamed;
            this.i_renamed = fVar.i_renamed;
            java.lang.String str = fVar.i_renamed;
            if (str != null) {
                this.k_renamed.put(str, this);
            }
            this.j_renamed = fVar.j_renamed;
        }

        private void a_renamed(androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed cVar, android.graphics.Matrix matrix, android.graphics.Canvas canvas, int i_renamed, int i2, android.graphics.ColorFilter colorFilter) {
            cVar.f1785a.set(matrix);
            cVar.f1785a.preConcat(cVar.d_renamed);
            canvas.save();
            for (int i3 = 0; i3 < cVar.f1786b.size(); i3++) {
                androidx.vectordrawable.a_renamed.a_renamed.i_renamed.d_renamed dVar = cVar.f1786b.get(i3);
                if (dVar instanceof androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed) {
                    a_renamed((androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed) dVar, cVar.f1785a, canvas, i_renamed, i2, colorFilter);
                } else if (dVar instanceof androidx.vectordrawable.a_renamed.a_renamed.i_renamed.e_renamed) {
                    a_renamed(cVar, (androidx.vectordrawable.a_renamed.a_renamed.i_renamed.e_renamed) dVar, canvas, i_renamed, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public void a_renamed(android.graphics.Canvas canvas, int i_renamed, int i2, android.graphics.ColorFilter colorFilter) {
            a_renamed(this.f1790c, n_renamed, canvas, i_renamed, i2, colorFilter);
        }

        private void a_renamed(androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed cVar, androidx.vectordrawable.a_renamed.a_renamed.i_renamed.e_renamed eVar, android.graphics.Canvas canvas, int i_renamed, int i2, android.graphics.ColorFilter colorFilter) {
            float f_renamed = i_renamed / this.f_renamed;
            float f2 = i2 / this.g_renamed;
            float fMin = java.lang.Math.min(f_renamed, f2);
            android.graphics.Matrix matrix = cVar.f1785a;
            this.o_renamed.set(matrix);
            this.o_renamed.postScale(f_renamed, f2);
            float fA_renamed = a_renamed(matrix);
            if (fA_renamed == 0.0f) {
                return;
            }
            eVar.a_renamed(this.l_renamed);
            android.graphics.Path path = this.l_renamed;
            this.m_renamed.reset();
            if (eVar.a_renamed()) {
                this.m_renamed.setFillType(eVar.n_renamed == 0 ? android.graphics.Path.FillType.WINDING : android.graphics.Path.FillType.EVEN_ODD);
                this.m_renamed.addPath(path, this.o_renamed);
                canvas.clipPath(this.m_renamed);
                return;
            }
            androidx.vectordrawable.a_renamed.a_renamed.i_renamed.b_renamed bVar = (androidx.vectordrawable.a_renamed.a_renamed.i_renamed.b_renamed) eVar;
            if (bVar.f_renamed != 0.0f || bVar.g_renamed != 1.0f) {
                float f3 = (bVar.f_renamed + bVar.h_renamed) % 1.0f;
                float f4 = (bVar.g_renamed + bVar.h_renamed) % 1.0f;
                if (this.p_renamed == null) {
                    this.p_renamed = new android.graphics.PathMeasure();
                }
                this.p_renamed.setPath(this.l_renamed, false);
                float length = this.p_renamed.getLength();
                float f5 = f3 * length;
                float f6 = f4 * length;
                path.reset();
                if (f5 > f6) {
                    this.p_renamed.getSegment(f5, length, path, true);
                    this.p_renamed.getSegment(0.0f, f6, path, true);
                } else {
                    this.p_renamed.getSegment(f5, f6, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.m_renamed.addPath(path, this.o_renamed);
            if (bVar.f1784c.e_renamed()) {
                androidx.core.a_renamed.a_renamed.b_renamed bVar2 = bVar.f1784c;
                if (this.f1789b == null) {
                    this.f1789b = new android.graphics.Paint(1);
                    this.f1789b.setStyle(android.graphics.Paint.Style.FILL);
                }
                android.graphics.Paint paint = this.f1789b;
                if (bVar2.c_renamed()) {
                    android.graphics.Shader shaderA = bVar2.a_renamed();
                    shaderA.setLocalMatrix(this.o_renamed);
                    paint.setShader(shaderA);
                    paint.setAlpha(java.lang.Math.round(bVar.e_renamed * 255.0f));
                } else {
                    paint.setShader(null);
                    paint.setAlpha(255);
                    paint.setColor(androidx.vectordrawable.a_renamed.a_renamed.i_renamed.a_renamed(bVar2.b_renamed(), bVar.e_renamed));
                }
                paint.setColorFilter(colorFilter);
                this.m_renamed.setFillType(bVar.n_renamed == 0 ? android.graphics.Path.FillType.WINDING : android.graphics.Path.FillType.EVEN_ODD);
                canvas.drawPath(this.m_renamed, paint);
            }
            if (bVar.f1782a.e_renamed()) {
                androidx.core.a_renamed.a_renamed.b_renamed bVar3 = bVar.f1782a;
                if (this.f1788a == null) {
                    this.f1788a = new android.graphics.Paint(1);
                    this.f1788a.setStyle(android.graphics.Paint.Style.STROKE);
                }
                android.graphics.Paint paint2 = this.f1788a;
                if (bVar.j_renamed != null) {
                    paint2.setStrokeJoin(bVar.j_renamed);
                }
                if (bVar.i_renamed != null) {
                    paint2.setStrokeCap(bVar.i_renamed);
                }
                paint2.setStrokeMiter(bVar.k_renamed);
                if (bVar3.c_renamed()) {
                    android.graphics.Shader shaderA2 = bVar3.a_renamed();
                    shaderA2.setLocalMatrix(this.o_renamed);
                    paint2.setShader(shaderA2);
                    paint2.setAlpha(java.lang.Math.round(bVar.d_renamed * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(androidx.vectordrawable.a_renamed.a_renamed.i_renamed.a_renamed(bVar3.b_renamed(), bVar.d_renamed));
                }
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(bVar.f1783b * fMin * fA_renamed);
                canvas.drawPath(this.m_renamed, paint2);
            }
        }

        private float a_renamed(android.graphics.Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) java.lang.Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) java.lang.Math.hypot(fArr[2], fArr[3]);
            float fA_renamed = a_renamed(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = java.lang.Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return java.lang.Math.abs(fA_renamed) / fMax;
            }
            return 0.0f;
        }

        public boolean a_renamed() {
            if (this.j_renamed == null) {
                this.j_renamed = java.lang.Boolean.valueOf(this.f1790c.b_renamed());
            }
            return this.j_renamed.booleanValue();
        }

        public boolean a_renamed(int[] iArr) {
            return this.f1790c.a_renamed(iArr);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    private static abstract class d_renamed {
        public boolean a_renamed(int[] iArr) {
            return false;
        }

        public boolean b_renamed() {
            return false;
        }

        private d_renamed() {
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    private static class c_renamed extends androidx.vectordrawable.a_renamed.a_renamed.i_renamed.d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final android.graphics.Matrix f1785a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final java.util.ArrayList<androidx.vectordrawable.a_renamed.a_renamed.i_renamed.d_renamed> f1786b;

        /* renamed from: c_renamed, reason: collision with root package name */
        float f1787c;
        final android.graphics.Matrix d_renamed;
        int e_renamed;
        private float f_renamed;
        private float g_renamed;
        private float h_renamed;
        private float i_renamed;
        private float j_renamed;
        private float k_renamed;
        private int[] l_renamed;
        private java.lang.String m_renamed;

        public c_renamed(androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed cVar, androidx.collection.ArrayMap<java.lang.String, java.lang.Object> arrayMap) {
            androidx.vectordrawable.a_renamed.a_renamed.i_renamed.e_renamed aVar;
            super();
            this.f1785a = new android.graphics.Matrix();
            this.f1786b = new java.util.ArrayList<>();
            this.f1787c = 0.0f;
            this.f_renamed = 0.0f;
            this.g_renamed = 0.0f;
            this.h_renamed = 1.0f;
            this.i_renamed = 1.0f;
            this.j_renamed = 0.0f;
            this.k_renamed = 0.0f;
            this.d_renamed = new android.graphics.Matrix();
            this.m_renamed = null;
            this.f1787c = cVar.f1787c;
            this.f_renamed = cVar.f_renamed;
            this.g_renamed = cVar.g_renamed;
            this.h_renamed = cVar.h_renamed;
            this.i_renamed = cVar.i_renamed;
            this.j_renamed = cVar.j_renamed;
            this.k_renamed = cVar.k_renamed;
            this.l_renamed = cVar.l_renamed;
            this.m_renamed = cVar.m_renamed;
            this.e_renamed = cVar.e_renamed;
            java.lang.String str = this.m_renamed;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.d_renamed.set(cVar.d_renamed);
            java.util.ArrayList<androidx.vectordrawable.a_renamed.a_renamed.i_renamed.d_renamed> arrayList = cVar.f1786b;
            for (int i_renamed = 0; i_renamed < arrayList.size(); i_renamed++) {
                androidx.vectordrawable.a_renamed.a_renamed.i_renamed.d_renamed dVar = arrayList.get(i_renamed);
                if (dVar instanceof androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed) {
                    this.f1786b.add(new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed((androidx.vectordrawable.a_renamed.a_renamed.i_renamed.c_renamed) dVar, arrayMap));
                } else {
                    if (dVar instanceof androidx.vectordrawable.a_renamed.a_renamed.i_renamed.b_renamed) {
                        aVar = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.b_renamed((androidx.vectordrawable.a_renamed.a_renamed.i_renamed.b_renamed) dVar);
                    } else if (dVar instanceof androidx.vectordrawable.a_renamed.a_renamed.i_renamed.a_renamed) {
                        aVar = new androidx.vectordrawable.a_renamed.a_renamed.i_renamed.a_renamed((androidx.vectordrawable.a_renamed.a_renamed.i_renamed.a_renamed) dVar);
                    } else {
                        throw new java.lang.IllegalStateException("Unknown object in_renamed the tree!");
                    }
                    this.f1786b.add(aVar);
                    if (aVar.m_renamed != null) {
                        arrayMap.put(aVar.m_renamed, aVar);
                    }
                }
            }
        }

        public c_renamed() {
            super();
            this.f1785a = new android.graphics.Matrix();
            this.f1786b = new java.util.ArrayList<>();
            this.f1787c = 0.0f;
            this.f_renamed = 0.0f;
            this.g_renamed = 0.0f;
            this.h_renamed = 1.0f;
            this.i_renamed = 1.0f;
            this.j_renamed = 0.0f;
            this.k_renamed = 0.0f;
            this.d_renamed = new android.graphics.Matrix();
            this.m_renamed = null;
        }

        public java.lang.String getGroupName() {
            return this.m_renamed;
        }

        public android.graphics.Matrix getLocalMatrix() {
            return this.d_renamed;
        }

        public void a_renamed(android.content.res.Resources resources, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser) {
            android.content.res.TypedArray typedArrayA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.vectordrawable.a_renamed.a_renamed.a_renamed.f1766b);
            a_renamed(typedArrayA, xmlPullParser);
            typedArrayA.recycle();
        }

        private void a_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser) {
            this.l_renamed = null;
            this.f1787c = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "rotation", 5, this.f1787c);
            this.f_renamed = typedArray.getFloat(1, this.f_renamed);
            this.g_renamed = typedArray.getFloat(2, this.g_renamed);
            this.h_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "scaleX", 3, this.h_renamed);
            this.i_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "scaleY", 4, this.i_renamed);
            this.j_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "translateX", 6, this.j_renamed);
            this.k_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "translateY", 7, this.k_renamed);
            java.lang.String string = typedArray.getString(0);
            if (string != null) {
                this.m_renamed = string;
            }
            a_renamed();
        }

        private void a_renamed() {
            this.d_renamed.reset();
            this.d_renamed.postTranslate(-this.f_renamed, -this.g_renamed);
            this.d_renamed.postScale(this.h_renamed, this.i_renamed);
            this.d_renamed.postRotate(this.f1787c, 0.0f, 0.0f);
            this.d_renamed.postTranslate(this.j_renamed + this.f_renamed, this.k_renamed + this.g_renamed);
        }

        public float getRotation() {
            return this.f1787c;
        }

        public void setRotation(float f_renamed) {
            if (f_renamed != this.f1787c) {
                this.f1787c = f_renamed;
                a_renamed();
            }
        }

        public float getPivotX() {
            return this.f_renamed;
        }

        public void setPivotX(float f_renamed) {
            if (f_renamed != this.f_renamed) {
                this.f_renamed = f_renamed;
                a_renamed();
            }
        }

        public float getPivotY() {
            return this.g_renamed;
        }

        public void setPivotY(float f_renamed) {
            if (f_renamed != this.g_renamed) {
                this.g_renamed = f_renamed;
                a_renamed();
            }
        }

        public float getScaleX() {
            return this.h_renamed;
        }

        public void setScaleX(float f_renamed) {
            if (f_renamed != this.h_renamed) {
                this.h_renamed = f_renamed;
                a_renamed();
            }
        }

        public float getScaleY() {
            return this.i_renamed;
        }

        public void setScaleY(float f_renamed) {
            if (f_renamed != this.i_renamed) {
                this.i_renamed = f_renamed;
                a_renamed();
            }
        }

        public float getTranslateX() {
            return this.j_renamed;
        }

        public void setTranslateX(float f_renamed) {
            if (f_renamed != this.j_renamed) {
                this.j_renamed = f_renamed;
                a_renamed();
            }
        }

        public float getTranslateY() {
            return this.k_renamed;
        }

        public void setTranslateY(float f_renamed) {
            if (f_renamed != this.k_renamed) {
                this.k_renamed = f_renamed;
                a_renamed();
            }
        }

        @Override // androidx.vectordrawable.a_renamed.a_renamed.i_renamed.d_renamed
        public boolean b_renamed() {
            for (int i_renamed = 0; i_renamed < this.f1786b.size(); i_renamed++) {
                if (this.f1786b.get(i_renamed).b_renamed()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.a_renamed.a_renamed.i_renamed.d_renamed
        public boolean a_renamed(int[] iArr) {
            boolean zA = false;
            for (int i_renamed = 0; i_renamed < this.f1786b.size(); i_renamed++) {
                zA |= this.f1786b.get(i_renamed).a_renamed(iArr);
            }
            return zA;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    private static abstract class e_renamed extends androidx.vectordrawable.a_renamed.a_renamed.i_renamed.d_renamed {
        protected androidx.core.graphics.e_renamed.b_renamed[] l_renamed;
        java.lang.String m_renamed;
        int n_renamed;
        int o_renamed;

        public boolean a_renamed() {
            return false;
        }

        public e_renamed() {
            super();
            this.l_renamed = null;
            this.n_renamed = 0;
        }

        public e_renamed(androidx.vectordrawable.a_renamed.a_renamed.i_renamed.e_renamed eVar) {
            super();
            this.l_renamed = null;
            this.n_renamed = 0;
            this.m_renamed = eVar.m_renamed;
            this.o_renamed = eVar.o_renamed;
            this.l_renamed = androidx.core.graphics.e_renamed.a_renamed(eVar.l_renamed);
        }

        public void a_renamed(android.graphics.Path path) {
            path.reset();
            androidx.core.graphics.e_renamed.b_renamed[] bVarArr = this.l_renamed;
            if (bVarArr != null) {
                androidx.core.graphics.e_renamed.b_renamed.a_renamed(bVarArr, path);
            }
        }

        public java.lang.String getPathName() {
            return this.m_renamed;
        }

        public androidx.core.graphics.e_renamed.b_renamed[] getPathData() {
            return this.l_renamed;
        }

        public void setPathData(androidx.core.graphics.e_renamed.b_renamed[] bVarArr) {
            if (!androidx.core.graphics.e_renamed.a_renamed(this.l_renamed, bVarArr)) {
                this.l_renamed = androidx.core.graphics.e_renamed.a_renamed(bVarArr);
            } else {
                androidx.core.graphics.e_renamed.b_renamed(this.l_renamed, bVarArr);
            }
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    private static class a_renamed extends androidx.vectordrawable.a_renamed.a_renamed.i_renamed.e_renamed {
        @Override // androidx.vectordrawable.a_renamed.a_renamed.i_renamed.e_renamed
        public boolean a_renamed() {
            return true;
        }

        a_renamed() {
        }

        a_renamed(androidx.vectordrawable.a_renamed.a_renamed.i_renamed.a_renamed aVar) {
            super(aVar);
        }

        public void a_renamed(android.content.res.Resources resources, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser) {
            if (androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(xmlPullParser, "pathData")) {
                android.content.res.TypedArray typedArrayA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.vectordrawable.a_renamed.a_renamed.a_renamed.d_renamed);
                a_renamed(typedArrayA, xmlPullParser);
                typedArrayA.recycle();
            }
        }

        private void a_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser) {
            java.lang.String string = typedArray.getString(0);
            if (string != null) {
                this.m_renamed = string;
            }
            java.lang.String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.l_renamed = androidx.core.graphics.e_renamed.b_renamed(string2);
            }
            this.n_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "fillType", 2, 0);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    private static class b_renamed extends androidx.vectordrawable.a_renamed.a_renamed.i_renamed.e_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        androidx.core.a_renamed.a_renamed.b_renamed f1782a;

        /* renamed from: b_renamed, reason: collision with root package name */
        float f1783b;

        /* renamed from: c_renamed, reason: collision with root package name */
        androidx.core.a_renamed.a_renamed.b_renamed f1784c;
        float d_renamed;
        float e_renamed;
        float f_renamed;
        float g_renamed;
        float h_renamed;
        android.graphics.Paint.Cap i_renamed;
        android.graphics.Paint.Join j_renamed;
        float k_renamed;
        private int[] p_renamed;

        b_renamed() {
            this.f1783b = 0.0f;
            this.d_renamed = 1.0f;
            this.e_renamed = 1.0f;
            this.f_renamed = 0.0f;
            this.g_renamed = 1.0f;
            this.h_renamed = 0.0f;
            this.i_renamed = android.graphics.Paint.Cap.BUTT;
            this.j_renamed = android.graphics.Paint.Join.MITER;
            this.k_renamed = 4.0f;
        }

        b_renamed(androidx.vectordrawable.a_renamed.a_renamed.i_renamed.b_renamed bVar) {
            super(bVar);
            this.f1783b = 0.0f;
            this.d_renamed = 1.0f;
            this.e_renamed = 1.0f;
            this.f_renamed = 0.0f;
            this.g_renamed = 1.0f;
            this.h_renamed = 0.0f;
            this.i_renamed = android.graphics.Paint.Cap.BUTT;
            this.j_renamed = android.graphics.Paint.Join.MITER;
            this.k_renamed = 4.0f;
            this.p_renamed = bVar.p_renamed;
            this.f1782a = bVar.f1782a;
            this.f1783b = bVar.f1783b;
            this.d_renamed = bVar.d_renamed;
            this.f1784c = bVar.f1784c;
            this.n_renamed = bVar.n_renamed;
            this.e_renamed = bVar.e_renamed;
            this.f_renamed = bVar.f_renamed;
            this.g_renamed = bVar.g_renamed;
            this.h_renamed = bVar.h_renamed;
            this.i_renamed = bVar.i_renamed;
            this.j_renamed = bVar.j_renamed;
            this.k_renamed = bVar.k_renamed;
        }

        private android.graphics.Paint.Cap a_renamed(int i_renamed, android.graphics.Paint.Cap cap) {
            if (i_renamed == 0) {
                return android.graphics.Paint.Cap.BUTT;
            }
            if (i_renamed != 1) {
                return i_renamed != 2 ? cap : android.graphics.Paint.Cap.SQUARE;
            }
            return android.graphics.Paint.Cap.ROUND;
        }

        private android.graphics.Paint.Join a_renamed(int i_renamed, android.graphics.Paint.Join join) {
            if (i_renamed == 0) {
                return android.graphics.Paint.Join.MITER;
            }
            if (i_renamed != 1) {
                return i_renamed != 2 ? join : android.graphics.Paint.Join.BEVEL;
            }
            return android.graphics.Paint.Join.ROUND;
        }

        public void a_renamed(android.content.res.Resources resources, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme, org.xmlpull.v1.XmlPullParser xmlPullParser) {
            android.content.res.TypedArray typedArrayA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.vectordrawable.a_renamed.a_renamed.a_renamed.f1767c);
            a_renamed(typedArrayA, xmlPullParser, theme);
            typedArrayA.recycle();
        }

        private void a_renamed(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser, android.content.res.Resources.Theme theme) {
            this.p_renamed = null;
            if (androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(xmlPullParser, "pathData")) {
                java.lang.String string = typedArray.getString(0);
                if (string != null) {
                    this.m_renamed = string;
                }
                java.lang.String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.l_renamed = androidx.core.graphics.e_renamed.b_renamed(string2);
                }
                this.f1784c = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.e_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "fillAlpha", 12, this.e_renamed);
                this.i_renamed = a_renamed(androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.i_renamed);
                this.j_renamed = a_renamed(androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.j_renamed);
                this.k_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.k_renamed);
                this.f1782a = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.d_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "strokeAlpha", 11, this.d_renamed);
                this.f1783b = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "strokeWidth", 4, this.f1783b);
                this.g_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "trimPathEnd", 6, this.g_renamed);
                this.h_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "trimPathOffset", 7, this.h_renamed);
                this.f_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "trimPathStart", 5, this.f_renamed);
                this.n_renamed = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArray, xmlPullParser, "fillType", 13, this.n_renamed);
            }
        }

        @Override // androidx.vectordrawable.a_renamed.a_renamed.i_renamed.d_renamed
        public boolean b_renamed() {
            return this.f1784c.d_renamed() || this.f1782a.d_renamed();
        }

        @Override // androidx.vectordrawable.a_renamed.a_renamed.i_renamed.d_renamed
        public boolean a_renamed(int[] iArr) {
            return this.f1782a.a_renamed(iArr) | this.f1784c.a_renamed(iArr);
        }

        int getStrokeColor() {
            return this.f1782a.b_renamed();
        }

        void setStrokeColor(int i_renamed) {
            this.f1782a.b_renamed(i_renamed);
        }

        float getStrokeWidth() {
            return this.f1783b;
        }

        void setStrokeWidth(float f_renamed) {
            this.f1783b = f_renamed;
        }

        float getStrokeAlpha() {
            return this.d_renamed;
        }

        void setStrokeAlpha(float f_renamed) {
            this.d_renamed = f_renamed;
        }

        int getFillColor() {
            return this.f1784c.b_renamed();
        }

        void setFillColor(int i_renamed) {
            this.f1784c.b_renamed(i_renamed);
        }

        float getFillAlpha() {
            return this.e_renamed;
        }

        void setFillAlpha(float f_renamed) {
            this.e_renamed = f_renamed;
        }

        float getTrimPathStart() {
            return this.f_renamed;
        }

        void setTrimPathStart(float f_renamed) {
            this.f_renamed = f_renamed;
        }

        float getTrimPathEnd() {
            return this.g_renamed;
        }

        void setTrimPathEnd(float f_renamed) {
            this.g_renamed = f_renamed;
        }

        float getTrimPathOffset() {
            return this.h_renamed;
        }

        void setTrimPathOffset(float f_renamed) {
            this.h_renamed = f_renamed;
        }
    }
}
