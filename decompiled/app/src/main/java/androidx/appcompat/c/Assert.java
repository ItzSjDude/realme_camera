package androidx.appcompat.c_renamed;

/* compiled from: AllCapsTransformationMethod.java */
/* loaded from: classes.dex */
public class a_renamed implements android.text.method.TransformationMethod {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.Locale f320a;

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(android.view.View view, java.lang.CharSequence charSequence, boolean z_renamed, int i_renamed, android.graphics.Rect rect) {
    }

    public a_renamed(android.content.Context context) {
        this.f320a = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public java.lang.CharSequence getTransformation(java.lang.CharSequence charSequence, android.view.View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f320a);
        }
        return null;
    }
}
