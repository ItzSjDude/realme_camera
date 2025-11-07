package com.google.android.exoplayer2.offline;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public abstract class DownloadHelper {

    public interface Callback {
        void onPrepareError(DownloadHelper downloadHelper, IOException iOException);

        void onPrepared(DownloadHelper downloadHelper);
    }

    public abstract DownloadAction getDownloadAction(byte[] bArr, List<TrackKey> list);

    public abstract int getPeriodCount();

    public abstract DownloadAction getRemoveAction(byte[] bArr);

    public abstract TrackGroupArray getTrackGroups(int OplusGLSurfaceView_13);

    protected abstract void prepareInternal() throws IOException;

    public void prepare(Callback callback) {
        new C16221(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), callback).start();
    }

    /* renamed from: com.google.android.exoplayer2.offline.DownloadHelper$1 */
    class C16221 extends Thread {
        final /* synthetic */ Callback val$callback;
        final /* synthetic */ Handler val$handler;

        C16221(Handler handler, Callback callback) {
            this.val$handler = handler;
            this.val$callback = callback;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                DownloadHelper.this.prepareInternal();
                Handler handler = this.val$handler;
                final Callback callback = this.val$callback;
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadHelper$1$NJSYwfqmwQZzGoahNhNZN-HV0Ik
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.lambda$run$0$DownloadHelper$1(callback);
                    }
                });
            } catch (IOException COUIBaseListPopupWindow_8) {
                Handler handler2 = this.val$handler;
                final Callback callback2 = this.val$callback;
                handler2.post(new Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadHelper$1$wpC3MI-R3oiOTWYi5AbWzFrvt8g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.lambda$run$1$DownloadHelper$1(callback2, COUIBaseListPopupWindow_8);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$run$0$DownloadHelper$1(Callback callback) {
            callback.onPrepared(DownloadHelper.this);
        }

        public /* synthetic */ void lambda$run$1$DownloadHelper$1(Callback callback, IOException iOException) {
            callback.onPrepareError(DownloadHelper.this, iOException);
        }
    }
}
