
//Clase Tarea.

package proyecto.pkg1;


public class Tarea {
    
    //Atributos
    private static int contadorTareas;
    private String descripcion;
    private String vencimiento;
    private String identificador;
    private String nombreEncargado;
    private String apellidoEncargado;
    private boolean estado;

    
    //Constructor
    public Tarea(String descripcion, String vencimiento, String nombreEncargado, String apellidoEncargado) {
        this.descripcion = descripcion;
        this.vencimiento = vencimiento;
        this.identificador = crearIdentificador();
        this.nombreEncargado = nombreEncargado;
        this.apellidoEncargado = apellidoEncargado;
        this.estado = false;
    }

    
    //Getters and setters
    public static int getContadorTareas() {
        return contadorTareas;
    }

    public static void setContadorTareas(int contadorTareas) {
        Tarea.contadorTareas = contadorTareas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public String getApellidoEncargado() {
        return apellidoEncargado;
    }

    public void setApellidoEncargado(String apellidoEncargado) {
        this.apellidoEncargado = apellidoEncargado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
 
    
    //Método para crear el identificador.
    private String crearIdentificador() {
        contadorTareas++;
        return "T" + String.format("%03d", contadorTareas);
    }
    
    //Método para marcar como completa.
    public void marcarCompleto() {
        this.estado = true;
    }
    
    //Método Override para dar una representación personalizada cuando se convierta en cadena para imprimir la tarea.
    @Override
    
    public String toString() {
        //Variables
        String estadoTarea;
        
        //Condicional para ver si esta en completado o pendiente.
        if (estado) {
            estadoTarea = Estilos.Verde + Estilos.Negrita + "Completado" + Estilos.Restablecer; //Marca el estado como Completado.
        } else {
            estadoTarea = Estilos.Amarillo + Estilos.Negrita + "Pendiente" + Estilos.Restablecer; //Marca el estado como Pendiente.
        }
        //Imprimir la tarea con los estilos.
        return Estilos.Morado + Estilos.Negrita +  "\n------------Tarea " + identificador + "------------" + Estilos.Restablecer +
               Estilos.Azul + Estilos.Negrita + "\nDescripción: " + Estilos.Restablecer +  descripcion + "\n" +
               Estilos.Azul + Estilos.Negrita +"Vencimiento: " + Estilos.Restablecer +  vencimiento + "\n" +
               Estilos.Azul + Estilos.Negrita +"Nombre del encargado: " + Estilos.Restablecer + nombreEncargado + " " + apellidoEncargado + "\n" +
               Estilos.Azul + Estilos.Negrita +"Estado: " + Estilos.Restablecer + estadoTarea;
    }

}