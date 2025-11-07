package androidx.appcompat.widget;

/* compiled from: AppCompatEditText.java */
/* loaded from: classes.dex */
public class j_renamed extends android.widget.EditText implements androidx.core.h_renamed.u_renamed {
    private final androidx.appcompat.widget.e_renamed mBackgroundTintHelper;
    private final androidx.appcompat.widget.u_renamed mTextClassifierHelper;
    private final androidx.appcompat.widget.v_renamed mTextHelper;

    public j_renamed(android.content.Context context) {
        this(context, null);
    }

    public j_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R_renamed.attr.editTextStyle);
    }

    public j_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(androidx.appcompat.widget.ao_renamed.a_renamed(context), attributeSet, i_renamed);
        this.mBackgroundTintHelper = new androidx.appcompat.widget.e_renamed(this);
        this.mBackgroundTintHelper.a_renamed(attributeSet, i_renamed);
        this.mTextHelper = new androidx.appcompat.widget.v_renamed(this);
        this.mTextHelper.a_renamed(attributeSet, i_renamed);
        this.mTextHelper.b_renamed();
        this.mTextClassifierHelper = new androidx.appcompat.widget.u_renamed(this);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public android.text.Editable getText() {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
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
}
