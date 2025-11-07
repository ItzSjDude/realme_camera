package com.oplus.camera.professional;

/* compiled from: RotateView.java */
/* loaded from: classes2.dex */
public class y_renamed extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    public boolean f5282a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected int f5283b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.Context f5284c;

    public void a_renamed(int i_renamed, boolean z_renamed) {
    }

    public y_renamed(android.content.Context context, int i_renamed) {
        super(context);
        this.f5282a = true;
        this.f5283b = -1;
        this.f5284c = context;
        this.f5283b = i_renamed;
        com.oplus.camera.e_renamed.f_renamed("RotateView", "RotateView mOrientation is_renamed " + this.f5283b);
        a_renamed(this.f5283b, false);
    }

    @Override // android.view.View
    public java.lang.Object getTag(int i_renamed) {
        java.lang.Object tag;
        return (getChildCount() <= 0 || (tag = getChildAt(0).getTag(i_renamed)) == null) ? super.getTag(i_renamed) : tag;
    }

    public void setRotateViewClickable(boolean z_renamed) {
        this.f5282a = z_renamed;
    }
}
