package com.google.android.material.shape;

/* loaded from: classes.dex */
public final class AdjustedCornerSize implements com.google.android.material.shape.CornerSize {
    private final float adjustment;
    private final com.google.android.material.shape.CornerSize other;

    public AdjustedCornerSize(float f_renamed, com.google.android.material.shape.CornerSize cornerSize) {
        while (cornerSize instanceof com.google.android.material.shape.AdjustedCornerSize) {
            cornerSize = ((com.google.android.material.shape.AdjustedCornerSize) cornerSize).other;
            f_renamed += ((com.google.android.material.shape.AdjustedCornerSize) cornerSize).adjustment;
        }
        this.other = cornerSize;
        this.adjustment = f_renamed;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(android.graphics.RectF rectF) {
        return java.lang.Math.max(0.0f, this.other.getCornerSize(rectF) + this.adjustment);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.android.material.shape.AdjustedCornerSize)) {
            return false;
        }
        com.google.android.material.shape.AdjustedCornerSize adjustedCornerSize = (com.google.android.material.shape.AdjustedCornerSize) obj;
        return this.other.equals(adjustedCornerSize.other) && this.adjustment == adjustedCornerSize.adjustment;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{this.other, java.lang.Float.valueOf(this.adjustment)});
    }
}
