package co.polarr.renderer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import co.polarr.renderer.entities.BrushItem;
import co.polarr.renderer.entities.DrawingItem;
import co.polarr.renderer.entities.FaceItem;
import co.polarr.renderer.entities.LutItem;
import co.polarr.renderer.entities.MagicEraserPath;
import java.util.List;
import java.util.Map;
import p000a.p001a.p003b.C0001a;
import p000a.p001a.p003b.C0098d;
import p000a.p001a.p003b.p005b.C0053bo;

/* loaded from: classes.dex */
public class PolarrRender {
    public static final int EXTERNAL_OES = 1;
    public static final int TEXTURE_2D = 0;
    public C0098d instance = new C0098d();

    public static void SetStaticResPath(String str) {
        C0053bo.m171b(str);
    }

    public static String Version() {
        return "1.7.4_op_camera";
    }

    public static void clearTextureHelper(int OplusGLSurfaceView_13, int i2, int i3) {
        C0001a.m8a(OplusGLSurfaceView_13, i2, i3);
    }

    public static void enableLogger(boolean z) {
        C0001a.m12a(z);
    }

    @Deprecated
    public static Map<String, Object> getRenderStatesFromJson(String str) {
        return C0001a.m15b(str);
    }

    public static void magicEraserOneTime(Resources resources, int OplusGLSurfaceView_13, int i2, int i3, MagicEraserPath magicEraserPath) {
        magicEraserOneTime(resources, OplusGLSurfaceView_13, i2, i3, magicEraserPath, 0.0f, 0.0f, 1.0f);
    }

    public static void magicEraserOneTime(Resources resources, int OplusGLSurfaceView_13, int i2, int i3, MagicEraserPath magicEraserPath, float COUIBaseListPopupWindow_12, float f2, float f3) {
        if (f3 != 1.0f) {
            magicEraserPath = magicEraserPath.copy();
            magicEraserPath.points = C0098d.m343a(magicEraserPath.points, COUIBaseListPopupWindow_12, f2, f3);
            magicEraserPath.radius /= f3;
        }
        C0001a.m10a(resources, OplusGLSurfaceView_13, i2, i3, magicEraserPath, 0);
    }

    public static void magicEraserOneTimeCompatible(Resources resources, int OplusGLSurfaceView_13, int i2, int i3, MagicEraserPath magicEraserPath, int i4) {
        C0001a.m10a(resources, OplusGLSurfaceView_13, i2, i3, magicEraserPath, i4);
    }

    public static List<Bitmap> renderBitmaps(Resources resources, Bitmap bitmap, List<String> list) {
        return C0001a.m4a(resources, bitmap, list);
    }

    public static List<Bitmap> renderBitmaps(Resources resources, Bitmap bitmap, List<String> list, float COUIBaseListPopupWindow_12) {
        return C0001a.m5a(resources, bitmap, list, COUIBaseListPopupWindow_12, 0.0f);
    }

    public static List<Bitmap> renderBitmaps(Resources resources, Bitmap bitmap, List<String> list, float COUIBaseListPopupWindow_12, float f2) {
        return C0001a.m5a(resources, bitmap, list, COUIBaseListPopupWindow_12, f2);
    }

    public static byte[] renderNV12(Context context, byte[] bArr, int OplusGLSurfaceView_13, int i2, String str, float COUIBaseListPopupWindow_12, boolean z) {
        return C0001a.m16b(context, bArr, OplusGLSurfaceView_13, i2, str, COUIBaseListPopupWindow_12, z);
    }

    public static byte[] renderNV21(Context context, byte[] bArr, int OplusGLSurfaceView_13, int i2, String str, float COUIBaseListPopupWindow_12, boolean z) {
        C0001a.m13a(context, bArr, OplusGLSurfaceView_13, i2, str, COUIBaseListPopupWindow_12, z);
        throw null;
    }

    public static void setupVignetteParams(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6) {
        C0001a.m6a(COUIBaseListPopupWindow_12, f2, f3, f4, f5, f6);
    }

