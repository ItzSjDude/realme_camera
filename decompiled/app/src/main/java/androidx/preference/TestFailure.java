package androidx.preference;

/* compiled from: PreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public abstract class f_renamed extends androidx.fragment.app.b_renamed implements android.content.DialogInterface.OnClickListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.preference.DialogPreference f1343a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.CharSequence f1344b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.CharSequence f1345c;
    private java.lang.CharSequence d_renamed;
    private java.lang.CharSequence e_renamed;
    private int f_renamed;
    private android.graphics.drawable.BitmapDrawable g_renamed;
    private int h_renamed;

    protected void a_renamed(androidx.appcompat.app.b_renamed.a_renamed aVar) {
    }

    public abstract void a_renamed(boolean z_renamed);

    protected boolean a_renamed() {
        return false;
    }

    @Override // androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.h_renamed targetFragment = getTargetFragment();
        if (!(targetFragment instanceof androidx.preference.DialogPreference.a_renamed)) {
            throw new java.lang.IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        androidx.preference.DialogPreference.a_renamed aVar = (androidx.preference.DialogPreference.a_renamed) targetFragment;
        java.lang.String string = getArguments().getString("key");
        if (bundle == null) {
            this.f1343a = (androidx.preference.DialogPreference) aVar.a_renamed(string);
            this.f1344b = this.f1343a.a_renamed();
            this.f1345c = this.f1343a.d_renamed();
            this.d_renamed = this.f1343a.e_renamed();
            this.e_renamed = this.f1343a.b_renamed();
            this.f_renamed = this.f1343a.f_renamed();
            android.graphics.drawable.Drawable drawableC = this.f1343a.c_renamed();
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
        this.f1344b = bundle.getCharSequence("PreferenceDialogFragment.title");
        this.f1345c = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
        this.d_renamed = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
        this.e_renamed = bundle.getCharSequence("PreferenceDialogFragment.message");
        this.f_renamed = bundle.getInt("PreferenceDialogFragment.layout", 0);
        android.graphics.Bitmap bitmap = (android.graphics.Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
        if (bitmap != null) {
            this.g_renamed = new android.graphics.drawable.BitmapDrawable(getResources(), bitmap);
        }
    }

    @Override // androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f1344b);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f1345c);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.d_renamed);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.e_renamed);
        bundle.putInt("PreferenceDialogFragment.layout", this.f_renamed);
        android.graphics.drawable.BitmapDrawable bitmapDrawable = this.g_renamed;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    @Override // androidx.fragment.app.b_renamed
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        androidx.fragment.app.c_renamed activity = getActivity();
        this.h_renamed = -2;
        androidx.appcompat.app.b_renamed.a_renamed negativeButton = new androidx.appcompat.app.b_renamed.a_renamed(activity).setTitle(this.f1344b).setIcon(this.g_renamed).setPositiveButton(this.f1345c, this).setNegativeButton(this.d_renamed, this);
        android.view.View viewA = a_renamed(activity);
        if (viewA != null) {
            a_renamed(viewA);
            negativeButton.setView(viewA);
        } else {
            negativeButton.setMessage(this.e_renamed);
        }
        a_renamed(negativeButton);
        androidx.appcompat.app.b_renamed bVarCreate = negativeButton.create();
        if (a_renamed()) {
            a_renamed(bVarCreate);
        }
        return bVarCreate;
    }

    public androidx.preference.DialogPreference b_renamed() {
        if (this.f1343a == null) {
            this.f1343a = (androidx.preference.DialogPreference) ((androidx.preference.DialogPreference.a_renamed) getTargetFragment()).a_renamed(getArguments().getString("key"));
        }
        return this.f1343a;
    }

    private void a_renamed(android.app.Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    protected android.view.View a_renamed(android.content.Context context) {
        int i_renamed = this.f_renamed;
        if (i_renamed == 0) {
            return null;
        }
        return android.view.LayoutInflater.from(context).inflate(i_renamed, (android.view.ViewGroup) null);
    }

    protected void a_renamed(android.view.View view) {
        android.view.View viewFindViewById = view.findViewById(android.R_renamed.id_renamed.message);
        if (viewFindViewById != null) {
            java.lang.CharSequence charSequence = this.e_renamed;
            int i_renamed = 8;
            if (!android.text.TextUtils.isEmpty(charSequence)) {
                if (viewFindViewById instanceof android.widget.TextView) {
                    ((android.widget.TextView) viewFindViewById).setText(charSequence);
                }
                i_renamed = 0;
            }
            if (viewFindViewById.getVisibility() != i_renamed) {
                viewFindViewById.setVisibility(i_renamed);
            }
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
        this.h_renamed = i_renamed;
    }

    @Override // androidx.fragment.app.b_renamed, android.content.DialogInterface.OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        a_renamed(this.h_renamed == -1);
    }
}
