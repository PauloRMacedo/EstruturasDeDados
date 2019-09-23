package listasencadeadas;

public class Principal {

    public static void main(String[] args) {
        
        ListaDuplamenteEncadeadaCircular<Aluno> lista = new ListaDuplamenteEncadeadaCircular<Aluno>();
        
        lista.add(new Aluno("Ana", "123456"));
        lista.add(new Aluno("Carlos", "456789"));
        lista.add(new Aluno("Silas", "123789"));
        lista.add(new Aluno("Davi", "456123"));
        lista.add(new Aluno("Roberto", "354689"));
        
        lista.printList();
        
        System.out.println("\nGET");
        System.out.println("Indice 0: "+lista.get(0));
        System.out.println("Indice 2: "+lista.get(2));
        System.out.println("Indice "+(lista.size()-1)+": "+lista.get(lista.size()-1));
        
        System.out.println("\nINDEXOF");
        System.out.println("Indice de Ana: "+lista.indexOf(new Aluno("Ana", "123456")));
        System.out.println("Indice de Carlos: "+lista.indexOf(new Aluno("Carlos", "456789")));
        System.out.println("Indice de Roberto: "+lista.indexOf(new Aluno("Roberto", "354689")));

        System.out.println("\nSET");
        lista.set(new Aluno("Jorge", "123456"), 0);
        System.out.println("Mudando item no indice 0 para: "+lista.get(0));
        
        lista.set(new Aluno("Marcos", "354689"), lista.size()-1);
        System.out.println("Mudando item no indice "+(lista.size()-1)+" para: "+lista.get(lista.size()-1));
        
        lista.set(new Aluno("Lúcia", "123789"), 2);
        System.out.println("Mudando item no indice 2 para: "+lista.get(2));
        
        lista.printList();
        
        System.out.println("\nREMOVE");
        System.out.println("Item no indice 0 removido? "+lista.remove(0));
        System.out.println("Item no indice 2 removido? "+lista.remove(2));
        System.out.println("Item no indice "+(lista.size()-1)+" removido? "+lista.remove(lista.size()-1));
        
        lista.printList();
        
        lista.add(new Aluno("Paulo", "123456"), 0);
        lista.add(new Aluno("Jayme", "354689"), 1);
        lista.add(new Aluno("Mariana", "652314"), 1);
        lista.add(new Aluno("Matheus", "123789"), lista.size());
        
        lista.printList();
                       
    }
    
}
