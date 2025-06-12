package Ejercicio4.model;

public class Participante {

    public static final String FORMATO_INVALIDO = "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN";
    public static final String TELEFONO_VACIO = "Debe cargar un telefono";
    public static final String NOMBRE_VACIO = "Debe cargar un nombre";
    private String nombre;
    private String telefono;
    private String region;
    private String email;

    public Participante(String nombre, String telefono, String region) {
        checkNombre(nombre);
        checkRegion(region);
        validarTelefono(telefono);

        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    public Participante(String nombre, String telefono, String region, String email) {
        checkNombre(nombre);
        checkRegion(region);
        validarTelefono(telefono);
        checkEmail(email);

        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
        this.email = email;
    }

    private void checkEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new RuntimeException("El email no puede estar vacío");
        }
        if (!email.contains("@")) {
            throw new RuntimeException("El email debe contener un '@'");
        }
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void checkRegion(String region){
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")){
            throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
        }
    }

    private void validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";

        if (telefono.isBlank()){
            throw new RuntimeException(TELEFONO_VACIO);
        }

        if(!telefono.matches(regex)){
            throw new RuntimeException(FORMATO_INVALIDO);
        }
    }


    private void checkNombre(String nombre) {
        if(nombre.isBlank()){
            throw new RuntimeException(NOMBRE_VACIO);
        }
    }

}
