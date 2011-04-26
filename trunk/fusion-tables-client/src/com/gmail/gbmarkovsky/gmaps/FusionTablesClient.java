package com.gmail.gbmarkovsky.gmaps;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import com.google.gdata.client.ClientLoginAccountType;
import com.google.gdata.client.GoogleService;
import com.google.gdata.client.Service.GDataRequest;
import com.google.gdata.client.Service.GDataRequest.RequestType;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.ServiceException;

public class FusionTablesClient {
	
	/** 
	 * URL сервиса Fusion Table.
	 */
	private static final String SERVICE_URL =
		"https://www.google.com/fusiontables/api/query";
	
	/**
	 * Шаблон для чтения CSV ответов сервиса.
	 */
	private static final Pattern CSV_VALUE_PATTERN =
		Pattern.compile("([^,\\r\\n\"]*|\"(([^\"]*\"\")*[^\"]*)\")(,|\\r?\\n)");

	/**
	 * Гугл-сервис.
	 */
	private GoogleService service;
	
	public FusionTablesClient(String email, String password)	throws AuthenticationException {
		service = new GoogleService("fusiontables", "fusiontables.ApiExample");
		service.setUserCredentials(email, password, ClientLoginAccountType.GOOGLE);
	}

	public void createQuery(String query) throws IOException, ServiceException {
		URL url = null;
		try {
			url = new URL(SERVICE_URL);
		} catch (MalformedURLException e1) {
			throw new RuntimeException();
		}
		
		GDataRequest request = service.getRequestFactory().getRequest(
					RequestType.INSERT, url,
					new ContentType("application/x-www-form-urlencoded"));
		
		OutputStreamWriter writer = new OutputStreamWriter(request.getRequestStream());

		writer.append("sql=" + URLEncoder.encode(query, "UTF-8"));

		writer.flush();
		
		request.execute();
		
		Scanner scanner = new Scanner(request.getResponseStream(),"UTF-8");
		
		while (scanner.hasNextLine()) {
			scanner.findWithinHorizon(CSV_VALUE_PATTERN, 0);
			MatchResult match = scanner.match();
			String quotedString = match.group(2);
			String decoded = quotedString == null ? match.group(1)
					: quotedString.replaceAll("\"\"", "\"");
			System.out.print("|" + decoded);
			if (!match.group(4).equals(",")) {
				System.out.println("|");
			}
		}
	}
	
	  public static void main(String[] args) {
		  FusionTablesClient tablesTest = null;
		  try {
			  tablesTest = new FusionTablesClient("gbmarkovsky@gmail.com", "vtnfkkjltntrnjh13");
		  } catch (AuthenticationException e) {
			  System.out.println("Ошибка при подключении");
			  e.printStackTrace();
		  }
		  try {
			//tablesTest.createQuery("CREATE TABLE 'my_ski_trace2' (description:STRING, name:STRING, geometry:LOCATION)");
			tablesTest.createQuery("INSERT INTO 715202 (description, name, geometry) VALUES ('<div dir=\"ltr\">Это точка старта. Время старта 23:02:36</div>','Start', '<Point>\n<coordinates>30.93818666666667,59.85067666666667,0.0 </coordinates>\n</Point>')");
			tablesTest.createQuery("INSERT INTO 715202 (description, name, geometry) VALUES ('<div dir=\"ltr\">Это точка финиша. Время финиша 23:03:10</div>','Finish', '<Point>\n<coordinates>30.937970000000004,59.850806666666664,0.0 </coordinates>\n</Point>')");
		  } catch (IOException e) {
			System.out.println("Ошибка соединения");
			e.printStackTrace();
		} catch (ServiceException e) {
			System.out.println("Ошибка сервиса");
			e.printStackTrace();
		}
	  }
}
