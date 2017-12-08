import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCsv {

        public static void main(String [] args)
        {
            generateCsvFile("test.csv");
        }

        private static void generateCsvFile(String sFileName) {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(sFileName));
                writer.append("\t\t\t");
                writer.append("Tabela 1: Resultados");
                writer.append("\n");

                writer.append("No. Nós |");
                writer.append("No. arestas    |");
                writer.append("\t Grau dos nós \t\t    |");
                writer.append("No. cores |");
                writer.append("Runtime (s) ");
                writer.append('\n');

                writer.append("______________________________________________________________________________________");
                writer.append("\n");

                writer.append("\t\t\t");
                writer.append("| mínimo ");
                writer.append("máximo ");
                writer.append("médio ");
                writer.append("desvio padrão |");
                writer.append("\n");

                writer.append("______________________________________________________________________________________");
                writer.append("\n");

                //generate whatever data you want

                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
