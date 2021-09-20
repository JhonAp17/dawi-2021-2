package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	public static void main(String[] args) {
		// 1. especificar la conexion de BD
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// 2. obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		// procesos registrar un nyevo usuario
		Usuario u = new Usuario();
		u.setCodigo(10);
		u.setNombre("Caro");
		u.setApellido("Campos");
		u.setUsuario("caro@gmail.com");
		u.setClave("fresa");
		u.setFnacim("2021/08/24");
		u.setTipo(1);
		u.setEstado(1);
		
		//registrar, actualizar, eliminar -> transsaccion
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			System.out.println("Registro OK");
		} catch (Exception e) {
			System.out.println("Error : " + e.getClass().getName());
		}
		
		em.close();
		
	}
}
