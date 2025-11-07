package com.oplus.tblplayer.misc;

/* loaded from: classes2.dex */
public interface IMediaFormat {
    public static final java.lang.String KEY_BIT_RATE = "bitrate";
    public static final java.lang.String KEY_FRAME_RATE = "frame-rate";
    public static final java.lang.String KEY_HEIGHT = "height";
    public static final java.lang.String KEY_MIME = "mime";
    public static final java.lang.String KEY_WIDTH = "width";

    int getInteger(java.lang.String str);

    java.lang.String getString(java.lang.String str);
}
