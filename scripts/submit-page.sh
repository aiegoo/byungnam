#!/bin/bash
# Submit specific page assignment using cherry-pick
# Usage: ./scripts/submit-page.sh <page-number>

PAGE=$1

if [ -z "$PAGE" ]; then
    echo "❌ Usage: ./scripts/submit-page.sh <page-number>"
    echo "   Example: ./scripts/submit-page.sh 66"
    exit 1
fi

# Make sure we're in a git repo
if ! git rev-parse --git-dir > /dev/null 2>&1; then
    echo "❌ Not in a git repository"
    exit 1
fi

# Find the feat commit for this page
echo "🔍 Looking for feat commit for page-$PAGE..."
COMMIT=$(git log work --oneline --grep="feat(page-$PAGE)" --format="%H" | head -1)

if [ -z "$COMMIT" ]; then
    echo "❌ No feat commit found for page-$PAGE"
    echo "💡 Make sure you have a commit with message: feat(page-$PAGE): ..."
    exit 1
fi

echo "📝 Found commit:"
git log --oneline -1 $COMMIT
echo ""

# Show what files changed
echo "📂 Files in this commit:"
git show --name-only --pretty="" $COMMIT
echo ""

# Ask for confirmation
read -p "Cherry-pick this commit to main and push to origin? (y/n) " -n 1 -r
echo ""

if [[ $REPLY =~ ^[Yy]$ ]]; then
    # Switch to main
    git checkout main
    
    # Cherry-pick the commit
    if git cherry-pick $COMMIT; then
        echo "✅ Cherry-picked successfully"
        
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
else
    echo "❌ Submission cancelled"
fi
