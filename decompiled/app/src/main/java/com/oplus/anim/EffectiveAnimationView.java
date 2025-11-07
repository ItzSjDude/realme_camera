package com.oplus.anim;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p121f.OplusLog;
import com.oplus.anim.p122g.EffectiveFrameInfo;
import com.oplus.anim.p122g.EffectiveValueCallback;
import com.oplus.anim.p122g.SimpleValueCallback;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class EffectiveAnimationView extends AppCompatImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f9791a = "EffectiveAnimationView";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final EffectiveAnimationDrawable f9792b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f9793c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f9794d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f9795e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f9796f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f9797g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private RenderMode f9798h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Set<OnCompositionLoadedListener> f9799i;

    /* renamed from: OplusGLSurfaceView_15 */
    private EffectiveAnimationTask<EffectiveAnimationComposition> f9800j;

    /* renamed from: OplusGLSurfaceView_5 */
    private EffectiveAnimationComposition f9801k;

    public EffectiveAnimationView(Context context) {
        super(context);
        this.f9792b = new EffectiveAnimationDrawable();
        this.f9795e = false;
        this.f9796f = false;
        this.f9797g = false;
        this.f9798h = RenderMode.AUTOMATIC;
        this.f9799i = new HashSet();
        m8765a((AttributeSet) null);
    }

    public EffectiveAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9792b = new EffectiveAnimationDrawable();
        this.f9795e = false;
        this.f9796f = false;
        this.f9797g = false;
        this.f9798h = RenderMode.AUTOMATIC;
        this.f9799i = new HashSet();
        m8765a(attributeSet);
    }

    public EffectiveAnimationView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f9792b = new EffectiveAnimationDrawable();
        this.f9795e = false;
        this.f9796f = false;
        this.f9797g = false;
        this.f9798h = RenderMode.AUTOMATIC;
        this.f9799i = new HashSet();
        m8765a(attributeSet);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8765a(AttributeSet attributeSet) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.EffectiveAnimationView);
        if (!isInEditMode()) {
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_rawRes);
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_fileName);
            boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_url);
            if (zHasValue && zHasValue2) {
                throw new IllegalArgumentException("rawRes and fileName cannot be used at the same time. Please use only one at once.");
            }
            if (zHasValue) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.EffectiveAnimationView_anim_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (zHasValue2) {
                String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.EffectiveAnimationView_anim_fileName);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(R.styleable.EffectiveAnimationView_anim_url)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.EffectiveAnimationView_anim_autoPlay, false)) {
            this.f9796f = true;
            this.f9797g = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.EffectiveAnimationView_anim_loop, false)) {
            this.f9792b.m8925e(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(R.styleable.EffectiveAnimationView_anim_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(R.styleable.EffectiveAnimationView_anim_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(R.styleable.EffectiveAnimationView_anim_speed, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R.styleable.EffectiveAnimationView_anim_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(R.styleable.EffectiveAnimationView_anim_progress, 0.0f));
        m8772a(typedArrayObtainStyledAttributes.getBoolean(R.styleable.f9846xcd30562d, false));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_colorFilter)) {
            m8770a(new KeyPath("**"), InterfaceC2361d.f10344z, new EffectiveValueCallback(new SimpleColorFilter(typedArrayObtainStyledAttributes.getColor(R.styleable.EffectiveAnimationView_anim_colorFilter, 0))));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_scale)) {
            this.f9792b.m8919d(typedArrayObtainStyledAttributes.getFloat(R.styleable.EffectiveAnimationView_anim_scale, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.EffectiveAnimationView_anim_renderMode)) {
            this.f9798h = RenderMode.values()[typedArrayObtainStyledAttributes.getInt(R.styleable.EffectiveAnimationView_anim_renderMode, 0)];
        }
        typedArrayObtainStyledAttributes.recycle();
        m8767h();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int OplusGLSurfaceView_13) {
        m8768a();
        super.setImageResource(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        m8768a();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m8768a();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        EffectiveAnimationDrawable c2309b = this.f9792b;
        if (drawable2 == c2309b) {
            super.invalidateDrawable(c2309b);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.f9793c;
        savedState.animationResId = this.f9794d;
        savedState.progress = this.f9792b.m8941u();
        savedState.isAnimating = this.f9792b.m8934n();
        savedState.imageAssetsFolder = this.f9792b.m8909b();
        savedState.repeatMode = this.f9792b.m8932l();
        savedState.repeatCount = this.f9792b.m8933m();
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
        this.f9793c = savedState.animationName;
        if (!TextUtils.isEmpty(this.f9793c)) {
            setAnimation(this.f9793c);
        }
        this.f9794d = savedState.animationResId;
        int OplusGLSurfaceView_13 = this.f9794d;
        if (OplusGLSurfaceView_13 != 0) {
            setAnimation(OplusGLSurfaceView_13);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            m8773b();
        }
        this.f9792b.m8905a(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            if (this.f9795e) {
                this.f9795e = false;
                m8774c();
                return;
            }
            return;
        }
        if (m8775d()) {
            this.f9795e = true;
            m8777f();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f9797g && this.f9796f) {
            m8773b();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (m8775d()) {
            m8776e();
            this.f9796f = true;
        }
        super.onDetachedFromWindow();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8772a(boolean z) {
        this.f9792b.m8906a(z);
    }

    public void setAnimation(int OplusGLSurfaceView_13) {
        this.f9794d = OplusGLSurfaceView_13;
        this.f9793c = null;
        setCompositionTask(EffectiveCompositionFactory.m9303a(getContext(), OplusGLSurfaceView_13));
    }

    public void setAnimationUsingActivityContext(int OplusGLSurfaceView_13) {
        this.f9794d = OplusGLSurfaceView_13;
        this.f9793c = null;
        setCompositionTask(EffectiveCompositionFactory.m9313b(getContext(), OplusGLSurfaceView_13));
    }

    public void setAnimation(String str) {
        this.f9793c = str;
        this.f9794d = 0;
        setCompositionTask(EffectiveCompositionFactory.m9305a(getContext().getAssets(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        m8771a(str, (String) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8771a(String str, String str2) {
        m8769a(new JsonReader(new StringReader(str)), str2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8769a(JsonReader jsonReader, String str) {
        setCompositionTask(EffectiveCompositionFactory.m9306a(jsonReader, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(EffectiveCompositionFactory.m9304a(getContext(), str));
    }

    private void setCompositionTask(EffectiveAnimationTask<EffectiveAnimationComposition> c2402f) {
        m8766g();
        m8768a();
        this.f9800j = c2402f.m9238a(new C2271b(this)).m9240b(new C2270a(this));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8768a() {
        EffectiveAnimationTask<EffectiveAnimationComposition> c2402f = this.f9800j;
        if (c2402f != null) {
            c2402f.m9237a();
            this.f9800j.m9239b();
        }
    }

    public EffectiveAnimationComposition getComposition() {
        return this.f9801k;
    }

    public void setComposition(EffectiveAnimationComposition c2272a) {
        if (OplusLog.f10386b) {
            OplusLog.m9286b("Set Composition \OplusGLSurfaceView_11" + c2272a);
        }
        this.f9792b.setCallback(this);
        this.f9801k = c2272a;
        boolean zM8908a = this.f9792b.m8908a(c2272a);
        m8767h();
        if (getDrawable() != this.f9792b || zM8908a) {
            setImageDrawable(null);
            setImageDrawable(this.f9792b);
            requestLayout();
            Iterator<OnCompositionLoadedListener> it = this.f9799i.iterator();
            while (it.hasNext()) {
                it.next().m9351a(c2272a);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m8773b() {
        this.f9792b.m8923e();
        m8767h();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m8774c() {
        this.f9792b.m8927g();
        m8767h();
    }

    public void setMinFrame(int OplusGLSurfaceView_13) {
        this.f9792b.m8899a(OplusGLSurfaceView_13);
    }

    public float getMinFrame() {
        return this.f9792b.m8928h();
    }

    public void setMinFrame(String str) {
        this.f9792b.m8912b(str);
    }

    public void setMinProgress(float COUIBaseListPopupWindow_12) {
        this.f9792b.m8898a(COUIBaseListPopupWindow_12);
    }

    public void setMaxFrame(int OplusGLSurfaceView_13) {
        this.f9792b.m8911b(OplusGLSurfaceView_13);
    }

    public float getMaxFrame() {
        return this.f9792b.m8929i();
    }

    public void setMaxFrame(String str) {
        this.f9792b.m8917c(str);
    }

    public void setMaxProgress(float COUIBaseListPopupWindow_12) {
        this.f9792b.m8910b(COUIBaseListPopupWindow_12);
    }

    public void setMinAndMaxFrame(String str) {
        this.f9792b.m8921d(str);
    }

    public float getSpeed() {
        return this.f9792b.m8930j();
    }

    public void setSpeed(float COUIBaseListPopupWindow_12) {
        this.f9792b.m8915c(COUIBaseListPopupWindow_12);
    }

    public int getRepeatMode() {
        return this.f9792b.m8932l();
    }

    public void setRepeatMode(int OplusGLSurfaceView_13) {
        this.f9792b.m8920d(OplusGLSurfaceView_13);
    }

    public int getRepeatCount() {
        return this.f9792b.m8933m();
    }

    public void setRepeatCount(int OplusGLSurfaceView_13) {
        this.f9792b.m8925e(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m8775d() {
        return this.f9792b.m8934n();
    }

    public String getImageAssetsFolder() {
        return this.f9792b.m8909b();
    }

    public void setImageAssetsFolder(String str) {
        this.f9792b.m8905a(str);
    }

    public void setImageAssetDelegate(ImageAssetDelegate interfaceC2418j) {
        this.f9792b.m8903a(interfaceC2418j);
    }

    public void setFontAssetDelegate(FontAssetDelegate c2417i) {
        this.f9792b.m8902a(c2417i);
    }

    public void setTextDelegate(TextDelegate c2424p) {
        this.f9792b.m8904a(c2424p);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void m8770a(KeyPath c2357f, T t, EffectiveValueCallback<T> c2412b) {
        this.f9792b.m8901a(c2357f, t, c2412b);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.oplus.anim.EffectiveAnimationView$1 */
    class C22671<T> extends EffectiveValueCallback<T> {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ SimpleValueCallback f9802a;

        @Override // com.oplus.anim.p122g.EffectiveValueCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public T mo8778a(EffectiveFrameInfo<T> c2411a) {
            return (T) this.f9802a.m9339a(c2411a);
        }
    }

    public float getScale() {
        return this.f9792b.m8937q();
    }

    public void setScale(float COUIBaseListPopupWindow_12) {
        this.f9792b.m8919d(COUIBaseListPopupWindow_12);
        if (getDrawable() == this.f9792b) {
            setImageDrawable(null);
            setImageDrawable(this.f9792b);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m8776e() {
        this.f9792b.m8939s();
        m8767h();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m8777f() {
        this.f9792b.m8940t();
        m8767h();
    }

    public int getFrame() {
        return this.f9792b.m8931k();
    }

    public void setFrame(int OplusGLSurfaceView_13) {
        this.f9792b.m8916c(OplusGLSurfaceView_13);
    }

    public float getProgress() {
        return this.f9792b.m8941u();
    }

    public void setProgress(float COUIBaseListPopupWindow_12) {
        this.f9792b.m8924e(COUIBaseListPopupWindow_12);
    }

    public long getDuration() {
        EffectiveAnimationComposition c2272a = this.f9801k;
        if (c2272a != null) {
            return (long) c2272a.m8794e();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f9792b.m8913b(z);
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.f9792b.m8914c();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m8766g() {
        this.f9801k = null;
        this.f9792b.m8918d();
    }

    public void setRenderMode(RenderMode enumC2422n) {
        this.f9798h = enumC2422n;
        m8767h();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m8767h() {
        EffectiveAnimationComposition c2272a;
        if (OplusLog.f10386b) {
            OplusLog.m9285a("Render mode : " + this.f9798h.name());
        }
        int OplusGLSurfaceView_13 = C22682.f9803a[this.f9798h.ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            setLayerType(2, null);
            return;
        }
        if (OplusGLSurfaceView_13 == 2) {
            setLayerType(1, null);
            return;
        }
        boolean z = false;
        if (OplusGLSurfaceView_13 == 3) {
            setLayerType(0, null);
            return;
        }
        if (OplusGLSurfaceView_13 != 4) {
            return;
        }
        EffectiveAnimationComposition c2272a2 = this.f9801k;
        if ((c2272a2 == null || !c2272a2.m8787a() || Build.VERSION.SDK_INT >= 28) && ((c2272a = this.f9801k) == null || c2272a.m8788b() <= 4)) {
            z = true;
        }
        setLayerType(z ? 2 : 1, null);
    }

    /* renamed from: com.oplus.anim.EffectiveAnimationView$2 */
    static /* synthetic */ class C22682 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f9803a = new int[RenderMode.values().length];

        static {
            try {
                f9803a[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9803a[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9803a[RenderMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9803a[RenderMode.AUTOMATIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.oplus.anim.EffectiveAnimationView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
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

        /* synthetic */ SavedState(Parcel parcel, C22671 c22671) {
            this(parcel);
        }

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

    /* renamed from: com.oplus.anim.EffectiveAnimationView$PlatformImplementations.kt_3 */
    static class C2270a implements EffectiveAnimationListener<Throwable> {

        /* renamed from: PlatformImplementations.kt_3 */
        WeakReference<EffectiveAnimationView> f9804a;

        C2270a(EffectiveAnimationView effectiveAnimationView) {
            this.f9804a = new WeakReference<>(effectiveAnimationView);
        }

        @Override // com.oplus.anim.EffectiveAnimationListener
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo8781a(Throwable th) {
            WeakReference<EffectiveAnimationView> weakReference = this.f9804a;
            if (weakReference != null && weakReference.get() != null) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        }
    }

    /* renamed from: com.oplus.anim.EffectiveAnimationView$IntrinsicsJvm.kt_4 */
    static class C2271b implements EffectiveAnimationListener<EffectiveAnimationComposition> {

        /* renamed from: PlatformImplementations.kt_3 */
        WeakReference<EffectiveAnimationView> f9805a;

        C2271b(EffectiveAnimationView effectiveAnimationView) {
            this.f9805a = new WeakReference<>(effectiveAnimationView);
        }

        @Override // com.oplus.anim.EffectiveAnimationListener
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo8781a(EffectiveAnimationComposition c2272a) {
            WeakReference<EffectiveAnimationView> weakReference = this.f9805a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f9805a.get().setComposition(c2272a);
        }
    }
}
