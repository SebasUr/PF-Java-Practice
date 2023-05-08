public class Taller5 {
    public static void main(String[] args){

        // CASO PRUEBA. Class Estudiante.
        Estudiante Sebas = new Estudiante(35,"Sebastián",true);
        System.out.println(Sebas);
        Sebas.puedeIrAPractica();

        System.out.println("-----------------------------------");

        // Class Racional

        Racional racional1 = new Racional(3, 4);
        System.out.println(racional1.sumar());
        System.out.println("-----------------------------------");

        // Class rectangulo

        Rectangulo rec1 = new Rectangulo("2,5","4,8");
        System.out.println(rec1.obtenerArea());
        System.out.println(rec1.obtenerPerimetro());
        System.out.println("-----------------------------------");

        // Class Asignatura.
        Asignatura fundamentos = new Asignatura("Fundamentos", 4.5);
        System.out.println(fundamentos);
        System.out.println(fundamentos.aprobate());
        System.out.println("-----------------------------------");

            // set y prueba.
        fundamentos.setNota(2.5);
        System.out.println(fundamentos.aprobate());

        // Class Alumno y Asignatura.

        Alumno sebas = new Alumno("Sebastián", 18);
        sebas.agregarAsignatura(fundamentos);
        Asignatura principios = new Asignatura("Principios",5);
        sebas.agregarAsignatura(principios);
        System.out.println(sebas.getPromedio());
        sebas.mostrarAsignaturas();

        // Class animal

        Animal perro = new Animal("Vertebrado", true, false, false, true);

        System.out.println("Tipo de animal: " + perro.getTipo());
        System.out.println("¿Es vivíparo?: " + perro.esViviparo());
        System.out.println("¿Es herbívoro?: " + perro.esHerbivoro());
        System.out.println("¿Es acuático?: " + perro.esAcuatico());
        System.out.println("¿Es terrestre?: " + perro.esTerrestre());

        perro.setEsHerbivoro(true);
        perro.setEsAcuatico(false);

        
        System.out.println("¿Es herbívoro ahora?: " + perro.esHerbivoro());
        System.out.println("¿Es acuático ahora?: " + perro.esAcuatico());
    }
}

class Estudiante {
    private int creditosAprobados;
    private String nombre;
    private boolean pagoSemestre;

    public Estudiante(int creditos, String name, boolean pago){
        this.creditosAprobados = creditos;
        this.nombre = name;
        this.pagoSemestre = pago;
    }

    public void puedeIrAPractica(){
        if(((this.creditosAprobados > 50) && (this.pagoSemestre == true))==true){
            System.out.println("El estudiante " + this.nombre + " puede ir a Prácticas");
        } else {
            System.out.println("El estudiante " + this.nombre + " NO puede ir a Prácticas");
        }
    }

    public String toString(){
        if(this.pagoSemestre=true){
            return "Este estudiante se llama " + this.nombre + " tiene " + this.creditosAprobados + " Créditos aprobados" +  " y pagó el semestre.";
        }
        return "Este estudiante se llama " + this.nombre + " tiene " + this.creditosAprobados +" Créditos aprobados" + " y NO pagó el semestre.";
    }
}

class Racional {
    private double numero1;
    private double numero2;

    public Racional(double num1, double num2) {
        numero1 = num1;
        numero2 = num2;
    }

    public double sumar() {
        return numero1 + numero2;
    }

    public double restar() {
        return numero1 - numero2;
    }

    public double multiplicar() {
        return numero1 * numero2;
    }

    public double dividir() {
        if (numero2 != 0) {
            return numero1 / numero2;
        } else {
            throw new ArithmeticException("Error: No se puede dividir entre cero.");
        }
    }
}

class Rectangulo {
    String[] coordenada1;
    String[] coordenada2;
    int lado;
    int lado2;

    // "2,5" // 3,6
    public Rectangulo(String cord1,String cord2){
        String[] cords1 = cord1.split(",");
        String[] cords2 = cord2.split(",");

        this.coordenada1 = cords1;
        this.coordenada2 = cords2;

        // definicion de lados.

        int x1= Integer.parseInt(coordenada1[0]);
        int x2= Integer.parseInt(coordenada2[0]);
        int xMax = Math.max(x1,x2);
        if(xMax==x1){
            this.lado = xMax-x2;
        } else {
            this.lado = xMax-x1;
        }

        int y1=Integer.parseInt(coordenada1[1]);
        int y2=Integer.parseInt(coordenada2[1]);
        int yMax = Math.max(y1,y2);
        if(yMax==y1){
            this.lado2= yMax-y2;
        } else {
            this.lado2= yMax-y1;
        }
    }

