uniform mat4 uMVPMatrix;
attribute vec4 vPosition;
attribute vec2 aTexCoord;
varying vec2 vTexCoord;

void main() {
	vTexCoord = aTexCoord;
	gl_Position = uMVPMatrix * vPosition;
}