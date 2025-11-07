package com.oplus.camera.p172ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.preview.CameraPreviewUI;
import com.oplus.camera.util.BackgroundUtil;
import com.oplus.camera.util.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BackgroundSplitManager.java */
/* renamed from: com.oplus.camera.ui.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class BackgroundSplitManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f17400a = "PlatformImplementations.kt_3";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static ConcurrentHashMap<Integer, BackgroundSplitManager> f17401b = new ConcurrentHashMap<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ConcurrentHashMap<Integer, IntrinsicsJvm.kt_4> f17402c = new ConcurrentHashMap<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private WeakReference f17403d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private WeakReference f17404e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private IntrinsicsJvm.kt_3 f17405f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Paint f17406g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Paint f17407h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private Paint f17408i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private Paint f17409j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private Paint f17410k = null;

    /* compiled from: BackgroundSplitManager.java */
    /* renamed from: com.oplus.camera.ui.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo18292a(boolean z, int OplusGLSurfaceView_13);

        void setNormalBackground(boolean z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static BackgroundSplitManager m18430a(Context context) {
        return m18429a(context.hashCode());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static BackgroundSplitManager m18429a(int OplusGLSurfaceView_13) {
        if (f17401b.containsKey(Integer.valueOf(OplusGLSurfaceView_13))) {
            return f17401b.get(Integer.valueOf(OplusGLSurfaceView_13));
        }
        BackgroundSplitManager c3129a = new BackgroundSplitManager();
        f17401b.put(Integer.valueOf(OplusGLSurfaceView_13), c3129a);
        return c3129a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m18437b(Context context) {
        if (f17401b.containsKey(Integer.valueOf(context.hashCode()))) {
            f17401b.remove(Integer.valueOf(context.hashCode()));
        }
    }

    private BackgroundSplitManager() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18441a(Context context, CameraPreviewUI viewOnLayoutChangeListenerC3444g) {
        this.f17403d = new WeakReference(context);
        this.f17404e = new WeakReference(viewOnLayoutChangeListenerC3444g);
        this.f17408i = new Paint();
        this.f17408i.setAntiAlias(true);
        this.f17408i.setStyle(Paint.Style.FILL);
        this.f17408i.setStrokeWidth(1.0f);
        this.f17408i.setColor(Util.m24472l().getColor(R.color.color_white_with_20_percent_transparency));
        this.f17408i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f17406g = new Paint();
        this.f17406g.setAntiAlias(true);
        this.f17406g.setStyle(Paint.Style.FILL);
        this.f17406g.setStrokeWidth(1.0f);
        this.f17406g.setColor(Util.m24472l().getColor(R.color.color_white_with_20_percent_transparency));
        this.f17409j = new Paint();
        this.f17409j.setAntiAlias(true);
        this.f17409j.setStyle(Paint.Style.FILL);
        this.f17409j.setStrokeWidth(1.0f);
        this.f17409j.setColor(Util.m24472l().getColor(R.color.color_black_with_30_percent_transparency));
        this.f17409j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f17407h = new Paint();
        this.f17407h.setAntiAlias(true);
        this.f17407h.setStyle(Paint.Style.FILL);
        this.f17407h.setStrokeWidth(1.0f);
        this.f17407h.setColor(Util.m24472l().getColor(R.color.color_black_with_30_percent_transparency));
        this.f17410k = new Paint();
        this.f17410k.setAntiAlias(true);
        this.f17410k.setStyle(Paint.Style.FILL);
        this.f17410k.setStrokeWidth(1.0f);
        this.f17410k.setColor(BackgroundUtil.m24523a(-16777216));
        this.f17410k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18445a(PlatformImplementations.kt_3 aVar, String str) {
        if (aVar == null || Util.m24498u()) {
            return;
        }
        this.f17402c.put(Integer.valueOf(aVar.hashCode()), new IntrinsicsJvm.kt_4(new WeakReference(aVar), str));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18442a(PlatformImplementations.kt_3 aVar) {
        if (aVar == null || !this.f17402c.containsKey(Integer.valueOf(aVar.hashCode()))) {
            return;
        }
        this.f17402c.remove(Integer.valueOf(aVar.hashCode()));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18440a(long OplusGLSurfaceView_15, long j2) {
        WeakReference weakReference = this.f17403d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f17405f = new IntrinsicsJvm.kt_3(OplusGLSurfaceView_15, j2, this.f17403d.get().hashCode());
        ((Activity) this.f17403d.get()).runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.PlatformImplementations.kt_3.1
            @Override // java.lang.Runnable
            public void run() {
                Choreographer.getInstance().postFrameCallback(BackgroundSplitManager.this.f17405f);
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18447b(int OplusGLSurfaceView_13) {
        for (Map.Entry<Integer, IntrinsicsJvm.kt_4> entry : this.f17402c.entrySet()) {
            if (entry.getValue() != null && entry.getValue().f17476b.get() != null) {
                ((PlatformImplementations.kt_3) entry.getValue().f17476b.get()).mo18292a(true, OplusGLSurfaceView_13);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18438a() {
        for (Map.Entry<Integer, IntrinsicsJvm.kt_4> entry : this.f17402c.entrySet()) {
            if (entry.getValue() != null && entry.getValue().f17476b.get() != null) {
                ((PlatformImplementations.kt_3) entry.getValue().f17476b.get()).mo18292a(false, 0);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m18446b() {
        WeakReference weakReference = this.f17404e;
        if (weakReference == null || weakReference.get() == null) {
            return -1;
        }
        return ((CameraPreviewUI) this.f17404e.get()).m23324Y();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float[] m18435a(float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13) {
        float[] fArr = new float[2];
        if (f2 > COUIBaseListPopupWindow_12) {
            fArr[0] = (((float) Math.asin((f2 - COUIBaseListPopupWindow_12) / COUIBaseListPopupWindow_12)) * 180.0f) / 3.1415927f;
            fArr[1] = 180.0f - (fArr[0] * 2.0f);
        } else if (f2 == COUIBaseListPopupWindow_12) {
            fArr[0] = 0.0f;
            fArr[1] = 180.0f;
        } else {
            fArr[0] = ((-((float) Math.asin((COUIBaseListPopupWindow_12 - f2) / COUIBaseListPopupWindow_12))) * 180.0f) / 3.1415927f;
            fArr[1] = (Math.abs(fArr[0]) * 2.0f) + 180.0f;
        }
        if (OplusGLSurfaceView_13 == 1) {
            fArr[0] = fArr[0] + fArr[1];
            fArr[1] = 360.0f - fArr[1];
        }
        return fArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float[] m18436a(RectF rectF, float COUIBaseListPopupWindow_12, float f2) {
        float[] fArr = new float[2];
        if (f2 < COUIBaseListPopupWindow_12) {
            double dSqrt = Math.sqrt(Math.pow(COUIBaseListPopupWindow_12, 2.0d) - Math.pow(COUIBaseListPopupWindow_12 - f2, 2.0d));
            fArr[0] = (float) ((rectF.left + COUIBaseListPopupWindow_12) - dSqrt);
            fArr[1] = (float) ((rectF.right - COUIBaseListPopupWindow_12) + dSqrt);
        } else if (f2 > COUIBaseListPopupWindow_12) {
            double dSqrt2 = Math.sqrt(Math.pow(COUIBaseListPopupWindow_12, 2.0d) - Math.pow(f2 - COUIBaseListPopupWindow_12, 2.0d));
            fArr[0] = (float) ((rectF.left + COUIBaseListPopupWindow_12) - dSqrt2);
            fArr[1] = (float) ((rectF.right - COUIBaseListPopupWindow_12) + dSqrt2);
        } else {
            fArr[0] = rectF.left;
            fArr[1] = rectF.right;
        }
        return fArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18434a(View view, Canvas canvas, int OplusGLSurfaceView_13, boolean z) {
        int paddingLeft = view.getPaddingLeft();
        float width = ((view.getWidth() - paddingLeft) - view.getPaddingRight()) / 2.0f;
        float width2 = view.getWidth() / 2.0f;
        float height = view.getHeight() / 2.0f;
        int saveCount = canvas.getSaveCount();
        if (z) {
            if (OplusGLSurfaceView_13 == 1) {
                canvas.drawCircle(width2, height, width, this.f17410k);
                canvas.drawCircle(width2, height, width, this.f17406g);
            } else if (OplusGLSurfaceView_13 == 2) {
                canvas.drawCircle(width2, height, width, this.f17409j);
            }
        } else if (OplusGLSurfaceView_13 == 1) {
            canvas.drawCircle(width2, height, width, this.f17409j);
        } else if (OplusGLSurfaceView_13 == 2) {
            canvas.drawCircle(width2, height, width, this.f17410k);
            canvas.drawCircle(width2, height, width, this.f17406g);
        }
        canvas.restoreToCount(saveCount);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18431a(Canvas canvas, RectF rectF, float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13, boolean z) {
        if (z) {
            if (OplusGLSurfaceView_13 == 1) {
                canvas.drawRoundRect(rectF, COUIBaseListPopupWindow_12, f2, this.f17410k);
                canvas.drawRoundRect(rectF, COUIBaseListPopupWindow_12, f2, this.f17406g);
                return;
            } else {
                if (OplusGLSurfaceView_13 == 2) {
                    canvas.drawRoundRect(rectF, COUIBaseListPopupWindow_12, f2, this.f17409j);
                    return;
                }
                return;
            }
        }
        if (OplusGLSurfaceView_13 == 1) {
            canvas.drawRoundRect(rectF, COUIBaseListPopupWindow_12, f2, this.f17409j);
        } else if (OplusGLSurfaceView_13 == 2) {
            canvas.drawRoundRect(rectF, COUIBaseListPopupWindow_12, f2, this.f17410k);
            canvas.drawRoundRect(rectF, COUIBaseListPopupWindow_12, f2, this.f17406g);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18432a(Canvas canvas, RectF rectF, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        float f2 = (rectF.bottom - rectF.top) / 2.0f;
        float[] fArrM18435a = m18435a(f2, COUIBaseListPopupWindow_12, OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 == 1) {
            canvas.drawRoundRect(rectF, f2, f2, this.f17410k);
            canvas.drawRoundRect(rectF, f2, f2, this.f17406g);
            float f3 = f2 * 2.0f;
            RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.left + f3, rectF.bottom);
            RectF rectF3 = new RectF(rectF.right - f3, rectF.top, rectF.right, rectF.bottom);
            canvas.drawArc(rectF2, fArrM18435a[0], fArrM18435a[1] / 2.0f, false, this.f17409j);
            float[] fArrM18436a = m18436a(rectF, f2, COUIBaseListPopupWindow_12);
            Path path = new Path();
            path.moveTo(fArrM18436a[0], rectF.top + COUIBaseListPopupWindow_12);
            path.lineTo(rectF.left + f2, rectF.top);
            path.lineTo(rectF.right - f2, rectF.top);
            path.lineTo(fArrM18436a[1], rectF.top + COUIBaseListPopupWindow_12);
            path.close();
            canvas.drawPath(path, this.f17409j);
            canvas.drawArc(rectF3, (fArrM18435a[1] / 2.0f) + fArrM18435a[0], fArrM18435a[1] / 2.0f, false, this.f17409j);
            return;
        }
        if (OplusGLSurfaceView_13 == 2) {
            canvas.drawRoundRect(rectF, f2, f2, this.f17409j);
            float f4 = f2 * 2.0f;
            RectF rectF4 = new RectF(rectF.left, rectF.top, rectF.left + f4, rectF.bottom);
            RectF rectF5 = new RectF(rectF.right - f4, rectF.top, rectF.right, rectF.bottom);
            canvas.drawArc(rectF4, fArrM18435a[0] + (fArrM18435a[1] / 2.0f), fArrM18435a[1] / 2.0f, false, this.f17410k);
            canvas.drawArc(rectF4, fArrM18435a[0] + (fArrM18435a[1] / 2.0f), fArrM18435a[1] / 2.0f, false, this.f17406g);
            float[] fArrM18436a2 = m18436a(rectF, f2, COUIBaseListPopupWindow_12);
            Path path2 = new Path();
            path2.moveTo(fArrM18436a2[0], rectF.top + COUIBaseListPopupWindow_12);
            path2.lineTo(rectF.left + f2, rectF.bottom);
            path2.lineTo(rectF.right - f2, rectF.bottom);
            path2.lineTo(fArrM18436a2[1], rectF.top + COUIBaseListPopupWindow_12);
            path2.close();
            canvas.drawPath(path2, this.f17410k);
            canvas.drawPath(path2, this.f17406g);
            canvas.drawArc(rectF5, fArrM18435a[0], fArrM18435a[1] / 2.0f, false, this.f17410k);
            canvas.drawArc(rectF5, fArrM18435a[0], fArrM18435a[1] / 2.0f, false, this.f17406g);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18433a(View view, Canvas canvas, float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13, String str) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        float[] fArrM18435a = m18435a(f2, COUIBaseListPopupWindow_12, OplusGLSurfaceView_13);
        float f3 = f2 * 2.0f;
        RectF rectF = new RectF(paddingLeft, paddingTop, f3, f3);
        int saveCount = canvas.getSaveCount();
        if (OplusGLSurfaceView_13 == 1) {
            canvas.drawCircle(view.getWidth() / 2.0f, view.getHeight() / 2.0f, f2, this.f17410k);
            canvas.drawCircle(view.getWidth() / 2.0f, view.getHeight() / 2.0f, f2, this.f17406g);
            canvas.drawArc(rectF, fArrM18435a[0], fArrM18435a[1], false, this.f17409j);
        } else if (OplusGLSurfaceView_13 == 2) {
            canvas.drawCircle(view.getWidth() / 2.0f, view.getHeight() / 2.0f, f2, this.f17409j);
            canvas.drawArc(rectF, fArrM18435a[0], fArrM18435a[1], false, this.f17410k);
            canvas.drawArc(rectF, fArrM18435a[0], fArrM18435a[1], false, this.f17406g);
        }
        canvas.restoreToCount(saveCount);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m18444a(PlatformImplementations.kt_3 aVar, Canvas canvas, RectF rectF, int OplusGLSurfaceView_13) {
        if (this.f17402c.containsKey(Integer.valueOf(aVar.hashCode()))) {
            IntrinsicsJvm.kt_4 bVar = this.f17402c.get(Integer.valueOf(aVar.hashCode()));
            View view = (View) aVar;
            view.getLocationOnScreen(new int[2]);
            int iM18446b = m18446b();
            float COUIBaseListPopupWindow_12 = (rectF.bottom - rectF.top) / 2.0f;
            if (iM18446b != -1 && OplusGLSurfaceView_13 == 1) {
                float f2 = iM18446b;
                if (f2 < r4[1] + rectF.top) {
                    bVar.f17475a = false;
                    m18431a(canvas, rectF, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, OplusGLSurfaceView_13, true);
                    view.invalidate();
                    return;
                } else {
                    if (f2 > r4[1] + rectF.bottom) {
                        if (bVar.f17475a) {
                            return;
                        }
                        m18431a(canvas, rectF, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, OplusGLSurfaceView_13, false);
                        aVar.setNormalBackground(false);
                        bVar.f17475a = true;
                        return;
                    }
                    bVar.f17475a = false;
                    m18432a(canvas, rectF, (iM18446b - r4[1]) - rectF.top, OplusGLSurfaceView_13);
                    view.invalidate();
                    return;
                }
            }
            if (iM18446b == -1 || OplusGLSurfaceView_13 != 2) {
                return;
            }
            float f3 = iM18446b;
            if (f3 < r4[1] + rectF.top) {
                if (bVar.f17475a) {
                    return;
                }
                m18431a(canvas, rectF, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, OplusGLSurfaceView_13, false);
                aVar.setNormalBackground(true);
                bVar.f17475a = true;
                return;
            }
            if (f3 > r4[1] + rectF.bottom) {
                bVar.f17475a = false;
                m18431a(canvas, rectF, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, OplusGLSurfaceView_13, true);
                view.invalidate();
            } else {
                bVar.f17475a = false;
                m18432a(canvas, rectF, (iM18446b - r4[1]) - rectF.top, OplusGLSurfaceView_13);
                view.invalidate();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m18443a(PlatformImplementations.kt_3 aVar, Canvas canvas, int OplusGLSurfaceView_13) {
        if (this.f17402c.containsKey(Integer.valueOf(aVar.hashCode()))) {
            IntrinsicsJvm.kt_4 bVar = this.f17402c.get(Integer.valueOf(aVar.hashCode()));
            View view = (View) aVar;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int paddingLeft = view.getPaddingLeft();
            int paddingTop = view.getPaddingTop();
            int paddingRight = view.getPaddingRight();
            int paddingBottom = view.getPaddingBottom();
            int width = (view.getWidth() - paddingLeft) - paddingRight;
            int height = (view.getHeight() - paddingTop) - paddingBottom;
            int iM18446b = m18446b();
            if (iM18446b != -1 && OplusGLSurfaceView_13 == 1) {
                if (iM18446b < iArr[1] + paddingTop) {
                    bVar.f17475a = false;
                    m18434a(view, canvas, OplusGLSurfaceView_13, true);
                    view.invalidate();
                    return;
                } else {
                    if (iM18446b > iArr[1] + paddingTop + height) {
                        if (bVar.f17475a) {
                            return;
                        }
                        m18434a(view, canvas, OplusGLSurfaceView_13, false);
                        aVar.setNormalBackground(false);
                        bVar.f17475a = true;
                        return;
                    }
                    bVar.f17475a = false;
                    m18433a(view, canvas, (iM18446b - iArr[1]) - paddingTop, width / 2.0f, OplusGLSurfaceView_13, bVar.f17477c);
                    view.invalidate();
                    return;
                }
            }
            if (iM18446b == -1 || OplusGLSurfaceView_13 != 2) {
                return;
            }
            if (iM18446b < iArr[1] + paddingTop) {
                if (bVar.f17475a) {
                    return;
                }
                m18434a(view, canvas, OplusGLSurfaceView_13, false);
                aVar.setNormalBackground(true);
                bVar.f17475a = true;
                return;
            }
            if (iM18446b > iArr[1] + paddingTop + height) {
                bVar.f17475a = false;
                m18434a(view, canvas, OplusGLSurfaceView_13, true);
                view.invalidate();
            } else {
                bVar.f17475a = false;
                m18433a(view, canvas, (iM18446b - iArr[1]) - paddingTop, width / 2.0f, OplusGLSurfaceView_13, bVar.f17477c);
                view.invalidate();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18439a(long OplusGLSurfaceView_15) {
        WeakReference weakReference = this.f17404e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((CameraPreviewUI) this.f17404e.get()).m23332a(OplusGLSurfaceView_15);
    }

    /* compiled from: BackgroundSplitManager.java */
    /* renamed from: com.oplus.camera.ui.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public static class IntrinsicsJvm.kt_3 implements Choreographer.FrameCallback {

        /* renamed from: PlatformImplementations.kt_3 */
        private long f17478a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private long f17479b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private long f17480c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f17481d;

        public IntrinsicsJvm.kt_3(long OplusGLSurfaceView_15, long j2, int OplusGLSurfaceView_13) {
            this.f17478a = 0L;
            this.f17479b = 0L;
            this.f17480c = 0L;
            this.f17481d = 0;
            this.f17478a = OplusGLSurfaceView_15;
            this.f17479b = j2;
            this.f17480c = SystemClock.uptimeMillis();
            this.f17481d = OplusGLSurfaceView_13;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long OplusGLSurfaceView_15) {
            this.f17480c = SystemClock.uptimeMillis();
            BackgroundSplitManager.m18429a(this.f17481d).m18439a(this.f17480c);
            if (SystemClock.uptimeMillis() - this.f17478a < this.f17479b) {
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* compiled from: BackgroundSplitManager.java */
    /* renamed from: com.oplus.camera.ui.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean f17475a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public WeakReference f17476b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public String f17477c;

        public IntrinsicsJvm.kt_4(WeakReference weakReference, String str) {
            this.f17475a = false;
            this.f17476b = null;
            this.f17477c = null;
            this.f17475a = false;
            this.f17476b = weakReference;
            this.f17477c = str;
        }
    }
}
