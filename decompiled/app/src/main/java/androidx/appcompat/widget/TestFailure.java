package androidx.appcompat.widget;

/* compiled from: AppCompatButton.java */
/* loaded from: classes.dex */
public class f_renamed extends android.widget.Button implements androidx.core.h_renamed.u_renamed, androidx.core.widget.b_renamed {
    private final androidx.appcompat.widget.e_renamed mBackgroundTintHelper;
    private final androidx.appcompat.widget.v_renamed mTextHelper;

    public f_renamed(android.content.Context context) {
        this(context, null);
    }

    public f_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R_renamed.attr.buttonStyle);
    }

    public f_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(androidx.appcompat.widget.ao_renamed.a_renamed(context), attributeSet, i_renamed);
        this.mBackgroundTintHelper = new androidx.appcompat.widget.e_renamed(this);
        this.mBackgroundTintHelper.a_renamed(attributeSet, i_renamed);
        this.mTextHelper = new androidx.appcompat.widget.v_renamed(this);
        this.mTextHelper.a_renamed(attributeSet, i_renamed);
        this.mTextHelper.b_renamed();
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

    @Override // android.widget.TextView
    public void setTextAppearance(android.content.Context context, int i_renamed) {
        super.setTextAppearance(context, i_renamed);
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed(context, i_renamed);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(android.widget.Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(android.widget.Button.class.getName());
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

    public void setSupportAllCaps(boolean z_renamed) {
        androidx.appcompat.widget.v_renamed vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.a_renamed(z_renamed);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(android.view.ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i_renamed.a_renamed(this, callback));
    }
}
