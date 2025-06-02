import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiChallengeRunner {

    public static void main(String[] args) {

        Tp1();
        Tp2();
        Tp3();
        Tp4();
        Tp5();
        Tp6();
        Tp7();
        Tp8();
        Tp9();
        Tp10();
        Tp11();
        Tp12();
    }

    public static void Tp1() {
        System.out.println("--- Tp 1 ---");
        String urlString = "https://apichallenges.eviltester.com/sim/entities";

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status: " + statusCode);

            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Corpo da Resposta:\n" + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("----------------------------------------------------\n");
    }

    public static void Tp2() {
        System.out.println("--- Tp 2 ---");
        int[] idsToTest = {1, 5, 8};

        for (int id : idsToTest) {
            String urlString = "https://apichallenges.eviltester.com/sim/entities/" + id;
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(urlString);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int statusCode = connection.getResponseCode();
                System.out.println("ID: " + id + " - Código de Status: " + statusCode);

                if (statusCode >= 200 && statusCode < 300) {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                } else {
                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                }

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("ID: " + id + " - Corpo da Resposta:\n" + response.toString());

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    connection.disconnect();
                }
            }
            System.out.println("---");
        }
        System.out.println("----------------------------------------------------\n");
    }

    public static void Tp3() {
        System.out.println("--- Tp 3 ---");
        String urlString = "https://apichallenges.eviltester.com/sim/entities/13";

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status: " + statusCode);

            if (statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
                System.out.println("Mensagem: Entidade com ID 13 não encontrada (Status 404).");
            }

            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Corpo da Resposta:\n" + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("----------------------------------------------------\n");
    }

    public static void Tp4() {
        System.out.println("--- Tp 4 ---");

        String baseUrl = "https://apichallenges.eviltester.com/sim/entities";
        String categoria = "teste";
        int limite = 5;

        String encodedCategoria = URLEncoder.encode(categoria, StandardCharsets.UTF_8);
        String encodedLimite = URLEncoder.encode(String.valueOf(limite), StandardCharsets.UTF_8);

        String urlString = String.format("%s?categoria=%s&limite=%s", baseUrl, encodedCategoria, encodedLimite);

        System.out.println("URL Final Montada: " + urlString);

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status: " + statusCode);

            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Corpo da Resposta:\n" + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("----------------------------------------------------\n");
    }

    public static void Tp5() {
        System.out.println("--- Tp 5 ---");
        String urlString = "https://apichallenges.eviltester.com/sim/entities";
        String jsonInputString = "{\"name\": \"aluno\"}";

        HttpURLConnection connection = null;
        DataOutputStream outputStream = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(jsonInputString);
            outputStream.flush();

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status: " + statusCode);

            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Corpo da Resposta:\n" + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("----------------------------------------------------\n");
    }

    public static void Tp6() {
        System.out.println("--- Tp 6 ---");
        String urlString = "https://apichallenges.eviltester.com/sim/entities/11";

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status: " + statusCode);

            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Corpo da Resposta:\n" + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("----------------------------------------------------\n");
    }

    public static void Tp7() {
        System.out.println("--- Tp 7 ---");
        int entityIdToUpdate = 10;
        String urlUpdate = "https://apichallenges.eviltester.com/sim/entities/" + entityIdToUpdate;
        String jsonUpdateString = "{\"name\": \"atualizado\"}";

        HttpURLConnection connection = null;
        DataOutputStream outputStream = null;
        BufferedReader reader = null;

        System.out.println("Tentando atualizar a entidade " + entityIdToUpdate + " com POST e JSON: " + jsonUpdateString);

        try {
            URL url = new URL(urlUpdate);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(jsonUpdateString);
            outputStream.flush();

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status da Atualização (POST): " + statusCode);

            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Corpo da Resposta da Atualização (POST):\n" + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        System.out.println("\nVerificando a entidade " + entityIdToUpdate + " após a atualização (GET)...");
        String urlVerify = "https://apichallenges.eviltester.com/sim/entities/" + entityIdToUpdate;
        try {
            URL url = new URL(urlVerify);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status da Verificação (GET): " + statusCode);

            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Corpo da Resposta da Verificação (GET):\n" + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("----------------------------------------------------\n");
    }

    public static void Tp8() {
        System.out.println("--- Tp 8 ---");
        int entityIdToUpdate = 10;
        String urlPut = "https://apichallenges.eviltester.com/sim/entities/" + entityIdToUpdate;
        String jsonUpdateString = "{\"name\": \"atualizado_com_put\"}";

        HttpURLConnection connection = null;
        DataOutputStream outputStream = null;
        BufferedReader reader = null;

        System.out.println("Tentando atualizar a entidade " + entityIdToUpdate + " com PUT e JSON: " + jsonUpdateString);

        try {
            URL url = new URL(urlPut);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(jsonUpdateString);
            outputStream.flush();

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status da Atualização (PUT): " + statusCode);

            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Corpo da Resposta da Atualização (PUT):\n" + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        System.out.println("\nVerificando a entidade " + entityIdToUpdate + " após a atualização (GET)...");
        String urlVerify = "https://apichallenges.eviltester.com/sim/entities/" + entityIdToUpdate;
        try {
            URL url = new URL(urlVerify);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status da Verificação (GET): " + statusCode);

            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Corpo da Resposta da Verificação (GET):\n" + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("----------------------------------------------------\n");
    }

    public static void Tp9() {
        System.out.println("--- Tp 9 ---");
        int entityIdToDelete = 9;
        String urlDelete = "https://apichallenges.eviltester.com/sim/entities/" + entityIdToDelete;

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        System.out.println("Tentando deletar a entidade com ID: " + entityIdToDelete);

        try {
            URL url = new URL(urlDelete);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("DELETE");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status do DELETE: " + statusCode);

            if (statusCode >= 200 && statusCode < 300 || statusCode == HttpURLConnection.HTTP_NO_CONTENT) {
                System.out.println("DELETE da entidade " + entityIdToDelete + " bem-sucedido.");
            } else {
                System.out.println("Erro ao deletar entidade " + entityIdToDelete + ".");
            }

            try {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                if (response.length() > 0) {
                    System.out.println("Corpo da Resposta do DELETE:\n" + response.toString());
                } else {
                    System.out.println("Corpo da Resposta do DELETE: Vazio (esperado para 204 No Content).");
                }
            } catch (java.io.IOException e) {
                System.out.println("Não foi possível ler o corpo da resposta do DELETE (pode ser intencional para 204 No Content).");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        System.out.println("\nVerificando a entidade " + entityIdToDelete + " após o DELETE (GET)...");
        String urlVerify = "https://apichallenges.eviltester.com/sim/entities/" + entityIdToDelete;
        try {
            URL url = new URL(urlVerify);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status da Verificação (GET): " + statusCode);

            if (statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
                System.out.println("Mensagem: Entidade com ID " + entityIdToDelete + " não encontrada (Status 404). Confirmação do DELETE.");
            } else {
                System.out.println("Aviso: Entidade " + entityIdToDelete + " ainda encontrada ou outro status. Status: " + statusCode);
            }

            try {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                if (response.length() > 0) {
                    System.out.println("Corpo da Resposta da Verificação (GET):\n" + response.toString());
                }
            } catch (Exception e) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("----------------------------------------------------\n");
    }

    public static void Tp10() {
        System.out.println("--- Tp 10 ---");
        int entityIdToDelete = 2;
        String urlDelete = "https://apichallenges.eviltester.com/sim/entities/" + entityIdToDelete;

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        System.out.println("Tentando deletar a entidade com ID (inválido para DELETE): " + entityIdToDelete);

        try {
            URL url = new URL(urlDelete);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("DELETE");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status do DELETE inválido: " + statusCode);

            if (statusCode == HttpURLConnection.HTTP_FORBIDDEN) {
                System.out.println("Mensagem: Requisição DELETE para o ID " + entityIdToDelete + " foi proibida (Status 403 Forbidden).");
            } else if (statusCode == HttpURLConnection.HTTP_BAD_METHOD) {
                System.out.println("Mensagem: Método DELETE não permitido para o ID " + entityIdToDelete + " (Status 405 Method Not Allowed).");
            } else {
                System.out.println("Aviso: Status inesperado para DELETE inválido. Status: " + statusCode);
            }

            if (statusCode >= 400) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }


            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Corpo da Resposta do DELETE inválido:\n" + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("----------------------------------------------------\n");
    }

    public static void Tp11() {
        System.out.println("--- Tp 11 ---");
        String urlString = "https://apichallenges.eviltester.com/sim/entities";

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        System.out.println("Enviando requisição OPTIONS para: " + urlString);

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("OPTIONS");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status do OPTIONS: " + statusCode);

            String allowHeader = connection.getHeaderField("Allow");
            if (allowHeader != null && !allowHeader.isEmpty()) {
                System.out.println("Métodos HTTP permitidos (Cabeçalho 'Allow'): " + allowHeader);
            } else {
                System.out.println("Cabeçalho 'Allow' não encontrado ou vazio.");
            }

            try {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                if (response.length() > 0) {
                    System.out.println("Corpo da Resposta do OPTIONS (se houver):\n" + response.toString());
                } else {
                    System.out.println("Corpo da Resposta do OPTIONS: Vazio.");
                }
            } catch (java.io.IOException e) {
                System.out.println("Não foi possível ler o corpo da resposta do OPTIONS (pode ser intencional).");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("----------------------------------------------------\n");
    }

    public static void Tp12() {
        System.out.println("--- Tp 12: Experimentos com a Simple API ---");

        String itemsBaseUrl = "https://apichallenges.eviltester.com/simpleapi/items";
        String randomIsbnUrl = "https://apichallenges.eviltester.com/simpleapi/randomisbn";
        String generatedIsbn = null;

        HttpURLConnection connection = null;
        BufferedReader reader = null;
        DataOutputStream outputStream = null;

        System.out.println("\n--- 12.1: GET todos os itens ---");
        try {
            URL url = new URL(itemsBaseUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status: " + statusCode);

            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Corpo da Resposta:\n" + response.toString());

        } catch (Exception e) {
            System.err.println("Erro no GET de todos os itens: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        System.out.println("\n--- 12.2: Gerar ISBN aleatório ---");
        try {
            URL url = new URL(randomIsbnUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            System.out.println("Código de Status: " + statusCode);

            if (statusCode >= 200 && statusCode < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Corpo da Resposta:\n" + response.toString());

            Pattern pattern = Pattern.compile("\"isbn\":\\s*\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(response.toString());
            if (matcher.find()) {
                generatedIsbn = matcher.group(1);
                System.out.println("ISBN Gerado: " + generatedIsbn);
            } else {
                System.out.println("Não foi possível extrair o ISBN gerado da resposta.");
            }

        } catch (Exception e) {
            System.err.println("Erro ao gerar ISBN: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        if (generatedIsbn != null) {
            System.out.println("\n--- 12.3: Criar item com POST ---");
            String jsonCreate = String.format("{\"isbn\": \"%s\", \"title\": \"Livro de Teste\", \"author\": \"Aluno\"}", generatedIsbn);
            System.out.println("Corpo da Requisição:\n" + jsonCreate);

            try {
                URL url = new URL(itemsBaseUrl);
                connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);

                outputStream = new DataOutputStream(connection.getOutputStream());
                outputStream.writeBytes(jsonCreate);
                outputStream.flush();

                int statusCode = connection.getResponseCode();
                System.out.println("Código de Status: " + statusCode);

                if (statusCode >= 200 && statusCode < 300) {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                } else {
                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                }

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("Corpo da Resposta:\n" + response.toString());

            } catch (Exception e) {
                System.err.println("Erro ao criar item com POST: " + e.getMessage());
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    connection.disconnect();
                }
            }
        } else {
            System.out.println("Não foi possível criar item com POST, ISBN não gerado.");
        }

        if (generatedIsbn != null) {
            System.out.println("\n--- 12.4: Atualizar item com PUT ---");
            String jsonUpdate = String.format("{\"isbn\": \"%s\", \"title\": \"Livro de Teste Atualizado\", \"author\": \"Aluno Atualizado\"}", generatedIsbn);
            System.out.println("Corpo da Requisição:\n" + jsonUpdate);

            try {
                URL url = new URL(itemsBaseUrl);
                connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("PUT");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                outputStream = new DataOutputStream(connection.getOutputStream());
                outputStream.writeBytes(jsonUpdate);
                outputStream.flush();

                int statusCode = connection.getResponseCode();
                System.out.println("Código de Status: " + statusCode);

                if (statusCode >= 200 && statusCode < 300) {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                } else {
                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                }

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("Corpo da Resposta:\n" + response.toString());

            } catch (Exception e) {
                System.err.println("Erro ao atualizar item com PUT: " + e.getMessage());
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    connection.disconnect();
                }
            }

            System.out.println("\n--- 12.4.1: Verificando o item após PUT ---");
            String getItemUrl = itemsBaseUrl + "/" + generatedIsbn;
            try {
                URL url = new URL(getItemUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int statusCode = connection.getResponseCode();
                System.out.println("Código de Status: " + statusCode);

                if (statusCode >= 200 && statusCode < 300) {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                } else {
                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                }

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("Corpo da Resposta:\n" + response.toString());

            } catch (Exception e) {
                System.err.println("Erro ao verificar item após PUT: " + e.getMessage());
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    connection.disconnect();
                }
            }

        } else {
            System.out.println("Não foi possível atualizar item com PUT, ISBN não gerado.");
        }

        if (generatedIsbn != null) {
            System.out.println("\n--- 12.5: Remover item com DELETE ---");
            String deleteItemUrl = itemsBaseUrl + "/" + generatedIsbn;
            System.out.println("Requisição DELETE para: " + deleteItemUrl);

            try {
                URL url = new URL(deleteItemUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("DELETE");

                int statusCode = connection.getResponseCode();
                System.out.println("Código de Status: " + statusCode);

                if (statusCode >= 200 && statusCode < 300 || statusCode == HttpURLConnection.HTTP_NO_CONTENT) {
                    System.out.println("DELETE bem-sucedido.");
                } else {
                    System.out.println("Erro no DELETE.");
                }

                try {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    if (response.length() > 0) {
                        System.out.println("Corpo da Resposta:\n" + response.toString());
                    } else {
                        System.out.println("Corpo da Resposta: Vazio (esperado para 204 No Content).");
                    }
                } catch (java.io.IOException e) {
                    System.out.println("Não foi possível ler o corpo da resposta do DELETE (pode ser intencional para 204 No Content).");
                }

            } catch (Exception e) {
                System.err.println("Erro na requisição DELETE para " + deleteItemUrl + ": " + e.getMessage());
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    connection.disconnect();
                }
            }

            System.out.println("\n--- 12.5.1: Verificando o item após DELETE ---");
            String getItemAfterDeleteUrl = itemsBaseUrl + "/" + generatedIsbn;
            try {
                URL url = new URL(getItemAfterDeleteUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int statusCode = connection.getResponseCode();
                System.out.println("Código de Status: " + statusCode);

                if (statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
                    System.out.println("Mensagem: Item com ISBN " + generatedIsbn + " não encontrado (Status 404). Confirmação do DELETE.");
                } else {
                    System.out.println("Aviso: Item " + generatedIsbn + " ainda encontrado ou outro status. Status: " + statusCode);
                }

                try {
                    reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    if (response.length() > 0) {
                        System.out.println("Corpo da Resposta:\n" + response.toString());
                    }
                } catch (Exception e) {
                }

            } catch (Exception e) {
                System.err.println("Erro ao verificar item após DELETE: " + e.getMessage());
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    connection.disconnect();
                }
            }

        } else {
            System.out.println("Não foi possível remover item com DELETE, ISBN não gerado.");
        }

        System.out.println("\n----------------------------------------------------\n");
    }
}