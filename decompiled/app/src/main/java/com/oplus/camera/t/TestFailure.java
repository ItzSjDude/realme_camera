package com.oplus.camera.t_renamed;

/* compiled from: StreetTraceGuideLayout.java */
/* loaded from: classes2.dex */
public class f_renamed extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.widget.TextView f5612a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.widget.TextView f5613b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.TextView f5614c;
    private android.widget.TextView d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private android.graphics.Paint i_renamed;
    private android.graphics.RectF j_renamed;

    public f_renamed(android.content.Context context, int i_renamed) {
        super(context);
        this.f5612a = null;
        this.f5613b = null;
        this.f5614c = null;
        this.d_renamed = null;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.i_renamed = null;
        this.j_renamed = null;
        this.e_renamed = i_renamed;
        this.f_renamed = getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_trace_guide_textview_panding);
        this.g_renamed = com.oplus.camera.util.Util.getScreenWidth();
        this.h_renamed = getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_trace_height);
        this.i_renamed = new android.graphics.Paint();
        this.i_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.i_renamed.setColor(getContext().getColor(com.oplus.camera.R_renamed.color.street_trace_guide_angle_color));
        this.i_renamed.setAntiAlias(true);
        this.i_renamed.setStrokeWidth(5.0f);
        int i2 = this.g_renamed;
        int i3 = this.e_renamed;
        int i4 = this.h_renamed;
        this.j_renamed = new android.graphics.RectF(((i2 / 2) - i3) - 11, ((i4 / 2) - i3) - 11, (i2 / 2) + i3 + 11, (i4 / 2) + i3 + 11);
    }

    private void b_renamed() {
        this.f5612a = c_renamed();
        this.f5613b = c_renamed();
        this.f5614c = c_renamed();
        this.d_renamed = c_renamed();
        this.f5612a.setPadding(0, 0, this.f_renamed, 0);
        this.f5612a.setGravity(5);
        this.f5612a.setText(getContext().getString(com.oplus.camera.R_renamed.string.reduce_fouces_distance));
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams((this.g_renamed / 2) - this.e_renamed, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        this.f5612a.setLayoutParams(layoutParams);
        this.f5613b.setPadding(this.f_renamed, 0, 0, 0);
        this.f5613b.setGravity(3);
        this.f5613b.setText(getContext().getString(com.oplus.camera.R_renamed.string.increate_fouces_distance));
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams((this.g_renamed / 2) - this.e_renamed, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        this.f5613b.setLayoutParams(layoutParams2);
        this.f5614c.setPadding(0, 0, 0, this.f_renamed);
        this.f5614c.setGravity(80);
        this.f5614c.setText(getContext().getString(com.oplus.camera.R_renamed.string.zoom_out));
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, (this.h_renamed / 2) - this.e_renamed);
        layoutParams3.addRule(10);
        layoutParams3.addRule(14);
        this.f5614c.setLayoutParams(layoutParams3);
        this.d_renamed.setPadding(0, this.f_renamed, 0, 0);
        this.d_renamed.setGravity(48);
        this.d_renamed.setText(getContext().getString(com.oplus.camera.R_renamed.string.zoom_in));
        android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-2, (this.h_renamed / 2) - this.e_renamed);
        layoutParams4.addRule(12);
        layoutParams4.addRule(14);
        this.d_renamed.setLayoutParams(layoutParams4);
        addView(this.f5612a);
        addView(this.f5613b);
        addView(this.f5614c);
        addView(this.d_renamed);
    }

    private android.widget.TextView c_renamed() {
        android.widget.TextView textView = new android.widget.TextView(getContext().getApplicationContext());
        android.content.res.Resources resources = getContext().getApplicationContext().getResources();
        textView.setIncludeFontPadding(false);
        textView.setTextSize(0, resources.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_trace_guide_textview_size));
        textView.setTypeface(com.oplus.camera.util.Util.l_renamed(getContext().getApplicationContext()));
        textView.setTextColor(resources.getColor(com.oplus.camera.R_renamed.color.main_item_title_text_color));
        textView.setId(android.view.View.generateViewId());
        return textView;
    }

    public void a_renamed(float f_renamed) {
        b_renamed(f_renamed);
        setVisibility(0);
    }

    public void a_renamed() {
        setVisibility(8);
    }

    private void b_renamed(float f_renamed) {
        setY(f_renamed);
        if (this.f5612a == null) {
            setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.street_mode_trace_height)));
            b_renamed();
            setBackgroundColor(0);
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.j_renamed, -18.0f, 36.0f, false, this.i_renamed);
        canvas.drawArc(this.j_renamed, 72.0f, 36.0f, false, this.i_renamed);
        canvas.drawArc(this.j_renamed, 162.0f, 36.0f, false, this.i_renamed);
        canvas.drawArc(this.j_renamed, 252.0f, 36.0f, false, this.i_renamed);
    }
}
