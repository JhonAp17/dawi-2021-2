package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	public static void main(String[] args) {
		// 1. especificar la conexion de BD
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// 2. obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		// procesos eliminar  un nyevo usuario
		Usuario u = new Usuario();
		u.setCodigo(12);
		
		
		//registrar, actualizar, eliminar -> transsaccion
		try {
			em.getTransaction().begin();
			em.remove(u);//actualizar
			em.getTransaction().commit();
			System.out.println("Eliminado OK");
		} catch (Exception e) {
			System.out.println("Error : " + e.getClass().getTypeName());
		}
		
		em.close();
		
	}
}
