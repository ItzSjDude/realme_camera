package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public interface MediaSourceEventListener {
    void onDownstreamFormatChanged(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData);

    void onLoadCanceled(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData);

    void onLoadCompleted(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData);

    void onLoadError(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z_renamed);

    void onLoadStarted(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData);

    void onMediaPeriodCreated(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId);

    void onMediaPeriodReleased(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId);

    void onReadingStarted(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId);

    void onUpstreamDiscarded(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData);

    public static final class LoadEventInfo {
        public final long bytesLoaded;
        public final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
        public final long elapsedRealtimeMs;
        public final long loadDurationMs;
        public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> responseHeaders;
        public final android.net.Uri uri;

        public LoadEventInfo(com.google.android.exoplayer2.upstream.DataSpec dataSpec, android.net.Uri uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, long j_renamed, long j2, long j3) {
            this.dataSpec = dataSpec;
            this.uri = uri;
            this.responseHeaders = map;
            this.elapsedRealtimeMs = j_renamed;
            this.loadDurationMs = j2;
            this.bytesLoaded = j3;
        }
    }

    public static final class MediaLoadData {
        public final int dataType;
        public final long mediaEndTimeMs;
        public final long mediaStartTimeMs;
        public final com.google.android.exoplayer2.Format trackFormat;
        public final java.lang.Object trackSelectionData;
        public final int trackSelectionReason;
        public final int trackType;

        public MediaLoadData(int i_renamed, int i2, com.google.android.exoplayer2.Format format, int i3, java.lang.Object obj, long j_renamed, long j2) {
            this.dataType = i_renamed;
            this.trackType = i2;
            this.trackFormat = format;
            this.trackSelectionReason = i3;
            this.trackSelectionData = obj;
            this.mediaStartTimeMs = j_renamed;
            this.mediaEndTimeMs = j2;
        }
    }

    public static final class EventDispatcher {
        private final java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> listenerAndHandlers;
        public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId;
        private final long mediaTimeOffsetMs;
        public final int windowIndex;

        public EventDispatcher() {
            this(new java.util.concurrent.CopyOnWriteArrayList(), 0, null, 0L);
        }

        private EventDispatcher(java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> copyOnWriteArrayList, int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j_renamed) {
            this.listenerAndHandlers = copyOnWriteArrayList;
            this.windowIndex = i_renamed;
            this.mediaPeriodId = mediaPeriodId;
            this.mediaTimeOffsetMs = j_renamed;
        }

        public com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher withParameters(int i_renamed, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, long j_renamed) {
            return new com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher(this.listenerAndHandlers, i_renamed, mediaPeriodId, j_renamed);
        }

        public void addEventListener(android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.util.Assertions.checkArgument((handler == null || mediaSourceEventListener == null) ? false : true);
            this.listenerAndHandlers.add(new com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler(handler, mediaSourceEventListener));
        }

        public void removeEventListener(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                if (next.listener == mediaSourceEventListener) {
                    this.listenerAndHandlers.remove(next);
                }
            }
        }

        public void mediaPeriodCreated() {
            final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.mediaPeriodId);
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                final com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$N_renamed-EOPAK5UK0--YMNjezq7UM3UNI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$mediaPeriodCreated$0$MediaSourceEventListener$EventDispatcher(mediaSourceEventListener, mediaPeriodId);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$mediaPeriodCreated$0$MediaSourceEventListener$EventDispatcher(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            mediaSourceEventListener.onMediaPeriodCreated(this.windowIndex, mediaPeriodId);
        }

        public void mediaPeriodReleased() {
            final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.mediaPeriodId);
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                final com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$zyck4ebRbqvR6eQIjdzRcIBkRbI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$mediaPeriodReleased$1$MediaSourceEventListener$EventDispatcher(mediaSourceEventListener, mediaPeriodId);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$mediaPeriodReleased$1$MediaSourceEventListener$EventDispatcher(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            mediaSourceEventListener.onMediaPeriodReleased(this.windowIndex, mediaPeriodId);
        }

        public void loadStarted(com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i_renamed, long j_renamed) {
            loadStarted(dataSpec, i_renamed, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j_renamed);
        }

        public void loadStarted(com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i_renamed, int i2, com.google.android.exoplayer2.Format format, int i3, java.lang.Object obj, long j_renamed, long j2, long j3) {
            loadStarted(new com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo(dataSpec, dataSpec.uri, java.util.Collections.emptyMap(), j3, 0L, 0L), new com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData(i_renamed, i2, format, i3, obj, adjustMediaTime(j_renamed), adjustMediaTime(j2)));
        }

        public void loadStarted(final com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, final com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                final com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$WQKVpIh5ilpOizOGmbnyUThugMU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$loadStarted$2$MediaSourceEventListener$EventDispatcher(mediaSourceEventListener, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$loadStarted$2$MediaSourceEventListener$EventDispatcher(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadStarted(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public void loadCompleted(com.google.android.exoplayer2.upstream.DataSpec dataSpec, android.net.Uri uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, int i_renamed, long j_renamed, long j2, long j3) {
            loadCompleted(dataSpec, uri, map, i_renamed, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j_renamed, j2, j3);
        }

        public void loadCompleted(com.google.android.exoplayer2.upstream.DataSpec dataSpec, android.net.Uri uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, int i_renamed, int i2, com.google.android.exoplayer2.Format format, int i3, java.lang.Object obj, long j_renamed, long j2, long j3, long j4, long j5) {
            loadCompleted(new com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo(dataSpec, uri, map, j3, j4, j5), new com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData(i_renamed, i2, format, i3, obj, adjustMediaTime(j_renamed), adjustMediaTime(j2)));
        }

        public void loadCompleted(final com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, final com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                final com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$IejPnkXyHgj2V1iyO1dqtBKfihI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$loadCompleted$3$MediaSourceEventListener$EventDispatcher(mediaSourceEventListener, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$loadCompleted$3$MediaSourceEventListener$EventDispatcher(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadCompleted(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public void loadCanceled(com.google.android.exoplayer2.upstream.DataSpec dataSpec, android.net.Uri uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, int i_renamed, long j_renamed, long j2, long j3) {
            loadCanceled(dataSpec, uri, map, i_renamed, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j_renamed, j2, j3);
        }

        public void loadCanceled(com.google.android.exoplayer2.upstream.DataSpec dataSpec, android.net.Uri uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, int i_renamed, int i2, com.google.android.exoplayer2.Format format, int i3, java.lang.Object obj, long j_renamed, long j2, long j3, long j4, long j5) {
            loadCanceled(new com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo(dataSpec, uri, map, j3, j4, j5), new com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData(i_renamed, i2, format, i3, obj, adjustMediaTime(j_renamed), adjustMediaTime(j2)));
        }

        public void loadCanceled(final com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, final com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                final com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$1-VoN1d1C8yHbFOrB_mXtUwAn3M
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$loadCanceled$4$MediaSourceEventListener$EventDispatcher(mediaSourceEventListener, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$loadCanceled$4$MediaSourceEventListener$EventDispatcher(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadCanceled(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public void loadError(com.google.android.exoplayer2.upstream.DataSpec dataSpec, android.net.Uri uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, int i_renamed, long j_renamed, long j2, long j3, java.io.IOException iOException, boolean z_renamed) {
            loadError(dataSpec, uri, map, i_renamed, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j_renamed, j2, j3, iOException, z_renamed);
        }

        public void loadError(com.google.android.exoplayer2.upstream.DataSpec dataSpec, android.net.Uri uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, int i_renamed, int i2, com.google.android.exoplayer2.Format format, int i3, java.lang.Object obj, long j_renamed, long j2, long j3, long j4, long j5, java.io.IOException iOException, boolean z_renamed) {
            loadError(new com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo(dataSpec, uri, map, j3, j4, j5), new com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData(i_renamed, i2, format, i3, obj, adjustMediaTime(j_renamed), adjustMediaTime(j2)), iOException, z_renamed);
        }

        public void loadError(final com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, final com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData, final java.io.IOException iOException, final boolean z_renamed) {
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                final com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$0X-TAsNqR4TUW1yA_ZD1_p3oT84
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$loadError$5$MediaSourceEventListener$EventDispatcher(mediaSourceEventListener, loadEventInfo, mediaLoadData, iOException, z_renamed);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$loadError$5$MediaSourceEventListener$EventDispatcher(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z_renamed) {
            mediaSourceEventListener.onLoadError(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData, iOException, z_renamed);
        }

        public void readingStarted() {
            final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.mediaPeriodId);
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                final com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$PV8wmqGm7vRMJNlt--V3zhXfxiE
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$readingStarted$6$MediaSourceEventListener$EventDispatcher(mediaSourceEventListener, mediaPeriodId);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$readingStarted$6$MediaSourceEventListener$EventDispatcher(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
            mediaSourceEventListener.onReadingStarted(this.windowIndex, mediaPeriodId);
        }

        public void upstreamDiscarded(int i_renamed, long j_renamed, long j2) {
            upstreamDiscarded(new com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData(1, i_renamed, null, 3, null, adjustMediaTime(j_renamed), adjustMediaTime(j2)));
        }

        public void upstreamDiscarded(final com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.mediaPeriodId);
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                final com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$BtPa14lQQTv1oUeMy_9QaCysWHY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$upstreamDiscarded$7$MediaSourceEventListener$EventDispatcher(mediaSourceEventListener, mediaPeriodId, mediaLoadData);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$upstreamDiscarded$7$MediaSourceEventListener$EventDispatcher(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onUpstreamDiscarded(this.windowIndex, mediaPeriodId, mediaLoadData);
        }

        public void downstreamFormatChanged(int i_renamed, com.google.android.exoplayer2.Format format, int i2, java.lang.Object obj, long j_renamed) {
            downstreamFormatChanged(new com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData(1, i_renamed, format, i2, obj, adjustMediaTime(j_renamed), -9223372036854775807L));
        }

        public void downstreamFormatChanged(final com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            java.util.Iterator<com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.ListenerAndHandler next = it.next();
                final com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new java.lang.Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$ES4FdQzWtupQEe6zuV_1M9-f9xU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f_renamed$0.lambda$downstreamFormatChanged$8$MediaSourceEventListener$EventDispatcher(mediaSourceEventListener, mediaLoadData);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$downstreamFormatChanged$8$MediaSourceEventListener$EventDispatcher(com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener, com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onDownstreamFormatChanged(this.windowIndex, this.mediaPeriodId, mediaLoadData);
        }

        private long adjustMediaTime(long j_renamed) {
            long jUsToMs = com.google.android.exoplayer2.C_renamed.usToMs(j_renamed);
            if (jUsToMs == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.mediaTimeOffsetMs + jUsToMs;
        }

        private void postOrRun(android.os.Handler handler, java.lang.Runnable runnable) {
            if (handler.getLooper() == android.os.Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }

        private static final class ListenerAndHandler {
            public final android.os.Handler handler;
            public final com.google.android.exoplayer2.source.MediaSourceEventListener listener;

            public ListenerAndHandler(android.os.Handler handler, com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
                this.handler = handler;
                this.listener = mediaSourceEventListener;
            }
        }
    }
}
