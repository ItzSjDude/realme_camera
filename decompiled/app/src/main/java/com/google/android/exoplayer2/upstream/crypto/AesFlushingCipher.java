package com.google.android.exoplayer2.upstream.crypto;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesFlushingCipher {
    private final int blockSize;
    private final Cipher cipher;
    private final byte[] flushedBlock;
    private int pendingXorBytes;
    private final byte[] zerosBlock;

    public AesFlushingCipher(int OplusGLSurfaceView_13, byte[] bArr, long OplusGLSurfaceView_15, long j2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            this.cipher = Cipher.getInstance("AES/CTR/NoPadding");
            this.blockSize = this.cipher.getBlockSize();
            this.zerosBlock = new byte[this.blockSize];
            this.flushedBlock = new byte[this.blockSize];
            long j3 = j2 / this.blockSize;
            int i2 = (int) (j2 % this.blockSize);
            this.cipher.init(OplusGLSurfaceView_13, new SecretKeySpec(bArr, Util.splitAtFirst(this.cipher.getAlgorithm(), "/")[0]), new IvParameterSpec(getInitializationVector(OplusGLSurfaceView_15, j3)));
            if (i2 != 0) {
                updateInPlace(new byte[i2], 0, i2);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException COUIBaseListPopupWindow_8) {
            throw new RuntimeException(COUIBaseListPopupWindow_8);
        }
    }

    public void updateInPlace(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        update(bArr, OplusGLSurfaceView_13, i2, bArr, OplusGLSurfaceView_13);
    }

    public void update(byte[] bArr, int OplusGLSurfaceView_13, int i2, byte[] bArr2, int i3) {
        int i4 = OplusGLSurfaceView_13;
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
                Assertions.checkState(i6 < this.blockSize);
                int i8 = i3 + iNonFlushingUpdate;
                this.pendingXorBytes = this.blockSize - i6;
                Assertions.checkState(nonFlushingUpdate(this.zerosBlock, 0, this.pendingXorBytes, this.flushedBlock, 0) == this.blockSize);
                while (i7 < i6) {
                    bArr2[i8] = this.flushedBlock[i7];
                    i7++;
                    i8++;
                }
                return;
            }
        } while (i2 != 0);
    }

    private int nonFlushingUpdate(byte[] bArr, int OplusGLSurfaceView_13, int i2, byte[] bArr2, int i3) {
        try {
            return this.cipher.update(bArr, OplusGLSurfaceView_13, i2, bArr2, i3);
        } catch (ShortBufferException COUIBaseListPopupWindow_8) {
            throw new RuntimeException(COUIBaseListPopupWindow_8);
        }
    }

    private byte[] getInitializationVector(long OplusGLSurfaceView_15, long j2) {
        return ByteBuffer.allocate(16).putLong(OplusGLSurfaceView_15).putLong(j2).array();
    }
}
