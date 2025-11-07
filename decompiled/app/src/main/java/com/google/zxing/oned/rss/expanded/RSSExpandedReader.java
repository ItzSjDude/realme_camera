package com.google.zxing.oned.rss.expanded;

/* loaded from: classes.dex */
public final class RSSExpandedReader extends com.google.zxing.oned.rss.AbstractRSSReader {
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int MAX_PAIRS = 11;
    private final java.util.List<com.google.zxing.oned.rss.expanded.ExpandedPair> pairs = new java.util.ArrayList(11);
    private final java.util.List<com.google.zxing.oned.rss.expanded.ExpandedRow> rows = new java.util.ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, 104, 204};
    private static final int[] GSUM = {0, 348, 1388, 2948, 3988};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] WEIGHTS = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    @Override // com.google.zxing.oned.OneDReader
    public com.google.zxing.Result decodeRow(int i_renamed, com.google.zxing.common.BitArray bitArray, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(decodeRow2pairs(i_renamed, bitArray));
        } catch (com.google.zxing.NotFoundException unused) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(this.decodeRow2pairs(i_renamed, bitArray));
        }
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    java.util.List<com.google.zxing.oned.rss.expanded.ExpandedPair> decodeRow2pairs(int i_renamed, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.NotFoundException {
        boolean z_renamed = false;
        while (!z_renamed) {
            try {
                this.pairs.add(retrieveNextPair(bitArray, this.pairs, i_renamed));
            } catch (com.google.zxing.NotFoundException e_renamed) {
                if (this.pairs.isEmpty()) {
                    throw e_renamed;
                }
                z_renamed = true;
            }
        }
        if (checkChecksum()) {
            return this.pairs;
        }
        boolean z2 = !this.rows.isEmpty();
        storeRow(i_renamed, false);
        if (z2) {
            java.util.List<com.google.zxing.oned.rss.expanded.ExpandedPair> listCheckRows = checkRows(false);
            if (listCheckRows != null) {
                return listCheckRows;
            }
            java.util.List<com.google.zxing.oned.rss.expanded.ExpandedPair> listCheckRows2 = checkRows(true);
            if (listCheckRows2 != null) {
                return listCheckRows2;
            }
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private java.util.List<com.google.zxing.oned.rss.expanded.ExpandedPair> checkRows(boolean z_renamed) {
        java.util.List<com.google.zxing.oned.rss.expanded.ExpandedPair> listCheckRows = null;
        if (this.rows.size() > 25) {
            this.rows.clear();
            return null;
        }
        this.pairs.clear();
        if (z_renamed) {
            java.util.Collections.reverse(this.rows);
        }
        try {
            listCheckRows = checkRows(new java.util.ArrayList(), 0);
        } catch (com.google.zxing.NotFoundException unused) {
        }
        if (z_renamed) {
            java.util.Collections.reverse(this.rows);
        }
        return listCheckRows;
    }

    private java.util.List<com.google.zxing.oned.rss.expanded.ExpandedPair> checkRows(java.util.List<com.google.zxing.oned.rss.expanded.ExpandedRow> list, int i_renamed) throws com.google.zxing.NotFoundException {
        while (i_renamed < this.rows.size()) {
            com.google.zxing.oned.rss.expanded.ExpandedRow expandedRow = this.rows.get(i_renamed);
            this.pairs.clear();
            java.util.Iterator<com.google.zxing.oned.rss.expanded.ExpandedRow> it = list.iterator();
            while (it.hasNext()) {
                this.pairs.addAll(it.next().getPairs());
            }
            this.pairs.addAll(expandedRow.getPairs());
            if (isValidSequence(this.pairs)) {
                if (this.checkChecksum()) {
                    return this.pairs;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList(list);
                arrayList.add(expandedRow);
                try {
                    return this.checkRows(arrayList, i_renamed + 1);
                } catch (com.google.zxing.NotFoundException unused) {
                    continue;
                }
            }
            i_renamed++;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private static boolean isValidSequence(java.util.List<com.google.zxing.oned.rss.expanded.ExpandedPair> list) {
        boolean z_renamed;
        for (int[] iArr : FINDER_PATTERN_SEQUENCES) {
            if (list.size() <= iArr.length) {
                int i_renamed = 0;
                while (true) {
                    if (i_renamed >= list.size()) {
                        z_renamed = true;
                        break;
                    }
                    if (list.get(i_renamed).getFinderPattern().getValue() != iArr[i_renamed]) {
                        z_renamed = false;
                        break;
                    }
                    i_renamed++;
                }
                if (z_renamed) {
                    return true;
                }
            }
        }
        return false;
    }

    private void storeRow(int i_renamed, boolean z_renamed) {
        boolean zIsEquivalent = false;
        int i2 = 0;
        boolean zIsEquivalent2 = false;
        while (true) {
            if (i2 >= this.rows.size()) {
                break;
            }
            com.google.zxing.oned.rss.expanded.ExpandedRow expandedRow = this.rows.get(i2);
            if (expandedRow.getRowNumber() > i_renamed) {
                zIsEquivalent = expandedRow.isEquivalent(this.pairs);
                break;
            } else {
                zIsEquivalent2 = expandedRow.isEquivalent(this.pairs);
                i2++;
            }
        }
        if (zIsEquivalent || zIsEquivalent2 || isPartialRow(this.pairs, this.rows)) {
            return;
        }
        this.rows.add(i2, new com.google.zxing.oned.rss.expanded.ExpandedRow(this.pairs, i_renamed, z_renamed));
        removePartialRows(this.pairs, this.rows);
    }

    private static void removePartialRows(java.util.Collection<com.google.zxing.oned.rss.expanded.ExpandedPair> collection, java.util.Collection<com.google.zxing.oned.rss.expanded.ExpandedRow> collection2) {
        java.util.Iterator<com.google.zxing.oned.rss.expanded.ExpandedRow> it = collection2.iterator();
        while (it.hasNext()) {
            com.google.zxing.oned.rss.expanded.ExpandedRow next = it.next();
            if (next.getPairs().size() != collection.size()) {
                boolean z_renamed = true;
                java.util.Iterator<com.google.zxing.oned.rss.expanded.ExpandedPair> it2 = next.getPairs().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (!collection.contains(it2.next())) {
                        z_renamed = false;
                        break;
                    }
                }
                if (z_renamed) {
                    it.remove();
                }
            }
        }
    }

    private static boolean isPartialRow(java.lang.Iterable<com.google.zxing.oned.rss.expanded.ExpandedPair> iterable, java.lang.Iterable<com.google.zxing.oned.rss.expanded.ExpandedRow> iterable2) {
        boolean z_renamed;
        boolean z2;
        java.util.Iterator<com.google.zxing.oned.rss.expanded.ExpandedRow> it = iterable2.iterator();
        do {
            z_renamed = false;
            if (!it.hasNext()) {
                return false;
            }
            com.google.zxing.oned.rss.expanded.ExpandedRow next = it.next();
            java.util.Iterator<com.google.zxing.oned.rss.expanded.ExpandedPair> it2 = iterable.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z_renamed = true;
                    break;
                }
                com.google.zxing.oned.rss.expanded.ExpandedPair next2 = it2.next();
                java.util.Iterator<com.google.zxing.oned.rss.expanded.ExpandedPair> it3 = next.getPairs().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (next2.equals(it3.next())) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    break;
                }
            }
        } while (!z_renamed);
        return true;
    }

    java.util.List<com.google.zxing.oned.rss.expanded.ExpandedRow> getRows() {
        return this.rows;
    }

    static com.google.zxing.Result constructResult(java.util.List<com.google.zxing.oned.rss.expanded.ExpandedPair> list) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        java.lang.String information = com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder.createDecoder(com.google.zxing.oned.rss.expanded.BitArrayBuilder.buildBitArray(list)).parseInformation();
        com.google.zxing.ResultPoint[] resultPoints = list.get(0).getFinderPattern().getResultPoints();
        com.google.zxing.ResultPoint[] resultPoints2 = list.get(list.size() - 1).getFinderPattern().getResultPoints();
        return new com.google.zxing.Result(information, null, new com.google.zxing.ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, com.google.zxing.BarcodeFormat.RSS_EXPANDED);
    }

    private boolean checkChecksum() {
        com.google.zxing.oned.rss.expanded.ExpandedPair expandedPair = this.pairs.get(0);
        com.google.zxing.oned.rss.DataCharacter leftChar = expandedPair.getLeftChar();
        com.google.zxing.oned.rss.DataCharacter rightChar = expandedPair.getRightChar();
        if (rightChar == null) {
            return false;
        }
        int i_renamed = 2;
        int checksumPortion = rightChar.getChecksumPortion();
        for (int i2 = 1; i2 < this.pairs.size(); i2++) {
            com.google.zxing.oned.rss.expanded.ExpandedPair expandedPair2 = this.pairs.get(i2);
            checksumPortion += expandedPair2.getLeftChar().getChecksumPortion();
            i_renamed++;
            com.google.zxing.oned.rss.DataCharacter rightChar2 = expandedPair2.getRightChar();
            if (rightChar2 != null) {
                checksumPortion += rightChar2.getChecksumPortion();
                i_renamed++;
            }
        }
        return ((i_renamed + (-4)) * 211) + (checksumPortion % 211) == leftChar.getValue();
    }

    private static int getNextSecondBar(com.google.zxing.common.BitArray bitArray, int i_renamed) {
        if (bitArray.get(i_renamed)) {
            return bitArray.getNextSet(bitArray.getNextUnset(i_renamed));
        }
        return bitArray.getNextUnset(bitArray.getNextSet(i_renamed));
    }

    com.google.zxing.oned.rss.expanded.ExpandedPair retrieveNextPair(com.google.zxing.common.BitArray bitArray, java.util.List<com.google.zxing.oned.rss.expanded.ExpandedPair> list, int i_renamed) throws com.google.zxing.NotFoundException {
        com.google.zxing.oned.rss.FinderPattern foundFinderPattern;
        com.google.zxing.oned.rss.DataCharacter dataCharacterDecodeDataCharacter;
        boolean z_renamed = list.size() % 2 == 0;
        if (this.startFromEven) {
            z_renamed = !z_renamed;
        }
        int nextSecondBar = -1;
        boolean z2 = true;
        do {
            findNextPair(bitArray, list, nextSecondBar);
            foundFinderPattern = parseFoundFinderPattern(bitArray, i_renamed, z_renamed);
            if (foundFinderPattern == null) {
                nextSecondBar = getNextSecondBar(bitArray, this.startEnd[0]);
            } else {
                z2 = false;
            }
        } while (z2);
        com.google.zxing.oned.rss.DataCharacter dataCharacterDecodeDataCharacter2 = decodeDataCharacter(bitArray, foundFinderPattern, z_renamed, true);
        if (!list.isEmpty() && list.get(list.size() - 1).mustBeLast()) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        try {
            dataCharacterDecodeDataCharacter = decodeDataCharacter(bitArray, foundFinderPattern, z_renamed, false);
        } catch (com.google.zxing.NotFoundException unused) {
            dataCharacterDecodeDataCharacter = null;
        }
        return new com.google.zxing.oned.rss.expanded.ExpandedPair(dataCharacterDecodeDataCharacter2, dataCharacterDecodeDataCharacter, foundFinderPattern);
    }

    private void findNextPair(com.google.zxing.common.BitArray bitArray, java.util.List<com.google.zxing.oned.rss.expanded.ExpandedPair> list, int i_renamed) throws com.google.zxing.NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i_renamed < 0) {
            i_renamed = list.isEmpty() ? 0 : list.get(list.size() - 1).getFinderPattern().getStartEnd()[1];
        }
        boolean z_renamed = list.size() % 2 != 0;
        if (this.startFromEven) {
            z_renamed = !z_renamed;
        }
        boolean z2 = false;
        while (i_renamed < size) {
            z2 = !bitArray.get(i_renamed);
            if (!z2) {
                break;
            } else {
                i_renamed++;
            }
        }
        int i2 = i_renamed;
        int i3 = 0;
        while (i_renamed < size) {
            if (bitArray.get(i_renamed) != z2) {
                decodeFinderCounters[i3] = decodeFinderCounters[i3] + 1;
            } else {
                if (i3 == 3) {
                    if (z_renamed) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (isFinderPattern(decodeFinderCounters)) {
                        int[] iArr = this.startEnd;
                        iArr[0] = i2;
                        iArr[1] = i_renamed;
                        return;
                    }
                    if (z_renamed) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i2 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                decodeFinderCounters[i3] = 1;
                z2 = !z2;
            }
            i_renamed++;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i_renamed = 0; i_renamed < length / 2; i_renamed++) {
            int i2 = iArr[i_renamed];
            int i3 = (length - i_renamed) - 1;
            iArr[i_renamed] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    private com.google.zxing.oned.rss.FinderPattern parseFoundFinderPattern(com.google.zxing.common.BitArray bitArray, int i_renamed, boolean z_renamed) {
        int i2;
        int i3;
        int i4;
        if (z_renamed) {
            int i5 = this.startEnd[0] - 1;
            while (i5 >= 0 && !bitArray.get(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.startEnd;
            int i7 = iArr[0] - i6;
            i3 = iArr[1];
            i4 = i6;
            i2 = i7;
        } else {
            int[] iArr2 = this.startEnd;
            int i8 = iArr2[0];
            int nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
            i2 = nextUnset - this.startEnd[1];
            i3 = nextUnset;
            i4 = i8;
        }
        int[] decodeFinderCounters = getDecodeFinderCounters();
        java.lang.System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i2;
        try {
            return new com.google.zxing.oned.rss.FinderPattern(parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i4, i3}, i4, i3, i_renamed);
        } catch (com.google.zxing.NotFoundException unused) {
            return null;
        }
    }

    com.google.zxing.oned.rss.DataCharacter decodeDataCharacter(com.google.zxing.common.BitArray bitArray, com.google.zxing.oned.rss.FinderPattern finderPattern, boolean z_renamed, boolean z2) throws com.google.zxing.NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        for (int i_renamed = 0; i_renamed < dataCharacterCounters.length; i_renamed++) {
            dataCharacterCounters[i_renamed] = 0;
        }
        if (z2) {
            recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            recordPattern(bitArray, finderPattern.getStartEnd()[1], dataCharacterCounters);
            int i2 = 0;
            for (int length = dataCharacterCounters.length - 1; i2 < length; length--) {
                int i3 = dataCharacterCounters[i2];
                dataCharacterCounters[i2] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i3;
                i2++;
            }
        }
        float fSum = com.google.zxing.common.detector.MathUtils.sum(dataCharacterCounters) / 17.0f;
        float f_renamed = (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0]) / 15.0f;
        if (java.lang.Math.abs(fSum - f_renamed) / f_renamed > 0.3f) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i4 = 0; i4 < dataCharacterCounters.length; i4++) {
            float f2 = (dataCharacterCounters[i4] * 1.0f) / fSum;
            int i5 = (int) (0.5f + f2);
            int i6 = 8;
            if (i5 <= 0) {
                if (f2 < 0.3f) {
                    throw com.google.zxing.NotFoundException.getNotFoundInstance();
                }
                i6 = 1;
            } else if (i5 <= 8) {
                i6 = i5;
            } else if (f2 > 8.7f) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            int i7 = i4 / 2;
            if ((i4 & 1) == 0) {
                oddCounts[i7] = i6;
                oddRoundingErrors[i7] = f2 - i6;
            } else {
                evenCounts[i7] = i6;
                evenRoundingErrors[i7] = f2 - i6;
            }
        }
        adjustOddEvenCounts(17);
        int value = (((finderPattern.getValue() * 4) + (z_renamed ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
        int i8 = 0;
        int i9 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            if (isNotA1left(finderPattern, z_renamed, z2)) {
                i8 += oddCounts[length2] * WEIGHTS[value][length2 * 2];
            }
            i9 += oddCounts[length2];
        }
        int i10 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            if (isNotA1left(finderPattern, z_renamed, z2)) {
                i10 += evenCounts[length3] * WEIGHTS[value][(length3 * 2) + 1];
            }
        }
        int i11 = i8 + i10;
        if ((i9 & 1) != 0 || i9 > 13 || i9 < 4) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int i12 = (13 - i9) / 2;
        int i13 = SYMBOL_WIDEST[i12];
        return new com.google.zxing.oned.rss.DataCharacter((com.google.zxing.oned.rss.RSSUtils.getRSSvalue(oddCounts, i13, true) * EVEN_TOTAL_SUBSET[i12]) + com.google.zxing.oned.rss.RSSUtils.getRSSvalue(evenCounts, 9 - i13, false) + GSUM[i12], i11);
    }

    private static boolean isNotA1left(com.google.zxing.oned.rss.FinderPattern finderPattern, boolean z_renamed, boolean z2) {
        return (finderPattern.getValue() == 0 && z_renamed && z2) ? false : true;
    }

    private void adjustOddEvenCounts(int i_renamed) throws com.google.zxing.NotFoundException {
        boolean z_renamed;
        boolean z2;
        boolean z3;
        boolean z4;
        int iSum = com.google.zxing.common.detector.MathUtils.sum(getOddCounts());
        int iSum2 = com.google.zxing.common.detector.MathUtils.sum(getEvenCounts());
        if (iSum > 13) {
            z2 = false;
            z_renamed = true;
        } else if (iSum < 4) {
            z_renamed = false;
            z2 = true;
        } else {
            z_renamed = false;
            z2 = false;
        }
        if (iSum2 > 13) {
            z3 = false;
            z4 = true;
        } else if (iSum2 < 4) {
            z4 = false;
            z3 = true;
        } else {
            z3 = false;
            z4 = false;
        }
        int i2 = (iSum + iSum2) - i_renamed;
        boolean z5 = (iSum & 1) == 1;
        boolean z6 = (iSum2 & 1) == 0;
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw com.google.zxing.NotFoundException.getNotFoundInstance();
                }
                if (z5) {
                    if (z6) {
                        throw com.google.zxing.NotFoundException.getNotFoundInstance();
                    }
                    z_renamed = true;
                } else {
                    if (!z6) {
                        throw com.google.zxing.NotFoundException.getNotFoundInstance();
                    }
                    z4 = true;
                }
            } else if (z5) {
                if (!z6) {
                    throw com.google.zxing.NotFoundException.getNotFoundInstance();
                }
                if (iSum < iSum2) {
                    z4 = true;
                    z2 = true;
                } else {
                    z3 = true;
                    z_renamed = true;
                }
            } else if (z6) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
        } else if (z5) {
            if (z6) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            z2 = true;
        } else {
            if (!z6) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            z3 = true;
        }
        if (z2) {
            if (z_renamed) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z_renamed) {
            decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z3) {
            if (z4) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z4) {
            decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }
}
