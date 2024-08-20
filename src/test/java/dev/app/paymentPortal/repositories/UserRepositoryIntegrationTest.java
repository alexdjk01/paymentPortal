package dev.app.paymentPortal.repositories;

import dev.app.paymentPortal.TestDataUtil;
import dev.app.paymentPortal.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserRepositoryIntegrationTest {

    private UserRepository underTest;

    @Autowired
    public UserRepositoryIntegrationTest(UserRepository underTest)
    {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled()
    {
        User user = TestDataUtil.createUserA();
        underTest.save(user);
        Optional<User> result = underTest.findById(user.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(user);
    }

    @Test
    public void testThatMultipleUsersCanBeCreatedAndRecalled()
    {
        User userA = TestDataUtil.createUserA();
        underTest.save(userA);
        User userB = TestDataUtil.createUserB();
        underTest.save(userB);
        User userC = TestDataUtil.createUserC();
        underTest.save(userC);

        Iterable<User> result = underTest.findAll();
        assertThat(result).hasSize(3);
        assertThat(result).containsExactly(userA, userB, userC);
    }

    @Test
    public void testThatUserCanBeUpdated()
    {
        User userA = TestDataUtil.createUserA();
        underTest.save(userA);

        userA.setFullName("UPDATED USER");
        underTest.save(userA);
        Optional<User> result = underTest.findById(userA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(userA);

    }

    @Test
    public void testThatUserCanBeDeleted()
    {
        User userA = TestDataUtil.createUserA();
        underTest.save(userA);

        underTest.delete(userA); /// underTest.deleteById(userA.getId()); same thing
        Optional<User> result =  underTest.findById(userA.getId());
        assertThat(result).isEmpty();

    }

}
