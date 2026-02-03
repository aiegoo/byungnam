#!/bin/bash
# Push to Personal Repository (byungnam)
set -e

DRY_RUN=false
[[ "$1" == "--dry-run" ]] && DRY_RUN=true && echo "🔍 DRY RUN MODE" && echo ""

echo "📚 Pushing to personal repository (byungnam)..."
CURRENT_BRANCH=$(git branch --show-current)
git add .

if git diff --cached --quiet; then
    echo "✅ No changes to commit"
else
    TIMESTAMP=$(date "+%Y-%m-%d %H:%M:%S")
    if [ "$DRY_RUN" = true ]; then
        echo "🔍 Would commit: 'Work in progress: $TIMESTAMP'"
    else
        git commit -m "Work in progress: $TIMESTAMP"
        echo "✅ Changes committed"
    fi
fi

if [ "$DRY_RUN" = true ]; then
    echo "🔍 Would run: git push byungnam $CURRENT_BRANCH --force-with-lease"
    echo ""
    echo "📋 Files that would be pushed:"
    git ls-files
else
    git push byungnam "$CURRENT_BRANCH" --force-with-lease
    echo "🎉 Successfully pushed to byungnam/$CURRENT_BRANCH"
fi
