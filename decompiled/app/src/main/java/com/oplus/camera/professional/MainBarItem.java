package com.oplus.camera.professional;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.p027a.ContextCompat;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.ShadowImageView;
import com.oplus.camera.p172ui.RotateLottieAnimationView;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.util.Util;
import com.p078a.p079a.Spring;

/* compiled from: MainBarItem.java */
/* renamed from: com.oplus.camera.professional.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class MainBarItem extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private static int f15591a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int f15592b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f15593c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f15594d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Activity f15595e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private RotateLottieAnimationView f15596f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private RelativeLayout f15597g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ImageView f15598h;

    /* renamed from: OplusGLSurfaceView_13 */
    private ProfessionalTextView f15599i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ProfessionalTextView f15600j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f15601k;

    /* renamed from: OplusGLSurfaceView_14 */
    private View f15602l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f15603m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f15604n;

    /* renamed from: o */
    private Resources f15605o;

    /* renamed from: p */
    private boolean f15606p;

    /* renamed from: q */
    private String f15607q;

    /* renamed from: r */
    private int f15608r;

    /* renamed from: s */
    private Spring f15609s;

    /* renamed from: t */
    private boolean f15610t;

    /* renamed from: u */
    private int f15611u;

    /* renamed from: v */
    private Animator f15612v;

    /* renamed from: w */
    private Animator f15613w;

    public MainBarItem(Activity activity, BaseScreenMode abstractC2934a) throws Resources.NotFoundException {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        super(activity);
        this.f15595e = null;
        this.f15596f = null;
        this.f15597g = null;
        this.f15598h = null;
        this.f15599i = null;
        this.f15600j = null;
        this.f15601k = 0;
        this.f15602l = null;
        this.f15603m = 0;
        this.f15604n = 0;
        this.f15606p = true;
        this.f15608r = 0;
        this.f15609s = null;
        this.f15610t = false;
        this.f15611u = -1;
        this.f15612v = null;
        this.f15613w = null;
        this.f15595e = activity;
        Util.m24489q(this.f15595e.getApplicationContext());
        this.f15605o = this.f15595e.getApplication().getResources();
        if (1 == (abstractC2934a == null ? 0 : abstractC2934a.mo16539j())) {
            this.f15601k = this.f15605o.getDimensionPixelSize(R.dimen.fold_full_professional_params_item_image_margin_top);
            f15591a = this.f15605o.getDimensionPixelSize(R.dimen.fold_full_professional_params_item_image_margin_top);
            f15592b = this.f15605o.getDimensionPixelSize(R.dimen.fold_full_professional_params_selector_margin_top);
            this.f15603m = this.f15605o.getDimensionPixelSize(R.dimen.fold_full_professional_params_item_value_text_margin_top);
            dimensionPixelSize = this.f15605o.getDimensionPixelSize(R.dimen.fold_full_professional_params_background_size);
            dimensionPixelSize2 = this.f15605o.getDimensionPixelSize(R.dimen.fold_full_professional_params_selector_size);
            this.f15608r = (this.f15605o.getDimensionPixelSize(R.dimen.fold_full_professional_params_item_width) - dimensionPixelSize2) / 2;
        } else {
            this.f15601k = this.f15605o.getDimensionPixelSize(R.dimen.main_mode_bar_item_title_image_margin);
            f15591a = this.f15605o.getDimensionPixelSize(R.dimen.main_mode_bar_item_title_image_margin_top);
            f15592b = this.f15605o.getDimensionPixelSize(R.dimen.main_mode_bar_item_frame_image_margin_top);
            this.f15603m = this.f15605o.getDimensionPixelSize(R.dimen.main_mode_bar_item_value_text_margin_top);
            dimensionPixelSize = this.f15605o.getDimensionPixelSize(R.dimen.main_mode_bar_item_image_width);
            dimensionPixelSize2 = this.f15605o.getDimensionPixelSize(R.dimen.main_mode_bar_item_frame_width);
            this.f15608r = 0;
        }
        this.f15604n = this.f15605o.getDimensionPixelSize(R.dimen.main_mode_bar_item_value_auto_image_padding);
        this.f15593c = ContextCompat.m2254c(this.f15595e, R.color.camera_white);
        this.f15594d = Util.m24164A(this.f15595e);
        this.f15596f = new RotateLottieAnimationView(this.f15595e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        this.f15596f.setBackgroundResource(R.drawable.main_bar_button_bg);
        this.f15596f.setLayoutParams(layoutParams);
        if (Util.m24495t()) {
            if (abstractC2934a != null && abstractC2934a.mo16631r() && !abstractC2934a.mo16630q()) {
                z = true;
            }
            this.f15596f.setLightBackground(z);
        } else {
            this.f15596f.setLightBackground(Util.m24178H() == 2);
        }
        addView(this.f15596f);
        this.f15599i = new ProfessionalTextView(this.f15595e);
        m15719a(this.f15599i);
        addView(this.f15599i);
        this.f15602l = new View(this.f15595e);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2);
        this.f15602l.setBackgroundResource(R.drawable.main_mode_bar_item_select_highlight);
        this.f15602l.setVisibility(4);
        addView(this.f15602l, layoutParams2);
        this.f15600j = new ProfessionalTextView(this.f15595e);
        m15719a(this.f15600j);
        this.f15600j.setVisibility(8);
        this.f15600j.setText(R.string.camera_professional_disable_title);
        this.f15600j.setTextColor(getResources().getColor(R.color.camera_white));
        addView(this.f15600j);
        this.f15597g = new RelativeLayout(this.f15595e);
        this.f15598h = new ShadowImageView(this.f15595e);
        this.f15598h.setImageDrawable(Util.m24376b(getContext(), R.drawable.pro_ic_tips_auto_bg));
        this.f15598h.setImageTintList(ColorStateList.valueOf(ContextCompat.m2254c(this.f15595e, R.color.camera_white)));
        this.f15598h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f15597g.addView(this.f15598h);
        ImageView imageView = new ImageView(this.f15595e);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.f15605o.getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_width), this.f15605o.getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_height));
        layoutParams3.addRule(13);
        imageView.setLayoutParams(layoutParams3);
        imageView.setImageResource(R.drawable.pro_ic_tips_auto_img);
        this.f15597g.addView(imageView);
        this.f15597g.setLayoutParams(new RelativeLayout.LayoutParams(this.f15605o.getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_width), this.f15605o.getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_width)));
        this.f15597g.setVisibility(8);
        addView(this.f15597g);
        this.f15609s = ProfessionalAnimUtil.m15923a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15719a(ProfessionalTextView c2905w) throws Resources.NotFoundException {
        c2905w.setHeight(this.f15605o.getDimensionPixelSize(R.dimen.main_mode_bar_item_value_text_height));
        c2905w.setVerticalDraw(true);
        c2905w.setIncludeFontPadding(false);
        c2905w.setTextSize(0, this.f15605o.getDimensionPixelSize(R.dimen.main_mode_bar_item_value_text_size));
        c2905w.setTypeface(Util.m24411c(true));
        c2905w.setGravity(17);
        c2905w.setTextColor(this.f15593c);
        c2905w.setShadowLayer(this.f15605o.getDimension(R.dimen.main_mode_bar_item_text_shadow_radius), 0.0f, 0.0f, R.color.color_black_with_30_percent_transparency);
        Util.m24275a((TextView) c2905w);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15725a(boolean z) {
        this.f15606p = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15724a(int OplusGLSurfaceView_13, boolean z) {
        RelativeLayout relativeLayout;
        if (!this.f15606p || (relativeLayout = this.f15597g) == null || OplusGLSurfaceView_13 == relativeLayout.getVisibility()) {
            return;
        }
        if (OplusGLSurfaceView_13 == 0) {
            if (z) {
                Util.m24273a(this.f15597g, 250, ProfessionalAnimConstant.f15694a);
                return;
            } else {
                this.f15597g.setVisibility(0);
                return;
            }
        }
        if (z) {
            Util.m24268a(this.f15597g, 250, 0, ProfessionalAnimConstant.f15694a);
        } else {
            this.f15597g.setVisibility(8);
        }
    }

    public void setItemTitleImage(final int OplusGLSurfaceView_13) {
        Activity activity = this.f15595e;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.OplusGLSurfaceView_14.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MainBarItem.this.f15596f != null) {
                        MainBarItem.this.f15596f.setImageResource(OplusGLSurfaceView_13);
                        MainBarItem.this.f15596f.measure(Util.getScreenWidth(), Util.m24193U());
                    }
                }
            });
        }
    }

    public void setItemValueText(String str) {
        this.f15607q = str;
        String strM16136a = ProfessionalUtil.m16136a(str);
        if (strM16136a != null && strM16136a.length() < ProfessionalTextView.f15810a) {
            this.f15599i.setVerticalDraw(false);
        }
        this.f15599i.setText(strM16136a);
        this.f15599i.setContentDescription(strM16136a);
        this.f15599i.measure(Util.getScreenWidth(), Util.m24193U());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15726a(boolean z, boolean z2) {
        int OplusGLSurfaceView_13 = z ? 500 : 250;
        if (!z2) {
            OplusGLSurfaceView_13 = 0;
        }
        ProfessionalAnimUtil.m15925a(this.f15596f, z, OplusGLSurfaceView_13);
    }

    public void setItemAnimation(int OplusGLSurfaceView_13) {
        RotateLottieAnimationView rotateLottieAnimationView = this.f15596f;
        if (rotateLottieAnimationView != null) {
            rotateLottieAnimationView.setAnimation(OplusGLSurfaceView_13);
        }
        this.f15611u = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m15722b() {
        return this.f15611u > 0;
    }

    public String getItemValueText() {
        return this.f15607q;
    }

    @Override // android.view.View
    public Object getTag(int OplusGLSurfaceView_13) {
        if (R.id_renamed.touch_area_tag == OplusGLSurfaceView_13) {
            Rect rect = new Rect();
            this.f15596f.getDrawingRect(rect);
            rect.offset(this.f15608r, 0);
            return new Rect(rect.left + this.f15601k, rect.top + this.f15601k, rect.right + this.f15601k, rect.bottom + this.f15601k);
        }
        return super.getTag(OplusGLSurfaceView_13);
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        boolean zIsPressed = isPressed();
        super.setPressed(z);
        if (zIsPressed == z || !hasWindowFocus() || m15722b()) {
            return;
        }
        m15721b(z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m15721b(boolean z) {
        Animator animator = this.f15612v;
        Float fValueOf = Float.valueOf(1.0f);
        if (animator == null) {
            this.f15612v = ObjectAnimator.ofObject(this.f15602l, "alpha", new FloatEvaluator(), 0, fValueOf);
            this.f15612v.setDuration(250L);
            this.f15612v.setInterpolator(ProfessionalAnimConstant.f15694a);
            this.f15612v.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.professional.OplusGLSurfaceView_14.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    MainBarItem.this.f15602l.setVisibility(0);
                    MainBarItem.this.f15602l.setAlpha(0.0f);
                }
            });
        } else if (animator.isRunning()) {
            this.f15612v.cancel();
        }
        Animator animator2 = this.f15613w;
        if (animator2 == null) {
            this.f15613w = ObjectAnimator.ofObject(this.f15602l, "alpha", new FloatEvaluator(), fValueOf, 0);
            this.f15613w.setDuration(250L);
            this.f15613w.setInterpolator(ProfessionalAnimConstant.f15694a);
            this.f15613w.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.professional.OplusGLSurfaceView_14.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator3) {
                    MainBarItem.this.f15602l.setVisibility(0);
                    MainBarItem.this.f15602l.setAlpha(1.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator3) {
                    MainBarItem.this.f15602l.setVisibility(4);
                }
            });
        } else if (animator2.isRunning()) {
            this.f15613w.cancel();
        }
        if (z) {
            this.f15612v.start();
        } else {
            this.f15613w.start();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int measuredHeight;
        int i5 = i3 - OplusGLSurfaceView_13;
        RotateLottieAnimationView rotateLottieAnimationView = this.f15596f;
        if (rotateLottieAnimationView != null) {
            int measuredWidth = rotateLottieAnimationView.getMeasuredWidth();
            int measuredHeight2 = this.f15596f.getMeasuredHeight();
            int i6 = (i5 - measuredWidth) / 2;
            RotateLottieAnimationView rotateLottieAnimationView2 = this.f15596f;
            int i7 = this.f15601k;
            rotateLottieAnimationView2.layout(i6, i7, measuredWidth + i6, measuredHeight2 + i7);
        }
        ProfessionalTextView c2905w = this.f15599i;
        int measuredWidth2 = 0;
        if (c2905w != null) {
            measuredWidth2 = c2905w.getMeasuredWidth();
            measuredHeight = this.f15599i.getMeasuredHeight();
            int i8 = (i5 - measuredWidth2) / 2;
            ProfessionalTextView c2905w2 = this.f15599i;
            int i9 = this.f15603m;
            c2905w2.layout(i8, i9, i8 + measuredWidth2, i9 + measuredHeight);
        } else {
            measuredHeight = 0;
        }
        RelativeLayout relativeLayout = this.f15597g;
        if (relativeLayout != null) {
            int measuredWidth3 = relativeLayout.getMeasuredWidth();
            int measuredHeight3 = this.f15597g.getMeasuredHeight();
            int i10 = (((i5 - measuredWidth2) / 2) - this.f15604n) - measuredWidth3;
            int i11 = this.f15603m + ((measuredHeight - measuredHeight3) / 2);
            this.f15597g.layout(i10, i11, measuredWidth3 + i10, measuredHeight3 + i11);
        }
        ProfessionalTextView c2905w3 = this.f15600j;
        if (c2905w3 != null) {
            int measuredWidth4 = c2905w3.getMeasuredWidth();
            int measuredHeight4 = this.f15600j.getMeasuredHeight();
            int i12 = (i5 - measuredWidth4) / 2;
            ProfessionalTextView c2905w4 = this.f15600j;
            int i13 = this.f15603m;
            c2905w4.layout(i12, i13, measuredWidth4 + i12, measuredHeight4 + i13);
        }
        View view = this.f15602l;
        if (view != null) {
            int measuredWidth5 = view.getMeasuredWidth();
            int measuredHeight5 = this.f15602l.getMeasuredHeight();
            int i14 = (i5 - measuredWidth5) / 2;
            View view2 = this.f15602l;
            int i15 = f15592b;
            view2.layout(i14, i15, measuredWidth5 + i14, measuredHeight5 + i15);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15727b(boolean z, boolean z2) {
        RelativeLayout relativeLayout;
        boolean zIsEnabled = isEnabled();
        super.setEnabled(z);
        if (zIsEnabled == z) {
            return;
        }
        if (m15722b()) {
            RotateLottieAnimationView rotateLottieAnimationView = this.f15596f;
            if (rotateLottieAnimationView != null && z) {
                rotateLottieAnimationView.m5519f();
                this.f15596f.setProgress(0.0f);
            }
        } else {
            ProfessionalTextView c2905w = this.f15599i;
            if (c2905w != null) {
                c2905w.setVisibility(z ? 0 : 4);
            }
            if (this.f15606p && (relativeLayout = this.f15597g) != null) {
                relativeLayout.setVisibility(z ? 0 : 4);
            }
            ProfessionalTextView c2905w2 = this.f15600j;
            if (c2905w2 != null) {
                c2905w2.setVisibility(z ? 4 : 0);
            }
        }
        ProfessionalAnimUtil.m15926a(this.f15596f, z ? 0.3f : 1.0f, z ? 1.0f : 0.3f, z2 ? 250 : 0, null);
    }

    public void setTouched(boolean z) {
        if (this.f15610t == z) {
            return;
        }
        this.f15610t = z;
        ProfessionalAnimUtil.m15924a(this.f15596f, this.f15609s, z);
        ProfessionalAnimUtil.m15924a(this.f15602l, this.f15609s, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15723a() {
        RotateLottieAnimationView rotateLottieAnimationView;
        if (!m15722b() || (rotateLottieAnimationView = this.f15596f) == null) {
            return;
        }
        rotateLottieAnimationView.m5507a();
    }

    public void setLightBackground(boolean z) {
        RotateLottieAnimationView rotateLottieAnimationView = this.f15596f;
        if (rotateLottieAnimationView != null) {
            rotateLottieAnimationView.setLightBackground(z);
        }
    }
}
