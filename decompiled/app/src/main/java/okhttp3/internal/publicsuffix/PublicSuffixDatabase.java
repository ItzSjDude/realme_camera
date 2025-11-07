package okhttp3.internal.publicsuffix;

/* loaded from: classes2.dex */
public final class PublicSuffixDatabase {
    private static final byte EXCEPTION_MARKER = 33;
    public static final java.lang.String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz_renamed";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private static final byte[] WILDCARD_LABEL = {42};
    private static final java.lang.String[] EMPTY_RULE = new java.lang.String[0];
    private static final java.lang.String[] PREVAILING_RULE = {"*"};
    private static final okhttp3.internal.publicsuffix.PublicSuffixDatabase instance = new okhttp3.internal.publicsuffix.PublicSuffixDatabase();
    private final java.util.concurrent.atomic.AtomicBoolean listRead = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final java.util.concurrent.CountDownLatch readCompleteLatch = new java.util.concurrent.CountDownLatch(1);

    public static okhttp3.internal.publicsuffix.PublicSuffixDatabase get() {
        return instance;
    }

    public java.lang.String getEffectiveTldPlusOne(java.lang.String str) throws java.lang.InterruptedException {
        int length;
        int length2;
        if (str == null) {
            throw new java.lang.NullPointerException("domain == null");
        }
        java.lang.String[] strArrSplit = java.net.IDN.toUnicode(str).split("\\.");
        java.lang.String[] strArrFindMatchingRule = findMatchingRule(strArrSplit);
        if (strArrSplit.length == strArrFindMatchingRule.length && strArrFindMatchingRule[0].charAt(0) != '!') {
            return null;
        }
        if (strArrFindMatchingRule[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrFindMatchingRule.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrFindMatchingRule.length + 1;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String[] strArrSplit2 = str.split("\\.");
        for (int i_renamed = length - length2; i_renamed < strArrSplit2.length; i_renamed++) {
            sb.append(strArrSplit2[i_renamed]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private java.lang.String[] findMatchingRule(java.lang.String[] strArr) throws java.lang.InterruptedException {
        java.lang.String strBinarySearchBytes;
        java.lang.String strBinarySearchBytes2;
        java.lang.String strBinarySearchBytes3;
        java.lang.String[] strArrSplit;
        java.lang.String[] strArrSplit2;
        if (!this.listRead.get() && this.listRead.compareAndSet(false, true)) {
            readTheListUninterruptibly();
        } else {
            try {
                this.readCompleteLatch.await();
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
            }
        }
        synchronized (this) {
            if (this.publicSuffixListBytes == null) {
                throw new java.lang.IllegalStateException("Unable to load publicsuffixes.gz_renamed resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length][];
        for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
            bArr[i_renamed] = strArr[i_renamed].getBytes(okhttp3.internal.Util.UTF_8);
        }
        int i2 = 0;
        while (true) {
            if (i2 >= bArr.length) {
                strBinarySearchBytes = null;
                break;
            }
            strBinarySearchBytes = binarySearchBytes(this.publicSuffixListBytes, bArr, i2);
            if (strBinarySearchBytes != null) {
                break;
            }
            i2++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i3 = 0; i3 < bArr2.length - 1; i3++) {
                bArr2[i3] = WILDCARD_LABEL;
                strBinarySearchBytes2 = binarySearchBytes(this.publicSuffixListBytes, bArr2, i3);
                if (strBinarySearchBytes2 != null) {
                    break;
                }
            }
            strBinarySearchBytes2 = null;
        } else {
            strBinarySearchBytes2 = null;
        }
        if (strBinarySearchBytes2 != null) {
            for (int i4 = 0; i4 < bArr.length - 1; i4++) {
                strBinarySearchBytes3 = binarySearchBytes(this.publicSuffixExceptionListBytes, bArr, i4);
                if (strBinarySearchBytes3 != null) {
                    break;
                }
            }
            strBinarySearchBytes3 = null;
        } else {
            strBinarySearchBytes3 = null;
        }
        if (strBinarySearchBytes3 != null) {
            return ("!" + strBinarySearchBytes3).split("\\.");
        }
        if (strBinarySearchBytes == null && strBinarySearchBytes2 == null) {
            return PREVAILING_RULE;
        }
        if (strBinarySearchBytes != null) {
            strArrSplit = strBinarySearchBytes.split("\\.");
        } else {
            strArrSplit = EMPTY_RULE;
        }
        if (strBinarySearchBytes2 != null) {
            strArrSplit2 = strBinarySearchBytes2.split("\\.");
        } else {
            strArrSplit2 = EMPTY_RULE;
        }
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    private static java.lang.String binarySearchBytes(byte[] bArr, byte[][] bArr2, int i_renamed) {
        int i2;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i_renamed;
            boolean z_renamed = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z_renamed) {
                    i3 = 46;
                    z_renamed = false;
                } else {
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length == i11) {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        i11 = -1;
                        z_renamed = true;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new java.lang.String(bArr, i7, i9, okhttp3.internal.Util.UTF_8);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    private void readTheListUninterruptibly() {
        boolean z_renamed = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (java.io.InterruptedIOException unused) {
                    java.lang.Thread.interrupted();
                    z_renamed = true;
                } catch (java.io.IOException e_renamed) {
                    okhttp3.internal.platform.Platform.get().log(5, "Failed to read public suffix list", e_renamed);
                    if (z_renamed) {
                        java.lang.Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (java.lang.Throwable th) {
                if (z_renamed) {
                    java.lang.Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z_renamed) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    private void readTheList() throws java.io.IOException {
        java.io.InputStream resourceAsStream = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        okio.BufferedSource bufferedSourceBuffer = okio.Okio.buffer(new okio.GzipSource(okio.Okio.source(resourceAsStream)));
        try {
            byte[] bArr = new byte[bufferedSourceBuffer.readInt()];
            bufferedSourceBuffer.readFully(bArr);
            byte[] bArr2 = new byte[bufferedSourceBuffer.readInt()];
            bufferedSourceBuffer.readFully(bArr2);
            synchronized (this) {
                this.publicSuffixListBytes = bArr;
                this.publicSuffixExceptionListBytes = bArr2;
            }
            this.readCompleteLatch.countDown();
        } finally {
            okhttp3.internal.Util.closeQuietly(bufferedSourceBuffer);
        }
    }

    void setListBytes(byte[] bArr, byte[] bArr2) {
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
