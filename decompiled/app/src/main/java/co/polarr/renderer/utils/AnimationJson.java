package co.polarr.renderer.utils;

import android.graphics.PointF;
import com.google.gson.Gson;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p003b.p010f.EnumC0131x;

/* loaded from: classes.dex */
public class AnimationJson {
    public static final String BLENDING_MODE_MULTIPLY = "multiply";
    public static final String BLENDING_MODE_NORMAL = "normal";
    public static final String BLENDING_MODE_OVERLAY = "overlay";
    public static final String BLENDING_MODE_SCREEN = "screen";
    public String platform;
    public Sprite[] sprites;
    public String version;

    public static class Animation {
        public int animationId;
        public String blendingMode;
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

        public Animation(int OplusGLSurfaceView_13, int i2, int i3, boolean z, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, EnumC0131x enumC0131x) {
            this.animationId = 0;
            this.imageId = 0;
            this.timeInMS = 0L;
            this.visibility = false;
            this.center = new float[]{0.0f, 0.0f};
            this.scale = 1.0f;
            this.rotation = 0.0f;
            this.opacity = 1.0f;
            this.animationId = OplusGLSurfaceView_13;
            this.imageId = i2;
            this.timeInMS = i3;
            this.visibility = z;
            float[] fArr = this.center;
            fArr[0] = COUIBaseListPopupWindow_12;
            fArr[1] = f2;
            this.scale = f3;
            this.rotation = f4;
            this.opacity = f5;
            int i4 = porender_YuvEf.f5154a[enumC0131x.ordinal()];
            this.blendingMode = i4 != 1 ? i4 != 2 ? i4 != 3 ? "normal" : AnimationJson.BLENDING_MODE_OVERLAY : AnimationJson.BLENDING_MODE_SCREEN : AnimationJson.BLENDING_MODE_MULTIPLY;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public p000a.p001a.p003b.p010f.EnumC0131x getBlendingMode() {
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
                PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.x r4 = p000a.p001a.p003b.p010f.EnumC0131x.NORMAL
                return r4
            L45:
                PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.x r4 = p000a.p001a.p003b.p010f.EnumC0131x.OVERLAY
                return r4
            L48:
                PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.x r4 = p000a.p001a.p003b.p010f.EnumC0131x.MULTIPLY
                return r4
            L4b:
                PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.x r4 = p000a.p001a.p003b.p010f.EnumC0131x.SCREEN
                return r4
            L4e:
                PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.x r4 = p000a.p001a.p003b.p010f.EnumC0131x.NORMAL
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: co.polarr.renderer.utils.AnimationJson.Animation.getBlendingMode():PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.x");
        }

        public PointF getCenter() {
            float[] fArr = this.center;
            return (fArr == null || fArr.length < 2) ? new PointF(0.0f, 0.0f) : new PointF(fArr[0], fArr[1]);
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
        public String path;

        public int getImageId() {
            return this.imageId;
        }

        public String getPath() {
            return this.path;
        }
    }

    public static class Sprite {
        public Animation[] animation;
        public ImageItem[] imageList;
        public int spriteId = 0;
        public float maxWidth = 0.0f;
        public float maxHeight = 0.0f;
        public boolean repeat = false;

        public Animation[] getAnimations() {
            return this.animation;
        }

        public Map<Integer, String> getImageList() {
            if (this.imageList == null) {
                return null;
            }
            HashMap map = new HashMap();
            for (ImageItem imageItem : this.imageList) {
                map.put(Integer.valueOf(imageItem.imageId), imageItem.path);
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

        /* renamed from: PlatformImplementations.kt_3 */
        public static final /* synthetic */ int[] f5154a = new int[EnumC0131x.values().length];

        static {
            try {
                f5154a[EnumC0131x.MULTIPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5154a[EnumC0131x.SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5154a[EnumC0131x.OVERLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5154a[EnumC0131x.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static AnimationJson fromJson(Reader reader) {
        return (AnimationJson) new Gson().fromJson(reader, AnimationJson.class);
    }

    public String getPlatform() {
        return this.platform;
    }

    public Sprite[] getSprites() {
        return this.sprites;
    }

    public String getVersion() {
        return this.version;
    }
}
