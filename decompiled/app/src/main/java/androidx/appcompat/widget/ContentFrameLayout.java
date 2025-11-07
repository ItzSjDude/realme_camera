package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.core.p036h.ViewCompat;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private TypedValue f1606a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private TypedValue f1607b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TypedValue f1608c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TypedValue f1609d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private TypedValue f1610e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private TypedValue f1611f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Rect f1612g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private InterfaceC0276a f1613h;

    /* renamed from: androidx.appcompat.widget.ContentFrameLayout$PlatformImplementations.kt_3 */
    public interface InterfaceC0276a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo850a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo851b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f1612g = new Rect();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1327a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(InterfaceC0276a interfaceC0276a) {
        this.f1613h = interfaceC0276a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1326a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f1612g.set(OplusGLSurfaceView_13, i2, i3, i4);
        if (ViewCompat.m2823A(this)) {
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f5  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1606a == null) {
            this.f1606a = new TypedValue();
        }
        return this.f1606a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1607b == null) {
            this.f1607b = new TypedValue();
        }
        return this.f1607b;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1608c == null) {
            this.f1608c = new TypedValue();
        }
        return this.f1608c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1609d == null) {
            this.f1609d = new TypedValue();
        }
        return this.f1609d;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1610e == null) {
            this.f1610e = new TypedValue();
        }
        return this.f1610e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1611f == null) {
            this.f1611f = new TypedValue();
        }
        return this.f1611f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        InterfaceC0276a interfaceC0276a = this.f1613h;
        if (interfaceC0276a != null) {
            interfaceC0276a.mo850a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC0276a interfaceC0276a = this.f1613h;
        if (interfaceC0276a != null) {
            interfaceC0276a.mo851b();
        }
    }
}
