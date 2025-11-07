package org.apache.commons.codec.language;

/* loaded from: classes2.dex */
public class DoubleMetaphone implements org.apache.commons.codec.StringEncoder {
    private static final java.lang.String VOWELS = "AEIOUY";
    private int maxCodeLen = 4;
    private static final java.lang.String[] SILENT_START = {"GN", "KN", "PN", "WR", "PS_renamed"};
    private static final java.lang.String[] L_R_N_M_B_H_F_V_W_SPACE = {"L_renamed", "R_renamed", "N_renamed", "M_renamed", "B_renamed", "H_renamed", "F_renamed", com.oplus.exif.OplusExifInterface.GpsStatus.INTEROPERABILITY, com.oplus.exif.OplusExifInterface.GpsLongitudeRef.WEST, " "};
    private static final java.lang.String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN_renamed", "IE", "EI", "ER"};
    private static final java.lang.String[] L_T_K_S_N_M_B_Z = {"L_renamed", com.oplus.exif.OplusExifInterface.GpsTrackRef.TRUE_DIRECTION, com.oplus.exif.OplusExifInterface.GpsSpeedRef.KILOMETERS, com.oplus.exif.OplusExifInterface.GpsLatitudeRef.SOUTH, "N_renamed", "M_renamed", "B_renamed", "Z_renamed"};

