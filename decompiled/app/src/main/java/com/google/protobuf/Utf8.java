package com.google.protobuf;

/* loaded from: classes.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final com.google.protobuf.Utf8.Processor processor;

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i_renamed) {
        if (i_renamed > -12) {
            return -1;
        }
        return i_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i_renamed, int i2) {
        if (i_renamed > -12 || i2 > -65) {
            return -1;
        }
        return i_renamed ^ (i2 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i_renamed, int i2, int i3) {
        if (i_renamed > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i_renamed ^ (i2 << 8)) ^ (i3 << 16);
    }

    static {
        processor = (!com.google.protobuf.Utf8.UnsafeProcessor.isAvailable() || com.google.protobuf.Android.isOnAndroidDevice()) ? new com.google.protobuf.Utf8.SafeProcessor() : new com.google.protobuf.Utf8.UnsafeProcessor();
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    public static boolean isValidUtf8(byte[] bArr, int i_renamed, int i2) {
        return processor.isValidUtf8(bArr, i_renamed, i2);
    }

    public static int partialIsValidUtf8(int i_renamed, byte[] bArr, int i2, int i3) {
        return processor.partialIsValidUtf8(i_renamed, bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i_renamed, int i2) {
        byte b2 = bArr[i_renamed - 1];
        int i3 = i2 - i_renamed;
        if (i3 == 0) {
            return incompleteStateFor(b2);
        }
        if (i3 == 1) {
            return incompleteStateFor(b2, bArr[i_renamed]);
        }
        if (i3 == 2) {
            return incompleteStateFor(b2, bArr[i_renamed], bArr[i_renamed + 1]);
        }
        throw new java.lang.AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(java.nio.ByteBuffer byteBuffer, int i_renamed, int i2, int i3) {
        if (i3 == 0) {
            return incompleteStateFor(i_renamed);
        }
        if (i3 == 1) {
            return incompleteStateFor(i_renamed, byteBuffer.get(i2));
        }
        if (i3 == 2) {
            return incompleteStateFor(i_renamed, byteBuffer.get(i2), byteBuffer.get(i2 + 1));
        }
        throw new java.lang.AssertionError();
    }

    static class UnpairedSurrogateException extends java.lang.IllegalArgumentException {
        UnpairedSurrogateException(int i_renamed, int i2) {
            super("Unpaired surrogate at_renamed index " + i_renamed + " of_renamed " + i2);
        }
    }

    static int encodedLength(java.lang.CharSequence charSequence) {
        int length = charSequence.length();
        int i_renamed = 0;
        while (i_renamed < length && charSequence.charAt(i_renamed) < 128) {
            i_renamed++;
        }
        int iEncodedLengthGeneral = length;
        while (true) {
            if (i_renamed < length) {
                char cCharAt = charSequence.charAt(i_renamed);
                if (cCharAt >= 2048) {
                    iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i_renamed);
                    break;
                }
                iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
                i_renamed++;
            } else {
                break;
            }
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new java.lang.IllegalArgumentException("UTF-8 length does not fit in_renamed int: " + (iEncodedLengthGeneral + com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1));
    }

    private static int encodedLengthGeneral(java.lang.CharSequence charSequence, int i_renamed) {
        int length = charSequence.length();
        int i2 = 0;
        while (i_renamed < length) {
            char cCharAt = charSequence.charAt(i_renamed);
            if (cCharAt < 2048) {
                i2 += (127 - cCharAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (java.lang.Character.codePointAt(charSequence, i_renamed) < 65536) {
                        throw new com.google.protobuf.Utf8.UnpairedSurrogateException(i_renamed, length);
                    }
                    i_renamed++;
                }
            }
            i_renamed++;
        }
        return i2;
    }

    static int encode(java.lang.CharSequence charSequence, byte[] bArr, int i_renamed, int i2) {
        return processor.encodeUtf8(charSequence, bArr, i_renamed, i2);
    }

    static boolean isValidUtf8(java.nio.ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    static int partialIsValidUtf8(int i_renamed, java.nio.ByteBuffer byteBuffer, int i2, int i3) {
        return processor.partialIsValidUtf8(i_renamed, byteBuffer, i2, i3);
    }

    static java.lang.String decodeUtf8(java.nio.ByteBuffer byteBuffer, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException {
        return processor.decodeUtf8(byteBuffer, i_renamed, i2);
    }

    static java.lang.String decodeUtf8(byte[] bArr, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException {
        return processor.decodeUtf8(bArr, i_renamed, i2);
    }

    static void encodeUtf8(java.lang.CharSequence charSequence, java.nio.ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(java.nio.ByteBuffer byteBuffer, int i_renamed, int i2) {
        int i3 = i2 - 7;
        int i4 = i_renamed;
        while (i4 < i3 && (byteBuffer.getLong(i4) & ASCII_MASK_LONG) == 0) {
            i4 += 8;
        }
        return i4 - i_renamed;
    }

    static abstract class Processor {
        abstract java.lang.String decodeUtf8(byte[] bArr, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException;

        abstract java.lang.String decodeUtf8Direct(java.nio.ByteBuffer byteBuffer, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException;

        abstract int encodeUtf8(java.lang.CharSequence charSequence, byte[] bArr, int i_renamed, int i2);

        abstract void encodeUtf8Direct(java.lang.CharSequence charSequence, java.nio.ByteBuffer byteBuffer);

        abstract int partialIsValidUtf8(int i_renamed, byte[] bArr, int i2, int i3);

        abstract int partialIsValidUtf8Direct(int i_renamed, java.nio.ByteBuffer byteBuffer, int i2, int i3);

        Processor() {
        }

        final boolean isValidUtf8(byte[] bArr, int i_renamed, int i2) {
            return partialIsValidUtf8(0, bArr, i_renamed, i2) == 0;
        }

        final boolean isValidUtf8(java.nio.ByteBuffer byteBuffer, int i_renamed, int i2) {
            return partialIsValidUtf8(0, byteBuffer, i_renamed, i2) == 0;
        }

        final int partialIsValidUtf8(int i_renamed, java.nio.ByteBuffer byteBuffer, int i2, int i3) {
            if (byteBuffer.hasArray()) {
                int iArrayOffset = byteBuffer.arrayOffset();
                return partialIsValidUtf8(i_renamed, byteBuffer.array(), i2 + iArrayOffset, iArrayOffset + i3);
            }
            if (byteBuffer.isDirect()) {
                return partialIsValidUtf8Direct(i_renamed, byteBuffer, i2, i3);
            }
            return partialIsValidUtf8Default(i_renamed, byteBuffer, i2, i3);
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:10:0x0017, code lost:
        
            if (r7.get(r8) > (-65)) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B_renamed:29:0x0048, code lost:
        
            if (r7.get(r8) > (-65)) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B_renamed:49:0x0086, code lost:
        
            if (r7.get(r6) > (-65)) goto L50;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final int partialIsValidUtf8Default(int r6, java.nio.ByteBuffer r7, int r8, int r9) {
            /*
                r5 = this;
                if (r6 == 0) goto L89
                if (r8 < r9) goto L5
                return r6
            L5:
                byte r5 = (byte) r6
                r0 = -32
                r1 = -1
                r2 = -65
                if (r5 >= r0) goto L1a
                r6 = -62
                if (r5 < r6) goto L19
                int r5 = r8 + 1
                byte r6 = r7.get(r8)
                if (r6 <= r2) goto L8a
            L19:
                return r1
            L1a:
                r3 = -16
                if (r5 >= r3) goto L4b
                int r6 = r6 >> 8
                int r6 = ~r6
                byte r6 = (byte) r6
                if (r6 != 0) goto L34
                int r6 = r8 + 1
                byte r8 = r7.get(r8)
                if (r6 < r9) goto L31
                int r5 = com.google.protobuf.Utf8.access$000(r5, r8)
                return r5
            L31:
                r4 = r8
                r8 = r6
                r6 = r4
            L34:
                if (r6 > r2) goto L4a
                r3 = -96
                if (r5 != r0) goto L3c
                if (r6 < r3) goto L4a
            L3c:
                r0 = -19
                if (r5 != r0) goto L42
                if (r6 >= r3) goto L4a
            L42:
                int r5 = r8 + 1
                byte r6 = r7.get(r8)
                if (r6 <= r2) goto L8a
            L4a:
                return r1
            L4b:
                int r0 = r6 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                r3 = 0
                if (r0 != 0) goto L5f
                int r6 = r8 + 1
                byte r0 = r7.get(r8)
                if (r6 < r9) goto L63
                int r5 = com.google.protobuf.Utf8.access$000(r5, r0)
                return r5
            L5f:
                int r6 = r6 >> 16
                byte r3 = (byte) r6
                r6 = r8
            L63:
                if (r3 != 0) goto L73
                int r8 = r6 + 1
                byte r3 = r7.get(r6)
                if (r8 < r9) goto L72
                int r5 = com.google.protobuf.Utf8.access$100(r5, r0, r3)
                return r5
            L72:
                r6 = r8
            L73:
                if (r0 > r2) goto L88
                int r5 = r5 << 28
                int r0 = r0 + 112
                int r5 = r5 + r0
                int r5 = r5 >> 30
                if (r5 != 0) goto L88
                if (r3 > r2) goto L88
                int r8 = r6 + 1
                byte r5 = r7.get(r6)
                if (r5 <= r2) goto L89
            L88:
                return r1
            L89:
                r5 = r8
            L8a:
                int r5 = partialIsValidUtf8(r7, r5, r9)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.Processor.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int partialIsValidUtf8(java.nio.ByteBuffer byteBuffer, int i_renamed, int i2) {
            int iEstimateConsecutiveAscii = i_renamed + com.google.protobuf.Utf8.estimateConsecutiveAscii(byteBuffer, i_renamed, i2);
            while (iEstimateConsecutiveAscii < i2) {
                int i3 = iEstimateConsecutiveAscii + 1;
                byte b2 = byteBuffer.get(iEstimateConsecutiveAscii);
                if (b2 < 0) {
                    if (b2 < -32) {
                        if (i3 >= i2) {
                            return b2;
                        }
                        if (b2 < -62 || byteBuffer.get(i3) > -65) {
                            return -1;
                        }
                        i3++;
                    } else {
                        if (b2 >= -16) {
                            if (i3 >= i2 - 2) {
                                return com.google.protobuf.Utf8.incompleteStateFor(byteBuffer, b2, i3, i2 - i3);
                            }
                            int i4 = i3 + 1;
                            byte b3 = byteBuffer.get(i3);
                            if (b3 <= -65 && (((b2 << 28) + (b3 + 112)) >> 30) == 0) {
                                int i5 = i4 + 1;
                                if (byteBuffer.get(i4) <= -65) {
                                    i3 = i5 + 1;
                                    if (byteBuffer.get(i5) > -65) {
                                    }
                                }
                            }
                            return -1;
                        }
                        if (i3 >= i2 - 1) {
                            return com.google.protobuf.Utf8.incompleteStateFor(byteBuffer, b2, i3, i2 - i3);
                        }
                        int i6 = i3 + 1;
                        byte b4 = byteBuffer.get(i3);
                        if (b4 > -65 || ((b2 == -32 && b4 < -96) || ((b2 == -19 && b4 >= -96) || byteBuffer.get(i6) > -65))) {
                            return -1;
                        }
                        iEstimateConsecutiveAscii = i6 + 1;
                    }
                }
                iEstimateConsecutiveAscii = i3;
            }
            return 0;
        }

        final java.lang.String decodeUtf8(java.nio.ByteBuffer byteBuffer, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i_renamed, i2);
            }
            if (byteBuffer.isDirect()) {
                return decodeUtf8Direct(byteBuffer, i_renamed, i2);
            }
            return decodeUtf8Default(byteBuffer, i_renamed, i2);
        }

        final java.lang.String decodeUtf8Default(java.nio.ByteBuffer byteBuffer, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException {
            if ((i_renamed | i2 | ((byteBuffer.limit() - i_renamed) - i2)) < 0) {
                throw new java.lang.ArrayIndexOutOfBoundsException(java.lang.String.format("buffer limit=%d_renamed, index=%d_renamed, limit=%d_renamed", java.lang.Integer.valueOf(byteBuffer.limit()), java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2)));
            }
            int i3 = i_renamed + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i_renamed < i3) {
                byte b2 = byteBuffer.get(i_renamed);
                if (!com.google.protobuf.Utf8.DecodeUtil.isOneByte(b2)) {
                    break;
                }
                i_renamed++;
                com.google.protobuf.Utf8.DecodeUtil.handleOneByte(b2, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i_renamed < i3) {
                int i6 = i_renamed + 1;
                byte b3 = byteBuffer.get(i_renamed);
                if (com.google.protobuf.Utf8.DecodeUtil.isOneByte(b3)) {
                    int i7 = i5 + 1;
                    com.google.protobuf.Utf8.DecodeUtil.handleOneByte(b3, cArr, i5);
                    while (i6 < i3) {
                        byte b4 = byteBuffer.get(i6);
                        if (!com.google.protobuf.Utf8.DecodeUtil.isOneByte(b4)) {
                            break;
                        }
                        i6++;
                        com.google.protobuf.Utf8.DecodeUtil.handleOneByte(b4, cArr, i7);
                        i7++;
                    }
                    i_renamed = i6;
                    i5 = i7;
                } else if (com.google.protobuf.Utf8.DecodeUtil.isTwoBytes(b3)) {
                    if (i6 >= i3) {
                        throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
                    }
                    com.google.protobuf.Utf8.DecodeUtil.handleTwoBytes(b3, byteBuffer.get(i6), cArr, i5);
                    i_renamed = i6 + 1;
                    i5++;
                } else if (com.google.protobuf.Utf8.DecodeUtil.isThreeBytes(b3)) {
                    if (i6 >= i3 - 1) {
                        throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i8 = i6 + 1;
                    com.google.protobuf.Utf8.DecodeUtil.handleThreeBytes(b3, byteBuffer.get(i6), byteBuffer.get(i8), cArr, i5);
                    i_renamed = i8 + 1;
                    i5++;
                } else {
                    if (i6 >= i3 - 2) {
                        throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i9 = i6 + 1;
                    byte b5 = byteBuffer.get(i6);
                    int i10 = i9 + 1;
                    com.google.protobuf.Utf8.DecodeUtil.handleFourBytes(b3, b5, byteBuffer.get(i9), byteBuffer.get(i10), cArr, i5);
                    i_renamed = i10 + 1;
                    i5 = i5 + 1 + 1;
                }
            }
            return new java.lang.String(cArr, 0, i5);
        }

        final void encodeUtf8(java.lang.CharSequence charSequence, java.nio.ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int iArrayOffset = byteBuffer.arrayOffset();
                byteBuffer.position(com.google.protobuf.Utf8.encode(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                encodeUtf8Default(charSequence, byteBuffer);
            }
        }

        final void encodeUtf8Default(java.lang.CharSequence charSequence, java.nio.ByteBuffer byteBuffer) {
            int length = charSequence.length();
            int iPosition = byteBuffer.position();
            int i_renamed = 0;
            while (i_renamed < length) {
                try {
                    char cCharAt = charSequence.charAt(i_renamed);
                    if (cCharAt >= 128) {
                        break;
                    }
                    byteBuffer.put(iPosition + i_renamed, (byte) cCharAt);
                    i_renamed++;
                } catch (java.lang.IndexOutOfBoundsException unused) {
                    throw new java.lang.ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i_renamed) + " at_renamed index " + (byteBuffer.position() + java.lang.Math.max(i_renamed, (iPosition - byteBuffer.position()) + 1)));
                }
            }
            if (i_renamed == length) {
                byteBuffer.position(iPosition + i_renamed);
                return;
            }
            iPosition += i_renamed;
            while (i_renamed < length) {
                char cCharAt2 = charSequence.charAt(i_renamed);
                if (cCharAt2 < 128) {
                    byteBuffer.put(iPosition, (byte) cCharAt2);
                } else if (cCharAt2 < 2048) {
                    int i2 = iPosition + 1;
                    try {
                        byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> 6) | 192));
                        byteBuffer.put(i2, (byte) ((cCharAt2 & '?') | 128));
                        iPosition = i2;
                    } catch (java.lang.IndexOutOfBoundsException unused2) {
                        iPosition = i2;
                        throw new java.lang.ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i_renamed) + " at_renamed index " + (byteBuffer.position() + java.lang.Math.max(i_renamed, (iPosition - byteBuffer.position()) + 1)));
                    }
                } else if (cCharAt2 < 55296 || 57343 < cCharAt2) {
                    int i3 = iPosition + 1;
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> '\f_renamed') | 224));
                    iPosition = i3 + 1;
                    byteBuffer.put(i3, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 & '?') | 128));
                } else {
                    int i4 = i_renamed + 1;
                    if (i4 != length) {
                        try {
                            char cCharAt3 = charSequence.charAt(i4);
                            if (java.lang.Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = java.lang.Character.toCodePoint(cCharAt2, cCharAt3);
                                int i5 = iPosition + 1;
                                try {
                                    byteBuffer.put(iPosition, (byte) ((codePoint >>> 18) | 240));
                                    int i6 = i5 + 1;
                                    byteBuffer.put(i5, (byte) (((codePoint >>> 12) & 63) | 128));
                                    int i7 = i6 + 1;
                                    byteBuffer.put(i6, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(i7, (byte) ((codePoint & 63) | 128));
                                    iPosition = i7;
                                    i_renamed = i4;
                                } catch (java.lang.IndexOutOfBoundsException unused3) {
                                    iPosition = i5;
                                    i_renamed = i4;
                                    throw new java.lang.ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i_renamed) + " at_renamed index " + (byteBuffer.position() + java.lang.Math.max(i_renamed, (iPosition - byteBuffer.position()) + 1)));
                                }
                            } else {
                                i_renamed = i4;
                            }
                        } catch (java.lang.IndexOutOfBoundsException unused4) {
                        }
                    }
                    throw new com.google.protobuf.Utf8.UnpairedSurrogateException(i_renamed, length);
                }
                i_renamed++;
                iPosition++;
            }
            byteBuffer.position(iPosition);
        }
    }

    static final class SafeProcessor extends com.google.protobuf.Utf8.Processor {
        SafeProcessor() {
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:10:0x0015, code lost:
        
            if (r7[r8] > (-65)) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B_renamed:29:0x0042, code lost:
        
            if (r7[r8] > (-65)) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B_renamed:49:0x007a, code lost:
        
            if (r7[r6] > (-65)) goto L50;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int partialIsValidUtf8(int r6, byte[] r7, int r8, int r9) {
            /*
                r5 = this;
                if (r6 == 0) goto L7d
                if (r8 < r9) goto L5
                return r6
            L5:
                byte r5 = (byte) r6
                r0 = -32
                r1 = -1
                r2 = -65
                if (r5 >= r0) goto L18
                r6 = -62
                if (r5 < r6) goto L17
                int r5 = r8 + 1
                r6 = r7[r8]
                if (r6 <= r2) goto L7e
            L17:
                return r1
            L18:
                r3 = -16
                if (r5 >= r3) goto L45
                int r6 = r6 >> 8
                int r6 = ~r6
                byte r6 = (byte) r6
                if (r6 != 0) goto L30
                int r6 = r8 + 1
                r8 = r7[r8]
                if (r6 < r9) goto L2d
                int r5 = com.google.protobuf.Utf8.access$000(r5, r8)
                return r5
            L2d:
                r4 = r8
                r8 = r6
                r6 = r4
            L30:
                if (r6 > r2) goto L44
                r3 = -96
                if (r5 != r0) goto L38
                if (r6 < r3) goto L44
            L38:
                r0 = -19
                if (r5 != r0) goto L3e
                if (r6 >= r3) goto L44
            L3e:
                int r5 = r8 + 1
                r6 = r7[r8]
                if (r6 <= r2) goto L7e
            L44:
                return r1
            L45:
                int r0 = r6 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                r3 = 0
                if (r0 != 0) goto L57
                int r6 = r8 + 1
                r0 = r7[r8]
                if (r6 < r9) goto L5b
                int r5 = com.google.protobuf.Utf8.access$000(r5, r0)
                return r5
            L57:
                int r6 = r6 >> 16
                byte r3 = (byte) r6
                r6 = r8
            L5b:
                if (r3 != 0) goto L69
                int r8 = r6 + 1
                r3 = r7[r6]
                if (r8 < r9) goto L68
                int r5 = com.google.protobuf.Utf8.access$100(r5, r0, r3)
                return r5
            L68:
                r6 = r8
            L69:
                if (r0 > r2) goto L7c
                int r5 = r5 << 28
                int r0 = r0 + 112
                int r5 = r5 + r0
                int r5 = r5 >> 30
                if (r5 != 0) goto L7c
                if (r3 > r2) goto L7c
                int r8 = r6 + 1
                r5 = r7[r6]
                if (r5 <= r2) goto L7d
            L7c:
                return r1
            L7d:
                r5 = r8
            L7e:
                int r5 = partialIsValidUtf8(r7, r5, r9)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int i_renamed, java.nio.ByteBuffer byteBuffer, int i2, int i3) {
            return partialIsValidUtf8Default(i_renamed, byteBuffer, i2, i3);
        }

        @Override // com.google.protobuf.Utf8.Processor
        java.lang.String decodeUtf8(byte[] bArr, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException {
            if ((i_renamed | i2 | ((bArr.length - i_renamed) - i2)) < 0) {
                throw new java.lang.ArrayIndexOutOfBoundsException(java.lang.String.format("buffer length=%d_renamed, index=%d_renamed, size=%d_renamed", java.lang.Integer.valueOf(bArr.length), java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2)));
            }
            int i3 = i_renamed + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i_renamed < i3) {
                byte b2 = bArr[i_renamed];
                if (!com.google.protobuf.Utf8.DecodeUtil.isOneByte(b2)) {
                    break;
                }
                i_renamed++;
                com.google.protobuf.Utf8.DecodeUtil.handleOneByte(b2, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i_renamed < i3) {
                int i6 = i_renamed + 1;
                byte b3 = bArr[i_renamed];
                if (com.google.protobuf.Utf8.DecodeUtil.isOneByte(b3)) {
                    int i7 = i5 + 1;
                    com.google.protobuf.Utf8.DecodeUtil.handleOneByte(b3, cArr, i5);
                    while (i6 < i3) {
                        byte b4 = bArr[i6];
                        if (!com.google.protobuf.Utf8.DecodeUtil.isOneByte(b4)) {
                            break;
                        }
                        i6++;
                        com.google.protobuf.Utf8.DecodeUtil.handleOneByte(b4, cArr, i7);
                        i7++;
                    }
                    i_renamed = i6;
                    i5 = i7;
                } else if (com.google.protobuf.Utf8.DecodeUtil.isTwoBytes(b3)) {
                    if (i6 >= i3) {
                        throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
                    }
                    com.google.protobuf.Utf8.DecodeUtil.handleTwoBytes(b3, bArr[i6], cArr, i5);
                    i_renamed = i6 + 1;
                    i5++;
                } else if (com.google.protobuf.Utf8.DecodeUtil.isThreeBytes(b3)) {
                    if (i6 >= i3 - 1) {
                        throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i8 = i6 + 1;
                    com.google.protobuf.Utf8.DecodeUtil.handleThreeBytes(b3, bArr[i6], bArr[i8], cArr, i5);
                    i_renamed = i8 + 1;
                    i5++;
                } else {
                    if (i6 >= i3 - 2) {
                        throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i9 = i6 + 1;
                    byte b5 = bArr[i6];
                    int i10 = i9 + 1;
                    com.google.protobuf.Utf8.DecodeUtil.handleFourBytes(b3, b5, bArr[i9], bArr[i10], cArr, i5);
                    i_renamed = i10 + 1;
                    i5 = i5 + 1 + 1;
                }
            }
            return new java.lang.String(cArr, 0, i5);
        }

        @Override // com.google.protobuf.Utf8.Processor
        java.lang.String decodeUtf8Direct(java.nio.ByteBuffer byteBuffer, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException {
            return decodeUtf8Default(byteBuffer, i_renamed, i2);
        }

        @Override // com.google.protobuf.Utf8.Processor
        int encodeUtf8(java.lang.CharSequence charSequence, byte[] bArr, int i_renamed, int i2) {
            int i3;
            int i4;
            int i5;
            char cCharAt;
            int length = charSequence.length();
            int i6 = i2 + i_renamed;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i_renamed) < i6 && (cCharAt = charSequence.charAt(i7)) < 128) {
                bArr[i5] = (byte) cCharAt;
                i7++;
            }
            if (i7 == length) {
                return i_renamed + length;
            }
            int i8 = i_renamed + i7;
            while (i7 < length) {
                char cCharAt2 = charSequence.charAt(i7);
                if (cCharAt2 >= 128 || i8 >= i6) {
                    if (cCharAt2 < 2048 && i8 <= i6 - 2) {
                        int i9 = i8 + 1;
                        bArr[i8] = (byte) ((cCharAt2 >>> 6) | com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_960);
                        i8 = i9 + 1;
                        bArr[i9] = (byte) ((cCharAt2 & '?') | 128);
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i8 > i6 - 3) {
                            if (i8 <= i6 - 4) {
                                int i10 = i7 + 1;
                                if (i10 != charSequence.length()) {
                                    char cCharAt3 = charSequence.charAt(i10);
                                    if (java.lang.Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                        int codePoint = java.lang.Character.toCodePoint(cCharAt2, cCharAt3);
                                        int i11 = i8 + 1;
                                        bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                                        int i12 = i11 + 1;
                                        bArr[i11] = (byte) (((codePoint >>> 12) & 63) | 128);
                                        int i13 = i12 + 1;
                                        bArr[i12] = (byte) (((codePoint >>> 6) & 63) | 128);
                                        i8 = i13 + 1;
                                        bArr[i13] = (byte) ((codePoint & 63) | 128);
                                        i7 = i10;
                                    } else {
                                        i7 = i10;
                                    }
                                }
                                throw new com.google.protobuf.Utf8.UnpairedSurrogateException(i7 - 1, length);
                            }
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i7 + 1) == charSequence.length() || !java.lang.Character.isSurrogatePair(cCharAt2, charSequence.charAt(i4)))) {
                                throw new com.google.protobuf.Utf8.UnpairedSurrogateException(i7, length);
                            }
                            throw new java.lang.ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at_renamed index " + i8);
                        }
                        int i14 = i8 + 1;
                        bArr[i8] = (byte) ((cCharAt2 >>> '\f_renamed') | com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_480);
                        int i15 = i14 + 1;
                        bArr[i14] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                        i3 = i15 + 1;
                        bArr[i15] = (byte) ((cCharAt2 & '?') | 128);
                    }
                    i7++;
                } else {
                    i3 = i8 + 1;
                    bArr[i8] = (byte) cCharAt2;
                }
                i8 = i3;
                i7++;
            }
            return i8;
        }

        @Override // com.google.protobuf.Utf8.Processor
        void encodeUtf8Direct(java.lang.CharSequence charSequence, java.nio.ByteBuffer byteBuffer) {
            encodeUtf8Default(charSequence, byteBuffer);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i_renamed, int i2) {
            while (i_renamed < i2 && bArr[i_renamed] >= 0) {
                i_renamed++;
            }
            if (i_renamed >= i2) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i_renamed, i2);
        }

        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i_renamed, int i2) {
            while (i_renamed < i2) {
                int i3 = i_renamed + 1;
                byte b2 = bArr[i_renamed];
                if (b2 < 0) {
                    if (b2 < -32) {
                        if (i3 >= i2) {
                            return b2;
                        }
                        if (b2 >= -62) {
                            i_renamed = i3 + 1;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b2 >= -16) {
                        if (i3 >= i2 - 2) {
                            return com.google.protobuf.Utf8.incompleteStateFor(bArr, i3, i2);
                        }
                        int i4 = i3 + 1;
                        byte b3 = bArr[i3];
                        if (b3 <= -65 && (((b2 << 28) + (b3 + 112)) >> 30) == 0) {
                            int i5 = i4 + 1;
                            if (bArr[i4] <= -65) {
                                i3 = i5 + 1;
                                if (bArr[i5] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i3 >= i2 - 1) {
                        return com.google.protobuf.Utf8.incompleteStateFor(bArr, i3, i2);
                    }
                    int i6 = i3 + 1;
                    byte b4 = bArr[i3];
                    if (b4 <= -65 && ((b2 != -32 || b4 >= -96) && (b2 != -19 || b4 < -96))) {
                        i_renamed = i6 + 1;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return -1;
                }
                i_renamed = i3;
            }
            return 0;
        }
    }

    static final class UnsafeProcessor extends com.google.protobuf.Utf8.Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            return com.google.protobuf.UnsafeUtil.hasUnsafeArrayOperations() && com.google.protobuf.UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:14:0x0025, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r12, r1) > (-65)) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B_renamed:33:0x0056, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r12, r1) > (-65)) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B_renamed:54:0x0098, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r12, r1) > (-65)) goto L55;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int partialIsValidUtf8(int r11, byte[] r12, int r13, int r14) {
            /*
                Method dump skipped, instructions count: 199
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:14:0x002f, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r1) > (-65)) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B_renamed:33:0x0060, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r1) > (-65)) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B_renamed:54:0x00a2, code lost:
        
            if (com.google.protobuf.UnsafeUtil.getByte(r1) > (-65)) goto L55;
         */
        @Override // com.google.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int partialIsValidUtf8Direct(int r10, java.nio.ByteBuffer r11, int r12, int r13) {
            /*
                Method dump skipped, instructions count: 212
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        @Override // com.google.protobuf.Utf8.Processor
        java.lang.String decodeUtf8(byte[] bArr, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException {
            if ((i_renamed | i2 | ((bArr.length - i_renamed) - i2)) < 0) {
                throw new java.lang.ArrayIndexOutOfBoundsException(java.lang.String.format("buffer length=%d_renamed, index=%d_renamed, size=%d_renamed", java.lang.Integer.valueOf(bArr.length), java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2)));
            }
            int i3 = i_renamed + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i_renamed < i3) {
                byte b2 = com.google.protobuf.UnsafeUtil.getByte(bArr, i_renamed);
                if (!com.google.protobuf.Utf8.DecodeUtil.isOneByte(b2)) {
                    break;
                }
                i_renamed++;
                com.google.protobuf.Utf8.DecodeUtil.handleOneByte(b2, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i_renamed < i3) {
                int i6 = i_renamed + 1;
                byte b3 = com.google.protobuf.UnsafeUtil.getByte(bArr, i_renamed);
                if (com.google.protobuf.Utf8.DecodeUtil.isOneByte(b3)) {
                    int i7 = i5 + 1;
                    com.google.protobuf.Utf8.DecodeUtil.handleOneByte(b3, cArr, i5);
                    while (i6 < i3) {
                        byte b4 = com.google.protobuf.UnsafeUtil.getByte(bArr, i6);
                        if (!com.google.protobuf.Utf8.DecodeUtil.isOneByte(b4)) {
                            break;
                        }
                        i6++;
                        com.google.protobuf.Utf8.DecodeUtil.handleOneByte(b4, cArr, i7);
                        i7++;
                    }
                    i_renamed = i6;
                    i5 = i7;
                } else if (com.google.protobuf.Utf8.DecodeUtil.isTwoBytes(b3)) {
                    if (i6 >= i3) {
                        throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
                    }
                    com.google.protobuf.Utf8.DecodeUtil.handleTwoBytes(b3, com.google.protobuf.UnsafeUtil.getByte(bArr, i6), cArr, i5);
                    i_renamed = i6 + 1;
                    i5++;
                } else if (com.google.protobuf.Utf8.DecodeUtil.isThreeBytes(b3)) {
                    if (i6 >= i3 - 1) {
                        throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i8 = i6 + 1;
                    com.google.protobuf.Utf8.DecodeUtil.handleThreeBytes(b3, com.google.protobuf.UnsafeUtil.getByte(bArr, i6), com.google.protobuf.UnsafeUtil.getByte(bArr, i8), cArr, i5);
                    i_renamed = i8 + 1;
                    i5++;
                } else {
                    if (i6 >= i3 - 2) {
                        throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i9 = i6 + 1;
                    byte b5 = com.google.protobuf.UnsafeUtil.getByte(bArr, i6);
                    int i10 = i9 + 1;
                    com.google.protobuf.Utf8.DecodeUtil.handleFourBytes(b3, b5, com.google.protobuf.UnsafeUtil.getByte(bArr, i9), com.google.protobuf.UnsafeUtil.getByte(bArr, i10), cArr, i5);
                    i_renamed = i10 + 1;
                    i5 = i5 + 1 + 1;
                }
            }
            return new java.lang.String(cArr, 0, i5);
        }

        @Override // com.google.protobuf.Utf8.Processor
        java.lang.String decodeUtf8Direct(java.nio.ByteBuffer byteBuffer, int i_renamed, int i2) throws com.google.protobuf.InvalidProtocolBufferException {
            if ((i_renamed | i2 | ((byteBuffer.limit() - i_renamed) - i2)) < 0) {
                throw new java.lang.ArrayIndexOutOfBoundsException(java.lang.String.format("buffer limit=%d_renamed, index=%d_renamed, limit=%d_renamed", java.lang.Integer.valueOf(byteBuffer.limit()), java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2)));
            }
            long jAddressOffset = com.google.protobuf.UnsafeUtil.addressOffset(byteBuffer) + i_renamed;
            long j_renamed = i2 + jAddressOffset;
            char[] cArr = new char[i2];
            int i3 = 0;
            while (jAddressOffset < j_renamed) {
                byte b2 = com.google.protobuf.UnsafeUtil.getByte(jAddressOffset);
                if (!com.google.protobuf.Utf8.DecodeUtil.isOneByte(b2)) {
                    break;
                }
                jAddressOffset++;
                com.google.protobuf.Utf8.DecodeUtil.handleOneByte(b2, cArr, i3);
                i3++;
            }
            while (true) {
                int i4 = i3;
                while (jAddressOffset < j_renamed) {
                    long j2 = jAddressOffset + 1;
                    byte b3 = com.google.protobuf.UnsafeUtil.getByte(jAddressOffset);
                    if (com.google.protobuf.Utf8.DecodeUtil.isOneByte(b3)) {
                        int i5 = i4 + 1;
                        com.google.protobuf.Utf8.DecodeUtil.handleOneByte(b3, cArr, i4);
                        while (j2 < j_renamed) {
                            byte b4 = com.google.protobuf.UnsafeUtil.getByte(j2);
                            if (!com.google.protobuf.Utf8.DecodeUtil.isOneByte(b4)) {
                                break;
                            }
                            j2++;
                            com.google.protobuf.Utf8.DecodeUtil.handleOneByte(b4, cArr, i5);
                            i5++;
                        }
                        i4 = i5;
                        jAddressOffset = j2;
                    } else if (com.google.protobuf.Utf8.DecodeUtil.isTwoBytes(b3)) {
                        if (j2 >= j_renamed) {
                            throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
                        }
                        jAddressOffset = j2 + 1;
                        com.google.protobuf.Utf8.DecodeUtil.handleTwoBytes(b3, com.google.protobuf.UnsafeUtil.getByte(j2), cArr, i4);
                        i4++;
                    } else if (com.google.protobuf.Utf8.DecodeUtil.isThreeBytes(b3)) {
                        if (j2 >= j_renamed - 1) {
                            throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
                        }
                        long j3 = j2 + 1;
                        com.google.protobuf.Utf8.DecodeUtil.handleThreeBytes(b3, com.google.protobuf.UnsafeUtil.getByte(j2), com.google.protobuf.UnsafeUtil.getByte(j3), cArr, i4);
                        i4++;
                        jAddressOffset = j3 + 1;
                    } else {
                        if (j2 >= j_renamed - 2) {
                            throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
                        }
                        long j4 = j2 + 1;
                        byte b5 = com.google.protobuf.UnsafeUtil.getByte(j2);
                        long j5 = j4 + 1;
                        byte b6 = com.google.protobuf.UnsafeUtil.getByte(j4);
                        jAddressOffset = j5 + 1;
                        com.google.protobuf.Utf8.DecodeUtil.handleFourBytes(b3, b5, b6, com.google.protobuf.UnsafeUtil.getByte(j5), cArr, i4);
                        i3 = i4 + 1 + 1;
                    }
                }
                return new java.lang.String(cArr, 0, i4);
            }
        }

        @Override // com.google.protobuf.Utf8.Processor
        int encodeUtf8(java.lang.CharSequence charSequence, byte[] bArr, int i_renamed, int i2) {
            char c2;
            long j_renamed;
            long j2;
            long j3;
            char c3;
            int i3;
            char cCharAt;
            long j4 = i_renamed;
            long j5 = i2 + j4;
            int length = charSequence.length();
            if (length > i2 || bArr.length - i2 < i_renamed) {
                throw new java.lang.ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at_renamed index " + (i_renamed + i2));
            }
            int i4 = 0;
            while (true) {
                c2 = 128;
                j_renamed = 1;
                if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                    break;
                }
                com.google.protobuf.UnsafeUtil.putByte(bArr, j4, (byte) cCharAt);
                i4++;
                j4 = 1 + j4;
            }
            if (i4 == length) {
                return (int) j4;
            }
            while (i4 < length) {
                char cCharAt2 = charSequence.charAt(i4);
                if (cCharAt2 < c2 && j4 < j5) {
                    long j6 = j4 + j_renamed;
                    com.google.protobuf.UnsafeUtil.putByte(bArr, j4, (byte) cCharAt2);
                    j3 = j_renamed;
                    j2 = j6;
                    c3 = c2;
                } else if (cCharAt2 < 2048 && j4 <= j5 - 2) {
                    long j7 = j4 + j_renamed;
                    com.google.protobuf.UnsafeUtil.putByte(bArr, j4, (byte) ((cCharAt2 >>> 6) | com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_960));
                    long j8 = j7 + j_renamed;
                    com.google.protobuf.UnsafeUtil.putByte(bArr, j7, (byte) ((cCharAt2 & '?') | 128));
                    long j9 = j_renamed;
                    c3 = 128;
                    j2 = j8;
                    j3 = j9;
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j4 > j5 - 3) {
                        if (j4 <= j5 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char cCharAt3 = charSequence.charAt(i5);
                                if (java.lang.Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = java.lang.Character.toCodePoint(cCharAt2, cCharAt3);
                                    long j10 = j4 + 1;
                                    com.google.protobuf.UnsafeUtil.putByte(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                    long j11 = j10 + 1;
                                    c3 = 128;
                                    com.google.protobuf.UnsafeUtil.putByte(bArr, j10, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j12 = j11 + 1;
                                    com.google.protobuf.UnsafeUtil.putByte(bArr, j11, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j3 = 1;
                                    j2 = j12 + 1;
                                    com.google.protobuf.UnsafeUtil.putByte(bArr, j12, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new com.google.protobuf.Utf8.UnpairedSurrogateException(i4 - 1, length);
                        }
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i3 = i4 + 1) == length || !java.lang.Character.isSurrogatePair(cCharAt2, charSequence.charAt(i3)))) {
                            throw new com.google.protobuf.Utf8.UnpairedSurrogateException(i4, length);
                        }
                        throw new java.lang.ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at_renamed index " + j4);
                    }
                    long j13 = j4 + j_renamed;
                    com.google.protobuf.UnsafeUtil.putByte(bArr, j4, (byte) ((cCharAt2 >>> '\f_renamed') | com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_480));
                    long j14 = j13 + j_renamed;
                    com.google.protobuf.UnsafeUtil.putByte(bArr, j13, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    com.google.protobuf.UnsafeUtil.putByte(bArr, j14, (byte) ((cCharAt2 & '?') | 128));
                    j2 = j14 + 1;
                    j3 = 1;
                    c3 = 128;
                }
                i4++;
                c2 = c3;
                long j15 = j3;
                j4 = j2;
                j_renamed = j15;
            }
            return (int) j4;
        }

        @Override // com.google.protobuf.Utf8.Processor
        void encodeUtf8Direct(java.lang.CharSequence charSequence, java.nio.ByteBuffer byteBuffer) {
            char c2;
            long j_renamed;
            int i_renamed;
            int i2;
            long j2;
            char c3;
            char cCharAt;
            long jAddressOffset = com.google.protobuf.UnsafeUtil.addressOffset(byteBuffer);
            long jPosition = byteBuffer.position() + jAddressOffset;
            long jLimit = byteBuffer.limit() + jAddressOffset;
            int length = charSequence.length();
            if (length > jLimit - jPosition) {
                throw new java.lang.ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at_renamed index " + byteBuffer.limit());
            }
            int i3 = 0;
            while (true) {
                c2 = 128;
                if (i3 >= length || (cCharAt = charSequence.charAt(i3)) >= 128) {
                    break;
                }
                com.google.protobuf.UnsafeUtil.putByte(jPosition, (byte) cCharAt);
                i3++;
                jPosition++;
            }
            if (i3 == length) {
                byteBuffer.position((int) (jPosition - jAddressOffset));
                return;
            }
            while (i3 < length) {
                char cCharAt2 = charSequence.charAt(i3);
                if (cCharAt2 >= c2 || jPosition >= jLimit) {
                    if (cCharAt2 >= 2048 || jPosition > jLimit - 2) {
                        j_renamed = jAddressOffset;
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || jPosition > jLimit - 3) {
                            if (jPosition <= jLimit - 4) {
                                i2 = i3 + 1;
                                if (i2 != length) {
                                    char cCharAt3 = charSequence.charAt(i2);
                                    if (java.lang.Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                        int codePoint = java.lang.Character.toCodePoint(cCharAt2, cCharAt3);
                                        j2 = jLimit;
                                        long j3 = jPosition + 1;
                                        com.google.protobuf.UnsafeUtil.putByte(jPosition, (byte) ((codePoint >>> 18) | 240));
                                        long j4 = j3 + 1;
                                        c3 = 128;
                                        com.google.protobuf.UnsafeUtil.putByte(j3, (byte) (((codePoint >>> 12) & 63) | 128));
                                        long j5 = j4 + 1;
                                        com.google.protobuf.UnsafeUtil.putByte(j4, (byte) (((codePoint >>> 6) & 63) | 128));
                                        com.google.protobuf.UnsafeUtil.putByte(j5, (byte) ((codePoint & 63) | 128));
                                        jPosition = j5 + 1;
                                    }
                                } else {
                                    i2 = i3;
                                }
                                throw new com.google.protobuf.Utf8.UnpairedSurrogateException(i2 - 1, length);
                            }
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i_renamed = i3 + 1) == length || !java.lang.Character.isSurrogatePair(cCharAt2, charSequence.charAt(i_renamed)))) {
                                throw new com.google.protobuf.Utf8.UnpairedSurrogateException(i3, length);
                            }
                            throw new java.lang.ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at_renamed index " + jPosition);
                        }
                        long j6 = jPosition + 1;
                        com.google.protobuf.UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> '\f_renamed') | com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_480));
                        long j7 = j6 + 1;
                        com.google.protobuf.UnsafeUtil.putByte(j6, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        com.google.protobuf.UnsafeUtil.putByte(j7, (byte) ((cCharAt2 & '?') | 128));
                        jPosition = j7 + 1;
                    } else {
                        j_renamed = jAddressOffset;
                        long j8 = jPosition + 1;
                        com.google.protobuf.UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> 6) | com.oplus.ocs.camera.CameraParameter.VideoFps.FPS_960));
                        com.google.protobuf.UnsafeUtil.putByte(j8, (byte) ((cCharAt2 & '?') | 128));
                        jPosition = j8 + 1;
                    }
                    j2 = jLimit;
                    i2 = i3;
                    c3 = 128;
                } else {
                    com.google.protobuf.UnsafeUtil.putByte(jPosition, (byte) cCharAt2);
                    j2 = jLimit;
                    i2 = i3;
                    c3 = c2;
                    jPosition++;
                    j_renamed = jAddressOffset;
                }
                c2 = c3;
                jAddressOffset = j_renamed;
                jLimit = j2;
                i3 = i2 + 1;
            }
            byteBuffer.position((int) (jPosition - jAddressOffset));
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j_renamed, int i_renamed) {
            int i2 = 0;
            if (i_renamed < 16) {
                return 0;
            }
            while (i2 < i_renamed) {
                long j2 = 1 + j_renamed;
                if (com.google.protobuf.UnsafeUtil.getByte(bArr, j_renamed) < 0) {
                    return i2;
                }
                i2++;
                j_renamed = j2;
            }
            return i_renamed;
        }

        private static int unsafeEstimateConsecutiveAscii(long j_renamed, int i_renamed) {
            if (i_renamed < 16) {
                return 0;
            }
            int i2 = 8 - (((int) j_renamed) & 7);
            long j2 = j_renamed;
            int i3 = i2;
            while (i3 > 0) {
                long j3 = 1 + j2;
                if (com.google.protobuf.UnsafeUtil.getByte(j2) < 0) {
                    return i2 - i3;
                }
                i3--;
                j2 = j3;
            }
            int i4 = i_renamed - i2;
            while (i4 >= 8 && (com.google.protobuf.UnsafeUtil.getLong(j2) & com.google.protobuf.Utf8.ASCII_MASK_LONG) == 0) {
                j2 += 8;
                i4 -= 8;
            }
            return i_renamed - i4;
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B_renamed:39:0x0063, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int partialIsValidUtf8(byte[] r8, long r9, int r11) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r8, r9, r11)
                int r11 = r11 - r0
                long r0 = (long) r0
                long r9 = r9 + r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r11 <= 0) goto L1a
                long r4 = r9 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r8, r9)
                if (r1 < 0) goto L19
                int r11 = r11 + (-1)
                r9 = r4
                goto L9
            L19:
                r9 = r4
            L1a:
                if (r11 != 0) goto L1d
                return r0
            L1d:
                int r11 = r11 + (-1)
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L3a
                if (r11 != 0) goto L29
                return r1
            L29:
                int r11 = r11 + (-1)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.UnsafeUtil.getByte(r8, r9)
                if (r9 <= r4) goto L37
                goto L39
            L37:
                r9 = r2
                goto L7
            L39:
                return r5
            L3a:
                r6 = -16
                if (r1 >= r6) goto L64
                r6 = 2
                if (r11 >= r6) goto L46
                int r8 = unsafeIncompleteStateFor(r8, r1, r9, r11)
                return r8
            L46:
                int r11 = r11 + (-2)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.UnsafeUtil.getByte(r8, r9)
                if (r9 > r4) goto L63
                r10 = -96
                if (r1 != r0) goto L56
                if (r9 < r10) goto L63
            L56:
                r0 = -19
                if (r1 != r0) goto L5c
                if (r9 >= r10) goto L63
            L5c:
                long r2 = r2 + r6
                byte r9 = com.google.protobuf.UnsafeUtil.getByte(r8, r6)
                if (r9 <= r4) goto L37
            L63:
                return r5
            L64:
                r0 = 3
                if (r11 >= r0) goto L6c
                int r8 = unsafeIncompleteStateFor(r8, r1, r9, r11)
                return r8
            L6c:
                int r11 = r11 + (-3)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.UnsafeUtil.getByte(r8, r9)
                if (r9 > r4) goto L8e
                int r10 = r1 << 28
                int r9 = r9 + 112
                int r10 = r10 + r9
                int r9 = r10 >> 30
                if (r9 != 0) goto L8e
                long r9 = r6 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r8, r6)
                if (r0 > r4) goto L8e
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.UnsafeUtil.getByte(r8, r9)
                if (r9 <= r4) goto L37
            L8e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(byte[], long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B_renamed:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B_renamed:39:0x0063, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int partialIsValidUtf8(long r8, int r10) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r8, r10)
                long r1 = (long) r0
                long r8 = r8 + r1
                int r10 = r10 - r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r10 <= 0) goto L1a
                long r4 = r8 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r1 < 0) goto L19
                int r10 = r10 + (-1)
                r8 = r4
                goto L9
            L19:
                r8 = r4
            L1a:
                if (r10 != 0) goto L1d
                return r0
            L1d:
                int r10 = r10 + (-1)
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L3a
                if (r10 != 0) goto L29
                return r1
            L29:
                int r10 = r10 + (-1)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r8 <= r4) goto L37
                goto L39
            L37:
                r8 = r2
                goto L7
            L39:
                return r5
            L3a:
                r6 = -16
                if (r1 >= r6) goto L64
                r6 = 2
                if (r10 >= r6) goto L46
                int r8 = unsafeIncompleteStateFor(r8, r1, r10)
                return r8
            L46:
                int r10 = r10 + (-2)
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r8 > r4) goto L63
                r9 = -96
                if (r1 != r0) goto L56
                if (r8 < r9) goto L63
            L56:
                r0 = -19
                if (r1 != r0) goto L5c
                if (r8 >= r9) goto L63
            L5c:
                long r2 = r2 + r6
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r8 <= r4) goto L37
            L63:
                return r5
            L64:
                r0 = 3
                if (r10 >= r0) goto L6c
                int r8 = unsafeIncompleteStateFor(r8, r1, r10)
                return r8
            L6c:
                int r10 = r10 + (-3)
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r8 > r4) goto L8e
                int r9 = r1 << 28
                int r8 = r8 + 112
                int r9 = r9 + r8
                int r8 = r9 >> 30
                if (r8 != 0) goto L8e
                long r8 = r6 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r6)
                if (r0 > r4) goto L8e
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.UnsafeUtil.getByte(r8)
                if (r8 <= r4) goto L37
            L8e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(long, int):int");
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i_renamed, long j_renamed, int i2) {
            if (i2 == 0) {
                return com.google.protobuf.Utf8.incompleteStateFor(i_renamed);
            }
            if (i2 == 1) {
                return com.google.protobuf.Utf8.incompleteStateFor(i_renamed, com.google.protobuf.UnsafeUtil.getByte(bArr, j_renamed));
            }
            if (i2 == 2) {
                return com.google.protobuf.Utf8.incompleteStateFor(i_renamed, com.google.protobuf.UnsafeUtil.getByte(bArr, j_renamed), com.google.protobuf.UnsafeUtil.getByte(bArr, j_renamed + 1));
            }
            throw new java.lang.AssertionError();
        }

        private static int unsafeIncompleteStateFor(long j_renamed, int i_renamed, int i2) {
            if (i2 == 0) {
                return com.google.protobuf.Utf8.incompleteStateFor(i_renamed);
            }
            if (i2 == 1) {
                return com.google.protobuf.Utf8.incompleteStateFor(i_renamed, com.google.protobuf.UnsafeUtil.getByte(j_renamed));
            }
            if (i2 == 2) {
                return com.google.protobuf.Utf8.incompleteStateFor(i_renamed, com.google.protobuf.UnsafeUtil.getByte(j_renamed), com.google.protobuf.UnsafeUtil.getByte(j_renamed + 1));
            }
            throw new java.lang.AssertionError();
        }
    }

    private static class DecodeUtil {
        private static char highSurrogate(int i_renamed) {
            return (char) ((i_renamed >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b2) {
            return b2 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b2) {
            return b2 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b2) {
            return b2 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b2) {
            return b2 < -32;
        }

        private static char lowSurrogate(int i_renamed) {
            return (char) ((i_renamed & 1023) + 56320);
        }

        private static int trailingByteValue(byte b2) {
            return b2 & 63;
        }

        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b2, char[] cArr, int i_renamed) {
            cArr[i_renamed] = (char) b2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b2, byte b3, char[] cArr, int i_renamed) throws com.google.protobuf.InvalidProtocolBufferException {
            if (b2 < -62 || isNotTrailingByte(b3)) {
                throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i_renamed] = (char) (((b2 & 31) << 6) | trailingByteValue(b3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b2, byte b3, byte b4, char[] cArr, int i_renamed) throws com.google.protobuf.InvalidProtocolBufferException {
            if (isNotTrailingByte(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || isNotTrailingByte(b4)))) {
                throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i_renamed] = (char) (((b2 & 15) << 12) | (trailingByteValue(b3) << 6) | trailingByteValue(b4));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i_renamed) throws com.google.protobuf.InvalidProtocolBufferException {
            if (isNotTrailingByte(b3) || (((b2 << 28) + (b3 + 112)) >> 30) != 0 || isNotTrailingByte(b4) || isNotTrailingByte(b5)) {
                throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
            }
            int iTrailingByteValue = ((b2 & 7) << 18) | (trailingByteValue(b3) << 12) | (trailingByteValue(b4) << 6) | trailingByteValue(b5);
            cArr[i_renamed] = highSurrogate(iTrailingByteValue);
            cArr[i_renamed + 1] = lowSurrogate(iTrailingByteValue);
        }
    }

    private Utf8() {
    }
}
