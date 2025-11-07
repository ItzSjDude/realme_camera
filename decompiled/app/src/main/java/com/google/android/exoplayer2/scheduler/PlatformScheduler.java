package com.google.android.exoplayer2.scheduler;

@android.annotation.TargetApi(21)
/* loaded from: classes.dex */
public final class PlatformScheduler implements com.google.android.exoplayer2.scheduler.Scheduler {
    private static final java.lang.String KEY_REQUIREMENTS = "requirements";
    private static final java.lang.String KEY_SERVICE_ACTION = "service_action";
    private static final java.lang.String KEY_SERVICE_PACKAGE = "service_package";
    private static final java.lang.String TAG = "PlatformScheduler";
    private final int jobId;
    private final android.app.job.JobScheduler jobScheduler;
    private final android.content.ComponentName jobServiceComponentName;

    /* JADX INFO: Access modifiers changed from: private */
    public static void logd(java.lang.String str) {
    }

    public PlatformScheduler(android.content.Context context, int i_renamed) {
        this.jobId = i_renamed;
        this.jobServiceComponentName = new android.content.ComponentName(context, (java.lang.Class<?>) com.google.android.exoplayer2.scheduler.PlatformScheduler.PlatformSchedulerService.class);
        this.jobScheduler = (android.app.job.JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.google.android.exoplayer2.scheduler.Scheduler
    public boolean schedule(com.google.android.exoplayer2.scheduler.Requirements requirements, java.lang.String str, java.lang.String str2) {
        int iSchedule = this.jobScheduler.schedule(buildJobInfo(this.jobId, this.jobServiceComponentName, requirements, str2, str));
        logd("Scheduling job: " + this.jobId + " result: " + iSchedule);
        return iSchedule == 1;
    }

    @Override // com.google.android.exoplayer2.scheduler.Scheduler
    public boolean cancel() {
        logd("Canceling job: " + this.jobId);
        this.jobScheduler.cancel(this.jobId);
        return true;
    }

    private static android.app.job.JobInfo buildJobInfo(int i_renamed, android.content.ComponentName componentName, com.google.android.exoplayer2.scheduler.Requirements requirements, java.lang.String str, java.lang.String str2) {
        android.app.job.JobInfo.Builder builder = new android.app.job.JobInfo.Builder(i_renamed, componentName);
        int requiredNetworkType = requirements.getRequiredNetworkType();
        int i2 = 4;
        if (requiredNetworkType == 0) {
            i2 = 0;
        } else if (requiredNetworkType == 1) {
            i2 = 1;
        } else if (requiredNetworkType == 2) {
            i2 = 2;
        } else if (requiredNetworkType != 3) {
            if (requiredNetworkType == 4) {
                if (com.google.android.exoplayer2.util.Util.SDK_INT < 26) {
                    throw new java.lang.UnsupportedOperationException();
                }
            } else {
                throw new java.lang.UnsupportedOperationException();
            }
        } else {
            if (com.google.android.exoplayer2.util.Util.SDK_INT < 24) {
                throw new java.lang.UnsupportedOperationException();
            }
            i2 = 3;
        }
        builder.setRequiredNetworkType(i2);
        builder.setRequiresDeviceIdle(requirements.isIdleRequired());
        builder.setRequiresCharging(requirements.isChargingRequired());
        builder.setPersisted(true);
        android.os.PersistableBundle persistableBundle = new android.os.PersistableBundle();
        persistableBundle.putString(KEY_SERVICE_ACTION, str);
        persistableBundle.putString(KEY_SERVICE_PACKAGE, str2);
        persistableBundle.putInt(KEY_REQUIREMENTS, requirements.getRequirementsData());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    public static final class PlatformSchedulerService extends android.app.job.JobService {
        @Override // android.app.job.JobService
        public boolean onStopJob(android.app.job.JobParameters jobParameters) {
            return false;
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(android.app.job.JobParameters jobParameters) {
            com.google.android.exoplayer2.scheduler.PlatformScheduler.logd("PlatformSchedulerService started");
            android.os.PersistableBundle extras = jobParameters.getExtras();
            if (new com.google.android.exoplayer2.scheduler.Requirements(extras.getInt(com.google.android.exoplayer2.scheduler.PlatformScheduler.KEY_REQUIREMENTS)).checkRequirements(this)) {
                com.google.android.exoplayer2.scheduler.PlatformScheduler.logd("Requirements are met");
                java.lang.String string = extras.getString(com.google.android.exoplayer2.scheduler.PlatformScheduler.KEY_SERVICE_ACTION);
                java.lang.String string2 = extras.getString(com.google.android.exoplayer2.scheduler.PlatformScheduler.KEY_SERVICE_PACKAGE);
                android.content.Intent intent = new android.content.Intent(string).setPackage(string2);
                com.google.android.exoplayer2.scheduler.PlatformScheduler.logd("Starting service action: " + string + " package: " + string2);
                com.google.android.exoplayer2.util.Util.startForegroundService(this, intent);
                return false;
            }
            com.google.android.exoplayer2.scheduler.PlatformScheduler.logd("Requirements are not met");
            jobFinished(jobParameters, true);
            return false;
        }
    }
}
