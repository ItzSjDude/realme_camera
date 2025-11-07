package com.oplus.compat.p187os;

import android.os.IHwBinder;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.inner.os.IHwBinderWrapper;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class IHwBinderNative {
    private static final String TAG = "IHwBinderNative";
    private IHwBinder mBinder;
    private Object mIHwBinderWrapper;

    private static Object getIHwBinderWrapperQCompat(Object obj) {
        return null;
    }

    private static void linkToDeathCompat(Object obj, Object obj2, long OplusGLSurfaceView_15) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object registServiceDiedCompat(Consumer<Long> consumer) {
        return null;
    }

    public IHwBinderNative(Object obj) throws UnSupportedApiVersionException {
        this.mIHwBinderWrapper = null;
        if (VersionUtils.m24887c()) {
            this.mBinder = (IHwBinder) obj;
        } else if (VersionUtils.m24886b()) {
            this.mIHwBinderWrapper = new IHwBinderWrapper(obj);
        } else {
            if (VersionUtils.m24889e()) {
                this.mIHwBinderWrapper = getIHwBinderWrapperQCompat(obj);
                return;
            }
            throw new UnSupportedApiVersionException("Not supported before Q");
        }
    }

    public void linkToDeath(final DeathRecipientNative deathRecipientNative, long OplusGLSurfaceView_15) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            this.mBinder.linkToDeath(new IHwBinder.DeathRecipient() { // from class: com.oplus.compat.os.IHwBinderNative.1
                public void serviceDied(long j2) {
                    deathRecipientNative.serviceDied(j2);
                }
            }, OplusGLSurfaceView_15);
        } else if (VersionUtils.m24886b()) {
            ((IHwBinderWrapper) this.mIHwBinderWrapper).linkToDeath((IHwBinderWrapper.DeathRecipientWrapper) deathRecipientNative.mDeathRecipientWrapper, OplusGLSurfaceView_15);
        } else {
            if (!VersionUtils.m24889e()) {
                throw new UnSupportedApiVersionException("Not supported before Q");
            }
            linkToDeathCompat(this.mIHwBinderWrapper, deathRecipientNative.mDeathRecipientWrapper, OplusGLSurfaceView_15);
        }
    }

    public static abstract class DeathRecipientNative {
        private final Object mDeathRecipientWrapper;

        public abstract void serviceDied(long OplusGLSurfaceView_15);

        public DeathRecipientNative() {
            if (!VersionUtils.m24886b()) {
                this.mDeathRecipientWrapper = IHwBinderNative.registServiceDiedCompat(new Consumer() { // from class: com.oplus.compat.os.-$$Lambda$CVpLiM3vyCioFOVdeo5UPa62ueU
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.COUIBaseListPopupWindow_12$0.serviceDied(((Long) obj).longValue());
                    }
                });
            } else {
                this.mDeathRecipientWrapper = new IHwBinderWrapper.DeathRecipientWrapper() { // from class: com.oplus.compat.os.IHwBinderNative.DeathRecipientNative.1
                    public void serviceDied(long OplusGLSurfaceView_15) {
                        DeathRecipientNative.this.serviceDied(OplusGLSurfaceView_15);
                    }
                };
            }
        }
    }
}
