package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class AppCompatTextView extends android.widget.TextView implements androidx.core.h_renamed.u_renamed, androidx.core.widget.b_renamed, androidx.core.widget.k_renamed {
    private final androidx.appcompat.widget.e_renamed mBackgroundTintHelper;
    private java.util.concurrent.Future<androidx.core.f_renamed.c_renamed> mPrecomputedTextFuture;
    private final androidx.appcompat.widget.u_renamed mTextClassifierHelper;
    private final androidx.appcompat.widget.v_renamed mTextHelper;

    public AppCompatTextView(android.content.Context context) {
        this(context, null);
    }

    public AppCompatTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, android.R_renamed.attr.textViewStyle);
    }

    public AppCompatTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(androidx.appcompat.widget.ao_renamed.a_renamed(context), attributeSet, i_renamed);
        this.mBackgroundTintHelper = new androidx.appcompat.widget.e_renamed(this);
        this.mBackgroundTintHelper.a_renamed(attributeSet, i_renamed);
        this.mTextHelper = new androidx.appcompat.widget.v_renamed(this);
        this.mTextHelper.a_renamed(attributeSet, i_renamed);
        this.mTextHelper.b_renamed();
        this.mTextClassifierHelper = new androidx.appcompat.widget.u_renamed(this);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i_renamed) {
        super.setBackgroundResource(i_renamed);
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a_renamed(i_renamed);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a_renamed(drawable);
        }
    }

    @Override // androidx.core.h_renamed.u_renamed
    public void setSupportBackgroundTintList(android.content.res.ColorStateList colorStateList) {
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a_renamed(colorStateList);
        }
    }

    @Override // androidx.core.h_renamed.u_renamed
    public android.content.res.ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.a_renamed();
        }
        return null;
    }

    @Override // androidx.core.h_renamed.u_renamed
    public void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode) {
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a_renamed(mode);
        }
    }

    @Override // androidx.core.h_renamed.u_renamed
    public android.graphics.PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.b_renamed();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setTextAppearance(android.content.Context context, int i_renamed) {
        super.setTextAppearance(context, i_renamed);
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed(context, i_renamed);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.c_renamed();
        }
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.b_renamed();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed(z_renamed, i_renamed, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i_renamed, float f_renamed) {
        if (d_renamed) {
            super.setTextSize(i_renamed, f_renamed);
            return;
        }
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed(i_renamed, f_renamed);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(java.lang.CharSequence charSequence, int i_renamed, int i2, int i3) {
        super.onTextChanged(charSequence, i_renamed, i2, i3);
        if (this.mTextHelper == null || d_renamed || !this.mTextHelper.d_renamed()) {
            return;
        }
        this.mTextHelper.c_renamed();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i_renamed) {
        if (d_renamed) {
            super.setAutoSizeTextTypeWithDefaults(i_renamed);
            return;
        }
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed(i_renamed);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i_renamed, int i2, int i3, int i4) throws java.lang.IllegalArgumentException {
        if (d_renamed) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i_renamed, i2, i3, i4);
            return;
        }
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed(i_renamed, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i_renamed) throws java.lang.IllegalArgumentException {
        if (d_renamed) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i_renamed);
            return;
        }
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed(iArr, i_renamed);
        }
    }

    @Override // android.widget.TextView
    @android.annotation.SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (d_renamed) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            return vVar.e_renamed();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (d_renamed) {
            return super.getAutoSizeStepGranularity();
        }
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            return vVar.f_renamed();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (d_renamed) {
            return super.getAutoSizeMinTextSize();
        }
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            return vVar.g_renamed();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (d_renamed) {
            return super.getAutoSizeMaxTextSize();
        }
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            return vVar.h_renamed();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (d_renamed) {
            return super.getAutoSizeTextAvailableSizes();
        }
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            return vVar.i_renamed();
        }
        return new int[0];
    }

    @Override // android.widget.TextView, android.view.View
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo editorInfo) {
        return androidx.appcompat.widget.k_renamed.a_renamed(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i_renamed);
        } else {
            androidx.core.widget.i_renamed.b_renamed(this, i_renamed);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i_renamed);
        } else {
            androidx.core.widget.i_renamed.c_renamed(this, i_renamed);
        }
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.i_renamed.c_renamed(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.i_renamed.d_renamed(this);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i_renamed) {
        androidx.core.widget.i_renamed.d_renamed(this, i_renamed);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(android.view.ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i_renamed.a_renamed(this, callback));
    }

    public androidx.core.f_renamed.c_renamed.a_renamed getTextMetricsParamsCompat() {
        return androidx.core.widget.i_renamed.e_renamed(this);
    }

    public void setTextMetricsParamsCompat(androidx.core.f_renamed.c_renamed.a_renamed aVar) {
        androidx.core.widget.i_renamed.a_renamed(this, aVar);
    }

    public void setPrecomputedText(androidx.core.f_renamed.c_renamed cVar) {
        androidx.core.widget.i_renamed.a_renamed(this, cVar);
    }

    private void consumeTextFutureAndSetBlocking() {
        java.util.concurrent.Future<androidx.core.f_renamed.c_renamed> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                androidx.core.widget.i_renamed.a_renamed(this, future.get());
            } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public java.lang.CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    @Override // android.widget.TextView
    public void setTextClassifier(android.view.textclassifier.TextClassifier textClassifier) {
        androidx.appcompat.widget.u_renamed uVar;
        if (android.os.Build.VERSION.SDK_INT >= 28 || (uVar = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            uVar.a_renamed(textClassifier);
        }
    }

    @Override // android.widget.TextView
    public android.view.textclassifier.TextClassifier getTextClassifier() {
        androidx.appcompat.widget.u_renamed uVar;
        if (android.os.Build.VERSION.SDK_INT >= 28 || (uVar = this.mTextClassifierHelper) == null) {
            return super.getTextClassifier();
        }
        return uVar.a_renamed();
    }

    public void setTextFuture(java.util.concurrent.Future<androidx.core.f_renamed.c_renamed> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i_renamed, i2);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, android.graphics.drawable.Drawable drawable3, android.graphics.drawable.Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, android.graphics.drawable.Drawable drawable3, android.graphics.drawable.Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, android.graphics.drawable.Drawable drawable3, android.graphics.drawable.Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i_renamed, int i2, int i3, int i4) {
        android.content.Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i_renamed != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(context, i_renamed) : null, i2 != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(context, i2) : null, i3 != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(context, i3) : null, i4 != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(context, i4) : null);
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, android.graphics.drawable.Drawable drawable3, android.graphics.drawable.Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i_renamed, int i2, int i3, int i4) {
        android.content.Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i_renamed != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(context, i_renamed) : null, i2 != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(context, i2) : null, i3 != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(context, i3) : null, i4 != 0 ? androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(context, i4) : null);
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed();
        }
    }

    public android.content.res.ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j_renamed();
    }

    @Override // androidx.core.widget.k_renamed
    public void setSupportCompoundDrawablesTintList(android.content.res.ColorStateList colorStateList) {
        this.mTextHelper.a_renamed(colorStateList);
        this.mTextHelper.b_renamed();
    }

    public android.graphics.PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k_renamed();
    }

    @Override // androidx.core.widget.k_renamed
    public void setSupportCompoundDrawablesTintMode(android.graphics.PorterDuff.Mode mode) {
        this.mTextHelper.a_renamed(mode);
        this.mTextHelper.b_renamed();
    }

    @Override // android.widget.TextView
    public void setTypeface(android.graphics.Typeface typeface, int i_renamed) {
        android.graphics.Typeface typefaceA = (typeface == null || i_renamed <= 0) ? null : androidx.core.graphics.f_renamed.a_renamed(getContext(), typeface, i_renamed);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        super.setTypeface(typeface, i_renamed);
    }
}
