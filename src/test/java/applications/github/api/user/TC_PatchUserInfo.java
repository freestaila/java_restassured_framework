//package applications.github.api.user;
//
//import config.ConfigTestNG;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//
//public class TC_PatchUserInfo {
//    ConfigTestNG config;
//    GetUserName getRequest;
//
//    public TC_PatchUserInfo() {
//        this.config = new ConfigTestNG("src/main/java/config/envs/githubApiData.json");
//        this.getRequest = new GetUserName();
//    }
//
//    // Positive scenario
//    @Test
//    public void patchUserName() {
//        String endpoint = (config.restAssured.baseURI);
//        String headers = """
//                {
//                "Accept":"application/vnd.github+json"
//                }
//                """;
//        String bodyParams = """
//                {
//                "name":"",
//                "email":"",
//                "blog":"",
//                "twitter_username":"",
//                "company":"",
//                "location":"",
//                "hireable":"",
//                "bio":""
//                }
//                """;
//        var response = given().body(bodyParams).when().patch(endpoint).then();
//        //-H "Accept: application/vnd.github+json" \
//        //-H "Authorization: Bearer <YOUR-TOKEN>" \
//        //-H "X-GitHub-Api-Version: 2022-11-28" \
//        // given().queryParam("id", 2).when().get(endpoint).then();
//    }
//}
