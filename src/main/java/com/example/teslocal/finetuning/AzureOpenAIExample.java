package com.example.teslocal.finetuning;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AzureOpenAIExample {
    public static void main(String[] args) {
        // Provide the key for your Azure OpenAI resource.
        // Remember to remove your key from your code when you're done.
        String api_key = "<your-resource-key>";

        // Provide the endpoint for your Azure OpenAI resource.
        // Example: https://<your-resource-name>.openai.azure.com/
        String api_base = "<your-resource-endpoint>";
        String api_type = "azure";

        // Provide the API version.
        // Note that the API version might change in the future.
        String api_version = "2023-05-15";

        String training_file_name = "training.jsonl";
        String validation_file_name = "validation.jsonl";

        List<String> sampleData = new ArrayList<>();
        sampleData.add("{\"prompt\": \"When I go to the store, I want an\", \"completion\": \"apple\"}");
        sampleData.add("{\"prompt\": \"When I go to work, I want a\", \"completion\": \"coffee\"}");
        sampleData.add("{\"prompt\": \"When I go home, I want a\", \"completion\": \"soda\"}");

        // Generate the training dataset file.
        System.out.println("Generating the training file: " + training_file_name);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(training_file_name))) {
            for (String entry : sampleData) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Copy the validation dataset file from the training dataset file.
        // Typically, your training data and validation data should be mutually exclusive.
        // For the purposes of this example, you use the same data.
        System.out.println("Copying the training file to the validation file");
        try {
            Files.copy(Paths.get(training_file_name), Paths.get(validation_file_name));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        // Upload the training and validation dataset files to Azure OpenAI with the REST API.
//        String uploadUrl = api_base + "openai/files?api-version=" + api_version;
//        String uploadHeaders = "api-key: " + api_key;
//        String uploadData = "purpose=fine-tune";
//
//        // Upload the training file
//        String training_id = uploadFile(uploadUrl, uploadHeaders, uploadData, training_file_name);
//        System.out.println("Training file ID: " + training_id);
//
//        // Upload the validation file
//        String validation_id = uploadFile(uploadUrl, uploadHeaders, uploadData, validation_file_name);
//        System.out.println("Validation file ID: " + validation_id);
    }

    private static String uploadFile(String uploadUrl, String uploadHeaders, String uploadData, String fileName) {
        try {
            URL url = new URL(uploadUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            connection.setRequestProperty("Content-Length", String.valueOf(new File(fileName).length()));
            connection.setRequestProperty("api-key", uploadHeaders);

            connection.setDoOutput(true);
            OutputStream os = connection.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.print(uploadData);
            writer.flush();
            writer.close();
            os.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = in.readLine();
                in.close();
                return response;
            } else {
                System.err.println("Error uploading file: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
    CloseableHttpClient httpClient = HttpClients.custom()
            .setSSLContext(SSLContexts.custom()
                    .loadTrustMaterial(new TrustStrategy() {
                        @Override
                        public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                            // Trust all certificates
                            return true;
                        }
                    })
                    .build())
            .build();
    HttpPost httpPost = new HttpPost("https://example.com/upload");
    MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create()
            .addTextBody("field1", "value1") // Add form fields
            .addTextBody("field2", "value2")
            .addBinaryBody("fileField", new File("/path/to/file.jpg")); // Add file upload
    MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create()
            .addTextBody("field1", "value1") // Add form fields
            .addTextBody("field2", "value2")
            .addBinaryBody("fileField", new File("/path/to/file.jpg")); // Add file upload
try {
        ClassicHttpResponse response = httpClient.execute(httpPost);

        // Handle the response here
        } catch (IOException | HttpResponseException | ParseException e) {
        e.printStackTrace();
        } finally {
        httpPost.releaseConnection();
        httpClient.close(CloseMode.GRACEFUL);
        }