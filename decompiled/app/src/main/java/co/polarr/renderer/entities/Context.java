package co.polarr.renderer.entities;

import android.content.res.AssetManager;
import android.content.res.Resources;
import co.polarr.renderer.entities.Mesh;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p007c.AbstractC0092b;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p007c.C0096f;
import p000a.p001a.p003b.p007c.C0097g;
import p000a.p001a.p003b.p010f.C0113f;
import p000a.p001a.p003b.p010f.C0120m;
import p000a.p001a.p003b.p010f.C0125r;
import p000a.p001a.p003b.p010f.C0127t;

/* loaded from: classes.dex */
public class Context {
    public static final int DESIGN_FOR_SDK_HEIGHT = 800;
    public static final float DESIGN_FOR_SDK_IMAGE = 2073600.0f;
    public static final int DESIGN_FOR_SDK_WIDTH = 800;
    public static final int GRAIN_TEXTURE_SIZE = 1024;
    public static Context LutContext = null;
    public static final int P4_3_OVERLAY_TEXTURE_SIZE = 1000;
    public static Mesh overlayMesh;
    public AssetManager assetManager;
    public C0094d[] brushTextures;
    public Map<String, C0094d> brushes;
    public C0094d cacheTexture;
    public float[] compositeCoords;
    public float[] compositeResolution;
    public android.content.Context context;
    public float[] cropMatrix;
    public boolean cropMode;
    public float cropScale;
    public C0097g currentRender;
    public C0094d dehazeTexture;
    public float[][] deltaVertices;
    public C0094d denoiseTexture;
    public C0127t distortion;
    public float[][] distortionVertices;
    public float downsampleFactor;
    public C0094d exportTexture;
    public C0096f[] faceMasks;
    public float fov;
    public AbstractC0092b glRenderView;
    public C0094d grainTexture;
    public boolean grainTextureBinded;
    public C0094d imageTexture;
    public C0094d intermediateTexture;
    public float invFov;
    public boolean isLutRender;
    public boolean isOES;
    public boolean isSDK;
    public C0094d lensBlurTexture;
    public float margin;
    public float[] margins;
    public float[] matrix;
    public float[] matrixInv;
    public int maxTextureSize;
    public Mesh mesh;
    public float minZoom;
    public boolean needUpdateFace;
    public float[] offset;
    public int orientation;
    public Overlay overlay;
    public float[] overlayMask;
    public float[] overlayMatrix;
    public C0094d overlayTexture;
    public boolean overlayTextureBinded;
    public C0094d paintTexture;
    public Map<String, C0094d> patterns;
    public float[] perspectiveMatrix;
    public boolean photoLoaded;
    public float[] projectionMatrix;
    public float[] projectionMatrixInv;
    public C0094d readableTexture;
    public Map<String, Object> renderStates;
    public Resources resources;
    public C0094d retouchTexture;
    public float rotation;
    public float[] rotation90Matrix;
    public float[] rotation90MatrixInv;
    public float[] rotationMatrix;
    public float[] scaleMatrix;
    public Screen screen;
    public float[] screenMatrix;
    public C0094d screenTexture;
    public C0120m shaderUtil;
    public float[] skinColor;
    public C0094d tempTexture;
    public List<C0094d> textLayers;
    public int[] textures;
    public float[] thresholdAverage;
    public float[] tmpMatrix;
    public float[] translationMatrix;
    public float[] viewMatrix;
    public WatermarkOptions watermarkOptions;
    public C0094d watermarkTexture;
    public C0094d writableTexture;
    public float zoom;
    public static float[] backgroundColor = {0.11764706f, 0.11764706f, 0.11764706f};
    public static Mesh DefaultMesh = null;

    public static class FaceFeaturesState {
        public float[] eye_size = {0.0f, 0.0f};
        public float face_width = 0.0f;
        public float forehead_height = 0.0f;
        public float chin_height = 0.0f;
        public float nose_width = 0.0f;
        public float nose_height = 0.0f;
        public float mouth_width = 0.0f;
        public float mouth_height = 0.0f;
        public float smile = 0.0f;
    }

    public static class FaceState {
        public float skin_smoothness = 0.0f;
        public float skin_tone = 0.0f;
        public float skin_hue = 0.0f;
        public float skin_saturation = 0.0f;
        public float skin_shadows = 0.0f;
        public float skin_highlights = 0.0f;
        public float teeth_whitening = 0.0f;
        public float teeth_brightness = 0.0f;
        public float eyes_brightness = 0.0f;
        public float eyes_contrast = 0.0f;
        public float eyes_clarity = 0.0f;
        public float lips_brightness = 0.0f;
        public float lips_saturation = 0.0f;
    }