    public java.lang.String doubleMetaphone(java.lang.String str) {
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
    public java.lang.String doubleMetaphone(java.lang.String str, boolean z_renamed) {
        int i_renamed;
        ?? CleanInput = cleanInput(str);
        if (CleanInput == 0) {
            return null;
        }
        boolean zIsSlavoGermanic = isSlavoGermanic(CleanInput);
        ?? IsSilentStart = isSilentStart(CleanInput);
        org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult = new org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult(this, getMaxCodeLen());
        while (!doubleMetaphoneResult.isComplete() && IsSilentStart <= CleanInput.length() - 1) {
            char cCharAt = CleanInput.charAt(IsSilentStart);
            if (cCharAt == 199) {
                doubleMetaphoneResult.append('S_renamed');
            } else if (cCharAt != 209) {
                switch (cCharAt) {
                    case 'A_renamed':
                    case 'E_renamed':
                    case 'I_renamed':
                    case 'O_renamed':
                    case 'U_renamed':
                    case 'Y_renamed':
                        IsSilentStart = handleAEIOUY(doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'B_renamed':
                        doubleMetaphoneResult.append('P_renamed');
                        i_renamed = IsSilentStart + 1;
                        if (charAt(CleanInput, i_renamed) != 'B_renamed') {
                            IsSilentStart = i_renamed;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'C_renamed':
                        IsSilentStart = handleC(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'D_renamed':
                        IsSilentStart = handleD(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'F_renamed':
                        doubleMetaphoneResult.append('F_renamed');
                        i_renamed = IsSilentStart + 1;
                        if (charAt(CleanInput, i_renamed) != 'F_renamed') {
                            IsSilentStart = i_renamed;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'G_renamed':
                        IsSilentStart = handleG(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'H_renamed':
                        IsSilentStart = handleH(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'J_renamed':
                        IsSilentStart = handleJ(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'K_renamed':
                        doubleMetaphoneResult.append('K_renamed');
                        i_renamed = IsSilentStart + 1;
                        if (charAt(CleanInput, i_renamed) != 'K_renamed') {
                            IsSilentStart = i_renamed;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'L_renamed':
                        IsSilentStart = handleL(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'M_renamed':
                        doubleMetaphoneResult.append('M_renamed');
                        if (!conditionM0(CleanInput, IsSilentStart)) {
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'N_renamed':
                        doubleMetaphoneResult.append('N_renamed');
                        i_renamed = IsSilentStart + 1;
                        if (charAt(CleanInput, i_renamed) != 'N_renamed') {
                            IsSilentStart = i_renamed;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'P_renamed':
                        IsSilentStart = handleP(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'Q_renamed':
                        doubleMetaphoneResult.append('K_renamed');
                        i_renamed = IsSilentStart + 1;
                        if (charAt(CleanInput, i_renamed) != 'Q_renamed') {
                            IsSilentStart = i_renamed;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'R_renamed':
                        IsSilentStart = handleR(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'S_renamed':
                        IsSilentStart = handleS(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'T_renamed':
                        IsSilentStart = handleT(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'V_renamed':
                        doubleMetaphoneResult.append('F_renamed');
                        i_renamed = IsSilentStart + 1;
                        if (charAt(CleanInput, i_renamed) != 'V_renamed') {
                            IsSilentStart = i_renamed;
                            break;
                        } else {
                            IsSilentStart += 2;
                            break;
                        }
                    case 'W_renamed':
                        IsSilentStart = handleW(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'X_renamed':
                        IsSilentStart = handleX(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'Z_renamed':
                        IsSilentStart = handleZ(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                }
            } else {
                doubleMetaphoneResult.append('N_renamed');
            }
            IsSilentStart++;
        }
        return z_renamed ? doubleMetaphoneResult.getAlternate() : doubleMetaphoneResult.getPrimary();
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (!(obj instanceof java.lang.String)) {
            throw new org.apache.commons.codec.EncoderException("DoubleMetaphone encode parameter is_renamed not of_renamed type String");
        }
        return doubleMetaphone((java.lang.String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        return doubleMetaphone(str);
    }

    public boolean isDoubleMetaphoneEqual(java.lang.String str, java.lang.String str2) {
        return isDoubleMetaphoneEqual(str, str2, false);
    }

    public boolean isDoubleMetaphoneEqual(java.lang.String str, java.lang.String str2, boolean z_renamed) {
        return doubleMetaphone(str, z_renamed).equals(doubleMetaphone(str2, z_renamed));
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public void setMaxCodeLen(int i_renamed) {
        this.maxCodeLen = i_renamed;
    }

    private int handleAEIOUY(org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed) {
        if (i_renamed == 0) {
            doubleMetaphoneResult.append('A_renamed');
        }
        return i_renamed + 1;
    }

    private int handleC(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed) {
        if (conditionC0(str, i_renamed)) {
            doubleMetaphoneResult.append('K_renamed');
        } else if (i_renamed == 0 && contains(str, i_renamed, 6, "CAESAR")) {
            doubleMetaphoneResult.append('S_renamed');
        } else {
            if (contains(str, i_renamed, 2, "CH")) {
                return handleCH(str, doubleMetaphoneResult, i_renamed);
            }
            if (contains(str, i_renamed, 2, "CZ") && !contains(str, i_renamed - 2, 4, "WICZ")) {
                doubleMetaphoneResult.append('S_renamed', 'X_renamed');
            } else {
                int i2 = i_renamed + 1;
                if (contains(str, i2, 3, "CIA")) {
                    doubleMetaphoneResult.append('X_renamed');
                } else {
                    if (contains(str, i_renamed, 2, "CC") && (i_renamed != 1 || charAt(str, 0) != 'M_renamed')) {
                        return handleCC(str, doubleMetaphoneResult, i_renamed);
                    }
                    if (contains(str, i_renamed, 2, "CK", "CG", "CQ")) {
                        doubleMetaphoneResult.append('K_renamed');
                    } else if (contains(str, i_renamed, 2, "CI", "CE", "CY")) {
                        if (contains(str, i_renamed, 3, "CIO", "CIE", "CIA")) {
                            doubleMetaphoneResult.append('S_renamed', 'X_renamed');
                        } else {
                            doubleMetaphoneResult.append('S_renamed');
                        }
                    } else {
                        doubleMetaphoneResult.append('K_renamed');
                        if (!contains(str, i2, 2, " C_renamed", " Q_renamed", " G_renamed")) {
                            if (!contains(str, i2, 1, "C_renamed", com.oplus.exif.OplusExifInterface.GpsSpeedRef.KILOMETERS, "Q_renamed") || contains(str, i2, 2, "CE", "CI")) {
                                return i2;
                            }
                        }
                    }
                }
                return i_renamed + 3;
            }
        }
        return i_renamed + 2;
    }

    private int handleCC(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed) {
        int i2 = i_renamed + 2;
        if (contains(str, i2, 1, "I_renamed", com.oplus.exif.OplusExifInterface.GpsLongitudeRef.EAST, "H_renamed") && !contains(str, i2, 2, "HU")) {
            if ((i_renamed == 1 && charAt(str, i_renamed - 1) == 'A_renamed') || contains(str, i_renamed - 1, 5, "UCCEE", "UCCES")) {
                doubleMetaphoneResult.append("KS");
            } else {
                doubleMetaphoneResult.append('X_renamed');
            }
            return i_renamed + 3;
        }
        doubleMetaphoneResult.append('K_renamed');
        return i2;
    }

    private int handleCH(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed) {
        if (i_renamed > 0 && contains(str, i_renamed, 4, "CHAE")) {
            doubleMetaphoneResult.append('K_renamed', 'X_renamed');
        } else {
            if (!conditionCH0(str, i_renamed) && !conditionCH1(str, i_renamed)) {
                if (i_renamed > 0) {
                    if (contains(str, 0, 2, "MC")) {
                        doubleMetaphoneResult.append('K_renamed');
                    } else {
                        doubleMetaphoneResult.append('X_renamed', 'K_renamed');
                    }
                } else {
                    doubleMetaphoneResult.append('X_renamed');
                }
                return i_renamed + 2;
            }
            doubleMetaphoneResult.append('K_renamed');
        }
        return i_renamed + 2;
    }

    private int handleD(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed) {
        if (contains(str, i_renamed, 2, "DG")) {
            int i2 = i_renamed + 2;
            if (contains(str, i2, 1, "I_renamed", com.oplus.exif.OplusExifInterface.GpsLongitudeRef.EAST, "Y_renamed")) {
                doubleMetaphoneResult.append('J_renamed');
                return i_renamed + 3;
            }
            doubleMetaphoneResult.append("TK");
            return i2;
        }
        if (contains(str, i_renamed, 2, "DT", "DD")) {
            doubleMetaphoneResult.append('T_renamed');
            return 2 + i_renamed;
        }
        doubleMetaphoneResult.append('T_renamed');
        return i_renamed + 1;
    }

    private int handleG(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed, boolean z_renamed) {
        int i2;
        int i3 = i_renamed + 1;
        if (charAt(str, i3) == 'H_renamed') {
            return handleGH(str, doubleMetaphoneResult, i_renamed);
        }
        if (charAt(str, i3) == 'N_renamed') {
            if (i_renamed == 1 && isVowel(charAt(str, 0)) && !z_renamed) {
                doubleMetaphoneResult.append("KN", "N_renamed");
            } else if (!contains(str, i_renamed + 2, 2, "EY") && charAt(str, i3) != 'Y_renamed' && !z_renamed) {
                doubleMetaphoneResult.append("N_renamed", "KN");
            } else {
                doubleMetaphoneResult.append("KN");
            }
        } else if (contains(str, i3, 2, "LI") && !z_renamed) {
            doubleMetaphoneResult.append("KL", "L_renamed");
        } else if (i_renamed == 0 && (charAt(str, i3) == 'Y_renamed' || contains(str, i3, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
            doubleMetaphoneResult.append('K_renamed', 'J_renamed');
        } else {
            if (contains(str, i3, 2, "ER") || charAt(str, i3) == 'Y_renamed') {
                i2 = 3;
                if (!contains(str, 0, 6, "DANGER", "RANGER", "MANGER")) {
                    int i4 = i_renamed - 1;
                    if (!contains(str, i4, 1, com.oplus.exif.OplusExifInterface.GpsLongitudeRef.EAST, "I_renamed") && !contains(str, i4, 3, "RGY", "OGY")) {
                        doubleMetaphoneResult.append('K_renamed', 'J_renamed');
                    }
                }
            } else {
                i2 = 3;
            }
            if (contains(str, i3, 1, com.oplus.exif.OplusExifInterface.GpsLongitudeRef.EAST, "I_renamed", "Y_renamed") || contains(str, i_renamed - 1, 4, "AGGI", "OGGI")) {
                if (contains(str, 0, 4, "VAN ", "VON ") || contains(str, 0, i2, "SCH") || contains(str, i3, 2, "ET")) {
                    doubleMetaphoneResult.append('K_renamed');
                } else if (contains(str, i3, i2, "IER")) {
                    doubleMetaphoneResult.append('J_renamed');
                } else {
                    doubleMetaphoneResult.append('J_renamed', 'K_renamed');
                }
            } else {
                if (charAt(str, i3) == 'G_renamed') {
                    int i5 = i_renamed + 2;
                    doubleMetaphoneResult.append('K_renamed');
                    return i5;
                }
                doubleMetaphoneResult.append('K_renamed');
                return i3;
            }
        }
        return i_renamed + 2;
    }

    private int handleGH(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed) {
        if (i_renamed > 0 && !isVowel(charAt(str, i_renamed - 1))) {
            doubleMetaphoneResult.append('K_renamed');
        } else {
            if (i_renamed == 0) {
                int i2 = i_renamed + 2;
                if (charAt(str, i2) == 'I_renamed') {
                    doubleMetaphoneResult.append('J_renamed');
                } else {
                    doubleMetaphoneResult.append('K_renamed');
                }
                return i2;
            }
            if ((i_renamed <= 1 || !contains(str, i_renamed - 2, 1, "B_renamed", "H_renamed", "D_renamed")) && ((i_renamed <= 2 || !contains(str, i_renamed - 3, 1, "B_renamed", "H_renamed", "D_renamed")) && (i_renamed <= 3 || !contains(str, i_renamed - 4, 1, "B_renamed", "H_renamed")))) {
                if (i_renamed > 2 && charAt(str, i_renamed - 1) == 'U_renamed' && contains(str, i_renamed - 3, 1, "C_renamed", "G_renamed", "L_renamed", "R_renamed", com.oplus.exif.OplusExifInterface.GpsTrackRef.TRUE_DIRECTION)) {
                    doubleMetaphoneResult.append('F_renamed');
                } else if (i_renamed > 0 && charAt(str, i_renamed - 1) != 'I_renamed') {
                    doubleMetaphoneResult.append('K_renamed');
                }
            }
        }
        return i_renamed + 2;
    }

    private int handleH(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed) {
        if ((i_renamed != 0 && !isVowel(charAt(str, i_renamed - 1))) || !isVowel(charAt(str, i_renamed + 1))) {
            return i_renamed + 1;
        }
        doubleMetaphoneResult.append('H_renamed');
        return i_renamed + 2;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x004f  */
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
            java.lang.String r4 = "S_renamed"
            java.lang.String r5 = "K_renamed"
            java.lang.String r6 = "L_renamed"
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

    private int handleL(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed) {
        int i2 = i_renamed + 1;
        if (charAt(str, i2) == 'L_renamed') {
            if (conditionL0(str, i_renamed)) {
                doubleMetaphoneResult.appendPrimary('L_renamed');
            } else {
                doubleMetaphoneResult.append('L_renamed');
            }
            return i_renamed + 2;
        }
        doubleMetaphoneResult.append('L_renamed');
        return i2;
    }

    private int handleP(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed) {
        int i2 = i_renamed + 1;
        if (charAt(str, i2) == 'H_renamed') {
            doubleMetaphoneResult.append('F_renamed');
            return i_renamed + 2;
        }
        doubleMetaphoneResult.append('P_renamed');
        if (contains(str, i2, 1, "P_renamed", "B_renamed")) {
            i2 = i_renamed + 2;
        }
        return i2;
    }

    private int handleR(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed, boolean z_renamed) {
        if (i_renamed == str.length() - 1 && !z_renamed && contains(str, i_renamed - 2, 2, "IE") && !contains(str, i_renamed - 4, 2, "ME", "MA")) {
            doubleMetaphoneResult.appendAlternate('R_renamed');
        } else {
            doubleMetaphoneResult.append('R_renamed');
        }
        int i2 = i_renamed + 1;
        return charAt(str, i2) == 'R_renamed' ? i_renamed + 2 : i2;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:28:0x0085  */
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
            java.lang.String r14 = "Z_renamed"
            if (r9 != 0) goto L7d
            int r1 = r9 + 1
            r2 = 1
            java.lang.String r3 = "M_renamed"
            java.lang.String r4 = "N_renamed"
            java.lang.String r5 = "L_renamed"
            java.lang.String r6 = "W_renamed"
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
            java.lang.String r1 = "S_renamed"
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

    private int handleSC(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed) {
        int i2 = i_renamed + 2;
        if (charAt(str, i2) == 'H_renamed') {
            int i3 = i_renamed + 3;
            if (contains(str, i3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (contains(str, i3, 2, "ER", "EN")) {
                    doubleMetaphoneResult.append("X_renamed", "SK");
                } else {
                    doubleMetaphoneResult.append("SK");
                }
            } else if (i_renamed == 0 && !isVowel(charAt(str, 3)) && charAt(str, 3) != 'W_renamed') {
                doubleMetaphoneResult.append('X_renamed', 'S_renamed');
            } else {
                doubleMetaphoneResult.append('X_renamed');
            }
        } else if (contains(str, i2, 1, "I_renamed", com.oplus.exif.OplusExifInterface.GpsLongitudeRef.EAST, "Y_renamed")) {
            doubleMetaphoneResult.append('S_renamed');
        } else {
            doubleMetaphoneResult.append("SK");
        }
        return i_renamed + 3;
    }

    private int handleT(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed) {
        if (contains(str, i_renamed, 4, "TION") || contains(str, i_renamed, 3, "TIA", "TCH")) {
            doubleMetaphoneResult.append('X_renamed');
            return i_renamed + 3;
        }
        if (contains(str, i_renamed, 2, "TH") || contains(str, i_renamed, 3, "TTH")) {
            int i2 = i_renamed + 2;
            if (contains(str, i2, 2, "OM", "AM") || contains(str, 0, 4, "VAN ", "VON ") || contains(str, 0, 3, "SCH")) {
                doubleMetaphoneResult.append('T_renamed');
                return i2;
            }
            doubleMetaphoneResult.append('0', 'T_renamed');
            return i2;
        }
        doubleMetaphoneResult.append('T_renamed');
        int i3 = i_renamed + 1;
        return contains(str, i3, 1, com.oplus.exif.OplusExifInterface.GpsTrackRef.TRUE_DIRECTION, "D_renamed") ? i_renamed + 2 : i3;
    }

    private int handleW(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed) {
        if (contains(str, i_renamed, 2, "WR")) {
            doubleMetaphoneResult.append('R_renamed');
            return i_renamed + 2;
        }
        if (i_renamed == 0) {
            int i2 = i_renamed + 1;
            if (isVowel(charAt(str, i2)) || contains(str, i_renamed, 2, "WH")) {
                if (isVowel(charAt(str, i2))) {
                    doubleMetaphoneResult.append('A_renamed', 'F_renamed');
                } else {
                    doubleMetaphoneResult.append('A_renamed');
                }
                return i2;
            }
        }
        if ((i_renamed == str.length() - 1 && isVowel(charAt(str, i_renamed - 1))) || contains(str, i_renamed - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") || contains(str, 0, 3, "SCH")) {
            doubleMetaphoneResult.appendAlternate('F_renamed');
        } else if (contains(str, i_renamed, 4, "WICZ", "WITZ")) {
            doubleMetaphoneResult.append("TS", "FX");
            return i_renamed + 4;
        }
        return i_renamed + 1;
    }

    private int handleX(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed) {
        if (i_renamed == 0) {
            doubleMetaphoneResult.append('S_renamed');
            return i_renamed + 1;
        }
        if (i_renamed != str.length() - 1 || (!contains(str, i_renamed - 3, 3, "IAU", "EAU") && !contains(str, i_renamed - 2, 2, "AU", "OU"))) {
            doubleMetaphoneResult.append("KS");
        }
        int i2 = i_renamed + 1;
        return contains(str, i2, 1, "C_renamed", "X_renamed") ? i_renamed + 2 : i2;
    }

    private int handleZ(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i_renamed, boolean z_renamed) {
        int i2 = i_renamed + 1;
        if (charAt(str, i2) == 'H_renamed') {
            doubleMetaphoneResult.append('J_renamed');
            return i_renamed + 2;
        }
        if (contains(str, i2, 2, "ZO", "ZI", "ZA") || (z_renamed && i_renamed > 0 && charAt(str, i_renamed - 1) != 'T_renamed')) {
            doubleMetaphoneResult.append(com.oplus.exif.OplusExifInterface.GpsLatitudeRef.SOUTH, "TS");
        } else {
            doubleMetaphoneResult.append('S_renamed');
        }
        if (charAt(str, i2) == 'Z_renamed') {
            i2 = i_renamed + 2;
        }
        return i2;
    }

    private boolean conditionC0(java.lang.String str, int i_renamed) {
        if (contains(str, i_renamed, 4, "CHIA")) {
            return true;
        }
        if (i_renamed <= 1) {
            return false;
        }
        int i2 = i_renamed - 2;
        if (isVowel(charAt(str, i2)) || !contains(str, i_renamed - 1, 3, "ACH")) {
            return false;
        }
        char cCharAt = charAt(str, i_renamed + 2);
        return !(cCharAt == 'I_renamed' || cCharAt == 'E_renamed') || contains(str, i2, 6, "BACHER", "MACHER");
    }

    private boolean conditionCH0(java.lang.String str, int i_renamed) {
        if (i_renamed != 0) {
            return false;
        }
        int i2 = i_renamed + 1;
        return (contains(str, i2, 5, "HARAC", "HARIS") || contains(str, i2, 3, "HOR", "HYM", "HIA", "HEM")) && !contains(str, 0, 5, "CHORE");
    }

    private boolean conditionCH1(java.lang.String str, int i_renamed) {
        if (!contains(str, 0, 4, "VAN ", "VON ") && !contains(str, 0, 3, "SCH") && !contains(str, i_renamed - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
            int i2 = i_renamed + 2;
            if (!contains(str, i2, 1, com.oplus.exif.OplusExifInterface.GpsTrackRef.TRUE_DIRECTION, com.oplus.exif.OplusExifInterface.GpsLatitudeRef.SOUTH)) {
                if (!contains(str, i_renamed - 1, 1, com.oplus.exif.OplusExifInterface.GpsStatus.IN_PROGRESS, "O_renamed", "U_renamed", com.oplus.exif.OplusExifInterface.GpsLongitudeRef.EAST) && i_renamed != 0) {
                    return false;
                }
                if (!contains(str, i2, 1, L_R_N_M_B_H_F_V_W_SPACE) && i_renamed + 1 != str.length() - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean conditionL0(java.lang.String str, int i_renamed) {
        if (i_renamed == str.length() - 3 && contains(str, i_renamed - 1, 4, "ILLO", "ILLA", "ALLE")) {
            return true;
        }
        return (contains(str, str.length() - 2, 2, "AS_renamed", "OS") || contains(str, str.length() - 1, 1, com.oplus.exif.OplusExifInterface.GpsStatus.IN_PROGRESS, "O_renamed")) && contains(str, i_renamed - 1, 4, "ALLE");
    }

    private boolean conditionM0(java.lang.String str, int i_renamed) {
        int i2 = i_renamed + 1;
        if (charAt(str, i2) == 'M_renamed') {
            return true;
        }
        return contains(str, i_renamed + (-1), 3, "UMB") && (i2 == str.length() - 1 || contains(str, i_renamed + 2, 2, "ER"));
    }

    private boolean isSlavoGermanic(java.lang.String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf("CZ") > -1 || str.indexOf("WITZ") > -1;
    }

    private boolean isVowel(char c2) {
        return VOWELS.indexOf(c2) != -1;
    }

    private boolean isSilentStart(java.lang.String str) {
        int i_renamed = 0;
        while (true) {
            java.lang.String[] strArr = SILENT_START;
            if (i_renamed >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i_renamed])) {
                return true;
            }
            i_renamed++;
        }
    }

    private java.lang.String cleanInput(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return null;
        }
        return strTrim.toUpperCase(java.util.Locale.ENGLISH);
    }

    protected char charAt(java.lang.String str, int i_renamed) {
        if (i_renamed < 0 || i_renamed >= str.length()) {
            return (char) 0;
        }
        return str.charAt(i_renamed);
    }

    private static boolean contains(java.lang.String str, int i_renamed, int i2, java.lang.String str2) {
        return contains(str, i_renamed, i2, new java.lang.String[]{str2});
    }

    private static boolean contains(java.lang.String str, int i_renamed, int i2, java.lang.String str2, java.lang.String str3) {
        return contains(str, i_renamed, i2, new java.lang.String[]{str2, str3});
    }

    private static boolean contains(java.lang.String str, int i_renamed, int i2, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return contains(str, i_renamed, i2, new java.lang.String[]{str2, str3, str4});
    }

    private static boolean contains(java.lang.String str, int i_renamed, int i2, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        return contains(str, i_renamed, i2, new java.lang.String[]{str2, str3, str4, str5});
    }

    private static boolean contains(java.lang.String str, int i_renamed, int i2, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        return contains(str, i_renamed, i2, new java.lang.String[]{str2, str3, str4, str5, str6});
    }

    private static boolean contains(java.lang.String str, int i_renamed, int i2, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        return contains(str, i_renamed, i2, new java.lang.String[]{str2, str3, str4, str5, str6, str7});
    }

    protected static boolean contains(java.lang.String str, int i_renamed, int i2, java.lang.String[] strArr) {
        int i3;
        if (i_renamed < 0 || (i3 = i2 + i_renamed) > str.length()) {
            return false;
        }
        java.lang.String strSubstring = str.substring(i_renamed, i3);
        for (java.lang.String str2 : strArr) {
            if (strSubstring.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public class DoubleMetaphoneResult {
        private java.lang.StringBuffer alternate;
        private int maxLength;
        private java.lang.StringBuffer primary;
        private final org.apache.commons.codec.language.DoubleMetaphone this$0;

        public DoubleMetaphoneResult(org.apache.commons.codec.language.DoubleMetaphone doubleMetaphone, int i_renamed) {
            this.this$0 = doubleMetaphone;
            this.primary = new java.lang.StringBuffer(this.this$0.getMaxCodeLen());
            this.alternate = new java.lang.StringBuffer(this.this$0.getMaxCodeLen());
            this.maxLength = i_renamed;
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

        public void append(java.lang.String str) {
            appendPrimary(str);
            appendAlternate(str);
        }

        public void append(java.lang.String str, java.lang.String str2) {
            appendPrimary(str);
            appendAlternate(str2);
        }

        public void appendPrimary(java.lang.String str) {
            int length = this.maxLength - this.primary.length();
            if (str.length() <= length) {
                this.primary.append(str);
            } else {
                this.primary.append(str.substring(0, length));
            }
        }

        public void appendAlternate(java.lang.String str) {
            int length = this.maxLength - this.alternate.length();
            if (str.length() <= length) {
                this.alternate.append(str);
            } else {
                this.alternate.append(str.substring(0, length));
            }
        }

        public java.lang.String getPrimary() {
            return this.primary.toString();
        }

        public java.lang.String getAlternate() {
            return this.alternate.toString();
        }

        public boolean isComplete() {
            return this.primary.length() >= this.maxLength && this.alternate.length() >= this.maxLength;
        }
    }
}
