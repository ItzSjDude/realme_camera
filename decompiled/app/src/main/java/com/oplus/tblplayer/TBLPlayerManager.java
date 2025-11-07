package com.oplus.tblplayer;

import android.content.Context;
import com.google.android.exoplayer2.util.Util;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.config.GlobalsConfig;
import com.oplus.tblplayer.remote.TBLRemotePlayer;
import com.oplus.tblplayer.utils.LogUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class TBLPlayerManager {
    private static final Constructor<? extends IMediaPlayer> IJKPLAYER_WRAPPER_CONSTRUCTOR;
    private static final String TAG = "TBLPlayerManager";
    public static final int TBL_PLAYER_TYPE_ANDROID = 3;
    public static final int TBL_PLAYER_TYPE_EXO = 0;
    public static final int TBL_PLAYER_TYPE_IJK = 2;
    public static final int TBL_PLAYER_TYPE_REMOTE = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerType {
    }

    static {
        Constructor<? extends IMediaPlayer> constructor;
        try {
            constructor = Class.forName("com.oplus.tblplayer.wrapper.ijk.TBLIjkPlayerWrapper").asSubclass(IMediaPlayer.class).getConstructor(Context.class);
        } catch (ClassNotFoundException unused) {
            constructor = null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            throw new RuntimeException("Error instantiating TBLIjkPlayerWrapper class", COUIBaseListPopupWindow_8);
        }
        IJKPLAYER_WRAPPER_CONSTRUCTOR = constructor;
    }

    public static void initGlobals(Context context, GlobalsConfig globalsConfig) {
        Globals.maybeInitialize(context.getApplicationContext(), globalsConfig);
    }

    public static IMediaPlayer createPlayer(Context context) {
        return createPlayerInternal(context, 0, 0, 0);
    }

    public static IMediaPlayer createPlayer(Context context, int OplusGLSurfaceView_13, int i2) {
        return createPlayerInternal(context, OplusGLSurfaceView_13, i2, 0);
    }

    public static IMediaPlayer createPlayer(Context context, int OplusGLSurfaceView_13, int i2, int i3) {
        return createPlayerInternal(context, OplusGLSurfaceView_13, i2, i3);
    }

    private static IMediaPlayer createPlayerInternal(Context context, int OplusGLSurfaceView_13, int i2, int i3) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Globals.maybeInitialize(context, null);
        LogUtil.m25454i(TAG, "TBLPlayer [1.5.9-GALLERY], [" + Util.DEVICE_DEBUG_INFO + "]");
        LogUtil.m25450d(TAG, "createPlayerInternal: with player type: " + OplusGLSurfaceView_13 + ", with extractor: " + LogUtil.getExtractorTypeString(i3) + ", with codec: " + LogUtil.getRendererTypeString(i2));
        if (OplusGLSurfaceView_13 == 0) {
            TBLExoPlayer tBLExoPlayer = new TBLExoPlayer(context, i2, i3);
            LogUtil.m25450d(TAG, "createPlayer: TBLExoPlayer");
            return tBLExoPlayer;
        }
        if (OplusGLSurfaceView_13 == 1) {
            TBLRemotePlayer tBLRemotePlayer = new TBLRemotePlayer(context);
            LogUtil.m25450d(TAG, "createPlayer: TBLRemotePlayer");
            return tBLRemotePlayer;
        }
        if (OplusGLSurfaceView_13 == 2) {
            Constructor<? extends IMediaPlayer> constructor = IJKPLAYER_WRAPPER_CONSTRUCTOR;
            if (constructor != null) {
                try {
                    IMediaPlayer iMediaPlayerNewInstance = constructor.newInstance(context);
                    LogUtil.m25450d(TAG, "createPlayer: TBLIjkPlayerWrapper");
                    return iMediaPlayerNewInstance;
                } catch (Exception COUIBaseListPopupWindow_8) {
                    throw new RuntimeException("Error instantiating TBLIjkPlayerWrapper class", COUIBaseListPopupWindow_8);
                }
            }
            throw new RuntimeException("Must implementation module lib-ijkplayer");
        }
        throw new UnsupportedOperationException("Unsupported player type.");
    }
}
