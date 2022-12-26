package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static javax.swing.UIManager.get;

public class ApiUtilities {

    public static Response response                  =  null;
    public static RequestSpecification specification =  new RequestSpecBuilder().
                                                            setBaseUri("https://petstore.swagger.io/v2").
                                                            setRelaxedHTTPSValidation().build();


    // Verify Status code
    public static void verifyStatusCode(int statusCode){
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    // User can connect with get method
    public static void connectWithGetMethod(String endPoint){
        response = (Response) given().
                contentType(ContentType.URLENC.withCharset("UTF-8")).
                spec(specification).
                param("status", "sold").
        get(endPoint);
        List<Object> ids = response.jsonPath().getList("id");
        List<String> name = response.jsonPath().getList("name");

        System.out.println("ids = "+ ids);
        System.out.println("names = "+name);
     //   response.prettyPrint();

        Map<String, Integer> countMap = new HashMap<>();


        for (String word : name) {
            Integer count = countMap.get(word);
            if(count == null) {
                count = 0;
            }
            countMap.put(word, (count.intValue()+1));
        }

        System.out.println(countMap.toString());

    }

}
