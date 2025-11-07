package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.p031c.MathUtils;
import androidx.core.p034f.TextDirectionHeuristicsCompat;
import androidx.core.p035g.Preconditions;
import androidx.core.p036h.GravityCompat;
import androidx.core.p036h.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;

/* loaded from: classes.dex */
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final Paint DEBUG_DRAW_PAINT;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final String TAG = "CollapsingTextHelper";
    private static final boolean USE_SCALING_TEXTURE;
    private boolean boundsChanged;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private CancelableFontCallback collapsedFontCallback;
    private ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private float collapsedTextBlend;
    private ColorStateList collapsedTextColor;
    private Typeface collapsedTypeface;
    private float currentDrawX;
    private float currentDrawY;
    private float currentTextSize;
    private Typeface currentTypeface;
    private boolean drawTitle;
    private float expandedDrawX;
    private float expandedDrawY;
    private float expandedFirstLineDrawX;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private boolean isRtl;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;
    private CharSequence text;
    private StaticLayout textLayout;
    private TimeInterpolator textSizeInterpolator;
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;
    private Paint texturePaint;
    private boolean useTexture;
    private final View view;
    private int expandedTextGravity = 16;
    private int collapsedTextGravity = 16;
    private float expandedTextSize = 15.0f;
    private float collapsedTextSize = 15.0f;
    private int maxLines = 1;
    private final TextPaint textPaint = new TextPaint(129);
    private final TextPaint tmpPaint = new TextPaint(this.textPaint);
    private final Rect collapsedBounds = new Rect();
    private final Rect expandedBounds = new Rect();
    private final RectF currentBounds = new RectF();

    static {
        USE_SCALING_TEXTURE = Build.VERSION.SDK_INT < 18;
        DEBUG_DRAW_PAINT = null;
        Paint paint = DEBUG_DRAW_PAINT;
        if (paint != null) {
            paint.setAntiAlias(true);
            DEBUG_DRAW_PAINT.setColor(-65281);
        }
    }

    public CollapsingTextHelper(View view) {
        this.view = view;
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.textSizeInterpolator = timeInterpolator;
        recalculate();
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.positionInterpolator = timeInterpolator;
        recalculate();
    }

    public void setExpandedTextSize(float COUIBaseListPopupWindow_12) {
        if (this.expandedTextSize != COUIBaseListPopupWindow_12) {
            this.expandedTextSize = COUIBaseListPopupWindow_12;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float COUIBaseListPopupWindow_12) {
        if (this.collapsedTextSize != COUIBaseListPopupWindow_12) {
            this.collapsedTextSize = COUIBaseListPopupWindow_12;
            recalculate();
        }
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.expandedTextColor != colorStateList) {
            this.expandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedBounds(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (rectEquals(this.expandedBounds, OplusGLSurfaceView_13, i2, i3, i4)) {
            return;
        }
        this.expandedBounds.set(OplusGLSurfaceView_13, i2, i3, i4);
        this.boundsChanged = true;
        onBoundsChanged();
    }

    public void setExpandedBounds(Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setCollapsedBounds(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (rectEquals(this.collapsedBounds, OplusGLSurfaceView_13, i2, i3, i4)) {
            return;
        }
        this.collapsedBounds.set(OplusGLSurfaceView_13, i2, i3, i4);
        this.boundsChanged = true;
        onBoundsChanged();
    }

    public void setCollapsedBounds(Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void getCollapsedTextActualBounds(RectF rectF, int OplusGLSurfaceView_13, int i2) {
        this.isRtl = calculateIsRtl(this.text);
        rectF.left = getCollapsedTextLeftBound(OplusGLSurfaceView_13, i2);
        rectF.top = this.collapsedBounds.top;
        rectF.right = getCollapsedTextRightBound(rectF, OplusGLSurfaceView_13, i2);
        rectF.bottom = this.collapsedBounds.top + getCollapsedTextHeight();
    }

    private float getCollapsedTextLeftBound(int OplusGLSurfaceView_13, int i2) {
        if (i2 == 17 || (i2 & 7) == 1) {
            return (OplusGLSurfaceView_13 / 2.0f) - (calculateCollapsedTextWidth() / 2.0f);
        }
        return ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) ? this.isRtl ? this.collapsedBounds.left : this.collapsedBounds.right - calculateCollapsedTextWidth() : this.isRtl ? this.collapsedBounds.right - calculateCollapsedTextWidth() : this.collapsedBounds.left;
    }

    private float getCollapsedTextRightBound(RectF rectF, int OplusGLSurfaceView_13, int i2) {
        if (i2 == 17 || (i2 & 7) == 1) {
            return (OplusGLSurfaceView_13 / 2.0f) + (calculateCollapsedTextWidth() / 2.0f);
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
        TextPaint textPaint = this.tmpPaint;
        CharSequence charSequence = this.text;
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

    private void getTextPaintExpanded(TextPaint textPaint) {
        textPaint.setTextSize(this.expandedTextSize);
        textPaint.setTypeface(this.expandedTypeface);
    }

    private void getTextPaintCollapsed(TextPaint textPaint) {
        textPaint.setTextSize(this.collapsedTextSize);
        textPaint.setTypeface(this.collapsedTypeface);
    }

    void onBoundsChanged() {
        this.drawTitle = this.collapsedBounds.width() > 0 && this.collapsedBounds.height() > 0 && this.expandedBounds.width() > 0 && this.expandedBounds.height() > 0;
    }

    public void setExpandedTextGravity(int OplusGLSurfaceView_13) {
        if (this.expandedTextGravity != OplusGLSurfaceView_13) {
            this.expandedTextGravity = OplusGLSurfaceView_13;
            recalculate();
        }
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public void setCollapsedTextGravity(int OplusGLSurfaceView_13) {
        if (this.collapsedTextGravity != OplusGLSurfaceView_13) {
            this.collapsedTextGravity = OplusGLSurfaceView_13;
            recalculate();
        }
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public void setCollapsedTextAppearance(int OplusGLSurfaceView_13) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), OplusGLSurfaceView_13);
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
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.collapsedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.1
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setCollapsedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setExpandedTextAppearance(int OplusGLSurfaceView_13) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), OplusGLSurfaceView_13);
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
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.expandedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.2
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setExpandedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (setCollapsedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (setExpandedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setTypefaces(Typeface typeface) {
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        boolean expandedTypefaceInternal = setExpandedTypefaceInternal(typeface);
        if (collapsedTypefaceInternal || expandedTypefaceInternal) {
            recalculate();
        }
    }

    private boolean setCollapsedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.collapsedTypeface == typeface) {
            return false;
        }
        this.collapsedTypeface = typeface;
        return true;
    }

    private boolean setExpandedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.expandedTypeface == typeface) {
            return false;
        }
        this.expandedTypeface = typeface;
        return true;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.collapsedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.expandedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void setExpansionFraction(float COUIBaseListPopupWindow_12) {
        float fM2446a = MathUtils.m2446a(COUIBaseListPopupWindow_12, 0.0f, 1.0f);
        if (fM2446a != this.expandedFraction) {
            this.expandedFraction = fM2446a;
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
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.collapsedTextColor;
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

    private void calculateOffsets(float COUIBaseListPopupWindow_12) {
        interpolateBounds(COUIBaseListPopupWindow_12);
        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, COUIBaseListPopupWindow_12, this.positionInterpolator);
        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, COUIBaseListPopupWindow_12, this.positionInterpolator);
        setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, COUIBaseListPopupWindow_12, this.textSizeInterpolator));
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - COUIBaseListPopupWindow_12, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        setExpandedTextBlend(lerp(1.0f, 0.0f, COUIBaseListPopupWindow_12, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if (this.collapsedTextColor != this.expandedTextColor) {
            this.textPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), COUIBaseListPopupWindow_12));
        } else {
            this.textPaint.setColor(getCurrentCollapsedTextColor());
        }
        this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, COUIBaseListPopupWindow_12, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, COUIBaseListPopupWindow_12, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, COUIBaseListPopupWindow_12, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), COUIBaseListPopupWindow_12));
        ViewCompat.m2881e(this.view);
    }

    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    private int getCurrentColor(ColorStateList colorStateList) {
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
        StaticLayout staticLayout;
        float COUIBaseListPopupWindow_12 = this.currentTextSize;
        calculateUsingTextSize(this.collapsedTextSize);
        CharSequence charSequence = this.textToDraw;
        if (charSequence != null && (staticLayout = this.textLayout) != null) {
            this.textToDrawCollapsed = TextUtils.ellipsize(charSequence, this.textPaint, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.textToDrawCollapsed;
        float fMeasureText = charSequence2 != null ? this.textPaint.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int iM2773a = GravityCompat.m2773a(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        float height = this.textLayout != null ? r5.getHeight() : 0.0f;
        int OplusGLSurfaceView_13 = iM2773a & 112;
        if (OplusGLSurfaceView_13 == 48) {
            this.collapsedDrawY = this.collapsedBounds.top - this.textPaint.ascent();
        } else if (OplusGLSurfaceView_13 == 80) {
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
        int i2 = iM2773a & 8388615;
        if (i2 == 1) {
            this.collapsedDrawX = this.collapsedBounds.centerX() - (fMeasureText / 2.0f);
        } else if (i2 == 5) {
            this.collapsedDrawX = this.collapsedBounds.right - fMeasureText;
        } else {
            this.collapsedDrawX = this.collapsedBounds.left;
        }
        calculateUsingTextSize(this.expandedTextSize);
        CharSequence charSequence3 = this.textToDraw;
        float fMeasureText2 = charSequence3 != null ? this.textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout2 = this.textLayout;
        if (staticLayout2 != null && this.maxLines > 1 && !this.isRtl) {
            fMeasureText2 = staticLayout2.getLineWidth(0);
        }
        StaticLayout staticLayout3 = this.textLayout;
        this.expandedFirstLineDrawX = staticLayout3 != null ? staticLayout3.getLineLeft(0) : 0.0f;
        int iM2773a2 = GravityCompat.m2773a(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int i3 = iM2773a2 & 112;
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
        int i4 = iM2773a2 & 8388615;
        if (i4 == 1) {
            this.expandedDrawX = this.expandedBounds.centerX() - (fMeasureText2 / 2.0f);
        } else if (i4 == 5) {
            this.expandedDrawX = this.expandedBounds.right - fMeasureText2;
        } else {
            this.expandedDrawX = this.expandedBounds.left;
        }
        clearTexture();
        setInterpolatedTextSize(COUIBaseListPopupWindow_12);
    }

    private void interpolateBounds(float COUIBaseListPopupWindow_12) {
        this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, COUIBaseListPopupWindow_12, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, COUIBaseListPopupWindow_12, this.positionInterpolator);
        this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, COUIBaseListPopupWindow_12, this.positionInterpolator);
        this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, COUIBaseListPopupWindow_12, this.positionInterpolator);
    }

    private void setCollapsedTextBlend(float COUIBaseListPopupWindow_12) {
        this.collapsedTextBlend = COUIBaseListPopupWindow_12;
        ViewCompat.m2881e(this.view);
    }

    private void setExpandedTextBlend(float COUIBaseListPopupWindow_12) {
        this.expandedTextBlend = COUIBaseListPopupWindow_12;
        ViewCompat.m2881e(this.view);
    }

    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        if (this.textToDraw == null || !this.drawTitle) {
            return;
        }
        float lineLeft = (this.currentDrawX + this.textLayout.getLineLeft(0)) - (this.expandedFirstLineDrawX * 2.0f);
        this.textPaint.setTextSize(this.currentTextSize);
        float COUIBaseListPopupWindow_12 = this.currentDrawX;
        float f2 = this.currentDrawY;
        boolean z = this.useTexture && this.expandedTitleTexture != null;
        float lineAscent = this.textLayout.getLineAscent(0);
        float f3 = this.scale;
        if (f3 != 1.0f) {
            canvas.scale(f3, f3, COUIBaseListPopupWindow_12, f2);
        }
        if (z) {
            canvas.drawBitmap(this.expandedTitleTexture, COUIBaseListPopupWindow_12, f2 + lineAscent, this.texturePaint);
            canvas.restoreToCount(iSave);
            return;
        }
        if (shouldDrawMultiline()) {
            drawMultinlineTransition(canvas, lineLeft, COUIBaseListPopupWindow_12, f2, lineAscent);
        } else {
            canvas.translate(COUIBaseListPopupWindow_12, f2 + lineAscent);
            this.textLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    private boolean shouldDrawMultiline() {
        return (this.maxLines <= 1 || this.isRtl || this.useTexture) ? false : true;
    }

    private void drawMultinlineTransition(Canvas canvas, float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        int alpha = this.textPaint.getAlpha();
        canvas.translate(COUIBaseListPopupWindow_12, f3);
        float f5 = alpha;
        this.textPaint.setAlpha((int) (this.expandedTextBlend * f5));
        this.textLayout.draw(canvas);
        canvas.translate(f2 - COUIBaseListPopupWindow_12, 0.0f);
        this.textPaint.setAlpha((int) (this.collapsedTextBlend * f5));
        CharSequence charSequence = this.textToDrawCollapsed;
        float f6 = -f4;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f6 / this.scale, this.textPaint);
        String strTrim = this.textToDrawCollapsed.toString().trim();
        if (strTrim.endsWith(ELLIPSIS_NORMAL)) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.textPaint.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.textLayout.getLineEnd(0), str.length()), 0.0f, f6 / this.scale, (Paint) this.textPaint);
    }

    private boolean calculateIsRtl(CharSequence charSequence) {
        return (isDefaultIsRtl() ? TextDirectionHeuristicsCompat.f2925d : TextDirectionHeuristicsCompat.f2924c).mo2519a(charSequence, 0, charSequence.length());
    }

    private boolean isDefaultIsRtl() {
        return ViewCompat.m2885g(this.view) == 1;
    }

    private void setInterpolatedTextSize(float COUIBaseListPopupWindow_12) {
        calculateUsingTextSize(COUIBaseListPopupWindow_12);
        this.useTexture = USE_SCALING_TEXTURE && this.scale != 1.0f;
        if (this.useTexture) {
            ensureExpandedTexture();
        }
        ViewCompat.m2881e(this.view);
    }

    private void calculateUsingTextSize(float COUIBaseListPopupWindow_12) {
        boolean z;
        float f2;
        boolean z2;
        if (this.text == null) {
            return;
        }
        float fWidth = this.collapsedBounds.width();
        float fWidth2 = this.expandedBounds.width();
        if (isClose(COUIBaseListPopupWindow_12, this.collapsedTextSize)) {
            f2 = this.collapsedTextSize;
            this.scale = 1.0f;
            Typeface typeface = this.currentTypeface;
            Typeface typeface2 = this.collapsedTypeface;
            if (typeface != typeface2) {
                this.currentTypeface = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            float f3 = this.expandedTextSize;
            Typeface typeface3 = this.currentTypeface;
            Typeface typeface4 = this.expandedTypeface;
            if (typeface3 != typeface4) {
                this.currentTypeface = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (isClose(COUIBaseListPopupWindow_12, this.expandedTextSize)) {
                this.scale = 1.0f;
            } else {
                this.scale = COUIBaseListPopupWindow_12 / this.expandedTextSize;
            }
            float f4 = this.collapsedTextSize / this.expandedTextSize;
            fWidth = fWidth2 * f4 > fWidth ? Math.min(fWidth / f4, fWidth2) : fWidth2;
            f2 = f3;
            z2 = z;
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

    private StaticLayout createStaticLayout(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, boolean z) throws ClassNotFoundException {
        StaticLayout staticLayoutBuild;
        try {
            staticLayoutBuild = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) COUIBaseListPopupWindow_12).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(z).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(OplusGLSurfaceView_13).build();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8(TAG, COUIBaseListPopupWindow_8.getCause().getMessage(), COUIBaseListPopupWindow_8);
            staticLayoutBuild = null;
        }
        return (StaticLayout) Preconditions.m2536a(staticLayoutBuild);
    }

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture != null || this.expandedBounds.isEmpty() || TextUtils.isEmpty(this.textToDraw)) {
            return;
        }
        calculateOffsets(0.0f);
        int width = this.textLayout.getWidth();
        int height = this.textLayout.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.expandedTitleTexture = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.textLayout.draw(new Canvas(this.expandedTitleTexture));
        if (this.texturePaint == null) {
            this.texturePaint = new Paint(3);
        }
    }

    public void recalculate() {
        if (this.view.getHeight() <= 0 || this.view.getWidth() <= 0) {
            return;
        }
        calculateBaseOffsets();
        calculateCurrentOffsets();
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    public CharSequence getText() {
        return this.text;
    }

    private void clearTexture() {
        Bitmap bitmap = this.expandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.expandedTitleTexture = null;
        }
    }

    public void setMaxLines(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != this.maxLines) {
            this.maxLines = OplusGLSurfaceView_13;
            clearTexture();
            recalculate();
        }
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    private static boolean isClose(float COUIBaseListPopupWindow_12, float f2) {
        return Math.abs(COUIBaseListPopupWindow_12 - f2) < 0.001f;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    private static int blendColors(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        float f2 = 1.0f - COUIBaseListPopupWindow_12;
        return Color.argb((int) ((Color.alpha(OplusGLSurfaceView_13) * f2) + (Color.alpha(i2) * COUIBaseListPopupWindow_12)), (int) ((Color.red(OplusGLSurfaceView_13) * f2) + (Color.red(i2) * COUIBaseListPopupWindow_12)), (int) ((Color.green(OplusGLSurfaceView_13) * f2) + (Color.green(i2) * COUIBaseListPopupWindow_12)), (int) ((Color.blue(OplusGLSurfaceView_13) * f2) + (Color.blue(i2) * COUIBaseListPopupWindow_12)));
    }

    private static float lerp(float COUIBaseListPopupWindow_12, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return AnimationUtils.lerp(COUIBaseListPopupWindow_12, f2, f3);
    }

    private static boolean rectEquals(Rect rect, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        return rect.left == OplusGLSurfaceView_13 && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
