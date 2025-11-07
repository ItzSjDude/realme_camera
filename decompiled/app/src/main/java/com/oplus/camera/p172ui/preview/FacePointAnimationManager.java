package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PointFEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.oplus.camera.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: FacePointAnimationManager.java */
/* renamed from: com.oplus.camera.ui.preview.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class FacePointAnimationManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int[][] f22125a = {new int[]{121}, new int[]{115, 127}, new int[]{110, 132}, new int[]{-1, 118, 39, -1, 124, 36}, new int[]{-1, 38, 37}, new int[]{105, 104}, new int[]{106, 136}, new int[]{44}, new int[]{30, 3}, new int[]{46}, new int[]{-1, 81, 61, -1, 82, 52}, new int[]{-1, 49, 87}, new int[]{25, 8}, new int[]{90, 96}, new int[]{16}};

    /* renamed from: COUIBaseListPopupWindow_10 */
    private FaceView f22132h;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f22134j;

    /* renamed from: OplusGLSurfaceView_6 */
    private Interpolator f22137m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Interpolator f22138n;

    /* renamed from: o */
    private Interpolator f22139o;

    /* renamed from: p */
    private Interpolator f22140p;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int[] f22126b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Size f22127c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f22128d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f22129e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Matrix f22130f = new Matrix();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private List<FaceBean> f22131g = new ArrayList();

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f22133i = false;

    /* renamed from: OplusGLSurfaceView_5 */
    private Random f22135k = new Random();

    /* renamed from: OplusGLSurfaceView_14 */
    private IntrinsicsJvm.kt_4 f22136l = null;

    /* renamed from: q */
    private Handler f22141q = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.preview.OplusGLSurfaceView_5.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (FacePointAnimationManager.this.f22134j) {
                return;
            }
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 1) {
                if (FacePointAnimationManager.this.f22136l != null) {
                    FacePointAnimationManager.this.f22136l.mo23372al();
                }
                FacePointAnimationManager.this.m23518c();
            } else {
                if (OplusGLSurfaceView_13 != 2) {
                    return;
                }
                if (FacePointAnimationManager.this.f22133i || FacePointAnimationManager.this.f22136l == null || !FacePointAnimationManager.this.f22136l.mo23373am()) {
                    FacePointAnimationManager.this.f22141q.sendEmptyMessageDelayed(2, 50L);
                } else {
                    FacePointAnimationManager.this.m23509a();
                }
            }
        }
    };

    /* compiled from: FacePointAnimationManager.java */
    /* renamed from: com.oplus.camera.ui.preview.OplusGLSurfaceView_5$PlatformImplementations.kt_3 */
    private enum PlatformImplementations.kt_3 {
        ALPHA,
        SCALE,
        TRANSLATION_X,
        TRANSLATION_Y
    }

    /* compiled from: FacePointAnimationManager.java */
    /* renamed from: com.oplus.camera.ui.preview.OplusGLSurfaceView_5$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: ak */
        void mo23371ak();

        /* renamed from: al */
        void mo23372al();

        /* renamed from: am */
        boolean mo23373am();
    }

    public FacePointAnimationManager(FaceView faceView) {
        this.f22132h = null;
        this.f22134j = false;
        this.f22137m = null;
        this.f22138n = null;
        this.f22139o = null;
        this.f22140p = null;
        this.f22134j = false;
        this.f22132h = faceView;
        this.f22137m = AnimationUtils.loadInterpolator(this.f22132h.getContext(), R.anim.face_point_scale_interpolator1);
        this.f22138n = AnimationUtils.loadInterpolator(this.f22132h.getContext(), R.anim.face_point_scale_interpolator2);
        this.f22139o = AnimationUtils.loadInterpolator(this.f22132h.getContext(), R.anim.face_point_scale_interpolator3);
        this.f22140p = AnimationUtils.loadInterpolator(this.f22132h.getContext(), R.anim.face_point_translation_interpolator);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23512a(Size size) {
        this.f22127c = size;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23510a(int OplusGLSurfaceView_13) {
        this.f22128d = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23514a(boolean z) {
        this.f22129e = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23511a(Canvas canvas) {
        if (this.f22132h == null || this.f22126b == null || this.f22131g.size() == 0 || this.f22127c == null || !this.f22133i) {
            return;
        }
        Iterator<FaceBean> it = this.f22131g.iterator();
        while (it.hasNext()) {
            for (FacePointBean c3449l : it.next().m23496a()) {
                if (c3449l.m23538f()) {
                    float fM23557q = c3449l.m23557q();
                    float fM23558r = c3449l.m23558r();
                    canvas.drawCircle(fM23557q, fM23558r, c3449l.m23553n(), c3449l.m23561u());
                    canvas.drawCircle(fM23557q, fM23558r, c3449l.m23551m(), c3449l.m23560t());
                    canvas.drawCircle(fM23557q, fM23558r, c3449l.m23549l(), c3449l.m23559s());
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23515a(int[] iArr) {
        FaceView faceView;
        this.f22126b = iArr;
        if (iArr == null || (faceView = this.f22132h) == null || faceView.getWidth() <= 0) {
            return;
        }
        IntrinsicsJvm.kt_4 bVar = this.f22136l;
        if (bVar != null && !bVar.mo23373am()) {
            m23518c();
            return;
        }
        if (this.f22133i) {
            try {
                m23508f();
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                m23518c();
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m23508f() {
        int OplusGLSurfaceView_13;
        char c2;
        int i2;
        int i3;
        int i4;
        int iCenterX;
        int iCenterY;
        int i5;
        int[] iArr = this.f22126b;
        if (iArr == null) {
            return;
        }
        int i6 = iArr[3];
        char c3 = 1;
        int i7 = iArr[1];
        if (i7 == 0) {
            return;
        }
        int i8 = 0;
        if (i7 < this.f22131g.size()) {
            this.f22131g = this.f22131g.subList(0, i7);
        }
        int i9 = 0;
        int i10 = 0;
        while (i10 < i7) {
            int i11 = i10 == 0 ? 12 : i9 + i6;
            int i12 = i11 + i6;
            int[] iArrCopyOfRange = Arrays.copyOfRange(this.f22126b, i11, i12);
            int i13 = i12 + i6;
            int[] iArrCopyOfRange2 = Arrays.copyOfRange(this.f22126b, i12, i13);
            RectF rectFM23498a = m23498a(iArrCopyOfRange[i8], iArrCopyOfRange2[i8], iArrCopyOfRange[32], iArrCopyOfRange2[32]);
            if (this.f22131g.size() == 0 || i10 >= this.f22131g.size()) {
                float[] fArrM23503a = m23503a(iArrCopyOfRange[45], iArrCopyOfRange2[45]);
                float COUIBaseListPopupWindow_12 = fArrM23503a[i8];
                float f2 = fArrM23503a[c3];
                ArrayList arrayList = new ArrayList();
                int i14 = i8;
                while (i14 < f22125a.length) {
                    int iNextInt = this.f22135k.nextInt(2);
                    int i15 = i8;
                    while (true) {
                        int[][] iArr2 = f22125a;
                        if (i15 < iArr2[i14].length) {
                            int i16 = iArr2[i14][i15];
                            if (i16 < 0) {
                                int i17 = iArr2[i14][i15 + 1];
                                i5 = i15 + 2;
                                int i18 = iArr2[i14][i5];
                                float f3 = iArrCopyOfRange[i17];
                                i3 = i15;
                                float f4 = iArrCopyOfRange2[i17];
                                i4 = iNextInt;
                                RectF rectF = new RectF(f3, f4, iArrCopyOfRange[i18], iArrCopyOfRange2[i18]);
                                iCenterX = (int) rectF.centerX();
                                iCenterY = (int) rectF.centerY();
                            } else {
                                i3 = i15;
                                i4 = iNextInt;
                                iCenterX = iArrCopyOfRange[i16];
                                iCenterY = iArrCopyOfRange2[i16];
                                i5 = i3;
                            }
                            int i19 = i3;
                            int i20 = i6;
                            int i21 = i4;
                            int i22 = i7;
                            int i23 = i14;
                            int[] iArr3 = iArrCopyOfRange;
                            ArrayList arrayList2 = arrayList;
                            FacePointBean c3449lM23499a = m23499a(iCenterX, iCenterY, COUIBaseListPopupWindow_12, f2, rectFM23498a);
                            c3449lM23499a.m23522a(i16);
                            c3449lM23499a.m23527b(i21);
                            c3449lM23499a.m23531c(i23);
                            c3449lM23499a.m23534d(i19);
                            if (i21 == 0) {
                                c3449lM23499a.m23559s().setAlpha(153);
                            } else {
                                c3449lM23499a.m23559s().setAlpha(229);
                            }
                            arrayList2.add(c3449lM23499a);
                            i15 = i5 + 1;
                            c3 = 1;
                            iNextInt = i21;
                            i14 = i23;
                            arrayList = arrayList2;
                            i7 = i22;
                            i6 = i20;
                            iArrCopyOfRange = iArr3;
                        }
                    }
                    i14++;
                    i7 = i7;
                    iArrCopyOfRange = iArrCopyOfRange;
                    i8 = 0;
                }
                OplusGLSurfaceView_13 = i6;
                c2 = c3;
                i2 = i7;
                this.f22131g.add(new FaceBean(arrayList));
            } else {
                m23501a(iArrCopyOfRange, iArrCopyOfRange2, this.f22131g.get(i10), rectFM23498a);
                OplusGLSurfaceView_13 = i6;
                c2 = c3;
                i2 = i7;
            }
            i10++;
            c3 = c2;
            i9 = i13;
            i7 = i2;
            i6 = OplusGLSurfaceView_13;
            i8 = 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23501a(int[] iArr, int[] iArr2, FaceBean c3447j, RectF rectF) {
        int iCenterY;
        int iCenterX;
        List<FacePointBean> listM23496a = c3447j.m23496a();
        int size = listM23496a.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            FacePointBean c3449l = listM23496a.get(OplusGLSurfaceView_13);
            int iM23525b = c3449l.m23525b();
            float fM23532d = c3449l.m23532d();
            float fM23535e = c3449l.m23535e();
            if (iM23525b < 0) {
                int i2 = f22125a[c3449l.m23541h()][c3449l.m23562v() + 1];
                int i3 = f22125a[c3449l.m23541h()][c3449l.m23562v() + 2];
                RectF rectF2 = new RectF(iArr[i2], iArr2[i2], iArr[i3], iArr2[i3]);
                iCenterX = (int) rectF2.centerX();
                iCenterY = (int) rectF2.centerY();
            } else {
                int i4 = iArr[iM23525b];
                iCenterY = iArr2[iM23525b];
                iCenterX = i4;
            }
            float[] fArrM23503a = m23503a(iCenterX, iCenterY);
            double dM23535e = (c3449l.m23535e() - fArrM23503a[1]) / Math.sin(Math.atan2(c3449l.m23535e() - fArrM23503a[1], c3449l.m23532d() - fArrM23503a[0]));
            if (30.0d < dM23535e) {
                c3449l.m23521a(rectF.width() * 0.2f * 0.5f);
                c3449l.m23526b(fArrM23503a[0]);
                c3449l.m23530c(fArrM23503a[1]);
            }
            if (30.0d < dM23535e && !c3449l.m23524a()) {
                c3449l.m23546j(fM23532d);
                c3449l.m23548k(fM23535e);
                m23497a(c3449l, 100, new LinearInterpolator(), 0).start();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private FacePointBean m23499a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, float f2, RectF rectF) {
        FacePointBean c3449l = new FacePointBean();
        float[] fArrM23503a = m23503a(OplusGLSurfaceView_13, i2);
        c3449l.m23521a(rectF.width() * 0.2f * 0.5f);
        c3449l.m23526b(fArrM23503a[0]);
        c3449l.m23530c(fArrM23503a[1]);
        double dAtan2 = Math.atan2(f2 - c3449l.m23535e(), COUIBaseListPopupWindow_12 - c3449l.m23532d());
        double dM23535e = ((f2 - c3449l.m23535e()) / Math.sin(dAtan2)) + 200.0d;
        c3449l.m23546j((float) (COUIBaseListPopupWindow_12 - (Math.cos(dAtan2) * dM23535e)));
        c3449l.m23548k((float) (f2 - (dM23535e * Math.sin(dAtan2))));
        c3449l.m23550l(0.0f);
        c3449l.m23552m(0.0f);
        c3449l.m23559s().setColor(-1);
        c3449l.m23559s().setAntiAlias(true);
        c3449l.m23559s().setStyle(Paint.Style.FILL);
        c3449l.m23560t().set(c3449l.m23559s());
        c3449l.m23560t().setAlpha(0);
        c3449l.m23561u().set(c3449l.m23559s());
        c3449l.m23561u().setAlpha(0);
        return c3449l;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float[] m23503a(int OplusGLSurfaceView_13, int i2) {
        int width = this.f22132h.getWidth();
        int height = this.f22132h.getHeight();
        this.f22130f.reset();
        this.f22130f.setTranslate((-this.f22127c.getWidth()) / 2, (-this.f22127c.getHeight()) / 2);
        this.f22130f.postScale(this.f22129e ? -1.0f : 1.0f, 1.0f);
        this.f22130f.postRotate(this.f22128d);
        this.f22130f.postScale((width * 1.0f) / this.f22127c.getHeight(), (height * 1.0f) / this.f22127c.getWidth());
        this.f22130f.postTranslate(width / 2, height / 2);
        float[] fArr = {OplusGLSurfaceView_13, i2};
        this.f22130f.mapPoints(fArr);
        return fArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private RectF m23498a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int width = this.f22132h.getWidth();
        int height = this.f22132h.getHeight();
        this.f22130f.reset();
        this.f22130f.setTranslate((-this.f22127c.getWidth()) / 2, (-this.f22127c.getHeight()) / 2);
        this.f22130f.postScale(this.f22129e ? -1.0f : 1.0f, 1.0f);
        this.f22130f.postRotate(this.f22128d);
        this.f22130f.postScale((width * 1.0f) / this.f22127c.getHeight(), (height * 1.0f) / this.f22127c.getWidth());
        this.f22130f.postTranslate(width / 2, height / 2);
        RectF rectF = new RectF(OplusGLSurfaceView_13, i2, i3, i4);
        this.f22130f.mapRect(rectF);
        return rectF;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23509a() {
        FaceView faceView = this.f22132h;
        if (faceView == null || this.f22133i) {
            return;
        }
        int[] iArr = this.f22126b;
        if (iArr != null && iArr.length != 0 && faceView.getWidth() > 0) {
            if (this.f22126b[1] != 0) {
                this.f22131g.clear();
                int OplusGLSurfaceView_13 = this.f22126b[1];
                try {
                    m23508f();
                    Iterator<FaceBean> it = this.f22131g.iterator();
                    while (it.hasNext()) {
                        for (FacePointBean c3449l : it.next().m23496a()) {
                            if (!c3449l.m23538f()) {
                                m23500a(c3449l);
                            }
                        }
                    }
                    this.f22133i = OplusGLSurfaceView_13 > 0;
                    IntrinsicsJvm.kt_4 bVar = this.f22136l;
                    if (bVar == null || !this.f22133i) {
                        return;
                    }
                    bVar.mo23371ak();
                    return;
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    m23518c();
                    return;
                }
            }
        }
        this.f22141q.removeMessages(2);
        this.f22141q.sendEmptyMessageDelayed(2, 50L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23500a(FacePointBean c3449l) {
        if (this.f22134j) {
            return;
        }
        int iM23541h = c3449l.m23541h() * 50;
        c3449l.m23523a(true);
        ValueAnimator valueAnimatorM23497a = m23497a(c3449l, 250, this.f22140p, iM23541h);
        IntrinsicsJvm.kt_3 cVar = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.SCALE, 0, iM23541h, 400, this.f22137m, 0.0f, 0.45f);
        IntrinsicsJvm.kt_3 cVar2 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.SCALE, 0, 0, 767, this.f22138n, 0.45f, 0.35f);
        IntrinsicsJvm.kt_3 cVar3 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.SCALE, 0, 0, 600, this.f22139o, 0.35f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(cVar, cVar2, cVar3);
        float COUIBaseListPopupWindow_12 = c3449l.m23539g() == 0 ? 0.32f : 0.48f;
        IntrinsicsJvm.kt_3 cVar4 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.SCALE, 1, iM23541h, 400, this.f22138n, 0.2f, COUIBaseListPopupWindow_12);
        IntrinsicsJvm.kt_3 cVar5 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.SCALE, 1, 0, 367, this.f22138n, COUIBaseListPopupWindow_12, 0.2f);
        IntrinsicsJvm.kt_3 cVar6 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.SCALE, 1, 0, 400, this.f22138n, 0.2f, COUIBaseListPopupWindow_12);
        IntrinsicsJvm.kt_3 cVar7 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.SCALE, 1, 0, 367, this.f22138n, COUIBaseListPopupWindow_12, 0.2f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(cVar4, cVar5, cVar6, cVar7);
        float f2 = c3449l.m23539g() == 0 ? 0.61f : 0.77f;
        int OplusGLSurfaceView_13 = iM23541h + 767;
        IntrinsicsJvm.kt_3 cVar8 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.SCALE, 2, OplusGLSurfaceView_13, 400, this.f22138n, 0.16f, f2);
        IntrinsicsJvm.kt_3 cVar9 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.SCALE, 2, 0, 367, this.f22138n, f2, 0.16f);
        IntrinsicsJvm.kt_3 cVar10 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.ALPHA, 2, OplusGLSurfaceView_13, 400, this.f22138n, 0.0f, 0.1f);
        IntrinsicsJvm.kt_3 cVar11 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.ALPHA, 2, 0, 367, this.f22138n, 0.1f, 0.0f);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(cVar8, cVar9);
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.playSequentially(cVar10, cVar11);
        float f3 = c3449l.m23539g() == 0 ? 0.84f : 1.0f;
        IntrinsicsJvm.kt_3 cVar12 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.SCALE, 3, OplusGLSurfaceView_13, 400, this.f22138n, 0.16f, f3);
        IntrinsicsJvm.kt_3 cVar13 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.SCALE, 3, 0, 367, this.f22138n, f3, 0.16f);
        IntrinsicsJvm.kt_3 cVar14 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.ALPHA, 3, OplusGLSurfaceView_13, 400, this.f22138n, 0.0f, 0.1f);
        IntrinsicsJvm.kt_3 cVar15 = new IntrinsicsJvm.kt_3(c3449l, PlatformImplementations.kt_3.ALPHA, 3, 0, 367, this.f22138n, 0.1f, 0.0f);
        AnimatorSet animatorSet5 = new AnimatorSet();
        animatorSet5.playSequentially(cVar12, cVar13);
        AnimatorSet animatorSet6 = new AnimatorSet();
        animatorSet6.playSequentially(cVar14, cVar15);
        animatorSet.playTogether(valueAnimatorM23497a, animatorSet2, animatorSet3, animatorSet4, animatorSet5, animatorSet6);
        animatorSet.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ValueAnimator m23497a(final FacePointBean c3449l, int OplusGLSurfaceView_13, Interpolator interpolator, int i2) {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new PointFEvaluator() { // from class: com.oplus.camera.ui.preview.OplusGLSurfaceView_5.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.animation.TypeEvaluator
            public PointF evaluate(float COUIBaseListPopupWindow_12, PointF pointF, PointF pointF2) {
                pointF.set(c3449l.m23555o(), c3449l.m23556p());
                pointF2.set(c3449l.m23532d(), c3449l.m23535e());
                return new PointF(pointF.x + ((pointF2.x - pointF.x) * COUIBaseListPopupWindow_12), pointF.y + (COUIBaseListPopupWindow_12 * (pointF2.y - pointF.y)));
            }
        }, new PointF(), new PointF());
        valueAnimatorOfObject.setDuration(OplusGLSurfaceView_13);
        valueAnimatorOfObject.setStartDelay(i2);
        valueAnimatorOfObject.setInterpolator(interpolator);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.OplusGLSurfaceView_5.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (FacePointAnimationManager.this.f22134j) {
                    valueAnimator.cancel();
                    return;
                }
                PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                c3449l.m23550l(pointF.x);
                c3449l.m23552m(pointF.y);
                if (1.0f <= valueAnimator.getAnimatedFraction()) {
                    c3449l.m23523a(false);
                } else {
                    c3449l.m23523a(true);
                }
                FacePointAnimationManager.this.f22132h.invalidate();
            }
        });
        return valueAnimatorOfObject;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23513a(IntrinsicsJvm.kt_4 bVar) {
        this.f22136l = bVar;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m23517b() {
        return this.f22133i;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23518c() {
        m23516b(true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23516b(boolean z) {
        this.f22126b = null;
        List<FaceBean> list = this.f22131g;
        if (list != null) {
            list.clear();
            this.f22133i = false;
        }
        Handler handler = this.f22141q;
        if (handler == null || !z) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23519d() {
        Handler handler;
        if (this.f22136l != null && (handler = this.f22141q) != null && handler.hasMessages(1)) {
            this.f22136l.mo23372al();
        }
        m23518c();
        this.f22134j = true;
        this.f22132h = null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m23520e() {
        Handler handler;
        int[] iArr = this.f22126b;
        return (iArr != null && iArr.length > 0) || ((handler = this.f22141q) != null && handler.hasMessages(2));
    }

    /* compiled from: FacePointAnimationManager.java */
    /* renamed from: com.oplus.camera.ui.preview.OplusGLSurfaceView_5$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 extends ValueAnimator implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private FacePointBean f22148b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private PlatformImplementations.kt_3 f22149c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f22150d;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        public IntrinsicsJvm.kt_3(FacePointBean c3449l, PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, int i2, int i3, Interpolator interpolator, float... fArr) {
            this.f22148b = null;
            this.f22149c = PlatformImplementations.kt_3.SCALE;
            this.f22150d = 0;
            this.f22148b = c3449l;
            this.f22150d = OplusGLSurfaceView_13;
            setFloatValues(fArr);
            setDuration(i3);
            setStartDelay(i2);
            setInterpolator(interpolator);
            addUpdateListener(this);
            addListener(this);
            this.f22149c = aVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (FacePointAnimationManager.this.f22134j) {
                cancel();
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (PlatformImplementations.kt_3.ALPHA == this.f22149c) {
                int OplusGLSurfaceView_13 = (int) (fFloatValue * 255.0f);
                int i2 = this.f22150d;
                if (1 == i2) {
                    this.f22148b.m23559s().setAlpha(OplusGLSurfaceView_13);
                    return;
                } else if (2 == i2) {
                    this.f22148b.m23560t().setAlpha(OplusGLSurfaceView_13);
                    return;
                } else {
                    if (3 == i2) {
                        this.f22148b.m23561u().setAlpha(OplusGLSurfaceView_13);
                        return;
                    }
                    return;
                }
            }
            if (PlatformImplementations.kt_3.TRANSLATION_X == this.f22149c) {
                this.f22148b.m23550l(fFloatValue);
                return;
            }
            if (PlatformImplementations.kt_3.TRANSLATION_Y == this.f22149c) {
                this.f22148b.m23552m(fFloatValue);
                return;
            }
            int i3 = this.f22150d;
            if (i3 != 0) {
                if (1 == i3) {
                    this.f22148b.m23533d(fFloatValue);
                    return;
                } else if (2 == i3) {
                    this.f22148b.m23536e(fFloatValue);
                    return;
                } else {
                    if (3 == i3) {
                        this.f22148b.m23537f(fFloatValue);
                        return;
                    }
                    return;
                }
            }
            this.f22148b.m23554n(fFloatValue);
            FacePointBean c3449l = this.f22148b;
            c3449l.m23540g(c3449l.m23543i() * this.f22148b.m23529c() * fFloatValue);
            FacePointBean c3449l2 = this.f22148b;
            c3449l2.m23542h(c3449l2.m23545j() * this.f22148b.m23529c() * fFloatValue);
            FacePointBean c3449l3 = this.f22148b;
            c3449l3.m23544i(c3449l3.m23547k() * this.f22148b.m23529c() * fFloatValue);
            FacePointAnimationManager.this.f22132h.invalidate();
            FacePointAnimationManager.this.f22141q.removeMessages(1);
            FacePointAnimationManager.this.f22141q.sendEmptyMessageDelayed(1, 50L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f22150d == 0) {
                this.f22148b.m23528b(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f22150d == 0) {
                this.f22148b.m23528b(false);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f22150d == 0) {
                this.f22148b.m23528b(false);
            }
        }
    }
}
