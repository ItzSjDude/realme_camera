package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: FishEyeTexturePreview.java */
/* loaded from: classes2.dex */
public class n_renamed extends com.oplus.camera.ui.preview.a_renamed.y_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.lang.String f6918a = "0ms";

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Bitmap f6919b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.preview.a_renamed.n_renamed.a_renamed f6920c;
    private int d_renamed;
    private int k_renamed;
    private boolean l_renamed;
    private com.oplus.camera.ui.preview.a_renamed.aa_renamed m_renamed;
    private com.oplus.camera.gl_renamed.s_renamed n_renamed;
    private com.oplus.camera.gl_renamed.s_renamed o_renamed;
    private com.oplus.camera.gl_renamed.s_renamed p_renamed;

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed() {
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void b_renamed() {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void c_renamed() {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public int d_renamed() {
        return 2048;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void e_renamed() {
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean h_renamed() {
        return false;
    }

    /* compiled from: FishEyeTexturePreview.java */
    public static class a_renamed extends android.graphics.drawable.Drawable {

        /* renamed from: a_renamed, reason: collision with root package name */
        private int f6921a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.graphics.Paint f6922b = new android.graphics.Paint(1);

        /* renamed from: c_renamed, reason: collision with root package name */
        private float f6923c;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        public a_renamed(int i_renamed, float f_renamed) {
            this.f6922b.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
            this.f6921a = i_renamed;
            this.f6923c = f_renamed;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            int iSave = canvas.save();
            canvas.drawColor(this.f6921a);
            canvas.drawCircle(getBounds().centerX(), getBounds().centerY(), this.f6923c, this.f6922b);
            canvas.restoreToCount(iSave);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i_renamed) {
            this.f6922b.setAlpha(i_renamed);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
            this.f6922b.setColorFilter(colorFilter);
        }
    }

    public n_renamed(android.content.Context context) {
        super(context);
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar;
        if (a__renamed(i_renamed) && (aaVar = this.m_renamed) != null) {
            return aaVar.c_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.ui.preview.a_renamed.aa_renamed aaVar) {
        this.m_renamed = aaVar;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed f_renamed() {
        return this.o_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public com.oplus.camera.gl_renamed.s_renamed g_renamed() {
        return this.p_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void i_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FishEyeTexturePreview", "newTextures");
        this.f6919b = android.graphics.Bitmap.createBitmap(this.k_renamed, this.d_renamed, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(this.f6919b);
        this.f6920c = new com.oplus.camera.ui.preview.a_renamed.n_renamed.a_renamed(this.j_renamed.getColor(com.oplus.camera.R_renamed.color.fish_eye_cover), (this.d_renamed / 2) - 6);
        this.f6920c.setBounds(0, 0, this.k_renamed, this.d_renamed);
        this.f6920c.draw(canvas);
        this.n_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.k_renamed, this.d_renamed, false);
        this.o_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.k_renamed, this.d_renamed, true);
        this.p_renamed = new com.oplus.camera.gl_renamed.s_renamed(this.k_renamed, this.d_renamed, true);
        this.l_renamed = true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        android.graphics.Bitmap bitmap;
        com.oplus.camera.gl_renamed.s_renamed sVar = this.n_renamed;
        if (sVar != null && !sVar.n_renamed() && (bitmap = this.f6919b) != null) {
            this.n_renamed.a_renamed(hVar, com.oplus.camera.util.k_renamed.a_renamed(bitmap));
            com.oplus.camera.e_renamed.a_renamed("FishEyeTexturePreview", "prepareTextures, mFishEyeCoverTexture.getId: " + this.n_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar2 = this.o_renamed;
        if (sVar2 != null && !sVar2.n_renamed()) {
            this.o_renamed.c_renamed(hVar);
            com.oplus.camera.e_renamed.a_renamed("FishEyeTexturePreview", "prepareTextures, mInputTexture.getId: " + this.o_renamed.e_renamed());
        }
        com.oplus.camera.gl_renamed.s_renamed sVar3 = this.p_renamed;
        if (sVar3 == null || sVar3.n_renamed()) {
            return;
        }
        this.p_renamed.c_renamed(hVar);
        com.oplus.camera.e_renamed.a_renamed("FishEyeTexturePreview", "prepareTextures, mOutputTexture.getId: " + this.p_renamed.e_renamed());
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a_renamed(com.oplus.camera.ui.preview.a_renamed.y_renamed.a_renamed aVar) {
        long jA = com.oplus.camera.algovisualization.a_renamed.a_renamed();
        if (aVar == null) {
            return false;
        }
        aVar.f6975a.a_renamed(this.p_renamed);
        aVar.f6975a.a_renamed(this.n_renamed, aVar.i_renamed, 0, 0, this.k_renamed, this.d_renamed);
        aVar.f6975a.h_renamed();
        f6918a = com.oplus.camera.algovisualization.a_renamed.a_renamed(jA, com.oplus.camera.algovisualization.a_renamed.a_renamed());
        return true;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FishEyeTexturePreview", "recycleTextures");
        if (this.l_renamed) {
            com.oplus.camera.gl_renamed.s_renamed sVar = this.n_renamed;
            if (sVar != null) {
                sVar.o_renamed();
                this.n_renamed = null;
            }
            android.graphics.Bitmap bitmap = this.f6919b;
            if (bitmap != null) {
                bitmap.recycle();
                this.f6919b = null;
            }
            com.oplus.camera.gl_renamed.s_renamed sVar2 = this.o_renamed;
            if (sVar2 != null) {
                sVar2.o_renamed();
                this.o_renamed = null;
            }
            com.oplus.camera.gl_renamed.s_renamed sVar3 = this.p_renamed;
            if (sVar3 != null) {
                sVar3.o_renamed();
                this.p_renamed = null;
            }
            this.l_renamed = false;
        }
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(com.oplus.camera.gl_renamed.s_renamed sVar) {
        com.oplus.camera.e_renamed.e_renamed("FishEyeTexturePreview", "setOutputTexture");
        this.p_renamed = sVar;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("FishEyeTexturePreview", "setSize, height: " + i_renamed + ", width: " + i2);
        this.k_renamed = i2;
        this.d_renamed = i_renamed;
    }

    @Override // com.oplus.camera.ui.preview.a_renamed.y_renamed
    public boolean a__renamed(int i_renamed) {
        return (d_renamed() & i_renamed) != 0;
    }
}
