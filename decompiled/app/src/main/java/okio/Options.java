package okio;

/* loaded from: classes2.dex */
public final class Options extends java.util.AbstractList<okio.ByteString> implements java.util.RandomAccess {
    final okio.ByteString[] byteStrings;
    final int[] trie;

    private Options(okio.ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:51:0x00bc, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static okio.Options of_renamed(okio.ByteString... r10) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Options.of_renamed(okio.ByteString[]):okio.Options");
    }

    private static void buildTrieRecursive(long j_renamed, okio.Buffer buffer, int i_renamed, java.util.List<okio.ByteString> list, int i2, int i3, java.util.List<java.lang.Integer> list2) {
        int i4;
        int i5;
        int i6;
        okio.Buffer buffer2;
        int i7 = i2;
        if (i7 >= i3) {
            throw new java.lang.AssertionError();
        }
        for (int i8 = i7; i8 < i3; i8++) {
            if (list.get(i8).size() < i_renamed) {
                throw new java.lang.AssertionError();
            }
        }
        okio.ByteString byteString = list.get(i2);
        okio.ByteString byteString2 = list.get(i3 - 1);
        int iIntValue = -1;
        if (i_renamed == byteString.size()) {
            iIntValue = list2.get(i7).intValue();
            i7++;
            byteString = list.get(i7);
        }
        int i9 = i7;
        if (byteString.getByte(i_renamed) != byteString2.getByte(i_renamed)) {
            int i10 = 1;
            for (int i11 = i9 + 1; i11 < i3; i11++) {
                if (list.get(i11 - 1).getByte(i_renamed) != list.get(i11).getByte(i_renamed)) {
                    i10++;
                }
            }
            long jIntCount = j_renamed + intCount(buffer) + 2 + (i10 * 2);
            buffer.writeInt(i10);
            buffer.writeInt(iIntValue);
            for (int i12 = i9; i12 < i3; i12++) {
                byte b2 = list.get(i12).getByte(i_renamed);
                if (i12 == i9 || b2 != list.get(i12 - 1).getByte(i_renamed)) {
                    buffer.writeInt(b2 & 255);
                }
            }
            okio.Buffer buffer3 = new okio.Buffer();
            int i13 = i9;
            while (i13 < i3) {
                byte b3 = list.get(i13).getByte(i_renamed);
                int i14 = i13 + 1;
                int i15 = i14;
                while (true) {
                    if (i15 >= i3) {
                        i5 = i3;
                        break;
                    } else {
                        if (b3 != list.get(i15).getByte(i_renamed)) {
                            i5 = i15;
                            break;
                        }
                        i15++;
                    }
                }
                if (i14 == i5 && i_renamed + 1 == list.get(i13).size()) {
                    buffer.writeInt(list2.get(i13).intValue());
                    i6 = i5;
                    buffer2 = buffer3;
                } else {
                    buffer.writeInt((int) ((intCount(buffer3) + jIntCount) * (-1)));
                    i6 = i5;
                    buffer2 = buffer3;
                    buildTrieRecursive(jIntCount, buffer3, i_renamed + 1, list, i13, i5, list2);
                }
                buffer3 = buffer2;
                i13 = i6;
            }
            okio.Buffer buffer4 = buffer3;
            buffer.write(buffer4, buffer4.size());
            return;
        }
        int iMin = java.lang.Math.min(byteString.size(), byteString2.size());
        int i16 = 0;
        for (int i17 = i_renamed; i17 < iMin && byteString.getByte(i17) == byteString2.getByte(i17); i17++) {
            i16++;
        }
        long jIntCount2 = 1 + j_renamed + intCount(buffer) + 2 + i16;
        buffer.writeInt(-i16);
        buffer.writeInt(iIntValue);
        int i18 = i_renamed;
        while (true) {
            i4 = i_renamed + i16;
            if (i18 >= i4) {
                break;
            }
            buffer.writeInt(byteString.getByte(i18) & 255);
            i18++;
        }
        if (i9 + 1 == i3) {
            if (i4 != list.get(i9).size()) {
                throw new java.lang.AssertionError();
            }
            buffer.writeInt(list2.get(i9).intValue());
        } else {
            okio.Buffer buffer5 = new okio.Buffer();
            buffer.writeInt((int) ((intCount(buffer5) + jIntCount2) * (-1)));
            buildTrieRecursive(jIntCount2, buffer5, i4, list, i9, i3, list2);
            buffer.write(buffer5, buffer5.size());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public okio.ByteString get(int i_renamed) {
        return this.byteStrings[i_renamed];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }

    private static int intCount(okio.Buffer buffer) {
        return (int) (buffer.size() / 4);
    }
}
