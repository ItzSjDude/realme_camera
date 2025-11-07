package com.google.android.material.internal;

/* loaded from: classes.dex */
final class StaticLayoutBuilderCompat {
    private static final java.lang.String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final java.lang.String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final java.lang.String TEXT_DIR_CLASS_LTR = "LTR";
    private static final java.lang.String TEXT_DIR_CLASS_RTL = "RTL";
    private static java.lang.reflect.Constructor<android.text.StaticLayout> constructor;
    private static boolean initialized;
    private static java.lang.Object textDirection;
    private int end;
    private boolean isRtl;
    private final android.text.TextPaint paint;
    private java.lang.CharSequence source;
    private final int width;
    private int start = 0;
    private android.text.Layout.Alignment alignment = android.text.Layout.Alignment.ALIGN_NORMAL;
    private int maxLines = Integer.MAX_VALUE;
    private boolean includePad = true;
    private android.text.TextUtils.TruncateAt ellipsize = null;

    private StaticLayoutBuilderCompat(java.lang.CharSequence charSequence, android.text.TextPaint textPaint, int i_renamed) {
        this.source = charSequence;
        this.paint = textPaint;
        this.width = i_renamed;
        this.end = charSequence.length();
    }

    public static com.google.android.material.internal.StaticLayoutBuilderCompat obtain(java.lang.CharSequence charSequence, android.text.TextPaint textPaint, int i_renamed) {
        return new com.google.android.material.internal.StaticLayoutBuilderCompat(charSequence, textPaint, i_renamed);
    }

    public com.google.android.material.internal.StaticLayoutBuilderCompat setAlignment(android.text.Layout.Alignment alignment) {
        this.alignment = alignment;
        return this;
    }

    public com.google.android.material.internal.StaticLayoutBuilderCompat setIncludePad(boolean z_renamed) {
        this.includePad = z_renamed;
        return this;
    }

    public com.google.android.material.internal.StaticLayoutBuilderCompat setStart(int i_renamed) {
        this.start = i_renamed;
        return this;
    }

    public com.google.android.material.internal.StaticLayoutBuilderCompat setEnd(int i_renamed) {
        this.end = i_renamed;
        return this;
    }

    public com.google.android.material.internal.StaticLayoutBuilderCompat setMaxLines(int i_renamed) {
        this.maxLines = i_renamed;
        return this;
    }

    public com.google.android.material.internal.StaticLayoutBuilderCompat setEllipsize(android.text.TextUtils.TruncateAt truncateAt) {
        this.ellipsize = truncateAt;
        return this;
    }

    public android.text.StaticLayout build() throws java.lang.ClassNotFoundException, com.google.android.material.internal.StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException {
        if (this.source == null) {
            this.source = "";
        }
        int iMax = java.lang.Math.max(0, this.width);
        java.lang.CharSequence charSequenceEllipsize = this.source;
        if (this.maxLines == 1) {
            charSequenceEllipsize = android.text.TextUtils.ellipsize(charSequenceEllipsize, this.paint, iMax, this.ellipsize);
        }
        this.end = java.lang.Math.min(charSequenceEllipsize.length(), this.end);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (this.isRtl) {
                this.alignment = android.text.Layout.Alignment.ALIGN_OPPOSITE;
            }
            android.text.StaticLayout.Builder builderObtain = android.text.StaticLayout.Builder.obtain(charSequenceEllipsize, this.start, this.end, this.paint, iMax);
            builderObtain.setAlignment(this.alignment);
            builderObtain.setIncludePad(this.includePad);
            builderObtain.setTextDirection(this.isRtl ? android.text.TextDirectionHeuristics.RTL : android.text.TextDirectionHeuristics.LTR);
            android.text.TextUtils.TruncateAt truncateAt = this.ellipsize;
            if (truncateAt != null) {
                builderObtain.setEllipsize(truncateAt);
            }
            builderObtain.setMaxLines(this.maxLines);
            return builderObtain.build();
        }
        createConstructorWithReflection();
        try {
            return (android.text.StaticLayout) ((java.lang.reflect.Constructor) androidx.core.g_renamed.f_renamed.a_renamed(constructor)).newInstance(charSequenceEllipsize, java.lang.Integer.valueOf(this.start), java.lang.Integer.valueOf(this.end), this.paint, java.lang.Integer.valueOf(iMax), this.alignment, androidx.core.g_renamed.f_renamed.a_renamed(textDirection), java.lang.Float.valueOf(1.0f), java.lang.Float.valueOf(0.0f), java.lang.Boolean.valueOf(this.includePad), null, java.lang.Integer.valueOf(iMax), java.lang.Integer.valueOf(this.maxLines));
        } catch (java.lang.Exception e_renamed) {
            throw new com.google.android.material.internal.StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException(e_renamed);
        }
    }

    private void createConstructorWithReflection() throws java.lang.ClassNotFoundException, com.google.android.material.internal.StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException {
        java.lang.Class<?> cls;
        if (initialized) {
            return;
        }
        try {
            boolean z_renamed = this.isRtl && android.os.Build.VERSION.SDK_INT >= 23;
            if (android.os.Build.VERSION.SDK_INT >= 18) {
                cls = android.text.TextDirectionHeuristic.class;
                textDirection = z_renamed ? android.text.TextDirectionHeuristics.RTL : android.text.TextDirectionHeuristics.LTR;
            } else {
                java.lang.ClassLoader classLoader = com.google.android.material.internal.StaticLayoutBuilderCompat.class.getClassLoader();
                java.lang.String str = this.isRtl ? TEXT_DIR_CLASS_RTL : TEXT_DIR_CLASS_LTR;
                java.lang.Class<?> clsLoadClass = classLoader.loadClass(TEXT_DIR_CLASS);
                java.lang.Class<?> clsLoadClass2 = classLoader.loadClass(TEXT_DIRS_CLASS);
                textDirection = clsLoadClass2.getField(str).get(clsLoadClass2);
                cls = clsLoadClass;
            }
            constructor = android.text.StaticLayout.class.getDeclaredConstructor(java.lang.CharSequence.class, java.lang.Integer.TYPE, java.lang.Integer.TYPE, android.text.TextPaint.class, java.lang.Integer.TYPE, android.text.Layout.Alignment.class, cls, java.lang.Float.TYPE, java.lang.Float.TYPE, java.lang.Boolean.TYPE, android.text.TextUtils.TruncateAt.class, java.lang.Integer.TYPE, java.lang.Integer.TYPE);
            constructor.setAccessible(true);
            initialized = true;
        } catch (java.lang.Exception e_renamed) {
            throw new com.google.android.material.internal.StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException(e_renamed);
        }
    }

    public com.google.android.material.internal.StaticLayoutBuilderCompat setIsRtl(boolean z_renamed) {
        this.isRtl = z_renamed;
        return this;
    }

    static class StaticLayoutBuilderCompatException extends java.lang.Exception {
        StaticLayoutBuilderCompatException(java.lang.Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }
}
