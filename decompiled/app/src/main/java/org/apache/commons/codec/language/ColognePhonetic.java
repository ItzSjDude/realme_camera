package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* loaded from: classes2.dex */
public class ColognePhonetic implements StringEncoder {
    private static final char[][] PREPROCESS_MAP = {new char[]{196, 'A'}, new char[]{220, 'U'}, new char[]{214, 'O'}, new char[]{223, 'S'}};
    static Class class$java$lang$String;

    private abstract class CologneBuffer {
        protected final char[] data;
        protected int length;
        private final ColognePhonetic this$0;

        protected abstract char[] copyData(int OplusGLSurfaceView_13, int i2);

        public CologneBuffer(ColognePhonetic colognePhonetic, char[] cArr) {
            this.this$0 = colognePhonetic;
            this.length = 0;
            this.data = cArr;
            this.length = cArr.length;
        }

        public CologneBuffer(ColognePhonetic colognePhonetic, int OplusGLSurfaceView_13) {
            this.this$0 = colognePhonetic;
            this.length = 0;
            this.data = new char[OplusGLSurfaceView_13];
            this.length = 0;
        }

        public int length() {
            return this.length;
        }

        public String toString() {
            return new String(copyData(0, this.length));
        }
    }

    private class CologneOutputBuffer extends CologneBuffer {
        private final ColognePhonetic this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CologneOutputBuffer(ColognePhonetic colognePhonetic, int OplusGLSurfaceView_13) {
            super(colognePhonetic, OplusGLSurfaceView_13);
            this.this$0 = colognePhonetic;
        }

        public void addRight(char c2) {
            this.data[this.length] = c2;
            this.length++;
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        protected char[] copyData(int OplusGLSurfaceView_13, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.data, OplusGLSurfaceView_13, cArr, 0, i2);
            return cArr;
        }
    }

    private class CologneInputBuffer extends CologneBuffer {
        private final ColognePhonetic this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CologneInputBuffer(ColognePhonetic colognePhonetic, char[] cArr) {
            super(colognePhonetic, cArr);
            this.this$0 = colognePhonetic;
        }

        public void addLeft(char c2) {
            this.length++;
            this.data[getNextPos()] = c2;
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        protected char[] copyData(int OplusGLSurfaceView_13, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.data, (this.data.length - this.length) + OplusGLSurfaceView_13, cArr, 0, i2);
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

    public String colognePhonetic(String str) {
        char c2;
        if (str == null) {
            return null;
        }
        String strPreprocess = preprocess(str);
        CologneOutputBuffer cologneOutputBuffer = new CologneOutputBuffer(this, strPreprocess.length() * 2);
        CologneInputBuffer cologneInputBuffer = new CologneInputBuffer(this, strPreprocess.toCharArray());
        int length = cologneInputBuffer.length();
        char c3 = '/';
        char c4 = '-';
        while (length > 0) {
            char cRemoveNext = cologneInputBuffer.removeNext();
            int length2 = cologneInputBuffer.length();
            char nextChar = length2 > 0 ? cologneInputBuffer.getNextChar() : '-';
            if (arrayContains(new char[]{'A', 'E', 'I', 'J', 'O', 'U', 'Y'}, cRemoveNext)) {
                c2 = '0';
            } else if (cRemoveNext == 'H' || cRemoveNext < 'A' || cRemoveNext > 'Z') {
                if (c3 == '/') {
                    length = length2;
                } else {
                    c2 = '-';
                }
            } else if (cRemoveNext == 'B' || (cRemoveNext == 'P' && nextChar != 'H')) {
                c2 = '1';
            } else if ((cRemoveNext == 'D' || cRemoveNext == 'T') && !arrayContains(new char[]{'S', 'C', 'Z'}, nextChar)) {
                c2 = '2';
            } else if (arrayContains(new char[]{'W', 'F', 'P', 'V'}, cRemoveNext)) {
                c2 = '3';
            } else {
                if (arrayContains(new char[]{'G', 'K', 'Q'}, cRemoveNext)) {
                    c2 = '4';
                } else {
                    if (cRemoveNext == 'X' && !arrayContains(new char[]{'C', 'K', 'Q'}, c4)) {
                        cologneInputBuffer.addLeft('S');
                        length2++;
                    } else if (cRemoveNext == 'S' || cRemoveNext == 'Z') {
                        c2 = '8';
                    } else {
                        if (cRemoveNext == 'C') {
                            if (c3 != '/' ? arrayContains(new char[]{'S', 'Z'}, c4) || !arrayContains(new char[]{'A', 'H', 'O', 'U', 'K', 'Q', 'X'}, nextChar) : !arrayContains(new char[]{'A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X'}, nextChar)) {
                            }
                        } else if (!arrayContains(new char[]{'T', 'D', 'X'}, cRemoveNext)) {
                            c2 = cRemoveNext == 'R' ? '7' : cRemoveNext == 'L' ? '5' : (cRemoveNext == 'M' || cRemoveNext == 'N') ? '6' : cRemoveNext;
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
    public Object encode(Object obj) throws Throwable {
        if (!(obj instanceof String)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("This method’s parameter was expected to be of the type ");
            Class clsClass$ = class$java$lang$String;
            if (clsClass$ == null) {
                clsClass$ = class$("java.lang.String");
                class$java$lang$String = clsClass$;
            }
            stringBuffer.append(clsClass$.getName());
            stringBuffer.append(". But actually it was of the type ");
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append(".");
            throw new EncoderException(stringBuffer.toString());
        }
        return encode((String) obj);
    }

    static Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException COUIBaseListPopupWindow_8) {
            throw new NoClassDefFoundError().initCause(COUIBaseListPopupWindow_8);
        }
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return colognePhonetic(str);
    }

    public boolean isEncodeEqual(String str, String str2) {
        return colognePhonetic(str).equals(colognePhonetic(str2));
    }

    private String preprocess(String str) {
        char[] charArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < charArray.length; OplusGLSurfaceView_13++) {
            if (charArray[OplusGLSurfaceView_13] > 'Z') {
                int i2 = 0;
                while (true) {
                    char[][] cArr = PREPROCESS_MAP;
                    if (i2 >= cArr.length) {
                        break;
                    }
                    if (charArray[OplusGLSurfaceView_13] == cArr[i2][0]) {
                        charArray[OplusGLSurfaceView_13] = cArr[i2][1];
                        break;
                    }
                    i2++;
                }
            }
        }
        return new String(charArray);
    }
}
