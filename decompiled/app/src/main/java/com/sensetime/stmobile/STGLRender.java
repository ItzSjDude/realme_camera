package com.sensetime.stmobile;

/* loaded from: classes2.dex */
public class STGLRender {
    public static final java.lang.String CAMERA_INPUT_FRAGMENT_SHADER = "precision mediump float;\nvarying highp vec2 textureCoordinate;\n_renamed\nuniform sampler2D inputImageTexture;\n_renamed\nvoid main()\n_renamed{\ngl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n_renamed}";
    private static final java.lang.String CAMERA_INPUT_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n_renamed\nvarying vec2 textureCoordinate;\n_renamed\nvoid main()\n_renamed{\ntextureCoordinate = inputTextureCoordinate.xy;\ngl_Position = position;\n_renamed}";
    private static final java.lang.String POSITION_COORDINATE = "position";
    private static final java.lang.String PROGRAM_ID = "program";
    private static final java.lang.String TEXTURE_COORDINATE = "inputTextureCoordinate";
    private static final java.lang.String TEXTURE_UNIFORM = "inputImageTexture";
    private int[] mFrameBufferTexturesResize;
    private int[] mFrameBuffersResize;
    private java.nio.FloatBuffer mGLCubeBuffer;
    private java.nio.FloatBuffer mGLSaveTextureBuffer;
    private boolean mIsInitialized;
    private int[] mOesFrameBuffer;
    private java.nio.FloatBuffer mVertexBuffer;
    public static final float[] CUBE = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] TEXTURE_NO_ROTATION = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] TEXTURE_VERTICAL_FLIP = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private int mWidth = 0;
    private int mHeight = 0;
    private java.util.HashMap<java.lang.String, java.lang.Integer> mProgram = new java.util.HashMap<>();

    public STGLRender() {
        this.mProgram.put(PROGRAM_ID, 0);
        this.mProgram.put(POSITION_COORDINATE, -1);
        this.mProgram.put(TEXTURE_UNIFORM, -1);
        this.mProgram.put(TEXTURE_COORDINATE, -1);
        this.mGLCubeBuffer = java.nio.ByteBuffer.allocateDirect(CUBE.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLCubeBuffer.put(CUBE).position(0);
        this.mGLSaveTextureBuffer = java.nio.ByteBuffer.allocateDirect(TEXTURE_NO_ROTATION.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLSaveTextureBuffer.put(TEXTURE_VERTICAL_FLIP).position(0);
    }

    public void init(int i_renamed, int i2) {
        this.mWidth = i_renamed;
        this.mHeight = i2;
        initProgram(CAMERA_INPUT_FRAGMENT_SHADER, this.mProgram);
        initFrameBuffers();
        this.mIsInitialized = true;
        calculateVertexBuffer();
    }

    private void initProgram(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Integer> map) {
        if (map.get(PROGRAM_ID).intValue() == 0) {
            int iA = com.oplus.camera.util.k_renamed.a_renamed(CAMERA_INPUT_VERTEX_SHADER, str);
            map.put(PROGRAM_ID, java.lang.Integer.valueOf(iA));
            map.put(POSITION_COORDINATE, java.lang.Integer.valueOf(android.opengl.GLES20.glGetAttribLocation(iA, POSITION_COORDINATE)));
            map.put(TEXTURE_UNIFORM, java.lang.Integer.valueOf(android.opengl.GLES20.glGetUniformLocation(iA, TEXTURE_UNIFORM)));
            map.put(TEXTURE_COORDINATE, java.lang.Integer.valueOf(android.opengl.GLES20.glGetAttribLocation(iA, TEXTURE_COORDINATE)));
        }
    }

    public void calculateVertexBuffer() {
        if (this.mVertexBuffer == null) {
            this.mVertexBuffer = java.nio.ByteBuffer.allocateDirect(CUBE.length * 4).order(java.nio.ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.mVertexBuffer.clear();
        this.mVertexBuffer.put(CUBE).position(0);
    }

    public void copyTexture(int i_renamed, int i2, int i3, int i4) {
        if (this.mOesFrameBuffer == null) {
            this.mOesFrameBuffer = new int[1];
            android.opengl.GLES20.glGenFramebuffers(1, this.mOesFrameBuffer, 0);
        }
        android.opengl.GLES30.glBindFramebuffer(36008, this.mFrameBuffersResize[0]);
        android.opengl.GLES30.glBindTexture(3553, i_renamed);
        android.opengl.GLES30.glFramebufferTexture2D(36008, 36064, 3553, i_renamed, 0);
        android.opengl.GLES30.glBindFramebuffer(36009, this.mOesFrameBuffer[0]);
        android.opengl.GLES30.glFramebufferTexture2D(36009, 36064, 36197, i2, 0);
        android.opengl.GLES30.glBlitFramebuffer(0, 0, i3, i4, 0, 0, i3, i4, 16384, 9729);
        android.opengl.GLES30.glBindFramebuffer(36009, 0);
        android.opengl.GLES30.glBindFramebuffer(36008, 0);
        android.opengl.GLES30.glBindTexture(3553, 0);
        android.opengl.GLES30.glBindTexture(36197, 0);
    }

    public int resizeTexture(int i_renamed, int i2, int i3, int i4) {
        if (!this.mIsInitialized) {
            return -1;
        }
        android.opengl.GLES20.glUseProgram(this.mProgram.get(PROGRAM_ID).intValue());
        this.mVertexBuffer.position(0);
        int iIntValue = this.mProgram.get(POSITION_COORDINATE).intValue();
        android.opengl.GLES20.glVertexAttribPointer(iIntValue, 2, 5126, false, 0, (java.nio.Buffer) this.mVertexBuffer);
        android.opengl.GLES20.glEnableVertexAttribArray(iIntValue);
        int iIntValue2 = this.mProgram.get(TEXTURE_COORDINATE).intValue();
        this.mGLSaveTextureBuffer.position(0);
        android.opengl.GLES20.glVertexAttribPointer(iIntValue2, 2, 5126, false, 0, (java.nio.Buffer) this.mGLSaveTextureBuffer);
        android.opengl.GLES20.glEnableVertexAttribArray(iIntValue2);
        if (i_renamed != -1) {
            android.opengl.GLES20.glActiveTexture(33984);
            android.opengl.GLES20.glBindTexture(3553, i_renamed);
            android.opengl.GLES20.glUniform1i(this.mProgram.get(TEXTURE_UNIFORM).intValue(), 0);
        }
        android.opengl.GLES20.glBindFramebuffer(36160, this.mFrameBuffersResize[i4]);
        com.oplus.camera.util.k_renamed.a_renamed("resizeTexture");
        android.opengl.GLES20.glViewport(0, 0, i2, i3);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
        android.opengl.GLES20.glDisableVertexAttribArray(iIntValue);
        android.opengl.GLES20.glDisableVertexAttribArray(iIntValue2);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, 0);
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        android.opengl.GLES20.glUseProgram(0);
        return this.mFrameBufferTexturesResize[i4];
    }

    public void destroyResizeFrameBuffers() {
        int[] iArr = this.mFrameBufferTexturesResize;
        if (iArr != null) {
            android.opengl.GLES20.glDeleteTextures(1, iArr, 0);
            this.mFrameBufferTexturesResize = null;
        }
        int[] iArr2 = this.mFrameBuffersResize;
        if (iArr2 != null) {
            android.opengl.GLES20.glDeleteFramebuffers(1, iArr2, 0);
            this.mFrameBuffersResize = null;
        }
        int[] iArr3 = this.mOesFrameBuffer;
        if (iArr3 != null) {
            android.opengl.GLES20.glDeleteFramebuffers(1, iArr3, 0);
            this.mOesFrameBuffer = null;
        }
    }

    private void initFrameBuffers() {
        destroyResizeFrameBuffers();
        if (this.mFrameBuffersResize == null) {
            this.mFrameBuffersResize = new int[1];
            this.mFrameBufferTexturesResize = new int[1];
            android.opengl.GLES20.glGenFramebuffers(1, this.mFrameBuffersResize, 0);
            android.opengl.GLES20.glGenTextures(1, this.mFrameBufferTexturesResize, 0);
            bindFrameBuffer(this.mFrameBufferTexturesResize[0], this.mFrameBuffersResize[0], this.mWidth, this.mHeight);
        }
    }

    private void bindFrameBuffer(int i_renamed, int i2, int i3, int i4) {
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glTexImage2D(3553, 0, 6408, i3, i4, 0, 6408, 5121, null);
        android.opengl.GLES20.glTexParameterf(3553, 10240, 9729.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10241, 9729.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10242, 33071.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10243, 33071.0f);
        android.opengl.GLES20.glBindFramebuffer(36160, i2);
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, i_renamed, 0);
        android.opengl.GLES20.glBindTexture(3553, 0);
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
    }

    public void destroy() {
        destroyResizeFrameBuffers();
        java.nio.FloatBuffer floatBuffer = this.mVertexBuffer;
        if (floatBuffer != null) {
            floatBuffer.clear();
            this.mVertexBuffer = null;
        }
        java.nio.FloatBuffer floatBuffer2 = this.mGLSaveTextureBuffer;
        if (floatBuffer2 != null) {
            floatBuffer2.clear();
            this.mGLSaveTextureBuffer = null;
        }
        java.nio.FloatBuffer floatBuffer3 = this.mGLCubeBuffer;
        if (floatBuffer3 != null) {
            floatBuffer3.clear();
            this.mGLCubeBuffer = null;
        }
        java.util.HashMap<java.lang.String, java.lang.Integer> map = this.mProgram;
        if (map != null) {
            android.opengl.GLES20.glDeleteProgram(map.get(PROGRAM_ID).intValue());
            this.mProgram.clear();
            this.mProgram = null;
        }
        this.mIsInitialized = false;
    }
}
