precision mediump float;

const float RING_FADE_RADIUS = 0.04;

uniform sampler2D sTexture;
uniform sampler2D sFilterName;
uniform bool fadeOn;
uniform bool isVertical;
uniform bool hasFilterName;
uniform float height;
uniform float width;
uniform float fadeRange;
uniform vec2 uSurfaceSize;
varying vec2 vTextureCoord;

uniform bool uDrawRing;
uniform float uRingRadius;
uniform float uRingThickness;
uniform float uRingOffsetCenterY;
uniform float uRingOffsetCenterX;
uniform vec4 uRingTintColor;

vec4 calcRingColor() {
    vec2 uv = gl_FragCoord.xy/uSurfaceSize * 2.0 - vec2(1.0);
    float aspect = uSurfaceSize.x / uSurfaceSize.y;

    if (aspect > 1.0) {
        uv.x *= aspect;
    } else {
        uv.y /= aspect;
    }

    uv /= uRingRadius;
    uv.y -= uRingOffsetCenterY;
    uv.x -= uRingOffsetCenterX;

    float thickness = RING_FADE_RADIUS + uRingThickness;
    float distance = 1.0 - length(uv);
    vec4 color = vec4(smoothstep(0.0, RING_FADE_RADIUS, distance));
    color *= vec4(1.0 - smoothstep(thickness - RING_FADE_RADIUS, thickness, distance));

    return color * uRingTintColor;
}

void main() {
    if (uDrawRing) {
        gl_FragColor = calcRingColor();
        return;
    }

    vec4 textureColor = texture2D(sTexture, vTextureCoord);
    vec4 finalColor = textureColor;
    float alpha = 1.0;

    if (hasFilterName) {
        vec4 filterNameColor = texture2D(sFilterName, vTextureCoord);
        finalColor = mix(textureColor, filterNameColor, filterNameColor.a);
    }

    if (fadeOn) {
        if (isVertical) {
            if (gl_FragCoord.y > (height - fadeRange)) {
                alpha = (height - gl_FragCoord.y) / fadeRange;
            } else if(gl_FragCoord.y < fadeRange) {
                alpha = gl_FragCoord.y / fadeRange;
            }
        } else {
            if (gl_FragCoord.x > (width - fadeRange)) {
                alpha = (width - gl_FragCoord.x) / fadeRange;
            } else if(gl_FragCoord.x < fadeRange) {
                alpha = gl_FragCoord.x / fadeRange;
            }
        }
    }

    gl_FragColor = finalColor * alpha;
}
