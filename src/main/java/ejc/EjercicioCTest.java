package ejc;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class EjercicioCTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    private void restoreStreams() {
        System.setOut(originalOut);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testNumerosMixtos() {
        setUpStreams();
        provideInput("1\n2\n3\n4\n-1\n");
        ejercicioC.main(new String[]{});
        String output = outContent.toString();
        assertEquals("Se introdujeron 4 números", true, output.contains("se introdujeron 4 numeros"));
        assertEquals("Media de impares 2.0", true, output.contains("la mdedia de los numeros impares es de 2.0"));
        assertEquals("Mayor par 4", true, output.contains("El número par mayor es: 4"));
        restoreStreams();
    }

    @Test
    public void testSoloImpares() {
        setUpStreams();
        provideInput("1\n3\n5\n-1\n");
        ejercicioC.main(new String[]{});
        String output = outContent.toString();
        assertEquals("Se introdujeron 3 números", true, output.contains("se introdujeron 3 numeros"));
        assertEquals("Media de impares 3.0", true, output.contains("la mdedia de los numeros impares es de 3.0"));
        assertEquals("Mayor par 0", true, output.contains("El número par mayor es: 0"));
        restoreStreams();
    }

    @Test
    public void testUnNumeroImpar() {
        setUpStreams();
        provideInput("5\n-1\n");
        ejercicioC.main(new String[]{});
        String output = outContent.toString();
        assertEquals("Se introdujeron 1 número", true, output.contains("se introdujeron 1 numeros"));
        assertEquals("Media de impares 5.0", true, output.contains("la mdedia de los numeros impares es de 5.0"));
        assertEquals("Mayor par 0", true, output.contains("El número par mayor es: 0"));
        restoreStreams();
    }
}