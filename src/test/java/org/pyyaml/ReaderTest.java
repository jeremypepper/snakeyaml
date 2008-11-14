package org.pyyaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.yaml.snakeyaml.reader.Reader;
import org.yaml.snakeyaml.reader.ReaderException;

/**
 * @see imported from PyYAML
 */
public class ReaderTest extends PyImportTest {

    public void testReaderUnicodeErrors() throws IOException {
        File[] inputs = getStreamsByExtension(".stream-error");
        for (int i = 0; i < inputs.length; i++) {
            Reader stream = new Reader(new FileInputStream(inputs[i]));
            try {
                while (stream.peek() != '\u0000') {
                    stream.forward();
                }
                fail("Invalid stream must not be accepted: " + inputs[i].getAbsolutePath()
                        + "; encoding=" + stream.getEncoding());
            } catch (ReaderException e) {
                System.out.println(e.toString());
                assertTrue(true);
            }
        }
    }

}
