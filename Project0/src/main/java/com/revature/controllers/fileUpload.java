package com.revature.controllers;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;




public class FileUpload {


	
	public static String postImg() throws Exception {


	      //Creating CloseableHttpClient object
	      CloseableHttpClient httpclient = HttpClients.createDefault();
	 
	      //Creating a file object
	      File file = new File(fileChooser());
	      FileBody fb = new FileBody(file);

	      //Creating the FileBody object
	      FileBody filebody = new FileBody(file, ContentType.DEFAULT_BINARY);

	      //Creating the MultipartEntityBuilder
	      MultipartEntityBuilder entitybuilder = MultipartEntityBuilder.create();

	      //Setting the mode
	      entitybuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

	      //Adding text
	      entitybuilder.addTextBody("sample_text", "This is the text part of our file");

	      
	      
	      
	      entitybuilder.addPart("file", fb);
	      //Building a single entity using the parts
	      HttpEntity mutiPartHttpEntity = entitybuilder.build();

	      //Building the RequestBuilder request object
	      RequestBuilder reqbuilder = RequestBuilder.post("https://filebeam.io/saveItem");

	      //Set the entity object to the RequestBuilder
	      reqbuilder.setEntity(mutiPartHttpEntity);

	      //Building the request
	      HttpUriRequest multipartRequest = reqbuilder.build();

	      //Executing the request
	      HttpResponse httpresponse = httpclient.execute(multipartRequest);

	      //Printing the status and the contents of the response
	      return (EntityUtils.toString(httpresponse.getEntity()));
     
	
	}
	
	public static String fileChooser() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);  
		
		//int returnValue = jfc.showOpenDialog(null);
		int returnValue = jfc.showOpenDialog(dialog);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			return (selectedFile.getAbsolutePath());
		}
		return "";
	}

}
