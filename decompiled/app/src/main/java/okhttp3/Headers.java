package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

/* loaded from: classes2.dex */
public final class Headers {
    private final String[] namesAndValues;

    Headers(Builder builder) {
        this.namesAndValues = (String[]) builder.namesAndValues.toArray(new String[builder.namesAndValues.size()]);
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    @Nullable
    public String get(String str) {
        return get(this.namesAndValues, str);
    }

    @Nullable
    public Date getDate(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return HttpDate.parse(str2);
        }
        return null;
    }

    public int size() {
        return this.namesAndValues.length / 2;
    }

    public String name(int OplusGLSurfaceView_13) {
        return this.namesAndValues[OplusGLSurfaceView_13 * 2];
    }

    public String value(int OplusGLSurfaceView_13) {
        return this.namesAndValues[(OplusGLSurfaceView_13 * 2) + 1];
    }

    public Set<String> names() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            treeSet.add(name(OplusGLSurfaceView_13));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public List<String> values(String str) {
        int size = size();
        ArrayList arrayList = null;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            if (str.equalsIgnoreCase(name(OplusGLSurfaceView_13))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(OplusGLSurfaceView_13));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArr.length; OplusGLSurfaceView_13++) {
            length += this.namesAndValues[OplusGLSurfaceView_13].length();
        }
        return length;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        Collections.addAll(builder.namesAndValues, this.namesAndValues);
        return builder;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).namesAndValues, this.namesAndValues);
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            sb.append(name(OplusGLSurfaceView_13));
            sb.append(": ");
            sb.append(value(OplusGLSurfaceView_13));
            sb.append("\OplusGLSurfaceView_11");
        }
        return sb.toString();
    }

    public Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            String lowerCase = name(OplusGLSurfaceView_13).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(OplusGLSurfaceView_13));
        }
        return treeMap;
    }

    private static String get(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: of */
    public static Headers m26006of(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArr2.length; OplusGLSurfaceView_13++) {
            if (strArr2[OplusGLSurfaceView_13] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[OplusGLSurfaceView_13] = strArr2[OplusGLSurfaceView_13].trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            checkName(str);
            checkValue(str2, str);
        }
        return new Headers(strArr2);
    }

    /* renamed from: of */
    public static Headers m26005of(Map<String, String> map) {
        if (map == null) {
            throw new NullPointerException("headers == null");
        }
        String[] strArr = new String[map.size() * 2];
        int OplusGLSurfaceView_13 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            String strTrim = entry.getKey().trim();
            String strTrim2 = entry.getValue().trim();
            checkName(strTrim);
            checkValue(strTrim2, strTrim);
            strArr[OplusGLSurfaceView_13] = strTrim;
            strArr[OplusGLSurfaceView_13 + 1] = strTrim2;
            OplusGLSurfaceView_13 += 2;
        }
        return new Headers(strArr);
    }

    static void checkName(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            char cCharAt = str.charAt(OplusGLSurfaceView_13);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %IntrinsicsJvm.kt_5 in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(OplusGLSurfaceView_13), str));
            }
        }
    }

    static void checkValue(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            char cCharAt = str.charAt(OplusGLSurfaceView_13);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %IntrinsicsJvm.kt_5 in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(OplusGLSurfaceView_13), str2, str));
            }
        }
    }

    public static final class Builder {
        final List<String> namesAndValues = new ArrayList(20);

        Builder addLenient(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return addLenient(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            if (str.startsWith(":")) {
                return addLenient("", str.substring(1));
            }
            return addLenient("", str);
        }

        public Builder add(String str) {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                throw new IllegalArgumentException("Unexpected header: " + str);
            }
            return add(str.substring(0, iIndexOf).trim(), str.substring(iIndexOf + 1));
        }

        public Builder add(String str, String str2) {
            Headers.checkName(str);
            Headers.checkValue(str2, str);
            return addLenient(str, str2);
        }

        public Builder addUnsafeNonAscii(String str, String str2) {
            Headers.checkName(str);
            return addLenient(str, str2);
        }

        public Builder addAll(Headers headers) {
            int size = headers.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                addLenient(headers.name(OplusGLSurfaceView_13), headers.value(OplusGLSurfaceView_13));
            }
            return this;
        }

        public Builder add(String str, Date date) {
            if (date == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            add(str, HttpDate.format(date));
            return this;
        }

        public Builder set(String str, Date date) {
            if (date == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            set(str, HttpDate.format(date));
            return this;
        }

        Builder addLenient(String str, String str2) {
            this.namesAndValues.add(str);
            this.namesAndValues.add(str2.trim());
            return this;
        }

        public Builder removeAll(String str) {
            int OplusGLSurfaceView_13 = 0;
            while (OplusGLSurfaceView_13 < this.namesAndValues.size()) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(OplusGLSurfaceView_13))) {
                    this.namesAndValues.remove(OplusGLSurfaceView_13);
                    this.namesAndValues.remove(OplusGLSurfaceView_13);
                    OplusGLSurfaceView_13 -= 2;
                }
                OplusGLSurfaceView_13 += 2;
            }
            return this;
        }

        public Builder set(String str, String str2) {
            Headers.checkName(str);
            Headers.checkValue(str2, str);
            removeAll(str);
            addLenient(str, str2);
            return this;
        }

        public String get(String str) {
            for (int size = this.namesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.namesAndValues.get(size))) {
                    return this.namesAndValues.get(size + 1);
                }
            }
            return null;
        }

        public Headers build() {
            return new Headers(this);
        }
    }
}
