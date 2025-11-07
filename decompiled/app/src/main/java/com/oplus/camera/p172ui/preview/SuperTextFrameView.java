package com.oplus.camera.p172ui.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p171u.DetectResult;
import com.oplus.camera.util.Util;
import java.util.Arrays;

/* compiled from: SuperTextFrameView.java */
/* renamed from: com.oplus.camera.ui.preview.z */
/* loaded from: classes2.dex */
public class SuperTextFrameView extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private PointF[] f22468a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Paint f22469b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Path f22470c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Path f22471d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f22472e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f22473f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f22474g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Handler f22475h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f22476i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f22477j;

    public SuperTextFrameView(Context context) {
        super(context);
        this.f22468a = null;
        this.f22469b = null;
        this.f22470c = null;
        this.f22471d = null;
        this.f22472e = false;
        m23895a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23895a(Context context) {
        this.f22469b = new Paint(1);
        this.f22470c = new Path();
        this.f22471d = new Path();
        this.f22473f = Util.m24164A(context);
        this.f22474g = this.f22473f & 452984831;
        this.f22475h = new Handler(Looper.getMainLooper());
    }

    public void setMStrokeColor(int OplusGLSurfaceView_13) {
        this.f22473f = OplusGLSurfaceView_13;
        invalidate();
    }

    public void setMSolidColor(int OplusGLSurfaceView_13) {
        this.f22474g = OplusGLSurfaceView_13;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        PointF[] pointFArr = this.f22468a;
        if (pointFArr == null || pointFArr.length != 4) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            return;
        }
        canvas.save();
        this.f22476i = getWidth();
        this.f22477j = getHeight();
        this.f22469b.setAntiAlias(true);
        this.f22469b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f22469b.setColor(this.f22474g);
        this.f22470c.reset();
        this.f22470c.moveTo(this.f22468a[0].x * this.f22476i, this.f22468a[0].y * this.f22477j);
        this.f22470c.lineTo(this.f22468a[1].x * this.f22476i, this.f22468a[1].y * this.f22477j);
        this.f22470c.lineTo(this.f22468a[2].x * this.f22476i, this.f22468a[2].y * this.f22477j);
        this.f22470c.lineTo(this.f22468a[3].x * this.f22476i, this.f22468a[3].y * this.f22477j);
        this.f22470c.close();
        canvas.drawPath(this.f22470c, this.f22469b);
        this.f22469b.setStyle(Paint.Style.STROKE);
        this.f22469b.setStrokeWidth(4.0f);
        this.f22469b.setColor(this.f22473f);
        this.f22471d.reset();
        this.f22471d.moveTo(this.f22468a[0].x * this.f22476i, this.f22468a[0].y * this.f22477j);
        this.f22471d.lineTo(this.f22468a[1].x * this.f22476i, this.f22468a[1].y * this.f22477j);
        this.f22471d.lineTo(this.f22468a[2].x * this.f22476i, this.f22468a[2].y * this.f22477j);
        this.f22471d.lineTo(this.f22468a[3].x * this.f22476i, this.f22468a[3].y * this.f22477j);
        this.f22471d.close();
        canvas.drawPath(this.f22471d, this.f22469b);
        canvas.restore();
    }

    public void setPointsArray(PointF[] pointFArr) {
        if (pointFArr == null || this.f22472e) {
            this.f22468a = null;
            this.f22471d.reset();
            this.f22470c.reset();
            invalidate();
            return;
        }
        this.f22468a = pointFArr;
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23896a(DetectResult c3077a) {
        CameraLog.m12954a("SuperTextFrameView", "executeAnimation, mPointsArray: " + Arrays.toString(this.f22468a));
        this.f22468a = c3077a.m17955b();
        setVisibility(0);
    }
}
