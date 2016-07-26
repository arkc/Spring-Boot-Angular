package com.arkc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello
{
    @RequestMapping(value = "/getPdf", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<byte[]> hello()
    {
	FileInputStream fileStream;
	File file = new File("D:\\Work\\java\\bootProject2\\src\\main\\java\\com\\arkc\\123.pdf");

	try
	{
	    fileStream = new FileInputStream(file);
	    byte contents[] = new byte[(int) file.length()];
	    fileStream.read(contents);

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
	    String filename = "123.pdf";
	    headers.setContentDispositionFormData(filename, filename);
	    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
	    return response;
	}
	catch (FileNotFoundException e)
	{
	    System.err.println(e);
	}
	catch (IOException e)
	{
	    System.err.println(e);
	}
	return null;

	// return "/123.pdf";
    }
}
