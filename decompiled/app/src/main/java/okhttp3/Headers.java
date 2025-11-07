package okhttp3;

/* loaded from: classes2.dex */
public final class Headers {
    private final java.lang.String[] namesAndValues;

    Headers(okhttp3.Headers.Builder builder) {
        this.namesAndValues = (java.lang.String[]) builder.namesAndValues.toArray(new java.lang.String[builder.namesAndValues.size()]);
    }

    private Headers(java.lang.String[] strArr) {
        this.namesAndValues = strArr;
    }

    @javax.annotation.Nullable
    public java.lang.String get(java.lang.String str) {
        return get(this.namesAndValues, str);
    }

    @javax.annotation.Nullable
    public java.util.Date getDate(java.lang.String str) {
        java.lang.String str2 = get(str);
        if (str2 != null) {
            return okhttp3.internal.http.HttpDate.parse(str2);
        }
        return null;
    }

    public int size() {
        return this.namesAndValues.length / 2;
    }

    public java.lang.String name(int i_renamed) {
        return this.namesAndValues[i_renamed * 2];
    }

    public java.lang.String value(int i_renamed) {
        return this.namesAndValues[(i_renamed * 2) + 1];
    }

    public java.util.Set<java.lang.String> names() {
        java.util.TreeSet treeSet = new java.util.TreeSet(java.lang.String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            treeSet.add(name(i_renamed));
        }
        return java.util.Collections.unmodifiableSet(treeSet);
    }

