package socialmedia.service_api.test.file;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import socialmedia.service_api.file.FileReader;
import socialmedia.service_api.file.FileReaderImpl;
import socialmedia.service_api.file.FileWriterImpl;

public class FileReaderImplTest {

	private FileWriterImpl fWriter =  new FileWriterImpl();
	private FileReader freader =  new FileReaderImpl();
	
	@Rule
	public TemporaryFolder tempFolder =  new TemporaryFolder();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
    public void throwsErrorWhenTargetFileExists() throws IOException {
        // arrange
        File output = tempFolder.newFile("output.txt");

        thrown.expect(IOException.class);
        thrown.expectMessage("file already exists");

        String expectedContent  = "This is test message! Writing it in file";
        
        // act
        fWriter.writeTo(output.getPath(), expectedContent);
        
        String actualContent = freader.readFromFile(output.getPath());
        System.out.println("Content in File : " + actualContent);
        Assert.assertEquals(expectedContent, actualContent);
        
    }
}
