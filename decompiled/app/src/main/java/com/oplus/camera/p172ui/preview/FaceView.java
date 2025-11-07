package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.params.Face;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.preview.FacePointAnimationManager;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes2.dex */
public class FaceView extends View implements FocusIndicator {

    /* renamed from: A */
    private float f20752A;

    /* renamed from: B */
    private int f20753B;

    /* renamed from: C */
    private int f20754C;

    /* renamed from: D */
    private int f20755D;

    /* renamed from: E */
    private Face[] f20756E;

    /* renamed from: F */
    private Face[] f20757F;

    /* renamed from: G */
    private ArrayList<Rect> f20758G;

    /* renamed from: H */
    private ArrayList<Rect> f20759H;

    /* renamed from: I */
    private HashMap<String, String> f20760I;

    /* renamed from: J */
    private ValueAnimator f20761J;

    /* renamed from: K */
    private ValueAnimator f20762K;

    /* renamed from: L */
    private int f20763L;

    /* renamed from: M */
    private int f20764M;

    /* renamed from: N */
    private boolean f20765N;

    /* renamed from: O */
    private boolean f20766O;

    /* renamed from: P */
    private float f20767P;

    /* renamed from: Q */
    private volatile boolean f20768Q;

    /* renamed from: R */
    private int f20769R;

    /* renamed from: S */
    private volatile int f20770S;

    /* renamed from: T */
    private Queue<Rect[]> f20771T;

    /* renamed from: U */
    private int f20772U;

    /* renamed from: V */
    private FacePointAnimationManager f20773V;

    /* renamed from: W */
    private float f20774W;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f20775a;

    /* renamed from: aa */
    private Drawable f20776aa;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f20777b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f20778c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f20779d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f20780e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Matrix f20781f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Rect f20782g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Rect[] f20783h;

    /* renamed from: OplusGLSurfaceView_13 */
    private ArrayList<RectF> f20784i;

    /* renamed from: OplusGLSurfaceView_15 */
    private RectF f20785j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Face[] f20786k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Face[] f20787l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Paint f20788m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f20789n;

    /* renamed from: o */
    private int[] f20790o;

    /* renamed from: p */
    private int[] f20791p;

    /* renamed from: q */
    private int[] f20792q;

    /* renamed from: r */
    private long f20793r;

    /* renamed from: s */
    private boolean f20794s;

    /* renamed from: t */
    private boolean f20795t;

    /* renamed from: u */
    private boolean f20796u;

    /* renamed from: v */
    private boolean f20797v;

    /* renamed from: w */
    private long f20798w;

    /* renamed from: x */
    private float f20799x;

    /* renamed from: y */
    private float f20800y;

    /* renamed from: z */
    private float f20801z;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m22139h() {
        return true;
    }

    public FaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20779d = false;
        this.f20781f = new Matrix();
        this.f20782g = null;
        this.f20783h = null;
        this.f20784i = null;
        this.f20785j = new RectF();
        this.f20789n = 0;
        this.f20793r = 0L;
        this.f20794s = false;
        this.f20795t = false;
        this.f20796u = true;
        this.f20797v = false;
        this.f20798w = 0L;
        this.f20799x = 0.0f;
        this.f20800y = 0.0f;
        this.f20801z = 1.0f;
        this.f20752A = 1.0f;
        this.f20753B = 0;
        this.f20754C = 0;
        this.f20755D = 0;
        this.f20756E = null;
        this.f20757F = null;
        this.f20758G = null;
        this.f20759H = null;
        this.f20760I = null;
        this.f20761J = null;
        this.f20762K = null;
        this.f20763L = 32;
        this.f20764M = 255;
        this.f20765N = false;
        this.f20766O = false;
        this.f20767P = 1.0f;
        this.f20768Q = false;
        this.f20769R = 0;
        this.f20770S = 0;
        this.f20771T = null;
        this.f20772U = 0;
        this.f20773V = null;
        this.f20774W = 0.0f;
        this.f20776aa = null;
        this.f20769R = (int) getResources().getDimension(R.dimen.beauty3d_face_outer_width);
        this.f20788m = new Paint();
        this.f20788m.setAntiAlias(true);
        this.f20788m.setDither(true);
        this.f20788m.setColor(Util.m24164A(context));
        this.f20788m.setStyle(Paint.Style.STROKE);
        this.f20788m.setStrokeCap(Paint.Cap.ROUND);
        this.f20788m.setStrokeWidth(context.getResources().getDimension(R.dimen.focus_common_stroke_width));
        this.f20771T = new LinkedList();
        this.f20784i = new ArrayList<>();
        this.f20773V = new FacePointAnimationManager(this);
        this.f20774W = context.getResources().getDimension(R.dimen.video_tracking_focus_frame_radius);
        this.f20776aa = Util.m24376b(context, R.drawable.icon_face_detect);
        if (m22139h()) {
            m22142k();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22149a(Face[] faceArr, int[] iArr) {
        Face[] faceArr2;
        Face[] faceArr3;
        if (this.f20780e) {
            return;
        }
        this.f20773V.m23515a(iArr);
        if (faceArr == null || this.f20773V.m23517b()) {
            return;
        }
        this.f20787l = this.f20786k;
        this.f20786k = faceArr;
        m22125a(faceArr);
        if (m22139h()) {
            if (this.f20766O) {
                return;
            }
            if (this.f20764M != 0 && this.f20796u && !this.f20765N && (faceArr3 = this.f20786k) != null && faceArr3.length > 0) {
                m22132b(faceArr3);
            }
            if (this.f20755D != 0 && this.f20796u && !this.f20765N) {
                m22140i();
                return;
            }
            if (SystemClock.uptimeMillis() - this.f20798w > 100 && this.f20764M == 255 && this.f20795t && ((faceArr2 = this.f20786k) == null || faceArr2.length == 0 || !this.f20796u)) {
                m22141j();
                return;
            }
            if (this.f20765N || !m22128a(this.f20787l, this.f20786k) || !this.f20796u) {
                return;
            }
            this.f20764M = 255;
            this.f20759H.clear();
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                Face[] faceArr4 = this.f20786k;
                if (OplusGLSurfaceView_13 < faceArr4.length) {
                    this.f20759H.add(new Rect(faceArr4[OplusGLSurfaceView_13].getBounds().left, this.f20786k[OplusGLSurfaceView_13].getBounds().top, this.f20786k[OplusGLSurfaceView_13].getBounds().right, this.f20786k[OplusGLSurfaceView_13].getBounds().bottom));
                    OplusGLSurfaceView_13++;
                } else {
                    invalidate();
                    return;
                }
            }
        } else {
            invalidate();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22125a(Face[] faceArr) {
        boolean z;
        float COUIBaseListPopupWindow_12;
        if (this.f20789n == faceArr.length) {
            z = false;
        } else {
            this.f20789n = faceArr.length;
            this.f20790o = new int[faceArr.length];
            this.f20791p = new int[faceArr.length];
            this.f20792q = new int[faceArr.length];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < faceArr.length; OplusGLSurfaceView_13++) {
                Face face = faceArr[OplusGLSurfaceView_13];
                this.f20790o[OplusGLSurfaceView_13] = m22129b(face.getBounds().left, face.getBounds().right);
                this.f20791p[OplusGLSurfaceView_13] = m22129b(face.getBounds().top, face.getBounds().bottom);
                this.f20792q[OplusGLSurfaceView_13] = m22121a(face);
            }
            this.f20794s = false;
            z = true;
        }
        boolean z2 = z;
        for (int i2 = 0; i2 < faceArr.length; i2++) {
            Face face2 = faceArr[i2];
            int iM22129b = m22129b(face2.getBounds().left, face2.getBounds().right);
            int iM22129b2 = m22129b(face2.getBounds().top, face2.getBounds().bottom);
            int iM22121a = m22121a(face2);
            if (this.f20792q[i2] > 0) {
                float f2 = iM22121a / r7[i2];
                if (f2 < 1.0f) {
                    f2 = 1.0f / f2;
                }
                COUIBaseListPopupWindow_12 = f2 - 1.0f;
            } else {
                COUIBaseListPopupWindow_12 = 0.3f;
            }
            if (m22119a(iM22129b, iM22129b2, this.f20790o[i2], this.f20791p[i2]) > 260 || COUIBaseListPopupWindow_12 >= 0.3f) {
                this.f20794s = false;
                z2 = true;
            }
            if (z2) {
                this.f20790o[i2] = iM22129b;
                this.f20791p[i2] = iM22129b2;
                this.f20792q[i2] = iM22121a;
            }
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!z2 && this.f20794s && jElapsedRealtime - this.f20793r > 3000 && !this.f20766O) {
            this.f20796u = false;
            Queue<Rect[]> queue = this.f20771T;
            if (queue != null) {
                queue.clear();
                return;
            }
            return;
        }
        if (!this.f20796u) {
            this.f20798w = SystemClock.uptimeMillis();
            Queue<Rect[]> queue2 = this.f20771T;
            if (queue2 != null) {
                queue2.clear();
            }
        }
        this.f20796u = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22118a(int OplusGLSurfaceView_13, int i2) {
        return Math.abs(i2 - OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22119a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int i5 = i3 - OplusGLSurfaceView_13;
        int i6 = i4 - i2;
        return (int) Math.sqrt((i5 * i5) + (i6 * i6));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m22129b(int OplusGLSurfaceView_13, int i2) {
        return (OplusGLSurfaceView_13 + i2) / 2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22121a(Face face) {
        return Math.abs(face.getBounds().right - face.getBounds().left) * Math.abs(face.getBounds().bottom - face.getBounds().top);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m22120a(Rect rect) {
        if (rect == null) {
            return 0;
        }
        return Math.abs(rect.right - rect.left) * Math.abs(rect.bottom - rect.top);
    }

    public Rect[] getFaceRects() {
        return this.f20783h;
    }

    public void setDisplayOrientation(int OplusGLSurfaceView_13) {
        this.f20775a = OplusGLSurfaceView_13;
        this.f20773V.m23510a(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22144a(int OplusGLSurfaceView_13, boolean z) {
        this.f20777b = OplusGLSurfaceView_13;
        invalidate();
    }

    public void setMirror(boolean z) {
        this.f20778c = z;
        this.f20773V.m23514a(z);
    }

    public void setRearMirrorEnable(boolean z) {
        this.f20779d = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22145a(Rect rect, Size size) {
        this.f20782g = rect;
        this.f20773V.m23512a(size);
    }

    public void setEISScale(float COUIBaseListPopupWindow_12) {
        this.f20767P = COUIBaseListPopupWindow_12;
        this.f20772U = ((int) Math.sqrt(this.f20801z * this.f20767P * this.f20752A)) + 4;
    }

    public void setZoomValue(float COUIBaseListPopupWindow_12) {
        this.f20801z = COUIBaseListPopupWindow_12;
        this.f20772U = ((int) Math.sqrt(this.f20801z * this.f20767P * this.f20752A)) + 4;
    }

    public void setFaceSlenderZoomValue(float COUIBaseListPopupWindow_12) {
        this.f20752A = COUIBaseListPopupWindow_12;
        this.f20772U = ((int) Math.sqrt(this.f20801z * this.f20767P * this.f20752A)) + 4;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m22150a() {
        Face[] faceArr = this.f20786k;
        return faceArr != null && faceArr.length > 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22146a(boolean z) {
        FacePointAnimationManager c3448k = this.f20773V;
        if (c3448k == null || !c3448k.m23520e() || this.f20773V.m23517b()) {
            return;
        }
        this.f20773V.m23516b(z);
    }

    @Override // com.oplus.camera.p172ui.preview.FocusIndicator
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22148a(boolean z, boolean z2) {
        CameraLog.m12954a("FaceView", "showSuccess()");
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22151b() {
        if (this.f20786k != null) {
            CameraLog.m12954a("FaceView", "clear()");
            this.f20786k = null;
            this.f20789n = 0;
            ArrayList<Rect> arrayList = this.f20759H;
            if (arrayList != null && arrayList.size() > 0) {
                this.f20759H.clear();
                invalidate();
            }
        }
        Queue<Rect[]> queue = this.f20771T;
        if (queue != null) {
            queue.clear();
        }
        ArrayList<RectF> arrayList2 = this.f20784i;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m22152c() {
        CameraLog.m12954a("FaceView", "pause()");
        this.f20780e = true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m22153d() {
        CameraLog.m12954a("FaceView", "resume()");
        this.f20780e = false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m22154e() {
        this.f20780e = true;
        this.f20786k = null;
        this.f20784i = null;
        this.f20781f = null;
        this.f20788m = null;
        this.f20771T = null;
        m22143l();
        FacePointAnimationManager c3448k = this.f20773V;
        if (c3448k != null) {
            c3448k.m23519d();
        }
        this.f20773V = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int length;
        ArrayList<RectF> arrayList;
        Face[] faceArr;
        this.f20781f.reset();
        this.f20795t = false;
        ArrayList<Rect> arrayList2 = this.f20759H;
        if (arrayList2 != null) {
            length = arrayList2.size();
        } else {
            Face[] faceArr2 = this.f20786k;
            length = faceArr2 != null ? faceArr2.length : 0;
        }
        ArrayList<RectF> arrayList3 = this.f20784i;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        this.f20773V.m23511a(canvas);
        if (length > 0) {
            this.f20781f.setTranslate((-this.f20782g.width()) / 2, (-this.f20782g.height()) / 2);
            this.f20781f.postScale(this.f20778c ? -1.0f : 1.0f, this.f20779d ? -1.0f : 1.0f);
            this.f20781f.postRotate(this.f20775a);
            this.f20781f.postScale((((getWidth() * this.f20801z) * this.f20767P) * this.f20752A) / this.f20782g.height(), (((getHeight() * this.f20801z) * this.f20767P) * this.f20752A) / this.f20782g.width());
            this.f20781f.postTranslate(getWidth() / 2, getHeight() / 2);
            this.f20783h = new Rect[length];
            int OplusGLSurfaceView_13 = 0;
            for (int i2 = 0; i2 < length; i2++) {
                ArrayList<Rect> arrayList4 = this.f20759H;
                if (arrayList4 != null) {
                    this.f20785j.set(arrayList4.get(i2));
                } else {
                    this.f20785j.set(this.f20786k[i2].getBounds());
                }
                this.f20785j.offset(-this.f20782g.left, -this.f20782g.top);
                this.f20781f.mapRect(this.f20785j);
                Rect rect = new Rect(Math.max(0, Math.round(this.f20785j.left)), Math.max(0, Math.round(this.f20785j.top)), Math.min(getWidth(), Math.round(this.f20785j.right)), Math.min(getHeight(), Math.round(this.f20785j.bottom)));
                int iM22120a = m22120a(rect);
                if (iM22120a >= OplusGLSurfaceView_13) {
                    OplusGLSurfaceView_13 = iM22120a;
                }
                this.f20783h[i2] = rect;
            }
            Queue<Rect[]> queue = this.f20771T;
            if (queue != null) {
                Rect[] rectArr = this.f20783h;
                if (rectArr.length > 0) {
                    queue.offer(rectArr);
                }
            }
            while (true) {
                Queue<Rect[]> queue2 = this.f20771T;
                if (queue2 == null || queue2.size() <= this.f20772U) {
                    break;
                } else {
                    this.f20771T.poll();
                }
            }
            Queue<Rect[]> queue3 = this.f20771T;
            if (queue3 != null && (faceArr = this.f20787l) != null && this.f20783h.length != faceArr.length) {
                queue3.clear();
                this.f20771T.offer(this.f20783h);
            }
            Queue<Rect[]> queue4 = this.f20771T;
            if (queue4 != null && queue4.size() > 0) {
                for (int i3 = 0; i3 < this.f20783h.length; i3++) {
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    for (Rect[] rectArr2 : this.f20771T) {
                        if (rectArr2.length > i3 && !rectArr2[i3].isEmpty()) {
                            i5 += rectArr2[i3].left;
                            i7 += rectArr2[i3].right;
                            i6 += rectArr2[i3].top;
                            i8 += rectArr2[i3].bottom;
                            i4++;
                        }
                    }
                    if (i4 != 0 && (arrayList = this.f20784i) != null) {
                        arrayList.add(new RectF(i5 / i4, i6 / i4, i7 / i4, i8 / i4));
                    }
                }
            }
            ArrayList<RectF> arrayList5 = this.f20784i;
            if (arrayList5 == null || arrayList5.isEmpty()) {
                return;
            }
            for (int i9 = 0; i9 < this.f20784i.size(); i9++) {
                if (this.f20796u) {
                    if (!this.f20794s) {
                        this.f20793r = SystemClock.elapsedRealtime();
                    }
                    this.f20794s = true;
                    this.f20795t = true;
                    this.f20788m.setAlpha(this.f20764M);
                    RectF rectF = this.f20784i.get(i9);
                    m22123a(rectF);
                    this.f20776aa.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    this.f20776aa.setAlpha(this.f20764M);
                    this.f20776aa.draw(canvas);
                }
            }
        }
        ArrayList<Rect> arrayList6 = this.f20759H;
        if (arrayList6 != null && this.f20764M == 0 && arrayList6.size() > 0) {
            this.f20759H.clear();
        }
        ArrayList<RectF> arrayList7 = this.f20784i;
        if (arrayList7 != null) {
            arrayList7.clear();
        }
        super.onDraw(canvas);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m22140i() {
        if (this.f20765N) {
            return;
        }
        this.f20765N = true;
        this.f20764M = 255;
        setLayerType(2, null);
        int OplusGLSurfaceView_13 = this.f20763L;
        this.f20753B = (OplusGLSurfaceView_13 / 16) + 1;
        this.f20754C = 0;
        this.f20800y = 100.0f / this.f20753B;
        ValueAnimator valueAnimator = this.f20761J;
        if (valueAnimator != null) {
            valueAnimator.setDuration(OplusGLSurfaceView_13);
            this.f20761J.start();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22128a(Face[] faceArr, Face[] faceArr2) {
        int OplusGLSurfaceView_13;
        if (faceArr == null || faceArr2 == null || faceArr.length <= 0 || faceArr.length != faceArr2.length) {
            OplusGLSurfaceView_13 = 0;
        } else {
            OplusGLSurfaceView_13 = 0;
            for (int i2 = 0; i2 < faceArr.length; i2++) {
                Rect bounds = faceArr[i2].getBounds();
                int iM22129b = m22129b(bounds.left, bounds.right);
                int iM22129b2 = m22129b(bounds.top, bounds.bottom);
                int iM22121a = m22121a(faceArr[i2]);
                int i3 = 0;
                while (true) {
                    if (i3 >= faceArr2.length) {
                        break;
                    }
                    if (-1 == faceArr2[i2].getId() || faceArr[i2].getId() != faceArr2[i3].getId()) {
                        i3++;
                    } else {
                        Rect bounds2 = faceArr2[i3].getBounds();
                        int iM22129b3 = m22129b(bounds2.left, bounds2.right);
                        int iM22129b4 = m22129b(bounds2.top, bounds2.bottom);
                        int iM22121a2 = m22121a(faceArr2[i3]);
                        if (m22119a(iM22129b, iM22129b2, iM22129b3, iM22129b4) == 0 && m22118a(iM22121a, iM22121a2) == 0) {
                            OplusGLSurfaceView_13++;
                        }
                    }
                }
            }
        }
        if (faceArr == null || faceArr2 == null || OplusGLSurfaceView_13 != faceArr2.length || OplusGLSurfaceView_13 != faceArr.length) {
            return (faceArr == null && faceArr2 == null) ? false : true;
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22132b(Face[] faceArr) {
        Face[] faceArr2;
        if (!m22128a(this.f20757F, faceArr)) {
            return;
        }
        this.f20763L = 32;
        int OplusGLSurfaceView_13 = 0;
        this.f20755D = 0;
        this.f20756E = this.f20757F;
        this.f20757F = faceArr;
        this.f20758G.clear();
        this.f20760I.clear();
        Face[] faceArr3 = this.f20756E;
        if (faceArr3 != null && (faceArr2 = this.f20757F) != null && faceArr3.length > 0 && faceArr2.length > 0) {
            int i2 = 0;
            while (true) {
                Face[] faceArr4 = this.f20756E;
                if (i2 >= faceArr4.length) {
                    break;
                }
                Rect bounds = faceArr4[i2].getBounds();
                int iM22129b = m22129b(bounds.left, bounds.right);
                int iM22129b2 = m22129b(bounds.top, bounds.bottom);
                int iM22121a = m22121a(this.f20756E[i2]);
                int i3 = 0;
                while (true) {
                    Face[] faceArr5 = this.f20757F;
                    if (i3 < faceArr5.length) {
                        if (-1 != faceArr5[i3].getId() && this.f20757F[i3].getId() == this.f20756E[i2].getId() && !this.f20760I.containsKey(String.valueOf(i3))) {
                            Rect bounds2 = this.f20757F[i3].getBounds();
                            int iM22129b3 = m22129b(bounds2.left, bounds2.right);
                            int iM22129b4 = m22129b(bounds2.top, bounds2.bottom);
                            int iM22121a2 = m22121a(this.f20757F[i3]);
                            m22118a(iM22121a, iM22121a2);
                            int iM22119a = m22119a(iM22129b, iM22129b2, iM22129b3, iM22129b4);
                            float COUIBaseListPopupWindow_12 = 0.0f;
                            if (iM22121a > 0) {
                                float f2 = (iM22121a2 * 1.0f) / iM22121a;
                                if (f2 < 1.0f) {
                                    f2 = 1.0f / f2;
                                }
                                COUIBaseListPopupWindow_12 = f2 - 1.0f;
                            }
                            if (iM22119a > 2 || COUIBaseListPopupWindow_12 > 0.01f) {
                                int iM24205a = Util.m24205a((int) ((iM22119a / 30.0f) * 32.0f), 32, 96);
                                int iM24205a2 = Util.m24205a((int) (COUIBaseListPopupWindow_12 * 32.0f * 1.5f), 32, 160);
                                if (iM24205a > this.f20763L) {
                                    this.f20763L = iM24205a;
                                }
                                if (iM24205a2 > this.f20763L) {
                                    this.f20763L = iM24205a2;
                                }
                                this.f20755D = 1 << i3;
                                this.f20760I.put(String.valueOf(i3), String.valueOf(i2));
                                this.f20758G.add(new Rect(bounds2.left - bounds.left, bounds2.top - bounds.top, bounds2.right - bounds.right, bounds2.bottom - bounds.bottom));
                            }
                        }
                        i3++;
                    }
                }
                i2++;
            }
        }
        if (this.f20755D == 0) {
            return;
        }
        this.f20759H.clear();
        while (true) {
            Face[] faceArr6 = this.f20757F;
            if (OplusGLSurfaceView_13 >= faceArr6.length) {
                return;
            }
            this.f20759H.add(new Rect(faceArr6[OplusGLSurfaceView_13].getBounds().left, this.f20757F[OplusGLSurfaceView_13].getBounds().top, this.f20757F[OplusGLSurfaceView_13].getBounds().right, this.f20757F[OplusGLSurfaceView_13].getBounds().bottom));
            OplusGLSurfaceView_13++;
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m22141j() {
        if (this.f20766O) {
            return;
        }
        this.f20796u = true;
        ValueAnimator valueAnimator = this.f20761J;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f20761J.cancel();
        }
        ValueAnimator valueAnimator2 = this.f20762K;
        if (valueAnimator2 != null) {
            this.f20766O = true;
            valueAnimator2.start();
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m22142k() {
        this.f20758G = new ArrayList<>();
        this.f20759H = new ArrayList<>();
        this.f20760I = new HashMap<>();
        this.f20761J = ValueAnimator.ofInt(0, 100);
        this.f20761J.setDuration(this.f20763L);
        this.f20761J.setInterpolator(new LinearInterpolator());
        this.f20761J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.FaceView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) throws NumberFormatException {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (!FaceView.this.f20780e || FaceView.this.f20761J == null) {
                    if (!FaceView.this.f20765N || FaceView.this.f20754C >= FaceView.this.f20753B) {
                        return;
                    }
                    if (!FaceView.this.f20766O || FaceView.this.f20761J == null) {
                        FaceView.this.m22122a(iIntValue);
                        FaceView.this.invalidate();
                        return;
                    } else {
                        FaceView.this.f20761J.end();
                        return;
                    }
                }
                FaceView.this.f20761J.cancel();
            }
        });
        this.f20761J.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.FaceView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                FaceView.this.f20765N = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FaceView.this.setLayerType(0, null);
                FaceView.this.f20765N = false;
                FaceView.this.f20755D = 0;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                FaceView.this.f20765N = false;
            }
        });
        this.f20762K = ValueAnimator.ofInt(255, 0);
        this.f20762K.setDuration(300L);
        this.f20762K.setInterpolator(new LinearInterpolator());
        this.f20762K.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.FaceView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FaceView.this.f20764M = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                FaceView.this.invalidate();
            }
        });
        this.f20762K.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.FaceView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FaceView.this.f20766O = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m22122a(int OplusGLSurfaceView_13) throws NumberFormatException {
        int i2 = this.f20754C;
        this.f20754C = i2 + 1;
        float COUIBaseListPopupWindow_12 = (i2 < this.f20753B ? this.f20754C * this.f20800y : 100.0f) / 100.0f;
        if (OplusGLSurfaceView_13 >= 100) {
            COUIBaseListPopupWindow_12 = 1.0f;
            this.f20754C = this.f20753B;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            ArrayList<Rect> arrayList = this.f20759H;
            if (arrayList == null || i3 >= arrayList.size()) {
                return;
            }
            if ((this.f20755D & (1 << i3)) != 0) {
                int i5 = Integer.parseInt(this.f20760I.get(String.valueOf(i3)));
                this.f20759H.get(i3).left = this.f20756E[i5].getBounds().left + ((int) (this.f20758G.get(i4).left * COUIBaseListPopupWindow_12));
                this.f20759H.get(i3).top = this.f20756E[i5].getBounds().top + ((int) (this.f20758G.get(i4).top * COUIBaseListPopupWindow_12));
                this.f20759H.get(i3).right = this.f20756E[i5].getBounds().right + ((int) (this.f20758G.get(i4).right * COUIBaseListPopupWindow_12));
                this.f20759H.get(i3).bottom = this.f20756E[i5].getBounds().bottom + ((int) (this.f20758G.get(i4).bottom * COUIBaseListPopupWindow_12));
                i4++;
            }
            i3++;
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m22143l() {
        if (m22139h()) {
            this.f20755D = 0;
            this.f20756E = null;
            this.f20757F = null;
            this.f20787l = null;
            this.f20786k = null;
            ValueAnimator valueAnimator = this.f20761J;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f20761J.end();
            }
            ValueAnimator valueAnimator2 = this.f20762K;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f20762K.end();
            }
            this.f20761J = null;
            this.f20762K = null;
            ArrayList<Rect> arrayList = this.f20758G;
            if (arrayList != null) {
                arrayList.clear();
                this.f20758G = null;
            }
            ArrayList<Rect> arrayList2 = this.f20759H;
            if (arrayList2 != null) {
                arrayList2.clear();
                this.f20759H = null;
            }
            HashMap<String, String> map = this.f20760I;
            if (map != null) {
                map.clear();
                this.f20760I = null;
            }
        }
    }

    public void setShowBeauty3DFace(boolean z) {
        this.f20768Q = z;
    }

    public void setMainFaceIndex(int OplusGLSurfaceView_13) {
        this.f20770S = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m22155f() {
        Face[] faceArr = this.f20786k;
        return faceArr == null || faceArr.length == 0 || !(this.f20796u || this.f20766O);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m22156g() {
        FacePointAnimationManager c3448k = this.f20773V;
        if (c3448k != null) {
            c3448k.m23509a();
        }
    }

    public void setFacePointAnimationListener(FacePointAnimationManager.IntrinsicsJvm.kt_4 bVar) {
        FacePointAnimationManager c3448k = this.f20773V;
        if (c3448k != null) {
            c3448k.m23513a(bVar);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22147a(boolean z, float COUIBaseListPopupWindow_12) {
        this.f20797v = z;
        this.f20799x = (getWidth() * (1.0f - COUIBaseListPopupWindow_12)) / 2.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22123a(RectF rectF) {
        if (this.f20797v) {
            if (rectF.right > getRight() - this.f20799x) {
                rectF.right = getRight() - this.f20799x;
            } else {
                float COUIBaseListPopupWindow_12 = rectF.right;
                float f2 = this.f20799x;
                if (COUIBaseListPopupWindow_12 < f2) {
                    rectF.right = f2;
                }
            }
            if (rectF.left < getLeft() + this.f20799x) {
                rectF.left = getLeft() + this.f20799x;
            } else if (rectF.left > getRight() - this.f20799x) {
                rectF.left = getRight() - this.f20799x;
            }
            if (rectF.bottom > getBottom()) {
                rectF.bottom = getBottom();
            } else if (rectF.bottom < 0.0f) {
                rectF.bottom = 0.0f;
            }
            if (rectF.top > getBottom()) {
                rectF.top = getBottom();
            } else if (rectF.top < 0.0f) {
                rectF.top = 0.0f;
            }
        }
    }
}
