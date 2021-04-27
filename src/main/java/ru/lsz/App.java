package ru.lsz;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Bing Wallpaper
 */
public class App {
    static ObjectMapper mapper = new ObjectMapper();
    public static final String URI = "https://bing.biturl.top/";

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet(URI);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            ApiBingWallPaper apiBingWallPaper = mapper.readValue(response.getEntity().getContent(), ApiBingWallPaper.class);

            saveImageToFile(apiBingWallPaper.getUrl());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveImageToFile(String url) {
        String[] pathParse = url.split("=");
        try (InputStream in = new URL(url).openStream()) {
            Files.copy(in, Paths.get(pathParse[pathParse.length - 1]), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}