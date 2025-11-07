package com.oplus.camera.ui;

/* compiled from: OplusViewOutlineProvider.java */
/* loaded from: classes2.dex */
public class q_renamed extends android.view.ViewOutlineProvider {

    /* renamed from: a_renamed, reason: collision with root package name */
    java.lang.String f7166a = "Rect";

    /* renamed from: b_renamed, reason: collision with root package name */
    private float f7167b = 0.0f;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Rect f7168c = null;

    public com.oplus.camera.ui.q_renamed a_renamed(android.graphics.Rect rect, float f_renamed) {
        this.f7166a = "RoundRect";
        this.f7167b = f_renamed;
        this.f7168c = rect;
        com.oplus.camera.e_renamed.f_renamed("OplusViewOutlineProvider", "setRountRect, mOutLineRect: " + this.f7168c.toString());
        if (a_renamed(this.f7168c)) {
            return this;
        }
        return null;
    }

    private boolean a_renamed(android.graphics.Rect rect) {
        if (rect != null && rect.left >= 0 && rect.top >= 0 && rect.width() > 0 && rect.height() > 0) {
            return true;
        }
        com.oplus.camera.e_renamed.f_renamed("OplusViewOutlineProvider", "checkArgumentNonnegative, value is_renamed invalid");
        return false;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(android.view.View view, android.graphics.Outline outline) {
        if (this.f7168c == null || !"RoundRect".equals(this.f7166a)) {
            return;
        }
        outline.setRoundRect(this.f7168c, this.f7167b);
    }
}
