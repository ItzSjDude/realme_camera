package androidx.appcompat.widget;

/* compiled from: AppCompatCheckedTextView.java */
/* loaded from: classes.dex */
public class g_renamed extends android.widget.CheckedTextView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int[] f612a = {android.R_renamed.attr.checkMark};

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.appcompat.widget.v_renamed f613b;

    public g_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, android.R_renamed.attr.checkedTextViewStyle);
    }

    public g_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(androidx.appcompat.widget.ao_renamed.a_renamed(context), attributeSet, i_renamed);
        this.f613b = new androidx.appcompat.widget.v_renamed(this);
        this.f613b.a_renamed(attributeSet, i_renamed);
        this.f613b.b_renamed();
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(getContext(), attributeSet, f612a, i_renamed, 0);
        setCheckMarkDrawable(arVarA.a_renamed(0));
        arVarA.b_renamed();
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i_renamed) {
        setCheckMarkDrawable(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(android.content.Context context, int i_renamed) {
        super.setTextAppearance(context, i_renamed);
        androidx.appcompat.widget.v_renamed vVar = this.f613b;
        if (vVar != null) {
            vVar.a_renamed(context, i_renamed);
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.v_renamed vVar = this.f613b;
        if (vVar != null) {
            vVar.b_renamed();
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
