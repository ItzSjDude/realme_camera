package a_renamed.a_renamed.b_renamed.c_renamed;

/* loaded from: classes.dex */
public abstract class b_renamed {
    public static final java.lang.String WATERMARK_PATH = "/watermark.png";

    /* renamed from: a_renamed, reason: collision with root package name */
    public final a_renamed.a_renamed.b_renamed.d_renamed f28a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public a_renamed.a_renamed.b_renamed.c_renamed.g_renamed f29b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f30c;
    public int d_renamed;
    public android.graphics.Bitmap e_renamed;

    public b_renamed(a_renamed.a_renamed.b_renamed.c_renamed.g_renamed gVar) {
        this.f29b = gVar;
        b_renamed().currentRender = gVar;
        b_renamed().context = a_renamed();
        b_renamed().assetManager = a_renamed().getAssets();
        b_renamed().resources = a_renamed().getResources();
        b_renamed().glRenderView = this;
        try {
            this.e_renamed = d_renamed();
            if (this.e_renamed == null) {
                this.e_renamed = android.graphics.BitmapFactory.decodeStream(a_renamed().getAssets().open("editor/img/sample_images/logo-large.png"));
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        this.f28a = new a_renamed.a_renamed.b_renamed.d_renamed();
    }

    public abstract android.content.Context a_renamed();

    public void a_renamed(int i_renamed) {
        android.opengl.GLES20.glGetError();
        if (this.f28a.r_renamed() != i_renamed) {
            this.f28a.c_renamed(i_renamed);
            this.f28a.c_renamed(this.f30c, this.d_renamed);
            this.f28a.b_renamed();
        }
    }

    public void a_renamed(int[] iArr) {
        android.opengl.GLES20.glGetError();
        if (this.f28a.a_renamed(iArr)) {
            return;
        }
        this.f28a.c_renamed(this.f30c, this.d_renamed);
        this.f28a.b_renamed();
    }

    public final co_renamed.polarr.renderer.entities.Context b_renamed() {
        return a_renamed.a_renamed.b_renamed.c_renamed.a_renamed.f27a;
    }

    public android.content.res.Resources c_renamed() {
        return a_renamed().getResources();
    }

    public final android.graphics.Bitmap d_renamed() {
        try {
            java.io.File file = new java.io.File(a_renamed().getFilesDir().getPath() + WATERMARK_PATH);
            if (file.exists()) {
                return android.graphics.BitmapFactory.decodeFile(file.getPath());
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        return null;
    }

    public void e_renamed() {
        this.f28a.a_renamed(a_renamed().getResources(), 512, 512, (java.util.Map<java.lang.String, java.lang.Object>) null);
        this.f28a.k_renamed(false);
    }

    public void f_renamed() {
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed gVar = this.f29b;
        if (gVar != null) {
            gVar.c_renamed();
        }
    }
}
