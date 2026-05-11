package demo;

import org.godot.annotation.GodotClass;
import org.godot.annotation.GodotMethod;
import org.godot.node.Node;

@GodotClass(name = "TemplateNode", parent = "Node")
public class TemplateNode extends Node {

	private boolean readyCalled;

	@Override
	public void _ready() {
		readyCalled = true;
		System.out.println("godot-java-template: TemplateNode ready");
	}

	@GodotMethod
	public String ping(String value) {
		return "pong:" + value;
	}

	@GodotMethod
	public boolean wasReadyCalled() {
		return readyCalled;
	}
}
