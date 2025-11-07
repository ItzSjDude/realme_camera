package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsCheckExpirationOnline {
    private static final java.lang.String TAG = "Meicam";
    private static com.meicam.sdk.NvsCheckExpirationOnline m_checker;
    private android.content.Context mContext = null;
    private android.os.Handler mHandler = null;
    private java.lang.Thread mThread = null;

    private void checkExpiration() {
    }

    public void startCheck() {
    }

    public static com.meicam.sdk.NvsCheckExpirationOnline init(android.content.Context context) {
        return m_checker;
    }

    public static com.meicam.sdk.NvsCheckExpirationOnline instance() {
        return m_checker;
    }

    private NvsCheckExpirationOnline(android.content.Context context) {
    }

    public void release() {
        if (m_checker == null) {
            return;
        }
        this.mContext = null;
        m_checker = null;
    }
}
