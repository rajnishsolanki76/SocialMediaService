package socialmedia.service_api.file;

import java.io.IOException;

public interface FileReader {

	public String readFromFile(String path) throws IOException;
}
