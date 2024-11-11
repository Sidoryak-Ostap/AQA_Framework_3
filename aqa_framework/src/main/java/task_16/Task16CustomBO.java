package task_16;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task16CustomBO {
    private static final String KEY = "";
    private static final String TOKEN = "";
    private static HttpClient client = HttpClient.newBuilder().build();

    ObjectMapper objectMapper = new ObjectMapper();


    @BeforeTest
    public static void setup() {
        client = HttpClient.newHttpClient();
    }

    @Test
    public OrganizationTemplate createOrganization(String organizationName) throws IOException, InterruptedException {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.trello.com/1/organizations?key=" + KEY + "&token=" + TOKEN + "&displayName=" + organizationName))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            Assert.assertEquals(response.statusCode(), 200, "Invalid status code");

            OrganizationTemplate organization = new OrganizationTemplate();
            organization = objectMapper.readValue(response.body(), OrganizationTemplate.class);
            return organization;


    }

    @Test()
    public BoardTemplate createBoard(String organizationId) throws IOException, InterruptedException{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.trello.com/1/boards?key=" + KEY + "&token=" + TOKEN + "&name=TestBoardAQA" + "&idOrganization=" + organizationId))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            System.out.println(response.body());
            System.out.println("completed");
            Assert.assertEquals(response.statusCode(), 200, "Invalid status code");

            BoardTemplate board = new BoardTemplate();
            board = objectMapper.readValue(response.body(), BoardTemplate.class);
            return board;


    }

    @Test()
    public ListTemplate createList(String boardId) throws IOException, InterruptedException{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.trello.com/1/lists?key=" + KEY + "&token=" + TOKEN + "&name=Todo" + "&idBoard=" + boardId))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Assert.assertEquals(response.statusCode(), 200, "Invalid status code");
            ListTemplate list = new ListTemplate();
            list = objectMapper.readValue(response.body(), ListTemplate.class);
            return list;

    }

    @Test()
    public CardTemplate createCard(String listId) throws IOException, InterruptedException{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.trello.com/1/cards/?key=" + KEY + "&token=" + TOKEN + "&idList=" + listId))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            Assert.assertEquals(response.statusCode(), 200, "Invalid status code");
            CardTemplate card = new CardTemplate();
            card = objectMapper.readValue(response.body(), CardTemplate.class);
            return card;
    }

    @Test()
    public CardTemplate addDueData(String dueData, String cardId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.trello.com/1/cards/" + cardId + "?key=" + KEY + "&token=" + TOKEN))
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString("{\"due\": \"" + dueData + "\"}"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(), 200, "Invalid status code");

        CardTemplate card = objectMapper.readValue(response.body(), CardTemplate.class);
        return card;
    }

    @Test()
    void updateDueData(String cardId){
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

    @Test()
    public CardTemplate removeDueData(String cardId) throws IOException, InterruptedException{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.trello.com/1/cards/" + cardId + "?key=" + KEY + "&token=" + TOKEN))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString("{\"due\": \"null\"}"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Assert.assertEquals(response.statusCode(), 200, "Invalid status code");

            CardTemplate card = objectMapper.readValue(response.body(), CardTemplate.class);
            return card;
    }
}

