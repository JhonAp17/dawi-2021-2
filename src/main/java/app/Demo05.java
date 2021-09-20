package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	public static void main(String[] args) {
		// 1. especificar la conexion de BD
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// 2. obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		// procesos obtener  el usuario para eliminarlo
		Usuario u = em.find(Usuario.class, 10);
		
		
		if(u == null) {
			System.out.println("Usuario no existe");
			
		} else {
			System.out.println("Usuario encontrado : " + u.getNombre());
			System.out.println(u);
			em.getTransaction().begin();
			em.remove(u);//eliminar
			em.getTransaction().commit();
			System.out.println("Eliminado OK");
		}
		
		
		em.close();
		
	}
}
