package model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	@Id
	private String producto;
	private String descripcion;
	private int stock;
	private double precio;
	private int categoria;
	private int estado;
	
	
}
