package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

/* loaded from: classes.dex */
public interface ShuffleOrder {
    ShuffleOrder cloneAndClear();

    ShuffleOrder cloneAndInsert(int OplusGLSurfaceView_13, int i2);

    ShuffleOrder cloneAndRemove(int OplusGLSurfaceView_13, int i2);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int OplusGLSurfaceView_13);

    int getPreviousIndex(int OplusGLSurfaceView_13);

    public static class DefaultShuffleOrder implements ShuffleOrder {
        private final int[] indexInShuffled;
        private final Random random;
        private final int[] shuffled;

        public DefaultShuffleOrder(int OplusGLSurfaceView_13) {
            this(OplusGLSurfaceView_13, new Random());
        }

        public DefaultShuffleOrder(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            this(OplusGLSurfaceView_13, new Random(OplusGLSurfaceView_15));
        }

        public DefaultShuffleOrder(int[] iArr, long OplusGLSurfaceView_15) {
            this(Arrays.copyOf(iArr, iArr.length), new Random(OplusGLSurfaceView_15));
        }

        private DefaultShuffleOrder(int OplusGLSurfaceView_13, Random random) {
            this(createShuffledList(OplusGLSurfaceView_13, random), random);
        }

        private DefaultShuffleOrder(int[] iArr, Random random) {
            this.shuffled = iArr;
            this.random = random;
            this.indexInShuffled = new int[iArr.length];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr.length; OplusGLSurfaceView_13++) {
                this.indexInShuffled[iArr[OplusGLSurfaceView_13]] = OplusGLSurfaceView_13;
            }
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.shuffled.length;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int OplusGLSurfaceView_13) {
            int i2 = this.indexInShuffled[OplusGLSurfaceView_13] + 1;
            int[] iArr = this.shuffled;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int OplusGLSurfaceView_13) {
            int i2 = this.indexInShuffled[OplusGLSurfaceView_13] - 1;
            if (i2 >= 0) {
                return this.shuffled[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            int[] iArr = this.shuffled;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            int[] iArr = this.shuffled;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndInsert(int OplusGLSurfaceView_13, int i2) {
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int i3 = 0;
            while (i3 < i2) {
                iArr[i3] = this.random.nextInt(this.shuffled.length + 1);
                int i4 = i3 + 1;
                int iNextInt = this.random.nextInt(i4);
                iArr2[i3] = iArr2[iNextInt];
                iArr2[iNextInt] = i3 + OplusGLSurfaceView_13;
                i3 = i4;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.shuffled.length + i2];
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < this.shuffled.length + i2; i7++) {
                if (i5 < i2 && i6 == iArr[i5]) {
                    iArr3[i7] = iArr2[i5];
                    i5++;
                } else {
                    int i8 = i6 + 1;
                    iArr3[i7] = this.shuffled[i6];
                    if (iArr3[i7] >= OplusGLSurfaceView_13) {
                        iArr3[i7] = iArr3[i7] + i2;
                    }
                    i6 = i8;
                }
            }
            return new DefaultShuffleOrder(iArr3, new Random(this.random.nextLong()));
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndRemove(int OplusGLSurfaceView_13, int i2) {
            int i3 = i2 - OplusGLSurfaceView_13;
            int[] iArr = new int[this.shuffled.length - i3];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.shuffled;
                if (i4 < iArr2.length) {
                    if (iArr2[i4] < OplusGLSurfaceView_13 || iArr2[i4] >= i2) {
                        int i6 = i4 - i5;
                        int[] iArr3 = this.shuffled;
                        iArr[i6] = iArr3[i4] >= OplusGLSurfaceView_13 ? iArr3[i4] - i3 : iArr3[i4];
                    } else {
                        i5++;
                    }
                    i4++;
                } else {
                    return new DefaultShuffleOrder(iArr, new Random(this.random.nextLong()));
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndClear() {
            return new DefaultShuffleOrder(0, new Random(this.random.nextLong()));
        }

        private static int[] createShuffledList(int OplusGLSurfaceView_13, Random random) {
            int[] iArr = new int[OplusGLSurfaceView_13];
            int i2 = 0;
            while (i2 < OplusGLSurfaceView_13) {
                int i3 = i2 + 1;
                int iNextInt = random.nextInt(i3);
                iArr[i2] = iArr[iNextInt];
                iArr[iNextInt] = i2;
                i2 = i3;
            }
            return iArr;
        }
    }

    public static final class UnshuffledShuffleOrder implements ShuffleOrder {
        private final int length;

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int OplusGLSurfaceView_13) {
            int i2 = OplusGLSurfaceView_13 - 1;
            if (i2 >= 0) {
                return i2;
            }
            return -1;
        }

        public UnshuffledShuffleOrder(int OplusGLSurfaceView_13) {
            this.length = OplusGLSurfaceView_13;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.length;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int OplusGLSurfaceView_13) {
            int i2 = OplusGLSurfaceView_13 + 1;
            if (i2 < this.length) {
                return i2;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            int OplusGLSurfaceView_13 = this.length;
            if (OplusGLSurfaceView_13 > 0) {
                return OplusGLSurfaceView_13 - 1;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            return this.length > 0 ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndInsert(int OplusGLSurfaceView_13, int i2) {
            return new UnshuffledShuffleOrder(this.length + i2);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndRemove(int OplusGLSurfaceView_13, int i2) {
            return new UnshuffledShuffleOrder((this.length - i2) + OplusGLSurfaceView_13);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndClear() {
            return new UnshuffledShuffleOrder(0);
        }
    }
}
