package androidx.appcompat.widget;

/* compiled from: AppCompatRadioButton.java */
/* loaded from: classes.dex */
public class q_renamed extends android.widget.RadioButton implements androidx.core.h_renamed.u_renamed, androidx.core.widget.j_renamed {
    private final androidx.appcompat.widget.e_renamed mBackgroundTintHelper;
    private final androidx.appcompat.widget.h_renamed mCompoundButtonHelper;
    private final androidx.appcompat.widget.v_renamed mTextHelper;

    public q_renamed(android.content.Context context) {
        this(context, null);
    }

    public q_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R_renamed.attr.radioButtonStyle);
    }

    public q_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(androidx.appcompat.widget.ao_renamed.a_renamed(context), attributeSet, i_renamed);
        this.mCompoundButtonHelper = new androidx.appcompat.widget.h_renamed(this);
        this.mCompoundButtonHelper.a_renamed(attributeSet, i_renamed);
        this.mBackgroundTintHelper = new androidx.appcompat.widget.e_renamed(this);
        this.mBackgroundTintHelper.a_renamed(attributeSet, i_renamed);
        this.mTextHelper = new androidx.appcompat.widget.v_renamed(this);
        this.mTextHelper.a_renamed(attributeSet, i_renamed);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(android.graphics.drawable.Drawable drawable) {
        super.setButtonDrawable(drawable);
        androidx.appcompat.widget.h_renamed hVar = this.mCompoundButtonHelper;
        if (hVar != null) {
            hVar.c_renamed();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i_renamed) {
        setButtonDrawable(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        androidx.appcompat.widget.h_renamed hVar = this.mCompoundButtonHelper;
        return hVar != null ? hVar.a_renamed(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // androidx.core.widget.j_renamed
    public void setSupportButtonTintList(android.content.res.ColorStateList colorStateList) {
        androidx.appcompat.widget.h_renamed hVar = this.mCompoundButtonHelper;
        if (hVar != null) {
            hVar.a_renamed(colorStateList);
        }
    }

    @Override // androidx.core.widget.j_renamed
    public android.content.res.ColorStateList getSupportButtonTintList() {
        androidx.appcompat.widget.h_renamed hVar = this.mCompoundButtonHelper;
        if (hVar != null) {
            return hVar.a_renamed();
        }
        return null;
    }

    @Override // androidx.core.widget.j_renamed
    public void setSupportButtonTintMode(android.graphics.PorterDuff.Mode mode) {
        androidx.appcompat.widget.h_renamed hVar = this.mCompoundButtonHelper;
        if (hVar != null) {
            hVar.a_renamed(mode);
        }
    }

    public android.graphics.PorterDuff.Mode getSupportButtonTintMode() {
        androidx.appcompat.widget.h_renamed hVar = this.mCompoundButtonHelper;
        if (hVar != null) {
            return hVar.b_renamed();
        }
        return null;
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

    @Override // android.view.View
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a_renamed(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i_renamed) {
        super.setBackgroundResource(i_renamed);
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a_renamed(i_renamed);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
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
}
