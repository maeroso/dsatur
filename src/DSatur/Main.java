package DSatur;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map m = read("grafo10.csv");
        int[] colorsArray = dsatur(m);
    }

    private static int[] dsatur(Map m) {


        return new int[0];
    }

    private static Map read(String csvFile) {
        String row;
        String csvSeparator = ",";
        Map<Integer, LinkedList<Integer>> vertexMap = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            int vertexCount = 0;
            while ((row = br.readLine()) != null) {
                String[] columns = row.split(csvSeparator);
                vertexCount++;
                vertexMap.put(vertexCount, new LinkedList<>());

                for (int i = 0, columnsLength = columns.length; i < columnsLength; i++) {
                    String column = columns[i].trim();
                    if (i == 0) {
                        continue;
                    }
                    int value = Integer.valueOf(column);
                    vertexMap.get(vertexCount).add(value);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return vertexMap;
    }

    public void writeOutput(int[] colorsArray) {
        BufferedWriter bufferedWriter;

        try {
            FileWriter fileWriter = new FileWriter("output.csv");
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.append("Nó,Cor");

            for (int i = 0, colorsArrayLength = colorsArray.length; i < colorsArrayLength; i++) {
                int color = colorsArray[i];
                bufferedWriter.append(String.valueOf(i))
                        .append(",")
                        .append(String.valueOf(color))
                        .append("\n");
            }

            bufferedWriter.flush();
            bufferedWriter.close();

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
        private static void outputCSV(String sFileName) {
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
        }*/
}
