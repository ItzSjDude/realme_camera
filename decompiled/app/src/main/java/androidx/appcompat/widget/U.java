package androidx.appcompat.widget;

/* compiled from: AppCompatMultiAutoCompleteTextView.java */
/* loaded from: classes.dex */
public class n_renamed extends android.widget.MultiAutoCompleteTextView implements androidx.core.h_renamed.u_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int[] f626a = {android.R_renamed.attr.popupBackground};

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.appcompat.widget.e_renamed f627b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final androidx.appcompat.widget.v_renamed f628c;

    public n_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R_renamed.attr.autoCompleteTextViewStyle);
    }

    public n_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(androidx.appcompat.widget.ao_renamed.a_renamed(context), attributeSet, i_renamed);
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(getContext(), attributeSet, f626a, i_renamed, 0);
        if (arVarA.g_renamed(0)) {
            setDropDownBackgroundDrawable(arVarA.a_renamed(0));
        }
        arVarA.b_renamed();
        this.f627b = new androidx.appcompat.widget.e_renamed(this);
        this.f627b.a_renamed(attributeSet, i_renamed);
        this.f628c = new androidx.appcompat.widget.v_renamed(this);
        this.f628c.a_renamed(attributeSet, i_renamed);
        this.f628c.b_renamed();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i_renamed) {
        setDropDownBackgroundDrawable(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
    }

    @Override // android.view.View
    public void setBackgroundResource(int i_renamed) {
        super.setBackgroundResource(i_renamed);
        androidx.appcompat.widget.e_renamed eVar = this.f627b;
        if (eVar != null) {
            eVar.a_renamed(i_renamed);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.e_renamed eVar = this.f627b;
        if (eVar != null) {
            eVar.a_renamed(drawable);
        }
    }

    @Override // androidx.core.h_renamed.u_renamed
    public void setSupportBackgroundTintList(android.content.res.ColorStateList colorStateList) {
        androidx.appcompat.widget.e_renamed eVar = this.f627b;
        if (eVar != null) {
            eVar.a_renamed(colorStateList);
        }
    }

    @Override // androidx.core.h_renamed.u_renamed
    public android.content.res.ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.e_renamed eVar = this.f627b;
        if (eVar != null) {
            return eVar.a_renamed();
        }
        return null;
    }

    @Override // androidx.core.h_renamed.u_renamed
    public void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode) {
        androidx.appcompat.widget.e_renamed eVar = this.f627b;
        if (eVar != null) {
            eVar.a_renamed(mode);
        }
    }

    @Override // androidx.core.h_renamed.u_renamed
    public android.graphics.PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.e_renamed eVar = this.f627b;
        if (eVar != null) {
            return eVar.b_renamed();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e_renamed eVar = this.f627b;
        if (eVar != null) {
            eVar.c_renamed();
        }
        androidx.appcompat.widget.v_renamed vVar = this.f628c;
        if (vVar != null) {
            vVar.b_renamed();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(android.content.Context context, int i_renamed) {
        super.setTextAppearance(context, i_renamed);
        androidx.appcompat.widget.v_renamed vVar = this.f628c;
        if (vVar != null) {
            vVar.a_renamed(context, i_renamed);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo editorInfo) {
        return androidx.appcompat.widget.k_renamed.a_renamed(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
