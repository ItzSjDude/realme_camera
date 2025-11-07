package com.google.android.material.resources;

/* loaded from: classes.dex */
public class TextAppearance {
    private static final java.lang.String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    private android.graphics.Typeface font;
    public final java.lang.String fontFamily;
    private final int fontFamilyResourceId;
    private boolean fontResolved = false;
    public final android.content.res.ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    public final android.content.res.ColorStateList textColor;
    public final android.content.res.ColorStateList textColorHint;
    public final android.content.res.ColorStateList textColorLink;
    public final float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i_renamed, com.google.android.material.R_renamed.styleable.TextAppearance);
        this.textSize = typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R_renamed.styleable.TextAppearance_android_textSize, 0.0f);
        this.textColor = com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.TextAppearance_android_textColor);
        this.textColorHint = com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.TextAppearance_android_textColorLink);
        this.textStyle = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = typedArrayObtainStyledAttributes.getInt(com.google.android.material.R_renamed.styleable.TextAppearance_android_typeface, 1);
        int indexWithValue = com.google.android.material.resources.MaterialResources.getIndexWithValue(typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.TextAppearance_fontFamily, com.google.android.material.R_renamed.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = typedArrayObtainStyledAttributes.getResourceId(indexWithValue, 0);
        this.fontFamily = typedArrayObtainStyledAttributes.getString(indexWithValue);
        this.textAllCaps = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.R_renamed.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = com.google.android.material.resources.MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, com.google.android.material.R_renamed.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = typedArrayObtainStyledAttributes.getFloat(com.google.android.material.R_renamed.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = typedArrayObtainStyledAttributes.getFloat(com.google.android.material.R_renamed.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = typedArrayObtainStyledAttributes.getFloat(com.google.android.material.R_renamed.styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public android.graphics.Typeface getFont(android.content.Context context) {
        if (this.fontResolved) {
            return this.font;
        }
        if (!context.isRestricted()) {
            try {
                this.font = androidx.core.a_renamed.a_renamed.f_renamed.a_renamed(context, this.fontFamilyResourceId);
                if (this.font != null) {
                    this.font = android.graphics.Typeface.create(this.font, this.textStyle);
                }
            } catch (android.content.res.Resources.NotFoundException | java.lang.UnsupportedOperationException unused) {
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.d_renamed(TAG, "Error loading font " + this.fontFamily, e_renamed);
            }
        }
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    }

    public void getFontAsync(android.content.Context context, final com.google.android.material.resources.TextAppearanceFontCallback textAppearanceFontCallback) {
        if (com.google.android.material.resources.TextAppearanceConfig.shouldLoadFontSynchronously()) {
            getFont(context);
        } else {
            createFallbackFont();
        }
        if (this.fontFamilyResourceId == 0) {
            this.fontResolved = true;
        }
        if (this.fontResolved) {
            textAppearanceFontCallback.onFontRetrieved(this.font, true);
            return;
        }
        try {
            androidx.core.a_renamed.a_renamed.f_renamed.a_renamed(context, this.fontFamilyResourceId, new androidx.core.a_renamed.a_renamed.f_renamed.a_renamed() { // from class: com.google.android.material.resources.TextAppearance.1
                @Override // androidx.core.a_renamed.a_renamed.f_renamed.a_renamed
                public void onFontRetrieved(android.graphics.Typeface typeface) {
                    com.google.android.material.resources.TextAppearance textAppearance = com.google.android.material.resources.TextAppearance.this;
                    textAppearance.font = android.graphics.Typeface.create(typeface, textAppearance.textStyle);
                    com.google.android.material.resources.TextAppearance.this.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrieved(com.google.android.material.resources.TextAppearance.this.font, false);
                }

                @Override // androidx.core.a_renamed.a_renamed.f_renamed.a_renamed
                public void onFontRetrievalFailed(int i_renamed) {
                    com.google.android.material.resources.TextAppearance.this.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrievalFailed(i_renamed);
                }
            }, null);
        } catch (android.content.res.Resources.NotFoundException unused) {
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(1);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.d_renamed(TAG, "Error loading font " + this.fontFamily, e_renamed);
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(-3);
        }
    }

    public void getFontAsync(android.content.Context context, final android.text.TextPaint textPaint, final com.google.android.material.resources.TextAppearanceFontCallback textAppearanceFontCallback) {
        updateTextPaintMeasureState(textPaint, getFallbackFont());
        getFontAsync(context, new com.google.android.material.resources.TextAppearanceFontCallback() { // from class: com.google.android.material.resources.TextAppearance.2
            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrieved(android.graphics.Typeface typeface, boolean z_renamed) {
                com.google.android.material.resources.TextAppearance.this.updateTextPaintMeasureState(textPaint, typeface);
                textAppearanceFontCallback.onFontRetrieved(typeface, z_renamed);
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrievalFailed(int i_renamed) {
                textAppearanceFontCallback.onFontRetrievalFailed(i_renamed);
            }
        });
    }

    public android.graphics.Typeface getFallbackFont() {
        createFallbackFont();
        return this.font;
    }

    private void createFallbackFont() {
        java.lang.String str;
        if (this.font == null && (str = this.fontFamily) != null) {
            this.font = android.graphics.Typeface.create(str, this.textStyle);
        }
        if (this.font == null) {
            int i_renamed = this.typeface;
            if (i_renamed == 1) {
                this.font = android.graphics.Typeface.SANS_SERIF;
            } else if (i_renamed == 2) {
                this.font = android.graphics.Typeface.SERIF;
            } else if (i_renamed == 3) {
                this.font = android.graphics.Typeface.MONOSPACE;
            } else {
                this.font = android.graphics.Typeface.DEFAULT;
            }
            this.font = android.graphics.Typeface.create(this.font, this.textStyle);
        }
    }

    public void updateDrawState(android.content.Context context, android.text.TextPaint textPaint, com.google.android.material.resources.TextAppearanceFontCallback textAppearanceFontCallback) {
        updateMeasureState(context, textPaint, textAppearanceFontCallback);
        android.content.res.ColorStateList colorStateList = this.textColor;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, this.textColor.getDefaultColor()) : -16777216);
        float f_renamed = this.shadowRadius;
        float f2 = this.shadowDx;
        float f3 = this.shadowDy;
        android.content.res.ColorStateList colorStateList2 = this.shadowColor;
        textPaint.setShadowLayer(f_renamed, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, this.shadowColor.getDefaultColor()) : 0);
    }

    public void updateMeasureState(android.content.Context context, android.text.TextPaint textPaint, com.google.android.material.resources.TextAppearanceFontCallback textAppearanceFontCallback) {
        if (com.google.android.material.resources.TextAppearanceConfig.shouldLoadFontSynchronously()) {
            updateTextPaintMeasureState(textPaint, getFont(context));
        } else {
            getFontAsync(context, textPaint, textAppearanceFontCallback);
        }
    }

    public void updateTextPaintMeasureState(android.text.TextPaint textPaint, android.graphics.Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i_renamed = (~typeface.getStyle()) & this.textStyle;
        textPaint.setFakeBoldText((i_renamed & 1) != 0);
        textPaint.setTextSkewX((i_renamed & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.textSize);
    }
}
