package co.matisses.persistence.dwb.facade;

import co.matisses.persistence.dwb.entity.DevolucionEncabezado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class DevolucionEncabezadoFacade extends AbstractFacade<DevolucionEncabezado> {

    @PersistenceContext(unitName = "DWBPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DevolucionEncabezadoFacade() {
        super(DevolucionEncabezado.class);
    }
}
