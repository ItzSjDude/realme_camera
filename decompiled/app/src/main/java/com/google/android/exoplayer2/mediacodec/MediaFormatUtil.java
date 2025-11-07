package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.List;

@TargetApi(16)
/* loaded from: classes.dex */
public final class MediaFormatUtil {
    private MediaFormatUtil() {
    }

    public static void setString(MediaFormat mediaFormat, String str, String str2) {
        mediaFormat.setString(str, str2);
    }

    public static void setCsdBuffers(MediaFormat mediaFormat, List<byte[]> list) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            mediaFormat.setByteBuffer("csd-" + OplusGLSurfaceView_13, ByteBuffer.wrap(list.get(OplusGLSurfaceView_13)));
        }
    }

    public static void maybeSetInteger(MediaFormat mediaFormat, String str, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != -1) {
            mediaFormat.setInteger(str, OplusGLSurfaceView_13);
        }
    }

    public static void maybeSetFloat(MediaFormat mediaFormat, String str, float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 != -1.0f) {
            mediaFormat.setFloat(str, COUIBaseListPopupWindow_12);
        }
    }

    public static void maybeSetByteBuffer(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void maybeSetColorInfo(MediaFormat mediaFormat, ColorInfo colorInfo) {
        if (colorInfo != null) {
            maybeSetInteger(mediaFormat, "color-transfer", colorInfo.colorTransfer);
            maybeSetInteger(mediaFormat, "color-standard", colorInfo.colorSpace);
            maybeSetInteger(mediaFormat, "color-range", colorInfo.colorRange);
            maybeSetByteBuffer(mediaFormat, "hdr-static-info", colorInfo.hdrStaticInfo);
        }
    }
}
