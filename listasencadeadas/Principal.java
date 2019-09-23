package listasencadeadas;

public class Principal {

    public static void main(String[] args) {
        
        ListaDuplamenteEncadeada<Aluno> lista = new ListaDuplamenteEncadeada<Aluno>();
        
        lista.add(new Aluno("Paulo", "123456"));
        lista.add(new Aluno("Maria", "456789"));
        lista.add(new Aluno("Pedro", "123789"));
        lista.add(new Aluno("Julia", "456123"));
        lista.add(new Aluno("Jayme", "354689"));
        
        lista.printList();
        
        System.out.println("\nGET");
        System.out.println("Indice 0: "+lista.get(0));
        System.out.println("Indice 2: "+lista.get(2));
        System.out.println("Indice "+(lista.size()-1)+": "+lista.get(lista.size()-1));
        
        System.out.println("\nINDEXOF");
        System.out.println("Indice de Paulo: "+lista.indexOf(new Aluno("Paulo", "123456")));
        System.out.println("Indice de Jayme: "+lista.indexOf(new Aluno("Jayme", "354689")));
        System.out.println("Indice de Pedro: "+lista.indexOf(new Aluno("Pedro", "123789")));

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
        lista.add(new Aluno("Mariana", "652314"), 3);
        lista.add(new Aluno("Pedro", "123789"), lista.size());
        
        lista.printList();
        
        /*lista.add(new Aluno("Marcelo", "963258"), 0);
        lista.add(new Aluno("Ivan", "562314"), lista.size());
        lista.add(new Aluno("Jorge", "854123"), lista.size() + 1); //Não será adicionado
        lista.add(new Aluno("Luiza", "159487"), 4);
        
        System.out.println("");
        lista.printList();
        
        lista.remove(0);
        lista.remove(lista.size());//Não remove nada
        lista.remove(1);
        lista.remove(lista.size()-1);//remove ultimo elemento
        
        System.out.println("\nRemove");
        lista.printList();
        
        lista.set(new Aluno("Ivan", "562314"), lista.size()-1);
        lista.set(new Aluno("Marcelo", "963258"), 0);
        lista.set(new Aluno("Luiza", "159487"), 2);
        
        System.out.println("\nSet");
        lista.printList();*/
        
    }
    
}
