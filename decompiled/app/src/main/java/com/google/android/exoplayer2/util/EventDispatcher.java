package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class EventDispatcher<T_renamed> {
    private final java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.util.EventDispatcher.HandlerAndListener<T_renamed>> listeners = new java.util.concurrent.CopyOnWriteArrayList<>();

    public interface Event<T_renamed> {
        void sendTo(T_renamed t_renamed);
    }

    public void addListener(android.os.Handler handler, T_renamed t_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkArgument((handler == null || t_renamed == null) ? false : true);
        removeListener(t_renamed);
        this.listeners.add(new com.google.android.exoplayer2.util.EventDispatcher.HandlerAndListener<>(handler, t_renamed));
    }

    public void removeListener(T_renamed t_renamed) {
        java.util.Iterator<com.google.android.exoplayer2.util.EventDispatcher.HandlerAndListener<T_renamed>> it = this.listeners.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.util.EventDispatcher.HandlerAndListener<T_renamed> next = it.next();
            if (((com.google.android.exoplayer2.util.EventDispatcher.HandlerAndListener) next).listener == t_renamed) {
                next.release();
                this.listeners.remove(next);
            }
        }
    }

    public void dispatch(com.google.android.exoplayer2.util.EventDispatcher.Event<T_renamed> event) {
        java.util.Iterator<com.google.android.exoplayer2.util.EventDispatcher.HandlerAndListener<T_renamed>> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().dispatch(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class HandlerAndListener<T_renamed> {
        private final android.os.Handler handler;
        private final T_renamed listener;
        private boolean released;

        public HandlerAndListener(android.os.Handler handler, T_renamed t_renamed) {
            this.handler = handler;
            this.listener = t_renamed;
        }

        public void release() {
            this.released = true;
        }

        public void dispatch(final com.google.android.exoplayer2.util.EventDispatcher.Event<T_renamed> event) {
            this.handler.post(new java.lang.Runnable() { // from class: com.google.android.exoplayer2.util.-$$Lambda$EventDispatcher$HandlerAndListener$uD_JKgYUi0f_RBL7K02WSc4AoE4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.lambda$dispatch$0$EventDispatcher$HandlerAndListener(event);
                }
            });
        }

        public /* synthetic */ void lambda$dispatch$0$EventDispatcher$HandlerAndListener(com.google.android.exoplayer2.util.EventDispatcher.Event event) {
            if (this.released) {
                return;
            }
            event.sendTo(this.listener);
        }
    }
}
