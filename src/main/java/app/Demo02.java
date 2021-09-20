package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	public static void main(String[] args) {
		// 1. especificar la conexion de BD
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// 2. obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		// procesos actualizar un nyevo usuario
		Usuario u = new Usuario();
		u.setCodigo(12);
		u.setNombre("Mayyyy");
		u.setApellido("Campos");
		u.setUsuario("mattttt@gmail.com");
		u.setClave("0001ma");
		u.setFnacim("2020/08/02");
		u.setTipo(1);
		u.setEstado(1);
		
		//registrar, actualizar, eliminar -> transsaccion
		try {
			em.getTransaction().begin();
			em.merge(u);//actualizar
			em.getTransaction().commit();
			System.out.println("Actualizacion OK");
		} catch (Exception e) {
			System.out.println("Error : " + e.getClass().getTypeName());
		}
		
		em.close();
		
	}
}
