/*
 *
 */
package poo.cursosccm.dao;

import java.util.List;
import poo.cursosccm.entity.Tematicas;

/**
 * Esta interface provee mecanismos para operar con entidades de tipo Tematicas
 * @author Iván Fischer
 */
public interface TematicasDao {

    /**
     * Permite obtener una lista de Tematicas
     * @return un objeto de tipo List de Tematicas
     */
    public List<Tematicas> listarTematicas();
}
