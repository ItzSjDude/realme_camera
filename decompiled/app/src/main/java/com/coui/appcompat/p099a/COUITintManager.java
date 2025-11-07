package com.coui.appcompat.p099a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.collection.LruCache;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p027a.ContextCompat;
import coui.support.appcompat.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: COUITintManager.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.v */
/* loaded from: classes.dex */
public final class COUITintManager {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final boolean f6363a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final PorterDuff.Mode f6364b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final WeakHashMap<Context, COUITintManager> f6365c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final PlatformImplementations.kt_3 f6366d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final WeakReference<Context> f6367e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private SparseArray<ColorStateList> f6368f;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final PorterDuff.Mode m6494b(int OplusGLSurfaceView_13) {
        return null;
    }

    static {
        f6363a = Build.VERSION.SDK_INT < 21;
        f6364b = PorterDuff.Mode.SRC_IN;
        f6365c = new WeakHashMap<>();
        f6366d = new PlatformImplementations.kt_3(6);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static COUITintManager m6488a(Context context) {
        COUITintManager c1278v = f6365c.get(context);
        if (c1278v != null) {
            return c1278v;
        }
        COUITintManager c1278v2 = new COUITintManager(context);
        f6365c.put(context, c1278v2);
        return c1278v2;
    }

    private COUITintManager(Context context) {
        this.f6367e = new WeakReference<>(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Drawable m6491a(int OplusGLSurfaceView_13) {
        return m6492a(OplusGLSurfaceView_13, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Drawable m6492a(int OplusGLSurfaceView_13, boolean z) {
        Context context = this.f6367e.get();
        Drawable drawableM2581g = null;
        if (context == null) {
            return null;
        }
        Drawable drawableM2248a = ContextCompat.m2248a(context, OplusGLSurfaceView_13);
        if (drawableM2248a == null) {
            return drawableM2248a;
        }
        if (Build.VERSION.SDK_INT >= 8) {
            drawableM2248a = drawableM2248a.mutate();
        }
        ColorStateList colorStateListM6495c = m6495c(OplusGLSurfaceView_13);
        if (colorStateListM6495c != null) {
            drawableM2581g = DrawableCompat.m2581g(drawableM2248a);
            DrawableCompat.m2570a(drawableM2581g, colorStateListM6495c);
            PorterDuff.Mode modeM6494b = m6494b(OplusGLSurfaceView_13);
            if (modeM6494b != null) {
                DrawableCompat.m2573a(drawableM2581g, modeM6494b);
            }
        } else if (m6493a(OplusGLSurfaceView_13, drawableM2248a) || !z) {
            return drawableM2248a;
        }
        return drawableM2581g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m6493a(int OplusGLSurfaceView_13, Drawable drawable) {
        if (this.f6367e.get() == null) {
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final ColorStateList m6495c(int OplusGLSurfaceView_13) {
        Context context = this.f6367e.get();
        if (context == null) {
            return null;
        }
        SparseArray<ColorStateList> sparseArray = this.f6368f;
        ColorStateList colorStateListM6490b = sparseArray != null ? sparseArray.get(OplusGLSurfaceView_13) : null;
        if (colorStateListM6490b == null) {
            if (OplusGLSurfaceView_13 == R.drawable.coui_back_arrow_normal) {
                colorStateListM6490b = m6490b(context);
            }
            if (colorStateListM6490b != null) {
                if (this.f6368f == null) {
                    this.f6368f = new SparseArray<>();
                }
                this.f6368f.append(OplusGLSurfaceView_13, colorStateListM6490b);
            }
        }
        return colorStateListM6490b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ColorStateList m6490b(Context context) {
        return new ColorStateList(new int[][]{COUIThemeUtils.f6353a, COUIThemeUtils.f6356d, COUIThemeUtils.f6359g}, new int[]{COUIThemeUtils.m6487c(context, R.attr.couiTintControlDisabled), COUIThemeUtils.m6483a(context, R.attr.couiTintControlPressed), COUIThemeUtils.m6483a(context, R.attr.couiTintControlNormal)});
    }

    /* compiled from: COUITintManager.java */
    /* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.v$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends LruCache<Integer, PorterDuffColorFilter> {
        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13) {
            super(OplusGLSurfaceView_13);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        PorterDuffColorFilter m6497a(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
            return get(Integer.valueOf(m6496b(OplusGLSurfaceView_13, mode)));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        PorterDuffColorFilter m6498a(int OplusGLSurfaceView_13, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(m6496b(OplusGLSurfaceView_13, mode)), porterDuffColorFilter);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static int m6496b(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
            return ((OplusGLSurfaceView_13 + 31) * 31) + mode.hashCode();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m6489a(Drawable drawable, int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
        if (mode == null) {
            mode = f6364b;
        }
        PorterDuffColorFilter porterDuffColorFilterM6497a = f6366d.m6497a(OplusGLSurfaceView_13, mode);
        if (porterDuffColorFilterM6497a == null) {
            porterDuffColorFilterM6497a = new PorterDuffColorFilter(OplusGLSurfaceView_13, mode);
            f6366d.m6498a(OplusGLSurfaceView_13, mode, porterDuffColorFilterM6497a);
        }
        drawable.setColorFilter(porterDuffColorFilterM6497a);
    }
}
