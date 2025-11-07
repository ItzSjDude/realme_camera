package com.oplus.camera.p172ui.menu.p175a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.DimenConstants;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: ArrangeAnim.java */
/* renamed from: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class ArrangeAnim {

    /* renamed from: K */
    private HeadlineBackground f18960K;

    /* renamed from: N */
    private ModePickerView f18963N;

    /* renamed from: O */
    private Paint f18964O;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f18967a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f18969c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f18970d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f18971e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f18972f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f18973g;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f18976j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f18977k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f18978l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f18979m;

    /* renamed from: r */
    private float f18984r;

    /* renamed from: s */
    private float f18985s;

    /* renamed from: t */
    private float f18986t;

    /* renamed from: u */
    private float f18987u;

    /* renamed from: v */
    private float f18988v;

    /* renamed from: x */
    private float f18990x;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f18968b = 255;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f18974h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f18975i = 0;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f18980n = 0.0f;

    /* renamed from: o */
    private float f18981o = 0.0f;

    /* renamed from: p */
    private float f18982p = 0.0f;

    /* renamed from: q */
    private float f18983q = 0.0f;

    /* renamed from: w */
    private float f18989w = 0.99f;

    /* renamed from: y */
    private float[] f18991y = null;

    /* renamed from: z */
    private float[] f18992z = null;

    /* renamed from: A */
    private float[] f18950A = null;

    /* renamed from: B */
    private float[] f18951B = null;

    /* renamed from: C */
    private ValueAnimator f18952C = null;

    /* renamed from: D */
    private ValueAnimator f18953D = null;

    /* renamed from: E */
    private ValueAnimator f18954E = null;

    /* renamed from: F */
    private PathInterpolator f18955F = null;

    /* renamed from: G */
    private Paint f18956G = null;

    /* renamed from: H */
    private Paint f18957H = null;

    /* renamed from: I */
    private RectF f18958I = null;

    /* renamed from: J */
    private TextPaint f18959J = null;

    /* renamed from: L */
    private Runnable f18961L = null;

    /* renamed from: M */
    private Paint.FontMetrics f18962M = null;

    /* renamed from: P */
    private Animator.AnimatorListener f18965P = null;

    /* renamed from: Q */
    private Animator.AnimatorListener f18966Q = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m20316b(int OplusGLSurfaceView_13) {
        return (20 == OplusGLSurfaceView_13 || 21 == OplusGLSurfaceView_13) ? false : true;
    }

    public ArrangeAnim(HeadlineBackground c3236b, ModePickerView c3239e, Paint paint) throws Resources.NotFoundException {
        this.f18967a = 0;
        this.f18969c = 0;
        this.f18970d = 0;
        this.f18971e = 0;
        this.f18972f = 0;
        this.f18973g = 0;
        this.f18976j = 0.0f;
        this.f18977k = 0.0f;
        this.f18978l = 0.0f;
        this.f18979m = 0.0f;
        this.f18984r = 0.0f;
        this.f18985s = 0.0f;
        this.f18986t = 0.0f;
        this.f18987u = 0.0f;
        this.f18988v = 0.0f;
        this.f18990x = 0.0f;
        this.f18960K = null;
        this.f18963N = null;
        this.f18964O = null;
        Resources resources = Util.m24472l().getResources();
        this.f18979m = resources.getDimension(R.dimen.headline_recycle_view_item_radius);
        this.f18978l = resources.getDimension(R.dimen.headline_recycle_view_item_height);
        this.f18976j = resources.getDimension(R.dimen.headline_recycle_view_text_padding_left_right);
        this.f18969c = resources.getDimensionPixelSize(R.dimen.head_line_background_padding);
        this.f18970d = resources.getDimensionPixelSize(R.dimen.head_line_check_line_width);
        this.f18990x = resources.getDimensionPixelOffset(R.dimen.baseline_vertical_offset);
        this.f18984r = resources.getDimensionPixelOffset(R.dimen.baseline_arrange_vertical_offset);
        this.f18971e = resources.getDimensionPixelOffset(R.dimen.select_line_arrange_vertical_offset);
        this.f18967a = (int) Util.m24456h(R.dimen.headline_item_gap);
        this.f18977k = Util.m24456h(R.dimen.headline_recycle_view_item_padding_left_right);
        this.f18972f = resources.getDimensionPixelSize(R.dimen.head_line_view_margin_top);
        this.f18973g = resources.getDimensionPixelSize(R.dimen.headline_bg_fold_offset);
        this.f18985s = resources.getDimension(R.dimen.headline_vertical_anim_more_offset);
        this.f18986t = resources.getDimension(R.dimen.headline_vertical_anim_first_item_offset);
        this.f18987u = resources.getDimension(R.dimen.headline_vertical_anim_second_item_offset);
        this.f18988v = resources.getDimensionPixelOffset(R.dimen.vertical_headline_double_line_text_height);
        this.f18960K = c3236b;
        this.f18963N = c3239e;
        this.f18964O = paint;
        m20317f();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m20309a(String str) {
        return this.f18964O.measureText(str);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m20317f() throws Resources.NotFoundException {
        if (this.f18956G == null) {
            this.f18956G = new Paint();
            this.f18956G.setAntiAlias(true);
            this.f18956G.setColor(Util.m24472l().getResources().getColor(R.color.color_white_with_10_percent_transparency, null));
        }
        if (this.f18955F == null) {
            this.f18955F = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        }
        this.f18959J = new TextPaint();
        this.f18959J.setAntiAlias(true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20324a(int OplusGLSurfaceView_13, final String[] strArr, float[] fArr) {
        final int length = strArr.length;
        final long OplusGLSurfaceView_15 = 500 + (length * 32);
        this.f18991y = new float[length];
        this.f18992z = new float[length];
        this.f18950A = new float[length];
        this.f18951B = new float[length];
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        int i2 = length - 2;
        int iM20309a = (int) (((this.f18976j + COUIBaseListPopupWindow_12) + (m20309a(strArr[i2]) / 2.0f)) - (m20318g() / 2));
        if (4 == this.f18975i) {
            iM20309a = (int) (((COUIBaseListPopupWindow_12 + this.f18976j) + (m20309a(strArr[i2]) / 2.0f)) - (Util.getScreenHeight() / 2));
        }
        int i3 = length - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            float[] fArr2 = this.f18992z;
            fArr2[i4] = fArr[i4];
            this.f18991y[i4] = fArr2[i4];
            this.f18951B[i4] = 0.0f;
            if (i4 == i3) {
                this.f18950A[i4] = iM20309a + fArr2[i4] + this.f18967a + m20309a(strArr[i4]) + ((this.f18976j + this.f18977k) / 2.0f);
            } else if (i4 == i2) {
                this.f18950A[i4] = iM20309a + fArr2[i4 + 1];
            } else {
                float[] fArr3 = this.f18950A;
                int i5 = i4 + 1;
                fArr3[i4] = (fArr3[i5] - ((this.f18976j + this.f18977k) * 2.0f)) - ((m20309a(strArr[i4]) + m20309a(strArr[i5])) / 2.0f);
            }
        }
        this.f18952C = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f18952C.setInterpolator(new LinearInterpolator());
        this.f18952C.setDuration(OplusGLSurfaceView_15);
        this.f18952C.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.-$$Lambda$PlatformImplementations.kt_3$lYvp54_FAVCID9OeHdochKKzlPg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m20314b(strArr, OplusGLSurfaceView_15, length, valueAnimator);
            }
        });
        this.f18952C.addListener(this.f18965P);
        this.f18952C.start();
        m20310a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m20314b(String[] strArr, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, ValueAnimator valueAnimator) {
        Float COUIBaseListPopupWindow_12 = (Float) valueAnimator.getAnimatedValue();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            float fFloatValue = ((COUIBaseListPopupWindow_12.floatValue() * OplusGLSurfaceView_15) - (i2 * 32)) / 500.0f;
            if (fFloatValue >= 0.0f && fFloatValue <= 1.0f) {
                this.f18951B[i2] = fFloatValue;
                int i3 = (OplusGLSurfaceView_13 - 1) - i2;
                float[] fArr = this.f18991y;
                float interpolation = this.f18955F.getInterpolation(fFloatValue);
                float f2 = this.f18950A[i3];
                float[] fArr2 = this.f18992z;
                fArr[i3] = (interpolation * (f2 - fArr2[i3])) + fArr2[i3];
            }
        }
        this.f18963N.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b3 A[LOOP:1: B:19:0x00b1->B:20:0x00b3, LOOP_END] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m20329a(int[] r18, final java.lang.String[] r19, float[] r20, int r21) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.p175a.ArrangeAnim.m20329a(int[], java.lang.String[], float[], int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m20312a(String[] strArr, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, ValueAnimator valueAnimator) {
        Float COUIBaseListPopupWindow_12 = (Float) valueAnimator.getAnimatedValue();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            float fFloatValue = ((COUIBaseListPopupWindow_12.floatValue() * OplusGLSurfaceView_15) - (i2 * 32)) / 500.0f;
            if (fFloatValue >= 0.0f && fFloatValue <= 1.0f) {
                this.f18951B[i2] = fFloatValue;
                int i3 = (OplusGLSurfaceView_13 - 1) - i2;
                float[] fArr = this.f18991y;
                float interpolation = this.f18955F.getInterpolation(fFloatValue);
                float f2 = this.f18950A[i3];
                float[] fArr2 = this.f18992z;
                fArr[i3] = (interpolation * (f2 - fArr2[i3])) + fArr2[i3];
            }
        }
        this.f18963N.invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20327a(int[] iArr, final String[] strArr, float COUIBaseListPopupWindow_12) {
        int length = strArr.length;
        long OplusGLSurfaceView_15 = (length * 32) + 500;
        int[] iArr2 = new int[length];
        this.f18992z = new float[length];
        this.f18950A = new float[length];
        this.f18991y = new float[length];
        this.f18951B = new float[length];
        iArr2[iArr[0]] = (int) (iArr[1] + this.f18976j + (m20309a(strArr[iArr[0]]) / 2.0f));
        for (int OplusGLSurfaceView_13 = iArr[0] - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            iArr2[OplusGLSurfaceView_13] = (int) ((iArr2[r7] - ((this.f18977k + this.f18976j) * 2.0f)) - ((m20309a(strArr[OplusGLSurfaceView_13]) + m20309a(strArr[OplusGLSurfaceView_13 + 1])) / 2.0f));
        }
        for (int i2 = iArr[0] + 1; i2 < length; i2++) {
            iArr2[i2] = (int) (iArr2[r5] + ((this.f18977k + this.f18976j) * 2.0f) + ((m20309a(strArr[i2]) + m20309a(strArr[i2 - 1])) / 2.0f));
        }
        for (int i3 = 0; i3 < length; i3++) {
            this.f18951B[i3] = 255.0f;
            this.f18992z[i3] = (iArr2[i3] - (m20318g() / 2.0f)) + COUIBaseListPopupWindow_12;
            int i4 = length - 1;
            int i5 = i4 - i3;
            Context contextM24472l = Util.m24472l();
            float dimensionPixelSize = contextM24472l.getResources().getDimensionPixelSize(R.dimen.headline_arrange_text_right_offset);
            float dimensionPixelSize2 = contextM24472l.getResources().getDimensionPixelSize(R.dimen.headline_arrange_text_left_offset);
            if (i5 == i4) {
                this.f18950A[i5] = COUIBaseListPopupWindow_12;
            } else if (i5 == length - 2) {
                float[] fArr = this.f18950A;
                int i6 = i5 + 1;
                fArr[i5] = ((fArr[i6] - this.f18967a) - ((m20309a(strArr[i6]) + m20309a(strArr[i5])) / 2.0f)) - dimensionPixelSize2;
            } else {
                float[] fArr2 = this.f18950A;
                int i7 = i5 + 1;
                fArr2[i5] = ((fArr2[i7] - this.f18967a) - ((m20309a(strArr[i7]) + m20309a(strArr[i5])) / 2.0f)) + dimensionPixelSize;
            }
        }
        this.f18953D = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f18953D.setInterpolator(this.f18955F);
        this.f18953D.setDuration(OplusGLSurfaceView_15);
        this.f18953D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.-$$Lambda$PlatformImplementations.kt_3$iM5miySNsRqqxHlBsLaMHu0mppg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m20315b(strArr, valueAnimator);
            }
        });
        this.f18953D.addListener(this.f18966Q);
        this.f18953D.start();
        m20310a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m20315b(String[] strArr, ValueAnimator valueAnimator) {
        Float COUIBaseListPopupWindow_12 = (Float) valueAnimator.getAnimatedValue();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArr.length; OplusGLSurfaceView_13++) {
            this.f18951B[OplusGLSurfaceView_13] = 1.0f - COUIBaseListPopupWindow_12.floatValue();
            float[] fArr = this.f18991y;
            float fFloatValue = COUIBaseListPopupWindow_12.floatValue();
            float f2 = this.f18950A[OplusGLSurfaceView_13];
            float[] fArr2 = this.f18992z;
            fArr[OplusGLSurfaceView_13] = (fFloatValue * (f2 - fArr2[OplusGLSurfaceView_13])) + fArr2[OplusGLSurfaceView_13];
        }
        this.f18963N.invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20328a(int[] iArr, final String[] strArr, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        char c2;
        int i2;
        int i3;
        int[] iArr2 = iArr;
        int length = strArr.length;
        long OplusGLSurfaceView_15 = (length * 32) + 500;
        this.f18992z = new float[length];
        this.f18950A = new float[length];
        this.f18991y = new float[length];
        this.f18951B = new float[length];
        Paint.FontMetrics fontMetrics = this.f18964O.getFontMetrics();
        float f2 = fontMetrics.bottom - fontMetrics.top;
        float f3 = (this.f18978l - f2) / 2.0f;
        int[] iArr3 = new int[2];
        this.f18963N.getLocationOnScreen(iArr3);
        int length2 = iArr2.length;
        this.f18974h = length2;
        if (90 == OplusGLSurfaceView_13) {
            i2 = -1;
            c2 = 0;
        } else {
            c2 = 270 == OplusGLSurfaceView_13 ? (char) 0 : (char) 1;
            i2 = 1;
        }
        int i4 = iArr3[c2];
        int i5 = length - 1;
        this.f18950A[i5] = (COUIBaseListPopupWindow_12 - fontMetrics.descent) + this.f18986t;
        int i6 = length2 < i5 ? i5 - length2 : 0;
        int i7 = length - 2;
        if (this.f18963N.m20444a(strArr[i7])) {
            float[] fArr = this.f18950A;
            fArr[i7] = ((fArr[i5] - f2) - this.f18963N.getTextGap()) - (this.f18987u / 2.0f);
        } else {
            float[] fArr2 = this.f18950A;
            fArr2[i7] = ((fArr2[i5] - f2) - this.f18963N.getTextGap()) - this.f18987u;
        }
        int i8 = 0;
        while (i8 < i5) {
            this.f18951B[i8] = 255.0f;
            if (i8 >= i6) {
                this.f18992z[i8] = ((((iArr2[i8 - i6] - i4) * i2) - this.f18963N.getVerticalOffset()) - f3) - fontMetrics.descent;
            }
            int i9 = i5 - i8;
            boolean z = i9 < i5 && this.f18963N.m20444a(strArr[i9 + 1]);
            if (i9 >= i7) {
                i3 = i4;
            } else if (z) {
                float[] fArr3 = this.f18950A;
                i3 = i4;
                fArr3[i9] = ((fArr3[i9 + 1] - this.f18988v) - this.f18963N.getTextGap()) + this.f18986t;
            } else {
                i3 = i4;
                float[] fArr4 = this.f18950A;
                fArr4[i9] = (fArr4[i9 + 1] - f2) - this.f18963N.getTextGap();
            }
            i8++;
            iArr2 = iArr;
            i4 = i3;
        }
        float[] fArr5 = this.f18992z;
        fArr5[i5] = fArr5[i7] + this.f18985s + f2 + this.f18963N.getTextGap();
        this.f18953D = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f18953D.setInterpolator(this.f18955F);
        this.f18953D.setDuration(OplusGLSurfaceView_15);
        this.f18953D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.-$$Lambda$PlatformImplementations.kt_3$o4MIPm6F4gpDj7FzwpzOCJkux8E
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m20313a(strArr, valueAnimator);
            }
        });
        this.f18953D.addListener(this.f18966Q);
        this.f18953D.start();
        m20310a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m20313a(String[] strArr, ValueAnimator valueAnimator) {
        Float COUIBaseListPopupWindow_12 = (Float) valueAnimator.getAnimatedValue();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArr.length; OplusGLSurfaceView_13++) {
            this.f18951B[OplusGLSurfaceView_13] = 1.0f - COUIBaseListPopupWindow_12.floatValue();
            float[] fArr = this.f18991y;
            float fFloatValue = COUIBaseListPopupWindow_12.floatValue();
            float f2 = this.f18950A[OplusGLSurfaceView_13];
            float[] fArr2 = this.f18992z;
            fArr[OplusGLSurfaceView_13] = (fFloatValue * (f2 - fArr2[OplusGLSurfaceView_13])) + fArr2[OplusGLSurfaceView_13];
        }
        this.f18963N.invalidate();
        if (COUIBaseListPopupWindow_12.floatValue() > this.f18989w) {
            this.f18960K.setVisibility(8);
            this.f18963N.m20460h();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20310a(final boolean z) {
        this.f18954E = ValueAnimator.ofInt(0, 255);
        this.f18954E.setDuration(320L);
        this.f18954E.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        this.f18954E.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.-$$Lambda$PlatformImplementations.kt_3$qZuUuNlIPT7gkDdz0FZ04Axqazw
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m20311a(z, valueAnimator);
            }
        });
        this.f18954E.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m20311a(boolean z, ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        CameraLog.m12967f("ArrangeAnim", "editeAndMoreAnimation, value:" + iIntValue);
        if (!z) {
            iIntValue = 255 - iIntValue;
        }
        this.f18968b = iIntValue;
        this.f18963N.setArrangeEditAlpha(this.f18968b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Runnable m20319a() {
        return this.f18961L;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20326a(Runnable runnable) {
        this.f18961L = runnable;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20320a(float COUIBaseListPopupWindow_12, float f2, Paint.FontMetrics fontMetrics, boolean z, int OplusGLSurfaceView_13) {
        this.f18982p = COUIBaseListPopupWindow_12;
        float f3 = this.f18990x;
        this.f18981o = COUIBaseListPopupWindow_12 - f3;
        this.f18983q = f2;
        this.f18980n = f2 - f3;
        this.f18962M = fontMetrics;
        this.f18959J.setTextSize(DimenConstants.m14495m());
        this.f18959J.setTypeface(Util.m24411c(true));
        TextPaint textPaint = this.f18959J;
        if (!z) {
            OplusGLSurfaceView_13 = -1;
        }
        textPaint.setColor(OplusGLSurfaceView_13);
        this.f18959J.setTextAlign(Paint.Align.CENTER);
        this.f18957H = new Paint();
        this.f18957H.setAntiAlias(true);
        this.f18957H.setColor(Util.m24472l().getColor(R.color.camera_white));
        this.f18958I = new RectF();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20325a(Animator.AnimatorListener animatorListener) {
        this.f18965P = animatorListener;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20330b(Animator.AnimatorListener animatorListener) {
        this.f18966Q = animatorListener;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20322a(int OplusGLSurfaceView_13, Canvas canvas, Paint paint, String[] strArr, int i2, float COUIBaseListPopupWindow_12) {
        if (OplusGLSurfaceView_13 == strArr.length - 1) {
            paint.setAlpha(this.f18968b);
            this.f18957H.setAlpha(this.f18968b);
            this.f18958I.left = (this.f18991y[OplusGLSurfaceView_13] - (this.f18960K.getBGWidth() / 2)) + 11.0f;
            this.f18958I.right = (this.f18991y[OplusGLSurfaceView_13] + (this.f18960K.getBGWidth() / 2)) - 11.0f;
            RectF rectF = this.f18958I;
            rectF.top = this.f18972f + this.f18973g;
            rectF.bottom = (this.f18960K.getHeight() - this.f18972f) + this.f18973g;
            float dimensionPixelSize = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.headline_arrange_radius);
            canvas.drawRoundRect(this.f18958I, dimensionPixelSize, dimensionPixelSize, this.f18957H);
            canvas.drawText(strArr[OplusGLSurfaceView_13], this.f18991y[OplusGLSurfaceView_13], this.f18983q, paint);
            return;
        }
        this.f18956G.setAlpha(i2 == 0 ? 0 : (int) (this.f18951B[OplusGLSurfaceView_13] * 0.1f * 255.0f));
        float[] fArr = this.f18991y;
        float f2 = COUIBaseListPopupWindow_12 / 2.0f;
        float f3 = fArr[OplusGLSurfaceView_13] - f2;
        float f4 = this.f18976j;
        float f5 = f3 - f4;
        int i3 = this.f18972f;
        float f6 = i3;
        float f7 = f4 + fArr[OplusGLSurfaceView_13] + f2;
        float f8 = i3 + this.f18978l;
        float f9 = this.f18979m;
        canvas.drawRoundRect(f5, f6, f7, f8, f9, f9, this.f18956G);
        if (i2 == 0) {
            this.f18959J.setAlpha(0);
        } else {
            this.f18959J.setAlpha(m20316b(HeadlineHelper.m20350c(strArr[OplusGLSurfaceView_13])) ? 255 : (int) ((((1.0f - this.f18951B[OplusGLSurfaceView_13]) * 0.9d) + 0.10000000149011612d) * 255.0d));
        }
        canvas.drawText(strArr[OplusGLSurfaceView_13], this.f18991y[OplusGLSurfaceView_13], this.f18982p, this.f18959J);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m20331b() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.f18952C;
        return (valueAnimator2 != null && valueAnimator2.isRunning()) || ((valueAnimator = this.f18953D) != null && valueAnimator.isRunning());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20323a(int OplusGLSurfaceView_13, Canvas canvas, Paint paint, String[] strArr, int i2, float COUIBaseListPopupWindow_12, float f2, int i3, float f3) {
        float fMeasureText;
        if (OplusGLSurfaceView_13 < (strArr.length - 1) - this.f18974h) {
            return;
        }
        float f4 = this.f18978l;
        boolean zM20444a = this.f18963N.m20444a(strArr[OplusGLSurfaceView_13]);
        if (zM20444a) {
            fMeasureText = this.f18959J.measureText(this.f18963N.m20449b(strArr[OplusGLSurfaceView_13])[0]);
            f4 = this.f18988v;
        } else {
            fMeasureText = COUIBaseListPopupWindow_12;
        }
        Paint.FontMetrics fontMetrics = this.f18959J.getFontMetrics();
        float f5 = (f4 - (fontMetrics.bottom - fontMetrics.top)) / 2.0f;
        RectF rectF = this.f18958I;
        float f6 = i3 / 2.0f;
        float f7 = fMeasureText / 2.0f;
        float f8 = this.f18976j;
        int i4 = this.f18973g;
        rectF.left = ((f6 - f7) - f8) + i4;
        rectF.right = ((f6 + f7) + f8) - i4;
        rectF.top = ((((this.f18991y[OplusGLSurfaceView_13] + fontMetrics.ascent) + fontMetrics.leading) - f5) - this.f18973g) - 2.0f;
        RectF rectF2 = this.f18958I;
        rectF2.bottom = rectF2.top + f4;
        if (OplusGLSurfaceView_13 == strArr.length - 1) {
            paint.setAlpha(this.f18968b);
            this.f18957H.setAlpha(this.f18968b);
            float dimensionPixelSize = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.headline_arrange_radius);
            canvas.drawRoundRect(this.f18958I, dimensionPixelSize, dimensionPixelSize, this.f18957H);
            canvas.drawText(strArr[OplusGLSurfaceView_13], f2, this.f18991y[OplusGLSurfaceView_13], paint);
            return;
        }
        this.f18956G.setAlpha(i2 == 0 ? 0 : (int) (this.f18951B[OplusGLSurfaceView_13] * 0.1f * 255.0f));
        RectF rectF3 = this.f18958I;
        float f9 = this.f18979m;
        canvas.drawRoundRect(rectF3, f9, f9, this.f18956G);
        if (i2 == 0) {
            this.f18959J.setAlpha(0);
        } else {
            this.f18959J.setAlpha(m20316b(HeadlineHelper.m20350c(strArr[OplusGLSurfaceView_13])) ? 255 : (int) ((((1.0f - this.f18951B[OplusGLSurfaceView_13]) * 0.9d) + 0.10000000149011612d) * 255.0d));
        }
        if (this.f18991y[OplusGLSurfaceView_13] < (-f3)) {
            this.f18959J.setAlpha((int) (this.f18951B[OplusGLSurfaceView_13] * 255.0f));
        }
        if (zM20444a) {
            String[] strArrM20449b = this.f18963N.m20449b(strArr[OplusGLSurfaceView_13]);
            canvas.drawText(strArrM20449b[0], f2, this.f18991y[OplusGLSurfaceView_13] - (this.f18988v / 2.0f), this.f18959J);
            canvas.drawText(strArrM20449b[1], f2, this.f18991y[OplusGLSurfaceView_13], this.f18959J);
            return;
        }
        canvas.drawText(strArr[OplusGLSurfaceView_13], f2, this.f18991y[OplusGLSurfaceView_13], this.f18959J);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int m20318g() {
        if (3 == this.f18975i) {
            return Util.getScreenWidth() / 2;
        }
        return Util.getScreenWidth();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20321a(int OplusGLSurfaceView_13) {
        this.f18975i = OplusGLSurfaceView_13;
        int i2 = this.f18975i;
        if (i2 == 3 || i2 == 4) {
            this.f18977k = Util.m24456h(R.dimen.fold_headline_recycle_view_item_padding_left_right);
        } else {
            this.f18977k = Util.m24456h(R.dimen.headline_recycle_view_item_padding_left_right);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20332c() {
        ValueAnimator valueAnimator = this.f18953D;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f18953D.end();
        this.f18953D.cancel();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m20333d() {
        ValueAnimator valueAnimator = this.f18952C;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m20334e() {
        if (m20333d()) {
            this.f18952C.end();
            this.f18952C.cancel();
        }
    }
}
