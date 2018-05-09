package co.matisses.persistence.dwb.facade;

import co.matisses.persistence.dwb.entity.Rotacion;
import co.matisses.persistence.dwb.entity.Rotacion_;
import co.matisses.persistence.sap.dto.FiltroDTO;
import co.matisses.persistence.sap.facade.BaruColorFacade;
import co.matisses.persistence.sap.facade.BaruColorGenericoFacade;
import co.matisses.persistence.sap.facade.BaruMaterialArticuloFacade;
import co.matisses.persistence.sap.facade.ItemInventarioFacade;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
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
public class RotacionFacade extends AbstractFacade<Rotacion> {

    @PersistenceContext(unitName = "DWBPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(RotacionFacade.class.getSimpleName());
    @EJB
    private BaruColorFacade baruColorFacade;
    @EJB
    private BaruColorGenericoFacade baruColorGenericoFacade;
    @EJB
    private BaruMaterialArticuloFacade baruMaterialArticuloFacade;
    @EJB
    private ItemInventarioFacade itemInventarioFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RotacionFacade() {
        super(Rotacion.class);
    }

    public List<Rotacion> obtenerInforme(Integer idInforme) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Rotacion> cq = cb.createQuery(Rotacion.class);
        Root<Rotacion> rotacion = cq.from(Rotacion.class);

        cq.where(cb.equal(rotacion.get(Rotacion_.idInforme), idInforme));
        cq.orderBy(cb.desc(rotacion.get(Rotacion_.referencia)));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el informe. ", e);
            return null;
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Object> crearReporte(HashMap<FiltroDTO, List<String>> params) {
        String fechaInicio;
        String fechaFin;
        boolean primeras = true;
        List<String> referencias = new ArrayList<>();
        StringBuilder items = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //Si en los parametros hay fecha inicial, la configura; sino, toma el 2007-01-01
        if (validarFiltro("fechaInicio", params)) {
            fechaInicio = (String) obtenerValorFiltro("fechaInicio", params);
        } else {
            fechaInicio = "01/01/2007";
        }
        CONSOLE.log(Level.INFO, "Fecha inicio: {0}", fechaInicio);

        //Si en los parametros hay fecha final, la configura; sino, toma la fecha actual
        if (validarFiltro("fechaFin", params)) {
            fechaFin = (String) obtenerValorFiltro("fechaFin", params);
        } else {
            fechaFin = sdf.format(new Date());
        }
        CONSOLE.log(Level.INFO, "Fecha fin: {0}", fechaFin);

        if (validarFiltro("color_especifico", params)) {
            List<String> refColor = baruColorFacade.obtenerReferenciasColor(params);

            if (refColor.size() > 0) {
                referencias = validarRelacion(refColor, referencias, primeras);
                primeras = false;
            }
        }

        if (validarFiltro("color", params)) {
            List<String> refColorGenerico = baruColorGenericoFacade.obtenerReferenciasColorGenerico(params);

            if (refColorGenerico.size() > 0) {
                referencias = validarRelacion(refColorGenerico, referencias, primeras);
                primeras = false;
            }
        }

        if (validarFiltro("U_materiales", params)) {
            List<String> refMateriales = baruMaterialArticuloFacade.obtenerReferenciasMateriales(params);

            if (refMateriales.size() > 0) {
                referencias = validarRelacion(refMateriales, referencias, primeras);
                primeras = false;
            }
        }

        List<String> refFiltros = itemInventarioFacade.obtenerReferenciasParametros(params);
        if (refFiltros.size() > 0) {
            referencias = validarRelacion(refFiltros, referencias, primeras);
        }

        for (String r : referencias) {
            items.append("'");
            items.append(r);
            items.append("',");
        }
        if (referencias.size() > 0) {
            items.deleteCharAt(items.length() - 1);
        }

        StringBuilder query = new StringBuilder();

        query.append("SELECT referencia,  ");
        query.append("       CONVERT(INT, SUM(case tipo when 'Compra' then cantidad_compra else 0 end)) comprado, ");
        query.append("       CONVERT(INT, SUM(case tipo when 'Entrada' then cantidad_compra else 0 end)) entrada, ");
        query.append("       CONVERT(INT, SUM(case tipo when 'EntradaTaller' then cantidad_compra else 0 end)) entradaTaller, ");
        query.append("       CONVERT(INT, SUM(case tipo when 'N/A' then cantidad_compra else 0 end)) otraEntrada, ");
        query.append("       MIN(fecha_compra) fecha_compra, ");
        query.append("       CASE WHEN MAX(ISNULL(fecha_cierre, CONVERT(DATE, '31/12/2199', 103))) = CONVERT(DATE, '31/12/2199', 103) THEN NULL ");
        query.append("        ELSE MAX(ISNULL(fecha_cierre, CONVERT(DATE, '31/12/2199', 103))) END fecha_cierre, ");
        query.append("       CONVERT(INT, SUM(dias_stock * (CASE WHEN cantidad_venta = 0 THEN 0 ELSE 1 END))) promedio_dias, ");
        query.append("       CONVERT(INT, MAX(dias_stock)) maximo_dias, ");
        query.append("       CONVERT(INT, SUM(saldo_pendiente)) pendiente, ");
        query.append("       CONVERT(INT, SUM(cantidad_venta)) vendido, ");
        query.append("       CONVERT(INT, SUM(cantidad_baja)) bajas, ");
        query.append("       MAX(fecha_ultima_venta) ultima_venta, ");
        query.append("       ISNULL(MIN(utilidad_minima), 0) utilidad_minima, ");
        query.append("       ISNULL(AVG(utilidad_promedio), 0) utilidad_promedio, ");
        query.append("       ISNULL((SELECT SUM(cantidad_compra) FROM rotacionimportacion r WHERE r.referencia = rotacion.referencia),0) AS total_comprado ");
        query.append("FROM   ROTACIONIMPORTACION rotacion ");
        query.append("WHERE  ((fecha_compra BETWEEN CONVERT(DATE, '");
        query.append(fechaInicio);
        query.append("', 103) AND CONVERT(DATE, '");
        query.append(fechaFin);
        query.append("', 103)) ");
        query.append("OR (fecha_cierre BETWEEN CONVERT(DATE, '");
        query.append(fechaInicio);
        query.append("', 103) AND CONVERT(DATE, '");
        query.append(fechaFin);
        query.append("', 103)) ");
        query.append("AND (fecha_compra < CONVERT(DATE, '");
        query.append(fechaInicio);
        query.append("', 103) AND fecha_cierre > CONVERT(DATE, '");
        query.append(fechaFin);
        query.append("', 103)) ");
        query.append("AND (fecha_compra < CONVERT(DATE, '");
        query.append(fechaInicio);
        query.append("', 103) AND fecha_cierre IS NULL)) ");

        if (items != null && items.length() > 0) {
            query.append("AND referencia IN (");
            query.append(items.toString());
            query.append(") ");
        }

        if (validarFiltro("diasStockMin", params)) {
            query.append("AND dias_stock >= ");
            query.append(obtenerValorFiltro("diasStockMin", params));
            query.append(" ");
        }

        if (validarFiltro("diasStockMax", params)) {
            query.append("AND dias_stock <= ");
            query.append(obtenerValorFiltro("diasStockMax", params));
            query.append(" ");
        }

        //Excluye los registros con inconsistencia (salida / ventas sin una entrada correspondiente)
        query.append("AND cantidad_compra > 0 ");
        query.append("AND LEN(referencia) = 20 ");

        //Agrupa y ordena
        query.append("GROUP BY referencia ");
        query.append("ORDER BY referencia ");

        try {
            if (items.length() > 0 || !fechaInicio.isEmpty() || !fechaFin.isEmpty()) {
                return em.createNativeQuery(query.toString()).getResultList();
            } else {
                return new ArrayList<Object>();
            }
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al armar los datos del informe de rotacion. ", e);
            return new ArrayList<Object>();
        }
    }

    private boolean validarFiltro(String filtro, HashMap<FiltroDTO, List<String>> params) {
        for (Map.Entry<FiltroDTO, List<String>> entry : params.entrySet()) {
            if (entry.getKey().getCodigoColumna().equals(filtro)) {
                return true;
            }
        }

        return false;
    }

    private Object obtenerValorFiltro(String filtro, HashMap<FiltroDTO, List<String>> params) {
        for (Map.Entry<FiltroDTO, List<String>> entry : params.entrySet()) {
            if (entry.getKey().getCodigoColumna().equals(filtro)) {
                return entry.getValue().get(0);
            }
        }

        return null;
    }

    private List<String> validarRelacion(List<String> recientes, List<String> similares, boolean inicial) {
        List<String> referencias = new ArrayList<>();

        if ((similares == null || similares.isEmpty()) && inicial) {
            referencias = recientes;
        }

        if (!inicial) {
            for (String r : recientes) {
                for (String s : similares) {
                    if (r.equals(s)) {
                        referencias.add(s);
                        break;
                    }
                }
            }
        }

        return referencias;
    }

    public void eliminarInforme(Integer idInforme) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Rotacion> cd = cb.createCriteriaDelete(Rotacion.class);
        Root<Rotacion> rotacion = cd.from(Rotacion.class);

        cd.where(cb.equal(rotacion.get(Rotacion_.idInforme), idInforme));

        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            return;
        }
    }
}
