package co.matisses.persistence.dwb.facade;

import co.matisses.persistence.dwb.entity.EstadoInforme;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class EstadoInformeFacade extends AbstractFacade<EstadoInforme> {

    @PersistenceContext(unitName = "DWBPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoInformeFacade() {
        super(EstadoInforme.class);
    }
}
