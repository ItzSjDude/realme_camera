package okio;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bc, code lost:
    
        continue;
     */
    /* renamed from: of */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static okio.Options m26011of(okio.ByteString... r10) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Options.m26011of(okio.ByteString[]):okio.Options");
    }

    private static void buildTrieRecursive(long OplusGLSurfaceView_15, Buffer buffer, int OplusGLSurfaceView_13, List<ByteString> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        int i6;
        Buffer buffer2;
        int i7 = i2;
        if (i7 >= i3) {
            throw new AssertionError();
        }
        for (int i8 = i7; i8 < i3; i8++) {
            if (list.get(i8).size() < OplusGLSurfaceView_13) {
                throw new AssertionError();
            }
        }
        ByteString byteString = list.get(i2);
        ByteString byteString2 = list.get(i3 - 1);
        int iIntValue = -1;
        if (OplusGLSurfaceView_13 == byteString.size()) {
            iIntValue = list2.get(i7).intValue();
            i7++;
            byteString = list.get(i7);
        }
        int i9 = i7;
        if (byteString.getByte(OplusGLSurfaceView_13) != byteString2.getByte(OplusGLSurfaceView_13)) {
            int i10 = 1;
            for (int i11 = i9 + 1; i11 < i3; i11++) {
                if (list.get(i11 - 1).getByte(OplusGLSurfaceView_13) != list.get(i11).getByte(OplusGLSurfaceView_13)) {
                    i10++;
                }
            }
            long jIntCount = OplusGLSurfaceView_15 + intCount(buffer) + 2 + (i10 * 2);
            buffer.writeInt(i10);
            buffer.writeInt(iIntValue);
            for (int i12 = i9; i12 < i3; i12++) {
                byte b2 = list.get(i12).getByte(OplusGLSurfaceView_13);
                if (i12 == i9 || b2 != list.get(i12 - 1).getByte(OplusGLSurfaceView_13)) {
                    buffer.writeInt(b2 & 255);
                }
            }
            Buffer buffer3 = new Buffer();
            int i13 = i9;
            while (i13 < i3) {
                byte b3 = list.get(i13).getByte(OplusGLSurfaceView_13);
                int i14 = i13 + 1;
                int i15 = i14;
                while (true) {
                    if (i15 >= i3) {
                        i5 = i3;
                        break;
                    } else {
                        if (b3 != list.get(i15).getByte(OplusGLSurfaceView_13)) {
                            i5 = i15;
                            break;
                        }
                        i15++;
                    }
                }
                if (i14 == i5 && OplusGLSurfaceView_13 + 1 == list.get(i13).size()) {
                    buffer.writeInt(list2.get(i13).intValue());
                    i6 = i5;
                    buffer2 = buffer3;
                } else {
                    buffer.writeInt((int) ((intCount(buffer3) + jIntCount) * (-1)));
                    i6 = i5;
                    buffer2 = buffer3;
                    buildTrieRecursive(jIntCount, buffer3, OplusGLSurfaceView_13 + 1, list, i13, i5, list2);
                }
                buffer3 = buffer2;
                i13 = i6;
            }
            Buffer buffer4 = buffer3;
            buffer.write(buffer4, buffer4.size());
            return;
        }
        int iMin = Math.min(byteString.size(), byteString2.size());
        int i16 = 0;
        for (int i17 = OplusGLSurfaceView_13; i17 < iMin && byteString.getByte(i17) == byteString2.getByte(i17); i17++) {
            i16++;
        }
        long jIntCount2 = 1 + OplusGLSurfaceView_15 + intCount(buffer) + 2 + i16;
        buffer.writeInt(-i16);
        buffer.writeInt(iIntValue);
        int i18 = OplusGLSurfaceView_13;
        while (true) {
            i4 = OplusGLSurfaceView_13 + i16;
            if (i18 >= i4) {
                break;
            }
            buffer.writeInt(byteString.getByte(i18) & 255);
            i18++;
        }
        if (i9 + 1 == i3) {
            if (i4 != list.get(i9).size()) {
                throw new AssertionError();
            }
            buffer.writeInt(list2.get(i9).intValue());
        } else {
            Buffer buffer5 = new Buffer();
            buffer.writeInt((int) ((intCount(buffer5) + jIntCount2) * (-1)));
            buildTrieRecursive(jIntCount2, buffer5, i4, list, i9, i3, list2);
            buffer.write(buffer5, buffer5.size());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int OplusGLSurfaceView_13) {
        return this.byteStrings[OplusGLSurfaceView_13];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }
}
