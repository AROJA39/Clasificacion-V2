package extraccion;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONObject;

import constantes.Constantes;
import handler.get;

public class extraccion {


	public static HashMap<String, Object> responseInfo;
	//HashMap<String, Object> codeProcess = get.getValue(Constantes.PROCESSCODE);
	ConcurrentHashMap<String, Object> codeProcess =  get.getValue(Constantes.PROCESSCODE);
	//HashMap<String, Object> additionalInfo = get.getValue(Constantes.SUPPORTINFO);
	ConcurrentHashMap<String, Object> additionalInfo =   get.getValue(Constantes.SUPPORTINFO);
	
	
	public String extraccionClasificacion1(HashMap<String, String> map) {
		Long initialTime = System.nanoTime();
		responseInfo= new HashMap<>();
		Set<String> keys = map.keySet();
		String field = new String();
		String key1 = null;
		for (String key: keys ) {
			if (key.equals("P3")) {
				key1 = map.get(key);
				field = codeProcess.containsKey(map.get(key)) ? (String) codeProcess.get(map.get(key)) : Constantes.INFO_NOT_FOUND;
			}else if (key.contains("EXCEPCION")) {				
				key1 = key1 + map.get(key);				
				field = codeProcess.containsKey(key1) ? (String) codeProcess.get(key1) : Constantes.INFO_NOT_FOUND;
				responseInfo.put("P3", field);
			}else {
				field = additionalInfo.containsKey(key + "_" + map.get(key)) ? (String) additionalInfo.get(key + "_" + map.get(key)) : Constantes.INFO_NOT_FOUND;
			}
			responseInfo.put(key, field);
        }
		responseInfo.put("Z_STATUS", responseInfo.containsValue(Constantes.INFO_NOT_FOUND) ? "FAILED" : "SUCCESS");
		responseInfo.put("VERSION",Constantes.VERSION);		
		responseInfo.put("TIEMPO",(System.nanoTime()-initialTime)+" Nanosegundos");
		responseInfo.put("SERVICIO",Constantes.SERVICIO);		
		responseInfo.put("PAQUETE",Constantes.PAQUETE);		
		responseInfo.put("CLASE",Constantes.CLASE);		
		responseInfo.put("ENDPOINT",Constantes.ENDPOINT);		
		
		
		JSONObject jsonObject = new JSONObject(responseInfo);
		return jsonObject.toString();
	}

}
