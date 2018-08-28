/**
用两个stack来回交替，有两种方法：
1. push时倒腾一下，需要更多时间， pop和top直接操作
push(1) 放到primary里
primary: 1
buffer:

push(2) 把primary放到buffer里， push进primary， 再把buffer放回primary
primary: 1          -->         primary: 2              --->    primary: 2 -> 1
buffer:                         buffer:1                        buffer:

push(3) 
primary:  2 -> 1       --->     primary: 2      -->     primary: 3              --->    primary:  3 -> 2 -> 1
buffer:                         buffer:1        -->     buffer:1 -> 2                   buffer:

pop() ： 直接拿出一个
primary: 3 -> 2 -> 1           
buffer: 


2. push直接放入，pop和top需要倒腾一下，需要更多时间
push(1) push(2) push(3) : 放到primary里
primary: 1 -> 2 -> 3
buffer:

pop() ： primary里出来进buffer，直到剩一个。再把buffer放回primary
primary: 1 -> 2 -> 3       -->        primary: 1           --->          primary: 2 -> 3
buffer:                               buffer:3 -> 2                      buffer: 

**/

//1 
class MyQueue {
    Stack<Integer> primary = new Stack<>();
    Stack<Integer> buffer = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (primary.size() > 0) {
            buffer.push(primary.pop());
        }
        primary.push(x);
        while (buffer.size() > 0) {
            primary.push(buffer.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return primary.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return primary.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return primary.size() == 0;
    }
}


//2
class MyQueue {
    Stack<Integer> primary = new Stack<>();
    Stack<Integer> buffer = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        primary.push(x);
        
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (primary.size() > 1) {
            buffer.push(primary.pop());
        }
        int result = primary.pop();
        while (buffer.size() > 0) {
            primary.push(buffer.pop());
        }
        return result;
    }
    
    /** Get the front element. */
    public int peek() {
        while (primary.size() > 1) {
            buffer.push(primary.pop());
        }
        int result = primary.peek();
        while (buffer.size() > 0) {
            primary.push(buffer.pop());
        }
        return result;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return primary.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */