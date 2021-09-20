package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



import model.Usuario;

public class Demo09 {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em = fabrica.createEntityManager();
		
		//Usuario u = em.find(Usuario.class, 12);
		
		//String sql = "{call usp_validaAcceso ( :xusr and u.clave = :xcla)}";
		String sql = "{call usp_validaAcceso ( ?,?)}";
		//TypedQuery<Usuario> query3 = em.createQuery(sql, Usuario.class); esto es solo para JPA
		
		Query query3 = em.createNativeQuery(sql, Usuario.class); //nativo
		query3.setParameter(1,"U002@gmail.com");
		query3.setParameter(2,"10002");
		
		Usuario u = null;
		try {
			u = (Usuario) query3.getSingleResult();
		} catch (NoResultException e) {
			
		
		}
		
		if(u == null) {
			System.out.println("Usuario no existe");
		} else {
			System.out.println("Usuario encontrado : " + u.getNombre());
			System.out.println(u);
		}
		
		
		em.close();
		
	}


}
