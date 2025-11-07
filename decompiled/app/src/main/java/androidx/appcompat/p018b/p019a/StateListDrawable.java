package androidx.appcompat.p018b.p019a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.p018b.p019a.DrawableContainer;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.p027a.p028a.TypedArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: StateListDrawable.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
class StateListDrawable extends DrawableContainer {

    /* renamed from: PlatformImplementations.kt_3 */
    private PlatformImplementations.kt_3 f1157a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f1158b;

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    StateListDrawable() {
        this(null, null);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iM1046b = this.f1157a.m1046b(iArr);
        if (iM1046b < 0) {
            iM1046b = this.f1157a.m1046b(StateSet.WILD_CARD);
        }
        return m1012a(iM1046b) || zOnStateChange;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo990b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, R.styleable.StateListDrawable);
        setVisible(typedArrayM2311a.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        m1043a(typedArrayM2311a);
        m1010a(resources);
        typedArrayM2311a.recycle();
        m1042a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1043a(TypedArray typedArray) {
        PlatformImplementations.kt_3 aVar = this.f1157a;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.f1136f |= typedArray.getChangingConfigurations();
        }
        aVar.f1141k = typedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, aVar.f1141k);
        aVar.f1144n = typedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, aVar.f1144n);
        aVar.f1124C = typedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, aVar.f1124C);
        aVar.f1125D = typedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, aVar.f1125D);
        aVar.f1156z = typedArray.getBoolean(R.styleable.StateListDrawable_android_dither, aVar.f1156z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1042a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        PlatformImplementations.kt_3 aVar = this.f1157a;
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
                TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                int resourceId = typedArrayM2311a.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                Drawable drawableM1474a = resourceId > 0 ? ResourceManagerInternal.m1462a().m1474a(context, resourceId) : null;
                typedArrayM2311a.recycle();
                int[] iArrM1044a = m1044a(attributeSet);
                if (drawableM1474a == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires PlatformImplementations.kt_3 'drawable' attribute or child tag defining PlatformImplementations.kt_3 drawable");
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawableM1474a = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                    } else {
                        drawableM1474a = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                    }
                }
                aVar.m1045a(iArrM1044a, drawableM1474a);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int[] m1044a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = OplusGLSurfaceView_13 + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[OplusGLSurfaceView_13] = attributeNameResource;
                OplusGLSurfaceView_13 = i3;
            }
        }
        return StateSet.trimStateSet(iArr, OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1158b && super.mutate() == this) {
            this.f1157a.mo1000a();
            this.f1158b = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.p018b.p019a.DrawableContainer
    /* renamed from: IntrinsicsJvm.kt_4 */
    public PlatformImplementations.kt_3 mo991c() {
        return new PlatformImplementations.kt_3(this.f1157a, this, null);
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer
    void clearMutated() {
        super.clearMutated();
        this.f1158b = false;
    }

    /* compiled from: StateListDrawable.java */
    /* renamed from: androidx.appcompat.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 extends DrawableContainer.IntrinsicsJvm.kt_4 {

        /* renamed from: L */
        int[][] f1159L;

        PlatformImplementations.kt_3(PlatformImplementations.kt_3 aVar, StateListDrawable c0218d, Resources resources) {
            super(aVar, c0218d, resources);
            if (aVar != null) {
                this.f1159L = aVar.f1159L;
            } else {
                this.f1159L = new int[m1025c()][];
            }
        }

        @Override // androidx.appcompat.p018b.p019a.DrawableContainer.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        void mo1000a() {
            int[][] iArr = this.f1159L;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.f1159L;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.f1159L = iArr2;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m1045a(int[] iArr, Drawable drawable) {
            int iA = m1018a(drawable);
            this.f1159L[iA] = iArr;
            return iA;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        int m1046b(int[] iArr) {
            int[][] iArr2 = this.f1159L;
            int iD = m1027d();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iD; OplusGLSurfaceView_13++) {
                if (StateSet.stateSetMatches(iArr2[OplusGLSurfaceView_13], iArr)) {
                    return OplusGLSurfaceView_13;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new StateListDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new StateListDrawable(this, resources);
        }

        @Override // androidx.appcompat.p018b.p019a.DrawableContainer.IntrinsicsJvm.kt_4
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo1031e(int OplusGLSurfaceView_13, int i2) {
            super.mo1031e(OplusGLSurfaceView_13, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.f1159L, 0, iArr, 0, OplusGLSurfaceView_13);
            this.f1159L = iArr;
        }
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.p018b.p019a.DrawableContainer
    /* renamed from: PlatformImplementations.kt_3 */
    void mo988a(DrawableContainer.IntrinsicsJvm.kt_4 bVar) {
        super.mo988a(bVar);
        if (bVar instanceof PlatformImplementations.kt_3) {
            this.f1157a = (PlatformImplementations.kt_3) bVar;
        }
    }

    StateListDrawable(PlatformImplementations.kt_3 aVar, Resources resources) {
        mo988a(new PlatformImplementations.kt_3(aVar, this, resources));
        onStateChange(getState());
    }

    StateListDrawable(PlatformImplementations.kt_3 aVar) {
        if (aVar != null) {
            mo988a(aVar);
        }
    }
}