    public static class LocalState {
        public String mosaic_pattern;
        public float blur = 0.0f;
        public float exposure = 0.0f;
        public float gamma = 0.0f;
        public float temperature = 0.0f;
        public float tint = 0.0f;
        public float saturation = 0.0f;
        public float vibrance = 0.0f;
        public float contrast = 0.0f;
        public float highlights = 0.0f;
        public float shadows = 0.0f;
        public float clarity = 0.0f;
        public float mosaic_size = 0.0f;
        public float shadows_hue = 0.0f;
        public float shadows_saturation = 0.0f;
        public float balance = -1.0f;
        public float dehaze = 0.0f;
    }

    public static class Overlay {
        public int flipX;
        public int flipY;
        public float height;
        public float imageHeight;
        public float imageWidth;
        public float rotation;

        /* renamed from: tx */
        public float f5143tx;

        /* renamed from: ty */
        public float f5144ty;
        public float width;
    }

    public static class Screen {
        public float zoom = 1.0f;
        public float[] offset = {0.0f, 0.0f};
        public float[] center = {0.5f, 0.5f};
        public float[] rotation = {0.0f, 0.0f, 0.0f};
        public int orientation = 0;
    }

    public static class WatermarkOptions {
        public String artist;
        public String copyright;
        public String description;
        public int height;
        public int width;
        public float scale = 0.2f;
        public float rotation = 0.0f;
        public float opacity = 1.0f;
        public float[] position = {0.95f, 0.95f};
        public boolean enabled = false;
        public boolean preview = false;
        public boolean addMetadata = false;
    }

    public Context() {
        this.textures = new int[0];
        this.brushTextures = new C0094d[4];
        this.grainTextureBinded = false;
        this.overlayTextureBinded = false;
        this.matrix = C0125r.m596a();
        this.matrixInv = C0125r.m596a();
        this.perspectiveMatrix = C0125r.m596a();
        this.projectionMatrix = C0125r.m596a();
        this.projectionMatrixInv = C0125r.m596a();
        this.translationMatrix = C0125r.m596a();
        this.rotationMatrix = C0125r.m596a();
        this.rotation90Matrix = C0125r.m596a();
        this.rotation90MatrixInv = C0125r.m596a();
        this.scaleMatrix = C0125r.m596a();
        this.cropMatrix = C0125r.m596a();
        this.screenMatrix = C0125r.m596a();
        this.viewMatrix = C0125r.m596a();
        this.overlayMatrix = C0125r.m596a();
        this.tmpMatrix = C0125r.m596a();
        this.zoom = 1.0f;
        this.rotation = 0.0f;
        this.orientation = 0;
        this.offset = new float[]{0.0f, 0.0f};
        this.cropScale = 1.0f;
        this.compositeResolution = new float[]{0.0f, 0.0f};
        this.compositeCoords = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.downsampleFactor = 1.0f;
        this.margin = 0.0f;
        this.margins = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.cropMode = false;
        this.thresholdAverage = new float[]{1.0f, 1.0f, 1.0f};
        this.skinColor = new float[]{0.0f, 0.0f, 0.0f};
        this.overlayMask = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.screen = new Screen();
        this.watermarkOptions = new WatermarkOptions();
        this.textLayers = new ArrayList();
        this.renderStates = new HashMap();
        this.needUpdateFace = false;
        this.overlay = new Overlay();
        this.distortion = new C0127t();
        this.photoLoaded = false;
        this.isSDK = false;
        this.isOES = false;
        this.isLutRender = false;
        init();
    }

