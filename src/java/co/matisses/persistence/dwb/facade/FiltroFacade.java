package co.matisses.persistence.dwb.facade;

import co.matisses.persistence.dwb.entity.Filtro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class FiltroFacade extends AbstractFacade<Filtro> {

    @PersistenceContext(unitName = "DWBPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FiltroFacade() {
        super(Filtro.class);
    }
}
