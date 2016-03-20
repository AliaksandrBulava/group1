/**
 * 
 */
package jmp.yury.kiryla.web_services_task1.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.util.Random;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.json.JSONJAXBContext;
import com.sun.jersey.api.json.JSONMarshaller;
import com.sun.jersey.api.json.JSONUnmarshaller;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.MultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import jmp.yury.kiryla.web_services_task1.beans.User;

/**
 * For REST Service Testing
 * 
 * @author Yury
 *
 */
public class App {

    /**
     * @param args
     * @throws JAXBException
     * @throws IOException
     */
    public static void main(String[] args) throws JAXBException, IOException {

	String baseURL = "http://localhost:8080/rest_service/users";
	Client client = Client.create();
	client.setFollowRedirects(true);
	WebResource webResource;
	Random random = new Random();

	// Test Create User
	webResource = client.resource(baseURL + "/new");
	User user = new User();
	user.setFirstName("Yury");
	user.setLastName("Kiryla");
	user.setLogin("yury" + random.nextInt(10000));
	user.setEmail("yury@test.com");
	JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
	Marshaller marshaller = jaxbContext.createMarshaller();
	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	StringWriter writer = new StringWriter();
	marshaller.marshal(user, writer);
	String response = webResource.type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML)
		.post(String.class, writer.toString());
	System.out.println("User create response:");
	System.out.println(response);
	user = (User) jaxbContext.createUnmarshaller().unmarshal(new StringReader(response));
	System.out.println();

	// Test Get User
	webResource = client.resource(baseURL + "/" + user.getId());
	response = webResource.accept(MediaType.APPLICATION_JSON).get(String.class);
	System.out.println("Get User response:");
	System.out.println(response);
	System.out.println();

	// Test User Update
	webResource = client.resource(baseURL + "/update");
	jaxbContext = JSONJAXBContext.newInstance(User.class);
	marshaller = jaxbContext.createMarshaller();
	JSONMarshaller jsonMarshaller = JSONJAXBContext.getJSONMarshaller(marshaller, jaxbContext);
	jsonMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	writer = new StringWriter();
	user.setEmail("yury_new@test.com");
	jsonMarshaller.marshallToJSON(user, writer);
	response = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).put(String.class,
		writer.toString());
	System.out.println("User update response:");
	System.out.println(response);
	Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	JSONUnmarshaller jsonUnmarshaller = JSONJAXBContext.getJSONUnmarshaller(unmarshaller, jaxbContext);
	user = jsonUnmarshaller.unmarshalFromJSON(new StringReader(response), User.class);
	System.out.println();

	// Test upload logo
	webResource = client.resource(baseURL + "/logo");
	File file = new File(App.class.getClassLoader().getResource("logo.jpg").getFile());
	FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
	formDataMultiPart.bodyPart(new FileDataBodyPart("file", file, MediaType.APPLICATION_OCTET_STREAM_TYPE));
	formDataMultiPart.field("id", String.valueOf(user.getId()));
	response = webResource.type(MediaType.MULTIPART_FORM_DATA).post(String.class, formDataMultiPart);
	System.out.println("Upload logo response:");
	System.out.println(response);
	System.out.println();

	// Test Download logo
	ClientResponse clientResponse = webResource.queryParam("id", String.valueOf(user.getId()))
		.get(ClientResponse.class);
	System.out.println("Download logo response:");
	System.out.println(clientResponse);
	System.out.println();
	try (InputStream is = clientResponse.getEntityInputStream();
		FileOutputStream fos = new FileOutputStream(new File(
			clientResponse.getHeaders().get("content-disposition").get(0).substring(23)))) {
	    fos.write(IOUtils.toByteArray(is));
	    fos.flush();
	    fos.close();
	}

	// Test User delete
	webResource = client.resource(baseURL + "/delete");
	response = webResource.queryParam("id", String.valueOf(user.getId())).accept(MediaType.TEXT_PLAIN)
		.delete(String.class);
	System.out.println("Delete User response:");
	System.out.println(response);
	System.out.println();

	// Try to get deleted user
	webResource = client.resource(baseURL + "/" + user.getId());
	clientResponse = webResource.get(ClientResponse.class);
	System.out.println("Get User after delete response:");
	System.out.println(clientResponse);
    }

}
