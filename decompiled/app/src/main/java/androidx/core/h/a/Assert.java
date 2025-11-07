package androidx.core.h_renamed.a_renamed;

/* compiled from: AccessibilityClickableSpanCompat.java */
/* loaded from: classes.dex */
public final class a_renamed extends android.text.style.ClickableSpan {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f956a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.core.h_renamed.a_renamed.d_renamed f957b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f958c;

    public a_renamed(int i_renamed, androidx.core.h_renamed.a_renamed.d_renamed dVar, int i2) {
        this.f956a = i_renamed;
        this.f957b = dVar;
        this.f958c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(android.view.View view) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f956a);
        this.f957b.a_renamed(this.f958c, bundle);
    }
}
