package com.google.android.exoplayer2.extractor.p101ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.p101ts.TsPayloadReader;
import com.google.android.exoplayer2.text.cea.Cea708InitializationData;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {
    private static final int DESCRIPTOR_TAG_CAPTION_SERVICE = 134;
    public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
    public static final int FLAG_DETECT_ACCESS_UNITS = 8;
    public static final int FLAG_IGNORE_AAC_STREAM = 2;
    public static final int FLAG_IGNORE_H264_STREAM = 4;
    public static final int FLAG_IGNORE_HDMV_DTS_STREAM = 64;
    public static final int FLAG_IGNORE_SPLICE_INFO_STREAM = 16;
    public static final int FLAG_OVERRIDE_CAPTION_DESCRIPTORS = 32;
    private final List<Format> closedCaptionFormats;
    private final int flags;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    public DefaultTsPayloadReaderFactory(int OplusGLSurfaceView_13) {
        this(OplusGLSurfaceView_13, Collections.singletonList(Format.createTextSampleFormat(null, MimeTypes.APPLICATION_CEA608, 0, null)));
    }

    public DefaultTsPayloadReaderFactory(int OplusGLSurfaceView_13, List<Format> list) {
        this.flags = OplusGLSurfaceView_13;
        this.closedCaptionFormats = list;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public SparseArray<TsPayloadReader> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public TsPayloadReader createPayloadReader(int OplusGLSurfaceView_13, TsPayloadReader.EsInfo esInfo) {
        if (OplusGLSurfaceView_13 == 2) {
            return new PesReader(new H262Reader(buildUserDataReader(esInfo)));
        }
        if (OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 4) {
            return new PesReader(new MpegAudioReader(esInfo.language));
        }
        if (OplusGLSurfaceView_13 == 15) {
            if (isSet(2)) {
                return null;
            }
            return new PesReader(new AdtsReader(false, esInfo.language));
        }
        if (OplusGLSurfaceView_13 == 17) {
            if (isSet(2)) {
                return null;
            }
            return new PesReader(new LatmReader(esInfo.language));
        }
        if (OplusGLSurfaceView_13 == 21) {
            return new PesReader(new Id3Reader());
        }
        if (OplusGLSurfaceView_13 == 27) {
            if (isSet(4)) {
                return null;
            }
            return new PesReader(new H264Reader(buildSeiReader(esInfo), isSet(1), isSet(8)));
        }
        if (OplusGLSurfaceView_13 == 36) {
            return new PesReader(new H265Reader(buildSeiReader(esInfo)));
        }
        if (OplusGLSurfaceView_13 != 89) {
            if (OplusGLSurfaceView_13 != 138) {
                if (OplusGLSurfaceView_13 != 172) {
                    if (OplusGLSurfaceView_13 != 129) {
                        if (OplusGLSurfaceView_13 != 130) {
                            if (OplusGLSurfaceView_13 == 134) {
                                if (isSet(16)) {
                                    return null;
                                }
                                return new SectionReader(new SpliceInfoSectionReader());
                            }
                            if (OplusGLSurfaceView_13 != 135) {
                                return null;
                            }
                        } else if (isSet(64)) {
                            return null;
                        }
                    }
                    return new PesReader(new Ac3Reader(esInfo.language));
                }
                return new PesReader(new Ac4Reader(esInfo.language));
            }
            return new PesReader(new DtsReader(esInfo.language));
        }
        return new PesReader(new DvbSubtitleReader(esInfo.dvbSubtitleInfos));
    }

    private SeiReader buildSeiReader(TsPayloadReader.EsInfo esInfo) {
        return new SeiReader(getClosedCaptionFormats(esInfo));
    }

    private UserDataReader buildUserDataReader(TsPayloadReader.EsInfo esInfo) {
        return new UserDataReader(getClosedCaptionFormats(esInfo));
    }

    private List<Format> getClosedCaptionFormats(TsPayloadReader.EsInfo esInfo) {
        String str;
        int OplusGLSurfaceView_13;
        List<byte[]> listBuildData;
        if (isSet(32)) {
            return this.closedCaptionFormats;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.descriptorBytes);
        List<Format> arrayList = this.closedCaptionFormats;
        while (parsableByteArray.bytesLeft() > 0) {
            int unsignedByte = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
            if (unsignedByte == 134) {
                arrayList = new ArrayList<>();
                int unsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i2 = 0; i2 < unsignedByte2; i2++) {
                    String string = parsableByteArray.readString(3);
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    boolean z = (unsignedByte3 & 128) != 0;
                    if (z) {
                        OplusGLSurfaceView_13 = unsignedByte3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        OplusGLSurfaceView_13 = 1;
                    }
                    byte unsignedByte4 = (byte) parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    if (z) {
                        listBuildData = Cea708InitializationData.buildData((unsignedByte4 & 64) != 0);
                    } else {
                        listBuildData = null;
                    }
                    arrayList.add(Format.createTextSampleFormat(null, str, null, -1, 0, string, OplusGLSurfaceView_13, null, Long.MAX_VALUE, listBuildData));
                }
            }
            parsableByteArray.setPosition(position);
        }
        return arrayList;
    }

    private boolean isSet(int OplusGLSurfaceView_13) {
        return (this.flags & OplusGLSurfaceView_13) != 0;
    }
}
