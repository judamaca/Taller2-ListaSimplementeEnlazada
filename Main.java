
void main() {
    MiLista miLista = new MiLista();
    System.out.println(miLista.toString());

    miLista.insertHead(0);

//  System.out.println(miLista.toString());
    miLista.insertHead("Juan");
//  miLista.insertHead("Albert Einstein");

//  System.out.println(miLista.toString());

    miLista.insertTail("Angela");

    System.out.println(miLista.toString());
    System.out.println(miLista.getSize());


    System.out.println(miLista.toString());

    miLista.insertTail(155);
    System.out.println(miLista.toString());
    miLista.getSize();
    System.out.println(miLista.getSize());
    System.out.println(miLista.getHead());
    System.out.println(miLista.getTail());

    System.out.println(miLista.get(miLista.cabeza));
    miLista.add("Juansebaschu");

    System.out.println(miLista.contains("Juansebascho"));
    System.out.println(miLista.search("Angela"));

    miLista.insert(miLista.cabeza.siguiente.siguiente, "Juju");
    miLista.insert("Juju", "Jojo");
    miLista.set(miLista.cabeza.siguiente, "AAAAAAAGHHCHU");

    System.out.println(miLista.toString());


}
