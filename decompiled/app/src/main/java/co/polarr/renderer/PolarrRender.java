package co_renamed.polarr.renderer;

/* loaded from: classes.dex */
public class PolarrRender {
    public static final int EXTERNAL_OES = 1;
    public static final int TEXTURE_2D = 0;
    public a_renamed.a_renamed.b_renamed.d_renamed instance = new a_renamed.a_renamed.b_renamed.d_renamed();

    public static void SetStaticResPath(java.lang.String str) {
        a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed.b_renamed(str);
    }

    public static java.lang.String Version() {
        return "1.7.4_op_camera";
    }

    public static void clearTextureHelper(int i_renamed, int i2, int i3) {
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(i_renamed, i2, i3);
    }

    public static void enableLogger(boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(z_renamed);
    }

    @java.lang.Deprecated
    public static java.util.Map<java.lang.String, java.lang.Object> getRenderStatesFromJson(java.lang.String str) {
        return a_renamed.a_renamed.b_renamed.a_renamed.b_renamed(str);
    }

    public static void magicEraserOneTime(android.content.res.Resources resources, int i_renamed, int i2, int i3, co_renamed.polarr.renderer.entities.MagicEraserPath magicEraserPath) {
        magicEraserOneTime(resources, i_renamed, i2, i3, magicEraserPath, 0.0f, 0.0f, 1.0f);
    }

    public static void magicEraserOneTime(android.content.res.Resources resources, int i_renamed, int i2, int i3, co_renamed.polarr.renderer.entities.MagicEraserPath magicEraserPath, float f_renamed, float f2, float f3) {
        if (f3 != 1.0f) {
            magicEraserPath = magicEraserPath.copy();
            magicEraserPath.points = a_renamed.a_renamed.b_renamed.d_renamed.a_renamed(magicEraserPath.points, f_renamed, f2, f3);
            magicEraserPath.radius /= f3;
        }
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(resources, i_renamed, i2, i3, magicEraserPath, 0);
    }

    public static void magicEraserOneTimeCompatible(android.content.res.Resources resources, int i_renamed, int i2, int i3, co_renamed.polarr.renderer.entities.MagicEraserPath magicEraserPath, int i4) {
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(resources, i_renamed, i2, i3, magicEraserPath, i4);
    }

    public static java.util.List<android.graphics.Bitmap> renderBitmaps(android.content.res.Resources resources, android.graphics.Bitmap bitmap, java.util.List<java.lang.String> list) {
        return a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(resources, bitmap, list);
    }

    public static java.util.List<android.graphics.Bitmap> renderBitmaps(android.content.res.Resources resources, android.graphics.Bitmap bitmap, java.util.List<java.lang.String> list, float f_renamed) {
        return a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(resources, bitmap, list, f_renamed, 0.0f);
    }

    public static java.util.List<android.graphics.Bitmap> renderBitmaps(android.content.res.Resources resources, android.graphics.Bitmap bitmap, java.util.List<java.lang.String> list, float f_renamed, float f2) {
        return a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(resources, bitmap, list, f_renamed, f2);
    }

    public static byte[] renderNV12(android.content.Context context, byte[] bArr, int i_renamed, int i2, java.lang.String str, float f_renamed, boolean z_renamed) {
        return a_renamed.a_renamed.b_renamed.a_renamed.b_renamed(context, bArr, i_renamed, i2, str, f_renamed, z_renamed);
    }

    public static byte[] renderNV21(android.content.Context context, byte[] bArr, int i_renamed, int i2, java.lang.String str, float f_renamed, boolean z_renamed) {
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(context, bArr, i_renamed, i2, str, f_renamed, z_renamed);
        throw null;
    }

    public static void setupVignetteParams(float f_renamed, float f2, float f3, float f4, float f5, float f6) {
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(f_renamed, f2, f3, f4, f5, f6);
    }

