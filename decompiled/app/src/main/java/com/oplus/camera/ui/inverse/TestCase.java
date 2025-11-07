package com.oplus.camera.ui.inverse;

/* compiled from: InverseManager.java */
/* loaded from: classes2.dex */
public enum e_renamed {
    INS;

    private static final int ANIMATION_DURATION = 300;
    private static final int AUTO_INVERSE_DELAY = 500;
    private static final float BRIGHTNESS_MAX = 100.0f;
    private static final int MSG_INVERSE_DELAY = 1;
    private static final int MSG_POST_INVERSE = 2;
    private static final int SEND_MSG_CD = 3000;
    private static final java.lang.String TAG = com.oplus.camera.ui.inverse.e_renamed.class.getSimpleName();
    private com.oplus.camera.ui.inverse.f_renamed mInverseViewHolder = new com.oplus.camera.ui.inverse.f_renamed();
    private com.oplus.camera.ui.inverse.e_renamed.b_renamed mHandler = null;
    private java.util.Map<java.lang.Integer, java.lang.Boolean> mInverseMap = new java.util.HashMap();
    private int mInverseColor = 0;
    private android.view.animation.Interpolator mInterpolator = null;
    private android.animation.ValueAnimator mAnimator = null;
    private volatile boolean mbAnimationRunning = false;
    private final java.lang.Object mLock = new java.lang.Object();
    private java.lang.Boolean mbDelayInverseColor = null;
    private long mDelayInverseTs = 0;
    private float mBrightness = 0.0f;
    private float mVideoBrightness = 0.0f;
    private float mCurrentHighBrightnessValue = 0.0f;
    private int mThreshold = 0;
    private int mThresholdRecover = 0;
    private boolean mbExecuteDelayMsg = true;

    /* compiled from: InverseManager.java */
    public interface a_renamed {
        void call();
    }

    /* compiled from: InverseManager.java */
    public interface c_renamed {
        void call(com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView);
    }

    e_renamed() {
    }

