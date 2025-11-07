package androidx.fragment.app;

/* compiled from: DialogFragment.java */
/* loaded from: classes.dex */
public class b_renamed extends androidx.fragment.app.Fragment implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnDismissListener {
    private static final java.lang.String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final java.lang.String SAVED_CANCELABLE = "android:cancelable";
    private static final java.lang.String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final java.lang.String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final java.lang.String SAVED_STYLE = "android:style";
    private static final java.lang.String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    android.app.Dialog mDialog;
    boolean mDismissed;
    private android.os.Handler mHandler;
    boolean mShownByMe;
    boolean mViewDestroyed;
    private java.lang.Runnable mDismissRunnable = new java.lang.Runnable() { // from class: androidx.fragment.app.b_renamed.1
        @Override // java.lang.Runnable
        public void run() {
            if (androidx.fragment.app.b_renamed.this.mDialog != null) {
                androidx.fragment.app.b_renamed bVar = androidx.fragment.app.b_renamed.this;
                bVar.onDismiss(bVar.mDialog);
            }
        }
    };
    int mStyle = 0;
    int mTheme = 0;
    boolean mCancelable = true;
    boolean mShowsDialog = true;
    int mBackStackId = -1;

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(android.content.DialogInterface dialogInterface) {
    }

    public void setStyle(int i_renamed, int i2) {
        this.mStyle = i_renamed;
        int i3 = this.mStyle;
        if (i3 == 2 || i3 == 3) {
            this.mTheme = android.R_renamed.style.Theme.Panel;
        }
        if (i2 != 0) {
            this.mTheme = i2;
        }
    }

    public void show(androidx.fragment.app.h_renamed hVar, java.lang.String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        androidx.fragment.app.k_renamed kVarA = hVar.a_renamed();
        kVarA.a_renamed(this, str);
        kVarA.b_renamed();
    }

    public int show(androidx.fragment.app.k_renamed kVar, java.lang.String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        kVar.a_renamed(this, str);
        this.mViewDestroyed = false;
        this.mBackStackId = kVar.b_renamed();
        return this.mBackStackId;
    }

    public void showNow(androidx.fragment.app.h_renamed hVar, java.lang.String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        androidx.fragment.app.k_renamed kVarA = hVar.a_renamed();
        kVarA.a_renamed(this, str);
        kVarA.d_renamed();
    }

    public void dismiss() {
        dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false);
    }

    void dismissInternal(boolean z_renamed, boolean z2) {
        if (this.mDismissed) {
            return;
        }
        this.mDismissed = true;
        this.mShownByMe = false;
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!z2) {
                if (android.os.Looper.myLooper() == this.mHandler.getLooper()) {
                    onDismiss(this.mDialog);
                } else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }
        this.mViewDestroyed = true;
        if (this.mBackStackId >= 0) {
            requireFragmentManager().a_renamed(this.mBackStackId, 1);
            this.mBackStackId = -1;
            return;
        }
        androidx.fragment.app.k_renamed kVarA = requireFragmentManager().a_renamed();
        kVarA.a_renamed(this);
        if (z_renamed) {
            kVarA.c_renamed();
        } else {
            kVarA.b_renamed();
        }
    }

    public android.app.Dialog getDialog() {
        return this.mDialog;
    }

    public final android.app.Dialog requireDialog() {
        android.app.Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new java.lang.IllegalStateException("DialogFragment " + this + " does not have a_renamed Dialog.");
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void setCancelable(boolean z_renamed) {
        this.mCancelable = z_renamed;
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z_renamed);
        }
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    public void setShowsDialog(boolean z_renamed) {
        this.mShowsDialog = z_renamed;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(android.content.Context context) {
        super.onAttach(context);
        if (this.mShownByMe) {
            return;
        }
        this.mDismissed = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.mShownByMe || this.mDismissed) {
            return;
        }
        this.mDismissed = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new android.os.Handler();
        this.mShowsDialog = this.mContainerId == 0;
        if (bundle != null) {
            this.mStyle = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = bundle.getInt(SAVED_THEME, 0);
            this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
            this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public android.view.LayoutInflater onGetLayoutInflater(android.os.Bundle bundle) {
        if (!this.mShowsDialog) {
            return super.onGetLayoutInflater(bundle);
        }
        this.mDialog = onCreateDialog(bundle);
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null) {
            setupDialog(dialog, this.mStyle);
            return (android.view.LayoutInflater) this.mDialog.getContext().getSystemService("layout_inflater");
        }
        return (android.view.LayoutInflater) this.mHost.j_renamed().getSystemService("layout_inflater");
    }

    public void setupDialog(android.app.Dialog dialog, int i_renamed) {
        if (i_renamed != 1 && i_renamed != 2) {
            if (i_renamed != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        return new android.app.Dialog(requireContext(), getTheme());
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        if (this.mViewDestroyed) {
            return;
        }
        dismissInternal(true, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(android.os.Bundle bundle) {
        android.os.Bundle bundle2;
        super.onActivityCreated(bundle);
        if (this.mShowsDialog) {
            android.view.View view = getView();
            if (view != null) {
                if (view.getParent() != null) {
                    throw new java.lang.IllegalStateException("DialogFragment can not be_renamed attached to a_renamed container view");
                }
                this.mDialog.setContentView(view);
            }
            androidx.fragment.app.c_renamed activity = getActivity();
            if (activity != null) {
                this.mDialog.setOwnerActivity(activity);
            }
            this.mDialog.setCancelable(this.mCancelable);
            this.mDialog.setOnCancelListener(this);
            this.mDialog.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) == null) {
                return;
            }
            this.mDialog.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        android.os.Bundle bundleOnSaveInstanceState;
        super.onSaveInstanceState(bundle);
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null && (bundleOnSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, bundleOnSaveInstanceState);
        }
        int i_renamed = this.mStyle;
        if (i_renamed != 0) {
            bundle.putInt(SAVED_STYLE, i_renamed);
        }
        int i2 = this.mTheme;
        if (i2 != 0) {
            bundle.putInt(SAVED_THEME, i2);
        }
        boolean z_renamed = this.mCancelable;
        if (!z_renamed) {
            bundle.putBoolean(SAVED_CANCELABLE, z_renamed);
        }
        boolean z2 = this.mShowsDialog;
        if (!z2) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, z2);
        }
        int i3 = this.mBackStackId;
        if (i3 != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        android.app.Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
        }
    }
}
