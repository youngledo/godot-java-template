# godot-java-template

Minimal desktop project template for godot-java.

## Build and Sync

```bash
mvn package
```

The Maven build creates `target/app.jar`, resolves the matching
`io.github.youngledo:godot-java-native` platform artifact, and syncs both files
into `godot/godot-java/`.

## Run Smoke Scene

```bash
godot --path godot
```

The main scene is a Java `SmokeRunner`. It creates a Java `TemplateNode`, calls a Java method, and exits with code `0` after printing `GODOT_JAVA_TEMPLATE_SMOKE_PASSED`.

## Export

```bash
mkdir -p godot/build/linux
godot --headless --path godot --export-release Linux godot/build/linux/godot-java-template.x86_64
./godot/build/linux/godot-java-template.x86_64 --headless
```

The Godot project uses `res://godot-java/` as the runtime directory. The sync step writes `app.jar`, the platform native library, and a small `VERSION` file there.
