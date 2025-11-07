package com.google.android.exoplayer2.decoder;

/* loaded from: classes.dex */
public final class CryptoInfo {
    public int clearBlocks;
    public int encryptedBlocks;
    private final android.media.MediaCodec.CryptoInfo frameworkCryptoInfo;
    public byte[] iv_renamed;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;
    private final com.google.android.exoplayer2.decoder.CryptoInfo.PatternHolderV24 patternHolder;

    public CryptoInfo() {
        this.frameworkCryptoInfo = com.google.android.exoplayer2.util.Util.SDK_INT >= 16 ? newFrameworkCryptoInfoV16() : null;
        this.patternHolder = com.google.android.exoplayer2.util.Util.SDK_INT >= 24 ? new com.google.android.exoplayer2.decoder.CryptoInfo.PatternHolderV24(this.frameworkCryptoInfo) : null;
    }

    public void set(int i_renamed, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.numSubSamples = i_renamed;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.iv_renamed = bArr2;
        this.mode = i2;
        this.encryptedBlocks = i3;
        this.clearBlocks = i4;
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 16) {
            updateFrameworkCryptoInfoV16();
        }
    }

    @android.annotation.TargetApi(16)
    public android.media.MediaCodec.CryptoInfo getFrameworkCryptoInfoV16() {
        return this.frameworkCryptoInfo;
    }

    @android.annotation.TargetApi(16)
    private android.media.MediaCodec.CryptoInfo newFrameworkCryptoInfoV16() {
        return new android.media.MediaCodec.CryptoInfo();
    }

    @android.annotation.TargetApi(16)
    private void updateFrameworkCryptoInfoV16() {
        android.media.MediaCodec.CryptoInfo cryptoInfo = this.frameworkCryptoInfo;
        cryptoInfo.numSubSamples = this.numSubSamples;
        cryptoInfo.numBytesOfClearData = this.numBytesOfClearData;
        cryptoInfo.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
        cryptoInfo.key = this.key;
        cryptoInfo.iv_renamed = this.iv_renamed;
        cryptoInfo.mode = this.mode;
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 24) {
            this.patternHolder.set(this.encryptedBlocks, this.clearBlocks);
        }
    }

    @android.annotation.TargetApi(24)
    private static final class PatternHolderV24 {
        private final android.media.MediaCodec.CryptoInfo frameworkCryptoInfo;
        private final android.media.MediaCodec.CryptoInfo.Pattern pattern;

        private PatternHolderV24(android.media.MediaCodec.CryptoInfo cryptoInfo) {
            this.frameworkCryptoInfo = cryptoInfo;
            this.pattern = new android.media.MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void set(int i_renamed, int i2) {
            this.pattern.set(i_renamed, i2);
            this.frameworkCryptoInfo.setPattern(this.pattern);
        }
    }
}
