package extraccion;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class extraccionTest {

	extraccion extraccion=null;
	HashMap<String, String> request = null;
	String response=null;

	@Test
	void testSuccessfulTransactionWithException() {
		extraccion = new extraccion();
		request = new HashMap<>();
		response = "{\"P22\":\"Lectura Chip\",\"P3\":\"Cuenta De Ahorros.\",\"MTI\":\"Autorizacion\",\"P35\":\"tarjeta presente\",\"P3_TIPODECUENTA\":\"Ahorros\",\"P104_EXCEPCION_CODIGO_PROCESO\":\"Cobro giro WebService\",\"P41\":\"Cajero ATH\",\"Z_STATUS\":\"SUCCESS\"}";
		request.put("P3", "011000");
		request.put("MTI", "200");
		request.put("P35", "4");
		request.put("P41", "1");
		request.put("P22", "051");
		request.put("P3_TIPODECUENTA", "10");
		request.put("P104_EXCEPCION_CODIGO_PROCESO", "10");
		Assertions.assertEquals(response, extraccion.extraccionClasificacion1(request));
	}

	@Test
	void testSuccessfulTransactionWith() {
		extraccion = new extraccion();
		request = new HashMap<>();
		response = "{\"P22\":\"Lectura Chip\",\"P3\":\"Cuenta De Ahorros.\",\"MTI\":\"Autorizacion\",\"P35\":\"tarjeta presente\",\"P3_TIPODECUENTA\":\"Ahorros\",\"P41\":\"Cajero ATH\",\"Z_STATUS\":\"SUCCESS\"}";
		request.put("P3", "011000");
		request.put("MTI", "200");
		request.put("P35", "4");
		request.put("P41", "1");
		request.put("P22", "051");
		request.put("P3_TIPODECUENTA", "10");
		Assertions.assertEquals(response, extraccion.extraccionClasificacion1(request));
	}

	@Test
	void testTransactionWithInvalidInformation() {
		extraccion = new extraccion();
		request = new HashMap<>();
		response = "{\"Z_STATUS\":\"FAILED\",\"P3\":\"Informacion no encontrada\"}";
		request.put("P3", "031000");
		Assertions.assertEquals(response, extraccion.extraccionClasificacion1(request));
	}

}
