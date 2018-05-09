package co.matisses.persistence.dwb.facade;

import co.matisses.persistence.dwb.entity.RotacionImportacion;
import co.matisses.persistence.dwb.entity.RotacionImportacion_;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class RotacionImportacionFacade extends AbstractFacade<RotacionImportacion> {

    @PersistenceContext(unitName = "DWBPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(RotacionImportacionFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RotacionImportacionFacade() {
        super(RotacionImportacion.class);
    }

    public void eliminarTodo() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<RotacionImportacion> cd = cb.createCriteriaDelete(RotacionImportacion.class);
        Root<RotacionImportacion> rotacion = cd.from(RotacionImportacion.class);

        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al eliminar todos los registros de rotacion importacion. ", e);
        }
    }

    public void eliminarReferencias(List<String> referencias) {
        StringBuilder sb = new StringBuilder();

        sb.append("DELETE FROM rotacionimportacion ");
        sb.append("WHERE  referencia IN (");

        for (String reference : referencias) {
            sb.append("'");
            sb.append(reference);
            sb.append("',");
        }

        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(")");

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al eliminar los registros de rotacion importacion. ", e);
        }
    }

    public List<RotacionImportacion> obtenerRotacionItem(String item) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<RotacionImportacion> cq = cb.createQuery(RotacionImportacion.class);
        Root<RotacionImportacion> rotacion = cq.from(RotacionImportacion.class);

        cq.where(cb.equal(rotacion.get("rotacionImportacionPK").get("referencia"), item));
        cq.orderBy(cb.asc(rotacion.get(RotacionImportacion_.fechaCompra)));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
        }
        return null;
    }

    public List<Float> obtenerDiasRotacionPromedioReferencia(String referencia) {
        List<Float> dias = new ArrayList<>();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<RotacionImportacion> cq = cb.createQuery(RotacionImportacion.class);
        Root<RotacionImportacion> root = cq.from(RotacionImportacion.class);

        cq.where(cb.equal(root.get("rotacionImportacionPK").get("referencia"), referencia));

        try {
            List<RotacionImportacion> resultado = em.createQuery(cq).getResultList();

            for (RotacionImportacion r : resultado) {
                if (r.getCantidadVenta() > 0) {
                    dias.add(new Float(r.getDiasStock() / r.getCantidadVenta()));
                } else {
                    dias.add(new Float(r.getDiasStock()));
                }
            }
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los dias promedio de rotacion para referencias. ", e);
        }
        return dias;
    }

    public List<Float> obtenerUtilidadPromedioReferencia(String referencia) {
        List<Float> utilidad = new ArrayList<Float>();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<RotacionImportacion> cq = cb.createQuery(RotacionImportacion.class);
        Root<RotacionImportacion> root = cq.from(RotacionImportacion.class);

        cq.where(cb.equal(root.get("rotacionImportacionPK").get("referencia"), referencia));

        try {
            List<RotacionImportacion> resultado = em.createQuery(cq).getResultList();

            for (RotacionImportacion r : resultado) {
                if (r.getUtilidadPromedio() != null) {
                    utilidad.add(r.getUtilidadPromedio().floatValue());
                }
            }
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar la utilidad promedio de rotacion para referencias. ", e);
        }
        return utilidad;
    }

    public int obtenerSiguienteID(String referencia) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT (ISNULL(MAX(id_compra), 0) + 1) nextId ");
        sb.append("FROM   rotacionimportacion ");
        sb.append("WHERE  referencia = '");
        sb.append(referencia);
        sb.append("' ");

        try {
            return (Integer) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el siguiente ID. ", e);
            return 1;
        }
    }

    public RotacionImportacion obtenerPrimeraImportacionAbierta(String referencia) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<RotacionImportacion> cq = cb.createQuery(RotacionImportacion.class);
        Root<RotacionImportacion> root = cq.from(RotacionImportacion.class);

        cq.where(cb.and(cb.isNull(root.<Date>get(RotacionImportacion_.fechaCierre)), cb.equal(root.get("rotacionImportacionPK").get("referencia"), referencia)));
        cq.orderBy(cb.asc(root.get(RotacionImportacion_.fechaCompra)));

        try {
            return em.createQuery(cq).getResultList().get(0);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener la primera importacion abierta. ", e);
            return new RotacionImportacion();
        }
    }

    public List<RotacionImportacion> obtenerImportacionesAbiertas(String referencias) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<RotacionImportacion> cq = cb.createQuery(RotacionImportacion.class);
        Root<RotacionImportacion> root = cq.from(RotacionImportacion.class);

        cq.where(cb.and(cb.isNull(root.<Date>get(RotacionImportacion_.fechaCierre)), cb.equal(root.get("rotacionImportacionPK").get("referencia"), referencias)));
        cq.orderBy(cb.asc(root.get(RotacionImportacion_.fechaCompra)));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener las importaciones abiertas. ", e);
            return new ArrayList<RotacionImportacion>();
        }
    }
}
