import java.util.Scanner;
public class Cuadratica {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese su ecuación cuadrática. Recuerde usar la forma correcta y ordenada y expresar el segundo grado con  ^2: ");
        String cuadratica = in.nextLine();

        System.out.println(cuadratica(cuadratica));

    }

    
    public static Double cuadratica(String ecuacion){
        int a;
        int b;
        int c;
        String aString = "";
        String tempString = "";
        String bString = "";
        String cString = "";
        

        for(int i=0; i<ecuacion.length(); i++){
            if(ecuacion.charAt(i)== '+' || ecuacion.charAt(i)== '-'){
                aString = ecuacion.substring(0, i-1);
                tempString = ecuacion.substring(i, ecuacion.length());
                break;
            }
        }

        for(int i=1; i<tempString.length(); i++){
            if(tempString.charAt(i)== '+' || tempString.charAt(i)== '-'){
                bString = tempString.substring(1, i-1);
                cString = tempString.substring(i+1, tempString.length());
                break;
            }
        }
        System.out.println(aString);
        String aString2 = aString.substring(0, aString.length()-1).replaceAll("[^0-9]", "");
        String bString2 = bString.replaceAll("[^0-9]", "");
        String cString2 = cString.replaceAll("[^0-9]", "");
        if(aString.equals("x^2")){
            a = 1;
        } else {
            a = Integer.parseInt(aString2);
        }
        b = Integer.parseInt(bString2);
        c = Integer.parseInt(cString2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        int dentroRaiz = b*b-4*a*c;
        Double solNeg = (-1*b - Math.sqrt(dentroRaiz))/2*a;
        Double solPos = (1*b + Math.sqrt(dentroRaiz))/2*a;
        System.out.println(solPos);
        return solNeg;
    }
}