    public void init(android.content.Context context, int i_renamed, boolean z_renamed, int i2, int i3, int i4, int i5, int i6) {
        com.oplus.camera.e_renamed.b_renamed(TAG, "init, context.hashCode(): " + context.hashCode() + ", cameraEntryType: " + i_renamed);
        if (1 == i_renamed && i4 > 0 && !z_renamed) {
            this.mInverseMap.put(java.lang.Integer.valueOf(context.hashCode()), false);
            this.mInverseColor = i6;
            this.mBrightness = i2 / BRIGHTNESS_MAX;
            this.mVideoBrightness = i3 / BRIGHTNESS_MAX;
            this.mThreshold = i4;
            this.mThresholdRecover = i5;
            this.mInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context, com.oplus.camera.R_renamed.anim.inverse_interpolator);
        }
        if (this.mHandler == null) {
            this.mHandler = new com.oplus.camera.ui.inverse.e_renamed.b_renamed();
        }
        com.oplus.camera.e_renamed.b_renamed(TAG, "init, X_renamed" + context.hashCode() + ", cameraEntryType: " + i_renamed + ", mInverseViewMap.size(): " + this.mInverseViewHolder.a_renamed());
    }

    public int getInverseColor() {
        return this.mInverseColor;
    }

    public float getBrightness() {
        return this.mBrightness;
    }

    public float getVideoBrightness() {
        return this.mVideoBrightness;
    }

    public float getCurrentHighBrightnessValue() {
        return this.mCurrentHighBrightnessValue;
    }

    public void setCurrentHighBrightnessValue(float f_renamed) {
        this.mCurrentHighBrightnessValue = f_renamed;
    }

    public int getThreshold() {
        return this.mThreshold;
    }

    public int getThresholdRecover() {
        return this.mThresholdRecover;
    }

    public void release(android.content.Context context) {
        com.oplus.camera.e_renamed.b_renamed(TAG, "release, context.hashCode(): " + context.hashCode());
        this.mInverseViewHolder.a_renamed(context);
        this.mInverseMap.remove(java.lang.Integer.valueOf(context.hashCode()));
        this.mbDelayInverseColor = null;
        com.oplus.camera.e_renamed.b_renamed(TAG, "release X_renamed");
    }

    public boolean setInverseDelay(android.content.Context context, boolean z_renamed, boolean z2, com.oplus.camera.ui.inverse.e_renamed.a_renamed aVar) {
        java.lang.Boolean bool;
        if (!this.mInverseMap.containsKey(java.lang.Integer.valueOf(context.hashCode())) || java.lang.System.currentTimeMillis() - this.mDelayInverseTs < 3000) {
            return false;
        }
        boolean z3 = !this.mHandler.hasMessages(1) ? isInverseColor(context.hashCode()) == z_renamed : (bool = this.mbDelayInverseColor) != null && bool.booleanValue() == z_renamed;
        if (z3) {
            this.mHandler.removeMessages(1);
            android.os.Message messageObtainMessage = this.mHandler.obtainMessage(1, new java.lang.Object[]{java.lang.Boolean.valueOf(z_renamed), java.lang.Boolean.valueOf(z2), aVar});
            messageObtainMessage.arg1 = context.hashCode();
            this.mHandler.sendMessageDelayed(messageObtainMessage, 500L);
            this.mbDelayInverseColor = java.lang.Boolean.valueOf(z_renamed);
        }
        return z3;
    }

    public void setInverseColor(android.content.Context context, boolean z_renamed, boolean z2) {
        setInverseColor(context.hashCode(), z_renamed, z2);
    }

    public boolean isInverseColor(int i_renamed) {
        java.lang.Boolean bool = this.mInverseMap.get(java.lang.Integer.valueOf(i_renamed));
        return bool != null && bool.booleanValue();
    }

    public void setInverseColor(final int i_renamed, final boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.b_renamed(TAG, "setInverseColor, contextHash: " + i_renamed + ", inverseColor: " + z_renamed + ", showAnimation: " + z2);
        if (!this.mInverseMap.containsKey(java.lang.Integer.valueOf(i_renamed))) {
            com.oplus.camera.e_renamed.b_renamed(TAG, "setInverseColor, return, contextHash: " + i_renamed);
            return;
        }
        this.mHandler.removeMessages(1);
        this.mbDelayInverseColor = null;
        this.mDelayInverseTs = java.lang.System.currentTimeMillis();
        if (isInverseColor(i_renamed) == z_renamed) {
            com.oplus.camera.e_renamed.b_renamed(TAG, "setInverseColor, color return, contextHash: " + i_renamed);
            return;
        }
        if (this.mbAnimationRunning) {
            com.oplus.camera.e_renamed.b_renamed(TAG, "setInverseColor, animation running, contextHash: " + i_renamed);
            this.mAnimator.cancel();
        }
        this.mInverseMap.put(java.lang.Integer.valueOf(i_renamed), java.lang.Boolean.valueOf(z_renamed));
        if (z2) {
            this.mAnimator = null;
            if (z_renamed) {
                this.mAnimator = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            } else {
                this.mAnimator = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
            }
            this.mAnimator.setInterpolator(this.mInterpolator);
            this.mAnimator.setDuration(300L);
            this.mAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$ZEKwizAYlwSTrBKb8Y1P6mBDVw8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f_renamed$0.lambda$setInverseColor$1$e_renamed(i_renamed, z_renamed, valueAnimator);
                }
            });
            this.mAnimator.addListener(new com.oplus.camera.ui.inverse.e_renamed.SceneLoader_2(i_renamed, z_renamed));
            this.mbAnimationRunning = true;
            this.mAnimator.start();
        } else {
            synchronized (this.mLock) {
                com.oplus.camera.e_renamed.b_renamed(TAG, "setInverseColor, no animation, mbAnimationRunning: " + this.mbAnimationRunning);
                this.mInverseViewHolder.a_renamed(new com.oplus.camera.ui.inverse.f_renamed.a_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$NmApdipZ8SULLMeyPpwuAOZmAfM
                    @Override // com.oplus.camera.ui.inverse.f_renamed.a_renamed
                    public final boolean call(java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar) {
                        return this.f_renamed$0.lambda$setInverseColor$2$e_renamed(i_renamed, z_renamed, obj, cVar);
                    }
                });
                com.oplus.camera.e_renamed.b_renamed(TAG, "setInverseColor, no animation X_renamed, mbAnimationRunning: " + this.mbAnimationRunning);
            }
        }
        com.oplus.camera.e_renamed.b_renamed(TAG, "setInverseColor X_renamed, contextHash: " + i_renamed);
    }

    public /* synthetic */ void lambda$setInverseColor$1$e_renamed(final int i_renamed, final boolean z_renamed, android.animation.ValueAnimator valueAnimator) {
        final float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        synchronized (this.mLock) {
            com.oplus.camera.e_renamed.b_renamed(TAG, "setInverseColor, animation, mbAnimationRunning: " + this.mbAnimationRunning);
            if (this.mbAnimationRunning) {
                this.mInverseViewHolder.a_renamed(new com.oplus.camera.ui.inverse.f_renamed.a_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$2eRCD4iz2S25zIIgqQYyc22IGhc
                    @Override // com.oplus.camera.ui.inverse.f_renamed.a_renamed
                    public final boolean call(java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar) {
                        return this.f_renamed$0.lambda$setInverseColor$0$e_renamed(i_renamed, fFloatValue, z_renamed, obj, cVar);
                    }
                });
                com.oplus.camera.e_renamed.b_renamed(TAG, "setInverseColor, animation X_renamed, mbAnimationRunning: " + this.mbAnimationRunning);
            }
        }
    }

    public /* synthetic */ boolean lambda$setInverseColor$0$e_renamed(int i_renamed, float f_renamed, boolean z_renamed, java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar) {
        if (i_renamed == cVar.f6249a) {
            int i2 = com.oplus.camera.ui.inverse.e_renamed.XPanMode_2.f6255a[cVar.e_renamed.ordinal()];
            if (i2 != 2) {
                boolean z2 = true;
                if (i2 == 3) {
                    if (z_renamed) {
                        ((com.oplus.camera.ui.inverse.InverseMaskView) obj).setInverseColor(true);
                    }
                    ((com.oplus.camera.ui.inverse.InverseMaskView) obj).setAlpha(f_renamed);
                } else if (i2 == 4) {
                    com.oplus.camera.ui.preview.g_renamed gVar = (com.oplus.camera.ui.preview.g_renamed) obj;
                    if (f_renamed <= 0.0f && !z_renamed) {
                        z2 = false;
                    }
                    gVar.a_renamed(z2, getColorWithAlpha(this.mInverseColor, f_renamed));
                }
            } else {
                cVar.d_renamed = f_renamed;
                ((android.view.View) obj).setBackgroundColor(cVar.f6250b);
            }
        }
        return false;
    }

    /* compiled from: InverseManager.java */
    /* renamed from: com.oplus.camera.ui.inverse.e_renamed$1, reason: invalid class name */
    class SceneLoader_2 extends android.animation.AnimatorListenerAdapter {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ int f6252a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final /* synthetic */ boolean f6253b;

        SceneLoader_2(int i_renamed, boolean z_renamed) {
            this.f6252a = i_renamed;
            this.f6253b = z_renamed;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            com.oplus.camera.ui.inverse.e_renamed.this.mbAnimationRunning = false;
            com.oplus.camera.ui.inverse.f_renamed fVar = com.oplus.camera.ui.inverse.e_renamed.this.mInverseViewHolder;
            final int i_renamed = this.f6252a;
            final boolean z_renamed = this.f6253b;
            fVar.a_renamed(new com.oplus.camera.ui.inverse.f_renamed.a_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$1$W1sVRVfWBsfr2cFBdKzfsC9KrZM
                @Override // com.oplus.camera.ui.inverse.f_renamed.a_renamed
                public final boolean call(java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar) {
                    return com.oplus.camera.ui.inverse.e_renamed.SceneLoader_2.c_renamed(i_renamed, z_renamed, obj, cVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean c_renamed(int i_renamed, boolean z_renamed, java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar) {
            if (cVar.e_renamed != com.oplus.camera.ui.inverse.c_renamed.a_renamed.mask || i_renamed != cVar.f6249a) {
                return true;
            }
            ((com.oplus.camera.ui.inverse.InverseMaskView) obj).setInverseColor(z_renamed);
            return true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.oplus.camera.ui.inverse.e_renamed.this.mbAnimationRunning = false;
            com.oplus.camera.ui.inverse.f_renamed fVar = com.oplus.camera.ui.inverse.e_renamed.this.mInverseViewHolder;
            final int i_renamed = this.f6252a;
            final boolean z_renamed = this.f6253b;
            fVar.a_renamed(new com.oplus.camera.ui.inverse.f_renamed.a_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$1$URMfj-2p-yD7aA6ILT_9JgVt2TE
                @Override // com.oplus.camera.ui.inverse.f_renamed.a_renamed
                public final boolean call(java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar) {
                    return com.oplus.camera.ui.inverse.e_renamed.SceneLoader_2.b_renamed(i_renamed, z_renamed, obj, cVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean b_renamed(int i_renamed, boolean z_renamed, java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar) {
            if (cVar.e_renamed != com.oplus.camera.ui.inverse.c_renamed.a_renamed.mask || i_renamed != cVar.f6249a) {
                return true;
            }
            ((com.oplus.camera.ui.inverse.InverseMaskView) obj).setInverseColor(z_renamed);
            return true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            synchronized (com.oplus.camera.ui.inverse.e_renamed.this.mLock) {
                com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.ui.inverse.e_renamed.TAG, "setInverseColor, onAnimationStart, mbAnimationRunning: " + com.oplus.camera.ui.inverse.e_renamed.this.mbAnimationRunning);
                if (com.oplus.camera.ui.inverse.e_renamed.this.mbAnimationRunning) {
                    com.oplus.camera.ui.inverse.f_renamed fVar = com.oplus.camera.ui.inverse.e_renamed.this.mInverseViewHolder;
                    final int i_renamed = this.f6252a;
                    final boolean z_renamed = this.f6253b;
                    fVar.a_renamed(new com.oplus.camera.ui.inverse.f_renamed.a_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$1$a0P70OsTK0EqwTy3lgJOw8c2yJU
                        @Override // com.oplus.camera.ui.inverse.f_renamed.a_renamed
                        public final boolean call(java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar) {
                            return com.oplus.camera.ui.inverse.e_renamed.SceneLoader_2.a_renamed(i_renamed, z_renamed, obj, cVar);
                        }
                    });
                    com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.ui.inverse.e_renamed.TAG, "setInverseColor, onAnimationStart X_renamed, mbAnimationRunning: " + com.oplus.camera.ui.inverse.e_renamed.this.mbAnimationRunning);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean a_renamed(int i_renamed, boolean z_renamed, java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar) {
            if (cVar.e_renamed != com.oplus.camera.ui.inverse.c_renamed.a_renamed.common || i_renamed != cVar.f6249a) {
                return false;
            }
            try {
                ((com.oplus.camera.ui.inverse.a_renamed) obj).setInverseColor(z_renamed);
                return false;
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
                com.oplus.camera.e_renamed.b_renamed(com.oplus.camera.ui.inverse.e_renamed.TAG, e_renamed.getMessage());
                return false;
            }
        }
    }

    /* compiled from: InverseManager.java */
    /* renamed from: com.oplus.camera.ui.inverse.e_renamed$2, reason: invalid class name */
    static /* synthetic */ class XPanMode_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ int[] f6255a = new int[com.oplus.camera.ui.inverse.c_renamed.a_renamed.values().length];

        static {
            try {
                f6255a[com.oplus.camera.ui.inverse.c_renamed.a_renamed.common.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f6255a[com.oplus.camera.ui.inverse.c_renamed.a_renamed.background.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f6255a[com.oplus.camera.ui.inverse.c_renamed.a_renamed.mask.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f6255a[com.oplus.camera.ui.inverse.c_renamed.a_renamed.preview.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public /* synthetic */ boolean lambda$setInverseColor$2$e_renamed(int i_renamed, boolean z_renamed, java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar) {
        if (i_renamed != cVar.f6249a) {
            return false;
        }
        int i2 = com.oplus.camera.ui.inverse.e_renamed.XPanMode_2.f6255a[cVar.e_renamed.ordinal()];
        if (i2 == 1) {
            ((com.oplus.camera.ui.inverse.a_renamed) obj).setInverseColor(z_renamed);
            return false;
        }
        if (i2 == 2) {
            cVar.d_renamed = 1.0f;
            ((android.view.View) obj).setBackgroundColor(cVar.f6250b);
            return false;
        }
        if (i2 != 3) {
            if (i2 != 4) {
                return false;
            }
            ((com.oplus.camera.ui.preview.g_renamed) obj).a_renamed(z_renamed, getColorWithAlpha(this.mInverseColor, 1.0f));
            return false;
        }
        com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView = (com.oplus.camera.ui.inverse.InverseMaskView) obj;
        inverseMaskView.setInverseColor(z_renamed);
        inverseMaskView.setAlpha(1.0f);
        return false;
    }

    private int getColorWithAlpha(int i_renamed, float f_renamed) {
        return android.graphics.Color.argb((int) (android.graphics.Color.alpha(i_renamed) * f_renamed), android.graphics.Color.red(i_renamed), android.graphics.Color.green(i_renamed), android.graphics.Color.blue(i_renamed));
    }

    private int inverse(int i_renamed, float f_renamed, boolean z_renamed) {
        float f2;
        if (android.graphics.Color.alpha(i_renamed) != 0 || !z_renamed) {
            float f3 = 204.0f * f_renamed;
            int iAlpha = android.graphics.Color.alpha(i_renamed);
            f2 = (iAlpha * (1.0f - f_renamed)) + f3;
            float f4 = 1.0f - f_renamed;
            return android.graphics.Color.argb((int) f2, (int) ((android.graphics.Color.red(this.mInverseColor) * f_renamed) + (android.graphics.Color.red(i_renamed) * f4)), (int) ((android.graphics.Color.green(this.mInverseColor) * f_renamed) + (android.graphics.Color.green(i_renamed) * f4)), (int) ((android.graphics.Color.blue(this.mInverseColor) * f_renamed) + (android.graphics.Color.blue(i_renamed) * f4)));
        }
        f2 = 0.0f;
        float f42 = 1.0f - f_renamed;
        return android.graphics.Color.argb((int) f2, (int) ((android.graphics.Color.red(this.mInverseColor) * f_renamed) + (android.graphics.Color.red(i_renamed) * f42)), (int) ((android.graphics.Color.green(this.mInverseColor) * f_renamed) + (android.graphics.Color.green(i_renamed) * f42)), (int) ((android.graphics.Color.blue(this.mInverseColor) * f_renamed) + (android.graphics.Color.blue(i_renamed) * f42)));
    }

    public void registerBackgroundInverse(android.content.Context context, android.view.View view, boolean z_renamed) {
        if (this.mInverseMap.containsKey(java.lang.Integer.valueOf(context.hashCode())) && !this.mInverseViewHolder.c_renamed(view)) {
            android.graphics.drawable.Drawable background = view.getBackground();
            if (background instanceof android.graphics.drawable.ColorDrawable) {
                com.oplus.camera.ui.inverse.c_renamed cVar = new com.oplus.camera.ui.inverse.c_renamed(com.oplus.camera.ui.inverse.c_renamed.a_renamed.background);
                cVar.f6249a = context.hashCode();
                cVar.f6250b = ((android.graphics.drawable.ColorDrawable) background).getColor();
                cVar.f6251c = z_renamed;
                this.mInverseViewHolder.a_renamed(view, cVar);
                view.setBackgroundColor(cVar.f6250b);
            } else {
                com.oplus.camera.ui.inverse.c_renamed cVar2 = new com.oplus.camera.ui.inverse.c_renamed(com.oplus.camera.ui.inverse.c_renamed.a_renamed.background);
                cVar2.f6249a = context.hashCode();
                this.mInverseViewHolder.a_renamed(view, cVar2);
            }
            com.oplus.camera.e_renamed.b_renamed(TAG, "registerBackgroundInverse, context.hashCode(): " + context.hashCode() + ", mInverseViewMap: " + this.mInverseViewHolder.a_renamed());
        }
    }

    public int getBackgroundColor(android.view.View view, int i_renamed) {
        com.oplus.camera.ui.inverse.c_renamed cVarB = this.mInverseViewHolder.b_renamed(view);
        if (cVarB == null) {
            return i_renamed;
        }
        cVarB.f6250b = i_renamed;
        return (isInverseAble(view.getContext()) && this.mbAnimationRunning) || isInverseColor(view.getContext().hashCode()) ? inverse(i_renamed, cVarB.d_renamed, cVarB.f6251c) : i_renamed;
    }

    public void registerInverse(android.content.Context context, com.oplus.camera.ui.inverse.a_renamed aVar) {
        if (this.mInverseMap.containsKey(java.lang.Integer.valueOf(context.hashCode())) && !this.mInverseViewHolder.c_renamed(aVar)) {
            com.oplus.camera.ui.inverse.c_renamed cVar = new com.oplus.camera.ui.inverse.c_renamed(com.oplus.camera.ui.inverse.c_renamed.a_renamed.common);
            cVar.f6249a = context.hashCode();
            this.mInverseViewHolder.a_renamed(aVar, cVar);
            aVar.setInverseColor(isInverseColor(context.hashCode()));
            com.oplus.camera.e_renamed.b_renamed(TAG, "registerInverse, context.hashCode(): " + context.hashCode() + ", mInverseViewMap: " + this.mInverseViewHolder.a_renamed());
        }
    }

    public void unRegisterInverse(android.content.Context context, com.oplus.camera.ui.inverse.a_renamed aVar) {
        if (this.mInverseMap.containsKey(java.lang.Integer.valueOf(context.hashCode())) && this.mInverseViewHolder.c_renamed(aVar)) {
            this.mInverseViewHolder.a_renamed(aVar);
        }
    }

    public void setInverseMaskView(android.content.Context context, com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView) {
        if (this.mInverseMap.containsKey(java.lang.Integer.valueOf(context.hashCode())) && !this.mInverseViewHolder.c_renamed(inverseMaskView)) {
            com.oplus.camera.ui.inverse.c_renamed cVar = new com.oplus.camera.ui.inverse.c_renamed(com.oplus.camera.ui.inverse.c_renamed.a_renamed.mask);
            cVar.f6249a = context.hashCode();
            this.mInverseViewHolder.a_renamed(inverseMaskView, cVar);
            inverseMaskView.setInverseColor(isInverseColor(context.hashCode()));
        }
    }

    public void setCameraPreviewUI(android.content.Context context, com.oplus.camera.ui.preview.g_renamed gVar) {
        if (this.mInverseMap.containsKey(java.lang.Integer.valueOf(context.hashCode())) && !this.mInverseViewHolder.c_renamed(gVar)) {
            com.oplus.camera.ui.inverse.c_renamed cVar = new com.oplus.camera.ui.inverse.c_renamed(com.oplus.camera.ui.inverse.c_renamed.a_renamed.preview);
            cVar.f6249a = context.hashCode();
            this.mInverseViewHolder.a_renamed(gVar, cVar);
            gVar.a_renamed(isInverseColor(context.hashCode()), getColorWithAlpha(this.mInverseColor, 1.0f));
        }
    }

    public void setMaskAlpha(android.content.Context context, final float f_renamed) {
        withMask(context, new com.oplus.camera.ui.inverse.e_renamed.c_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$TcnbrV-POqFtkYWdWgfyQbxY6CU
            @Override // com.oplus.camera.ui.inverse.e_renamed.c_renamed
            public final void call(com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView) {
                inverseMaskView.setMaskAlpha(f_renamed);
            }
        });
    }

    public void setMaskAlpha(android.content.Context context, final boolean z_renamed, final boolean z2) {
        withMask(context, new com.oplus.camera.ui.inverse.e_renamed.c_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$UwQQ8lvyz5fDxBO0LYnDIp3PqJI
            @Override // com.oplus.camera.ui.inverse.e_renamed.c_renamed
            public final void call(com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView) {
                inverseMaskView.a_renamed(z_renamed, z2);
            }
        });
    }

    public void setMaskRadius(android.content.Context context, final int i_renamed) {
        withMask(context, new com.oplus.camera.ui.inverse.e_renamed.c_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$UvSetmnGetkQwEj1o83jUirBQiQ
            @Override // com.oplus.camera.ui.inverse.e_renamed.c_renamed
            public final void call(com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView) {
                inverseMaskView.setRadius(i_renamed);
            }
        });
    }

    public void setMaskSplitScreenYOffset(android.content.Context context, final float f_renamed) {
        withMask(context, new com.oplus.camera.ui.inverse.e_renamed.c_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$ItsNODwTfvVV3tObtXFbbmqIEw4
            @Override // com.oplus.camera.ui.inverse.e_renamed.c_renamed
            public final void call(com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView) {
                inverseMaskView.setSplitScreenYOffset(f_renamed);
            }
        });
    }

    public void startMaskScaleAnimation(final android.content.Context context) {
        withMask(context, new com.oplus.camera.ui.inverse.e_renamed.c_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$SrDI5Wvm1GWxBuOEfCmrpkoAjW0
            @Override // com.oplus.camera.ui.inverse.e_renamed.c_renamed
            public final void call(com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView) {
                this.f_renamed$0.lambda$startMaskScaleAnimation$7$e_renamed(context, inverseMaskView);
            }
        });
    }

    public /* synthetic */ void lambda$startMaskScaleAnimation$7$e_renamed(android.content.Context context, com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView) {
        if (isInverseColor(context.hashCode())) {
            inverseMaskView.a_renamed();
        }
    }

    public void setPositionRatio(android.content.Context context, final float f_renamed, final boolean z_renamed) {
        withMask(context, new com.oplus.camera.ui.inverse.e_renamed.c_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$_D9pG4Wxfn_fDLAZf7A3VrFHJlE
            @Override // com.oplus.camera.ui.inverse.e_renamed.c_renamed
            public final void call(com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView) {
                inverseMaskView.a_renamed(f_renamed, z_renamed);
            }
        });
    }

    public void withMask(final android.content.Context context, final com.oplus.camera.ui.inverse.e_renamed.c_renamed cVar) {
        if (context == null || !this.mInverseMap.containsKey(java.lang.Integer.valueOf(context.hashCode()))) {
            return;
        }
        this.mInverseViewHolder.a_renamed(new com.oplus.camera.ui.inverse.f_renamed.a_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$Vvi6xFmtwTgzz_gQIctS5is5GaQ
            @Override // com.oplus.camera.ui.inverse.f_renamed.a_renamed
            public final boolean call(java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar2) {
                return com.oplus.camera.ui.inverse.e_renamed.lambda$withMask$9(context, cVar, obj, cVar2);
            }
        });
    }

    static /* synthetic */ boolean lambda$withMask$9(android.content.Context context, com.oplus.camera.ui.inverse.e_renamed.c_renamed cVar, java.lang.Object obj, com.oplus.camera.ui.inverse.c_renamed cVar2) {
        if (cVar2.e_renamed != com.oplus.camera.ui.inverse.c_renamed.a_renamed.mask || cVar2.f6249a != context.hashCode()) {
            return false;
        }
        cVar.call((com.oplus.camera.ui.inverse.InverseMaskView) obj);
        return true;
    }

    public boolean isInverseAble(android.content.Context context) {
        return context != null && this.mInverseMap.containsKey(java.lang.Integer.valueOf(context.hashCode()));
    }

    public void setExecuteDelayMsg(boolean z_renamed) {
        this.mbExecuteDelayMsg = z_renamed;
    }

    public void clear() {
        this.mInverseViewHolder.a_renamed((android.content.Context) null);
    }

    public void removeMessages() {
        com.oplus.camera.ui.inverse.e_renamed.b_renamed bVar = this.mHandler;
        if (bVar != null) {
            bVar.removeMessages(1);
        }
    }

    public void postInverseColor(int i_renamed, boolean z_renamed, boolean z2) {
        android.os.Message messageObtainMessage = this.mHandler.obtainMessage(2, new java.lang.Object[]{java.lang.Boolean.valueOf(z_renamed), java.lang.Boolean.valueOf(z2)});
        messageObtainMessage.arg1 = i_renamed;
        messageObtainMessage.sendToTarget();
    }

    public void setMaskLayoutMode(android.content.Context context, final int i_renamed, final boolean z_renamed, final int i2) {
        withMask(context, new com.oplus.camera.ui.inverse.e_renamed.c_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$A3F90eOPeIl3geZj5UwWkcUPJz8
            @Override // com.oplus.camera.ui.inverse.e_renamed.c_renamed
            public final void call(com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView) {
                inverseMaskView.a_renamed(i_renamed, z_renamed, i2);
            }
        });
    }

    public void setMaskToLayoutMode(android.content.Context context, final com.oplus.camera.ui.inverse.b_renamed bVar) {
        withMask(context, new com.oplus.camera.ui.inverse.e_renamed.c_renamed() { // from class: com.oplus.camera.ui.inverse.-$$Lambda$e_renamed$doTLUz4QcIFO_Jls6o47v1Lekfk
            @Override // com.oplus.camera.ui.inverse.e_renamed.c_renamed
            public final void call(com.oplus.camera.ui.inverse.InverseMaskView inverseMaskView) {
                inverseMaskView.setMaskToLayoutMode(bVar);
            }
        });
    }

    /* compiled from: InverseManager.java */
    public class b_renamed extends android.os.Handler {
        public b_renamed() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i_renamed = message.arg1;
            if (com.oplus.camera.ui.inverse.e_renamed.this.mInverseMap.containsKey(java.lang.Integer.valueOf(i_renamed)) && com.oplus.camera.ui.inverse.e_renamed.this.mbExecuteDelayMsg) {
                if (1 == message.what) {
                    java.lang.Object[] objArr = (java.lang.Object[]) message.obj;
                    com.oplus.camera.ui.inverse.e_renamed.this.setInverseColor(i_renamed, ((java.lang.Boolean) objArr[0]).booleanValue(), ((java.lang.Boolean) objArr[1]).booleanValue());
                    com.oplus.camera.ui.inverse.e_renamed.a_renamed aVar = (com.oplus.camera.ui.inverse.e_renamed.a_renamed) objArr[2];
                    if (aVar != null) {
                        aVar.call();
                        return;
                    }
                    return;
                }
                if (2 == message.what) {
                    java.lang.Object[] objArr2 = (java.lang.Object[]) message.obj;
                    com.oplus.camera.ui.inverse.e_renamed.this.setInverseColor(i_renamed, ((java.lang.Boolean) objArr2[0]).booleanValue(), ((java.lang.Boolean) objArr2[1]).booleanValue());
                }
            }
        }
    }
}
