#!/usr/bin/env bash

set -euo pipefail

repo_root=$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)
build_root="$repo_root/build"

mkdir -p "$build_root"

while IFS= read -r -d '' project_dir; do
  mapfile -d '' sources < <(find "$project_dir" -type f -name '*.java' -print0 | sort -z)
  if (( ${#sources[@]} == 0 )); then
    continue
  fi

  project_name=${project_dir#"$repo_root"/}
  output_dir="$build_root/$project_name"
  mkdir -p "$output_dir"
  javac -proc:none -Xlint:all -d "$output_dir" "${sources[@]}"
  printf 'Compiled %s\n' "$project_name"
done < <(find "$repo_root" -mindepth 1 -maxdepth 1 -type d ! -name .git ! -name .github ! -name build ! -name scripts -print0 | sort -z)
