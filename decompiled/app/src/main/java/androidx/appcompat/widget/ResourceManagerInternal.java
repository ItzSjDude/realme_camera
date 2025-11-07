package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.p018b.p019a.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.R;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SparseArrayCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p027a.ContextCompat;
import androidx.vectordrawable.p055a.p056a.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.p055a.p056a.VectorDrawableCompat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourceManagerInternal.java */
/* renamed from: androidx.appcompat.widget.ah */
/* loaded from: classes.dex */
public final class ResourceManagerInternal {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static ResourceManagerInternal f1797b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> f1799d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ArrayMap<String, IntrinsicsJvm.kt_5> f1800e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private SparseArrayCompat<String> f1801f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> f1802g = new WeakHashMap<>(0);

    /* renamed from: COUIBaseListPopupWindow_10 */
    private TypedValue f1803h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f1804i;

    /* renamed from: OplusGLSurfaceView_15 */
    private COUIBaseListPopupWindow_8 f1805j;

    /* renamed from: PlatformImplementations.kt_3 */
    private static final PorterDuff.Mode f1796a = PorterDuff.Mode.SRC_IN;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final IntrinsicsJvm.kt_3 f1798c = new IntrinsicsJvm.kt_3(6);

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: androidx.appcompat.widget.ah$IntrinsicsJvm.kt_5 */
    private interface IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        Drawable mo1481a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: androidx.appcompat.widget.ah$COUIBaseListPopupWindow_8 */
    interface COUIBaseListPopupWindow_8 {
        /* renamed from: PlatformImplementations.kt_3 */
        ColorStateList mo1485a(Context context, int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        PorterDuff.Mode mo1486a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        Drawable mo1487a(ResourceManagerInternal c0312ah, Context context, int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo1488a(Context context, int OplusGLSurfaceView_13, Drawable drawable);

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo1489b(Context context, int OplusGLSurfaceView_13, Drawable drawable);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized ResourceManagerInternal m1462a() {
        if (f1797b == null) {
            f1797b = new ResourceManagerInternal();
            m1465a(f1797b);
        }
        return f1797b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m1465a(ResourceManagerInternal c0312ah) {
        if (Build.VERSION.SDK_INT < 24) {
            c0312ah.m1466a("vector", new COUIBaseListPopupWindow_12());
            c0312ah.m1466a("animated-vector", new IntrinsicsJvm.kt_4());
            c0312ah.m1466a("animated-selector", new PlatformImplementations.kt_3());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m1478a(COUIBaseListPopupWindow_8 eVar) {
        this.f1805j = eVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized Drawable m1474a(Context context, int OplusGLSurfaceView_13) {
        return m1475a(context, OplusGLSurfaceView_13, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    synchronized Drawable m1475a(Context context, int OplusGLSurfaceView_13, boolean z) {
        Drawable drawableM1471d;
        m1469b(context);
        drawableM1471d = m1471d(context, OplusGLSurfaceView_13);
        if (drawableM1471d == null) {
            drawableM1471d = m1470c(context, OplusGLSurfaceView_13);
        }
        if (drawableM1471d == null) {
            drawableM1471d = ContextCompat.m2248a(context, OplusGLSurfaceView_13);
        }
        if (drawableM1471d != null) {
            drawableM1471d = m1460a(context, OplusGLSurfaceView_13, z, drawableM1471d);
        }
        if (drawableM1471d != null) {
            DrawableUtils.m1396b(drawableM1471d);
        }
        return drawableM1471d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m1477a(Context context) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f1802g.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static long m1457a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Drawable m1470c(Context context, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        if (this.f1803h == null) {
            this.f1803h = new TypedValue();
        }
        TypedValue typedValue = this.f1803h;
        context.getResources().getValue(OplusGLSurfaceView_13, typedValue, true);
        long jM1457a = m1457a(typedValue);
        Drawable drawableM1461a = m1461a(context, jM1457a);
        if (drawableM1461a != null) {
            return drawableM1461a;
        }
        COUIBaseListPopupWindow_8 eVar = this.f1805j;
        Drawable drawableMo1487a = eVar == null ? null : eVar.mo1487a(this, context, OplusGLSurfaceView_13);
        if (drawableMo1487a != null) {
            drawableMo1487a.setChangingConfigurations(typedValue.changingConfigurations);
            m1467a(context, jM1457a, drawableMo1487a);
        }
        return drawableMo1487a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Drawable m1460a(Context context, int OplusGLSurfaceView_13, boolean z, Drawable drawable) {
        ColorStateList colorStateListM1480b = m1480b(context, OplusGLSurfaceView_13);
        if (colorStateListM1480b != null) {
            if (DrawableUtils.m1397c(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable drawableM2581g = DrawableCompat.m2581g(drawable);
            DrawableCompat.m2570a(drawableM2581g, colorStateListM1480b);
            PorterDuff.Mode modeM1473a = m1473a(OplusGLSurfaceView_13);
            if (modeM1473a == null) {
                return drawableM2581g;
            }
            DrawableCompat.m2573a(drawableM2581g, modeM1473a);
            return drawableM2581g;
        }
        COUIBaseListPopupWindow_8 eVar = this.f1805j;
        if ((eVar == null || !eVar.mo1488a(context, OplusGLSurfaceView_13, drawable)) && !m1479a(context, OplusGLSurfaceView_13, drawable) && z) {
            return null;
        }
        return drawable;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Drawable m1471d(Context context, int OplusGLSurfaceView_13) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        ArrayMap<String, IntrinsicsJvm.kt_5> arrayMap = this.f1800e;
        if (arrayMap == null || arrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat<String> sparseArrayCompat = this.f1801f;
        if (sparseArrayCompat != null) {
            String str = sparseArrayCompat.get(OplusGLSurfaceView_13);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f1800e.get(str) == null)) {
                return null;
            }
        } else {
            this.f1801f = new SparseArrayCompat<>();
        }
        if (this.f1803h == null) {
            this.f1803h = new TypedValue();
        }
        TypedValue typedValue = this.f1803h;
        Resources resources = context.getResources();
        resources.getValue(OplusGLSurfaceView_13, typedValue, true);
        long jM1457a = m1457a(typedValue);
        Drawable drawableM1461a = m1461a(context, jM1457a);
        if (drawableM1461a != null) {
            return drawableM1461a;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(OplusGLSurfaceView_13);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f1801f.append(OplusGLSurfaceView_13, name);
                IntrinsicsJvm.kt_5 dVar = this.f1800e.get(name);
                if (dVar != null) {
                    drawableM1461a = dVar.mo1481a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableM1461a != null) {
                    drawableM1461a.setChangingConfigurations(typedValue.changingConfigurations);
                    m1467a(context, jM1457a, drawableM1461a);
                }
            } catch (Exception e2) {
                Log.COUIBaseListPopupWindow_8("ResourceManagerInternal", "Exception while inflating drawable", e2);
            }
        }
        if (drawableM1461a == null) {
            this.f1801f.append(OplusGLSurfaceView_13, "appcompat_skip_skip");
        }
        return drawableM1461a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private synchronized Drawable m1461a(Context context, long OplusGLSurfaceView_15) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f1802g.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReference = longSparseArray.get(OplusGLSurfaceView_15);
        if (weakReference != null) {
            Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.delete(OplusGLSurfaceView_15);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private synchronized boolean m1467a(Context context, long OplusGLSurfaceView_15, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f1802g.get(context);
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray<>();
            this.f1802g.put(context, longSparseArray);
        }
        longSparseArray.put(OplusGLSurfaceView_15, new WeakReference<>(constantState));
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    synchronized Drawable m1476a(Context context, VectorEnabledTintResources c0327aw, int OplusGLSurfaceView_13) {
        Drawable drawableM1471d = m1471d(context, OplusGLSurfaceView_13);
        if (drawableM1471d == null) {
            drawableM1471d = c0327aw.m1621a(OplusGLSurfaceView_13);
        }
        if (drawableM1471d == null) {
            return null;
        }
        return m1460a(context, OplusGLSurfaceView_13, false, drawableM1471d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m1479a(Context context, int OplusGLSurfaceView_13, Drawable drawable) {
        COUIBaseListPopupWindow_8 eVar = this.f1805j;
        return eVar != null && eVar.mo1489b(context, OplusGLSurfaceView_13, drawable);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1466a(String str, IntrinsicsJvm.kt_5 dVar) {
        if (this.f1800e == null) {
            this.f1800e = new ArrayMap<>();
        }
        this.f1800e.put(str, dVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    PorterDuff.Mode m1473a(int OplusGLSurfaceView_13) {
        COUIBaseListPopupWindow_8 eVar = this.f1805j;
        if (eVar == null) {
            return null;
        }
        return eVar.mo1486a(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    synchronized ColorStateList m1480b(Context context, int OplusGLSurfaceView_13) {
        ColorStateList colorStateListM1472e;
        colorStateListM1472e = m1472e(context, OplusGLSurfaceView_13);
        if (colorStateListM1472e == null) {
            colorStateListM1472e = this.f1805j == null ? null : this.f1805j.mo1485a(context, OplusGLSurfaceView_13);
            if (colorStateListM1472e != null) {
                m1463a(context, OplusGLSurfaceView_13, colorStateListM1472e);
            }
        }
        return colorStateListM1472e;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ColorStateList m1472e(Context context, int OplusGLSurfaceView_13) {
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.f1799d;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return sparseArrayCompat.get(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1463a(Context context, int OplusGLSurfaceView_13, ColorStateList colorStateList) {
        if (this.f1799d == null) {
            this.f1799d = new WeakHashMap<>();
        }
        SparseArrayCompat<ColorStateList> sparseArrayCompat = this.f1799d.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat<>();
            this.f1799d.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(OplusGLSurfaceView_13, colorStateList);
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: androidx.appcompat.widget.ah$IntrinsicsJvm.kt_3 */
    private static class IntrinsicsJvm.kt_3 extends LruCache<Integer, PorterDuffColorFilter> {
        public IntrinsicsJvm.kt_3(int OplusGLSurfaceView_13) {
            super(OplusGLSurfaceView_13);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        PorterDuffColorFilter m1483a(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
            return get(Integer.valueOf(m1482b(OplusGLSurfaceView_13, mode)));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        PorterDuffColorFilter m1484a(int OplusGLSurfaceView_13, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(m1482b(OplusGLSurfaceView_13, mode)), porterDuffColorFilter);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static int m1482b(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
            return ((OplusGLSurfaceView_13 + 31) * 31) + mode.hashCode();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m1464a(Drawable drawable, TintInfo c0320ap, int[] iArr) {
        if (DrawableUtils.m1397c(drawable) && drawable.mutate() != drawable) {
            Log.IntrinsicsJvm.kt_5("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (c0320ap.f1872d || c0320ap.f1871c) {
            drawable.setColorFilter(m1459a(c0320ap.f1872d ? c0320ap.f1869a : null, c0320ap.f1871c ? c0320ap.f1870b : f1796a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static PorterDuffColorFilter m1459a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m1458a(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized PorterDuffColorFilter m1458a(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterM1483a;
        porterDuffColorFilterM1483a = f1798c.m1483a(OplusGLSurfaceView_13, mode);
        if (porterDuffColorFilterM1483a == null) {
            porterDuffColorFilterM1483a = new PorterDuffColorFilter(OplusGLSurfaceView_13, mode);
            f1798c.m1484a(OplusGLSurfaceView_13, mode, porterDuffColorFilterM1483a);
        }
        return porterDuffColorFilterM1483a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1469b(Context context) {
        if (this.f1804i) {
            return;
        }
        this.f1804i = true;
        Drawable drawableM1474a = m1474a(context, R.drawable.abc_vector_test);
        if (drawableM1474a == null || !m1468a(drawableM1474a)) {
            this.f1804i = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m1468a(Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: androidx.appcompat.widget.ah$COUIBaseListPopupWindow_12 */
    private static class COUIBaseListPopupWindow_12 implements IntrinsicsJvm.kt_5 {
        COUIBaseListPopupWindow_12() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public Drawable mo1481a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.m4870a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("VdcInflateDelegate", "Exception while inflating <vector>", COUIBaseListPopupWindow_8);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: androidx.appcompat.widget.ah$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 implements IntrinsicsJvm.kt_5 {
        IntrinsicsJvm.kt_4() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public Drawable mo1481a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.m4836a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("AvdcInflateDelegate", "Exception while inflating <animated-vector>", COUIBaseListPopupWindow_8);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: androidx.appcompat.widget.ah$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 implements IntrinsicsJvm.kt_5 {
        PlatformImplementations.kt_3() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public Drawable mo1481a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.m980a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("AsldcInflateDelegate", "Exception while inflating <animated-selector>", COUIBaseListPopupWindow_8);
                return null;
            }
        }
    }
}
