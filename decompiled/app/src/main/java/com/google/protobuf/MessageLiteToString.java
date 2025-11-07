package com.google.protobuf;

/* loaded from: classes.dex */
final class MessageLiteToString {
    private static final java.lang.String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final java.lang.String BYTES_SUFFIX = "Bytes";
    private static final java.lang.String LIST_SUFFIX = "List";
    private static final java.lang.String MAP_SUFFIX = "Map";

    MessageLiteToString() {
    }

    static java.lang.String toString(com.google.protobuf.MessageLite messageLite, java.lang.String str) throws java.lang.SecurityException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("# ");
        sb.append(str);
        reflectivePrintWithIndent(messageLite, sb, 0);
        return sb.toString();
    }

    private static void reflectivePrintWithIndent(com.google.protobuf.MessageLite messageLite, java.lang.StringBuilder sb, int i_renamed) throws java.lang.SecurityException {
        boolean zBooleanValue;
        java.util.HashMap map = new java.util.HashMap();
        java.util.HashMap map2 = new java.util.HashMap();
        java.util.TreeSet<java.lang.String> treeSet = new java.util.TreeSet();
        for (java.lang.reflect.Method method : messageLite.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (java.lang.String str : treeSet) {
            java.lang.String strReplaceFirst = str.replaceFirst("get", "");
            if (strReplaceFirst.endsWith(LIST_SUFFIX) && !strReplaceFirst.endsWith(BUILDER_LIST_SUFFIX) && !strReplaceFirst.equals(LIST_SUFFIX)) {
                java.lang.String str2 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1, strReplaceFirst.length() - 4);
                java.lang.reflect.Method method2 = (java.lang.reflect.Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(java.util.List.class)) {
                    printField(sb, i_renamed, camelCaseToSnakeCase(str2), com.google.protobuf.GeneratedMessageLite.invokeOrDie(method2, messageLite, new java.lang.Object[0]));
                }
            }
            if (strReplaceFirst.endsWith(MAP_SUFFIX) && !strReplaceFirst.equals(MAP_SUFFIX)) {
                java.lang.String str3 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1, strReplaceFirst.length() - 3);
                java.lang.reflect.Method method3 = (java.lang.reflect.Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(java.util.Map.class) && !method3.isAnnotationPresent(java.lang.Deprecated.class) && java.lang.reflect.Modifier.isPublic(method3.getModifiers())) {
                    printField(sb, i_renamed, camelCaseToSnakeCase(str3), com.google.protobuf.GeneratedMessageLite.invokeOrDie(method3, messageLite, new java.lang.Object[0]));
                }
            }
            if (((java.lang.reflect.Method) map2.get("set" + strReplaceFirst)) != null) {
                if (strReplaceFirst.endsWith(BYTES_SUFFIX)) {
                    if (map.containsKey("get" + strReplaceFirst.substring(0, strReplaceFirst.length() - 5))) {
                    }
                }
                java.lang.String str4 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1);
                java.lang.reflect.Method method4 = (java.lang.reflect.Method) map.get("get" + strReplaceFirst);
                java.lang.reflect.Method method5 = (java.lang.reflect.Method) map.get("has" + strReplaceFirst);
                if (method4 != null) {
                    java.lang.Object objInvokeOrDie = com.google.protobuf.GeneratedMessageLite.invokeOrDie(method4, messageLite, new java.lang.Object[0]);
                    if (method5 == null) {
                        zBooleanValue = !isDefaultValue(objInvokeOrDie);
                    } else {
                        zBooleanValue = ((java.lang.Boolean) com.google.protobuf.GeneratedMessageLite.invokeOrDie(method5, messageLite, new java.lang.Object[0])).booleanValue();
                    }
                    if (zBooleanValue) {
                        printField(sb, i_renamed, camelCaseToSnakeCase(str4), objInvokeOrDie);
                    }
                }
            }
        }
        if (messageLite instanceof com.google.protobuf.GeneratedMessageLite.ExtendableMessage) {
            java.util.Iterator<java.util.Map.Entry<T_renamed, java.lang.Object>> it = ((com.google.protobuf.GeneratedMessageLite.ExtendableMessage) messageLite).extensions.iterator();
            while (it.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
                printField(sb, i_renamed, "[" + ((com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor) entry.getKey()).getNumber() + "]", entry.getValue());
            }
        }
        com.google.protobuf.GeneratedMessageLite generatedMessageLite = (com.google.protobuf.GeneratedMessageLite) messageLite;
        if (generatedMessageLite.unknownFields != null) {
            generatedMessageLite.unknownFields.printWithIndent(sb, i_renamed);
        }
    }

    private static boolean isDefaultValue(java.lang.Object obj) {
        if (obj instanceof java.lang.Boolean) {
            return !((java.lang.Boolean) obj).booleanValue();
        }
        if (obj instanceof java.lang.Integer) {
            return ((java.lang.Integer) obj).intValue() == 0;
        }
        if (obj instanceof java.lang.Float) {
            return ((java.lang.Float) obj).floatValue() == 0.0f;
        }
        if (obj instanceof java.lang.Double) {
            return ((java.lang.Double) obj).doubleValue() == 0.0d;
        }
        if (obj instanceof java.lang.String) {
            return obj.equals("");
        }
        if (obj instanceof com.google.protobuf.ByteString) {
            return obj.equals(com.google.protobuf.ByteString.EMPTY);
        }
        return obj instanceof com.google.protobuf.MessageLite ? obj == ((com.google.protobuf.MessageLite) obj).getDefaultInstanceForType() : (obj instanceof java.lang.Enum) && ((java.lang.Enum) obj).ordinal() == 0;
    }

    static final void printField(java.lang.StringBuilder sb, int i_renamed, java.lang.String str, java.lang.Object obj) throws java.lang.SecurityException {
        if (obj instanceof java.util.List) {
            java.util.Iterator it = ((java.util.List) obj).iterator();
            while (it.hasNext()) {
                printField(sb, i_renamed, str, it.next());
            }
            return;
        }
        if (obj instanceof java.util.Map) {
            java.util.Iterator it2 = ((java.util.Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                printField(sb, i_renamed, str, (java.util.Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n_renamed');
        int i2 = 0;
        for (int i3 = 0; i3 < i_renamed; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof java.lang.String) {
            sb.append(": \"");
            sb.append(com.google.protobuf.TextFormatEscaper.escapeText((java.lang.String) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof com.google.protobuf.ByteString) {
            sb.append(": \"");
            sb.append(com.google.protobuf.TextFormatEscaper.escapeBytes((com.google.protobuf.ByteString) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof com.google.protobuf.GeneratedMessageLite) {
            sb.append(" {");
            reflectivePrintWithIndent((com.google.protobuf.GeneratedMessageLite) obj, sb, i_renamed + 2);
            sb.append("\n_renamed");
            while (i2 < i_renamed) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (obj instanceof java.util.Map.Entry) {
            sb.append(" {");
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            int i4 = i_renamed + 2;
            printField(sb, i4, "key", entry.getKey());
            printField(sb, i4, com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE, entry.getValue());
            sb.append("\n_renamed");
            while (i2 < i_renamed) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj.toString());
    }

    private static final java.lang.String camelCaseToSnakeCase(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            char cCharAt = str.charAt(i_renamed);
            if (java.lang.Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(java.lang.Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }
}
