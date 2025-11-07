package androidx.core.f_renamed;

/* compiled from: PrecomputedTextCompat.java */
/* loaded from: classes.dex */
public class c_renamed implements android.text.Spannable {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Object f897a = new java.lang.Object();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.util.concurrent.Executor f898b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.text.Spannable f899c;
    private final androidx.core.f_renamed.c_renamed.a_renamed d_renamed;
    private final android.text.PrecomputedText e_renamed;

    /* compiled from: PrecomputedTextCompat.java */
    public static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final android.text.PrecomputedText.Params f900a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.text.TextPaint f901b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final android.text.TextDirectionHeuristic f902c;
        private final int d_renamed;
        private final int e_renamed;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: androidx.core.f_renamed.c_renamed$a_renamed$a_renamed, reason: collision with other inner class name */
        public static class PrecomputedTextCompat_3 {

            /* renamed from: a_renamed, reason: collision with root package name */
            private final android.text.TextPaint f903a;

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.text.TextDirectionHeuristic f904b;

            /* renamed from: c_renamed, reason: collision with root package name */
            private int f905c;
            private int d_renamed;

            public PrecomputedTextCompat_3(android.text.TextPaint textPaint) {
                this.f903a = textPaint;
                if (android.os.Build.VERSION.SDK_INT >= 23) {
                    this.f905c = 1;
                    this.d_renamed = 1;
                } else {
                    this.d_renamed = 0;
                    this.f905c = 0;
                }
                if (android.os.Build.VERSION.SDK_INT >= 18) {
                    this.f904b = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f904b = null;
                }
            }

            public androidx.core.f_renamed.c_renamed.a_renamed.PrecomputedTextCompat_3 a_renamed(int i_renamed) {
                this.f905c = i_renamed;
                return this;
            }

            public androidx.core.f_renamed.c_renamed.a_renamed.PrecomputedTextCompat_3 b_renamed(int i_renamed) {
                this.d_renamed = i_renamed;
                return this;
            }

            public androidx.core.f_renamed.c_renamed.a_renamed.PrecomputedTextCompat_3 a_renamed(android.text.TextDirectionHeuristic textDirectionHeuristic) {
                this.f904b = textDirectionHeuristic;
                return this;
            }

            public androidx.core.f_renamed.c_renamed.a_renamed a_renamed() {
                return new androidx.core.f_renamed.c_renamed.a_renamed(this.f903a, this.f904b, this.f905c, this.d_renamed);
            }
        }

