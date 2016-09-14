#version 150 core

in vec2 pos;
in mat3 model;

void main() {
	vec3 pos = model * vec3(pos, 1.f);
	pos /= pos.z;
	pos.z = 0;
	gl_Position = vec4(pos, 1.f);
}