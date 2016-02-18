precision mediump float;
uniform sampler2D sTexture;
varying vec2 vTexCoord;
varying vec4 vVertex;

void main() {
	vec4 tex = texture2D(sTexture, vTexCoord);
	if (tex.a > 0.5) gl_FragColor = tex; else discard;
}