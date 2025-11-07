package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public abstract class DownloadHelper {

    public interface Callback {
        void onPrepareError(com.google.android.exoplayer2.offline.DownloadHelper downloadHelper, java.io.IOException iOException);

        void onPrepared(com.google.android.exoplayer2.offline.DownloadHelper downloadHelper);
    }

    public abstract com.google.android.exoplayer2.offline.DownloadAction getDownloadAction(byte[] bArr, java.util.List<com.google.android.exoplayer2.offline.TrackKey> list);

    public abstract int getPeriodCount();

    public abstract com.google.android.exoplayer2.offline.DownloadAction getRemoveAction(byte[] bArr);

    public abstract com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups(int i_renamed);

    protected abstract void prepareInternal() throws java.io.IOException;

    public void prepare(com.google.android.exoplayer2.offline.DownloadHelper.Callback callback) {
        new com.google.android.exoplayer2.offline.DownloadHelper.SceneLoader_2(new android.os.Handler(android.os.Looper.myLooper() != null ? android.os.Looper.myLooper() : android.os.Looper.getMainLooper()), callback).start();
    }

    /* renamed from: com.google.android.exoplayer2.offline.DownloadHelper$1, reason: invalid class name */
    class SceneLoader_2 extends java.lang.Thread {
        final /* synthetic */ com.google.android.exoplayer2.offline.DownloadHelper.Callback val$callback;
        final /* synthetic */ android.os.Handler val$handler;

        SceneLoader_2(android.os.Handler handler, com.google.android.exoplayer2.offline.DownloadHelper.Callback callback) {
            this.val$handler = handler;
            this.val$callback = callback;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                com.google.android.exoplayer2.offline.DownloadHelper.this.prepareInternal();
                android.os.Handler handler = this.val$handler;
                final com.google.android.exoplayer2.offline.DownloadHelper.Callback callback = this.val$callback;
                handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadHelper$1$NJSYwfqmwQZzGoahNhNZN-HV0Ik
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$run$0$DownloadHelper$1(callback);
                    }
                });
            } catch (java.io.IOException e_renamed) {
                android.os.Handler handler2 = this.val$handler;
                final com.google.android.exoplayer2.offline.DownloadHelper.Callback callback2 = this.val$callback;
                handler2.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.offline.-$$Lambda$DownloadHelper$1$wpC3MI-R3oiOTWYi5AbWzFrvt8g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$run$1$DownloadHelper$1(callback2, e_renamed);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$run$0$DownloadHelper$1(com.google.android.exoplayer2.offline.DownloadHelper.Callback callback) {
            callback.onPrepared(com.google.android.exoplayer2.offline.DownloadHelper.this);
        }

        public /* synthetic */ void lambda$run$1$DownloadHelper$1(com.google.android.exoplayer2.offline.DownloadHelper.Callback callback, java.io.IOException iOException) {
            callback.onPrepareError(com.google.android.exoplayer2.offline.DownloadHelper.this, iOException);
        }
    }
}
