package adapters;

import models.negative.ErrorRs;
import models.positive.ProjectCreateRq;
import models.positive.ProjectCreateRs;
import models.positive.ProjectDeleteRs;
import models.positive.ProjectGetRs;

import static io.restassured.RestAssured.given;

public class ProjectAdapter extends BaseAdapter {

    public static ProjectCreateRs createProject(ProjectCreateRq rq) {
        return given()
                .spec(spec)
                .body(rq)
                .when()
                .post("/project")
                .then()
                .spec(ok200)
                .extract()
                .as(ProjectCreateRs.class);
    }

    public static ProjectDeleteRs deleteProject(String code) {
        return given()
                .spec(spec)
                .pathParam("code", code)
                .when()
                .delete("/project/{code}")
                .then()
                .spec(ok200)
                .extract()
                .as(ProjectDeleteRs.class);
    }

    public static ProjectGetRs getProject(String code) {
        return given()
                .spec(spec)
                .pathParam("code", code)
                .when()
                .get("/project/{code}")
                .then()
                .spec(ok200)
                .extract()
                .as(ProjectGetRs.class);
    }

    public static ErrorRs getProjectWithError(String code) {
        return given()
                .spec(spec)
                .pathParam("code", code)
                .when()
                .get("/project/{code}")
                .then()
                .spec(false404)
                .extract()
                .as(ErrorRs.class);
    }
}