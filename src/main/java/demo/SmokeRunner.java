package demo;

import org.godot.Godot;
import org.godot.annotation.GodotClass;
import org.godot.node.Node;

@GodotClass(name = "SmokeRunner", parent = "Node")
public class SmokeRunner extends Node {

	@Override
	public void _ready() {
		System.out.println("GODOT_JAVA_TEMPLATE_SMOKE: starting");

		TemplateNode node = Godot.create("TemplateNode");
		if (node == null || !node.isValid()) {
			System.err.println("GODOT_JAVA_TEMPLATE_SMOKE_FAILED: could not instantiate TemplateNode");
			getTree().quit(1);
			return;
		}

		addChild(node);

		String result = node.ping("template");
		if (!"pong:template".equals(result)) {
			System.err.println("GODOT_JAVA_TEMPLATE_SMOKE_FAILED: ping returned " + result);
			getTree().quit(1);
			return;
		}

		System.out.println("GODOT_JAVA_TEMPLATE_SMOKE_PASSED");
		getTree().quit(0);
	}
}
