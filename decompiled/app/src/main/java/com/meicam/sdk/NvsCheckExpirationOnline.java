package com.meicam.sdk;

import android.content.Context;
import android.os.Handler;

/* loaded from: classes2.dex */
public class NvsCheckExpirationOnline {
    private static final String TAG = "Meicam";
    private static NvsCheckExpirationOnline m_checker;
    private Context mContext = null;
    private Handler mHandler = null;
    private Thread mThread = null;

    private void checkExpiration() {
    }

    public void startCheck() {
    }

    public static NvsCheckExpirationOnline init(Context context) {
        return m_checker;
    }

    public static NvsCheckExpirationOnline instance() {
        return m_checker;
    }

    private NvsCheckExpirationOnline(Context context) {
    }

    public void release() {
        if (m_checker == null) {
            return;
        }
        this.mContext = null;
        m_checker = null;
    }
}
