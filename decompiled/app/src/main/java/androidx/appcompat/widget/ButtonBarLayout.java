package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.core.p036h.ViewCompat;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f1603a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f1604b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f1605c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1604b = -1;
        this.f1605c = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ButtonBarLayout);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R.styleable.ButtonBarLayout, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        }
        this.f1603a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setAllowStacking(boolean z) {
        if (this.f1603a != z) {
            this.f1603a = z;
            if (!this.f1603a && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int iMakeMeasureSpec;
        boolean z;
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        int paddingBottom = 0;
        if (this.f1603a) {
            if (size > this.f1604b && m1325a()) {
                setStacked(false);
            }
            this.f1604b = size;
        }
        if (m1325a() || View.MeasureSpec.getMode(OplusGLSurfaceView_13) != 1073741824) {
            iMakeMeasureSpec = OplusGLSurfaceView_13;
            z = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(iMakeMeasureSpec, i2);
        if (this.f1603a && !m1325a()) {
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(OplusGLSurfaceView_13, i2);
        }
        int iM1324a = m1324a(0);
        if (iM1324a >= 0) {
            View childAt = getChildAt(iM1324a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (m1325a()) {
                int iM1324a2 = m1324a(iM1324a + 1);
                if (iM1324a2 >= 0) {
                    paddingTop += getChildAt(iM1324a2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                paddingBottom = paddingTop;
            } else {
                paddingBottom = paddingTop + getPaddingBottom();
            }
        }
        if (ViewCompat.m2894m(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m1324a(int OplusGLSurfaceView_13) {
        int childCount = getChildCount();
        while (OplusGLSurfaceView_13 < childCount) {
            if (getChildAt(OplusGLSurfaceView_13).getVisibility() == 0) {
                return OplusGLSurfaceView_13;
            }
            OplusGLSurfaceView_13++;
        }
        return -1;
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.f1605c, super.getMinimumHeight());
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View viewFindViewById = findViewById(R.id_renamed.spacer);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m1325a() {
        return getOrientation() == 1;
    }
}
