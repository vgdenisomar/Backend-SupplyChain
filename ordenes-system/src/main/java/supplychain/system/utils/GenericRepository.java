package supplychain.system.utils;

import javax.persistence.EntityManager;
import supplychain.system.interfaces.BaseEntity;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public class GenericRepository {

    public static void guardarCambios(EntityManager entityManager, BaseEntity entidadAEditar, BaseEntity nuevaEntidad) {
        GenericRepository genericRepository = new GenericRepository();
        if (entidadAEditar == null) {
            entityManager.persist(nuevaEntidad);
        } else if (!Validations.validaIgualdadEntidad(nuevaEntidad, entidadAEditar)) {
            genericRepository.modificarEntidad(entityManager, entidadAEditar, nuevaEntidad);
        }
    }

    private void modificarEntidad(EntityManager entityManager, BaseEntity entidadAEditar, BaseEntity nuevaEntidad) {
        entityManager.merge(nuevaEntidad);

    }
}
