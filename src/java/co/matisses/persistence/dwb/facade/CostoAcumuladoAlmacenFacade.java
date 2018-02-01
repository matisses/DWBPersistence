package co.matisses.persistence.dwb.facade;

import co.matisses.persistence.dwb.entity.CostoAcumuladoAlmacen;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class CostoAcumuladoAlmacenFacade extends AbstractFacade<CostoAcumuladoAlmacen> {

    @PersistenceContext(unitName = "DWBPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(CostoAcumuladoAlmacenFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CostoAcumuladoAlmacenFacade() {
        super(CostoAcumuladoAlmacen.class);
    }

    public List<CostoAcumuladoAlmacen> acumuladosTaller(Date fechaInicio, Date fechaFin) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CostoAcumuladoAlmacen> cq = cb.createQuery(CostoAcumuladoAlmacen.class);
        Root<CostoAcumuladoAlmacen> from = cq.from(CostoAcumuladoAlmacen.class);

        Predicate conj = cb.conjunction();
        if (fechaInicio != null && fechaFin != null) {
            conj.getExpressions().add(cb.between(from.get("costoAcumuladoAlmacenPK").<Date>get("fecha"), fechaInicio, fechaFin));
        }

        conj.getExpressions().add(cb.equal(from.get("costoAcumuladoAlmacenPK").<String>get("whsCode"), "9901"));
        cq.where(conj);

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener el saldo acumulado en el taller. ", e);
            return null;
        }
    }
}
