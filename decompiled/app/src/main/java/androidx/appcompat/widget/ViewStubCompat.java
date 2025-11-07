package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f1700a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f1701b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private WeakReference<View> f1702c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private LayoutInflater f1703d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private InterfaceC0303a f1704e;

    /* renamed from: androidx.appcompat.widget.ViewStubCompat$PlatformImplementations.kt_3 */
    public interface InterfaceC0303a {
        /* renamed from: PlatformImplementations.kt_3 */
        void m1386a(ViewStubCompat viewStubCompat, View view);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f1700a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewStubCompat, OplusGLSurfaceView_13, 0);
        this.f1701b = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.f1700a = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.f1701b;
    }

    public void setInflatedId(int OplusGLSurfaceView_13) {
        this.f1701b = OplusGLSurfaceView_13;
    }

    public int getLayoutResource() {
        return this.f1700a;
    }

    public void setLayoutResource(int OplusGLSurfaceView_13) {
        this.f1700a = OplusGLSurfaceView_13;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1703d = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1703d;
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        WeakReference<View> weakReference = this.f1702c;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(OplusGLSurfaceView_13);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 == 4) {
            m1385a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public View m1385a() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            if (this.f1700a != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                LayoutInflater layoutInflaterFrom = this.f1703d;
                if (layoutInflaterFrom == null) {
                    layoutInflaterFrom = LayoutInflater.from(getContext());
                }
                View viewInflate = layoutInflaterFrom.inflate(this.f1700a, viewGroup, false);
                int OplusGLSurfaceView_13 = this.f1701b;
                if (OplusGLSurfaceView_13 != -1) {
                    viewInflate.setId(OplusGLSurfaceView_13);
                }
                int iIndexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
                } else {
                    viewGroup.addView(viewInflate, iIndexOfChild);
                }
                this.f1702c = new WeakReference<>(viewInflate);
                InterfaceC0303a interfaceC0303a = this.f1704e;
                if (interfaceC0303a != null) {
                    interfaceC0303a.m1386a(this, viewInflate);
                }
                return viewInflate;
            }
            throw new IllegalArgumentException("ViewStub must have PlatformImplementations.kt_3 valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have PlatformImplementations.kt_3 non-null ViewGroup viewParent");
    }

    public void setOnInflateListener(InterfaceC0303a interfaceC0303a) {
        this.f1704e = interfaceC0303a;
    }
}
