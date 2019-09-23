package listasencadeadas;

public class ListaDuplamenteEncadeadaCircular <Type> {
    
    private ListNode head;
    private ListNode tail;
    private int size;
    
    private class ListNode{
        private Type element;
        private ListNode next;
        private ListNode previous;
        
        private ListNode(Type element, ListNode previous, ListNode next){
            this.element = element;
            this.previous = previous;
            this.next = next;
        }        
    }
    
    public int size(){
        return size;
    }
    
    public void clear(){
        tail = head = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return (size == 0);
    }
    
    public void add(Type elem){
        ListNode newElement = new ListNode(elem, head, head);
        if(head == null){
            head = newElement;
        } else {
            newElement.previous = tail;
            tail.next = newElement;
        }
        tail = newElement;
        size++;
    }
    
    
    
    public void printList(){
        ListNode print = head;
        System.out.println("\nLISTA DUPLAMENTE ENCADEADA CIRCULAR");
        for (int i = 0; i < size; i++) {
            System.out.println("Índice "+i+": "+print.element);
            print = print.next;
        }
    }
    
}
