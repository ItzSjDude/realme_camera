package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes.dex */
public final class Mp4WebvttDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    private static final int BOX_HEADER_SIZE = 8;
    private static final int TYPE_payl = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("payl");
    private static final int TYPE_sttg = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("sttg");
    private static final int TYPE_vttc = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("vttc");
    private final com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder builder;
    private final com.google.android.exoplayer2.util.ParsableByteArray sampleData;

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
        this.sampleData = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.builder = new com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.webvtt.Mp4WebvttSubtitle decode(byte[] bArr, int i_renamed, boolean z_renamed) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        this.sampleData.reset(bArr, i_renamed);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (this.sampleData.bytesLeft() > 0) {
            if (this.sampleData.bytesLeft() < 8) {
                throw new com.google.android.exoplayer2.text.SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int i2 = this.sampleData.readInt();
            if (this.sampleData.readInt() == TYPE_vttc) {
                arrayList.add(parseVttCueBox(this.sampleData, this.builder, i2 - 8));
            } else {
                this.sampleData.skipBytes(i2 - 8);
            }
        }
        return new com.google.android.exoplayer2.text.webvtt.Mp4WebvttSubtitle(arrayList);
    }

    private static com.google.android.exoplayer2.text.Cue parseVttCueBox(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder builder, int i_renamed) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        builder.reset();
        while (i_renamed > 0) {
            if (i_renamed < 8) {
                throw new com.google.android.exoplayer2.text.SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int i2 = parsableByteArray.readInt();
            int i3 = parsableByteArray.readInt();
            int i4 = i2 - 8;
            java.lang.String strFromUtf8Bytes = com.google.android.exoplayer2.util.Util.fromUtf8Bytes(parsableByteArray.data, parsableByteArray.getPosition(), i4);
            parsableByteArray.skipBytes(i4);
            i_renamed = (i_renamed - 8) - i4;
            if (i3 == TYPE_sttg) {
                com.google.android.exoplayer2.text.webvtt.WebvttCueParser.parseCueSettingsList(strFromUtf8Bytes, builder);
            } else if (i3 == TYPE_payl) {
                com.google.android.exoplayer2.text.webvtt.WebvttCueParser.parseCueText(null, strFromUtf8Bytes.trim(), builder, java.util.Collections.emptyList());
            }
        }
        return builder.build();
    }
}
