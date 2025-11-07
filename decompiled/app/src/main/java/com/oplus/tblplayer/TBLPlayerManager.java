package com.oplus.tblplayer;

/* loaded from: classes2.dex */
public final class TBLPlayerManager {
    private static final java.lang.reflect.Constructor<? extends com.oplus.tblplayer.IMediaPlayer> IJKPLAYER_WRAPPER_CONSTRUCTOR;
    private static final java.lang.String TAG = "TBLPlayerManager";
    public static final int TBL_PLAYER_TYPE_ANDROID = 3;
    public static final int TBL_PLAYER_TYPE_EXO = 0;
    public static final int TBL_PLAYER_TYPE_IJK = 2;
    public static final int TBL_PLAYER_TYPE_REMOTE = 1;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface PlayerType {
    }

    static {
        java.lang.reflect.Constructor<? extends com.oplus.tblplayer.IMediaPlayer> constructor;
        try {
            constructor = java.lang.Class.forName("com.oplus.tblplayer.wrapper.ijk.TBLIjkPlayerWrapper").asSubclass(com.oplus.tblplayer.IMediaPlayer.class).getConstructor(android.content.Context.class);
        } catch (java.lang.ClassNotFoundException unused) {
            constructor = null;
        } catch (java.lang.Exception e_renamed) {
            throw new java.lang.RuntimeException("Error instantiating TBLIjkPlayerWrapper class", e_renamed);
        }
        IJKPLAYER_WRAPPER_CONSTRUCTOR = constructor;
    }

    public static void initGlobals(android.content.Context context, com.oplus.tblplayer.config.GlobalsConfig globalsConfig) {
        com.oplus.tblplayer.config.Globals.maybeInitialize(context.getApplicationContext(), globalsConfig);
    }

    public static com.oplus.tblplayer.IMediaPlayer createPlayer(android.content.Context context) {
        return createPlayerInternal(context, 0, 0, 0);
    }

    public static com.oplus.tblplayer.IMediaPlayer createPlayer(android.content.Context context, int i_renamed, int i2) {
        return createPlayerInternal(context, i_renamed, i2, 0);
    }

    public static com.oplus.tblplayer.IMediaPlayer createPlayer(android.content.Context context, int i_renamed, int i2, int i3) {
        return createPlayerInternal(context, i_renamed, i2, i3);
    }

    private static com.oplus.tblplayer.IMediaPlayer createPlayerInternal(android.content.Context context, int i_renamed, int i2, int i3) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.oplus.tblplayer.config.Globals.maybeInitialize(context, null);
        com.oplus.tblplayer.utils.LogUtil.i_renamed(TAG, "TBLPlayer [1.5.9-GALLERY], [" + com.google.android.exoplayer2.util.Util.DEVICE_DEBUG_INFO + "]");
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "createPlayerInternal: with player type: " + i_renamed + ", with extractor: " + com.oplus.tblplayer.utils.LogUtil.getExtractorTypeString(i3) + ", with codec: " + com.oplus.tblplayer.utils.LogUtil.getRendererTypeString(i2));
        if (i_renamed == 0) {
            com.oplus.tblplayer.TBLExoPlayer tBLExoPlayer = new com.oplus.tblplayer.TBLExoPlayer(context, i2, i3);
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "createPlayer: TBLExoPlayer");
            return tBLExoPlayer;
        }
        if (i_renamed == 1) {
            com.oplus.tblplayer.remote.TBLRemotePlayer tBLRemotePlayer = new com.oplus.tblplayer.remote.TBLRemotePlayer(context);
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "createPlayer: TBLRemotePlayer");
            return tBLRemotePlayer;
        }
        if (i_renamed == 2) {
            java.lang.reflect.Constructor<? extends com.oplus.tblplayer.IMediaPlayer> constructor = IJKPLAYER_WRAPPER_CONSTRUCTOR;
            if (constructor != null) {
                try {
                    com.oplus.tblplayer.IMediaPlayer iMediaPlayerNewInstance = constructor.newInstance(context);
                    com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "createPlayer: TBLIjkPlayerWrapper");
                    return iMediaPlayerNewInstance;
                } catch (java.lang.Exception e_renamed) {
                    throw new java.lang.RuntimeException("Error instantiating TBLIjkPlayerWrapper class", e_renamed);
                }
            }
            throw new java.lang.RuntimeException("Must implementation module lib-ijkplayer");
        }
        throw new java.lang.UnsupportedOperationException("Unsupported player type.");
    }
}
