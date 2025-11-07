package androidx.core.p034f;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.p035g.ObjectsCompat;
import java.util.concurrent.Executor;

/* compiled from: PrecomputedTextCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class PrecomputedTextCompat implements Spannable {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Object f2908a = new Object();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Executor f2909b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Spannable f2910c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final PlatformImplementations.kt_3 f2911d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final PrecomputedText f2912e;

    /* compiled from: PrecomputedTextCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final PrecomputedText.Params f2913a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final TextPaint f2914b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final TextDirectionHeuristic f2915c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final int f2916d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final int f2917e;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: androidx.core.COUIBaseListPopupWindow_12.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3$PlatformImplementations.kt_3, reason: collision with other inner class name */
        public static class PrecomputedTextCompat_3 {

            /* renamed from: PlatformImplementations.kt_3 */
            private final TextPaint f2918a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            private TextDirectionHeuristic f2919b;

            /* renamed from: IntrinsicsJvm.kt_3 */
            private int f2920c;

            /* renamed from: IntrinsicsJvm.kt_5 */
            private int f2921d;

            public PrecomputedTextCompat_3(TextPaint textPaint) {
                this.f2918a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f2920c = 1;
                    this.f2921d = 1;
                } else {
                    this.f2921d = 0;
                    this.f2920c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f2919b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f2919b = null;
                }
            }

            /* renamed from: PlatformImplementations.kt_3 */
            public PrecomputedTextCompat_3 m2515a(int OplusGLSurfaceView_13) {
                this.f2920c = OplusGLSurfaceView_13;
                return this;
            }

            /* renamed from: IntrinsicsJvm.kt_4 */
            public PrecomputedTextCompat_3 m2518b(int OplusGLSurfaceView_13) {
                this.f2921d = OplusGLSurfaceView_13;
                return this;
            }

            /* renamed from: PlatformImplementations.kt_3 */
            public PrecomputedTextCompat_3 m2516a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f2919b = textDirectionHeuristic;
                return this;
            }

            /* renamed from: PlatformImplementations.kt_3 */
            public PlatformImplementations.kt_3 m2517a() {
                return new PlatformImplementations.kt_3(this.f2918a, this.f2919b, this.f2920c, this.f2921d);
            }
        }

        @SuppressLint({"NewApi"})
        PlatformImplementations.kt_3(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int OplusGLSurfaceView_13, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f2913a = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(OplusGLSurfaceView_13).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f2913a = null;
            }
            this.f2914b = textPaint;
            this.f2915c = textDirectionHeuristic;
            this.f2916d = OplusGLSurfaceView_13;
            this.f2917e = i2;
        }

        public PlatformImplementations.kt_3(PrecomputedText.Params params) {
            this.f2914b = params.getTextPaint();
            this.f2915c = params.getTextDirection();
            this.f2916d = params.getBreakStrategy();
            this.f2917e = params.getHyphenationFrequency();
            this.f2913a = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public TextPaint m2510a() {
            return this.f2914b;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public TextDirectionHeuristic m2512b() {
            return this.f2915c;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int m2513c() {
            return this.f2916d;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int m2514d() {
            return this.f2917e;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m2511a(PlatformImplementations.kt_3 aVar) {
            if ((Build.VERSION.SDK_INT >= 23 && (this.f2916d != aVar.m2513c() || this.f2917e != aVar.m2514d())) || this.f2914b.getTextSize() != aVar.m2510a().getTextSize() || this.f2914b.getTextScaleX() != aVar.m2510a().getTextScaleX() || this.f2914b.getTextSkewX() != aVar.m2510a().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f2914b.getLetterSpacing() != aVar.m2510a().getLetterSpacing() || !TextUtils.equals(this.f2914b.getFontFeatureSettings(), aVar.m2510a().getFontFeatureSettings()))) || this.f2914b.getFlags() != aVar.m2510a().getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.f2914b.getTextLocales().equals(aVar.m2510a().getTextLocales())) {
                    return false;
                }
            } else if (Build.VERSION.SDK_INT >= 17 && !this.f2914b.getTextLocale().equals(aVar.m2510a().getTextLocale())) {
                return false;
            }
            return this.f2914b.getTypeface() == null ? aVar.m2510a().getTypeface() == null : this.f2914b.getTypeface().equals(aVar.m2510a().getTypeface());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PlatformImplementations.kt_3)) {
                return false;
            }
            PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) obj;
            if (m2511a(aVar)) {
                return Build.VERSION.SDK_INT < 18 || this.f2915c == aVar.m2512b();
            }
            return false;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return ObjectsCompat.m2529a(Float.valueOf(this.f2914b.getTextSize()), Float.valueOf(this.f2914b.getTextScaleX()), Float.valueOf(this.f2914b.getTextSkewX()), Float.valueOf(this.f2914b.getLetterSpacing()), Integer.valueOf(this.f2914b.getFlags()), this.f2914b.getTextLocales(), this.f2914b.getTypeface(), Boolean.valueOf(this.f2914b.isElegantTextHeight()), this.f2915c, Integer.valueOf(this.f2916d), Integer.valueOf(this.f2917e));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                return ObjectsCompat.m2529a(Float.valueOf(this.f2914b.getTextSize()), Float.valueOf(this.f2914b.getTextScaleX()), Float.valueOf(this.f2914b.getTextSkewX()), Float.valueOf(this.f2914b.getLetterSpacing()), Integer.valueOf(this.f2914b.getFlags()), this.f2914b.getTextLocale(), this.f2914b.getTypeface(), Boolean.valueOf(this.f2914b.isElegantTextHeight()), this.f2915c, Integer.valueOf(this.f2916d), Integer.valueOf(this.f2917e));
            }
            if (Build.VERSION.SDK_INT >= 18) {
                return ObjectsCompat.m2529a(Float.valueOf(this.f2914b.getTextSize()), Float.valueOf(this.f2914b.getTextScaleX()), Float.valueOf(this.f2914b.getTextSkewX()), Integer.valueOf(this.f2914b.getFlags()), this.f2914b.getTextLocale(), this.f2914b.getTypeface(), this.f2915c, Integer.valueOf(this.f2916d), Integer.valueOf(this.f2917e));
            }
            if (Build.VERSION.SDK_INT >= 17) {
                return ObjectsCompat.m2529a(Float.valueOf(this.f2914b.getTextSize()), Float.valueOf(this.f2914b.getTextScaleX()), Float.valueOf(this.f2914b.getTextSkewX()), Integer.valueOf(this.f2914b.getFlags()), this.f2914b.getTextLocale(), this.f2914b.getTypeface(), this.f2915c, Integer.valueOf(this.f2916d), Integer.valueOf(this.f2917e));
            }
            return ObjectsCompat.m2529a(Float.valueOf(this.f2914b.getTextSize()), Float.valueOf(this.f2914b.getTextScaleX()), Float.valueOf(this.f2914b.getTextSkewX()), Integer.valueOf(this.f2914b.getFlags()), this.f2914b.getTypeface(), this.f2915c, Integer.valueOf(this.f2916d), Integer.valueOf(this.f2917e));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f2914b.getTextSize());
            sb.append(", textScaleX=" + this.f2914b.getTextScaleX());
            sb.append(", textSkewX=" + this.f2914b.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f2914b.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f2914b.isElegantTextHeight());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                sb.append(", textLocale=" + this.f2914b.getTextLocales());
            } else if (Build.VERSION.SDK_INT >= 17) {
                sb.append(", textLocale=" + this.f2914b.getTextLocale());
            }
            sb.append(", typeface=" + this.f2914b.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f2914b.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f2915c);
            sb.append(", breakStrategy=" + this.f2916d);
            sb.append(", hyphenationFrequency=" + this.f2917e);
            sb.append("}");
            return sb.toString();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public PrecomputedText m2508a() {
        Spannable spannable = this.f2910c;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public PlatformImplementations.kt_3 m2509b() {
        return this.f2911d;
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int OplusGLSurfaceView_13, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2912e.setSpan(obj, OplusGLSurfaceView_13, i2, i3);
        } else {
            this.f2910c.setSpan(obj, OplusGLSurfaceView_13, i2, i3);
        }
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2912e.removeSpan(obj);
        } else {
            this.f2910c.removeSpan(obj);
        }
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int OplusGLSurfaceView_13, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return (T[]) this.f2912e.getSpans(OplusGLSurfaceView_13, i2, cls);
        }
        return (T[]) this.f2910c.getSpans(OplusGLSurfaceView_13, i2, cls);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f2910c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f2910c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f2910c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int OplusGLSurfaceView_13, int i2, Class cls) {
        return this.f2910c.nextSpanTransition(OplusGLSurfaceView_13, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f2910c.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int OplusGLSurfaceView_13) {
        return this.f2910c.charAt(OplusGLSurfaceView_13);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int OplusGLSurfaceView_13, int i2) {
        return this.f2910c.subSequence(OplusGLSurfaceView_13, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f2910c.toString();
    }
}
