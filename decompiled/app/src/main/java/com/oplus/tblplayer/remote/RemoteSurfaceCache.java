package com.oplus.tblplayer.remote;

/* loaded from: classes2.dex */
class RemoteSurfaceCache {
    private static final java.lang.String TAG = "RemoteSurfaceCache";
    private final com.oplus.tblplayer.remote.RemoteSurfaceCache.ComponentListener componentListener = new com.oplus.tblplayer.remote.RemoteSurfaceCache.ComponentListener();
    private final com.oplus.tblplayer.remote.RemotePlayerProxy mPlayer;
    private boolean ownsSurface;
    private android.view.Surface surface;
    private android.view.SurfaceHolder surfaceHolder;
    private android.view.TextureView textureView;

    RemoteSurfaceCache(com.oplus.tblplayer.remote.RemotePlayerProxy remotePlayerProxy) {
        this.mPlayer = remotePlayerProxy;
    }

    private final class ComponentListener implements android.view.SurfaceHolder.Callback, android.view.TextureView.SurfaceTextureListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i_renamed, int i2, int i3) {
        }

        private ComponentListener() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
            com.oplus.tblplayer.remote.RemoteSurfaceCache.this.setVideoSurfaceInternal(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
            com.oplus.tblplayer.remote.RemoteSurfaceCache.this.setVideoSurfaceInternal(null, false);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i_renamed, int i2) {
            com.oplus.tblplayer.remote.RemoteSurfaceCache.this.setVideoSurfaceInternal(new android.view.Surface(surfaceTexture), true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
            com.oplus.tblplayer.remote.RemoteSurfaceCache.this.setVideoSurfaceInternal(null, true);
            return true;
        }
    }

    void setVideoSurfaceHolder(android.view.SurfaceHolder surfaceHolder) {
        removeSurfaceCallbacks();
        this.surfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            setVideoSurfaceInternal(null, false);
            return;
        }
        surfaceHolder.addCallback(this.componentListener);
        android.view.Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            surface = null;
        }
        setVideoSurfaceInternal(surface, false);
    }

    void clearVideoSurfaceHolder(android.view.SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null || surfaceHolder != this.surfaceHolder) {
            return;
        }
        setVideoSurfaceHolder(null);
    }

    void setVideoSurfaceView(android.view.SurfaceView surfaceView) {
        setVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    void clearVideoSurfaceView(android.view.SurfaceView surfaceView) {
        clearVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    void setVideoTextureView(android.view.TextureView textureView) {
        removeSurfaceCallbacks();
        this.textureView = textureView;
        if (textureView == null) {
            setVideoSurfaceInternal(null, true);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setVideoTextureView: Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.componentListener);
        android.graphics.SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        setVideoSurfaceInternal(surfaceTexture != null ? new android.view.Surface(surfaceTexture) : null, true);
    }

    void clearVideoTextureView(android.view.TextureView textureView) {
        if (textureView == null || textureView != this.textureView) {
            return;
        }
        setVideoTextureView(null);
    }

    public void clearVideoSurface() {
        setVideoSurface(null);
    }

    public void setVideoSurface(android.view.Surface surface) {
        removeSurfaceCallbacks();
        setVideoSurfaceInternal(surface, false);
    }

    public void clearVideoSurface(android.view.Surface surface) {
        if (surface == null || surface != this.surface) {
            return;
        }
        setVideoSurface(null);
    }

    private void removeSurfaceCallbacks() {
        android.view.TextureView textureView = this.textureView;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.componentListener) {
                com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "removeSurfaceCallbacks: SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener(null);
            }
            this.textureView = null;
        }
        android.view.SurfaceHolder surfaceHolder = this.surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoSurfaceInternal(android.view.Surface surface, boolean z_renamed) {
        if (this.surface != surface) {
            this.mPlayer.updateSurface(surface);
            android.view.Surface surface2 = this.surface;
            if (surface2 != null && this.ownsSurface) {
                surface2.release();
            }
        }
        this.ownsSurface = z_renamed;
        this.surface = surface;
    }

    void refreshSurface() {
        android.view.Surface surface = this.surface;
        if (surface != null) {
            this.mPlayer.updateSurface(surface);
        }
    }

    void release() {
        if (!this.ownsSurface || this.surface == null) {
            return;
        }
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "release: ");
        this.surface.release();
    }
}
