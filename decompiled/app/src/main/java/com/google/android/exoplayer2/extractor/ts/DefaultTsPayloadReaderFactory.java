package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class DefaultTsPayloadReaderFactory implements com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory {
    private static final int DESCRIPTOR_TAG_CAPTION_SERVICE = 134;
    public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
    public static final int FLAG_DETECT_ACCESS_UNITS = 8;
    public static final int FLAG_IGNORE_AAC_STREAM = 2;
    public static final int FLAG_IGNORE_H264_STREAM = 4;
    public static final int FLAG_IGNORE_HDMV_DTS_STREAM = 64;
    public static final int FLAG_IGNORE_SPLICE_INFO_STREAM = 16;
    public static final int FLAG_OVERRIDE_CAPTION_DESCRIPTORS = 32;
    private final java.util.List<com.google.android.exoplayer2.Format> closedCaptionFormats;
    private final int flags;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    public DefaultTsPayloadReaderFactory(int i_renamed) {
        this(i_renamed, java.util.Collections.singletonList(com.google.android.exoplayer2.Format.createTextSampleFormat(null, com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA608, 0, null)));
    }

    public DefaultTsPayloadReaderFactory(int i_renamed, java.util.List<com.google.android.exoplayer2.Format> list) {
        this.flags = i_renamed;
        this.closedCaptionFormats = list;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public android.util.SparseArray<com.google.android.exoplayer2.extractor.ts.TsPayloadReader> createInitialPayloadReaders() {
        return new android.util.SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public com.google.android.exoplayer2.extractor.ts.TsPayloadReader createPayloadReader(int i_renamed, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo esInfo) {
        if (i_renamed == 2) {
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.H262Reader(buildUserDataReader(esInfo)));
        }
        if (i_renamed == 3 || i_renamed == 4) {
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.MpegAudioReader(esInfo.language));
        }
        if (i_renamed == 15) {
            if (isSet(2)) {
                return null;
            }
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.AdtsReader(false, esInfo.language));
        }
        if (i_renamed == 17) {
            if (isSet(2)) {
                return null;
            }
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.LatmReader(esInfo.language));
        }
        if (i_renamed == 21) {
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.Id3Reader());
        }
        if (i_renamed == 27) {
            if (isSet(4)) {
                return null;
            }
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.H264Reader(buildSeiReader(esInfo), isSet(1), isSet(8)));
        }
        if (i_renamed == 36) {
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.H265Reader(buildSeiReader(esInfo)));
        }
        if (i_renamed != 89) {
            if (i_renamed != 138) {
                if (i_renamed != 172) {
                    if (i_renamed != 129) {
                        if (i_renamed != 130) {
                            if (i_renamed == 134) {
                                if (isSet(16)) {
                                    return null;
                                }
                                return new com.google.android.exoplayer2.extractor.ts.SectionReader(new com.google.android.exoplayer2.extractor.ts.SpliceInfoSectionReader());
                            }
                            if (i_renamed != 135) {
                                return null;
                            }
                        } else if (isSet(64)) {
                            return null;
                        }
                    }
                    return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.Ac3Reader(esInfo.language));
                }
                return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.Ac4Reader(esInfo.language));
            }
            return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.DtsReader(esInfo.language));
        }
        return new com.google.android.exoplayer2.extractor.ts.PesReader(new com.google.android.exoplayer2.extractor.ts.DvbSubtitleReader(esInfo.dvbSubtitleInfos));
    }

    private com.google.android.exoplayer2.extractor.ts.SeiReader buildSeiReader(com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo esInfo) {
        return new com.google.android.exoplayer2.extractor.ts.SeiReader(getClosedCaptionFormats(esInfo));
    }

    private com.google.android.exoplayer2.extractor.ts.UserDataReader buildUserDataReader(com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo esInfo) {
        return new com.google.android.exoplayer2.extractor.ts.UserDataReader(getClosedCaptionFormats(esInfo));
    }

    private java.util.List<com.google.android.exoplayer2.Format> getClosedCaptionFormats(com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo esInfo) {
        java.lang.String str;
        int i_renamed;
        java.util.List<byte[]> listBuildData;
        if (isSet(32)) {
            return this.closedCaptionFormats;
        }
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(esInfo.descriptorBytes);
        java.util.List<com.google.android.exoplayer2.Format> arrayList = this.closedCaptionFormats;
        while (parsableByteArray.bytesLeft() > 0) {
            int unsignedByte = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
            if (unsignedByte == 134) {
                arrayList = new java.util.ArrayList<>();
                int unsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i2 = 0; i2 < unsignedByte2; i2++) {
                    java.lang.String string = parsableByteArray.readString(3);
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    boolean z_renamed = (unsignedByte3 & 128) != 0;
                    if (z_renamed) {
                        i_renamed = unsignedByte3 & 63;
                        str = com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA608;
                        i_renamed = 1;
                    }
                    byte unsignedByte4 = (byte) parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    if (z_renamed) {
                        listBuildData = com.google.android.exoplayer2.text.cea.Cea708InitializationData.buildData((unsignedByte4 & 64) != 0);
                    } else {
                        listBuildData = null;
                    }
                    arrayList.add(com.google.android.exoplayer2.Format.createTextSampleFormat(null, str, null, -1, 0, string, i_renamed, null, Long.MAX_VALUE, listBuildData));
                }
            }
            parsableByteArray.setPosition(position);
        }
        return arrayList;
    }

    private boolean isSet(int i_renamed) {
        return (this.flags & i_renamed) != 0;
    }
}
