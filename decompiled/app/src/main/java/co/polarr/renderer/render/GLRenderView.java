package co_renamed.polarr.renderer.render;

/* loaded from: classes.dex */
public class GLRenderView extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.c_renamed.b_renamed f1950a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public android.opengl.GLSurfaceView f1951b;

    public class porender_YuvEf extends a_renamed.a_renamed.b_renamed.c_renamed.b_renamed {
        public porender_YuvEf(a_renamed.a_renamed.b_renamed.c_renamed.g_renamed gVar) {
            super(gVar);
        }

        @Override // a_renamed.a_renamed.b_renamed.c_renamed.b_renamed
        public android.content.Context a_renamed() {
            return co_renamed.polarr.renderer.render.GLRenderView.this.getContext();
        }
    }

    public GLRenderView(android.content.Context context) {
        super(context);
        a_renamed();
    }

    public GLRenderView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        a_renamed();
    }

    public GLRenderView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        a_renamed();
    }

    public void a_renamed() {
        if (this.f1950a == null) {
            android.content.Context context = getContext();
            this.f1951b = new android.opengl.GLSurfaceView(context);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed gVar = new a_renamed.a_renamed.b_renamed.c_renamed.g_renamed(context, getResources(), this.f1951b);
            this.f1950a = new co_renamed.polarr.renderer.render.GLRenderView.porender_YuvEf(gVar);
            this.f1951b.setEGLContextClientVersion(2);
            this.f1951b.setRenderer(gVar);
            addView(this.f1951b, -1, -1);
        }
    }

    public a_renamed.a_renamed.b_renamed.c_renamed.b_renamed getRenderDelegate() {
        return this.f1950a;
    }
}
