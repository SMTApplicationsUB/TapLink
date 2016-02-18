uniform mat4 uMVPMatrix;
attribute vec4 vPosition;
attribute vec2 aTexCoord;
varying vec2 vTexCoord;
varying vec4 vVertex;

void main() {
	vTexCoord = aTexCoord;
	vVertex = vPosition;
	gl_Position = uMVPMatrix * vPosition;
}