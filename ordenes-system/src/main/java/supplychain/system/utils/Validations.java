package supplychain.system.utils;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public class Validations {

    public static <T> Boolean validaIgualdadEntidad(T entidad, T entidadDB) {
        if (entidadDB != null) {
            return entidad.equals(entidadDB);
        }
        return false;
    }
}
