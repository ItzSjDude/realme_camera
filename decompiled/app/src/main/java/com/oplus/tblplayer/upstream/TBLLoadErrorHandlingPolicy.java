package com.oplus.tblplayer.upstream;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes2.dex */
public class TBLLoadErrorHandlingPolicy extends DefaultLoadErrorHandlingPolicy {
    @Override // com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getRetryDelayMsFor(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, IOException iOException, int i2) {
        if ((iOException instanceof FileNotFoundException) || (iOException instanceof ParserException)) {
            return -9223372036854775807L;
        }
        return super.getRetryDelayMsFor(OplusGLSurfaceView_13, OplusGLSurfaceView_15, iOException, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long getBlacklistDurationMsFor(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, IOException iOException, int i2) {
        return ((iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode == 500) ? DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS : super.getBlacklistDurationMsFor(OplusGLSurfaceView_13, OplusGLSurfaceView_15, iOException, i2);
    }
}
