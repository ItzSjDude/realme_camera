package androidx.vectordrawable.a_renamed.a_renamed;

/* compiled from: AnimatedVectorDrawableCompat.java */
/* loaded from: classes.dex */
public class c_renamed extends androidx.vectordrawable.a_renamed.a_renamed.h_renamed implements androidx.vectordrawable.a_renamed.a_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    java.util.ArrayList<java.lang.Object> f1768a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final android.graphics.drawable.Drawable.Callback f1769b;
    private androidx.vectordrawable.a_renamed.a_renamed.c_renamed.a_renamed d_renamed;
    private android.content.Context e_renamed;
    private android.animation.ArgbEvaluator f_renamed;
    private android.animation.Animator.AnimatorListener g_renamed;

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
    public /* bridge */ /* synthetic */ void setHotspot(float f_renamed, float f2) {
        super.setHotspot(f_renamed, f2);
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i_renamed, int i2, int i3, int i4) {
        super.setHotspotBounds(i_renamed, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    c_renamed() {
        this(null, null, null);
    }

    private c_renamed(android.content.Context context) {
        this(context, null, null);
    }

    private c_renamed(android.content.Context context, androidx.vectordrawable.a_renamed.a_renamed.c_renamed.a_renamed aVar, android.content.res.Resources resources) {
        this.f_renamed = null;
        this.g_renamed = null;
        this.f1768a = null;
        this.f1769b = new android.graphics.drawable.Drawable.Callback() { // from class: androidx.vectordrawable.a_renamed.a_renamed.c_renamed.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
                androidx.vectordrawable.a_renamed.a_renamed.c_renamed.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable, long j_renamed) {
                androidx.vectordrawable.a_renamed.a_renamed.c_renamed.this.scheduleSelf(runnable, j_renamed);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable) {
                androidx.vectordrawable.a_renamed.a_renamed.c_renamed.this.unscheduleSelf(runnable);
            }
        };
        this.e_renamed = context;
        if (aVar != null) {
            this.d_renamed = aVar;
        } else {
            this.d_renamed = new androidx.vectordrawable.a_renamed.a_renamed.c_renamed.a_renamed(context, aVar, this.f1769b, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable mutate() {
        if (this.f1779c != null) {
            this.f1779c.mutate();
        }
        return this;
    }

    public static androidx.vectordrawable.a_renamed.a_renamed.c_renamed a_renamed(android.content.Context context, android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        androidx.vectordrawable.a_renamed.a_renamed.c_renamed cVar = new androidx.vectordrawable.a_renamed.a_renamed.c_renamed(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        if (this.f1779c == null || android.os.Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new androidx.vectordrawable.a_renamed.a_renamed.c_renamed.b_renamed(this.f1779c.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.f1779c != null) {
            return this.f1779c.getChangingConfigurations();
        }
        return this.d_renamed.f1771a | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (this.f1779c != null) {
            this.f1779c.draw(canvas);
            return;
        }
        this.d_renamed.f1772b.draw(canvas);
        if (this.d_renamed.f1773c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        if (this.f1779c != null) {
            this.f1779c.setBounds(rect);
        } else {
            this.d_renamed.f1772b.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f1779c != null) {
            return this.f1779c.setState(iArr);
        }
        return this.d_renamed.f1772b.setState(iArr);
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i_renamed) {
        if (this.f1779c != null) {
            return this.f1779c.setLevel(i_renamed);
        }
        return this.d_renamed.f1772b.setLevel(i_renamed);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.f1779c != null) {
            return androidx.core.graphics.drawable.a_renamed.c_renamed(this.f1779c);
        }
        return this.d_renamed.f1772b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
        if (this.f1779c != null) {
            this.f1779c.setAlpha(i_renamed);
        } else {
            this.d_renamed.f1772b.setAlpha(i_renamed);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        if (this.f1779c != null) {
            this.f1779c.setColorFilter(colorFilter);
        } else {
            this.d_renamed.f1772b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.ColorFilter getColorFilter() {
        if (this.f1779c != null) {
            return androidx.core.graphics.drawable.a_renamed.e_renamed(this.f1779c);
        }
        return this.d_renamed.f1772b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTint(int i_renamed) {
        if (this.f1779c != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.f1779c, i_renamed);
        } else {
            this.d_renamed.f1772b.setTint(i_renamed);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintList(android.content.res.ColorStateList colorStateList) {
        if (this.f1779c != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.f1779c, colorStateList);
        } else {
            this.d_renamed.f1772b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b_renamed
    public void setTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.f1779c != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.f1779c, mode);
        } else {
            this.d_renamed.f1772b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z_renamed, boolean z2) {
        if (this.f1779c != null) {
            return this.f1779c.setVisible(z_renamed, z2);
        }
        this.d_renamed.f1772b.setVisible(z_renamed, z2);
        return super.setVisible(z_renamed, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.f1779c != null) {
            return this.f1779c.isStateful();
        }
        return this.d_renamed.f1772b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f1779c != null) {
            return this.f1779c.getOpacity();
        }
        return this.d_renamed.f1772b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f1779c != null) {
            return this.f1779c.getIntrinsicWidth();
        }
        return this.d_renamed.f1772b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f1779c != null) {
            return this.f1779c.getIntrinsicHeight();
        }
        return this.d_renamed.f1772b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        if (this.f1779c != null) {
            return androidx.core.graphics.drawable.a_renamed.b_renamed(this.f1779c);
        }
        return this.d_renamed.f1772b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z_renamed) {
        if (this.f1779c != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.f1779c, z_renamed);
        } else {
            this.d_renamed.f1772b.setAutoMirrored(z_renamed);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (this.f1779c != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.f1779c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                java.lang.String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    android.content.res.TypedArray typedArrayA = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(resources, theme, attributeSet, androidx.vectordrawable.a_renamed.a_renamed.a_renamed.e_renamed);
                    int resourceId = typedArrayA.getResourceId(0, 0);
                    if (resourceId != 0) {
                        androidx.vectordrawable.a_renamed.a_renamed.i_renamed iVarA = androidx.vectordrawable.a_renamed.a_renamed.i_renamed.a_renamed(resources, resourceId, theme);
                        iVarA.a_renamed(false);
                        iVarA.setCallback(this.f1769b);
                        if (this.d_renamed.f1772b != null) {
                            this.d_renamed.f1772b.setCallback(null);
                        }
                        this.d_renamed.f1772b = iVarA;
                    }
                    typedArrayA.recycle();
                } else if ("target".equals(name)) {
                    android.content.res.TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.a_renamed.a_renamed.a_renamed.f_renamed);
                    java.lang.String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        android.content.Context context = this.e_renamed;
                        if (context != null) {
                            a_renamed(string, androidx.vectordrawable.a_renamed.a_renamed.e_renamed.a_renamed(context, resourceId2));
                        } else {
                            typedArrayObtainAttributes.recycle();
                            throw new java.lang.IllegalStateException("Context can't_renamed be_renamed null when inflating animators");
                        }
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.d_renamed.a_renamed();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(android.content.res.Resources resources, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // androidx.vectordrawable.a_renamed.a_renamed.h_renamed, android.graphics.drawable.Drawable
    public void applyTheme(android.content.res.Resources.Theme theme) {
        if (this.f1779c != null) {
            androidx.core.graphics.drawable.a_renamed.a_renamed(this.f1779c, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f1779c != null) {
            return androidx.core.graphics.drawable.a_renamed.d_renamed(this.f1779c);
        }
        return false;
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    private static class b_renamed extends android.graphics.drawable.Drawable.ConstantState {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final android.graphics.drawable.Drawable.ConstantState f1774a;

        public b_renamed(android.graphics.drawable.Drawable.ConstantState constantState) {
            this.f1774a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable() {
            androidx.vectordrawable.a_renamed.a_renamed.c_renamed cVar = new androidx.vectordrawable.a_renamed.a_renamed.c_renamed();
            cVar.f1779c = this.f1774a.newDrawable();
            cVar.f1779c.setCallback(cVar.f1769b);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            androidx.vectordrawable.a_renamed.a_renamed.c_renamed cVar = new androidx.vectordrawable.a_renamed.a_renamed.c_renamed();
            cVar.f1779c = this.f1774a.newDrawable(resources);
            cVar.f1779c.setCallback(cVar.f1769b);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources, android.content.res.Resources.Theme theme) {
            androidx.vectordrawable.a_renamed.a_renamed.c_renamed cVar = new androidx.vectordrawable.a_renamed.a_renamed.c_renamed();
            cVar.f1779c = this.f1774a.newDrawable(resources, theme);
            cVar.f1779c.setCallback(cVar.f1769b);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f1774a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1774a.getChangingConfigurations();
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    private static class a_renamed extends android.graphics.drawable.Drawable.ConstantState {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1771a;

        /* renamed from: b_renamed, reason: collision with root package name */
        androidx.vectordrawable.a_renamed.a_renamed.i_renamed f1772b;

        /* renamed from: c_renamed, reason: collision with root package name */
        android.animation.AnimatorSet f1773c;
        java.util.ArrayList<android.animation.Animator> d_renamed;
        androidx.collection.ArrayMap<android.animation.Animator, java.lang.String> e_renamed;

        public a_renamed(android.content.Context context, androidx.vectordrawable.a_renamed.a_renamed.c_renamed.a_renamed aVar, android.graphics.drawable.Drawable.Callback callback, android.content.res.Resources resources) {
            if (aVar != null) {
                this.f1771a = aVar.f1771a;
                androidx.vectordrawable.a_renamed.a_renamed.i_renamed iVar = aVar.f1772b;
                if (iVar != null) {
                    android.graphics.drawable.Drawable.ConstantState constantState = iVar.getConstantState();
                    if (resources != null) {
                        this.f1772b = (androidx.vectordrawable.a_renamed.a_renamed.i_renamed) constantState.newDrawable(resources);
                    } else {
                        this.f1772b = (androidx.vectordrawable.a_renamed.a_renamed.i_renamed) constantState.newDrawable();
                    }
                    this.f1772b = (androidx.vectordrawable.a_renamed.a_renamed.i_renamed) this.f1772b.mutate();
                    this.f1772b.setCallback(callback);
                    this.f1772b.setBounds(aVar.f1772b.getBounds());
                    this.f1772b.a_renamed(false);
                }
                java.util.ArrayList<android.animation.Animator> arrayList = aVar.d_renamed;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.d_renamed = new java.util.ArrayList<>(size);
                    this.e_renamed = new androidx.collection.ArrayMap<>(size);
                    for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                        android.animation.Animator animator = aVar.d_renamed.get(i_renamed);
                        android.animation.Animator animatorClone = animator.clone();
                        java.lang.String str = aVar.e_renamed.get(animator);
                        animatorClone.setTarget(this.f1772b.a_renamed(str));
                        this.d_renamed.add(animatorClone);
                        this.e_renamed.put(animatorClone, str);
                    }
                    a_renamed();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable() {
            throw new java.lang.IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            throw new java.lang.IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1771a;
        }

        public void a_renamed() {
            if (this.f1773c == null) {
                this.f1773c = new android.animation.AnimatorSet();
            }
            this.f1773c.playTogether(this.d_renamed);
        }
    }

    private void a_renamed(android.animation.Animator animator) {
        java.util.ArrayList<android.animation.Animator> childAnimations;
        if ((animator instanceof android.animation.AnimatorSet) && (childAnimations = ((android.animation.AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i_renamed = 0; i_renamed < childAnimations.size(); i_renamed++) {
                a_renamed(childAnimations.get(i_renamed));
            }
        }
        if (animator instanceof android.animation.ObjectAnimator) {
            android.animation.ObjectAnimator objectAnimator = (android.animation.ObjectAnimator) animator;
            java.lang.String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f_renamed == null) {
                    this.f_renamed = new android.animation.ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f_renamed);
            }
        }
    }

    private void a_renamed(java.lang.String str, android.animation.Animator animator) {
        animator.setTarget(this.d_renamed.f1772b.a_renamed(str));
        if (android.os.Build.VERSION.SDK_INT < 21) {
            a_renamed(animator);
        }
        if (this.d_renamed.d_renamed == null) {
            this.d_renamed.d_renamed = new java.util.ArrayList<>();
            this.d_renamed.e_renamed = new androidx.collection.ArrayMap<>();
        }
        this.d_renamed.d_renamed.add(animator);
        this.d_renamed.e_renamed.put(animator, str);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        if (this.f1779c != null) {
            return ((android.graphics.drawable.AnimatedVectorDrawable) this.f1779c).isRunning();
        }
        return this.d_renamed.f1773c.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f1779c != null) {
            ((android.graphics.drawable.AnimatedVectorDrawable) this.f1779c).start();
        } else {
            if (this.d_renamed.f1773c.isStarted()) {
                return;
            }
            this.d_renamed.f1773c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f1779c != null) {
            ((android.graphics.drawable.AnimatedVectorDrawable) this.f1779c).stop();
        } else {
            this.d_renamed.f1773c.end();
        }
    }
}
