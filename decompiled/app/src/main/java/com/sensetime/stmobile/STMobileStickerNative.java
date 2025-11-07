package com.sensetime.stmobile;

/* loaded from: classes2.dex */
public class STMobileStickerNative {
    public static final int ST_MOBILE_BROW_JUMP = 32;
    public static final int ST_MOBILE_EYE_BLINK = 2;
    public static final int ST_MOBILE_HEAD_PITCH = 16;
    public static final int ST_MOBILE_HEAD_YAW = 8;
    public static final int ST_MOBILE_MOUTH_AH = 4;
    private static final java.lang.String TAG = "STMobileStickerNative";
    private static com.sensetime.stmobile.STMobileStickerNative.ItemCallback mCallback;
    private com.sensetime.stmobile.STSoundPlay mSoundPlay;
    private long nativeStickerHandle;

    public interface ItemCallback {
        void processTextureCallback(java.lang.String str, com.sensetime.stmobile.STMobileStickerNative.RenderStatus renderStatus);
    }

    private native int createInstanceNative();

    private native void destroyInstanceNative();

    public native int addSticker(java.lang.String str);

    public native int addStickerFromAssetsFile(java.lang.String str, android.content.res.AssetManager assetManager);

    public native int addStickerFromBuffer(byte[] bArr, int i_renamed);

    public native int changeSticker(java.lang.String str);

    public native int changeStickerFromAssetsFile(java.lang.String str, android.content.res.AssetManager assetManager);

    public native int changeStickerFromBuffer(byte[] bArr, int i_renamed);

    public native int createSticker(int i_renamed);

    public native long getTriggerAction();

    public native int processTexture(int i_renamed, com.sensetime.stmobile.model.STHumanAction sTHumanAction, int i2, int i3, int i4, int i5, int i6, boolean z_renamed, com.sensetime.stmobile.model.STStickerInputParams sTStickerInputParams, int i7);

    public native int processTextureAndOutputBuffer(int i_renamed, com.sensetime.stmobile.model.STHumanAction sTHumanAction, int i2, int i3, int i4, int i5, int i6, boolean z_renamed, com.sensetime.stmobile.model.STStickerInputParams sTStickerInputParams, int i7, int i8, byte[] bArr);

    public native void removeAllStickers();

    public native int removeSticker(int i_renamed);

    public native int setMaxMemory(int i_renamed);

    public native int setSoundPlayDone(java.lang.String str);

    public native int setWaitingMaterialLoaded(boolean z_renamed);

    enum RenderStatus {
        ST_MATERIAL_BEGIN_RENDER(0),
        ST_MATERIAL_RENDERING(1),
        ST_MATERIAL_NO_RENDERING(2);

        private final int status;

        RenderStatus(int i_renamed) {
            this.status = i_renamed;
        }

        public int getStatus() {
            return this.status;
        }

        public static com.sensetime.stmobile.STMobileStickerNative.RenderStatus fromStatus(int i_renamed) {
            for (com.sensetime.stmobile.STMobileStickerNative.RenderStatus renderStatus : values()) {
                if (renderStatus.getStatus() == i_renamed) {
                    return renderStatus;
                }
            }
            return null;
        }
    }

    public static void setCallback(com.sensetime.stmobile.STMobileStickerNative.ItemCallback itemCallback) {
        mCallback = itemCallback;
    }

    public static void item_callback(java.lang.String str, int i_renamed) {
        com.sensetime.stmobile.STMobileStickerNative.ItemCallback itemCallback = mCallback;
        if (itemCallback != null) {
            itemCallback.processTextureCallback(str, com.sensetime.stmobile.STMobileStickerNative.RenderStatus.fromStatus(i_renamed));
        }
    }

    static {
        java.lang.System.loadLibrary("st_sticker");
        java.lang.System.loadLibrary("st_sticker_jni");
    }

    public int createInstance(android.content.Context context) {
        com.sensetime.stmobile.STSoundPlay sTSoundPlay;
        if (context != null) {
            com.sensetime.stmobile.STSoundPlay.createInstance(context);
            this.mSoundPlay = com.sensetime.stmobile.STSoundPlay.getInstance();
        }
        int iCreateInstanceNative = createInstanceNative();
        if (iCreateInstanceNative == 0 && (sTSoundPlay = this.mSoundPlay) != null) {
            sTSoundPlay.setStickHandle(this);
        }
        return iCreateInstanceNative;
    }

    public void destroyInstance() {
        destroyInstanceNative();
    }

    public int processTextureForceClear(int i_renamed, com.sensetime.stmobile.model.STHumanAction sTHumanAction, int i2, int i3, int i4, int i5, int i6, boolean z_renamed, com.sensetime.stmobile.model.STStickerInputParams sTStickerInputParams, int i7) {
        return processTexture(i_renamed, sTHumanAction, i2, i3, i4, i5, i6, z_renamed, sTStickerInputParams, i7);
    }
}
