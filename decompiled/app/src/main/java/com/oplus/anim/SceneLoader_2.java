package com.oplus.anim;

/* loaded from: classes2.dex */
public class EffectiveAnimationView extends androidx.appcompat.widget.AppCompatImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f3446a = "EffectiveAnimationView";

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.oplus.anim.b_renamed f3447b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f3448c;
    private int d_renamed;
    private boolean e_renamed;
    private boolean f_renamed;
    private boolean g_renamed;
    private com.oplus.anim.n_renamed h_renamed;
    private java.util.Set<com.oplus.anim.l_renamed> i_renamed;
    private com.oplus.anim.f_renamed<com.oplus.anim.a_renamed> j_renamed;
    private com.oplus.anim.a_renamed k_renamed;

    public EffectiveAnimationView(android.content.Context context) {
        super(context);
        this.f3447b = new com.oplus.anim.b_renamed();
        this.e_renamed = false;
        this.f_renamed = false;
        this.g_renamed = false;
        this.h_renamed = com.oplus.anim.n_renamed.AUTOMATIC;
        this.i_renamed = new java.util.HashSet();
        a_renamed((android.util.AttributeSet) null);
    }

    public EffectiveAnimationView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3447b = new com.oplus.anim.b_renamed();
        this.e_renamed = false;
        this.f_renamed = false;
        this.g_renamed = false;
        this.h_renamed = com.oplus.anim.n_renamed.AUTOMATIC;
        this.i_renamed = new java.util.HashSet();
        a_renamed(attributeSet);
    }

    public EffectiveAnimationView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f3447b = new com.oplus.anim.b_renamed();
        this.e_renamed = false;
        this.f_renamed = false;
        this.g_renamed = false;
        this.h_renamed = com.oplus.anim.n_renamed.AUTOMATIC;
        this.i_renamed = new java.util.HashSet();
        a_renamed(attributeSet);
    }

    private void a_renamed(android.util.AttributeSet attributeSet) {
        java.lang.String string;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.oplus.anim.R_renamed.styleable.EffectiveAnimationView);
        if (!isInEditMode()) {
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_rawRes);
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_fileName);
            boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_url);
            if (zHasValue && zHasValue2) {
                throw new java.lang.IllegalArgumentException("rawRes and fileName cannot be_renamed used at_renamed the same time. Please use only one at_renamed once.");
            }
            if (zHasValue) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (zHasValue2) {
                java.lang.String string2 = typedArrayObtainStyledAttributes.getString(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_fileName);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_url)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (typedArrayObtainStyledAttributes.getBoolean(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_autoPlay, false)) {
            this.f_renamed = true;
            this.g_renamed = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_loop, false)) {
            this.f3447b.e_renamed(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_speed, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_progress, 0.0f));
        a_renamed(typedArrayObtainStyledAttributes.getBoolean(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_enableMergePathsForKitKatAndAbove, false));
        if (typedArrayObtainStyledAttributes.hasValue(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_colorFilter)) {
            a_renamed(new com.oplus.anim.c_renamed.f_renamed("**"), com.oplus.anim.d_renamed.z_renamed, new com.oplus.anim.g_renamed.b_renamed(new com.oplus.anim.o_renamed(typedArrayObtainStyledAttributes.getColor(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_colorFilter, 0))));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_scale)) {
            this.f3447b.d_renamed(typedArrayObtainStyledAttributes.getFloat(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_scale, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_renderMode)) {
            this.h_renamed = com.oplus.anim.n_renamed.values()[typedArrayObtainStyledAttributes.getInt(com.oplus.anim.R_renamed.styleable.EffectiveAnimationView_anim_renderMode, 0)];
        }
        typedArrayObtainStyledAttributes.recycle();
        h_renamed();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i_renamed) {
        a_renamed();
        super.setImageResource(i_renamed);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        a_renamed();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        a_renamed();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = getDrawable();
        com.oplus.anim.b_renamed bVar = this.f3447b;
        if (drawable2 == bVar) {
            super.invalidateDrawable(bVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        com.oplus.anim.EffectiveAnimationView.SavedState savedState = new com.oplus.anim.EffectiveAnimationView.SavedState(super.onSaveInstanceState());
        savedState.animationName = this.f3448c;
        savedState.animationResId = this.d_renamed;
        savedState.progress = this.f3447b.u_renamed();
        savedState.isAnimating = this.f3447b.n_renamed();
        savedState.imageAssetsFolder = this.f3447b.b_renamed();
        savedState.repeatMode = this.f3447b.l_renamed();
        savedState.repeatCount = this.f3447b.m_renamed();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.oplus.anim.EffectiveAnimationView.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.oplus.anim.EffectiveAnimationView.SavedState savedState = (com.oplus.anim.EffectiveAnimationView.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f3448c = savedState.animationName;
        if (!android.text.TextUtils.isEmpty(this.f3448c)) {
            setAnimation(this.f3448c);
        }
        this.d_renamed = savedState.animationResId;
        int i_renamed = this.d_renamed;
        if (i_renamed != 0) {
            setAnimation(i_renamed);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            b_renamed();
        }
        this.f3447b.a_renamed(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i_renamed) {
        if (i_renamed == 0) {
            if (this.e_renamed) {
                this.e_renamed = false;
                c_renamed();
                return;
            }
            return;
        }
        if (d_renamed()) {
            this.e_renamed = true;
            f_renamed();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.g_renamed && this.f_renamed) {
            b_renamed();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (d_renamed()) {
            e_renamed();
            this.f_renamed = true;
        }
        super.onDetachedFromWindow();
    }

    public void a_renamed(boolean z_renamed) {
        this.f3447b.a_renamed(z_renamed);
    }

    public void setAnimation(int i_renamed) {
        this.d_renamed = i_renamed;
        this.f3448c = null;
        setCompositionTask(com.oplus.anim.g_renamed.a_renamed(getContext(), i_renamed));
    }

    public void setAnimationUsingActivityContext(int i_renamed) {
        this.d_renamed = i_renamed;
        this.f3448c = null;
        setCompositionTask(com.oplus.anim.g_renamed.b_renamed(getContext(), i_renamed));
    }

    public void setAnimation(java.lang.String str) {
        this.f3448c = str;
        this.d_renamed = 0;
        setCompositionTask(com.oplus.anim.g_renamed.a_renamed(getContext().getAssets(), str));
    }

    @java.lang.Deprecated
    public void setAnimationFromJson(java.lang.String str) {
        a_renamed(str, (java.lang.String) null);
    }

    public void a_renamed(java.lang.String str, java.lang.String str2) {
        a_renamed(new android.util.JsonReader(new java.io.StringReader(str)), str2);
    }

    public void a_renamed(android.util.JsonReader jsonReader, java.lang.String str) {
        setCompositionTask(com.oplus.anim.g_renamed.a_renamed(jsonReader, str));
    }

    public void setAnimationFromUrl(java.lang.String str) {
        setCompositionTask(com.oplus.anim.g_renamed.a_renamed(getContext(), str));
    }

    private void setCompositionTask(com.oplus.anim.f_renamed<com.oplus.anim.a_renamed> fVar) {
        g_renamed();
        a_renamed();
        this.j_renamed = fVar.a_renamed(new com.oplus.anim.EffectiveAnimationView.b_renamed(this)).b_renamed(new com.oplus.anim.EffectiveAnimationView.a_renamed(this));
    }

    public void a_renamed() {
        com.oplus.anim.f_renamed<com.oplus.anim.a_renamed> fVar = this.j_renamed;
        if (fVar != null) {
            fVar.a_renamed();
            this.j_renamed.b_renamed();
        }
    }

    public com.oplus.anim.a_renamed getComposition() {
        return this.k_renamed;
    }

    public void setComposition(com.oplus.anim.a_renamed aVar) {
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.b_renamed("Set Composition \n_renamed" + aVar);
        }
        this.f3447b.setCallback(this);
        this.k_renamed = aVar;
        boolean zA = this.f3447b.a_renamed(aVar);
        h_renamed();
        if (getDrawable() != this.f3447b || zA) {
            setImageDrawable(null);
            setImageDrawable(this.f3447b);
            requestLayout();
            java.util.Iterator<com.oplus.anim.l_renamed> it = this.i_renamed.iterator();
            while (it.hasNext()) {
                it.next().a_renamed(aVar);
            }
        }
    }

    public void b_renamed() {
        this.f3447b.e_renamed();
        h_renamed();
    }

    public void c_renamed() {
        this.f3447b.g_renamed();
        h_renamed();
    }

    public void setMinFrame(int i_renamed) {
        this.f3447b.a_renamed(i_renamed);
    }

    public float getMinFrame() {
        return this.f3447b.h_renamed();
    }

    public void setMinFrame(java.lang.String str) {
        this.f3447b.b_renamed(str);
    }

    public void setMinProgress(float f_renamed) {
        this.f3447b.a_renamed(f_renamed);
    }

    public void setMaxFrame(int i_renamed) {
        this.f3447b.b_renamed(i_renamed);
    }

    public float getMaxFrame() {
        return this.f3447b.i_renamed();
    }

    public void setMaxFrame(java.lang.String str) {
        this.f3447b.c_renamed(str);
    }

    public void setMaxProgress(float f_renamed) {
        this.f3447b.b_renamed(f_renamed);
    }

    public void setMinAndMaxFrame(java.lang.String str) {
        this.f3447b.d_renamed(str);
    }

    public float getSpeed() {
        return this.f3447b.j_renamed();
    }

    public void setSpeed(float f_renamed) {
        this.f3447b.c_renamed(f_renamed);
    }

    public int getRepeatMode() {
        return this.f3447b.l_renamed();
    }

    public void setRepeatMode(int i_renamed) {
        this.f3447b.d_renamed(i_renamed);
    }

    public int getRepeatCount() {
        return this.f3447b.m_renamed();
    }

    public void setRepeatCount(int i_renamed) {
        this.f3447b.e_renamed(i_renamed);
    }

    public boolean d_renamed() {
        return this.f3447b.n_renamed();
    }

    public java.lang.String getImageAssetsFolder() {
        return this.f3447b.b_renamed();
    }

    public void setImageAssetsFolder(java.lang.String str) {
        this.f3447b.a_renamed(str);
    }

    public void setImageAssetDelegate(com.oplus.anim.j_renamed jVar) {
        this.f3447b.a_renamed(jVar);
    }

    public void setFontAssetDelegate(com.oplus.anim.i_renamed iVar) {
        this.f3447b.a_renamed(iVar);
    }

    public void setTextDelegate(com.oplus.anim.p_renamed pVar) {
        this.f3447b.a_renamed(pVar);
    }

    public <T_renamed> void a_renamed(com.oplus.anim.c_renamed.f_renamed fVar, T_renamed t_renamed, com.oplus.anim.g_renamed.b_renamed<T_renamed> bVar) {
        this.f3447b.a_renamed(fVar, t_renamed, bVar);
    }

    /* JADX INFO: Add missing generic type declarations: [T_renamed] */
    /* renamed from: com.oplus.anim.EffectiveAnimationView$1, reason: invalid class name */
    class SceneLoader_2<T_renamed> extends com.oplus.anim.g_renamed.b_renamed<T_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.anim.g_renamed.e_renamed f3449a;

        @Override // com.oplus.anim.g_renamed.b_renamed
        public T_renamed a_renamed(com.oplus.anim.g_renamed.a_renamed<T_renamed> aVar) {
            return (T_renamed) this.f3449a.a_renamed(aVar);
        }
    }

    public float getScale() {
        return this.f3447b.q_renamed();
    }

    public void setScale(float f_renamed) {
        this.f3447b.d_renamed(f_renamed);
        if (getDrawable() == this.f3447b) {
            setImageDrawable(null);
            setImageDrawable(this.f3447b);
        }
    }

    public void e_renamed() {
        this.f3447b.s_renamed();
        h_renamed();
    }

    public void f_renamed() {
        this.f3447b.t_renamed();
        h_renamed();
    }

    public int getFrame() {
        return this.f3447b.k_renamed();
    }

    public void setFrame(int i_renamed) {
        this.f3447b.c_renamed(i_renamed);
    }

    public float getProgress() {
        return this.f3447b.u_renamed();
    }

    public void setProgress(float f_renamed) {
        this.f3447b.e_renamed(f_renamed);
    }

    public long getDuration() {
        com.oplus.anim.a_renamed aVar = this.k_renamed;
        if (aVar != null) {
            return (long) aVar.e_renamed();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z_renamed) {
        this.f3447b.b_renamed(z_renamed);
    }

    public com.oplus.anim.m_renamed getPerformanceTracker() {
        return this.f3447b.c_renamed();
    }

    private void g_renamed() {
        this.k_renamed = null;
        this.f3447b.d_renamed();
    }

    public void setRenderMode(com.oplus.anim.n_renamed nVar) {
        this.h_renamed = nVar;
        h_renamed();
    }

    private void h_renamed() {
        com.oplus.anim.a_renamed aVar;
        if (com.oplus.anim.f_renamed.f_renamed.f3677b) {
            com.oplus.anim.f_renamed.f_renamed.a_renamed("Render mode : " + this.h_renamed.name());
        }
        int i_renamed = com.oplus.anim.EffectiveAnimationView.XPanMode_2.f3450a[this.h_renamed.ordinal()];
        if (i_renamed == 1) {
            setLayerType(2, null);
            return;
        }
        if (i_renamed == 2) {
            setLayerType(1, null);
            return;
        }
        boolean z_renamed = false;
        if (i_renamed == 3) {
            setLayerType(0, null);
            return;
        }
        if (i_renamed != 4) {
            return;
        }
        com.oplus.anim.a_renamed aVar2 = this.k_renamed;
        if ((aVar2 == null || !aVar2.a_renamed() || android.os.Build.VERSION.SDK_INT >= 28) && ((aVar = this.k_renamed) == null || aVar.b_renamed() <= 4)) {
            z_renamed = true;
        }
        setLayerType(z_renamed ? 2 : 1, null);
    }

    /* renamed from: com.oplus.anim.EffectiveAnimationView$2, reason: invalid class name */
    static /* synthetic */ class XPanMode_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f3450a = new int[com.oplus.anim.n_renamed.values().length];

        static {
            try {
                f3450a[com.oplus.anim.n_renamed.HARDWARE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f3450a[com.oplus.anim.n_renamed.SOFTWARE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f3450a[com.oplus.anim.n_renamed.NONE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f3450a[com.oplus.anim.n_renamed.AUTOMATIC.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    private static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<com.oplus.anim.EffectiveAnimationView.SavedState> CREATOR = new android.os.Parcelable.Creator<com.oplus.anim.EffectiveAnimationView.SavedState>() { // from class: com.oplus.anim.EffectiveAnimationView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.anim.EffectiveAnimationView.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.oplus.anim.EffectiveAnimationView.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.oplus.anim.EffectiveAnimationView.SavedState[] newArray(int i_renamed) {
                return new com.oplus.anim.EffectiveAnimationView.SavedState[i_renamed];
            }
        };
        java.lang.String animationName;
        int animationResId;
        java.lang.String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        /* synthetic */ SavedState(android.os.Parcel parcel, com.oplus.anim.EffectiveAnimationView.SceneLoader_2 anonymousClass1) {
            this(parcel);
        }

        SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() == 1;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }

    static class a_renamed implements com.oplus.anim.c_renamed<java.lang.Throwable> {

        /* renamed from: a_renamed, reason: collision with root package name */
        java.lang.ref.WeakReference<com.oplus.anim.EffectiveAnimationView> f3451a;

        a_renamed(com.oplus.anim.EffectiveAnimationView effectiveAnimationView) {
            this.f3451a = new java.lang.ref.WeakReference<>(effectiveAnimationView);
        }

        @Override // com.oplus.anim.c_renamed
        public void a_renamed(java.lang.Throwable th) {
            java.lang.ref.WeakReference<com.oplus.anim.EffectiveAnimationView> weakReference = this.f3451a;
            if (weakReference != null && weakReference.get() != null) {
                throw new java.lang.IllegalStateException("Unable to parse composition", th);
            }
        }
    }

    static class b_renamed implements com.oplus.anim.c_renamed<com.oplus.anim.a_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        java.lang.ref.WeakReference<com.oplus.anim.EffectiveAnimationView> f3452a;

        b_renamed(com.oplus.anim.EffectiveAnimationView effectiveAnimationView) {
            this.f3452a = new java.lang.ref.WeakReference<>(effectiveAnimationView);
        }

        @Override // com.oplus.anim.c_renamed
        public void a_renamed(com.oplus.anim.a_renamed aVar) {
            java.lang.ref.WeakReference<com.oplus.anim.EffectiveAnimationView> weakReference = this.f3452a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f3452a.get().setComposition(aVar);
        }
    }
}
