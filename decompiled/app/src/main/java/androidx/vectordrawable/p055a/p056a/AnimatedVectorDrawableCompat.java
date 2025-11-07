package androidx.vectordrawable.p055a.p056a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p027a.p028a.TypedArrayUtils;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedVectorDrawableCompat.java */
/* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements InterfaceC0805b {

    /* renamed from: PlatformImplementations.kt_3 */
    ArrayList<Object> f4689a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final Drawable.Callback f4690b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PlatformImplementations.kt_3 f4691d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Context f4692e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ArgbEvaluator f4693f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Animator.AnimatorListener f4694g;

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int OplusGLSurfaceView_13) {
        super.setChangingConfigurations(OplusGLSurfaceView_13);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
        super.setColorFilter(OplusGLSurfaceView_13, mode);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float COUIBaseListPopupWindow_12, float f2) {
        super.setHotspot(COUIBaseListPopupWindow_12, f2);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.setHotspotBounds(OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context) {
        this(context, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context, PlatformImplementations.kt_3 aVar, Resources resources) {
        this.f4693f = null;
        this.f4694g = null;
        this.f4689a = null;
        this.f4690b = new Drawable.Callback() { // from class: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                AnimatedVectorDrawableCompat.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long OplusGLSurfaceView_15) {
                AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, OplusGLSurfaceView_15);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
            }
        };
        this.f4692e = context;
        if (aVar != null) {
            this.f4691d = aVar;
        } else {
            this.f4691d = new PlatformImplementations.kt_3(context, aVar, this.f4690b, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f4706c != null) {
            this.f4706c.mutate();
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static AnimatedVectorDrawableCompat m4836a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat c0806c = new AnimatedVectorDrawableCompat(context);
        c0806c.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0806c;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f4706c == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new IntrinsicsJvm.kt_4(this.f4706c.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.f4706c != null) {
            return this.f4706c.getChangingConfigurations();
        }
        return this.f4691d.f4696a | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f4706c != null) {
            this.f4706c.draw(canvas);
            return;
        }
        this.f4691d.f4697b.draw(canvas);
        if (this.f4691d.f4698c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f4706c != null) {
            this.f4706c.setBounds(rect);
        } else {
            this.f4691d.f4697b.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f4706c != null) {
            return this.f4706c.setState(iArr);
        }
        return this.f4691d.f4697b.setState(iArr);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int OplusGLSurfaceView_13) {
        if (this.f4706c != null) {
            return this.f4706c.setLevel(OplusGLSurfaceView_13);
        }
        return this.f4691d.f4697b.setLevel(OplusGLSurfaceView_13);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.f4706c != null) {
            return DrawableCompat.m2577c(this.f4706c);
        }
        return this.f4691d.f4697b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int OplusGLSurfaceView_13) {
        if (this.f4706c != null) {
            this.f4706c.setAlpha(OplusGLSurfaceView_13);
        } else {
            this.f4691d.f4697b.setAlpha(OplusGLSurfaceView_13);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f4706c != null) {
            this.f4706c.setColorFilter(colorFilter);
        } else {
            this.f4691d.f4697b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        if (this.f4706c != null) {
            return DrawableCompat.m2579e(this.f4706c);
        }
        return this.f4691d.f4697b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int OplusGLSurfaceView_13) {
        if (this.f4706c != null) {
            DrawableCompat.m2568a(this.f4706c, OplusGLSurfaceView_13);
        } else {
            this.f4691d.f4697b.setTint(OplusGLSurfaceView_13);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f4706c != null) {
            DrawableCompat.m2570a(this.f4706c, colorStateList);
        } else {
            this.f4691d.f4697b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f4706c != null) {
            DrawableCompat.m2573a(this.f4706c, mode);
        } else {
            this.f4691d.f4697b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.f4706c != null) {
            return this.f4706c.setVisible(z, z2);
        }
        this.f4691d.f4697b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.f4706c != null) {
            return this.f4706c.isStateful();
        }
        return this.f4691d.f4697b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f4706c != null) {
            return this.f4706c.getOpacity();
        }
        return this.f4691d.f4697b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f4706c != null) {
            return this.f4706c.getIntrinsicWidth();
        }
        return this.f4691d.f4697b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f4706c != null) {
            return this.f4706c.getIntrinsicHeight();
        }
        return this.f4691d.f4697b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        if (this.f4706c != null) {
            return DrawableCompat.m2575b(this.f4706c);
        }
        return this.f4691d.f4697b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f4706c != null) {
            DrawableCompat.m2574a(this.f4706c, z);
        } else {
            this.f4691d.f4697b.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.f4706c != null) {
            DrawableCompat.m2572a(this.f4706c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, AndroidResources.f4681e);
                    int resourceId = typedArrayM2311a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat c0812iM4869a = VectorDrawableCompat.m4869a(resources, resourceId, theme);
                        c0812iM4869a.m4876a(false);
                        c0812iM4869a.setCallback(this.f4690b);
                        if (this.f4691d.f4697b != null) {
                            this.f4691d.f4697b.setCallback(null);
                        }
                        this.f4691d.f4697b = c0812iM4869a;
                    }
                    typedArrayM2311a.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, AndroidResources.f4682f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f4692e;
                        if (context != null) {
                            m4838a(string, AnimatorInflaterCompat.m4844a(context, resourceId2));
                        } else {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f4691d.m4839a();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        if (this.f4706c != null) {
            DrawableCompat.m2571a(this.f4706c, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f4706c != null) {
            return DrawableCompat.m2578d(this.f4706c);
        }
        return false;
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 extends Drawable.ConstantState {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Drawable.ConstantState f4701a;

        public IntrinsicsJvm.kt_4(Drawable.ConstantState constantState) {
            this.f4701a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat c0806c = new AnimatedVectorDrawableCompat();
            c0806c.f4706c = this.f4701a.newDrawable();
            c0806c.f4706c.setCallback(c0806c.f4690b);
            return c0806c;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat c0806c = new AnimatedVectorDrawableCompat();
            c0806c.f4706c = this.f4701a.newDrawable(resources);
            c0806c.f4706c.setCallback(c0806c.f4690b);
            return c0806c;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat c0806c = new AnimatedVectorDrawableCompat();
            c0806c.f4706c = this.f4701a.newDrawable(resources, theme);
            c0806c.f4706c.setCallback(c0806c.f4690b);
            return c0806c;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f4701a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4701a.getChangingConfigurations();
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends Drawable.ConstantState {

        /* renamed from: PlatformImplementations.kt_3 */
        int f4696a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        VectorDrawableCompat f4697b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        AnimatorSet f4698c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        ArrayList<Animator> f4699d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        ArrayMap<Animator, String> f4700e;

        public PlatformImplementations.kt_3(Context context, PlatformImplementations.kt_3 aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f4696a = aVar.f4696a;
                VectorDrawableCompat c0812i = aVar.f4697b;
                if (c0812i != null) {
                    Drawable.ConstantState constantState = c0812i.getConstantState();
                    if (resources != null) {
                        this.f4697b = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.f4697b = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    this.f4697b = (VectorDrawableCompat) this.f4697b.mutate();
                    this.f4697b.setCallback(callback);
                    this.f4697b.setBounds(aVar.f4697b.getBounds());
                    this.f4697b.m4876a(false);
                }
                ArrayList<Animator> arrayList = aVar.f4699d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f4699d = new ArrayList<>(size);
                    this.f4700e = new ArrayMap<>(size);
                    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                        Animator animator = aVar.f4699d.get(OplusGLSurfaceView_13);
                        Animator animatorClone = animator.clone();
                        String str = aVar.f4700e.get(animator);
                        animatorClone.setTarget(this.f4697b.m4875a(str));
                        this.f4699d.add(animatorClone);
                        this.f4700e.put(animatorClone, str);
                    }
                    m4839a();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4696a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4839a() {
            if (this.f4698c == null) {
                this.f4698c = new AnimatorSet();
            }
            this.f4698c.playTogether(this.f4699d);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4837a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childAnimations.size(); OplusGLSurfaceView_13++) {
                m4837a(childAnimations.get(OplusGLSurfaceView_13));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f4693f == null) {
                    this.f4693f = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f4693f);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4838a(String str, Animator animator) {
        animator.setTarget(this.f4691d.f4697b.m4875a(str));
        if (Build.VERSION.SDK_INT < 21) {
            m4837a(animator);
        }
        if (this.f4691d.f4699d == null) {
            this.f4691d.f4699d = new ArrayList<>();
            this.f4691d.f4700e = new ArrayMap<>();
        }
        this.f4691d.f4699d.add(animator);
        this.f4691d.f4700e.put(animator, str);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        if (this.f4706c != null) {
            return ((AnimatedVectorDrawable) this.f4706c).isRunning();
        }
        return this.f4691d.f4698c.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f4706c != null) {
            ((AnimatedVectorDrawable) this.f4706c).start();
        } else {
            if (this.f4691d.f4698c.isStarted()) {
                return;
            }
            this.f4691d.f4698c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f4706c != null) {
            ((AnimatedVectorDrawable) this.f4706c).stop();
        } else {
            this.f4691d.f4698c.end();
        }
    }
}
