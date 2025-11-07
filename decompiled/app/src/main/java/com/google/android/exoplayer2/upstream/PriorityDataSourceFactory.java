package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class PriorityDataSourceFactory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
    private final int priority;
    private final com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager;
    private final com.google.android.exoplayer2.upstream.DataSource.Factory upstreamFactory;

    public PriorityDataSourceFactory(com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager, int i_renamed) {
        this.upstreamFactory = factory;
        this.priorityTaskManager = priorityTaskManager;
        this.priority = i_renamed;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public com.google.android.exoplayer2.upstream.PriorityDataSource createDataSource() {
        return new com.google.android.exoplayer2.upstream.PriorityDataSource(this.upstreamFactory.createDataSource(), this.priorityTaskManager, this.priority);
    }
}
