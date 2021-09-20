package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo06 {
	
	public static void main(String[] args) {
		// 1. especificar la conexion de BD
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// 2. obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		//listado de los usuarios DE UNA TABLA DE MYSQL
		TypedQuery<Usuario> query = em.createQuery("Select u from Usuario u", Usuario.class);
		List<Usuario> lstUsuario = query.getResultList();
		System.out.println("Cantidad de usuarios :" + lstUsuario.size());
		
		if(lstUsuario.size()==0)
			System.out.println("Listado VAcio");
		else {
			System.out.println("LISTADO DE USUARIOS");
			for (Usuario u : lstUsuario) {
				System.out.println(">>> : " + u);
			}
		}
		
		
		
		List<Usuario> lstUsuario2 = em.createQuery("Select u from Usuario u", Usuario.class).getResultList();
		System.out.println("Cantidad de usuarios :" + lstUsuario2.size());
		
		if(lstUsuario2.size()==0)
			System.out.println("Listado VAcio");
		else {
			System.out.println("--LISTADO DE USUARIOS--");
			for (Usuario u : lstUsuario2) {
				System.out.println(">>> : " + u);
			}
		}
		
		//LISTADO CON PARAMETROS >- LISTADO DE LOS USUARIOS POR TIPO
		String sql = "Select u from Usuario u where u.tipo= :xtipo";
		TypedQuery<Usuario> query3 = em.createQuery(sql, Usuario.class);
		query3.setParameter("xtipo",1);
		
		List<Usuario> lstUsuario3 = query3.getResultList();
		System.out.println("Cantidad de usuarios :" + lstUsuario3.size());
		
		if(lstUsuario3.size()==0)
			System.out.println("Listado VAcio");
		else {
			System.out.println("LISTADO DE USUARIOS TIPO 1");
			for (Usuario u : lstUsuario3) {
				System.out.println(">>> : " + u);
			}
		}
		
		
		
		em.close();
		
	}
		
}
