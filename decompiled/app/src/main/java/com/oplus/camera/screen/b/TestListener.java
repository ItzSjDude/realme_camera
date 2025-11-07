package com.oplus.camera.screen.b_renamed;

/* compiled from: FullScreenModeRotate.java */
/* loaded from: classes2.dex */
public abstract class g_renamed extends com.oplus.camera.screen.b_renamed.c_renamed {
    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    public boolean a_renamed() {
        return false;
    }

    @Override // com.oplus.camera.screen.b_renamed.a_renamed
    public void a_renamed(com.oplus.camera.screen.ScreenRelativeLayout screenRelativeLayout) {
        this.f5361b = com.oplus.camera.screen.f_renamed.f5372b;
        this.f5362c = com.oplus.camera.screen.f_renamed.f5371a;
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) screenRelativeLayout.getLayoutParams();
        layoutParams.addRule(13);
        layoutParams.topMargin = (-(this.f5362c - this.f5361b)) / 2;
        layoutParams.bottomMargin = (-(this.f5362c - this.f5361b)) / 2;
        layoutParams.leftMargin = (this.f5362c - this.f5361b) / 2;
        layoutParams.rightMargin = (this.f5362c - this.f5361b) / 2;
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.a_renamed
    protected void a_renamed(android.app.Activity activity, com.oplus.camera.screen.c_renamed cVar) {
        super.a_renamed(activity, cVar);
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(android.app.Activity activity, boolean z_renamed, float f_renamed, float f2) {
        android.content.res.Resources resources = activity.getResources();
        return f2 <= ((float) (com.oplus.camera.screen.f_renamed.f5372b - (resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_right) + resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_length))));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(android.app.Activity activity, android.graphics.Rect rect) {
        android.content.res.Resources resources = activity.getResources();
        return ((float) rect.bottom) <= ((float) (com.oplus.camera.screen.f_renamed.f5372b - (resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_right) + resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_length))));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public boolean b_renamed(android.app.Activity activity, android.graphics.Rect rect) {
        android.content.res.Resources resources = activity.getResources();
        return ((float) rect.centerY()) >= ((float) (com.oplus.camera.screen.f_renamed.f5372b - (resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.control_panel_margin_right) + resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.shutter_button_length))));
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public com.oplus.camera.ui.RotableTextView a_renamed(android.app.Activity activity, android.widget.RelativeLayout relativeLayout, int i_renamed) {
        activity.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.burst_fold, relativeLayout);
        com.oplus.camera.ui.RotableTextView rotableTextView = (com.oplus.camera.ui.RotableTextView) activity.findViewById(com.oplus.camera.R_renamed.id_renamed.burst_num_view_fold);
        if (i_renamed == 0 || 1 == i_renamed) {
            rotableTextView.setBackground(activity.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.burst_num_bg_fold_white, null));
        } else {
            rotableTextView.setBackground(activity.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.burst_num_bg_fold_black, null));
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) rotableTextView.getLayoutParams();
        layoutParams.addRule(12);
        layoutParams.bottomMargin = activity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.fold_full_first_level_burst_num_view_margin_bottom_rotate);
        return rotableTextView;
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public void d_renamed(com.oplus.camera.screen.b_renamed.o_renamed.a_renamed aVar) {
        aVar.call(new java.lang.Object[0]);
    }

    @Override // com.oplus.camera.screen.b_renamed.o_renamed
    public boolean a_renamed(com.oplus.camera.ui.CameraUIInterface cameraUIInterface, int i_renamed, int i2) {
        return i2 > this.d_renamed && i2 < this.f5362c - this.d_renamed;
    }

    @Override // com.oplus.camera.screen.b_renamed.c_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    public int[] a_renamed(android.util.Size size, android.util.Size size2) {
        return new int[]{this.f5361b, (int) (this.f5361b / (size.getWidth() / size.getHeight())), this.f5361b, (int) (this.f5361b / (size2.getWidth() / size2.getHeight()))};
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:12:0x0048  */
    @Override // com.oplus.camera.screen.b_renamed.a_renamed, com.oplus.camera.screen.b_renamed.o_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b_renamed(android.app.Activity r8, int r9) {
        /*
            r7 = this;
            r7 = 2131296935(0x7f0902a7, float:1.82118E38)
            r0 = 2131297042(0x7f090312, float:1.8212018E38)
            r1 = 2131296418(0x7f0900a2, float:1.8210752E38)
            r2 = 2131296581(0x7f090145, float:1.8211083E38)
            r3 = 2131296616(0x7f090168, float:1.8211154E38)
            r4 = 0
            r5 = 1
            if (r9 == 0) goto L48
            if (r9 == r5) goto L2c
            r6 = 2
            if (r9 == r6) goto L48
            r5 = 6
            if (r9 == r5) goto L1c
            goto L57
        L1c:
            com.oplus.camera.util.Util.a_renamed(r8, r3, r4)
            com.oplus.camera.util.Util.a_renamed(r8, r2, r4)
            com.oplus.camera.util.Util.a_renamed(r8, r1, r4)
            com.oplus.camera.util.Util.a_renamed(r8, r0, r4)
            com.oplus.camera.util.Util.a_renamed(r8, r7, r4)
            goto L57
        L2c:
            com.oplus.camera.util.Util.a_renamed(r8, r3, r5)
            com.oplus.camera.util.Util.a_renamed(r8, r2, r5)
            com.oplus.camera.util.Util.a_renamed(r8, r1, r5)
            com.oplus.camera.util.Util.a_renamed(r8, r0, r5)
            com.oplus.camera.util.Util.a_renamed(r8, r7, r5)
            r7 = 2131297219(0x7f0903c3, float:1.8212377E38)
            com.oplus.camera.util.Util.a_renamed(r8, r7, r5)
            r7 = 2131297216(0x7f0903c0, float:1.821237E38)
            com.oplus.camera.util.Util.a_renamed(r8, r7, r5)
            goto L57
        L48:
            com.oplus.camera.util.Util.a_renamed(r8, r3, r4)
            com.oplus.camera.util.Util.a_renamed(r8, r2, r4)
            com.oplus.camera.util.Util.a_renamed(r8, r1, r4)
            com.oplus.camera.util.Util.a_renamed(r8, r0, r5)
            com.oplus.camera.util.Util.a_renamed(r8, r7, r5)
        L57:
            r7 = 2131297156(0x7f090384, float:1.8212249E38)
            r9 = 2131232319(0x7f08063f, float:1.8080744E38)
            com.oplus.camera.util.Util.a_renamed(r8, r7, r9)
            r7 = 2131296417(0x7f0900a1, float:1.821075E38)
            com.oplus.camera.util.Util.a_renamed(r8, r7, r9)
            r7 = 2131297305(0x7f090419, float:1.8212551E38)
            com.oplus.camera.util.Util.a_renamed(r8, r7, r9)
            r7 = 2131296999(0x7f0902e7, float:1.821193E38)
            com.oplus.camera.util.Util.a_renamed(r8, r7, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.screen.b_renamed.g_renamed.b_renamed(android.app.Activity, int):void");
    }
}
