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
    
    public ListaDuplamenteEncadeadaCircular(){
        head = tail = null;
        size = 0;
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
    
    public int indexOf(Type elem){
        ListNode search = head;
        for(int i = 0; i < size; i++){
            if(search.element.equals(elem)){
                return i;
            }
            search = search.next;
        }
        return -1;
    }
    
    public Type get(int index){
        if(index < 0 || index >= size){
            return null;
        } else {
            ListNode search = head;
            for (int i = 0; i < index; i++) {
                search = search.next;
            }
            return search.element;
        }
    }
    
    public void set(Type elem, int index){
        if (index < 0 || index >= size) {
            return;
        } else {
            ListNode set = findPrevious(index);
            set.element = elem;
        }
    }
    
    public boolean remove(int index){
        if(index < 0 || index >= size){
            return false;
        } else {
            if(index == 0){
                if(head.equals(tail)){
                    head = tail = null;
                } else {
                    head = head.next;
                    head.previous = tail;
                }
            } else {
                if(index == size - 1){
                    tail = tail.previous;
                    tail.next = head;
                } else {
                    ListNode delete = findPrevious(index);
                    delete.next = delete.next.next;
                    delete.next.previous = delete;
                }
            }
            size--;
            return true;
        }
    }
    
    public void add(Type elem, int index){
        if(index < 0 || index > size){
            return;
        } else {
            
        }
    }
    
    private ListNode findPrevious(int index){
        ListNode search = tail;
        for (int i = 0; i < index; i++) {
            search = search.next;
        }
        return search;
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
