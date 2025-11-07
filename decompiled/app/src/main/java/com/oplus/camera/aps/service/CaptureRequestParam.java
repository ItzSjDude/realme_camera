package com.oplus.camera.aps.service;

import com.oplus.camera.CameraManager;
import com.oplus.camera.p136a.PictureTakenCallback;
import com.oplus.camera.p136a.SuperTextResultProcessor;
import com.oplus.camera.p172ui.control.Thumbnail;

/* loaded from: classes2.dex */
public class CaptureRequestParam {
    public boolean mbSuperTextOpen = false;
    public SuperTextResultProcessor mSuperTextResultProcessor = null;
    public PictureTakenCallback mPictureTakenCallback = null;
    public Thumbnail.PlatformImplementations.kt_3 mBurstShotThumbnailCallBack = null;
    public int mThumbWidth = 0;
    public int mCaptureOrientation = 0;
    public CameraManager.C2573a mApsServiceListener = null;
}
