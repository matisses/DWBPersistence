package co.matisses.persistence.dwb.facade;

import co.matisses.persistence.dwb.entity.Entradas;
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
public class EntradasFacade extends AbstractFacade<Entradas> {

    @PersistenceContext(unitName = "DWBPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(EntradasFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntradasFacade() {
        super(Entradas.class);
    }

    public List<Date> obtenerFechasRelevantes(List<String> referencias) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT DISTINCT(fecha) ");
        sb.append("FROM   entradas ");
        sb.append("WHERE  referencia IN (");

        for (String reference : referencias) {
            sb.append("'");
            sb.append(reference);
            sb.append("',");
        }

        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(") ");

        sb.append("UNION ");
        sb.append("SELECT DISTINCT(fecha) ");
        sb.append("FROM   ventasnetas ");
        sb.append("WHERE  referencia IN (");

        for (String reference : referencias) {
            sb.append("'");
            sb.append(reference);
            sb.append("',");
        }

        sb.deleteCharAt(sb.lastIndexOf(","));

        sb.append(") ");
        sb.append("order by fecha ");

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener las fechas relevantes. ", e);
            return new ArrayList<>();
        }
    }

    public List<Entradas> obtenerEntradasFecha(Date fecha) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Entradas> cq = cb.createQuery(Entradas.class);
        Root<Entradas> root = cq.from(Entradas.class);

        cq.where(cb.equal(root.<Date>get("fecha"), fecha));
        cq.orderBy(cb.asc(root.get("fecha")), cb.asc(root.get("referencia")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error obteniendo por fecha. ", e);
            return new ArrayList<Entradas>();
        }
    }

    public List<Entradas> obtenerEntradasReferencias(Date fecha, List<String> referencias) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Entradas> cq = cb.createQuery(Entradas.class);
        Root<Entradas> root = cq.from(Entradas.class);

        cq.where(cb.and(cb.equal(root.<Date>get("fecha"), fecha), root.get("referencia").in(referencias)));
        cq.orderBy(cb.asc(root.get("fecha")), cb.asc(root.get("referencia")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error obteniendo por referencias. ", e);
            return new ArrayList<Entradas>();
        }
    }
}
