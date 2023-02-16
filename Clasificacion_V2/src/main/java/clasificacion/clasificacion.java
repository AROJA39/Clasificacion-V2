package clasificacion;

import handler.get;
import io.javalin.Javalin;

public class clasificacion {
	
	public static void main(String args[]) {
		Javalin app = Javalin.create().start(8000);
		app.get("/get", new get());
	}

	
}
