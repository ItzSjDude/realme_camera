package com.airbnb.lottie;

/* loaded from: classes.dex */
public class LottieAnimationView extends androidx.appcompat.widget.AppCompatImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f1976a = "LottieAnimationView";

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final com.airbnb.lottie.h_renamed<java.lang.Throwable> f1977b = new com.airbnb.lottie.h_renamed<java.lang.Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
        @Override // com.airbnb.lottie.h_renamed
        public void a_renamed(java.lang.Throwable th) {
            if (com.airbnb.lottie.f_renamed.h_renamed.a_renamed(th)) {
                com.airbnb.lottie.f_renamed.d_renamed.a_renamed("Unable to load composition.", th);
                return;
            }
            throw new java.lang.IllegalStateException("Unable to parse composition", th);
        }
    };

    /* renamed from: c_renamed, reason: collision with root package name */
    private final com.airbnb.lottie.h_renamed<com.airbnb.lottie.d_renamed> f1978c;
    private final com.airbnb.lottie.h_renamed<java.lang.Throwable> d_renamed;
    private com.airbnb.lottie.h_renamed<java.lang.Throwable> e_renamed;
    private int f_renamed;
    private final com.airbnb.lottie.f_renamed g_renamed;
    private boolean h_renamed;
    private java.lang.String i_renamed;
    private int j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private boolean m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private com.airbnb.lottie.o_renamed q_renamed;
    private final java.util.Set<com.airbnb.lottie.j_renamed> r_renamed;
    private int s_renamed;
    private com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> t_renamed;
    private com.airbnb.lottie.d_renamed u_renamed;

    public LottieAnimationView(android.content.Context context) {
        super(context);
        this.f1978c = new com.airbnb.lottie.h_renamed<com.airbnb.lottie.d_renamed>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.h_renamed
            public void a_renamed(com.airbnb.lottie.d_renamed dVar) {
                com.airbnb.lottie.LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.d_renamed = new com.airbnb.lottie.h_renamed<java.lang.Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.h_renamed
            public void a_renamed(java.lang.Throwable th) {
                if (com.airbnb.lottie.LottieAnimationView.this.f_renamed != 0) {
                    com.airbnb.lottie.LottieAnimationView lottieAnimationView = com.airbnb.lottie.LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.f_renamed);
                }
                (com.airbnb.lottie.LottieAnimationView.this.e_renamed == null ? com.airbnb.lottie.LottieAnimationView.f1977b : com.airbnb.lottie.LottieAnimationView.this.e_renamed).a_renamed(th);
            }
        };
        this.f_renamed = 0;
        this.g_renamed = new com.airbnb.lottie.f_renamed();
        this.k_renamed = false;
        this.l_renamed = false;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = true;
        this.q_renamed = com.airbnb.lottie.o_renamed.AUTOMATIC;
        this.r_renamed = new java.util.HashSet();
        this.s_renamed = 0;
        a_renamed((android.util.AttributeSet) null, com.airbnb.lottie.R_renamed.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1978c = new com.airbnb.lottie.h_renamed<com.airbnb.lottie.d_renamed>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.h_renamed
            public void a_renamed(com.airbnb.lottie.d_renamed dVar) {
                com.airbnb.lottie.LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.d_renamed = new com.airbnb.lottie.h_renamed<java.lang.Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.h_renamed
            public void a_renamed(java.lang.Throwable th) {
                if (com.airbnb.lottie.LottieAnimationView.this.f_renamed != 0) {
                    com.airbnb.lottie.LottieAnimationView lottieAnimationView = com.airbnb.lottie.LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.f_renamed);
                }
                (com.airbnb.lottie.LottieAnimationView.this.e_renamed == null ? com.airbnb.lottie.LottieAnimationView.f1977b : com.airbnb.lottie.LottieAnimationView.this.e_renamed).a_renamed(th);
            }
        };
        this.f_renamed = 0;
        this.g_renamed = new com.airbnb.lottie.f_renamed();
        this.k_renamed = false;
        this.l_renamed = false;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = true;
        this.q_renamed = com.airbnb.lottie.o_renamed.AUTOMATIC;
        this.r_renamed = new java.util.HashSet();
        this.s_renamed = 0;
        a_renamed(attributeSet, com.airbnb.lottie.R_renamed.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f1978c = new com.airbnb.lottie.h_renamed<com.airbnb.lottie.d_renamed>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.h_renamed
            public void a_renamed(com.airbnb.lottie.d_renamed dVar) {
                com.airbnb.lottie.LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.d_renamed = new com.airbnb.lottie.h_renamed<java.lang.Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.h_renamed
            public void a_renamed(java.lang.Throwable th) {
                if (com.airbnb.lottie.LottieAnimationView.this.f_renamed != 0) {
                    com.airbnb.lottie.LottieAnimationView lottieAnimationView = com.airbnb.lottie.LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.f_renamed);
                }
                (com.airbnb.lottie.LottieAnimationView.this.e_renamed == null ? com.airbnb.lottie.LottieAnimationView.f1977b : com.airbnb.lottie.LottieAnimationView.this.e_renamed).a_renamed(th);
            }
        };
        this.f_renamed = 0;
        this.g_renamed = new com.airbnb.lottie.f_renamed();
        this.k_renamed = false;
        this.l_renamed = false;
        this.m_renamed = false;
        this.n_renamed = false;
        this.o_renamed = false;
        this.p_renamed = true;
        this.q_renamed = com.airbnb.lottie.o_renamed.AUTOMATIC;
        this.r_renamed = new java.util.HashSet();
        this.s_renamed = 0;
        a_renamed(attributeSet, i_renamed);
    }

    private void a_renamed(android.util.AttributeSet attributeSet, int i_renamed) {
        java.lang.String string;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.airbnb.lottie.R_renamed.styleable.LottieAnimationView, i_renamed, 0);
        this.p_renamed = typedArrayObtainStyledAttributes.getBoolean(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_rawRes);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_fileName);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_url);
        if (zHasValue && zHasValue2) {
            throw new java.lang.IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be_renamed used at_renamed the same time. Please use only one at_renamed once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            java.lang.String string2 = typedArrayObtainStyledAttributes.getString(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.m_renamed = true;
            this.o_renamed = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_loop, false)) {
            this.g_renamed.e_renamed(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_progress, 0.0f));
        a_renamed(typedArrayObtainStyledAttributes.getBoolean(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (typedArrayObtainStyledAttributes.hasValue(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_colorFilter)) {
            a_renamed(new com.airbnb.lottie.c_renamed.e_renamed("**"), (com.airbnb.lottie.c_renamed.e_renamed) com.airbnb.lottie.k_renamed.E_renamed, (com.airbnb.lottie.g_renamed.c_renamed<com.airbnb.lottie.c_renamed.e_renamed>) new com.airbnb.lottie.g_renamed.c_renamed(new com.airbnb.lottie.p_renamed(androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(getContext(), typedArrayObtainStyledAttributes.getResourceId(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor())));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_scale)) {
            this.g_renamed.e_renamed(typedArrayObtainStyledAttributes.getFloat(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_renderMode)) {
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(com.airbnb.lottie.R_renamed.styleable.LottieAnimationView_lottie_renderMode, com.airbnb.lottie.o_renamed.AUTOMATIC.ordinal());
            if (iOrdinal >= com.airbnb.lottie.o_renamed.values().length) {
                iOrdinal = com.airbnb.lottie.o_renamed.AUTOMATIC.ordinal();
            }
            setRenderMode(com.airbnb.lottie.o_renamed.values()[iOrdinal]);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.g_renamed.a_renamed(java.lang.Boolean.valueOf(com.airbnb.lottie.f_renamed.h_renamed.a_renamed(getContext()) != 0.0f));
        j_renamed();
        this.h_renamed = true;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i_renamed) {
        h_renamed();
        super.setImageResource(i_renamed);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        h_renamed();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        h_renamed();
        super.setImageBitmap(bitmap);
    }

    @Override // android.view.View
    public void unscheduleDrawable(android.graphics.drawable.Drawable drawable) {
        com.airbnb.lottie.f_renamed fVar;
        if (!this.n_renamed && drawable == (fVar = this.g_renamed) && fVar.p_renamed()) {
            f_renamed();
        } else if (!this.n_renamed && (drawable instanceof com.airbnb.lottie.f_renamed)) {
            com.airbnb.lottie.f_renamed fVar2 = (com.airbnb.lottie.f_renamed) drawable;
            if (fVar2.p_renamed()) {
                fVar2.v_renamed();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = getDrawable();
        com.airbnb.lottie.f_renamed fVar = this.g_renamed;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        com.airbnb.lottie.LottieAnimationView.SavedState savedState = new com.airbnb.lottie.LottieAnimationView.SavedState(super.onSaveInstanceState());
        savedState.animationName = this.i_renamed;
        savedState.animationResId = this.j_renamed;
        savedState.progress = this.g_renamed.w_renamed();
        savedState.isAnimating = this.g_renamed.p_renamed() || (!androidx.core.h_renamed.v_renamed.D_renamed(this) && this.m_renamed);
        savedState.imageAssetsFolder = this.g_renamed.b_renamed();
        savedState.repeatMode = this.g_renamed.n_renamed();
        savedState.repeatCount = this.g_renamed.o_renamed();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.airbnb.lottie.LottieAnimationView.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.airbnb.lottie.LottieAnimationView.SavedState savedState = (com.airbnb.lottie.LottieAnimationView.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.i_renamed = savedState.animationName;
        if (!android.text.TextUtils.isEmpty(this.i_renamed)) {
            setAnimation(this.i_renamed);
        }
        this.j_renamed = savedState.animationResId;
        int i_renamed = this.j_renamed;
        if (i_renamed != 0) {
            setAnimation(i_renamed);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            a_renamed();
        }
        this.g_renamed.a_renamed(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i_renamed) {
        if (this.h_renamed) {
            if (isShown()) {
                if (this.l_renamed) {
                    b_renamed();
                } else if (this.k_renamed) {
                    a_renamed();
                }
                this.l_renamed = false;
                this.k_renamed = false;
                return;
            }
            if (d_renamed()) {
                f_renamed();
                this.l_renamed = true;
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.o_renamed || this.m_renamed)) {
            a_renamed();
            this.o_renamed = false;
            this.m_renamed = false;
        }
        if (android.os.Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (d_renamed()) {
            e_renamed();
            this.m_renamed = true;
        }
        super.onDetachedFromWindow();
    }

    public void a_renamed(boolean z_renamed) {
        this.g_renamed.a_renamed(z_renamed);
    }

    public void setCacheComposition(boolean z_renamed) {
        this.p_renamed = z_renamed;
    }

    public void setOutlineMasksAndMattes(boolean z_renamed) {
        this.g_renamed.c_renamed(z_renamed);
    }

    public void setAnimation(int i_renamed) {
        this.j_renamed = i_renamed;
        this.i_renamed = null;
        setCompositionTask(a_renamed(i_renamed));
    }

    private com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> a_renamed(final int i_renamed) {
        if (isInEditMode()) {
            return new com.airbnb.lottie.m_renamed<>(new java.util.concurrent.Callable<com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed>>() { // from class: com.airbnb.lottie.LottieAnimationView.4
                @Override // java.util.concurrent.Callable
                /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
                public com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> call() {
                    return com.airbnb.lottie.LottieAnimationView.this.p_renamed ? com.airbnb.lottie.e_renamed.b_renamed(com.airbnb.lottie.LottieAnimationView.this.getContext(), i_renamed) : com.airbnb.lottie.e_renamed.b_renamed(com.airbnb.lottie.LottieAnimationView.this.getContext(), i_renamed, (java.lang.String) null);
                }
            }, true);
        }
        return this.p_renamed ? com.airbnb.lottie.e_renamed.a_renamed(getContext(), i_renamed) : com.airbnb.lottie.e_renamed.a_renamed(getContext(), i_renamed, (java.lang.String) null);
    }

    public void setAnimation(java.lang.String str) {
        this.i_renamed = str;
        this.j_renamed = 0;
        setCompositionTask(a_renamed(str));
    }

    private com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> a_renamed(final java.lang.String str) {
        if (isInEditMode()) {
            return new com.airbnb.lottie.m_renamed<>(new java.util.concurrent.Callable<com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed>>() { // from class: com.airbnb.lottie.LottieAnimationView.5
                @Override // java.util.concurrent.Callable
                /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
                public com.airbnb.lottie.l_renamed<com.airbnb.lottie.d_renamed> call() {
                    return com.airbnb.lottie.LottieAnimationView.this.p_renamed ? com.airbnb.lottie.e_renamed.c_renamed(com.airbnb.lottie.LottieAnimationView.this.getContext(), str) : com.airbnb.lottie.e_renamed.c_renamed(com.airbnb.lottie.LottieAnimationView.this.getContext(), str, null);
                }
            }, true);
        }
        return this.p_renamed ? com.airbnb.lottie.e_renamed.b_renamed(getContext(), str) : com.airbnb.lottie.e_renamed.b_renamed(getContext(), str, (java.lang.String) null);
    }

    @java.lang.Deprecated
    public void setAnimationFromJson(java.lang.String str) {
        a_renamed(str, (java.lang.String) null);
    }

    public void a_renamed(java.lang.String str, java.lang.String str2) {
        a_renamed(new java.io.ByteArrayInputStream(str.getBytes()), str2);
    }

    public void a_renamed(java.io.InputStream inputStream, java.lang.String str) {
        setCompositionTask(com.airbnb.lottie.e_renamed.a_renamed(inputStream, str));
    }

    public void setAnimationFromUrl(java.lang.String str) {
        setCompositionTask(this.p_renamed ? com.airbnb.lottie.e_renamed.a_renamed(getContext(), str) : com.airbnb.lottie.e_renamed.a_renamed(getContext(), str, (java.lang.String) null));
    }

    public void setFailureListener(com.airbnb.lottie.h_renamed<java.lang.Throwable> hVar) {
        this.e_renamed = hVar;
    }

    public void setFallbackResource(int i_renamed) {
        this.f_renamed = i_renamed;
    }

    private void setCompositionTask(com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> mVar) {
        i_renamed();
        h_renamed();
        this.t_renamed = mVar.a_renamed(this.f1978c).c_renamed(this.d_renamed);
    }

    private void h_renamed() {
        com.airbnb.lottie.m_renamed<com.airbnb.lottie.d_renamed> mVar = this.t_renamed;
        if (mVar != null) {
            mVar.b_renamed(this.f1978c);
            this.t_renamed.d_renamed(this.d_renamed);
        }
    }

    public void setComposition(com.airbnb.lottie.d_renamed dVar) {
        if (com.airbnb.lottie.c_renamed.f2048a) {
            android.util.Log.v_renamed(f1976a, "Set Composition \n_renamed" + dVar);
        }
        this.g_renamed.setCallback(this);
        this.u_renamed = dVar;
        this.n_renamed = true;
        boolean zA = this.g_renamed.a_renamed(dVar);
        this.n_renamed = false;
        j_renamed();
        if (getDrawable() != this.g_renamed || zA) {
            if (!zA) {
                k_renamed();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            java.util.Iterator<com.airbnb.lottie.j_renamed> it = this.r_renamed.iterator();
            while (it.hasNext()) {
                it.next().onCompositionLoaded(dVar);
            }
        }
    }

    public com.airbnb.lottie.d_renamed getComposition() {
        return this.u_renamed;
    }

    public void a_renamed() {
        if (isShown()) {
            this.g_renamed.f_renamed();
            j_renamed();
        } else {
            this.k_renamed = true;
        }
    }

    public void b_renamed() {
        if (isShown()) {
            this.g_renamed.h_renamed();
            j_renamed();
        } else {
            this.k_renamed = false;
            this.l_renamed = true;
        }
    }

    public void setMinFrame(int i_renamed) {
        this.g_renamed.a_renamed(i_renamed);
    }

    public float getMinFrame() {
        return this.g_renamed.i_renamed();
    }

    public void setMinProgress(float f_renamed) {
        this.g_renamed.a_renamed(f_renamed);
    }

    public void setMaxFrame(int i_renamed) {
        this.g_renamed.b_renamed(i_renamed);
    }

    public float getMaxFrame() {
        return this.g_renamed.j_renamed();
    }

    public void setMaxProgress(float f_renamed) {
        this.g_renamed.b_renamed(f_renamed);
    }

    public void setMinFrame(java.lang.String str) {
        this.g_renamed.b_renamed(str);
    }

    public void setMaxFrame(java.lang.String str) {
        this.g_renamed.c_renamed(str);
    }

    public void setMinAndMaxFrame(java.lang.String str) {
        this.g_renamed.d_renamed(str);
    }

    public void setSpeed(float f_renamed) {
        this.g_renamed.c_renamed(f_renamed);
    }

    public float getSpeed() {
        return this.g_renamed.k_renamed();
    }

    public void a_renamed(android.animation.Animator.AnimatorListener animatorListener) {
        this.g_renamed.a_renamed(animatorListener);
    }

    public void c_renamed() {
        this.g_renamed.l_renamed();
    }

    public void setRepeatMode(int i_renamed) {
        this.g_renamed.d_renamed(i_renamed);
    }

    public int getRepeatMode() {
        return this.g_renamed.n_renamed();
    }

    public void setRepeatCount(int i_renamed) {
        this.g_renamed.e_renamed(i_renamed);
    }

    public int getRepeatCount() {
        return this.g_renamed.o_renamed();
    }

    public boolean d_renamed() {
        return this.g_renamed.p_renamed();
    }

    public void setImageAssetsFolder(java.lang.String str) {
        this.g_renamed.a_renamed(str);
    }

    public java.lang.String getImageAssetsFolder() {
        return this.g_renamed.b_renamed();
    }

    public void setImageAssetDelegate(com.airbnb.lottie.b_renamed bVar) {
        this.g_renamed.a_renamed(bVar);
    }

    public void setFontAssetDelegate(com.airbnb.lottie.a_renamed aVar) {
        this.g_renamed.a_renamed(aVar);
    }

    public void setTextDelegate(com.airbnb.lottie.q_renamed qVar) {
        this.g_renamed.a_renamed(qVar);
    }

    public <T_renamed> void a_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar, T_renamed t_renamed, com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        this.g_renamed.a_renamed(eVar, t_renamed, cVar);
    }

    public <T_renamed> void a_renamed(com.airbnb.lottie.c_renamed.e_renamed eVar, T_renamed t_renamed, final com.airbnb.lottie.g_renamed.e_renamed<T_renamed> eVar2) {
        this.g_renamed.a_renamed(eVar, t_renamed, new com.airbnb.lottie.g_renamed.c_renamed<T_renamed>() { // from class: com.airbnb.lottie.LottieAnimationView.6
            @Override // com.airbnb.lottie.g_renamed.c_renamed
            public T_renamed a_renamed(com.airbnb.lottie.g_renamed.b_renamed<T_renamed> bVar) {
                return (T_renamed) eVar2.getValue(bVar);
            }
        });
    }

    public void setScale(float f_renamed) {
        this.g_renamed.e_renamed(f_renamed);
        if (getDrawable() == this.g_renamed) {
            k_renamed();
        }
    }

    public float getScale() {
        return this.g_renamed.s_renamed();
    }

    public void e_renamed() {
        this.m_renamed = false;
        this.l_renamed = false;
        this.k_renamed = false;
        this.g_renamed.u_renamed();
        j_renamed();
    }

    public void f_renamed() {
        this.o_renamed = false;
        this.m_renamed = false;
        this.l_renamed = false;
        this.k_renamed = false;
        this.g_renamed.v_renamed();
        j_renamed();
    }

    public void setFrame(int i_renamed) {
        this.g_renamed.c_renamed(i_renamed);
    }

    public int getFrame() {
        return this.g_renamed.m_renamed();
    }

    public void setProgress(float f_renamed) {
        this.g_renamed.d_renamed(f_renamed);
    }

    public float getProgress() {
        return this.g_renamed.w_renamed();
    }

    public long getDuration() {
        com.airbnb.lottie.d_renamed dVar = this.u_renamed;
        if (dVar != null) {
            return (long) dVar.e_renamed();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z_renamed) {
        this.g_renamed.b_renamed(z_renamed);
    }

    public com.airbnb.lottie.n_renamed getPerformanceTracker() {
        return this.g_renamed.c_renamed();
    }

    private void i_renamed() {
        this.u_renamed = null;
        this.g_renamed.e_renamed();
    }

    public void setSafeMode(boolean z_renamed) {
        this.g_renamed.e_renamed(z_renamed);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z_renamed) {
        com.airbnb.lottie.c_renamed.a_renamed("buildDrawingCache");
        this.s_renamed++;
        super.buildDrawingCache(z_renamed);
        if (this.s_renamed == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z_renamed) == null) {
            setRenderMode(com.airbnb.lottie.o_renamed.HARDWARE);
        }
        this.s_renamed--;
        com.airbnb.lottie.c_renamed.b_renamed("buildDrawingCache");
    }

    public void setRenderMode(com.airbnb.lottie.o_renamed oVar) {
        this.q_renamed = oVar;
        j_renamed();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z_renamed) {
        this.g_renamed.d_renamed(z_renamed);
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f1987a = new int[com.airbnb.lottie.o_renamed.values().length];

        static {
            try {
                f1987a[com.airbnb.lottie.o_renamed.HARDWARE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f1987a[com.airbnb.lottie.o_renamed.SOFTWARE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f1987a[com.airbnb.lottie.o_renamed.AUTOMATIC.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j_renamed() {
        /*
            r5 = this;
            int[] r0 = com.airbnb.lottie.LottieAnimationView.AnonymousClass7.f1987a
            com.airbnb.lottie.o_renamed r1 = r5.q_renamed
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L4a
            if (r0 == r1) goto L13
            r3 = 3
            if (r0 == r3) goto L15
        L13:
            r1 = r2
            goto L4a
        L15:
            com.airbnb.lottie.d_renamed r0 = r5.u_renamed
            r3 = 0
            if (r0 == 0) goto L27
            boolean r0 = r0.a_renamed()
            if (r0 == 0) goto L27
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L27
            goto L48
        L27:
            com.airbnb.lottie.d_renamed r0 = r5.u_renamed
            if (r0 == 0) goto L33
            int r0 = r0.b_renamed()
            r4 = 4
            if (r0 <= r4) goto L33
            goto L48
        L33:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r0 >= r4) goto L3a
            goto L48
        L3a:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r0 == r4) goto L48
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 25
            if (r0 != r4) goto L47
            goto L48
        L47:
            r3 = r2
        L48:
            if (r3 == 0) goto L13
        L4a:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L54
            r0 = 0
            r5.setLayerType(r1, r0)
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.j_renamed():void");
    }

    public boolean a_renamed(com.airbnb.lottie.j_renamed jVar) {
        com.airbnb.lottie.d_renamed dVar = this.u_renamed;
        if (dVar != null) {
            jVar.onCompositionLoaded(dVar);
        }
        return this.r_renamed.add(jVar);
    }

    private void k_renamed() {
        boolean zD = d_renamed();
        setImageDrawable(null);
        setImageDrawable(this.g_renamed);
        if (zD) {
            this.g_renamed.h_renamed();
        }
    }

    private static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<com.airbnb.lottie.LottieAnimationView.SavedState> CREATOR = new android.os.Parcelable.Creator<com.airbnb.lottie.LottieAnimationView.SavedState>() { // from class: com.airbnb.lottie.LottieAnimationView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.airbnb.lottie.LottieAnimationView.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.airbnb.lottie.LottieAnimationView.SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.airbnb.lottie.LottieAnimationView.SavedState[] newArray(int i_renamed) {
                return new com.airbnb.lottie.LottieAnimationView.SavedState[i_renamed];
            }
        };
        java.lang.String animationName;
        int animationResId;
        java.lang.String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

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
}
