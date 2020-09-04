package socialmedia.service_api.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReaderImpl implements FileReader{

	@Override
	public String readFromFile(String path) throws IOException {
		
		File f = new File(path);
		BufferedReader buffReader = new BufferedReader(new java.io.FileReader(f));
		
		String str =  null;
		while((str = buffReader.readLine()) !=null ) {
			
		}
		System.out.println(str);
		buffReader.close();
		return str;
	}
	
	

}
