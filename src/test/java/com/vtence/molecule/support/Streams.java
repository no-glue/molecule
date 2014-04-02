package com.vtence.molecule.support;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class Streams {

    public static String toString(InputStream in) throws IOException {
        return toString(in, Charset.defaultCharset());
    }

    public static String toString(InputStream in, Charset charset) throws IOException {
        return new String(toBytes(in), charset);
    }

    public static byte[] toBytes(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        copy(in, out);
        return out.toByteArray();
    }

    public static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8 * 1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

    private Streams() {
    }
}