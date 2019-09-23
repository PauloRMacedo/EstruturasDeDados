package listasencadeadas;

public class ListaDuplamenteEncadeada <Type>{
    
    private ListNode head;
    private ListNode tail;
    private ListNode node;
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
    
    public ListaDuplamenteEncadeada(){
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
        if(head == null){
            ListNode newElement = new ListNode(elem, null, null);
            head = tail = newElement;
        } else {
            ListNode newElement = new ListNode(elem, tail, null);
            tail.next = newElement;
            tail = newElement;
        }
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
            for(int i = 0; i < index; i++){
                search = search.next;
            }
            return search.element;
        }
    }
    
    public void set(Type elem, int index){
        if(index < 0 || index >= size){
            return;
        } else {
            findNode(index);
            node.element = elem;
        }
    }
    
    private void findNode(int index){
        node = head;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
    }
    
    public boolean remove(int index){
        if(index < 0 || index >= size){
            return false;
        } else if(index == 0) {
            if(head.equals(tail)){
                head = tail = null;
            } else {
                head = head.next;
                head.previous = null;
            }
        } else {
            findNode(index);
            if(node.equals(tail)){
                tail = node.previous;
                tail.next = null;
            } else {
                node.previous.next = node.next;
                node.next.previous = node.previous;
            }
        }
        size--;
        return true;
    }
    
    public void add(Type elem, int index){
        if(index < 0 || index > size){
            return;
        } else {
            if(index == 0){
                if(head == null){
                    ListNode newElement = new ListNode(elem, null, null);
                    head = newElement;
                } else {
                    ListNode newElement = new ListNode(elem, null, head);
                    head = newElement;
                }
            } else {
                if(index == size){
                    tail.next = new ListNode(elem, tail, null);
                    tail = tail.next;
                } else {
//                    return;
                    findNode(index-1); //Acha o anterior
                    node.next = new ListNode(elem, node, node.next);
                    node.previous = node.next;
//                    node = newElement;
                }
            }
            size++;
        }
    }
    
    public void printList(){
        System.out.println("\nLISTA DUPLAMENTE ENCADEADA");
        ListNode print = head;
        for (int i = 0; i < size; i++) {
            System.out.println("Índice "+i+": "+print.element);
            print = print.next;
        }
//        System.out.println("Tail = "+tail.element);
    }
    
}
