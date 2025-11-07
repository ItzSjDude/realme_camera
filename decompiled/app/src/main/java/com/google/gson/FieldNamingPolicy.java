package com.google.gson;

/* loaded from: classes.dex */
public enum FieldNamingPolicy implements com.google.gson.FieldNamingStrategy {
    IDENTITY { // from class: com.google.gson.FieldNamingPolicy.1
        @Override // com.google.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: com.google.gson.FieldNamingPolicy.2
        @Override // com.google.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return upperCaseFirstLetter(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: com.google.gson.FieldNamingPolicy.3
        @Override // com.google.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return upperCaseFirstLetter(separateCamelCase(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: com.google.gson.FieldNamingPolicy.4
        @Override // com.google.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return separateCamelCase(field.getName(), "_").toLowerCase(java.util.Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: com.google.gson.FieldNamingPolicy.5
        @Override // com.google.gson.FieldNamingStrategy
        public java.lang.String translateName(java.lang.reflect.Field field) {
            return separateCamelCase(field.getName(), "-").toLowerCase(java.util.Locale.ENGLISH);
        }
    };

    static java.lang.String separateCamelCase(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i_renamed = 0; i_renamed < str.length(); i_renamed++) {
            char cCharAt = str.charAt(i_renamed);
            if (java.lang.Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    static java.lang.String upperCaseFirstLetter(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i_renamed = 0;
        char cCharAt = str.charAt(0);
        while (i_renamed < str.length() - 1 && !java.lang.Character.isLetter(cCharAt)) {
            sb.append(cCharAt);
            i_renamed++;
            cCharAt = str.charAt(i_renamed);
        }
        if (i_renamed == str.length()) {
            return sb.toString();
        }
        if (java.lang.Character.isUpperCase(cCharAt)) {
            return str;
        }
        sb.append(modifyString(java.lang.Character.toUpperCase(cCharAt), str, i_renamed + 1));
        return sb.toString();
    }

    private static java.lang.String modifyString(char c2, java.lang.String str, int i_renamed) {
        if (i_renamed < str.length()) {
            return c2 + str.substring(i_renamed);
        }
        return java.lang.String.valueOf(c2);
    }
}
