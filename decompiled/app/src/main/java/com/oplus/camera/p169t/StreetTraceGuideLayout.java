package com.oplus.camera.p169t;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: StreetTraceGuideLayout.java */
/* renamed from: com.oplus.camera.t.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class StreetTraceGuideLayout extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private TextView f16609a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private TextView f16610b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TextView f16611c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TextView f16612d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f16613e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f16614f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f16615g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16616h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Paint f16617i;

    /* renamed from: OplusGLSurfaceView_15 */
    private RectF f16618j;

    public StreetTraceGuideLayout(Context context, int OplusGLSurfaceView_13) {
        super(context);
        this.f16609a = null;
        this.f16610b = null;
        this.f16611c = null;
        this.f16612d = null;
        this.f16613e = 0;
        this.f16614f = 0;
        this.f16615g = 0;
        this.f16616h = 0;
        this.f16617i = null;
        this.f16618j = null;
        this.f16613e = OplusGLSurfaceView_13;
        this.f16614f = getContext().getResources().getDimensionPixelSize(R.dimen.street_mode_trace_guide_textview_panding);
        this.f16615g = Util.getScreenWidth();
        this.f16616h = getContext().getResources().getDimensionPixelSize(R.dimen.street_mode_trace_height);
        this.f16617i = new Paint();
        this.f16617i.setStyle(Paint.Style.STROKE);
        this.f16617i.setColor(getContext().getColor(R.color.street_trace_guide_angle_color));
        this.f16617i.setAntiAlias(true);
        this.f16617i.setStrokeWidth(5.0f);
        int i2 = this.f16615g;
        int i3 = this.f16613e;
        int i4 = this.f16616h;
        this.f16618j = new RectF(((i2 / 2) - i3) - 11, ((i4 / 2) - i3) - 11, (i2 / 2) + i3 + 11, (i4 / 2) + i3 + 11);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17323b() {
        this.f16609a = m17325c();
        this.f16610b = m17325c();
        this.f16611c = m17325c();
        this.f16612d = m17325c();
        this.f16609a.setPadding(0, 0, this.f16614f, 0);
        this.f16609a.setGravity(5);
        this.f16609a.setText(getContext().getString(R.string.reduce_fouces_distance));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((this.f16615g / 2) - this.f16613e, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        this.f16609a.setLayoutParams(layoutParams);
        this.f16610b.setPadding(this.f16614f, 0, 0, 0);
        this.f16610b.setGravity(3);
        this.f16610b.setText(getContext().getString(R.string.increate_fouces_distance));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((this.f16615g / 2) - this.f16613e, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        this.f16610b.setLayoutParams(layoutParams2);
        this.f16611c.setPadding(0, 0, 0, this.f16614f);
        this.f16611c.setGravity(80);
        this.f16611c.setText(getContext().getString(R.string.zoom_out));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, (this.f16616h / 2) - this.f16613e);
        layoutParams3.addRule(10);
        layoutParams3.addRule(14);
        this.f16611c.setLayoutParams(layoutParams3);
        this.f16612d.setPadding(0, this.f16614f, 0, 0);
        this.f16612d.setGravity(48);
        this.f16612d.setText(getContext().getString(R.string.zoom_in));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, (this.f16616h / 2) - this.f16613e);
        layoutParams4.addRule(12);
        layoutParams4.addRule(14);
        this.f16612d.setLayoutParams(layoutParams4);
        addView(this.f16609a);
        addView(this.f16610b);
        addView(this.f16611c);
        addView(this.f16612d);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TextView m17325c() {
        TextView textView = new TextView(getContext().getApplicationContext());
        Resources resources = getContext().getApplicationContext().getResources();
        textView.setIncludeFontPadding(false);
        textView.setTextSize(0, resources.getDimensionPixelSize(R.dimen.street_mode_trace_guide_textview_size));
        textView.setTypeface(Util.m24473l(getContext().getApplicationContext()));
        textView.setTextColor(resources.getColor(R.color.main_item_title_text_color));
        textView.setId(View.generateViewId());
        return textView;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17327a(float COUIBaseListPopupWindow_12) {
        m17324b(COUIBaseListPopupWindow_12);
        setVisibility(0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17326a() {
        setVisibility(8);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17324b(float COUIBaseListPopupWindow_12) {
        setY(COUIBaseListPopupWindow_12);
        if (this.f16609a == null) {
            setLayoutParams(new RelativeLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(R.dimen.street_mode_trace_height)));
            m17323b();
            setBackgroundColor(0);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f16618j, -18.0f, 36.0f, false, this.f16617i);
        canvas.drawArc(this.f16618j, 72.0f, 36.0f, false, this.f16617i);
        canvas.drawArc(this.f16618j, 162.0f, 36.0f, false, this.f16617i);
        canvas.drawArc(this.f16618j, 252.0f, 36.0f, false, this.f16617i);
    }
}