    public static void updateGlobalScreenOrientation(int i_renamed) {
        synchronized (co_renamed.polarr.renderer.PolarrRender.class) {
            try {
                a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(i_renamed);
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    public void addBrushPathPoint(co_renamed.polarr.renderer.entities.BrushItem brushItem, android.graphics.PointF pointF) {
        this.instance.a_renamed(brushItem, pointF);
    }

    @java.lang.Deprecated
    public void autoEnhanceFace(java.util.Map<java.lang.String, java.lang.Object> map, int i_renamed, float f_renamed, boolean z_renamed) {
        this.instance.a_renamed(map, i_renamed, f_renamed, z_renamed);
    }

    public java.util.Map<java.lang.String, java.lang.Object> autoEnhanceGlobal(float f_renamed) {
        return this.instance.a_renamed(f_renamed, (java.util.Map<java.lang.String, java.lang.Object>) null);
    }

    public java.util.Map<java.lang.String, java.lang.Object> autoEnhanceGlobal(float f_renamed, java.util.Map<java.lang.String, java.lang.Object> map) {
        return this.instance.a_renamed(f_renamed, map);
    }

    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.Object> autoEnhanceGlobalForFace(float f_renamed) {
        return this.instance.a_renamed(f_renamed);
    }

    public int brushPaintAdd(java.util.List<android.graphics.PointF> list) {
        return this.instance.a_renamed(list);
    }

    public void brushPaintFinish() {
        this.instance.d_renamed();
    }

    public void brushStart(co_renamed.polarr.renderer.entities.BrushItem brushItem) {
        this.instance.a_renamed(brushItem);
    }

    public void clearTexture(int i_renamed, int i2, int i3) {
        this.instance.a_renamed(i_renamed, i2, i3);
    }

    public void clearThumbCache() {
        this.instance.e_renamed();
    }

    public void combine(int i_renamed, int i2) {
        this.instance.a_renamed(i_renamed, i2);
    }

    public void createInputTexture() {
        this.instance.f_renamed();
    }

    public void drawFiltersFrame(java.util.List<co_renamed.polarr.renderer.entities.DrawingItem> list, int i_renamed) {
        this.instance.a_renamed(list, i_renamed);
    }

    public void drawFiltersFrame(java.util.List<co_renamed.polarr.renderer.entities.DrawingItem> list, int i_renamed, boolean z_renamed, float f_renamed, float f2, float f3) {
        this.instance.a_renamed(list, i_renamed, z_renamed, f_renamed, f2, f3);
    }

    public void drawFrame() {
        this.instance.h_renamed();
    }

    public void drawFrameWithVignette() {
        this.instance.i_renamed();
    }

    public void enableBloom(boolean z_renamed) {
        this.instance.b_renamed(z_renamed);
    }

    public void enableCA(boolean z_renamed) {
        this.instance.c_renamed(z_renamed);
    }

    public void enableDemoire(boolean z_renamed) {
        this.instance.d_renamed(z_renamed);
    }

    public void enableGlitch(boolean z_renamed) {
        this.instance.e_renamed(z_renamed);
    }

    public void enablePacman(boolean z_renamed) {
        this.instance.f_renamed(z_renamed);
    }

    public void enableRealTimeAutoEnhancement(boolean z_renamed) {
        this.instance.g_renamed(z_renamed);
    }

    @java.lang.Deprecated
    public void fastAutoEnhancement(boolean z_renamed) {
        this.instance.h_renamed(z_renamed);
    }

    public android.graphics.Bitmap fastRenderBitmap(android.graphics.Bitmap bitmap, java.lang.String str) {
        return this.instance.a_renamed(bitmap, str);
    }

    public android.graphics.Bitmap fastRenderBitmap(android.graphics.Bitmap bitmap, java.lang.String str, float f_renamed) {
        return this.instance.a_renamed(bitmap, str, f_renamed);
    }

    public void fastUpdateFilter(java.lang.String str) {
        this.instance.a_renamed(str);
    }

    public void fastUpdateFilter(java.lang.String str, float f_renamed) {
        this.instance.b_renamed(str, f_renamed);
    }

    public void fastUpdateLutsFilter(java.util.List<co_renamed.polarr.renderer.entities.LutItem> list) {
        this.instance.b_renamed(list);
    }

    public void fastUseCombineLut() {
        this.instance.l_renamed();
    }

    public int getBrushLastPaint() {
        return this.instance.m_renamed();
    }

    public int getGlitchSeed() {
        return this.instance.n_renamed();
    }

    public a_renamed.a_renamed.b_renamed.b_renamed.bo_renamed getLookup2DFilter() {
        return this.instance.o_renamed();
    }

    public int getOutputId() {
        return this.instance.p_renamed();
    }

    public co_renamed.polarr.renderer.PacmanFilter getPacmanFilter() {
        return this.instance.q_renamed();
    }

    public int getTextureId() {
        return this.instance.r_renamed();
    }

    @java.lang.Deprecated
    public void initAllFilters() {
        this.instance.s_renamed();
    }

    public void initRender(android.content.res.Resources resources, int i_renamed, int i2, boolean z_renamed) {
        this.instance.a_renamed(resources, i_renamed, i2, z_renamed);
    }

    public void initRender(android.content.res.Resources resources, int i_renamed, int i2, boolean z_renamed, int i3) {
        this.instance.a_renamed(resources, i_renamed, i2, z_renamed, i3);
    }

    @java.lang.Deprecated
    public boolean isUseVignette() {
        return false;
    }

    public void loadPacManResource() {
        this.instance.t_renamed();
    }

    public void magicEraserPathOverLay(co_renamed.polarr.renderer.entities.MagicEraserPath magicEraserPath, int i_renamed, int i2, int i3) {
        this.instance.a_renamed(magicEraserPath, i_renamed, i2, i3);
    }

    public void release() {
        this.instance.u_renamed();
    }

    public void releaseGLRes() {
        this.instance.x_renamed();
    }

    public void releaseNonGLRes() {
        this.instance.z_renamed();
    }

    public android.graphics.Bitmap renderBitmap(android.graphics.Bitmap bitmap, java.util.Map<java.lang.String, java.lang.Object> map) {
        return this.instance.a_renamed(bitmap, map);
    }

    public void setBrushLastPaintingTex(int i_renamed) {
        this.instance.a_renamed(i_renamed);
    }

    public void setFilterIntensity(float f_renamed) {
        this.instance.b_renamed(f_renamed);
    }

    public void setGlitchSeed(int i_renamed) {
        this.instance.b_renamed(i_renamed);
    }

    public void setGrainAmount(float f_renamed) {
        this.instance.c_renamed(f_renamed);
    }

    public void setInputTexture(int i_renamed) {
        this.instance.c_renamed(i_renamed);
    }

    public void setNeedDrawScreen(boolean z_renamed) {
        this.instance.j_renamed(z_renamed);
    }

    public void setOutputTexture(int i_renamed) {
        this.instance.d_renamed(i_renamed);
    }

    @java.lang.Deprecated
    public void setUseVignette(boolean z_renamed) {
    }

    public void updateBrushPoints(co_renamed.polarr.renderer.entities.BrushItem brushItem) {
        this.instance.b_renamed(brushItem);
    }

    @java.lang.Deprecated
    public void updateFaces(java.util.List<co_renamed.polarr.renderer.entities.FaceItem> list, float f_renamed) {
        this.instance.a_renamed(list, f_renamed);
    }

    public void updateInputTexture() {
        this.instance.b_renamed();
    }

    public void updateOffsetScale(float f_renamed, float f2, float f3) {
        this.instance.a_renamed(f_renamed, f2, f3);
    }

    public void updateSize(int i_renamed, int i2) {
        this.instance.c_renamed(i_renamed, i2);
    }

    @java.lang.Deprecated
    public void updateStates(java.lang.String str) {
        this.instance.b_renamed(str);
    }

    public void updateStates(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.instance.b_renamed(map);
    }
}
