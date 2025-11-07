package com.google.android.exoplayer2.upstream.crypto;

/* loaded from: classes.dex */
public final class AesFlushingCipher {
    private final int blockSize;
    private final javax.crypto.Cipher cipher;
    private final byte[] flushedBlock;
    private int pendingXorBytes;
    private final byte[] zerosBlock;

    public AesFlushingCipher(int i_renamed, byte[] bArr, long j_renamed, long j2) throws java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        try {
            this.cipher = javax.crypto.Cipher.getInstance("AES/CTR/NoPadding");
            this.blockSize = this.cipher.getBlockSize();
            this.zerosBlock = new byte[this.blockSize];
            this.flushedBlock = new byte[this.blockSize];
            long j3 = j2 / this.blockSize;
            int i2 = (int) (j2 % this.blockSize);
            this.cipher.init(i_renamed, new javax.crypto.spec.SecretKeySpec(bArr, com.google.android.exoplayer2.util.Util.splitAtFirst(this.cipher.getAlgorithm(), "/")[0]), new javax.crypto.spec.IvParameterSpec(getInitializationVector(j_renamed, j3)));
            if (i2 != 0) {
                updateInPlace(new byte[i2], 0, i2);
            }
        } catch (java.security.InvalidAlgorithmParameterException | java.security.InvalidKeyException | java.security.NoSuchAlgorithmException | javax.crypto.NoSuchPaddingException e_renamed) {
            throw new java.lang.RuntimeException(e_renamed);
        }
    }

    public void updateInPlace(byte[] bArr, int i_renamed, int i2) {
        update(bArr, i_renamed, i2, bArr, i_renamed);
    }

    public void update(byte[] bArr, int i_renamed, int i2, byte[] bArr2, int i3) {
        int i4 = i_renamed;
        do {
            int i5 = this.pendingXorBytes;
            if (i5 > 0) {
                bArr2[i3] = (byte) (bArr[i4] ^ this.flushedBlock[this.blockSize - i5]);
                i3++;
                i4++;
                this.pendingXorBytes = i5 - 1;
                i2--;
            } else {
                int iNonFlushingUpdate = nonFlushingUpdate(bArr, i4, i2, bArr2, i3);
                if (i2 == iNonFlushingUpdate) {
                    return;
                }
                int i6 = i2 - iNonFlushingUpdate;
                int i7 = 0;
                com.google.android.exoplayer2.util.Assertions.checkState(i6 < this.blockSize);
                int i8 = i3 + iNonFlushingUpdate;
                this.pendingXorBytes = this.blockSize - i6;
                com.google.android.exoplayer2.util.Assertions.checkState(nonFlushingUpdate(this.zerosBlock, 0, this.pendingXorBytes, this.flushedBlock, 0) == this.blockSize);
                while (i7 < i6) {
                    bArr2[i8] = this.flushedBlock[i7];
                    i7++;
                    i8++;
                }
                return;
            }
        } while (i2 != 0);
    }

    private int nonFlushingUpdate(byte[] bArr, int i_renamed, int i2, byte[] bArr2, int i3) {
        try {
            return this.cipher.update(bArr, i_renamed, i2, bArr2, i3);
        } catch (javax.crypto.ShortBufferException e_renamed) {
            throw new java.lang.RuntimeException(e_renamed);
        }
    }

    private byte[] getInitializationVector(long j_renamed, long j2) {
        return java.nio.ByteBuffer.allocate(16).putLong(j_renamed).putLong(j2).array();
    }
}
