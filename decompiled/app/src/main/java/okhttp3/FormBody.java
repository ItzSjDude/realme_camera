package okhttp3;

/* loaded from: classes2.dex */
public final class FormBody extends okhttp3.RequestBody {
    private static final okhttp3.MediaType CONTENT_TYPE = okhttp3.MediaType.get("application/x_renamed-www-form-urlencoded");
    private final java.util.List<java.lang.String> encodedNames;
    private final java.util.List<java.lang.String> encodedValues;

    FormBody(java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2) {
        this.encodedNames = okhttp3.internal.Util.immutableList(list);
        this.encodedValues = okhttp3.internal.Util.immutableList(list2);
    }

    public int size() {
        return this.encodedNames.size();
    }

    public java.lang.String encodedName(int i_renamed) {
        return this.encodedNames.get(i_renamed);
    }

    public java.lang.String name(int i_renamed) {
        return okhttp3.HttpUrl.percentDecode(encodedName(i_renamed), true);
    }

    public java.lang.String encodedValue(int i_renamed) {
        return this.encodedValues.get(i_renamed);
    }

    public java.lang.String value(int i_renamed) {
        return okhttp3.HttpUrl.percentDecode(encodedValue(i_renamed), true);
    }

    @Override // okhttp3.RequestBody
    public okhttp3.MediaType contentType() {
        return CONTENT_TYPE;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(okio.BufferedSink bufferedSink) throws java.io.IOException {
        writeOrCountBytes(bufferedSink, false);
    }

    private long writeOrCountBytes(@javax.annotation.Nullable okio.BufferedSink bufferedSink, boolean z_renamed) {
        okio.Buffer buffer;
        if (z_renamed) {
            buffer = new okio.Buffer();
        } else {
            buffer = bufferedSink.buffer();
        }
        int size = this.encodedNames.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            if (i_renamed > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.encodedNames.get(i_renamed));
            buffer.writeByte(61);
            buffer.writeUtf8(this.encodedValues.get(i_renamed));
        }
        if (!z_renamed) {
            return 0L;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    public static final class Builder {
        private final java.nio.charset.Charset charset;
        private final java.util.List<java.lang.String> names;
        private final java.util.List<java.lang.String> values;

        public Builder() {
            this(null);
        }

        public Builder(java.nio.charset.Charset charset) {
            this.names = new java.util.ArrayList();
            this.values = new java.util.ArrayList();
            this.charset = charset;
        }

        public okhttp3.FormBody.Builder add(java.lang.String str, java.lang.String str2) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new java.lang.NullPointerException("value == null");
            }
            this.names.add(okhttp3.HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
            this.values.add(okhttp3.HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
            return this;
        }

        public okhttp3.FormBody.Builder addEncoded(java.lang.String str, java.lang.String str2) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new java.lang.NullPointerException("value == null");
            }
            this.names.add(okhttp3.HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
            this.values.add(okhttp3.HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
            return this;
        }

        public okhttp3.FormBody build() {
            return new okhttp3.FormBody(this.names, this.values);
        }
    }
}
