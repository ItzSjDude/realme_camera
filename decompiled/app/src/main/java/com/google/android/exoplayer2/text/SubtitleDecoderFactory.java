package com.google.android.exoplayer2.text;

/* loaded from: classes.dex */
public interface SubtitleDecoderFactory {
    public static final com.google.android.exoplayer2.text.SubtitleDecoderFactory DEFAULT = new com.google.android.exoplayer2.text.SubtitleDecoderFactory() { // from class: com.google.android.exoplayer2.text.SubtitleDecoderFactory.1
        @Override // com.google.android.exoplayer2.text.SubtitleDecoderFactory
        public boolean supportsFormat(com.google.android.exoplayer2.Format format) {
            java.lang.String str = format.sampleMimeType;
            return com.google.android.exoplayer2.util.MimeTypes.TEXT_VTT.equals(str) || com.google.android.exoplayer2.util.MimeTypes.TEXT_SSA.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_TTML.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_MP4VTT.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_SUBRIP.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_TX3G.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA608.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_MP4CEA608.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA708.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_DVBSUBS.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_PGS.equals(str);
        }

        /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B_renamed:38:0x007d  */
        @Override // com.google.android.exoplayer2.text.SubtitleDecoderFactory
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.android.exoplayer2.text.SubtitleDecoder createDecoder(com.google.android.exoplayer2.Format r2) {
            /*
                Method dump skipped, instructions count: 284
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.SubtitleDecoderFactory.SceneLoader_2.createDecoder(com.google.android.exoplayer2.Format):com.google.android.exoplayer2.text.SubtitleDecoder");
        }
    };

    com.google.android.exoplayer2.text.SubtitleDecoder createDecoder(com.google.android.exoplayer2.Format format);

    boolean supportsFormat(com.google.android.exoplayer2.Format format);
}
