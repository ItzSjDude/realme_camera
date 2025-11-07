package com.oplus.camera.p172ui.control;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.hardware.camera2.params.Face;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotableTextView;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.preview.PreviewFrameLayout;
import com.oplus.camera.util.Util;

/* compiled from: TimerSnapShotManager.java */
/* renamed from: com.oplus.camera.ui.control.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class TimerSnapShotManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Typeface f18316a;

    /* renamed from: OplusGLSurfaceView_11 */
    private PlatformImplementations.kt_3 f18329n;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f18317b = 0.0f;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float f18318c = 0.0f;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f18319d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f18320e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f18321f = false;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f18322g = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f18323h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f18324i = false;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f18325j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f18326k = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    private long f18327l = 0;

    /* renamed from: OplusGLSurfaceView_6 */
    private IntrinsicsJvm.kt_4 f18328m = null;

    /* renamed from: o */
    private RotableTextView f18330o = null;

    /* renamed from: p */
    private ValueAnimator f18331p = null;

    /* compiled from: TimerSnapShotManager.java */
    /* renamed from: com.oplus.camera.ui.control.OplusGLSurfaceView_13$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo11054a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo11055a(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo11056b(boolean z);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo11057c(boolean z);

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo11058d(boolean z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static /* synthetic */ int m19308a(TimerSnapShotManager c3207i, int OplusGLSurfaceView_13) {
        int i2 = c3207i.f18325j - OplusGLSurfaceView_13;
        c3207i.f18325j = i2;
        return i2;
    }

    public TimerSnapShotManager() {
        this.f18329n = null;
        this.f18329n = new PlatformImplementations.kt_3();
    }

    /* compiled from: TimerSnapShotManager.java */
    /* renamed from: com.oplus.camera.ui.control.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends Handler {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f18333b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f18334c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f18335d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f18336e;

        private PlatformImplementations.kt_3() {
            this.f18333b = false;
            this.f18334c = 0;
            this.f18335d = 0;
            this.f18336e = 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CameraLog.m12954a("TimerSnapShotManager", "handleMessage, what: " + message.what);
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 1) {
                int iIntValue = ((Integer) message.obj).intValue();
                if (TimerSnapShotManager.this.f18330o != null) {
                    TimerSnapShotManager.this.f18330o.m18344a(iIntValue, false);
                }
                this.f18336e = iIntValue;
                this.f18333b = true;
                this.f18334c = 0;
                this.f18335d = 0;
                return;
            }
            if (OplusGLSurfaceView_13 == 2) {
                if (m19338b()) {
                    return;
                }
                m19340c(((Integer) message.obj).intValue());
            } else {
                if (OplusGLSurfaceView_13 != 3) {
                    return;
                }
                m19335a(((Boolean) message.obj).booleanValue() ? 1 : 2, message.arg1);
                if (this.f18333b) {
                    CameraLog.m12954a("TimerSnapShotManager", "handleMessage, MSG_UPDATE_POSITION, mbFirstPreview");
                    this.f18333b = false;
                    m19340c(1000);
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m19342a() {
            this.f18333b = false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean m19338b() {
            if (TimerSnapShotManager.this.f18325j > 0) {
                return false;
            }
            if (TimerSnapShotManager.this.f18328m != null) {
                TimerSnapShotManager.this.f18322g = true;
                TimerSnapShotManager.this.f18328m.mo11055a(TimerSnapShotManager.this.f18324i);
            }
            return true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m19335a(int OplusGLSurfaceView_13, int i2) {
            if (TimerSnapShotManager.this.f18330o != null) {
                int i3 = this.f18335d;
                if (i3 == 0) {
                    m19337b(OplusGLSurfaceView_13);
                    this.f18335d = OplusGLSurfaceView_13;
                } else if (i3 != OplusGLSurfaceView_13) {
                    m19337b(OplusGLSurfaceView_13);
                    if (this.f18335d == 1) {
                        m19336a(TimerSnapShotManager.this.f18330o, (TimerSnapShotManager.this.f18317b * 1.0f) / TimerSnapShotManager.this.f18318c, this.f18335d, OplusGLSurfaceView_13);
                    } else if (OplusGLSurfaceView_13 == 1) {
                        m19336a(TimerSnapShotManager.this.f18330o, (TimerSnapShotManager.this.f18318c * 1.0f) / TimerSnapShotManager.this.f18317b, this.f18335d, OplusGLSurfaceView_13);
                    }
                    this.f18335d = OplusGLSurfaceView_13;
                }
                if (this.f18336e != i2) {
                    TimerSnapShotManager.this.f18330o.m18344a(i2, true);
                    this.f18336e = i2;
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m19336a(View view, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, int i2) {
            int i3;
            PointF pointFM19334a = m19334a(OplusGLSurfaceView_13);
            PointF pointFM19334a2 = m19334a(i2);
            view.setScaleX(COUIBaseListPopupWindow_12);
            view.setScaleY(COUIBaseListPopupWindow_12);
            if (!Util.m24498u() || (i3 = this.f18336e) == 0) {
                view.setTranslationY(pointFM19334a.y - pointFM19334a2.y);
                view.setTranslationX(pointFM19334a.x - pointFM19334a2.x);
            } else if (270 == i3) {
                view.setTranslationY(pointFM19334a2.y - pointFM19334a.y);
                view.setTranslationX(pointFM19334a.x - pointFM19334a2.x);
            } else {
                view.setTranslationY(pointFM19334a.y - pointFM19334a2.y);
                view.setTranslationX(pointFM19334a2.x - pointFM19334a.x);
            }
            view.animate().setDuration(500L).scaleX(1.0f).scaleY(1.0f).translationX(1.0f).translationY(1.0f);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private PointF m19334a(int OplusGLSurfaceView_13) {
            float height;
            ViewGroup viewGroup = (ViewGroup) TimerSnapShotManager.this.f18330o.getParent();
            float width = 0.0f;
            if (OplusGLSurfaceView_13 == 1) {
                width = viewGroup.getWidth() / 2.0f;
                height = viewGroup.getHeight() / 2.0f;
            } else if (OplusGLSurfaceView_13 != 2) {
                height = 0.0f;
            } else {
                int i2 = (!TimerSnapShotManager.this.f18323h || Util.m24498u()) ? 0 : TimerSnapShotManager.this.f18320e;
                if (Util.m24498u() && this.f18336e != 0) {
                    i2 = TimerSnapShotManager.this.f18319d;
                }
                width = (viewGroup.getWidth() - (TimerSnapShotManager.this.f18318c / 2.0f)) - TimerSnapShotManager.this.f18319d;
                height = (TimerSnapShotManager.this.f18318c / 2.0f) + i2;
            }
            return new PointF(width, height);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m19337b(int OplusGLSurfaceView_13) {
            int i2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (OplusGLSurfaceView_13 == 1) {
                layoutParams.addRule(13);
                TimerSnapShotManager.this.f18330o.setTextSize(0, TimerSnapShotManager.this.f18317b);
                TimerSnapShotManager.this.f18330o.setTextColor(-1);
            } else if (OplusGLSurfaceView_13 == 2) {
                if (!Util.m24498u() || (i2 = this.f18336e) == 0) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = TimerSnapShotManager.this.f18319d;
                    if (TimerSnapShotManager.this.f18323h && !Util.m24498u()) {
                        layoutParams.topMargin = TimerSnapShotManager.this.f18320e;
                    }
                } else if (270 == i2) {
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = TimerSnapShotManager.this.f18319d;
                    layoutParams.bottomMargin = TimerSnapShotManager.this.f18319d;
                } else if (90 == i2) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = TimerSnapShotManager.this.f18319d;
                    layoutParams.topMargin = TimerSnapShotManager.this.f18319d;
                }
                TimerSnapShotManager.this.f18330o.setTextSize(0, TimerSnapShotManager.this.f18318c);
                TimerSnapShotManager.this.f18330o.setTextColor(InverseManager.INS.isInverseColor(TimerSnapShotManager.this.f18330o.getContext().hashCode()) ? TimerSnapShotManager.this.f18330o.getContext().getColor(R.color.inverse_text_color) : -1);
            }
            TimerSnapShotManager.this.f18330o.setLayoutParams(layoutParams);
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private void m19340c(int OplusGLSurfaceView_13) {
            int iCeil;
            if (TimerSnapShotManager.this.f18330o != null && (iCeil = (int) Math.ceil((TimerSnapShotManager.this.f18325j * 1.0d) / 1000.0d)) != this.f18334c) {
                TimerSnapShotManager.this.f18330o.setAlpha(1.0f);
                TimerSnapShotManager.this.f18330o.setText(Util.m24474l(iCeil));
                this.f18334c = iCeil;
                m19339c();
            }
            TimerSnapShotManager.m19308a(TimerSnapShotManager.this, OplusGLSurfaceView_13);
            TimerSnapShotManager.this.f18328m.mo11054a();
            int i2 = 1000;
            if (TimerSnapShotManager.this.f18326k > 3000 && TimerSnapShotManager.this.f18325j <= 3000) {
                i2 = TimerSnapShotManager.this.f18325j <= 1000 ? 125 : 250;
            }
            removeMessages(2);
            sendMessageDelayed(obtainMessage(2, Integer.valueOf(i2)), OplusGLSurfaceView_13);
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private void m19339c() {
            if (TimerSnapShotManager.this.f18331p == null) {
                m19341d();
            }
            TimerSnapShotManager.this.f18331p.cancel();
            TimerSnapShotManager.this.f18331p.start();
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        private void m19341d() {
            TimerSnapShotManager.this.f18331p = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(1000L);
            TimerSnapShotManager.this.f18331p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.OplusGLSurfaceView_13.PlatformImplementations.kt_3.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (TimerSnapShotManager.this.f18330o != null) {
                        TimerSnapShotManager.this.f18330o.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        TimerSnapShotManager.this.f18330o.postInvalidate();
                    }
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19328a(IntrinsicsJvm.kt_4 bVar) {
        this.f18328m = bVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m19311a(Activity activity) throws Resources.NotFoundException {
        if (this.f18330o != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        PreviewFrameLayout previewFrameLayout = (PreviewFrameLayout) activity.findViewById(R.id_renamed.frame_layout);
        float dimension = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_shadow_radius_size);
        float dimension2 = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_shadow_radius_dx);
        float dimension3 = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_shadow_radius_dy);
        this.f18317b = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_text_size);
        this.f18318c = activity.getResources().getDimension(R.dimen.time_snapshot_indicator_text_size_corner);
        this.f18319d = (int) activity.getResources().getDimension(R.dimen.time_snapshot_indicator_text_margin_horizontal);
        this.f18320e = Util.m24186N();
        this.f18330o = new RotableTextView(activity);
        this.f18330o.setShadowLayer(dimension, dimension2, dimension3, 0);
        if (f18316a == null) {
            f18316a = Util.m24473l(activity);
        }
        this.f18330o.setTypeface(f18316a);
        this.f18330o.setTextSize(0, this.f18317b);
        previewFrameLayout.addView(this.f18330o, layoutParams);
        this.f18330o.setVisibility(8);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19325a() {
        this.f18330o = null;
        this.f18329n = null;
        ValueAnimator valueAnimator = this.f18331p;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f18331p = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m19329b() {
        if (this.f18330o == null) {
            return null;
        }
        return this.f18330o.getWidth() + "x" + this.f18330o.getHeight();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public String m19330c() {
        if (this.f18330o == null) {
            return null;
        }
        return this.f18330o.getLeft() + "," + this.f18330o.getTop() + "," + this.f18330o.getRight() + "," + this.f18330o.getBottom();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19326a(int OplusGLSurfaceView_13, Activity activity, int i2, boolean z, boolean z2) {
        CameraLog.m12954a("TimerSnapShotManager", "startTimerSnapShot, time: " + OplusGLSurfaceView_13);
        this.f18324i = z2;
        this.f18323h = z;
        this.f18325j = OplusGLSurfaceView_13 * 1000;
        this.f18326k = this.f18325j;
        m19311a(activity);
        this.f18321f = true;
        RotableTextView rotableTextView = this.f18330o;
        if (rotableTextView != null) {
            rotableTextView.setVisibility(0);
        }
        this.f18329n.removeMessages(1);
        PlatformImplementations.kt_3 aVar = this.f18329n;
        aVar.sendMessage(aVar.obtainMessage(1, Integer.valueOf(i2)));
        this.f18328m.mo11056b(this.f18324i);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m19331d() {
        return this.f18321f;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m19332e() {
        return this.f18322g;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m19333f() {
        this.f18329n.removeMessages(2);
        this.f18329n.removeMessages(3);
        this.f18329n.m19342a();
        this.f18321f = false;
        this.f18324i = false;
        RotableTextView rotableTextView = this.f18330o;
        if (rotableTextView != null) {
            rotableTextView.clearAnimation();
            this.f18330o.setVisibility(8);
        }
        IntrinsicsJvm.kt_4 bVar = this.f18328m;
        if (bVar != null) {
            bVar.mo11057c(this.f18322g);
        }
        this.f18322g = false;
        this.f18325j = 0;
        this.f18326k = 0;
        this.f18327l = 0L;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m19327a(Rect rect, Face[] faceArr, int OplusGLSurfaceView_13) {
        if (System.currentTimeMillis() - this.f18327l > 500) {
            this.f18327l = System.currentTimeMillis();
            boolean zM19312a = m19312a(rect, faceArr);
            this.f18329n.removeMessages(3);
            Message messageObtainMessage = this.f18329n.obtainMessage(3);
            messageObtainMessage.obj = Boolean.valueOf(zM19312a);
            messageObtainMessage.arg1 = OplusGLSurfaceView_13;
            this.f18329n.sendMessage(messageObtainMessage);
            IntrinsicsJvm.kt_4 bVar = this.f18328m;
            if (bVar != null) {
                bVar.mo11058d(zM19312a);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m19312a(Rect rect, Face[] faceArr) {
        if (faceArr == null || faceArr.length <= 0) {
            return true;
        }
        int iWidth = (rect.width() * rect.height()) / 16;
        for (Face face : faceArr) {
            if (m19313a(face, iWidth)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m19313a(Face face, int OplusGLSurfaceView_13) {
        if (face == null) {
            return false;
        }
        Rect bounds = face.getBounds();
        return bounds.width() * bounds.height() <= OplusGLSurfaceView_13;
    }
}
