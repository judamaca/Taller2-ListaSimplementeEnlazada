import java.util.Arrays;
import java.util.Iterator;

public class MiLista implements ListInterface{
    ListNode cabeza;

    @Override
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    @Override
    public int getSize() {
        ListNode iterador = this.cabeza;
        int contador = 0; // Iniciamos en 0 por si la lista está vacía
        while (iterador != null) { // Evaluamos el nodo actual
            contador++;
            iterador = iterador.siguiente;
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
        if(this.cabeza == null) {
            return null;
        }
        ListNode iterador = this.cabeza;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
        }
        return iterador.dato;
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
        ListNode actual = this.cabeza;
        while (actual != null) {
            if (actual.dato != null && actual.dato.equals(object)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        ListNode newNode = new ListNode(object);
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


    @Override
    public boolean insert(ListNode node, Object object) {
        try {
            if (this.cabeza == null) {
                return false;
            }
            ListNode newNode = new ListNode(object);
            ListNode actual = this.cabeza;
            while (actual != null) {
                if (node == actual) {
                    newNode.siguiente = actual.siguiente;
                    actual.siguiente = newNode;
                    return true;
                }
                actual = actual.siguiente;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insert(Object ob, Object object) {

        if (this.cabeza == null || ob == null) {
            return false;
            }

        ListNode newNode = new ListNode(object);
        ListNode actual = this.cabeza;

        while (actual != null) {
            if (ob.equals(actual.dato)) {
                newNode.siguiente = actual.siguiente;
                actual.siguiente = newNode;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public boolean insertHead(Object object) {
        ListNode nuevaCabeza = new ListNode(object);
        nuevaCabeza.siguiente = this.cabeza;
        this.cabeza = nuevaCabeza;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        ListNode nuevoNodo = new ListNode(object);

        if(this.cabeza == null) {
            this.cabeza = nuevoNodo;
            return true;
        }
        ListNode iterador = this.cabeza;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
        }
        iterador.siguiente = nuevoNodo;
        return true;
    }

    @Override
    public boolean set(ListNode node, Object object) {
        if (this.cabeza == null || node == null) {
            return false;
        }
        ListNode actual = this.cabeza;
        while (actual != null) {
            if (node == actual) {
                actual.dato = object;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public boolean remove(ListNode node) {
        if (node == null) {
            return false;
        }
        if (node == this.cabeza) {
            this.cabeza = this.cabeza.siguiente;
            return true;
        }
        ListNode actual = this.cabeza;
        while (actual != null && actual.siguiente != null) {
            if (actual.siguiente == node) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public boolean contains(Object object) {
        ListNode actual = this.cabeza;
        while (actual != null) {
            if (actual.dato.equals(object)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }


    @Override
    public Object[] toArray() {
        if (this.cabeza == null) return new Object[0];
        ListNode iterador = this.cabeza;
        int contador = 1;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
            contador++;
        }

        Object[] arreglo = new Object[contador];
        int i = 0;
        iterador = this.cabeza;

        while (iterador != null) {
            arreglo[i] = iterador.dato;
            i++;
            iterador = iterador.siguiente;
        }
        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {

        int contador = 0;
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            contador++;
            iterador = iterador.siguiente;
        }

        Object[] destino = object;
        if (destino.length < contador) {
            destino = new Object[contador];
        }

        int i = 0;
        iterador = this.cabeza;
        while (iterador != null) {
            destino[i] = iterador.dato;
            i++;
            iterador = iterador.siguiente;
        }

        if (destino.length > contador) {
            destino[contador] = null;
        }
        return destino;
    }

    @Override
    public Object getBeforeTo(ListNode node) {

        if (this.cabeza == null || node == null) {
            return null;
        }

        if (this.cabeza == node) {
            return null;
        }

        ListNode actual = this.cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente == node) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }


    @Override
    public Object getNextTo(ListNode node) {
        if (node == null) {
            return null;
        }
        return node.siguiente;
    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {
        MiLista sub = new MiLista();
        if (from == null || to == null) {
            return sub;
        }
        ListNode actual = from;
        boolean finAlcanzado = false;

        while (actual != null) {
            sub.add(actual.dato);
            if (actual == to) {
                finAlcanzado = true;
                break;
            }
            actual = actual.siguiente;
        }
        if (!finAlcanzado) {
            return new MiLista();
        }
        return sub;
    }

    @Override
    public MiLista sortList() {
        Object[] arreglo = this.toArray();


        Arrays.sort(arreglo);
        ListNode actual = this.cabeza;
        int i = 0;
        while (actual != null) {
            actual.dato = arreglo[i];
            i++;
            actual = actual.siguiente;
        }
        return this;
    }

    @Override
    public String toString() {
        return "MiLista{" +
                "cabeza=" + cabeza +
                '}';
    }
}
