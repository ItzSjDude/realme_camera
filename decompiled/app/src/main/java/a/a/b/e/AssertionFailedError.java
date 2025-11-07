package a_renamed.a_renamed.b_renamed.e_renamed;

/* loaded from: classes.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.e_renamed.a_renamed f66a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public android.opengl.EGLSurface f67b = android.opengl.EGL14.EGL_NO_SURFACE;

    public b_renamed(a_renamed.a_renamed.b_renamed.e_renamed.a_renamed aVar) {
        this.f66a = aVar;
    }

    public void a_renamed() {
        this.f66a.a_renamed(this.f67b);
    }

    public void a_renamed(java.lang.Object obj) {
        if (this.f67b != android.opengl.EGL14.EGL_NO_SURFACE) {
            throw new java.lang.IllegalStateException("surface already created");
        }
        this.f67b = this.f66a.a_renamed(obj);
    }

    public void b_renamed() {
        this.f66a.b_renamed(this.f67b);
        this.f67b = android.opengl.EGL14.EGL_NO_SURFACE;
    }

    public boolean c_renamed() {
        boolean zC = this.f66a.c_renamed(this.f67b);
        if (!zC) {
            android.util.Log.d_renamed("EglSurfaceBase", "WARNING: swapBuffers() failed");
        }
        return zC;
    }
}
