package task_16;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Task16CustomTest {

    @Test
    void compareCreateOrganizationTest() throws IOException, InterruptedException {
        String displayName = "TestName";
        Task16CustomBO task16CustomBO = new Task16CustomBO();
        OrganizationTemplate organizationReceived = task16CustomBO.createOrganization(displayName);

        System.out.println(organizationReceived);
        OrganizationTemplate organizationExpected = new OrganizationTemplate();

        organizationExpected.setDisplayName(displayName);
        organizationExpected.setOffering("trello.free");
        organizationExpected.setIdMemberCreator("654a26a8740d9459cb69f952");

        Assert.assertEquals(organizationReceived, organizationExpected, "Bad response body");
    }

    @Test
    void compareCreateBoardTest() throws IOException, InterruptedException {
        String organizationId = "67322cc18e4a209531afa76f";
        String boardName = "TestBoardAQA";
        Task16CustomBO task16CustomBO = new Task16CustomBO();
        BoardTemplate boardReceived = task16CustomBO.createBoard(organizationId);

        System.out.println(boardReceived);

        BoardTemplate boardExpected = new BoardTemplate();
        boardExpected.setClosed(false);
        boardExpected.setIdOrganization(organizationId);
        boardExpected.setPined(false);
        boardExpected.setName(boardName);

        Assert.assertEquals(boardReceived, boardExpected, "Bad response body");


    }

    @Test
    void compareCreateListTest() throws  IOException, InterruptedException{
        String boardId = "67322d3d23789718748edb8b";
        Task16CustomBO task16CustomBO = new Task16CustomBO();
        ListTemplate listReceived = task16CustomBO.createList(boardId);

        System.out.println("Received list");
        System.out.println(listReceived);

        ListTemplate listExpected = new ListTemplate();
        listExpected.setIdBoard(boardId);
        listExpected.setName("Todo");
        listExpected.setClosed(false);

        Assert.assertEquals(listReceived, listExpected, "Bad response body");


    }

    @Test
    void compareCreateCardTest() throws IOException, InterruptedException{
        String listId = "67322e48e3db98267abe69e8";
        Task16CustomBO task16CustomBO = new Task16CustomBO();
        CardTemplate cardReceived = task16CustomBO.createCard(listId);

        System.out.println("Received card");
        System.out.println(cardReceived);

        CardTemplate cardExpected = new CardTemplate();
        cardExpected.setCheckItems(0);
        cardExpected.setVotes(0);
        cardExpected.setClosed(false);
        cardExpected.setDescription(false);
        cardExpected.setIdList(listId);
        cardExpected.setDue(null);

        Assert.assertEquals(cardReceived, cardExpected, "Bad response body");
    }

    @Test
    void compareUpdateDueData() throws  IOException, InterruptedException{
        String listId = "67322e48e3db98267abe69e8";
        String cardId = "673230ddab30897b608ee9cd";
        String dueData = "2024-10-31T18:30:00Z";
        String expectedDueData = "2024-10-31T18:30:00.000Z";

        Task16CustomBO task16CustomBO = new Task16CustomBO();
        CardTemplate cardReceived = task16CustomBO.addDueData(dueData, cardId);

        System.out.println("Received card");
        System.out.println(cardReceived);

        CardTemplate cardExpected = new CardTemplate();
        cardExpected.setCheckItems(0);
        cardExpected.setVotes(0);
        cardExpected.setClosed(false);
        cardExpected.setDescription(false);
        cardExpected.setIdList(listId);
        cardExpected.setDue(expectedDueData);

        Assert.assertEquals(cardReceived, cardExpected, "Bad response body");
    }

    @Test
    void compareRemoveDueData() throws  IOException, InterruptedException{
        String listId = "67322e48e3db98267abe69e8";
        String cardId = "673230ddab30897b608ee9cd";

        Task16CustomBO task16CustomBO = new Task16CustomBO();
        CardTemplate cardReceived = task16CustomBO.removeDueData(cardId);

        System.out.println("Received card");
        System.out.println(cardReceived);

        CardTemplate cardExpected = new CardTemplate();
        cardExpected.setCheckItems(0);
        cardExpected.setVotes(0);
        cardExpected.setClosed(false);
        cardExpected.setDescription(false);
        cardExpected.setIdList(listId);
        cardExpected.setDue(null);

        Assert.assertEquals(cardReceived, cardExpected, "Bad response body");
    }
}
