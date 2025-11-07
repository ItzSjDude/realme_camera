package com.oplus.camera.professional;

import android.animation.Animator;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.p027a.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotateLottieAnimationView;
import com.oplus.camera.util.Util;
import com.p078a.p079a.Spring;

/* compiled from: HSMainBarItem.java */
/* renamed from: com.oplus.camera.professional.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class HSMainBarItem extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private static int f15444a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f15445b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f15446c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Activity f15447d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private LottieAnimationView f15448e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private TextView f15449f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ImageView f15450g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private RelativeLayout f15451h;

    /* renamed from: OplusGLSurfaceView_13 */
    private LinearLayout f15452i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ImageView f15453j;

    /* renamed from: OplusGLSurfaceView_5 */
    private ProfessionalTextView f15454k;

    /* renamed from: OplusGLSurfaceView_14 */
    private ProfessionalTextView f15455l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f15456m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f15457n;

    /* renamed from: o */
    private int f15458o;

    /* renamed from: p */
    private Resources f15459p;

    /* renamed from: q */
    private boolean f15460q;

    /* renamed from: r */
    private String f15461r;

    /* renamed from: s */
    private Spring f15462s;

    /* renamed from: t */
    private boolean f15463t;

    /* renamed from: u */
    private int f15464u;

    public HSMainBarItem(Activity activity, Boolean bool) {
        super(activity);
        this.f15447d = null;
        this.f15448e = null;
        this.f15449f = null;
        this.f15450g = null;
        this.f15451h = null;
        this.f15452i = null;
        this.f15453j = null;
        this.f15454k = null;
        this.f15455l = null;
        this.f15456m = 0;
        this.f15457n = 0;
        this.f15458o = 0;
        this.f15460q = true;
        this.f15462s = null;
        this.f15463t = false;
        this.f15464u = -1;
        this.f15447d = activity;
        Util.m24489q(this.f15447d.getApplicationContext());
        this.f15459p = this.f15447d.getApplication().getResources();
        f15444a = this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_image_margin_top);
        this.f15456m = this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_value_text_margin_top);
        this.f15458o = this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_value_text_interval);
        this.f15457n = this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_value_auto_image_padding);
        this.f15445b = ContextCompat.m2254c(this.f15447d, R.color.camera_white);
        this.f15446c = ContextCompat.m2254c(this.f15447d, R.color.camera_Hasu);
        if (bool.booleanValue()) {
            this.f15448e = new RotateLottieAnimationView(this.f15447d);
            this.f15448e.setLayoutParams(new RelativeLayout.LayoutParams(this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_reset_image_width), this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_reset_image_height)));
            this.f15448e.setBackgroundResource(R.drawable.main_bar_reset_bg);
            this.f15448e.setImageResource(R.drawable.professional_mode_ic_reset);
            this.f15448e.measure(Util.getScreenWidth(), Util.m24193U());
            addView(this.f15448e);
            this.f15454k = new ProfessionalTextView(this.f15447d);
            this.f15454k.setVisibility(8);
            this.f15455l = new ProfessionalTextView(this.f15447d);
            this.f15455l.setVisibility(8);
            this.f15451h = new RelativeLayout(this.f15447d);
            this.f15453j = new ImageView(this.f15447d);
            this.f15451h.addView(this.f15453j);
            this.f15451h.setVisibility(8);
            this.f15451h.addView(new ImageView(this.f15447d));
            this.f15451h.setVisibility(8);
            this.f15452i = new LinearLayout(this.f15447d);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.f15452i.setGravity(17);
            this.f15452i.setLayoutParams(layoutParams);
        } else {
            this.f15450g = new ImageView(this.f15447d);
            this.f15450g.setLayoutParams(new RelativeLayout.LayoutParams(this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_separate_width), this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_separate_height)));
            this.f15450g.setBackgroundColor(getResources().getColor(R.color.pro_separate_line));
            addView(this.f15450g);
            this.f15449f = new TextView(this.f15447d);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_image_height));
            layoutParams2.addRule(14);
            this.f15449f.setLayoutParams(layoutParams2);
            this.f15449f.setTextColor(getResources().getColor(R.color.camera_white));
            this.f15449f.setTextSize(0, this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_title_text_size));
            addView(this.f15449f);
            this.f15454k = new ProfessionalTextView(this.f15447d);
            m15442a(this.f15454k);
            this.f15455l = new ProfessionalTextView(this.f15447d);
            m15442a(this.f15455l);
            this.f15455l.setVisibility(8);
            this.f15455l.setText(R.string.camera_professional_disable_title);
            this.f15455l.setTextColor(getResources().getColor(R.color.camera_white));
            this.f15451h = new RelativeLayout(this.f15447d);
            this.f15453j = new ImageView(this.f15447d);
            this.f15453j.setImageDrawable(Util.m24376b(getContext(), R.drawable.pro_ic_tips_auto_bg));
            this.f15453j.setImageTintList(ColorStateList.valueOf(ContextCompat.m2254c(this.f15447d, R.color.camera_white)));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.addRule(17);
            this.f15453j.setLayoutParams(layoutParams3);
            this.f15451h.addView(this.f15453j);
            ImageView imageView = new ImageView(this.f15447d);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_auto_width), this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_auto_height));
            layoutParams4.addRule(17);
            imageView.setLayoutParams(layoutParams4);
            imageView.setImageResource(R.drawable.pro_ic_tips_auto_img);
            this.f15451h.addView(imageView);
            this.f15451h.setLayoutParams(new RelativeLayout.LayoutParams(this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_auto_width), this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_auto_width)));
            this.f15451h.setVisibility(8);
            this.f15452i = new LinearLayout(this.f15447d);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.weight = 1.0f;
            this.f15452i.setGravity(1);
            this.f15452i.setLayoutParams(layoutParams5);
        }
        addView(this.f15455l);
        this.f15452i.setClipChildren(false);
        this.f15452i.addView(this.f15451h);
        this.f15452i.addView(this.f15454k);
        addView(this.f15452i);
        this.f15462s = ProfessionalAnimUtil.m15923a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15442a(ProfessionalTextView c2905w) {
        c2905w.setHeight(this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_value_text_height));
        c2905w.setVerticalDraw(true);
        c2905w.setIncludeFontPadding(false);
        c2905w.setTextSize(0, this.f15459p.getDimensionPixelSize(R.dimen.hs_main_mode_bar_item_value_text_size));
        c2905w.setTypeface(Util.m24411c(true));
        c2905w.setGravity(17);
        c2905w.setTextColor(this.f15445b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15446a(boolean z) {
        this.f15460q = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15445a(int OplusGLSurfaceView_13, boolean z) {
        RelativeLayout relativeLayout;
        if (!this.f15460q || (relativeLayout = this.f15451h) == null || OplusGLSurfaceView_13 == relativeLayout.getVisibility()) {
            return;
        }
        if (OplusGLSurfaceView_13 == 0) {
            if (z) {
                Util.m24273a(this.f15451h, 250, ProfessionalAnimConstant.f15694a);
                return;
            } else {
                this.f15451h.setVisibility(0);
                return;
            }
        }
        if (z) {
            Util.m24268a(this.f15451h, 250, 0, ProfessionalAnimConstant.f15694a);
        } else {
            this.f15451h.setVisibility(8);
        }
    }

    public void setItemTitleImage(final String str) {
        Activity activity = this.f15447d;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.professional.COUIBaseListPopupWindow_12.1
                @Override // java.lang.Runnable
                public void run() {
                    if (HSMainBarItem.this.f15449f != null) {
                        HSMainBarItem.this.f15449f.setText(str);
                        HSMainBarItem.this.f15449f.measure(Util.getScreenWidth(), Util.m24193U());
                    }
                }
            });
        }
    }

    public void setItemValueText(String str) {
        this.f15461r = str;
        String strM16136a = ProfessionalUtil.m16136a(str);
        if (strM16136a != null && strM16136a.length() < ProfessionalTextView.f15810a) {
            this.f15454k.setVerticalDraw(false);
        }
        this.f15454k.setText(strM16136a);
        this.f15454k.setContentDescription(strM16136a);
        this.f15454k.measure(Util.getScreenWidth(), Util.m24193U());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15447a(boolean z, boolean z2) {
        int OplusGLSurfaceView_13 = z ? 500 : 250;
        if (!z2) {
            OplusGLSurfaceView_13 = 0;
        }
        ProfessionalAnimUtil.m15925a(this.f15448e, z, OplusGLSurfaceView_13);
    }

    public void setItemAnimation(int OplusGLSurfaceView_13) {
        LottieAnimationView lottieAnimationView = this.f15448e;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation(OplusGLSurfaceView_13);
        }
        this.f15464u = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m15443b() {
        return this.f15464u > 0;
    }

    public String getItemValueText() {
        return this.f15461r;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        boolean zIsPressed = isPressed();
        super.setPressed(z);
        if (zIsPressed == z || !hasWindowFocus() || m15443b()) {
            return;
        }
        int OplusGLSurfaceView_13 = z ? this.f15445b : this.f15446c;
        int i2 = z ? this.f15446c : this.f15445b;
        ProfessionalAnimUtil.m15927a(this.f15448e, OplusGLSurfaceView_13, i2, 250, (Interpolator) null, (Animator.AnimatorListener) null);
        ProfessionalAnimUtil.m15928a(this.f15449f, OplusGLSurfaceView_13, i2, 250, (Interpolator) null, (Animator.AnimatorListener) null);
        ProfessionalAnimUtil.m15928a(this.f15454k, OplusGLSurfaceView_13, i2, 250, (Interpolator) null, (Animator.AnimatorListener) null);
        ProfessionalAnimUtil.m15927a(this.f15453j, OplusGLSurfaceView_13, i2, 250, (Interpolator) null, (Animator.AnimatorListener) null);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int i5 = i3 - OplusGLSurfaceView_13;
        int i6 = i4 - i2;
        LottieAnimationView lottieAnimationView = this.f15448e;
        if (lottieAnimationView != null) {
            int measuredWidth = lottieAnimationView.getMeasuredWidth();
            int measuredHeight = this.f15448e.getMeasuredHeight();
            int i7 = (i5 - measuredWidth) / 2;
            int i8 = (i6 - measuredHeight) / 2;
            this.f15448e.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
        }
        TextView textView = this.f15449f;
        if (textView != null) {
            int measuredWidth2 = textView.getMeasuredWidth();
            int measuredHeight2 = this.f15449f.getMeasuredHeight();
            int i9 = (i5 - measuredWidth2) / 2;
            TextView textView2 = this.f15449f;
            int i10 = f15444a;
            textView2.layout(i9, i10, measuredWidth2 + i9, measuredHeight2 + i10);
        }
        LinearLayout linearLayout = this.f15452i;
        if (linearLayout != null) {
            int measuredWidth3 = linearLayout.getMeasuredWidth();
            ProfessionalTextView c2905w = this.f15454k;
            if (c2905w != null && this.f15451h != null) {
                measuredWidth3 = c2905w.getMeasuredWidth() + this.f15451h.getMeasuredWidth() + this.f15457n;
            }
            int measuredHeight3 = this.f15452i.getMeasuredHeight();
            int i11 = (i5 - measuredWidth3) / 2;
            LinearLayout linearLayout2 = this.f15452i;
            int i12 = this.f15456m;
            linearLayout2.layout(i11, i12, measuredWidth3 + i11, measuredHeight3 + i12);
        }
        ProfessionalTextView c2905w2 = this.f15455l;
        if (c2905w2 != null) {
            int measuredWidth4 = c2905w2.getMeasuredWidth();
            int measuredHeight4 = this.f15455l.getMeasuredHeight();
            int i13 = (i5 - measuredWidth4) / 2;
            ProfessionalTextView c2905w3 = this.f15455l;
            int i14 = this.f15456m;
            c2905w3.layout(i13, i14, measuredWidth4 + i13, measuredHeight4 + i14);
        }
        ImageView imageView = this.f15450g;
        if (imageView != null) {
            int measuredWidth5 = imageView.getMeasuredWidth();
            int measuredHeight5 = this.f15450g.getMeasuredHeight();
            int i15 = (i6 - measuredHeight5) / 2;
            this.f15450g.layout(0, i15, measuredWidth5, measuredHeight5 + i15);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15448b(boolean z, boolean z2) {
        RelativeLayout relativeLayout;
        boolean zIsEnabled = isEnabled();
        super.setEnabled(z);
        if (zIsEnabled == z) {
            return;
        }
        if (m15443b()) {
            LottieAnimationView lottieAnimationView = this.f15448e;
            if (lottieAnimationView != null && z) {
                lottieAnimationView.m5519f();
                this.f15448e.setProgress(0.0f);
            }
        } else {
            ProfessionalTextView c2905w = this.f15454k;
            if (c2905w != null) {
                c2905w.setVisibility(z ? 0 : 4);
            }
            if (this.f15460q && (relativeLayout = this.f15451h) != null) {
                relativeLayout.setVisibility(z ? 0 : 4);
            }
            ProfessionalTextView c2905w2 = this.f15455l;
            if (c2905w2 != null) {
                c2905w2.setVisibility(z ? 4 : 0);
            }
        }
        ProfessionalAnimUtil.m15926a(this.f15448e, z ? 0.3f : 1.0f, z ? 1.0f : 0.3f, z2 ? 250 : 0, null);
    }

    public void setTouched(boolean z) {
        if (this.f15463t == z) {
            return;
        }
        this.f15463t = z;
        ProfessionalAnimUtil.m15924a(this.f15448e, this.f15462s, z);
        ProfessionalAnimUtil.m15924a(this.f15449f, this.f15462s, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15444a() {
        LottieAnimationView lottieAnimationView;
        if (!m15443b() || (lottieAnimationView = this.f15448e) == null) {
            return;
        }
        lottieAnimationView.m5507a();
    }
}
