package com.ciberfarma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_proveedor")
@Data
public class Proveedores {
	@Id
	public int idproveedor;
	public String nombre_rs;
	public String telefono;
	public String email;
}
