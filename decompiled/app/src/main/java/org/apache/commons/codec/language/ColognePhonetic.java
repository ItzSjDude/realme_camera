package org.apache.commons.codec.language;

/* loaded from: classes2.dex */
public class ColognePhonetic implements org.apache.commons.codec.StringEncoder {
    private static final char[][] PREPROCESS_MAP = {new char[]{196, 'A_renamed'}, new char[]{220, 'U_renamed'}, new char[]{214, 'O_renamed'}, new char[]{223, 'S_renamed'}};
    static java.lang.Class class$java$lang$String;

    private abstract class CologneBuffer {
        protected final char[] data;
        protected int length;
        private final org.apache.commons.codec.language.ColognePhonetic this$0;

        protected abstract char[] copyData(int i_renamed, int i2);

        public CologneBuffer(org.apache.commons.codec.language.ColognePhonetic colognePhonetic, char[] cArr) {
            this.this$0 = colognePhonetic;
            this.length = 0;
            this.data = cArr;
            this.length = cArr.length;
        }

        public CologneBuffer(org.apache.commons.codec.language.ColognePhonetic colognePhonetic, int i_renamed) {
            this.this$0 = colognePhonetic;
            this.length = 0;
            this.data = new char[i_renamed];
            this.length = 0;
        }

        public int length() {
            return this.length;
        }

        public java.lang.String toString() {
            return new java.lang.String(copyData(0, this.length));
        }
    }

    private class CologneOutputBuffer extends org.apache.commons.codec.language.ColognePhonetic.CologneBuffer {
        private final org.apache.commons.codec.language.ColognePhonetic this$0;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        public CologneOutputBuffer(org.apache.commons.codec.language.ColognePhonetic colognePhonetic, int i_renamed) {
            super(colognePhonetic, i_renamed);
            this.this$0 = colognePhonetic;
        }

        public void addRight(char c2) {
            this.data[this.length] = c2;
            this.length++;
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        protected char[] copyData(int i_renamed, int i2) {
            char[] cArr = new char[i2];
            java.lang.System.arraycopy(this.data, i_renamed, cArr, 0, i2);
            return cArr;
        }
    }

    private class CologneInputBuffer extends org.apache.commons.codec.language.ColognePhonetic.CologneBuffer {
        private final org.apache.commons.codec.language.ColognePhonetic this$0;

        /* JADX WARN: 'super' call moved to the top of_renamed the method (can break code semantics) */
        public CologneInputBuffer(org.apache.commons.codec.language.ColognePhonetic colognePhonetic, char[] cArr) {
            super(colognePhonetic, cArr);
            this.this$0 = colognePhonetic;
        }

        public void addLeft(char c2) {
            this.length++;
            this.data[getNextPos()] = c2;
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        protected char[] copyData(int i_renamed, int i2) {
            char[] cArr = new char[i2];
            java.lang.System.arraycopy(this.data, (this.data.length - this.length) + i_renamed, cArr, 0, i2);
            return cArr;
        }

        public char getNextChar() {
            return this.data[getNextPos()];
        }

        protected int getNextPos() {
            return this.data.length - this.length;
        }

        public char removeNext() {
            this.length--;
            return getNextChar();
        }
    }

