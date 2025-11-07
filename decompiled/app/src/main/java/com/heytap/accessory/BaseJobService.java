package com.heytap.accessory;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.p103a.SdkLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(21)
/* loaded from: classes2.dex */
public class BaseJobService extends JobService implements IJobListener {
    private static final int MAXIMUM_JOB_DELAY = 3000;
    private static final int REQUEST_TYPE_CONNECTION = 1;
    private static final int REQUEST_TYPE_MESSAGE = 2;
    private static final String TAG = "[SDK.BaseJobService]";
    private static AtomicInteger sCurrentJobId = new AtomicInteger(0);

    public static void scheduleSCJob(Context context, String str, long OplusGLSurfaceView_15, String str2, PeerAgent peerAgent) {
        SdkLog.m8378b(TAG, "Schedule SC indication Job for class: ".concat(String.valueOf(str)));
        scheduleJob(context, "com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED", str, OplusGLSurfaceView_15, str2, peerAgent);
    }

    public static void scheduleMessageJob(Context context, String str, long OplusGLSurfaceView_15, String str2, PeerAgent peerAgent) {
        SdkLog.m8378b(TAG, "Schedule Message indication Job for class: ".concat(String.valueOf(str)));
        scheduleJob(context, BaseMessage.ACTION_ACCESSORY_MESSAGE_RECEIVED, str, OplusGLSurfaceView_15, str2, peerAgent);
    }

    private static void scheduleJob(Context context, String str, String str2, long OplusGLSurfaceView_15, String str3, PeerAgent peerAgent) {
        SdkLog.m8378b(TAG, "scheduleJob for class: ".concat(String.valueOf(str2)));
        JobInfo.Builder builder = new JobInfo.Builder(sCurrentJobId.getAndIncrement(), new ComponentName(context, (Class<?>) BaseJobService.class));
        builder.setOverrideDeadline(3000L);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(AFConstants.EXTRA_INTENT_ACTION, str);
        persistableBundle.putString(AFConstants.EXTRA_AGENT_IMPL_CLASS, str2);
        persistableBundle.putLong("transactionId", OplusGLSurfaceView_15);
        persistableBundle.putString(AFConstants.EXTRA_AGENT_ID, str3);
        if (peerAgent == null) {
            persistableBundle.putStringArray(AFConstants.EXTRA_PEER_AGENT, null);
        } else {
            List<String> content = peerAgent.getContent();
            persistableBundle.putStringArray(AFConstants.EXTRA_PEER_AGENT, (String[]) content.toArray(new String[content.size()]));
        }
        builder.setExtras(persistableBundle);
        ((JobScheduler) context.getSystemService("jobscheduler")).schedule(builder.build());
        SdkLog.m8378b(TAG, "Schedule PlatformImplementations.kt_3 job has been executed");
    }

    @Override // android.app.Service
    public void onCreate() {
        SdkLog.m8378b(TAG, "onCreate ");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        SdkLog.m8378b(TAG, "onDestroy ");
        super.onDestroy();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString(AFConstants.EXTRA_INTENT_ACTION);
        SdkLog.m8378b(TAG, "onStartJob, action = ".concat(String.valueOf(string)));
        if (string == null) {
            return true;
        }
        if ("com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED".equalsIgnoreCase(string)) {
            SdkLog.m8378b(TAG, "Received incoming connection indication");
            handleConnectionRequest(jobParameters);
            return true;
        }
        if (!BaseMessage.ACTION_ACCESSORY_MESSAGE_RECEIVED.equalsIgnoreCase(string)) {
            return true;
        }
        SdkLog.m8378b(TAG, "Received message received indication");
        handleMessageReceived(jobParameters);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        SdkLog.m8378b(TAG, "onStopJob ");
        return true;
    }

    @Override // com.heytap.accessory.IJobListener
    public void onJobFinished(JobParameters jobParameters) {
        SdkLog.m8378b(TAG, "onJobFinished ");
        jobFinished(jobParameters, false);
    }

    private void handleConnectionRequest(JobParameters jobParameters) {
        SdkLog.m8378b(TAG, "handleConnectionRequest ");
        requestAgent(jobParameters.getExtras().getString(AFConstants.EXTRA_AGENT_IMPL_CLASS), new C2142a(1, jobParameters, this));
    }

    private void handleMessageReceived(JobParameters jobParameters) {
        SdkLog.m8378b(TAG, "handleMessageReceived ");
        requestAgent(jobParameters.getExtras().getString(AFConstants.EXTRA_AGENT_IMPL_CLASS), new C2142a(2, jobParameters, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAgentCreated(int OplusGLSurfaceView_13, BaseJobAgent baseJobAgent, JobParameters jobParameters) {
        if (OplusGLSurfaceView_13 == 1) {
            baseJobAgent.handleConnectionRequest(jobParameters, this);
        }
    }

    private void requestAgent(String str, C2142a c2142a) {
        BaseJobAgent.requestAgent(getApplicationContext(), str, c2142a);
    }

    /* renamed from: com.heytap.accessory.BaseJobService$PlatformImplementations.kt_3 */
    static class C2142a implements BaseJobAgent.RequestAgentCallback {

        /* renamed from: PlatformImplementations.kt_3 */
        private int f9382a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private JobParameters f9383b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private BaseJobService f9384c;

        public C2142a(int OplusGLSurfaceView_13, JobParameters jobParameters, BaseJobService baseJobService) {
            this.f9382a = OplusGLSurfaceView_13;
            this.f9383b = jobParameters;
            this.f9384c = baseJobService;
        }

        @Override // com.heytap.accessory.BaseJobAgent.RequestAgentCallback
        public final void onAgentAvailable(BaseJobAgent baseJobAgent) {
            SdkLog.m8378b(BaseJobService.TAG, "onAgentAvailable");
            this.f9384c.onAgentCreated(this.f9382a, baseJobAgent, this.f9383b);
        }

        @Override // com.heytap.accessory.BaseJobAgent.RequestAgentCallback
        public final void onError(int OplusGLSurfaceView_13, String str) {
            SdkLog.m8383e(BaseJobService.TAG, "Request failed. Type = " + this.f9382a + ". ErrorCode : " + OplusGLSurfaceView_13 + ". ErrorMsg: " + str);
        }
    }
}
