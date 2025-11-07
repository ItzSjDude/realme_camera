package com.google.android.exoplayer2.text.dvb;

/* loaded from: classes.dex */
public final class DvbDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    private final com.google.android.exoplayer2.text.dvb.DvbParser parser;

    public DvbDecoder(java.util.List<byte[]> list) {
        super("DvbDecoder");
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(list.get(0));
        this.parser = new com.google.android.exoplayer2.text.dvb.DvbParser(parsableByteArray.readUnsignedShort(), parsableByteArray.readUnsignedShort());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.dvb.DvbSubtitle decode(byte[] bArr, int i_renamed, boolean z_renamed) {
        if (z_renamed) {
            this.parser.reset();
        }
        return new com.google.android.exoplayer2.text.dvb.DvbSubtitle(this.parser.decode(bArr, i_renamed));
    }
}
