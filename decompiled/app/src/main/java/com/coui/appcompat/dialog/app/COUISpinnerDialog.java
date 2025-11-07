package com.coui.appcompat.dialog.app;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/* compiled from: COUISpinnerDialog.java */
/* renamed from: com.coui.appcompat.dialog.app.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class COUISpinnerDialog extends COUIAlertDialog {

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected View f6577c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected TextView f6578d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected int f6579e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected int f6580f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected CharSequence f6581g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected boolean f6582h;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6604b(int OplusGLSurfaceView_13) {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6605c(int OplusGLSurfaceView_13) {
    }

    public COUISpinnerDialog(Context context) {
        super(context);
    }

    @Override // com.coui.appcompat.dialog.app.COUIAlertDialog, androidx.appcompat.app.AlertDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException, ClassNotFoundException {
        int OplusGLSurfaceView_13 = this.f6579e;
        if (OplusGLSurfaceView_13 > 0) {
            m6605c(OplusGLSurfaceView_13);
        }
        int i2 = this.f6580f;
        if (i2 > 0) {
            m6604b(i2);
        }
        CharSequence charSequence = this.f6581g;
        if (charSequence != null) {
            mo905a(charSequence);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.f6582h = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.f6582h = false;
    }

    @Override // com.coui.appcompat.dialog.app.COUIAlertDialog, androidx.appcompat.app.AlertDialog
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo905a(CharSequence charSequence) {
        if (this.f6577c != null) {
            this.f6578d.setText(charSequence);
        } else {
            this.f6581g = charSequence;
        }
    }
}
