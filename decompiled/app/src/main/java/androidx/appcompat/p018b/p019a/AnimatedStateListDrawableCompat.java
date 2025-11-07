package androidx.appcompat.p018b.p019a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.p018b.p019a.DrawableContainer;
import androidx.appcompat.p018b.p019a.StateListDrawable;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.p027a.p028a.TypedArrayUtils;
import androidx.vectordrawable.p055a.p056a.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.p055a.p056a.VectorDrawableCompat;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedStateListDrawableCompat.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class AnimatedStateListDrawableCompat extends StateListDrawable implements TintAwareDrawable {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f1092a = "PlatformImplementations.kt_3";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private IntrinsicsJvm.kt_4 f1093b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private COUIBaseListPopupWindow_12 f1094c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f1095d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f1096e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f1097f;

    @Override // androidx.appcompat.p018b.p019a.StateListDrawable, androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.p018b.p019a.StateListDrawable, androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int OplusGLSurfaceView_13) {
        return super.onLayoutDirectionChanged(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long OplusGLSurfaceView_15) {
        super.scheduleDrawable(drawable, runnable, OplusGLSurfaceView_15);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int OplusGLSurfaceView_13) {
        super.setAlpha(OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.setHotspotBounds(OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    AnimatedStateListDrawableCompat(IntrinsicsJvm.kt_4 bVar, Resources resources) {
        super(null);
        this.f1095d = -1;
        this.f1096e = -1;
        mo988a(new IntrinsicsJvm.kt_4(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static AnimatedStateListDrawableCompat m980a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        AnimatedStateListDrawableCompat c0215a = new AnimatedStateListDrawableCompat();
        c0215a.mo990b(context, resources, xmlPullParser, attributeSet, theme);
        return c0215a;
    }

    @Override // androidx.appcompat.p018b.p019a.StateListDrawable
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo990b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(typedArrayM2311a.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        m981a(typedArrayM2311a);
        m1010a(resources);
        typedArrayM2311a.recycle();
        m983c(context, resources, xmlPullParser, attributeSet, theme);
        m986e();
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.f1094c != null && (visible || z2)) {
            if (z) {
                this.f1094c.mo992a();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        COUIBaseListPopupWindow_12 fVar = this.f1094c;
        if (fVar != null) {
            fVar.mo993b();
            this.f1094c = null;
            m1012a(this.f1095d);
            this.f1095d = -1;
            this.f1096e = -1;
        }
    }

    @Override // androidx.appcompat.p018b.p019a.StateListDrawable, androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int iM998a = this.f1093b.m998a(iArr);
        boolean z = iM998a != m1013d() && (m982b(iM998a) || m1012a(iM998a));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m982b(int OplusGLSurfaceView_13) {
        int iD;
        int iM996a;
        COUIBaseListPopupWindow_12 aVar;
        COUIBaseListPopupWindow_12 fVar = this.f1094c;
        if (fVar != null) {
            if (OplusGLSurfaceView_13 == this.f1095d) {
                return true;
            }
            if (OplusGLSurfaceView_13 == this.f1096e && fVar.mo1003c()) {
                fVar.mo1004d();
                this.f1095d = this.f1096e;
                this.f1096e = OplusGLSurfaceView_13;
                return true;
            }
            iD = this.f1095d;
            fVar.mo993b();
        } else {
            iD = m1013d();
        }
        this.f1094c = null;
        this.f1096e = -1;
        this.f1095d = -1;
        IntrinsicsJvm.kt_4 bVar = this.f1093b;
        int iM995a = bVar.m995a(iD);
        int iM995a2 = bVar.m995a(OplusGLSurfaceView_13);
        if (iM995a2 == 0 || iM995a == 0 || (iM996a = bVar.m996a(iM995a, iM995a2)) < 0) {
            return false;
        }
        boolean zM1002c = bVar.m1002c(iM995a, iM995a2);
        m1012a(iM996a);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            aVar = new IntrinsicsJvm.kt_5((AnimationDrawable) current, bVar.m1001b(iM995a, iM995a2), zM1002c);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            aVar = new IntrinsicsJvm.kt_3((AnimatedVectorDrawableCompat) current);
        } else {
            if (current instanceof Animatable) {
                aVar = new PlatformImplementations.kt_3((Animatable) current);
            }
            return false;
        }
        aVar.mo992a();
        this.f1094c = aVar;
        this.f1096e = iD;
        this.f1095d = OplusGLSurfaceView_13;
        return true;
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3$COUIBaseListPopupWindow_12 */
    private static abstract class COUIBaseListPopupWindow_12 {
        /* renamed from: PlatformImplementations.kt_3 */
        public abstract void mo992a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        public abstract void mo993b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo1003c() {
            return false;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo1004d() {
        }

        private COUIBaseListPopupWindow_12() {
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends COUIBaseListPopupWindow_12 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Animatable f1098a;

        PlatformImplementations.kt_3(Animatable animatable) {
            super();
            this.f1098a = animatable;
        }

        @Override // androidx.appcompat.p018b.p019a.AnimatedStateListDrawableCompat.COUIBaseListPopupWindow_12
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo992a() {
            this.f1098a.start();
        }

        @Override // androidx.appcompat.p018b.p019a.AnimatedStateListDrawableCompat.COUIBaseListPopupWindow_12
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo993b() {
            this.f1098a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_5 */
    private static class IntrinsicsJvm.kt_5 extends COUIBaseListPopupWindow_12 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final ObjectAnimator f1102a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final boolean f1103b;

        IntrinsicsJvm.kt_5(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int OplusGLSurfaceView_13 = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            COUIBaseListPopupWindow_8 eVar = new COUIBaseListPopupWindow_8(animationDrawable, z);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", OplusGLSurfaceView_13, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                objectAnimatorOfInt.setAutoCancel(true);
            }
            objectAnimatorOfInt.setDuration(eVar.m1005a());
            objectAnimatorOfInt.setInterpolator(eVar);
            this.f1103b = z2;
            this.f1102a = objectAnimatorOfInt;
        }

        @Override // androidx.appcompat.p018b.p019a.AnimatedStateListDrawableCompat.COUIBaseListPopupWindow_12
        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo1003c() {
            return this.f1103b;
        }

        @Override // androidx.appcompat.p018b.p019a.AnimatedStateListDrawableCompat.COUIBaseListPopupWindow_12
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo992a() {
            this.f1102a.start();
        }

        @Override // androidx.appcompat.p018b.p019a.AnimatedStateListDrawableCompat.COUIBaseListPopupWindow_12
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo1004d() {
            this.f1102a.reverse();
        }

        @Override // androidx.appcompat.p018b.p019a.AnimatedStateListDrawableCompat.COUIBaseListPopupWindow_12
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo993b() {
            this.f1102a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    private static class IntrinsicsJvm.kt_3 extends COUIBaseListPopupWindow_12 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final AnimatedVectorDrawableCompat f1101a;

        IntrinsicsJvm.kt_3(AnimatedVectorDrawableCompat c0806c) {
            super();
            this.f1101a = c0806c;
        }

        @Override // androidx.appcompat.p018b.p019a.AnimatedStateListDrawableCompat.COUIBaseListPopupWindow_12
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo992a() {
            this.f1101a.start();
        }

        @Override // androidx.appcompat.p018b.p019a.AnimatedStateListDrawableCompat.COUIBaseListPopupWindow_12
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo993b() {
            this.f1101a.stop();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m981a(TypedArray typedArray) {
        IntrinsicsJvm.kt_4 bVar = this.f1093b;
        if (Build.VERSION.SDK_INT >= 21) {
            bVar.f1136f |= typedArray.getChangingConfigurations();
        }
        bVar.m1021a(typedArray.getBoolean(R.styleable.f1164x93692c12, bVar.f1141k));
        bVar.m1024b(typedArray.getBoolean(R.styleable.f1161xced414c8, bVar.f1144n));
        bVar.m1026c(typedArray.getInt(R.styleable.f1162x4831be05, bVar.f1124C));
        bVar.m1028d(typedArray.getInt(R.styleable.f1163x94d8b1f1, bVar.f1125D));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, bVar.f1156z));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m986e() {
        onStateChange(getState());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m983c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    m985e(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    m984d(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m984d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = typedArrayM2311a.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = typedArrayM2311a.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = typedArrayM2311a.getResourceId(R.styleable.f1165x799754ae, -1);
        Drawable drawableM1474a = resourceId3 > 0 ? ResourceManagerInternal.m1462a().m1474a(context, resourceId3) : null;
        boolean z = typedArrayM2311a.getBoolean(R.styleable.f1166x30d888c5, false);
        typedArrayM2311a.recycle();
        if (drawableM1474a == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires PlatformImplementations.kt_3 'drawable' attribute or child tag defining PlatformImplementations.kt_3 drawable");
            }
            if (xmlPullParser.getName().equals("animated-vector")) {
                drawableM1474a = AnimatedVectorDrawableCompat.m4836a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawableM1474a = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableM1474a = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableM1474a == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires PlatformImplementations.kt_3 'drawable' attribute or child tag defining PlatformImplementations.kt_3 drawable");
        }
        if (resourceId == -1 || resourceId2 == -1) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
        return this.f1093b.m997a(resourceId, resourceId2, drawableM1474a, z);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int m985e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = typedArrayM2311a.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = typedArrayM2311a.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawableM1474a = resourceId2 > 0 ? ResourceManagerInternal.m1462a().m1474a(context, resourceId2) : null;
        typedArrayM2311a.recycle();
        int[] iArrA = m1044a(attributeSet);
        if (drawableM1474a == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires PlatformImplementations.kt_3 'drawable' attribute or child tag defining PlatformImplementations.kt_3 drawable");
            }
            if (xmlPullParser.getName().equals("vector")) {
                drawableM1474a = VectorDrawableCompat.m4870a(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawableM1474a = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableM1474a = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableM1474a == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires PlatformImplementations.kt_3 'drawable' attribute or child tag defining PlatformImplementations.kt_3 drawable");
        }
        return this.f1093b.m999a(iArrA, drawableM1474a, resourceId);
    }

    @Override // androidx.appcompat.p018b.p019a.StateListDrawable, androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1097f && super.mutate() == this) {
            this.f1093b.mo1000a();
            this.f1097f = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.p018b.p019a.StateListDrawable, androidx.appcompat.p018b.p019a.DrawableContainer
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public IntrinsicsJvm.kt_4 mo991c() {
        return new IntrinsicsJvm.kt_4(this.f1093b, this, null);
    }

    @Override // androidx.appcompat.p018b.p019a.StateListDrawable, androidx.appcompat.p018b.p019a.DrawableContainer
    void clearMutated() {
        super.clearMutated();
        this.f1097f = false;
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    static class IntrinsicsJvm.kt_4 extends StateListDrawable.PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        LongSparseArray<Long> f1099a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        SparseArrayCompat<Integer> f1100b;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private static long m994f(int OplusGLSurfaceView_13, int i2) {
            return i2 | (OplusGLSurfaceView_13 << 32);
        }

        IntrinsicsJvm.kt_4(IntrinsicsJvm.kt_4 bVar, AnimatedStateListDrawableCompat c0215a, Resources resources) {
            super(bVar, c0215a, resources);
            if (bVar != null) {
                this.f1099a = bVar.f1099a;
                this.f1100b = bVar.f1100b;
            } else {
                this.f1099a = new LongSparseArray<>();
                this.f1100b = new SparseArrayCompat<>();
            }
        }

        @Override // androidx.appcompat.p018b.p019a.StateListDrawable.PlatformImplementations.kt_3, androidx.appcompat.p018b.p019a.DrawableContainer.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        void mo1000a() {
            this.f1099a = this.f1099a.m26266clone();
            this.f1100b = this.f1100b.m26267clone();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m997a(int OplusGLSurfaceView_13, int i2, Drawable drawable, boolean z) {
            int iA = super.m1018a(drawable);
            long jM994f = m994f(OplusGLSurfaceView_13, i2);
            long OplusGLSurfaceView_15 = z ? STMobileHumanActionNative.ST_MOBILE_BODY_ACTION2 : 0L;
            long j2 = iA;
            this.f1099a.append(jM994f, Long.valueOf(j2 | OplusGLSurfaceView_15));
            if (z) {
                this.f1099a.append(m994f(i2, OplusGLSurfaceView_13), Long.valueOf(STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 | j2 | OplusGLSurfaceView_15));
            }
            return iA;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m999a(int[] iArr, Drawable drawable, int OplusGLSurfaceView_13) {
            int iM1045a = super.m1045a(iArr, drawable);
            this.f1100b.put(iM1045a, Integer.valueOf(OplusGLSurfaceView_13));
            return iM1045a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m998a(int[] iArr) {
            int iM1046b = super.m1046b(iArr);
            return iM1046b >= 0 ? iM1046b : super.m1046b(StateSet.WILD_CARD);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m995a(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 < 0) {
                return 0;
            }
            return this.f1100b.get(OplusGLSurfaceView_13, 0).intValue();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m996a(int OplusGLSurfaceView_13, int i2) {
            return (int) this.f1099a.get(m994f(OplusGLSurfaceView_13, i2), -1L).longValue();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean m1001b(int OplusGLSurfaceView_13, int i2) {
            return (this.f1099a.get(m994f(OplusGLSurfaceView_13, i2), -1L).longValue() & STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1) != 0;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean m1002c(int OplusGLSurfaceView_13, int i2) {
            return (this.f1099a.get(m994f(OplusGLSurfaceView_13, i2), -1L).longValue() & STMobileHumanActionNative.ST_MOBILE_BODY_ACTION2) != 0;
        }

        @Override // androidx.appcompat.p018b.p019a.StateListDrawable.PlatformImplementations.kt_3, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        @Override // androidx.appcompat.p018b.p019a.StateListDrawable.PlatformImplementations.kt_3, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    @Override // androidx.appcompat.p018b.p019a.StateListDrawable, androidx.appcompat.p018b.p019a.DrawableContainer
    /* renamed from: PlatformImplementations.kt_3 */
    void mo988a(DrawableContainer.IntrinsicsJvm.kt_4 bVar) {
        super.mo988a(bVar);
        if (bVar instanceof IntrinsicsJvm.kt_4) {
            this.f1093b = (IntrinsicsJvm.kt_4) bVar;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3$COUIBaseListPopupWindow_8 */
    private static class COUIBaseListPopupWindow_8 implements TimeInterpolator {

        /* renamed from: PlatformImplementations.kt_3 */
        private int[] f1104a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f1105b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f1106c;

        COUIBaseListPopupWindow_8(AnimationDrawable animationDrawable, boolean z) {
            m1006a(animationDrawable, z);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m1006a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f1105b = numberOfFrames;
            int[] iArr = this.f1104a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f1104a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f1104a;
            int OplusGLSurfaceView_13 = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                OplusGLSurfaceView_13 += duration;
            }
            this.f1106c = OplusGLSurfaceView_13;
            return OplusGLSurfaceView_13;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m1005a() {
            return this.f1106c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float COUIBaseListPopupWindow_12) {
            int OplusGLSurfaceView_13 = (int) ((COUIBaseListPopupWindow_12 * this.f1106c) + 0.5f);
            int i2 = this.f1105b;
            int[] iArr = this.f1104a;
            int i3 = 0;
            while (i3 < i2 && OplusGLSurfaceView_13 >= iArr[i3]) {
                OplusGLSurfaceView_13 -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? OplusGLSurfaceView_13 / this.f1106c : 0.0f);
        }
    }
}
