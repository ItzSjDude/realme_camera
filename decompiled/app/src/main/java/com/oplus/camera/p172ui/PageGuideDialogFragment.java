package com.oplus.camera.p172ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.DialogFragment;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: PageGuideDialogFragment.java */
/* renamed from: com.oplus.camera.ui.s */
/* loaded from: classes2.dex */
public class PageGuideDialogFragment extends DialogFragment {

    /* renamed from: PlatformImplementations.kt_3 */
    private View f22487a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private DialogInterface.OnShowListener f22488b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private DialogInterface.OnDismissListener f22489c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PlatformImplementations.kt_3 f22490d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CameraUIListener f22491e;

    /* compiled from: PageGuideDialogFragment.java */
    /* renamed from: com.oplus.camera.ui.s$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        void onGuideDialogShowAction();
    }

    public PageGuideDialogFragment(View view, CameraUIListener cameraUIListener) {
        this.f22487a = null;
        this.f22491e = null;
        this.f22487a = view;
        this.f22491e = cameraUIListener;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Dialog dialog;
        Window window;
        super.onStart();
        CameraUIListener cameraUIListener = this.f22491e;
        if (cameraUIListener == null) {
            return;
        }
        if ((3 != cameraUIListener.mo10816ca() && 4 != this.f22491e.mo10816ca()) || (dialog = getDialog()) == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(Util.getScreenWidth() / 2, -1);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        CameraLog.m12959b("PageGuideDialogFragment", "onCreateDialog");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return null;
        }
        AppCompatDialog dialogC0208f = new AppCompatDialog(activity, R.style.PageGuideTheme);
        final Window window = dialogC0208f.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.windowAnimations = R.style.PageGuideAnimation;
            CameraUIListener cameraUIListener = this.f22491e;
            if (cameraUIListener != null && 3 == cameraUIListener.mo10816ca()) {
                if (this.f22491e.mo10653G() == 0) {
                    attributes.gravity = 5;
                } else {
                    attributes.gravity = 3;
                }
                attributes.flags = 32;
            } else {
                CameraUIListener cameraUIListener2 = this.f22491e;
                if (cameraUIListener2 != null && 4 == cameraUIListener2.mo10816ca()) {
                    if (this.f22491e.mo10769bL().mo16570k() == 90) {
                        attributes.gravity = 3;
                    } else {
                        attributes.gravity = 5;
                    }
                    attributes.flags = 32;
                }
            }
            window.setAttributes(attributes);
            dialogC0208f.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.oplus.camera.ui.s.1
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    window.clearFlags(8);
                    PageGuideDialogFragment.this.m23906a(window);
                    if (PageGuideDialogFragment.this.f22488b != null) {
                        PageGuideDialogFragment.this.f22488b.onShow(dialogInterface);
                    }
                }
            });
        }
        PlatformImplementations.kt_3 aVar = this.f22490d;
        if (aVar != null) {
            aVar.onGuideDialogShowAction();
        }
        this.f22487a.setForceDarkAllowed(true);
        dialogC0208f.setContentView(this.f22487a);
        return dialogC0208f;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ViewGroup viewGroup;
        super.onDestroyView();
        View view = this.f22487a;
        if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
            return;
        }
        viewGroup.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m23906a(Window window) {
        window.setFlags(1024, 1024);
        if (30 < Build.VERSION.SDK_INT && Util.m24339ab()) {
            window.getDecorView().setSystemUiVisibility(5892);
            window.setNavigationBarContrastEnforced(false);
            window.setNavigationBarColor(0);
            return;
        }
        window.getDecorView().setSystemUiVisibility(2566);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public View m23908a() {
        return this.f22487a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m23912b() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23911a(PlatformImplementations.kt_3 aVar) {
        this.f22490d = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23910a(DialogInterface.OnShowListener onShowListener) {
        this.f22488b = onShowListener;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23909a(DialogInterface.OnDismissListener onDismissListener) {
        this.f22489c = onDismissListener;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.f22489c;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}
