package com.google.android.exoplayer2.metadata;

/* loaded from: classes.dex */
public interface MetadataDecoderFactory {
    public static final com.google.android.exoplayer2.metadata.MetadataDecoderFactory DEFAULT = new com.google.android.exoplayer2.metadata.MetadataDecoderFactory() { // from class: com.google.android.exoplayer2.metadata.MetadataDecoderFactory.1
        @Override // com.google.android.exoplayer2.metadata.MetadataDecoderFactory
        public boolean supportsFormat(com.google.android.exoplayer2.Format format) {
            java.lang.String str = format.sampleMimeType;
            return com.google.android.exoplayer2.util.MimeTypes.APPLICATION_ID3.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_EMSG.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_SCTE35.equals(str);
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:18:0x0036  */
        @Override // com.google.android.exoplayer2.metadata.MetadataDecoderFactory
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.android.exoplayer2.metadata.MetadataDecoder createDecoder(com.google.android.exoplayer2.Format r4) {
            /*
                r3 = this;
                java.lang.String r3 = r4.sampleMimeType
                int r4 = r3.hashCode()
                r0 = -1248341703(0xffffffffb597d139, float:-1.1311269E-6)
                r1 = 2
                r2 = 1
                if (r4 == r0) goto L2c
                r0 = 1154383568(0x44ce7ed0, float:1651.9629)
                if (r4 == r0) goto L22
                r0 = 1652648887(0x62816bb7, float:1.1936958E21)
                if (r4 == r0) goto L18
                goto L36
            L18:
                java.lang.String r4 = "application/x_renamed-scte35"
                boolean r3 = r3.equals(r4)
                if (r3 == 0) goto L36
                r3 = r1
                goto L37
            L22:
                java.lang.String r4 = "application/x_renamed-emsg"
                boolean r3 = r3.equals(r4)
                if (r3 == 0) goto L36
                r3 = r2
                goto L37
            L2c:
                java.lang.String r4 = "application/id3"
                boolean r3 = r3.equals(r4)
                if (r3 == 0) goto L36
                r3 = 0
                goto L37
            L36:
                r3 = -1
            L37:
                if (r3 == 0) goto L51
                if (r3 == r2) goto L4b
                if (r3 != r1) goto L43
                com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder r3 = new com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder
                r3.<init>()
                return r3
            L43:
                java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
                java.lang.String r4 = "Attempted to create decoder for unsupported format"
                r3.<init>(r4)
                throw r3
            L4b:
                com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder r3 = new com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder
                r3.<init>()
                return r3
            L51:
                com.google.android.exoplayer2.metadata.id3.Id3Decoder r3 = new com.google.android.exoplayer2.metadata.id3.Id3Decoder
                r3.<init>()
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.MetadataDecoderFactory.SceneLoader_2.createDecoder(com.google.android.exoplayer2.Format):com.google.android.exoplayer2.metadata.MetadataDecoder");
        }
    };

    com.google.android.exoplayer2.metadata.MetadataDecoder createDecoder(com.google.android.exoplayer2.Format format);

    boolean supportsFormat(com.google.android.exoplayer2.Format format);
}
