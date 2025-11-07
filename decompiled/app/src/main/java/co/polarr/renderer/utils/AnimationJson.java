package co_renamed.polarr.renderer.utils;

/* loaded from: classes.dex */
public class AnimationJson {
    public static final java.lang.String BLENDING_MODE_MULTIPLY = "multiply";
    public static final java.lang.String BLENDING_MODE_NORMAL = "normal";
    public static final java.lang.String BLENDING_MODE_OVERLAY = "overlay";
    public static final java.lang.String BLENDING_MODE_SCREEN = "screen";
    public java.lang.String platform;
    public co_renamed.polarr.renderer.utils.AnimationJson.Sprite[] sprites;
    public java.lang.String version;

    public static class Animation {
        public int animationId;
        public java.lang.String blendingMode;
        public float[] center;
        public int imageId;
        public float opacity;
        public float rotation;
        public float scale;
        public long timeInMS;
        public boolean visibility;

        public Animation() {
            this.animationId = 0;
            this.imageId = 0;
            this.timeInMS = 0L;
            this.visibility = false;
            this.center = new float[]{0.0f, 0.0f};
            this.scale = 1.0f;
            this.rotation = 0.0f;
            this.opacity = 1.0f;
        }

        public Animation(int i_renamed, int i2, int i3, boolean z_renamed, float f_renamed, float f2, float f3, float f4, float f5, a_renamed.a_renamed.b_renamed.f_renamed.x_renamed xVar) {
            this.animationId = 0;
            this.imageId = 0;
            this.timeInMS = 0L;
            this.visibility = false;
            this.center = new float[]{0.0f, 0.0f};
            this.scale = 1.0f;
            this.rotation = 0.0f;
            this.opacity = 1.0f;
            this.animationId = i_renamed;
            this.imageId = i2;
            this.timeInMS = i3;
            this.visibility = z_renamed;
            float[] fArr = this.center;
            fArr[0] = f_renamed;
            fArr[1] = f2;
            this.scale = f3;
            this.rotation = f4;
            this.opacity = f5;
            int i4 = co_renamed.polarr.renderer.utils.AnimationJson.porender_YuvEf.f1954a[xVar.ordinal()];
            this.blendingMode = i4 != 1 ? i4 != 2 ? i4 != 3 ? "normal" : co_renamed.polarr.renderer.utils.AnimationJson.BLENDING_MODE_OVERLAY : co_renamed.polarr.renderer.utils.AnimationJson.BLENDING_MODE_SCREEN : co_renamed.polarr.renderer.utils.AnimationJson.BLENDING_MODE_MULTIPLY;
        }

        /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x0039  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a_renamed.a_renamed.b_renamed.f_renamed.x_renamed getBlendingMode() {
            /*
                r4 = this;
                java.lang.String r4 = r4.blendingMode
                java.lang.String r4 = r4.toLowerCase()
                int r0 = r4.hashCode()
                r1 = 2
                r2 = 1
                r3 = 3
                switch(r0) {
                    case -1091287984: goto L2f;
                    case -1039745817: goto L25;
                    case -907689876: goto L1b;
                    case 653829668: goto L11;
                    default: goto L10;
                }
            L10:
                goto L39
            L11:
                java.lang.String r0 = "multiply"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L39
                r4 = r1
                goto L3a
            L1b:
                java.lang.String r0 = "screen"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L39
                r4 = r2
                goto L3a
            L25:
                java.lang.String r0 = "normal"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L39
                r4 = 0
                goto L3a
            L2f:
                java.lang.String r0 = "overlay"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L39
                r4 = r3
                goto L3a
            L39:
                r4 = -1
            L3a:
                if (r4 == 0) goto L4e
                if (r4 == r2) goto L4b
                if (r4 == r1) goto L48
                if (r4 == r3) goto L45
                a_renamed.a_renamed.b_renamed.f_renamed.x_renamed r4 = a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.NORMAL
                return r4
            L45:
                a_renamed.a_renamed.b_renamed.f_renamed.x_renamed r4 = a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.OVERLAY
                return r4
            L48:
                a_renamed.a_renamed.b_renamed.f_renamed.x_renamed r4 = a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.MULTIPLY
                return r4
            L4b:
                a_renamed.a_renamed.b_renamed.f_renamed.x_renamed r4 = a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.SCREEN
                return r4
            L4e:
                a_renamed.a_renamed.b_renamed.f_renamed.x_renamed r4 = a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.NORMAL
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: co_renamed.polarr.renderer.utils.AnimationJson.Animation.getBlendingMode():a_renamed.a_renamed.b_renamed.f_renamed.x_renamed");
        }

        public android.graphics.PointF getCenter() {
            float[] fArr = this.center;
            return (fArr == null || fArr.length < 2) ? new android.graphics.PointF(0.0f, 0.0f) : new android.graphics.PointF(fArr[0], fArr[1]);
        }

        public int getId() {
            return this.animationId;
        }

        public int getImageId() {
            return this.imageId;
        }

        public float getOpacity() {
            return this.opacity;
        }

        public float getRotation() {
            return this.rotation;
        }

        public float getScale() {
            return this.scale;
        }

        public long getTimeInMS() {
            return this.timeInMS;
        }

        public boolean isVisibility() {
            return this.visibility;
        }
    }

    public static class ImageItem {
        public int imageId = 0;
        public java.lang.String path;

        public int getImageId() {
            return this.imageId;
        }

        public java.lang.String getPath() {
            return this.path;
        }
    }

    public static class Sprite {
        public co_renamed.polarr.renderer.utils.AnimationJson.Animation[] animation;
        public co_renamed.polarr.renderer.utils.AnimationJson.ImageItem[] imageList;
        public int spriteId = 0;
        public float maxWidth = 0.0f;
        public float maxHeight = 0.0f;
        public boolean repeat = false;

        public co_renamed.polarr.renderer.utils.AnimationJson.Animation[] getAnimations() {
            return this.animation;
        }

        public java.util.Map<java.lang.Integer, java.lang.String> getImageList() {
            if (this.imageList == null) {
                return null;
            }
            java.util.HashMap map = new java.util.HashMap();
            for (co_renamed.polarr.renderer.utils.AnimationJson.ImageItem imageItem : this.imageList) {
                map.put(java.lang.Integer.valueOf(imageItem.imageId), imageItem.path);
            }
            return map;
        }

        public float getMaxHeight() {
            return this.maxHeight;
        }

        public float getMaxWidth() {
            return this.maxWidth;
        }

        public int getSpriteId() {
            return this.spriteId;
        }

        public boolean isRepeat() {
            return this.repeat;
        }
    }

    public static /* synthetic */ class porender_YuvEf {

        /* renamed from: a_renamed, reason: collision with root package name */
        public static final /* synthetic */ int[] f1954a = new int[a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.values().length];

        static {
            try {
                f1954a[a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.MULTIPLY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f1954a[a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.SCREEN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f1954a[a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.OVERLAY.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f1954a[a_renamed.a_renamed.b_renamed.f_renamed.x_renamed.NORMAL.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public static co_renamed.polarr.renderer.utils.AnimationJson fromJson(java.io.Reader reader) {
        return (co_renamed.polarr.renderer.utils.AnimationJson) new com.google.gson.Gson().fromJson(reader, co_renamed.polarr.renderer.utils.AnimationJson.class);
    }

    public java.lang.String getPlatform() {
        return this.platform;
    }

    public co_renamed.polarr.renderer.utils.AnimationJson.Sprite[] getSprites() {
        return this.sprites;
    }

    public java.lang.String getVersion() {
        return this.version;
    }
}
