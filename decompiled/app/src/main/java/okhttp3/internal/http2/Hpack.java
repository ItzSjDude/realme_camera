package okhttp3.internal.http2;

import com.android.providers.downloads.Downloads;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* loaded from: classes2.dex */
final class Hpack {
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] STATIC_HEADER_TABLE = {new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, DcsMsgData.LOGTAG_CAPTURE), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header(FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(CameraStatisticsUtil.PORTRAIT_LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header(Downloads.Impl.COLUMN_REFERER, ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
    static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();

    private Hpack() {
    }

    static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final BufferedSource source;

        Reader(int OplusGLSurfaceView_13, Source source) {
            this(OplusGLSurfaceView_13, OplusGLSurfaceView_13, source);
        }

        Reader(int OplusGLSurfaceView_13, int i2, Source source) {
            this.headerList = new ArrayList();
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = OplusGLSurfaceView_13;
            this.maxDynamicTableByteCount = i2;
            this.source = Okio.buffer(source);
        }

        int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        private void adjustDynamicTableByteCount() {
            int OplusGLSurfaceView_13 = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (OplusGLSurfaceView_13 < i2) {
                if (OplusGLSurfaceView_13 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - OplusGLSurfaceView_13);
                }
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int OplusGLSurfaceView_13) {
            int i2 = 0;
            if (OplusGLSurfaceView_13 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || OplusGLSurfaceView_13 <= 0) {
                        break;
                    }
                    OplusGLSurfaceView_13 -= this.dynamicTable[length].hpackSize;
                    this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                    this.headerCount--;
                    i2++;
                }
                Header[] headerArr = this.dynamicTable;
                int i3 = this.nextHeaderIndex;
                System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i2, this.headerCount);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                int OplusGLSurfaceView_13 = this.source.readByte() & 255;
                if (OplusGLSurfaceView_13 == 128) {
                    throw new IOException("index == 0");
                }
                if ((OplusGLSurfaceView_13 & 128) == 128) {
                    readIndexedHeader(readInt(OplusGLSurfaceView_13, 127) - 1);
                } else if (OplusGLSurfaceView_13 == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((OplusGLSurfaceView_13 & 64) == 64) {
                    m26007xb412701e(readInt(OplusGLSurfaceView_13, 63) - 1);
                } else if ((OplusGLSurfaceView_13 & 32) == 32) {
                    this.maxDynamicTableByteCount = readInt(OplusGLSurfaceView_13, 31);
                    int i2 = this.maxDynamicTableByteCount;
                    if (i2 < 0 || i2 > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (OplusGLSurfaceView_13 == 16 || OplusGLSurfaceView_13 == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(OplusGLSurfaceView_13, 15) - 1);
                }
            }
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        private void readIndexedHeader(int OplusGLSurfaceView_13) throws IOException {
            if (isStaticHeader(OplusGLSurfaceView_13)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[OplusGLSurfaceView_13]);
                return;
            }
            int iDynamicTableIndex = dynamicTableIndex(OplusGLSurfaceView_13 - Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[iDynamicTableIndex]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (OplusGLSurfaceView_13 + 1));
        }

        private int dynamicTableIndex(int OplusGLSurfaceView_13) {
            return this.nextHeaderIndex + 1 + OplusGLSurfaceView_13;
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int OplusGLSurfaceView_13) throws IOException {
            this.headerList.add(new Header(getName(OplusGLSurfaceView_13), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        /* renamed from: readLiteralHeaderWithIncrementalIndexingIndexedName */
        private void m26007xb412701e(int OplusGLSurfaceView_13) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(OplusGLSurfaceView_13), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private ByteString getName(int OplusGLSurfaceView_13) throws IOException {
            if (isStaticHeader(OplusGLSurfaceView_13)) {
                return Hpack.STATIC_HEADER_TABLE[OplusGLSurfaceView_13].name;
            }
            int iDynamicTableIndex = dynamicTableIndex(OplusGLSurfaceView_13 - Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    return headerArr[iDynamicTableIndex].name;
                }
            }
            throw new IOException("Header index too large " + (OplusGLSurfaceView_13 + 1));
        }

        private boolean isStaticHeader(int OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private void insertIntoDynamicTable(int OplusGLSurfaceView_13, Header header) {
            this.headerList.add(header);
            int i2 = header.hpackSize;
            if (OplusGLSurfaceView_13 != -1) {
                i2 -= this.dynamicTable[dynamicTableIndex(OplusGLSurfaceView_13)].hpackSize;
            }
            int i3 = this.maxDynamicTableByteCount;
            if (i2 > i3) {
                clearDynamicTable();
                return;
            }
            int iEvictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i2) - i3);
            if (OplusGLSurfaceView_13 == -1) {
                int i4 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i5 = this.nextHeaderIndex;
                this.nextHeaderIndex = i5 - 1;
                this.dynamicTable[i5] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[OplusGLSurfaceView_13 + dynamicTableIndex(OplusGLSurfaceView_13) + iEvictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i2;
        }

        private int readByte() throws IOException {
            return this.source.readByte() & 255;
        }

        int readInt(int OplusGLSurfaceView_13, int i2) throws IOException {
            int i3 = OplusGLSurfaceView_13 & i2;
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

        ByteString readByteString() throws IOException {
            int OplusGLSurfaceView_13 = readByte();
            boolean z = (OplusGLSurfaceView_13 & 128) == 128;
            int i2 = readInt(OplusGLSurfaceView_13, 127);
            if (z) {
                return ByteString.m26009of(Huffman.get().decode(this.source.readByteArray(i2)));
            }
            return this.source.readByteString(i2);
        }
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (OplusGLSurfaceView_13 < headerArr.length) {
                if (!linkedHashMap.containsKey(headerArr[OplusGLSurfaceView_13].name)) {
                    linkedHashMap.put(STATIC_HEADER_TABLE[OplusGLSurfaceView_13].name, Integer.valueOf(OplusGLSurfaceView_13));
                }
                OplusGLSurfaceView_13++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        Writer(Buffer buffer) {
            this(4096, true, buffer);
        }

        Writer(int OplusGLSurfaceView_13, boolean z, Buffer buffer) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = OplusGLSurfaceView_13;
            this.maxDynamicTableByteCount = OplusGLSurfaceView_13;
            this.useCompression = z;
            this.out = buffer;
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int OplusGLSurfaceView_13) {
            int i2 = 0;
            if (OplusGLSurfaceView_13 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || OplusGLSurfaceView_13 <= 0) {
                        break;
                    }
                    OplusGLSurfaceView_13 -= this.dynamicTable[length].hpackSize;
                    this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                    this.headerCount--;
                    i2++;
                }
                Header[] headerArr = this.dynamicTable;
                int i3 = this.nextHeaderIndex;
                System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i2, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i4 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i4 + 1, i4 + 1 + i2, (Object) null);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        private void insertIntoDynamicTable(Header header) {
            int OplusGLSurfaceView_13 = header.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (OplusGLSurfaceView_13 > i2) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + OplusGLSurfaceView_13) - i2);
            int i3 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += OplusGLSurfaceView_13;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
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

        void writeInt(int OplusGLSurfaceView_13, int i2, int i3) {
            if (OplusGLSurfaceView_13 < i2) {
                this.out.writeByte(OplusGLSurfaceView_13 | i3);
                return;
            }
            this.out.writeByte(i3 | i2);
            int i4 = OplusGLSurfaceView_13 - i2;
            while (i4 >= 128) {
                this.out.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.out.writeByte(i4);
        }

        void writeByteString(ByteString byteString) throws IOException {
            if (this.useCompression && Huffman.get().encodedLength(byteString) < byteString.size()) {
                Buffer buffer = new Buffer();
                Huffman.get().encode(byteString, buffer);
                ByteString byteString2 = buffer.readByteString();
                writeInt(byteString2.size(), 127, 128);
                this.out.write(byteString2);
                return;
            }
            writeInt(byteString.size(), 127, 0);
            this.out.write(byteString);
        }

        void setHeaderTableSizeSetting(int OplusGLSurfaceView_13) {
            this.headerTableSizeSetting = OplusGLSurfaceView_13;
            int iMin = Math.min(OplusGLSurfaceView_13, 16384);
            int i2 = this.maxDynamicTableByteCount;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            adjustDynamicTableByteCount();
        }

        private void adjustDynamicTableByteCount() {
            int OplusGLSurfaceView_13 = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (OplusGLSurfaceView_13 < i2) {
                if (OplusGLSurfaceView_13 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - OplusGLSurfaceView_13);
                }
            }
        }
    }

    static ByteString checkLowercase(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            byte b2 = byteString.getByte(OplusGLSurfaceView_13);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
