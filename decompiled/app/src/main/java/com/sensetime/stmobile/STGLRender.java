package com.sensetime.stmobile;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.oplus.camera.util.OpenGLUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class STGLRender {
    public static final String CAMERA_INPUT_FRAGMENT_SHADER = "precision mediump float;\nvarying highp vec2 textureCoordinate;\OplusGLSurfaceView_11\nuniform sampler2D inputImageTexture;\OplusGLSurfaceView_11\nvoid main()\OplusGLSurfaceView_11{\ngl_FragColor = texture2D(inputImageTexture, textureCoordinate);\OplusGLSurfaceView_11}";
    private static final String CAMERA_INPUT_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\OplusGLSurfaceView_11\nvarying vec2 textureCoordinate;\OplusGLSurfaceView_11\nvoid main()\OplusGLSurfaceView_11{\ntextureCoordinate = inputTextureCoordinate.xy;\ngl_Position = position;\OplusGLSurfaceView_11}";
    private static final String POSITION_COORDINATE = "position";
    private static final String PROGRAM_ID = "program";
    private static final String TEXTURE_COORDINATE = "inputTextureCoordinate";
    private static final String TEXTURE_UNIFORM = "inputImageTexture";
    private int[] mFrameBufferTexturesResize;
    private int[] mFrameBuffersResize;
    private FloatBuffer mGLCubeBuffer;
    private FloatBuffer mGLSaveTextureBuffer;
    private boolean mIsInitialized;
    private int[] mOesFrameBuffer;
    private FloatBuffer mVertexBuffer;
    public static final float[] CUBE = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] TEXTURE_NO_ROTATION = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] TEXTURE_VERTICAL_FLIP = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private int mWidth = 0;
    private int mHeight = 0;
    private HashMap<String, Integer> mProgram = new HashMap<>();

    public STGLRender() {
        this.mProgram.put(PROGRAM_ID, 0);
        this.mProgram.put(POSITION_COORDINATE, -1);
        this.mProgram.put(TEXTURE_UNIFORM, -1);
        this.mProgram.put(TEXTURE_COORDINATE, -1);
        this.mGLCubeBuffer = ByteBuffer.allocateDirect(CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLCubeBuffer.put(CUBE).position(0);
        this.mGLSaveTextureBuffer = ByteBuffer.allocateDirect(TEXTURE_NO_ROTATION.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLSaveTextureBuffer.put(TEXTURE_VERTICAL_FLIP).position(0);
    }

    public void init(int OplusGLSurfaceView_13, int i2) {
        this.mWidth = OplusGLSurfaceView_13;
        this.mHeight = i2;
        initProgram(CAMERA_INPUT_FRAGMENT_SHADER, this.mProgram);
        initFrameBuffers();
        this.mIsInitialized = true;
        calculateVertexBuffer();
    }

    private void initProgram(String str, HashMap<String, Integer> map) {
        if (map.get(PROGRAM_ID).intValue() == 0) {
            int iM24589a = OpenGLUtils.m24589a(CAMERA_INPUT_VERTEX_SHADER, str);
            map.put(PROGRAM_ID, Integer.valueOf(iM24589a));
            map.put(POSITION_COORDINATE, Integer.valueOf(GLES20.glGetAttribLocation(iM24589a, POSITION_COORDINATE)));
            map.put(TEXTURE_UNIFORM, Integer.valueOf(GLES20.glGetUniformLocation(iM24589a, TEXTURE_UNIFORM)));
            map.put(TEXTURE_COORDINATE, Integer.valueOf(GLES20.glGetAttribLocation(iM24589a, TEXTURE_COORDINATE)));
        }
    }

    public void calculateVertexBuffer() {
        if (this.mVertexBuffer == null) {
            this.mVertexBuffer = ByteBuffer.allocateDirect(CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.mVertexBuffer.clear();
        this.mVertexBuffer.put(CUBE).position(0);
    }

    public void copyTexture(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (this.mOesFrameBuffer == null) {
            this.mOesFrameBuffer = new int[1];
            GLES20.glGenFramebuffers(1, this.mOesFrameBuffer, 0);
        }
        GLES30.glBindFramebuffer(36008, this.mFrameBuffersResize[0]);
        GLES30.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES30.glFramebufferTexture2D(36008, 36064, 3553, OplusGLSurfaceView_13, 0);
        GLES30.glBindFramebuffer(36009, this.mOesFrameBuffer[0]);
        GLES30.glFramebufferTexture2D(36009, 36064, 36197, i2, 0);
        GLES30.glBlitFramebuffer(0, 0, i3, i4, 0, 0, i3, i4, 16384, 9729);
        GLES30.glBindFramebuffer(36009, 0);
        GLES30.glBindFramebuffer(36008, 0);
        GLES30.glBindTexture(3553, 0);
        GLES30.glBindTexture(36197, 0);
    }

    public int resizeTexture(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (!this.mIsInitialized) {
            return -1;
        }
        GLES20.glUseProgram(this.mProgram.get(PROGRAM_ID).intValue());
        this.mVertexBuffer.position(0);
        int iIntValue = this.mProgram.get(POSITION_COORDINATE).intValue();
        GLES20.glVertexAttribPointer(iIntValue, 2, 5126, false, 0, (Buffer) this.mVertexBuffer);
        GLES20.glEnableVertexAttribArray(iIntValue);
        int iIntValue2 = this.mProgram.get(TEXTURE_COORDINATE).intValue();
        this.mGLSaveTextureBuffer.position(0);
        GLES20.glVertexAttribPointer(iIntValue2, 2, 5126, false, 0, (Buffer) this.mGLSaveTextureBuffer);
        GLES20.glEnableVertexAttribArray(iIntValue2);
        if (OplusGLSurfaceView_13 != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
            GLES20.glUniform1i(this.mProgram.get(TEXTURE_UNIFORM).intValue(), 0);
        }
        GLES20.glBindFramebuffer(36160, this.mFrameBuffersResize[i4]);
        OpenGLUtils.m24594a("resizeTexture");
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(iIntValue);
        GLES20.glDisableVertexAttribArray(iIntValue2);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        return this.mFrameBufferTexturesResize[i4];
    }

    public void destroyResizeFrameBuffers() {
        int[] iArr = this.mFrameBufferTexturesResize;
        if (iArr != null) {
            GLES20.glDeleteTextures(1, iArr, 0);
            this.mFrameBufferTexturesResize = null;
        }
        int[] iArr2 = this.mFrameBuffersResize;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(1, iArr2, 0);
            this.mFrameBuffersResize = null;
        }
        int[] iArr3 = this.mOesFrameBuffer;
        if (iArr3 != null) {
            GLES20.glDeleteFramebuffers(1, iArr3, 0);
            this.mOesFrameBuffer = null;
        }
    }

    private void initFrameBuffers() {
        destroyResizeFrameBuffers();
        if (this.mFrameBuffersResize == null) {
            this.mFrameBuffersResize = new int[1];
            this.mFrameBufferTexturesResize = new int[1];
            GLES20.glGenFramebuffers(1, this.mFrameBuffersResize, 0);
            GLES20.glGenTextures(1, this.mFrameBufferTexturesResize, 0);
            bindFrameBuffer(this.mFrameBufferTexturesResize[0], this.mFrameBuffersResize[0], this.mWidth, this.mHeight);
        }
    }

    private void bindFrameBuffer(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glTexImage2D(3553, 0, 6408, i3, i4, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glBindFramebuffer(36160, i2);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, OplusGLSurfaceView_13, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void destroy() {
        destroyResizeFrameBuffers();
        FloatBuffer floatBuffer = this.mVertexBuffer;
        if (floatBuffer != null) {
            floatBuffer.clear();
            this.mVertexBuffer = null;
        }
        FloatBuffer floatBuffer2 = this.mGLSaveTextureBuffer;
        if (floatBuffer2 != null) {
            floatBuffer2.clear();
            this.mGLSaveTextureBuffer = null;
        }
        FloatBuffer floatBuffer3 = this.mGLCubeBuffer;
        if (floatBuffer3 != null) {
            floatBuffer3.clear();
            this.mGLCubeBuffer = null;
        }
        HashMap<String, Integer> map = this.mProgram;
        if (map != null) {
            GLES20.glDeleteProgram(map.get(PROGRAM_ID).intValue());
            this.mProgram.clear();
            this.mProgram = null;
        }
        this.mIsInitialized = false;
    }
}
