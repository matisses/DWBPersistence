package co.matisses.persistence.dwb.facade;

import co.matisses.persistence.dwb.entity.InformeRotacion;
import co.matisses.persistence.dwb.entity.InformeRotacion_;
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
public class InformeRotacionFacade extends AbstractFacade<InformeRotacion> {

    @PersistenceContext(unitName = "DWBPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(InformeRotacionFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InformeRotacionFacade() {
        super(InformeRotacion.class);
    }

    public long obtenerTotalDatos() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<InformeRotacion> columna = cq.from(InformeRotacion.class);

        cq.select(cb.count(columna));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, e.getMessage());
            return 0;
        }
    }

    public List<InformeRotacion> obtenerInformes(int pageNum, int pageSize) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<InformeRotacion> cq = cb.createQuery(InformeRotacion.class);
        Root<InformeRotacion> factura = cq.from(InformeRotacion.class);

        cq.orderBy(cb.desc(factura.get(InformeRotacion_.idInforme)));

        javax.persistence.Query query = em.createQuery(cq);
        query.setFirstResult((pageNum - 1) * pageSize);
        query.setMaxResults(pageSize);

        try {
            return query.getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "", e);
            return null;
        }
    }

    public void eliminarInforme(Integer idInforme) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<InformeRotacion> cd = cb.createCriteriaDelete(InformeRotacion.class);
        Root<InformeRotacion> rotacion = cd.from(InformeRotacion.class);

        cd.where(cb.equal(rotacion.get(InformeRotacion_.idInforme), idInforme));

        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            return;
        }
    }

    public InformeRotacion obtenerInformeProcesar() {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT TOP 1 * ");
        sb.append("FROM   informe_rotacion ");
        sb.append("WHERE  estado = 1 AND (SELECT COUNT(estado) FROM informe_rotacion WHERE estado = 2) <= 0 ");
        sb.append("ORDER  BY id_informe ");

        try {
            return (InformeRotacion) em.createNativeQuery(sb.toString(), InformeRotacion.class).getSingleResult();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los informes de rotacion pendientes. ", e);
        }
        return null;
    }
}
