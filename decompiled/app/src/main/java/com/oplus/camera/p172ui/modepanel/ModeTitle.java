package com.oplus.camera.p172ui.modepanel;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseImageView;
import com.oplus.camera.p172ui.menu.p175a.HeadlineBackground;
import com.oplus.camera.util.Util;

/* compiled from: ModeTitle.java */
/* renamed from: com.oplus.camera.ui.modepanel.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
public class ModeTitle implements View.OnClickListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Typeface f20603a;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Activity f20606d;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PathInterpolator f20604b = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final PathInterpolator f20605c = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: COUIBaseListPopupWindow_8 */
    private RelativeLayout f20607e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private TextView f20608f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f20609g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f20610h = 8;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f20611i = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f20612j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f20613k = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f20614l = true;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f20615m = false;

    /* renamed from: OplusGLSurfaceView_11 */
    private HeadlineBackground f20616n = null;

    /* renamed from: o */
    private int f20617o = 0;

    /* renamed from: p */
    private int f20618p = 0;

    /* renamed from: q */
    private boolean f20619q = false;

    /* compiled from: ModeTitle.java */
    /* renamed from: com.oplus.camera.ui.modepanel.OplusGLSurfaceView_11$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo20059a();
    }

    public ModeTitle(Activity activity, ViewGroup viewGroup) {
        this.f20606d = null;
        this.f20606d = activity;
        m21957a(viewGroup);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21957a(ViewGroup viewGroup) {
        this.f20606d.getLayoutInflater().inflate(R.layout.mode_title, viewGroup);
        this.f20607e = (RelativeLayout) this.f20606d.findViewById(R.id_renamed.mode_title_layout);
        this.f20608f = (TextView) this.f20607e.findViewById(R.id_renamed.mode_name);
        this.f20608f.setTypeface(m21971f(), 1);
        this.f20607e.setOnClickListener(this);
        this.f20611i = this.f20606d.getResources().getDimensionPixelOffset(R.dimen.face_beauty_menu_translate_y);
        this.f20616n = (HeadlineBackground) this.f20606d.findViewById(R.id_renamed.headline_background);
        this.f20612j = (this.f20606d.getResources().getDimensionPixelSize(R.dimen.head_line_background_space) - this.f20606d.getResources().getDimensionPixelSize(R.dimen.headline_margin_space)) * 2;
        this.f20613k = 0;
        HeadlineBackground c3236b = this.f20616n;
        if (c3236b != null) {
            c3236b.m20342a(this.f20607e);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m21967d() throws Resources.NotFoundException {
        RelativeLayout.LayoutParams layoutParams;
        int OplusGLSurfaceView_13;
        int dimensionPixelSize;
        m21969e();
        Resources resources = this.f20606d.getResources();
        int i2 = this.f20617o;
        if (i2 == 1) {
            layoutParams = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(R.dimen.mode_title_height));
            layoutParams.addRule(21);
            layoutParams.addRule(12);
            int i3 = this.f20618p;
            if (270 == i3 || 90 == i3) {
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(R.dimen.vertical_rotate_mode_title_margin_bottom);
            } else {
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(R.dimen.vertical_mode_title_margin_bottom);
            }
            this.f20608f.measure(0, 0);
            int measuredWidth = this.f20608f.getMeasuredWidth();
            if (this.f20615m) {
                layoutParams.height = resources.getDimensionPixelSize(R.dimen.vertical_mode_title_double_line_height);
                layoutParams.bottomMargin += (resources.getDimensionPixelSize(R.dimen.mode_title_height) - layoutParams.height) / 2;
            }
            if (270 == this.f20618p) {
                layoutParams.removeRule(21);
                layoutParams.addRule(14);
            } else {
                if (this.f20615m) {
                    OplusGLSurfaceView_13 = measuredWidth / 2;
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.vertical_double_line_mode_name_tv_margin_right);
                } else if (measuredWidth >= resources.getDimensionPixelSize(R.dimen.vertical_mode_title_width_threshold)) {
                    OplusGLSurfaceView_13 = measuredWidth / 2;
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.vertical_long_mode_name_tv_margin_right);
                } else {
                    OplusGLSurfaceView_13 = measuredWidth / 2;
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.vertical_mode_name_tv_margin_right);
                }
                layoutParams.setMarginEnd((resources.getDimensionPixelSize(R.dimen.control_panel_width_full) / 2) - (OplusGLSurfaceView_13 + dimensionPixelSize));
            }
            if (this.f20615m) {
                this.f20607e.setBackground(this.f20606d.getDrawable(R.drawable.mode_long_title_bg_vertical));
            } else {
                this.f20607e.setBackground(this.f20606d.getDrawable(R.drawable.mode_title_bg_vertical));
            }
            this.f20614l = false;
            HeadlineBackground c3236b = this.f20616n;
            if (c3236b != null) {
                c3236b.m20343b(this.f20607e);
            }
        } else if (i2 == 4) {
            layoutParams = new RelativeLayout.LayoutParams(-2, resources.getDimensionPixelSize(R.dimen.mode_title_height));
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = resources.getDimensionPixelOffset(R.dimen.rack_mode_title_margin_bottom);
            this.f20607e.setBackground(this.f20606d.getDrawable(R.drawable.mode_title_bg_vertical));
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            layoutParams.topMargin = resources.getDimensionPixelOffset(R.dimen.mode_title_margin_top);
            this.f20607e.setBackground(null);
            this.f20614l = true;
            HeadlineBackground c3236b2 = this.f20616n;
            if (c3236b2 != null) {
                c3236b2.m20342a(this.f20607e);
            }
        }
        this.f20607e.setLayoutParams(layoutParams);
        this.f20607e.invalidate();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m21969e() throws Resources.NotFoundException {
        InverseImageView inverseImageView = (InverseImageView) this.f20606d.findViewById(R.id_renamed.mode_close);
        TextView textView = this.f20608f;
        if (textView == null || inverseImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        Resources resources = this.f20606d.getResources();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) inverseImageView.getLayoutParams();
        if (layoutParams == null || inverseImageView == null) {
            return;
        }
        int OplusGLSurfaceView_13 = this.f20617o;
        if (OplusGLSurfaceView_13 == 1) {
            this.f20608f.measure(0, 0);
            boolean z = this.f20608f.getMeasuredWidth() >= this.f20606d.getResources().getDimensionPixelSize(R.dimen.vertical_mode_title_width_threshold);
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.vertical_mode_title_max_width);
            this.f20615m = this.f20608f.getMeasuredWidth() >= dimensionPixelOffset;
            if (this.f20615m) {
                layoutParams.setMarginStart(resources.getDimensionPixelOffset(R.dimen.vertical_double_line_mode_name_tv_margin_left));
                layoutParams2.setMarginStart(resources.getDimensionPixelOffset(R.dimen.vertical_double_line_close_img_margin_left));
                layoutParams2.setMarginEnd(resources.getDimensionPixelOffset(R.dimen.vertical_double_line_close_img_margin_right));
            } else if (z) {
                layoutParams.setMarginStart(resources.getDimensionPixelOffset(R.dimen.vertical_long_mode_name_tv_margin_left));
                layoutParams2.setMarginStart(resources.getDimensionPixelOffset(R.dimen.vertical_mode_close_img_margin_left));
                layoutParams2.setMarginEnd(resources.getDimensionPixelOffset(R.dimen.vertical_long_mode_close_img_margin_right));
            } else {
                layoutParams.setMarginStart(resources.getDimensionPixelOffset(R.dimen.mode_name_tv_margin_left));
                layoutParams2.setMarginStart(resources.getDimensionPixelOffset(R.dimen.vertical_mode_close_img_margin_left));
                layoutParams2.setMarginEnd(resources.getDimensionPixelOffset(R.dimen.vertical_mode_close_img_margin_right));
            }
            if (this.f20615m) {
                String string = this.f20608f.getText().toString();
                if (this.f20608f.getPaint().measureText(string.split("\\s")[0]) < dimensionPixelOffset) {
                    this.f20608f.setText(string.replaceFirst(" ", "\OplusGLSurfaceView_11"));
                }
            }
            layoutParams2.removeRule(15);
            layoutParams2.addRule(10);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(R.dimen.vertical_mode_close_img_margin_top) + resources.getDimensionPixelOffset(R.dimen.headline_bg_fold_offset);
            layoutParams2.width = resources.getDimensionPixelOffset(R.dimen.vertical_mode_close_img_width);
            layoutParams2.height = resources.getDimensionPixelOffset(R.dimen.vertical_mode_close_img_width);
            this.f20608f.setMaxWidth(dimensionPixelOffset);
            this.f20608f.setSingleLine(false);
            this.f20608f.setMaxLines(2);
            this.f20608f.setGravity(1);
        } else if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 4) {
            layoutParams.addRule(14, 0);
            layoutParams.setMarginStart(resources.getDimensionPixelOffset(R.dimen.mode_name_tv_margin_left));
            layoutParams2.setMarginStart(resources.getDimensionPixelOffset(R.dimen.mode_close_img_margin_left));
            layoutParams2.setMarginEnd(resources.getDimensionPixelOffset(R.dimen.mode_close_img_margin_right));
            layoutParams2.removeRule(15);
            layoutParams2.addRule(10);
            layoutParams2.topMargin = resources.getDimensionPixelOffset(R.dimen.vertical_mode_close_img_margin_top) + resources.getDimensionPixelOffset(R.dimen.headline_bg_fold_offset);
            layoutParams2.width = -2;
            layoutParams2.height = -2;
            this.f20608f.setMaxWidth(Integer.MAX_VALUE);
            this.f20608f.setSingleLine(true);
            this.f20608f.setTextAlignment(0);
        } else {
            layoutParams.addRule(14, 0);
            layoutParams.setMarginStart(resources.getDimensionPixelOffset(R.dimen.mode_name_tv_margin_left));
            layoutParams2.setMarginStart(resources.getDimensionPixelOffset(R.dimen.mode_close_img_margin_left));
            layoutParams2.setMarginEnd(resources.getDimensionPixelOffset(R.dimen.mode_close_img_margin_right));
            layoutParams2.removeRule(10);
            layoutParams2.addRule(15);
            layoutParams2.width = -2;
            layoutParams2.height = -2;
            this.f20608f.setMaxWidth(Integer.MAX_VALUE);
            this.f20608f.setSingleLine(true);
            this.f20608f.setTextAlignment(0);
        }
        inverseImageView.setLayoutParams(layoutParams2);
        this.f20608f.setLayoutParams(layoutParams);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21978a(boolean z) {
        this.f20619q = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21973a(int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        boolean z = this.f20617o != OplusGLSurfaceView_13;
        this.f20617o = OplusGLSurfaceView_13;
        this.f20618p = i2;
        m21967d();
        if ((m21980b() || this.f20619q) && z) {
            this.f20607e.post(new Runnable() { // from class: com.oplus.camera.ui.modepanel.OplusGLSurfaceView_11.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!ModeTitle.this.f20614l || ModeTitle.this.f20616n == null) {
                        if (ModeTitle.this.f20616n != null) {
                            ModeTitle.this.f20616n.setVisibility(4);
                        }
                    } else {
                        ModeTitle.this.f20616n.m20339a(ModeTitle.this.f20607e.getWidth() + ModeTitle.this.f20612j, ModeTitle.this.f20607e.getHeight() + ModeTitle.this.f20613k);
                        ModeTitle.this.f20616n.invalidate();
                        ModeTitle.this.f20616n.setAlpha(1.0f);
                        ModeTitle.this.f20616n.setVisibility(ModeTitle.this.f20610h);
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f20609g == null || this.f20607e.getVisibility() != 0) {
            return;
        }
        if (this.f20607e.getAnimation() == null || !this.f20607e.getAnimation().hasStarted()) {
            this.f20609g.mo20059a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21977a(String str) throws Resources.NotFoundException {
        this.f20608f.setText(str);
        this.f20607e.setContentDescription(str);
        if (1 == this.f20617o) {
            m21967d();
        }
        this.f20607e.post(new Runnable() { // from class: com.oplus.camera.ui.modepanel.OplusGLSurfaceView_11.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ModeTitle.this.f20614l || ModeTitle.this.f20616n == null || ModeTitle.this.f20607e == null) {
                    return;
                }
                ModeTitle.this.f20607e.measure(0, 0);
                ModeTitle.this.f20616n.m20340a(ModeTitle.this.f20607e.getMeasuredWidth() + ModeTitle.this.f20612j, ModeTitle.this.f20607e.getMeasuredHeight() + ModeTitle.this.f20613k, 250, 0);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m21972a() {
        TextView textView = this.f20608f;
        if (textView == null || textView.getText() == null) {
            return "";
        }
        if (1 == this.f20617o) {
            return this.f20608f.getText().toString().replaceAll("\OplusGLSurfaceView_11", " ");
        }
        return (String) this.f20608f.getText();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m21980b() {
        return this.f20610h == 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m21959a(int OplusGLSurfaceView_13) {
        HeadlineBackground c3236b;
        if (this.f20610h == OplusGLSurfaceView_13) {
            return false;
        }
        this.f20610h = OplusGLSurfaceView_13;
        if (!this.f20614l || (c3236b = this.f20616n) == null) {
            return true;
        }
        c3236b.setAlpha(1.0f);
        this.f20616n.m20341a(OplusGLSurfaceView_13, this.f20607e);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21974a(int OplusGLSurfaceView_13, Animation animation, boolean z) {
        HeadlineBackground c3236b;
        CameraLog.m12954a("ModeTitle", "setVisibility, visibility: " + OplusGLSurfaceView_13);
        if (m21959a(OplusGLSurfaceView_13)) {
            if (OplusGLSurfaceView_13 == 0) {
                m21958a(animation);
            } else {
                m21963b(animation);
            }
            if (z || !this.f20614l || (c3236b = this.f20616n) == null) {
                return;
            }
            c3236b.clearAnimation();
            if (animation != null) {
                this.f20616n.startAnimation(animation);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21975a(int OplusGLSurfaceView_13, boolean z, int i2) {
        AnimationSet animationSetM21964c;
        HeadlineBackground c3236b;
        CameraLog.m12954a("ModeTitle", "setVisibility, visibility: " + OplusGLSurfaceView_13);
        if (m21959a(OplusGLSurfaceView_13)) {
            if (z) {
                if (OplusGLSurfaceView_13 == 0) {
                    animationSetM21964c = m21961b(i2);
                    m21958a(animationSetM21964c);
                } else {
                    animationSetM21964c = m21964c(i2);
                    m21963b(animationSetM21964c);
                }
                if (!this.f20614l || (c3236b = this.f20616n) == null) {
                    return;
                }
                c3236b.clearAnimation();
                this.f20616n.startAnimation(animationSetM21964c);
                return;
            }
            if (this.f20607e.getAnimation() != null) {
                this.f20607e.clearAnimation();
            }
            this.f20607e.setVisibility(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21979b(boolean z) {
        CameraLog.m12954a("ModeTitle", "setEnable, enable: " + z);
        RelativeLayout relativeLayout = this.f20607e;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m21981c() {
        RelativeLayout relativeLayout = this.f20607e;
        return relativeLayout != null && relativeLayout.isEnabled();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Typeface m21971f() {
        Typeface typeface = f20603a;
        if (typeface != null) {
            return typeface;
        }
        f20603a = Util.m24226a((Context) this.f20606d, true);
        return f20603a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21958a(Animation animation) {
        this.f20607e.setVisibility(0);
        this.f20607e.clearAnimation();
        if (animation != null) {
            this.f20607e.startAnimation(animation);
        }
        this.f20607e.setEnabled(true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21963b(Animation animation) {
        this.f20607e.setVisibility(8);
        this.f20607e.clearAnimation();
        if (animation != null) {
            this.f20607e.startAnimation(animation);
        }
        this.f20607e.setEnabled(false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private AnimationSet m21961b(int OplusGLSurfaceView_13) {
        AnimationSet animationSet = new AnimationSet(false);
        if (OplusGLSurfaceView_13 == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setInterpolator(this.f20604b);
            alphaAnimation.setDuration(250L);
            animationSet.addAnimation(alphaAnimation);
        } else if (1 == OplusGLSurfaceView_13) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation2.setInterpolator(this.f20604b);
            alphaAnimation2.setDuration(250L);
            animationSet.addAnimation(alphaAnimation2);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -this.f20611i, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setInterpolator(this.f20605c);
            animationSet.addAnimation(translateAnimation);
            animationSet.setStartOffset(150L);
        }
        return animationSet;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private AnimationSet m21964c(int OplusGLSurfaceView_13) {
        AnimationSet animationSet = new AnimationSet(false);
        if (OplusGLSurfaceView_13 == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setInterpolator(this.f20604b);
            alphaAnimation.setDuration(250L);
            animationSet.addAnimation(alphaAnimation);
        } else if (1 == OplusGLSurfaceView_13) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setInterpolator(this.f20604b);
            alphaAnimation2.setDuration(250L);
            animationSet.addAnimation(alphaAnimation2);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -this.f20611i);
            translateAnimation.setDuration(400L);
            translateAnimation.setInterpolator(this.f20605c);
            animationSet.addAnimation(translateAnimation);
        }
        return animationSet;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21976a(PlatformImplementations.kt_3 aVar) {
        this.f20609g = aVar;
    }
}
