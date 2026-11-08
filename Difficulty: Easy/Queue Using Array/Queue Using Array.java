class myQueue {

    // Queue Pattern - Same Problem 622. Design Circular Queue Leetcode
    int[] queue;
    int front=-1,rear=-1;
    int size;
    // Constructor
    public myQueue(int n) {
        // Define Data Structures
        queue= new int[n];
        size=n;
    }

    public boolean isEmpty() {
        // Check if queue is empty
        if(front==-1 && rear==-1){
            return true;
        }
    return false;
    }

    public boolean isFull() {
        // Check if queue is full
        if(front==0 && rear==size-1 || front==rear+1){
            return true;
        }
    return false;
    }

    public void enqueue(int x) {
        // Enqueue
        if(!isFull()){
            if(front==-1 && rear==-1){
                front=0;
                rear=0;
                queue[rear]=x;
            }
            else{
                rear=(rear+1)%size;
                queue[rear]=x;
            }
            
            
        }
    }

    public void dequeue() {
        // Dequeue
        if(!isEmpty()){
            if(front==rear){
                front=-1;
                rear=-1;
            }
            else{
                front=(front+1)%size;
            
            }
            
        }
    }

    public int getFront() {
        // Get front element
        if(!isEmpty()){
            return queue[front];
        }
    return -1;
    }

    public int getRear() {
        // Get last element
        if(!isEmpty()){
            return queue[rear];
        }
    return -1;
    }
}














