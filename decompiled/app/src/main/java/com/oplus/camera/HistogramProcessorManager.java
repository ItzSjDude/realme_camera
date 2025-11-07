package com.oplus.camera;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSIllegalArgumentException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.p034f.TextUtilsCompat;
import com.oplus.camera.jni.FormatConverter;
import com.oplus.camera.p172ui.HistogramView;
import com.oplus.camera.professional.ProfessionalAnimConstant;
import com.oplus.camera.professional.ProfessionalAnimUtil;
import com.oplus.camera.util.Util;
import java.util.Locale;

/* compiled from: HistogramProcessorManager.java */
/* renamed from: com.oplus.camera.p */
/* loaded from: classes2.dex */
public class HistogramProcessorManager {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Resources f14786e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ViewGroup f14787f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f14788g;

    /* renamed from: o */
    private Context f14796o;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f14782a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f14783b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f14784c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Handler f14785d = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Animator f14789h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private FrameLayout f14790i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private HistogramView f14791j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private ValueAnimator f14792k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private ValueAnimator f14793l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private final Object f14794m = new Object();

    /* renamed from: OplusGLSurfaceView_11 */
    private RenderScript f14795n = null;

    /* renamed from: p */
    private ScriptIntrinsicYuvToRGB f14797p = null;

    /* renamed from: q */
    private Allocation f14798q = null;

    /* renamed from: r */
    private Allocation f14799r = null;

    /* renamed from: s */
    private byte[] f14800s = null;

    /* renamed from: t */
    private float[] f14801t = null;

    /* renamed from: u */
    private float[] f14802u = null;

    /* renamed from: v */
    private float[] f14803v = null;

    /* renamed from: w */
    private float[] f14804w = null;

    /* renamed from: x */
    private FormatConverter f14805x = new FormatConverter();

    /* renamed from: y */
    private Handler f14806y = null;

    /* renamed from: z */
    private RelativeLayout.LayoutParams f14807z = null;