    // el x no puede ser el mismo, el y tampoco
    // lado1 = puntoXmayor - puntoXmenor
    // lo mismo lado2

    public String obtenerArea(){
        String enun;
        if(lado==0 || lado2==0){
            enun = "No se puede calcular tu área porque tus coordenadas son inválidas. Revíselo.";
        } else {
            int area = lado*lado2;
            enun = "El área de tu rectangulo es de " + area;
        }
        return enun;
    }

    public String obtenerPerimetro(){
        String enun;
        if(lado==0 || lado2==0){
            enun = "No se puede calcular tu perimetro porque tus coordenadas son inválidas. Revíselo.";
        } else {
            int perimetro = lado*2 + lado2*2;
            enun = "El área de tu rectangulo es de " + perimetro;
        }
        return enun;
    }
}

class Asignatura {
    String nombre;
    double nota;
    public Asignatura(String nombre, double nota){
        this.nombre = nombre;
        this.nota = nota;
    }

    public void setNota(double n){
        this.nota = n;
    }
    public double getNota(){
        return this.nota;
    }
    public String aprobate(){
        if(this.nota > 3.5){
            return "Aprobado";
        }
        return "Reprobado";
    }
    public String toString(){
        return nombre;
    }

}

class Alumno {
    String nombre;
    int edad;
    Asignatura[] asignaturas;
    int contadorAsignaturas;

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.asignaturas = new Asignatura[4];
        this.contadorAsignaturas = 0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public double getPromedio() {
        if (contadorAsignaturas == 0) {
            return 0.0;
        }

        double sumaNotas = 0;
        for (int i = 0; i < contadorAsignaturas; i++) {
            sumaNotas += asignaturas[i].getNota();
        }
        return sumaNotas / contadorAsignaturas;
    }

    public void agregarAsignatura(Asignatura asignatura) {
        if (contadorAsignaturas < 4) {
            for (int i = 0; i < contadorAsignaturas; i++) {
                if (asignaturas[i] == asignatura) {
                    System.out.println("La asignatura ya existe en el plan de estudio del alumno.");
                    return;
                }
            }
            asignaturas[contadorAsignaturas] = asignatura;
            contadorAsignaturas++;
        } else {
            System.out.println("El alumno ya tiene el máximo de asignaturas permitidas.");
        }
    }

    public void mostrarAsignaturas(){
        System.out.println("HOLA");
        System.out.println("Las asignaturas que tiene " + this.nombre + " son");
        for(int i=0; i<this.contadorAsignaturas; i++){
            System.out.println(asignaturas[i] + " - " + asignaturas[i].aprobate());
        }
    }
}

class Animal {
    private String tipo;  // Vertebrado o invertebrado
    private boolean esViviparo;
    private boolean esHerbivoro;
    private boolean esAcuatico;
    private boolean esTerrestre;

    // Constructor
    public Animal(String tipo, boolean esViviparo, boolean esHerbivoro, boolean esAcuatico, boolean esTerrestre) {
        this.tipo = tipo;
        this.esViviparo = esViviparo;
        this.esHerbivoro = esHerbivoro;
        this.esAcuatico = esAcuatico;
        this.esTerrestre = esTerrestre;
    }

    // Métodos getters y setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean esViviparo() {
        return esViviparo;
    }

    public void setEsViviparo(boolean esViviparo) {
        this.esViviparo = esViviparo;
    }

    public boolean esHerbivoro() {
        return esHerbivoro;
    }

    public void setEsHerbivoro(boolean esHerbivoro) {
        this.esHerbivoro = esHerbivoro;
    }

    public boolean esAcuatico() {
        return esAcuatico;
    }

    public void setEsAcuatico(boolean esAcuatico) {
        this.esAcuatico = esAcuatico;
    }

    public boolean esTerrestre() {
        return esTerrestre;
    }

    public void setEsTerrestre(boolean esTerrestre) {
        this.esTerrestre = esTerrestre;
    }
}
