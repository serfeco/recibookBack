package com.recibook.recibook.models;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.recibook.recibook.exceptions.Excepcion;

/**
 * The Class UsuarioModel.
 */
@Component

public class UsuarioModel {

    /**
     * Dni correcto.
     *
     * @param dni the dni
     * @return true, if successful
     * @throws Excepcion the excepcion
     */
    public boolean dniCorrecto(String dni) throws Excepcion {
        if(dni.isBlank()) {
            throw new Excepcion(HttpStatus.BAD_REQUEST, "El dni está vacio");
        }else {
        char[] letra = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
                'L', 'C', 'K', 'E' };
        if (dni.length() != 9 || letra[(Integer.parseInt(dni.substring(0, 8)) % 23)] != dni.charAt(8)) {
            throw new Excepcion(HttpStatus.BAD_REQUEST, "Este dni no es correcto");
        }
        return true;
        }
    }

    /**
     * Nombre incorrecto.
     *
     * @param nombre the nombre
     * @return true, if successful
     * @throws Excepcion the excepcion
     */
    public boolean nombreIncorrecto(String nombre) throws Excepcion {
        if(nombre.isBlank()) {
            throw new Excepcion(HttpStatus.BAD_REQUEST, "El nombre está vacio");
        }else {
        for (int i = 0; i < nombre.length(); i++) {
            if (Character.isDigit(nombre.charAt(i))) {
                throw new Excepcion(HttpStatus.BAD_REQUEST, "Este nombre contiene números");
            }
        }
        return true;
        }
    }

    /**
     * Apellido incorrecto.
     *
     * @param apellidos the apellidos
     * @return true, if successful
     * @throws Excepcion the excepcion
     */
    public boolean apellidoIncorrecto(String apellidos) throws Excepcion {
        if (apellidos.isBlank()) {
            throw new Excepcion(HttpStatus.BAD_REQUEST, "El apellido está vacio");
        }else {
        for (int i = 0; i < apellidos.length(); i++) {
            if (Character.isDigit(apellidos.charAt(i))) {
                throw new Excepcion(HttpStatus.BAD_REQUEST, "Este apellido contiene números");
            }
        }
        return true;
        }
    }
    
    /**
     * Telefono incorrecto.
     *
     * @param telefono the telefono
     * @return true, if successful
     * @throws Excepcion the excepcion
     */
    public boolean telefonoIncorrecto(String telefono) throws Excepcion {
 {
        for(int i = 0; i < telefono.length(); i++) {
            if (Character.isLetter(i)) {
                throw new Excepcion(HttpStatus.BAD_REQUEST, "Este número contiene caracteres inválidos");
            }
        }
        return true;
        }
    }
    
    
    
    
    
}
