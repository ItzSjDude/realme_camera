package co_renamed.polarr.renderer.textureview;

/* loaded from: classes.dex */
public class GLTextureView extends android.view.TextureView {

    /* renamed from: a_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.c_renamed.b_renamed f1952a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.e_renamed.d_renamed f1953b;

    public class porender_YuvEf extends a_renamed.a_renamed.b_renamed.c_renamed.b_renamed {
        public porender_YuvEf(a_renamed.a_renamed.b_renamed.c_renamed.g_renamed gVar) {
            super(gVar);
        }

        @Override // a_renamed.a_renamed.b_renamed.c_renamed.b_renamed
        public android.content.Context a_renamed() {
            return co_renamed.polarr.renderer.textureview.GLTextureView.this.getContext();
        }
    }

    public GLTextureView(android.content.Context context) {
        super(context);
        a_renamed();
    }

    public GLTextureView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        a_renamed();
    }

    public GLTextureView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        a_renamed();
    }

    public void a_renamed() {
        this.f1953b = new a_renamed.a_renamed.b_renamed.e_renamed.d_renamed();
        this.f1953b.start();
        setSurfaceTextureListener(this.f1953b);
        b_renamed();
    }

    public void b_renamed() {
        if (this.f1952a == null) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed gVar = new a_renamed.a_renamed.b_renamed.c_renamed.g_renamed(getContext(), getResources(), this.f1953b);
            this.f1953b.a_renamed(gVar);
            this.f1952a = new co_renamed.polarr.renderer.textureview.GLTextureView.porender_YuvEf(gVar);
        }
    }

    public a_renamed.a_renamed.b_renamed.c_renamed.b_renamed getRenderDelegate() {
        return this.f1952a;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1953b.b_renamed();
    }
}
