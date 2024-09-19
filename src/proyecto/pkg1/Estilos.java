
//Clase para darle estilos al código en la terminal.

package proyecto.pkg1;

public class Estilos {
    
    //Método para limpiar pantalla.
    public static void limpiarPantalla() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }
    
    
    //Métodos para colores de texto.
    public static final String Restablecer = "\u001B[0m"; //Restablece el color.
    
    public static final String Rojo = "\u001B[31m"; //Color rojo.
    public static void textoRojo(String texto) {
        System.out.print(Rojo + texto + Restablecer + "\n");
    }
    
    public static final String Verde = "\u001B[32m"; //Color verde.
    public static void textoVerde(String texto) {
        System.out.print(Verde + texto + Restablecer + "\n");
    }
    
    public static final String Amarillo = "\u001B[33m"; //Color amarillo.
    public static void textoAmarillo(String texto) {
        System.out.print(Amarillo + texto + Restablecer + "\n");
    }
    
    public static final String Azul = "\u001B[34m"; //Color azul.
    public static void textoAzul(String texto) {
        System.out.print(Azul + texto + Restablecer);
    }
    
    public static final String Morado = "\u001B[35m"; //Color morado.
    public static void textoMorado(String texto) {
        System.out.print(Morado + texto + Restablecer + "\n");
    }
    
    public static final String Cian = "\u001B[36m"; //Color cian.
    public static void textoCian(String texto) {
        System.out.print(Negrita + Cian + texto + Restablecer + "\n");
    }
    
    public static final String Negrita = "\u001B[1m"; //Pone el texto en negrito.
    public static void textoNegrita(String texto) {
        System.out.print(Negrita + texto + Restablecer + "\n");
    }
    
    //- - - - - - Métodos para estilos específicos - - - - - -//
    
    //Método para el estilo de las opciones.
    public static void opciones(String cuadro1, String numero, String cuadro2, String texto) {
        System.out.println(Negrita + Azul + cuadro1 + Restablecer + Cian + numero + Restablecer + Negrita + Azul + cuadro2 + Restablecer + texto);
    }
    
    //Método para el estilo de la opción de sí desea regresar.
    public static void deseaRegresar(String texto1, String letra1, String texto2, String letra2, String texto3) {
        System.out.print(texto1 + Negrita + Verde + letra1 + Restablecer + texto2 + Negrita + Rojo + letra2 + Restablecer + texto3);
    }
    
    //Método para el estilo de las identidades de tareas.
    public static void idTarea(String texto1, String id, String texto2) {
        System.out.print(texto1 + Cian + id + Restablecer + texto2);
    }
}