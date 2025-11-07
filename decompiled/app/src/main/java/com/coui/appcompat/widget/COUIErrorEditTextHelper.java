package com.coui.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.EditText;
import com.coui.appcompat.p099a.COUICollectionUtil;
import com.coui.appcompat.widget.COUICutoutDrawable;
import com.coui.appcompat.widget.COUIEditText;
import com.google.android.material.badge.BadgeDrawable;
import coui.support.appcompat.R;
import java.util.ArrayList;

/* compiled from: COUIErrorEditTextHelper.java */
/* renamed from: com.coui.appcompat.widget.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
class COUIErrorEditTextHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Rect f7990a = new Rect();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final EditText f7991b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final COUICutoutDrawable.PlatformImplementations.kt_3 f7992c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ColorStateList f7993d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f7994e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f7995f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f7996g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private COUICutoutDrawable f7997h;

    /* renamed from: OplusGLSurfaceView_13 */
    private ColorStateList f7998i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ColorStateList f7999j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Paint f8000k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Paint f8001l;

    /* renamed from: OplusGLSurfaceView_6 */
    private AnimatorSet f8002m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f8003n;

    /* renamed from: o */
    private ArrayList<COUIEditText.InterfaceC1375c> f8004o;

    /* renamed from: p */
    private boolean f8005p;

    /* renamed from: q */
    private boolean f8006q;

    /* renamed from: r */
    private float f8007r;

    /* renamed from: s */
    private float f8008s;

    /* renamed from: t */
    private float f8009t;

    /* renamed from: u */
    private float f8010u;

    /* renamed from: v */
    private float f8011v;

    COUIErrorEditTextHelper(EditText editText) {
        this.f7991b = editText;
        this.f7992c = new COUICutoutDrawable.PlatformImplementations.kt_3(this.f7991b);
        this.f7992c.m7581a(new LinearInterpolator());
        this.f7992c.m7589b(new LinearInterpolator());
        this.f7992c.m7586b(BadgeDrawable.TOP_START);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7629a(int OplusGLSurfaceView_13, int i2, int i3, float[] fArr, COUICutoutDrawable.PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException {
        this.f7993d = this.f7991b.getTextColors();
        this.f7994e = this.f7991b.getHighlightColor();
        this.f7995f = OplusGLSurfaceView_13;
        this.f7996g = i2;
        if (i3 == 2) {
            this.f7992c.m7580a(Typeface.create("sans-serif-medium", 0));
        }
        this.f7992c.m7573a(aVar.m7598k());
        this.f7992c.m7586b(aVar.m7594g());
        this.f7992c.m7574a(aVar.m7593f());
        this.f7997h = new COUICutoutDrawable();
        this.f7997h.setCornerRadii(fArr);
        this.f8000k = new Paint();
        this.f8000k.setStrokeWidth(this.f7996g);
        this.f8001l = new Paint();
        m7620c();
        this.f7991b.addTextChangedListener(new TextWatcher() { // from class: com.coui.appcompat.widget.COUIBaseListPopupWindow_8.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                if (COUIErrorEditTextHelper.this.f8011v <= 0.0f) {
                    COUIErrorEditTextHelper.this.f8011v = r0.f7991b.getHeight();
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                COUIErrorEditTextHelper.this.m7611a(false, false, false);
                Editable text = COUIErrorEditTextHelper.this.f7991b.getText();
                int length = text.length();
                COUIErrorEditTextHelper c1451e = COUIErrorEditTextHelper.this;
                c1451e.f8010u = c1451e.f7991b.getPaint().measureText(text, 0, length);
            }
        });
        m7639b(aVar);
        m7635a(aVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7634a(Canvas canvas, COUICutoutDrawable.PlatformImplementations.kt_3 aVar) {
        this.f7992c.m7577a(ColorStateList.valueOf(m7607a(this.f7998i.getDefaultColor(), this.f7995f, this.f8007r)));
        this.f7992c.m7588b(ColorStateList.valueOf(m7607a(this.f7999j.getDefaultColor(), this.f7995f, this.f8007r)));
        this.f7992c.m7585b(aVar.m7595h());
        this.f7992c.m7578a(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7633a(Canvas canvas, GradientDrawable gradientDrawable, int OplusGLSurfaceView_13) {
        this.f7997h.setBounds(gradientDrawable.getBounds());
        if (gradientDrawable instanceof COUICutoutDrawable) {
            this.f7997h.m7549a(((COUICutoutDrawable) gradientDrawable).m7551b());
        }
        this.f7997h.setStroke(this.f7996g, m7607a(OplusGLSurfaceView_13, this.f7995f, this.f8007r));
        this.f7997h.draw(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7632a(Canvas canvas, int OplusGLSurfaceView_13, int i2, int i3, Paint paint, Paint paint2) {
        this.f8000k.setColor(m7607a(paint.getColor(), this.f7995f, this.f8007r));
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        canvas.drawLine(0.0f, COUIBaseListPopupWindow_12, i2, COUIBaseListPopupWindow_12, this.f8000k);
        this.f8000k.setColor(m7607a(paint2.getColor(), this.f7995f, this.f8007r));
        canvas.drawLine(0.0f, COUIBaseListPopupWindow_12, i3, COUIBaseListPopupWindow_12, this.f8000k);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7631a(Canvas canvas) {
        float COUIBaseListPopupWindow_12;
        float f2;
        if (this.f8005p && this.f8003n) {
            int iSave = canvas.save();
            if (!m7627e()) {
                canvas.translate(this.f8008s, 0.0f);
            } else {
                canvas.translate(-this.f8008s, 0.0f);
            }
            int compoundPaddingStart = this.f7991b.getCompoundPaddingStart();
            int compoundPaddingEnd = this.f7991b.getCompoundPaddingEnd();
            int width = this.f7991b.getWidth() - compoundPaddingEnd;
            int OplusGLSurfaceView_13 = width - compoundPaddingStart;
            float x = width + this.f7991b.getX() + this.f7991b.getScrollX();
            float f3 = OplusGLSurfaceView_13;
            float scrollX = (this.f8010u - this.f7991b.getScrollX()) - f3;
            this.f7991b.getLineBounds(0, f7990a);
            int iSave2 = canvas.save();
            if (!m7627e()) {
                canvas.translate(compoundPaddingStart, f7990a.top);
            } else {
                canvas.translate(compoundPaddingEnd, f7990a.top);
            }
            int iSave3 = canvas.save();
            if (this.f7991b.getBottom() - this.f7991b.getTop() == this.f8011v && this.f8010u > f3) {
                if (!m7627e()) {
                    canvas.translate(-scrollX, 0.0f);
                    canvas.clipRect(this.f7991b.getScrollX(), 0.0f, x, this.f8011v);
                } else {
                    canvas.clipRect(this.f7991b.getScrollX() + OplusGLSurfaceView_13, 0.0f, this.f7991b.getScrollX(), this.f8011v);
                }
            }
            Layout layout = this.f7991b.getLayout();
            layout.getPaint().setColor(this.f7993d.getDefaultColor());
            layout.draw(canvas);
            canvas.restoreToCount(iSave3);
            canvas.restoreToCount(iSave2);
            Layout.Alignment alignmentM7613b = m7613b();
            this.f8001l.setColor(m7606a(this.f8009t));
            if ((alignmentM7613b != Layout.Alignment.ALIGN_NORMAL || m7627e()) && (!(alignmentM7613b == Layout.Alignment.ALIGN_OPPOSITE && m7627e()) && (!(alignmentM7613b == Layout.Alignment.ALIGN_NORMAL && m7627e()) && (alignmentM7613b != Layout.Alignment.ALIGN_OPPOSITE || m7627e())))) {
                float f4 = ((compoundPaddingStart + r4) - compoundPaddingEnd) / 2.0f;
                float f5 = this.f8010u;
                float f6 = f4 - (f5 / 2.0f);
                COUIBaseListPopupWindow_12 = f6;
                f2 = f6 + f5;
            } else {
                COUIBaseListPopupWindow_12 = compoundPaddingStart;
                f2 = COUIBaseListPopupWindow_12;
            }
            canvas.drawRect(COUIBaseListPopupWindow_12, f7990a.top, f2, f7990a.bottom, this.f8001l);
            canvas.restoreToCount(iSave);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Layout.Alignment m7613b() {
        switch (this.f7991b.getTextAlignment()) {
            case 1:
                int gravity = this.f7991b.getGravity() & 8388615;
                if (gravity == 1) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (gravity == 3) {
                    return m7627e() ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
                }
                if (gravity == 5) {
                    return m7627e() ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
                }
                if (gravity == 8388611) {
                    return Layout.Alignment.ALIGN_NORMAL;
                }
                if (gravity == 8388613) {
                    return Layout.Alignment.ALIGN_OPPOSITE;
                }
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
                return Layout.Alignment.ALIGN_NORMAL;
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 4:
                return Layout.Alignment.ALIGN_CENTER;
            case 5:
                return Layout.Alignment.ALIGN_NORMAL;
            case 6:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                return Layout.Alignment.ALIGN_NORMAL;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7620c() throws Resources.NotFoundException {
        float dimension = this.f7991b.getResources().getDimension(R.dimen.coui_edit_text_shake_amplitude);
        PathInterpolator pathInterpolator = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(pathInterpolator);
        valueAnimatorOfFloat.setDuration(217L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUIBaseListPopupWindow_8.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUIErrorEditTextHelper.this.f8007r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, dimension);
        valueAnimatorOfFloat2.setInterpolator(new PlatformImplementations.kt_3());
        valueAnimatorOfFloat2.setDuration(PlatformImplementations.kt_3.f8018a);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUIBaseListPopupWindow_8.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (COUIErrorEditTextHelper.this.f8006q) {
                    COUIErrorEditTextHelper.this.f8008s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
                COUIErrorEditTextHelper.this.f7991b.invalidate();
            }
        });
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 0.3f);
        valueAnimatorOfFloat3.setInterpolator(pathInterpolator);
        valueAnimatorOfFloat3.setDuration(133L);
        valueAnimatorOfFloat3.setStartDelay(80L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUIBaseListPopupWindow_8.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (COUIErrorEditTextHelper.this.f8006q) {
                    COUIErrorEditTextHelper.this.f8009t = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        this.f8002m = new AnimatorSet();
        this.f8002m.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2, valueAnimatorOfFloat3);
        this.f8002m.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.widget.COUIBaseListPopupWindow_8.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUIErrorEditTextHelper.this.f7991b.setSelection(COUIErrorEditTextHelper.this.f7991b.length());
                if (COUIErrorEditTextHelper.this.f8011v <= 0.0f) {
                    COUIErrorEditTextHelper.this.f7991b.post(new Runnable() { // from class: com.coui.appcompat.widget.COUIBaseListPopupWindow_8.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            COUIErrorEditTextHelper.this.f8011v = COUIErrorEditTextHelper.this.f7991b.getHeight();
                        }
                    });
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIErrorEditTextHelper.this.m7618b(true, true, true);
                COUIErrorEditTextHelper.this.m7621c(true);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7606a(float COUIBaseListPopupWindow_12) {
        return Color.argb((int) (COUIBaseListPopupWindow_12 * 255.0f), Color.red(this.f7995f), Color.green(this.f7995f), Color.blue(this.f7995f));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7607a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 <= 0.0f) {
            return OplusGLSurfaceView_13;
        }
        if (COUIBaseListPopupWindow_12 >= 1.0f) {
            return i2;
        }
        float f2 = 1.0f - COUIBaseListPopupWindow_12;
        int iAlpha = (int) ((Color.alpha(OplusGLSurfaceView_13) * f2) + (Color.alpha(i2) * COUIBaseListPopupWindow_12));
        int iRed = (int) ((Color.red(OplusGLSurfaceView_13) * f2) + (Color.red(i2) * COUIBaseListPopupWindow_12));
        int iGreen = (int) ((Color.green(OplusGLSurfaceView_13) * f2) + (Color.green(i2) * COUIBaseListPopupWindow_12));
        int iBlue = (int) ((Color.blue(OplusGLSurfaceView_13) * f2) + (Color.blue(i2) * COUIBaseListPopupWindow_12));
        if (iAlpha > 255) {
            iAlpha = 255;
        }
        if (iRed > 255) {
            iRed = 255;
        }
        if (iGreen > 255) {
            iGreen = 255;
        }
        if (iBlue > 255) {
            iBlue = 255;
        }
        return Color.argb(iAlpha, iRed, iGreen, iBlue);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m7638a() {
        return this.f8003n;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7636a(boolean z) {
        m7610a(z, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7610a(boolean z, boolean z2) {
        m7611a(z, z2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m7611a(boolean z, boolean z2, boolean z3) {
        if (this.f8003n == z) {
            return;
        }
        this.f8003n = z;
        m7616b(z);
        if (z2) {
            m7617b(z, z3);
        } else {
            m7622c(z, z3);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7617b(boolean z, boolean z2) {
        if (z) {
            m7625d();
            this.f7991b.setTextColor(0);
            this.f7991b.setHighlightColor(0);
            this.f8007r = 0.0f;
            this.f8008s = 0.0f;
            this.f8009t = 0.0f;
            this.f8005p = true;
            this.f8006q = this.f7991b.isFocused();
            this.f8002m.start();
            return;
        }
        m7625d();
        m7618b(false, false, z2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7622c(boolean z, boolean z2) {
        if (z) {
            this.f8007r = 1.0f;
            this.f8008s = 0.0f;
            this.f8009t = 0.0f;
            m7618b(true, false, z2);
            return;
        }
        m7618b(false, false, z2);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7625d() {
        if (this.f8002m.isStarted()) {
            this.f8002m.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7618b(boolean z, boolean z2, boolean z3) {
        this.f8005p = false;
        if (z) {
            if (z2) {
                this.f7991b.setTextColor(this.f7993d);
            }
            this.f7991b.setHighlightColor(m7606a(0.3f));
            if (z3) {
                EditText editText = this.f7991b;
                editText.setSelection(0, editText.getText().length());
                return;
            }
            return;
        }
        this.f7991b.setTextColor(this.f7993d);
        this.f7991b.setHighlightColor(this.f7994e);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7616b(boolean z) {
        if (this.f8004o != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f8004o.size(); OplusGLSurfaceView_13++) {
                this.f8004o.get(OplusGLSurfaceView_13).m7121a(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m7621c(boolean z) {
        if (this.f8004o != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f8004o.size(); OplusGLSurfaceView_13++) {
                this.f8004o.get(OplusGLSurfaceView_13).m7122b(z);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m7627e() {
        return this.f7991b.getLayoutDirection() == 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7635a(COUICutoutDrawable.PlatformImplementations.kt_3 aVar) {
        this.f7998i = aVar.m7603p();
        this.f7999j = aVar.m7602o();
        this.f7992c.m7577a(this.f7998i);
        this.f7992c.m7588b(this.f7999j);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m7639b(COUICutoutDrawable.PlatformImplementations.kt_3 aVar) {
        this.f7992c.m7582a(aVar.m7601n());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m7640c(COUICutoutDrawable.PlatformImplementations.kt_3 aVar) {
        Rect rectM7572a = aVar.m7572a();
        Rect rectM7584b = aVar.m7584b();
        this.f7992c.m7575a(rectM7572a.left, rectM7572a.top, rectM7572a.right, rectM7572a.bottom);
        this.f7992c.m7587b(rectM7584b.left, rectM7584b.top, rectM7584b.right, rectM7584b.bottom);
        this.f7992c.m7600m();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7637a(int[] iArr) {
        this.f7992c.m7583a(iArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7630a(int OplusGLSurfaceView_13, ColorStateList colorStateList) {
        this.f7992c.m7576a(OplusGLSurfaceView_13, colorStateList);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7628a(int OplusGLSurfaceView_13) {
        this.f7995f = OplusGLSurfaceView_13;
    }

    /* compiled from: COUIErrorEditTextHelper.java */
    /* renamed from: com.coui.appcompat.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 implements Interpolator {

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final Interpolator f8022e;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static final float[] f8019b = {0.0f, -1.0f, 0.5f, -0.5f, 0.0f};

        /* renamed from: IntrinsicsJvm.kt_3 */
        private static final int[] f8020c = {83, 133, 117, 117};

        /* renamed from: PlatformImplementations.kt_3 */
        static final int f8018a = COUICollectionUtil.m6392a(f8020c);

        /* renamed from: IntrinsicsJvm.kt_5 */
        private static final float[] f8021d = new float[f8020c.length + 1];

        static {
            int OplusGLSurfaceView_13 = 0;
            int i2 = 0;
            while (true) {
                int[] iArr = f8020c;
                if (OplusGLSurfaceView_13 >= iArr.length) {
                    return;
                }
                i2 += iArr[OplusGLSurfaceView_13];
                OplusGLSurfaceView_13++;
                f8021d[OplusGLSurfaceView_13] = i2 / f8018a;
            }
        }

        private PlatformImplementations.kt_3() {
            this.f8022e = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float COUIBaseListPopupWindow_12) {
            int OplusGLSurfaceView_13 = 1;
            while (true) {
                float[] fArr = f8021d;
                if (OplusGLSurfaceView_13 >= fArr.length) {
                    return 0.0f;
                }
                if (COUIBaseListPopupWindow_12 <= fArr[OplusGLSurfaceView_13]) {
                    int i2 = OplusGLSurfaceView_13 - 1;
                    float interpolation = this.f8022e.getInterpolation((COUIBaseListPopupWindow_12 - fArr[i2]) / (fArr[OplusGLSurfaceView_13] - fArr[i2]));
                    float[] fArr2 = f8019b;
                    return (fArr2[i2] * (1.0f - interpolation)) + (fArr2[OplusGLSurfaceView_13] * interpolation);
                }
                OplusGLSurfaceView_13++;
            }
        }
    }
}
