package co.matisses.persistence.dwb.facade;

import co.matisses.persistence.dwb.entity.VentasNetas;
import co.matisses.persistence.dwb.entity.VentasNetas_;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class VentasNetasFacade extends AbstractFacade<VentasNetas> {

    @PersistenceContext(unitName = "DWBPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(VentasNetasFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentasNetasFacade() {
        super(VentasNetas.class);
    }

    public List<VentasNetas> obtenerVentasReferencia(String referencia) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VentasNetas> cq = cb.createQuery(VentasNetas.class);
        Root<VentasNetas> ventas = cq.from(VentasNetas.class);

        cq.where(cb.equal(ventas.get(VentasNetas_.referencia), referencia));
        cq.orderBy(cb.asc(ventas.get(VentasNetas_.fecha)), cb.asc(ventas.get(VentasNetas_.referencia)));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
        }
        return null;
    }

    public List<VentasNetas> obtenerVentasFecha(Date fecha) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VentasNetas> cq = cb.createQuery(VentasNetas.class);
        Root<VentasNetas> ventas = cq.from(VentasNetas.class);

        cq.where(cb.equal(ventas.<Date>get(VentasNetas_.fecha), fecha));
        cq.orderBy(cb.asc(ventas.get(VentasNetas_.fecha)), cb.asc(ventas.get(VentasNetas_.referencia)));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener las ventas para la fecha. ", e);
            return new ArrayList<>();
        }
    }

    public List<VentasNetas> obtenerVentasFechaReferencia(Date fecha, List<String> referencias) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VentasNetas> cq = cb.createQuery(VentasNetas.class);
        Root<VentasNetas> ventas = cq.from(VentasNetas.class);

        cq.where(cb.and(cb.equal(ventas.<Date>get(VentasNetas_.fecha), fecha), ventas.get(VentasNetas_.referencia).in(referencias)));
        cq.orderBy(cb.asc(ventas.get(VentasNetas_.fecha)), cb.asc(ventas.get(VentasNetas_.referencia)));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener las ventas para la fecha de la referencia. ", e);
            return new ArrayList<VentasNetas>();
        }
    }
}
