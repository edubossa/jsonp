package br.com.json;

import java.io.IOException;
import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JsonApplicationCode
 * <p>
 * http://localhost:8080/JSONProcessing/JsonApplicationCode
 * 
 */
@WebServlet("/JsonApplicationCode")
public class JsonApplicationCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonApplicationCode() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//19.3.2 Creating an Object Model from Application Code
		JsonObject model = 
				Json.createObjectBuilder()
				.add("nome", "Eduardo Wallace")
				.add("sobrenome", "da Silva")
				.add("email", "edubossa@gmail.com")
				.add("telefones", 
						
						Json.createArrayBuilder()
							.add(Json.createObjectBuilder().add("Celular:", "(011) 94606-5413"))
							.add(Json.createObjectBuilder().add("Residencial", "(011) 4798-6523"))
							.add(Json.createObjectBuilder().add("Empresarial", "(011) 6654-3325"))
							
						)
				.build();
		
		
		//19.3.4 Writing an Object Model to a Stream
		StringWriter sw = new StringWriter();
		try(JsonWriter jw = Json.createWriter(sw)) {
			jw.writeObject(model);
		}
		
		response.getWriter().println(sw);
	}

	
}
