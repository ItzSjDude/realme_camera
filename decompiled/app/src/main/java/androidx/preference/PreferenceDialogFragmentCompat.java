package androidx.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.preference.DialogPreference;

/* compiled from: PreferenceDialogFragmentCompat.java */
/* renamed from: androidx.preference.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public abstract class PreferenceDialogFragmentCompat extends DialogFragment implements DialogInterface.OnClickListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private DialogPreference f3875a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence f3876b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CharSequence f3877c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CharSequence f3878d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CharSequence f3879e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f3880f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private BitmapDrawable f3881g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f3882h;

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3917a(AlertDialog.PlatformImplementations.kt_3 aVar) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3911a(boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean mo3912a() {
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LifecycleOwner targetFragment = getTargetFragment();
        if (!(targetFragment instanceof DialogPreference.InterfaceC0633a)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.InterfaceC0633a interfaceC0633a = (DialogPreference.InterfaceC0633a) targetFragment;
        String string = getArguments().getString("key");
        if (bundle == null) {
            this.f3875a = (DialogPreference) interfaceC0633a.mo3744a(string);
            this.f3876b = this.f3875a.m3737a();
            this.f3877c = this.f3875a.m3740d();
            this.f3878d = this.f3875a.m3741e();
            this.f3879e = this.f3875a.m3738b();
            this.f3880f = this.f3875a.m3742f();
            Drawable drawableM3739c = this.f3875a.m3739c();
            if (drawableM3739c == null || (drawableM3739c instanceof BitmapDrawable)) {
                this.f3881g = (BitmapDrawable) drawableM3739c;
                return;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableM3739c.getIntrinsicWidth(), drawableM3739c.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableM3739c.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawableM3739c.draw(canvas);
            this.f3881g = new BitmapDrawable(getResources(), bitmapCreateBitmap);
            return;
        }
        this.f3876b = bundle.getCharSequence("PreferenceDialogFragment.title");
        this.f3877c = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
        this.f3878d = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
        this.f3879e = bundle.getCharSequence("PreferenceDialogFragment.message");
        this.f3880f = bundle.getInt("PreferenceDialogFragment.layout", 0);
        Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
        if (bitmap != null) {
            this.f3881g = new BitmapDrawable(getResources(), bitmap);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f3876b);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f3877c);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f3878d);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f3879e);
        bundle.putInt("PreferenceDialogFragment.layout", this.f3880f);
        BitmapDrawable bitmapDrawable = this.f3881g;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.f3882h = -2;
        AlertDialog.PlatformImplementations.kt_3 negativeButton = new AlertDialog.PlatformImplementations.kt_3(activity).setTitle(this.f3876b).setIcon(this.f3881g).setPositiveButton(this.f3877c, this).setNegativeButton(this.f3878d, this);
        View viewM3929a = m3929a(activity);
        if (viewM3929a != null) {
            mo3910a(viewM3929a);
            negativeButton.setView(viewM3929a);
        } else {
            negativeButton.setMessage(this.f3879e);
        }
        mo3917a(negativeButton);
        AlertDialog dialogInterfaceC0204bCreate = negativeButton.create();
        if (mo3912a()) {
            m3928a(dialogInterfaceC0204bCreate);
        }
        return dialogInterfaceC0204bCreate;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public DialogPreference m3930b() {
        if (this.f3875a == null) {
            this.f3875a = (DialogPreference) ((DialogPreference.InterfaceC0633a) getTargetFragment()).mo3744a(getArguments().getString("key"));
        }
        return this.f3875a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3928a(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected View m3929a(Context context) {
        int OplusGLSurfaceView_13 = this.f3880f;
        if (OplusGLSurfaceView_13 == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(OplusGLSurfaceView_13, (ViewGroup) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3910a(View view) {
        View viewFindViewById = view.findViewById(android.R.id_renamed.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.f3879e;
            int OplusGLSurfaceView_13 = 8;
            if (!TextUtils.isEmpty(charSequence)) {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                OplusGLSurfaceView_13 = 0;
            }
            if (viewFindViewById.getVisibility() != OplusGLSurfaceView_13) {
                viewFindViewById.setVisibility(OplusGLSurfaceView_13);
            }
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
        this.f3882h = OplusGLSurfaceView_13;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        mo3911a(this.f3882h == -1);
    }
}
