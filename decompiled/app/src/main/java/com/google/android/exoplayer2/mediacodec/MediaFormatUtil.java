package com.google.android.exoplayer2.mediacodec;

@android.annotation.TargetApi(16)
/* loaded from: classes.dex */
public final class MediaFormatUtil {
    private MediaFormatUtil() {
    }

    public static void setString(android.media.MediaFormat mediaFormat, java.lang.String str, java.lang.String str2) {
        mediaFormat.setString(str, str2);
    }

    public static void setCsdBuffers(android.media.MediaFormat mediaFormat, java.util.List<byte[]> list) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            mediaFormat.setByteBuffer("csd-" + i_renamed, java.nio.ByteBuffer.wrap(list.get(i_renamed)));
        }
    }

    public static void maybeSetInteger(android.media.MediaFormat mediaFormat, java.lang.String str, int i_renamed) {
        if (i_renamed != -1) {
            mediaFormat.setInteger(str, i_renamed);
        }
    }

    public static void maybeSetFloat(android.media.MediaFormat mediaFormat, java.lang.String str, float f_renamed) {
        if (f_renamed != -1.0f) {
            mediaFormat.setFloat(str, f_renamed);
        }
    }

    public static void maybeSetByteBuffer(android.media.MediaFormat mediaFormat, java.lang.String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, java.nio.ByteBuffer.wrap(bArr));
        }
    }

    public static void maybeSetColorInfo(android.media.MediaFormat mediaFormat, com.google.android.exoplayer2.video.ColorInfo colorInfo) {
        if (colorInfo != null) {
            maybeSetInteger(mediaFormat, "color-transfer", colorInfo.colorTransfer);
            maybeSetInteger(mediaFormat, "color-standard", colorInfo.colorSpace);
            maybeSetInteger(mediaFormat, "color-range", colorInfo.colorRange);
            maybeSetByteBuffer(mediaFormat, "hdr-static-info", colorInfo.hdrStaticInfo);
        }
    }
}