        @android.annotation.SuppressLint({"NewApi"})
        a_renamed(android.text.TextPaint textPaint, android.text.TextDirectionHeuristic textDirectionHeuristic, int i_renamed, int i2) {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                this.f900a = new android.text.PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i_renamed).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f900a = null;
            }
            this.f901b = textPaint;
            this.f902c = textDirectionHeuristic;
            this.d_renamed = i_renamed;
            this.e_renamed = i2;
        }

        public a_renamed(android.text.PrecomputedText.Params params) {
            this.f901b = params.getTextPaint();
            this.f902c = params.getTextDirection();
            this.d_renamed = params.getBreakStrategy();
            this.e_renamed = params.getHyphenationFrequency();
            this.f900a = android.os.Build.VERSION.SDK_INT < 29 ? null : params;
        }

        public android.text.TextPaint a_renamed() {
            return this.f901b;
        }

        public android.text.TextDirectionHeuristic b_renamed() {
            return this.f902c;
        }

        public int c_renamed() {
            return this.d_renamed;
        }

        public int d_renamed() {
            return this.e_renamed;
        }

        public boolean a_renamed(androidx.core.f_renamed.c_renamed.a_renamed aVar) {
            if ((android.os.Build.VERSION.SDK_INT >= 23 && (this.d_renamed != aVar.c_renamed() || this.e_renamed != aVar.d_renamed())) || this.f901b.getTextSize() != aVar.a_renamed().getTextSize() || this.f901b.getTextScaleX() != aVar.a_renamed().getTextScaleX() || this.f901b.getTextSkewX() != aVar.a_renamed().getTextSkewX()) {
                return false;
            }
            if ((android.os.Build.VERSION.SDK_INT >= 21 && (this.f901b.getLetterSpacing() != aVar.a_renamed().getLetterSpacing() || !android.text.TextUtils.equals(this.f901b.getFontFeatureSettings(), aVar.a_renamed().getFontFeatureSettings()))) || this.f901b.getFlags() != aVar.a_renamed().getFlags()) {
                return false;
            }
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                if (!this.f901b.getTextLocales().equals(aVar.a_renamed().getTextLocales())) {
                    return false;
                }
            } else if (android.os.Build.VERSION.SDK_INT >= 17 && !this.f901b.getTextLocale().equals(aVar.a_renamed().getTextLocale())) {
                return false;
            }
            return this.f901b.getTypeface() == null ? aVar.a_renamed().getTypeface() == null : this.f901b.getTypeface().equals(aVar.a_renamed().getTypeface());
        }

        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof androidx.core.f_renamed.c_renamed.a_renamed)) {
                return false;
            }
            androidx.core.f_renamed.c_renamed.a_renamed aVar = (androidx.core.f_renamed.c_renamed.a_renamed) obj;
            if (a_renamed(aVar)) {
                return android.os.Build.VERSION.SDK_INT < 18 || this.f902c == aVar.b_renamed();
            }
            return false;
        }

        public int hashCode() {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                return androidx.core.g_renamed.c_renamed.a_renamed(java.lang.Float.valueOf(this.f901b.getTextSize()), java.lang.Float.valueOf(this.f901b.getTextScaleX()), java.lang.Float.valueOf(this.f901b.getTextSkewX()), java.lang.Float.valueOf(this.f901b.getLetterSpacing()), java.lang.Integer.valueOf(this.f901b.getFlags()), this.f901b.getTextLocales(), this.f901b.getTypeface(), java.lang.Boolean.valueOf(this.f901b.isElegantTextHeight()), this.f902c, java.lang.Integer.valueOf(this.d_renamed), java.lang.Integer.valueOf(this.e_renamed));
            }
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                return androidx.core.g_renamed.c_renamed.a_renamed(java.lang.Float.valueOf(this.f901b.getTextSize()), java.lang.Float.valueOf(this.f901b.getTextScaleX()), java.lang.Float.valueOf(this.f901b.getTextSkewX()), java.lang.Float.valueOf(this.f901b.getLetterSpacing()), java.lang.Integer.valueOf(this.f901b.getFlags()), this.f901b.getTextLocale(), this.f901b.getTypeface(), java.lang.Boolean.valueOf(this.f901b.isElegantTextHeight()), this.f902c, java.lang.Integer.valueOf(this.d_renamed), java.lang.Integer.valueOf(this.e_renamed));
            }
            if (android.os.Build.VERSION.SDK_INT >= 18) {
                return androidx.core.g_renamed.c_renamed.a_renamed(java.lang.Float.valueOf(this.f901b.getTextSize()), java.lang.Float.valueOf(this.f901b.getTextScaleX()), java.lang.Float.valueOf(this.f901b.getTextSkewX()), java.lang.Integer.valueOf(this.f901b.getFlags()), this.f901b.getTextLocale(), this.f901b.getTypeface(), this.f902c, java.lang.Integer.valueOf(this.d_renamed), java.lang.Integer.valueOf(this.e_renamed));
            }
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                return androidx.core.g_renamed.c_renamed.a_renamed(java.lang.Float.valueOf(this.f901b.getTextSize()), java.lang.Float.valueOf(this.f901b.getTextScaleX()), java.lang.Float.valueOf(this.f901b.getTextSkewX()), java.lang.Integer.valueOf(this.f901b.getFlags()), this.f901b.getTextLocale(), this.f901b.getTypeface(), this.f902c, java.lang.Integer.valueOf(this.d_renamed), java.lang.Integer.valueOf(this.e_renamed));
            }
            return androidx.core.g_renamed.c_renamed.a_renamed(java.lang.Float.valueOf(this.f901b.getTextSize()), java.lang.Float.valueOf(this.f901b.getTextScaleX()), java.lang.Float.valueOf(this.f901b.getTextSkewX()), java.lang.Integer.valueOf(this.f901b.getFlags()), this.f901b.getTypeface(), this.f902c, java.lang.Integer.valueOf(this.d_renamed), java.lang.Integer.valueOf(this.e_renamed));
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("{");
            sb.append("textSize=" + this.f901b.getTextSize());
            sb.append(", textScaleX=" + this.f901b.getTextScaleX());
            sb.append(", textSkewX=" + this.f901b.getTextSkewX());
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f901b.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f901b.isElegantTextHeight());
            }
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                sb.append(", textLocale=" + this.f901b.getTextLocales());
            } else if (android.os.Build.VERSION.SDK_INT >= 17) {
                sb.append(", textLocale=" + this.f901b.getTextLocale());
            }
            sb.append(", typeface=" + this.f901b.getTypeface());
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f901b.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f902c);
            sb.append(", breakStrategy=" + this.d_renamed);
            sb.append(", hyphenationFrequency=" + this.e_renamed);
            sb.append("}");
            return sb.toString();
        }
    }

    public android.text.PrecomputedText a_renamed() {
        android.text.Spannable spannable = this.f899c;
        if (spannable instanceof android.text.PrecomputedText) {
            return (android.text.PrecomputedText) spannable;
        }
        return null;
    }

    public androidx.core.f_renamed.c_renamed.a_renamed b_renamed() {
        return this.d_renamed;
    }

    @Override // android.text.Spannable
    @android.annotation.SuppressLint({"NewApi"})
    public void setSpan(java.lang.Object obj, int i_renamed, int i2, int i3) {
        if (obj instanceof android.text.style.MetricAffectingSpan) {
            throw new java.lang.IllegalArgumentException("MetricAffectingSpan can not be_renamed set to PrecomputedText.");
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            this.e_renamed.setSpan(obj, i_renamed, i2, i3);
        } else {
            this.f899c.setSpan(obj, i_renamed, i2, i3);
        }
    }

    @Override // android.text.Spannable
    @android.annotation.SuppressLint({"NewApi"})
    public void removeSpan(java.lang.Object obj) {
        if (obj instanceof android.text.style.MetricAffectingSpan) {
            throw new java.lang.IllegalArgumentException("MetricAffectingSpan can not be_renamed removed from PrecomputedText.");
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            this.e_renamed.removeSpan(obj);
        } else {
            this.f899c.removeSpan(obj);
        }
    }

    @Override // android.text.Spanned
    @android.annotation.SuppressLint({"NewApi"})
    public <T_renamed> T_renamed[] getSpans(int i_renamed, int i2, java.lang.Class<T_renamed> cls) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return (T_renamed[]) this.e_renamed.getSpans(i_renamed, i2, cls);
        }
        return (T_renamed[]) this.f899c.getSpans(i_renamed, i2, cls);
    }

    @Override // android.text.Spanned
    public int getSpanStart(java.lang.Object obj) {
        return this.f899c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(java.lang.Object obj) {
        return this.f899c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(java.lang.Object obj) {
        return this.f899c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i_renamed, int i2, java.lang.Class cls) {
        return this.f899c.nextSpanTransition(i_renamed, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f899c.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i_renamed) {
        return this.f899c.charAt(i_renamed);
    }

    @Override // java.lang.CharSequence
    public java.lang.CharSequence subSequence(int i_renamed, int i2) {
        return this.f899c.subSequence(i_renamed, i2);
    }

    @Override // java.lang.CharSequence
    public java.lang.String toString() {
        return this.f899c.toString();
    }
}
