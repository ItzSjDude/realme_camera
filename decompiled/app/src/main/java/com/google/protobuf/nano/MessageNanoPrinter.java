package com.google.protobuf.nano;

/* loaded from: classes.dex */
public final class MessageNanoPrinter {
    private static final java.lang.String INDENT = "  ";
    private static final int MAX_STRING_LEN = 200;

    private MessageNanoPrinter() {
    }

    public static <T_renamed extends com.google.protobuf.nano.MessageNano> java.lang.String print(T_renamed t_renamed) throws java.lang.SecurityException, java.lang.IllegalArgumentException {
        if (t_renamed == null) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        try {
            print(null, t_renamed, new java.lang.StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (java.lang.IllegalAccessException e_renamed) {
            java.lang.String strValueOf = java.lang.String.valueOf(e_renamed.getMessage());
            return strValueOf.length() != 0 ? "Error printing proto: ".concat(strValueOf) : new java.lang.String("Error printing proto: ");
        } catch (java.lang.reflect.InvocationTargetException e2) {
            java.lang.String strValueOf2 = java.lang.String.valueOf(e2.getMessage());
            return strValueOf2.length() != 0 ? "Error printing proto: ".concat(strValueOf2) : new java.lang.String("Error printing proto: ");
        }
    }

    private static void print(java.lang.String str, java.lang.Object obj, java.lang.StringBuffer stringBuffer, java.lang.StringBuffer stringBuffer2) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (obj == null) {
            return;
        }
        if (obj instanceof com.google.protobuf.nano.MessageNano) {
            int length = stringBuffer.length();
            if (str != null) {
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(deCamelCaseify(str));
                stringBuffer2.append(" <\n_renamed");
                stringBuffer.append(INDENT);
            }
            java.lang.Class<?> cls = obj.getClass();
            for (java.lang.reflect.Field field : cls.getFields()) {
                int modifiers = field.getModifiers();
                java.lang.String name = field.getName();
                if (!"cachedSize".equals(name) && (modifiers & 1) == 1 && (modifiers & 8) != 8 && !name.startsWith("_") && !name.endsWith("_")) {
                    java.lang.Class<?> type = field.getType();
                    java.lang.Object obj2 = field.get(obj);
                    if (type.isArray()) {
                        if (type.getComponentType() == java.lang.Byte.TYPE) {
                            print(name, obj2, stringBuffer, stringBuffer2);
                        } else {
                            int length2 = obj2 == null ? 0 : java.lang.reflect.Array.getLength(obj2);
                            for (int i_renamed = 0; i_renamed < length2; i_renamed++) {
                                print(name, java.lang.reflect.Array.get(obj2, i_renamed), stringBuffer, stringBuffer2);
                            }
                        }
                    } else {
                        print(name, obj2, stringBuffer, stringBuffer2);
                    }
                }
            }
            for (java.lang.reflect.Method method : cls.getMethods()) {
                java.lang.String name2 = method.getName();
                if (name2.startsWith("set")) {
                    java.lang.String strSubstring = name2.substring(3);
                    try {
                        java.lang.String strValueOf = java.lang.String.valueOf(strSubstring);
                        if (((java.lang.Boolean) cls.getMethod(strValueOf.length() != 0 ? "has".concat(strValueOf) : new java.lang.String("has"), new java.lang.Class[0]).invoke(obj, new java.lang.Object[0])).booleanValue()) {
                            java.lang.String strValueOf2 = java.lang.String.valueOf(strSubstring);
                            print(strSubstring, cls.getMethod(strValueOf2.length() != 0 ? "get".concat(strValueOf2) : new java.lang.String("get"), new java.lang.Class[0]).invoke(obj, new java.lang.Object[0]), stringBuffer, stringBuffer2);
                        }
                    } catch (java.lang.NoSuchMethodException unused) {
                    }
                }
            }
            if (str != null) {
                stringBuffer.setLength(length);
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(">\n_renamed");
                return;
            }
            return;
        }
        java.lang.String strDeCamelCaseify = deCamelCaseify(str);
        stringBuffer2.append(stringBuffer);
        stringBuffer2.append(strDeCamelCaseify);
        stringBuffer2.append(": ");
        if (obj instanceof java.lang.String) {
            java.lang.String strSanitizeString = sanitizeString((java.lang.String) obj);
            stringBuffer2.append("\"");
            stringBuffer2.append(strSanitizeString);
            stringBuffer2.append("\"");
        } else if (obj instanceof byte[]) {
            appendQuotedBytes((byte[]) obj, stringBuffer2);
        } else {
            stringBuffer2.append(obj);
        }
        stringBuffer2.append("\n_renamed");
    }

    private static java.lang.String deCamelCaseify(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            char cCharAt = str.charAt(i_renamed);
            if (i_renamed == 0) {
                stringBuffer.append(java.lang.Character.toLowerCase(cCharAt));
            } else if (java.lang.Character.isUpperCase(cCharAt)) {
                stringBuffer.append('_');
                stringBuffer.append(java.lang.Character.toLowerCase(cCharAt));
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        return stringBuffer.toString();
    }

    private static java.lang.String sanitizeString(java.lang.String str) {
        if (!str.startsWith("http") && str.length() > 200) {
            str = java.lang.String.valueOf(str.substring(0, 200)).concat("[...]");
        }
        return escapeString(str);
    }

    private static java.lang.String escapeString(java.lang.String str) {
        int length = str.length();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length);
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            char cCharAt = str.charAt(i_renamed);
            if (cCharAt < ' ' || cCharAt > '~' || cCharAt == '\"' || cCharAt == '\'') {
                sb.append(java.lang.String.format("\\u_renamed%04x", java.lang.Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private static void appendQuotedBytes(byte[] bArr, java.lang.StringBuffer stringBuffer) {
        if (bArr == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append('\"');
        for (byte b2 : bArr) {
            int i_renamed = b2 & 255;
            if (i_renamed == 92 || i_renamed == 34) {
                stringBuffer.append('\\');
                stringBuffer.append((char) i_renamed);
            } else if (i_renamed < 32 || i_renamed >= 127) {
                stringBuffer.append(java.lang.String.format("\\%03o", java.lang.Integer.valueOf(i_renamed)));
            } else {
                stringBuffer.append((char) i_renamed);
            }
        }
        stringBuffer.append('\"');
    }
}
