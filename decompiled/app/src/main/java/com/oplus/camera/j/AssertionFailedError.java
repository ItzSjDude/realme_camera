package com.oplus.camera.j_renamed;

/* compiled from: VideoViewPagerAdapter.java */
/* loaded from: classes2.dex */
public class b_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.oplus.camera.j_renamed.b_renamed.VideoViewPagerAdapter_3> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int[] f4768a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.net.Uri[] f4769b;
    private android.content.Context d_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Bitmap f4770c = null;
    private int e_renamed = -1;
    private int f_renamed = 1;
    private com.oplus.camera.doubleexposure.DoubleExposureVideoView.a_renamed g_renamed = null;

    public b_renamed(android.content.Context context, int[] iArr, android.net.Uri[] uriArr) {
        this.f4768a = null;
        this.f4769b = null;
        this.d_renamed = null;
        this.f4768a = iArr;
        this.f4769b = uriArr;
        this.d_renamed = context;
    }

    public void a_renamed(com.oplus.camera.doubleexposure.DoubleExposureVideoView.a_renamed aVar) {
        this.g_renamed = aVar;
        android.net.Uri[] uriArr = this.f4769b;
        if (uriArr.length > 0) {
            com.oplus.camera.util.Util.a_renamed(new com.oplus.camera.j_renamed.b_renamed.a_renamed(this.d_renamed, uriArr[0], this.g_renamed));
        }
    }

    public void a_renamed(int i_renamed) {
        this.e_renamed = i_renamed;
    }

    public int a_renamed() {
        return this.e_renamed;
    }

    public void a_renamed(android.graphics.Bitmap bitmap) {
        this.f4770c = bitmap;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.camera.j_renamed.b_renamed.VideoViewPagerAdapter_3 onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        com.oplus.camera.j_renamed.b_renamed.VideoViewPagerAdapter_3 c0105b = new com.oplus.camera.j_renamed.b_renamed.VideoViewPagerAdapter_3(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.oplus.camera.R_renamed.layout.common_bottom_double_exposure_layout, viewGroup, false));
        c0105b.setIsRecyclable(false);
        return c0105b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final com.oplus.camera.j_renamed.b_renamed.VideoViewPagerAdapter_3 c0105b, int i_renamed) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        c0105b.f4778c.setText(this.f4768a[i_renamed]);
        c0105b.f4778c.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() { // from class: com.oplus.camera.j_renamed.b_renamed.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (c0105b.f4778c.getLineCount() <= 0) {
                    return false;
                }
                c0105b.f4778c.getViewTreeObserver().removeOnPreDrawListener(this);
                com.oplus.camera.j_renamed.b_renamed.this.f_renamed = java.lang.Math.max(c0105b.f4778c.getLineCount(), com.oplus.camera.j_renamed.b_renamed.this.f_renamed);
                c0105b.f4778c.setMaxLines(java.lang.Math.min(com.oplus.camera.j_renamed.b_renamed.this.f_renamed, 3));
                c0105b.f4778c.setMinLines(java.lang.Math.min(com.oplus.camera.j_renamed.b_renamed.this.f_renamed, 3));
                return false;
            }
        });
        if (i_renamed == 0) {
            c0105b.f4777b.setVideoThumb(this.f4770c);
        }
        if (c0105b.f4777b.getVideoUri() == null) {
            c0105b.f4777b.setVideoUri(this.f4769b[i_renamed]);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        return this.f4768a.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoViewPagerAdapter.java */
    static class a_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        private android.content.Context f4773a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.net.Uri f4774b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private com.oplus.camera.doubleexposure.DoubleExposureVideoView.a_renamed f4775c;

        public a_renamed(android.content.Context context, android.net.Uri uri, com.oplus.camera.doubleexposure.DoubleExposureVideoView.a_renamed aVar) {
            this.f4773a = null;
            this.f4774b = null;
            this.f4775c = null;
            this.f4773a = context;
            this.f4774b = uri;
            this.f4775c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() throws java.lang.SecurityException, java.io.IOException, java.lang.IllegalArgumentException {
            android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f4773a, this.f4774b);
            try {
                try {
                    final android.graphics.Bitmap frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(2);
                    if (frameAtIndex != null && this.f4775c != null) {
                        com.oplus.camera.util.Util.ay_renamed().post(new java.lang.Runnable() { // from class: com.oplus.camera.j_renamed.-$$Lambda$b_renamed$a_renamed$p_renamed-1p6wpfZXSolGDLDRVA0EibjdM
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f_renamed$0.a_renamed(frameAtIndex);
                            }
                        });
                    }
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                    com.oplus.camera.e_renamed.f_renamed("VideoViewPagerAdapter", "LoadThumbTask error " + e_renamed.toString());
                }
            } finally {
                mediaMetadataRetriever.close();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a_renamed(android.graphics.Bitmap bitmap) {
            this.f4775c.a_renamed(bitmap);
        }
    }

    /* compiled from: VideoViewPagerAdapter.java */
    /* renamed from: com.oplus.camera.j_renamed.b_renamed$b_renamed, reason: collision with other inner class name */
    public final class VideoViewPagerAdapter_3 extends androidx.recyclerview.widget.RecyclerView.w_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private com.oplus.camera.doubleexposure.DoubleExposureVideoView f4777b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private androidx.appcompat.widget.AppCompatTextView f4778c;

        public VideoViewPagerAdapter_3(android.view.View view) {
            super(view);
            this.f4777b = null;
            this.f4778c = null;
            this.f4778c = (androidx.appcompat.widget.AppCompatTextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.double_exposure_text);
            this.f4777b = (com.oplus.camera.doubleexposure.DoubleExposureVideoView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.videoView);
        }
    }
}
