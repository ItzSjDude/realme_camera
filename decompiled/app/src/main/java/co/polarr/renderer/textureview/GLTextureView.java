package co.polarr.renderer.textureview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import p000a.p001a.p003b.p007c.AbstractC0092b;
import p000a.p001a.p003b.p007c.C0097g;
import p000a.p001a.p003b.p009e.TextureViewSurfaceTextureListenerC0105d;

/* loaded from: classes.dex */
public class GLTextureView extends TextureView {

    /* renamed from: PlatformImplementations.kt_3 */
    public AbstractC0092b f5151a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public TextureViewSurfaceTextureListenerC0105d f5152b;

    public class porender_YuvEf extends AbstractC0092b {
        public porender_YuvEf(C0097g c0097g) {
            super(c0097g);
        }

        @Override // p000a.p001a.p003b.p007c.AbstractC0092b
        /* renamed from: PlatformImplementations.kt_3 */
        public Context mo270a() {
            return GLTextureView.this.getContext();
        }
    }

    public GLTextureView(Context context) {
        super(context);
        m5428a();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5428a();
    }

    public GLTextureView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        m5428a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5428a() {
        this.f5152b = new TextureViewSurfaceTextureListenerC0105d();
        this.f5152b.start();
        setSurfaceTextureListener(this.f5152b);
        m5429b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5429b() {
        if (this.f5151a == null) {
            C0097g c0097g = new C0097g(getContext(), getResources(), this.f5152b);
            this.f5152b.m456a(c0097g);
            this.f5151a = new porender_YuvEf(c0097g);
        }
    }

    public AbstractC0092b getRenderDelegate() {
        return this.f5151a;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5152b.m459b();
    }
}
