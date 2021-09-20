package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Producto;

public class Demo07 {
	//*********************************REGISTRAR***********************//
	public static void main(String[] args) {
		// 1. especificar la conexion de BD - DAOFactory
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				
				// 2. Obtener el DAO
				EntityManager em = fabrica.createEntityManager();
				
				// procesos.. registrar un nuevo usuario
				Producto p= new Producto();
				p.setProducto("P0032");
				p.setDescripcion("Papitas");
				p.setStock(10);
				p.setPrecio(1.0);
				p.setCategoria(6);
				p.setEstado(1);
					
				// reg, act, elim -> Transacciones
				try {
					em.getTransaction().begin();
					em.persist(p);	//registrar
					em.getTransaction().commit();
					System.out.println("Registro OK");
				} catch (Exception e) {
					System.out.println("Error : "+e.getClass().getTypeName());
				}
				em.close();
				
				
				
				//***********************************ACTUALIZAR********************************//
					// 1. especificar la conexion de BD - DAOFactory
					EntityManagerFactory fabrica2 = Persistence.createEntityManagerFactory("mysql");
					
					// 2. Obtener el DAO
					EntityManager em2 = fabrica.createEntityManager();
					
					// procesos.. actualizar un usuario
					Producto p2= new Producto();
					p2.setProducto("P0032");
					p2.setDescripcion("Cuates");
					p2.setStock(20);
					p2.setPrecio(0.50);
					p2.setCategoria(6);
					p2.setEstado(2);
					
					// reg, act, elim -> Transacciones
					try {
						em.getTransaction().begin();
						em.merge(p);	//actualizar -> si existe cod / si  no existe lo crea
						em.getTransaction().commit();
						System.out.println("Actualización OK");
					} catch (Exception e) {
						System.out.println("Error : "+e.getClass().getTypeName());
					}
					em.close();
					
					
					//*****************************ELIMINAR*******************************//
						// 1. especificar la conexion de BD - DAOFactory
						EntityManagerFactory fabrica3 = Persistence.createEntityManagerFactory("mysql");
						
						// 2. Obtener el DAO
						EntityManager em3 = fabrica.createEntityManager();
						
						// procesos.. obtener la info del usuario con codigo 12
						Producto p3= em.find(Producto.class, "P0032");
						
						if (p3==null) {
							System.out.println("Producto NO existe");
						}else {
							System.out.println("Producto encontrado : "+p3.getDescripcion());
							System.out.println(p3);
							em.getTransaction().begin();
							em.remove(p3);	//eliminar 
							em.getTransaction().commit();
							System.out.println("Eliminación OK");
						}
						
						em.close();
						
						
						
						
						//**********************************LISTA*******************************//
						// 1. especificar la conexion de BD - DAOFactory
						EntityManagerFactory fabrica4 = Persistence.createEntityManagerFactory("mysql");
						
						// 2. Obtener el DAO
						EntityManager em4 = fabrica.createEntityManager();
						
						// listado de los usuarios
						
						TypedQuery<Producto> query = em4.createQuery("Select p from Producto p",Producto.class);
						
						List<Producto> lstProducto = query.getResultList();
						
						System.out.println("Cantidad de usuarios : "+lstProducto.size());
						
						if (lstProducto.size()==0) {
							System.out.println("Listado vacio");
						}else {
							System.out.println("Listado de usuarios");
							for(Producto u: lstProducto) {
								System.out.println(">>>> "+u);
							}
						}
		
				
		}

}
