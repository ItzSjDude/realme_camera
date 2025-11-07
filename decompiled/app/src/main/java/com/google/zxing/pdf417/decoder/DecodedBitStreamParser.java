package com.google.zxing.pdf417.decoder;

/* loaded from: classes.dex */
final class DecodedBitStreamParser {
    private static final int AL_renamed = 28;
    private static final int AS_renamed = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final java.math.BigInteger[] EXP900;
    private static final int LL_renamed = 27;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_ADDRESSEE = 4;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_CHECKSUM = 6;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_NAME = 0;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_SIZE = 5;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SEGMENT_COUNT = 1;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SENDER = 3;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_TIME_STAMP = 2;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int ML_renamed = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL_renamed = 25;
    private static final int PS_renamed = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r_renamed\t_renamed,:\n_renamed-.$/\"|*()?{}'".toCharArray();
    private static final char[] MIXED_CHARS = "0123456789&\r_renamed\t_renamed,:#-.$/+%*=^".toCharArray();

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        java.math.BigInteger[] bigIntegerArr = new java.math.BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = java.math.BigInteger.ONE;
        java.math.BigInteger bigIntegerValueOf = java.math.BigInteger.valueOf(900L);
        EXP900[1] = bigIntegerValueOf;
        int i_renamed = 2;
        while (true) {
            java.math.BigInteger[] bigIntegerArr2 = EXP900;
            if (i_renamed >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i_renamed] = bigIntegerArr2[i_renamed - 1].multiply(bigIntegerValueOf);
            i_renamed++;
        }
    }

    private DecodedBitStreamParser() {
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.zxing.common.DecoderResult decode(int[] r6, java.lang.String r7) throws com.google.zxing.FormatException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.ISO_8859_1
            r2 = r6[r2]
            com.google.zxing.pdf417.PDF417ResultMetadata r3 = new com.google.zxing.pdf417.PDF417ResultMetadata
            r3.<init>()
            r4 = 2
        L12:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L6d
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L58
            switch(r2) {
                case 900: goto L53;
                case 901: goto L4e;
                case 902: goto L49;
                default: goto L1e;
            }
        L1e:
            switch(r2) {
                case 922: goto L44;
                case 923: goto L44;
                case 924: goto L4e;
                case 925: goto L41;
                case 926: goto L3e;
                case 927: goto L2d;
                case 928: goto L28;
                default: goto L21;
            }
        L21:
            int r4 = r4 + (-1)
            int r2 = textCompaction(r6, r4, r0)
            goto L60
        L28:
            int r2 = decodeMacroBlock(r6, r4, r3)
            goto L60
        L2d:
            int r2 = r4 + 1
            r1 = r6[r4]
            com.google.zxing.common.CharacterSetECI r1 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByValue(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L60
        L3e:
            int r2 = r4 + 2
            goto L60
        L41:
            int r2 = r4 + 1
            goto L60
        L44:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L49:
            int r2 = numericCompaction(r6, r4, r0)
            goto L60
        L4e:
            int r2 = byteCompaction(r2, r6, r1, r4, r0)
            goto L60
        L53:
            int r2 = textCompaction(r6, r4, r0)
            goto L60
        L58:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L60:
            int r4 = r6.length
            if (r2 >= r4) goto L68
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L12
        L68:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L6d:
            int r6 = r0.length()
            if (r6 == 0) goto L81
            com.google.zxing.common.DecoderResult r6 = new com.google.zxing.common.DecoderResult
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.setOther(r3)
            return r6
        L81:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decode(int[], java.lang.String):com.google.zxing.common.DecoderResult");
    }

    static int decodeMacroBlock(int[] iArr, int i_renamed, com.google.zxing.pdf417.PDF417ResultMetadata pDF417ResultMetadata) throws com.google.zxing.FormatException {
        if (i_renamed + 2 > iArr[0]) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i2 = i_renamed;
        int i3 = 0;
        while (i3 < 2) {
            iArr2[i3] = iArr[i2];
            i3++;
            i2++;
        }
        pDF417ResultMetadata.setSegmentIndex(java.lang.Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int iTextCompaction = textCompaction(iArr, i2, sb);
        pDF417ResultMetadata.setFileId(sb.toString());
        int i4 = iArr[iTextCompaction] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD ? iTextCompaction + 1 : -1;
        while (iTextCompaction < iArr[0]) {
            int i5 = iArr[iTextCompaction];
            if (i5 == MACRO_PDF417_TERMINATOR) {
                iTextCompaction++;
                pDF417ResultMetadata.setLastSegment(true);
            } else if (i5 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                int i6 = iTextCompaction + 1;
                switch (iArr[i6]) {
                    case 0:
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        iTextCompaction = textCompaction(iArr, i6 + 1, sb2);
                        pDF417ResultMetadata.setFileName(sb2.toString());
                        break;
                    case 1:
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        iTextCompaction = numericCompaction(iArr, i6 + 1, sb3);
                        pDF417ResultMetadata.setSegmentCount(java.lang.Integer.parseInt(sb3.toString()));
                        break;
                    case 2:
                        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                        iTextCompaction = numericCompaction(iArr, i6 + 1, sb4);
                        pDF417ResultMetadata.setTimestamp(java.lang.Long.parseLong(sb4.toString()));
                        break;
                    case 3:
                        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                        iTextCompaction = textCompaction(iArr, i6 + 1, sb5);
                        pDF417ResultMetadata.setSender(sb5.toString());
                        break;
                    case 4:
                        java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                        iTextCompaction = textCompaction(iArr, i6 + 1, sb6);
                        pDF417ResultMetadata.setAddressee(sb6.toString());
                        break;
                    case 5:
                        java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
                        iTextCompaction = numericCompaction(iArr, i6 + 1, sb7);
                        pDF417ResultMetadata.setFileSize(java.lang.Long.parseLong(sb7.toString()));
                        break;
                    case 6:
                        java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
                        iTextCompaction = numericCompaction(iArr, i6 + 1, sb8);
                        pDF417ResultMetadata.setChecksum(java.lang.Integer.parseInt(sb8.toString()));
                        break;
                    default:
                        throw com.google.zxing.FormatException.getFormatInstance();
                }
            } else {
                throw com.google.zxing.FormatException.getFormatInstance();
            }
        }
        if (i4 != -1) {
            int i7 = iTextCompaction - i4;
            if (pDF417ResultMetadata.isLastSegment()) {
                i7--;
            }
            pDF417ResultMetadata.setOptionalData(java.util.Arrays.copyOfRange(iArr, i4, i7 + i4));
        }
        return iTextCompaction;
    }

    /* JADX WARN: Failed to find 'out' block for switch in_renamed B_renamed:14:0x0034. Please report as_renamed an_renamed issue. */
    /* JADX WARN: Failed to find 'out' block for switch in_renamed B_renamed:15:0x0037. Please report as_renamed an_renamed issue. */
    private static int textCompaction(int[] iArr, int i_renamed, java.lang.StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i_renamed) << 1];
        int[] iArr3 = new int[(iArr[0] - i_renamed) << 1];
        boolean z_renamed = false;
        int i2 = 0;
        while (i_renamed < iArr[0] && !z_renamed) {
            int i3 = i_renamed + 1;
            int i4 = iArr[i_renamed];
            if (i4 < 900) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i4 != 928) {
                    switch (i4) {
                        case 900:
                            iArr2[i2] = 900;
                            i2++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i4) {
                            }
                    }
                }
                i_renamed = i3 - 1;
                z_renamed = true;
            } else {
                iArr2[i2] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i_renamed = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i_renamed = i3;
        }
        decodeTextCompaction(iArr2, iArr3, i2, sb);
        return i_renamed;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:44:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:67:0x00d3 A_renamed[PHI: r1
      0x00d3: PHI (r1v14 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode) = 
      (r1v2 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r1v2 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r1v2 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
      (r1v15 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode)
     binds: [B_renamed:61:0x00c2, B_renamed:49:0x00a1, B_renamed:38:0x007e, B_renamed:24:0x0051] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void decodeTextCompaction(int[] r12, int[] r13, int r14, java.lang.StringBuilder r15) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    /*  JADX ERROR: JadxRuntimeException in_renamed pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by_renamed exit block: B_renamed:30:0x0067
        	at_renamed jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at_renamed jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at_renamed jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at_renamed jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at_renamed jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at_renamed jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at_renamed jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at_renamed jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at_renamed jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
        	at_renamed jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at_renamed jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at_renamed jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at_renamed jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at_renamed jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at_renamed jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at_renamed jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at_renamed jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at_renamed jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at_renamed jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at_renamed jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Failed to find 'out' block for switch in_renamed B_renamed:34:0x0078. Please report as_renamed an_renamed issue. */
    /* JADX WARN: Failed to find 'out' block for switch in_renamed B_renamed:35:0x007b. Please report as_renamed an_renamed issue. */
    /* JADX WARN: Removed duplicated region for block: B_renamed:56:0x0045 A_renamed[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:59:0x0021 A_renamed[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int byteCompaction(int r16, int[] r17, java.nio.charset.Charset r18, int r19, java.lang.StringBuilder r20) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.byteCompaction(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int numericCompaction(int[] r7, int r8, java.lang.StringBuilder r9) throws com.google.zxing.FormatException {
        /*
            r0 = 15
            int[] r0 = new int[r0]
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            r4 = r7[r1]
            if (r8 >= r4) goto L47
            if (r2 != 0) goto L47
            int r4 = r8 + 1
            r8 = r7[r8]
            r5 = r7[r1]
            r6 = 1
            if (r4 != r5) goto L17
            r2 = r6
        L17:
            r5 = 900(0x384, float:1.261E-42)
            if (r8 >= r5) goto L20
            r0[r3] = r8
            int r3 = r3 + 1
            goto L31
        L20:
            if (r8 == r5) goto L2e
            r5 = 901(0x385, float:1.263E-42)
            if (r8 == r5) goto L2e
            r5 = 928(0x3a0, float:1.3E-42)
            if (r8 == r5) goto L2e
            switch(r8) {
                case 922: goto L2e;
                case 923: goto L2e;
                case 924: goto L2e;
                default: goto L2d;
            }
        L2d:
            goto L31
        L2e:
            int r4 = r4 + (-1)
            r2 = r6
        L31:
            int r5 = r3 % 15
            if (r5 == 0) goto L3b
            r5 = 902(0x386, float:1.264E-42)
            if (r8 == r5) goto L3b
            if (r2 == 0) goto L45
        L3b:
            if (r3 <= 0) goto L45
            java.lang.String r8 = decodeBase900toBase10(r0, r3)
            r9.append(r8)
            r3 = r1
        L45:
            r8 = r4
            goto L7
        L47:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.numericCompaction(int[], int, java.lang.StringBuilder):int");
    }

    private static java.lang.String decodeBase900toBase10(int[] iArr, int i_renamed) throws com.google.zxing.FormatException {
        java.math.BigInteger bigIntegerAdd = java.math.BigInteger.ZERO;
        for (int i2 = 0; i2 < i_renamed; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(EXP900[(i_renamed - i2) - 1].multiply(java.math.BigInteger.valueOf(iArr[i2])));
        }
        java.lang.String string = bigIntegerAdd.toString();
        if (string.charAt(0) != '1') {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        return string.substring(1);
    }
}
