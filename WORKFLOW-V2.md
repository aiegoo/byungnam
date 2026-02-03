# Git Workflow V2: Cherry-Pick Based Submission

## Overview
Better version control using separate branches and cherry-picking for submissions.

## Branch Strategy

### `work` branch (personal development)
- **Purpose**: Your main development branch with full history
- **Content**: All files including tests, detailed comments, scripts, docs
- **Commits**: Granular commits for better tracking
  - Feature commits (assignment implementation)
  - Test commits (test suite)
  - Refactor commits (code improvements)
  - Doc commits (comments, README updates)
- **Remote**: Push to `byungnam` remote

### `main` branch (submission)
- **Purpose**: Clean submission branch for assignments
- **Content**: Only assignment files, minimal comments (class JavaDoc only)
- **Commits**: Cherry-picked from `work` branch (only assignment file commits)
- **Remote**: Push to `origin` remote

## Workflow

### 1. Start New Assignment

```bash
# Make sure you're on work branch
git checkout work

# Create page directory
mkdir -p pages/page-XX

# Start coding...
```

### 2. Development with Granular Commits

```bash
# Commit assignment file (clean, minimal comments)
git add pages/page-XX/Assignment.java
git commit -m "feat(page-XX): implement Assignment"

# Commit test suite separately
git add pages/page-XX/AssignmentTest.java
git commit -m "test(page-XX): add Assignment test suite"

# Add detailed comments to assignment (personal use)
# Edit Assignment.java to add //given //when //then comments
git add pages/page-XX/Assignment.java
git commit -m "docs(page-XX): add detailed comments for personal reference"

# Refactor if needed
git add pages/page-XX/
git commit -m "refactor(page-XX): simplify Assignment logic"
```

### 3. Submit to Origin (Cherry-Pick)

```bash
# Switch to main branch
git checkout main

# Cherry-pick ONLY the assignment implementation commit (not tests, not detailed comments)
# Use the commit hash from step 2 (the first "feat" commit)
git cherry-pick <commit-hash>

# Push to origin
git push origin main

# Go back to work branch
git checkout work
```

### 4. Push Full Work to Personal Repo

```bash
# On work branch, push everything
git push byungnam work
```

## Commit Message Convention

Use conventional commits for easy cherry-picking:

- `feat(page-XX): <description>` - Assignment implementation (cherry-pick to main)
- `test(page-XX): <description>` - Test suite (keep on work only)
- `docs(page-XX): <description>` - Detailed comments (keep on work only)
- `refactor(page-XX): <description>` - Code improvements (decide case-by-case)
- `chore: <description>` - Scripts, tooling (keep on work only)

## Benefits

1. **Better Version Control**: Granular commits show your development process
2. **Selective Submission**: Cherry-pick only what should go to origin
3. **No Comment Stripping**: Write clean code in feat commits, add details in docs commits
4. **Full History on Personal**: byungnam has complete development story
5. **Clean Submission History**: origin has minimal, essential commits

## Migration from Current Setup

```bash
# Rename main-work to work
git branch -m main-work work

# Make sure main tracks origin/main
git checkout main
git reset --hard origin/main

# Push work branch to byungnam
git push byungnam work

# Continue with new workflow
```

## Quick Reference

```bash
# Daily workflow
git checkout work                          # Work on personal branch
git add <files> && git commit -m "..."    # Commit with conventional messages
git push byungnam work                     # Push full history to personal

# When submitting
git checkout main                          # Switch to submission branch
git cherry-pick <feat-commit>              # Pick only assignment commits
git push origin main                       # Submit to origin
git checkout work                          # Back to work branch
```

## Scripts for New Workflow

Create `scripts/submit-page.sh`:

```bash
#!/bin/bash
# Submit specific page assignment using cherry-pick

PAGE=$1
if [ -z "$PAGE" ]; then
    echo "Usage: ./scripts/submit-page.sh <page-number>"
    exit 1
fi

# Find the feat commit for this page
COMMIT=$(git log work --oneline --grep="feat(page-$PAGE)" --format="%H" | head -1)

if [ -z "$COMMIT" ]; then
    echo "❌ No feat commit found for page-$PAGE"
    exit 1
fi

echo "📝 Found commit: $COMMIT"
git log --oneline -1 $COMMIT

read -p "Cherry-pick this commit to main and push to origin? (y/n) " -n 1 -r
echo
if [[ $REPLY =~ ^[Yy]$ ]]; then
    git checkout main
    git cherry-pick $COMMIT
    git push origin main
    git checkout work
    echo "✅ Submitted page-$PAGE to origin"
fi
```
