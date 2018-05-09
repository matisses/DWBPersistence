package co.matisses.persistence.dwb.facade;

import co.matisses.persistence.dwb.entity.FiltrosInforme;
import co.matisses.persistence.dwb.entity.FiltrosInforme_;
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
public class FiltrosInformeFacade extends AbstractFacade<FiltrosInforme> {

    @PersistenceContext(unitName = "DWBPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(FiltrosInformeFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FiltrosInformeFacade() {
        super(FiltrosInforme.class);
    }

    public List<FiltrosInforme> obtenerInforme(Integer idInforme) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<FiltrosInforme> cq = cb.createQuery(FiltrosInforme.class);
        Root<FiltrosInforme> filtros = cq.from(FiltrosInforme.class);

        cq.where(cb.equal(filtros.get(FiltrosInforme_.idInforme), idInforme));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los filtros del informe. ", e);
        }
        return null;
    }

    public void eliminarInforme(Integer idInforme) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<FiltrosInforme> cd = cb.createCriteriaDelete(FiltrosInforme.class);
        Root<FiltrosInforme> rotacion = cd.from(FiltrosInforme.class);

        cd.where(cb.equal(rotacion.get(FiltrosInforme_.idInforme), idInforme));

        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            return;
        }
    }
}
