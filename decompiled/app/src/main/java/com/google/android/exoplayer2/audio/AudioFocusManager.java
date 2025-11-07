package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public final class AudioFocusManager {
    private static final int AUDIO_FOCUS_STATE_HAVE_FOCUS = 1;
    private static final int AUDIO_FOCUS_STATE_LOSS_TRANSIENT = 2;
    private static final int AUDIO_FOCUS_STATE_LOSS_TRANSIENT_DUCK = 3;
    private static final int AUDIO_FOCUS_STATE_LOST_FOCUS = -1;
    private static final int AUDIO_FOCUS_STATE_NO_FOCUS = 0;
    public static final int PLAYER_COMMAND_DO_NOT_PLAY = -1;
    public static final int PLAYER_COMMAND_PLAY_WHEN_READY = 1;
    public static final int PLAYER_COMMAND_WAIT_FOR_CALLBACK = 0;
    private static final java.lang.String TAG = "AudioFocusManager";
    private static final float VOLUME_MULTIPLIER_DEFAULT = 1.0f;
    private static final float VOLUME_MULTIPLIER_DUCK = 0.2f;
    private com.google.android.exoplayer2.audio.AudioAttributes audioAttributes;
    private android.media.AudioFocusRequest audioFocusRequest;
    private int audioFocusState;
    private final android.media.AudioManager audioManager;
    private int focusGain;
    private final com.google.android.exoplayer2.audio.AudioFocusManager.AudioFocusListener focusListener;
    private final com.google.android.exoplayer2.audio.AudioFocusManager.PlayerControl playerControl;
    private boolean rebuildAudioFocusRequest;
    private float volumeMultiplier = 1.0f;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface PlayerCommand {
    }

    public interface PlayerControl {
        void executePlayerCommand(int i_renamed);

        void setVolumeMultiplier(float f_renamed);
    }

    private int handleIdle(boolean z_renamed) {
        return z_renamed ? 1 : -1;
    }

    public AudioFocusManager(android.content.Context context, com.google.android.exoplayer2.audio.AudioFocusManager.PlayerControl playerControl) {
        this.audioManager = context == null ? null : (android.media.AudioManager) context.getApplicationContext().getSystemService(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO);
        this.playerControl = playerControl;
        this.focusListener = new com.google.android.exoplayer2.audio.AudioFocusManager.AudioFocusListener();
        this.audioFocusState = 0;
    }

    public float getVolumeMultiplier() {
        return this.volumeMultiplier;
    }

    public int setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes, boolean z_renamed, int i_renamed) {
        if (this.audioAttributes == null && audioAttributes == null) {
            return z_renamed ? 1 : -1;
        }
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioManager, "SimpleExoPlayer must be_renamed created with a_renamed context to handle audio focus.");
        if (!com.google.android.exoplayer2.util.Util.areEqual(this.audioAttributes, audioAttributes)) {
            this.audioAttributes = audioAttributes;
            this.focusGain = convertAudioAttributesToFocusGain(audioAttributes);
            int i2 = this.focusGain;
            com.google.android.exoplayer2.util.Assertions.checkArgument(i2 == 1 || i2 == 0, "Automatic handling of_renamed audio focus is_renamed only available for USAGE_MEDIA and USAGE_GAME.");
            if (z_renamed && (i_renamed == 2 || i_renamed == 3)) {
                return requestAudioFocus();
            }
        }
        if (i_renamed == 1) {
            return handleIdle(z_renamed);
        }
        return handlePrepare(z_renamed);
    }

    public int handlePrepare(boolean z_renamed) {
        if (this.audioManager == null) {
            return 1;
        }
        if (z_renamed) {
            return requestAudioFocus();
        }
        return -1;
    }

    public int handleSetPlayWhenReady(boolean z_renamed, int i_renamed) {
        if (this.audioManager == null) {
            return 1;
        }
        if (z_renamed) {
            return i_renamed == 1 ? handleIdle(z_renamed) : requestAudioFocus();
        }
        abandonAudioFocus();
        return -1;
    }

    public void handleStop() {
        if (this.audioManager == null) {
            return;
        }
        abandonAudioFocus(true);
    }

    private int requestAudioFocus() {
        int iRequestAudioFocusDefault;
        if (this.focusGain == 0) {
            if (this.audioFocusState != 0) {
                abandonAudioFocus(true);
            }
            return 1;
        }
        if (this.audioFocusState == 0) {
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 26) {
                iRequestAudioFocusDefault = requestAudioFocusV26();
            } else {
                iRequestAudioFocusDefault = requestAudioFocusDefault();
            }
            this.audioFocusState = iRequestAudioFocusDefault == 1 ? 1 : 0;
        }
        int i_renamed = this.audioFocusState;
        if (i_renamed == 0) {
            return -1;
        }
        return i_renamed == 2 ? 0 : 1;
    }

    private void abandonAudioFocus() {
        abandonAudioFocus(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abandonAudioFocus(boolean z_renamed) {
        if (this.focusGain == 0 && this.audioFocusState == 0) {
            return;
        }
        if (this.focusGain != 1 || this.audioFocusState == -1 || z_renamed) {
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 26) {
                abandonAudioFocusV26();
            } else {
                abandonAudioFocusDefault();
            }
            this.audioFocusState = 0;
        }
    }

    private int requestAudioFocusDefault() {
        return ((android.media.AudioManager) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioManager)).requestAudioFocus(this.focusListener, com.google.android.exoplayer2.util.Util.getStreamTypeForAudioUsage(((com.google.android.exoplayer2.audio.AudioAttributes) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioAttributes)).usage), this.focusGain);
    }

    private int requestAudioFocusV26() {
        if (this.audioFocusRequest == null || this.rebuildAudioFocusRequest) {
            android.media.AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
            this.audioFocusRequest = (audioFocusRequest == null ? new android.media.AudioFocusRequest.Builder(this.focusGain) : new android.media.AudioFocusRequest.Builder(audioFocusRequest)).setAudioAttributes(((com.google.android.exoplayer2.audio.AudioAttributes) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioAttributes)).getAudioAttributesV21()).setWillPauseWhenDucked(willPauseWhenDucked()).setOnAudioFocusChangeListener(this.focusListener).build();
            this.rebuildAudioFocusRequest = false;
        }
        return ((android.media.AudioManager) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioManager)).requestAudioFocus(this.audioFocusRequest);
    }

    private void abandonAudioFocusDefault() {
        ((android.media.AudioManager) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioManager)).abandonAudioFocus(this.focusListener);
    }

    private void abandonAudioFocusV26() {
        if (this.audioFocusRequest != null) {
            ((android.media.AudioManager) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.audioManager)).abandonAudioFocusRequest(this.audioFocusRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean willPauseWhenDucked() {
        com.google.android.exoplayer2.audio.AudioAttributes audioAttributes = this.audioAttributes;
        return audioAttributes != null && audioAttributes.contentType == 1;
    }

    private static int convertAudioAttributesToFocusGain(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
        if (audioAttributes == null) {
            return 0;
        }
        switch (audioAttributes.usage) {
            case 0:
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Specify a_renamed proper usage in_renamed the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by_renamed default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (audioAttributes.contentType == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unidentified audio usage: " + audioAttributes.usage);
                return 0;
            case 16:
                return com.google.android.exoplayer2.util.Util.SDK_INT >= 19 ? 4 : 2;
        }
    }

    private class AudioFocusListener implements android.media.AudioManager.OnAudioFocusChangeListener {
        private AudioFocusListener() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i_renamed) {
            if (i_renamed != -3) {
                if (i_renamed == -2) {
                    com.google.android.exoplayer2.audio.AudioFocusManager.this.audioFocusState = 2;
                } else if (i_renamed == -1) {
                    com.google.android.exoplayer2.audio.AudioFocusManager.this.audioFocusState = -1;
                } else if (i_renamed == 1) {
                    com.google.android.exoplayer2.audio.AudioFocusManager.this.audioFocusState = 1;
                } else {
                    com.google.android.exoplayer2.util.Log.w_renamed(com.google.android.exoplayer2.audio.AudioFocusManager.TAG, "Unknown focus change type: " + i_renamed);
                    return;
                }
            } else if (com.google.android.exoplayer2.audio.AudioFocusManager.this.willPauseWhenDucked()) {
                com.google.android.exoplayer2.audio.AudioFocusManager.this.audioFocusState = 2;
            } else {
                com.google.android.exoplayer2.audio.AudioFocusManager.this.audioFocusState = 3;
            }
            int i2 = com.google.android.exoplayer2.audio.AudioFocusManager.this.audioFocusState;
            if (i2 == -1) {
                com.google.android.exoplayer2.audio.AudioFocusManager.this.playerControl.executePlayerCommand(-1);
                com.google.android.exoplayer2.audio.AudioFocusManager.this.abandonAudioFocus(true);
            } else if (i2 != 0) {
                if (i2 == 1) {
                    com.google.android.exoplayer2.audio.AudioFocusManager.this.playerControl.executePlayerCommand(1);
                } else if (i2 == 2) {
                    com.google.android.exoplayer2.audio.AudioFocusManager.this.playerControl.executePlayerCommand(0);
                } else if (i2 != 3) {
                    throw new java.lang.IllegalStateException("Unknown audio focus state: " + com.google.android.exoplayer2.audio.AudioFocusManager.this.audioFocusState);
                }
            }
            float f_renamed = com.google.android.exoplayer2.audio.AudioFocusManager.this.audioFocusState == 3 ? com.google.android.exoplayer2.audio.AudioFocusManager.VOLUME_MULTIPLIER_DUCK : 1.0f;
            if (com.google.android.exoplayer2.audio.AudioFocusManager.this.volumeMultiplier != f_renamed) {
                com.google.android.exoplayer2.audio.AudioFocusManager.this.volumeMultiplier = f_renamed;
                com.google.android.exoplayer2.audio.AudioFocusManager.this.playerControl.setVolumeMultiplier(f_renamed);
            }
        }
    }
}
