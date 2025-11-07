package okhttp3.internal.http2;

/* loaded from: classes2.dex */
final class Hpack {
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final okhttp3.internal.http2.Header[] STATIC_HEADER_TABLE = {new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_AUTHORITY, ""), new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_METHOD, "GET"), new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_METHOD, "POST"), new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_PATH, "/"), new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_PATH, "/index.html"), new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_SCHEME, "http"), new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_SCHEME, "https"), new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.RESPONSE_STATUS, com.oplus.camera.statistics.model.DcsMsgData.LOGTAG_CAPTURE), new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.RESPONSE_STATUS, "204"), new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.RESPONSE_STATUS, "206"), new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.RESPONSE_STATUS, "304"), new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.RESPONSE_STATUS, "400"), new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.RESPONSE_STATUS, "404"), new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.RESPONSE_STATUS, "500"), new okhttp3.internal.http2.Header("accept-charset", ""), new okhttp3.internal.http2.Header("accept-encoding", "gzip, deflate"), new okhttp3.internal.http2.Header("accept-language", ""), new okhttp3.internal.http2.Header("accept-ranges", ""), new okhttp3.internal.http2.Header("accept", ""), new okhttp3.internal.http2.Header("access-control-allow-origin", ""), new okhttp3.internal.http2.Header("age", ""), new okhttp3.internal.http2.Header("allow", ""), new okhttp3.internal.http2.Header("authorization", ""), new okhttp3.internal.http2.Header("cache-control", ""), new okhttp3.internal.http2.Header("content-disposition", ""), new okhttp3.internal.http2.Header("content-encoding", ""), new okhttp3.internal.http2.Header("content-language", ""), new okhttp3.internal.http2.Header("content-length", ""), new okhttp3.internal.http2.Header("content-location", ""), new okhttp3.internal.http2.Header("content-range", ""), new okhttp3.internal.http2.Header("content-type", ""), new okhttp3.internal.http2.Header("cookie", ""), new okhttp3.internal.http2.Header(com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, ""), new okhttp3.internal.http2.Header("etag", ""), new okhttp3.internal.http2.Header("expect", ""), new okhttp3.internal.http2.Header("expires", ""), new okhttp3.internal.http2.Header("from", ""), new okhttp3.internal.http2.Header("host", ""), new okhttp3.internal.http2.Header("if-match", ""), new okhttp3.internal.http2.Header("if-modified-since", ""), new okhttp3.internal.http2.Header("if-none-match", ""), new okhttp3.internal.http2.Header("if-range", ""), new okhttp3.internal.http2.Header("if-unmodified-since", ""), new okhttp3.internal.http2.Header("last-modified", ""), new okhttp3.internal.http2.Header("link", ""), new okhttp3.internal.http2.Header(com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_LOCATION, ""), new okhttp3.internal.http2.Header("max-forwards", ""), new okhttp3.internal.http2.Header("proxy-authenticate", ""), new okhttp3.internal.http2.Header("proxy-authorization", ""), new okhttp3.internal.http2.Header("range", ""), new okhttp3.internal.http2.Header(com.android.providers.downloads.Downloads.Impl.COLUMN_REFERER, ""), new okhttp3.internal.http2.Header("refresh", ""), new okhttp3.internal.http2.Header("retry-after", ""), new okhttp3.internal.http2.Header("server", ""), new okhttp3.internal.http2.Header("set-cookie", ""), new okhttp3.internal.http2.Header("strict-transport-security", ""), new okhttp3.internal.http2.Header("transfer-encoding", ""), new okhttp3.internal.http2.Header("user-agent", ""), new okhttp3.internal.http2.Header("vary", ""), new okhttp3.internal.http2.Header("via", ""), new okhttp3.internal.http2.Header("www-authenticate", "")};
    static final java.util.Map<okio.ByteString, java.lang.Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();

    private Hpack() {
    }

    static final class Reader {
        okhttp3.internal.http2.Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final java.util.List<okhttp3.internal.http2.Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final okio.BufferedSource source;

        Reader(int i_renamed, okio.Source source) {
            this(i_renamed, i_renamed, source);
        }

        Reader(int i_renamed, int i2, okio.Source source) {
            this.headerList = new java.util.ArrayList();
            this.dynamicTable = new okhttp3.internal.http2.Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i_renamed;
            this.maxDynamicTableByteCount = i2;
            this.source = okio.Okio.buffer(source);
        }

        int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        private void adjustDynamicTableByteCount() {
            int i_renamed = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i_renamed < i2) {
                if (i_renamed == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - i_renamed);
                }
            }
        }

        private void clearDynamicTable() {
            java.util.Arrays.fill(this.dynamicTable, (java.lang.Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i_renamed) {
            int i2 = 0;
            if (i_renamed > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i_renamed <= 0) {
                        break;
                    }
                    i_renamed -= this.dynamicTable[length].hpackSize;
                    this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                    this.headerCount--;
                    i2++;
                }
                okhttp3.internal.http2.Header[] headerArr = this.dynamicTable;
                int i3 = this.nextHeaderIndex;
                java.lang.System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i2, this.headerCount);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        void readHeaders() throws java.io.IOException {
            while (!this.source.exhausted()) {
                int i_renamed = this.source.readByte() & 255;
                if (i_renamed == 128) {
                    throw new java.io.IOException("index == 0");
                }
                if ((i_renamed & 128) == 128) {
                    readIndexedHeader(readInt(i_renamed, 127) - 1);
                } else if (i_renamed == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((i_renamed & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i_renamed, 63) - 1);
                } else if ((i_renamed & 32) == 32) {
                    this.maxDynamicTableByteCount = readInt(i_renamed, 31);
                    int i2 = this.maxDynamicTableByteCount;
                    if (i2 < 0 || i2 > this.headerTableSizeSetting) {
                        throw new java.io.IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (i_renamed == 16 || i_renamed == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(i_renamed, 15) - 1);
                }
            }
        }

        public java.util.List<okhttp3.internal.http2.Header> getAndResetHeaderList() {
            java.util.ArrayList arrayList = new java.util.ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        private void readIndexedHeader(int i_renamed) throws java.io.IOException {
            if (isStaticHeader(i_renamed)) {
                this.headerList.add(okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE[i_renamed]);
                return;
            }
            int iDynamicTableIndex = dynamicTableIndex(i_renamed - okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                okhttp3.internal.http2.Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[iDynamicTableIndex]);
                    return;
                }
            }
            throw new java.io.IOException("Header index too large " + (i_renamed + 1));
        }

        private int dynamicTableIndex(int i_renamed) {
            return this.nextHeaderIndex + 1 + i_renamed;
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i_renamed) throws java.io.IOException {
            this.headerList.add(new okhttp3.internal.http2.Header(getName(i_renamed), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws java.io.IOException {
            this.headerList.add(new okhttp3.internal.http2.Header(okhttp3.internal.http2.Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i_renamed) throws java.io.IOException {
            insertIntoDynamicTable(-1, new okhttp3.internal.http2.Header(getName(i_renamed), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws java.io.IOException {
            insertIntoDynamicTable(-1, new okhttp3.internal.http2.Header(okhttp3.internal.http2.Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private okio.ByteString getName(int i_renamed) throws java.io.IOException {
            if (isStaticHeader(i_renamed)) {
                return okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE[i_renamed].name;
            }
            int iDynamicTableIndex = dynamicTableIndex(i_renamed - okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                okhttp3.internal.http2.Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    return headerArr[iDynamicTableIndex].name;
                }
            }
            throw new java.io.IOException("Header index too large " + (i_renamed + 1));
        }

        private boolean isStaticHeader(int i_renamed) {
            return i_renamed >= 0 && i_renamed <= okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private void insertIntoDynamicTable(int i_renamed, okhttp3.internal.http2.Header header) {
            this.headerList.add(header);
            int i2 = header.hpackSize;
            if (i_renamed != -1) {
                i2 -= this.dynamicTable[dynamicTableIndex(i_renamed)].hpackSize;
            }
            int i3 = this.maxDynamicTableByteCount;
            if (i2 > i3) {
                clearDynamicTable();
                return;
            }
            int iEvictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i2) - i3);
            if (i_renamed == -1) {
                int i4 = this.headerCount + 1;
                okhttp3.internal.http2.Header[] headerArr = this.dynamicTable;
                if (i4 > headerArr.length) {
                    okhttp3.internal.http2.Header[] headerArr2 = new okhttp3.internal.http2.Header[headerArr.length * 2];
                    java.lang.System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i5 = this.nextHeaderIndex;
                this.nextHeaderIndex = i5 - 1;
                this.dynamicTable[i5] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i_renamed + dynamicTableIndex(i_renamed) + iEvictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i2;
        }

        private int readByte() throws java.io.IOException {
            return this.source.readByte() & 255;
        }

        int readInt(int i_renamed, int i2) throws java.io.IOException {
            int i3 = i_renamed & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = readByte();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }

        okio.ByteString readByteString() throws java.io.IOException {
            int i_renamed = readByte();
            boolean z_renamed = (i_renamed & 128) == 128;
            int i2 = readInt(i_renamed, 127);
            if (z_renamed) {
                return okio.ByteString.of_renamed(okhttp3.internal.http2.Huffman.get().decode(this.source.readByteArray(i2)));
            }
            return this.source.readByteString(i2);
        }
    }

    private static java.util.Map<okio.ByteString, java.lang.Integer> nameToFirstIndex() {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i_renamed = 0;
        while (true) {
            okhttp3.internal.http2.Header[] headerArr = STATIC_HEADER_TABLE;
            if (i_renamed < headerArr.length) {
                if (!linkedHashMap.containsKey(headerArr[i_renamed].name)) {
                    linkedHashMap.put(STATIC_HEADER_TABLE[i_renamed].name, java.lang.Integer.valueOf(i_renamed));
                }
                i_renamed++;
            } else {
                return java.util.Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        okhttp3.internal.http2.Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final okio.Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        Writer(okio.Buffer buffer) {
            this(4096, true, buffer);
        }

        Writer(int i_renamed, boolean z_renamed, okio.Buffer buffer) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.dynamicTable = new okhttp3.internal.http2.Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i_renamed;
            this.maxDynamicTableByteCount = i_renamed;
            this.useCompression = z_renamed;
            this.out = buffer;
        }

        private void clearDynamicTable() {
            java.util.Arrays.fill(this.dynamicTable, (java.lang.Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i_renamed) {
            int i2 = 0;
            if (i_renamed > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i_renamed <= 0) {
                        break;
                    }
                    i_renamed -= this.dynamicTable[length].hpackSize;
                    this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                    this.headerCount--;
                    i2++;
                }
                okhttp3.internal.http2.Header[] headerArr = this.dynamicTable;
                int i3 = this.nextHeaderIndex;
                java.lang.System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i2, this.headerCount);
                okhttp3.internal.http2.Header[] headerArr2 = this.dynamicTable;
                int i4 = this.nextHeaderIndex;
                java.util.Arrays.fill(headerArr2, i4 + 1, i4 + 1 + i2, (java.lang.Object) null);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        private void insertIntoDynamicTable(okhttp3.internal.http2.Header header) {
            int i_renamed = header.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i_renamed > i2) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i_renamed) - i2);
            int i3 = this.headerCount + 1;
            okhttp3.internal.http2.Header[] headerArr = this.dynamicTable;
            if (i3 > headerArr.length) {
                okhttp3.internal.http2.Header[] headerArr2 = new okhttp3.internal.http2.Header[headerArr.length * 2];
                java.lang.System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i_renamed;
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:22:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:37:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:38:0x00b1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void writeHeaders(java.util.List<okhttp3.internal.http2.Header> r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 237
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.writeHeaders(java.util.List):void");
        }

        void writeInt(int i_renamed, int i2, int i3) {
            if (i_renamed < i2) {
                this.out.writeByte(i_renamed | i3);
                return;
            }
            this.out.writeByte(i3 | i2);
            int i4 = i_renamed - i2;
            while (i4 >= 128) {
                this.out.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.out.writeByte(i4);
        }

        void writeByteString(okio.ByteString byteString) throws java.io.IOException {
            if (this.useCompression && okhttp3.internal.http2.Huffman.get().encodedLength(byteString) < byteString.size()) {
                okio.Buffer buffer = new okio.Buffer();
                okhttp3.internal.http2.Huffman.get().encode(byteString, buffer);
                okio.ByteString byteString2 = buffer.readByteString();
                writeInt(byteString2.size(), 127, 128);
                this.out.write(byteString2);
                return;
            }
            writeInt(byteString.size(), 127, 0);
            this.out.write(byteString);
        }

        void setHeaderTableSizeSetting(int i_renamed) {
            this.headerTableSizeSetting = i_renamed;
            int iMin = java.lang.Math.min(i_renamed, 16384);
            int i2 = this.maxDynamicTableByteCount;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.smallestHeaderTableSizeSetting = java.lang.Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            adjustDynamicTableByteCount();
        }

        private void adjustDynamicTableByteCount() {
            int i_renamed = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i_renamed < i2) {
                if (i_renamed == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - i_renamed);
                }
            }
        }
    }

    static okio.ByteString checkLowercase(okio.ByteString byteString) throws java.io.IOException {
        int size = byteString.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            byte b2 = byteString.getByte(i_renamed);
            if (b2 >= 65 && b2 <= 90) {
                throw new java.io.IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
