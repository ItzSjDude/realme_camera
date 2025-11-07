package com.oplus.camera.timelapsepro;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.p027a.ContextCompat;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.menu.OplusTextView;
import com.oplus.camera.p172ui.preview.CameraTimeView;

/* compiled from: TimeLapseProRecordView.java */
/* renamed from: com.oplus.camera.timelapsepro.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class TimeLapseProRecordView extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f17047a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f17048b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f17049c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f17050d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f17051e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private CameraTimeView f17052f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CameraTimeView f17053g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private long f17054h;

    public TimeLapseProRecordView(Context context) {
        this(context, null);
    }

    public TimeLapseProRecordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimeLapseProRecordView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17054h = -1L;
        setLayoutDirection(0);
        this.f17047a = context;
        this.f17050d = getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_radius_size);
        this.f17048b = getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dx);
        this.f17049c = getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dy);
        m17926c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17926c() throws Resources.NotFoundException {
        this.f17051e = getResources().getDimensionPixelSize(R.dimen.time_lapse_pro_record_time_margin_to_center);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        m17929f();
        m17928e();
        m17927d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m17927d() throws Resources.NotFoundException {
        OplusTextView oplusTextView = new OplusTextView(this.f17047a);
        oplusTextView.setId(R.id_renamed.time_lapse_pro_record_right_title);
        oplusTextView.setText(R.string.video_time);
        oplusTextView.setTextSize(1, 12.0f);
        oplusTextView.setTextColor(ContextCompat.m2254c(this.f17047a, R.color.camera_white));
        oplusTextView.setShadowLayer(this.f17050d, this.f17048b, this.f17049c, ContextCompat.m2254c(this.f17047a, R.color.camera_time_shadow_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, R.id_renamed.time_lapse_pro_record_middle_line);
        layoutParams.leftMargin = this.f17051e;
        addView(oplusTextView, layoutParams);
        this.f17053g = (CameraTimeView) LayoutInflater.from(this.f17047a).inflate(R.layout.time_lapse_pro_record_time, (ViewGroup) null);
        this.f17053g.m22091a();
        this.f17053g.m22099b();
        this.f17053g.setNeedRelayout(false);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, R.id_renamed.time_lapse_pro_record_right_title);
        layoutParams2.addRule(5, R.id_renamed.time_lapse_pro_record_right_title);
        layoutParams2.topMargin = (int) getResources().getDimension(R.dimen.time_lapse_pro_record_time_margin_top);
        addView(this.f17053g, layoutParams2);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m17928e() throws Resources.NotFoundException {
        OplusTextView oplusTextView = new OplusTextView(this.f17047a);
        oplusTextView.setId(R.id_renamed.time_lapse_pro_record_left_title);
        oplusTextView.setText(R.string.record_time);
        oplusTextView.setTextSize(1, 12.0f);
        oplusTextView.setTextColor(ContextCompat.m2254c(this.f17047a, R.color.camera_white));
        oplusTextView.setShadowLayer(this.f17050d, this.f17048b, this.f17049c, ContextCompat.m2254c(this.f17047a, R.color.camera_time_shadow_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, R.id_renamed.time_lapse_pro_record_middle_line);
        layoutParams.rightMargin = this.f17051e;
        addView(oplusTextView, layoutParams);
        this.f17052f = (CameraTimeView) LayoutInflater.from(this.f17047a).inflate(R.layout.time_lapse_pro_record_time, (ViewGroup) null);
        this.f17052f.m22091a();
        this.f17052f.setNeedRelayout(false);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, R.id_renamed.time_lapse_pro_record_left_title);
        layoutParams2.addRule(7, R.id_renamed.time_lapse_pro_record_left_title);
        layoutParams2.topMargin = (int) getResources().getDimension(R.dimen.time_lapse_pro_record_time_margin_top);
        addView(this.f17052f, layoutParams2);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m17929f() {
        View view = new View(this.f17047a);
        view.setId(R.id_renamed.time_lapse_pro_record_middle_line);
        view.setBackgroundColor(ContextCompat.m2254c(this.f17047a, R.color.color_white_with_15_percent_transparency));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.time_lapse_pro_record_middle_line_w), getResources().getDimensionPixelSize(R.dimen.time_lapse_pro_record_middle_line_h));
        layoutParams.addRule(13);
        addView(view, layoutParams);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17931a(long OplusGLSurfaceView_15, long j2, boolean z) {
        if (OplusGLSurfaceView_15 >= 359999999) {
            OplusGLSurfaceView_15 = 359999999;
        }
        this.f17052f.m22094a(OplusGLSurfaceView_15, z);
        if (this.f17054h == j2) {
            return;
        }
        CameraLog.m12954a("TimeLapseProRecordView", "showTime, recordTime: " + OplusGLSurfaceView_15 + ", videoTime: " + j2 + ", showIndicator: " + z);
        this.f17054h = j2;
        this.f17053g.m22094a(j2, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17930a() {
        CameraLog.m12954a("TimeLapseProRecordView", "resetTime.");
        this.f17052f.m22094a(0L, true);
        this.f17053g.m22094a(0L, false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17932b() {
        removeAllViews();
        this.f17047a = null;
    }
}
