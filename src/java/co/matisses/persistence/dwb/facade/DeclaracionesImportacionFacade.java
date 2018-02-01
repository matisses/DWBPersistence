package co.matisses.persistence.dwb.facade;

import co.matisses.persistence.dwb.entity.DeclaracionesImportacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class DeclaracionesImportacionFacade extends AbstractFacade<DeclaracionesImportacion> {

    @PersistenceContext(unitName = "DWBPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeclaracionesImportacionFacade() {
        super(DeclaracionesImportacion.class);
    }
}
