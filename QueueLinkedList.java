public class QueueLinkedList {
    
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class Queue {
        Node front;
        Node rear;
        int size; // menyimpan jumlah item

        Queue() {
            front = null;
            rear = null;
            size = 0;
        }
        
        void enqueue(int data) {
            Node newNode = new Node(data);

            if (rear == null) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }

            size++;
        }
       
        void dequeue() {
            if (front == null) {
                System.out.println("Queue kosong");
                return;
            }

            front = front.next;
            size--;

            if (front == null) {
                rear = null;
            }
        }
       
        int getJumlahItem() {
            return size;
        }
    }

    public static void main(String[] args) {

        Queue queueL = new Queue();

        queueL.enqueue(10);
        queueL.enqueue(20);
        queueL.enqueue(30);

        System.out.println("Jumlah item dalam antrian: " + queueL.getJumlahItem());

        queueL.dequeue();

        System.out.println("Jumlah item setelah dequeue: " + queueL.getJumlahItem());
    }
}