    public Context(boolean z) {
        this.textures = new int[0];
        this.brushTextures = new C0094d[4];
        this.grainTextureBinded = false;
        this.overlayTextureBinded = false;
        this.matrix = C0125r.m596a();
        this.matrixInv = C0125r.m596a();
        this.perspectiveMatrix = C0125r.m596a();
        this.projectionMatrix = C0125r.m596a();
        this.projectionMatrixInv = C0125r.m596a();
        this.translationMatrix = C0125r.m596a();
        this.rotationMatrix = C0125r.m596a();
        this.rotation90Matrix = C0125r.m596a();
        this.rotation90MatrixInv = C0125r.m596a();
        this.scaleMatrix = C0125r.m596a();
        this.cropMatrix = C0125r.m596a();
        this.screenMatrix = C0125r.m596a();
        this.viewMatrix = C0125r.m596a();
        this.overlayMatrix = C0125r.m596a();
        this.tmpMatrix = C0125r.m596a();
        this.zoom = 1.0f;
        this.rotation = 0.0f;
        this.orientation = 0;
        this.offset = new float[]{0.0f, 0.0f};
        this.cropScale = 1.0f;
        this.compositeResolution = new float[]{0.0f, 0.0f};
        this.compositeCoords = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.downsampleFactor = 1.0f;
        this.margin = 0.0f;
        this.margins = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.cropMode = false;
        this.thresholdAverage = new float[]{1.0f, 1.0f, 1.0f};
        this.skinColor = new float[]{0.0f, 0.0f, 0.0f};
        this.overlayMask = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.screen = new Screen();
        this.watermarkOptions = new WatermarkOptions();
        this.textLayers = new ArrayList();
        this.renderStates = new HashMap();
        this.needUpdateFace = false;
        this.overlay = new Overlay();
        this.distortion = new C0127t();
        this.photoLoaded = false;
        this.isSDK = false;
        this.isOES = false;
        this.isLutRender = false;
        if (!z) {
            init();
        } else {
            C0106f.m464a(this.renderStates);
            this.mesh = Mesh.plane(new Mesh.Options(1));
        }
    }

    private void init() {
        C0106f.m464a(this.renderStates);
        this.mesh = Mesh.plane(new Mesh.Options(64));
        if (DefaultMesh == null) {
            DefaultMesh = Mesh.plane(new Mesh.Options(64));
        }
        if (overlayMesh == null) {
            overlayMesh = Mesh.plane(new Mesh.Options(true, false, false, 32));
        }
        if (LutContext == null) {
            LutContext = new Context(true);
            Context context = LutContext;
            context.isLutRender = true;
            context.imageTexture = C0113f.m486b(0, 6408, 32, 32);
        }
        this.distortionVertices = this.mesh.getDistortionPoints();
        this.deltaVertices = this.mesh.getDeltaPoints();
    }

    public static Map<String, Object> makeCompatible(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        C0106f.m464a(map2);
        HashMap map3 = new HashMap();
        for (String str : map.keySet()) {
            Object objM523a = C0120m.m523a(str, map.get(str));
            if (map2.containsKey(str)) {
                map3.put(str, objM523a);
            }
        }
        List list = (List) map3.get("local_adjustments");
        if (list != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
                Object obj = list.get(OplusGLSurfaceView_13);
                if (obj instanceof HashMap) {
                    Adjustment.fromDecodedHashMap((HashMap) obj).adjustments = new LocalState();
                } else if (obj instanceof Adjustment) {
                }
            }
        }
        return map3;
    }

    public static Map<String, Object> prepareAdjustments(Map<String, Object> map) {
        Map<String, Object> mapMakeCompatible = makeCompatible(map);
        float[] fArr = (float[]) mapMakeCompatible.get("crop");
        if (fArr != null && Arrays.equals(fArr, new float[]{0.0f, 0.0f, 1.0f, 1.0f})) {
            mapMakeCompatible.remove("crop");
        }
        mapMakeCompatible.remove("faces");
        mapMakeCompatible.remove("face_features");
        mapMakeCompatible.remove("spots");
        mapMakeCompatible.remove(MimeTypes.BASE_TYPE_TEXT);
        if (mapMakeCompatible.get("rotation") != null && ((Float) mapMakeCompatible.get("rotation")).floatValue() == 0.0f) {
            mapMakeCompatible.remove("rotation");
        }
        mapMakeCompatible.remove("rotate90");
        mapMakeCompatible.remove("distortion_horizontal");
        mapMakeCompatible.remove("distortion_vertical");
        mapMakeCompatible.remove("distortion_mesh");
        return mapMakeCompatible;
    }

    public void reset() {
        this.mesh = Mesh.plane(new Mesh.Options(64));
        this.distortionVertices = this.mesh.getDistortionPoints();
        this.deltaVertices = this.mesh.getDeltaPoints();
        overlayMesh = Mesh.plane(new Mesh.Options(true, false, false, 32));
        this.screen = new Screen();
        this.textLayers.clear();
        C0106f.m464a(this.renderStates);
    }
}
