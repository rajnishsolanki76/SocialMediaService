package socialmedia.service_api.test.file;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import socialmedia.service_api.file.FileWriterImpl;

public class FileWriterImplTest {

	private FileWriterImpl fWriter = new FileWriterImpl();

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void throwsErrorWhenTargetFileExists() throws IOException {
		// arrange
		File output = tempFolder.newFile("output.txt");

		thrown.expect(IOException.class);
		thrown.expectMessage("file already exists");

		System.out.println("Output File Name : " + output.getPath());
		// act
		fWriter.writeTo(output.getPath(), "test");
	}

	@Test
	public void writesContentToFile() throws IOException {
		// arrange
		File output = tempFolder.newFolder("reports").toPath().resolve("output.txt").toFile();

		// act
		fWriter.writeTo(output.getPath(), "test");

		// assert
		/*
		 * Assert.assertThat(output) .hasContent("test") .hasExtension("txt")
		 * .hasParent(resolvePath("reports"));
		 */
	}

	private String resolvePath(String folder) {
		return tempFolder.getRoot().toPath().resolve(folder).toString();
	}

}
