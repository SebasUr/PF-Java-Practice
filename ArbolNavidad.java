public class ArbolNavidad {

    public static void main(String[] args) {
        dibujarArbol(5, 4);
    }

    public static void dibujarArbol(int numSegmentos, int alturaSegmento) {
        int alturaTotal = numSegmentos * alturaSegmento;

        // Dibujar cada segmento del árbol
        for (int segmento = 1; segmento <= numSegmentos; segmento++) {
            // Dibujar cada fila del segmento
            for (int fila = 1; fila <= alturaSegmento; fila++) {
                // Calcular el número de espacios en cada fila
                int espacios = alturaTotal - fila;

                // Dibujar los espacios en blanco
                for (int i = 0; i < espacios; i++) {
                    System.out.print(" ");
                }

                // Dibujar los asteriscos
                for (int i = 1; i <= (2 * fila - 1); i++) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }

        // Dibujar el tronco del árbol
        int espaciosTronco = alturaTotal - alturaSegmento;
        for (int i = 0; i < espaciosTronco; i++) {
            System.out.print(" ");
        }
        System.out.println("*");
    }
}
