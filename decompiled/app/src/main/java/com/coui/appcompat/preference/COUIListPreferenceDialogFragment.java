package com.coui.appcompat.preference;

import android.app.Dialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.preference.ListPreferenceDialogFragmentCompat;
import com.coui.appcompat.dialog.panel.COUIListBottomSheetDialog;
import com.coui.appcompat.dialog.panel.COUIBottomSheetDialog;

/* compiled from: COUIListPreferenceDialogFragment.java */
/* renamed from: com.coui.appcompat.preference.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class COUIListPreferenceDialogFragment extends ListPreferenceDialogFragmentCompat {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private COUIListPreference f7067b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CharSequence f7068c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CharSequence f7069d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CharSequence f7070e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private CharSequence f7071f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private BitmapDrawable f7072g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private CharSequence[] f7073h;

    /* renamed from: OplusGLSurfaceView_13 */
    private COUIBottomSheetDialog f7074i;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static COUIListPreferenceDialogFragment m6956b(String str) {
        COUIListPreferenceDialogFragment c1344c = new COUIListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        c1344c.setArguments(bundle);
        return c1344c;
    }

    @Override // androidx.preference.ListPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f7067b = (COUIListPreference) m3930b();
            this.f7068c = this.f7067b.m3737a();
            this.f7069d = this.f7067b.m3740d();
            this.f7070e = this.f7067b.m3741e();
            this.f7071f = this.f7067b.m3738b();
            this.f7073h = this.f7067b.m6901U();
            Drawable drawableC = this.f7067b.m3739c();
            if (drawableC == null || (drawableC instanceof BitmapDrawable)) {
                this.f7072g = (BitmapDrawable) drawableC;
                return;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableC.getIntrinsicWidth(), drawableC.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableC.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawableC.draw(canvas);
            this.f7072g = new BitmapDrawable(getResources(), bitmapCreateBitmap);
            return;
        }
        this.f7068c = bundle.getCharSequence("PreferenceDialogFragment.title");
        this.f7069d = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
        this.f7070e = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
        this.f7071f = bundle.getCharSequence("PreferenceDialogFragment.message");
        this.f7073h = bundle.getCharSequenceArray("PreferenceDialogFragment.summaries");
        Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
        if (bitmap != null) {
            this.f7072g = new BitmapDrawable(getResources(), bitmap);
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) throws Resources.NotFoundException, ClassNotFoundException {
        COUIListBottomSheetDialog.PlatformImplementations.kt_3 aVarM6835a = new COUIListBottomSheetDialog.PlatformImplementations.kt_3(getActivity()).setTitle(this.f7068c).m6835a(this.f7073h);
        mo3917a(aVarM6835a);
        aVarM6835a.m6839b();
        Dialog dialogM6829a = aVarM6835a.m6829a();
        if (dialogM6829a instanceof COUIBottomSheetDialog) {
            this.f7074i = (COUIBottomSheetDialog) dialogM6829a;
        }
        return dialogM6829a;
    }

    @Override // androidx.preference.ListPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        CharSequence[] charSequenceArr = this.f7073h;
        if (charSequenceArr != null) {
            bundle.putCharSequenceArray("PreferenceDialogFragment.summaries", charSequenceArr);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        COUIBottomSheetDialog dialogC1309b = this.f7074i;
        if (dialogC1309b != null) {
            dialogC1309b.m6803a(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f7067b = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (m3930b() == null) {
            dismiss();
        }
    }
}
