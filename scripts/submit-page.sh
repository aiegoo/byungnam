#!/bin/bash
# Submit specific page assignment using cherry-pick
# Usage: ./scripts/submit-page.sh <page-number> [-y|--yes]
#
# ⚠️ CRITICAL GUARDRAIL:
# - There must be EXACTLY ONE feat(page-XX) commit per page
# - The feat commit must contain ALL assignments with MINIMAL/CLEAN code
# - Detailed comments should be in SEPARATE docs(page-XX) commits AFTER feat
# - This ensures clean submissions to origin while keeping detailed notes on work branch

PAGE=$1
AUX_FLAG=$2

if [ -z "$PAGE" ]; then
    echo "❌ Usage: ./scripts/submit-page.sh <page-number> [-y|--yes]"
    echo "   Example: ./scripts/submit-page.sh 66"
    exit 1
fi

# Determine whether we should auto-confirm (useful for automation)
AUTO_CONFIRM=false

if [ "$AUX_FLAG" = "-y" ] || [ "$AUX_FLAG" = "--yes" ]; then
    AUTO_CONFIRM=true
fi

if [ "$SUBMIT_AUTO_CONFIRM" = "1" ] || [ "$SUBMIT_AUTO_CONFIRM" = "true" ]; then
    AUTO_CONFIRM=true
fi

# If stdin is not a TTY (non-interactive), auto-confirm to avoid accidental "n"
if [ ! -t 0 ]; then
    AUTO_CONFIRM=true
fi

# Make sure we're in a git repo
if ! git rev-parse --git-dir > /dev/null 2>&1; then
    echo "❌ Not in a git repository"
    exit 1
fi

# Find ALL feat commits for this page
echo "🔍 Looking for feat commit for page-$PAGE..."
COMMITS=$(git log work --oneline --grep="feat(page-$PAGE)" --format="%H")
COMMIT_COUNT=$(echo "$COMMITS" | grep -c '^' 2>/dev/null || echo 0)

# ⚠️ GUARDRAIL CHECK: Ensure exactly ONE feat commit
if [ "$COMMIT_COUNT" -gt 1 ]; then
    echo "⚠️  WARNING: Found $COMMIT_COUNT feat commits for page-$PAGE"
    echo "❌ GUARDRAIL VIOLATION: There should be EXACTLY ONE feat commit per page!"
    echo ""
    echo "📋 Found commits:"
    git log work --oneline --grep="feat(page-$PAGE)"
    echo ""
    echo "🔧 To fix this, you should:"
    echo "   1. Squash multiple feat commits into ONE commit, OR"
    echo "   2. Use 'git rebase -i' to combine them, OR"
    echo "   3. Create a new single feat commit with all assignments"
    echo ""
    echo "💡 Remember: ONE feat commit = ALL assignments + CLEAN code"
    echo "   Then add detailed comments in separate docs(page-$PAGE) commits"
    exit 1
fi

# Verify we found exactly one commit
if [ "$COMMIT_COUNT" -eq 0 ]; then
    echo "❌ No feat(page-$PAGE) commit found on work branch"
    exit 1
fi

# Get the single feat commit
COMMIT=$(echo "$COMMITS" | head -1)

echo "✅ Found exactly ONE feat commit (correct!):"
git log --oneline -1 $COMMIT
echo ""

# Show what files changed
echo "📂 Files in this commit:"
FILES=$(git show --name-only --pretty="" $COMMIT)
echo "$FILES"
echo ""

# Count non-test Java files (assignments)
ASSIGNMENT_COUNT=$(echo "$FILES" | grep "pages/page-$PAGE/.*\.java$" | grep -v "Test\.java$" | wc -l | tr -d ' ')
echo "📊 Assignment files: $ASSIGNMENT_COUNT"
echo ""

# Ask for confirmation (or auto-confirm when running non-interactively)
PROCEED=false

if [ "$AUTO_CONFIRM" = true ]; then
    echo "🤖 Auto-confirm enabled. Proceeding without manual confirmation."
    PROCEED=true
else
    while true; do
        read -r -p "Cherry-pick this commit to main and push to origin? (y/n) " RESPONSE
        if [ -z "$RESPONSE" ] || [[ $RESPONSE =~ ^[Yy]$ ]]; then
            PROCEED=true
            break
        elif [[ $RESPONSE =~ ^[Nn]$ ]]; then
            echo "❌ Submission cancelled"
            exit 0
        else
            echo "Please answer with 'y' or 'n'."
        fi
    done
fi

if [ "$PROCEED" = true ]; then
    # Switch to main
    git checkout main
    
    # Cherry-pick the commit
    if git cherry-pick $COMMIT; then
        echo "✅ Cherry-picked successfully"
        
        # Copy assignment files to src/ directory
        echo "📁 Copying assignment files to src/..."
        mkdir -p src
        
        # Find all .java files in pages/page-XX/ (excluding test files)
        for file in pages/page-$PAGE/*.java; do
            if [[ -f "$file" ]] && [[ ! "$file" =~ Test\.java$ ]]; then
                filename=$(basename "$file")
                cp "$file" "src/$filename"
                echo "  → Copied $filename to src/"
            fi
        done
        
        # Stage and commit the src/ updates
        git add src/
        git commit -m "chore: update src/ with page-$PAGE assignments" --no-verify
        echo "✅ Updated src/ directory"
        
        # Push to origin
        if git push origin main; then
            echo "✅ Pushed to origin/main"
            echo "🎉 Submitted page-$PAGE successfully!"
        else
            echo "❌ Failed to push to origin"
            git checkout work
            exit 1
        fi
    else
        echo "❌ Cherry-pick failed - resolve conflicts and run:"
        echo "   git cherry-pick --continue"
        echo "   git push origin main"
        echo "   git checkout work"
        exit 1
    fi
    
    # Go back to work branch
    git checkout work
    echo "🔄 Back on work branch"
fi
