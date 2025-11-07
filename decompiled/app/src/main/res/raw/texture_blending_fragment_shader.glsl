precision mediump float;
varying vec2 vTextureCoord;
uniform float uAlpha;
uniform sampler2D uBlendingTexture1;
uniform sampler2D uBlendingTexture2;
uniform float uBlendingAlpha1;
uniform float uBlendingAlpha2;

void main() {
    vec4 textureColor1 = texture2D(uBlendingTexture1, vTextureCoord);
    vec4 textureColor2 = texture2D(uBlendingTexture2, vTextureCoord);
    gl_FragColor = textureColor1 * uBlendingAlpha1 + textureColor2 * uBlendingAlpha2;
    gl_FragColor *= uAlpha;
}