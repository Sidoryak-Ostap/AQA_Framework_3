package task_16;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Task16Test {

    private static final String KEY = "";
    private static final String TOKEN = "";

    String organizationId;
    String boardId;
    String listId;
    String cardId;


    @Test()
    void createOrganization(){
        Response createOrgResponse = given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .queryParam("displayName", "TestOrganization")
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .log()
                .all()
                .when()
                .post("https://api.trello.com/1/organizations")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().response();

        organizationId = createOrgResponse.jsonPath().getString("id");

    }

    @Test(dependsOnMethods = {"createOrganization"})
    void createBoard(){
        Response createBoardResponse = given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .queryParam("name", "TestingBoard")
                .queryParam("idOrganization", organizationId)
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .log()
                .all()
                .when()
                .post("https://api.trello.com/1/boards/")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().response();

        boardId = createBoardResponse.jsonPath().getString("id");
    }

    @Test(dependsOnMethods = {"createBoard"})
    void createList(){
        Response createListResponse = given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .queryParam("name", "Todo")
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .queryParam("idBoard", boardId)
                .log()
                .all()
                .when()
                .post("https://api.trello.com/1/lists")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().response();

        listId = createListResponse.jsonPath().getString("id");
    }

    @Test(dependsOnMethods = {"createList"})
    void createCard(){
        Response createCardResponse = given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .queryParam("idList", listId)
                .log()
                .all()
                .when()
                .post("https://api.trello.com/1/cards")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().response();

        cardId = createCardResponse.jsonPath().getString("id");

    }

    @Test(dependsOnMethods = {"createCard"})
    void addDueDataOnTheCard(){
        Response addDueDataResponse = given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .pathParam("idCard", cardId)
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .body("{\"due\": \"2024-10-31T18:30:00Z\"}")
                .log()
                .all()
                .when()
                .put("https://api.trello.com/1/cards/{idCard}")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().response();

        String dueData = addDueDataResponse.jsonPath().getString("badges.due");
        Assert.assertNotNull(dueData);
    }

    @Test(dependsOnMethods = {"addDueDataOnTheCard"})
    void updateDueDataOnTheCard(){
        Response updateDueDataResponse = given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .pathParam("idCard", cardId)
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .body("{\"due\": \"2024-11-05T14:20:00Z\"}")
                .log()
                .all()
                .when()
                .put("https://api.trello.com/1/cards/{idCard}")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().response();

        String updatedDueData = updateDueDataResponse.jsonPath().getString("badges.due");
        Assert.assertEquals(updatedDueData,"2024-11-05T14:20:00.000Z" );
    }

    @Test(dependsOnMethods = "updateDueDataOnTheCard")
    void removeDueDataOnTheCard(){
        Response deleteDueDataResponse = given()
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .pathParam("idCard", cardId)
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .body("{\"due\": \"\"}")
                .log()
                .all()
                .when()
                .put("https://api.trello.com/1/cards/{idCard}")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract().response();

        String updatedDueData = deleteDueDataResponse.jsonPath().getString("badges.due");
        Assert.assertNull(updatedDueData);
    }

}
