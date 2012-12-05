package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.xDatosContactox;
import modelo.xEsposax;
import modelo.xPoligamox;
import modelo.xTransaccionx;

public class ClasePrincipal {
	
	private static final String PERSISTENCE_UNIT_NAME = "gente";
	private EntityManagerFactory fabrica;
	
	public void configurar() throws Exception{
		fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = fabrica.createEntityManager();

		// Empezar una transaccion local para poder crear persistencias
		em.getTransaction().begin();
		
		// Leer los registros existentes
		Query q = em.createQuery("select m from Usuario m");
		// Deberia estar vacia
		boolean createNewEntries = (q.getResultList().size() == 0);
		
		if (createNewEntries) {
			xPoligamox poligamo = new xPoligamox();
			xDatosContactox datos = new xDatosContactox();
		
			datos.setCelular("3003019621");
			datos.setTelefono("0345448888");
			datos.setDireccion("Av Siempre Viva 123");
	
			poligamo.setNombre("Asrahir");
			poligamo.setApellido("Asnab");
			poligamo.setFechaNacimiento(12011967);
			poligamo.setDatosContacto(datos);
			em.persist(poligamo);
			
		for(int i=0;i<20;i++){
			xEsposax esposa = new xEsposax();
			esposa.setNombre("Juana_"+i);
			esposa.setApellido("de Asnab");
			esposa.setCupo(i*100+50);
			esposa.setMarido(poligamo);
			poligamo.getEsposas().add(esposa);
			em.persist(esposa);
			em.persist(poligamo);
			}
		}
		
		// Hace commit en la base de datos
		em.getTransaction().commit();

		// Siempre es bueno cerrar la entidad para que se preserve
		em.close();
	}
	
	public void comprar (){
		EntityManager em = fabrica.createEntityManager();
		em.getTransaction().begin();
		Query q = em
				.createQuery("SELECT e FROM Usuario e WHERE e.nombre = :primerNombre AND e.apellido = :apellido");
		q.setParameter("primerNombre", "Juana_14");
		q.setParameter("apellido", "de Asnab");
		xEsposax usuario = (xEsposax) q.getSingleResult();
		System.out.println(usuario.getCupo());
		
		xTransaccionx compra = new xTransaccionx();
		compra.setFecha(220112);
		compra.setMonto(100);
		em.persist(compra);
		
		xTransaccionx compra2 = new xTransaccionx();
		compra2.setFecha(221215);
		compra2.setMonto(150);
		em.persist(compra2);
		
		usuario.getCompra().add(compra);
		usuario.getCompra().add(compra2);
		em.persist(usuario);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void borrar(){
		EntityManager em = fabrica.createEntityManager();
		em.getTransaction().begin();
		Query q = em
				.createQuery("SELECT e FROM Usuario e WHERE e.nombre = :primerNombre AND e.apellido = :apellido");
		q.setParameter("primerNombre", "Juana_3");
		q.setParameter("apellido", "de Asnab");
		xEsposax usuario = (xEsposax) q.getSingleResult();
		System.out.println(usuario.getNombre());
		em.remove(usuario);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ClasePrincipal p = new ClasePrincipal();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        int opcion = 0;
        
		do{
        System.out.println("1-Crear Registros");
		System.out.println("2-Comprar ");
		System.out.println("3-Borrar ");
		opcion = Integer.parseInt(br.readLine());
		
		switch(opcion){
			
		case 1:
			p.configurar();
			break;
		
		case 2:
			p.comprar();
			break;
		
		case 3:
			p.borrar();
			break;
		}
		}while(opcion!=4);

	}
}
