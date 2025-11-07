package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public class FFmpegMediaMetadataRetriever {
    public static android.graphics.Bitmap.Config IN_PREFERRED_CONFIG = null;
    public static final java.lang.String METADATA_CHAPTER_COUNT = "chapter_count";
    public static final java.lang.String METADATA_KEY_ALBUM = "album";
    public static final java.lang.String METADATA_KEY_ALBUM_ARTIST = "album_artist";
    public static final java.lang.String METADATA_KEY_ARTIST = "artist";
    public static final java.lang.String METADATA_KEY_AUDIO_CODEC = "audio_codec";
    public static final java.lang.String METADATA_KEY_CHAPTER_END_TIME = "chapter_end_time";
    public static final java.lang.String METADATA_KEY_CHAPTER_START_TIME = "chapter_start_time";
    public static final java.lang.String METADATA_KEY_COLOR_RANGE = "color_range";
    public static final java.lang.String METADATA_KEY_COLOR_STANDARD = "color_standard";
    public static final java.lang.String METADATA_KEY_COLOR_TRANSFER = "color_transfer";
    public static final java.lang.String METADATA_KEY_COMMENT = "comment";
    public static final java.lang.String METADATA_KEY_COMPOSER = "composer";
    public static final java.lang.String METADATA_KEY_COPYRIGHT = "copyright";
    public static final java.lang.String METADATA_KEY_CREATION_TIME = "creation_time";
    public static final java.lang.String METADATA_KEY_DATE = "date";
    public static final java.lang.String METADATA_KEY_DISC = "disc";
    public static final java.lang.String METADATA_KEY_DISPLAY_ROTATION = "display_rotate";
    public static final java.lang.String METADATA_KEY_DURATION = "duration";
    public static final java.lang.String METADATA_KEY_ENCODED_BY = "encoded_by";
    public static final java.lang.String METADATA_KEY_ENCODER = "encoder";
    public static final java.lang.String METADATA_KEY_FILENAME = "filename";
    public static final java.lang.String METADATA_KEY_FILESIZE = "filesize";
    public static final java.lang.String METADATA_KEY_FRAMERATE = "framerate";
    public static final java.lang.String METADATA_KEY_GENRE = "genre";
    public static final java.lang.String METADATA_KEY_ICY_METADATA = "icy_metadata";
    public static final java.lang.String METADATA_KEY_LANGUAGE = "language";
    public static final java.lang.String METADATA_KEY_PERFORMER = "performer";
    public static final java.lang.String METADATA_KEY_PUBLISHER = "publisher";
    public static final java.lang.String METADATA_KEY_SERVICE_NAME = "service_name";
    public static final java.lang.String METADATA_KEY_SERVICE_PROVIDER = "service_provider";
    public static final java.lang.String METADATA_KEY_TITLE = "title";
    public static final java.lang.String METADATA_KEY_TRACK = "track";
    public static final java.lang.String METADATA_KEY_VARIANT_BITRATE = "bitrate";
    public static final java.lang.String METADATA_KEY_VIDEO_CODEC = "video_codec";
    public static final java.lang.String METADATA_KEY_VIDEO_FRAME_COUNT = "video_frame_count";
    public static final java.lang.String METADATA_KEY_VIDEO_HEIGHT = "video_height";
    public static final java.lang.String METADATA_KEY_VIDEO_ROTATION = "rotate";
    public static final java.lang.String METADATA_KEY_VIDEO_WIDTH = "video_width";
    public static final int OPTION_CLOSEST = 3;
    public static final int OPTION_CLOSEST_SYNC = 2;
    public static final int OPTION_NEXT_SYNC = 1;
    public static final int OPTION_PREVIOUS_SYNC = 0;
    private static final java.lang.String TAG = "FFMediaMetaRetriever";
    private long mNativeContext;

    private native byte[] _getFrameAtTime(long j_renamed, int i_renamed);

    private native byte[] _getScaledFrameAtTime(long j_renamed, int i_renamed, int i2, int i3, boolean z_renamed);

    private native void _setDataSource(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2) throws java.lang.IllegalArgumentException;

    private final native void native_finalize();

    private final native java.util.HashMap<java.lang.String, java.lang.String> native_getMetadata(boolean z_renamed, boolean z2, java.util.HashMap<java.lang.String, java.lang.String> map);

    private static native void native_init();

    private native void native_setup();

    public native java.lang.String extractMetadata(java.lang.String str);

    public native java.lang.String extractMetadataFromChapter(java.lang.String str, int i_renamed);

    public native byte[] getEmbeddedPicture();

    public native void release();

    public native void setDataSource(java.io.FileDescriptor fileDescriptor, long j_renamed, long j2) throws java.lang.IllegalArgumentException;

    public native void setDataSource(java.lang.String str) throws java.lang.IllegalArgumentException;

    public native void setSurface(java.lang.Object obj);

    public FFmpegMediaMetadataRetriever() throws com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetrieverException {
        com.oplus.tblplayer.ffmpeg.FfmpegLibrary.isAvailable();
        native_init();
        native_setup();
    }

    public void setDataSource(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) throws java.lang.IllegalArgumentException {
        java.lang.String[] strArr = new java.lang.String[map.size()];
        java.lang.String[] strArr2 = new java.lang.String[map.size()];
        int i_renamed = 0;
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            strArr[i_renamed] = entry.getKey();
            strArr2[i_renamed] = entry.getValue();
            i_renamed++;
        }
        _setDataSource(str, strArr, strArr2);
    }

    public void setDataSource(java.io.FileDescriptor fileDescriptor) throws java.lang.IllegalArgumentException {
        setDataSource(fileDescriptor, 0L, 576460752303423487L);
    }

    public void setDataSource(android.content.Context context, android.net.Uri uri) throws java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        if (uri == null) {
            throw new java.lang.IllegalArgumentException();
        }
        java.lang.String scheme = uri.getScheme();
        if (scheme == null || scheme.equals("file")) {
            setDataSource(uri.getPath());
            return;
        }
        android.content.res.AssetFileDescriptor assetFileDescriptor = null;
        try {
            try {
                android.content.res.AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r_renamed");
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    throw new java.lang.IllegalArgumentException();
                }
                java.io.FileDescriptor fileDescriptor = assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor();
                if (!fileDescriptor.valid()) {
                    throw new java.lang.IllegalArgumentException();
                }
                if (assetFileDescriptorOpenAssetFileDescriptor.getDeclaredLength() < 0) {
                    setDataSource(fileDescriptor);
                } else {
                    setDataSource(fileDescriptor, assetFileDescriptorOpenAssetFileDescriptor.getStartOffset(), assetFileDescriptorOpenAssetFileDescriptor.getDeclaredLength());
                }
                if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                    try {
                        assetFileDescriptorOpenAssetFileDescriptor.close();
                    } catch (java.io.IOException unused) {
                    }
                }
            } catch (java.io.FileNotFoundException unused2) {
                throw new java.lang.IllegalArgumentException();
            }
        } catch (java.lang.SecurityException unused3) {
            if (0 != 0) {
                try {
                    assetFileDescriptor.close();
                } catch (java.io.IOException unused4) {
                }
            }
            setDataSource(uri.toString());
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                try {
                    assetFileDescriptor.close();
                } catch (java.io.IOException unused5) {
                }
            }
            throw th;
        }
    }

    public com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.Metadata getMetadata() {
        com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.Metadata metadata = new com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.Metadata();
        java.util.HashMap<java.lang.String, java.lang.String> mapNative_getMetadata = native_getMetadata(false, false, null);
        if (mapNative_getMetadata != null && metadata.parse(mapNative_getMetadata)) {
            return metadata;
        }
        return null;
    }

    public android.graphics.Bitmap getFrameAtTime(long j_renamed, int i_renamed) {
        if (i_renamed < 0 || i_renamed > 3) {
            throw new java.lang.IllegalArgumentException("Unsupported option: " + i_renamed);
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inDither = false;
        byte[] bArr_getFrameAtTime = _getFrameAtTime(j_renamed, i_renamed);
        if (bArr_getFrameAtTime != null) {
            return android.graphics.BitmapFactory.decodeByteArray(bArr_getFrameAtTime, 0, bArr_getFrameAtTime.length, options);
        }
        return null;
    }

    public android.graphics.Bitmap getFrameAtTime(long j_renamed) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inDither = false;
        byte[] bArr_getFrameAtTime = _getFrameAtTime(j_renamed, 2);
        if (bArr_getFrameAtTime != null) {
            return android.graphics.BitmapFactory.decodeByteArray(bArr_getFrameAtTime, 0, bArr_getFrameAtTime.length, options);
        }
        return null;
    }

    public android.graphics.Bitmap getFrameAtTime() {
        return getFrameAtTime(-1L, 2);
    }

    public android.graphics.Bitmap getScaledFrameAtTime(long j_renamed, int i_renamed, int i2, int i3, boolean z_renamed) {
        if (i_renamed < 0 || i_renamed > 3) {
            throw new java.lang.IllegalArgumentException("Unsupported option: " + i_renamed);
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inDither = false;
        byte[] bArr_getScaledFrameAtTime = _getScaledFrameAtTime(j_renamed, i_renamed, i2, i3, z_renamed);
        if (bArr_getScaledFrameAtTime != null) {
            return android.graphics.BitmapFactory.decodeByteArray(bArr_getScaledFrameAtTime, 0, bArr_getScaledFrameAtTime.length, options);
        }
        return null;
    }

    public android.graphics.Bitmap getScaledFrameAtTime(long j_renamed, int i_renamed, int i2) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inDither = false;
        byte[] bArr_getScaledFrameAtTime = _getScaledFrameAtTime(j_renamed, 2, i_renamed, i2, false);
        if (bArr_getScaledFrameAtTime != null) {
            return android.graphics.BitmapFactory.decodeByteArray(bArr_getScaledFrameAtTime, 0, bArr_getScaledFrameAtTime.length, options);
        }
        return null;
    }

    protected void finalize() throws java.lang.Throwable {
        try {
            native_finalize();
        } finally {
            super.finalize();
        }
    }

    public class Metadata {
        public static final int BOOLEAN_VAL = 3;
        public static final int BYTE_ARRAY_VAL = 7;
        public static final int DATE_VAL = 6;
        public static final int DOUBLE_VAL = 5;
        public static final int INTEGER_VAL = 2;
        public static final int LONG_VAL = 4;
        public static final int STRING_VAL = 1;
        private java.util.HashMap<java.lang.String, java.lang.String> mParcel;

        private boolean checkMetadataId(java.lang.String str) {
            return true;
        }

        public Metadata() {
        }

        public boolean parse(java.util.HashMap<java.lang.String, java.lang.String> map) {
            if (map == null) {
                return false;
            }
            this.mParcel = map;
            return true;
        }

        public boolean has(java.lang.String str) {
            if (!checkMetadataId(str)) {
                throw new java.lang.IllegalArgumentException("Invalid key: " + str);
            }
            return this.mParcel.containsKey(str);
        }

        public java.util.HashMap<java.lang.String, java.lang.String> getAll() {
            return this.mParcel;
        }

        public java.lang.String getString(java.lang.String str) {
            checkType(str, 1);
            return java.lang.String.valueOf(this.mParcel.get(str));
        }

        public int getInt(java.lang.String str) {
            checkType(str, 2);
            return java.lang.Integer.valueOf(this.mParcel.get(str)).intValue();
        }

        public boolean getBoolean(java.lang.String str) {
            checkType(str, 3);
            return java.lang.Integer.valueOf(this.mParcel.get(str)).intValue() == 1;
        }

        public long getLong(java.lang.String str) {
            checkType(str, 4);
            return java.lang.Long.valueOf(this.mParcel.get(str)).longValue();
        }

        public double getDouble(java.lang.String str) {
            checkType(str, 5);
            return java.lang.Double.valueOf(this.mParcel.get(str)).doubleValue();
        }

        public byte[] getByteArray(java.lang.String str) {
            checkType(str, 7);
            return this.mParcel.get(str).getBytes();
        }

        public java.util.Date getDate(java.lang.String str) {
            checkType(str, 6);
            long jLongValue = java.lang.Long.valueOf(this.mParcel.get(str)).longValue();
            java.lang.String str2 = this.mParcel.get(str);
            if (str2.length() == 0) {
                return new java.util.Date(jLongValue);
            }
            java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone(str2));
            calendar.setTimeInMillis(jLongValue);
            return calendar.getTime();
        }

        private void checkType(java.lang.String str, int i_renamed) {
            java.lang.String str2 = this.mParcel.get(str);
            if (str2 != null) {
                return;
            }
            throw new java.lang.IllegalStateException("Wrong type " + i_renamed + " but got " + str2);
        }
    }
}
