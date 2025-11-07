package com.coui.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.customview.p039a.ExploreByTouchHelper;
import com.coui.appcompat.p099a.COUILockPatternUtils;
import coui.support.appcompat.R;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class COUILockPatternView extends View {

    /* renamed from: A */
    private int f7366A;

    /* renamed from: B */
    private int f7367B;

    /* renamed from: C */
    private final Interpolator f7368C;

    /* renamed from: D */
    private PatternExploreByTouchHelper f7369D;

    /* renamed from: E */
    private boolean f7370E;

    /* renamed from: F */
    private Drawable f7371F;

    /* renamed from: G */
    private Drawable f7372G;

    /* renamed from: H */
    private ValueAnimator f7373H;

    /* renamed from: I */
    private boolean f7374I;

    /* renamed from: J */
    private Context f7375J;

    /* renamed from: K */
    private AccessibilityManager f7376K;

    /* renamed from: L */
    private int f7377L;

    /* renamed from: M */
    private Interpolator f7378M;

    /* renamed from: N */
    private Interpolator f7379N;

    /* renamed from: PlatformImplementations.kt_3 */
    private final CellState[][] f7380a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f7381b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float f7382c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Paint f7383d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Paint f7384e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private OnPatternListener f7385f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final ArrayList<Cell> f7386g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final boolean[][] f7387h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f7388i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f7389j;

    /* renamed from: OplusGLSurfaceView_5 */
    private long f7390k;

    /* renamed from: OplusGLSurfaceView_14 */
    private DisplayMode f7391l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f7392m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f7393n;

    /* renamed from: o */
    private boolean f7394o;

    /* renamed from: p */
    private boolean f7395p;

    /* renamed from: q */
    private float f7396q;

    /* renamed from: r */
    private float f7397r;

    /* renamed from: s */
    private float f7398s;

    /* renamed from: t */
    private float f7399t;

    /* renamed from: u */
    private final Path f7400u;

    /* renamed from: v */
    private final Rect f7401v;

    /* renamed from: w */
    private final Rect f7402w;

    /* renamed from: x */
    private int f7403x;

    /* renamed from: y */
    private int f7404y;

    /* renamed from: z */
    private int f7405z;

    public enum DisplayMode {
        Correct,
        Animate,
        Wrong,
        FingerprintMatch,
        FingerprintNoMatch
    }

    interface OnCellDrawListener {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo7194a();
    }

    public interface OnPatternListener {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7200a();

        /* renamed from: PlatformImplementations.kt_3 */
        void m7201a(List<Cell> list);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m7202b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m7203b(List<Cell> list);
    }

    public static final class Cell {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final Cell[][] f7424a = m7197a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f7425b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final int f7426c;

        /* renamed from: PlatformImplementations.kt_3 */
        private static Cell[][] m7197a() {
            Cell[][] cellArr = (Cell[][]) Array.newInstance((Class<?>) Cell.class, 3, 3);
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 3; OplusGLSurfaceView_13++) {
                for (int i2 = 0; i2 < 3; i2++) {
                    cellArr[OplusGLSurfaceView_13][i2] = new Cell(OplusGLSurfaceView_13, i2);
                }
            }
            return cellArr;
        }

        private Cell(int OplusGLSurfaceView_13, int i2) {
            m7199b(OplusGLSurfaceView_13, i2);
            this.f7425b = OplusGLSurfaceView_13;
            this.f7426c = i2;
        }

        public int getRow() {
            return this.f7425b;
        }

        public int getColumn() {
            return this.f7426c;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static Cell m7196a(int OplusGLSurfaceView_13, int i2) {
            m7199b(OplusGLSurfaceView_13, i2);
            return f7424a[OplusGLSurfaceView_13][i2];
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static void m7199b(int OplusGLSurfaceView_13, int i2) {
            if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > 2) {
                throw new IllegalArgumentException("row must be in range 0-2");
            }
            if (i2 < 0 || i2 > 2) {
                throw new IllegalArgumentException("column must be in range 0-2");
            }
        }

        public String toString() {
            return "(row=" + this.f7425b + ",clmn=" + this.f7426c + ")";
        }
    }

    public static class CellState {

        /* renamed from: PlatformImplementations.kt_3 */
        float f7427a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        float f7428b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        float f7429c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        float f7430d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public float f7431e = Float.MIN_VALUE;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public float f7432f = Float.MIN_VALUE;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public ValueAnimator f7433g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        float f7434h;

        /* renamed from: OplusGLSurfaceView_13 */
        float f7435i;

        /* renamed from: OplusGLSurfaceView_15 */
        float f7436j;

        /* renamed from: OplusGLSurfaceView_5 */
        float f7437k;

        /* renamed from: OplusGLSurfaceView_14 */
        boolean f7438l;

        /* renamed from: OplusGLSurfaceView_6 */
        OnCellDrawListener f7439m;

        public void setCellDrawListener(OnCellDrawListener onCellDrawListener) {
            this.f7439m = onCellDrawListener;
        }

        public void setCellNumberAlpha(float COUIBaseListPopupWindow_12) {
            this.f7430d = COUIBaseListPopupWindow_12;
            this.f7439m.mo7194a();
        }

        public void setCellNumberTranslateY(int OplusGLSurfaceView_13) {
            this.f7427a = OplusGLSurfaceView_13;
            this.f7439m.mo7194a();
        }

        public void setCellNumberTranslateX(int OplusGLSurfaceView_13) {
            this.f7428b = OplusGLSurfaceView_13;
            this.f7439m.mo7194a();
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUILockPatternView$1 */
    class C13911 implements OnCellDrawListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUILockPatternView f7406a;

        @Override // com.coui.appcompat.widget.COUILockPatternView.OnCellDrawListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo7194a() {
            this.f7406a.invalidate();
        }
    }

    public CellState[][] getCellStates() {
        return this.f7380a;
    }

    public void setInStealthMode(boolean z) {
        this.f7393n = z;
    }

    public void setTactileFeedbackEnabled(boolean z) {
        this.f7394o = z;
    }

    public void setOnPatternListener(OnPatternListener onPatternListener) {
        this.f7385f = onPatternListener;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7193a(DisplayMode displayMode, List<Cell> list) {
        this.f7386g.clear();
        this.f7386g.addAll(list);
        m7188i();
        for (Cell cell : list) {
            this.f7387h[cell.getRow()][cell.getColumn()] = true;
        }
        setDisplayMode(displayMode);
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.f7391l = displayMode;
        if (displayMode == DisplayMode.Animate) {
            if (this.f7386g.size() == 0) {
                throw new IllegalStateException("you must have PlatformImplementations.kt_3 pattern to animate if you want to set the display mode to animate");
            }
            this.f7390k = SystemClock.elapsedRealtime();
            Cell cell = this.f7386g.get(0);
            this.f7388i = m7163b(cell.getColumn());
            this.f7389j = m7173c(cell.getRow());
            m7188i();
        }
        if (displayMode == DisplayMode.Wrong) {
            if (this.f7386g.size() > 1) {
                m7154a();
            }
            m7168b();
        }
        if (displayMode == DisplayMode.FingerprintNoMatch) {
            m7176c();
        }
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7154a() {
        if (this.f7394o) {
            if (this.f7374I) {
                performHapticFeedback(304, 3);
            } else {
                performHapticFeedback(300, 3);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7168b() {
        this.f7373H = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("pathAlpha", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, 0.35f), Keyframe.ofFloat(0.4f, 1.0f), Keyframe.ofFloat(0.6f, 0.15f), Keyframe.ofFloat(0.8f, 0.5f), Keyframe.ofFloat(1.0f, 0.0f)));
        this.f7373H.setDuration(1000L);
        this.f7373H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUILockPatternView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUILockPatternView.this.f7382c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Iterator it = COUILockPatternView.this.f7386g.iterator();
                while (it.hasNext()) {
                    Cell cell = (Cell) it.next();
                    CellState cellState = COUILockPatternView.this.f7380a[cell.f7425b][cell.f7426c];
                    cellState.f7436j = COUILockPatternView.this.f7382c;
                    cellState.f7438l = COUILockPatternView.this.f7382c <= 0.1f;
                }
                COUILockPatternView.this.invalidate();
            }
        });
        this.f7373H.start();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7176c() {
        ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("pathAlpha", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, 0.35f), Keyframe.ofFloat(0.4f, 1.0f), Keyframe.ofFloat(0.6f, 0.15f), Keyframe.ofFloat(0.8f, 0.5f), Keyframe.ofFloat(1.0f, 0.0f)));
        valueAnimatorOfPropertyValuesHolder.setDuration(1000L);
        valueAnimatorOfPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUILockPatternView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 3; OplusGLSurfaceView_13++) {
                    for (int i2 = 0; i2 < 3; i2++) {
                        CellState cellState = COUILockPatternView.this.f7380a[OplusGLSurfaceView_13][i2];
                        cellState.f7436j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        cellState.f7438l = cellState.f7436j <= 0.1f;
                    }
                }
                COUILockPatternView.this.invalidate();
            }
        });
        valueAnimatorOfPropertyValuesHolder.start();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7177d() {
        OnPatternListener onPatternListener = this.f7385f;
        if (onPatternListener != null) {
            onPatternListener.m7201a(this.f7386g);
        }
        this.f7369D.invalidateRoot();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m7180e() {
        m7155a(R.string.lockscreen_access_pattern_start);
        OnPatternListener onPatternListener = this.f7385f;
        if (onPatternListener != null) {
            onPatternListener.m7200a();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m7181f() {
        m7155a(R.string.lockscreen_access_pattern_detected);
        OnPatternListener onPatternListener = this.f7385f;
        if (onPatternListener != null) {
            onPatternListener.m7203b(this.f7386g);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m7183g() {
        m7155a(R.string.lockscreen_access_pattern_cleared);
        OnPatternListener onPatternListener = this.f7385f;
        if (onPatternListener != null) {
            onPatternListener.m7202b();
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUILockPatternView$4 */
    class C13944 extends AnimatorListenerAdapter {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUILockPatternView f7409a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f7409a.m7186h();
            if (this.f7409a.f7373H != null) {
                this.f7409a.f7373H.removeAllListeners();
            }
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f7369D.dispatchHoverEvent(motionEvent) | super.dispatchHoverEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m7186h() {
        this.f7386g.clear();
        m7188i();
        this.f7391l = DisplayMode.Correct;
        invalidate();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m7188i() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 3; OplusGLSurfaceView_13++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.f7387h[OplusGLSurfaceView_13][i2] = false;
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f7397r = ((OplusGLSurfaceView_13 - getPaddingLeft()) - getPaddingRight()) / 3.0f;
        this.f7398s = ((i2 - getPaddingTop()) - getPaddingBottom()) / 3.0f;
        this.f7369D.invalidateRoot();
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        setMeasuredDimension(this.f7366A, this.f7367B);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Cell m7152a(float COUIBaseListPopupWindow_12, float f2) {
        Cell cellM7167b = m7167b(COUIBaseListPopupWindow_12, f2);
        Cell cellM7196a = null;
        if (cellM7167b == null) {
            return null;
        }
        ArrayList<Cell> arrayList = this.f7386g;
        if (!arrayList.isEmpty()) {
            Cell cell = arrayList.get(arrayList.size() - 1);
            int OplusGLSurfaceView_13 = cellM7167b.f7425b - cell.f7425b;
            int i2 = cellM7167b.f7426c - cell.f7426c;
            int i3 = cell.f7425b;
            int i4 = cell.f7426c;
            if (Math.abs(OplusGLSurfaceView_13) == 2 && Math.abs(i2) != 1) {
                i3 = cell.f7425b + (OplusGLSurfaceView_13 > 0 ? 1 : -1);
            }
            if (Math.abs(i2) == 2 && Math.abs(OplusGLSurfaceView_13) != 1) {
                i4 = cell.f7426c + (i2 <= 0 ? -1 : 1);
            }
            cellM7196a = Cell.m7196a(i3, i4);
        }
        if (cellM7196a != null && !this.f7387h[cellM7196a.f7425b][cellM7196a.f7426c]) {
            m7159a(cellM7196a);
        }
        m7159a(cellM7167b);
        if (this.f7394o) {
            m7190j();
        }
        return cellM7167b;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m7190j() {
        if (this.f7374I) {
            performHapticFeedback(302);
        } else {
            performHapticFeedback(1);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7159a(Cell cell) {
        this.f7387h[cell.getRow()][cell.getColumn()] = true;
        this.f7386g.add(cell);
        if (!this.f7393n) {
            m7170b(cell);
        }
        m7177d();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7170b(Cell cell) {
        CellState cellState = this.f7380a[cell.f7425b][cell.f7426c];
        m7160a(cellState);
        m7171b(cellState);
        m7161a(cellState, this.f7388i, this.f7389j, m7163b(cell.f7426c), m7173c(cell.f7425b));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7161a(final CellState cellState, final float COUIBaseListPopupWindow_12, final float f2, final float f3, final float f4) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUILockPatternView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CellState cellState2 = cellState;
                float f5 = 1.0f - fFloatValue;
                cellState2.f7431e = (COUIBaseListPopupWindow_12 * f5) + (f3 * fFloatValue);
                cellState2.f7432f = (f5 * f2) + (fFloatValue * f4);
                COUILockPatternView.this.invalidate();
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.widget.COUILockPatternView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                cellState.f7433g = null;
            }
        });
        valueAnimatorOfFloat.setInterpolator(this.f7368C);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.start();
        cellState.f7433g = valueAnimatorOfFloat;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7160a(final CellState cellState) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(460L);
        animatorSet.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 7.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUILockPatternView.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                cellState.f7435i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                COUILockPatternView.this.invalidate();
            }
        });
        ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.5f, this.f7399t), Keyframe.ofFloat(1.0f, 0.0f)));
        valueAnimatorOfPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUILockPatternView.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                cellState.f7437k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                COUILockPatternView.this.invalidate();
            }
        });
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfPropertyValuesHolder);
        animatorSet.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7171b(final CellState cellState) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.7f, 0.0f));
        valueAnimatorOfFloat.setDuration(230L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUILockPatternView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                cellState.f7436j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        valueAnimatorOfFloat.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Cell m7167b(float COUIBaseListPopupWindow_12, float f2) {
        int iM7165b;
        int iM7150a = m7150a(f2);
        if (iM7150a >= 0 && (iM7165b = m7165b(COUIBaseListPopupWindow_12)) >= 0 && !this.f7387h[iM7150a][iM7165b]) {
            return Cell.m7196a(iM7150a, iM7165b);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public int m7150a(float COUIBaseListPopupWindow_12) {
        float f2 = this.f7398s;
        float f3 = this.f7396q * f2;
        float paddingTop = getPaddingTop() + ((f2 - f3) / 2.0f);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 3; OplusGLSurfaceView_13++) {
            float f4 = (OplusGLSurfaceView_13 * f2) + paddingTop;
            if (COUIBaseListPopupWindow_12 >= f4 && COUIBaseListPopupWindow_12 <= f4 + f3) {
                return OplusGLSurfaceView_13;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m7165b(float COUIBaseListPopupWindow_12) {
        float f2 = this.f7397r;
        float f3 = this.f7396q * f2;
        float paddingLeft = getPaddingLeft() + ((f2 - f3) / 2.0f);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 3; OplusGLSurfaceView_13++) {
            float f4 = (OplusGLSurfaceView_13 * f2) + paddingLeft;
            if (COUIBaseListPopupWindow_12 >= f4 && COUIBaseListPopupWindow_12 <= f4 + f3) {
                return OplusGLSurfaceView_13;
            }
        }
        return -1;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.f7376K.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7) {
                motionEvent.setAction(2);
            } else if (action == 9) {
                motionEvent.setAction(0);
            } else if (action == 10) {
                motionEvent.setAction(1);
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f7392m || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            ValueAnimator valueAnimator = this.f7373H;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f7373H.end();
            }
            m7169b(motionEvent);
            return true;
        }
        if (action == 1) {
            m7191k();
            return true;
        }
        if (action == 2) {
            m7158a(motionEvent);
            return true;
        }
        if (action != 3) {
            return false;
        }
        if (this.f7395p) {
            setPatternInProgress(false);
            m7186h();
            m7183g();
        }
        return true;
    }

    private void setPatternInProgress(boolean z) {
        this.f7395p = z;
        this.f7369D.invalidateRoot();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7158a(MotionEvent motionEvent) {
        float COUIBaseListPopupWindow_12 = this.f7381b;
        int historySize = motionEvent.getHistorySize();
        this.f7402w.setEmpty();
        int OplusGLSurfaceView_13 = 0;
        boolean z = false;
        while (OplusGLSurfaceView_13 < historySize + 1) {
            float historicalX = OplusGLSurfaceView_13 < historySize ? motionEvent.getHistoricalX(OplusGLSurfaceView_13) : motionEvent.getX();
            float historicalY = OplusGLSurfaceView_13 < historySize ? motionEvent.getHistoricalY(OplusGLSurfaceView_13) : motionEvent.getY();
            Cell cellM7152a = m7152a(historicalX, historicalY);
            int size = this.f7386g.size();
            if (cellM7152a != null && size == 1) {
                setPatternInProgress(true);
                m7180e();
            }
            float fAbs = Math.abs(historicalX - this.f7388i);
            float fAbs2 = Math.abs(historicalY - this.f7389j);
            if (fAbs > 0.0f || fAbs2 > 0.0f) {
                z = true;
            }
            if (this.f7395p && size > 0) {
                Cell cell = this.f7386g.get(size - 1);
                float fM7163b = m7163b(cell.f7426c);
                float fM7173c = m7173c(cell.f7425b);
                float fMin = Math.min(fM7163b, historicalX) - COUIBaseListPopupWindow_12;
                float fMax = Math.max(fM7163b, historicalX) + COUIBaseListPopupWindow_12;
                float fMin2 = Math.min(fM7173c, historicalY) - COUIBaseListPopupWindow_12;
                float fMax2 = Math.max(fM7173c, historicalY) + COUIBaseListPopupWindow_12;
                if (cellM7152a != null) {
                    float f2 = this.f7397r * 0.5f;
                    float f3 = this.f7398s * 0.5f;
                    float fM7163b2 = m7163b(cellM7152a.f7426c);
                    float fM7173c2 = m7173c(cellM7152a.f7425b);
                    fMin = Math.min(fM7163b2 - f2, fMin);
                    fMax = Math.max(fM7163b2 + f2, fMax);
                    fMin2 = Math.min(fM7173c2 - f3, fMin2);
                    fMax2 = Math.max(fM7173c2 + f3, fMax2);
                }
                this.f7402w.union(Math.round(fMin), Math.round(fMin2), Math.round(fMax), Math.round(fMax2));
            }
            OplusGLSurfaceView_13++;
        }
        this.f7388i = motionEvent.getX();
        this.f7389j = motionEvent.getY();
        if (z) {
            this.f7401v.union(this.f7402w);
            invalidate(this.f7401v);
            this.f7401v.set(this.f7402w);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7155a(int OplusGLSurfaceView_13) {
        announceForAccessibility(this.f7375J.getString(OplusGLSurfaceView_13));
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m7191k() {
        if (this.f7386g.isEmpty()) {
            return;
        }
        setPatternInProgress(false);
        m7192l();
        m7181f();
        invalidate();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m7192l() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 3; OplusGLSurfaceView_13++) {
            for (int i2 = 0; i2 < 3; i2++) {
                CellState cellState = this.f7380a[OplusGLSurfaceView_13][i2];
                if (cellState.f7433g != null) {
                    cellState.f7433g.cancel();
                    cellState.f7431e = Float.MIN_VALUE;
                    cellState.f7432f = Float.MIN_VALUE;
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7169b(MotionEvent motionEvent) {
        this.f7382c = 1.0f;
        m7186h();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Cell cellM7152a = m7152a(x, y);
        if (cellM7152a != null) {
            setPatternInProgress(true);
            this.f7391l = DisplayMode.Correct;
            m7180e();
        } else if (this.f7395p) {
            setPatternInProgress(false);
            m7183g();
        }
        if (cellM7152a != null) {
            float fM7163b = m7163b(cellM7152a.f7426c);
            float fM7173c = m7173c(cellM7152a.f7425b);
            float COUIBaseListPopupWindow_12 = this.f7397r / 2.0f;
            float f2 = this.f7398s / 2.0f;
            invalidate((int) (fM7163b - COUIBaseListPopupWindow_12), (int) (fM7173c - f2), (int) (fM7163b + COUIBaseListPopupWindow_12), (int) (fM7173c + f2));
        }
        this.f7388i = x;
        this.f7389j = y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m7163b(int OplusGLSurfaceView_13) {
        float paddingLeft = getPaddingLeft();
        float COUIBaseListPopupWindow_12 = this.f7397r;
        return paddingLeft + (OplusGLSurfaceView_13 * COUIBaseListPopupWindow_12) + (COUIBaseListPopupWindow_12 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public float m7173c(int OplusGLSurfaceView_13) {
        float paddingTop = getPaddingTop();
        float COUIBaseListPopupWindow_12 = this.f7398s;
        return paddingTop + (OplusGLSurfaceView_13 * COUIBaseListPopupWindow_12) + (COUIBaseListPopupWindow_12 / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float COUIBaseListPopupWindow_12;
        float f2;
        float f3;
        CellState cellState;
        COUILockPatternView cOUILockPatternView = this;
        ArrayList<Cell> arrayList = cOUILockPatternView.f7386g;
        int size = arrayList.size();
        boolean[][] zArr = cOUILockPatternView.f7387h;
        if (cOUILockPatternView.f7391l == DisplayMode.Animate) {
            int iElapsedRealtime = (((int) (SystemClock.elapsedRealtime() - cOUILockPatternView.f7390k)) % ((size + 1) * 700)) / 700;
            m7188i();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iElapsedRealtime; OplusGLSurfaceView_13++) {
                Cell cell = arrayList.get(OplusGLSurfaceView_13);
                zArr[cell.getRow()][cell.getColumn()] = true;
            }
            if (iElapsedRealtime > 0 && iElapsedRealtime < size) {
                float f4 = (r3 % 700) / 700.0f;
                Cell cell2 = arrayList.get(iElapsedRealtime - 1);
                float fM7163b = cOUILockPatternView.m7163b(cell2.f7426c);
                float fM7173c = cOUILockPatternView.m7173c(cell2.f7425b);
                Cell cell3 = arrayList.get(iElapsedRealtime);
                float fM7163b2 = (cOUILockPatternView.m7163b(cell3.f7426c) - fM7163b) * f4;
                float fM7173c2 = f4 * (cOUILockPatternView.m7173c(cell3.f7425b) - fM7173c);
                cOUILockPatternView.f7388i = fM7163b + fM7163b2;
                cOUILockPatternView.f7389j = fM7173c + fM7173c2;
            }
            invalidate();
        }
        Path path = cOUILockPatternView.f7400u;
        path.rewind();
        if (!cOUILockPatternView.f7393n) {
            cOUILockPatternView.f7384e.setColor(cOUILockPatternView.m7151a(true));
            cOUILockPatternView.f7384e.setAlpha((int) (cOUILockPatternView.f7382c * 255.0f));
            float fM7163b3 = 0.0f;
            float fM7173c3 = 0.0f;
            int i2 = 0;
            boolean z = false;
            while (i2 < size) {
                Cell cell4 = arrayList.get(i2);
                if (!zArr[cell4.f7425b][cell4.f7426c]) {
                    break;
                }
                fM7163b3 = cOUILockPatternView.m7163b(cell4.f7426c);
                fM7173c3 = cOUILockPatternView.m7173c(cell4.f7425b);
                if (i2 == 0) {
                    path.rewind();
                    path.moveTo(fM7163b3, fM7173c3);
                }
                if (i2 != 0) {
                    CellState cellState2 = cOUILockPatternView.f7380a[cell4.f7425b][cell4.f7426c];
                    if (cellState2.f7431e != Float.MIN_VALUE && cellState2.f7432f != Float.MIN_VALUE) {
                        path.lineTo(cellState2.f7431e, cellState2.f7432f);
                    } else {
                        path.lineTo(fM7163b3, fM7173c3);
                    }
                }
                i2++;
                z = true;
            }
            if ((cOUILockPatternView.f7395p || cOUILockPatternView.f7391l == DisplayMode.Animate) && z) {
                path.moveTo(fM7163b3, fM7173c3);
                path.lineTo(cOUILockPatternView.f7388i, cOUILockPatternView.f7389j);
            }
            canvas.drawPath(path, cOUILockPatternView.f7384e);
        }
        int i3 = 0;
        while (true) {
            int i4 = 3;
            if (i3 >= 3) {
                return;
            }
            float fM7173c4 = cOUILockPatternView.m7173c(i3);
            int i5 = 0;
            while (i5 < i4) {
                CellState cellState3 = cOUILockPatternView.f7380a[i3][i5];
                float fM7163b4 = cOUILockPatternView.m7163b(i5);
                float f5 = cellState3.f7427a;
                float f6 = cellState3.f7428b;
                boolean z2 = zArr[i3][i5];
                if (z2 || cOUILockPatternView.f7391l == DisplayMode.FingerprintNoMatch) {
                    COUIBaseListPopupWindow_12 = f6;
                    f2 = f5;
                    f3 = fM7163b4;
                    cellState = cellState3;
                    m7156a(canvas, ((int) fM7163b4) + f6, ((int) fM7173c4) + f5, cellState3.f7434h, cellState3.f7436j, cellState3.f7435i, cellState3.f7437k);
                } else {
                    COUIBaseListPopupWindow_12 = f6;
                    f2 = f5;
                    f3 = fM7163b4;
                    cellState = cellState3;
                }
                if (cellState.f7438l) {
                    m7157a(canvas, ((int) f3) + COUIBaseListPopupWindow_12, ((int) fM7173c4) + f2, cellState.f7429c, z2, cellState.f7430d);
                }
                i5++;
                i4 = 3;
                cOUILockPatternView = this;
            }
            i3++;
            cOUILockPatternView = this;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7151a(boolean z) {
        if (this.f7391l == DisplayMode.Wrong || this.f7391l == DisplayMode.FingerprintNoMatch) {
            return this.f7404y;
        }
        if (this.f7391l == DisplayMode.Correct || this.f7391l == DisplayMode.Animate || this.f7391l == DisplayMode.FingerprintMatch) {
            return this.f7405z;
        }
        if (!z || this.f7393n || this.f7395p) {
            return this.f7403x;
        }
        throw new IllegalStateException("unknown display mode " + this.f7391l);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7157a(Canvas canvas, float COUIBaseListPopupWindow_12, float f2, float f3, boolean z, float f4) {
        this.f7383d.setColor(this.f7403x);
        this.f7383d.setAlpha((int) (f4 * 255.0f));
        canvas.drawCircle(COUIBaseListPopupWindow_12, f2, f3, this.f7383d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7156a(Canvas canvas, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6) {
        canvas.save();
        int intrinsicWidth = this.f7371F.getIntrinsicWidth();
        float f7 = intrinsicWidth / 2;
        int OplusGLSurfaceView_13 = (int) (COUIBaseListPopupWindow_12 - f7);
        int i2 = (int) (f2 - f7);
        canvas.scale(f3, f3, COUIBaseListPopupWindow_12, f2);
        this.f7371F.setTint(m7151a(true));
        this.f7371F.setBounds(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13 + intrinsicWidth, intrinsicWidth + i2);
        this.f7371F.setAlpha((int) (f4 * 255.0f));
        this.f7371F.draw(canvas);
        canvas.restore();
        canvas.save();
        int intrinsicWidth2 = this.f7372G.getIntrinsicWidth();
        float f8 = intrinsicWidth2 / 2;
        int i3 = (int) (COUIBaseListPopupWindow_12 - f8);
        int i4 = (int) (f2 - f8);
        canvas.scale(f5, f5, COUIBaseListPopupWindow_12, f2);
        this.f7372G.setTint(m7151a(true));
        this.f7372G.setBounds(i3, i4, i3 + intrinsicWidth2, intrinsicWidth2 + i4);
        this.f7372G.setAlpha((int) (f6 * 255.0f));
        this.f7372G.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f7373H;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f7373H.removeAllListeners();
            this.f7373H = null;
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), COUILockPatternUtils.m6426a(this.f7386g), this.f7391l.ordinal(), this.f7392m, this.f7393n, this.f7394o, null);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m7193a(DisplayMode.Correct, COUILockPatternUtils.m6427a(savedState.getSerializedPattern()));
        this.f7391l = DisplayMode.values()[savedState.getDisplayMode()];
        this.f7392m = savedState.isInputEnabled();
        this.f7393n = savedState.isInStealthMode();
        this.f7394o = savedState.isTactileFeedbackEnabled();
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.widget.COUILockPatternView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        private final int mDisplayMode;
        private final boolean mInStealthMode;
        private final boolean mInputEnabled;
        private final String mSerializedPattern;
        private final boolean mTactileFeedbackEnabled;

        /* synthetic */ SavedState(Parcel parcel, C13911 c13911) {
            this(parcel);
        }

        /* synthetic */ SavedState(Parcelable parcelable, String str, int OplusGLSurfaceView_13, boolean z, boolean z2, boolean z3, C13911 c13911) {
            this(parcelable, str, OplusGLSurfaceView_13, z, z2, z3);
        }

        private SavedState(Parcelable parcelable, String str, int OplusGLSurfaceView_13, boolean z, boolean z2, boolean z3) {
            super(parcelable);
            this.mSerializedPattern = str;
            this.mDisplayMode = OplusGLSurfaceView_13;
            this.mInputEnabled = z;
            this.mInStealthMode = z2;
            this.mTactileFeedbackEnabled = z3;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mSerializedPattern = parcel.readString();
            this.mDisplayMode = parcel.readInt();
            this.mInputEnabled = ((Boolean) parcel.readValue(null)).booleanValue();
            this.mInStealthMode = ((Boolean) parcel.readValue(null)).booleanValue();
            this.mTactileFeedbackEnabled = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public String getSerializedPattern() {
            return this.mSerializedPattern;
        }

        public int getDisplayMode() {
            return this.mDisplayMode;
        }

        public boolean isInputEnabled() {
            return this.mInputEnabled;
        }

        public boolean isInStealthMode() {
            return this.mInStealthMode;
        }

        public boolean isTactileFeedbackEnabled() {
            return this.mTactileFeedbackEnabled;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeString(this.mSerializedPattern);
            parcel.writeInt(this.mDisplayMode);
            parcel.writeValue(Boolean.valueOf(this.mInputEnabled));
            parcel.writeValue(Boolean.valueOf(this.mInStealthMode));
            parcel.writeValue(Boolean.valueOf(this.mTactileFeedbackEnabled));
        }
    }

    private final class PatternExploreByTouchHelper extends ExploreByTouchHelper {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUILockPatternView f7440a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Rect f7441b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final SparseArray<VirtualViewContainer> f7442c;

        class VirtualViewContainer {

            /* renamed from: PlatformImplementations.kt_3 */
            CharSequence f7443a;
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected int getVirtualViewAt(float COUIBaseListPopupWindow_12, float f2) {
            return m7204a(COUIBaseListPopupWindow_12, f2);
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            if (this.f7440a.f7395p) {
                for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < 10; OplusGLSurfaceView_13++) {
                    list.add(Integer.valueOf(OplusGLSurfaceView_13));
                }
            }
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int OplusGLSurfaceView_13, AccessibilityEvent accessibilityEvent) {
            VirtualViewContainer virtualViewContainer = this.f7442c.get(OplusGLSurfaceView_13);
            if (virtualViewContainer != null) {
                accessibilityEvent.getText().add(virtualViewContainer.f7443a);
            }
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int OplusGLSurfaceView_13, AccessibilityNodeInfoCompat c0483d) {
            c0483d.m2697c(m7207d(OplusGLSurfaceView_13));
            c0483d.m2702e(m7207d(OplusGLSurfaceView_13));
            if (this.f7440a.f7395p) {
                c0483d.m2698c(true);
                if (m7205b(OplusGLSurfaceView_13)) {
                    c0483d.m2679a(AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3018e);
                    c0483d.m2709g(m7205b(OplusGLSurfaceView_13));
                }
            }
            c0483d.m2687b(m7206c(OplusGLSurfaceView_13));
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            if (this.f7440a.f7395p) {
                return;
            }
            accessibilityEvent.setContentDescription(this.f7440a.getContext().getText(R.string.lockscreen_access_pattern_area));
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean m7205b(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == Integer.MIN_VALUE || OplusGLSurfaceView_13 == Integer.MAX_VALUE) {
                return false;
            }
            int i2 = OplusGLSurfaceView_13 - 1;
            return !this.f7440a.f7387h[i2 / 3][i2 % 3];
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int OplusGLSurfaceView_13, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            return m7208a(OplusGLSurfaceView_13);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m7208a(int OplusGLSurfaceView_13) {
            invalidateVirtualView(OplusGLSurfaceView_13);
            sendEventForVirtualView(OplusGLSurfaceView_13, 1);
            return true;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Rect m7206c(int OplusGLSurfaceView_13) {
            int i2 = OplusGLSurfaceView_13 - 1;
            Rect rect = this.f7441b;
            int i3 = i2 / 3;
            float fM7163b = this.f7440a.m7163b(i2 % 3);
            float fM7173c = this.f7440a.m7173c(i3);
            float COUIBaseListPopupWindow_12 = this.f7440a.f7398s * this.f7440a.f7396q * 0.5f;
            float f2 = this.f7440a.f7397r * this.f7440a.f7396q * 0.5f;
            rect.left = (int) (fM7163b - f2);
            rect.right = (int) (fM7163b + f2);
            rect.top = (int) (fM7173c - COUIBaseListPopupWindow_12);
            rect.bottom = (int) (fM7173c + COUIBaseListPopupWindow_12);
            return rect;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        private CharSequence m7207d(int OplusGLSurfaceView_13) {
            return this.f7440a.getResources().getString(R.string.lockscreen_access_pattern_cell_added_verbose, String.valueOf(OplusGLSurfaceView_13));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private int m7204a(float COUIBaseListPopupWindow_12, float f2) {
            int iM7165b;
            int iM7150a = this.f7440a.m7150a(f2);
            if (iM7150a < 0 || (iM7165b = this.f7440a.m7165b(COUIBaseListPopupWindow_12)) < 0) {
                return Integer.MIN_VALUE;
            }
            boolean z = this.f7440a.f7387h[iM7150a][iM7165b];
            int OplusGLSurfaceView_13 = (iM7150a * 3) + iM7165b + 1;
            if (z) {
                return OplusGLSurfaceView_13;
            }
            return Integer.MIN_VALUE;
        }
    }

    public void setLockPassword(boolean z) {
        this.f7370E = z;
    }

    @Deprecated
    public Animator getFailAnimator() {
        return ValueAnimator.ofFloat(0.0f, 1.0f);
    }

    @Deprecated
    public Animator getSuccessAnimator() {
        return ValueAnimator.ofInt(255, 0);
    }

    public AnimatorSet getEnterAnim() {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 3; OplusGLSurfaceView_13++) {
            for (int i2 = 0; i2 < 3; i2++) {
                m7162a(this.f7380a[OplusGLSurfaceView_13][i2], arrayList, (OplusGLSurfaceView_13 * 3) + i2);
            }
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7162a(CellState cellState, List<Animator> list, int OplusGLSurfaceView_13) {
        cellState.setCellNumberAlpha(0.0f);
        cellState.setCellNumberTranslateY(this.f7377L);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(cellState, "cellNumberAlpha", 0.0f, Color.alpha(this.f7403x) / 255.0f);
        long OplusGLSurfaceView_15 = OplusGLSurfaceView_13 * 16;
        objectAnimatorOfFloat.setStartDelay(166 + OplusGLSurfaceView_15);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(this.f7378M);
        list.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(cellState, "cellNumberTranslateY", this.f7377L, 0);
        objectAnimatorOfInt.setStartDelay(OplusGLSurfaceView_15);
        objectAnimatorOfInt.setDuration(500L);
        objectAnimatorOfInt.setInterpolator(this.f7379N);
        list.add(objectAnimatorOfInt);
    }

    public void setRegularColor(int OplusGLSurfaceView_13) {
        this.f7403x = OplusGLSurfaceView_13;
    }

    public void setErrorColor(int OplusGLSurfaceView_13) {
        this.f7404y = OplusGLSurfaceView_13;
    }

    public void setSuccessColor(int OplusGLSurfaceView_13) {
        this.f7405z = OplusGLSurfaceView_13;
    }

    public void setPathColor(int OplusGLSurfaceView_13) {
        this.f7384e.setColor(OplusGLSurfaceView_13);
    }

    public void setOuterCircleMaxAlpha(int OplusGLSurfaceView_13) {
        this.f7399t = OplusGLSurfaceView_13;
    }
}
