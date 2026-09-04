
void main() {
    System.out.println("====== INICIANDO PRUEBAS DE MILISTA ======\n");
    MiLista lista = new MiLista();

    // 1. isEmpty() y getSize() iniciales
    System.out.println("1. ¿Lista vacía al inicio?: " + lista.isEmpty());
    System.out.println("   Tamaño inicial: " + lista.getSize());

    // 2. add(Object)
    System.out.println("\n2. Agregando elementos (10, 20, 30)...");
    lista.add(10);
    lista.add(20);
    lista.add(30);
    System.out.println("   Tamaño ahora: " + lista.getSize());
    System.out.println("   Contenido actual (toArray): " + Arrays.toString(lista.toArray()));

    // 3. insertHead(Object) e insertTail(Object)
    System.out.println("\n3. Probando insertHead(5) e insertTail(40)...");
    lista.insertHead(5);
    lista.insertTail(40);
    System.out.println("   Contenido actual: " + Arrays.toString(lista.toArray()));

    // 4. getHead() y getTail()
    System.out.println("\n4. getHead(): " + lista.getHead());
    System.out.println("   getTail(): " + lista.getTail());

    // 5. search(Object) y contains(Object)
    System.out.println("\n5. search(20) [Debe devolver 20]: " + lista.search(20));
    System.out.println("   contains(50) [Debe ser false]: " + lista.contains(50));
    System.out.println("   contains(10) [Debe ser true]: " + lista.contains(10));

    // 6. insert(Object, Object) -> (Objeto_buscado, Objeto_a_insertar)
    System.out.println("\n6. insert(Object, Object) - Insertar '25' después del '20':");
    lista.insert((Object) 20, (Object) 25);
    System.out.println("   Contenido actual: " + Arrays.toString(lista.toArray()));

        /* ==========================================================
           Pruebas de métodos que requieren un objeto ListNode
           ========================================================== */
    System.out.println("\n====== PRUEBAS CON NODOS (ListNode) ======");

    // Estado actual esperado: [5, 10, 20, 25, 30, 40]
    // Vamos a capturar el nodo que contiene el '20' (es el tercer nodo)
    ListNode nodo20 = lista.cabeza.siguiente.siguiente;

    // 7. get(ListNode)
    System.out.println("7. get(nodo20): " + lista.get(nodo20));

    // 8. insert(ListNode, Object)
    System.out.println("\n8. insert(ListNode, Object) - Insertar '22' después del nodo con 20:");
    lista.insert(nodo20, 22);
    System.out.println("   Contenido actual: " + Arrays.toString(lista.toArray()));

    // 9. set(ListNode, Object)
    System.out.println("\n9. set(ListNode, Object) - Cambiar el valor del nodo '20' a '99':");
    lista.set(nodo20, 99);
    System.out.println("   Contenido actual: " + Arrays.toString(lista.toArray()));

    // 10. getBeforeTo(ListNode) y getNextTo(ListNode)
    // Nota: Como devuelve Object, hacemos un cast a ListNode para poder imprimir su dato
    ListNode nodoAnterior = (ListNode) lista.getBeforeTo(nodo20);
    ListNode nodoSiguiente = (ListNode) lista.getNextTo(nodo20);
    System.out.println("\n10. getBeforeTo(nodo99) [Debe ser 10]: " + (nodoAnterior != null ? nodoAnterior.dato : "null"));
    System.out.println("    getNextTo(nodo99) [Debe ser 22]: " + (nodoSiguiente != null ? nodoSiguiente.dato : "null"));

    // 11. remove(ListNode)
    System.out.println("\n11. remove(nodo99) - Eliminando ese nodo específico:");
    lista.remove(nodo20);
    System.out.println("   Contenido actual: " + Arrays.toString(lista.toArray()));

    // 12. toArray(Object[])
    System.out.println("\n12. toArray(Object[]) con un array preexistente de tamaño 10:");
    Object[] arrayDestino = new Object[10];
    arrayDestino = lista.toArray(arrayDestino);
    System.out.println("    Resultado: " + Arrays.toString(arrayDestino));

    // 13. subList(ListNode, ListNode)
    System.out.println("\n13. subList(from, to):");
    ListNode from = lista.cabeza.siguiente; // El segundo nodo (actualmente 10)
    ListNode to = from.siguiente.siguiente; // Dos nodos más adelante (actualmente 25)
    MiLista sublista = lista.subList(from, to);
    System.out.println("    Sublista extraída: " + Arrays.toString(sublista.toArray()));

    // 14. sortList()
    System.out.println("\n14. sortList() - Desordenando y aplicando sortList:");
    lista.insertHead(100);
    lista.add(1);
    lista.insertHead(50);
    System.out.println("    Antes de ordenar : " + Arrays.toString(lista.toArray()));
    lista.sortList();
    System.out.println("    Después de ordenar: " + Arrays.toString(lista.toArray()));

    // 15. toString() e iterator()
    System.out.println("\n15. toString() original: " + lista.toString());
    System.out.println("    iterator(): " + lista.iterator());

    // 16. clear()
    System.out.println("\n16. clear() - Vaciando la lista por completo...");
    lista.clear();
    System.out.println("    ¿isEmpty() ahora?: " + lista.isEmpty());
    System.out.println("    getSize() ahora?: " + lista.getSize());

    System.out.println("\n====== PRUEBAS FINALIZADAS ======");
}
