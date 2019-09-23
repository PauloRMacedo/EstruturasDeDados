package listasencadeadas;

public class ListaEncadeadaCircular <Type> {
    
    private ListNode head;
    private ListNode tail;
    private ListNode previous;
    private int size;
    
    private class ListNode {
        private Type element;
        private ListNode next;
        
        private ListNode(Type element, ListNode next){
            this.element = element;
            this.next = next;
        }     
    }
    
    public ListaEncadeadaCircular(){
        head = tail = previous = null;
        size = 0;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return (size == 0);
    }
    
    public void clear(){
        head = tail = previous = null;
        size = 0;
    }
    
    public void add(Type elem){
        ListNode newElement = new ListNode(elem, head);
        if(isEmpty()){
            head = newElement;
        } else {
            tail.next = newElement;
        }
        tail = newElement;
//        System.out.println("\nTail: "+tail.element+"\n");
        size++;
    }
    
    public void add(Type elem, int index){
        if(index < 0 || index > size){
           return; 
        } else {
            findPrevious(index);
            ListNode newElement = new ListNode(elem, previous.next);
            previous.next = newElement;
            if(index == 0){
                head = newElement;
            } else if(index == size){
                tail = newElement;
//                System.out.println("\ntail = "+tail.element+"\n");
            }
            size++;
        }       
    }
    
    public void set(Type elem, int index){
        if(index < 0 || index >= size){
            return;
        } else {
            findPrevious(index);
            previous.next.element = elem;
            if(index == 0){
                head.element = elem;
//                System.out.println("\nHead "+head.element+"\nTail.next "+tail.next.element);
            }
        }
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
    
    public void remove(int index){
        if(index < 0 || index >= size){
            return;
        } else {
            if(index == 0){ //remove o head
                if(tail == head){ //lista com um elemento
                    head = null;
                } else {
                    head = head.next;
                }
                tail = head;
            } else { //remove em qualquer outra posição
                findPrevious(index);
//                System.out.println("\n Previous de "+index+" | "+previous.element+"\n");
                previous.next = previous.next.next;
                if(index == size - 1){ //remove o tail
                    tail = previous;                                        
                }
            }
            size--;
        }
    }
    
    private void findPrevious(int index){
        ListNode search = head;
        previous = tail;
        for(int i = 0; i < index; i++){
            previous = search;
            search = search.next;
        }
//        System.out.println("\n index"+index+" previous "+previous.element);

    }
        
    public void printList(){
        ListNode itr = head;
        for (int i = 0; i < size; i++) {
            System.out.println(i+" "+itr.element);
            itr = itr.next;
        }
    }
    
}
