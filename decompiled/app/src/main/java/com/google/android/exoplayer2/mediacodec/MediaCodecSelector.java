package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes.dex */
public interface MediaCodecSelector {
    public static final com.google.android.exoplayer2.mediacodec.MediaCodecSelector DEFAULT = new com.google.android.exoplayer2.mediacodec.MediaCodecSelector() { // from class: com.google.android.exoplayer2.mediacodec.MediaCodecSelector.1
        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
        public java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfos(java.lang.String str, boolean z_renamed) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
            java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> decoderInfos = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getDecoderInfos(str, z_renamed);
            if (decoderInfos.isEmpty()) {
                return java.util.Collections.emptyList();
            }
            return java.util.Collections.singletonList(decoderInfos.get(0));
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
        public com.google.android.exoplayer2.mediacodec.MediaCodecInfo getPassthroughDecoderInfo() throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
            return com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getPassthroughDecoderInfo();
        }
    };
    public static final com.google.android.exoplayer2.mediacodec.MediaCodecSelector DEFAULT_WITH_FALLBACK = new com.google.android.exoplayer2.mediacodec.MediaCodecSelector() { // from class: com.google.android.exoplayer2.mediacodec.MediaCodecSelector.2
        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
        public java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfos(java.lang.String str, boolean z_renamed) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
            return com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getDecoderInfos(str, z_renamed);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
        public com.google.android.exoplayer2.mediacodec.MediaCodecInfo getPassthroughDecoderInfo() throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
            return com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getPassthroughDecoderInfo();
        }
    };

    java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfos(java.lang.String str, boolean z_renamed) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;

    com.google.android.exoplayer2.mediacodec.MediaCodecInfo getPassthroughDecoderInfo() throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
}
