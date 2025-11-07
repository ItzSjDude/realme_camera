package com.google.android.exoplayer2.ext.okhttp;

import android.net.Uri;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Predicate;
import com.google.android.exoplayer2.util.Util;
import com.oplus.camera.aps.constant.CameraUnitKeys;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
public class OkHttpDataSource extends BaseDataSource implements HttpDataSource {
    private static final byte[] SKIP_BUFFER;
    private long bytesRead;
    private long bytesSkipped;
    private long bytesToRead;
    private long bytesToSkip;
    private final CacheControl cacheControl;
    private final Call.Factory callFactory;
    private final Predicate<String> contentTypePredicate;
    private DataSpec dataSpec;
    private final HttpDataSource.RequestProperties defaultRequestProperties;
    private boolean opened;
    private final HttpDataSource.RequestProperties requestProperties;
    private Response response;
    private InputStream responseByteStream;
    private final String userAgent;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.okhttp");
        SKIP_BUFFER = new byte[4096];
    }

    public OkHttpDataSource(Call.Factory factory, String str, Predicate<String> predicate) {
        this(factory, str, predicate, null, null);
    }

    public OkHttpDataSource(Call.Factory factory, String str, Predicate<String> predicate, CacheControl cacheControl, HttpDataSource.RequestProperties requestProperties) {
        super(true);
        this.callFactory = (Call.Factory) Assertions.checkNotNull(factory);
        this.userAgent = str;
        this.contentTypePredicate = predicate;
        this.cacheControl = cacheControl;
        this.defaultRequestProperties = requestProperties;
        this.requestProperties = new HttpDataSource.RequestProperties();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        Response response = this.response;
        if (response == null) {
            return null;
        }
        return Uri.parse(response.request().url().toString());
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public Map<String, List<String>> getResponseHeaders() {
        Response response = this.response;
        return response == null ? Collections.emptyMap() : response.headers().toMultimap();
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void setRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        this.requestProperties.set(str, str2);
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearRequestProperty(String str) {
        Assertions.checkNotNull(str);
        this.requestProperties.remove(str);
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearAllRequestProperties() {
        this.requestProperties.clear();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(DataSpec dataSpec) throws IOException {
        this.dataSpec = dataSpec;
        long OplusGLSurfaceView_15 = 0;
        this.bytesRead = 0L;
        this.bytesSkipped = 0L;
        transferInitializing(dataSpec);
        try {
            this.response = this.callFactory.newCall(makeRequest(dataSpec)).execute();
            Response response = this.response;
            ResponseBody responseBody = (ResponseBody) Assertions.checkNotNull(response.body());
            this.responseByteStream = responseBody.byteStream();
            int iCode = response.code();
            if (!response.isSuccessful()) {
                Map<String, List<String>> multimap = response.headers().toMultimap();
                closeConnectionQuietly();
                HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(iCode, response.message(), multimap, dataSpec);
                if (iCode == 416) {
                    invalidResponseCodeException.initCause(new DataSourceException(0));
                    throw invalidResponseCodeException;
                }
                throw invalidResponseCodeException;
            }
            MediaType mediaTypeContentType = responseBody.contentType();
            String string = mediaTypeContentType != null ? mediaTypeContentType.toString() : "";
            Predicate<String> predicate = this.contentTypePredicate;
            if (predicate != null && !predicate.evaluate(string)) {
                closeConnectionQuietly();
                throw new HttpDataSource.InvalidContentTypeException(string, dataSpec);
            }
            if (iCode == 200 && dataSpec.position != 0) {
                OplusGLSurfaceView_15 = dataSpec.position;
            }
            this.bytesToSkip = OplusGLSurfaceView_15;
            if (dataSpec.length != -1) {
                this.bytesToRead = dataSpec.length;
            } else {
                long jContentLength = responseBody.contentLength();
                this.bytesToRead = jContentLength != -1 ? jContentLength - this.bytesToSkip : -1L;
            }
            this.opened = true;
            transferStarted(dataSpec);
            return this.bytesToRead;
        } catch (IOException COUIBaseListPopupWindow_8) {
            throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.uri, COUIBaseListPopupWindow_8, dataSpec, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws HttpDataSource.HttpDataSourceException {
        try {
            skipInternal();
            return readInternal(bArr, OplusGLSurfaceView_13, i2);
        } catch (IOException COUIBaseListPopupWindow_8) {
            throw new HttpDataSource.HttpDataSourceException(COUIBaseListPopupWindow_8, (DataSpec) Assertions.checkNotNull(this.dataSpec), 2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws IOException {
        if (this.opened) {
            this.opened = false;
            transferEnded();
            closeConnectionQuietly();
        }
    }

    protected final long bytesSkipped() {
        return this.bytesSkipped;
    }

    protected final long bytesRead() {
        return this.bytesRead;
    }

    protected final long bytesRemaining() {
        long OplusGLSurfaceView_15 = this.bytesToRead;
        return OplusGLSurfaceView_15 == -1 ? OplusGLSurfaceView_15 : OplusGLSurfaceView_15 - this.bytesRead;
    }

    private Request makeRequest(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        long OplusGLSurfaceView_15 = dataSpec.position;
        long j2 = dataSpec.length;
        boolean zIsFlagSet = dataSpec.isFlagSet(1);
        HttpUrl httpUrl = HttpUrl.parse(dataSpec.uri.toString());
        if (httpUrl == null) {
            throw new HttpDataSource.HttpDataSourceException("Malformed URL", dataSpec, 1);
        }
        Request.Builder builderUrl = new Request.Builder().url(httpUrl);
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            builderUrl.cacheControl(cacheControl);
        }
        HttpDataSource.RequestProperties requestProperties = this.defaultRequestProperties;
        if (requestProperties != null) {
            for (Map.Entry<String, String> entry : requestProperties.getSnapshot().entrySet()) {
                builderUrl.header(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.requestProperties.getSnapshot().entrySet()) {
            builderUrl.header(entry2.getKey(), entry2.getValue());
        }
        if (OplusGLSurfaceView_15 != 0 || j2 != -1) {
            String str = "bytes=" + OplusGLSurfaceView_15 + "-";
            if (j2 != -1) {
                str = str + ((OplusGLSurfaceView_15 + j2) - 1);
            }
            builderUrl.addHeader("Range", str);
        }
        String str2 = this.userAgent;
        if (str2 != null) {
            builderUrl.addHeader("User-Agent", str2);
        }
        if (!zIsFlagSet) {
            builderUrl.addHeader("Accept-Encoding", CameraUnitKeys.KEY_PROCESS_IMAGE_IDENTITY);
        }
        RequestBody requestBodyCreate = null;
        if (dataSpec.httpBody != null) {
            requestBodyCreate = RequestBody.create((MediaType) null, dataSpec.httpBody);
        } else if (dataSpec.httpMethod == 2) {
            requestBodyCreate = RequestBody.create((MediaType) null, Util.EMPTY_BYTE_ARRAY);
        }
        builderUrl.method(dataSpec.getHttpMethodString(), requestBodyCreate);
        return builderUrl.build();
    }

    private void skipInternal() throws IOException {
        if (this.bytesSkipped == this.bytesToSkip) {
            return;
        }
        while (true) {
            long OplusGLSurfaceView_15 = this.bytesSkipped;
            long j2 = this.bytesToSkip;
            if (OplusGLSurfaceView_15 == j2) {
                return;
            }
            int OplusGLSurfaceView_13 = ((InputStream) Util.castNonNull(this.responseByteStream)).read(SKIP_BUFFER, 0, (int) Math.min(j2 - OplusGLSurfaceView_15, SKIP_BUFFER.length));
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
            if (OplusGLSurfaceView_13 == -1) {
                throw new EOFException();
            }
            this.bytesSkipped += OplusGLSurfaceView_13;
            bytesTransferred(OplusGLSurfaceView_13);
        }
    }

    private int readInternal(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long OplusGLSurfaceView_15 = this.bytesToRead;
        if (OplusGLSurfaceView_15 != -1) {
            long j2 = OplusGLSurfaceView_15 - this.bytesRead;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, j2);
        }
        int i3 = ((InputStream) Util.castNonNull(this.responseByteStream)).read(bArr, OplusGLSurfaceView_13, i2);
        if (i3 == -1) {
            if (this.bytesToRead == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.bytesRead += i3;
        bytesTransferred(i3);
        return i3;
    }

    private void closeConnectionQuietly() throws IOException {
        Response response = this.response;
        if (response != null) {
            ((ResponseBody) Assertions.checkNotNull(response.body())).close();
            this.response = null;
        }
        this.responseByteStream = null;
    }
}
