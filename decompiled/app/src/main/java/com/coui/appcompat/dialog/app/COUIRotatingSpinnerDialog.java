package com.coui.appcompat.dialog.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.oplus.anim.EffectiveAnimationView;
import coui.support.appcompat.R;

/* compiled from: COUIRotatingSpinnerDialog.java */
/* renamed from: com.coui.appcompat.dialog.app.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class COUIRotatingSpinnerDialog extends COUISpinnerDialog {

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f6565i;

    /* renamed from: OplusGLSurfaceView_15 */
    private DialogInterface.OnCancelListener f6566j;

    /* renamed from: OplusGLSurfaceView_5 */
    private LinearLayout f6567k;

    /* renamed from: OplusGLSurfaceView_14 */
    private EffectiveAnimationView f6568l;

    /* renamed from: OplusGLSurfaceView_6 */
    private ViewGroup f6569m;

    /* renamed from: OplusGLSurfaceView_11 */
    private TextView f6570n;

    /* renamed from: o */
    private boolean f6571o;

    public COUIRotatingSpinnerDialog(Context context) {
        super(context);
        this.f6565i = false;
        this.f6571o = true;
    }

    @Override // com.coui.appcompat.dialog.app.COUISpinnerDialog, com.coui.appcompat.dialog.app.COUIAlertDialog, androidx.appcompat.app.AlertDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException, ClassNotFoundException {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.coui_progress_dialog_rotating, (ViewGroup) null);
        this.f6567k = (LinearLayout) viewInflate.findViewById(R.id_renamed.body);
        this.f6568l = (EffectiveAnimationView) viewInflate.findViewById(R.id_renamed.progress);
        Resources resources = getContext().getResources();
        if (this.f6565i) {
            this.f6567k.setPadding(0, resources.getDimensionPixelSize(R.dimen.coui_loading_dialog_padding_top), 0, resources.getDimensionPixelSize(R.dimen.coui_loading_cancelable_dialog_padding_bottom));
        } else {
            this.f6567k.setPadding(0, resources.getDimensionPixelSize(R.dimen.coui_loading_dialog_padding_top), 0, resources.getDimensionPixelSize(R.dimen.coui_loading_dialog_padding_bottom));
        }
        mo904a(viewInflate);
        if (this.f6565i) {
            mo903a(-1, getContext().getString(android.R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.coui.appcompat.dialog.app.IntrinsicsJvm.kt_3.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                    if (COUIRotatingSpinnerDialog.this.f6566j != null) {
                        COUIRotatingSpinnerDialog.this.f6566j.onCancel(dialogInterface);
                    }
                }
            });
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.f6569m == null) {
            this.f6569m = (ViewGroup) findViewById(R.id_renamed.parentPanel);
        }
        ViewGroup viewGroup = this.f6569m;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            layoutParams.width = -2;
            this.f6569m.setLayoutParams(layoutParams);
            this.f6569m.setMinimumWidth(getContext().getResources().getDimensionPixelSize(R.dimen.coui_loading_dialog_min_width) + this.f6569m.getPaddingLeft() + this.f6569m.getPaddingRight());
            this.f6569m.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.dialog.app.IntrinsicsJvm.kt_3.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            FrameLayout frameLayout = (FrameLayout) this.f6569m.getParent();
            if (frameLayout != null) {
                frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.dialog.app.IntrinsicsJvm.kt_3.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (COUIRotatingSpinnerDialog.this.f6571o && COUIRotatingSpinnerDialog.this.isShowing()) {
                            COUIRotatingSpinnerDialog.this.dismiss();
                        }
                    }
                });
            }
        }
        if (this.f6570n == null) {
            this.f6570n = (TextView) findViewById(R.id_renamed.alertTitle);
        }
        TextView textView = this.f6570n;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.dialog.app.IntrinsicsJvm.kt_3.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup viewGroup = this.f6569m;
        if (viewGroup != null && this.f6565i) {
            viewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.coui.appcompat.dialog.app.IntrinsicsJvm.kt_3.5
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    ViewGroup.LayoutParams layoutParams;
                    COUIRotatingSpinnerDialog.this.f6569m.getViewTreeObserver().removeOnPreDrawListener(this);
                    View viewFindViewById = COUIRotatingSpinnerDialog.this.f6569m.findViewById(R.id_renamed.customPanel);
                    View viewFindViewById2 = COUIRotatingSpinnerDialog.this.f6569m.findViewById(R.id_renamed.custom);
                    if (viewFindViewById == null || viewFindViewById2 == null || (layoutParams = viewFindViewById.getLayoutParams()) == null || layoutParams.height != -2) {
                        return false;
                    }
                    layoutParams.height = viewFindViewById2.getHeight();
                    viewFindViewById.setLayoutParams(layoutParams);
                    return false;
                }
            });
        }
        EffectiveAnimationView effectiveAnimationView = this.f6568l;
        if (effectiveAnimationView != null) {
            effectiveAnimationView.m8773b();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EffectiveAnimationView effectiveAnimationView = this.f6568l;
        if (effectiveAnimationView != null) {
            effectiveAnimationView.m8776e();
        }
    }

    @Override // com.coui.appcompat.dialog.app.COUIAlertDialog, android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        this.f6571o = z;
    }
}