    public static void updateGlobalScreenOrientation(int OplusGLSurfaceView_13) {
        synchronized (PolarrRender.class) {
            try {
                C0001a.m7a(OplusGLSurfaceView_13);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addBrushPathPoint(BrushItem brushItem, PointF pointF) {
        this.instance.m376a(brushItem, pointF);
    }

    @Deprecated
    public void autoEnhanceFace(Map<String, Object> map, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, boolean z) {
        this.instance.m385a(map, OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, z);
    }

    public Map<String, Object> autoEnhanceGlobal(float COUIBaseListPopupWindow_12) {
        return this.instance.m358a(COUIBaseListPopupWindow_12, (Map<String, Object>) null);
    }

    public Map<String, Object> autoEnhanceGlobal(float COUIBaseListPopupWindow_12, Map<String, Object> map) {
        return this.instance.m358a(COUIBaseListPopupWindow_12, map);
    }

    @Deprecated
    public Map<String, Object> autoEnhanceGlobalForFace(float COUIBaseListPopupWindow_12) {
        return this.instance.m357a(COUIBaseListPopupWindow_12);
    }

    public int brushPaintAdd(List<PointF> list) {
        return this.instance.m350a(list);
    }

    public void brushPaintFinish() {
        this.instance.m404d();
    }

    public void brushStart(BrushItem brushItem) {
        this.instance.m375a(brushItem);
    }

    public void clearTexture(int OplusGLSurfaceView_13, int i2, int i3) {
        this.instance.m362a(OplusGLSurfaceView_13, i2, i3);
    }

    public void clearThumbCache() {
        this.instance.m407e();
    }

    public void combine(int OplusGLSurfaceView_13, int i2) {
        this.instance.m361a(OplusGLSurfaceView_13, i2);
    }

    public void createInputTexture() {
        this.instance.m409f();
    }

    public void drawFiltersFrame(List<DrawingItem> list, int OplusGLSurfaceView_13) {
        this.instance.m382a(list, OplusGLSurfaceView_13);
    }

    public void drawFiltersFrame(List<DrawingItem> list, int OplusGLSurfaceView_13, boolean z, float COUIBaseListPopupWindow_12, float f2, float f3) {
        this.instance.m383a(list, OplusGLSurfaceView_13, z, COUIBaseListPopupWindow_12, f2, f3);
    }

    public void drawFrame() {
        this.instance.m413h();
    }

    public void drawFrameWithVignette() {
        this.instance.m415i();
    }

    public void enableBloom(boolean z) {
        this.instance.m398b(z);
    }

    public void enableCA(boolean z) {
        this.instance.m403c(z);
    }

    public void enableDemoire(boolean z) {
        this.instance.m406d(z);
    }

    public void enableGlitch(boolean z) {
        this.instance.m408e(z);
    }

    public void enablePacman(boolean z) {
        this.instance.m410f(z);
    }

    public void enableRealTimeAutoEnhancement(boolean z) {
        this.instance.m412g(z);
    }

    @Deprecated
    public void fastAutoEnhancement(boolean z) {
        this.instance.m414h(z);
    }

    public Bitmap fastRenderBitmap(Bitmap bitmap, String str) {
        return this.instance.m353a(bitmap, str);
    }

    public Bitmap fastRenderBitmap(Bitmap bitmap, String str, float COUIBaseListPopupWindow_12) {
        return this.instance.m354a(bitmap, str, COUIBaseListPopupWindow_12);
    }

    public void fastUpdateFilter(String str) {
        this.instance.m379a(str);
    }

    public void fastUpdateFilter(String str, float COUIBaseListPopupWindow_12) {
        this.instance.m395b(str, COUIBaseListPopupWindow_12);
    }

    public void fastUpdateLutsFilter(List<LutItem> list) {
        this.instance.m396b(list);
    }

    public void fastUseCombineLut() {
        this.instance.m421l();
    }

    public int getBrushLastPaint() {
        return this.instance.m422m();
    }

    public int getGlitchSeed() {
        return this.instance.m423n();
    }

    public C0053bo getLookup2DFilter() {
        return this.instance.m424o();
    }

    public int getOutputId() {
        return this.instance.m425p();
    }

    public PacmanFilter getPacmanFilter() {
        return this.instance.m426q();
    }

    public int getTextureId() {
        return this.instance.m427r();
    }

    @Deprecated
    public void initAllFilters() {
        this.instance.m428s();
    }

    public void initRender(Resources resources, int OplusGLSurfaceView_13, int i2, boolean z) {
        this.instance.m372a(resources, OplusGLSurfaceView_13, i2, z);
    }

    public void initRender(Resources resources, int OplusGLSurfaceView_13, int i2, boolean z, int i3) {
        this.instance.m373a(resources, OplusGLSurfaceView_13, i2, z, i3);
    }

    @Deprecated
    public boolean isUseVignette() {
        return false;
    }

    public void loadPacManResource() {
        this.instance.m429t();
    }

    public void magicEraserPathOverLay(MagicEraserPath magicEraserPath, int OplusGLSurfaceView_13, int i2, int i3) {
        this.instance.m378a(magicEraserPath, OplusGLSurfaceView_13, i2, i3);
    }

    public void release() {
        this.instance.m430u();
    }

    public void releaseGLRes() {
        this.instance.m433x();
    }

    public void releaseNonGLRes() {
        this.instance.m435z();
    }

    public Bitmap renderBitmap(Bitmap bitmap, Map<String, Object> map) {
        return this.instance.m356a(bitmap, map);
    }

    public void setBrushLastPaintingTex(int OplusGLSurfaceView_13) {
        this.instance.m360a(OplusGLSurfaceView_13);
    }

    public void setFilterIntensity(float COUIBaseListPopupWindow_12) {
        this.instance.m390b(COUIBaseListPopupWindow_12);
    }

    public void setGlitchSeed(int OplusGLSurfaceView_13) {
        this.instance.m391b(OplusGLSurfaceView_13);
    }

    public void setGrainAmount(float COUIBaseListPopupWindow_12) {
        this.instance.m400c(COUIBaseListPopupWindow_12);
    }

    public void setInputTexture(int OplusGLSurfaceView_13) {
        this.instance.m401c(OplusGLSurfaceView_13);
    }

    public void setNeedDrawScreen(boolean z) {
        this.instance.m418j(z);
    }

    public void setOutputTexture(int OplusGLSurfaceView_13) {
        this.instance.m405d(OplusGLSurfaceView_13);
    }

    @Deprecated
    public void setUseVignette(boolean z) {
    }

    public void updateBrushPoints(BrushItem brushItem) {
        this.instance.m393b(brushItem);
    }

    @Deprecated
    public void updateFaces(List<FaceItem> list, float COUIBaseListPopupWindow_12) {
        this.instance.m381a(list, COUIBaseListPopupWindow_12);
    }

    public void updateInputTexture() {
        this.instance.m389b();
    }

    public void updateOffsetScale(float COUIBaseListPopupWindow_12, float f2, float f3) {
        this.instance.m359a(COUIBaseListPopupWindow_12, f2, f3);
    }

    public void updateSize(int OplusGLSurfaceView_13, int i2) {
        this.instance.m402c(OplusGLSurfaceView_13, i2);
    }

    @Deprecated
    public void updateStates(String str) {
        this.instance.m394b(str);
    }

    public void updateStates(Map<String, Object> map) {
        this.instance.m397b(map);
    }
}
