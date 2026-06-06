package tests;

import models.negative.ErrorRs;
import models.positive.ProjectCreateRq;
import models.positive.ProjectCreateRs;
import models.positive.ProjectDeleteRs;
import models.positive.ProjectGetRs;
import org.junit.jupiter.api.Test;

import static adapters.ProjectAdapter.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectAPITest {

    @Test
    public void checkCRUD() {
        ProjectCreateRq requestCreate = ProjectCreateRq.testQA();
        //CREATE
        ProjectCreateRs responseCreate = createProject(requestCreate);
        assertTrue(responseCreate.status());
        assertEquals(requestCreate.code(), responseCreate.result().code());
        //GET
        ProjectGetRs responseGet = getProject(requestCreate.code());
        assertTrue(responseGet.status());
        assertEquals(requestCreate.code(), responseGet.result().code());
        //DELETE
        ProjectDeleteRs responseDelete = deleteProject(requestCreate.code());
        assertTrue(responseDelete.status());
        //GET_AFTER_DELETE
        ErrorRs responseGetAfterDeleteError = getProjectWithError(requestCreate.code());
        assertFalse(responseGetAfterDeleteError.status());
        assertEquals("Project not found", responseGetAfterDeleteError.errorMessage());
    }
}