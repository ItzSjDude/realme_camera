package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsCustomVideoFx {

    public static class RenderContext {
        public long effectEndTime;
        public long effectStartTime;
        public long effectTime;
        public boolean hasBuddyVideoFrame;
        public com.meicam.sdk.NvsCustomVideoFx.RenderHelper helper;
        public com.meicam.sdk.NvsVideoFrameInfo inputBuddyVideoFrameInfo;
        public java.nio.ByteBuffer inputBuddyVideoFramebuffer;
        public com.meicam.sdk.NvsCustomVideoFx.VideoFrame inputVideoFrame;
        public com.meicam.sdk.NvsCustomVideoFx.VideoFrame outputVideoFrame;
    }

    public interface RenderHelper {
        int allocateRGBATexture(int i_renamed, int i2);

        void reclaimTexture(int i_renamed);
    }

    public interface Renderer {
        void onCleanup();

        void onInit();

        void onPreloadResources();

        void onRender(com.meicam.sdk.NvsCustomVideoFx.RenderContext renderContext);
    }

    public static class VideoFrame {
        public int height;
        public boolean isUpsideDownTexture;
        public int texId;
        public int width;
    }
}