    /* compiled from: HistogramProcessorManager.java */
    /* renamed from: com.oplus.camera.p$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f14811a = 0;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f14812b = 0;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f14813c = 0;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int f14814d = 0;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f14815e = 0;
    }

    public HistogramProcessorManager(Context context, View view, PlatformImplementations.kt_3 aVar) {
        this.f14786e = null;
        this.f14787f = null;
        this.f14788g = null;
        this.f14796o = null;
        this.f14796o = context;
        this.f14786e = context.getResources();
        this.f14787f = (ViewGroup) view;
        this.f14788g = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14821a(RelativeLayout.LayoutParams layoutParams, boolean z, boolean z2) {
        if (layoutParams == null) {
            return;
        }
        layoutParams.addRule(this.f14788g.f14811a);
        layoutParams.addRule(20);
        if (!z) {
            layoutParams.topMargin = this.f14788g.f14812b;
        }
        if (!z2) {
            if (1 == TextUtilsCompat.m2525a(Locale.getDefault())) {
                layoutParams.rightMargin = this.f14788g.f14814d;
            } else {
                layoutParams.leftMargin = this.f14788g.f14814d;
            }
        }
        layoutParams.bottomMargin = this.f14788g.f14813c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m14824c(ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar) {
        if (aVar == null) {
            return;
        }
        Animator animator = this.f14789h;
        if (animator != null) {
            animator.cancel();
            this.f14789h = null;
        }
        this.f14789h = ProfessionalAnimUtil.m15922a(this.f14790i, aVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14840a(int OplusGLSurfaceView_13) {
        FrameLayout frameLayout = this.f14790i;
        if (frameLayout != null) {
            frameLayout.setId(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14845a(ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException {
        CameraLog.m12954a("HistogramProcessorManager", "showHistogram");
        if (this.f14790i == null) {
            this.f14790i = new FrameLayout(this.f14796o);
            this.f14790i.setBackgroundResource(R.drawable.film_histogram_bg);
            int dimensionPixelSize = this.f14786e.getDimensionPixelSize(R.dimen.histogram_bg_radius);
            this.f14790i.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f14787f.getLayoutParams());
        layoutParams.width = this.f14786e.getDimensionPixelSize(R.dimen.histogram_graph_view_width);
        layoutParams.height = this.f14786e.getDimensionPixelSize(R.dimen.histogram_graph_view_height);
        m14821a(layoutParams, false, false);
        this.f14787f.removeView(this.f14790i);
        this.f14787f.addView(this.f14790i, layoutParams);
        if (this.f14791j == null) {
            this.f14791j = new HistogramView(this.f14796o);
            this.f14790i.removeAllViews();
            this.f14790i.addView(this.f14791j);
        }
        this.f14784c = true;
        this.f14790i.setRotation(this.f14788g.f14815e);
        this.f14790i.setVisibility(0);
        this.f14790i.invalidate();
        if (aVar != null) {
            m14824c(aVar);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14842a(PlatformImplementations.kt_3 aVar, boolean z) {
        m14844a(aVar, z, false, 0L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14843a(PlatformImplementations.kt_3 aVar, boolean z, boolean z2) {
        m14844a(aVar, z, z2, 0L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14844a(PlatformImplementations.kt_3 aVar, boolean z, boolean z2, long OplusGLSurfaceView_15) {
        FrameLayout frameLayout;
        if (aVar == null || (frameLayout = this.f14790i) == null) {
            return;
        }
        this.f14807z = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
        m14821a(this.f14807z, z, z2);
        this.f14790i.setLayoutParams(this.f14807z);
        this.f14790i.setRotation(aVar.f14815e);
        this.f14790i.invalidate();
        if (z) {
            int OplusGLSurfaceView_13 = this.f14788g.f14812b;
            int i2 = this.f14807z.topMargin;
            ValueAnimator valueAnimator = this.f14792k;
            if (valueAnimator == null) {
                this.f14792k = ValueAnimator.ofInt(i2, OplusGLSurfaceView_13);
                this.f14792k.setDuration(350L);
                this.f14792k.setInterpolator(ProfessionalAnimConstant.f15695b);
                this.f14792k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.p.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        HistogramProcessorManager.this.f14807z.topMargin = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                        HistogramProcessorManager.this.f14790i.setLayoutParams(HistogramProcessorManager.this.f14807z);
                    }
                });
            } else {
                valueAnimator.setIntValues(i2, OplusGLSurfaceView_13);
            }
            if (!this.f14792k.isRunning()) {
                this.f14792k.setStartDelay(OplusGLSurfaceView_15);
                this.f14792k.start();
            }
        } else {
            ValueAnimator valueAnimator2 = this.f14792k;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.f14792k = null;
            }
        }
        if (z2) {
            int i3 = this.f14788g.f14814d;
            int i4 = this.f14807z.leftMargin;
            ValueAnimator valueAnimator3 = this.f14793l;
            if (valueAnimator3 == null) {
                this.f14793l = ValueAnimator.ofInt(i4, i3);
                this.f14793l.setDuration(350L);
                this.f14793l.setInterpolator(ProfessionalAnimConstant.f15695b);
                this.f14793l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.p.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator4) {
                        HistogramProcessorManager.this.f14807z.leftMargin = ((Integer) valueAnimator4.getAnimatedValue()).intValue();
                        HistogramProcessorManager.this.f14790i.setLayoutParams(HistogramProcessorManager.this.f14807z);
                    }
                });
            } else {
                valueAnimator3.setIntValues(i4, i3);
            }
            if (!this.f14793l.isRunning()) {
                this.f14793l.setStartDelay(OplusGLSurfaceView_15);
                this.f14793l.start();
            }
        } else {
            ValueAnimator valueAnimator4 = this.f14793l;
            if (valueAnimator4 != null) {
                valueAnimator4.cancel();
                this.f14793l = null;
            }
        }
        this.f14788g = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14839a() {
        CameraLog.m12954a("HistogramProcessorManager", "updateHistogramLayout");
        if (this.f14790i == null || !m14827e()) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14790i.getLayoutParams();
        m14821a(layoutParams, false, false);
        this.f14790i.setLayoutParams(layoutParams);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m14848b() {
        return this.f14784c;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m14827e() {
        FrameLayout frameLayout;
        return this.f14784c && this.f14787f.indexOfChild(this.f14790i) != -1 && (frameLayout = this.f14790i) != null && frameLayout.getVisibility() == 0;
    }

    @SuppressLint({"HandlerLeak"})
    /* renamed from: PlatformImplementations.kt_3 */
    public void m14841a(Size size) {
        this.f14782a = size.getHeight();
        this.f14783b = size.getWidth();
        CameraLog.m12954a("HistogramProcessorManager", "HistogramProcessorManager onOpen, mSizeHeight: " + this.f14782a + ", mSizeWidth: " + this.f14783b);
        synchronized (this.f14794m) {
            this.f14795n = RenderScript.create(this.f14796o);
            this.f14797p = ScriptIntrinsicYuvToRGB.create(this.f14795n, Element.U8_4(this.f14795n));
            this.f14798q = Allocation.createTyped(this.f14795n, new Type.Builder(this.f14795n, Element.U8(this.f14795n)).setX(((this.f14783b * this.f14782a) * 3) / 2).create(), 1);
            this.f14799r = Allocation.createTyped(this.f14795n, new Type.Builder(this.f14795n, Element.RGBA_8888(this.f14795n)).setX(this.f14783b).setY(this.f14782a).create(), 1);
            this.f14800s = new byte[this.f14783b * this.f14782a * 4];
            this.f14801t = new float[1];
            this.f14802u = new float[256];
            this.f14803v = new float[256];
            this.f14804w = new float[256];
        }
        if (this.f14806y == null) {
            this.f14806y = new IntrinsicsJvm.kt_4();
        }
        if (this.f14785d == null) {
            this.f14785d = new Handler(Looper.getMainLooper());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14847b(ProfessionalAnimUtil.PlatformImplementations.kt_3 aVar) {
        CameraLog.m12954a("HistogramProcessorManager", "stopAndHideHistogram");
        ValueAnimator valueAnimator = this.f14792k;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f14792k = null;
        }
        ValueAnimator valueAnimator2 = this.f14793l;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f14793l = null;
        }
        ViewGroup viewGroup = this.f14787f;
        if (viewGroup != null) {
            if (aVar != null) {
                m14824c(aVar);
            } else {
                viewGroup.removeView(this.f14790i);
            }
        }
        this.f14784c = false;
        Handler handler = this.f14806y;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.f14785d;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14849c() {
        CameraLog.m12954a("HistogramProcessorManager", "HistogramProcessorManager onClose");
        m14847b((ProfessionalAnimUtil.PlatformImplementations.kt_3) null);
        synchronized (this.f14794m) {
            if (this.f14799r == null) {
                return;
            }
            if (this.f14798q != null) {
                this.f14798q.destroy();
            }
            if (this.f14799r != null) {
                this.f14799r.destroy();
            }
            this.f14799r = null;
            this.f14798q = null;
            if (this.f14795n != null) {
                this.f14795n.destroy();
                this.f14795n = null;
            }
            this.f14800s = null;
            this.f14801t = null;
            this.f14802u = null;
            this.f14804w = null;
            this.f14803v = null;
            this.f14806y = null;
            this.f14785d = null;
            Animator animator = this.f14789h;
            if (animator != null) {
                animator.cancel();
                this.f14789h = null;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14846a(byte[] bArr) {
        Handler handler;
        synchronized (this.f14794m) {
            if (this.f14799r == null) {
                return;
            }
            if (!m14827e() && (handler = this.f14785d) != null) {
                handler.post(new Runnable() { // from class: com.oplus.camera.p.3
                    @Override // java.lang.Runnable
                    public void run() throws Resources.NotFoundException {
                        HistogramProcessorManager.this.m14845a((ProfessionalAnimUtil.PlatformImplementations.kt_3) null);
                    }
                });
            }
            Handler handler2 = this.f14806y;
            if (handler2 != null) {
                Message messageObtainMessage = handler2.obtainMessage(1);
                messageObtainMessage.obj = bArr;
                this.f14806y.removeMessages(1);
                this.f14806y.sendMessage(messageObtainMessage);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m14850d() {
        int iM24460i;
        PlatformImplementations.kt_3 aVar = this.f14788g;
        if (aVar != null) {
            if (Util.m24498u()) {
                iM24460i = Util.m24460i(R.dimen.fold_rack_movie_histogram_margin_bottom);
            } else {
                iM24460i = Util.m24460i(R.dimen.movie_histogram_margin_bottom) + Util.m24318aG();
            }
            aVar.f14813c = iM24460i;
        }
    }

    /* compiled from: HistogramProcessorManager.java */
    /* renamed from: com.oplus.camera.p$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends Handler {
        private IntrinsicsJvm.kt_4() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            synchronized (HistogramProcessorManager.this.f14794m) {
                try {
                } catch (RSIllegalArgumentException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    CameraLog.m12967f("HistogramProcessorManager", "Array too small for allocation type.");
                }
                if (HistogramProcessorManager.this.f14798q == null) {
                    return;
                }
                HistogramProcessorManager.this.f14798q.copyFrom((byte[]) message.obj);
                HistogramProcessorManager.this.f14797p.setInput(HistogramProcessorManager.this.f14798q);
                HistogramProcessorManager.this.f14797p.forEach(HistogramProcessorManager.this.f14799r);
                HistogramProcessorManager.this.f14799r.copyTo(HistogramProcessorManager.this.f14800s);
                HistogramProcessorManager.this.f14805x.statisticsHistogramRGB(HistogramProcessorManager.this.f14800s, HistogramProcessorManager.this.f14801t, HistogramProcessorManager.this.f14782a, HistogramProcessorManager.this.f14783b, 8, HistogramProcessorManager.this.f14802u, HistogramProcessorManager.this.f14803v, HistogramProcessorManager.this.f14804w);
                HistogramProcessorManager.this.f14785d.post(new Runnable() { // from class: com.oplus.camera.p.IntrinsicsJvm.kt_4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (HistogramProcessorManager.this.f14791j != null) {
                            HistogramProcessorManager.this.f14791j.m20273a(HistogramProcessorManager.this.f14802u, HistogramProcessorManager.this.f14803v, HistogramProcessorManager.this.f14804w, HistogramProcessorManager.this.f14801t[0]);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Size m14819a(int OplusGLSurfaceView_13, int i2) {
        int i3 = OplusGLSurfaceView_13 / 3;
        int i4 = i2 / 3;
        if (i3 % 2 != 0) {
            i3++;
        }
        if (i4 % 2 != 0) {
            i4++;
        }
        return new Size(i3, i4);
    }
}
