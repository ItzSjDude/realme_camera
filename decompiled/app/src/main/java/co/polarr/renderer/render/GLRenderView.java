package co.polarr.renderer.render;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import p000a.p001a.p003b.p007c.AbstractC0092b;
import p000a.p001a.p003b.p007c.C0097g;

/* loaded from: classes.dex */
public class GLRenderView extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    public AbstractC0092b f5148a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public GLSurfaceView f5149b;

    public class porender_YuvEf extends AbstractC0092b {
        public porender_YuvEf(C0097g c0097g) {
            super(c0097g);
        }

        @Override // p000a.p001a.p003b.p007c.AbstractC0092b
        /* renamed from: PlatformImplementations.kt_3 */
        public Context mo270a() {
            return GLRenderView.this.getContext();
        }
    }

    public GLRenderView(Context context) {
        super(context);
        m5427a();
    }

    public GLRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5427a();
    }

    public GLRenderView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        m5427a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5427a() {
        if (this.f5148a == null) {
            Context context = getContext();
            this.f5149b = new GLSurfaceView(context);
            C0097g c0097g = new C0097g(context, getResources(), this.f5149b);
            this.f5148a = new porender_YuvEf(c0097g);
            this.f5149b.setEGLContextClientVersion(2);
            this.f5149b.setRenderer(c0097g);
            addView(this.f5149b, -1, -1);
        }
    }

    public AbstractC0092b getRenderDelegate() {
        return this.f5148a;
    }
}
