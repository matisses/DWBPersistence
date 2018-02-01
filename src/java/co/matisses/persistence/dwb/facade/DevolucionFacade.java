package co.matisses.persistence.dwb.facade;

import co.matisses.persistence.dwb.entity.Devolucion;
import co.matisses.persistence.dwb.entity.Devolucion_;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class DevolucionFacade extends AbstractFacade<Devolucion> {

    @PersistenceContext(unitName = "DWBPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(DevolucionFacade.class.getName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DevolucionFacade() {
        super(Devolucion.class);
    }

    public List<Devolucion> obtenerDevolucionesFactura(String numeroFactura) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Devolucion> cq = cb.createQuery(Devolucion.class);
        Root<Devolucion> devolucion = cq.from(Devolucion.class);

        cq.where(cb.equal(devolucion.get(Devolucion_.factura), numeroFactura));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron datos para la factura con numero {0}", numeroFactura);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener los datos de devoluciones para la factura. ", e);
        }
        return null;
    }
}
