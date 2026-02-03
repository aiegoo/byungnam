#!/bin/bash
# Submit Assignment to Origin - Page-based Structure
set -e

DRY_RUN=false
PAGE_NUM=""

for arg in "$@"; do
    [[ "$arg" == "--dry-run" ]] && DRY_RUN=true || PAGE_NUM="$arg"
done

if [ -z "$PAGE_NUM" ]; then
    echo "❌ Error: Provide page number"
    echo "Usage: ./submit-assignment.sh <page> [--dry-run]"
    exit 1
fi

[ "$DRY_RUN" = true ] && echo "🔍 DRY RUN MODE" && echo ""

SUBMISSION_BRANCH="page-$PAGE_NUM-submission"
CURRENT_BRANCH=$(git branch --show-current)
TEMP_DIR="/tmp/assignment-submission-$$"

echo "📝 Preparing submission for Page #$PAGE_NUM..."

if [ "$DRY_RUN" = true ]; then
    echo "🔍 Branch: $SUBMISSION_BRANCH"
    echo ""
    echo "✅ Would submit from: pages/page-$PAGE_NUM/"
    [ -d "pages/page-$PAGE_NUM" ] && ls pages/page-$PAGE_NUM/*.java 2>/dev/null | grep -v Test || echo "  (no files found)"
    echo ""
    echo "❌ Would exclude: *Test.java, *.class, scripts/, other pages/"
    exit 0
fi

# Create temp and copy assignment files
mkdir -p "$TEMP_DIR/src"

echo "📋 Copying assignment files..."
sed '/## 🧪 테스트 스위트/,$d' README.md > "$TEMP_DIR/README.md" 2>/dev/null || touch "$TEMP_DIR/README.md"

[ -d ".github" ] && cp -r .github "$TEMP_DIR/"

# Copy and clean Java files from page directory
if [ -d "pages/page-$PAGE_NUM" ]; then
    for file in pages/page-$PAGE_NUM/*.java; do
        if [ -f "$file" ] && [[ ! "$file" =~ Test\.java$ ]]; then
            echo "Processing: $file"
            python3 scripts/strip-comments.py "$file"
            cp "$file" "$TEMP_DIR/src/"
            git checkout "$file"  # Restore original
        fi
    done
fi

# Create/switch to submission branch
git checkout -b "$SUBMISSION_BRANCH" 2>/dev/null || git checkout "$SUBMISSION_BRANCH"

# Replace all files with clean submission
git rm -rf . 2>/dev/null || true
cp -r "$TEMP_DIR/"* .
cp "$TEMP_DIR/".[!.]* . 2>/dev/null || true
rm -rf "$TEMP_DIR"

# Commit and push
git add .
git commit -m "Submission: Page #$PAGE_NUM" -m "Clean assignment submission" || true

echo "📤 Pushing to origin..."
git push origin "$SUBMISSION_BRANCH" --force

echo ""
echo "✅ Submission complete!"
echo "📍 Create PR: https://github.com/emilyClassroom/back-end-aiegoo/compare/$SUBMISSION_BRANCH?expand=1"
echo ""

# Return to working branch
git checkout "$CURRENT_BRANCH"
echo "💡 Back on $CURRENT_BRANCH with all files intact"
