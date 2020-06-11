package calculadora;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Auxiliar {
    public static boolean comprobarExpresionAritmetica(String sb) {
        String opcion1 = "-?[1-9][0-9]*";
        String opcion2 = opcion1 + "[-\\+\\*%/]";
        String opcion3 =  opcion2 + "[1-9][0-9]*";
        return sb.matches(opcion1 + "|" + opcion2 + "|" + opcion3 );
    }

    public static boolean comprobarParaIgual (String sb) {
        return sb.matches("-?[1-9][0-9]*[-\\+\\*/%][1-9][0-9]*");
    }
    public static int obtenerOperacion(String operacion) {
        String pattern = "(-?[1-9][0-9]*)([-\\+\\*/%])([1-9][0-9]*)";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(operacion);
        int digitos1 = 0, digitos2 = 0;
        char operando = ' ';
        if (matcher.find()){
            digitos1 = Integer.parseInt(matcher.group(1));
            operando = matcher.group(2).charAt(0);
            digitos2 = Integer.parseInt(matcher.group(3));
        }
        switch (operando) {
            case '+':
                return digitos1 + digitos2;
            case '-':
                return digitos1 - digitos2;
            case '*':
                return digitos1 * digitos2;
            case '/':
                return digitos1 / digitos2;
            case '%':
                return digitos1 % digitos2;
            default:
                return 0;
        }

    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.toString() + "8");
   //      sb.append("-");
 //       sb.append("-");

            sb.append(1);
  //    sb.append(8);
        sb.append("-");
        System.out.println(sb.toString());
    //    sb.append("+");

        sb.append(3);
        sb.append( 8);
       // sb.append( 8);
        System.out.println(comprobarExpresionAritmetica(sb.toString()));
        System.out.println(obtenerOperacion(sb.toString()));
    }
}
