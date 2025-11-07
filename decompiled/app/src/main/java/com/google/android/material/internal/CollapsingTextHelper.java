package com.google.android.material.internal;

/* loaded from: classes.dex */
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final android.graphics.Paint DEBUG_DRAW_PAINT;
    private static final java.lang.String ELLIPSIS_NORMAL = "…";
    private static final java.lang.String TAG = "CollapsingTextHelper";
    private static final boolean USE_SCALING_TEXTURE;
    private boolean boundsChanged;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private com.google.android.material.resources.CancelableFontCallback collapsedFontCallback;
    private android.content.res.ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private float collapsedTextBlend;
    private android.content.res.ColorStateList collapsedTextColor;
    private android.graphics.Typeface collapsedTypeface;
    private float currentDrawX;
    private float currentDrawY;
    private float currentTextSize;
    private android.graphics.Typeface currentTypeface;
    private boolean drawTitle;
    private float expandedDrawX;
    private float expandedDrawY;
    private float expandedFirstLineDrawX;
    private com.google.android.material.resources.CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private android.content.res.ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private android.content.res.ColorStateList expandedTextColor;
    private android.graphics.Bitmap expandedTitleTexture;
    private android.graphics.Typeface expandedTypeface;
    private boolean isRtl;
    private android.animation.TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;
    private java.lang.CharSequence text;
    private android.text.StaticLayout textLayout;
    private android.animation.TimeInterpolator textSizeInterpolator;
    private java.lang.CharSequence textToDraw;
    private java.lang.CharSequence textToDrawCollapsed;
    private android.graphics.Paint texturePaint;
    private boolean useTexture;
    private final android.view.View view;
    private int expandedTextGravity = 16;
    private int collapsedTextGravity = 16;
    private float expandedTextSize = 15.0f;
    private float collapsedTextSize = 15.0f;
    private int maxLines = 1;
    private final android.text.TextPaint textPaint = new android.text.TextPaint(129);
    private final android.text.TextPaint tmpPaint = new android.text.TextPaint(this.textPaint);
    private final android.graphics.Rect collapsedBounds = new android.graphics.Rect();
    private final android.graphics.Rect expandedBounds = new android.graphics.Rect();
    private final android.graphics.RectF currentBounds = new android.graphics.RectF();

    static {
        USE_SCALING_TEXTURE = android.os.Build.VERSION.SDK_INT < 18;
        DEBUG_DRAW_PAINT = null;
        android.graphics.Paint paint = DEBUG_DRAW_PAINT;
        if (paint != null) {
            paint.setAntiAlias(true);
            DEBUG_DRAW_PAINT.setColor(-65281);
        }
    }

    public CollapsingTextHelper(android.view.View view) {
        this.view = view;
    }

    public void setTextSizeInterpolator(android.animation.TimeInterpolator timeInterpolator) {
        this.textSizeInterpolator = timeInterpolator;
        recalculate();
    }

    public void setPositionInterpolator(android.animation.TimeInterpolator timeInterpolator) {
        this.positionInterpolator = timeInterpolator;
        recalculate();
    }

    public void setExpandedTextSize(float f_renamed) {
        if (this.expandedTextSize != f_renamed) {
            this.expandedTextSize = f_renamed;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f_renamed) {
        if (this.collapsedTextSize != f_renamed) {
            this.collapsedTextSize = f_renamed;
            recalculate();
        }
    }

    public void setCollapsedTextColor(android.content.res.ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextColor(android.content.res.ColorStateList colorStateList) {
        if (this.expandedTextColor != colorStateList) {
            this.expandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedBounds(int i_renamed, int i2, int i3, int i4) {
        if (rectEquals(this.expandedBounds, i_renamed, i2, i3, i4)) {
            return;
        }
        this.expandedBounds.set(i_renamed, i2, i3, i4);
        this.boundsChanged = true;
        onBoundsChanged();
    }

    public void setExpandedBounds(android.graphics.Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setCollapsedBounds(int i_renamed, int i2, int i3, int i4) {
        if (rectEquals(this.collapsedBounds, i_renamed, i2, i3, i4)) {
            return;
        }
        this.collapsedBounds.set(i_renamed, i2, i3, i4);
        this.boundsChanged = true;
        onBoundsChanged();
    }

    public void setCollapsedBounds(android.graphics.Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void getCollapsedTextActualBounds(android.graphics.RectF rectF, int i_renamed, int i2) {
        this.isRtl = calculateIsRtl(this.text);
        rectF.left = getCollapsedTextLeftBound(i_renamed, i2);
        rectF.top = this.collapsedBounds.top;
        rectF.right = getCollapsedTextRightBound(rectF, i_renamed, i2);
        rectF.bottom = this.collapsedBounds.top + getCollapsedTextHeight();
    }

    private float getCollapsedTextLeftBound(int i_renamed, int i2) {
        if (i2 == 17 || (i2 & 7) == 1) {
            return (i_renamed / 2.0f) - (calculateCollapsedTextWidth() / 2.0f);
        }
        return ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) ? this.isRtl ? this.collapsedBounds.left : this.collapsedBounds.right - calculateCollapsedTextWidth() : this.isRtl ? this.collapsedBounds.right - calculateCollapsedTextWidth() : this.collapsedBounds.left;
    }

    private float getCollapsedTextRightBound(android.graphics.RectF rectF, int i_renamed, int i2) {
        if (i2 == 17 || (i2 & 7) == 1) {
            return (i_renamed / 2.0f) + (calculateCollapsedTextWidth() / 2.0f);
        }
        if ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) {
            return this.isRtl ? rectF.left + calculateCollapsedTextWidth() : this.collapsedBounds.right;
        }
        if (this.isRtl) {
            return this.collapsedBounds.right;
        }
        return calculateCollapsedTextWidth() + rectF.left;
    }

    public float calculateCollapsedTextWidth() {
        if (this.text == null) {
            return 0.0f;
        }
        getTextPaintCollapsed(this.tmpPaint);
        android.text.TextPaint textPaint = this.tmpPaint;
        java.lang.CharSequence charSequence = this.text;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public float getExpandedTextHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    private void getTextPaintExpanded(android.text.TextPaint textPaint) {
        textPaint.setTextSize(this.expandedTextSize);
        textPaint.setTypeface(this.expandedTypeface);
    }

    private void getTextPaintCollapsed(android.text.TextPaint textPaint) {
        textPaint.setTextSize(this.collapsedTextSize);
        textPaint.setTypeface(this.collapsedTypeface);
    }

    void onBoundsChanged() {
        this.drawTitle = this.collapsedBounds.width() > 0 && this.collapsedBounds.height() > 0 && this.expandedBounds.width() > 0 && this.expandedBounds.height() > 0;
    }

    public void setExpandedTextGravity(int i_renamed) {
        if (this.expandedTextGravity != i_renamed) {
            this.expandedTextGravity = i_renamed;
            recalculate();
        }
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public void setCollapsedTextGravity(int i_renamed) {
        if (this.collapsedTextGravity != i_renamed) {
            this.collapsedTextGravity = i_renamed;
            recalculate();
        }
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public void setCollapsedTextAppearance(int i_renamed) {
        com.google.android.material.resources.TextAppearance textAppearance = new com.google.android.material.resources.TextAppearance(this.view.getContext(), i_renamed);
        if (textAppearance.textColor != null) {
            this.collapsedTextColor = textAppearance.textColor;
        }
        if (textAppearance.textSize != 0.0f) {
            this.collapsedTextSize = textAppearance.textSize;
        }
        if (textAppearance.shadowColor != null) {
            this.collapsedShadowColor = textAppearance.shadowColor;
        }
        this.collapsedShadowDx = textAppearance.shadowDx;
        this.collapsedShadowDy = textAppearance.shadowDy;
        this.collapsedShadowRadius = textAppearance.shadowRadius;
        com.google.android.material.resources.CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.collapsedFontCallback = new com.google.android.material.resources.CancelableFontCallback(new com.google.android.material.resources.CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.1
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void apply(android.graphics.Typeface typeface) {
                com.google.android.material.internal.CollapsingTextHelper.this.setCollapsedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setExpandedTextAppearance(int i_renamed) {
        com.google.android.material.resources.TextAppearance textAppearance = new com.google.android.material.resources.TextAppearance(this.view.getContext(), i_renamed);
        if (textAppearance.textColor != null) {
            this.expandedTextColor = textAppearance.textColor;
        }
        if (textAppearance.textSize != 0.0f) {
            this.expandedTextSize = textAppearance.textSize;
        }
        if (textAppearance.shadowColor != null) {
            this.expandedShadowColor = textAppearance.shadowColor;
        }
        this.expandedShadowDx = textAppearance.shadowDx;
        this.expandedShadowDy = textAppearance.shadowDy;
        this.expandedShadowRadius = textAppearance.shadowRadius;
        com.google.android.material.resources.CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.expandedFontCallback = new com.google.android.material.resources.CancelableFontCallback(new com.google.android.material.resources.CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.2
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void apply(android.graphics.Typeface typeface) {
                com.google.android.material.internal.CollapsingTextHelper.this.setExpandedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setCollapsedTypeface(android.graphics.Typeface typeface) {
        if (setCollapsedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpandedTypeface(android.graphics.Typeface typeface) {
        if (setExpandedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setTypefaces(android.graphics.Typeface typeface) {
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        boolean expandedTypefaceInternal = setExpandedTypefaceInternal(typeface);
        if (collapsedTypefaceInternal || expandedTypefaceInternal) {
            recalculate();
        }
    }

    private boolean setCollapsedTypefaceInternal(android.graphics.Typeface typeface) {
        com.google.android.material.resources.CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.collapsedTypeface == typeface) {
            return false;
        }
        this.collapsedTypeface = typeface;
        return true;
    }

    private boolean setExpandedTypefaceInternal(android.graphics.Typeface typeface) {
        com.google.android.material.resources.CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.expandedTypeface == typeface) {
            return false;
        }
        this.expandedTypeface = typeface;
        return true;
    }

    public android.graphics.Typeface getCollapsedTypeface() {
        android.graphics.Typeface typeface = this.collapsedTypeface;
        return typeface != null ? typeface : android.graphics.Typeface.DEFAULT;
    }

    public android.graphics.Typeface getExpandedTypeface() {
        android.graphics.Typeface typeface = this.expandedTypeface;
        return typeface != null ? typeface : android.graphics.Typeface.DEFAULT;
    }

    public void setExpansionFraction(float f_renamed) {
        float fA_renamed = androidx.core.c_renamed.a_renamed.a_renamed(f_renamed, 0.0f, 1.0f);
        if (fA_renamed != this.expandedFraction) {
            this.expandedFraction = fA_renamed;
            calculateCurrentOffsets();
        }
    }

    public final boolean setState(int[] iArr) {
        this.state = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    public final boolean isStateful() {
        android.content.res.ColorStateList colorStateList;
        android.content.res.ColorStateList colorStateList2 = this.collapsedTextColor;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.expandedTextColor) != null && colorStateList.isStateful());
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private void calculateOffsets(float f_renamed) {
        interpolateBounds(f_renamed);
        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f_renamed, this.positionInterpolator);
        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f_renamed, this.positionInterpolator);
        setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f_renamed, this.textSizeInterpolator));
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - f_renamed, com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        setExpandedTextBlend(lerp(1.0f, 0.0f, f_renamed, com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if (this.collapsedTextColor != this.expandedTextColor) {
            this.textPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f_renamed));
        } else {
            this.textPaint.setColor(getCurrentCollapsedTextColor());
        }
        this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f_renamed, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f_renamed, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f_renamed, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f_renamed));
        androidx.core.h_renamed.v_renamed.e_renamed(this.view);
    }

    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    private int getCurrentColor(android.content.res.ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private void calculateBaseOffsets() {
        float fCenterY;
        float fCenterY2;
        android.text.StaticLayout staticLayout;
        float f_renamed = this.currentTextSize;
        calculateUsingTextSize(this.collapsedTextSize);
        java.lang.CharSequence charSequence = this.textToDraw;
        if (charSequence != null && (staticLayout = this.textLayout) != null) {
            this.textToDrawCollapsed = android.text.TextUtils.ellipsize(charSequence, this.textPaint, staticLayout.getWidth(), android.text.TextUtils.TruncateAt.END);
        }
        java.lang.CharSequence charSequence2 = this.textToDrawCollapsed;
        float fMeasureText = charSequence2 != null ? this.textPaint.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int iA = androidx.core.h_renamed.c_renamed.a_renamed(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        float height = this.textLayout != null ? r5.getHeight() : 0.0f;
        int i_renamed = iA & 112;
        if (i_renamed == 48) {
            this.collapsedDrawY = this.collapsedBounds.top - this.textPaint.ascent();
        } else if (i_renamed == 80) {
            this.collapsedDrawY = this.collapsedBounds.bottom;
        } else {
            float fDescent = (this.textPaint.descent() - this.textPaint.ascent()) / 2.0f;
            float fDescent2 = fDescent - this.textPaint.descent();
            if (shouldDrawMultiline()) {
                fCenterY2 = this.collapsedBounds.centerY() - fDescent;
            } else {
                fCenterY2 = fDescent2 + this.collapsedBounds.centerY();
            }
            this.collapsedDrawY = fCenterY2;
        }
        int i2 = iA & 8388615;
        if (i2 == 1) {
            this.collapsedDrawX = this.collapsedBounds.centerX() - (fMeasureText / 2.0f);
        } else if (i2 == 5) {
            this.collapsedDrawX = this.collapsedBounds.right - fMeasureText;
        } else {
            this.collapsedDrawX = this.collapsedBounds.left;
        }
        calculateUsingTextSize(this.expandedTextSize);
        java.lang.CharSequence charSequence3 = this.textToDraw;
        float fMeasureText2 = charSequence3 != null ? this.textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        android.text.StaticLayout staticLayout2 = this.textLayout;
        if (staticLayout2 != null && this.maxLines > 1 && !this.isRtl) {
            fMeasureText2 = staticLayout2.getLineWidth(0);
        }
        android.text.StaticLayout staticLayout3 = this.textLayout;
        this.expandedFirstLineDrawX = staticLayout3 != null ? staticLayout3.getLineLeft(0) : 0.0f;
        int iA2 = androidx.core.h_renamed.c_renamed.a_renamed(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int i3 = iA2 & 112;
        if (i3 == 48) {
            this.expandedDrawY = this.expandedBounds.top - this.textPaint.ascent();
        } else if (i3 == 80) {
            this.expandedDrawY = this.expandedBounds.bottom - (shouldDrawMultiline() ? height - this.textPaint.descent() : 0.0f);
        } else {
            float fDescent3 = ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f) - this.textPaint.descent();
            if (shouldDrawMultiline()) {
                fCenterY = this.expandedBounds.centerY() - (height / 2.0f);
            } else {
                fCenterY = fDescent3 + this.expandedBounds.centerY();
            }
            this.expandedDrawY = fCenterY;
        }
        int i4 = iA2 & 8388615;
        if (i4 == 1) {
            this.expandedDrawX = this.expandedBounds.centerX() - (fMeasureText2 / 2.0f);
        } else if (i4 == 5) {
            this.expandedDrawX = this.expandedBounds.right - fMeasureText2;
        } else {
            this.expandedDrawX = this.expandedBounds.left;
        }
        clearTexture();
        setInterpolatedTextSize(f_renamed);
    }

    private void interpolateBounds(float f_renamed) {
        this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, f_renamed, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f_renamed, this.positionInterpolator);
        this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, f_renamed, this.positionInterpolator);
        this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, f_renamed, this.positionInterpolator);
    }

    private void setCollapsedTextBlend(float f_renamed) {
        this.collapsedTextBlend = f_renamed;
        androidx.core.h_renamed.v_renamed.e_renamed(this.view);
    }

    private void setExpandedTextBlend(float f_renamed) {
        this.expandedTextBlend = f_renamed;
        androidx.core.h_renamed.v_renamed.e_renamed(this.view);
    }

    public void draw(android.graphics.Canvas canvas) {
        int iSave = canvas.save();
        if (this.textToDraw == null || !this.drawTitle) {
            return;
        }
        float lineLeft = (this.currentDrawX + this.textLayout.getLineLeft(0)) - (this.expandedFirstLineDrawX * 2.0f);
        this.textPaint.setTextSize(this.currentTextSize);
        float f_renamed = this.currentDrawX;
        float f2 = this.currentDrawY;
        boolean z_renamed = this.useTexture && this.expandedTitleTexture != null;
        float lineAscent = this.textLayout.getLineAscent(0);
        float f3 = this.scale;
        if (f3 != 1.0f) {
            canvas.scale(f3, f3, f_renamed, f2);
        }
        if (z_renamed) {
            canvas.drawBitmap(this.expandedTitleTexture, f_renamed, f2 + lineAscent, this.texturePaint);
            canvas.restoreToCount(iSave);
            return;
        }
        if (shouldDrawMultiline()) {
            drawMultinlineTransition(canvas, lineLeft, f_renamed, f2, lineAscent);
        } else {
            canvas.translate(f_renamed, f2 + lineAscent);
            this.textLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    private boolean shouldDrawMultiline() {
        return (this.maxLines <= 1 || this.isRtl || this.useTexture) ? false : true;
    }

    private void drawMultinlineTransition(android.graphics.Canvas canvas, float f_renamed, float f2, float f3, float f4) {
        int alpha = this.textPaint.getAlpha();
        canvas.translate(f_renamed, f3);
        float f5 = alpha;
        this.textPaint.setAlpha((int) (this.expandedTextBlend * f5));
        this.textLayout.draw(canvas);
        canvas.translate(f2 - f_renamed, 0.0f);
        this.textPaint.setAlpha((int) (this.collapsedTextBlend * f5));
        java.lang.CharSequence charSequence = this.textToDrawCollapsed;
        float f6 = -f4;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f6 / this.scale, this.textPaint);
        java.lang.String strTrim = this.textToDrawCollapsed.toString().trim();
        if (strTrim.endsWith(ELLIPSIS_NORMAL)) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        java.lang.String str = strTrim;
        this.textPaint.setAlpha(alpha);
        canvas.drawText(str, 0, java.lang.Math.min(this.textLayout.getLineEnd(0), str.length()), 0.0f, f6 / this.scale, (android.graphics.Paint) this.textPaint);
    }

    private boolean calculateIsRtl(java.lang.CharSequence charSequence) {
        return (isDefaultIsRtl() ? androidx.core.f_renamed.e_renamed.d_renamed : androidx.core.f_renamed.e_renamed.f908c).a_renamed(charSequence, 0, charSequence.length());
    }

    private boolean isDefaultIsRtl() {
        return androidx.core.h_renamed.v_renamed.g_renamed(this.view) == 1;
    }

    private void setInterpolatedTextSize(float f_renamed) {
        calculateUsingTextSize(f_renamed);
        this.useTexture = USE_SCALING_TEXTURE && this.scale != 1.0f;
        if (this.useTexture) {
            ensureExpandedTexture();
        }
        androidx.core.h_renamed.v_renamed.e_renamed(this.view);
    }

    private void calculateUsingTextSize(float f_renamed) {
        boolean z_renamed;
        float f2;
        boolean z2;
        if (this.text == null) {
            return;
        }
        float fWidth = this.collapsedBounds.width();
        float fWidth2 = this.expandedBounds.width();
        if (isClose(f_renamed, this.collapsedTextSize)) {
            f2 = this.collapsedTextSize;
            this.scale = 1.0f;
            android.graphics.Typeface typeface = this.currentTypeface;
            android.graphics.Typeface typeface2 = this.collapsedTypeface;
            if (typeface != typeface2) {
                this.currentTypeface = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            float f3 = this.expandedTextSize;
            android.graphics.Typeface typeface3 = this.currentTypeface;
            android.graphics.Typeface typeface4 = this.expandedTypeface;
            if (typeface3 != typeface4) {
                this.currentTypeface = typeface4;
                z_renamed = true;
            } else {
                z_renamed = false;
            }
            if (isClose(f_renamed, this.expandedTextSize)) {
                this.scale = 1.0f;
            } else {
                this.scale = f_renamed / this.expandedTextSize;
            }
            float f4 = this.collapsedTextSize / this.expandedTextSize;
            fWidth = fWidth2 * f4 > fWidth ? java.lang.Math.min(fWidth / f4, fWidth2) : fWidth2;
            f2 = f3;
            z2 = z_renamed;
        }
        if (fWidth > 0.0f) {
            z2 = this.currentTextSize != f2 || this.boundsChanged || z2;
            this.currentTextSize = f2;
            this.boundsChanged = false;
        }
        if (this.textToDraw == null || z2) {
            this.textPaint.setTextSize(this.currentTextSize);
            this.textPaint.setTypeface(this.currentTypeface);
            this.textPaint.setLinearText(this.scale != 1.0f);
            this.isRtl = calculateIsRtl(this.text);
            this.textLayout = createStaticLayout(shouldDrawMultiline() ? this.maxLines : 1, fWidth, this.isRtl);
            this.textToDraw = this.textLayout.getText();
        }
    }

    private android.text.StaticLayout createStaticLayout(int i_renamed, float f_renamed, boolean z_renamed) throws java.lang.ClassNotFoundException {
        android.text.StaticLayout staticLayoutBuild;
        try {
            staticLayoutBuild = com.google.android.material.internal.StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) f_renamed).setEllipsize(android.text.TextUtils.TruncateAt.END).setIsRtl(z_renamed).setAlignment(android.text.Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(i_renamed).build();
        } catch (com.google.android.material.internal.StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.getCause().getMessage(), e_renamed);
            staticLayoutBuild = null;
        }
        return (android.text.StaticLayout) androidx.core.g_renamed.f_renamed.a_renamed(staticLayoutBuild);
    }

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture != null || this.expandedBounds.isEmpty() || android.text.TextUtils.isEmpty(this.textToDraw)) {
            return;
        }
        calculateOffsets(0.0f);
        int width = this.textLayout.getWidth();
        int height = this.textLayout.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.expandedTitleTexture = android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888);
        this.textLayout.draw(new android.graphics.Canvas(this.expandedTitleTexture));
        if (this.texturePaint == null) {
            this.texturePaint = new android.graphics.Paint(3);
        }
    }

    public void recalculate() {
        if (this.view.getHeight() <= 0 || this.view.getWidth() <= 0) {
            return;
        }
        calculateBaseOffsets();
        calculateCurrentOffsets();
    }

    public void setText(java.lang.CharSequence charSequence) {
        if (charSequence == null || !android.text.TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    public java.lang.CharSequence getText() {
        return this.text;
    }

    private void clearTexture() {
        android.graphics.Bitmap bitmap = this.expandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.expandedTitleTexture = null;
        }
    }

    public void setMaxLines(int i_renamed) {
        if (i_renamed != this.maxLines) {
            this.maxLines = i_renamed;
            clearTexture();
            recalculate();
        }
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    private static boolean isClose(float f_renamed, float f2) {
        return java.lang.Math.abs(f_renamed - f2) < 0.001f;
    }

    public android.content.res.ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public android.content.res.ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    private static int blendColors(int i_renamed, int i2, float f_renamed) {
        float f2 = 1.0f - f_renamed;
        return android.graphics.Color.argb((int) ((android.graphics.Color.alpha(i_renamed) * f2) + (android.graphics.Color.alpha(i2) * f_renamed)), (int) ((android.graphics.Color.red(i_renamed) * f2) + (android.graphics.Color.red(i2) * f_renamed)), (int) ((android.graphics.Color.green(i_renamed) * f2) + (android.graphics.Color.green(i2) * f_renamed)), (int) ((android.graphics.Color.blue(i_renamed) * f2) + (android.graphics.Color.blue(i2) * f_renamed)));
    }

    private static float lerp(float f_renamed, float f2, float f3, android.animation.TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return com.google.android.material.animation.AnimationUtils.lerp(f_renamed, f2, f3);
    }

    private static boolean rectEquals(android.graphics.Rect rect, int i_renamed, int i2, int i3, int i4) {
        return rect.left == i_renamed && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