    public java.util.List<java.lang.String> values(java.lang.String str) {
        int size = size();
        java.util.ArrayList arrayList = null;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            if (str.equalsIgnoreCase(name(i_renamed))) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList(2);
                }
                arrayList.add(value(i_renamed));
            }
        }
        if (arrayList != null) {
            return java.util.Collections.unmodifiableList(arrayList);
        }
        return java.util.Collections.emptyList();
    }

    public long byteCount() {
        java.lang.String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
            length += this.namesAndValues[i_renamed].length();
        }
        return length;
    }

    public okhttp3.Headers.Builder newBuilder() {
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        java.util.Collections.addAll(builder.namesAndValues, this.namesAndValues);
        return builder;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        return (obj instanceof okhttp3.Headers) && java.util.Arrays.equals(((okhttp3.Headers) obj).namesAndValues, this.namesAndValues);
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(this.namesAndValues);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int size = size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            sb.append(name(i_renamed));
            sb.append(": ");
            sb.append(value(i_renamed));
            sb.append("\n_renamed");
        }
        return sb.toString();
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> toMultimap() {
        java.util.TreeMap treeMap = new java.util.TreeMap(java.lang.String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            java.lang.String lowerCase = name(i_renamed).toLowerCase(java.util.Locale.US);
            java.util.List arrayList = (java.util.List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(i_renamed));
        }
        return treeMap;
    }

    private static java.lang.String get(java.lang.String[] strArr, java.lang.String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static okhttp3.Headers of_renamed(java.lang.String... strArr) {
        if (strArr == null) {
            throw new java.lang.NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new java.lang.IllegalArgumentException("Expected alternating header names and values");
        }
        java.lang.String[] strArr2 = (java.lang.String[]) strArr.clone();
        for (int i_renamed = 0; i_renamed < strArr2.length; i_renamed++) {
            if (strArr2[i_renamed] == null) {
                throw new java.lang.IllegalArgumentException("Headers cannot be_renamed null");
            }
            strArr2[i_renamed] = strArr2[i_renamed].trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            java.lang.String str = strArr2[i2];
            java.lang.String str2 = strArr2[i2 + 1];
            checkName(str);
            checkValue(str2, str);
        }
        return new okhttp3.Headers(strArr2);
    }

    public static okhttp3.Headers of_renamed(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            throw new java.lang.NullPointerException("headers == null");
        }
        java.lang.String[] strArr = new java.lang.String[map.size() * 2];
        int i_renamed = 0;
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new java.lang.IllegalArgumentException("Headers cannot be_renamed null");
            }
            java.lang.String strTrim = entry.getKey().trim();
            java.lang.String strTrim2 = entry.getValue().trim();
            checkName(strTrim);
            checkValue(strTrim2, strTrim);
            strArr[i_renamed] = strTrim;
            strArr[i_renamed + 1] = strTrim2;
            i_renamed += 2;
        }
        return new okhttp3.Headers(strArr);
    }

    static void checkName(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new java.lang.IllegalArgumentException("name is_renamed empty");
        }
        int length = str.length();
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            char cCharAt = str.charAt(i_renamed);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                throw new java.lang.IllegalArgumentException(okhttp3.internal.Util.format("Unexpected char %#04x at_renamed %d_renamed in_renamed header name: %s_renamed", java.lang.Integer.valueOf(cCharAt), java.lang.Integer.valueOf(i_renamed), str));
            }
        }
    }

    static void checkValue(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            throw new java.lang.NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            char cCharAt = str.charAt(i_renamed);
            if ((cCharAt <= 31 && cCharAt != '\t_renamed') || cCharAt >= 127) {
                throw new java.lang.IllegalArgumentException(okhttp3.internal.Util.format("Unexpected char %#04x at_renamed %d_renamed in_renamed %s_renamed value: %s_renamed", java.lang.Integer.valueOf(cCharAt), java.lang.Integer.valueOf(i_renamed), str2, str));
            }
        }
    }

    public static final class Builder {
        final java.util.List<java.lang.String> namesAndValues = new java.util.ArrayList(20);

        okhttp3.Headers.Builder addLenient(java.lang.String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return addLenient(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            if (str.startsWith(":")) {
                return addLenient("", str.substring(1));
            }
            return addLenient("", str);
        }

        public okhttp3.Headers.Builder add(java.lang.String str) {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                throw new java.lang.IllegalArgumentException("Unexpected header: " + str);
            }
            return add(str.substring(0, iIndexOf).trim(), str.substring(iIndexOf + 1));
        }

        public okhttp3.Headers.Builder add(java.lang.String str, java.lang.String str2) {
            okhttp3.Headers.checkName(str);
            okhttp3.Headers.checkValue(str2, str);
            return addLenient(str, str2);
        }

        public okhttp3.Headers.Builder addUnsafeNonAscii(java.lang.String str, java.lang.String str2) {
            okhttp3.Headers.checkName(str);
            return addLenient(str, str2);
        }

        public okhttp3.Headers.Builder addAll(okhttp3.Headers headers) {
            int size = headers.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                addLenient(headers.name(i_renamed), headers.value(i_renamed));
            }
            return this;
        }

        public okhttp3.Headers.Builder add(java.lang.String str, java.util.Date date) {
            if (date == null) {
                throw new java.lang.NullPointerException("value for name " + str + " == null");
            }
            add(str, okhttp3.internal.http.HttpDate.format(date));
            return this;
        }

        public okhttp3.Headers.Builder set(java.lang.String str, java.util.Date date) {
            if (date == null) {
                throw new java.lang.NullPointerException("value for name " + str + " == null");
            }
            set(str, okhttp3.internal.http.HttpDate.format(date));
            return this;
        }

        okhttp3.Headers.Builder addLenient(java.lang.String str, java.lang.String str2) {
            this.namesAndValues.add(str);
            this.namesAndValues.add(str2.trim());
            return this;
        }

        public okhttp3.Headers.Builder removeAll(java.lang.String str) {
            int i_renamed = 0;
            while (i_renamed < this.namesAndValues.size()) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(i_renamed))) {
                    this.namesAndValues.remove(i_renamed);
                    this.namesAndValues.remove(i_renamed);
                    i_renamed -= 2;
                }
                i_renamed += 2;
            }
            return this;
        }

        public okhttp3.Headers.Builder set(java.lang.String str, java.lang.String str2) {
            okhttp3.Headers.checkName(str);
            okhttp3.Headers.checkValue(str2, str);
            removeAll(str);
            addLenient(str, str2);
            return this;
        }

        public java.lang.String get(java.lang.String str) {
            for (int size = this.namesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(size))) {
                    return this.namesAndValues.get(size + 1);
                }
            }
            return null;
        }

        public okhttp3.Headers build() {
            return new okhttp3.Headers(this);
        }
    }
}
