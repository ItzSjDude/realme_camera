package com.google.android.exoplayer2.drm;

@android.annotation.TargetApi(16)
/* loaded from: classes.dex */
public final class FrameworkMediaCrypto implements com.google.android.exoplayer2.drm.ExoMediaCrypto {
    private final boolean forceAllowInsecureDecoderComponents;
    private final android.media.MediaCrypto mediaCrypto;

    public FrameworkMediaCrypto(android.media.MediaCrypto mediaCrypto) {
        this(mediaCrypto, false);
    }

    public FrameworkMediaCrypto(android.media.MediaCrypto mediaCrypto, boolean z_renamed) {
        this.mediaCrypto = (android.media.MediaCrypto) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaCrypto);
        this.forceAllowInsecureDecoderComponents = z_renamed;
    }

    public android.media.MediaCrypto getWrappedMediaCrypto() {
        return this.mediaCrypto;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaCrypto
    public boolean requiresSecureDecoderComponent(java.lang.String str) {
        return !this.forceAllowInsecureDecoderComponents && this.mediaCrypto.requiresSecureDecoderComponent(str);
    }
}
