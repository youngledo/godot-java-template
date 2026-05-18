# godot-java-template

Minimal desktop project template for godot-java.

## Build and Sync

```bash
mvn package
```

The Maven build creates `target/app.jar`, resolves the matching
`io.github.youngledo:godot-java-native` platform artifact, and syncs both files
into `godot/godot-java/`.

## Run from Maven

```bash
mvn verify -Pgodot-run
```

The `godot-run` profile runs the same build and sync steps as `mvn package`,
then launches Godot with this project's `godot/` directory.

By default it expects a `godot` command on `PATH`. Override it when needed:

```bash
mvn verify -Pgodot-run -Dgodot.executable=/Applications/Godot.app/Contents/MacOS/Godot
```

## Doctor

```bash
mvn verify -Pgodot-doctor
```

The `godot-doctor` profile verifies the Maven JDK version, Godot project files,
the synced `app.jar`, the generated Java class registry inside the jar, and the
platform native library under `godot/godot-java/`.

## Smoke Scene

The main scene is a Java `SmokeRunner`. It creates a Java `TemplateNode`, calls
a Java method, and exits with code `0` after printing
`GODOT_JAVA_TEMPLATE_SMOKE_PASSED`.

## Export

Build with bundled JRE (no JDK required on target machine):

```bash
mvn package -Pjlink
```

This creates a `runtime/` directory inside `godot/godot-java/` containing a minimal
JRE (~32 MB). The native library automatically discovers it — no `JAVA_HOME` needed.

To include additional JDK modules (e.g., HTTP client):

```bash
mvn package -Pjlink -Djlink.modules=java.base,java.compiler,java.net.http
```

For export without bundled JRE (requires JDK on target):

```bash
mkdir -p godot/build/linux
godot --headless --path godot --export-release Linux godot/build/linux/godot-java-template.x86_64
./godot/build/linux/godot-java-template.x86_64 --headless
```

The Godot project uses `res://godot-java/` as the runtime directory. The sync step writes `app.jar`, the platform native library, and a small `VERSION` file there.
