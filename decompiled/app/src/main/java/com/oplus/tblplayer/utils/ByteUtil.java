package com.oplus.tblplayer.utils;

/* loaded from: classes2.dex */
public class ByteUtil {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a_renamed', 'b_renamed', 'c_renamed', 'd_renamed', 'e_renamed', 'f_renamed', 'g_renamed', 'h_renamed', 'i_renamed', 'j_renamed', 'k_renamed', 'l_renamed', 'm_renamed', 'n_renamed', 'o_renamed', 'p_renamed', 'q_renamed', 'r_renamed', 's_renamed', 't_renamed', 'u_renamed', 'v_renamed', 'w_renamed', 'x_renamed', 'y_renamed', 'z_renamed'};
    private static final char[] UPPER_CASE_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A_renamed', 'B_renamed', 'C_renamed', 'D_renamed', 'E_renamed', 'F_renamed', 'G_renamed', 'H_renamed', 'I_renamed', 'J_renamed', 'K_renamed', 'L_renamed', 'M_renamed', 'N_renamed', 'O_renamed', 'P_renamed', 'Q_renamed', 'R_renamed', 'S_renamed', 'T_renamed', 'U_renamed', 'V_renamed', 'W_renamed', 'X_renamed', 'Y_renamed', 'Z_renamed'};

    public static java.lang.String toHexArrayString(byte[] bArr, int i_renamed, int i2) {
        if (bArr == null || bArr.length == 0 || i_renamed < 0 || i2 <= 0) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("{");
        int iMin = java.lang.Math.min(bArr.length, i2 + i_renamed) - i_renamed;
        while (i_renamed < iMin) {
            try {
                sb.append(toHexString(bArr[i_renamed], true));
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
            if (i_renamed != iMin - 1) {
                sb.append(" ");
            } else {
                sb.append("}");
            }
            i_renamed++;
        }
        return sb.toString();
    }

    public static java.lang.String toHexString(byte b2, boolean z_renamed) {
        char[] cArr = z_renamed ? UPPER_CASE_DIGITS : DIGITS;
        return new java.lang.String(new char[]{cArr[(b2 >> 4) & 15], cArr[b2 & 15]}, 0, 2);
    }
}
