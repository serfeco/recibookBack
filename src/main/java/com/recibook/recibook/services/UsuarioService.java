package com.recibook.recibook.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.recibook.recibook.entities.Escandallo;
import com.recibook.recibook.entities.HojaPedido;
import com.recibook.recibook.entities.Local;
import com.recibook.recibook.entities.Receta;
import com.recibook.recibook.entities.Usuario;
import com.recibook.recibook.exceptions.Excepcion;
import com.recibook.recibook.models.UsuarioModel;
import com.recibook.recibook.repositories.UsuarioRepository;

/**
 * The Class UsuarioService.
 */
@Service
public class UsuarioService {

	/** The repo. */
	@Autowired
	private UsuarioRepository repo;

	/** The model. */
	@Autowired
	private UsuarioModel model;

	public static String encrypt(String texto) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(texto.getBytes(StandardCharsets.UTF_8));
			StringBuilder hexString = new StringBuilder();

			for (byte b : hash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Iniciar sesion. metodo usado también para comprobar la contraseña al
	 * modificarla
	 * 
	 * @param email    the email
	 * @param password the password
	 * @return the usuario
	 */

	public Usuario iniciarSesion(String email, String password) {
		if (email.isBlank() || password.isBlank()) {
			throw new Excepcion(HttpStatus.BAD_REQUEST, "Los campos son incorrectos");
		}

		return repo.inicioSesion(email, encrypt(password));

	}

	/**
	 * Check email.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	public Integer checkEmail(String email) {
		return repo.emailExiste(email);
	}

	/**
	 * Check dni.
	 *
	 * @param dni the dni
	 * @return true, if successful
	 */
	public Integer checkDni(String dni) {
		return repo.dniExiste(dni);
	}

	/**
	 * Registro.
	 *
	 * @param usuario the usuario
	 * @return the usuario
	 * @throws Exception the exception
	 */
	public Usuario registro(Usuario usuario) throws Exception {
		model.apellidoIncorrecto(usuario.getApellidos());
		model.dniCorrecto(usuario.getDni());
		model.nombreIncorrecto(usuario.getNombre());
		model.telefonoIncorrecto(usuario.getTelefono());
		if (checkEmail(usuario.getEmail()) > 0 || checkDni(usuario.getDni()) > 0) {
			throw new Excepcion(HttpStatus.BAD_REQUEST, "Hay datos incorrectos");
		}
		usuario.setFechaCreacion(LocalDate.now());
		usuario.setPassword(encrypt(usuario.getPassword()));
		return repo.save(usuario);

	}

	/**
	 * Modificar usuario.
	 *
	 * @param usuario the usuario
	 * @return the usuario
	 * @throws Exception the exception
	 */
	public Usuario modificarUsuario(Usuario usuario) throws Exception {
		if (usuario.getEmail().isEmpty() || repo.findById(usuario.getEmail()).isEmpty()) {
			throw new Excepcion(HttpStatus.NOT_FOUND, "El usuario no se ha encontrado");
		}
		model.apellidoIncorrecto(usuario.getApellidos());
		model.nombreIncorrecto(usuario.getNombre());
		model.telefonoIncorrecto(usuario.getTelefono());
		usuario.setPassword(usuario.getPassword());
		return repo.save(usuario);
	}

	/**
	 * Modificar password.
	 *
	 * @param email    the email
	 * @param password the password
	 */
	public void modificarPassword(String email, String password) {
		if (password.isBlank()) {
			throw new Excepcion(HttpStatus.NOT_ACCEPTABLE, "Contraseña vacía");
		}
		repo.modifyPassword(email, encrypt(password));
	}

	/**
	 * Locales usuario.
	 *
	 * @param email the email
	 * @return the list
	 */
	public List<Local> localesUsuario(String email) {
		if (repo.findById(email).isPresent()) {
			Usuario usuario = repo.findById(email).get();
			if (usuario.getLocales().isEmpty()) {
				throw new Excepcion(HttpStatus.NO_CONTENT, "No has creado ningun local");
			}
			return usuario.getLocales();
		} else {
			throw new Excepcion(HttpStatus.NOT_FOUND, "No se encontró el usuario");
		}
	}

	/**
	 * Recetas usuario.
	 *
	 * @param email the email
	 * @return the list
	 */
	public List<Receta> recetasUsuario(String email) {
		if (repo.findById(email).isPresent()) {
			Usuario usuario = repo.findById(email).get();
			if (usuario.getRecetas().isEmpty()) {
				throw new Excepcion(HttpStatus.NO_CONTENT, "No has creado ninguna receta");
			}
			return usuario.getRecetas();
		} else {
			throw new Excepcion(HttpStatus.NOT_FOUND, "No se encontró el usuario");
		}
	}

	/**
	 * Escandallos usuario.
	 *
	 * @param email the email
	 * @return the list
	 */
	public List<Escandallo> escandallosUsuario(String email) {
		if (repo.findById(email).isPresent()) {
			Usuario usuario = repo.findById(email).get();
			if (usuario.getEscandallos().isEmpty()) {
				throw new Excepcion(HttpStatus.BAD_REQUEST, "No has creado ningun escandallo");
			}
			return usuario.getEscandallos();
		} else {
			throw new Excepcion(HttpStatus.BAD_REQUEST, "No se encontró el usuario");
		}

	}

	/**
	 * Hoja pedido usuario.
	 *
	 * @param email the email
	 * @return the list
	 */
	public List<HojaPedido> hojaPedidoUsuario(String email) {
		if (repo.findById(email).isPresent()) {
			Usuario usuario = repo.findById(email).get();
			if (usuario.getHojaPedidos().isEmpty()) {
				throw new Excepcion(HttpStatus.BAD_REQUEST, "No has creado ninguna hoja de pedidos");
			}
			return usuario.getHojaPedidos();
		} else {
			throw new Excepcion(HttpStatus.BAD_REQUEST, "No se encontró el usuario");
		}

	}

	// ------------METODOS ADMINISTRADOR-----------------

	/**
	 * Modificar usuario admin.
	 *
	 * @param usuario the usuario
	 * @return the usuario
	 * @throws Exception the exception
	 */
	public Usuario modificarUsuarioAdmin(Usuario usuario) throws Exception {
		model.apellidoIncorrecto(usuario.getApellidos());
		model.nombreIncorrecto(usuario.getNombre());
		model.telefonoIncorrecto(usuario.getTelefono());
		model.dniCorrecto(usuario.getDni());
		usuario.setPassword(encrypt(usuario.getPassword()));
		return repo.save(usuario);
	}

	/**
	 * Lista usuario.
	 *
	 * @return the list
	 */
	public List<Usuario> listaUsuario() {
		return repo.findAll();
	}

	/**
	 * Buscar usuario.
	 *
	 * @param email the email
	 * @return the optional
	 */
	public Optional<Usuario> buscarUsuario(String email) {
		return repo.findById(email);
	}

}
