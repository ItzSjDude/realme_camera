package com.airbnb.lottie;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.p036h.ViewCompat;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p091f.Logger_3;
import com.airbnb.lottie.p091f.Utils_4;
import com.airbnb.lottie.p092g.LottieFrameInfo;
import com.airbnb.lottie.p092g.LottieValueCallback;
import com.airbnb.lottie.p092g.SimpleLottieValueCallback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f5196a = "LottieAnimationView";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final LottieListener<Throwable> f5197b = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo5520a(Throwable th) {
            if (Utils_4.m6151a(th)) {
                Logger_3.m6099a("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    };

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final LottieListener<LottieComposition> f5198c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final LottieListener<Throwable> f5199d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private LottieListener<Throwable> f5200e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f5201f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final LottieDrawable f5202g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f5203h;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f5204i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f5205j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f5206k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f5207l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f5208m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f5209n;

    /* renamed from: o */
    private boolean f5210o;

    /* renamed from: p */
    private boolean f5211p;

    /* renamed from: q */
    private RenderMode_2 f5212q;

    /* renamed from: r */
    private final Set<LottieOnCompositionLoadedListener> f5213r;

    /* renamed from: s */
    private int f5214s;

    /* renamed from: t */
    private LottieTask<LottieComposition> f5215t;

    /* renamed from: u */
    private LottieComposition f5216u;

    public LottieAnimationView(Context context) {
        super(context);
        this.f5198c = new LottieListener<LottieComposition>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.LottieListener
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo5520a(LottieComposition c1136d) {
                LottieAnimationView.this.setComposition(c1136d);
            }
        };
        this.f5199d = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.LottieListener
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo5520a(Throwable th) {
                if (LottieAnimationView.this.f5201f != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.f5201f);
                }
                (LottieAnimationView.this.f5200e == null ? LottieAnimationView.f5197b : LottieAnimationView.this.f5200e).mo5520a(th);
            }
        };
        this.f5201f = 0;
        this.f5202g = new LottieDrawable();
        this.f5206k = false;
        this.f5207l = false;
        this.f5208m = false;
        this.f5209n = false;
        this.f5210o = false;
        this.f5211p = true;
        this.f5212q = RenderMode_2.AUTOMATIC;
        this.f5213r = new HashSet();
        this.f5214s = 0;
        m5499a((AttributeSet) null, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5198c = new LottieListener<LottieComposition>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.LottieListener
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo5520a(LottieComposition c1136d) {
                LottieAnimationView.this.setComposition(c1136d);
            }
        };
        this.f5199d = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.LottieListener
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo5520a(Throwable th) {
                if (LottieAnimationView.this.f5201f != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.f5201f);
                }
                (LottieAnimationView.this.f5200e == null ? LottieAnimationView.f5197b : LottieAnimationView.this.f5200e).mo5520a(th);
            }
        };
        this.f5201f = 0;
        this.f5202g = new LottieDrawable();
        this.f5206k = false;
        this.f5207l = false;
        this.f5208m = false;
        this.f5209n = false;
        this.f5210o = false;
        this.f5211p = true;
        this.f5212q = RenderMode_2.AUTOMATIC;
        this.f5213r = new HashSet();
        this.f5214s = 0;
        m5499a(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f5198c = new LottieListener<LottieComposition>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.LottieListener
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo5520a(LottieComposition c1136d) {
                LottieAnimationView.this.setComposition(c1136d);
            }
        };
        this.f5199d = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.LottieListener
            /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo5520a(Throwable th) {
                if (LottieAnimationView.this.f5201f != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.f5201f);
                }
                (LottieAnimationView.this.f5200e == null ? LottieAnimationView.f5197b : LottieAnimationView.this.f5200e).mo5520a(th);
            }
        };
        this.f5201f = 0;
        this.f5202g = new LottieDrawable();
        this.f5206k = false;
        this.f5207l = false;
        this.f5208m = false;
        this.f5209n = false;
        this.f5210o = false;
        this.f5211p = true;
        this.f5212q = RenderMode_2.AUTOMATIC;
        this.f5213r = new HashSet();
        this.f5214s = 0;
        m5499a(attributeSet, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5499a(AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, OplusGLSurfaceView_13, 0);
        this.f5211p = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_url);
        if (zHasValue && zHasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f5208m = true;
            this.f5210o = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.f5202g.m6064e(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        m5513a(typedArrayObtainStyledAttributes.getBoolean(R.styleable.f5267x8756d533, false));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            m5509a(new KeyPath_2("**"), (KeyPath_2) InterfaceC1205k.f5926E, (LottieValueCallback<KeyPath_2>) new LottieValueCallback(new SimpleColorFilter_2(AppCompatResources.m729a(getContext(), typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor())));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.f5202g.m6063e(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_renderMode)) {
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_renderMode, RenderMode_2.AUTOMATIC.ordinal());
            if (iOrdinal >= RenderMode_2.values().length) {
                iOrdinal = RenderMode_2.AUTOMATIC.ordinal();
            }
            setRenderMode(RenderMode_2.values()[iOrdinal]);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f5202g.m6041a(Boolean.valueOf(Utils_4.m6140a(getContext()) != 0.0f));
        m5505j();
        this.f5203h = true;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int OplusGLSurfaceView_13) {
        m5503h();
        super.setImageResource(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        m5503h();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m5503h();
        super.setImageBitmap(bitmap);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        LottieDrawable c1187f;
        if (!this.f5209n && drawable == (c1187f = this.f5202g) && c1187f.m6076p()) {
            m5519f();
        } else if (!this.f5209n && (drawable instanceof LottieDrawable)) {
            LottieDrawable c1187f2 = (LottieDrawable) drawable;
            if (c1187f2.m6076p()) {
                c1187f2.m6082v();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable c1187f = this.f5202g;
        if (drawable2 == c1187f) {
            super.invalidateDrawable(c1187f);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.f5204i;
        savedState.animationResId = this.f5205j;
        savedState.progress = this.f5202g.m6083w();
        savedState.isAnimating = this.f5202g.m6076p() || (!ViewCompat.m2826D(this) && this.f5208m);
        savedState.imageAssetsFolder = this.f5202g.m6046b();
        savedState.repeatMode = this.f5202g.m6074n();
        savedState.repeatCount = this.f5202g.m6075o();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f5204i = savedState.animationName;
        if (!TextUtils.isEmpty(this.f5204i)) {
            setAnimation(this.f5204i);
        }
        this.f5205j = savedState.animationResId;
        int OplusGLSurfaceView_13 = this.f5205j;
        if (OplusGLSurfaceView_13 != 0) {
            setAnimation(OplusGLSurfaceView_13);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            m5507a();
        }
        this.f5202g.m6042a(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int OplusGLSurfaceView_13) {
        if (this.f5203h) {
            if (isShown()) {
                if (this.f5207l) {
                    m5515b();
                } else if (this.f5206k) {
                    m5507a();
                }
                this.f5207l = false;
                this.f5206k = false;
                return;
            }
            if (m5517d()) {
                m5519f();
                this.f5207l = true;
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.f5210o || this.f5208m)) {
            m5507a();
            this.f5210o = false;
            this.f5208m = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (m5517d()) {
            m5518e();
            this.f5208m = true;
        }
        super.onDetachedFromWindow();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5513a(boolean z) {
        this.f5202g.m6043a(z);
    }

    public void setCacheComposition(boolean z) {
        this.f5211p = z;
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.f5202g.m6055c(z);
    }

    public void setAnimation(int OplusGLSurfaceView_13) {
        this.f5205j = OplusGLSurfaceView_13;
        this.f5204i = null;
        setCompositionTask(m5497a(OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private LottieTask<LottieComposition> m5497a(final int OplusGLSurfaceView_13) {
        if (isInEditMode()) {
            return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() { // from class: com.airbnb.lottie.LottieAnimationView.4
                @Override // java.util.concurrent.Callable
                /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
                public LottieResult<LottieComposition> call() {
                    return LottieAnimationView.this.f5211p ? LottieCompositionFactory.m5893b(LottieAnimationView.this.getContext(), OplusGLSurfaceView_13) : LottieCompositionFactory.m5894b(LottieAnimationView.this.getContext(), OplusGLSurfaceView_13, (String) null);
                }
            }, true);
        }
        return this.f5211p ? LottieCompositionFactory.m5884a(getContext(), OplusGLSurfaceView_13) : LottieCompositionFactory.m5885a(getContext(), OplusGLSurfaceView_13, (String) null);
    }

    public void setAnimation(String str) {
        this.f5204i = str;
        this.f5205j = 0;
        setCompositionTask(m5498a(str));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private LottieTask<LottieComposition> m5498a(final String str) {
        if (isInEditMode()) {
            return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() { // from class: com.airbnb.lottie.LottieAnimationView.5
                @Override // java.util.concurrent.Callable
                /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
                public LottieResult<LottieComposition> call() {
                    return LottieAnimationView.this.f5211p ? LottieCompositionFactory.m5899c(LottieAnimationView.this.getContext(), str) : LottieCompositionFactory.m5900c(LottieAnimationView.this.getContext(), str, null);
                }
            }, true);
        }
        return this.f5211p ? LottieCompositionFactory.m5897b(getContext(), str) : LottieCompositionFactory.m5898b(getContext(), str, (String) null);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        m5512a(str, (String) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5512a(String str, String str2) {
        m5511a(new ByteArrayInputStream(str.getBytes()), str2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5511a(InputStream inputStream, String str) {
        setCompositionTask(LottieCompositionFactory.m5888a(inputStream, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f5211p ? LottieCompositionFactory.m5886a(getContext(), str) : LottieCompositionFactory.m5887a(getContext(), str, (String) null));
    }

    public void setFailureListener(LottieListener<Throwable> interfaceC1202h) {
        this.f5200e = interfaceC1202h;
    }

    public void setFallbackResource(int OplusGLSurfaceView_13) {
        this.f5201f = OplusGLSurfaceView_13;
    }

    private void setCompositionTask(LottieTask<LottieComposition> c1207m) {
        m5504i();
        m5503h();
        this.f5215t = c1207m.m6189a(this.f5198c).m6191c(this.f5199d);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m5503h() {
        LottieTask<LottieComposition> c1207m = this.f5215t;
        if (c1207m != null) {
            c1207m.m6190b(this.f5198c);
            this.f5215t.m6192d(this.f5199d);
        }
    }

    public void setComposition(LottieComposition c1136d) {
        if (L_2.f5465a) {
            Log.v(f5196a, "Set Composition \OplusGLSurfaceView_11" + c1136d);
        }
        this.f5202g.setCallback(this);
        this.f5216u = c1136d;
        this.f5209n = true;
        boolean zM6045a = this.f5202g.m6045a(c1136d);
        this.f5209n = false;
        m5505j();
        if (getDrawable() != this.f5202g || zM6045a) {
            if (!zM6045a) {
                m5506k();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<LottieOnCompositionLoadedListener> it = this.f5213r.iterator();
            while (it.hasNext()) {
                it.next().onCompositionLoaded(c1136d);
            }
        }
    }

    public LottieComposition getComposition() {
        return this.f5216u;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5507a() {
        if (isShown()) {
            this.f5202g.m6066f();
            m5505j();
        } else {
            this.f5206k = true;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5515b() {
        if (isShown()) {
            this.f5202g.m6068h();
            m5505j();
        } else {
            this.f5206k = false;
            this.f5207l = true;
        }
    }

    public void setMinFrame(int OplusGLSurfaceView_13) {
        this.f5202g.m6034a(OplusGLSurfaceView_13);
    }

    public float getMinFrame() {
        return this.f5202g.m6069i();
    }

    public void setMinProgress(float COUIBaseListPopupWindow_12) {
        this.f5202g.m6033a(COUIBaseListPopupWindow_12);
    }

    public void setMaxFrame(int OplusGLSurfaceView_13) {
        this.f5202g.m6048b(OplusGLSurfaceView_13);
    }

    public float getMaxFrame() {
        return this.f5202g.m6070j();
    }

    public void setMaxProgress(float COUIBaseListPopupWindow_12) {
        this.f5202g.m6047b(COUIBaseListPopupWindow_12);
    }

    public void setMinFrame(String str) {
        this.f5202g.m6049b(str);
    }

    public void setMaxFrame(String str) {
        this.f5202g.m6054c(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.f5202g.m6058d(str);
    }

    public void setSpeed(float COUIBaseListPopupWindow_12) {
        this.f5202g.m6052c(COUIBaseListPopupWindow_12);
    }

    public float getSpeed() {
        return this.f5202g.m6071k();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5508a(Animator.AnimatorListener animatorListener) {
        this.f5202g.m6036a(animatorListener);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m5516c() {
        this.f5202g.m6072l();
    }

    public void setRepeatMode(int OplusGLSurfaceView_13) {
        this.f5202g.m6057d(OplusGLSurfaceView_13);
    }

    public int getRepeatMode() {
        return this.f5202g.m6074n();
    }

    public void setRepeatCount(int OplusGLSurfaceView_13) {
        this.f5202g.m6064e(OplusGLSurfaceView_13);
    }

    public int getRepeatCount() {
        return this.f5202g.m6075o();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m5517d() {
        return this.f5202g.m6076p();
    }

    public void setImageAssetsFolder(String str) {
        this.f5202g.m6042a(str);
    }

    public String getImageAssetsFolder() {
        return this.f5202g.m6046b();
    }

    public void setImageAssetDelegate(ImageAssetDelegate_2 interfaceC1084b) {
        this.f5202g.m6038a(interfaceC1084b);
    }

    public void setFontAssetDelegate(FontAssetDelegate_2 c1047a) {
        this.f5202g.m6037a(c1047a);
    }

    public void setTextDelegate(TextDelegate_2 c1211q) {
        this.f5202g.m6040a(c1211q);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void m5509a(KeyPath_2 c1131e, T t, LottieValueCallback<T> c1199c) {
        this.f5202g.m6039a(c1131e, t, c1199c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void m5510a(KeyPath_2 c1131e, T t, final SimpleLottieValueCallback<T> interfaceC1201e) {
        this.f5202g.m6039a(c1131e, t, new LottieValueCallback<T>() { // from class: com.airbnb.lottie.LottieAnimationView.6
            @Override // com.airbnb.lottie.p092g.LottieValueCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public T mo5523a(LottieFrameInfo<T> c1198b) {
                return (T) interfaceC1201e.getValue(c1198b);
            }
        });
    }

    public void setScale(float COUIBaseListPopupWindow_12) {
        this.f5202g.m6063e(COUIBaseListPopupWindow_12);
        if (getDrawable() == this.f5202g) {
            m5506k();
        }
    }

    public float getScale() {
        return this.f5202g.m6079s();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m5518e() {
        this.f5208m = false;
        this.f5207l = false;
        this.f5206k = false;
        this.f5202g.m6081u();
        m5505j();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m5519f() {
        this.f5210o = false;
        this.f5208m = false;
        this.f5207l = false;
        this.f5206k = false;
        this.f5202g.m6082v();
        m5505j();
    }

    public void setFrame(int OplusGLSurfaceView_13) {
        this.f5202g.m6053c(OplusGLSurfaceView_13);
    }

    public int getFrame() {
        return this.f5202g.m6073m();
    }

    public void setProgress(float COUIBaseListPopupWindow_12) {
        this.f5202g.m6056d(COUIBaseListPopupWindow_12);
    }

    public float getProgress() {
        return this.f5202g.m6083w();
    }

    public long getDuration() {
        LottieComposition c1136d = this.f5216u;
        if (c1136d != null) {
            return (long) c1136d.m5852e();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f5202g.m6050b(z);
    }

    public PerformanceTracker_3 getPerformanceTracker() {
        return this.f5202g.m6051c();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m5504i() {
        this.f5216u = null;
        this.f5202g.m6062e();
    }

    public void setSafeMode(boolean z) {
        this.f5202g.m6065e(z);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        L_2.m5637a("buildDrawingCache");
        this.f5214s++;
        super.buildDrawingCache(z);
        if (this.f5214s == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode_2.HARDWARE);
        }
        this.f5214s--;
        L_2.m5638b("buildDrawingCache");
    }

    public void setRenderMode(RenderMode_2 enumC1209o) {
        this.f5212q = enumC1209o;
        m5505j();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.f5202g.m6059d(z);
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$7 */
    static /* synthetic */ class C10457 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f5225a = new int[RenderMode_2.values().length];

        static {
            try {
                f5225a[RenderMode_2.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5225a[RenderMode_2.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5225a[RenderMode_2.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: OplusGLSurfaceView_15 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m5505j() {
        /*
            r5 = this;
            int[] r0 = com.airbnb.lottie.LottieAnimationView.C10457.f5225a
            com.airbnb.lottie.o r1 = r5.f5212q
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
            com.airbnb.lottie.IntrinsicsJvm.kt_5 r0 = r5.f5216u
            r3 = 0
            if (r0 == 0) goto L27
            boolean r0 = r0.m5845a()
            if (r0 == 0) goto L27
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L27
            goto L48
        L27:
            com.airbnb.lottie.IntrinsicsJvm.kt_5 r0 = r5.f5216u
            if (r0 == 0) goto L33
            int r0 = r0.m5846b()
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
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.m5505j():void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m5514a(LottieOnCompositionLoadedListener interfaceC1204j) {
        LottieComposition c1136d = this.f5216u;
        if (c1136d != null) {
            interfaceC1204j.onCompositionLoaded(c1136d);
        }
        return this.f5213r.add(interfaceC1204j);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m5506k() {
        boolean zM5517d = m5517d();
        setImageDrawable(null);
        setImageDrawable(this.f5202g);
        if (zM5517d) {
            this.f5202g.m6068h();
        }
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.airbnb.lottie.LottieAnimationView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        String animationName;
        int animationResId;
        String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() == 1;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }
}
