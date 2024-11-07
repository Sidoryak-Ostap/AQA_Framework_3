package task_16;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task16CustomTest {


    private static final String KEY = "";
    private static final String TOKEN = "";
    private static HttpClient client;

    String organizationId;
    String boardId;
    String listId;
    String cardId;

    @BeforeTest
    public static void setup() {
        client = HttpClient.newHttpClient();
    }

    @Test
    void createOrganization(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.trello.com/1/organizations?key=" + KEY + "&token=" + TOKEN + "&displayName=TestOrganizationName"))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonResponse = new JSONObject(response.body());
            organizationId = jsonResponse.getString("id");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"createOrganization"})
    void createBoard(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.trello.com/1/boards?key=" + KEY + "&token=" + TOKEN + "&name=TestBoardAQA" + "&idOrganization=" + organizationId))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonResponse = new JSONObject(response.body());
            boardId = jsonResponse.getString("id");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"createBoard"})
    void createList(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.trello.com/1/lists?key=" + KEY + "&token=" + TOKEN + "&name=Todo" + "&idBoard=" + boardId))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonResponse = new JSONObject(response.body());
            listId = jsonResponse.getString("id");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "createList")
    void createCard(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.trello.com/1/cards/?key=" + KEY + "&token=" + TOKEN + "&idList=" + listId))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonResponse = new JSONObject(response.body());
            cardId = jsonResponse.getString("id");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"createCard"})
    void addDueData(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.trello.com/1/cards/" + cardId + "?key=" + KEY + "&token=" + TOKEN))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString("{\"due\": \"2024-10-31T18:30:00Z\"}"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());

            Assert.assertNotNull(jsonResponse.getString("badges.due"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"addDueData"})
    void updateDueData(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.trello.com/1/cards/" + cardId + "?key=" + KEY + "&token=" + TOKEN))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString("{\"due\": \"2024-11-05T14:20:00Z\"}"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());

            Assert.assertEquals(jsonResponse.getString("badges.due"), "2024-11-05T14:20:00.000Z");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"updateDueData"})
    void removeDueData(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.trello.com/1/cards/" + cardId + "?key=" + KEY + "&token=" + TOKEN))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString("{\"due\": \"\"}"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());

            Assert.assertNull(jsonResponse.getString("badges.due"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
