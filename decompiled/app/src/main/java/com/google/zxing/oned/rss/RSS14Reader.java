package com.google.zxing.oned.rss;

/* loaded from: classes.dex */
public final class RSS14Reader extends com.google.zxing.oned.rss.AbstractRSSReader {
    private final java.util.List<com.google.zxing.oned.rss.Pair> possibleLeftPairs = new java.util.ArrayList();
    private final java.util.List<com.google.zxing.oned.rss.Pair> possibleRightPairs = new java.util.ArrayList();
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = {1, 10, 34, 70, 126};
    private static final int[] INSIDE_ODD_TOTAL_SUBSET = {4, 20, 48, 81};
    private static final int[] OUTSIDE_GSUM = {0, 161, 961, 2015, 2715};
    private static final int[] INSIDE_GSUM = {0, 336, 1036, 1516};
    private static final int[] OUTSIDE_ODD_WIDEST = {8, 6, 4, 3, 1};
    private static final int[] INSIDE_ODD_WIDEST = {2, 4, 6, 8};
    private static final int[][] FINDER_PATTERNS = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    @Override // com.google.zxing.oned.OneDReader
    public com.google.zxing.Result decodeRow(int i_renamed, com.google.zxing.common.BitArray bitArray, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException {
        addOrTally(this.possibleLeftPairs, decodePair(bitArray, false, i_renamed, map));
        bitArray.reverse();
        addOrTally(this.possibleRightPairs, decodePair(bitArray, true, i_renamed, map));
        bitArray.reverse();
        for (com.google.zxing.oned.rss.Pair pair : this.possibleLeftPairs) {
            if (pair.getCount() > 1) {
                for (com.google.zxing.oned.rss.Pair pair2 : this.possibleRightPairs) {
                    if (pair2.getCount() > 1 && checkChecksum(pair, pair2)) {
                        return constructResult(pair, pair2);
                    }
                }
            }
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private static void addOrTally(java.util.Collection<com.google.zxing.oned.rss.Pair> collection, com.google.zxing.oned.rss.Pair pair) {
        if (pair == null) {
            return;
        }
        boolean z_renamed = false;
        java.util.Iterator<com.google.zxing.oned.rss.Pair> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.google.zxing.oned.rss.Pair next = it.next();
            if (next.getValue() == pair.getValue()) {
                next.incrementCount();
                z_renamed = true;
                break;
            }
        }
        if (z_renamed) {
            return;
        }
        collection.add(pair);
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.possibleLeftPairs.clear();
        this.possibleRightPairs.clear();
    }

    private static com.google.zxing.Result constructResult(com.google.zxing.oned.rss.Pair pair, com.google.zxing.oned.rss.Pair pair2) {
        java.lang.String strValueOf = java.lang.String.valueOf((pair.getValue() * 4537077) + pair2.getValue());
        java.lang.StringBuilder sb = new java.lang.StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i_renamed = 0;
        for (int i2 = 0; i2 < 13; i2++) {
            int iCharAt = sb.charAt(i2) - '0';
            if ((i2 & 1) == 0) {
                iCharAt *= 3;
            }
            i_renamed += iCharAt;
        }
        int i3 = 10 - (i_renamed % 10);
        if (i3 == 10) {
            i3 = 0;
        }
        sb.append(i3);
        com.google.zxing.ResultPoint[] resultPoints = pair.getFinderPattern().getResultPoints();
        com.google.zxing.ResultPoint[] resultPoints2 = pair2.getFinderPattern().getResultPoints();
        return new com.google.zxing.Result(sb.toString(), null, new com.google.zxing.ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, com.google.zxing.BarcodeFormat.RSS_14);
    }

    private static boolean checkChecksum(com.google.zxing.oned.rss.Pair pair, com.google.zxing.oned.rss.Pair pair2) {
        int checksumPortion = (pair.getChecksumPortion() + (pair2.getChecksumPortion() * 16)) % 79;
        int value = (pair.getFinderPattern().getValue() * 9) + pair2.getFinderPattern().getValue();
        if (value > 72) {
            value--;
        }
        if (value > 8) {
            value--;
        }
        return checksumPortion == value;
    }

    private com.google.zxing.oned.rss.Pair decodePair(com.google.zxing.common.BitArray bitArray, boolean z_renamed, int i_renamed, java.util.Map<com.google.zxing.DecodeHintType, ?> map) {
        try {
            com.google.zxing.oned.rss.FinderPattern foundFinderPattern = parseFoundFinderPattern(bitArray, i_renamed, z_renamed, findFinderPattern(bitArray, z_renamed));
            com.google.zxing.ResultPointCallback resultPointCallback = map == null ? null : (com.google.zxing.ResultPointCallback) map.get(com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                float size = (r1[0] + r1[1]) / 2.0f;
                if (z_renamed) {
                    size = (bitArray.getSize() - 1) - size;
                }
                resultPointCallback.foundPossibleResultPoint(new com.google.zxing.ResultPoint(size, i_renamed));
            }
            com.google.zxing.oned.rss.DataCharacter dataCharacterDecodeDataCharacter = decodeDataCharacter(bitArray, foundFinderPattern, true);
            com.google.zxing.oned.rss.DataCharacter dataCharacterDecodeDataCharacter2 = decodeDataCharacter(bitArray, foundFinderPattern, false);
            return new com.google.zxing.oned.rss.Pair((dataCharacterDecodeDataCharacter.getValue() * 1597) + dataCharacterDecodeDataCharacter2.getValue(), dataCharacterDecodeDataCharacter.getChecksumPortion() + (dataCharacterDecodeDataCharacter2.getChecksumPortion() * 4), foundFinderPattern);
        } catch (com.google.zxing.NotFoundException unused) {
            return null;
        }
    }

    private com.google.zxing.oned.rss.DataCharacter decodeDataCharacter(com.google.zxing.common.BitArray bitArray, com.google.zxing.oned.rss.FinderPattern finderPattern, boolean z_renamed) throws com.google.zxing.NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        for (int i_renamed = 0; i_renamed < dataCharacterCounters.length; i_renamed++) {
            dataCharacterCounters[i_renamed] = 0;
        }
        if (z_renamed) {
            recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
            int i2 = 0;
            for (int length = dataCharacterCounters.length - 1; i2 < length; length--) {
                int i3 = dataCharacterCounters[i2];
                dataCharacterCounters[i2] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i3;
                i2++;
            }
        }
        int i4 = z_renamed ? 16 : 15;
        float fSum = com.google.zxing.common.detector.MathUtils.sum(dataCharacterCounters) / i4;
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i5 = 0; i5 < dataCharacterCounters.length; i5++) {
            float f_renamed = dataCharacterCounters[i5] / fSum;
            int i6 = (int) (0.5f + f_renamed);
            if (i6 <= 0) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                oddCounts[i7] = i6;
                oddRoundingErrors[i7] = f_renamed - i6;
            } else {
                evenCounts[i7] = i6;
                evenRoundingErrors[i7] = f_renamed - i6;
            }
        }
        adjustOddEvenCounts(z_renamed, i4);
        int i8 = 0;
        int i9 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            i8 = (i8 * 9) + oddCounts[length2];
            i9 += oddCounts[length2];
        }
        int i10 = 0;
        int i11 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            i10 = (i10 * 9) + evenCounts[length3];
            i11 += evenCounts[length3];
        }
        int i12 = i8 + (i10 * 3);
        if (!z_renamed) {
            if ((i11 & 1) != 0 || i11 > 10 || i11 < 4) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            int i13 = (10 - i11) / 2;
            int i14 = INSIDE_ODD_WIDEST[i13];
            return new com.google.zxing.oned.rss.DataCharacter((com.google.zxing.oned.rss.RSSUtils.getRSSvalue(evenCounts, 9 - i14, false) * INSIDE_ODD_TOTAL_SUBSET[i13]) + com.google.zxing.oned.rss.RSSUtils.getRSSvalue(oddCounts, i14, true) + INSIDE_GSUM[i13], i12);
        }
        if ((i9 & 1) != 0 || i9 > 12 || i9 < 4) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int i15 = (12 - i9) / 2;
        int i16 = OUTSIDE_ODD_WIDEST[i15];
        return new com.google.zxing.oned.rss.DataCharacter((com.google.zxing.oned.rss.RSSUtils.getRSSvalue(oddCounts, i16, false) * OUTSIDE_EVEN_TOTAL_SUBSET[i15]) + com.google.zxing.oned.rss.RSSUtils.getRSSvalue(evenCounts, 9 - i16, true) + OUTSIDE_GSUM[i15], i12);
    }

    private int[] findFinderPattern(com.google.zxing.common.BitArray bitArray, boolean z_renamed) throws com.google.zxing.NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        int i_renamed = 0;
        boolean z2 = false;
        while (i_renamed < size) {
            z2 = !bitArray.get(i_renamed);
            if (z_renamed == z2) {
                break;
            }
            i_renamed++;
        }
        int i2 = 0;
        int i3 = i_renamed;
        while (i_renamed < size) {
            if (bitArray.get(i_renamed) != z2) {
                decodeFinderCounters[i2] = decodeFinderCounters[i2] + 1;
            } else {
                if (i2 != 3) {
                    i2++;
                } else {
                    if (isFinderPattern(decodeFinderCounters)) {
                        return new int[]{i3, i_renamed};
                    }
                    i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i2--;
                }
                decodeFinderCounters[i2] = 1;
                z2 = !z2;
            }
            i_renamed++;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private com.google.zxing.oned.rss.FinderPattern parseFoundFinderPattern(com.google.zxing.common.BitArray bitArray, int i_renamed, boolean z_renamed, int[] iArr) throws com.google.zxing.NotFoundException {
        int size;
        int i2;
        boolean z2 = bitArray.get(iArr[0]);
        int i3 = iArr[0] - 1;
        while (i3 >= 0 && z2 != bitArray.get(i3)) {
            i3--;
        }
        int i4 = i3 + 1;
        int i5 = iArr[0] - i4;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        java.lang.System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i5;
        int finderValue = parseFinderValue(decodeFinderCounters, FINDER_PATTERNS);
        int i6 = iArr[1];
        if (z_renamed) {
            int size2 = (bitArray.getSize() - 1) - i4;
            size = (bitArray.getSize() - 1) - i6;
            i2 = size2;
        } else {
            size = i6;
            i2 = i4;
        }
        return new com.google.zxing.oned.rss.FinderPattern(finderValue, new int[]{i4, iArr[1]}, i2, size, i_renamed);
    }

    private void adjustOddEvenCounts(boolean z_renamed, int i_renamed) throws com.google.zxing.NotFoundException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int iSum = com.google.zxing.common.detector.MathUtils.sum(getOddCounts());
        int iSum2 = com.google.zxing.common.detector.MathUtils.sum(getEvenCounts());
        if (z_renamed) {
            if (iSum > 12) {
                z6 = false;
                z7 = true;
            } else if (iSum < 4) {
                z7 = false;
                z6 = true;
            } else {
                z6 = false;
                z7 = false;
            }
            if (iSum2 > 12) {
                z4 = false;
                z2 = z6;
                z3 = z7;
                z5 = true;
            } else if (iSum2 < 4) {
                z4 = true;
                z2 = z6;
                z3 = z7;
                z5 = false;
            } else {
                z4 = false;
                z2 = z6;
                z3 = z7;
                z5 = z4;
            }
        } else {
            if (iSum > 11) {
                z2 = false;
                z3 = true;
            } else if (iSum < 5) {
                z3 = false;
                z2 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (iSum2 > 10) {
                z4 = false;
                z5 = true;
            } else if (iSum2 < 4) {
                z5 = false;
                z4 = true;
            } else {
                z4 = false;
                z5 = z4;
            }
        }
        int i2 = (iSum + iSum2) - i_renamed;
        boolean z8 = (iSum & 1) == z_renamed;
        boolean z9 = (iSum2 & 1) == 1;
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw com.google.zxing.NotFoundException.getNotFoundInstance();
                }
                if (z8) {
                    if (z9) {
                        throw com.google.zxing.NotFoundException.getNotFoundInstance();
                    }
                    z3 = true;
                } else {
                    if (!z9) {
                        throw com.google.zxing.NotFoundException.getNotFoundInstance();
                    }
                    z5 = true;
                }
            } else if (z8) {
                if (!z9) {
                    throw com.google.zxing.NotFoundException.getNotFoundInstance();
                }
                if (iSum < iSum2) {
                    z2 = true;
                    z5 = true;
                } else {
                    z4 = true;
                    z3 = true;
                }
            } else if (z9) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
        } else if (z8) {
            if (z9) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            z2 = true;
        } else {
            if (!z9) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            z4 = true;
        }
        if (z2) {
            if (z3) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z3) {
            decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z4) {
            if (z5) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z5) {
            decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }
}
