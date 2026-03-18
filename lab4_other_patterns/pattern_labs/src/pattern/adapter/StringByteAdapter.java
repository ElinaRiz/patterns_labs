package pattern.adapter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StringByteAdapter {
    private OutputStream outputStream;

    public StringByteAdapter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void writeStrings(String[] strings) throws IOException {
        for (String str : strings) {
            outputStream.write(str.getBytes());
            outputStream.write("\n".getBytes());
        }
        outputStream.flush();
    }

    public static String[] readStrings(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null)
            lines.add(line);
        return lines.toArray(new String[0]);
    }
}
