package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class IHwBinderNative {
    private static final java.lang.String TAG = "IHwBinderNative";
    private android.os.IHwBinder mBinder;
    private java.lang.Object mIHwBinderWrapper;

    private static java.lang.Object getIHwBinderWrapperQCompat(java.lang.Object obj) {
        return null;
    }

    private static void linkToDeathCompat(java.lang.Object obj, java.lang.Object obj2, long j_renamed) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Object registServiceDiedCompat(java.util.function.Consumer<java.lang.Long> consumer) {
        return null;
    }

    public IHwBinderNative(java.lang.Object obj) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        this.mIHwBinderWrapper = null;
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            this.mBinder = (android.os.IHwBinder) obj;
        } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            this.mIHwBinderWrapper = new com.oplus.inner.os.IHwBinderWrapper(obj);
        } else {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                this.mIHwBinderWrapper = getIHwBinderWrapperQCompat(obj);
                return;
            }
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before Q_renamed");
        }
    }

    public void linkToDeath(final com.oplus.compat.os.IHwBinderNative.DeathRecipientNative deathRecipientNative, long j_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            this.mBinder.linkToDeath(new android.os.IHwBinder.DeathRecipient() { // from class: com.oplus.compat.os.IHwBinderNative.1
                public void serviceDied(long j2) {
                    deathRecipientNative.serviceDied(j2);
                }
            }, j_renamed);
        } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            ((com.oplus.inner.os.IHwBinderWrapper) this.mIHwBinderWrapper).linkToDeath((com.oplus.inner.os.IHwBinderWrapper.DeathRecipientWrapper) deathRecipientNative.mDeathRecipientWrapper, j_renamed);
        } else {
            if (!com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before Q_renamed");
            }
            linkToDeathCompat(this.mIHwBinderWrapper, deathRecipientNative.mDeathRecipientWrapper, j_renamed);
        }
    }

    public static abstract class DeathRecipientNative {
        private final java.lang.Object mDeathRecipientWrapper;

        public abstract void serviceDied(long j_renamed);

        public DeathRecipientNative() {
            if (!com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
                this.mDeathRecipientWrapper = com.oplus.compat.os.IHwBinderNative.registServiceDiedCompat(new java.util.function.Consumer() { // from class: com.oplus.compat.os.-$$Lambda$CVpLiM3vyCioFOVdeo5UPa62ueU
                    @Override // java.util.function.Consumer
                    public final void accept(java.lang.Object obj) {
                        this.f_renamed$0.serviceDied(((java.lang.Long) obj).longValue());
                    }
                });
            } else {
                this.mDeathRecipientWrapper = new com.oplus.inner.os.IHwBinderWrapper.DeathRecipientWrapper() { // from class: com.oplus.compat.os.IHwBinderNative.DeathRecipientNative.1
                    public void serviceDied(long j_renamed) {
                        com.oplus.compat.os.IHwBinderNative.DeathRecipientNative.this.serviceDied(j_renamed);
                    }
                };
            }
        }
    }
}
