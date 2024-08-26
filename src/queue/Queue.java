package queue;

public class Queue {

    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int count;
    
    public Queue(int size)
    {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }
    
    public void add(int value) // Kuyruga eleman ekleme metodu
    {
        if(isFull())
        {
            System.out.println("Kuyruk Dolu!");
        }
        else
        {
            if(rear == maxSize -1)
            {
                rear = -1;
            }
            queueArray[++rear] = value;
            count++;
            System.out.println(value + " kuyruga eklendi.");
        }
    }
    
    public int delete() // Kuyruktan eleman cikarma metodu
    {
        if(isEmpty())
        {
            System.out.println("Kuyruk Bos!");
            return -1;
        }
        else
        {
            int temp = queueArray[front++];
            if(front == maxSize)
            {
                front = 0;
            }
            count--;
            System.out.println(temp + " kuyruktan cikarildi.");
            return temp;
        }  
    }
    
    public int peek() // Kuyrugun en on sırasindaki elemani bulma metodu;
    {
        if(isEmpty())
        {
            System.out.println("Kuyruk bos!");
            return -1;
        }
        else
        {
            return queueArray[front];
        }
    }
    
    private boolean isEmpty() // Kuyruk bos mu kontrol metodu
    {
        return (count == 0);
    }
    
    private boolean isFull() // Kuyruk dolu mu kontrol metodu
    {
        return (count == maxSize);
    }
    
    public int size() // Kuyruktaki toplam eleman sayisini bulma metodu
    {
        return count;
    }
    
    public static void main(String[] args) {
    
        Queue queue = new Queue(5);
        
        queue.add(6);
        queue.add(18);
        queue.add(52);
        
        System.out.println("Kuyruktaki eleman sayisi : " + queue.size());
        
        System.out.println("Kuyrugun en on sirasindaki eleman : " + queue.peek());
        
        queue.delete();
        
        System.out.println("Kuyruktaki eleman sayisi : " + queue.size());

        System.out.println("Kuyrugun en on sirasindaki eleman : " + queue.peek());

    }
}
