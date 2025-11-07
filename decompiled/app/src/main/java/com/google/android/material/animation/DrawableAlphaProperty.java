package com.google.android.material.animation;

/* loaded from: classes.dex */
public class DrawableAlphaProperty extends android.util.Property<android.graphics.drawable.Drawable, java.lang.Integer> {
    public static final android.util.Property<android.graphics.drawable.Drawable, java.lang.Integer> DRAWABLE_ALPHA_COMPAT = new com.google.android.material.animation.DrawableAlphaProperty();
    private final java.util.WeakHashMap<android.graphics.drawable.Drawable, java.lang.Integer> alphaCache;

    private DrawableAlphaProperty() {
        super(java.lang.Integer.class, "drawableAlphaCompat");
        this.alphaCache = new java.util.WeakHashMap<>();
    }

    @Override // android.util.Property
    public java.lang.Integer get(android.graphics.drawable.Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return java.lang.Integer.valueOf(drawable.getAlpha());
        }
        if (this.alphaCache.containsKey(drawable)) {
            return this.alphaCache.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    public void set(android.graphics.drawable.Drawable drawable, java.lang.Integer num) {
        if (android.os.Build.VERSION.SDK_INT < 19) {
            this.alphaCache.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
