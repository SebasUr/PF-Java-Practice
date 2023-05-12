public class Wrapper {
    public int valor;

    public void modificarObjeto(Wrapper obj) {
        obj.valor = 10;
    }

    public void testModificarObjeto() {
        Wrapper objeto = new Wrapper();
        objeto.valor = 5;

        System.out.println("Valor antes de modificarObjeto(): " + objeto.valor);
        modificarObjeto(objeto);
        System.out.println("Valor después de modificarObjeto(): " + objeto.valor);
    }

    public static void main(String[] args) {
        Wrapper wrapper = new Wrapper();
        wrapper.testModificarObjeto();
    }
}
