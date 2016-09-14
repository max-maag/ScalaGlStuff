#version 150 core

in vec3 pos;
in mat4 model;
in vec4 inCol;
out vec4 passCol;

void main() {
	gl_Position = model * vec4(pos, 1.f);
	passCol = inCol;
}