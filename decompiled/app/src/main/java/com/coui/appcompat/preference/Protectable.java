package com.coui.appcompat.preference;

/* compiled from: COUIListPreferenceDialogFragment.java */
/* loaded from: classes.dex */
public class c_renamed extends androidx.preference.c_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.coui.appcompat.preference.COUIListPreference f2669b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.CharSequence f2670c;
    private java.lang.CharSequence d_renamed;
    private java.lang.CharSequence e_renamed;
    private java.lang.CharSequence f_renamed;
    private android.graphics.drawable.BitmapDrawable g_renamed;
    private java.lang.CharSequence[] h_renamed;
    private com.coui.appcompat.dialog.panel.b_renamed i_renamed;

    public static com.coui.appcompat.preference.c_renamed b_renamed(java.lang.String str) {
        com.coui.appcompat.preference.c_renamed cVar = new com.coui.appcompat.preference.c_renamed();
        android.os.Bundle bundle = new android.os.Bundle(1);
        bundle.putString("key", str);
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // androidx.preference.c_renamed, androidx.preference.f_renamed, androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f2669b = (com.coui.appcompat.preference.COUIListPreference) b_renamed();
            this.f2670c = this.f2669b.a_renamed();
            this.d_renamed = this.f2669b.d_renamed();
            this.e_renamed = this.f2669b.e_renamed();
            this.f_renamed = this.f2669b.b_renamed();
            this.h_renamed = this.f2669b.U_renamed();
            android.graphics.drawable.Drawable drawableC = this.f2669b.c_renamed();
            if (drawableC == null || (drawableC instanceof android.graphics.drawable.BitmapDrawable)) {
                this.g_renamed = (android.graphics.drawable.BitmapDrawable) drawableC;
                return;
            }
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(drawableC.getIntrinsicWidth(), drawableC.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
            drawableC.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawableC.draw(canvas);
            this.g_renamed = new android.graphics.drawable.BitmapDrawable(getResources(), bitmapCreateBitmap);
            return;
        }
        this.f2670c = bundle.getCharSequence("PreferenceDialogFragment.title");
        this.d_renamed = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
        this.e_renamed = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
        this.f_renamed = bundle.getCharSequence("PreferenceDialogFragment.message");
        this.h_renamed = bundle.getCharSequenceArray("PreferenceDialogFragment.summaries");
        android.graphics.Bitmap bitmap = (android.graphics.Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
        if (bitmap != null) {
            this.g_renamed = new android.graphics.drawable.BitmapDrawable(getResources(), bitmap);
        }
    }

    @Override // androidx.preference.f_renamed, androidx.fragment.app.b_renamed
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        com.coui.appcompat.dialog.panel.c_renamed.a_renamed aVarA = new com.coui.appcompat.dialog.panel.c_renamed.a_renamed(getActivity()).setTitle(this.f2670c).a_renamed(this.h_renamed);
        a_renamed(aVarA);
        aVarA.b_renamed();
        android.app.Dialog dialogA = aVarA.a_renamed();
        if (dialogA instanceof com.coui.appcompat.dialog.panel.b_renamed) {
            this.i_renamed = (com.coui.appcompat.dialog.panel.b_renamed) dialogA;
        }
        return dialogA;
    }

    @Override // androidx.preference.c_renamed, androidx.preference.f_renamed, androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        java.lang.CharSequence[] charSequenceArr = this.h_renamed;
        if (charSequenceArr != null) {
            bundle.putCharSequenceArray("PreferenceDialogFragment.summaries", charSequenceArr);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.coui.appcompat.dialog.panel.b_renamed bVar = this.i_renamed;
        if (bVar != null) {
            bVar.a_renamed(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f2669b = null;
    }

    @Override // androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (b_renamed() == null) {
            dismiss();
        }
    }
}
