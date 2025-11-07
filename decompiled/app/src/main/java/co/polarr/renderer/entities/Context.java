package co_renamed.polarr.renderer.entities;

/* loaded from: classes.dex */
public class Context {
    public static final int DESIGN_FOR_SDK_HEIGHT = 800;
    public static final float DESIGN_FOR_SDK_IMAGE = 2073600.0f;
    public static final int DESIGN_FOR_SDK_WIDTH = 800;
    public static final int GRAIN_TEXTURE_SIZE = 1024;
    public static co_renamed.polarr.renderer.entities.Context LutContext = null;
    public static final int P4_3_OVERLAY_TEXTURE_SIZE = 1000;
    public static co_renamed.polarr.renderer.entities.Mesh overlayMesh;
    public android.content.res.AssetManager assetManager;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[] brushTextures;
    public java.util.Map<java.lang.String, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed> brushes;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed cacheTexture;
    public float[] compositeCoords;
    public float[] compositeResolution;
    public android.content.Context context;
    public float[] cropMatrix;
    public boolean cropMode;
    public float cropScale;
    public a_renamed.a_renamed.b_renamed.c_renamed.g_renamed currentRender;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dehazeTexture;
    public float[][] deltaVertices;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed denoiseTexture;
    public a_renamed.a_renamed.b_renamed.f_renamed.t_renamed distortion;
    public float[][] distortionVertices;
    public float downsampleFactor;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed exportTexture;
    public a_renamed.a_renamed.b_renamed.c_renamed.f_renamed[] faceMasks;
    public float fov;
    public a_renamed.a_renamed.b_renamed.c_renamed.b_renamed glRenderView;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed grainTexture;
    public boolean grainTextureBinded;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed imageTexture;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed intermediateTexture;
    public float invFov;
    public boolean isLutRender;
    public boolean isOES;
    public boolean isSDK;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed lensBlurTexture;
    public float margin;
    public float[] margins;
    public float[] matrix;
    public float[] matrixInv;
    public int maxTextureSize;
    public co_renamed.polarr.renderer.entities.Mesh mesh;
    public float minZoom;
    public boolean needUpdateFace;
    public float[] offset;
    public int orientation;
    public co_renamed.polarr.renderer.entities.Context.Overlay overlay;
    public float[] overlayMask;
    public float[] overlayMatrix;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed overlayTexture;
    public boolean overlayTextureBinded;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed paintTexture;
    public java.util.Map<java.lang.String, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed> patterns;
    public float[] perspectiveMatrix;
    public boolean photoLoaded;
    public float[] projectionMatrix;
    public float[] projectionMatrixInv;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed readableTexture;
    public java.util.Map<java.lang.String, java.lang.Object> renderStates;
    public android.content.res.Resources resources;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed retouchTexture;
    public float rotation;
    public float[] rotation90Matrix;
    public float[] rotation90MatrixInv;
    public float[] rotationMatrix;
    public float[] scaleMatrix;
    public co_renamed.polarr.renderer.entities.Context.Screen screen;
    public float[] screenMatrix;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed screenTexture;
    public a_renamed.a_renamed.b_renamed.f_renamed.m_renamed shaderUtil;
    public float[] skinColor;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed tempTexture;
    public java.util.List<a_renamed.a_renamed.b_renamed.c_renamed.d_renamed> textLayers;
    public int[] textures;
    public float[] thresholdAverage;
    public float[] tmpMatrix;
    public float[] translationMatrix;
    public float[] viewMatrix;
    public co_renamed.polarr.renderer.entities.Context.WatermarkOptions watermarkOptions;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed watermarkTexture;
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed writableTexture;
    public float zoom;
    public static float[] backgroundColor = {0.11764706f, 0.11764706f, 0.11764706f};
    public static co_renamed.polarr.renderer.entities.Mesh DefaultMesh = null;

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
        public java.lang.String mosaic_pattern;
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
        public float tx_renamed;
        public float ty_renamed;
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
        public java.lang.String artist;
        public java.lang.String copyright;
        public java.lang.String description;
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
        this.brushTextures = new a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[4];
        this.grainTextureBinded = false;
        this.overlayTextureBinded = false;
        this.matrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.matrixInv = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.perspectiveMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.projectionMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.projectionMatrixInv = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.translationMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.rotationMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.rotation90Matrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.rotation90MatrixInv = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.scaleMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.cropMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.screenMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.viewMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.overlayMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.tmpMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
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
        this.screen = new co_renamed.polarr.renderer.entities.Context.Screen();
        this.watermarkOptions = new co_renamed.polarr.renderer.entities.Context.WatermarkOptions();
        this.textLayers = new java.util.ArrayList();
        this.renderStates = new java.util.HashMap();
        this.needUpdateFace = false;
        this.overlay = new co_renamed.polarr.renderer.entities.Context.Overlay();
        this.distortion = new a_renamed.a_renamed.b_renamed.f_renamed.t_renamed();
        this.photoLoaded = false;
        this.isSDK = false;
        this.isOES = false;
        this.isLutRender = false;
        init();
    }

    public Context(boolean z_renamed) {
        this.textures = new int[0];
        this.brushTextures = new a_renamed.a_renamed.b_renamed.c_renamed.d_renamed[4];
        this.grainTextureBinded = false;
        this.overlayTextureBinded = false;
        this.matrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.matrixInv = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.perspectiveMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.projectionMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.projectionMatrixInv = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.translationMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.rotationMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.rotation90Matrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.rotation90MatrixInv = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.scaleMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.cropMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.screenMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.viewMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.overlayMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
        this.tmpMatrix = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
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
        this.screen = new co_renamed.polarr.renderer.entities.Context.Screen();
        this.watermarkOptions = new co_renamed.polarr.renderer.entities.Context.WatermarkOptions();
        this.textLayers = new java.util.ArrayList();
        this.renderStates = new java.util.HashMap();
        this.needUpdateFace = false;
        this.overlay = new co_renamed.polarr.renderer.entities.Context.Overlay();
        this.distortion = new a_renamed.a_renamed.b_renamed.f_renamed.t_renamed();
        this.photoLoaded = false;
        this.isSDK = false;
        this.isOES = false;
        this.isLutRender = false;
        if (!z_renamed) {
            init();
        } else {
            a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(this.renderStates);
            this.mesh = co_renamed.polarr.renderer.entities.Mesh.plane(new co_renamed.polarr.renderer.entities.Mesh.Options(1));
        }
    }

    private void init() {
        a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(this.renderStates);
        this.mesh = co_renamed.polarr.renderer.entities.Mesh.plane(new co_renamed.polarr.renderer.entities.Mesh.Options(64));
        if (DefaultMesh == null) {
            DefaultMesh = co_renamed.polarr.renderer.entities.Mesh.plane(new co_renamed.polarr.renderer.entities.Mesh.Options(64));
        }
        if (overlayMesh == null) {
            overlayMesh = co_renamed.polarr.renderer.entities.Mesh.plane(new co_renamed.polarr.renderer.entities.Mesh.Options(true, false, false, 32));
        }
        if (LutContext == null) {
            LutContext = new co_renamed.polarr.renderer.entities.Context(true);
            co_renamed.polarr.renderer.entities.Context context = LutContext;
            context.isLutRender = true;
            context.imageTexture = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(0, 6408, 32, 32);
        }
        this.distortionVertices = this.mesh.getDistortionPoints();
        this.deltaVertices = this.mesh.getDeltaPoints();
    }

    public static java.util.Map<java.lang.String, java.lang.Object> makeCompatible(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.HashMap map2 = new java.util.HashMap();
        a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(map2);
        java.util.HashMap map3 = new java.util.HashMap();
        for (java.lang.String str : map.keySet()) {
            java.lang.Object objA = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed(str, map.get(str));
            if (map2.containsKey(str)) {
                map3.put(str, objA);
            }
        }
        java.util.List list = (java.util.List) map3.get("local_adjustments");
        if (list != null) {
            for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
                java.lang.Object obj = list.get(i_renamed);
                if (obj instanceof java.util.HashMap) {
                    co_renamed.polarr.renderer.entities.Adjustment.fromDecodedHashMap((java.util.HashMap) obj).adjustments = new co_renamed.polarr.renderer.entities.Context.LocalState();
                } else if (obj instanceof co_renamed.polarr.renderer.entities.Adjustment) {
                }
            }
        }
        return map3;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> prepareAdjustments(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.util.Map<java.lang.String, java.lang.Object> mapMakeCompatible = makeCompatible(map);
        float[] fArr = (float[]) mapMakeCompatible.get("crop");
        if (fArr != null && java.util.Arrays.equals(fArr, new float[]{0.0f, 0.0f, 1.0f, 1.0f})) {
            mapMakeCompatible.remove("crop");
        }
        mapMakeCompatible.remove("faces");
        mapMakeCompatible.remove("face_features");
        mapMakeCompatible.remove("spots");
        mapMakeCompatible.remove(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_TEXT);
        if (mapMakeCompatible.get("rotation") != null && ((java.lang.Float) mapMakeCompatible.get("rotation")).floatValue() == 0.0f) {
            mapMakeCompatible.remove("rotation");
        }
        mapMakeCompatible.remove("rotate90");
        mapMakeCompatible.remove("distortion_horizontal");
        mapMakeCompatible.remove("distortion_vertical");
        mapMakeCompatible.remove("distortion_mesh");
        return mapMakeCompatible;
    }

    public void reset() {
        this.mesh = co_renamed.polarr.renderer.entities.Mesh.plane(new co_renamed.polarr.renderer.entities.Mesh.Options(64));
        this.distortionVertices = this.mesh.getDistortionPoints();
        this.deltaVertices = this.mesh.getDeltaPoints();
        overlayMesh = co_renamed.polarr.renderer.entities.Mesh.plane(new co_renamed.polarr.renderer.entities.Mesh.Options(true, false, false, 32));
        this.screen = new co_renamed.polarr.renderer.entities.Context.Screen();
        this.textLayers.clear();
        a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(this.renderStates);
    }
}
