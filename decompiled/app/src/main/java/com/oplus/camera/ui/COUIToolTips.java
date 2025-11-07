package com.oplus.camera.ui;

/* compiled from: PageGuideDialogFragment.java */
/* loaded from: classes2.dex */
public class s_renamed extends androidx.fragment.app.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.view.View f7172a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.DialogInterface.OnShowListener f7173b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.DialogInterface.OnDismissListener f7174c;
    private com.oplus.camera.ui.s_renamed.a_renamed d_renamed = null;
    private com.oplus.camera.ui.CameraUIListener e_renamed;

    /* compiled from: PageGuideDialogFragment.java */
    public interface a_renamed {
        void onGuideDialogShowAction();
    }

    public s_renamed(android.view.View view, com.oplus.camera.ui.CameraUIListener cameraUIListener) {
        this.f7172a = null;
        this.e_renamed = null;
        this.f7172a = view;
        this.e_renamed = cameraUIListener;
    }

    @Override // androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onStart() {
        android.app.Dialog dialog;
        android.view.Window window;
        super.onStart();
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.e_renamed;
        if (cameraUIListener == null) {
            return;
        }
        if ((3 != cameraUIListener.ca_renamed() && 4 != this.e_renamed.ca_renamed()) || (dialog = getDialog()) == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(com.oplus.camera.util.Util.getScreenWidth() / 2, -1);
    }

    @Override // androidx.fragment.app.b_renamed
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        com.oplus.camera.e_renamed.b_renamed("PageGuideDialogFragment", "onCreateDialog");
        androidx.fragment.app.c_renamed activity = getActivity();
        if (activity == null) {
            return null;
        }
        androidx.appcompat.app.f_renamed fVar = new androidx.appcompat.app.f_renamed(activity, com.oplus.camera.R_renamed.style.PageGuideTheme);
        final android.view.Window window = fVar.getWindow();
        if (window != null) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.windowAnimations = com.oplus.camera.R_renamed.style.PageGuideAnimation;
            com.oplus.camera.ui.CameraUIListener cameraUIListener = this.e_renamed;
            if (cameraUIListener != null && 3 == cameraUIListener.ca_renamed()) {
                if (this.e_renamed.G_renamed() == 0) {
                    attributes.gravity = 5;
                } else {
                    attributes.gravity = 3;
                }
                attributes.flags = 32;
            } else {
                com.oplus.camera.ui.CameraUIListener cameraUIListener2 = this.e_renamed;
                if (cameraUIListener2 != null && 4 == cameraUIListener2.ca_renamed()) {
                    if (this.e_renamed.bL_renamed().k_renamed() == 90) {
                        attributes.gravity = 3;
                    } else {
                        attributes.gravity = 5;
                    }
                    attributes.flags = 32;
                }
            }
            window.setAttributes(attributes);
            fVar.setOnShowListener(new android.content.DialogInterface.OnShowListener() { // from class: com.oplus.camera.ui.s_renamed.1
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(android.content.DialogInterface dialogInterface) {
                    window.clearFlags(8);
                    com.oplus.camera.ui.s_renamed.this.a_renamed(window);
                    if (com.oplus.camera.ui.s_renamed.this.f7173b != null) {
                        com.oplus.camera.ui.s_renamed.this.f7173b.onShow(dialogInterface);
                    }
                }
            });
        }
        com.oplus.camera.ui.s_renamed.a_renamed aVar = this.d_renamed;
        if (aVar != null) {
            aVar.onGuideDialogShowAction();
        }
        this.f7172a.setForceDarkAllowed(true);
        fVar.setContentView(this.f7172a);
        return fVar;
    }

    @Override // androidx.fragment.app.b_renamed, androidx.fragment.app.Fragment
    public void onDestroyView() {
        android.view.ViewGroup viewGroup;
        super.onDestroyView();
        android.view.View view = this.f7172a;
        if (view == null || (viewGroup = (android.view.ViewGroup) view.getParent()) == null) {
            return;
        }
        viewGroup.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.view.Window window) {
        window.setFlags(1024, 1024);
        if (30 < android.os.Build.VERSION.SDK_INT && com.oplus.camera.util.Util.ab_renamed()) {
            window.getDecorView().setSystemUiVisibility(5892);
            window.setNavigationBarContrastEnforced(false);
            window.setNavigationBarColor(0);
            return;
        }
        window.getDecorView().setSystemUiVisibility(2566);
    }

    public android.view.View a_renamed() {
        return this.f7172a;
    }

    public boolean b_renamed() {
        android.app.Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public void a_renamed(com.oplus.camera.ui.s_renamed.a_renamed aVar) {
        this.d_renamed = aVar;
    }

    public void a_renamed(android.content.DialogInterface.OnShowListener onShowListener) {
        this.f7173b = onShowListener;
    }

    public void a_renamed(android.content.DialogInterface.OnDismissListener onDismissListener) {
        this.f7174c = onDismissListener;
    }

    @Override // androidx.fragment.app.b_renamed, android.content.DialogInterface.OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        android.content.DialogInterface.OnDismissListener onDismissListener = this.f7174c;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}
