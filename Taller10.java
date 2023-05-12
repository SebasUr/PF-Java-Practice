import java.util.Random;
public class Taller10 {

    public static void main(String[] args){
            // Personas ----------------------------------------------------------.

/*         int capacidad = 10;
        ColeccionPersonas coleccion = new ColeccionPersonas(capacidad);
        coleccion.popularPersonas(capacidad);
        System.out.println("Personas antes de ordenar:");
        coleccion.imprimir();
        coleccion.ordenar();
        System.out.println("\nPersonas después de ordenar:");
        coleccion.imprimir(); */

            // Libros ------------------------------------------------------------.

        int Cantcoleccion = 3;
        Libro uno = new Libro("Cien años de soledad", "Gabriel Marquez", 542);
        Libro dos = new Libro("Crimen y castigo", "Gabriel Marquez", 432);
        Libro tres = new Libro("El principito", "Antoine de Saint", 115);
        Libro cuatro = new Libro("El extranjero", "Albert Camus", 130);


        ColeccionLibros misLibros = new ColeccionLibros(3);
        misLibros.popularLibros(uno);
        misLibros.popularLibros(dos);
        misLibros.popularLibros(tres);
        misLibros.popularLibros(cuatro);

        System.out.println(misLibros.escritorConMasLibros());
        System.out.println(misLibros.escritorMasProlijo());
        System.out.println(misLibros.tituloMasLargo());


    }
}

class Persona {
    private String nombre;
    private char genero;
    private int edad;
    private double peso;

    public Persona(String nombre, char genero, int edad, double peso) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public char getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", edad=" + edad +
                ", peso=" + peso +
                '}';
    }
}

class ColeccionPersonas {
    private Persona[] personas;

    public ColeccionPersonas(int capacidad) {
        personas = new Persona[capacidad];
    }

    public void popularPersonas(int n) {
        Random rnd = new Random();
        String[] nombres = {"Juan", "Pedro", "María", "Ana", "Luis", "Lucía"};
        char[] generos = {'M', 'F'};
        for (int i = 0; i < n; i++) {
            String nombre = nombres[rnd.nextInt(nombres.length)];
            char genero = generos[rnd.nextInt(generos.length)];
            int edad = rnd.nextInt(50) + 18; // edades entre 18 y 67 años
            double peso = rnd.nextDouble() * 50 + 50; // pesos entre 50 y 100 kg
            Persona persona = new Persona(nombre, genero, edad, peso);
            personas[i] = persona;
        }
    }

    public void ordenar() {
        for (int i = 0; i < personas.length - 1; i++) {
            for (int j = 0; j < personas.length - i - 1; j++) {
                if (personas[j].getEdad() > personas[j + 1].getEdad()
                        || (personas[j].getEdad() == personas[j + 1].getEdad()
                        && personas[j].getPeso() > personas[j + 1].getPeso())) {
                    Persona temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                }
            }
        }
    }

    public void imprimir() {
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}

class Libro {
    private String nombreLibro;
    private String nombreAutor;
    private int numPags;

    public Libro(String nl, String na, int np){
        this.nombreLibro = nl;
        this.nombreAutor = na;
        this.numPags = np;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public String getNombreAutor(){
        return nombreAutor;
    }

    public int getNumPags(){
        return numPags;
    }

    @Override
    public String toString(){
        return nombreLibro;
    }
}

class ColeccionLibros{
    Libro[] listaLibros;
    int CantidadColeccion;
    int contador = 0;

    public ColeccionLibros(int n){
        listaLibros = new Libro[n];
    }

    public void popularLibros(Libro x){
        if(contador<listaLibros.length){
            listaLibros[contador] = x;
            System.out.println("El libro " + x + " ha sido añadido.");
            contador++;
        }
        else {
            System.out.println("Ya no tienes más espacio en esta colección.");
        }
    }

    public String escritorMasProlijo(){

        if (listaLibros == null || listaLibros.length == 0) {
            return null; // Si no hay libros, devuelve null
        }

        int MaxPags=0;
        String autorProlijo = null;

        for(Libro a : listaLibros){
            if(a.getNumPags()>MaxPags){
                MaxPags = a.getNumPags();
            }
        }
        for(Libro a : listaLibros){
            if(a.getNumPags() == MaxPags){
                autorProlijo = a.getNombreAutor();
            }
        }

        return autorProlijo;
    }

    public String escritorConMasLibros(){
        if (listaLibros == null || listaLibros.length == 0) {
            return null; // Si no hay libros, devuelve null
        }

        String[] autores = new String[this.CantidadColeccion];
        int maxRepeticiones = 0;
        String autorMasRepetido = null;

        for(int i=0; i<autores.length; i++){
            if(listaLibros[i] != null){
                autores[i] = listaLibros[i].getNombreAutor();
            }
        }

        for(int i=0; i<autores.length; i++){
            if(listaLibros[i] != null){
            String autorActual = autores[i];
            int repeticiones = 0;

            for(int j=0; j <autores.length; j++){
                if(i != j && autorActual.equals(autores[j])){
                    repeticiones++;
                }
            }
            if (repeticiones>maxRepeticiones){
                maxRepeticiones = repeticiones;
                autorMasRepetido = autorActual;
            }
        }
    }
     return autorMasRepetido;   
    }

    public String tituloMasLargo(){
        int max = 0;
        Libro large = null;
        
        for(int i=0; i<listaLibros.length; i++){
            if(listaLibros[i] != null){
                String title = listaLibros[i].getNombreLibro();
                if(title.length() > max){
                    max = title.length();
                }
            }
        }
        for(int i=0; i<listaLibros.length; i++){
            if(listaLibros[i] != null){
                String title = listaLibros[i].getNombreLibro();
                if(title.length() == max){
                    large = listaLibros[i];
                    break;
                }
            }
        }

        return "El titulo de libro más largo es " + large.getNombreLibro() + " y su autor es " + large.getNombreAutor();
    }
}
