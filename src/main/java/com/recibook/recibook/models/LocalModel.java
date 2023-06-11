package com.recibook.recibook.models;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.recibook.recibook.exceptions.Excepcion;


/**
 * The Class LocalModel.
 */
@Component
public class LocalModel {

    /**
     * Validar cif.
     *
     * @param cif the cif
     * @return true, if successful
     */
    public boolean validarCif(String cif) {
      

        boolean respuesta = false;
                                
        char tabla[] = { 'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
                                                                           
        int sumap = 0;
        int sumai = 0;
        int p;
        int R;
        int dc;
        cif = cif.toUpperCase();
        try {
            sumap = Integer.parseInt(cif.substring(2, 3)) + Integer.parseInt(cif.substring(4, 5))
                    + Integer.parseInt(cif.substring(6, 7));
            for (int i = 1; i <= 8; i++) {
                p = 2 * Integer.parseInt(cif.substring(i, i + 1));
                if (p > 9) {
                    sumai += (p / 10) + (p % 10);
                } else {
                    sumai += p;
                }
                i++;
            }
            R = sumap + sumai;
            dc = R % 10;
            dc = 10 - dc;
            if (dc == 10) {
                dc = 0;
            }
            if (Character.isLetter(cif.charAt(8))) {
                if (tabla[dc] == cif.charAt(8)) {
                    respuesta = true;
                }
            } else {
                if (dc == Integer.parseInt(cif.substring(8, 9))) {
                    respuesta = true;
                }
            }
        } catch (ArithmeticException e) {
            respuesta = false;
            throw new Excepcion(HttpStatus.BAD_REQUEST, "El CIF no es correcto");
        }
        return respuesta;
    }
    
    /**
     * Telefono incorrecto.
     *
     * @param telefono the telefono
     * @return true, if successful
     * @throws Excepcion the excepcion
     */
    public boolean telefonoIncorrecto(String telefono) throws Excepcion {
        if (telefono.isBlank()) {
            throw new Excepcion(HttpStatus.BAD_REQUEST, "El telefono está vacio");
        }else {
        for(int i = 0; i < telefono.length(); i++) {
            if (Character.isLetter(i)) {
                throw new Excepcion(HttpStatus.BAD_REQUEST, "Este número contiene caracteres inválidos");
            }
        }
        return true;
        }
    }
    
}
