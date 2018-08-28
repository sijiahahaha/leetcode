/**
用两个queue来回交替，有两种方法：
1. push时倒腾一下，需要更多时间， pop和top直接操作
push(1) 放到primary里
primary: 1
buffer:

push(2) 把primary放到buffer里， push进primary， 再把buffer放回primary
primary: 1          -->         primary: 2              --->    primary:  1 -> 2
buffer:                         buffer:1                        buffer:

push(3) 
primary:  1 -> 2       --->     primary: 3              --->    primary:  1 -> 2 -> 3
buffer:                         buffer:1 -> 2                   buffer:

pop() ： 直接拿出一个
primary: 1 -> 2 -> 3           
buffer: 


2. push直接放入，pop和top需要倒腾一下，需要更多时间
push(1) push(2) push(3) : 放到primary里
primary: 3 -> 2 -> 1
buffer:

pop() ： primary里出来进buffer，直到剩一个。再把buffer放回primary
primary: 3 -> 2 -> 1       -->        primary: 3           --->          primary: 2 -> 1
buffer:                               buffer:2 -> 1                      buffer: 

**/
//1
class MyStack {
    Queue<Integer> primary = new LinkedList<>();
    Queue<Integer> buffer = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        while (primary.size() > 0) {
            buffer.offer(primary.poll());
        }
        primary.offer(x);
        while (buffer.size() > 0) {
            primary.offer(buffer.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return primary.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return primary.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return primary.size() == 0;
    }
}


//2
class MyStack {
    Queue<Integer> primary = new LinkedList<>();
    Queue<Integer> buffer = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        primary.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (primary.size() > 1) {
            buffer.offer(primary.poll());
        }
        int result = primary.poll();
        Queue<Integer> temp = primary;
        primary = buffer;
        buffer = temp;
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        while (primary.size() > 1) {
            buffer.offer(primary.poll());
        }
        int result = primary.peek();
        buffer.offer(primary.poll());
        Queue<Integer> temp = primary;
        primary = buffer;
        buffer = temp;
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return primary.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */