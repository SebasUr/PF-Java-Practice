public class Taller6 {
    public static void main(String[] args){
        System.out.println(printPowersOf3(3));

        printGrid(4,6);

        System.out.println(invertirNombre("Sebas"));
    }

    // METHODS ----------------------------------------------------------------------.
    public static String printPowersOf3(int n){
        String text = "";
        for(double i=0; i<n; i++){
            double actualNum = Math.pow(3.0,i);
            text = text + (int)actualNum + " ";
        }
        return text;
    }

    public static void printGrid(int numFilas, int numCols){
        int[][] grid = new int[numFilas][numCols];
        int sum= 0;
        for(int i=0; i<numFilas; i++){
            for(int j=0; j<numCols; j++){
                sum++;
                grid[i][j] = sum;
            }
        }

        for(int i=0; i<numFilas; i++){
            for(int j=0; j<numCols; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String invertirNombre(String s){
        String invertido = "";
        for(int i=s.length()-1; i>=0; i--){
            invertido += s.charAt(i);
        }
        return invertido;
    }

    public static void dibujarArbol(int numSegmentos, int alturaSegmento) {
        int alturaTotal = numSegmentos * alturaSegmento;
        for (int segmento = 1; segmento <= numSegmentos; segmento++) {
            for (int fila = 1; fila <= alturaSegmento; fila++) {
                int espacios = alturaTotal - fila;
                for (int i = 0; i < espacios; i++) {
                    System.out.print(" ");
                }
                for (int i = 1; i <= (2 * fila - 1); i++) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }
        int espaciosTronco = alturaTotal - alturaSegmento;
        for (int i = 0; i < espaciosTronco; i++) {
            System.out.print(" ");
        }
        System.out.println("*");
    }

} 

class PorValorYPorReferencia{
    
}
