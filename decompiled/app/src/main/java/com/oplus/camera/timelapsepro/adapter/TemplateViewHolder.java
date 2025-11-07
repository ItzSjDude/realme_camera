package com.oplus.camera.timelapsepro.adapter;

/* loaded from: classes2.dex */
public class TemplateViewHolder extends com.oplus.camera.timelapsepro.adapter.BaseViewHolder {
    final android.widget.ImageView mIcon;
    final android.widget.RelativeLayout mIconBg;
    final android.widget.ImageView mIconSelect;
    private final com.a_renamed.a_renamed.f_renamed mItemSpring;
    final android.widget.TextView mName;

    public TemplateViewHolder(android.view.View view) {
        super(view);
        this.mItemSpring = com.oplus.camera.professional.u_renamed.a_renamed();
        this.mIconSelect = (android.widget.ImageView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.icon_select);
        this.mIconBg = (android.widget.RelativeLayout) view.findViewById(com.oplus.camera.R_renamed.id_renamed.icon_bg);
        this.mIcon = (android.widget.ImageView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.icon);
        this.mName = (android.widget.TextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.name);
    }

    public void setImageSource(int i_renamed) {
        this.mIconBg.setBackgroundResource(i_renamed);
    }

    public void setSelected(boolean z_renamed, boolean z2) {
        com.oplus.camera.util.Util.a_renamed(this.mIconSelect, z_renamed ? 0 : 4, (android.view.animation.Animation.AnimationListener) null, z_renamed ? 280L : 150L, 0L, com.oplus.camera.professional.t_renamed.f5227a);
        this.mIcon.setVisibility(z2 ? 0 : 8);
    }

    public void setName(java.lang.String str) {
        this.mName.setText(str);
    }

    public void setItemTouchListener() {
        this.itemView.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.timelapsepro.adapter.-$$Lambda$TemplateViewHolder$Uq1A-dO7RWc2lyUEqwjUZkw_UUA
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                return this.f_renamed$0.lambda$setItemTouchListener$0$TemplateViewHolder(view, motionEvent);
            }
        });
    }

    public /* synthetic */ boolean lambda$setItemTouchListener$0$TemplateViewHolder(android.view.View view, android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) this.mIconSelect, this.mItemSpring, true);
            com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) this.mIconBg, this.mItemSpring, true);
        } else if (action == 1 || action == 3) {
            com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) this.mIconSelect, this.mItemSpring, false);
            com.oplus.camera.professional.u_renamed.a_renamed((android.view.View) this.mIconBg, this.mItemSpring, false);
        }
        return false;
    }
}
