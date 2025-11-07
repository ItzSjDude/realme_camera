package androidx.appcompat.widget;

/* compiled from: AppCompatPopupWindow.java */
/* loaded from: classes.dex */
class o_renamed extends android.widget.PopupWindow {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final boolean f629a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f630b;

    static {
        f629a = android.os.Build.VERSION.SDK_INT < 21;
    }

    public o_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        super(context, attributeSet, i_renamed, i2);
        a_renamed(context, attributeSet, i_renamed, i2);
    }

    private void a_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(context, attributeSet, androidx.appcompat.R_renamed.styleable.PopupWindow, i_renamed, i2);
        if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.PopupWindow_overlapAnchor)) {
            a_renamed(arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.PopupWindow_android_popupBackground));
        arVarA.b_renamed();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(android.view.View view, int i_renamed, int i2) {
        if (f629a && this.f630b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i_renamed, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(android.view.View view, int i_renamed, int i2, int i3) {
        if (f629a && this.f630b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i_renamed, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(android.view.View view, int i_renamed, int i2, int i3, int i4) {
        if (f629a && this.f630b) {
            i2 -= view.getHeight();
        }
        super.update(view, i_renamed, i2, i3, i4);
    }

    private void a_renamed(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        if (f629a) {
            this.f630b = z_renamed;
        } else {
            androidx.core.widget.h_renamed.a_renamed(this, z_renamed);
        }
    }
}
