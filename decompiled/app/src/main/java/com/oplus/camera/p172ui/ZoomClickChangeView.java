package com.oplus.camera.p172ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.oplus.camera.ZoomManager;
import com.oplus.camera.ZoomUnit;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.preview.ZoomRotableTextView;
import com.oplus.camera.util.Util;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ZoomClickChangeView.java */
/* renamed from: com.oplus.camera.ui.x */
/* loaded from: classes2.dex */
public class ZoomClickChangeView extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f22917a = "x";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PlatformImplementations.kt_3 f22918b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private DecimalFormat f22919c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ZoomUnit f22920d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f22921e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Animation f22922f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Animation f22923g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f22924h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f22925i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f22926j;

    /* renamed from: OplusGLSurfaceView_5 */
    private long f22927k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f22928l;

    /* renamed from: OplusGLSurfaceView_6 */
    private List<Float> f22929m;

    /* renamed from: OplusGLSurfaceView_11 */
    private List<RotableTextView> f22930n;

    /* renamed from: o */
    private ValueAnimator f22931o;

    /* renamed from: p */
    private int f22932p;

    /* compiled from: ZoomClickChangeView.java */
    /* renamed from: com.oplus.camera.ui.x$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo11560a(float COUIBaseListPopupWindow_12);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo11561a(float COUIBaseListPopupWindow_12, boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo11562a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo11563b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo11564b(float COUIBaseListPopupWindow_12);

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean mo11565c();
    }

    public ZoomClickChangeView(Context context) {
        this(context, null);
    }

    public ZoomClickChangeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoomClickChangeView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f22918b = null;
        this.f22919c = null;
        this.f22920d = null;
        this.f22921e = false;
        this.f22922f = null;
        this.f22923g = null;
        this.f22924h = false;
        this.f22925i = 0.0f;
        this.f22926j = false;
        this.f22927k = 0L;
        this.f22928l = 0.0f;
        this.f22929m = null;
        this.f22930n = null;
        this.f22931o = null;
        this.f22932p = 1;
        m24153a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24153a(Context context) {
        setOrientation(0);
        setGravity(17);
        this.f22919c = new DecimalFormat("#.#");
        setClickable(true);
    }

    public void setListener(PlatformImplementations.kt_3 aVar) {
        this.f22918b = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24162a(int OplusGLSurfaceView_13, boolean z) {
        List<RotableTextView> list = this.f22930n;
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < this.f22930n.size(); i2++) {
            this.f22930n.get(i2).m18344a(OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24159a(float COUIBaseListPopupWindow_12, List<Float> list, int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        ArrayList arrayList = new ArrayList(list);
        this.f22925i = COUIBaseListPopupWindow_12;
        this.f22929m = arrayList;
        this.f22932p = i2;
        removeAllViews();
        this.f22930n = new ArrayList();
        this.f22920d = new ZoomUnit();
        CameraLog.m12954a(f22917a, "init, points: " + arrayList.toString());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final float fFloatValue = ((Float) it.next()).floatValue();
            RotableTextView c3437ah = new ZoomRotableTextView(getContext());
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.zoom_mark_button_size);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.zoom_mark_button_margin);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.zoom_mark_button_margin);
            c3437ah.setLayoutParams(layoutParams);
            c3437ah.setGravity(17);
            boolean z = false;
            c3437ah.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.zoom_mark_button_text_size));
            c3437ah.setBackground(getResources().getDrawable(R.drawable.zoom_mark_button_background, null).mutate());
            c3437ah.setText(m24157a(fFloatValue));
            c3437ah.setTypeface(Util.m24165A());
            c3437ah.setPadding(0, 0, 2, 0);
            c3437ah.m18344a(OplusGLSurfaceView_13, false);
            c3437ah.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.-$$Lambda$x$6pzU-Ovaa-G2AxJjB6f2woQDqc8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.COUIBaseListPopupWindow_12$0.m24151a(fFloatValue, view);
                }
            });
            addView(c3437ah);
            if (!Util.m24498u() && m24154a(fFloatValue, COUIBaseListPopupWindow_12)) {
                z = true;
            }
            c3437ah.setSelected(z);
            this.f22930n.add(c3437ah);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m24151a(float COUIBaseListPopupWindow_12, View view) {
        m24160a(COUIBaseListPopupWindow_12, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24160a(float COUIBaseListPopupWindow_12, boolean z) {
        PlatformImplementations.kt_3 aVar = this.f22918b;
        if (aVar == null || aVar.mo11562a() || this.f22924h) {
            return;
        }
        if (!(Float.compare(this.f22925i, COUIBaseListPopupWindow_12) == 0 && 0.0f == this.f22928l) && 200 <= System.currentTimeMillis() - this.f22927k && this.f22918b.mo11565c() && Float.compare(this.f22928l, COUIBaseListPopupWindow_12) != 0) {
            this.f22928l = COUIBaseListPopupWindow_12;
            this.f22918b.mo11564b(COUIBaseListPopupWindow_12);
            this.f22926j = z;
            if (this.f22926j) {
                m24158a();
            }
            this.f22918b.mo11561a(COUIBaseListPopupWindow_12, this.f22926j);
            ValueAnimator valueAnimator = this.f22931o;
            if (valueAnimator == null) {
                this.f22931o = ValueAnimator.ofFloat(this.f22925i, COUIBaseListPopupWindow_12);
                this.f22931o.setDuration(300L);
                this.f22931o.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.zoom_interpolator_in));
                this.f22931o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.-$$Lambda$x$DYtMIOCHyDHYrYGV8HECcFWaflE
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.COUIBaseListPopupWindow_12$0.m24152a(valueAnimator2);
                    }
                });
                this.f22931o.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.x.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (ZoomClickChangeView.this.f22918b != null) {
                            ZoomClickChangeView.this.f22918b.mo11563b();
                            ZoomClickChangeView.this.f22918b.mo11564b(-1.0f);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (ZoomClickChangeView.this.f22918b != null) {
                            ZoomClickChangeView.this.f22918b.mo11563b();
                            ZoomClickChangeView.this.f22918b.mo11564b(-1.0f);
                        }
                    }
                });
            } else {
                if (valueAnimator.isRunning()) {
                    this.f22931o.cancel();
                }
                this.f22931o.setFloatValues(this.f22925i, COUIBaseListPopupWindow_12);
            }
            this.f22931o.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m24152a(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (ZoomManager.f12334a > fFloatValue) {
            fFloatValue = ZoomManager.f12334a;
        }
        this.f22918b.mo11560a(fFloatValue);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m24157a(float COUIBaseListPopupWindow_12) {
        return this.f22920d.m11590a(this.f22921e, COUIBaseListPopupWindow_12);
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        super.setVisibility(OplusGLSurfaceView_13 == 0 ? 0 : 4);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24163b(int OplusGLSurfaceView_13, boolean z) {
        Animation animation;
        if (z) {
            setVisibility(OplusGLSurfaceView_13);
            if (OplusGLSurfaceView_13 == 0) {
                if (this.f22922f == null) {
                    this.f22922f = AnimationUtils.loadAnimation(getContext(), R.anim.zoom_button_in);
                    this.f22922f.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.ui.x.2
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation2) {
                            ZoomClickChangeView.this.f22924h = true;
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation2) {
                            ZoomClickChangeView.this.f22924h = false;
                        }
                    });
                }
                animation = this.f22922f;
            } else {
                if (this.f22923g == null) {
                    this.f22923g = AnimationUtils.loadAnimation(getContext(), R.anim.zoom_button_out);
                    this.f22923g.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.ui.x.3
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation2) {
                            ZoomClickChangeView.this.f22924h = true;
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation2) {
                            ZoomClickChangeView.this.f22924h = false;
                            ZoomClickChangeView.this.f22927k = System.currentTimeMillis();
                        }
                    });
                }
                animation = this.f22923g;
            }
            startAnimation(animation);
            return;
        }
        setVisibility(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24161a(float COUIBaseListPopupWindow_12, boolean z, boolean z2) {
        this.f22925i = COUIBaseListPopupWindow_12;
        if (z2 || !this.f22926j) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f22929m.size(); OplusGLSurfaceView_13++) {
                this.f22930n.get(OplusGLSurfaceView_13).setSelected(z && m24154a(this.f22929m.get(OplusGLSurfaceView_13).floatValue(), COUIBaseListPopupWindow_12));
            }
            this.f22928l = 0.0f;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24158a() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f22929m.size(); OplusGLSurfaceView_13++) {
            this.f22930n.get(OplusGLSurfaceView_13).setSelected(this.f22926j && Float.compare(this.f22929m.get(OplusGLSurfaceView_13).floatValue(), this.f22928l) == 0);
        }
        this.f22928l = 0.0f;
    }

    public void setZoomUnit(boolean z) {
        this.f22921e = z;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f22929m == null) {
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f22929m.size(); OplusGLSurfaceView_13++) {
            this.f22930n.get(OplusGLSurfaceView_13).setEnabled(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m24154a(float COUIBaseListPopupWindow_12, float f2) {
        boolean zM24156b = m24156b(COUIBaseListPopupWindow_12, f2);
        if (zM24156b) {
            float f3 = this.f22928l;
            if (f3 > 0.0f) {
                boolean zM24156b2 = m24156b(COUIBaseListPopupWindow_12, f3);
                if (zM24156b2) {
                    this.f22928l = 0.0f;
                }
                return zM24156b2;
            }
        }
        return zM24156b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m24156b(float COUIBaseListPopupWindow_12, float f2) {
        return COUIBaseListPopupWindow_12 == ZoomManager.m11416a(f2, this.f22932p);
    }

    public void setFromClickView(boolean z) {
        this.f22926j = z;
    }
}
