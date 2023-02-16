package constantes;

public class Constantes {

	/**
	 * Esta clase define version inicial historia de usuario HU1 construida 
	 * @author: Karen Daniela  Medina Tovar & Adriana Patricia Rojas Beltran
	 * @version:  2023/01/24
	 * @see <a href = "https://es.wikipedia.org/wiki/ISO_8583#Message_Origin_-_Origen_del_Mensaje" /> </a>
	 * @apiNote el codigo de proceso para a transaccion de retiro ,cobro giros, compra QR y devolucion QR , requiere un identificador adicional para ser identificadas para  buscarlo en el codigo JSON
	 * 
	 */
	public static String JSONS = ".\\\\json\\\\Configuraciones.json";
	public static final String PROCESSCODE = "CODIGOPROCESO";
	public static final String SUPPORTINFO = "INFOAPOYO";
	public static final String INFO_NOT_FOUND = "Informacion no encontrada";
	public static final String VERSION= "1.0.0"; 
	public static final String SERVICIO= "Identificacion de Transacciones"; 
	public static final String PAQUETE= "extraccion"; 
	public static final String CLASE= "extraccion";  // Primera en mayuscula
	public static final String ENDPOINT= "http://localhost:8000/"; 
}
