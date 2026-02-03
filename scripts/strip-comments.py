#!/usr/bin/env python3
"""Comment Stripper for Java Files"""
import re, sys
from pathlib import Path

def strip_comments(content: str) -> str:
    lines = content.split('\n')
    result = []
    in_class_javadoc = False
    class_javadoc_done = False
    in_multiline_comment = False
    
    for i, line in enumerate(lines):
        stripped = line.strip()
        
        if stripped.startswith('package ') or stripped.startswith('import '):
            result.append(line)
            continue
        
        if '/*' in stripped and not class_javadoc_done:
            if i < len(lines) - 5:
                for j in range(i, min(i + 10, len(lines))):
                    if 'public class' in lines[j] or 'class ' in lines[j]:
                        in_class_javadoc = True
                        break
            
            if in_class_javadoc:
                result.append(line)
                if '*/' in stripped:
                    in_class_javadoc = False
                    class_javadoc_done = True
                continue
            else:
                in_multiline_comment = True
                if '*/' in stripped:
                    in_multiline_comment = False
                continue
        
        if in_multiline_comment:
            result.append(line) if in_class_javadoc else None
            if '*/' in stripped:
                in_multiline_comment = False
                in_class_javadoc = False
            continue
        
        if '// KEEP:' in line:
            result.append(line.replace('// KEEP:', '//'))
            continue
        
        if stripped.startswith('//'):
            continue
        
        if stripped or (result and result[-1].strip()):
            result.append(line)
    
    cleaned = []
    prev_blank = False
    for line in result:
        is_blank = not line.strip()
        if is_blank and prev_blank:
            continue
        cleaned.append(line)
        prev_blank = is_blank
    
    return '\n'.join(cleaned).strip() + '\n'

if __name__ == '__main__':
    path = Path(sys.argv[1])
    content = path.read_text(encoding='utf-8')
    path.write_text(strip_comments(content), encoding='utf-8')
