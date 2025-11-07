package androidx.appcompat.widget;

/* compiled from: AppCompatAutoCompleteTextView.java */
/* loaded from: classes.dex */
public class d_renamed extends android.widget.AutoCompleteTextView implements androidx.core.h_renamed.u_renamed {
    private static final int[] TINT_ATTRS = {android.R_renamed.attr.popupBackground};
    private final androidx.appcompat.widget.e_renamed mBackgroundTintHelper;
    private final androidx.appcompat.widget.v_renamed mTextHelper;

    public d_renamed(android.content.Context context) {
        this(context, null);
    }

    public d_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R_renamed.attr.autoCompleteTextViewStyle);
    }

    public d_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(androidx.appcompat.widget.ao_renamed.a_renamed(context), attributeSet, i_renamed);
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(getContext(), attributeSet, TINT_ATTRS, i_renamed, 0);
        if (arVarA.g_renamed(0)) {
            setDropDownBackgroundDrawable(arVarA.a_renamed(0));
        }
        arVarA.b_renamed();
        this.mBackgroundTintHelper = new androidx.appcompat.widget.e_renamed(this);
        this.mBackgroundTintHelper.a_renamed(attributeSet, i_renamed);
        this.mTextHelper = new androidx.appcompat.widget.v_renamed(this);
        this.mTextHelper.a_renamed(attributeSet, i_renamed);
        this.mTextHelper.b_renamed();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i_renamed) {
        setDropDownBackgroundDrawable(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
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

    @Override // android.widget.TextView, android.view.View
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo editorInfo) {
        return androidx.appcompat.widget.k_renamed.a_renamed(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(android.view.ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i_renamed.a_renamed(this, callback));
    }
}
