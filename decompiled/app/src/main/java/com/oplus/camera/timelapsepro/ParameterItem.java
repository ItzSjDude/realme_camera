package com.oplus.camera.timelapsepro;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.p027a.ContextCompat;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotateLottieAnimationView;
import com.oplus.camera.professional.ProfessionalAnimConstant;
import com.oplus.camera.professional.ProfessionalAnimUtil;
import com.oplus.camera.timelapsepro.p170a.ProParameter;
import com.oplus.camera.util.Util;
import com.p078a.p079a.Spring;

/* loaded from: classes2.dex */
public class ParameterItem extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private final ImageView f16652a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final RelativeLayout f16653b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final RotateLottieAnimationView f16654c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final TextView f16655d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final ImageView f16656e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ProParameter f16657f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private AnimatorSet f16658g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f16659h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Handler f16660i;

    public ParameterItem(Context context) {
        this(context, null);
    }

    public ParameterItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ParameterItem(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f16659h = false;
        this.f16660i = null;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.time_lapse_pro_param_item, this);
        setLayoutParams(new RelativeLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_param_item_width), getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_param_item_height)));
        setClipChildren(false);
        setClipToPadding(false);
        this.f16652a = (ImageView) viewInflate.findViewById(R.id_renamed.icon_select);
        this.f16653b = (RelativeLayout) viewInflate.findViewById(R.id_renamed.icon_bg);
        this.f16654c = (RotateLottieAnimationView) viewInflate.findViewById(R.id_renamed.icon);
        this.f16655d = (TextView) viewInflate.findViewById(R.id_renamed.name);
        this.f16656e = (ImageView) viewInflate.findViewById(R.id_renamed.auto);
        this.f16655d.setShadowLayer(getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_radius_size), getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dx), getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dy), ContextCompat.m2254c(context, R.color.color_black_with_full_percent_transparency));
        this.f16660i = new Handler(Looper.getMainLooper());
        m17386d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m17386d() {
        final Spring c1032fM15923a = ProfessionalAnimUtil.m15923a();
        setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.timelapsepro.ParameterItem.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    ProfessionalAnimUtil.m15924a((View) ParameterItem.this.f16652a, c1032fM15923a, true);
                    ProfessionalAnimUtil.m15924a((View) ParameterItem.this.f16653b, c1032fM15923a, true);
                } else if (action == 1 || action == 3) {
                    ProfessionalAnimUtil.m15924a((View) ParameterItem.this.f16652a, c1032fM15923a, false);
                    ProfessionalAnimUtil.m15924a((View) ParameterItem.this.f16653b, c1032fM15923a, false);
                }
                return false;
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17389a(ProParameter abstractC3051e, ProParameter.IntrinsicsJvm.kt_4 bVar) {
        CameraLog.m12954a("ParameterItem", "setData, parameter: " + abstractC3051e + ", callback: " + bVar);
        this.f16657f = abstractC3051e;
        this.f16654c.setImageResource(abstractC3051e.mo17439c());
        this.f16655d.setText(abstractC3051e.mo17441e());
        this.f16656e.setVisibility((abstractC3051e.mo17437a() && abstractC3051e.m17451g()) ? 0 : 8);
        if (this.f16657f.m17452h() != isEnabled()) {
            setItemEnabled(this.f16657f.m17452h());
        }
        if (this.f16657f.mo17457m()) {
            this.f16654c.setAnimation(this.f16657f.mo17456l());
            this.f16659h = true;
        }
        this.f16657f.m17444a(new C30362());
        this.f16657f.m17445a(bVar);
    }

    /* renamed from: com.oplus.camera.timelapsepro.ParameterItem$2 */
    class C30362 implements ProParameter.PlatformImplementations.kt_3 {
        C30362() {
        }

        @Override // com.oplus.camera.timelapsepro.p170a.ProParameter.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo17393a() {
            if (ParameterItem.this.f16660i != null) {
                ParameterItem.this.f16660i.post(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$ParameterItem$2$Yon49sGBhrE7ih-hoRJBGdFHYSQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m17392b();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_4 */
        public /* synthetic */ void m17392b() {
            ParameterItem.this.m17391c();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17387a() {
        ProParameter abstractC3051e = this.f16657f;
        if (abstractC3051e != null) {
            abstractC3051e.m17444a((ProParameter.PlatformImplementations.kt_3) null);
            this.f16657f.m17445a((ProParameter.IntrinsicsJvm.kt_4) null);
        }
        Handler handler = this.f16660i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f16660i = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17390b() {
        if (this.f16659h) {
            this.f16654c.m5507a();
        }
    }

    public ProParameter getProParameter() {
        return this.f16657f;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17391c() {
        Util.m24271a(this.f16652a, this.f16657f.m17453i() ? 0 : 4, (Animation.AnimationListener) null, this.f16657f.m17453i() ? 280L : 150L, 0L, ProfessionalAnimConstant.f15694a);
        this.f16655d.setText(this.f16657f.mo17441e());
        Util.m24270a(this.f16656e, (this.f16657f.mo17437a() && this.f16657f.m17451g()) ? 0 : 8, (Animation.AnimationListener) null, 250L);
        if (this.f16657f.m17452h() != isEnabled()) {
            setItemEnabled(this.f16657f.m17452h());
        }
    }

    public void setItemEnabled(final boolean z) {
        ObjectAnimator objectAnimatorOfFloat;
        setEnabled(z);
        if (z && this.f16657f.mo17457m()) {
            this.f16654c.m5519f();
            this.f16654c.setProgress(0.0f);
        }
        AnimatorSet animatorSet = this.f16658g;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f16658g.end();
        }
        if (z) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f16654c, "alpha", 0.2f, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f16654c, "alpha", 1.0f, 0.2f);
        }
        objectAnimatorOfFloat.setInterpolator(ProfessionalAnimConstant.f15694a);
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.timelapsepro.ParameterItem.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ParameterItem.this.f16654c.setAlpha(z ? 1.0f : 0.2f);
            }
        });
        this.f16658g = new AnimatorSet();
        this.f16658g.play(objectAnimatorOfFloat);
        this.f16658g.start();
    }

    public void setText(String str) {
        this.f16655d.setText(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17388a(int OplusGLSurfaceView_13, int i2, boolean z) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (OplusGLSurfaceView_13 == 1) {
            this.f16653b.setSelected(true);
            layoutParams.width = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_param_item_width);
            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_param_item_height_full_screen);
            return;
        }
        if (OplusGLSurfaceView_13 == 2) {
            this.f16653b.setSelected(false);
            layoutParams.width = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_param_item_width);
            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_param_item_height);
        } else if (OplusGLSurfaceView_13 == 3) {
            this.f16653b.setSelected(false);
            layoutParams.width = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_param_item_width_rack);
            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_param_item_height);
        } else {
            if (OplusGLSurfaceView_13 != 4) {
                return;
            }
            this.f16653b.setSelected(!z);
            layoutParams.width = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_param_item_width);
            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_param_item_height);
        }
    }
}
