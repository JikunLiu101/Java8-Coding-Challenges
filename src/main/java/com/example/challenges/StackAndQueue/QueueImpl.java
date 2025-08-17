package com.example.challenges.StackAndQueue;

import java.util.Stack;

public class QueueImpl {
    public class MyQueue{
        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        public MyQueue(){
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void push(int x){
            stackIn.push(x);
        }

        public int pop(){
            if (stackOut.isEmpty()){
                while (!stackIn.isEmpty()){
                    stackOut.push(stackIn.pop());
                }
            }
            return (int) stackOut.pop();
        }

        public int peek(){
            int res = pop();
            stackOut.push(res);
            return res;
        }

        public boolean empty(){
            return stackOut.isEmpty() && stackIn.isEmpty();
        }
    }
}
