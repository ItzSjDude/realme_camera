package com.oplus.camera.p172ui.preview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p146gl.GLPaint;
import com.oplus.camera.p146gl.GLCanvas;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class MultiFocusView extends View implements FocusIndicator {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int[] f20839a = {0, 0};

    /* renamed from: A */
    private Drawable f20840A;

    /* renamed from: B */
    private CopyOnWriteArrayList<RectF> f20841B;

    /* renamed from: C */
    private int[] f20842C;

    /* renamed from: D */
    private GLPaint f20843D;

    /* renamed from: E */
    private Size f20844E;

    /* renamed from: F */
    private PreviewRenderCallback f20845F;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f20846b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f20847c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f20848d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f20849e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f20850f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f20851g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f20852h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f20853i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f20854j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int[] f20855k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f20856l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f20857m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f20858n;

    /* renamed from: o */
    private int f20859o;

    /* renamed from: p */
    private int f20860p;

    /* renamed from: q */
    private int f20861q;

    /* renamed from: r */
    private int f20862r;

    /* renamed from: s */
    private ArrayList<Integer> f20863s;

    /* renamed from: t */
    private int f20864t;

    /* renamed from: u */
    private int f20865u;

    /* renamed from: v */
    private int f20866v;

    /* renamed from: w */
    private int f20867w;

    /* renamed from: x */
    private Matrix f20868x;

    /* renamed from: y */
    private RectF f20869y;

    /* renamed from: z */
    private Rect f20870z;

    public MultiFocusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20846b = 0;
        this.f20847c = -1;
        this.f20848d = 255;
        this.f20849e = 0;
        this.f20850f = 0;
        this.f20851g = 4;
        this.f20852h = this.f20851g / 2;
        this.f20853i = true;
        this.f20854j = 0.0f;
        this.f20855k = null;
        this.f20856l = 0;
        this.f20857m = 0;
        this.f20858n = 0;
        this.f20859o = 0;
        this.f20860p = 0;
        this.f20861q = 0;
        this.f20862r = 0;
        this.f20863s = null;
        this.f20864t = 0;
        this.f20865u = 0;
        this.f20866v = 0;
        this.f20867w = 0;
        this.f20868x = new Matrix();
        this.f20869y = null;
        this.f20870z = null;
        this.f20840A = null;
        this.f20841B = new CopyOnWriteArrayList<>();
        this.f20842C = new int[]{0, 0};
        this.f20843D = new GLPaint();
        this.f20844E = null;
        this.f20845F = new PreviewRenderCallback() { // from class: com.oplus.camera.ui.preview.MultiFocusView.2
            @Override // com.oplus.camera.p172ui.preview.PreviewRenderCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo22195a(GLCanvas interfaceC2757h, boolean z) {
            }

            @Override // com.oplus.camera.p172ui.preview.PreviewRenderCallback
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo22196b(GLCanvas interfaceC2757h, boolean z) {
                if (MultiFocusView.this.f20853i) {
                    return;
                }
                if (z) {
                    MultiFocusView.this.f20841B.clear();
                }
                if (1 != MultiFocusView.this.f20847c || MultiFocusView.this.f20841B.isEmpty()) {
                    return;
                }
                Iterator it = MultiFocusView.this.f20841B.iterator();
                while (it.hasNext()) {
                    MultiFocusView.this.m22180a(interfaceC2757h, (RectF) it.next());
                }
            }
        };
        Resources resources = context.getResources();
        this.f20840A = Util.m24376b(context, R.drawable.icon_face_detecte);
        this.f20854j = resources.getDimensionPixelSize(R.dimen.multi_focus_view_rect_space);
        this.f20850f = Util.m24164A(context);
        this.f20869y = new RectF();
        this.f20870z = new Rect();
        this.f20863s = new ArrayList<>();
        this.f20843D.m14024a(this.f20850f);
        this.f20843D.m14023a(this.f20851g);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22187a(int[] iArr, Size size) {
        if (this.f20853i || iArr == null) {
            return;
        }
        int[] iArr2 = this.f20855k;
        if (iArr2 == null || iArr2.length <= 0 || !Arrays.equals(iArr, iArr2)) {
            int[] iArr3 = this.f20855k;
            if (iArr3 != null && iArr3.length > 0 && iArr[0] != iArr3[0]) {
                m22189b();
            }
            this.f20855k = iArr;
            if (iArr.length != 0) {
                switch (iArr[0]) {
                    case 2:
                    case 3:
                        this.f20847c = 0;
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        this.f20847c = 1;
                        break;
                    default:
                        this.f20847c = -1;
                        return;
                }
                this.f20868x.reset();
                this.f20868x.setTranslate((-getHeight()) / 2, (-getWidth()) / 2);
                this.f20868x.postRotate(this.f20846b);
                this.f20868x.postTranslate(getWidth() / 2, getHeight() / 2);
                int OplusGLSurfaceView_13 = this.f20847c;
                if (OplusGLSurfaceView_13 == 0) {
                    this.f20870z.setEmpty();
                    this.f20841B.clear();
                    float width = size.getHeight() != 0 ? getWidth() / size.getHeight() : 1.0f;
                    this.f20864t = (int) (iArr[1] * width);
                    this.f20865u = (int) (iArr[2] * width);
                    this.f20866v = (int) (iArr[3] * width);
                    this.f20867w = (int) (iArr[4] * width);
                    this.f20869y.set(this.f20864t, this.f20865u, r12 + this.f20866v, r1 + this.f20867w);
                    this.f20868x.mapRect(this.f20869y);
                    this.f20869y.round(this.f20870z);
                } else if (1 == OplusGLSurfaceView_13) {
                    this.f20856l = iArr[1];
                    this.f20857m = iArr[2];
                    this.f20858n = iArr[3];
                    this.f20859o = iArr[4];
                    this.f20860p = iArr[5];
                    this.f20861q = iArr[6];
                    this.f20862r = iArr[7];
                    if (this.f20857m <= 0) {
                        CameraLog.m12959b("MultiFocusView", "setPosition, Face info is error");
                        return;
                    }
                    if (Util.m24495t() && getWidth() > 0) {
                        this.f20849e = getWidth() / this.f20857m;
                    } else {
                        this.f20849e = Util.getScreenWidth() / this.f20857m;
                    }
                    this.f20863s = m22179a(this.f20862r);
                    this.f20870z.setEmpty();
                    this.f20841B.clear();
                    Iterator<Integer> it = this.f20863s.iterator();
                    while (it.hasNext()) {
                        int iIntValue = it.next().intValue();
                        int i2 = this.f20858n;
                        int i3 = this.f20860p;
                        int i4 = this.f20849e;
                        float COUIBaseListPopupWindow_12 = this.f20854j;
                        int i5 = this.f20859o;
                        RectF rectF = new RectF((((iIntValue % (i3 - i2)) + i2) * i4) + COUIBaseListPopupWindow_12, (((iIntValue / (i3 - i2)) + i5) * i4) + COUIBaseListPopupWindow_12, ((((iIntValue % (i3 - i2)) + i2) + 1) * i4) - COUIBaseListPopupWindow_12, (((i5 + (iIntValue / (i3 - i2))) + 1) * i4) - COUIBaseListPopupWindow_12);
                        this.f20868x.mapRect(rectF);
                        this.f20841B.add(rectF);
                    }
                }
            }
            invalidate();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m22188a() {
        return 1 == this.f20847c;
    }

    public void setDisplayOrientation(int OplusGLSurfaceView_13) {
        this.f20846b = OplusGLSurfaceView_13;
        CameraLog.m12959b("MultiFocusView", "setDisplayOrientation, mDisplayOrientation: " + this.f20846b);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Rect rect;
        if (this.f20847c != 0 || (rect = this.f20870z) == null) {
            return;
        }
        this.f20840A.setBounds(rect);
        this.f20840A.setAlpha(this.f20848d);
        this.f20840A.draw(canvas);
    }

    @Override // com.oplus.camera.p172ui.preview.FocusIndicator
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22148a(boolean z, boolean z2) {
        CameraLog.m12959b("MultiFocusView", "showSuccess");
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22189b() {
        if (this.f20855k != null) {
            CameraLog.m12959b("MultiFocusView", "clear");
            if (this.f20855k != null) {
                this.f20855k = null;
            }
            Rect rect = this.f20870z;
            if (rect != null) {
                rect.setEmpty();
            }
            RectF rectF = this.f20869y;
            if (rectF != null) {
                rectF.setEmpty();
            }
            ArrayList<Integer> arrayList = this.f20863s;
            if (arrayList != null) {
                arrayList.clear();
            }
            Matrix matrix = this.f20868x;
            if (matrix != null) {
                matrix.reset();
            }
            this.f20841B.clear();
            this.f20847c = -1;
            postInvalidate();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m22190c() {
        CameraLog.m12959b("MultiFocusView", VideoRecordMsgData.EVENT_PAUSE);
        m22189b();
        this.f20853i = true;
        this.f20842C = f20839a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m22191d() {
        CameraLog.m12959b("MultiFocusView", "resume");
        m22189b();
        this.f20853i = false;
        getLocationOnScreen(this.f20842C);
        CameraLog.m12959b("MultiFocusView", "resume, x: " + this.f20842C[0] + ", y: " + this.f20842C[1]);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m22192e() {
        CameraLog.m12959b("MultiFocusView", "releaseMultiFocusView");
        m22189b();
        this.f20853i = true;
        if (this.f20840A != null) {
            this.f20840A = null;
        }
        if (this.f20868x != null) {
            this.f20868x = null;
        }
        if (this.f20855k != null) {
            this.f20855k = null;
        }
        if (this.f20869y != null) {
            this.f20869y = null;
        }
        if (this.f20870z != null) {
            this.f20870z = null;
        }
        ArrayList<Integer> arrayList = this.f20863s;
        if (arrayList != null) {
            arrayList.clear();
            this.f20863s = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m22193f() {
        int[] iArr;
        return (this.f20853i || (iArr = this.f20855k) == null || iArr.length <= 0) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ArrayList m22179a(int OplusGLSurfaceView_13) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (OplusGLSurfaceView_13 != 0) {
            if (1 == (OplusGLSurfaceView_13 & 1)) {
                arrayList.add(Integer.valueOf(i2));
            }
            i2++;
            OplusGLSurfaceView_13 >>>= 1;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m22180a(GLCanvas interfaceC2757h, RectF rectF) {
        PointF pointF = new PointF(this.f20842C[0] + rectF.left, this.f20842C[1] + rectF.top);
        PointF pointF2 = new PointF(pointF.x, pointF.y + rectF.height());
        PointF pointF3 = new PointF(pointF2.x + rectF.width(), pointF2.y);
        PointF pointF4 = new PointF(pointF3.x, pointF3.y - rectF.height());
        PointF pointF5 = new PointF(pointF4.x - rectF.width(), pointF4.y);
        if (m22182a(pointF) && m22182a(pointF2) && m22182a(pointF2) && m22182a(pointF3) && m22182a(pointF3) && m22182a(pointF4) && m22182a(pointF4) && m22182a(pointF5)) {
            interfaceC2757h.mo13964a(pointF.x, pointF.y, pointF2.x, pointF2.y + this.f20852h, this.f20843D);
            interfaceC2757h.mo13964a(pointF2.x, pointF2.y, pointF3.x + this.f20852h, pointF3.y, this.f20843D);
            interfaceC2757h.mo13964a(pointF3.x, pointF3.y, pointF4.x, pointF4.y - this.f20852h, this.f20843D);
            interfaceC2757h.mo13964a(pointF4.x, pointF4.y, pointF5.x - this.f20852h, pointF5.y, this.f20843D);
        }
    }

    protected PreviewRenderCallback getListener() {
        return this.f20845F;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m22182a(PointF pointF) {
        int[] iArr = this.f20842C;
        int OplusGLSurfaceView_13 = iArr[0];
        int i2 = iArr[1];
        return pointF.x >= ((float) OplusGLSurfaceView_13) && pointF.x <= ((float) (OplusGLSurfaceView_13 + getWidth())) && pointF.y >= ((float) i2) && pointF.y <= ((float) (i2 + getHeight()));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m22194g() {
        if (!this.f20853i) {
            m22189b();
            post(new Runnable() { // from class: com.oplus.camera.ui.preview.MultiFocusView.1
                @Override // java.lang.Runnable
                public void run() {
                    MultiFocusView multiFocusView = MultiFocusView.this;
                    multiFocusView.getLocationOnScreen(multiFocusView.f20842C);
                }
            });
        }
        CameraLog.m12959b("MultiFocusView", "onPreviewLayoutChanged, x: " + this.f20842C[0] + ", y: " + this.f20842C[1] + ", mbPause: " + this.f20853i);
    }
}
