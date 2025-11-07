package com.oplus.tblplayer.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Predicate;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.utils.CommonUtil;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.ReflectUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class TBLOkHttpDataSource extends OkHttpDataSource implements Interceptor {
    private static final String TAG = "TBLHttpDataSource";
    private long closeAtTimestamp;
    private long firstReadTime;
    private boolean hasFirstRead;
    private final List<OkHttpSession> httpSessions;
    private long openAtTimestamp;
    private String originalAddress;
    private String redirectedAddress;
    private long totalBytesRead;

    public TBLOkHttpDataSource(Call.Factory factory, String str, Predicate<String> predicate) {
        super(factory, str, predicate);
        this.openAtTimestamp = 0L;
        this.closeAtTimestamp = 0L;
        this.hasFirstRead = true;
        this.firstReadTime = 0L;
        this.totalBytesRead = 0L;
        this.originalAddress = null;
        this.redirectedAddress = null;
        this.httpSessions = new CopyOnWriteArrayList();
    }

    public TBLOkHttpDataSource(Call.Factory factory, String str, Predicate<String> predicate, CacheControl cacheControl, HttpDataSource.RequestProperties requestProperties) {
        super(factory, str, predicate, cacheControl, requestProperties);
        this.openAtTimestamp = 0L;
        this.closeAtTimestamp = 0L;
        this.hasFirstRead = true;
        this.firstReadTime = 0L;
        this.totalBytesRead = 0L;
        this.originalAddress = null;
        this.redirectedAddress = null;
        this.httpSessions = new CopyOnWriteArrayList();
    }

    private void setupInterceptor() {
        List list;
        Call.Factory factory = (Call.Factory) ReflectUtil.getField(this, Call.Factory.class, "callFactory");
        if (!(factory instanceof OkHttpClient) || (list = (List) ReflectUtil.getField(factory, List.class, "networkInterceptors")) == null || list.contains(this)) {
            return;
        }
        LogUtil.m25450d(TAG, "OkHttp interceptors size is " + list.size());
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, this);
        ReflectUtil.setField(factory, List.class, "networkInterceptors", CommonUtil.immutableList(arrayList));
    }

    private void resetInterceptor() {
        List list;
        Call.Factory factory = (Call.Factory) ReflectUtil.getField(this, Call.Factory.class, "callFactory");
        if ((factory instanceof OkHttpClient) && (list = (List) ReflectUtil.getField(factory, List.class, "networkInterceptors")) != null && list.contains(this)) {
            ArrayList arrayList = new ArrayList(list);
            arrayList.remove(this);
            ReflectUtil.setField(factory, List.class, "networkInterceptors", CommonUtil.immutableList(arrayList));
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        OkHttpSession okHttpSession = new OkHttpSession();
        okHttpSession.requestTimestamp = System.currentTimeMillis();
        okHttpSession.call = chain.call();
        okHttpSession.connection = chain.connection();
        okHttpSession.request = chain.request();
        this.httpSessions.add(okHttpSession);
        Response responseProceed = chain.proceed(okHttpSession.request);
        Response responseBuild = responseProceed.newBuilder().body(responseProceed.body()).build();
        okHttpSession.response = responseBuild;
        if (responseBuild.isRedirect()) {
            String strHeader = responseBuild.header("Location");
            LogUtil.dfmt(TAG, "redirect url from %s to %s", chain.request().url().toString(), strHeader);
            if (Globals.getPreferRedirectAddress()) {
                this.redirectedAddress = strHeader;
            }
        }
        return responseBuild;
    }

    private long innerOpen(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        LogUtil.m25450d(TAG, "innerOpen: ");
        try {
            this.httpSessions.clear();
            setupInterceptor();
            return super.open(dataSpec);
        } catch (Throwable th) {
            LogUtil.m25451d(TAG, "innerOpen: ", th);
            OkHttpSession okHttpSession = new OkHttpSession();
            okHttpSession.requestTimestamp = this.openAtTimestamp;
            okHttpSession.originalUrl = dataSpec.uri.toString();
            this.httpSessions.add(okHttpSession);
            this.printHttpSession();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource, com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        DataSpec dataSpec2;
        this.openAtTimestamp = System.currentTimeMillis();
        LogUtil.dfmt(TAG, "open data source: %s at %s", dataSpec.uri.toString(), LogUtil.getDateTimeString(this.openAtTimestamp));
        if (!Globals.getPreferRedirectAddress()) {
            dataSpec2 = dataSpec;
        } else if (this.originalAddress != null && this.redirectedAddress != null && dataSpec.uri.toString().compareToIgnoreCase(this.originalAddress) == 0) {
            LogUtil.m25450d(TAG, "open: will use redirected address.");
            dataSpec2 = new DataSpec(Uri.parse(this.redirectedAddress), dataSpec.httpMethod, dataSpec.httpBody, dataSpec.absoluteStreamPosition, dataSpec.position, dataSpec.length, dataSpec.key, dataSpec.flags);
        } else {
            this.originalAddress = dataSpec.uri.toString();
            dataSpec2 = dataSpec;
        }
        try {
            this.httpSessions.clear();
            setupInterceptor();
            return super.open(dataSpec2);
        } catch (Throwable th) {
            LogUtil.m25451d(TAG, "open: ", th);
            if (dataSpec2 != dataSpec) {
                return this.innerOpen(dataSpec);
            }
            OkHttpSession okHttpSession = new OkHttpSession();
            okHttpSession.requestTimestamp = this.openAtTimestamp;
            okHttpSession.originalUrl = dataSpec.uri.toString();
            this.httpSessions.add(okHttpSession);
            this.printHttpSession();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource, com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws HttpDataSource.HttpDataSourceException {
        if (this.hasFirstRead) {
            this.firstReadTime = System.currentTimeMillis();
            this.hasFirstRead = false;
            LogUtil.m25450d(TAG, "first read at " + LogUtil.getDateTimeString(this.firstReadTime));
        }
        try {
            int i3 = super.read(bArr, OplusGLSurfaceView_13, i2);
            if (this.httpSessions.size() > 0 && i3 > 0) {
                OkHttpSession okHttpSession = this.httpSessions.get(this.httpSessions.size() - 1);
                if (okHttpSession.needCache()) {
                    okHttpSession.cacheBytes(bArr, OplusGLSurfaceView_13, i3);
                }
            }
            if (i3 != -1) {
                this.totalBytesRead += i3;
            }
            return i3;
        } catch (Throwable th) {
            LogUtil.m25451d(TAG, "read: ", th);
            printHttpSession();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource, com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws IOException {
        super.close();
        this.closeAtTimestamp = System.currentTimeMillis();
        LogUtil.dfmt(TAG, "close data source at %s, exist duration %IntrinsicsJvm.kt_5 ms.", LogUtil.getDateTimeString(this.closeAtTimestamp), Long.valueOf(this.closeAtTimestamp - this.openAtTimestamp));
        LogUtil.m25450d(TAG, "close: with totalBytesRead = " + this.totalBytesRead);
        resetInterceptor();
        this.httpSessions.clear();
    }

    public long getTotalBytesRead() {
        return this.totalBytesRead;
    }

    private String getUrlFromHttpSession(Connection connection) {
        for (OkHttpSession okHttpSession : this.httpSessions) {
            if (okHttpSession.connection == connection) {
                return okHttpSession.getUrl();
            }
        }
        return null;
    }

    private String getIpFromHttpSession(Connection connection) {
        for (OkHttpSession okHttpSession : this.httpSessions) {
            if (okHttpSession.connection == connection) {
                return okHttpSession.getIp();
            }
        }
        return null;
    }

    private void printHttpSession() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append(">>>>>>>>>>>>>>>>>>>>Begin dump http request and response>>>>>>>>>>>>>>>>>>>");
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.httpSessions.size(); OplusGLSurfaceView_13++) {
                sb.append("\OplusGLSurfaceView_11" + this.httpSessions.get(OplusGLSurfaceView_13).toString());
                if (OplusGLSurfaceView_13 < this.httpSessions.size() - 1) {
                    sb.append("----------------------------------------------------------------------------");
                }
            }
            sb.append("<<<<<<<<<<<<<<<<<<<<Finish dump http request and response<<<<<<<<<<<<<<<<<<");
            LogUtil.m25454i(TAG, "\OplusGLSurfaceView_11" + sb.toString());
            LogUtil.m25450d(TAG, "printHttpSession: cost time " + (System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Throwable th) {
            LogUtil.m25455i(TAG, "Dump failed!", th);
        }
    }
}
