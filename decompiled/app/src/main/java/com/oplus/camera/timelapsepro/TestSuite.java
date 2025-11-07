package com.oplus.camera.timelapsepro;

/* compiled from: TimeLapseProRecordView.java */
/* loaded from: classes2.dex */
public class i_renamed extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f5722a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final int f5723b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f5724c;
    private final int d_renamed;
    private int e_renamed;
    private com.oplus.camera.ui.preview.CameraTimeView f_renamed;
    private com.oplus.camera.ui.preview.CameraTimeView g_renamed;
    private long h_renamed;

    public i_renamed(android.content.Context context) {
        this(context, null);
    }

    public i_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws android.content.res.Resources.NotFoundException {
        super(context, attributeSet, i_renamed);
        this.h_renamed = -1L;
        setLayoutDirection(0);
        this.f5722a = context;
        this.d_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_time_split_shadow_radius_size);
        this.f5723b = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_time_split_shadow_dx);
        this.f5724c = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.camera_time_split_shadow_dy);
        c_renamed();
    }

    private void c_renamed() throws android.content.res.Resources.NotFoundException {
        this.e_renamed = getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_record_time_margin_to_center);
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -2));
        f_renamed();
        e_renamed();
        d_renamed();
    }

    private void d_renamed() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = new com.oplus.camera.ui.menu.OplusTextView(this.f5722a);
        oplusTextView.setId(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_right_title);
        oplusTextView.setText(com.oplus.camera.R_renamed.string.video_time);
        oplusTextView.setTextSize(1, 12.0f);
        oplusTextView.setTextColor(androidx.core.a_renamed.a_renamed.c_renamed(this.f5722a, com.oplus.camera.R_renamed.color.camera_white));
        oplusTextView.setShadowLayer(this.d_renamed, this.f5723b, this.f5724c, androidx.core.a_renamed.a_renamed.c_renamed(this.f5722a, com.oplus.camera.R_renamed.color.camera_time_shadow_color));
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_middle_line);
        layoutParams.leftMargin = this.e_renamed;
        addView(oplusTextView, layoutParams);
        this.g_renamed = (com.oplus.camera.ui.preview.CameraTimeView) android.view.LayoutInflater.from(this.f5722a).inflate(com.oplus.camera.R_renamed.layout.time_lapse_pro_record_time, (android.view.ViewGroup) null);
        this.g_renamed.a_renamed();
        this.g_renamed.b_renamed();
        this.g_renamed.setNeedRelayout(false);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_right_title);
        layoutParams2.addRule(5, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_right_title);
        layoutParams2.topMargin = (int) getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_lapse_pro_record_time_margin_top);
        addView(this.g_renamed, layoutParams2);
    }

    private void e_renamed() throws android.content.res.Resources.NotFoundException {
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = new com.oplus.camera.ui.menu.OplusTextView(this.f5722a);
        oplusTextView.setId(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_left_title);
        oplusTextView.setText(com.oplus.camera.R_renamed.string.record_time);
        oplusTextView.setTextSize(1, 12.0f);
        oplusTextView.setTextColor(androidx.core.a_renamed.a_renamed.c_renamed(this.f5722a, com.oplus.camera.R_renamed.color.camera_white));
        oplusTextView.setShadowLayer(this.d_renamed, this.f5723b, this.f5724c, androidx.core.a_renamed.a_renamed.c_renamed(this.f5722a, com.oplus.camera.R_renamed.color.camera_time_shadow_color));
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_middle_line);
        layoutParams.rightMargin = this.e_renamed;
        addView(oplusTextView, layoutParams);
        this.f_renamed = (com.oplus.camera.ui.preview.CameraTimeView) android.view.LayoutInflater.from(this.f5722a).inflate(com.oplus.camera.R_renamed.layout.time_lapse_pro_record_time, (android.view.ViewGroup) null);
        this.f_renamed.a_renamed();
        this.f_renamed.setNeedRelayout(false);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_left_title);
        layoutParams2.addRule(7, com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_left_title);
        layoutParams2.topMargin = (int) getResources().getDimension(com.oplus.camera.R_renamed.dimen.time_lapse_pro_record_time_margin_top);
        addView(this.f_renamed, layoutParams2);
    }

    private void f_renamed() {
        android.view.View view = new android.view.View(this.f5722a);
        view.setId(com.oplus.camera.R_renamed.id_renamed.time_lapse_pro_record_middle_line);
        view.setBackgroundColor(androidx.core.a_renamed.a_renamed.c_renamed(this.f5722a, com.oplus.camera.R_renamed.color.color_white_with_15_percent_transparency));
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_record_middle_line_w), getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.time_lapse_pro_record_middle_line_h));
        layoutParams.addRule(13);
        addView(view, layoutParams);
    }

    public void a_renamed(long j_renamed, long j2, boolean z_renamed) {
        if (j_renamed >= 359999999) {
            j_renamed = 359999999;
        }
        this.f_renamed.a_renamed(j_renamed, z_renamed);
        if (this.h_renamed == j2) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProRecordView", "showTime, recordTime: " + j_renamed + ", videoTime: " + j2 + ", showIndicator: " + z_renamed);
        this.h_renamed = j2;
        this.g_renamed.a_renamed(j2, false);
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("TimeLapseProRecordView", "resetTime.");
        this.f_renamed.a_renamed(0L, true);
        this.g_renamed.a_renamed(0L, false);
    }

    public void b_renamed() {
        removeAllViews();
        this.f5722a = null;
    }
}
