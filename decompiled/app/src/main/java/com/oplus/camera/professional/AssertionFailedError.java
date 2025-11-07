package com.oplus.camera.professional;

/* compiled from: HSAutoImageView.java */
/* loaded from: classes2.dex */
public class b_renamed extends android.widget.ImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f5110a;

    public b_renamed(android.content.Context context) {
        this(context, null);
    }

    public b_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5110a = false;
        a_renamed();
    }

    private void a_renamed() {
        setImageResource(com.oplus.camera.R_renamed.drawable.hs_autoview_auto);
        setContentDescription(getContext().getResources().getString(com.oplus.camera.R_renamed.string.camera_description_professional_auto));
    }

    public void setAuto(boolean z_renamed) {
        if (this.f5110a == z_renamed) {
            return;
        }
        this.f5110a = z_renamed;
        setImageResource(z_renamed ? com.oplus.camera.R_renamed.drawable.hs_autoview_auto : com.oplus.camera.R_renamed.drawable.hs_autoview_normal);
        invalidate();
    }
}
