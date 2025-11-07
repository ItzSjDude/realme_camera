package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public class ConcatenatingMediaSource extends com.google.android.exoplayer2.source.CompositeMediaSource<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> {
    private static final int MSG_ADD = 0;
    private static final int MSG_MOVE = 2;
    private static final int MSG_ON_COMPLETION = 5;
    private static final int MSG_REMOVE = 1;
    private static final int MSG_SET_SHUFFLE_ORDER = 3;
    private static final int MSG_UPDATE_TIMELINE = 4;
    private final boolean isAtomic;
    private final java.util.Map<com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> mediaSourceByMediaPeriod;
    private final java.util.Map<java.lang.Object, com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> mediaSourceByUid;
    private final java.util.List<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> mediaSourceHolders;
    private final java.util.List<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> mediaSourcesPublic;
    private java.util.Set<com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable> nextTimelineUpdateOnCompletionActions;
    private final java.util.Set<com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable> pendingOnCompletionActions;
    private final com.google.android.exoplayer2.Timeline.Period period;
    private int periodCount;
    private android.os.Handler playbackThreadHandler;
    private com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder;
    private boolean timelineUpdateScheduled;
    private final boolean useLazyPreparation;
    private final com.google.android.exoplayer2.Timeline.Window window;
    private int windowCount;

    @Override // com.google.android.exoplayer2.source.MediaSource
    public java.lang.Object getTag() {
        return null;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
    }

    public ConcatenatingMediaSource(com.google.android.exoplayer2.source.MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    public ConcatenatingMediaSource(boolean z_renamed, com.google.android.exoplayer2.source.MediaSource... mediaSourceArr) {
        this(z_renamed, new com.google.android.exoplayer2.source.ShuffleOrder.DefaultShuffleOrder(0), mediaSourceArr);
    }

    public ConcatenatingMediaSource(boolean z_renamed, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder, com.google.android.exoplayer2.source.MediaSource... mediaSourceArr) {
        this(z_renamed, false, shuffleOrder, mediaSourceArr);
    }

    public ConcatenatingMediaSource(boolean z_renamed, boolean z2, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder, com.google.android.exoplayer2.source.MediaSource... mediaSourceArr) {
        for (com.google.android.exoplayer2.source.MediaSource mediaSource : mediaSourceArr) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaSource);
        }
        this.shuffleOrder = shuffleOrder.getLength() > 0 ? shuffleOrder.cloneAndClear() : shuffleOrder;
        this.mediaSourceByMediaPeriod = new java.util.IdentityHashMap();
        this.mediaSourceByUid = new java.util.HashMap();
        this.mediaSourcesPublic = new java.util.ArrayList();
        this.mediaSourceHolders = new java.util.ArrayList();
        this.nextTimelineUpdateOnCompletionActions = new java.util.HashSet();
        this.pendingOnCompletionActions = new java.util.HashSet();
        this.isAtomic = z_renamed;
        this.useLazyPreparation = z2;
        this.window = new com.google.android.exoplayer2.Timeline.Window();
        this.period = new com.google.android.exoplayer2.Timeline.Period();
        addMediaSources(java.util.Arrays.asList(mediaSourceArr));
    }

    public final synchronized void addMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource) {
        addMediaSource(this.mediaSourcesPublic.size(), mediaSource);
    }

    public final synchronized void addMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, android.os.Handler handler, java.lang.Runnable runnable) {
        addMediaSource(this.mediaSourcesPublic.size(), mediaSource, handler, runnable);
    }

    public final synchronized void addMediaSource(int i_renamed, com.google.android.exoplayer2.source.MediaSource mediaSource) {
        addPublicMediaSources(i_renamed, java.util.Collections.singletonList(mediaSource), null, null);
    }

    public final synchronized void addMediaSource(int i_renamed, com.google.android.exoplayer2.source.MediaSource mediaSource, android.os.Handler handler, java.lang.Runnable runnable) {
        addPublicMediaSources(i_renamed, java.util.Collections.singletonList(mediaSource), handler, runnable);
    }

    public final synchronized void addMediaSources(java.util.Collection<com.google.android.exoplayer2.source.MediaSource> collection) {
        addPublicMediaSources(this.mediaSourcesPublic.size(), collection, null, null);
    }

    public final synchronized void addMediaSources(java.util.Collection<com.google.android.exoplayer2.source.MediaSource> collection, android.os.Handler handler, java.lang.Runnable runnable) {
        addPublicMediaSources(this.mediaSourcesPublic.size(), collection, handler, runnable);
    }

    public final synchronized void addMediaSources(int i_renamed, java.util.Collection<com.google.android.exoplayer2.source.MediaSource> collection) {
        addPublicMediaSources(i_renamed, collection, null, null);
    }

    public final synchronized void addMediaSources(int i_renamed, java.util.Collection<com.google.android.exoplayer2.source.MediaSource> collection, android.os.Handler handler, java.lang.Runnable runnable) {
        addPublicMediaSources(i_renamed, collection, handler, runnable);
    }

    public final synchronized void removeMediaSource(int i_renamed) {
        removePublicMediaSources(i_renamed, i_renamed + 1, null, null);
    }

    public final synchronized void removeMediaSource(int i_renamed, android.os.Handler handler, java.lang.Runnable runnable) {
        removePublicMediaSources(i_renamed, i_renamed + 1, handler, runnable);
    }

    public final synchronized void removeMediaSourceRange(int i_renamed, int i2) {
        removePublicMediaSources(i_renamed, i2, null, null);
    }

    public final synchronized void removeMediaSourceRange(int i_renamed, int i2, android.os.Handler handler, java.lang.Runnable runnable) {
        removePublicMediaSources(i_renamed, i2, handler, runnable);
    }

    public final synchronized void moveMediaSource(int i_renamed, int i2) {
        movePublicMediaSource(i_renamed, i2, null, null);
    }

    public final synchronized void moveMediaSource(int i_renamed, int i2, android.os.Handler handler, java.lang.Runnable runnable) {
        movePublicMediaSource(i_renamed, i2, handler, runnable);
    }

    public final synchronized void clear() {
        removeMediaSourceRange(0, getSize());
    }

    public final synchronized void clear(android.os.Handler handler, java.lang.Runnable runnable) {
        removeMediaSourceRange(0, getSize(), handler, runnable);
    }

    public final synchronized int getSize() {
        return this.mediaSourcesPublic.size();
    }

    public final synchronized com.google.android.exoplayer2.source.MediaSource getMediaSource(int i_renamed) {
        return this.mediaSourcesPublic.get(i_renamed).mediaSource;
    }

    public final synchronized void setShuffleOrder(com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        setPublicShuffleOrder(shuffleOrder, null, null);
    }

    public final synchronized void setShuffleOrder(com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder, android.os.Handler handler, java.lang.Runnable runnable) {
        setPublicShuffleOrder(shuffleOrder, handler, runnable);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public final synchronized void prepareSourceInternal(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        this.playbackThreadHandler = new android.os.Handler(new android.os.Handler.Callback() { // from class: com.google.android.exoplayer2.source.-$$Lambda$ConcatenatingMediaSource$fl0myfoK2raBckmHYwV9YTd0eeo
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(android.os.Message message) {
                return this.f_renamed$0.handleMessage(message);
            }
        });
        if (this.mediaSourcesPublic.isEmpty()) {
            updateTimelineAndScheduleOnCompletionActions();
        } else {
            this.shuffleOrder = this.shuffleOrder.cloneAndInsert(0, this.mediaSourcesPublic.size());
            addMediaSourcesInternal(0, this.mediaSourcesPublic);
            scheduleTimelineUpdate();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed) {
        com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder = this.mediaSourceByUid.get(getMediaSourceHolderUid(mediaPeriodId.periodUid));
        if (mediaSourceHolder == null) {
            mediaSourceHolder = new com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder(new com.google.android.exoplayer2.source.ConcatenatingMediaSource.DummyMediaSource());
            mediaSourceHolder.hasStartedPreparing = true;
        }
        com.google.android.exoplayer2.source.DeferredMediaPeriod deferredMediaPeriod = new com.google.android.exoplayer2.source.DeferredMediaPeriod(mediaSourceHolder.mediaSource, mediaPeriodId, allocator, j_renamed);
        this.mediaSourceByMediaPeriod.put(deferredMediaPeriod, mediaSourceHolder);
        mediaSourceHolder.activeMediaPeriods.add(deferredMediaPeriod);
        if (!mediaSourceHolder.hasStartedPreparing) {
            mediaSourceHolder.hasStartedPreparing = true;
            prepareChildSource(mediaSourceHolder, mediaSourceHolder.mediaSource);
        } else if (mediaSourceHolder.isPrepared) {
            deferredMediaPeriod.createPeriod(mediaPeriodId.copyWithPeriodUid(getChildPeriodUid(mediaSourceHolder, mediaPeriodId.periodUid)));
        }
        return deferredMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder = (com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.mediaSourceByMediaPeriod.remove(mediaPeriod));
        ((com.google.android.exoplayer2.source.DeferredMediaPeriod) mediaPeriod).releasePeriod();
        mediaSourceHolder.activeMediaPeriods.remove(mediaPeriod);
        maybeReleaseChildSource(mediaSourceHolder);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public final synchronized void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.mediaSourceHolders.clear();
        this.mediaSourceByUid.clear();
        this.shuffleOrder = this.shuffleOrder.cloneAndClear();
        this.windowCount = 0;
        this.periodCount = 0;
        if (this.playbackThreadHandler != null) {
            this.playbackThreadHandler.removeCallbacksAndMessages(null);
            this.playbackThreadHandler = null;
        }
        this.timelineUpdateScheduled = false;
        this.nextTimelineUpdateOnCompletionActions.clear();
        dispatchOnCompletionActions(this.pendingOnCompletionActions);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in_renamed other method and merged with bridge method [inline-methods] */
    public final void lambda$prepareChildSource$0$CompositeMediaSource(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
        updateMediaSourceInternal(mediaSourceHolder, timeline);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i_renamed = 0; i_renamed < mediaSourceHolder.activeMediaPeriods.size(); i_renamed++) {
            if (mediaSourceHolder.activeMediaPeriods.get(i_renamed).id_renamed.windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return mediaPeriodId.copyWithPeriodUid(getPeriodUid(mediaSourceHolder, mediaPeriodId.periodUid));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public int getWindowIndexForChildWindowIndex(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder, int i_renamed) {
        return i_renamed + mediaSourceHolder.firstWindowIndexInChild;
    }

    private void addPublicMediaSources(int i_renamed, java.util.Collection<com.google.android.exoplayer2.source.MediaSource> collection, android.os.Handler handler, java.lang.Runnable runnable) {
        com.google.android.exoplayer2.util.Assertions.checkArgument((handler == null) == (runnable == null));
        android.os.Handler handler2 = this.playbackThreadHandler;
        java.util.Iterator<com.google.android.exoplayer2.source.MediaSource> it = collection.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(it.next());
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        java.util.Iterator<com.google.android.exoplayer2.source.MediaSource> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(new com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder(it2.next()));
        }
        this.mediaSourcesPublic.addAll(i_renamed, arrayList);
        if (handler2 != null && !collection.isEmpty()) {
            handler2.obtainMessage(0, new com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData(i_renamed, arrayList, createOnCompletionAction(handler, runnable))).sendToTarget();
        } else {
            if (runnable == null || handler == null) {
                return;
            }
            handler.post(runnable);
        }
    }

    private void removePublicMediaSources(int i_renamed, int i2, android.os.Handler handler, java.lang.Runnable runnable) {
        com.google.android.exoplayer2.util.Assertions.checkArgument((handler == null) == (runnable == null));
        android.os.Handler handler2 = this.playbackThreadHandler;
        com.google.android.exoplayer2.util.Util.removeRange(this.mediaSourcesPublic, i_renamed, i2);
        if (handler2 != null) {
            handler2.obtainMessage(1, new com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData(i_renamed, java.lang.Integer.valueOf(i2), createOnCompletionAction(handler, runnable))).sendToTarget();
        } else {
            if (runnable == null || handler == null) {
                return;
            }
            handler.post(runnable);
        }
    }

    private void movePublicMediaSource(int i_renamed, int i2, android.os.Handler handler, java.lang.Runnable runnable) {
        com.google.android.exoplayer2.util.Assertions.checkArgument((handler == null) == (runnable == null));
        android.os.Handler handler2 = this.playbackThreadHandler;
        java.util.List<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> list = this.mediaSourcesPublic;
        list.add(i2, list.remove(i_renamed));
        if (handler2 != null) {
            handler2.obtainMessage(2, new com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData(i_renamed, java.lang.Integer.valueOf(i2), createOnCompletionAction(handler, runnable))).sendToTarget();
        } else {
            if (runnable == null || handler == null) {
                return;
            }
            handler.post(runnable);
        }
    }

    private void setPublicShuffleOrder(com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder, android.os.Handler handler, java.lang.Runnable runnable) {
        com.google.android.exoplayer2.util.Assertions.checkArgument((handler == null) == (runnable == null));
        android.os.Handler handler2 = this.playbackThreadHandler;
        if (handler2 != null) {
            int size = getSize();
            if (shuffleOrder.getLength() != size) {
                shuffleOrder = shuffleOrder.cloneAndClear().cloneAndInsert(0, size);
            }
            handler2.obtainMessage(3, new com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData(0, shuffleOrder, createOnCompletionAction(handler, runnable))).sendToTarget();
            return;
        }
        if (shuffleOrder.getLength() > 0) {
            shuffleOrder = shuffleOrder.cloneAndClear();
        }
        this.shuffleOrder = shuffleOrder;
        if (runnable == null || handler == null) {
            return;
        }
        handler.post(runnable);
    }

    private com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable createOnCompletionAction(android.os.Handler handler, java.lang.Runnable runnable) {
        if (handler == null || runnable == null) {
            return null;
        }
        com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable handlerAndRunnable = new com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable(handler, runnable);
        this.pendingOnCompletionActions.add(handlerAndRunnable);
        return handlerAndRunnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean handleMessage(android.os.Message message) {
        int i_renamed = message.what;
        if (i_renamed == 0) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData messageData = (com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData) com.google.android.exoplayer2.util.Util.castNonNull(message.obj);
            this.shuffleOrder = this.shuffleOrder.cloneAndInsert(messageData.index, ((java.util.Collection) messageData.customData).size());
            addMediaSourcesInternal(messageData.index, (java.util.Collection) messageData.customData);
            scheduleTimelineUpdate(messageData.onCompletionAction);
        } else if (i_renamed == 1) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData messageData2 = (com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData) com.google.android.exoplayer2.util.Util.castNonNull(message.obj);
            int i2 = messageData2.index;
            int iIntValue = ((java.lang.Integer) messageData2.customData).intValue();
            if (i2 == 0 && iIntValue == this.shuffleOrder.getLength()) {
                this.shuffleOrder = this.shuffleOrder.cloneAndClear();
            } else {
                this.shuffleOrder = this.shuffleOrder.cloneAndRemove(i2, iIntValue);
            }
            for (int i3 = iIntValue - 1; i3 >= i2; i3--) {
                removeMediaSourceInternal(i3);
            }
            scheduleTimelineUpdate(messageData2.onCompletionAction);
        } else if (i_renamed == 2) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData messageData3 = (com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData) com.google.android.exoplayer2.util.Util.castNonNull(message.obj);
            this.shuffleOrder = this.shuffleOrder.cloneAndRemove(messageData3.index, messageData3.index + 1);
            this.shuffleOrder = this.shuffleOrder.cloneAndInsert(((java.lang.Integer) messageData3.customData).intValue(), 1);
            moveMediaSourceInternal(messageData3.index, ((java.lang.Integer) messageData3.customData).intValue());
            scheduleTimelineUpdate(messageData3.onCompletionAction);
        } else if (i_renamed == 3) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData messageData4 = (com.google.android.exoplayer2.source.ConcatenatingMediaSource.MessageData) com.google.android.exoplayer2.util.Util.castNonNull(message.obj);
            this.shuffleOrder = (com.google.android.exoplayer2.source.ShuffleOrder) messageData4.customData;
            scheduleTimelineUpdate(messageData4.onCompletionAction);
        } else if (i_renamed == 4) {
            updateTimelineAndScheduleOnCompletionActions();
        } else if (i_renamed == 5) {
            dispatchOnCompletionActions((java.util.Set) com.google.android.exoplayer2.util.Util.castNonNull(message.obj));
        } else {
            throw new java.lang.IllegalStateException();
        }
        return true;
    }

    private void scheduleTimelineUpdate() {
        scheduleTimelineUpdate(null);
    }

    private void scheduleTimelineUpdate(com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable handlerAndRunnable) {
        if (!this.timelineUpdateScheduled) {
            getPlaybackThreadHandlerOnPlaybackThread().obtainMessage(4).sendToTarget();
            this.timelineUpdateScheduled = true;
        }
        if (handlerAndRunnable != null) {
            this.nextTimelineUpdateOnCompletionActions.add(handlerAndRunnable);
        }
    }

    private void updateTimelineAndScheduleOnCompletionActions() {
        this.timelineUpdateScheduled = false;
        java.util.Set<com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable> set = this.nextTimelineUpdateOnCompletionActions;
        this.nextTimelineUpdateOnCompletionActions = new java.util.HashSet();
        refreshSourceInfo(new com.google.android.exoplayer2.source.ConcatenatingMediaSource.ConcatenatedTimeline(this.mediaSourceHolders, this.windowCount, this.periodCount, this.shuffleOrder, this.isAtomic), null);
        getPlaybackThreadHandlerOnPlaybackThread().obtainMessage(5, set).sendToTarget();
    }

    private android.os.Handler getPlaybackThreadHandlerOnPlaybackThread() {
        return (android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.playbackThreadHandler);
    }

    private synchronized void dispatchOnCompletionActions(java.util.Set<com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable> set) {
        java.util.Iterator<com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable> it = set.iterator();
        while (it.hasNext()) {
            it.next().dispatch();
        }
        this.pendingOnCompletionActions.removeAll(set);
    }

    private void addMediaSourcesInternal(int i_renamed, java.util.Collection<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> collection) {
        java.util.Iterator<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> it = collection.iterator();
        while (it.hasNext()) {
            addMediaSourceInternal(i_renamed, it.next());
            i_renamed++;
        }
    }

    private void addMediaSourceInternal(int i_renamed, com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder) {
        if (i_renamed > 0) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder2 = this.mediaSourceHolders.get(i_renamed - 1);
            mediaSourceHolder.reset(i_renamed, mediaSourceHolder2.firstWindowIndexInChild + mediaSourceHolder2.timeline.getWindowCount(), mediaSourceHolder2.firstPeriodIndexInChild + mediaSourceHolder2.timeline.getPeriodCount());
        } else {
            mediaSourceHolder.reset(i_renamed, 0, 0);
        }
        correctOffsets(i_renamed, 1, mediaSourceHolder.timeline.getWindowCount(), mediaSourceHolder.timeline.getPeriodCount());
        this.mediaSourceHolders.add(i_renamed, mediaSourceHolder);
        this.mediaSourceByUid.put(mediaSourceHolder.uid, mediaSourceHolder);
        if (this.useLazyPreparation) {
            return;
        }
        mediaSourceHolder.hasStartedPreparing = true;
        prepareChildSource(mediaSourceHolder, mediaSourceHolder.mediaSource);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateMediaSourceInternal(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder r14, com.google.android.exoplayer2.Timeline r15) {
        /*
            r13 = this;
            if (r14 == 0) goto Lb7
            com.google.android.exoplayer2.source.ConcatenatingMediaSource$DeferredTimeline r0 = r14.timeline
            com.google.android.exoplayer2.Timeline r1 = r0.getTimeline()
            if (r1 != r15) goto Lb
            return
        Lb:
            int r1 = r15.getWindowCount()
            int r2 = r0.getWindowCount()
            int r1 = r1 - r2
            int r2 = r15.getPeriodCount()
            int r3 = r0.getPeriodCount()
            int r2 = r2 - r3
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L23
            if (r2 == 0) goto L29
        L23:
            int r5 = r14.childIndex
            int r5 = r5 + r4
            r13.correctOffsets(r5, r3, r1, r2)
        L29:
            boolean r1 = r14.isPrepared
            if (r1 == 0) goto L35
            com.google.android.exoplayer2.source.ConcatenatingMediaSource$DeferredTimeline r15 = r0.cloneWithUpdatedTimeline(r15)
            r14.timeline = r15
            goto Lb1
        L35:
            boolean r0 = r15.isEmpty()
            if (r0 == 0) goto L47
            java.lang.Object r0 = com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline.access$100()
            com.google.android.exoplayer2.source.ConcatenatingMediaSource$DeferredTimeline r15 = com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline.createWithRealTimeline(r15, r0)
            r14.timeline = r15
            goto Lb1
        L47:
            java.util.List<com.google.android.exoplayer2.source.DeferredMediaPeriod> r0 = r14.activeMediaPeriods
            int r0 = r0.size()
            if (r0 > r4) goto L51
            r0 = r4
            goto L52
        L51:
            r0 = r3
        L52:
            com.google.android.exoplayer2.util.Assertions.checkState(r0)
            java.util.List<com.google.android.exoplayer2.source.DeferredMediaPeriod> r0 = r14.activeMediaPeriods
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L5f
            r0 = 0
            goto L67
        L5f:
            java.util.List<com.google.android.exoplayer2.source.DeferredMediaPeriod> r0 = r14.activeMediaPeriods
            java.lang.Object r0 = r0.get(r3)
            com.google.android.exoplayer2.source.DeferredMediaPeriod r0 = (com.google.android.exoplayer2.source.DeferredMediaPeriod) r0
        L67:
            com.google.android.exoplayer2.Timeline$Window r1 = r13.window
            r15.getWindow(r3, r1)
            com.google.android.exoplayer2.Timeline$Window r1 = r13.window
            long r1 = r1.getDefaultPositionUs()
            if (r0 == 0) goto L80
            long r5 = r0.getPreparePositionUs()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L80
            r11 = r5
            goto L81
        L80:
            r11 = r1
        L81:
            com.google.android.exoplayer2.Timeline$Window r8 = r13.window
            com.google.android.exoplayer2.Timeline$Period r9 = r13.period
            r10 = 0
            r7 = r15
            android.util.Pair r1 = r7.getPeriodPosition(r8, r9, r10, r11)
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r5 = r1.longValue()
            com.google.android.exoplayer2.source.ConcatenatingMediaSource$DeferredTimeline r15 = com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline.createWithRealTimeline(r15, r2)
            r14.timeline = r15
            if (r0 == 0) goto Lb1
            r0.overridePreparePositionUs(r5)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r15 = r0.id_renamed
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r0.id_renamed
            java.lang.Object r1 = r1.periodUid
            java.lang.Object r1 = getChildPeriodUid(r14, r1)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r15 = r15.copyWithPeriodUid(r1)
            r0.createPeriod(r15)
        Lb1:
            r14.isPrepared = r4
            r13.scheduleTimelineUpdate()
            return
        Lb7:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            r13.<init>()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ConcatenatingMediaSource.updateMediaSourceInternal(com.google.android.exoplayer2.source.ConcatenatingMediaSource$MediaSourceHolder, com.google.android.exoplayer2.Timeline):void");
    }

    private void removeMediaSourceInternal(int i_renamed) {
        com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolderRemove = this.mediaSourceHolders.remove(i_renamed);
        this.mediaSourceByUid.remove(mediaSourceHolderRemove.uid);
        com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline deferredTimeline = mediaSourceHolderRemove.timeline;
        correctOffsets(i_renamed, -1, -deferredTimeline.getWindowCount(), -deferredTimeline.getPeriodCount());
        mediaSourceHolderRemove.isRemoved = true;
        maybeReleaseChildSource(mediaSourceHolderRemove);
    }

    private void moveMediaSourceInternal(int i_renamed, int i2) {
        int iMin = java.lang.Math.min(i_renamed, i2);
        int iMax = java.lang.Math.max(i_renamed, i2);
        int windowCount = this.mediaSourceHolders.get(iMin).firstWindowIndexInChild;
        int periodCount = this.mediaSourceHolders.get(iMin).firstPeriodIndexInChild;
        java.util.List<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> list = this.mediaSourceHolders;
        list.add(i2, list.remove(i_renamed));
        while (iMin <= iMax) {
            com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder = this.mediaSourceHolders.get(iMin);
            mediaSourceHolder.firstWindowIndexInChild = windowCount;
            mediaSourceHolder.firstPeriodIndexInChild = periodCount;
            windowCount += mediaSourceHolder.timeline.getWindowCount();
            periodCount += mediaSourceHolder.timeline.getPeriodCount();
            iMin++;
        }
    }

    private void correctOffsets(int i_renamed, int i2, int i3, int i4) {
        this.windowCount += i3;
        this.periodCount += i4;
        while (i_renamed < this.mediaSourceHolders.size()) {
            this.mediaSourceHolders.get(i_renamed).childIndex += i2;
            this.mediaSourceHolders.get(i_renamed).firstWindowIndexInChild += i3;
            this.mediaSourceHolders.get(i_renamed).firstPeriodIndexInChild += i4;
            i_renamed++;
        }
    }

    private void maybeReleaseChildSource(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.isRemoved && mediaSourceHolder.hasStartedPreparing && mediaSourceHolder.activeMediaPeriods.isEmpty()) {
            releaseChildSource(mediaSourceHolder);
        }
    }

    private static java.lang.Object getMediaSourceHolderUid(java.lang.Object obj) {
        return com.google.android.exoplayer2.source.ConcatenatingMediaSource.ConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(obj);
    }

    private static java.lang.Object getChildPeriodUid(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder, java.lang.Object obj) {
        java.lang.Object childPeriodUidFromConcatenatedUid = com.google.android.exoplayer2.source.ConcatenatingMediaSource.ConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(obj);
        return childPeriodUidFromConcatenatedUid.equals(com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline.DUMMY_ID) ? mediaSourceHolder.timeline.replacedId : childPeriodUidFromConcatenatedUid;
    }

    private static java.lang.Object getPeriodUid(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder, java.lang.Object obj) {
        if (mediaSourceHolder.timeline.replacedId.equals(obj)) {
            obj = com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline.DUMMY_ID;
        }
        return com.google.android.exoplayer2.source.ConcatenatingMediaSource.ConcatenatedTimeline.getConcatenatedUid(mediaSourceHolder.uid, obj);
    }

    static final class MediaSourceHolder implements java.lang.Comparable<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> {
        public int childIndex;
        public int firstPeriodIndexInChild;
        public int firstWindowIndexInChild;
        public boolean hasStartedPreparing;
        public boolean isPrepared;
        public boolean isRemoved;
        public final com.google.android.exoplayer2.source.MediaSource mediaSource;
        public com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline timeline;
        public java.util.List<com.google.android.exoplayer2.source.DeferredMediaPeriod> activeMediaPeriods = new java.util.ArrayList();
        public final java.lang.Object uid = new java.lang.Object();

        public MediaSourceHolder(com.google.android.exoplayer2.source.MediaSource mediaSource) {
            this.mediaSource = mediaSource;
            this.timeline = com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline.createWithDummyTimeline(mediaSource.getTag());
        }

        public void reset(int i_renamed, int i2, int i3) {
            this.childIndex = i_renamed;
            this.firstWindowIndexInChild = i2;
            this.firstPeriodIndexInChild = i3;
            this.hasStartedPreparing = false;
            this.isPrepared = false;
            this.isRemoved = false;
            this.activeMediaPeriods.clear();
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder) {
            return this.firstPeriodIndexInChild - mediaSourceHolder.firstPeriodIndexInChild;
        }
    }

    private static final class MessageData<T_renamed> {
        public final T_renamed customData;
        public final int index;
        public final com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable onCompletionAction;

        public MessageData(int i_renamed, T_renamed t_renamed, com.google.android.exoplayer2.source.ConcatenatingMediaSource.HandlerAndRunnable handlerAndRunnable) {
            this.index = i_renamed;
            this.customData = t_renamed;
            this.onCompletionAction = handlerAndRunnable;
        }
    }

    private static final class ConcatenatedTimeline extends com.google.android.exoplayer2.source.AbstractConcatenatedTimeline {
        private final java.util.HashMap<java.lang.Object, java.lang.Integer> childIndexByUid;
        private final int[] firstPeriodInChildIndices;
        private final int[] firstWindowInChildIndices;
        private final int periodCount;
        private final com.google.android.exoplayer2.Timeline[] timelines;
        private final java.lang.Object[] uids;
        private final int windowCount;

        public ConcatenatedTimeline(java.util.Collection<com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder> collection, int i_renamed, int i2, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder, boolean z_renamed) {
            super(z_renamed, shuffleOrder);
            this.windowCount = i_renamed;
            this.periodCount = i2;
            int size = collection.size();
            this.firstPeriodInChildIndices = new int[size];
            this.firstWindowInChildIndices = new int[size];
            this.timelines = new com.google.android.exoplayer2.Timeline[size];
            this.uids = new java.lang.Object[size];
            this.childIndexByUid = new java.util.HashMap<>();
            int i3 = 0;
            for (com.google.android.exoplayer2.source.ConcatenatingMediaSource.MediaSourceHolder mediaSourceHolder : collection) {
                this.timelines[i3] = mediaSourceHolder.timeline;
                this.firstPeriodInChildIndices[i3] = mediaSourceHolder.firstPeriodIndexInChild;
                this.firstWindowInChildIndices[i3] = mediaSourceHolder.firstWindowIndexInChild;
                this.uids[i3] = mediaSourceHolder.uid;
                this.childIndexByUid.put(this.uids[i3], java.lang.Integer.valueOf(i3));
                i3++;
            }
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getChildIndexByPeriodIndex(int i_renamed) {
            return com.google.android.exoplayer2.util.Util.binarySearchFloor(this.firstPeriodInChildIndices, i_renamed + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getChildIndexByWindowIndex(int i_renamed) {
            return com.google.android.exoplayer2.util.Util.binarySearchFloor(this.firstWindowInChildIndices, i_renamed + 1, false, false);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getChildIndexByChildUid(java.lang.Object obj) {
            java.lang.Integer num = this.childIndexByUid.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected com.google.android.exoplayer2.Timeline getTimelineByChildIndex(int i_renamed) {
            return this.timelines[i_renamed];
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getFirstPeriodIndexByChildIndex(int i_renamed) {
            return this.firstPeriodInChildIndices[i_renamed];
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getFirstWindowIndexByChildIndex(int i_renamed) {
            return this.firstWindowInChildIndices[i_renamed];
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected java.lang.Object getChildUidByChildIndex(int i_renamed) {
            return this.uids[i_renamed];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.windowCount;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.periodCount;
        }
    }

    private static final class DeferredTimeline extends com.google.android.exoplayer2.source.ForwardingTimeline {
        private static final java.lang.Object DUMMY_ID = new java.lang.Object();
        private final java.lang.Object replacedId;

        public static com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline createWithDummyTimeline(java.lang.Object obj) {
            return new com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline(new com.google.android.exoplayer2.source.ConcatenatingMediaSource.DummyTimeline(obj), DUMMY_ID);
        }

        public static com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline createWithRealTimeline(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
            return new com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline(timeline, obj);
        }

        private DeferredTimeline(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj) {
            super(timeline);
            this.replacedId = obj;
        }

        public com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline cloneWithUpdatedTimeline(com.google.android.exoplayer2.Timeline timeline) {
            return new com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline(timeline, this.replacedId);
        }

        public com.google.android.exoplayer2.Timeline getTimeline() {
            return this.timeline;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Period getPeriod(int i_renamed, com.google.android.exoplayer2.Timeline.Period period, boolean z_renamed) {
            this.timeline.getPeriod(i_renamed, period, z_renamed);
            if (com.google.android.exoplayer2.util.Util.areEqual(period.uid, this.replacedId)) {
                period.uid = DUMMY_ID;
            }
            return period;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(java.lang.Object obj) {
            com.google.android.exoplayer2.Timeline timeline = this.timeline;
            if (DUMMY_ID.equals(obj)) {
                obj = this.replacedId;
            }
            return timeline.getIndexOfPeriod(obj);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public java.lang.Object getUidOfPeriod(int i_renamed) {
            java.lang.Object uidOfPeriod = this.timeline.getUidOfPeriod(i_renamed);
            return com.google.android.exoplayer2.util.Util.areEqual(uidOfPeriod, this.replacedId) ? DUMMY_ID : uidOfPeriod;
        }
    }

    private static final class DummyTimeline extends com.google.android.exoplayer2.Timeline {
        private final java.lang.Object tag;

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }

        public DummyTimeline(java.lang.Object obj) {
            this.tag = obj;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Window getWindow(int i_renamed, com.google.android.exoplayer2.Timeline.Window window, boolean z_renamed, long j_renamed) {
            return window.set(this.tag, -9223372036854775807L, -9223372036854775807L, false, true, 0L, -9223372036854775807L, 0, 0, 0L);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Period getPeriod(int i_renamed, com.google.android.exoplayer2.Timeline.Period period, boolean z_renamed) {
            return period.set(0, com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline.DUMMY_ID, 0, -9223372036854775807L, 0L);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(java.lang.Object obj) {
            return obj == com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline.DUMMY_ID ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public java.lang.Object getUidOfPeriod(int i_renamed) {
            return com.google.android.exoplayer2.source.ConcatenatingMediaSource.DeferredTimeline.DUMMY_ID;
        }
    }

    private static final class DummyMediaSource extends com.google.android.exoplayer2.source.BaseMediaSource {
        @Override // com.google.android.exoplayer2.source.MediaSource
        public java.lang.Object getTag() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        }

        @Override // com.google.android.exoplayer2.source.BaseMediaSource
        protected void prepareSourceInternal(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        }

        @Override // com.google.android.exoplayer2.source.BaseMediaSource
        protected void releaseSourceInternal() {
        }

        private DummyMediaSource() {
        }

        @Override // com.google.android.exoplayer2.source.MediaSource
        public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j_renamed) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    private static final class HandlerAndRunnable {
        private final android.os.Handler handler;
        private final java.lang.Runnable runnable;

        public HandlerAndRunnable(android.os.Handler handler, java.lang.Runnable runnable) {
            this.handler = handler;
            this.runnable = runnable;
        }

        public void dispatch() {
            this.handler.post(this.runnable);
        }
    }
}
