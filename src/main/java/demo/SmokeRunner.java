package demo;

import org.godot.annotation.GodotClass;
import org.godot.node.Node;

@GodotClass(name = "SmokeRunner", parent = "Node")
public class SmokeRunner extends Node {

	@Override
	public void _ready() {
		System.out.println("GODOT_JAVA_TEMPLATE_SMOKE: starting");

		TemplateNode node = new TemplateNode();
		addChild(node);

		String result = node.ping("template");
		if (!"pong:template".equals(result)) {
			System.err.println("GODOT_JAVA_TEMPLATE_SMOKE_FAILED: ping returned " + result);
			getTree().quit(1);
			return;
		}

		if (!node.wasReadyCalled()) {
			System.err.println("GODOT_JAVA_TEMPLATE_SMOKE_FAILED: TemplateNode _ready was not called");
			getTree().quit(1);
			return;
		}

		System.out.println("GODOT_JAVA_TEMPLATE_SMOKE_PASSED");
		getTree().quit(0);
	}
}
