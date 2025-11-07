package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.p025a.p026a.Helper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Arrays;

/* compiled from: ConstraintHelper.java */
/* renamed from: androidx.constraintlayout.widget.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    protected int[] f2559a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected int f2560b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected Context f2561c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected Helper f2562d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected boolean f2563e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f2564f;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2181b(ConstraintLayout constraintLayout) {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m2182c(ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    public ConstraintHelper(Context context) throws IllegalAccessException, IllegalArgumentException {
        super(context);
        this.f2559a = new int[32];
        this.f2563e = false;
        this.f2561c = context;
        mo2176a((AttributeSet) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo2176a(AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < indexCount; OplusGLSurfaceView_13++) {
                int index = typedArrayObtainStyledAttributes.getIndex(OplusGLSurfaceView_13);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f2564f = typedArrayObtainStyledAttributes.getString(index);
                    setIds(this.f2564f);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f2559a, this.f2560b);
    }

    public void setReferencedIds(int[] iArr) {
        this.f2560b = 0;
        for (int OplusGLSurfaceView_13 : iArr) {
            setTag(OplusGLSurfaceView_13, null);
        }
    }

    @Override // android.view.View
    public void setTag(int OplusGLSurfaceView_13, Object obj) {
        int i2 = this.f2560b + 1;
        int[] iArr = this.f2559a;
        if (i2 > iArr.length) {
            this.f2559a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f2559a;
        int i3 = this.f2560b;
        iArr2[i3] = OplusGLSurfaceView_13;
        this.f2560b = i3 + 1;
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        if (this.f2563e) {
            super.onMeasure(OplusGLSurfaceView_13, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2180b() {
        if (this.f2562d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.C0398a) {
            ((ConstraintLayout.C0398a) layoutParams).f2491al = this.f2562d;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2178a(String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        Object objM2172a;
        if (str == null || this.f2561c == null) {
            return;
        }
        String strTrim = str.trim();
        try {
            iIntValue = R.id_renamed.class.getField(strTrim).getInt(null);
        } catch (Exception unused) {
            iIntValue = 0;
        }
        if (iIntValue == 0) {
            iIntValue = this.f2561c.getResources().getIdentifier(strTrim, TtmlNode.ATTR_ID, this.f2561c.getPackageName());
        }
        if (iIntValue == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (objM2172a = ((ConstraintLayout) getParent()).m2172a(0, strTrim)) != null && (objM2172a instanceof Integer)) {
            iIntValue = ((Integer) objM2172a).intValue();
        }
        if (iIntValue != 0) {
            setTag(iIntValue, null);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id_renamed of \"" + strTrim + "\"");
    }

    private void setIds(String str) throws IllegalAccessException, IllegalArgumentException {
        if (str == null) {
            return;
        }
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, OplusGLSurfaceView_13);
            if (iIndexOf == -1) {
                m2178a(str.substring(OplusGLSurfaceView_13));
                return;
            } else {
                m2178a(str.substring(OplusGLSurfaceView_13, iIndexOf));
                OplusGLSurfaceView_13 = iIndexOf + 1;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2179a(ConstraintLayout constraintLayout) throws IllegalAccessException, IllegalArgumentException {
        if (isInEditMode()) {
            setIds(this.f2564f);
        }
        Helper c0383j = this.f2562d;
        if (c0383j == null) {
            return;
        }
        c0383j.m2059K();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f2560b; OplusGLSurfaceView_13++) {
            View viewM2168a = constraintLayout.m2168a(this.f2559a[OplusGLSurfaceView_13]);
            if (viewM2168a != null) {
                this.f2562d.m2060b(constraintLayout.m2169a(viewM2168a));
            }
        }
    }
}
