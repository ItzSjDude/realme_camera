package com.oplus.camera.filmvideomode;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.p027a.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotateLottieAnimationView;
import com.oplus.camera.professional.ProfessionalAnimConstant;
import com.oplus.camera.professional.ProfessionalAnimUtil;
import com.oplus.camera.professional.ProfessionalTextView;
import com.oplus.camera.professional.ProfessionalUtil;
import com.oplus.camera.util.Util;
import com.p078a.p079a.Spring;

/* compiled from: FilmMainBarItem.java */
/* renamed from: com.oplus.camera.filmvideomode.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class FilmMainBarItem extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f13617a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f13618b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RelativeLayout f13619c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f13620d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Activity f13621e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private RotateLottieAnimationView f13622f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private LottieAnimationView f13623g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ImageView f13624h;

    /* renamed from: OplusGLSurfaceView_13 */
    private ProfessionalTextView f13625i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ProfessionalTextView f13626j;

    /* renamed from: OplusGLSurfaceView_5 */
    private ImageView f13627k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f13628l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f13629m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Resources f13630n;

    /* renamed from: o */
    private boolean f13631o;

    /* renamed from: p */
    private String f13632p;

    /* renamed from: q */
    private Spring f13633q;

    /* renamed from: r */
    private boolean f13634r;

    /* renamed from: s */
    private int f13635s;

    /* renamed from: t */
    private int f13636t;

    /* renamed from: u */
    private boolean f13637u;

    public FilmMainBarItem(Activity activity) {
        super(activity);
        this.f13617a = 0;
        this.f13618b = 0;
        this.f13619c = null;
        this.f13620d = 0;
        this.f13621e = null;
        this.f13622f = null;
        this.f13623g = null;
        this.f13624h = null;
        this.f13625i = null;
        this.f13626j = null;
        this.f13627k = null;
        this.f13628l = 0;
        this.f13629m = 0;
        this.f13630n = null;
        this.f13631o = true;
        this.f13632p = null;
        this.f13633q = null;
        this.f13634r = false;
        this.f13635s = -1;
        this.f13636t = -1;
        this.f13637u = false;
        this.f13621e = activity;
        Util.m24489q(this.f13621e.getApplicationContext());
        this.f13630n = this.f13621e.getApplication().getResources();
        this.f13620d = this.f13630n.getDimensionPixelSize(R.dimen.main_mode_bar_item_title_image_margin_top);
        this.f13628l = this.f13630n.getDimensionPixelSize(R.dimen.main_mode_bar_item_value_text_margin_top);
        this.f13629m = this.f13630n.getDimensionPixelSize(R.dimen.main_mode_bar_item_value_auto_image_padding);
        this.f13617a = ContextCompat.m2254c(this.f13621e, R.color.camera_white);
        this.f13618b = Util.m24164A(this.f13621e);
        this.f13622f = new RotateLottieAnimationView(this.f13621e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f13630n.getDimensionPixelSize(R.dimen.film_params_item_bg_width), this.f13630n.getDimensionPixelSize(R.dimen.film_params_item_bg_height));
        this.f13622f.setBackgroundResource(R.drawable.film_params_item_bg_selected);
        this.f13622f.setLayoutParams(layoutParams);
        this.f13622f.setAlpha(0.0f);
        addView(this.f13622f);
        this.f13623g = new RotateLottieAnimationView(this.f13621e);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f13630n.getDimensionPixelSize(R.dimen.main_mode_bar_item_image_width), this.f13630n.getDimensionPixelSize(R.dimen.main_mode_bar_item_image_height));
        this.f13623g.setBackgroundResource(Util.m24498u() ? R.drawable.common_button_bg_light : R.drawable.common_button_bg);
        this.f13623g.setLayoutParams(layoutParams2);
        addView(this.f13623g);
        this.f13625i = new ProfessionalTextView(this.f13621e);
        m13490a(this.f13625i);
        addView(this.f13625i);
        this.f13626j = new ProfessionalTextView(this.f13621e);
        m13490a(this.f13626j);
        this.f13626j.setVisibility(8);
        this.f13626j.setText(R.string.camera_professional_disable_title);
        this.f13626j.setAlpha(0.3f);
        addView(this.f13626j);
        this.f13619c = new RelativeLayout(this.f13621e);
        this.f13624h = new ImageView(this.f13621e);
        this.f13624h.setImageDrawable(Util.m24376b(getContext(), R.drawable.pro_ic_tips_auto_bg));
        this.f13624h.setImageTintList(ColorStateList.valueOf(ContextCompat.m2254c(this.f13621e, R.color.camera_white)));
        this.f13624h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f13619c.addView(this.f13624h);
        this.f13627k = new ImageView(this.f13621e);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.f13630n.getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_width), this.f13630n.getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_height));
        layoutParams3.addRule(13);
        this.f13627k.setLayoutParams(layoutParams3);
        this.f13627k.setImageResource(R.drawable.pro_ic_tips_auto_img);
        this.f13619c.addView(this.f13627k);
        this.f13619c.setLayoutParams(new RelativeLayout.LayoutParams(this.f13630n.getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_width), this.f13630n.getDimensionPixelSize(R.dimen.main_mode_bar_item_auto_width)));
        this.f13619c.setVisibility(0);
        addView(this.f13619c);
        this.f13633q = ProfessionalAnimUtil.m15923a();
        this.f13620d = getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_title_image_margin_top_rotated);
        this.f13628l = getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_value_text_margin_top_rotated);
        if (Util.m24498u()) {
            this.f13628l += this.f13620d;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13490a(ProfessionalTextView c2905w) {
        c2905w.setHeight(this.f13630n.getDimensionPixelSize(R.dimen.main_mode_bar_item_value_text_height));
        c2905w.setVerticalDraw(true);
        c2905w.setIncludeFontPadding(false);
        c2905w.setTextSize(0, this.f13630n.getDimensionPixelSize(R.dimen.main_mode_bar_item_value_text_size));
        c2905w.setGravity(17);
        c2905w.setTextColor(this.f13617a);
        c2905w.setShadowLayer(this.f13630n.getDimension(R.dimen.main_mode_bar_item_text_shadow_radius), 0.0f, 0.0f, R.color.color_black_with_30_percent_transparency);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13493a(boolean z) {
        this.f13631o = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13492a(int OplusGLSurfaceView_13, boolean z) {
        if (this.f13631o) {
            CameraLog.m12959b("FilmMainBarItem", "setItemAutoVisibility, visibility: " + OplusGLSurfaceView_13 + ", item: " + ((Object) this.f13625i.getText()));
            ImageView imageView = this.f13624h;
            if (imageView == null || this.f13627k == null || OplusGLSurfaceView_13 == imageView.getVisibility()) {
                return;
            }
            if (OplusGLSurfaceView_13 == 0) {
                if (z) {
                    Util.m24273a(this.f13624h, 250, ProfessionalAnimConstant.f15694a);
                    Util.m24273a(this.f13627k, 250, ProfessionalAnimConstant.f15694a);
                    return;
                } else {
                    this.f13624h.setVisibility(0);
                    this.f13627k.setVisibility(0);
                    return;
                }
            }
            if (z) {
                Util.m24268a(this.f13624h, 250, 0, ProfessionalAnimConstant.f15694a);
                Util.m24268a(this.f13627k, 250, 0, ProfessionalAnimConstant.f15694a);
            } else {
                this.f13624h.setVisibility(8);
                this.f13627k.setVisibility(8);
            }
        }
    }

    public void setItemIndex(int OplusGLSurfaceView_13) {
        this.f13637u = this.f13636t != OplusGLSurfaceView_13;
        this.f13636t = OplusGLSurfaceView_13;
    }

    public void setItemTitleImage(final int OplusGLSurfaceView_13) {
        Activity activity = this.f13621e;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.filmvideomode.IntrinsicsJvm.kt_5.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FilmMainBarItem.this.f13623g != null) {
                        FilmMainBarItem.this.f13623g.setImageResource(OplusGLSurfaceView_13);
                        FilmMainBarItem.this.f13623g.measure(Util.getScreenWidth(), Util.m24193U());
                    }
                }
            });
        }
    }

    public void setItemValueText(String str) {
        if (!isEnabled() && 4 == this.f13636t) {
            str = this.f13621e.getString(R.string.camera_professional_disable_title);
        }
        this.f13632p = str;
        String strM16136a = ProfessionalUtil.m16136a(str);
        if (strM16136a != null && strM16136a.length() < ProfessionalTextView.f15810a) {
            this.f13625i.setVerticalDraw(false);
        }
        this.f13625i.setText(strM16136a);
        this.f13625i.setContentDescription(strM16136a);
        this.f13625i.measure(Util.getScreenWidth(), Util.m24193U());
    }

    public void setItemAnimation(int OplusGLSurfaceView_13) {
        LottieAnimationView lottieAnimationView = this.f13623g;
        if (lottieAnimationView != null && -1 != OplusGLSurfaceView_13) {
            lottieAnimationView.setAnimation(OplusGLSurfaceView_13);
        }
        this.f13635s = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m13491a() {
        return this.f13635s > 0;
    }

    public String getItemValueText() {
        return this.f13632p;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        m13494a(z, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13494a(boolean z, boolean z2) {
        if (m13491a()) {
            LottieAnimationView lottieAnimationView = this.f13623g;
            if (lottieAnimationView != null && z) {
                lottieAnimationView.m5507a();
            }
            this.f13622f.setAlpha(0.0f);
            return;
        }
        boolean zIsSelected = isSelected();
        super.setSelected(z);
        CameraLog.m12959b("FilmMainBarItem", "setSelected, selected: " + z + ", bPressed: " + zIsSelected + ", animation: " + z2);
        if (zIsSelected == z) {
            return;
        }
        this.f13622f.animate().cancel();
        if (z2) {
            this.f13622f.animate().alpha(z ? 1.0f : 0.0f).setInterpolator(ProfessionalAnimConstant.f15694a).setDuration(250L).start();
        } else {
            this.f13622f.setAlpha(z ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int measuredHeight;
        int i5 = i3 - OplusGLSurfaceView_13;
        RotateLottieAnimationView rotateLottieAnimationView = this.f13622f;
        int measuredWidth = 0;
        if (rotateLottieAnimationView != null) {
            int measuredWidth2 = rotateLottieAnimationView.getMeasuredWidth();
            int i6 = (i5 - measuredWidth2) / 2;
            this.f13622f.layout(i6, 0, measuredWidth2 + i6, this.f13622f.getMeasuredHeight());
        }
        LottieAnimationView lottieAnimationView = this.f13623g;
        if (lottieAnimationView != null) {
            int measuredWidth3 = lottieAnimationView.getMeasuredWidth();
            int measuredHeight2 = this.f13623g.getMeasuredHeight();
            int i7 = (i5 - measuredWidth3) / 2;
            LottieAnimationView lottieAnimationView2 = this.f13623g;
            int i8 = this.f13620d;
            lottieAnimationView2.layout(i7, i8, measuredWidth3 + i7, measuredHeight2 + i8);
        }
        ProfessionalTextView c2905w = this.f13625i;
        if (c2905w != null) {
            measuredWidth = c2905w.getMeasuredWidth();
            measuredHeight = this.f13625i.getMeasuredHeight();
            int i9 = (i5 - measuredWidth) / 2;
            ProfessionalTextView c2905w2 = this.f13625i;
            int i10 = this.f13628l;
            c2905w2.layout(i9, i10, i9 + measuredWidth, i10 + measuredHeight);
        } else {
            measuredHeight = 0;
        }
        RelativeLayout relativeLayout = this.f13619c;
        if (relativeLayout != null) {
            int measuredWidth4 = relativeLayout.getMeasuredWidth();
            int measuredHeight3 = this.f13619c.getMeasuredHeight();
            int i11 = (((i5 - measuredWidth) / 2) - this.f13629m) - measuredWidth4;
            int i12 = this.f13628l + ((measuredHeight - measuredHeight3) / 2);
            this.f13619c.layout(i11, i12, measuredWidth4 + i11, measuredHeight3 + i12);
        }
        ProfessionalTextView c2905w3 = this.f13626j;
        if (c2905w3 != null) {
            int measuredWidth5 = c2905w3.getMeasuredWidth();
            int measuredHeight4 = this.f13626j.getMeasuredHeight();
            int i13 = (i5 - measuredWidth5) / 2;
            ProfessionalTextView c2905w4 = this.f13626j;
            int i14 = this.f13628l;
            c2905w4.layout(i13, i14, measuredWidth5 + i13, measuredHeight4 + i14);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13495b(boolean z, boolean z2) {
        RelativeLayout relativeLayout;
        int OplusGLSurfaceView_13;
        CameraLog.m12959b("FilmMainBarItem", "setEnabled, enabled: " + z + ", isEnable: " + isEnabled() + ", mDataChanged: " + this.f13637u);
        boolean zIsEnabled = isEnabled();
        super.setEnabled(z);
        if (zIsEnabled == z) {
            LottieAnimationView lottieAnimationView = this.f13623g;
            if (lottieAnimationView == null || lottieAnimationView.m5517d()) {
                return;
            }
            this.f13623g.m5519f();
            this.f13623g.setProgress(0.0f);
            this.f13623g.refreshDrawableState();
            this.f13623g.invalidate();
            return;
        }
        if (!z && (4 == (OplusGLSurfaceView_13 = this.f13636t) || 3 == OplusGLSurfaceView_13)) {
            this.f13625i.setText(this.f13621e.getString(R.string.camera_professional_disable_title));
        } else {
            this.f13625i.setText(this.f13632p);
        }
        if (m13491a()) {
            LottieAnimationView lottieAnimationView2 = this.f13623g;
            if (lottieAnimationView2 != null && z) {
                lottieAnimationView2.m5519f();
                this.f13623g.setProgress(0.0f);
            }
        } else {
            if (this.f13631o && (relativeLayout = this.f13619c) != null) {
                relativeLayout.setVisibility(z ? 0 : 4);
            }
            this.f13625i.setAlpha(z ? 1.0f : 0.3f);
        }
        ProfessionalAnimUtil.m15926a(this.f13623g, z ? 0.3f : 1.0f, z ? 1.0f : 0.3f, z2 ? 250 : 0, null);
    }

    public void setTouched(boolean z) {
        if (this.f13634r == z) {
            return;
        }
        this.f13634r = z;
        if (m13491a()) {
            return;
        }
        ProfessionalAnimUtil.m15924a(this.f13623g, this.f13633q, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        CameraLog.m12959b("FilmMainBarItem", "onAttachedToWindow, view: " + this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CameraLog.m12959b("FilmMainBarItem", "onDetachedFromWindow, view: " + this);
        LottieAnimationView lottieAnimationView = this.f13623g;
        if (lottieAnimationView != null) {
            lottieAnimationView.clearAnimation();
        }
    }
}
