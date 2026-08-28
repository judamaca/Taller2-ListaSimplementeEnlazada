import java.util.Iterator;

public class MiLista implements ListInterface{
    ListNode cabeza;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getSize() {
        ListNode iterador = this.cabeza;
        int contador = 1;
        while (iterador.siguiente != null){
            iterador = iterador.siguiente;
            contador = contador + 1;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;
        return;
    }

    @Override
    public Object getHead() {
        if (this.cabeza == null) {
            return null;
        }
        return this.cabeza.dato;
    }


    @Override
    public Object getTail() {
        if(this.cabeza == null){
            return null;
        }else {
            ListNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;
            }
            return iterador.dato;
        }
    }

    @Override
    public Object get(ListNode node) {
        if (node == null) {
            return null;
        }
        return node.dato;
    }

    @Override
    public Object search(Object object) {
        try {
            if (this.cabeza == null) {
                System.out.println("Sin contenido");
                return false;
            }
            ListNode actual = this.cabeza;
            while (actual != null) {
                if (actual.dato != null && actual.dato.equals(object)) {
                    System.out.println("Objeto encontrado");
                    return actual.dato;
                }
                actual = actual.siguiente;
            }
            return null;
        }
        catch (Exception e) {
            System.out.println("Ocurrió un error");
            return null;
        }
    }

    @Override
    public boolean add(Object object) {
        ListNode newNode = new ListNode(object);
        try {
            if (this.cabeza == null) {
                this.cabeza = newNode;
                return true;
            }
            ListNode actual = this.cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = newNode;
            return true;
        }
        catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insert(ListNode node, Object object) {

        return false;
    }

    @Override
    public boolean insert(Object ob, Object object) {
        return false;
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            // 1er paso: Crear el nuevo nodo con la información recibida
            ListNode nuevaCabeza = new ListNode(object);
            //2do paso: Conectar el nodo a la cabeza
            nuevaCabeza.siguiente = this.cabeza;
            //3er paso: redefinir la cabeza
            this.cabeza = nuevaCabeza;
            return true;
        } catch (Exception e){
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        if(this.cabeza == null){
            ListNode nuevaCabeza = new ListNode(object);
            this.cabeza = nuevaCabeza;
        }else {
            ListNode nuevaCola = new ListNode(object);
            ListNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;

            }
            iterador.siguiente = nuevaCola;
        }
        return true;

    }

    @Override
    public boolean set(ListNode node, Object object) {
        return false;
    }

    @Override
    public boolean remove(ListNode node) {
        return false;
    }

    @Override
    public boolean contains(Object object) {
        try {
            if (this.cabeza == null) {
                System.out.println("Sin contenido");
                return false;
            }
            ListNode actual = this.cabeza;
            while (actual != null) {
                if (actual.dato != null && actual.dato.equals(object)) {
                    System.out.println("Sí está contenido el dato");
                    return true;
                }
                actual = actual.siguiente;
            }
            return false;
        }
        catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public Iterator<ListNode> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] object) {
        return new Object[0];
    }

    @Override
    public Object getBeforeTo() {
        return null;
    }

    @Override
    public Object getBeforeTo(ListNode node) {
        return null;
    }

    @Override
    public Object getNextTo() {
        return null;
    }

    @Override
    public Object getNextTo(ListNode node) {
        return null;
    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {
        return null;
    }

    @Override
    public MiLista sortList() {
        return null;
    }

    @Override
    public String toString() {
        return "MiLista{" +
                "cabeza=" + cabeza +
                '}';
    }
}
