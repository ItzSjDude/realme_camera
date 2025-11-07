package com.oplus.camera.p172ui.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.p034f.TextUtilsCompat;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.menu.OplusTextView;
import com.oplus.camera.p172ui.widget.TouchFeedbackListener;
import com.oplus.camera.util.Util;
import java.util.Locale;

/* loaded from: classes2.dex */
public class AiTextHintView extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f20689a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f20690b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f20691c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f20692d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f20693e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f20694f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f20695g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private OplusTextView f20696h;

    /* renamed from: OplusGLSurfaceView_13 */
    private AiTextHintView f20697i;

    /* renamed from: OplusGLSurfaceView_15 */
    private CameraUIListener f20698j;

    /* renamed from: OplusGLSurfaceView_5 */
    private ImageView f20699k;

    /* renamed from: OplusGLSurfaceView_14 */
    private ImageView f20700l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Context f20701m;

    public AiTextHintView(Context context) {
        this(context, null);
    }

    public AiTextHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AiTextHintView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f20689a = 0;
        this.f20690b = 0;
        this.f20691c = 0;
        this.f20692d = 0;
        this.f20693e = 0;
        this.f20694f = 0;
        this.f20695g = 0;
        this.f20696h = null;
        this.f20697i = null;
        this.f20698j = null;
        this.f20699k = null;
        this.f20700l = null;
        this.f20701m = null;
        this.f20701m = context;
        setOnTouchListener(new TouchFeedbackListener());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22076a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, CameraUIListener cameraUIListener) {
        this.f20689a = OplusGLSurfaceView_13;
        this.f20690b = i2;
        this.f20691c = i3;
        this.f20692d = i4;
        this.f20694f = getResources().getDimensionPixelSize(R.dimen.pi_ultra_wide_hint_horizontal_margin);
        this.f20698j = cameraUIListener;
        this.f20695g = i5;
        this.f20696h = (OplusTextView) findViewById(R.id_renamed.ai_hint_bubble_text);
        this.f20697i = (AiTextHintView) findViewById(R.id_renamed.ai_hint_hint_layout);
        this.f20699k = (ImageView) findViewById(R.id_renamed.ai_hint_arrow_image);
        this.f20700l = (ImageView) findViewById(R.id_renamed.ai_hint_icon);
        this.f20699k.setRotation(1 == TextUtilsCompat.m2525a(Locale.getDefault()) ? 180.0f : 0.0f);
        this.f20697i.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.preview.AiTextHintView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AiTextHintView.this.f20698j != null) {
                    AiTextHintView.this.f20698j.mo10677a(AiTextHintView.this.f20695g);
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22075a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        CameraLog.m12954a("AiTextHintView", "showAiHintUI");
        this.f20693e = i2;
        this.f20689a = OplusGLSurfaceView_13;
        this.f20696h.setText(i3);
        setVisibility(0);
        int i5 = this.f20695g;
        if (i5 == 0) {
            this.f20699k.setVisibility(0);
        } else if (i5 == 1) {
            this.f20699k.setVisibility(8);
        }
        this.f20700l.setBackground(this.f20701m.getDrawable(i4));
        m22072c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22074a() {
        if (8 == getVisibility()) {
            CameraLog.m12959b("AiTextHintView", "hideAiHintUI, return");
        } else {
            setVisibility(8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m22077b() {
        return getVisibility() == 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Size m22069a(View view) {
        measure(Util.getScreenWidth(), Util.getScreenWidth());
        return new Size(view.getMeasuredWidth(), getContext().getResources().getDimensionPixelSize(R.dimen.ai_notice_view_height));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m22072c() {
        CameraUIListener cameraUIListener;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, getContext().getResources().getDimensionPixelSize(R.dimen.ai_notice_view_height));
        Size sizeM22069a = m22069a((View) this);
        int OplusGLSurfaceView_13 = this.f20693e;
        int i2 = 270;
        if (OplusGLSurfaceView_13 == 90) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.topMargin = ((this.f20690b + (this.f20691c / 2)) - (sizeM22069a.getHeight() / 2)) + this.f20692d;
            layoutParams.rightMargin = ((this.f20694f + (sizeM22069a.getHeight() / 2)) + (sizeM22069a.getWidth() / 2)) - sizeM22069a.getWidth();
            i2 = 90;
        } else if (OplusGLSurfaceView_13 == 180) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = ((Util.getScreenWidth() / 2) - (sizeM22069a.getWidth() / 2)) + this.f20692d;
            layoutParams.topMargin = this.f20689a;
            i2 = 180;
        } else if (OplusGLSurfaceView_13 == 270) {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.topMargin = ((this.f20690b + (this.f20691c / 2)) - (sizeM22069a.getHeight() / 2)) + this.f20692d;
            layoutParams.leftMargin = ((this.f20694f + (sizeM22069a.getHeight() / 2)) + (sizeM22069a.getWidth() / 2)) - sizeM22069a.getWidth();
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.leftMargin = ((Util.getScreenWidth() / 2) - (sizeM22069a.getWidth() / 2)) + this.f20692d;
            layoutParams.topMargin = this.f20689a;
            if (Util.m24495t() && (cameraUIListener = this.f20698j) != null) {
                layoutParams.leftMargin = ((cameraUIListener.mo10771bN() / 2) - (sizeM22069a.getWidth() / 2)) + this.f20692d;
            }
            i2 = 0;
        }
        setLayoutParams(layoutParams);
        setRotation(-i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public AnimationSet m22073a(float COUIBaseListPopupWindow_12, float f2) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(COUIBaseListPopupWindow_12, f2));
        animationSet.setDuration(180L);
        animationSet.setInterpolator(this.f20701m, R.anim.ultra_wide_hint_alpha_path_interpolator);
        return animationSet;
    }
}
