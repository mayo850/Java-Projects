# Java Projects

A curated collection of 64 standalone Java exercises covering collections, recursion, sorting, data structures, object-oriented design, file processing, Swing, audio, and image manipulation.

## Requirements

- JDK 17 or newer
- Bash for the repository-wide build script

## Build every project

```bash
./scripts/compile-all.sh
```

The script compiles every top-level project independently into `build/<project-name>`. Isolation is intentional because many classroom exercises use the default package and repeat common class names such as `Point`, `DrawingPanel`, and `ArrayStack`.

## Run a project

Run applications from their project directory so relative data and media paths resolve correctly. For example:

```bash
cd Lab8B
java -cp "../build/Lab8B" DistanceFinder
```

GUI and audio exercises require a desktop environment and compatible media support. Input files and visual/audio assets used by the exercises remain with their corresponding projects.

## Repository organization

- Each top-level folder is an independent exercise or assignment.
- `scripts/compile-all.sh` provides a repeatable Java 17 build.
- `.github/workflows/java-build.yml` verifies every project on pushes and pull requests.
- Eclipse workspace caches, platform metadata, generated files, and redundant nested archives are excluded.
