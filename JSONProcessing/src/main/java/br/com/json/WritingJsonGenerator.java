package br.com.json;

import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WritingJsonGenerator
 * <p>
 * http://localhost:8080/JSONProcessing/WritingJsonGenerator
 * 
 */
@WebServlet("/WritingJsonGenerator")
public class WritingJsonGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WritingJsonGenerator() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * <p>
	 * 19.4.2 Writing JSON Data Using a Generator
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FileWriter writer = new FileWriter("C://Users/Edu/Downloads/contato.txt");
		JsonGenerator gen = Json.createGenerator(writer);
		gen.writeStartObject()
		   .write("firstName", "Duke")
		   .write("lastName", "Java")
		   .write("age", 18)
		   .write("streetAddress", "100 Internet Dr")
		   .write("city", "JavaTown")
		   .write("state", "JA")
		   .write("postalCode", "12345")
		   .writeStartArray("phoneNumbers")
		      .writeStartObject()
		         .write("type", "mobile")
		         .write("number", "(011) 94606-5413")
		      .writeEnd()
		      .writeStartObject()
		         .write("type", "home")
		         .write("number", "(011) 6523-1254")
		      .writeEnd()
		   .writeEnd()
		.writeEnd();
		gen.close();
		
		response.getWriter().println("Json File Gravado com Sucesso!");
	}


}
