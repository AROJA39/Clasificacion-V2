package handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import constantes.Constantes;
import extraccion.extraccion;
import io.javalin.http.ContentType;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class get implements Handler {

	private extraccion extraccion = new extraccion();

	@Override
	public void handle(Context ctx) throws Exception {
		Map<String, List<String>> params = ctx.queryParamMap();
		HashMap<String, String> requestParams = new HashMap<>();
		params.forEach((key, value) -> requestParams.put(key, value.get(0)));
		ctx.contentType(ContentType.APPLICATION_JSON);
		ctx.result(extraccion.extraccionClasificacion1(requestParams));

	}

	public static ConcurrentHashMap<String, Object>getValue(String codigo) {
		try {
			String ruta = Constantes.JSONS;
			JSONObject js = (JSONObject) parse(ruta);
			String firstName = (String) js.get(codigo);
			String ruta2 = firstName;
			Object js2 = parse(ruta2);
			ConcurrentHashMap<String, Object> map = new Gson().fromJson(js2.toString(), ConcurrentHashMap.class);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Object parse(String ruta) throws Exception {
		BufferedReader brBufferedReader = new BufferedReader(new FileReader(ruta));
		StringBuffer stringBuffer = new StringBuffer();
		String aux = null;
		while ((aux = brBufferedReader.readLine()) != null) {
			stringBuffer.append(aux);
		}
		// JSONObject js = new JSONObject(stringBuffer.toString());
		String json = stringBuffer.toString();
		// System.out.println(json);
		if (json.matches("[\\t ]*?\\[.*?")) {
			return new JSONArray(json);
		} else {
			return new JSONObject(json);
		}

	}

}
