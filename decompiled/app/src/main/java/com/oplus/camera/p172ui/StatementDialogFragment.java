package com.oplus.camera.p172ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.DialogFragment;
import com.coui.appcompat.widget.COUIFullPageStatement;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: StatementDialogFragment.java */
/* renamed from: com.oplus.camera.ui.v */
/* loaded from: classes2.dex */
public class StatementDialogFragment extends DialogFragment {

    /* renamed from: PlatformImplementations.kt_3 */
    private COUIFullPageStatement f22508a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PlatformImplementations.kt_3 f22509b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f22510c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f22511d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String f22512e;

    /* compiled from: StatementDialogFragment.java */
    /* renamed from: com.oplus.camera.ui.v$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo14362a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo14363b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo14364c();
    }

    public StatementDialogFragment() {
    }

    public StatementDialogFragment(String str) {
        this.f22510c = str;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        CameraLog.m12967f("StatementDialogFragment", "onCreateDialog");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return null;
        }
        AppCompatDialog dialogC0208f = new AppCompatDialog(activity, R.style.StatementAndGuideTheme);
        dialogC0208f.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.oplus.camera.ui.v.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
                if (OplusGLSurfaceView_13 != 4) {
                    return false;
                }
                FragmentActivity activity2 = StatementDialogFragment.this.getActivity();
                if (activity2 == null) {
                    return true;
                }
                activity2.finish();
                return true;
            }
        });
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.statement_dialog_layout, (ViewGroup) null);
        this.f22508a = (COUIFullPageStatement) viewInflate.findViewById(R.id_renamed.full_statement_page);
        if (Util.m24498u()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f22508a.getLayoutParams();
            layoutParams.width = Util.m24194V();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.full_page_statement_margin_bottom);
            layoutParams.addRule(14);
            this.f22508a.setLayoutParams(layoutParams);
            this.f22508a.setBackgroundResource(R.drawable.folder_statement_page_bg);
        } else {
            this.f22508a.setBackgroundResource(R.drawable.statement_page_bg);
        }
        m23920c();
        PlatformImplementations.kt_3 aVar = this.f22509b;
        if (aVar != null) {
            aVar.mo14362a();
        }
        viewInflate.setForceDarkAllowed(true);
        dialogC0208f.supportRequestWindowFeature(1);
        dialogC0208f.getWindow().getDecorView().setBackgroundColor(0);
        if (30 < Build.VERSION.SDK_INT && Util.m24339ab()) {
            dialogC0208f.getWindow().getDecorView().setSystemUiVisibility(5892);
            dialogC0208f.getWindow().setNavigationBarContrastEnforced(false);
            dialogC0208f.getWindow().setNavigationBarColor(0);
        } else {
            dialogC0208f.getWindow().getDecorView().setSystemUiVisibility(5124);
            dialogC0208f.getWindow().setNavigationBarColor(getContext().getColor(R.color.full_page_statement_bg_color));
        }
        dialogC0208f.setContentView(viewInflate);
        setShowsDialog(false);
        return dialogC0208f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23916a(String str) {
        this.f22511d = str;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23919b(String str) {
        this.f22512e = str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m23917a() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public COUIFullPageStatement m23918b() {
        return this.f22508a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23915a(PlatformImplementations.kt_3 aVar) {
        this.f22509b = aVar;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23920c() {
        if (this.f22508a == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.f22510c)) {
            this.f22508a.setTitleText(this.f22510c);
        }
        if (!TextUtils.isEmpty(this.f22511d)) {
            this.f22508a.setExitButtonText(this.f22511d);
        }
        if (TextUtils.isEmpty(this.f22512e)) {
            return;
        }
        this.f22508a.setButtonText(this.f22512e);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PlatformImplementations.kt_3 aVar = this.f22509b;
        if (aVar != null) {
            aVar.mo14364c();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        PlatformImplementations.kt_3 aVar = this.f22509b;
        if (aVar != null) {
            aVar.mo14363b();
        }
    }
}
