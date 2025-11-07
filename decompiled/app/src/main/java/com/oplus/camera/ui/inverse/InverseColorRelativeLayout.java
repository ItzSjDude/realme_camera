package com.oplus.camera.ui.inverse;

/* loaded from: classes2.dex */
public class InverseColorRelativeLayout extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f6225a;

    public InverseColorRelativeLayout(android.content.Context context) {
        super(context);
        this.f6225a = false;
        a_renamed(context);
    }

    public InverseColorRelativeLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6225a = false;
        a_renamed(context);
    }

    public InverseColorRelativeLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6225a = false;
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        com.oplus.camera.ui.inverse.e_renamed.INS.registerBackgroundInverse(context, this, false);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i_renamed) {
        int backgroundColor = com.oplus.camera.ui.inverse.e_renamed.INS.getBackgroundColor(this, com.oplus.camera.util.c_renamed.a_renamed(i_renamed));
        if (this.f6225a) {
            backgroundColor = 0;
        }
        super.setBackgroundColor(backgroundColor);
    }

    public void setBackgroundAlwaysTransparent(boolean z_renamed) {
        this.f6225a = z_renamed;
    }
}
