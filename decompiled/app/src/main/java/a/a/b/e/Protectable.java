package a_renamed.a_renamed.b_renamed.e_renamed;

/* loaded from: classes.dex */
public class c_renamed extends a_renamed.a_renamed.b_renamed.e_renamed.b_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    public android.view.Surface f68c;
    public boolean d_renamed;

    public c_renamed(a_renamed.a_renamed.b_renamed.e_renamed.a_renamed aVar, android.graphics.SurfaceTexture surfaceTexture) {
        super(aVar);
        a_renamed(surfaceTexture);
    }

    public void d_renamed() {
        b_renamed();
        android.view.Surface surface = this.f68c;
        if (surface != null) {
            if (this.d_renamed) {
                surface.release();
            }
            this.f68c = null;
        }
    }
}
