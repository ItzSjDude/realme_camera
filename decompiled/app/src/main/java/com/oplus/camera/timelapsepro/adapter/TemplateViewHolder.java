package com.oplus.camera.timelapsepro.adapter;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oplus.camera.R;
import com.oplus.camera.professional.ProfessionalAnimConstant;
import com.oplus.camera.professional.ProfessionalAnimUtil;
import com.oplus.camera.util.Util;
import com.p078a.p079a.Spring;

/* loaded from: classes2.dex */
public class TemplateViewHolder extends BaseViewHolder {
    final ImageView mIcon;
    final RelativeLayout mIconBg;
    final ImageView mIconSelect;
    private final Spring mItemSpring;
    final TextView mName;

    public TemplateViewHolder(View view) {
        super(view);
        this.mItemSpring = ProfessionalAnimUtil.m15923a();
        this.mIconSelect = (ImageView) view.findViewById(R.id_renamed.icon_select);
        this.mIconBg = (RelativeLayout) view.findViewById(R.id_renamed.icon_bg);
        this.mIcon = (ImageView) view.findViewById(R.id_renamed.icon);
        this.mName = (TextView) view.findViewById(R.id_renamed.name);
    }

    public void setImageSource(int OplusGLSurfaceView_13) {
        this.mIconBg.setBackgroundResource(OplusGLSurfaceView_13);
    }

    public void setSelected(boolean z, boolean z2) {
        Util.m24271a(this.mIconSelect, z ? 0 : 4, (Animation.AnimationListener) null, z ? 280L : 150L, 0L, ProfessionalAnimConstant.f15694a);
        this.mIcon.setVisibility(z2 ? 0 : 8);
    }

    public void setName(String str) {
        this.mName.setText(str);
    }

    public void setItemTouchListener() {
        this.itemView.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.timelapsepro.adapter.-$$Lambda$TemplateViewHolder$Uq1A-dO7RWc2lyUEqwjUZkw_UUA
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.COUIBaseListPopupWindow_12$0.lambda$setItemTouchListener$0$TemplateViewHolder(view, motionEvent);
            }
        });
    }

    public /* synthetic */ boolean lambda$setItemTouchListener$0$TemplateViewHolder(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            ProfessionalAnimUtil.m15924a((View) this.mIconSelect, this.mItemSpring, true);
            ProfessionalAnimUtil.m15924a((View) this.mIconBg, this.mItemSpring, true);
        } else if (action == 1 || action == 3) {
            ProfessionalAnimUtil.m15924a((View) this.mIconSelect, this.mItemSpring, false);
            ProfessionalAnimUtil.m15924a((View) this.mIconBg, this.mItemSpring, false);
        }
        return false;
    }
}
