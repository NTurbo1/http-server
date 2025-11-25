#!/bin/bash

set -e

# ----------------- CONFIGURATION -----------------
MAIN_CLASS="HttpServerApplication"
SRC_DIR="src"
OUT_DIR="out"
DIST_DIR="dist"
JAR_NAME="httpserver.jar"
JAVA_VERSION=17
# -------------------------------------------------

echo "[INFO] Cleaning previous build..."
rm -rf "$OUT_DIR" "$DIST_DIR"
mkdir -p "$OUT_DIR" "$DIST_DIR"

echo "[INFO] Compiling Java sources ..."
find "$SRC_DIR" -name "*.java" > sources.txt
javac --release $JAVA_VERSION -d "$OUT_DIR" @sources.txt
rm sources.txt

echo "[INFO] Generating manifest..."
MANIFEST_FILE="manifest.txt"
echo "Main-Class: $MAIN_CLASS" > "$MANIFEST_FILE"
echo "" >> "$MANIFEST_FILE"

echo "[INFO] Creating runnable JAR..."
jar cfm "$DIST_DIR/$JAR_NAME" "$MANIFEST_FILE" -C "$OUT_DIR" .
rm "$MANIFEST_FILE"

echo "[INFO] Build complete!"
echo "====================================================="
echo "The HTTP server executable is ready:"
echo "   $DIST_DIR/$JAR_NAME"
echo
echo "Run it using:"
echo "   java -jar $DIST_DIR/$JAR_NAME"
echo "====================================================="