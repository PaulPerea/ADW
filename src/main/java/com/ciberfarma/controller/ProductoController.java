package com.ciberfarma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ciberfarma.model.Productos;
import com.ciberfarma.repository.ICategoriaRepository;
import com.ciberfarma.repository.IProductoRepository;
import com.ciberfarma.repository.IProveedorRepository;

@Controller
public class ProductoController {
	@Autowired
	private ICategoriaRepository repoCat;
	@Autowired
	private IProveedorRepository repoProv;
	@Autowired
	private IProductoRepository repoProd;
	
	
	//crea los controladores
	//controlador para abrir la pag de prod
	
	@GetMapping("/cargar")
	public String abrirPagProd(Model model) {
		
		//crear obj de repository
		//enviar un listado para el combo
		//model.addAttribute("mensaje","Exito");
		model.addAttribute("lstCategorias",repoCat.findAll());
		model.addAttribute("lstProveedor",repoProv.findAll());
		model.addAttribute("boton","Registrar");
		//obj de tipo Producto para guardar los datos
		model.addAttribute("productos", new Productos());
		return "crudproductos";
	}
	@GetMapping("/listado")
	public String muestraListado(Model model) {
		
		//crear obj de repository
		//enviar un listado para el combo
		//model.addAttribute("mensaje","Exito");
		model.addAttribute("boton","Registrar");
		model.addAttribute("lstCategorias",repoCat.findAll());
		model.addAttribute("lstProdutos",repoProd.findAll());
		model.addAttribute("lstProveedor",repoProv.findAll());
		model.addAttribute("productos", new Productos());
		return "crudproductos";
	}
	
	//controlador para abrir principal
	@GetMapping("/")
	public String abrirPagPrincipal() {
		return "principal";
	}
	//controlador para grabar
	@PostMapping("/crud/security/producto/guardar")
	public String grabarCrudProducto(@ModelAttribute Productos productos , Model model) {
		
		try {
			repoProd.save(productos);
			model.addAttribute("mensaje","Registra Ok");
			model.addAttribute("clase","alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje","Error al registrar");
			model.addAttribute("clase","alert alert-danger");
		}
		return "crudproductos";
	}
	//controlador para buscar un producto a editar
	@PostMapping("/buscar")
	public String buscarProducto(@RequestParam(name="id_prod") String id_prod, Model modelo) { //lo guardo asi String id_prod
		
		System.out.println(id_prod);
		
		modelo.addAttribute("productos", repoProd.findById(id_prod));
		modelo.addAttribute("lstCategorias",repoCat.findAll());
		modelo.addAttribute("lstProveedor",repoProv.findAll());
		modelo.addAttribute("boton","Actualizar");
		return "crudproductos";
	}
	
	
}
