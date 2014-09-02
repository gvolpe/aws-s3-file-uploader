package aws;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class S3FileHelper {

	public static File convert(InputStream is) {
		try {
			InputStream reader = new BufferedInputStream(is);
			File file = new File("tempFile");
			OutputStream writer = new BufferedOutputStream(new FileOutputStream(file));

			int read = -1;

			while ((read = reader.read()) != -1) {
				writer.write(read);
			}

			writer.flush();
			writer.close();
			reader.close();

			return file;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
