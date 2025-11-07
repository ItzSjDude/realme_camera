package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.p027a.p028a.ResourcesCompat;
import androidx.core.widget.InterfaceC0522b;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;

/* compiled from: AppCompatTextHelper.java */
/* renamed from: androidx.appcompat.widget.v */
/* loaded from: classes.dex */
class AppCompatTextHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private final TextView f1990a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private TintInfo f1991b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TintInfo f1992c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TintInfo f1993d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private TintInfo f1994e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private TintInfo f1995f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private TintInfo f1996g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private TintInfo f1997h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final AppCompatTextViewAutoSizeHelper f1998i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f1999j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f2000k = -1;

    /* renamed from: OplusGLSurfaceView_14 */
    private Typeface f2001l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f2002m;

    AppCompatTextHelper(TextView textView) {
        this.f1990a = textView;
        this.f1998i = new AppCompatTextViewAutoSizeHelper(this.f1990a);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012b  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m1718a(android.util.AttributeSet r19, int r20) {
        /*
            Method dump skipped, instructions count: 829
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.m1718a(android.util.AttributeSet, int):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1717a(Typeface typeface) {
        if (this.f2002m) {
            this.f1990a.setTypeface(typeface);
            this.f2001l = typeface;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1719a(Runnable runnable) {
        this.f1990a.post(runnable);
    }

    /* compiled from: AppCompatTextHelper.java */
    /* renamed from: androidx.appcompat.widget.v$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends ResourcesCompat.PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final WeakReference<AppCompatTextHelper> f2003a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f2004b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final int f2005c;

        @Override // androidx.core.p027a.p028a.ResourcesCompat.PlatformImplementations.kt_3
        public void onFontRetrievalFailed(int OplusGLSurfaceView_13) {
        }

        /* compiled from: AppCompatTextHelper.java */
        /* renamed from: androidx.appcompat.widget.v$PlatformImplementations.kt_3$PlatformImplementations.kt_3, reason: collision with other inner class name */
        private class AppCompatTextHelper_3 implements Runnable {

            /* renamed from: IntrinsicsJvm.kt_4 */
            private final WeakReference<AppCompatTextHelper> f2007b;

            /* renamed from: IntrinsicsJvm.kt_3 */
            private final Typeface f2008c;

            AppCompatTextHelper_3(WeakReference<AppCompatTextHelper> weakReference, Typeface typeface) {
                this.f2007b = weakReference;
                this.f2008c = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                AppCompatTextHelper c0350v = this.f2007b.get();
                if (c0350v == null) {
                    return;
                }
                c0350v.m1717a(this.f2008c);
            }
        }

        PlatformImplementations.kt_3(AppCompatTextHelper c0350v, int OplusGLSurfaceView_13, int i2) {
            this.f2003a = new WeakReference<>(c0350v);
            this.f2004b = OplusGLSurfaceView_13;
            this.f2005c = i2;
        }

        @Override // androidx.core.p027a.p028a.ResourcesCompat.PlatformImplementations.kt_3
        public void onFontRetrieved(Typeface typeface) {
            int OplusGLSurfaceView_13;
            AppCompatTextHelper c0350v = this.f2003a.get();
            if (c0350v == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && (OplusGLSurfaceView_13 = this.f2004b) != -1) {
                typeface = Typeface.create(typeface, OplusGLSurfaceView_13, (this.f2005c & 2) != 0);
            }
            c0350v.m1719a(new AppCompatTextHelper_3(this.f2003a, typeface));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1705a(Context context, TintTypedArray c0322ar) {
        String strM1555d;
        this.f1999j = c0322ar.m1544a(R.styleable.TextAppearance_android_textStyle, this.f1999j);
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2000k = c0322ar.m1544a(R.styleable.TextAppearance_android_textFontWeight, -1);
            if (this.f2000k != -1) {
                this.f1999j = (this.f1999j & 2) | 0;
            }
        }
        if (c0322ar.m1561g(R.styleable.TextAppearance_android_fontFamily) || c0322ar.m1561g(R.styleable.TextAppearance_fontFamily)) {
            this.f2001l = null;
            int OplusGLSurfaceView_13 = c0322ar.m1561g(R.styleable.TextAppearance_fontFamily) ? R.styleable.TextAppearance_fontFamily : R.styleable.TextAppearance_android_fontFamily;
            int i2 = this.f2000k;
            int i3 = this.f1999j;
            if (!context.isRestricted()) {
                try {
                    Typeface typefaceM1545a = c0322ar.m1545a(OplusGLSurfaceView_13, this.f1999j, new PlatformImplementations.kt_3(this, i2, i3));
                    if (typefaceM1545a != null) {
                        if (Build.VERSION.SDK_INT >= 28 && this.f2000k != -1) {
                            this.f2001l = Typeface.create(Typeface.create(typefaceM1545a, 0), this.f2000k, (this.f1999j & 2) != 0);
                        } else {
                            this.f2001l = typefaceM1545a;
                        }
                    }
                    this.f2002m = this.f2001l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f2001l != null || (strM1555d = c0322ar.m1555d(OplusGLSurfaceView_13)) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && this.f2000k != -1) {
                this.f2001l = Typeface.create(Typeface.create(strM1555d, 0), this.f2000k, (this.f1999j & 2) != 0);
                return;
            } else {
                this.f2001l = Typeface.create(strM1555d, this.f1999j);
                return;
            }
        }
        if (c0322ar.m1561g(R.styleable.TextAppearance_android_typeface)) {
            this.f2002m = false;
            int iM1544a = c0322ar.m1544a(R.styleable.TextAppearance_android_typeface, 1);
            if (iM1544a == 1) {
                this.f2001l = Typeface.SANS_SERIF;
            } else if (iM1544a == 2) {
                this.f2001l = Typeface.SERIF;
            } else {
                if (iM1544a != 3) {
                    return;
                }
                this.f2001l = Typeface.MONOSPACE;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1714a(Context context, int OplusGLSurfaceView_13) {
        String strM1555d;
        ColorStateList colorStateListM1557e;
        TintTypedArray c0322arM1539a = TintTypedArray.m1539a(context, OplusGLSurfaceView_13, R.styleable.TextAppearance);
        if (c0322arM1539a.m1561g(R.styleable.TextAppearance_textAllCaps)) {
            m1720a(c0322arM1539a.m1547a(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && c0322arM1539a.m1561g(R.styleable.TextAppearance_android_textColor) && (colorStateListM1557e = c0322arM1539a.m1557e(R.styleable.TextAppearance_android_textColor)) != null) {
            this.f1990a.setTextColor(colorStateListM1557e);
        }
        if (c0322arM1539a.m1561g(R.styleable.TextAppearance_android_textSize) && c0322arM1539a.m1556e(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f1990a.setTextSize(0, 0.0f);
        }
        m1705a(context, c0322arM1539a);
        if (Build.VERSION.SDK_INT >= 26 && c0322arM1539a.m1561g(R.styleable.TextAppearance_fontVariationSettings) && (strM1555d = c0322arM1539a.m1555d(R.styleable.TextAppearance_fontVariationSettings)) != null) {
            this.f1990a.setFontVariationSettings(strM1555d);
        }
        c0322arM1539a.m1551b();
        Typeface typeface = this.f2001l;
        if (typeface != null) {
            this.f1990a.setTypeface(typeface, this.f1999j);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1720a(boolean z) {
        this.f1990a.setAllCaps(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1710a() {
        m1723b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m1723b() {
        if (this.f1991b != null || this.f1992c != null || this.f1993d != null || this.f1994e != null) {
            Drawable[] compoundDrawables = this.f1990a.getCompoundDrawables();
            m1707a(compoundDrawables[0], this.f1991b);
            m1707a(compoundDrawables[1], this.f1992c);
            m1707a(compoundDrawables[2], this.f1993d);
            m1707a(compoundDrawables[3], this.f1994e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f1995f == null && this.f1996g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f1990a.getCompoundDrawablesRelative();
            m1707a(compoundDrawablesRelative[0], this.f1995f);
            m1707a(compoundDrawablesRelative[2], this.f1996g);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1707a(Drawable drawable, TintInfo c0320ap) {
        if (drawable == null || c0320ap == null) {
            return;
        }
        AppCompatDrawableManager.m1665a(drawable, c0320ap, this.f1990a.getDrawableState());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static TintInfo m1704a(Context context, AppCompatDrawableManager c0337i, int OplusGLSurfaceView_13) {
        ColorStateList colorStateListM1671b = c0337i.m1671b(context, OplusGLSurfaceView_13);
        if (colorStateListM1671b == null) {
            return null;
        }
        TintInfo c0320ap = new TintInfo();
        c0320ap.f1872d = true;
        c0320ap.f1869a = colorStateListM1671b;
        return c0320ap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1721a(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (InterfaceC0522b.f3166d) {
            return;
        }
        m1724c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1712a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        if (InterfaceC0522b.f3166d || m1725d()) {
            return;
        }
        m1708b(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m1724c() {
        this.f1998i.m1762f();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean m1725d() {
        return this.f1998i.m1763g();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1708b(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f1998i.m1753a(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1711a(int OplusGLSurfaceView_13) {
        this.f1998i.m1752a(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1713a(int OplusGLSurfaceView_13, int i2, int i3, int i4) throws IllegalArgumentException {
        this.f1998i.m1754a(OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1722a(int[] iArr, int OplusGLSurfaceView_13) throws IllegalArgumentException {
        this.f1998i.m1756a(iArr, OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    int m1726e() {
        return this.f1998i.m1750a();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    int m1727f() {
        return this.f1998i.m1757b();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    int m1728g() {
        return this.f1998i.m1759c();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    int m1729h() {
        return this.f1998i.m1760d();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    int[] m1730i() {
        return this.f1998i.m1761e();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    ColorStateList m1731j() {
        TintInfo c0320ap = this.f1997h;
        if (c0320ap != null) {
            return c0320ap.f1869a;
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1715a(ColorStateList colorStateList) {
        if (this.f1997h == null) {
            this.f1997h = new TintInfo();
        }
        TintInfo c0320ap = this.f1997h;
        c0320ap.f1869a = colorStateList;
        c0320ap.f1872d = colorStateList != null;
        m1709l();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    PorterDuff.Mode m1732k() {
        TintInfo c0320ap = this.f1997h;
        if (c0320ap != null) {
            return c0320ap.f1870b;
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1716a(PorterDuff.Mode mode) {
        if (this.f1997h == null) {
            this.f1997h = new TintInfo();
        }
        TintInfo c0320ap = this.f1997h;
        c0320ap.f1870b = mode;
        c0320ap.f1871c = mode != null;
        m1709l();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m1709l() {
        TintInfo c0320ap = this.f1997h;
        this.f1991b = c0320ap;
        this.f1992c = c0320ap;
        this.f1993d = c0320ap;
        this.f1994e = c0320ap;
        this.f1995f = c0320ap;
        this.f1996g = c0320ap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1706a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f1990a.getCompoundDrawablesRelative();
            TextView textView = this.f1990a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.f1990a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.f1990a;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.f1990a.getCompoundDrawables();
        TextView textView3 = this.f1990a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }
}
