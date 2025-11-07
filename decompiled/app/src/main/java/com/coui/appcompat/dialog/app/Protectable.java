package com.coui.appcompat.dialog.app;

/* compiled from: COUIRotatingSpinnerDialog.java */
/* loaded from: classes.dex */
public class c_renamed extends com.coui.appcompat.dialog.app.d_renamed {
    private boolean i_renamed;
    private android.content.DialogInterface.OnCancelListener j_renamed;
    private android.widget.LinearLayout k_renamed;
    private com.oplus.anim.EffectiveAnimationView l_renamed;
    private android.view.ViewGroup m_renamed;
    private android.widget.TextView n_renamed;
    private boolean o_renamed;

    public c_renamed(android.content.Context context) {
        super(context);
        this.i_renamed = false;
        this.o_renamed = true;
    }

    @Override // com.coui.appcompat.dialog.app.d_renamed, com.coui.appcompat.dialog.app.b_renamed, androidx.appcompat.app.b_renamed, androidx.appcompat.app.f_renamed, android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        android.view.View viewInflate = android.view.LayoutInflater.from(getContext()).inflate(coui.support.appcompat.R_renamed.layout.coui_progress_dialog_rotating, (android.view.ViewGroup) null);
        this.k_renamed = (android.widget.LinearLayout) viewInflate.findViewById(coui.support.appcompat.R_renamed.id_renamed.body);
        this.l_renamed = (com.oplus.anim.EffectiveAnimationView) viewInflate.findViewById(coui.support.appcompat.R_renamed.id_renamed.progress);
        android.content.res.Resources resources = getContext().getResources();
        if (this.i_renamed) {
            this.k_renamed.setPadding(0, resources.getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_loading_dialog_padding_top), 0, resources.getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_loading_cancelable_dialog_padding_bottom));
        } else {
            this.k_renamed.setPadding(0, resources.getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_loading_dialog_padding_top), 0, resources.getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_loading_dialog_padding_bottom));
        }
        a_renamed(viewInflate);
        if (this.i_renamed) {
            a_renamed(-1, getContext().getString(android.R_renamed.string.cancel), new android.content.DialogInterface.OnClickListener() { // from class: com.coui.appcompat.dialog.app.c_renamed.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                    if (com.coui.appcompat.dialog.app.c_renamed.this.j_renamed != null) {
                        com.coui.appcompat.dialog.app.c_renamed.this.j_renamed.onCancel(dialogInterface);
                    }
                }
            });
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.m_renamed == null) {
            this.m_renamed = (android.view.ViewGroup) findViewById(coui.support.appcompat.R_renamed.id_renamed.parentPanel);
        }
        android.view.ViewGroup viewGroup = this.m_renamed;
        if (viewGroup != null) {
            android.view.ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            layoutParams.width = -2;
            this.m_renamed.setLayoutParams(layoutParams);
            this.m_renamed.setMinimumWidth(getContext().getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_loading_dialog_min_width) + this.m_renamed.getPaddingLeft() + this.m_renamed.getPaddingRight());
            this.m_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.coui.appcompat.dialog.app.c_renamed.2
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                }
            });
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) this.m_renamed.getParent();
            if (frameLayout != null) {
                frameLayout.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.coui.appcompat.dialog.app.c_renamed.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(android.view.View view) {
                        if (com.coui.appcompat.dialog.app.c_renamed.this.o_renamed && com.coui.appcompat.dialog.app.c_renamed.this.isShowing()) {
                            com.coui.appcompat.dialog.app.c_renamed.this.dismiss();
                        }
                    }
                });
            }
        }
        if (this.n_renamed == null) {
            this.n_renamed = (android.widget.TextView) findViewById(coui.support.appcompat.R_renamed.id_renamed.alertTitle);
        }
        android.widget.TextView textView = this.n_renamed;
        if (textView != null) {
            textView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.coui.appcompat.dialog.app.c_renamed.4
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                }
            });
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        android.view.ViewGroup viewGroup = this.m_renamed;
        if (viewGroup != null && this.i_renamed) {
            viewGroup.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() { // from class: com.coui.appcompat.dialog.app.c_renamed.5
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    android.view.ViewGroup.LayoutParams layoutParams;
                    com.coui.appcompat.dialog.app.c_renamed.this.m_renamed.getViewTreeObserver().removeOnPreDrawListener(this);
                    android.view.View viewFindViewById = com.coui.appcompat.dialog.app.c_renamed.this.m_renamed.findViewById(coui.support.appcompat.R_renamed.id_renamed.customPanel);
                    android.view.View viewFindViewById2 = com.coui.appcompat.dialog.app.c_renamed.this.m_renamed.findViewById(coui.support.appcompat.R_renamed.id_renamed.custom);
                    if (viewFindViewById == null || viewFindViewById2 == null || (layoutParams = viewFindViewById.getLayoutParams()) == null || layoutParams.height != -2) {
                        return false;
                    }
                    layoutParams.height = viewFindViewById2.getHeight();
                    viewFindViewById.setLayoutParams(layoutParams);
                    return false;
                }
            });
        }
        com.oplus.anim.EffectiveAnimationView effectiveAnimationView = this.l_renamed;
        if (effectiveAnimationView != null) {
            effectiveAnimationView.b_renamed();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.oplus.anim.EffectiveAnimationView effectiveAnimationView = this.l_renamed;
        if (effectiveAnimationView != null) {
            effectiveAnimationView.e_renamed();
        }
    }

    @Override // com.coui.appcompat.dialog.app.b_renamed, android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z_renamed) {
        super.setCanceledOnTouchOutside(z_renamed);
        this.o_renamed = z_renamed;
    }
}