    private static boolean arrayContains(char[] cArr, char c2) {
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    public java.lang.String colognePhonetic(java.lang.String str) {
        char c2;
        if (str == null) {
            return null;
        }
        java.lang.String strPreprocess = preprocess(str);
        org.apache.commons.codec.language.ColognePhonetic.CologneOutputBuffer cologneOutputBuffer = new org.apache.commons.codec.language.ColognePhonetic.CologneOutputBuffer(this, strPreprocess.length() * 2);
        org.apache.commons.codec.language.ColognePhonetic.CologneInputBuffer cologneInputBuffer = new org.apache.commons.codec.language.ColognePhonetic.CologneInputBuffer(this, strPreprocess.toCharArray());
        int length = cologneInputBuffer.length();
        char c3 = '/';
        char c4 = '-';
        while (length > 0) {
            char cRemoveNext = cologneInputBuffer.removeNext();
            int length2 = cologneInputBuffer.length();
            char nextChar = length2 > 0 ? cologneInputBuffer.getNextChar() : '-';
            if (arrayContains(new char[]{'A_renamed', 'E_renamed', 'I_renamed', 'J_renamed', 'O_renamed', 'U_renamed', 'Y_renamed'}, cRemoveNext)) {
                c2 = '0';
            } else if (cRemoveNext == 'H_renamed' || cRemoveNext < 'A_renamed' || cRemoveNext > 'Z_renamed') {
                if (c3 == '/') {
                    length = length2;
                } else {
                    c2 = '-';
                }
            } else if (cRemoveNext == 'B_renamed' || (cRemoveNext == 'P_renamed' && nextChar != 'H_renamed')) {
                c2 = '1';
            } else if ((cRemoveNext == 'D_renamed' || cRemoveNext == 'T_renamed') && !arrayContains(new char[]{'S_renamed', 'C_renamed', 'Z_renamed'}, nextChar)) {
                c2 = '2';
            } else if (arrayContains(new char[]{'W_renamed', 'F_renamed', 'P_renamed', 'V_renamed'}, cRemoveNext)) {
                c2 = '3';
            } else {
                if (arrayContains(new char[]{'G_renamed', 'K_renamed', 'Q_renamed'}, cRemoveNext)) {
                    c2 = '4';
                } else {
                    if (cRemoveNext == 'X_renamed' && !arrayContains(new char[]{'C_renamed', 'K_renamed', 'Q_renamed'}, c4)) {
                        cologneInputBuffer.addLeft('S_renamed');
                        length2++;
                    } else if (cRemoveNext == 'S_renamed' || cRemoveNext == 'Z_renamed') {
                        c2 = '8';
                    } else {
                        if (cRemoveNext == 'C_renamed') {
                            if (c3 != '/' ? arrayContains(new char[]{'S_renamed', 'Z_renamed'}, c4) || !arrayContains(new char[]{'A_renamed', 'H_renamed', 'O_renamed', 'U_renamed', 'K_renamed', 'Q_renamed', 'X_renamed'}, nextChar) : !arrayContains(new char[]{'A_renamed', 'H_renamed', 'K_renamed', 'L_renamed', 'O_renamed', 'Q_renamed', 'R_renamed', 'U_renamed', 'X_renamed'}, nextChar)) {
                            }
                        } else if (!arrayContains(new char[]{'T_renamed', 'D_renamed', 'X_renamed'}, cRemoveNext)) {
                            c2 = cRemoveNext == 'R_renamed' ? '7' : cRemoveNext == 'L_renamed' ? '5' : (cRemoveNext == 'M_renamed' || cRemoveNext == 'N_renamed') ? '6' : cRemoveNext;
                        }
                        c2 = '8';
                    }
                    c2 = '4';
                }
                length = length2;
            }
            if (c2 != '-' && ((c3 != c2 && (c2 != '0' || c3 == '/')) || c2 < '0' || c2 > '8')) {
                cologneOutputBuffer.addRight(c2);
            }
            c3 = c2;
            c4 = cRemoveNext;
            length = length2;
        }
        return cologneOutputBuffer.toString();
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws java.lang.Throwable {
        if (!(obj instanceof java.lang.String)) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append("This method’s_renamed parameter was expected to be_renamed of_renamed the type ");
            java.lang.Class clsClass$ = class$java$lang$String;
            if (clsClass$ == null) {
                clsClass$ = class$("java.lang.String");
                class$java$lang$String = clsClass$;
            }
            stringBuffer.append(clsClass$.getName());
            stringBuffer.append(". But actually it was of_renamed the type ");
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append(".");
            throw new org.apache.commons.codec.EncoderException(stringBuffer.toString());
        }
        return encode((java.lang.String) obj);
    }

    static java.lang.Class class$(java.lang.String str) throws java.lang.Throwable {
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.ClassNotFoundException e_renamed) {
            throw new java.lang.NoClassDefFoundError().initCause(e_renamed);
        }
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        return colognePhonetic(str);
    }

    public boolean isEncodeEqual(java.lang.String str, java.lang.String str2) {
        return colognePhonetic(str).equals(colognePhonetic(str2));
    }

    private java.lang.String preprocess(java.lang.String str) {
        char[] charArray = str.toUpperCase(java.util.Locale.GERMAN).toCharArray();
        for (int i_renamed = 0; i_renamed < charArray.length; i_renamed++) {
            if (charArray[i_renamed] > 'Z_renamed') {
                int i2 = 0;
                while (true) {
                    char[][] cArr = PREPROCESS_MAP;
                    if (i2 >= cArr.length) {
                        break;
                    }
                    if (charArray[i_renamed] == cArr[i2][0]) {
                        charArray[i_renamed] = cArr[i2][1];
                        break;
                    }
                    i2++;
                }
            }
        }
        return new java.lang.String(charArray);
    }
}
