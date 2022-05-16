import Service.UserService;
import org.jetbrains.annotations.TestOnly;
import org.junit.*;

public class LoginTest {
    UserService userService;
    @BeforeClass
    public static void initialSetUp(){

    }
    @Before
    public void setUp(){
        userService = new UserService();

    }
    @After
    public void tearDown(){

    }
    @AfterClass
    public static void finalTearDown(){

    }

    @Test
    public void canRegisterWhenUserExistsTest(){
        userService.register("alreadyExistingUser", "testPassword");
        int userIdShouldBe0 = userService.register("alreadyExistingUser","testPassword");
        Assert.assertTrue(userIdShouldBe0 == 0);
    }
    @Test
    public void canRegisterWhenUserDoesNotExistTest(){

    }
    @Test
    public void canLoginWhenUserExistsAndPasswordCorrect(){

    }
    @Test
    public void canRegisterTest(){

    }


}
