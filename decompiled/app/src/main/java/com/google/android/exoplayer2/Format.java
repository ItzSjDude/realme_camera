package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class Format implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.Format> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.Format>() { // from class: com.google.android.exoplayer2.Format.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.Format createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.Format(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.Format[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.Format[i_renamed];
        }
    };
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final int accessibilityChannel;
    public final int bitrate;
    public final int channelCount;
    public final java.lang.String codecs;
    public final com.google.android.exoplayer2.video.ColorInfo colorInfo;
    public final java.lang.String containerMimeType;
    public final com.google.android.exoplayer2.drm.DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final float frameRate;
    private int hashCode;
    public final int height;
    public final java.lang.String id_renamed;
    public final java.util.List<byte[]> initializationData;
    public final java.lang.String label;
    public final java.lang.String language;
    public final int maxInputSize;
    public final com.google.android.exoplayer2.metadata.Metadata metadata;
    public final int pcmEncoding;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int rotationDegrees;
    public final java.lang.String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createVideoContainerFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i_renamed, int i2, int i3, float f_renamed, java.util.List<byte[]> list, int i4) {
        return createVideoContainerFormat(str, null, str2, str3, str4, i_renamed, i2, i3, f_renamed, list, i4);
    }

    public static com.google.android.exoplayer2.Format createVideoContainerFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i_renamed, int i2, int i3, float f_renamed, java.util.List<byte[]> list, int i4) {
        return new com.google.android.exoplayer2.Format(str, str2, str3, str4, str5, i_renamed, -1, i2, i3, f_renamed, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i4, null, -1, Long.MAX_VALUE, list, null, null);
    }

    public static com.google.android.exoplayer2.Format createVideoSampleFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, int i3, int i4, float f_renamed, java.util.List<byte[]> list, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        return createVideoSampleFormat(str, str2, str3, i_renamed, i2, i3, i4, f_renamed, list, -1, -1.0f, drmInitData);
    }

    public static com.google.android.exoplayer2.Format createVideoSampleFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, int i3, int i4, float f_renamed, java.util.List<byte[]> list, int i5, float f2, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        return createVideoSampleFormat(str, str2, str3, i_renamed, i2, i3, i4, f_renamed, list, i5, f2, null, -1, null, drmInitData);
    }

    public static com.google.android.exoplayer2.Format createVideoSampleFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, int i3, int i4, float f_renamed, java.util.List<byte[]> list, int i5, float f2, byte[] bArr, int i6, com.google.android.exoplayer2.video.ColorInfo colorInfo, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        return new com.google.android.exoplayer2.Format(str, null, null, str2, str3, i_renamed, i2, i3, i4, f_renamed, i5, f2, bArr, i6, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createAudioContainerFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i_renamed, int i2, int i3, java.util.List<byte[]> list, int i4, java.lang.String str5) {
        return createAudioContainerFormat(str, null, str2, str3, str4, i_renamed, i2, i3, list, i4, str5);
    }

    public static com.google.android.exoplayer2.Format createAudioContainerFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i_renamed, int i2, int i3, java.util.List<byte[]> list, int i4, java.lang.String str6) {
        return new com.google.android.exoplayer2.Format(str, str2, str3, str4, str5, i_renamed, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i2, i3, -1, -1, -1, i4, str6, -1, Long.MAX_VALUE, list, null, null);
    }

    public static com.google.android.exoplayer2.Format createAudioSampleFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, int i3, int i4, java.util.List<byte[]> list, com.google.android.exoplayer2.drm.DrmInitData drmInitData, int i5, java.lang.String str4) {
        return createAudioSampleFormat(str, str2, str3, i_renamed, i2, i3, i4, -1, list, drmInitData, i5, str4);
    }

    public static com.google.android.exoplayer2.Format createAudioSampleFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, int i3, int i4, int i5, java.util.List<byte[]> list, com.google.android.exoplayer2.drm.DrmInitData drmInitData, int i6, java.lang.String str4) {
        return createAudioSampleFormat(str, str2, str3, i_renamed, i2, i3, i4, i5, -1, -1, list, drmInitData, i6, str4, null);
    }

    public static com.google.android.exoplayer2.Format createAudioSampleFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, java.util.List<byte[]> list, com.google.android.exoplayer2.drm.DrmInitData drmInitData, int i8, java.lang.String str4, com.google.android.exoplayer2.metadata.Metadata metadata) {
        return new com.google.android.exoplayer2.Format(str, null, null, str2, str3, i_renamed, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, i6, i7, i8, str4, -1, Long.MAX_VALUE, list, drmInitData, metadata);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createTextContainerFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i_renamed, int i2, java.lang.String str5) {
        return createTextContainerFormat(str, null, str2, str3, str4, i_renamed, i2, str5);
    }

    public static com.google.android.exoplayer2.Format createTextContainerFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i_renamed, int i2, java.lang.String str6) {
        return createTextContainerFormat(str, str2, str3, str4, str5, i_renamed, i2, str6, -1);
    }

    public static com.google.android.exoplayer2.Format createTextContainerFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i_renamed, int i2, java.lang.String str6, int i3) {
        return new com.google.android.exoplayer2.Format(str, str2, str3, str4, str5, i_renamed, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str6, i3, Long.MAX_VALUE, null, null, null);
    }

    public static com.google.android.exoplayer2.Format createTextSampleFormat(java.lang.String str, java.lang.String str2, int i_renamed, java.lang.String str3) {
        return createTextSampleFormat(str, str2, i_renamed, str3, null);
    }

    public static com.google.android.exoplayer2.Format createTextSampleFormat(java.lang.String str, java.lang.String str2, int i_renamed, java.lang.String str3, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        return createTextSampleFormat(str, str2, null, -1, i_renamed, str3, -1, drmInitData, Long.MAX_VALUE, java.util.Collections.emptyList());
    }

    public static com.google.android.exoplayer2.Format createTextSampleFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, java.lang.String str4, int i3, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        return createTextSampleFormat(str, str2, str3, i_renamed, i2, str4, i3, drmInitData, Long.MAX_VALUE, java.util.Collections.emptyList());
    }

    public static com.google.android.exoplayer2.Format createTextSampleFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, java.lang.String str4, com.google.android.exoplayer2.drm.DrmInitData drmInitData, long j_renamed) {
        return createTextSampleFormat(str, str2, str3, i_renamed, i2, str4, -1, drmInitData, j_renamed, java.util.Collections.emptyList());
    }

    public static com.google.android.exoplayer2.Format createTextSampleFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, java.lang.String str4, int i3, com.google.android.exoplayer2.drm.DrmInitData drmInitData, long j_renamed, java.util.List<byte[]> list) {
        return new com.google.android.exoplayer2.Format(str, null, null, str2, str3, i_renamed, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, i3, j_renamed, list, drmInitData, null);
    }

    public static com.google.android.exoplayer2.Format createImageSampleFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, java.util.List<byte[]> list, java.lang.String str4, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        return new com.google.android.exoplayer2.Format(str, null, null, str2, str3, i_renamed, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.Format createContainerFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i_renamed, int i2, java.lang.String str5) {
        return createContainerFormat(str, null, str2, str3, str4, i_renamed, i2, str5);
    }

    public static com.google.android.exoplayer2.Format createContainerFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i_renamed, int i2, java.lang.String str6) {
        return new com.google.android.exoplayer2.Format(str, str2, str3, str4, str5, i_renamed, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str6, -1, Long.MAX_VALUE, null, null, null);
    }

    public static com.google.android.exoplayer2.Format createSampleFormat(java.lang.String str, java.lang.String str2, long j_renamed) {
        return new com.google.android.exoplayer2.Format(str, null, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j_renamed, null, null, null);
    }

    public static com.google.android.exoplayer2.Format createSampleFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        return new com.google.android.exoplayer2.Format(str, null, null, str2, str3, i_renamed, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, drmInitData, null);
    }

    Format(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i_renamed, int i2, int i3, int i4, float f_renamed, int i5, float f2, byte[] bArr, int i6, com.google.android.exoplayer2.video.ColorInfo colorInfo, int i7, int i8, int i9, int i10, int i11, int i12, java.lang.String str6, int i13, long j_renamed, java.util.List<byte[]> list, com.google.android.exoplayer2.drm.DrmInitData drmInitData, com.google.android.exoplayer2.metadata.Metadata metadata) {
        this.id_renamed = str;
        this.label = str2;
        this.containerMimeType = str3;
        this.sampleMimeType = str4;
        this.codecs = str5;
        this.bitrate = i_renamed;
        this.maxInputSize = i2;
        this.width = i3;
        this.height = i4;
        this.frameRate = f_renamed;
        int i14 = i5;
        this.rotationDegrees = i14 == -1 ? 0 : i14;
        this.pixelWidthHeightRatio = f2 == -1.0f ? 1.0f : f2;
        this.projectionData = bArr;
        this.stereoMode = i6;
        this.colorInfo = colorInfo;
        this.channelCount = i7;
        this.sampleRate = i8;
        this.pcmEncoding = i9;
        int i15 = i10;
        this.encoderDelay = i15 == -1 ? 0 : i15;
        int i16 = i11;
        this.encoderPadding = i16 == -1 ? 0 : i16;
        this.selectionFlags = i12;
        this.language = str6;
        this.accessibilityChannel = i13;
        this.subsampleOffsetUs = j_renamed;
        this.initializationData = list == null ? java.util.Collections.emptyList() : list;
        this.drmInitData = drmInitData;
        this.metadata = metadata;
    }

    Format(android.os.Parcel parcel) {
        this.id_renamed = parcel.readString();
        this.label = parcel.readString();
        this.containerMimeType = parcel.readString();
        this.sampleMimeType = parcel.readString();
        this.codecs = parcel.readString();
        this.bitrate = parcel.readInt();
        this.maxInputSize = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.frameRate = parcel.readFloat();
        this.rotationDegrees = parcel.readInt();
        this.pixelWidthHeightRatio = parcel.readFloat();
        this.projectionData = com.google.android.exoplayer2.util.Util.readBoolean(parcel) ? parcel.createByteArray() : null;
        this.stereoMode = parcel.readInt();
        this.colorInfo = (com.google.android.exoplayer2.video.ColorInfo) parcel.readParcelable(com.google.android.exoplayer2.video.ColorInfo.class.getClassLoader());
        this.channelCount = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.pcmEncoding = parcel.readInt();
        this.encoderDelay = parcel.readInt();
        this.encoderPadding = parcel.readInt();
        this.selectionFlags = parcel.readInt();
        this.language = parcel.readString();
        this.accessibilityChannel = parcel.readInt();
        this.subsampleOffsetUs = parcel.readLong();
        int i_renamed = parcel.readInt();
        this.initializationData = new java.util.ArrayList(i_renamed);
        for (int i2 = 0; i2 < i_renamed; i2++) {
            this.initializationData.add(parcel.createByteArray());
        }
        this.drmInitData = (com.google.android.exoplayer2.drm.DrmInitData) parcel.readParcelable(com.google.android.exoplayer2.drm.DrmInitData.class.getClassLoader());
        this.metadata = (com.google.android.exoplayer2.metadata.Metadata) parcel.readParcelable(com.google.android.exoplayer2.metadata.Metadata.class.getClassLoader());
    }

    public com.google.android.exoplayer2.Format copyWithMaxInputSize(int i_renamed) {
        return new com.google.android.exoplayer2.Format(this.id_renamed, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, i_renamed, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public com.google.android.exoplayer2.Format copyWithSubsampleOffsetUs(long j_renamed) {
        return new com.google.android.exoplayer2.Format(this.id_renamed, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, j_renamed, this.initializationData, this.drmInitData, this.metadata);
    }

    public com.google.android.exoplayer2.Format copyWithContainerInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i_renamed, int i2, int i3, int i4, java.lang.String str5) {
        return new com.google.android.exoplayer2.Format(str, str2, this.containerMimeType, str3, str4, i_renamed, this.maxInputSize, i2, i3, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, i4, str5, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:24:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.exoplayer2.Format copyWithManifestFormatInfo(com.google.android.exoplayer2.Format r33) {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            if (r0 != r1) goto L7
            return r0
        L7:
            java.lang.String r2 = r0.sampleMimeType
            int r2 = com.google.android.exoplayer2.util.MimeTypes.getTrackType(r2)
            java.lang.String r4 = r1.id_renamed
            java.lang.String r3 = r1.label
            if (r3 == 0) goto L14
            goto L16
        L14:
            java.lang.String r3 = r0.label
        L16:
            r5 = r3
            java.lang.String r3 = r0.language
            r6 = 3
            r7 = 1
            if (r2 == r6) goto L1f
            if (r2 != r7) goto L26
        L1f:
            java.lang.String r6 = r1.language
            if (r6 == 0) goto L26
            r25 = r6
            goto L28
        L26:
            r25 = r3
        L28:
            int r3 = r0.bitrate
            r6 = -1
            if (r3 != r6) goto L2f
            int r3 = r1.bitrate
        L2f:
            r9 = r3
            java.lang.String r3 = r0.codecs
            if (r3 != 0) goto L43
            java.lang.String r6 = r1.codecs
            java.lang.String r6 = com.google.android.exoplayer2.util.Util.getCodecsOfType(r6, r2)
            java.lang.String[] r8 = com.google.android.exoplayer2.util.Util.splitCodecs(r6)
            int r8 = r8.length
            if (r8 != r7) goto L43
            r8 = r6
            goto L44
        L43:
            r8 = r3
        L44:
            float r3 = r0.frameRate
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 != 0) goto L53
            r6 = 2
            if (r2 != r6) goto L53
            float r2 = r1.frameRate
            r13 = r2
            goto L54
        L53:
            r13 = r3
        L54:
            int r2 = r0.selectionFlags
            int r3 = r1.selectionFlags
            r24 = r2 | r3
            com.google.android.exoplayer2.drm.DrmInitData r1 = r1.drmInitData
            com.google.android.exoplayer2.drm.DrmInitData r2 = r0.drmInitData
            com.google.android.exoplayer2.drm.DrmInitData r30 = com.google.android.exoplayer2.drm.DrmInitData.createSessionCreationData(r1, r2)
            com.google.android.exoplayer2.Format r1 = new com.google.android.exoplayer2.Format
            r3 = r1
            java.lang.String r6 = r0.containerMimeType
            java.lang.String r7 = r0.sampleMimeType
            int r10 = r0.maxInputSize
            int r11 = r0.width
            int r12 = r0.height
            int r14 = r0.rotationDegrees
            float r15 = r0.pixelWidthHeightRatio
            byte[] r2 = r0.projectionData
            r16 = r2
            int r2 = r0.stereoMode
            r17 = r2
            com.google.android.exoplayer2.video.ColorInfo r2 = r0.colorInfo
            r18 = r2
            int r2 = r0.channelCount
            r19 = r2
            int r2 = r0.sampleRate
            r20 = r2
            int r2 = r0.pcmEncoding
            r21 = r2
            int r2 = r0.encoderDelay
            r22 = r2
            int r2 = r0.encoderPadding
            r23 = r2
            int r2 = r0.accessibilityChannel
            r26 = r2
            r33 = r1
            long r1 = r0.subsampleOffsetUs
            r27 = r1
            java.util.List<byte[]> r1 = r0.initializationData
            r29 = r1
            com.google.android.exoplayer2.metadata.Metadata r0 = r0.metadata
            r31 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, r30, r31)
            return r33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.Format.copyWithManifestFormatInfo(com.google.android.exoplayer2.Format):com.google.android.exoplayer2.Format");
    }

    public com.google.android.exoplayer2.Format copyWithGaplessInfo(int i_renamed, int i2) {
        return new com.google.android.exoplayer2.Format(this.id_renamed, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, i_renamed, i2, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public com.google.android.exoplayer2.Format copyWithFrameRate(float f_renamed) {
        return new com.google.android.exoplayer2.Format(this.id_renamed, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, f_renamed, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public com.google.android.exoplayer2.Format copyWithDrmInitData(com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
        return new com.google.android.exoplayer2.Format(this.id_renamed, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, drmInitData, this.metadata);
    }

    public com.google.android.exoplayer2.Format copyWithMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
        return new com.google.android.exoplayer2.Format(this.id_renamed, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, metadata);
    }

    public com.google.android.exoplayer2.Format copyWithRotationDegrees(int i_renamed) {
        return new com.google.android.exoplayer2.Format(this.id_renamed, this.label, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, i_renamed, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public int getPixelCount() {
        int i_renamed;
        int i2 = this.width;
        if (i2 == -1 || (i_renamed = this.height) == -1) {
            return -1;
        }
        return i2 * i_renamed;
    }

    public java.lang.String toString() {
        return "Format(" + this.id_renamed + ", " + this.label + ", " + this.containerMimeType + ", " + this.sampleMimeType + ", " + this.codecs + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.frameRate + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            java.lang.String str = this.id_renamed;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            java.lang.String str2 = this.containerMimeType;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            java.lang.String str3 = this.sampleMimeType;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            java.lang.String str4 = this.codecs;
            int iHashCode4 = (((((((((((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.bitrate) * 31) + this.width) * 31) + this.height) * 31) + this.channelCount) * 31) + this.sampleRate) * 31;
            java.lang.String str5 = this.language;
            int iHashCode5 = (((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.accessibilityChannel) * 31;
            com.google.android.exoplayer2.drm.DrmInitData drmInitData = this.drmInitData;
            int iHashCode6 = (iHashCode5 + (drmInitData == null ? 0 : drmInitData.hashCode())) * 31;
            com.google.android.exoplayer2.metadata.Metadata metadata = this.metadata;
            int iHashCode7 = (iHashCode6 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            java.lang.String str6 = this.label;
            this.hashCode = ((((((((((((((((((((iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.maxInputSize) * 31) + ((int) this.subsampleOffsetUs)) * 31) + java.lang.Float.floatToIntBits(this.frameRate)) * 31) + java.lang.Float.floatToIntBits(this.pixelWidthHeightRatio)) * 31) + this.rotationDegrees) * 31) + this.stereoMode) * 31) + this.pcmEncoding) * 31) + this.encoderDelay) * 31) + this.encoderPadding) * 31) + this.selectionFlags;
        }
        return this.hashCode;
    }

    public boolean equals(java.lang.Object obj) {
        int i_renamed;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.Format format = (com.google.android.exoplayer2.Format) obj;
        int i2 = this.hashCode;
        if (i2 == 0 || (i_renamed = format.hashCode) == 0 || i2 == i_renamed) {
            return this.bitrate == format.bitrate && this.maxInputSize == format.maxInputSize && this.width == format.width && this.height == format.height && java.lang.Float.compare(this.frameRate, format.frameRate) == 0 && this.rotationDegrees == format.rotationDegrees && java.lang.Float.compare(this.pixelWidthHeightRatio, format.pixelWidthHeightRatio) == 0 && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.subsampleOffsetUs == format.subsampleOffsetUs && this.selectionFlags == format.selectionFlags && com.google.android.exoplayer2.util.Util.areEqual(this.id_renamed, format.id_renamed) && com.google.android.exoplayer2.util.Util.areEqual(this.label, format.label) && com.google.android.exoplayer2.util.Util.areEqual(this.language, format.language) && this.accessibilityChannel == format.accessibilityChannel && com.google.android.exoplayer2.util.Util.areEqual(this.containerMimeType, format.containerMimeType) && com.google.android.exoplayer2.util.Util.areEqual(this.sampleMimeType, format.sampleMimeType) && com.google.android.exoplayer2.util.Util.areEqual(this.codecs, format.codecs) && com.google.android.exoplayer2.util.Util.areEqual(this.drmInitData, format.drmInitData) && com.google.android.exoplayer2.util.Util.areEqual(this.metadata, format.metadata) && com.google.android.exoplayer2.util.Util.areEqual(this.colorInfo, format.colorInfo) && java.util.Arrays.equals(this.projectionData, format.projectionData) && initializationDataEquals(format);
        }
        return false;
    }

    public boolean initializationDataEquals(com.google.android.exoplayer2.Format format) {
        if (this.initializationData.size() != format.initializationData.size()) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < this.initializationData.size(); i_renamed++) {
            if (!java.util.Arrays.equals(this.initializationData.get(i_renamed), format.initializationData.get(i_renamed))) {
                return false;
            }
        }
        return true;
    }

    public static java.lang.String toLogString(com.google.android.exoplayer2.Format format) {
        if (format == null) {
            return "null";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("id_renamed=");
        sb.append(format.id_renamed);
        sb.append(", mimeType=");
        sb.append(format.sampleMimeType);
        if (format.bitrate != -1) {
            sb.append(", bitrate=");
            sb.append(format.bitrate);
        }
        if (format.codecs != null) {
            sb.append(", codecs=");
            sb.append(format.codecs);
        }
        if (format.width != -1 && format.height != -1) {
            sb.append(", res=");
            sb.append(format.width);
            sb.append("x_renamed");
            sb.append(format.height);
        }
        if (format.frameRate != -1.0f) {
            sb.append(", fps=");
            sb.append(format.frameRate);
        }
        if (format.channelCount != -1) {
            sb.append(", channels=");
            sb.append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            sb.append(", sample_rate=");
            sb.append(format.sampleRate);
        }
        if (format.language != null) {
            sb.append(", language=");
            sb.append(format.language);
        }
        if (format.label != null) {
            sb.append(", label=");
            sb.append(format.label);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.id_renamed);
        parcel.writeString(this.label);
        parcel.writeString(this.containerMimeType);
        parcel.writeString(this.sampleMimeType);
        parcel.writeString(this.codecs);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.maxInputSize);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.frameRate);
        parcel.writeInt(this.rotationDegrees);
        parcel.writeFloat(this.pixelWidthHeightRatio);
        com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.projectionData != null);
        byte[] bArr = this.projectionData;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.stereoMode);
        parcel.writeParcelable(this.colorInfo, i_renamed);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.pcmEncoding);
        parcel.writeInt(this.encoderDelay);
        parcel.writeInt(this.encoderPadding);
        parcel.writeInt(this.selectionFlags);
        parcel.writeString(this.language);
        parcel.writeInt(this.accessibilityChannel);
        parcel.writeLong(this.subsampleOffsetUs);
        int size = this.initializationData.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.initializationData.get(i2));
        }
        parcel.writeParcelable(this.drmInitData, 0);
        parcel.writeParcelable(this.metadata, 0);
    }
}
