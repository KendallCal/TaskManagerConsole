
//Proyecto #1. Programación Intermedia.

//Kendall Andrey Calderón Burgos.

//Cédula: 1-1892-0075

package proyecto.pkg1;

//Librerías.
import java.time.LocalDate; //Manipular fechas.
import java.time.format.DateTimeFormatter; //Manipular fechas.
import java.util.ArrayList; //Para implementar las ArrayList
import java.util.Iterator; //Para recorrer elementos de una colección.
import java.util.List; //Manipular elementos de ArrayList.
import java.util.Scanner; //Leer entrada de consola.

//Clase principal.
public class Proyecto1 {
    
    //Scanner.
    private static Scanner Entrada = new Scanner(System.in);
    
    //ArrayList para las tareas.
    private static ArrayList<Tarea> tareas = new ArrayList<>();

    //Main principal.
    public static void main(String[] args) {
        //Scanner
        Scanner Entrada = new Scanner(System.in);
        
        //Variables.
        int opcion;
        boolean bandera = false; //Para crear una bandera para no ingresar a opciones sin haber ingresado a la primera antes.
        
        //Menú
        do {
            Estilos.limpiarPantalla(); //Limpia la pantalla (Crea líneas vacías para se vea más limpio.)
            Estilos.textoCian("- - - - - - - - - - Menú  Principal - - - - - - - - - -");
            Estilos.opciones("[ ", "1", " ]", " Agregar Tareas.");
            Estilos.opciones("[ ", "2", " ]", " Ver Tareas.");
            Estilos.opciones("[ ", "3", " ]", " Marcar como Completada.");
            Estilos.opciones("[ ", "4", " ]", " Eliminar Tareas.");
            Estilos.opciones("[ ", "5", " ]", " Filtrar Tareas.");
            Estilos.opciones("[ ", "6", " ]", " Salir.");
            Estilos.textoCian("- - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.print("Digite una opción: ");

            //Verifica si la opción ingresada es un número y no un carácter.
            if (Entrada.hasNextInt()) {
                opcion = Entrada.nextInt();

                //Switch de las opciones.
                switch (opcion) {
                    case 1: //Agregar Tareas.
                        agregarTareas();
                        bandera = true;
                        break;
                        
                    case 2: //Mostrar Tareas.
                        if (bandera) {
                            mostrarTareas();
                        } else {
                            Estilos.limpiarPantalla();
                            Estilos.textoRojo("\nPara ingresar a esta opción primero debe agregar una tarea en la opción 1.");
                            Estilos.textoAzul("\nPresione \"Enter\" para volver al menú principal...");
                            new Scanner(System.in).nextLine();
                        }
                        break;
                        
                    case 3: //Marcar Tareas Completadas.
                        if (bandera) {
                            marcarCompleto();
                        } else {
                            Estilos.limpiarPantalla();
                            Estilos.textoRojo("\nPara ingresar a esta opción primero debe agregar una tarea en la opción 1.");
                            Estilos.textoAzul("\nPresione \"Enter\" para volver al menú principal...");
                            new Scanner(System.in).nextLine();
                        }
                        break;
                        
                    case 4: //Eliminar Tareas.
                        if (bandera) {
                            eliminarTareas();
                        } else {
                            Estilos.limpiarPantalla();
                            Estilos.textoRojo("\nPara ingresar a esta opción primero debe agregar una tarea en la opción 1.");
                            Estilos.textoAzul("\nPresione \"Enter\" para volver al menú principal...");
                            new Scanner(System.in).nextLine();
                        }
                        break;
                        
                    case 5: //Filtra las Tareas.
                        if (bandera) {
                            filtrarTareas();
                        } else {
                            Estilos.limpiarPantalla();
                            Estilos.textoRojo("\nPara ingresar a esta opción primero debe agregar una tarea en la opción 1.");
                            Estilos.textoAzul("\nPresione \"Enter\" para volver al menú principal...");
                            new Scanner(System.in).nextLine();
                        }
                        break;
                        
                    case 6: //Sale del programa.
                        Estilos.limpiarPantalla();
                        System.out.println("\nSaliendo del programa...");
                        break;
                        
                    default: //En caso de ingresar número correcto.
                        Estilos.limpiarPantalla();
                        Estilos.textoRojo("\nOpción inválida, por favor digite una entre 1-6.");
                        Estilos.textoAzul("\nPresione \"Enter\" para volver al menú principal...");
                        new Scanner(System.in).nextLine();
                        break;
                }
                
            } else { //En caso de que se ingrese un carácter y no un número.
                Estilos.limpiarPantalla();
                Estilos.textoRojo("Opción inválida, por favor digite un número.");
                Estilos.textoAzul("\nPresione \"Enter\" para volver al menú principal...");
                new Scanner(System.in).nextLine();
                Entrada.nextLine();  //Limpia el buffer.
                opcion = 0; //Reinicia la variable.
            }
            
        } while (opcion != 6);
    }
    
    //- - - - - - - - - - - - - - - - - - - - - - - Métodos - - - - - - - - - - - - - - - - - - - - - - -//
    
    //Método para agregar tareas.
    private static void agregarTareas() {
        //Variables
        String descripcion, vencimiento, nombreEncargado, apellidoEncargado, opcion;
        LocalDate fechaVencimiento; //Para la fecha.
        boolean agregarOtraTarea;
        
        Estilos.limpiarPantalla();
        do {
            
            //-----------Solicita los datos de la tarea------------
            System.out.println("\nIngrese la descripción de la tarea. (Opcional)"); //Solicita la descripción.
            descripcion = Entrada.nextLine();

            //Solicita y verifica el formato de la fecha.
            do {
                System.out.println("Ingrese la fecha de vencimiento en formato día/mes/año. (Opcional)"); //Solicita la fecha de vencimiento.
                vencimiento = Entrada.nextLine();

                if (vencimiento.isEmpty()) {
                    fechaVencimiento = LocalDate.now(); //Si no ingresa nada queda como vacío.
                    
                } else {
                    fechaVencimiento = cambiarFecha(vencimiento); //Si ingresa una fecha, cambia la fecha al formato de fecha.
                    
                    if (fechaVencimiento == null) {
                        Estilos.textoRojo("\nFormato de fecha incorrecta. Use el formato día/mes/año."); //Si ingresa una fecha incorrecta.
                    }
                }
            } while (fechaVencimiento == null);

            //Bucle para que se ingrese el nombre obligatoriamente, tenga más de 3 caracteres y solo contenga letras.
            do {
                System.out.println("Ingrese el nombre del encargado.");
                nombreEncargado = Entrada.nextLine();

                //Condiciona que tenga solo letras y sea mayor a 3 letras.
                if (nombreEncargado.trim().length() < 3 || !nombreEncargado.matches("[a-zA-Z]+")) {
                    Estilos.textoRojo("El nombre del encargado es obligatorio, debe tener al menos 3 caracteres y solo puede contener letras. ¡Por favor, inténtelo de nuevo!");
                }
            } while (nombreEncargado.trim().length() < 3 || !nombreEncargado.matches("[a-zA-Z]+")); //Matches verifica si cumple con el patron solicitado a-z.

            //Bucle para que se ingrese el apellido obligatoriamente y tenga más de 3 caracteres y solo contenga letras.
            do {
                System.out.println("Ingrese el apellido del encargado.");
                apellidoEncargado = Entrada.nextLine();

                //Condiciona que tenga solo letras y sea mayor a 3 letras.
                if (apellidoEncargado.trim().length() < 3 || !apellidoEncargado.matches("[a-zA-Z]+")) {
                    Estilos.textoRojo("El apellido del encargado es obligatorio, debe tener al menos 3 caracteres y solo puede contener letras. ¡Por favor, inténtelo de nuevo!");
                }
            } while (apellidoEncargado.trim().length() < 3 || !apellidoEncargado.matches("[a-zA-Z]+")); //Matches verifica si cumple con el patron solicitado a-z.

            //Crea el objeto. (Tarea)
            Tarea nuevaTarea = new Tarea(descripcion, vencimiento, nombreEncargado, apellidoEncargado);

            //Agrega el objeto al ArrayList.
            tareas.add(nuevaTarea);

            //Muestra que la tarea se ingresó correctamente.
            Estilos.limpiarPantalla();
            Estilos.textoVerde("\nLa tarea se ingresó correctamente.");
            System.out.println(nuevaTarea);
            
            //Bucle del desea ingresar otra.
            do {
                //Pregunta al usuario si desea agregar otra tarea.
                Estilos.deseaRegresar("\n¿Desea ingresar otra tarea? (", "S", "/",  "N", "): ");
                opcion = Entrada.nextLine();

                switch (opcion.toUpperCase()) {
                    case "S": //En caso de ser 'S'.
                        Estilos.limpiarPantalla();
                        agregarOtraTarea = true;
                        break;
                        
                    case "N": //En caso de ser 'N'.
                        agregarOtraTarea = false; //Solo si es falso el while permite salir al menú.
                        break;
                        
                    default:
                        Estilos.limpiarPantalla();
                        Estilos.textoRojo("\nOpción no válida. Por favor, ingrese S o N.");
                        agregarOtraTarea = true;
                        break;
                }
            } while (!opcion.equalsIgnoreCase("n") && !opcion.equalsIgnoreCase("s"));
            
        } while (agregarOtraTarea);
    }
    
    //Método para cambiar la fecha a formato de fecha.
    private static LocalDate cambiarFecha(String vencimiento) {
        DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Define el formato específico de la fecha.
        
        try {
            return LocalDate.parse(vencimiento, fechaFormato); //Convierte el String en LocalDate.
        } catch (Exception e) { //Si ocurre la exception devuelve null.
            return null;
        }
    }
    
    //Método para mostrar tareas.
    private static void mostrarTareas() {
        
        Estilos.limpiarPantalla();
        Estilos.textoCian("\n- - - - - - - - - - - - - - - Tareas - - - - - - - - - - - - - - -");
        
        //Verifica si hay tareas antes de intentar mostrarlas.
        if (tareas.isEmpty()) { 
            System.out.println("No hay tareas disponibles."); //Si no hay tareas disponibles.
        } else {
            //Recorre el arreglo y muestra los objetos.
            for (Tarea tarea : tareas) {
                System.out.println(tarea);
            }
        }
        
        Estilos.textoAzul("\nPresione \"Enter\" para volver al menú principal...");
        new Scanner(System.in).nextLine();
    }
    
    //Método para marcar como completada.
    private static void marcarCompleto() {
        //Variables.
        boolean agregarOtraTarea, encontrada = false;
        String opcion;

        do {
            Estilos.limpiarPantalla();

            //Verifica si hay tareas antes de intentar marcar alguna como completada.
            if (tareas.isEmpty()) {
                Estilos.textoRojo("No hay tareas disponibles para marcar como completadas.");
                Estilos.textoAzul("\nPresione \"Enter\" para volver al menú principal...");
                new Scanner(System.in).nextLine();
                return;
            }

            //Si hay tareas pide el identificador.
            Estilos.idTarea("Ingrese el identificador de la tarea (","T---", "): ");
            String id = Entrada.nextLine();

            //Recorre el arreglo y busca el identificador.
            for (Tarea tarea : tareas) {
                if (tarea.getIdentificador().equals(id)) {
                    tarea.marcarCompleto(); //Método para marcar como completada.
                    
                    Estilos.limpiarPantalla();
                    Estilos.textoVerde("La tarea fue marcada como completada con éxito.");
                    System.out.println(tarea);
                    encontrada = true;
                    break;
                }
            }

            //Verifica si no se encontró la tarea.
            if (!encontrada) {
                Estilos.textoRojo("No se encontró la tarea. !Por favor, inténtelo de nuevo¡");
            }

            //While de sí desea ingresar otra.
            do {
                //Pregunta al usuario si desea agregar otra tarea.
                Estilos.deseaRegresar("\n¿Desea ingresar otra tarea? (", "S", "/",  "N", "): ");
                opcion = Entrada.nextLine();

                //Utiliza un switch para manejar las opciones de "S" o "N".
                switch (opcion.toUpperCase()) {
                    case "S":
                        Estilos.limpiarPantalla();
                        agregarOtraTarea = true;
                        break;
                    case "N":
                        agregarOtraTarea = false;
                        break;
                    default:
                        Estilos.limpiarPantalla();
                        Estilos.textoRojo("\nOpción no válida. Por favor, ingrese S o N.");
                        agregarOtraTarea = true;
                        break;
                }
            } while (!opcion.equalsIgnoreCase("n") && !opcion.equalsIgnoreCase("s"));
            
        } while (agregarOtraTarea);
    }
    
    //Método para eliminar tareas.
    private static void eliminarTareas() {
        //Variables.
        boolean agregarOtraTarea, tareaEncontrada;
        String opcion;

        do {
            Estilos.limpiarPantalla();

            //Verifica si hay tareas antes de intentar eliminar alguna.
            if (tareas.isEmpty()) {
                Estilos.textoRojo("No hay tareas disponibles para eliminar.");
                Estilos.textoAzul("\nPresione \"Enter\" para volver al menú principal...");
                new Scanner(System.in).nextLine();
                return;
            }

            //Si hay tareas, pide el identificador.
            Estilos.idTarea("Ingrese el identificador de la tarea (","T---", "): ");
            String id = Entrada.nextLine();

            //Inicializa el iterador para recorrer la lista de tareas.
            Iterator<Tarea> iterator = tareas.iterator();
            tareaEncontrada = false;

            //Para eliminar de la ArrayList de forma segura con un iterador.
            while (iterator.hasNext()) {
                Tarea tarea = iterator.next();
                if (tarea.getIdentificador().equals(id)) {
                    iterator.remove(); //Elimina la tarea con el iterador.
                    tareaEncontrada = true;
                    
                    Estilos.limpiarPantalla();
                    Estilos.textoVerde("La tarea fue eliminada con éxito.");
                    break;
                }
            }

            //Muestra mensaje si no se encontró la tarea.
            if (!tareaEncontrada) {
                Estilos.textoRojo("No se encontró la tarea. Por favor, inténtelo de nuevo.");
            }

            //While de sí desea ingresar otra.
            do {
                    // Pregunta al usuario si desea agregar otra tarea.
                    Estilos.deseaRegresar("\n¿Desea ingresar otra tarea? (", "S", "/",  "N", "): ");
                    opcion = Entrada.nextLine();

                    // Utiliza un switch para manejar las opciones de "S" o "N".
                    switch (opcion.toUpperCase()) {
                        case "S":
                            Estilos.limpiarPantalla();
                            agregarOtraTarea = true;
                            break;
                        case "N":
                            agregarOtraTarea = false;
                            break;
                        default:
                            Estilos.limpiarPantalla();
                            Estilos.textoRojo("\nOpción no válida. Por favor, ingrese S o N.");
                            agregarOtraTarea = true;
                            break;
                    }
                } while (!opcion.equalsIgnoreCase("n") && !opcion.equalsIgnoreCase("s"));
            
        } while (agregarOtraTarea);
    }
    
    //Método para filtrar tarea.
    private static void filtrarTareas() {
        //Variables.
        int opcion2;
        
        Estilos.limpiarPantalla();
        do {
            //Menú.
            Estilos.textoCian("- - - - - - - Filtrar  Tareas - - - - - - -");
            Estilos.opciones("[", " 1 ", "]", " Filtrar por estado.");
            Estilos.opciones("[", " 2 ", "]", " Filtrar por vencimiento.");
            Estilos.textoCian("- - - - - - - - - - - - - - - - - - - - - -");
            System.out.print("Digite una opción: ");

            //Verifica si es un número.
            if (Entrada.hasNextInt()) {
                opcion2 = Entrada.nextInt();

                //Limpia el buffer para que no genere errores.
                Entrada.nextLine();

                switch (opcion2) {
                    case 1:
                        filtrarEstado(); //Filtra por el estado de la tarea (Completada o Pendiente).
                        break;
                    case 2:
                        filtrarVencimiento(); //Filtra por el vencimiento de la tarea.
                        break;
                    default:
                        Estilos.limpiarPantalla();
                        Estilos.textoRojo("Opción inválida, por favor digite una entre 1 y 2.");
                        break;
                }
            } else {
                Estilos.limpiarPantalla();
                Estilos.textoRojo("Opción inválida, por favor digite un número.");
                Entrada.nextLine();  //Limpia el buffer.
                opcion2 = 0;
            }
        } while (opcion2 < 1 || opcion2 > 2);
    }
    
    // Método para filtrar por estado.
    private static void filtrarEstado() {
        //Variables.
        int estado = 0;
        boolean inputValido = false;

        Estilos.limpiarPantalla();
        do {  
            //Menú
            Estilos.textoCian("- - - - - - - Filtrar por estado - - - - - - -");
            Estilos.opciones("[", " 1 ", "]", " Completada.");
            Estilos.opciones("[", " 2 ", "]", " Pendiente.");
            Estilos.textoCian("- - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.print("Ingrese el estado: ");

            //Verifica si la entrada es un número.
            if (Entrada.hasNextInt()) {
                estado = Entrada.nextInt();
                inputValido = true;

                //Switch para mostrar por estado o completado.
                switch (estado) {
                    case 1: { //Filtra las completadas.
                        boolean encontrada = false;
                        Estilos.limpiarPantalla();
                        Estilos.textoCian("- - - - - - - Tareas completadas - - - - - - -");

                        //Recorre el Array y busca e imprime las tareas completadas.
                        for (Tarea tarea : tareas) {
                            if (tarea.isEstado()) {
                                System.out.println(tarea);
                                encontrada = true;
                            }
                        }

                        //Verifica si no hay tareas completadas encontradas.
                        if (!encontrada) {
                            Estilos.textoRojo("\nNo hay tareas completadas.");
                        }

                        Estilos.textoAzul("\nPresione \"Enter\" para volver al menú principal...");
                        new Scanner(System.in).nextLine();
                        Entrada.nextLine(); //Limpia el buffer.
                        break;
                    }

                    case 2: { //Filtra las pendientes.
                        boolean encontrada = false;
                        Estilos.limpiarPantalla();
                        Estilos.textoCian("- - - - - - - Tareas pendientes - - - - - - -");

                        //Recorre el Array y busca e imprime las tareas pendientes.
                        for (Tarea tarea : tareas) {
                            if (!tarea.isEstado()) {
                                System.out.println(tarea);
                                encontrada = true;
                            }
                        }

                        //Verifica si no hay tareas pendientes encontradas.
                        if (!encontrada) {
                            Estilos.textoRojo("\nNo hay tareas pendientes.");
                        }

                        Estilos.textoAzul("\nPresione \"Enter\" para volver al menú principal...");
                        new Scanner(System.in).nextLine();
                        Entrada.nextLine();
                        break;
                    }

                    default: //Si ingresa un número incorrecto.
                        Estilos.limpiarPantalla();
                        Estilos.textoRojo("\nOpción invalida. Por favor, ingrese una entre 1 y 2.");
                        break;
                }
            } else {
                    Estilos.limpiarPantalla();
                    Estilos.textoRojo("Opción inválida, por favor digite un número.");
                    Entrada.nextLine(); //Limpia el buffer.
            }        
        } while (!inputValido || estado < 1 || estado > 2);
    }

    //Método para filtrar por vencimiento.
    private static void filtrarVencimiento() {
        Estilos.limpiarPantalla();
        
        //Solicita la fecha.
        Estilos.textoAzul("Ingrese la fecha de vencimiento en formato dia/mes/año o presione enter si no tiene: ");
        String vencimiento = Entrada.nextLine();

        //Almacena las tareas encontradas en una lista.
        List<Tarea> tareasEncontradas = new ArrayList<>();

        //Variable para indicar si ya se mostró la información de la fecha o "Sin fecha".
        boolean seMostroInfoFecha = false;

        //Recorre el ArrayList, busca y muestra según la fecha.
        for (Tarea tarea : tareas) {
            
            //Si tiene el vencimiento escrito la agrega a la List.
            if (tarea.getVencimiento().equals(vencimiento)) {
                tareasEncontradas.add(tarea);

                //Si se presiona enter muestra sin fecha.
                if (!seMostroInfoFecha) {
                    Estilos.limpiarPantalla();
                    if (vencimiento.isEmpty()) {
                        Estilos.textoCian("- - - - - - - Sin fecha de vencimiento - - - - - - -"); //Se muestra para las que no tengan fecha.
                    } else {
                        Estilos.textoCian("- - - - - - - - - - -" + vencimiento + "- - - - - - - - - - -"); //Se muestra para las que tengan fecha.
                    }
                    seMostroInfoFecha = true;
                }
            }
        }

        //Si no hay tareas con la fecha seleccionada.
        if (tareasEncontradas.isEmpty()) {
            Estilos.limpiarPantalla();
            Estilos.textoRojo("\nNo hay tareas con la fecha de vencimiento especificada.");
        } else {
            //Muestra todas las tareas encontradas.
            for (Tarea tareaEncontrada : tareasEncontradas) {
                System.out.println(tareaEncontrada);
            }
        }

        Estilos.textoAzul("\nPresione \"Enter\" para volver al menú principal...");
        new Scanner(System.in).nextLine();
    }
}