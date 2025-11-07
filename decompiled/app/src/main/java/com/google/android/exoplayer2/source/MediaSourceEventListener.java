package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.C1547C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public interface MediaSourceEventListener {
    void onDownstreamFormatChanged(int OplusGLSurfaceView_13, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    void onLoadCanceled(int OplusGLSurfaceView_13, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadCompleted(int OplusGLSurfaceView_13, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadError(int OplusGLSurfaceView_13, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z);

    void onLoadStarted(int OplusGLSurfaceView_13, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onMediaPeriodCreated(int OplusGLSurfaceView_13, MediaSource.MediaPeriodId mediaPeriodId);

    void onMediaPeriodReleased(int OplusGLSurfaceView_13, MediaSource.MediaPeriodId mediaPeriodId);

    void onReadingStarted(int OplusGLSurfaceView_13, MediaSource.MediaPeriodId mediaPeriodId);

    void onUpstreamDiscarded(int OplusGLSurfaceView_13, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    public static final class LoadEventInfo {
        public final long bytesLoaded;
        public final DataSpec dataSpec;
        public final long elapsedRealtimeMs;
        public final long loadDurationMs;
        public final Map<String, List<String>> responseHeaders;
        public final Uri uri;

        public LoadEventInfo(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, long OplusGLSurfaceView_15, long j2, long j3) {
            this.dataSpec = dataSpec;
            this.uri = uri;
            this.responseHeaders = map;
            this.elapsedRealtimeMs = OplusGLSurfaceView_15;
            this.loadDurationMs = j2;
            this.bytesLoaded = j3;
        }
    }

    public static final class MediaLoadData {
        public final int dataType;
        public final long mediaEndTimeMs;
        public final long mediaStartTimeMs;
        public final Format trackFormat;
        public final Object trackSelectionData;
        public final int trackSelectionReason;
        public final int trackType;

        public MediaLoadData(int OplusGLSurfaceView_13, int i2, Format format, int i3, Object obj, long OplusGLSurfaceView_15, long j2) {
            this.dataType = OplusGLSurfaceView_13;
            this.trackType = i2;
            this.trackFormat = format;
            this.trackSelectionReason = i3;
            this.trackSelectionData = obj;
            this.mediaStartTimeMs = OplusGLSurfaceView_15;
            this.mediaEndTimeMs = j2;
        }
    }

    public static final class EventDispatcher {
        private final CopyOnWriteArrayList<ListenerAndHandler> listenerAndHandlers;
        public final MediaSource.MediaPeriodId mediaPeriodId;
        private final long mediaTimeOffsetMs;
        public final int windowIndex;

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int OplusGLSurfaceView_13, MediaSource.MediaPeriodId mediaPeriodId, long OplusGLSurfaceView_15) {
            this.listenerAndHandlers = copyOnWriteArrayList;
            this.windowIndex = OplusGLSurfaceView_13;
            this.mediaPeriodId = mediaPeriodId;
            this.mediaTimeOffsetMs = OplusGLSurfaceView_15;
        }

        public EventDispatcher withParameters(int OplusGLSurfaceView_13, MediaSource.MediaPeriodId mediaPeriodId, long OplusGLSurfaceView_15) {
            return new EventDispatcher(this.listenerAndHandlers, OplusGLSurfaceView_13, mediaPeriodId, OplusGLSurfaceView_15);
        }

        public void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            Assertions.checkArgument((handler == null || mediaSourceEventListener == null) ? false : true);
            this.listenerAndHandlers.add(new ListenerAndHandler(handler, mediaSourceEventListener));
        }

        public void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                if (next.listener == mediaSourceEventListener) {
                    this.listenerAndHandlers.remove(next);
                }
            }
        }

        public void mediaPeriodCreated() {
            final MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) Assertions.checkNotNull(this.mediaPeriodId);
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$N-EOPAK5UK0--YMNjezq7UM3UNI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8310xa9fff584(mediaSourceEventListener, mediaPeriodId);
                    }
                });
            }
        }

        /* renamed from: lambda$mediaPeriodCreated$0$MediaSourceEventListener$EventDispatcher */
        public /* synthetic */ void m8310xa9fff584(MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId) {
            mediaSourceEventListener.onMediaPeriodCreated(this.windowIndex, mediaPeriodId);
        }

        public void mediaPeriodReleased() {
            final MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) Assertions.checkNotNull(this.mediaPeriodId);
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$zyck4ebRbqvR6eQIjdzRcIBkRbI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8311xb596e71e(mediaSourceEventListener, mediaPeriodId);
                    }
                });
            }
        }

        /* renamed from: lambda$mediaPeriodReleased$1$MediaSourceEventListener$EventDispatcher */
        public /* synthetic */ void m8311xb596e71e(MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId) {
            mediaSourceEventListener.onMediaPeriodReleased(this.windowIndex, mediaPeriodId);
        }

        public void loadStarted(DataSpec dataSpec, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
            loadStarted(dataSpec, OplusGLSurfaceView_13, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, OplusGLSurfaceView_15);
        }

        public void loadStarted(DataSpec dataSpec, int OplusGLSurfaceView_13, int i2, Format format, int i3, Object obj, long OplusGLSurfaceView_15, long j2, long j3) {
            loadStarted(new LoadEventInfo(dataSpec, dataSpec.uri, Collections.emptyMap(), j3, 0L, 0L), new MediaLoadData(OplusGLSurfaceView_13, i2, format, i3, obj, adjustMediaTime(OplusGLSurfaceView_15), adjustMediaTime(j2)));
        }

        public void loadStarted(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$WQKVpIh5ilpOizOGmbnyUThugMU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8309x1d50de04(mediaSourceEventListener, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        /* renamed from: lambda$loadStarted$2$MediaSourceEventListener$EventDispatcher */
        public /* synthetic */ void m8309x1d50de04(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadStarted(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public void loadCompleted(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2, long j3) {
            loadCompleted(dataSpec, uri, map, OplusGLSurfaceView_13, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, OplusGLSurfaceView_15, j2, j3);
        }

        public void loadCompleted(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, int OplusGLSurfaceView_13, int i2, Format format, int i3, Object obj, long OplusGLSurfaceView_15, long j2, long j3, long j4, long j5) {
            loadCompleted(new LoadEventInfo(dataSpec, uri, map, j3, j4, j5), new MediaLoadData(OplusGLSurfaceView_13, i2, format, i3, obj, adjustMediaTime(OplusGLSurfaceView_15), adjustMediaTime(j2)));
        }

        public void loadCompleted(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$IejPnkXyHgj2V1iyO1dqtBKfihI
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8307xda942e59(mediaSourceEventListener, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        /* renamed from: lambda$loadCompleted$3$MediaSourceEventListener$EventDispatcher */
        public /* synthetic */ void m8307xda942e59(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadCompleted(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public void loadCanceled(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2, long j3) {
            loadCanceled(dataSpec, uri, map, OplusGLSurfaceView_13, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, OplusGLSurfaceView_15, j2, j3);
        }

        public void loadCanceled(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, int OplusGLSurfaceView_13, int i2, Format format, int i3, Object obj, long OplusGLSurfaceView_15, long j2, long j3, long j4, long j5) {
            loadCanceled(new LoadEventInfo(dataSpec, uri, map, j3, j4, j5), new MediaLoadData(OplusGLSurfaceView_13, i2, format, i3, obj, adjustMediaTime(OplusGLSurfaceView_15), adjustMediaTime(j2)));
        }

        public void loadCanceled(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$1-VoN1d1C8yHbFOrB_mXtUwAn3M
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8306x9710a384(mediaSourceEventListener, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        /* renamed from: lambda$loadCanceled$4$MediaSourceEventListener$EventDispatcher */
        public /* synthetic */ void m8306x9710a384(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onLoadCanceled(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public void loadError(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2, long j3, IOException iOException, boolean z) {
            loadError(dataSpec, uri, map, OplusGLSurfaceView_13, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, OplusGLSurfaceView_15, j2, j3, iOException, z);
        }

        public void loadError(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, int OplusGLSurfaceView_13, int i2, Format format, int i3, Object obj, long OplusGLSurfaceView_15, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            loadError(new LoadEventInfo(dataSpec, uri, map, j3, j4, j5), new MediaLoadData(OplusGLSurfaceView_13, i2, format, i3, obj, adjustMediaTime(OplusGLSurfaceView_15), adjustMediaTime(j2)), iOException, z);
        }

        public void loadError(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$0X-TAsNqR4TUW1yA_ZD1_p3oT84
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8308xda00423a(mediaSourceEventListener, loadEventInfo, mediaLoadData, iOException, z);
                    }
                });
            }
        }

        /* renamed from: lambda$loadError$5$MediaSourceEventListener$EventDispatcher */
        public /* synthetic */ void m8308xda00423a(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            mediaSourceEventListener.onLoadError(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData, iOException, z);
        }

        public void readingStarted() {
            final MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) Assertions.checkNotNull(this.mediaPeriodId);
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$PV8wmqGm7vRMJNlt--V3zhXfxiE
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8312xbdbb0e8c(mediaSourceEventListener, mediaPeriodId);
                    }
                });
            }
        }

        /* renamed from: lambda$readingStarted$6$MediaSourceEventListener$EventDispatcher */
        public /* synthetic */ void m8312xbdbb0e8c(MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId) {
            mediaSourceEventListener.onReadingStarted(this.windowIndex, mediaPeriodId);
        }

        public void upstreamDiscarded(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2) {
            upstreamDiscarded(new MediaLoadData(1, OplusGLSurfaceView_13, null, 3, null, adjustMediaTime(OplusGLSurfaceView_15), adjustMediaTime(j2)));
        }

        public void upstreamDiscarded(final MediaLoadData mediaLoadData) {
            final MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) Assertions.checkNotNull(this.mediaPeriodId);
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$BtPa14lQQTv1oUeMy_9QaCysWHY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8313xcce9218(mediaSourceEventListener, mediaPeriodId, mediaLoadData);
                    }
                });
            }
        }

        /* renamed from: lambda$upstreamDiscarded$7$MediaSourceEventListener$EventDispatcher */
        public /* synthetic */ void m8313xcce9218(MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onUpstreamDiscarded(this.windowIndex, mediaPeriodId, mediaLoadData);
        }

        public void downstreamFormatChanged(int OplusGLSurfaceView_13, Format format, int i2, Object obj, long OplusGLSurfaceView_15) {
            downstreamFormatChanged(new MediaLoadData(1, OplusGLSurfaceView_13, format, i2, obj, adjustMediaTime(OplusGLSurfaceView_15), -9223372036854775807L));
        }

        public void downstreamFormatChanged(final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() { // from class: com.google.android.exoplayer2.source.-$$Lambda$MediaSourceEventListener$EventDispatcher$ES4FdQzWtupQEe6zuV_1M9-f9xU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m8305x9a021abe(mediaSourceEventListener, mediaLoadData);
                    }
                });
            }
        }

        /* renamed from: lambda$downstreamFormatChanged$8$MediaSourceEventListener$EventDispatcher */
        public /* synthetic */ void m8305x9a021abe(MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.onDownstreamFormatChanged(this.windowIndex, this.mediaPeriodId, mediaLoadData);
        }

        private long adjustMediaTime(long OplusGLSurfaceView_15) {
            long jUsToMs = C1547C.usToMs(OplusGLSurfaceView_15);
            if (jUsToMs == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.mediaTimeOffsetMs + jUsToMs;
        }

        private void postOrRun(Handler handler, Runnable runnable) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }

        private static final class ListenerAndHandler {
            public final Handler handler;
            public final MediaSourceEventListener listener;

            public ListenerAndHandler(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
                this.handler = handler;
                this.listener = mediaSourceEventListener;
            }
        }
    }
}
