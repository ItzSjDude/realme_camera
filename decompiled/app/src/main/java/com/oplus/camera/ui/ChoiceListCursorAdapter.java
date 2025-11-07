package com.oplus.camera.ui;

/* compiled from: TwoStateImageView.java */
/* loaded from: classes2.dex */
public class w_renamed extends android.widget.ImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final float f7187a;

    public w_renamed(android.content.Context context) {
        super(context);
        this.f7187a = 0.4f;
    }

    public w_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7187a = 0.4f;
    }

    public w_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f7187a = 0.4f;
    }

    @Override // android.view.View
    public void setEnabled(boolean z_renamed) {
        super.setEnabled(z_renamed);
        if (z_renamed) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.4f);
        }
    }

    public void a_renamed(boolean z_renamed, boolean z2) {
        super.setEnabled(z_renamed);
        if (z_renamed) {
            setAlpha(1.0f);
        } else if (z2) {
            setAlpha(0.4f);
        }
    }
}
