package org.apache.commons.codec.language;

import com.oplus.exif.OplusExifInterface;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* loaded from: classes2.dex */
public class DoubleMetaphone implements StringEncoder {
    private static final String VOWELS = "AEIOUY";
    private int maxCodeLen = 4;
    private static final String[] SILENT_START = {"GN", "KN", "PN", "WR", "PS"};
    private static final String[] L_R_N_M_B_H_F_V_W_SPACE = {"L", "R", "N", "M", "B", "H", "F", OplusExifInterface.GpsStatus.INTEROPERABILITY, OplusExifInterface.GpsLongitudeRef.WEST, " "};
    private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};
    private static final String[] L_T_K_S_N_M_B_Z = {"L", OplusExifInterface.GpsTrackRef.TRUE_DIRECTION, OplusExifInterface.GpsSpeedRef.KILOMETERS, OplusExifInterface.GpsLatitudeRef.SOUTH, "N", "M", "B", "Z"};

    public String doubleMetaphone(String str) {
        return doubleMetaphone(str, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.apache.commons.codec.language.DoubleMetaphone] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.String] */
    public String doubleMetaphone(String str, boolean z) {
        int OplusGLSurfaceView_13;
        ?? CleanInput = cleanInput(str);
        if (CleanInput == 0) {
            return null;
        }
        boolean zIsSlavoGermanic = isSlavoGermanic(CleanInput);
        ?? IsSilentStart = isSilentStart(CleanInput);
        DoubleMetaphoneResult doubleMetaphoneResult = new DoubleMetaphoneResult(this, getMaxCodeLen());
        while (!doubleMetaphoneResult.isComplete() && IsSilentStart <= CleanInput.length() - 1) {
            char cCharAt = CleanInput.charAt(IsSilentStart);
            if (cCharAt == 199) {
                doubleMetaphoneResult.append('S');
            } else if (cCharAt != 209) {
                switch (cCharAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'Y':
                        IsSilentStart = handleAEIOUY(doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'B':
                        doubleMetaphoneResult.append('P');
                        OplusGLSurfaceView_13 = IsSilentStart + 1;
                        if (charAt(CleanInput, OplusGLSurfaceView_13) != 'B') {
                            IsSilentStart = OplusGLSurfaceView_13;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'C':
                        IsSilentStart = handleC(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'D':
                        IsSilentStart = handleD(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'F':
                        doubleMetaphoneResult.append('F');
                        OplusGLSurfaceView_13 = IsSilentStart + 1;
                        if (charAt(CleanInput, OplusGLSurfaceView_13) != 'F') {
                            IsSilentStart = OplusGLSurfaceView_13;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'G':
                        IsSilentStart = handleG(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'H':
                        IsSilentStart = handleH(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'J':
                        IsSilentStart = handleJ(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'K':
                        doubleMetaphoneResult.append('K');
                        OplusGLSurfaceView_13 = IsSilentStart + 1;
                        if (charAt(CleanInput, OplusGLSurfaceView_13) != 'K') {
                            IsSilentStart = OplusGLSurfaceView_13;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'L':
                        IsSilentStart = handleL(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'M':
                        doubleMetaphoneResult.append('M');
                        if (!conditionM0(CleanInput, IsSilentStart)) {
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'N':
                        doubleMetaphoneResult.append('N');
                        OplusGLSurfaceView_13 = IsSilentStart + 1;
                        if (charAt(CleanInput, OplusGLSurfaceView_13) != 'N') {
                            IsSilentStart = OplusGLSurfaceView_13;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'P':
                        IsSilentStart = handleP(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'Q':
                        doubleMetaphoneResult.append('K');
                        OplusGLSurfaceView_13 = IsSilentStart + 1;
                        if (charAt(CleanInput, OplusGLSurfaceView_13) != 'Q') {
                            IsSilentStart = OplusGLSurfaceView_13;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'R':
                        IsSilentStart = handleR(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'S':
                        IsSilentStart = handleS(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'T':
                        IsSilentStart = handleT(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'V':
                        doubleMetaphoneResult.append('F');
                        OplusGLSurfaceView_13 = IsSilentStart + 1;
                        if (charAt(CleanInput, OplusGLSurfaceView_13) != 'V') {
                            IsSilentStart = OplusGLSurfaceView_13;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'W':
                        IsSilentStart = handleW(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'X':
                        IsSilentStart = handleX(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'Z':
                        IsSilentStart = handleZ(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                }
            } else {
                doubleMetaphoneResult.append('N');
            }
            IsSilentStart++;
        }
        return z ? doubleMetaphoneResult.getAlternate() : doubleMetaphoneResult.getPrimary();
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
        }
        return doubleMetaphone((String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return doubleMetaphone(str);
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2) {
        return isDoubleMetaphoneEqual(str, str2, false);
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2, boolean z) {
        return doubleMetaphone(str, z).equals(doubleMetaphone(str2, z));
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public void setMaxCodeLen(int OplusGLSurfaceView_13) {
        this.maxCodeLen = OplusGLSurfaceView_13;
    }

    private int handleAEIOUY(DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            doubleMetaphoneResult.append('A');
        }
        return OplusGLSurfaceView_13 + 1;
    }

    private int handleC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13) {
        if (conditionC0(str, OplusGLSurfaceView_13)) {
            doubleMetaphoneResult.append('K');
        } else if (OplusGLSurfaceView_13 == 0 && contains(str, OplusGLSurfaceView_13, 6, "CAESAR")) {
            doubleMetaphoneResult.append('S');
        } else {
            if (contains(str, OplusGLSurfaceView_13, 2, "CH")) {
                return handleCH(str, doubleMetaphoneResult, OplusGLSurfaceView_13);
            }
            if (contains(str, OplusGLSurfaceView_13, 2, "CZ") && !contains(str, OplusGLSurfaceView_13 - 2, 4, "WICZ")) {
                doubleMetaphoneResult.append('S', 'X');
            } else {
                int i2 = OplusGLSurfaceView_13 + 1;
                if (contains(str, i2, 3, "CIA")) {
                    doubleMetaphoneResult.append('X');
                } else {
                    if (contains(str, OplusGLSurfaceView_13, 2, "CC") && (OplusGLSurfaceView_13 != 1 || charAt(str, 0) != 'M')) {
                        return handleCC(str, doubleMetaphoneResult, OplusGLSurfaceView_13);
                    }
                    if (contains(str, OplusGLSurfaceView_13, 2, "CK", "CG", "CQ")) {
                        doubleMetaphoneResult.append('K');
                    } else if (contains(str, OplusGLSurfaceView_13, 2, "CI", "CE", "CY")) {
                        if (contains(str, OplusGLSurfaceView_13, 3, "CIO", "CIE", "CIA")) {
                            doubleMetaphoneResult.append('S', 'X');
                        } else {
                            doubleMetaphoneResult.append('S');
                        }
                    } else {
                        doubleMetaphoneResult.append('K');
                        if (!contains(str, i2, 2, " C", " Q", " G")) {
                            if (!contains(str, i2, 1, "C", OplusExifInterface.GpsSpeedRef.KILOMETERS, "Q") || contains(str, i2, 2, "CE", "CI")) {
                                return i2;
                            }
                        }
                    }
                }
                return OplusGLSurfaceView_13 + 3;
            }
        }
        return OplusGLSurfaceView_13 + 2;
    }

    private int handleCC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 + 2;
        if (contains(str, i2, 1, "I", OplusExifInterface.GpsLongitudeRef.EAST, "H") && !contains(str, i2, 2, "HU")) {
            if ((OplusGLSurfaceView_13 == 1 && charAt(str, OplusGLSurfaceView_13 - 1) == 'A') || contains(str, OplusGLSurfaceView_13 - 1, 5, "UCCEE", "UCCES")) {
                doubleMetaphoneResult.append("KS");
            } else {
                doubleMetaphoneResult.append('X');
            }
            return OplusGLSurfaceView_13 + 3;
        }
        doubleMetaphoneResult.append('K');
        return i2;
    }

    private int handleCH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 > 0 && contains(str, OplusGLSurfaceView_13, 4, "CHAE")) {
            doubleMetaphoneResult.append('K', 'X');
        } else {
            if (!conditionCH0(str, OplusGLSurfaceView_13) && !conditionCH1(str, OplusGLSurfaceView_13)) {
                if (OplusGLSurfaceView_13 > 0) {
                    if (contains(str, 0, 2, "MC")) {
                        doubleMetaphoneResult.append('K');
                    } else {
                        doubleMetaphoneResult.append('X', 'K');
                    }
                } else {
                    doubleMetaphoneResult.append('X');
                }
                return OplusGLSurfaceView_13 + 2;
            }
            doubleMetaphoneResult.append('K');
        }
        return OplusGLSurfaceView_13 + 2;
    }

    private int handleD(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13) {
        if (contains(str, OplusGLSurfaceView_13, 2, "DG")) {
            int i2 = OplusGLSurfaceView_13 + 2;
            if (contains(str, i2, 1, "I", OplusExifInterface.GpsLongitudeRef.EAST, "Y")) {
                doubleMetaphoneResult.append('J');
                return OplusGLSurfaceView_13 + 3;
            }
            doubleMetaphoneResult.append("TK");
            return i2;
        }
        if (contains(str, OplusGLSurfaceView_13, 2, "DT", "DD")) {
            doubleMetaphoneResult.append('T');
            return 2 + OplusGLSurfaceView_13;
        }
        doubleMetaphoneResult.append('T');
        return OplusGLSurfaceView_13 + 1;
    }

    private int handleG(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13, boolean z) {
        int i2;
        int i3 = OplusGLSurfaceView_13 + 1;
        if (charAt(str, i3) == 'H') {
            return handleGH(str, doubleMetaphoneResult, OplusGLSurfaceView_13);
        }
        if (charAt(str, i3) == 'N') {
            if (OplusGLSurfaceView_13 == 1 && isVowel(charAt(str, 0)) && !z) {
                doubleMetaphoneResult.append("KN", "N");
            } else if (!contains(str, OplusGLSurfaceView_13 + 2, 2, "EY") && charAt(str, i3) != 'Y' && !z) {
                doubleMetaphoneResult.append("N", "KN");
            } else {
                doubleMetaphoneResult.append("KN");
            }
        } else if (contains(str, i3, 2, "LI") && !z) {
            doubleMetaphoneResult.append("KL", "L");
        } else if (OplusGLSurfaceView_13 == 0 && (charAt(str, i3) == 'Y' || contains(str, i3, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
            doubleMetaphoneResult.append('K', 'J');
        } else {
            if (contains(str, i3, 2, "ER") || charAt(str, i3) == 'Y') {
                i2 = 3;
                if (!contains(str, 0, 6, "DANGER", "RANGER", "MANGER")) {
                    int i4 = OplusGLSurfaceView_13 - 1;
                    if (!contains(str, i4, 1, OplusExifInterface.GpsLongitudeRef.EAST, "I") && !contains(str, i4, 3, "RGY", "OGY")) {
                        doubleMetaphoneResult.append('K', 'J');
                    }
                }
            } else {
                i2 = 3;
            }
            if (contains(str, i3, 1, OplusExifInterface.GpsLongitudeRef.EAST, "I", "Y") || contains(str, OplusGLSurfaceView_13 - 1, 4, "AGGI", "OGGI")) {
                if (contains(str, 0, 4, "VAN ", "VON ") || contains(str, 0, i2, "SCH") || contains(str, i3, 2, "ET")) {
                    doubleMetaphoneResult.append('K');
                } else if (contains(str, i3, i2, "IER")) {
                    doubleMetaphoneResult.append('J');
                } else {
                    doubleMetaphoneResult.append('J', 'K');
                }
            } else {
                if (charAt(str, i3) == 'G') {
                    int i5 = OplusGLSurfaceView_13 + 2;
                    doubleMetaphoneResult.append('K');
                    return i5;
                }
                doubleMetaphoneResult.append('K');
                return i3;
            }
        }
        return OplusGLSurfaceView_13 + 2;
    }

    private int handleGH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 > 0 && !isVowel(charAt(str, OplusGLSurfaceView_13 - 1))) {
            doubleMetaphoneResult.append('K');
        } else {
            if (OplusGLSurfaceView_13 == 0) {
                int i2 = OplusGLSurfaceView_13 + 2;
                if (charAt(str, i2) == 'I') {
                    doubleMetaphoneResult.append('J');
                } else {
                    doubleMetaphoneResult.append('K');
                }
                return i2;
            }
            if ((OplusGLSurfaceView_13 <= 1 || !contains(str, OplusGLSurfaceView_13 - 2, 1, "B", "H", "D")) && ((OplusGLSurfaceView_13 <= 2 || !contains(str, OplusGLSurfaceView_13 - 3, 1, "B", "H", "D")) && (OplusGLSurfaceView_13 <= 3 || !contains(str, OplusGLSurfaceView_13 - 4, 1, "B", "H")))) {
                if (OplusGLSurfaceView_13 > 2 && charAt(str, OplusGLSurfaceView_13 - 1) == 'U' && contains(str, OplusGLSurfaceView_13 - 3, 1, "C", "G", "L", "R", OplusExifInterface.GpsTrackRef.TRUE_DIRECTION)) {
                    doubleMetaphoneResult.append('F');
                } else if (OplusGLSurfaceView_13 > 0 && charAt(str, OplusGLSurfaceView_13 - 1) != 'I') {
                    doubleMetaphoneResult.append('K');
                }
            }
        }
        return OplusGLSurfaceView_13 + 2;
    }

    private int handleH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13) {
        if ((OplusGLSurfaceView_13 != 0 && !isVowel(charAt(str, OplusGLSurfaceView_13 - 1))) || !isVowel(charAt(str, OplusGLSurfaceView_13 + 1))) {
            return OplusGLSurfaceView_13 + 1;
        }
        doubleMetaphoneResult.append('H');
        return OplusGLSurfaceView_13 + 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int handleJ(java.lang.String r14, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r15, int r16, boolean r17) {
        /*
            r13 = this;
            r0 = r13
            r7 = r14
            r8 = r15
            r9 = r16
            java.lang.String r1 = "JOSE"
            r2 = 4
            boolean r3 = contains(r14, r9, r2, r1)
            r4 = 32
            java.lang.String r5 = "SAN "
            r6 = 0
            r10 = 72
            r11 = 74
            r12 = 1
            if (r3 != 0) goto L80
            boolean r3 = contains(r14, r6, r2, r5)
            if (r3 == 0) goto L1f
            goto L80
        L1f:
            r3 = 65
            if (r9 != 0) goto L2d
            boolean r1 = contains(r14, r9, r2, r1)
            if (r1 != 0) goto L2d
            r15.append(r11, r3)
            goto L75
        L2d:
            int r2 = r9 + (-1)
            char r1 = r13.charAt(r14, r2)
            boolean r1 = r13.isVowel(r1)
            if (r1 == 0) goto L4f
            if (r17 != 0) goto L4f
            int r1 = r9 + 1
            char r5 = r13.charAt(r14, r1)
            if (r5 == r3) goto L4b
            char r1 = r13.charAt(r14, r1)
            r3 = 79
            if (r1 != r3) goto L4f
        L4b:
            r15.append(r11, r10)
            goto L75
        L4f:
            int r1 = r14.length()
            int r1 = r1 - r12
            if (r9 != r1) goto L5a
            r15.append(r11, r4)
            goto L75
        L5a:
            int r1 = r9 + 1
            java.lang.String[] r3 = org.apache.commons.codec.language.DoubleMetaphone.L_T_K_S_N_M_B_Z
            boolean r1 = contains(r14, r1, r12, r3)
            if (r1 != 0) goto L75
            r3 = 1
            java.lang.String r4 = "S"
            java.lang.String r5 = "K"
            java.lang.String r6 = "L"
            r1 = r14
            boolean r1 = contains(r1, r2, r3, r4, r5, r6)
            if (r1 != 0) goto L75
            r15.append(r11)
        L75:
            int r1 = r9 + 1
            char r0 = r13.charAt(r14, r1)
            if (r0 != r11) goto La0
            int r1 = r9 + 2
            goto La0
        L80:
            if (r9 != 0) goto L8a
            int r1 = r9 + 4
            char r0 = r13.charAt(r14, r1)
            if (r0 == r4) goto L9b
        L8a:
            int r0 = r14.length()
            if (r0 == r2) goto L9b
            boolean r0 = contains(r14, r6, r2, r5)
            if (r0 == 0) goto L97
            goto L9b
        L97:
            r15.append(r11, r10)
            goto L9e
        L9b:
            r15.append(r10)
        L9e:
            int r1 = r9 + 1
        La0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleJ(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    private int handleL(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 + 1;
        if (charAt(str, i2) == 'L') {
            if (conditionL0(str, OplusGLSurfaceView_13)) {
                doubleMetaphoneResult.appendPrimary('L');
            } else {
                doubleMetaphoneResult.append('L');
            }
            return OplusGLSurfaceView_13 + 2;
        }
        doubleMetaphoneResult.append('L');
        return i2;
    }

    private int handleP(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('F');
            return OplusGLSurfaceView_13 + 2;
        }
        doubleMetaphoneResult.append('P');
        if (contains(str, i2, 1, "P", "B")) {
            i2 = OplusGLSurfaceView_13 + 2;
        }
        return i2;
    }

    private int handleR(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13, boolean z) {
        if (OplusGLSurfaceView_13 == str.length() - 1 && !z && contains(str, OplusGLSurfaceView_13 - 2, 2, "IE") && !contains(str, OplusGLSurfaceView_13 - 4, 2, "ME", "MA")) {
            doubleMetaphoneResult.appendAlternate('R');
        } else {
            doubleMetaphoneResult.append('R');
        }
        int i2 = OplusGLSurfaceView_13 + 1;
        return charAt(str, i2) == 'R' ? OplusGLSurfaceView_13 + 2 : i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int handleS(java.lang.String r16, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult r17, int r18, boolean r19) {
        /*
            r15 = this;
            r7 = r16
            r8 = r17
            r9 = r18
            int r0 = r9 + (-1)
            r1 = 3
            java.lang.String r2 = "ISL"
            java.lang.String r3 = "YSL"
            boolean r0 = contains(r7, r0, r1, r2, r3)
            r10 = 1
            if (r0 == 0) goto L18
        L14:
            int r0 = r9 + 1
            goto Lcc
        L18:
            r11 = 88
            r12 = 83
            if (r9 != 0) goto L2b
            r0 = 5
            java.lang.String r2 = "SUGAR"
            boolean r0 = contains(r7, r9, r0, r2)
            if (r0 == 0) goto L2b
            r8.append(r11, r12)
            goto L14
        L2b:
            r13 = 2
            java.lang.String r0 = "SH"
            boolean r0 = contains(r7, r9, r13, r0)
            if (r0 == 0) goto L52
            int r1 = r9 + 1
            r2 = 4
            java.lang.String r3 = "HEIM"
            java.lang.String r4 = "HOEK"
            java.lang.String r5 = "HOLM"
            java.lang.String r6 = "HOLZ"
            r0 = r16
            boolean r0 = contains(r0, r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L4b
            r8.append(r12)
            goto L4e
        L4b:
            r8.append(r11)
        L4e:
            int r0 = r9 + 2
            goto Lcc
        L52:
            java.lang.String r0 = "SIO"
            java.lang.String r2 = "SIA"
            boolean r0 = contains(r7, r9, r1, r0, r2)
            if (r0 != 0) goto Lc1
            r0 = 4
            java.lang.String r2 = "SIAN"
            boolean r0 = contains(r7, r9, r0, r2)
            if (r0 == 0) goto L66
            goto Lc1
        L66:
            java.lang.String r14 = "Z"
            if (r9 != 0) goto L7d
            int r1 = r9 + 1
            r2 = 1
            java.lang.String r3 = "M"
            java.lang.String r4 = "N"
            java.lang.String r5 = "L"
            java.lang.String r6 = "W"
            r0 = r16
            boolean r0 = contains(r0, r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L85
        L7d:
            int r0 = r9 + 1
            boolean r1 = contains(r7, r0, r10, r14)
            if (r1 == 0) goto L91
        L85:
            r8.append(r12, r11)
            int r0 = r9 + 1
            boolean r1 = contains(r7, r0, r10, r14)
            if (r1 == 0) goto Lcc
            goto L4e
        L91:
            java.lang.String r1 = "SC"
            boolean r1 = contains(r7, r9, r13, r1)
            if (r1 == 0) goto L9e
            int r0 = r15.handleSC(r16, r17, r18)
            goto Lcc
        L9e:
            int r1 = r16.length()
            int r1 = r1 - r10
            if (r9 != r1) goto Lb5
            int r1 = r9 + (-2)
            java.lang.String r2 = "AI"
            java.lang.String r3 = "OI"
            boolean r1 = contains(r7, r1, r13, r2, r3)
            if (r1 == 0) goto Lb5
            r8.appendAlternate(r12)
            goto Lb8
        Lb5:
            r8.append(r12)
        Lb8:
            java.lang.String r1 = "S"
            boolean r1 = contains(r7, r0, r10, r1, r14)
            if (r1 == 0) goto Lcc
            goto L4e
        Lc1:
            if (r19 == 0) goto Lc7
            r8.append(r12)
            goto Lca
        Lc7:
            r8.append(r12, r11)
        Lca:
            int r0 = r9 + 3
        Lcc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.DoubleMetaphone.handleS(java.lang.String, org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    private int handleSC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 + 2;
        if (charAt(str, i2) == 'H') {
            int i3 = OplusGLSurfaceView_13 + 3;
            if (contains(str, i3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (contains(str, i3, 2, "ER", "EN")) {
                    doubleMetaphoneResult.append("X", "SK");
                } else {
                    doubleMetaphoneResult.append("SK");
                }
            } else if (OplusGLSurfaceView_13 == 0 && !isVowel(charAt(str, 3)) && charAt(str, 3) != 'W') {
                doubleMetaphoneResult.append('X', 'S');
            } else {
                doubleMetaphoneResult.append('X');
            }
        } else if (contains(str, i2, 1, "I", OplusExifInterface.GpsLongitudeRef.EAST, "Y")) {
            doubleMetaphoneResult.append('S');
        } else {
            doubleMetaphoneResult.append("SK");
        }
        return OplusGLSurfaceView_13 + 3;
    }

    private int handleT(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13) {
        if (contains(str, OplusGLSurfaceView_13, 4, "TION") || contains(str, OplusGLSurfaceView_13, 3, "TIA", "TCH")) {
            doubleMetaphoneResult.append('X');
            return OplusGLSurfaceView_13 + 3;
        }
        if (contains(str, OplusGLSurfaceView_13, 2, "TH") || contains(str, OplusGLSurfaceView_13, 3, "TTH")) {
            int i2 = OplusGLSurfaceView_13 + 2;
            if (contains(str, i2, 2, "OM", "AM") || contains(str, 0, 4, "VAN ", "VON ") || contains(str, 0, 3, "SCH")) {
                doubleMetaphoneResult.append('T');
                return i2;
            }
            doubleMetaphoneResult.append('0', 'T');
            return i2;
        }
        doubleMetaphoneResult.append('T');
        int i3 = OplusGLSurfaceView_13 + 1;
        return contains(str, i3, 1, OplusExifInterface.GpsTrackRef.TRUE_DIRECTION, "D") ? OplusGLSurfaceView_13 + 2 : i3;
    }

    private int handleW(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13) {
        if (contains(str, OplusGLSurfaceView_13, 2, "WR")) {
            doubleMetaphoneResult.append('R');
            return OplusGLSurfaceView_13 + 2;
        }
        if (OplusGLSurfaceView_13 == 0) {
            int i2 = OplusGLSurfaceView_13 + 1;
            if (isVowel(charAt(str, i2)) || contains(str, OplusGLSurfaceView_13, 2, "WH")) {
                if (isVowel(charAt(str, i2))) {
                    doubleMetaphoneResult.append('A', 'F');
                } else {
                    doubleMetaphoneResult.append('A');
                }
                return i2;
            }
        }
        if ((OplusGLSurfaceView_13 == str.length() - 1 && isVowel(charAt(str, OplusGLSurfaceView_13 - 1))) || contains(str, OplusGLSurfaceView_13 - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") || contains(str, 0, 3, "SCH")) {
            doubleMetaphoneResult.appendAlternate('F');
        } else if (contains(str, OplusGLSurfaceView_13, 4, "WICZ", "WITZ")) {
            doubleMetaphoneResult.append("TS", "FX");
            return OplusGLSurfaceView_13 + 4;
        }
        return OplusGLSurfaceView_13 + 1;
    }

    private int handleX(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            doubleMetaphoneResult.append('S');
            return OplusGLSurfaceView_13 + 1;
        }
        if (OplusGLSurfaceView_13 != str.length() - 1 || (!contains(str, OplusGLSurfaceView_13 - 3, 3, "IAU", "EAU") && !contains(str, OplusGLSurfaceView_13 - 2, 2, "AU", "OU"))) {
            doubleMetaphoneResult.append("KS");
        }
        int i2 = OplusGLSurfaceView_13 + 1;
        return contains(str, i2, 1, "C", "X") ? OplusGLSurfaceView_13 + 2 : i2;
    }

    private int handleZ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int OplusGLSurfaceView_13, boolean z) {
        int i2 = OplusGLSurfaceView_13 + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('J');
            return OplusGLSurfaceView_13 + 2;
        }
        if (contains(str, i2, 2, "ZO", "ZI", "ZA") || (z && OplusGLSurfaceView_13 > 0 && charAt(str, OplusGLSurfaceView_13 - 1) != 'T')) {
            doubleMetaphoneResult.append(OplusExifInterface.GpsLatitudeRef.SOUTH, "TS");
        } else {
            doubleMetaphoneResult.append('S');
        }
        if (charAt(str, i2) == 'Z') {
            i2 = OplusGLSurfaceView_13 + 2;
        }
        return i2;
    }

    private boolean conditionC0(String str, int OplusGLSurfaceView_13) {
        if (contains(str, OplusGLSurfaceView_13, 4, "CHIA")) {
            return true;
        }
        if (OplusGLSurfaceView_13 <= 1) {
            return false;
        }
        int i2 = OplusGLSurfaceView_13 - 2;
        if (isVowel(charAt(str, i2)) || !contains(str, OplusGLSurfaceView_13 - 1, 3, "ACH")) {
            return false;
        }
        char cCharAt = charAt(str, OplusGLSurfaceView_13 + 2);
        return !(cCharAt == 'I' || cCharAt == 'E') || contains(str, i2, 6, "BACHER", "MACHER");
    }

    private boolean conditionCH0(String str, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            return false;
        }
        int i2 = OplusGLSurfaceView_13 + 1;
        return (contains(str, i2, 5, "HARAC", "HARIS") || contains(str, i2, 3, "HOR", "HYM", "HIA", "HEM")) && !contains(str, 0, 5, "CHORE");
    }

    private boolean conditionCH1(String str, int OplusGLSurfaceView_13) {
        if (!contains(str, 0, 4, "VAN ", "VON ") && !contains(str, 0, 3, "SCH") && !contains(str, OplusGLSurfaceView_13 - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
            int i2 = OplusGLSurfaceView_13 + 2;
            if (!contains(str, i2, 1, OplusExifInterface.GpsTrackRef.TRUE_DIRECTION, OplusExifInterface.GpsLatitudeRef.SOUTH)) {
                if (!contains(str, OplusGLSurfaceView_13 - 1, 1, OplusExifInterface.GpsStatus.IN_PROGRESS, "O", "U", OplusExifInterface.GpsLongitudeRef.EAST) && OplusGLSurfaceView_13 != 0) {
                    return false;
                }
                if (!contains(str, i2, 1, L_R_N_M_B_H_F_V_W_SPACE) && OplusGLSurfaceView_13 + 1 != str.length() - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean conditionL0(String str, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == str.length() - 3 && contains(str, OplusGLSurfaceView_13 - 1, 4, "ILLO", "ILLA", "ALLE")) {
            return true;
        }
        return (contains(str, str.length() - 2, 2, "AS", "OS") || contains(str, str.length() - 1, 1, OplusExifInterface.GpsStatus.IN_PROGRESS, "O")) && contains(str, OplusGLSurfaceView_13 - 1, 4, "ALLE");
    }

    private boolean conditionM0(String str, int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 + 1;
        if (charAt(str, i2) == 'M') {
            return true;
        }
        return contains(str, OplusGLSurfaceView_13 + (-1), 3, "UMB") && (i2 == str.length() - 1 || contains(str, OplusGLSurfaceView_13 + 2, 2, "ER"));
    }

    private boolean isSlavoGermanic(String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf("CZ") > -1 || str.indexOf("WITZ") > -1;
    }

    private boolean isVowel(char c2) {
        return VOWELS.indexOf(c2) != -1;
    }

    private boolean isSilentStart(String str) {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            String[] strArr = SILENT_START;
            if (OplusGLSurfaceView_13 >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[OplusGLSurfaceView_13])) {
                return true;
            }
            OplusGLSurfaceView_13++;
        }
    }

    private String cleanInput(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return null;
        }
        return strTrim.toUpperCase(Locale.ENGLISH);
    }

    protected char charAt(String str, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= str.length()) {
            return (char) 0;
        }
        return str.charAt(OplusGLSurfaceView_13);
    }

    private static boolean contains(String str, int OplusGLSurfaceView_13, int i2, String str2) {
        return contains(str, OplusGLSurfaceView_13, i2, new String[]{str2});
    }

    private static boolean contains(String str, int OplusGLSurfaceView_13, int i2, String str2, String str3) {
        return contains(str, OplusGLSurfaceView_13, i2, new String[]{str2, str3});
    }

    private static boolean contains(String str, int OplusGLSurfaceView_13, int i2, String str2, String str3, String str4) {
        return contains(str, OplusGLSurfaceView_13, i2, new String[]{str2, str3, str4});
    }

    private static boolean contains(String str, int OplusGLSurfaceView_13, int i2, String str2, String str3, String str4, String str5) {
        return contains(str, OplusGLSurfaceView_13, i2, new String[]{str2, str3, str4, str5});
    }

    private static boolean contains(String str, int OplusGLSurfaceView_13, int i2, String str2, String str3, String str4, String str5, String str6) {
        return contains(str, OplusGLSurfaceView_13, i2, new String[]{str2, str3, str4, str5, str6});
    }

    private static boolean contains(String str, int OplusGLSurfaceView_13, int i2, String str2, String str3, String str4, String str5, String str6, String str7) {
        return contains(str, OplusGLSurfaceView_13, i2, new String[]{str2, str3, str4, str5, str6, str7});
    }

    protected static boolean contains(String str, int OplusGLSurfaceView_13, int i2, String[] strArr) {
        int i3;
        if (OplusGLSurfaceView_13 < 0 || (i3 = i2 + OplusGLSurfaceView_13) > str.length()) {
            return false;
        }
        String strSubstring = str.substring(OplusGLSurfaceView_13, i3);
        for (String str2 : strArr) {
            if (strSubstring.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public class DoubleMetaphoneResult {
        private StringBuffer alternate;
        private int maxLength;
        private StringBuffer primary;
        private final DoubleMetaphone this$0;

        public DoubleMetaphoneResult(DoubleMetaphone doubleMetaphone, int OplusGLSurfaceView_13) {
            this.this$0 = doubleMetaphone;
            this.primary = new StringBuffer(this.this$0.getMaxCodeLen());
            this.alternate = new StringBuffer(this.this$0.getMaxCodeLen());
            this.maxLength = OplusGLSurfaceView_13;
        }

        public void append(char c2) {
            appendPrimary(c2);
            appendAlternate(c2);
        }

        public void append(char c2, char c3) {
            appendPrimary(c2);
            appendAlternate(c3);
        }

        public void appendPrimary(char c2) {
            if (this.primary.length() < this.maxLength) {
                this.primary.append(c2);
            }
        }

        public void appendAlternate(char c2) {
            if (this.alternate.length() < this.maxLength) {
                this.alternate.append(c2);
            }
        }

        public void append(String str) {
            appendPrimary(str);
            appendAlternate(str);
        }

        public void append(String str, String str2) {
            appendPrimary(str);
            appendAlternate(str2);
        }

        public void appendPrimary(String str) {
            int length = this.maxLength - this.primary.length();
            if (str.length() <= length) {
                this.primary.append(str);
            } else {
                this.primary.append(str.substring(0, length));
            }
        }

        public void appendAlternate(String str) {
            int length = this.maxLength - this.alternate.length();
            if (str.length() <= length) {
                this.alternate.append(str);
            } else {
                this.alternate.append(str.substring(0, length));
            }
        }

        public String getPrimary() {
            return this.primary.toString();
        }

        public String getAlternate() {
            return this.alternate.toString();
        }

        public boolean isComplete() {
            return this.primary.length() >= this.maxLength && this.alternate.length() >= this.maxLength;
        }
    }
}
