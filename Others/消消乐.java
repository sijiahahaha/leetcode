/**
用stack，check最上面的三个，如果相同，就一直pop直到不同项
**/
	public String remove3ch(String test) {
        Stack<Character> stack = new Stack<Character>();
        char[] buf = test.toCharArray();

        for (int i = 0; i < buf.length; i++) {
            int len = stack.size();

            if (len > 2 && stack.peek() != buf) {
                tryRemove(stack);
            }
            stack.push(buf);
        }

        tryRemove(stack);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }

    private void tryRemove(Stack<Character> stack) {
        int top = stack.size()-1;
        int curr = top;
        char ch = stack.elementAt(top);

        while (curr >= 0 && stack.elementAt(curr) == ch) {
            curr--;
        }

        if (top - curr >= 2) {
            for (; curr < top; curr++) {. from: 1point3acres 
                stack.pop();.
            }
        }
    }